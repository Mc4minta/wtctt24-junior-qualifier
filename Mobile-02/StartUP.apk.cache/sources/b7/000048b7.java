package e.g.b.a.c.j;

import e.g.b.a.c.d;
import e.g.b.a.c.f;
import e.g.b.a.d.h;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;

/* compiled from: GsonFactory.java */
/* loaded from: classes2.dex */
public class a extends e.g.b.a.c.c {
    @Override // e.g.b.a.c.c
    public d a(OutputStream outputStream, Charset charset) {
        return l(new OutputStreamWriter(outputStream, charset));
    }

    @Override // e.g.b.a.c.c
    public f b(InputStream inputStream) {
        return d(new InputStreamReader(inputStream, h.a));
    }

    @Override // e.g.b.a.c.c
    public f c(InputStream inputStream, Charset charset) {
        if (charset == null) {
            return b(inputStream);
        }
        return d(new InputStreamReader(inputStream, charset));
    }

    @Override // e.g.b.a.c.c
    public f d(Reader reader) {
        return new c(this, new com.google.gson.stream.a(reader));
    }

    @Override // e.g.b.a.c.c
    public f e(String str) {
        return d(new StringReader(str));
    }

    public d l(Writer writer) {
        return new b(this, new com.google.gson.stream.c(writer));
    }
}