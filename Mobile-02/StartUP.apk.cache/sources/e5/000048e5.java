package e.g.b.a.d;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IOUtils.java */
/* loaded from: classes2.dex */
public class o {
    public static long a(b0 b0Var) throws IOException {
        f fVar = new f();
        try {
            b0Var.writeTo(fVar);
            fVar.close();
            return fVar.a;
        } catch (Throwable th) {
            fVar.close();
            throw th;
        }
    }

    public static void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        c(inputStream, outputStream, true);
    }

    public static void c(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        try {
            g.a(inputStream, outputStream);
        } finally {
            if (z) {
                inputStream.close();
            }
        }
    }
}