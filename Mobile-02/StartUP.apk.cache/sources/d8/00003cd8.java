package com.google.zxing;

/* compiled from: BinaryBitmap.java */
/* loaded from: classes2.dex */
public final class c {
    private final b a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.zxing.q.b f9798b;

    public c(b bVar) {
        if (bVar != null) {
            this.a = bVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public com.google.zxing.q.b a() throws NotFoundException {
        if (this.f9798b == null) {
            this.f9798b = this.a.b();
        }
        return this.f9798b;
    }

    public com.google.zxing.q.a b(int i2, com.google.zxing.q.a aVar) throws NotFoundException {
        return this.a.c(i2, aVar);
    }

    public int c() {
        return this.a.d();
    }

    public int d() {
        return this.a.f();
    }

    public boolean e() {
        return this.a.e().f();
    }

    public c f() {
        return new c(this.a.a(this.a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}