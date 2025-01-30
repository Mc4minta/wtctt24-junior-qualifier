package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w2 implements g2 {
    private final i2 a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6605b;

    /* renamed from: c  reason: collision with root package name */
    private final x2 f6606c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(i2 i2Var, String str, Object[] objArr) {
        this.a = i2Var;
        this.f6605b = str;
        this.f6606c = new x2(i2Var.getClass(), str, objArr);
    }

    @Override // com.google.android.gms.internal.clearcut.g2
    public final int a() {
        int i2;
        i2 = this.f6606c.f6614d;
        return (i2 & 1) == 1 ? e1.e.f6409i : e1.e.f6410j;
    }

    @Override // com.google.android.gms.internal.clearcut.g2
    public final boolean b() {
        int i2;
        i2 = this.f6606c.f6614d;
        return (i2 & 2) == 2;
    }

    @Override // com.google.android.gms.internal.clearcut.g2
    public final i2 c() {
        return this.a;
    }

    public final int d() {
        int i2;
        i2 = this.f6606c.f6615e;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final x2 e() {
        return this.f6606c;
    }

    public final int f() {
        int i2;
        i2 = this.f6606c.f6618h;
        return i2;
    }

    public final int g() {
        int i2;
        i2 = this.f6606c.f6619i;
        return i2;
    }

    public final int h() {
        int i2;
        i2 = this.f6606c.f6620j;
        return i2;
    }

    public final int i() {
        int i2;
        i2 = this.f6606c.m;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int[] j() {
        int[] iArr;
        iArr = this.f6606c.n;
        return iArr;
    }

    public final int k() {
        int i2;
        i2 = this.f6606c.f6622l;
        return i2;
    }

    public final int l() {
        int i2;
        i2 = this.f6606c.f6621k;
        return i2;
    }
}