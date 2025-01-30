package e.f.h.e;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

/* compiled from: RoundedCornersDrawable.java */
/* loaded from: classes2.dex */
public class m extends g implements j {

    /* renamed from: e  reason: collision with root package name */
    b f12287e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f12288f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f12289g;

    /* renamed from: h  reason: collision with root package name */
    private Matrix f12290h;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f12291j;

    /* renamed from: k  reason: collision with root package name */
    final float[] f12292k;

    /* renamed from: l  reason: collision with root package name */
    final Paint f12293l;
    private boolean m;
    private float n;
    private int p;
    private int q;
    private float t;
    private boolean u;
    private boolean v;
    private final Path w;
    private final Path x;
    private final RectF y;

    /* compiled from: RoundedCornersDrawable.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.CLIPPING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.OVERLAY_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: RoundedCornersDrawable.java */
    /* loaded from: classes2.dex */
    public enum b {
        OVERLAY_COLOR,
        CLIPPING
    }

    public m(Drawable drawable) {
        super((Drawable) e.f.d.c.i.g(drawable));
        this.f12287e = b.OVERLAY_COLOR;
        this.f12288f = new RectF();
        this.f12291j = new float[8];
        this.f12292k = new float[8];
        this.f12293l = new Paint(1);
        this.m = false;
        this.n = 0.0f;
        this.p = 0;
        this.q = 0;
        this.t = 0.0f;
        this.u = false;
        this.v = false;
        this.w = new Path();
        this.x = new Path();
        this.y = new RectF();
    }

    private void r() {
        float[] fArr;
        this.w.reset();
        this.x.reset();
        this.y.set(getBounds());
        RectF rectF = this.y;
        float f2 = this.t;
        rectF.inset(f2, f2);
        this.w.addRect(this.y, Path.Direction.CW);
        if (this.m) {
            this.w.addCircle(this.y.centerX(), this.y.centerY(), Math.min(this.y.width(), this.y.height()) / 2.0f, Path.Direction.CW);
        } else {
            this.w.addRoundRect(this.y, this.f12291j, Path.Direction.CW);
        }
        RectF rectF2 = this.y;
        float f3 = this.t;
        rectF2.inset(-f3, -f3);
        RectF rectF3 = this.y;
        float f4 = this.n;
        rectF3.inset(f4 / 2.0f, f4 / 2.0f);
        if (this.m) {
            this.x.addCircle(this.y.centerX(), this.y.centerY(), Math.min(this.y.width(), this.y.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.f12292k;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.f12291j[i2] + this.t) - (this.n / 2.0f);
                i2++;
            }
            this.x.addRoundRect(this.y, fArr, Path.Direction.CW);
        }
        RectF rectF4 = this.y;
        float f5 = this.n;
        rectF4.inset((-f5) / 2.0f, (-f5) / 2.0f);
    }

    @Override // e.f.h.e.j
    public void a(int i2, float f2) {
        this.p = i2;
        this.n = f2;
        r();
        invalidateSelf();
    }

    @Override // e.f.h.e.j
    public void c(boolean z) {
        this.m = z;
        r();
        invalidateSelf();
    }

    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f12288f.set(getBounds());
        int i2 = a.a[this.f12287e.ordinal()];
        if (i2 == 1) {
            int save = canvas.save();
            this.w.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.w);
            super.draw(canvas);
            canvas.restoreToCount(save);
        } else if (i2 == 2) {
            if (this.u) {
                RectF rectF = this.f12289g;
                if (rectF == null) {
                    this.f12289g = new RectF(this.f12288f);
                    this.f12290h = new Matrix();
                } else {
                    rectF.set(this.f12288f);
                }
                RectF rectF2 = this.f12289g;
                float f2 = this.n;
                rectF2.inset(f2, f2);
                this.f12290h.setRectToRect(this.f12288f, this.f12289g, Matrix.ScaleToFit.FILL);
                int save2 = canvas.save();
                canvas.clipRect(this.f12288f);
                canvas.concat(this.f12290h);
                super.draw(canvas);
                canvas.restoreToCount(save2);
            } else {
                super.draw(canvas);
            }
            this.f12293l.setStyle(Paint.Style.FILL);
            this.f12293l.setColor(this.q);
            this.f12293l.setStrokeWidth(0.0f);
            this.f12293l.setFilterBitmap(p());
            this.w.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.w, this.f12293l);
            if (this.m) {
                float width = ((this.f12288f.width() - this.f12288f.height()) + this.n) / 2.0f;
                float height = ((this.f12288f.height() - this.f12288f.width()) + this.n) / 2.0f;
                if (width > 0.0f) {
                    RectF rectF3 = this.f12288f;
                    float f3 = rectF3.left;
                    canvas.drawRect(f3, rectF3.top, f3 + width, rectF3.bottom, this.f12293l);
                    RectF rectF4 = this.f12288f;
                    float f4 = rectF4.right;
                    canvas.drawRect(f4 - width, rectF4.top, f4, rectF4.bottom, this.f12293l);
                }
                if (height > 0.0f) {
                    RectF rectF5 = this.f12288f;
                    float f5 = rectF5.left;
                    float f6 = rectF5.top;
                    canvas.drawRect(f5, f6, rectF5.right, f6 + height, this.f12293l);
                    RectF rectF6 = this.f12288f;
                    float f7 = rectF6.left;
                    float f8 = rectF6.bottom;
                    canvas.drawRect(f7, f8 - height, rectF6.right, f8, this.f12293l);
                }
            }
        }
        if (this.p != 0) {
            this.f12293l.setStyle(Paint.Style.STROKE);
            this.f12293l.setColor(this.p);
            this.f12293l.setStrokeWidth(this.n);
            this.w.setFillType(Path.FillType.EVEN_ODD);
            canvas.drawPath(this.x, this.f12293l);
        }
    }

    @Override // e.f.h.e.j
    public void e(boolean z) {
        if (this.v != z) {
            this.v = z;
            invalidateSelf();
        }
    }

    @Override // e.f.h.e.j
    public void f(boolean z) {
        this.u = z;
        r();
        invalidateSelf();
    }

    @Override // e.f.h.e.j
    public void h(float f2) {
        this.t = f2;
        r();
        invalidateSelf();
    }

    @Override // e.f.h.e.j
    public void i(float f2) {
        Arrays.fill(this.f12291j, f2);
        r();
        invalidateSelf();
    }

    @Override // e.f.h.e.j
    public void l(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f12291j, 0.0f);
        } else {
            e.f.d.c.i.c(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f12291j, 0, 8);
        }
        r();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.e.g, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        r();
    }

    public boolean p() {
        return this.v;
    }

    public void q(int i2) {
        this.q = i2;
        invalidateSelf();
    }
}