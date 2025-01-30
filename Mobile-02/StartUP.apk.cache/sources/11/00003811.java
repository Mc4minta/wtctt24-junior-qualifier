package com.google.api.client.http;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZipEncoding.java */
/* loaded from: classes2.dex */
public class f implements i {

    /* compiled from: GZipEncoding.java */
    /* loaded from: classes2.dex */
    class a extends BufferedOutputStream {
        a(OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                flush();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.google.api.client.http.i
    public void a(e.g.b.a.d.b0 b0Var, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new a(outputStream));
        b0Var.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }

    @Override // com.google.api.client.http.i
    public String getName() {
        return "gzip";
    }
}