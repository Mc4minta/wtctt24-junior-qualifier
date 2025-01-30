package e.f.d.c;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Closeables.java */
/* loaded from: classes2.dex */
public final class b {
    static final Logger a = Logger.getLogger(b.class.getName());

    private b() {
    }

    public static void a(Closeable closeable, boolean z) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            if (z) {
                a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e2);
                return;
            }
            throw e2;
        }
    }

    public static void b(InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}