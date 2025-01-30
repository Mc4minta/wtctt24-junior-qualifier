package com.google.zxing.o;

import com.google.zxing.m;
import com.google.zxing.q.g;

/* compiled from: AztecDetectorResult.java */
/* loaded from: classes2.dex */
public final class a extends g {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9857c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9858d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9859e;

    public a(com.google.zxing.q.b bVar, m[] mVarArr, boolean z, int i2, int i3) {
        super(bVar, mVarArr);
        this.f9857c = z;
        this.f9858d = i2;
        this.f9859e = i3;
    }

    public int c() {
        return this.f9858d;
    }

    public int d() {
        return this.f9859e;
    }

    public boolean e() {
        return this.f9857c;
    }
}