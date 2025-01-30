package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.a;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.pool.AbstractConnPool;
import org.apache.http.pool.ConnFactory;

@Deprecated
/* loaded from: classes3.dex */
class HttpConnPool extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();
    private final a log;
    private final long timeToLive;
    private final TimeUnit tunit;

    /* loaded from: classes3.dex */
    static class InternalConnFactory implements ConnFactory<HttpRoute, OperatedClientConnection> {
        private final ClientConnectionOperator connOperator;

        InternalConnFactory(ClientConnectionOperator clientConnectionOperator) {
            this.connOperator = clientConnectionOperator;
        }

        @Override // org.apache.http.pool.ConnFactory
        public OperatedClientConnection create(HttpRoute httpRoute) throws IOException {
            return this.connOperator.createConnection();
        }
    }

    public HttpConnPool(a aVar, ClientConnectionOperator clientConnectionOperator, int i2, int i3, long j2, TimeUnit timeUnit) {
        super(new InternalConnFactory(clientConnectionOperator), i2, i3);
        this.log = aVar;
        this.timeToLive = j2;
        this.tunit = timeUnit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.pool.AbstractConnPool
    public HttpPoolEntry createEntry(HttpRoute httpRoute, OperatedClientConnection operatedClientConnection) {
        return new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, operatedClientConnection, this.timeToLive, this.tunit);
    }
}