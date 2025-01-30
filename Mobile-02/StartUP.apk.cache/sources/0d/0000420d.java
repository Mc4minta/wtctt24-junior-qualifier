package com.toshi.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import e.j.f.y;
import org.toshi.R;

/* compiled from: ForegroundImageView.kt */
/* loaded from: classes2.dex */
public final class o extends AppCompatImageView {
    private Drawable a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(context);
        kotlin.jvm.internal.m.g(context, "context");
    }

    private final void c(int i2, int i3) {
        int pxSize = View_CommonKt.getPxSize(this, R.dimen.icon_default);
        Drawable drawable = this.a;
        if (drawable != null) {
            int i4 = pxSize + 0;
            drawable.setBounds(i4, i4, i2 / 2, i3);
        }
        Drawable drawable2 = this.a;
        int intrinsicWidth = drawable2 == null ? 0 : drawable2.getIntrinsicWidth();
        Drawable drawable3 = this.a;
        int intrinsicHeight = drawable3 != null ? drawable3.getIntrinsicHeight() : 0;
        int i5 = (i2 / 2) - (intrinsicWidth / 2);
        int i6 = (i3 / 2) - (intrinsicHeight / 2);
        Drawable drawable4 = this.a;
        if (drawable4 == null) {
            return;
        }
        drawable4.setBounds(i5, i6, intrinsicWidth + i5, intrinsicHeight + i6);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        kotlin.jvm.internal.m.g(canvas, "canvas");
        super.draw(canvas);
        Drawable drawable = this.a;
        if (drawable == null) {
            return;
        }
        drawable.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        Drawable drawable;
        super.drawableStateChanged();
        Drawable drawable2 = this.a;
        boolean z = false;
        if (drawable2 != null && drawable2.isStateful()) {
            z = true;
        }
        if (!z || (drawable = this.a) == null) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a;
        if (drawable == null) {
            return;
        }
        drawable.jumpToCurrentState();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        c(getMeasuredWidth(), getMeasuredHeight());
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        c(i2, i3);
        invalidate();
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.a;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            unscheduleDrawable(this.a);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
        requestLayout();
        invalidate();
    }

    public final void setForegroundResource(int i2) {
        setForeground(y.c(this, i2));
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable who) {
        kotlin.jvm.internal.m.g(who, "who");
        return super.verifyDrawable(who) || who == this.a;
    }
}