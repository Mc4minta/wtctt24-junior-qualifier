package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.i0;
import com.google.android.gms.internal.p000firebaseperf.y0;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public final class a extends OutputStream {
    private OutputStream a;

    /* renamed from: b  reason: collision with root package name */
    private long f9378b = -1;

    /* renamed from: c  reason: collision with root package name */
    private i0 f9379c;

    /* renamed from: d  reason: collision with root package name */
    private final y0 f9380d;

    public a(OutputStream outputStream, i0 i0Var, y0 y0Var) {
        this.a = outputStream;
        this.f9379c = i0Var;
        this.f9380d = y0Var;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        long j2 = this.f9378b;
        if (j2 != -1) {
            this.f9379c.k(j2);
        }
        this.f9379c.m(this.f9380d.a());
        try {
            this.a.close();
        } catch (IOException e2) {
            this.f9379c.o(this.f9380d.a());
            g.c(this.f9379c);
            throw e2;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            this.a.flush();
        } catch (IOException e2) {
            this.f9379c.o(this.f9380d.a());
            g.c(this.f9379c);
            throw e2;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        try {
            this.a.write(i2);
            long j2 = this.f9378b + 1;
            this.f9378b = j2;
            this.f9379c.k(j2);
        } catch (IOException e2) {
            this.f9379c.o(this.f9380d.a());
            g.c(this.f9379c);
            throw e2;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        try {
            this.a.write(bArr);
            long length = this.f9378b + bArr.length;
            this.f9378b = length;
            this.f9379c.k(length);
        } catch (IOException e2) {
            this.f9379c.o(this.f9380d.a());
            g.c(this.f9379c);
            throw e2;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        try {
            this.a.write(bArr, i2, i3);
            long j2 = this.f9378b + i3;
            this.f9378b = j2;
            this.f9379c.k(j2);
        } catch (IOException e2) {
            this.f9379c.o(this.f9380d.a());
            g.c(this.f9379c);
            throw e2;
        }
    }
}