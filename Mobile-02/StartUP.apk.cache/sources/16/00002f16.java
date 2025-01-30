package com.facebook.react.uimanager.f1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: PositionAndSizeAnimation.java */
/* loaded from: classes2.dex */
class m extends Animation implements j {
    private final View a;

    /* renamed from: b  reason: collision with root package name */
    private float f5110b;

    /* renamed from: c  reason: collision with root package name */
    private float f5111c;

    /* renamed from: d  reason: collision with root package name */
    private float f5112d;

    /* renamed from: e  reason: collision with root package name */
    private float f5113e;

    /* renamed from: f  reason: collision with root package name */
    private int f5114f;

    /* renamed from: g  reason: collision with root package name */
    private int f5115g;

    /* renamed from: h  reason: collision with root package name */
    private int f5116h;

    /* renamed from: j  reason: collision with root package name */
    private int f5117j;

    public m(View view, int i2, int i3, int i4, int i5) {
        this.a = view;
        c(i2, i3, i4, i5);
    }

    private void c(int i2, int i3, int i4, int i5) {
        this.f5110b = this.a.getX() - this.a.getTranslationX();
        this.f5111c = this.a.getY() - this.a.getTranslationY();
        this.f5114f = this.a.getWidth();
        int height = this.a.getHeight();
        this.f5115g = height;
        this.f5112d = i2 - this.f5110b;
        this.f5113e = i3 - this.f5111c;
        this.f5116h = i4 - this.f5114f;
        this.f5117j = i5 - height;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.f5110b + (this.f5112d * f2);
        float f4 = this.f5111c + (this.f5113e * f2);
        this.a.layout(Math.round(f3), Math.round(f4), Math.round(f3 + this.f5114f + (this.f5116h * f2)), Math.round(f4 + this.f5115g + (this.f5117j * f2)));
    }

    @Override // com.facebook.react.uimanager.f1.j
    public void b(int i2, int i3, int i4, int i5) {
        c(i2, i3, i4, i5);
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}