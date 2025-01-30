package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;

/* compiled from: ImageDecodeOptionsBuilder.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private boolean f4518b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4519c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4520d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4521e;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.imagepipeline.decoder.b f4523g;

    /* renamed from: h  reason: collision with root package name */
    private e.f.j.o.a f4524h;

    /* renamed from: i  reason: collision with root package name */
    private ColorSpace f4525i;
    private int a = 100;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap.Config f4522f = Bitmap.Config.ARGB_8888;

    public b a() {
        return new b(this);
    }

    public Bitmap.Config b() {
        return this.f4522f;
    }

    public e.f.j.o.a c() {
        return this.f4524h;
    }

    public ColorSpace d() {
        return this.f4525i;
    }

    public com.facebook.imagepipeline.decoder.b e() {
        return this.f4523g;
    }

    public boolean f() {
        return this.f4520d;
    }

    public boolean g() {
        return this.f4518b;
    }

    public boolean h() {
        return this.f4521e;
    }

    public int i() {
        return this.a;
    }

    public boolean j() {
        return this.f4519c;
    }
}