package org.apache.http.impl.conn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.a;
import org.apache.commons.logging.h;
import org.apache.http.HttpConnection;

@Deprecated
/* loaded from: classes3.dex */
public class IdleConnectionHandler {
    private final a log = h.n(getClass());
    private final Map<HttpConnection, TimeValues> connectionToTimes = new HashMap();

    /* loaded from: classes3.dex */
    private static class TimeValues {
        private final long timeAdded;
        private final long timeExpires;

        TimeValues(long j2, long j3, TimeUnit timeUnit) {
            this.timeAdded = j2;
            if (j3 > 0) {
                this.timeExpires = j2 + timeUnit.toMillis(j3);
            } else {
                this.timeExpires = Long.MAX_VALUE;
            }
        }
    }

    public void add(HttpConnection httpConnection, long j2, TimeUnit timeUnit) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Adding connection at: " + currentTimeMillis);
        }
        this.connectionToTimes.put(httpConnection, new TimeValues(currentTimeMillis, j2, timeUnit));
    }

    public void closeExpiredConnections() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Checking for expired connections, now: " + currentTimeMillis);
        }
        for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
            HttpConnection key = entry.getKey();
            TimeValues value = entry.getValue();
            if (value.timeExpires <= currentTimeMillis) {
                if (this.log.d()) {
                    a aVar2 = this.log;
                    aVar2.a("Closing connection, expired @: " + value.timeExpires);
                }
                try {
                    key.close();
                } catch (IOException e2) {
                    this.log.b("I/O error closing connection", e2);
                }
            }
        }
    }

    public void closeIdleConnections(long j2) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        if (this.log.d()) {
            a aVar = this.log;
            aVar.a("Checking for connections, idle timeout: " + currentTimeMillis);
        }
        for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
            HttpConnection key = entry.getKey();
            long j3 = entry.getValue().timeAdded;
            if (j3 <= currentTimeMillis) {
                if (this.log.d()) {
                    a aVar2 = this.log;
                    aVar2.a("Closing idle connection, connection time: " + j3);
                }
                try {
                    key.close();
                } catch (IOException e2) {
                    this.log.b("I/O error closing connection", e2);
                }
            }
        }
    }

    public boolean remove(HttpConnection httpConnection) {
        TimeValues remove = this.connectionToTimes.remove(httpConnection);
        if (remove != null) {
            return System.currentTimeMillis() <= remove.timeExpires;
        }
        this.log.j("Removing a connection that never existed!");
        return true;
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }
}