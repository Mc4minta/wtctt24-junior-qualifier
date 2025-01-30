package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import e.g.a.f.k;

/* compiled from: MaterialCardViewHelper.java */
/* loaded from: classes2.dex */
class a {
    private final MaterialCardView a;

    /* renamed from: b  reason: collision with root package name */
    private int f8139b;

    /* renamed from: c  reason: collision with root package name */
    private int f8140c;

    public a(MaterialCardView materialCardView) {
        this.a = materialCardView;
    }

    private void a() {
        this.a.setContentPadding(this.a.getContentPaddingLeft() + this.f8140c, this.a.getContentPaddingTop() + this.f8140c, this.a.getContentPaddingRight() + this.f8140c, this.a.getContentPaddingBottom() + this.f8140c);
    }

    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.a.getRadius());
        int i2 = this.f8139b;
        if (i2 != -1) {
            gradientDrawable.setStroke(this.f8140c, i2);
        }
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f8139b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f8140c;
    }

    public void e(TypedArray typedArray) {
        this.f8139b = typedArray.getColor(k.W0, -1);
        this.f8140c = typedArray.getDimensionPixelSize(k.X0, 0);
        h();
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i2) {
        this.f8139b = i2;
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(int i2) {
        this.f8140c = i2;
        h();
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.a.setForeground(b());
    }
}