package com.google.zxing.u.d;

/* compiled from: Codeword.java */
/* loaded from: classes2.dex */
final class d {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10087b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10088c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10089d;

    /* renamed from: e  reason: collision with root package name */
    private int f10090e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.f10087b = i3;
        this.f10088c = i4;
        this.f10089d = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f10088c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10087b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f10090e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f10089d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f10087b - this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return h(this.f10090e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i2) {
        return i2 != -1 && this.f10088c == (i2 % 3) * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i2) {
        this.f10090e = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f10090e = ((this.f10089d / 30) * 3) + (this.f10088c / 3);
    }

    public String toString() {
        return this.f10090e + "|" + this.f10089d;
    }
}