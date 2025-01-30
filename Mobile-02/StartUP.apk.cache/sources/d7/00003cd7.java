package com.google.zxing;

/* compiled from: Binarizer.java */
/* loaded from: classes2.dex */
public abstract class b {
    private final g a;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(g gVar) {
        this.a = gVar;
    }

    public abstract b a(g gVar);

    public abstract com.google.zxing.q.b b() throws NotFoundException;

    public abstract com.google.zxing.q.a c(int i2, com.google.zxing.q.a aVar) throws NotFoundException;

    public final int d() {
        return this.a.a();
    }

    public final g e() {
        return this.a;
    }

    public final int f() {
        return this.a.d();
    }
}