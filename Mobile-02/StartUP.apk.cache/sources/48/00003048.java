package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: ShimmerDrawable.java */
/* loaded from: classes2.dex */
public final class c extends Drawable {
    private final ValueAnimator.AnimatorUpdateListener a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Paint f5591b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f5592c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f5593d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f5594e;

    /* renamed from: f  reason: collision with root package name */
    private b f5595f;

    /* compiled from: ShimmerDrawable.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.invalidateSelf();
        }
    }

    public c() {
        Paint paint = new Paint();
        this.f5591b = paint;
        this.f5592c = new Rect();
        this.f5593d = new Matrix();
        paint.setAntiAlias(true);
    }

    private float c(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    private void f() {
        b bVar;
        Shader radialGradient;
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (width == 0 || height == 0 || (bVar = this.f5595f) == null) {
            return;
        }
        int d2 = bVar.d(width);
        int a2 = this.f5595f.a(height);
        b bVar2 = this.f5595f;
        boolean z = true;
        if (bVar2.f5585g != 1) {
            int i2 = bVar2.f5582d;
            if (i2 != 1 && i2 != 3) {
                z = false;
            }
            if (z) {
                d2 = 0;
            }
            if (!z) {
                a2 = 0;
            }
            float f2 = a2;
            b bVar3 = this.f5595f;
            radialGradient = new LinearGradient(0.0f, 0.0f, d2, f2, bVar3.f5580b, bVar3.a, Shader.TileMode.CLAMP);
        } else {
            float f3 = a2 / 2.0f;
            float max = (float) (Math.max(d2, a2) / Math.sqrt(2.0d));
            b bVar4 = this.f5595f;
            radialGradient = new RadialGradient(d2 / 2.0f, f3, max, bVar4.f5580b, bVar4.a, Shader.TileMode.CLAMP);
        }
        this.f5591b.setShader(radialGradient);
    }

    private void g() {
        boolean z;
        if (this.f5595f == null) {
            return;
        }
        ValueAnimator valueAnimator = this.f5594e;
        if (valueAnimator != null) {
            z = valueAnimator.isStarted();
            this.f5594e.cancel();
            this.f5594e.removeAllUpdateListeners();
        } else {
            z = false;
        }
        b bVar = this.f5595f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, ((float) (bVar.u / bVar.t)) + 1.0f);
        this.f5594e = ofFloat;
        ofFloat.setRepeatMode(this.f5595f.s);
        this.f5594e.setRepeatCount(this.f5595f.r);
        ValueAnimator valueAnimator2 = this.f5594e;
        b bVar2 = this.f5595f;
        valueAnimator2.setDuration(bVar2.t + bVar2.u);
        this.f5594e.addUpdateListener(this.a);
        if (z) {
            this.f5594e.start();
        }
    }

    public boolean a() {
        ValueAnimator valueAnimator = this.f5594e;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        b bVar;
        ValueAnimator valueAnimator = this.f5594e;
        if (valueAnimator == null || valueAnimator.isStarted() || (bVar = this.f5595f) == null || !bVar.p || getCallback() == null) {
            return;
        }
        this.f5594e.start();
    }

    public void d(b bVar) {
        this.f5595f = bVar;
        if (bVar != null) {
            this.f5591b.setXfermode(new PorterDuffXfermode(this.f5595f.q ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        f();
        g();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float c2;
        float c3;
        if (this.f5595f == null || this.f5591b.getShader() == null) {
            return;
        }
        float tan = (float) Math.tan(Math.toRadians(this.f5595f.n));
        float height = this.f5592c.height() + (this.f5592c.width() * tan);
        float width = this.f5592c.width() + (tan * this.f5592c.height());
        ValueAnimator valueAnimator = this.f5594e;
        float f2 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i2 = this.f5595f.f5582d;
        if (i2 != 1) {
            if (i2 == 2) {
                c3 = c(width, -width, animatedFraction);
            } else if (i2 != 3) {
                c3 = c(-width, width, animatedFraction);
            } else {
                c2 = c(height, -height, animatedFraction);
            }
            f2 = c3;
            c2 = 0.0f;
        } else {
            c2 = c(-height, height, animatedFraction);
        }
        this.f5593d.reset();
        this.f5593d.setRotate(this.f5595f.n, this.f5592c.width() / 2.0f, this.f5592c.height() / 2.0f);
        this.f5593d.postTranslate(f2, c2);
        this.f5591b.getShader().setLocalMatrix(this.f5593d);
        canvas.drawRect(this.f5592c, this.f5591b);
    }

    public void e() {
        if (this.f5594e == null || !a()) {
            return;
        }
        this.f5594e.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        b bVar = this.f5595f;
        return (bVar == null || !(bVar.o || bVar.q)) ? -1 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f5592c.set(0, 0, rect.width(), rect.height());
        f();
        b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}