package com.google.zxing.t.r.g.e;

/* compiled from: CurrentParsingState.java */
/* loaded from: classes2.dex */
final class m {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private a f10054b = a.NUMERIC;

    /* compiled from: CurrentParsingState.java */
    /* loaded from: classes2.dex */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i2) {
        this.a += i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f10054b == a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f10054b == a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f10054b = a.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f10054b = a.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f10054b = a.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i2) {
        this.a = i2;
    }
}