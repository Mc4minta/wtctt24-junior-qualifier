package com.facebook.react.views.text;

import android.text.Spannable;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: ReactTextUpdate.java */
/* loaded from: classes2.dex */
public class q {
    private final Spannable a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5435b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5436c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5437d;

    /* renamed from: e  reason: collision with root package name */
    private final float f5438e;

    /* renamed from: f  reason: collision with root package name */
    private final float f5439f;

    /* renamed from: g  reason: collision with root package name */
    private final float f5440g;

    /* renamed from: h  reason: collision with root package name */
    private final int f5441h;

    /* renamed from: i  reason: collision with root package name */
    private final int f5442i;

    /* renamed from: j  reason: collision with root package name */
    private final int f5443j;

    /* renamed from: k  reason: collision with root package name */
    private final int f5444k;

    /* renamed from: l  reason: collision with root package name */
    private final int f5445l;
    public ReadableMap m;

    public q(Spannable spannable, int i2, boolean z, float f2, float f3, float f4, float f5, int i3, int i4, int i5) {
        this(spannable, i2, z, f2, f3, f4, f5, i3, i4, i5, -1, -1);
    }

    public static q a(Spannable spannable, int i2, boolean z, int i3, int i4, int i5, ReadableMap readableMap) {
        q qVar = new q(spannable, i2, z, i3, i4, i5);
        qVar.m = readableMap;
        return qVar;
    }

    public boolean b() {
        return this.f5436c;
    }

    public int c() {
        return this.f5435b;
    }

    public int d() {
        return this.f5445l;
    }

    public float e() {
        return this.f5440g;
    }

    public float f() {
        return this.f5437d;
    }

    public float g() {
        return this.f5439f;
    }

    public float h() {
        return this.f5438e;
    }

    public int i() {
        return this.f5444k;
    }

    public int j() {
        return this.f5443j;
    }

    public Spannable k() {
        return this.a;
    }

    public int l() {
        return this.f5441h;
    }

    public int m() {
        return this.f5442i;
    }

    public q(Spannable spannable, int i2, boolean z, int i3, int i4, int i5) {
        this(spannable, i2, z, -1.0f, -1.0f, -1.0f, -1.0f, i3, i4, i5, -1, -1);
    }

    public q(Spannable spannable, int i2, boolean z, float f2, float f3, float f4, float f5, int i3, int i4, int i5, int i6, int i7) {
        this.m = null;
        this.a = spannable;
        this.f5435b = i2;
        this.f5436c = z;
        this.f5437d = f2;
        this.f5438e = f3;
        this.f5439f = f4;
        this.f5440g = f5;
        this.f5441h = i3;
        this.f5442i = i4;
        this.f5443j = i6;
        this.f5444k = i7;
        this.f5445l = i5;
    }
}