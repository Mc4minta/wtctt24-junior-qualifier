package j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: classes3.dex */
public final class q {
    public static final c0 a(File file) throws FileNotFoundException {
        return r.b(file);
    }

    public static final c0 b() {
        return s.a();
    }

    public static final g c(c0 c0Var) {
        return s.b(c0Var);
    }

    public static final h d(e0 e0Var) {
        return s.c(e0Var);
    }

    public static final boolean e(AssertionError assertionError) {
        return r.c(assertionError);
    }

    public static final c0 f(File file, boolean z) throws FileNotFoundException {
        return r.d(file, z);
    }

    public static final c0 g(OutputStream outputStream) {
        return r.e(outputStream);
    }

    public static final c0 h(Socket socket) throws IOException {
        return r.f(socket);
    }

    public static /* synthetic */ c0 i(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        return r.g(file, z, i2, obj);
    }

    public static final e0 j(File file) throws FileNotFoundException {
        return r.h(file);
    }

    public static final e0 k(InputStream inputStream) {
        return r.i(inputStream);
    }

    public static final e0 l(Socket socket) throws IOException {
        return r.j(socket);
    }
}