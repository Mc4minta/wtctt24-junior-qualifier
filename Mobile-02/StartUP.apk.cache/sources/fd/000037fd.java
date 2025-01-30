package com.google.api.client.http;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: AbstractHttpContent.java */
/* loaded from: classes2.dex */
public abstract class a implements h {
    private n a;

    /* renamed from: b  reason: collision with root package name */
    private long f8327b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str) {
        this(str == null ? null : new n(str));
    }

    public static long c(h hVar) throws IOException {
        if (hVar.a()) {
            return e.g.b.a.d.o.a(hVar);
        }
        return -1L;
    }

    @Override // com.google.api.client.http.h
    public boolean a() {
        return true;
    }

    protected long b() throws IOException {
        return c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Charset d() {
        n nVar = this.a;
        if (nVar != null && nVar.e() != null) {
            return this.a.e();
        }
        return e.g.b.a.d.h.a;
    }

    public final n e() {
        return this.a;
    }

    @Override // com.google.api.client.http.h
    public long getLength() throws IOException {
        if (this.f8327b == -1) {
            this.f8327b = b();
        }
        return this.f8327b;
    }

    @Override // com.google.api.client.http.h
    public String getType() {
        n nVar = this.a;
        if (nVar == null) {
            return null;
        }
        return nVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar) {
        this.f8327b = -1L;
        this.a = nVar;
    }
}