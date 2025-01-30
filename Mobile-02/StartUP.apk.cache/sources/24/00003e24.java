package com.journeyapps.barcodescanner.q;

/* compiled from: CameraSettings.java */
/* loaded from: classes2.dex */
public class d {
    private int a = -1;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10428b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10429c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10430d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10431e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10432f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10433g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10434h = false;

    /* renamed from: i  reason: collision with root package name */
    private a f10435i = a.AUTO;

    /* compiled from: CameraSettings.java */
    /* loaded from: classes2.dex */
    public enum a {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public a a() {
        return this.f10435i;
    }

    public int b() {
        return this.a;
    }

    public boolean c() {
        return this.f10431e;
    }

    public boolean d() {
        return this.f10434h;
    }

    public boolean e() {
        return this.f10429c;
    }

    public boolean f() {
        return this.f10433g;
    }

    public boolean g() {
        return this.f10430d;
    }

    public boolean h() {
        return this.f10428b;
    }

    public void i(int i2) {
        this.a = i2;
    }
}