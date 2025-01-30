package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawableWithShadow.java */
/* loaded from: classes.dex */
class g extends Drawable {
    private static final double a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b  reason: collision with root package name */
    static a f1027b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1028c;

    /* renamed from: e  reason: collision with root package name */
    private Paint f1030e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f1031f;

    /* renamed from: g  reason: collision with root package name */
    private final RectF f1032g;

    /* renamed from: h  reason: collision with root package name */
    private float f1033h;

    /* renamed from: i  reason: collision with root package name */
    private Path f1034i;

    /* renamed from: j  reason: collision with root package name */
    private float f1035j;

    /* renamed from: k  reason: collision with root package name */
    private float f1036k;

    /* renamed from: l  reason: collision with root package name */
    private float f1037l;
    private ColorStateList m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;

    /* renamed from: d  reason: collision with root package name */
    private Paint f1029d = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    /* loaded from: classes.dex */
    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(c.d.b.f2613d);
        this.p = resources.getColor(c.d.b.f2612c);
        this.f1028c = resources.getDimensionPixelSize(c.d.c.a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1030e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1033h = (int) (f2 + 0.5f);
        this.f1032g = new RectF();
        Paint paint2 = new Paint(this.f1030e);
        this.f1031f = paint2;
        paint2.setAntiAlias(false);
        s(f3, f4);
    }

    private void a(Rect rect) {
        float f2 = this.f1035j;
        float f3 = 1.5f * f2;
        this.f1032g.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        b();
    }

    private void b() {
        float f2 = this.f1033h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.f1036k;
        rectF2.inset(-f3, -f3);
        Path path = this.f1034i;
        if (path == null) {
            this.f1034i = new Path();
        } else {
            path.reset();
        }
        this.f1034i.setFillType(Path.FillType.EVEN_ODD);
        this.f1034i.moveTo(-this.f1033h, 0.0f);
        this.f1034i.rLineTo(-this.f1036k, 0.0f);
        this.f1034i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1034i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1034i.close();
        float f4 = this.f1033h;
        float f5 = f4 / (this.f1036k + f4);
        Paint paint = this.f1030e;
        float f6 = this.f1033h + this.f1036k;
        int i2 = this.o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.p}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1031f;
        float f7 = this.f1033h;
        float f8 = this.f1036k;
        int i3 = this.o;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1031f.setAntiAlias(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(float f2, float f3, boolean z) {
        return z ? (float) (f2 + ((1.0d - a) * f3)) : f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(float f2, float f3, boolean z) {
        return z ? (float) ((f2 * 1.5f) + ((1.0d - a) * f3)) : f2 * 1.5f;
    }

    private void e(Canvas canvas) {
        float f2 = this.f1033h;
        float f3 = (-f2) - this.f1036k;
        float f4 = f2 + this.f1028c + (this.f1037l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f1032g.width() - f5 > 0.0f;
        boolean z2 = this.f1032g.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1032g;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.f1034i, this.f1030e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f1032g.width() - f5, -this.f1033h, this.f1031f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1032g;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1034i, this.f1030e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f1032g.width() - f5, (-this.f1033h) + this.f1036k, this.f1031f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1032g;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1034i, this.f1030e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1032g.height() - f5, -this.f1033h, this.f1031f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1032g;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1034i, this.f1030e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f1032g.height() - f5, -this.f1033h, this.f1031f);
        }
        canvas.restoreToCount(save4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.f1029d.setColor(colorStateList.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private void s(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float t = t(f2);
            float t2 = t(f3);
            if (t > t2) {
                if (!this.r) {
                    this.r = true;
                }
                t = t2;
            }
            if (this.f1037l == t && this.f1035j == t2) {
                return;
            }
            this.f1037l = t;
            this.f1035j = t2;
            this.f1036k = (int) ((t * 1.5f) + this.f1028c + 0.5f);
            this.n = true;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    private int t(float f2) {
        int i2 = (int) (f2 + 0.5f);
        return i2 % 2 == 1 ? i2 - 1 : i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            a(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.f1037l / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1037l) / 2.0f);
        f1027b.a(canvas, this.f1032g, this.f1033h, this.f1029d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f1033h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(d(this.f1035j, this.f1033h, this.q));
        int ceil2 = (int) Math.ceil(c(this.f1035j, this.f1033h, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f1035j;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        float f2 = this.f1035j;
        return (Math.max(f2, this.f1033h + this.f1028c + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1035j * 1.5f) + this.f1028c) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k() {
        float f2 = this.f1035j;
        return (Math.max(f2, this.f1033h + this.f1028c + (f2 / 2.0f)) * 2.0f) + ((this.f1035j + this.f1028c) * 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.f1037l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1029d.getColor() == colorForState) {
            return false;
        }
        this.f1029d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (int) (f2 + 0.5f);
            if (this.f1033h == f3) {
                return;
            }
            this.f1033h = f3;
            this.n = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(float f2) {
        s(this.f1037l, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(float f2) {
        s(f2, this.f1035j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f1029d.setAlpha(i2);
        this.f1030e.setAlpha(i2);
        this.f1031f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1029d.setColorFilter(colorFilter);
    }
}