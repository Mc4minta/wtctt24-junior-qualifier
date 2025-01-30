package e.g.b.a.c;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;

/* compiled from: JsonFactory.java */
/* loaded from: classes2.dex */
public abstract class c {
    private ByteArrayOutputStream h(Object obj, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d a = a(byteArrayOutputStream, e.g.b.a.d.h.a);
        if (z) {
            a.a();
        }
        a.c(obj);
        a.b();
        return byteArrayOutputStream;
    }

    private String k(Object obj, boolean z) throws IOException {
        return h(obj, z).toString("UTF-8");
    }

    public abstract d a(OutputStream outputStream, Charset charset) throws IOException;

    public abstract f b(InputStream inputStream) throws IOException;

    public abstract f c(InputStream inputStream, Charset charset) throws IOException;

    public abstract f d(Reader reader) throws IOException;

    public abstract f e(String str) throws IOException;

    public final <T> T f(InputStream inputStream, Class<T> cls) throws IOException {
        return (T) b(inputStream).t(cls);
    }

    public final <T> T g(Reader reader, Class<T> cls) throws IOException {
        return (T) d(reader).t(cls);
    }

    public final String i(Object obj) throws IOException {
        return k(obj, true);
    }

    public final String j(Object obj) throws IOException {
        return k(obj, false);
    }
}