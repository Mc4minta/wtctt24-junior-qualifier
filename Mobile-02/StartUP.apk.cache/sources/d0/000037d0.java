package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* compiled from: CutoutDrawable.java */
/* loaded from: classes2.dex */
class a extends GradientDrawable {
    private final Paint a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private final RectF f8267b;

    /* renamed from: c  reason: collision with root package name */
    private int f8268c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        h();
        this.f8267b = new RectF();
    }

    private void b(Canvas canvas) {
        if (i(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f8268c);
    }

    private void c(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (i(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            e(canvas);
        }
    }

    private void e(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f8268c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.f8268c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void h() {
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.a.setColor(-1);
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean i(Drawable.Callback callback) {
        return callback instanceof View;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return !this.f8267b.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        f(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        c(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f8267b, this.a);
        b(canvas);
    }

    void f(float f2, float f3, float f4, float f5) {
        RectF rectF = this.f8267b;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(RectF rectF) {
        f(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}