package j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class r {
    private static final Logger a = Logger.getLogger("okio.Okio");

    public static final c0 b(File appendingSink) throws FileNotFoundException {
        kotlin.jvm.internal.m.g(appendingSink, "$this$appendingSink");
        return q.g(new FileOutputStream(appendingSink, true));
    }

    public static final boolean c(AssertionError isAndroidGetsocknameError) {
        kotlin.jvm.internal.m.g(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        if (isAndroidGetsocknameError.getCause() != null) {
            String message = isAndroidGetsocknameError.getMessage();
            return message != null ? kotlin.l0.y.V(message, "getsockname failed", false, 2, null) : false;
        }
        return false;
    }

    public static final c0 d(File sink, boolean z) throws FileNotFoundException {
        kotlin.jvm.internal.m.g(sink, "$this$sink");
        return q.g(new FileOutputStream(sink, z));
    }

    public static final c0 e(OutputStream sink) {
        kotlin.jvm.internal.m.g(sink, "$this$sink");
        return new u(sink, new f0());
    }

    public static final c0 f(Socket sink) throws IOException {
        kotlin.jvm.internal.m.g(sink, "$this$sink");
        d0 d0Var = new d0(sink);
        OutputStream outputStream = sink.getOutputStream();
        kotlin.jvm.internal.m.f(outputStream, "getOutputStream()");
        return d0Var.sink(new u(outputStream, d0Var));
    }

    public static /* synthetic */ c0 g(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return q.f(file, z);
    }

    public static final e0 h(File source) throws FileNotFoundException {
        kotlin.jvm.internal.m.g(source, "$this$source");
        return q.k(new FileInputStream(source));
    }

    public static final e0 i(InputStream source) {
        kotlin.jvm.internal.m.g(source, "$this$source");
        return new p(source, new f0());
    }

    public static final e0 j(Socket source) throws IOException {
        kotlin.jvm.internal.m.g(source, "$this$source");
        d0 d0Var = new d0(source);
        InputStream inputStream = source.getInputStream();
        kotlin.jvm.internal.m.f(inputStream, "getInputStream()");
        return d0Var.source(new p(inputStream, d0Var));
    }
}