package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.d0;
import e.g.a.f.k;

/* compiled from: ForegroundLinearLayout.java */
/* loaded from: classes2.dex */
public class e extends d0 {
    private Drawable t;
    private final Rect u;
    private final Rect v;
    private int w;
    protected boolean x;
    boolean y;

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.t;
        if (drawable != null) {
            if (this.y) {
                this.y = false;
                Rect rect = this.u;
                Rect rect2 = this.v;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.x) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.w, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.t;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.t.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.t;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.d0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.y = z | this.y;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.y = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.t);
            }
            this.t = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.w == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i2) {
        if (this.w != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.w = i2;
            if (i2 == 119 && this.t != null) {
                this.t.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.t;
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = new Rect();
        this.v = new Rect();
        this.w = 119;
        this.x = true;
        this.y = false;
        TypedArray h2 = h.h(context, attributeSet, k.x0, i2, 0, new int[0]);
        this.w = h2.getInt(k.z0, this.w);
        Drawable drawable = h2.getDrawable(k.y0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.x = h2.getBoolean(k.A0, true);
        h2.recycle();
    }
}