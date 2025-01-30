package com.google.protobuf;

/* compiled from: LazyFieldLite.java */
/* loaded from: classes2.dex */
public class m {
    private static final h a = h.a();

    /* renamed from: b  reason: collision with root package name */
    private e f9733b;

    /* renamed from: c  reason: collision with root package name */
    private h f9734c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile n f9735d;

    /* renamed from: e  reason: collision with root package name */
    private volatile e f9736e;

    protected void a(n nVar) {
        if (this.f9735d != null) {
            return;
        }
        synchronized (this) {
            if (this.f9735d != null) {
                return;
            }
            try {
                if (this.f9733b != null) {
                    this.f9735d = nVar.getParserForType().a(this.f9733b, this.f9734c);
                    this.f9736e = this.f9733b;
                } else {
                    this.f9735d = nVar;
                    this.f9736e = e.a;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f9735d = nVar;
                this.f9736e = e.a;
            }
        }
    }

    public n b(n nVar) {
        a(nVar);
        return this.f9735d;
    }

    public n c(n nVar) {
        n nVar2 = this.f9735d;
        this.f9733b = null;
        this.f9736e = null;
        this.f9735d = nVar;
        return nVar2;
    }
}