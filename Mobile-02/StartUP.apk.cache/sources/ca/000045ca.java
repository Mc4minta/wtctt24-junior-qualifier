package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* compiled from: RoundedDrawable.java */
/* loaded from: classes2.dex */
public abstract class n extends Drawable implements j, r {
    Matrix A;
    private s G;
    private final Drawable a;

    /* renamed from: l  reason: collision with root package name */
    float[] f12305l;
    RectF t;
    Matrix z;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f12296b = false;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f12297c = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f12298d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected final Path f12299e = new Path();

    /* renamed from: f  reason: collision with root package name */
    protected boolean f12300f = true;

    /* renamed from: g  reason: collision with root package name */
    protected int f12301g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected final Path f12302h = new Path();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f12303j = new float[8];

    /* renamed from: k  reason: collision with root package name */
    final float[] f12304k = new float[8];
    final RectF m = new RectF();
    final RectF n = new RectF();
    final RectF p = new RectF();
    final RectF q = new RectF();
    final Matrix u = new Matrix();
    final Matrix v = new Matrix();
    final Matrix w = new Matrix();
    final Matrix x = new Matrix();
    final Matrix y = new Matrix();
    final Matrix B = new Matrix();
    private float C = 0.0f;
    private boolean D = false;
    private boolean E = false;
    private boolean F = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Drawable drawable) {
        this.a = drawable;
    }

    @Override // e.f.h.e.j
    public void a(int i2, float f2) {
        if (this.f12301g == i2 && this.f12298d == f2) {
            return;
        }
        this.f12301g = i2;
        this.f12298d = f2;
        this.F = true;
        invalidateSelf();
    }

    @Override // e.f.h.e.r
    public void b(s sVar) {
        this.G = sVar;
    }

    @Override // e.f.h.e.j
    public void c(boolean z) {
        this.f12296b = z;
        this.F = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.a.clearColorFilter();
    }

    public boolean d() {
        return this.E;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("RoundedDrawable#draw");
        }
        this.a.draw(canvas);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    @Override // e.f.h.e.j
    public void e(boolean z) {
        if (this.E != z) {
            this.E = z;
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.j
    public void f(boolean z) {
        if (this.D != z) {
            this.D = z;
            this.F = true;
            invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f12296b || this.f12297c || this.f12298d > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.getOpacity();
    }

    @Override // e.f.h.e.j
    public void h(float f2) {
        if (this.C != f2) {
            this.C = f2;
            this.F = true;
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.j
    public void i(float f2) {
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        e.f.d.c.i.i(i2 >= 0);
        Arrays.fill(this.f12303j, f2);
        this.f12297c = i2 != 0;
        this.F = true;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        float[] fArr;
        if (this.F) {
            this.f12302h.reset();
            RectF rectF = this.m;
            float f2 = this.f12298d;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            if (this.f12296b) {
                this.f12302h.addCircle(this.m.centerX(), this.m.centerY(), Math.min(this.m.width(), this.m.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.f12304k;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.f12303j[i2] + this.C) - (this.f12298d / 2.0f);
                    i2++;
                }
                this.f12302h.addRoundRect(this.m, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.m;
            float f3 = this.f12298d;
            rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
            this.f12299e.reset();
            float f4 = this.C + (this.D ? this.f12298d : 0.0f);
            this.m.inset(f4, f4);
            if (this.f12296b) {
                this.f12299e.addCircle(this.m.centerX(), this.m.centerY(), Math.min(this.m.width(), this.m.height()) / 2.0f, Path.Direction.CW);
            } else if (this.D) {
                if (this.f12305l == null) {
                    this.f12305l = new float[8];
                }
                for (int i3 = 0; i3 < this.f12304k.length; i3++) {
                    this.f12305l[i3] = this.f12303j[i3] - this.f12298d;
                }
                this.f12299e.addRoundRect(this.m, this.f12305l, Path.Direction.CW);
            } else {
                this.f12299e.addRoundRect(this.m, this.f12303j, Path.Direction.CW);
            }
            float f5 = -f4;
            this.m.inset(f5, f5);
            this.f12299e.setFillType(Path.FillType.WINDING);
            this.F = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        Matrix matrix;
        s sVar = this.G;
        if (sVar != null) {
            sVar.d(this.w);
            this.G.g(this.m);
        } else {
            this.w.reset();
            this.m.set(getBounds());
        }
        this.p.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        this.q.set(this.a.getBounds());
        this.u.setRectToRect(this.p, this.q, Matrix.ScaleToFit.FILL);
        if (this.D) {
            RectF rectF = this.t;
            if (rectF == null) {
                this.t = new RectF(this.m);
            } else {
                rectF.set(this.m);
            }
            RectF rectF2 = this.t;
            float f2 = this.f12298d;
            rectF2.inset(f2, f2);
            if (this.z == null) {
                this.z = new Matrix();
            }
            this.z.setRectToRect(this.m, this.t, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.z;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.w.equals(this.x) || !this.u.equals(this.v) || ((matrix = this.z) != null && !matrix.equals(this.A))) {
            this.f12300f = true;
            this.w.invert(this.y);
            this.B.set(this.w);
            if (this.D) {
                this.B.postConcat(this.z);
            }
            this.B.preConcat(this.u);
            this.x.set(this.w);
            this.v.set(this.u);
            if (this.D) {
                Matrix matrix3 = this.A;
                if (matrix3 == null) {
                    this.A = new Matrix(this.z);
                } else {
                    matrix3.set(this.z);
                }
            } else {
                Matrix matrix4 = this.A;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (this.m.equals(this.n)) {
            return;
        }
        this.F = true;
        this.n.set(this.m);
    }

    @Override // e.f.h.e.j
    public void l(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f12303j, 0.0f);
            this.f12297c = false;
        } else {
            e.f.d.c.i.c(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f12303j, 0, 8);
            this.f12297c = false;
            for (int i2 = 0; i2 < 8; i2++) {
                this.f12297c |= fArr[i2] > 0.0f;
            }
        }
        this.F = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i2, PorterDuff.Mode mode) {
        this.a.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}