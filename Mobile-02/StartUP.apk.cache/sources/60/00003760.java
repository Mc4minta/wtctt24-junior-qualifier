package com.google.android.material.appbar;

import android.view.View;
import c.h.k.v;

/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes2.dex */
class d {
    private final View a;

    /* renamed from: b  reason: collision with root package name */
    private int f8063b;

    /* renamed from: c  reason: collision with root package name */
    private int f8064c;

    /* renamed from: d  reason: collision with root package name */
    private int f8065d;

    /* renamed from: e  reason: collision with root package name */
    private int f8066e;

    public d(View view) {
        this.a = view;
    }

    private void f() {
        View view = this.a;
        v.Y(view, this.f8065d - (view.getTop() - this.f8063b));
        View view2 = this.a;
        v.X(view2, this.f8066e - (view2.getLeft() - this.f8064c));
    }

    public int a() {
        return this.f8063b;
    }

    public int b() {
        return this.f8065d;
    }

    public void c() {
        this.f8063b = this.a.getTop();
        this.f8064c = this.a.getLeft();
        f();
    }

    public boolean d(int i2) {
        if (this.f8066e != i2) {
            this.f8066e = i2;
            f();
            return true;
        }
        return false;
    }

    public boolean e(int i2) {
        if (this.f8065d != i2) {
            this.f8065d = i2;
            f();
            return true;
        }
        return false;
    }
}