package org.apache.http.impl.conn.tsccm;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;
import org.apache.http.util.Args;

@Deprecated
/* loaded from: classes3.dex */
public abstract class AbstractConnPool {
    protected volatile boolean isShutDown;
    protected Set<BasicPoolEntryRef> issuedConnections;
    protected int numConnections;
    protected ReferenceQueue<Object> refQueue;
    private final a log = h.n(getClass());
    protected Set<BasicPoolEntry> leasedConnections = new HashSet();
    protected IdleConnectionHandler idleConnHandler = new IdleConnectionHandler();
    protected final Lock poolLock = new ReentrantLock();

    protected void closeConnection(OperatedClientConnection operatedClientConnection) {
        if (operatedClientConnection != null) {
            try {
                operatedClientConnection.close();
            } catch (IOException e2) {
                this.log.b("I/O error closing connection", e2);
            }
        }
    }

    public void closeExpiredConnections() {
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeExpiredConnections();
        } finally {
            this.poolLock.unlock();
        }
    }

    public void closeIdleConnections(long j2, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeIdleConnections(timeUnit.toMillis(j2));
        } finally {
            this.poolLock.unlock();
        }
    }

    public abstract void deleteClosedConnections();

    public void enableConnectionGC() throws IllegalStateException {
    }

    public abstract void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j2, TimeUnit timeUnit);

    public final BasicPoolEntry getEntry(HttpRoute httpRoute, Object obj, long j2, TimeUnit timeUnit) throws ConnectionPoolTimeoutException, InterruptedException {
        return requestPoolEntry(httpRoute, obj).getPoolEntry(j2, timeUnit);
    }

    protected abstract void handleLostEntry(HttpRoute httpRoute);

    public void handleReference(Reference<?> reference) {
    }

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj);

    public void shutdown() {
        this.poolLock.lock();
        try {
            if (this.isShutDown) {
                return;
            }
            Iterator<BasicPoolEntry> it = this.leasedConnections.iterator();
            while (it.hasNext()) {
                it.remove();
                closeConnection(it.next().getConnection());
            }
            this.idleConnHandler.removeAll();
            this.isShutDown = true;
        } finally {
            this.poolLock.unlock();
        }
    }
}