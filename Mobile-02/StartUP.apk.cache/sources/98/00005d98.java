package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolStats;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes3.dex */
public class PoolingClientConnectionManager implements ClientConnectionManager, ConnPoolControl<HttpRoute> {
    private final DnsResolver dnsResolver;
    private final a log;
    private final ClientConnectionOperator operator;
    private final HttpConnPool pool;
    private final SchemeRegistry schemeRegistry;

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS);
    }

    private String format(HttpRoute httpRoute, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("[route: ");
        sb.append(httpRoute);
        sb.append("]");
        if (obj != null) {
            sb.append("[state: ");
            sb.append(obj);
            sb.append("]");
        }
        return sb.toString();
    }

    private String formatStats(HttpRoute httpRoute) {
        StringBuilder sb = new StringBuilder();
        PoolStats totalStats = this.pool.getTotalStats();
        PoolStats stats = this.pool.getStats(httpRoute);
        sb.append("[total kept alive: ");
        sb.append(totalStats.getAvailable());
        sb.append("; ");
        sb.append("route allocated: ");
        sb.append(stats.getLeased() + stats.getAvailable());
        sb.append(" of ");
        sb.append(stats.getMax());
        sb.append("; ");
        sb.append("total allocated: ");
        sb.append(totalStats.getLeased() + totalStats.getAvailable());
        sb.append(" of ");
        sb.append(totalStats.getMax());
        sb.append("]");
        return sb.toString();
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.log.a("Closing expired connections");
        this.pool.closeExpired();
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void closeIdleConnections(long j2, TimeUnit timeUnit) {
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Closing connections idle longer than " + j2 + " " + timeUnit);
        }
        this.pool.closeIdle(j2, timeUnit);
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry, this.dnsResolver);
    }

    protected void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        return this.pool.getDefaultMaxPerRoute();
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxTotal() {
        return this.pool.getMaxTotal();
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        return this.pool.getTotalStats();
    }

    ManagedClientConnection leaseConnection(Future<HttpPoolEntry> future, long j2, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
        try {
            HttpPoolEntry httpPoolEntry = future.get(j2, timeUnit);
            if (httpPoolEntry != null && !future.isCancelled()) {
                Asserts.check(httpPoolEntry.getConnection() != null, "Pool entry with no connection");
                if (this.log.d()) {
                    a aVar = this.log;
                    aVar.a("Connection leased: " + format(httpPoolEntry) + formatStats(httpPoolEntry.getRoute()));
                }
                return new ManagedClientConnectionImpl(this, this.operator, httpPoolEntry);
            }
            throw new InterruptedException();
        } catch (ExecutionException e2) {
            e = e2;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            this.log.i("Unexpected exception leasing connection from pool", e);
            throw new InterruptedException();
        } catch (TimeoutException unused) {
            throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
        }
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection managedClientConnection, long j2, TimeUnit timeUnit) {
        String str;
        Args.check(managedClientConnection instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
        ManagedClientConnectionImpl managedClientConnectionImpl = (ManagedClientConnectionImpl) managedClientConnection;
        Asserts.check(managedClientConnectionImpl.getManager() == this, "Connection not obtained from this manager");
        synchronized (managedClientConnectionImpl) {
            HttpPoolEntry detach = managedClientConnectionImpl.detach();
            if (detach == null) {
                return;
            }
            if (managedClientConnectionImpl.isOpen() && !managedClientConnectionImpl.isMarkedReusable()) {
                try {
                    managedClientConnectionImpl.shutdown();
                } catch (IOException e2) {
                    if (this.log.d()) {
                        this.log.b("I/O exception shutting down released connection", e2);
                    }
                }
            }
            if (managedClientConnectionImpl.isMarkedReusable()) {
                detach.updateExpiry(j2, timeUnit != null ? timeUnit : TimeUnit.MILLISECONDS);
                if (this.log.d()) {
                    if (j2 > 0) {
                        str = "for " + j2 + " " + timeUnit;
                    } else {
                        str = "indefinitely";
                    }
                    this.log.a("Connection " + format(detach) + " can be kept alive " + str);
                }
            }
            this.pool.release((HttpConnPool) detach, managedClientConnectionImpl.isMarkedReusable());
            if (this.log.d()) {
                this.log.a("Connection released: " + format(detach) + formatStats(detach.getRoute()));
            }
        }
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(HttpRoute httpRoute, Object obj) {
        Args.notNull(httpRoute, "HTTP route");
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Connection request: " + format(httpRoute, obj) + formatStats(httpRoute));
        }
        final Future<HttpPoolEntry> lease = this.pool.lease(httpRoute, obj);
        return new ClientConnectionRequest() { // from class: org.apache.http.impl.conn.PoolingClientConnectionManager.1
            @Override // org.apache.http.conn.ClientConnectionRequest
            public void abortRequest() {
                lease.cancel(true);
            }

            @Override // org.apache.http.conn.ClientConnectionRequest
            public ManagedClientConnection getConnection(long j2, TimeUnit timeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
                return PoolingClientConnectionManager.this.leaseConnection(lease, j2, timeUnit);
            }
        };
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i2) {
        this.pool.setDefaultMaxPerRoute(i2);
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxTotal(int i2) {
        this.pool.setMaxTotal(i2);
    }

    @Override // org.apache.http.conn.ClientConnectionManager
    public void shutdown() {
        this.log.a("Connection manager is shutting down");
        try {
            this.pool.shutdown();
        } catch (IOException e2) {
            this.log.b("I/O exception shutting down connection manager", e2);
        }
        this.log.a("Connection manager shut down");
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, DnsResolver dnsResolver) {
        this(schemeRegistry, -1L, TimeUnit.MILLISECONDS, dnsResolver);
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public int getMaxPerRoute(HttpRoute httpRoute) {
        return this.pool.getMaxPerRoute(httpRoute);
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public PoolStats getStats(HttpRoute httpRoute) {
        return this.pool.getStats(httpRoute);
    }

    @Override // org.apache.http.pool.ConnPoolControl
    public void setMaxPerRoute(HttpRoute httpRoute, int i2) {
        this.pool.setMaxPerRoute(httpRoute, i2);
    }

    public PoolingClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j2, TimeUnit timeUnit) {
        this(schemeRegistry, j2, timeUnit, new SystemDefaultDnsResolver());
    }

    public PoolingClientConnectionManager(SchemeRegistry schemeRegistry, long j2, TimeUnit timeUnit, DnsResolver dnsResolver) {
        a n = h.n(getClass());
        this.log = n;
        Args.notNull(schemeRegistry, "Scheme registry");
        Args.notNull(dnsResolver, "DNS resolver");
        this.schemeRegistry = schemeRegistry;
        this.dnsResolver = dnsResolver;
        ClientConnectionOperator createConnectionOperator = createConnectionOperator(schemeRegistry);
        this.operator = createConnectionOperator;
        this.pool = new HttpConnPool(n, createConnectionOperator, 2, 20, j2, timeUnit);
    }

    private String format(HttpPoolEntry httpPoolEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append("[id: ");
        sb.append(httpPoolEntry.getId());
        sb.append("]");
        sb.append("[route: ");
        sb.append(httpPoolEntry.getRoute());
        sb.append("]");
        Object state = httpPoolEntry.getState();
        if (state != null) {
            sb.append("[state: ");
            sb.append(state);
            sb.append("]");
        }
        return sb.toString();
    }
}