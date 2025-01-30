package com.google.api.client.http;

import e.g.b.a.d.f0;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/* compiled from: UrlEncodedContent.java */
/* loaded from: classes2.dex */
public class b0 extends a {

    /* renamed from: c  reason: collision with root package name */
    private Object f8339c;

    public b0(Object obj) {
        super(c0.a);
        g(obj);
    }

    private static boolean f(boolean z, Writer writer, String str, Object obj) throws IOException {
        if (obj != null && !e.g.b.a.d.j.c(obj)) {
            if (z) {
                z = false;
            } else {
                writer.write("&");
            }
            writer.write(str);
            String b2 = e.g.b.a.d.h0.a.b(obj instanceof Enum ? e.g.b.a.d.m.j((Enum) obj).e() : obj.toString());
            if (b2.length() != 0) {
                writer.write("=");
                writer.write(b2);
            }
        }
        return z;
    }

    public b0 g(Object obj) {
        this.f8339c = e.g.b.a.d.y.d(obj);
        return this;
    }

    @Override // e.g.b.a.d.b0
    public void writeTo(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, d()));
        boolean z = true;
        for (Map.Entry<String, Object> entry : e.g.b.a.d.j.f(this.f8339c).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String b2 = e.g.b.a.d.h0.a.b(entry.getKey());
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    z = f(z, bufferedWriter, b2, value);
                } else {
                    for (Object obj : f0.l(value)) {
                        z = f(z, bufferedWriter, b2, obj);
                    }
                }
            }
        }
        bufferedWriter.flush();
    }
}