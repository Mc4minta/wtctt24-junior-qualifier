package org.apache.http.impl.conn.tsccm;

import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@Deprecated
/* loaded from: classes3.dex */
public class RouteSpecificPool {
    protected final ConnPerRoute connPerRoute;
    protected final LinkedList<BasicPoolEntry> freeEntries;
    private final a log;
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue<WaitingThread> waitingThreads;

    @Deprecated
    public RouteSpecificPool(HttpRoute httpRoute, int i2) {
        this.log = h.n(getClass());
        this.route = httpRoute;
        this.maxEntries = i2;
        this.connPerRoute = new ConnPerRoute() { // from class: org.apache.http.impl.conn.tsccm.RouteSpecificPool.1
            @Override // org.apache.http.conn.params.ConnPerRoute
            public int getMaxForRoute(HttpRoute httpRoute2) {
                return RouteSpecificPool.this.maxEntries;
            }
        };
        this.freeEntries = new LinkedList<>();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.http.impl.conn.tsccm.BasicPoolEntry allocEntry(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r0 = r3.freeEntries
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L32
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r0 = r3.freeEntries
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L12:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L32
            java.lang.Object r1 = r0.previous()
            org.apache.http.impl.conn.tsccm.BasicPoolEntry r1 = (org.apache.http.impl.conn.tsccm.BasicPoolEntry) r1
            java.lang.Object r2 = r1.getState()
            if (r2 == 0) goto L2e
            java.lang.Object r2 = r1.getState()
            boolean r2 = org.apache.http.util.LangUtils.equals(r4, r2)
            if (r2 == 0) goto L12
        L2e:
            r0.remove()
            return r1
        L32:
            int r4 = r3.getCapacity()
            if (r4 != 0) goto L5c
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r4 = r3.freeEntries
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L5c
            java.util.LinkedList<org.apache.http.impl.conn.tsccm.BasicPoolEntry> r4 = r3.freeEntries
            java.lang.Object r4 = r4.remove()
            org.apache.http.impl.conn.tsccm.BasicPoolEntry r4 = (org.apache.http.impl.conn.tsccm.BasicPoolEntry) r4
            r4.shutdownEntry()
            org.apache.http.conn.OperatedClientConnection r0 = r4.getConnection()
            r0.close()     // Catch: java.io.IOException -> L53
            goto L5b
        L53:
            r0 = move-exception
            org.apache.commons.logging.a r1 = r3.log
            java.lang.String r2 = "I/O error closing connection"
            r1.b(r2, r0)
        L5b:
            return r4
        L5c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.conn.tsccm.RouteSpecificPool.allocEntry(java.lang.Object):org.apache.http.impl.conn.tsccm.BasicPoolEntry");
    }

    public void createdEntry(BasicPoolEntry basicPoolEntry) {
        Args.check(this.route.equals(basicPoolEntry.getPlannedRoute()), "Entry not planned for this pool");
        this.numEntries++;
    }

    public boolean deleteEntry(BasicPoolEntry basicPoolEntry) {
        boolean remove = this.freeEntries.remove(basicPoolEntry);
        if (remove) {
            this.numEntries--;
        }
        return remove;
    }

    public void dropEntry() {
        Asserts.check(this.numEntries > 0, "There is no entry that could be dropped");
        this.numEntries--;
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry) {
        int i2 = this.numEntries;
        if (i2 >= 1) {
            if (i2 > this.freeEntries.size()) {
                this.freeEntries.add(basicPoolEntry);
                return;
            }
            throw new IllegalStateException("No entry allocated from this pool. " + this.route);
        }
        throw new IllegalStateException("No entry created for this pool. " + this.route);
    }

    public int getCapacity() {
        return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
    }

    public final int getEntryCount() {
        return this.numEntries;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }

    public boolean hasThread() {
        return !this.waitingThreads.isEmpty();
    }

    public boolean isUnused() {
        return this.numEntries < 1 && this.waitingThreads.isEmpty();
    }

    public WaitingThread nextThread() {
        return this.waitingThreads.peek();
    }

    public void queueThread(WaitingThread waitingThread) {
        Args.notNull(waitingThread, "Waiting thread");
        this.waitingThreads.add(waitingThread);
    }

    public void removeThread(WaitingThread waitingThread) {
        if (waitingThread == null) {
            return;
        }
        this.waitingThreads.remove(waitingThread);
    }

    public RouteSpecificPool(HttpRoute httpRoute, ConnPerRoute connPerRoute) {
        this.log = h.n(getClass());
        this.route = httpRoute;
        this.connPerRoute = connPerRoute;
        this.maxEntries = connPerRoute.getMaxForRoute(httpRoute);
        this.freeEntries = new LinkedList<>();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }
}