package e.f.h.e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* compiled from: RoundedColorDrawable.java */
/* loaded from: classes2.dex */
public class l extends Drawable implements j {

    /* renamed from: c  reason: collision with root package name */
    float[] f12278c;
    private final float[] a = new float[8];

    /* renamed from: b  reason: collision with root package name */
    final float[] f12277b = new float[8];

    /* renamed from: d  reason: collision with root package name */
    final Paint f12279d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private boolean f12280e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f12281f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f12282g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private int f12283h = 0;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12284j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12285k = false;

    /* renamed from: l  reason: collision with root package name */
    final Path f12286l = new Path();
    final Path m = new Path();
    private int n = 0;
    private final RectF p = new RectF();
    private int q = 255;

    public l(int i2) {
        g(i2);
    }

    @TargetApi(11)
    public static l b(ColorDrawable colorDrawable) {
        return new l(colorDrawable.getColor());
    }

    private void j() {
        float[] fArr;
        float[] fArr2;
        this.f12286l.reset();
        this.m.reset();
        this.p.set(getBounds());
        RectF rectF = this.p;
        float f2 = this.f12281f;
        rectF.inset(f2 / 2.0f, f2 / 2.0f);
        int i2 = 0;
        if (this.f12280e) {
            this.m.addCircle(this.p.centerX(), this.p.centerY(), Math.min(this.p.width(), this.p.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i3 = 0;
            while (true) {
                fArr = this.f12277b;
                if (i3 >= fArr.length) {
                    break;
                }
                fArr[i3] = (this.a[i3] + this.f12282g) - (this.f12281f / 2.0f);
                i3++;
            }
            this.m.addRoundRect(this.p, fArr, Path.Direction.CW);
        }
        RectF rectF2 = this.p;
        float f3 = this.f12281f;
        rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
        float f4 = this.f12282g + (this.f12284j ? this.f12281f : 0.0f);
        this.p.inset(f4, f4);
        if (this.f12280e) {
            this.f12286l.addCircle(this.p.centerX(), this.p.centerY(), Math.min(this.p.width(), this.p.height()) / 2.0f, Path.Direction.CW);
        } else if (this.f12284j) {
            if (this.f12278c == null) {
                this.f12278c = new float[8];
            }
            while (true) {
                fArr2 = this.f12278c;
                if (i2 >= fArr2.length) {
                    break;
                }
                fArr2[i2] = this.a[i2] - this.f12281f;
                i2++;
            }
            this.f12286l.addRoundRect(this.p, fArr2, Path.Direction.CW);
        } else {
            this.f12286l.addRoundRect(this.p, this.a, Path.Direction.CW);
        }
        float f5 = -f4;
        this.p.inset(f5, f5);
    }

    @Override // e.f.h.e.j
    public void a(int i2, float f2) {
        if (this.f12283h != i2) {
            this.f12283h = i2;
            invalidateSelf();
        }
        if (this.f12281f != f2) {
            this.f12281f = f2;
            j();
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.j
    public void c(boolean z) {
        this.f12280e = z;
        j();
        invalidateSelf();
    }

    public boolean d() {
        return this.f12285k;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f12279d.setColor(e.c(this.n, this.q));
        this.f12279d.setStyle(Paint.Style.FILL);
        this.f12279d.setFilterBitmap(d());
        canvas.drawPath(this.f12286l, this.f12279d);
        if (this.f12281f != 0.0f) {
            this.f12279d.setColor(e.c(this.f12283h, this.q));
            this.f12279d.setStyle(Paint.Style.STROKE);
            this.f12279d.setStrokeWidth(this.f12281f);
            canvas.drawPath(this.m, this.f12279d);
        }
    }

    @Override // e.f.h.e.j
    public void e(boolean z) {
        if (this.f12285k != z) {
            this.f12285k = z;
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.j
    public void f(boolean z) {
        if (this.f12284j != z) {
            this.f12284j = z;
            j();
            invalidateSelf();
        }
    }

    public void g(int i2) {
        if (this.n != i2) {
            this.n = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return e.b(e.c(this.n, this.q));
    }

    @Override // e.f.h.e.j
    public void h(float f2) {
        if (this.f12282g != f2) {
            this.f12282g = f2;
            j();
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.j
    public void i(float f2) {
        e.f.d.c.i.c(f2 >= 0.0f, "radius should be non negative");
        Arrays.fill(this.a, f2);
        j();
        invalidateSelf();
    }

    @Override // e.f.h.e.j
    public void l(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.a, 0.0f);
        } else {
            e.f.d.c.i.c(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.a, 0, 8);
        }
        j();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        j();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.q) {
            this.q = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}