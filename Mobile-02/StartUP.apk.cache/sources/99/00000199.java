package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable.java */
/* loaded from: classes.dex */
class f extends Drawable {
    private float a;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f1018c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1019d;

    /* renamed from: e  reason: collision with root package name */
    private float f1020e;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f1023h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f1024i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f1025j;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1021f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1022g = true;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f1026k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1017b = new Paint(5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ColorStateList colorStateList, float f2) {
        this.a = f2;
        e(colorStateList);
        this.f1018c = new RectF();
        this.f1019d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1023h = colorStateList;
        this.f1017b.setColor(colorStateList.getColorForState(getState(), this.f1023h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1018c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1019d.set(rect);
        if (this.f1021f) {
            float d2 = g.d(this.f1020e, this.a, this.f1022g);
            this.f1019d.inset((int) Math.ceil(g.c(this.f1020e, this.a, this.f1022g)), (int) Math.ceil(d2));
            this.f1018c.set(this.f1019d);
        }
    }

    public ColorStateList b() {
        return this.f1023h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f1020e;
    }

    public float d() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f1017b;
        if (this.f1024i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f1024i);
            z = true;
        }
        RectF rectF = this.f1018c;
        float f2 = this.a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f2, boolean z, boolean z2) {
        if (f2 == this.f1020e && this.f1021f == z && this.f1022g == z2) {
            return;
        }
        this.f1020e = f2;
        this.f1021f = z;
        this.f1022g = z2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1019d, this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f2) {
        if (f2 == this.a) {
            return;
        }
        this.a = f2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1025j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1023h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1023h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f1017b.getColor();
        if (z) {
            this.f1017b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1025j;
        if (colorStateList2 == null || (mode = this.f1026k) == null) {
            return z;
        }
        this.f1024i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1017b.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1017b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1025j = colorStateList;
        this.f1024i = a(colorStateList, this.f1026k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1026k = mode;
        this.f1024i = a(this.f1025j, mode);
        invalidateSelf();
    }
}