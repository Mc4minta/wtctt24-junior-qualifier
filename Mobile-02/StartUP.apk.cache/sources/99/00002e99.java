package com.facebook.react.modules.network;

import j.c0;
import j.q;
import java.io.IOException;
import java.io.OutputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: ProgressRequestBody.java */
/* loaded from: classes2.dex */
public class i extends RequestBody {
    private final RequestBody a;

    /* renamed from: b  reason: collision with root package name */
    private final h f4979b;

    /* renamed from: c  reason: collision with root package name */
    private long f4980c = 0;

    public i(RequestBody requestBody, h hVar) {
        this.a = requestBody;
        this.f4979b = hVar;
    }

    private c0 b(j.g gVar) {
        return q.g(new a(gVar.c1()));
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        if (this.f4980c == 0) {
            this.f4980c = this.a.contentLength();
        }
        return this.f4980c;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.a.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(j.g gVar) throws IOException {
        j.g c2 = q.c(b(gVar));
        contentLength();
        this.a.writeTo(c2);
        c2.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProgressRequestBody.java */
    /* loaded from: classes2.dex */
    public class a extends b {
        a(OutputStream outputStream) {
            super(outputStream);
        }

        private void b() throws IOException {
            long a = a();
            long contentLength = i.this.contentLength();
            i.this.f4979b.a(a, contentLength, a == contentLength);
        }

        @Override // com.facebook.react.modules.network.b, java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            super.write(bArr, i2, i3);
            b();
        }

        @Override // com.facebook.react.modules.network.b, java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            super.write(i2);
            b();
        }
    }
}