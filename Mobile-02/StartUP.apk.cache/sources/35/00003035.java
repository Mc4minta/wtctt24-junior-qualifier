package com.facebook.react.views.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import c.h.k.v;

/* compiled from: ReactViewBackgroundManager.java */
/* loaded from: classes2.dex */
public class e {
    private d a;

    /* renamed from: b  reason: collision with root package name */
    private View f5547b;

    public e(View view) {
        this.f5547b = view;
    }

    private d a() {
        if (this.a == null) {
            this.a = new d(this.f5547b.getContext());
            Drawable background = this.f5547b.getBackground();
            v.m0(this.f5547b, null);
            if (background == null) {
                v.m0(this.f5547b, this.a);
            } else {
                v.m0(this.f5547b, new LayerDrawable(new Drawable[]{this.a, background}));
            }
        }
        return this.a;
    }

    public void b(int i2) {
        if (i2 == 0 && this.a == null) {
            return;
        }
        a().x(i2);
    }

    public void c(int i2, float f2, float f3) {
        a().t(i2, f2, f3);
    }

    public void d(float f2) {
        a().y(f2);
    }

    public void e(float f2, int i2) {
        a().z(f2, i2);
    }

    public void f(String str) {
        a().v(str);
    }

    public void g(int i2, float f2) {
        a().w(i2, f2);
    }
}