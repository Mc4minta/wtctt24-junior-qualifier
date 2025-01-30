package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.a;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.RouteTracker;
import org.apache.http.pool.PoolEntry;

@Deprecated
/* loaded from: classes3.dex */
class HttpPoolEntry extends PoolEntry<HttpRoute, OperatedClientConnection> {
    private final a log;
    private final RouteTracker tracker;

    public HttpPoolEntry(a aVar, String str, HttpRoute httpRoute, OperatedClientConnection operatedClientConnection, long j2, TimeUnit timeUnit) {
        super(str, httpRoute, operatedClientConnection, j2, timeUnit);
        this.log = aVar;
        this.tracker = new RouteTracker(httpRoute);
    }

    @Override // org.apache.http.pool.PoolEntry
    public void close() {
        try {
            getConnection().close();
        } catch (IOException e2) {
            this.log.b("I/O error closing connection", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRoute getEffectiveRoute() {
        return this.tracker.toRoute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRoute getPlannedRoute() {
        return getRoute();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteTracker getTracker() {
        return this.tracker;
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
}