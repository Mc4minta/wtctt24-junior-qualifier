package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.h;
import e.g.a.f.b;
import e.g.a.f.j;
import e.g.a.f.k;

/* loaded from: classes2.dex */
public class MaterialCardView extends CardView {
    private final a cardViewHelper;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public int getStrokeColor() {
        return this.cardViewHelper.c();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.d();
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.cardViewHelper.h();
    }

    public void setStrokeColor(int i2) {
        this.cardViewHelper.f(i2);
    }

    public void setStrokeWidth(int i2) {
        this.cardViewHelper.g(i2);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f13232g);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray h2 = h.h(context, attributeSet, k.V0, i2, j.f13280k, new int[0]);
        a aVar = new a(this);
        this.cardViewHelper = aVar;
        aVar.e(h2);
        h2.recycle();
    }
}