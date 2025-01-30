package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.a;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.pool.PoolEntry;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes3.dex */
class CPoolEntry extends PoolEntry<HttpRoute, ManagedHttpClientConnection> {
    private final a log;
    private volatile boolean routeComplete;

    public CPoolEntry(a aVar, String str, HttpRoute httpRoute, ManagedHttpClientConnection managedHttpClientConnection, long j2, TimeUnit timeUnit) {
        super(str, httpRoute, managedHttpClientConnection, j2, timeUnit);
        this.log = aVar;
    }

    @Override // org.apache.http.pool.PoolEntry
    public void close() {
        try {
            closeConnection();
        } catch (IOException e2) {
            this.log.b("I/O error closing connection", e2);
        }
    }

    public void closeConnection() throws IOException {
        getConnection().close();
    }

    @Override // org.apache.http.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }

    @Override // org.apache.http.pool.PoolEntry
    public boolean isExpired(long j2) {
        boolean isExpired = super.isExpired(j2);
        if (isExpired && this.log.d()) {
            a aVar = this.log;
            aVar.a("Connection " + this + " expired @ " + new Date(getExpiry()));
        }
        return isExpired;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public void shutdownConnection() throws IOException {
        getConnection().shutdown();
    }
}