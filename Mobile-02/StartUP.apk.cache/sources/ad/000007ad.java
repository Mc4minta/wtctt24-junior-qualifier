package com.bugsnag.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

/* compiled from: JsonStream.java */
/* loaded from: classes.dex */
public class o0 extends p0 {
    private final u0 m;
    private final Writer n;

    /* compiled from: JsonStream.java */
    /* loaded from: classes.dex */
    public interface a {
        void toStream(o0 o0Var) throws IOException;
    }

    public o0(Writer writer) {
        super(writer);
        K(false);
        this.n = writer;
        this.m = new u0();
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 O(long j2) throws IOException {
        return super.O(j2);
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 V(Boolean bool) throws IOException {
        return super.V(bool);
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 a0(Number number) throws IOException {
        return super.a0(number);
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 c() throws IOException {
        return super.c();
    }

    @Override // com.bugsnag.android.p0, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 d() throws IOException {
        return super.d();
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 d0(String str) throws IOException {
        return super.d0(str);
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 e0(boolean z) throws IOException {
        return super.e0(z);
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 f() throws IOException {
        return super.f();
    }

    @Override // com.bugsnag.android.p0, java.io.Flushable
    public /* bridge */ /* synthetic */ void flush() throws IOException {
        super.flush();
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 g() throws IOException {
        return super.g();
    }

    @Override // com.bugsnag.android.p0
    /* renamed from: k0 */
    public o0 j(String str) throws IOException {
        super.j(str);
        return this;
    }

    @Override // com.bugsnag.android.p0
    public /* bridge */ /* synthetic */ p0 n() throws IOException {
        return super.n();
    }

    public void n0(a aVar) throws IOException {
        if (aVar == null) {
            n();
        } else {
            aVar.toStream(this);
        }
    }

    public void o0(File file) throws IOException {
        Throwable th;
        BufferedReader bufferedReader;
        if (file == null || file.length() <= 0) {
            return;
        }
        super.flush();
        b();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            l0.c(bufferedReader, this.n);
            l0.b(bufferedReader);
            this.n.flush();
        } catch (Throwable th3) {
            th = th3;
            l0.b(bufferedReader);
            throw th;
        }
    }

    public void r0(Object obj) throws IOException {
        this.m.a(obj, this);
    }
}