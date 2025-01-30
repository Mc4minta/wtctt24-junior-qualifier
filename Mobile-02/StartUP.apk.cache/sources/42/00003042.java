package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.shimmer.b;

/* loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private final Paint a;

    /* renamed from: b  reason: collision with root package name */
    private final c f5567b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5568c;

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.f5567b = new c();
        this.f5568c = true;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.f5567b.setCallback(this);
        if (attributeSet == null) {
            b(new b.a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.a, 0, 0);
        try {
            int i2 = a.f5573f;
            b(((obtainStyledAttributes.hasValue(i2) && obtainStyledAttributes.getBoolean(i2, false)) ? new b.c() : new b.a()).c(obtainStyledAttributes).a());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ShimmerFrameLayout b(b bVar) {
        this.f5567b.d(bVar);
        if (bVar != null && bVar.o) {
            setLayerType(2, this.a);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    public void c() {
        this.f5567b.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5568c) {
            this.f5567b.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5567b.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f5567b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5567b;
    }
}