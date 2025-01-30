package j;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class d0 extends d {
    private final Socket a;

    public d0(Socket socket) {
        kotlin.jvm.internal.m.g(socket, "socket");
        this.a = socket;
    }

    @Override // j.d
    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // j.d
    protected void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.a.close();
        } catch (AssertionError e2) {
            if (q.e(e2)) {
                logger2 = r.a;
                Level level = Level.WARNING;
                logger2.log(level, "Failed to close timed out socket " + this.a, (Throwable) e2);
                return;
            }
            throw e2;
        } catch (Exception e3) {
            logger = r.a;
            Level level2 = Level.WARNING;
            logger.log(level2, "Failed to close timed out socket " + this.a, (Throwable) e3);
        }
    }
}