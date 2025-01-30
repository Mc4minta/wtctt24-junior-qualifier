package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ExchangeFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b@\u0010AJ?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0010J\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101R\u001c\u00104\u001a\u0002038\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010>R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00101¨\u0006B"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/RealConnection;", "findHealthyConnection", "(IIIIZZ)Lokhttp3/internal/connection/RealConnection;", "findConnection", "(IIIIZ)Lokhttp3/internal/connection/RealConnection;", "retryCurrentRoute", "()Z", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "find", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "connectingConnection", "()Lokhttp3/internal/connection/RealConnection;", "Ljava/io/IOException;", "e", "Lkotlin/x;", "trackFailure", "(Ljava/io/IOException;)V", "retryAfterFailure", "Lokhttp3/HttpUrl;", "url", "sameHostAndPort", "(Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/internal/connection/RouteSelector;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "connectionShutdownCount", "I", "refusedStreamCount", "Lokhttp3/Address;", "address", "Lokhttp3/Address;", "getAddress$okhttp", "()Lokhttp3/Address;", "Lokhttp3/Route;", "nextRouteToTry", "Lokhttp3/Route;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/internal/connection/RealConnection;", "otherFailureCount", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool connectionPool, Address address, RealCall call, EventListener eventListener) {
        m.h(connectionPool, "connectionPool");
        m.h(address, "address");
        m.h(call, "call");
        m.h(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b4, code lost:
        if (r0.hasNext() == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, okhttp3.internal.connection.RealConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.internal.connection.RealConnection findConnection(int r19, int r20, int r21, int r22, boolean r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
        throw new java.io.IOException("exhausted all routes");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L0:
            okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            boolean r1 = r0.isHealthy(r9)
            if (r1 == 0) goto Lb
            return r0
        Lb:
            r0.noNewExchanges()
            okhttp3.internal.connection.RealConnectionPool r0 = r3.connectionPool
            monitor-enter(r0)
            okhttp3.Route r1 = r3.nextRouteToTry     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L16
            goto L2e
        L16:
            okhttp3.internal.connection.RouteSelector$Selection r1 = r3.routeSelection     // Catch: java.lang.Throwable -> L3a
            r2 = 1
            if (r1 == 0) goto L20
            boolean r1 = r1.hasNext()     // Catch: java.lang.Throwable -> L3a
            goto L21
        L20:
            r1 = r2
        L21:
            if (r1 == 0) goto L24
            goto L2e
        L24:
            okhttp3.internal.connection.RouteSelector r1 = r3.routeSelector     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L2c
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L3a
        L2c:
            if (r2 == 0) goto L32
        L2e:
            kotlin.x r1 = kotlin.x.a     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r0)
            goto L0
        L32:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "exhausted all routes"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            throw r4     // Catch: java.lang.Throwable -> L3a
        L3a:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final boolean retryCurrentRoute() {
        RealConnection connection;
        return this.refusedStreamCount <= 1 && this.connectionShutdownCount <= 1 && this.otherFailureCount <= 0 && (connection = this.call.getConnection()) != null && connection.getRouteFailureCount$okhttp() == 0 && Util.canReuseConnectionFor(connection.route().address().url(), this.address.url());
    }

    public final RealConnection connectingConnection() {
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnectionPool)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(realConnectionPool);
            throw new AssertionError(sb.toString());
        }
        return this.connectingConnection;
    }

    public final ExchangeCodec find(OkHttpClient client, RealInterceptorChain chain) {
        m.h(client, "client");
        m.h(chain, "chain");
        try {
            return findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), chain.getWriteTimeoutMillis$okhttp(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !m.c(chain.getRequest$okhttp().method(), HttpGet.METHOD_NAME)).newCodec$okhttp(client, chain);
        } catch (IOException e2) {
            trackFailure(e2);
            throw new RouteException(e2);
        } catch (RouteException e3) {
            trackFailure(e3.getLastConnectException());
            throw e3;
        }
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        synchronized (this.connectionPool) {
            if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
                return false;
            }
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                RealConnection connection = this.call.getConnection();
                if (connection == null) {
                    m.q();
                }
                this.nextRouteToTry = connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if (selection == null || !selection.hasNext()) {
                RouteSelector routeSelector = this.routeSelector;
                if (routeSelector != null) {
                    return routeSelector.hasNext();
                }
                return true;
            }
            return true;
        }
    }

    public final boolean sameHostAndPort(HttpUrl url) {
        m.h(url, "url");
        HttpUrl url2 = this.address.url();
        return url.port() == url2.port() && m.c(url.host(), url2.host());
    }

    public final void trackFailure(IOException e2) {
        m.h(e2, "e");
        RealConnectionPool realConnectionPool = this.connectionPool;
        if (Util.assertionsEnabled && Thread.holdsLock(realConnectionPool)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread currentThread = Thread.currentThread();
            m.d(currentThread, "Thread.currentThread()");
            sb.append(currentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(realConnectionPool);
            throw new AssertionError(sb.toString());
        }
        synchronized (this.connectionPool) {
            this.nextRouteToTry = null;
            if ((e2 instanceof StreamResetException) && ((StreamResetException) e2).errorCode == ErrorCode.REFUSED_STREAM) {
                this.refusedStreamCount++;
            } else if (e2 instanceof ConnectionShutdownException) {
                this.connectionShutdownCount++;
            } else {
                this.otherFailureCount++;
            }
        }
    }
}