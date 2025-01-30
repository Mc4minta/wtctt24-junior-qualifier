package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.react.uimanager.g0;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: ReactViewBackgroundDrawable.java */
/* loaded from: classes2.dex */
public class d extends Drawable {
    private g0 a;

    /* renamed from: b  reason: collision with root package name */
    private g0 f5525b;

    /* renamed from: c  reason: collision with root package name */
    private g0 f5526c;

    /* renamed from: d  reason: collision with root package name */
    private c f5527d;

    /* renamed from: e  reason: collision with root package name */
    private PathEffect f5528e;

    /* renamed from: f  reason: collision with root package name */
    private Path f5529f;

    /* renamed from: g  reason: collision with root package name */
    private Path f5530g;

    /* renamed from: h  reason: collision with root package name */
    private Path f5531h;

    /* renamed from: i  reason: collision with root package name */
    private Path f5532i;

    /* renamed from: j  reason: collision with root package name */
    private Path f5533j;

    /* renamed from: k  reason: collision with root package name */
    private RectF f5534k;

    /* renamed from: l  reason: collision with root package name */
    private RectF f5535l;
    private RectF m;
    private RectF n;
    private PointF o;
    private PointF p;
    private PointF q;
    private PointF r;
    private boolean s = false;
    private float t = Float.NaN;
    private final Paint u = new Paint(1);
    private int v = 0;
    private int w = 255;
    private float[] x;
    private final Context y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactViewBackgroundDrawable.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.SOLID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.DASHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.DOTTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: ReactViewBackgroundDrawable.java */
    /* loaded from: classes2.dex */
    public enum b {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactViewBackgroundDrawable.java */
    /* loaded from: classes2.dex */
    public enum c {
        SOLID,
        DASHED,
        DOTTED;

        public static PathEffect h(c cVar, float f2) {
            int i2 = a.a[cVar.ordinal()];
            if (i2 == 2) {
                float f3 = f2 * 3.0f;
                return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
            } else if (i2 != 3) {
                return null;
            } else {
                return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
            }
        }
    }

    public d(Context context) {
        this.y = context;
    }

    private void B() {
        float max;
        float max2;
        float max3;
        float max4;
        float max5;
        float max6;
        float max7;
        float max8;
        if (this.s) {
            this.s = false;
            if (this.f5529f == null) {
                this.f5529f = new Path();
            }
            if (this.f5530g == null) {
                this.f5530g = new Path();
            }
            if (this.f5531h == null) {
                this.f5531h = new Path();
            }
            if (this.f5533j == null) {
                this.f5533j = new Path();
            }
            if (this.f5534k == null) {
                this.f5534k = new RectF();
            }
            if (this.f5535l == null) {
                this.f5535l = new RectF();
            }
            if (this.m == null) {
                this.m = new RectF();
            }
            if (this.n == null) {
                this.n = new RectF();
            }
            this.f5529f.reset();
            this.f5530g.reset();
            this.f5531h.reset();
            this.f5533j.reset();
            this.f5534k.set(getBounds());
            this.f5535l.set(getBounds());
            this.m.set(getBounds());
            this.n.set(getBounds());
            RectF k2 = k();
            RectF rectF = this.f5534k;
            rectF.top += k2.top;
            rectF.bottom -= k2.bottom;
            rectF.left += k2.left;
            rectF.right -= k2.right;
            RectF rectF2 = this.n;
            rectF2.top += k2.top * 0.5f;
            rectF2.bottom -= k2.bottom * 0.5f;
            rectF2.left += k2.left * 0.5f;
            rectF2.right -= k2.right * 0.5f;
            float m = m();
            float h2 = h(m, b.TOP_LEFT);
            float h3 = h(m, b.TOP_RIGHT);
            float h4 = h(m, b.BOTTOM_LEFT);
            float h5 = h(m, b.BOTTOM_RIGHT);
            if (Build.VERSION.SDK_INT >= 17) {
                boolean z = o() == 1;
                float g2 = g(b.TOP_START);
                float g3 = g(b.TOP_END);
                float g4 = g(b.BOTTOM_START);
                float g5 = g(b.BOTTOM_END);
                if (com.facebook.react.modules.i18nmanager.a.d().b(this.y)) {
                    if (!com.facebook.yoga.g.a(g2)) {
                        h2 = g2;
                    }
                    if (!com.facebook.yoga.g.a(g3)) {
                        h3 = g3;
                    }
                    if (!com.facebook.yoga.g.a(g4)) {
                        h4 = g4;
                    }
                    if (!com.facebook.yoga.g.a(g5)) {
                        h5 = g5;
                    }
                    float f2 = z ? h3 : h2;
                    if (z) {
                        h3 = h2;
                    }
                    float f3 = z ? h5 : h4;
                    if (z) {
                        h5 = h4;
                    }
                    h4 = f3;
                    h2 = f2;
                } else {
                    float f4 = z ? g3 : g2;
                    if (!z) {
                        g2 = g3;
                    }
                    float f5 = z ? g5 : g4;
                    if (!z) {
                        g4 = g5;
                    }
                    if (!com.facebook.yoga.g.a(f4)) {
                        h2 = f4;
                    }
                    if (!com.facebook.yoga.g.a(g2)) {
                        h3 = g2;
                    }
                    if (!com.facebook.yoga.g.a(f5)) {
                        h4 = f5;
                    }
                    if (!com.facebook.yoga.g.a(g4)) {
                        h5 = g4;
                    }
                }
            }
            float f6 = h4;
            this.f5529f.addRoundRect(this.f5534k, new float[]{Math.max(h2 - k2.left, 0.0f), Math.max(h2 - k2.top, 0.0f), Math.max(h3 - k2.right, 0.0f), Math.max(h3 - k2.top, 0.0f), Math.max(h5 - k2.right, 0.0f), Math.max(h5 - k2.bottom, 0.0f), Math.max(h4 - k2.left, 0.0f), Math.max(h4 - k2.bottom, 0.0f)}, Path.Direction.CW);
            this.f5530g.addRoundRect(this.f5535l, new float[]{h2, h2, h3, h3, h5, h5, f6, f6}, Path.Direction.CW);
            g0 g0Var = this.a;
            float a2 = g0Var != null ? g0Var.a(8) / 2.0f : 0.0f;
            float f7 = h2 + a2;
            float f8 = h3 + a2;
            float f9 = h5 + a2;
            float f10 = f6 + a2;
            this.f5531h.addRoundRect(this.m, new float[]{f7, f7, f8, f8, f9, f9, f10, f10}, Path.Direction.CW);
            Path path = this.f5533j;
            RectF rectF3 = this.n;
            float[] fArr = new float[8];
            float f11 = k2.left;
            fArr[0] = Math.max(h2 - (f11 * 0.5f), f11 > 0.0f ? h2 / f11 : 0.0f);
            float f12 = k2.top;
            fArr[1] = Math.max(h2 - (f12 * 0.5f), f12 > 0.0f ? h2 / f12 : 0.0f);
            float f13 = k2.right;
            fArr[2] = Math.max(h3 - (f13 * 0.5f), f13 > 0.0f ? h3 / f13 : 0.0f);
            float f14 = k2.top;
            fArr[3] = Math.max(h3 - (f14 * 0.5f), f14 > 0.0f ? h3 / f14 : 0.0f);
            float f15 = k2.right;
            fArr[4] = Math.max(h5 - (f15 * 0.5f), f15 > 0.0f ? h5 / f15 : 0.0f);
            float f16 = k2.bottom;
            fArr[5] = Math.max(h5 - (f16 * 0.5f), f16 > 0.0f ? h5 / f16 : 0.0f);
            float f17 = k2.left;
            fArr[6] = Math.max(f6 - (f17 * 0.5f), f17 > 0.0f ? f6 / f17 : 0.0f);
            float f18 = k2.bottom;
            fArr[7] = Math.max(f6 - (f18 * 0.5f), f18 > 0.0f ? f6 / f18 : 0.0f);
            path.addRoundRect(rectF3, fArr, Path.Direction.CW);
            if (this.o == null) {
                this.o = new PointF();
            }
            PointF pointF = this.o;
            RectF rectF4 = this.f5534k;
            float f19 = rectF4.left;
            pointF.x = f19;
            float f20 = rectF4.top;
            pointF.y = f20;
            RectF rectF5 = this.f5535l;
            l(f19, f20, (max * 2.0f) + f19, (max2 * 2.0f) + f20, rectF5.left, rectF5.top, f19, f20, pointF);
            if (this.r == null) {
                this.r = new PointF();
            }
            PointF pointF2 = this.r;
            RectF rectF6 = this.f5534k;
            float f21 = rectF6.left;
            pointF2.x = f21;
            float f22 = rectF6.bottom;
            pointF2.y = f22;
            RectF rectF7 = this.f5535l;
            l(f21, f22 - (max8 * 2.0f), (max7 * 2.0f) + f21, f22, rectF7.left, rectF7.bottom, f21, f22, pointF2);
            if (this.p == null) {
                this.p = new PointF();
            }
            PointF pointF3 = this.p;
            RectF rectF8 = this.f5534k;
            float f23 = rectF8.right;
            pointF3.x = f23;
            float f24 = rectF8.top;
            pointF3.y = f24;
            RectF rectF9 = this.f5535l;
            l(f23 - (max3 * 2.0f), f24, f23, (max4 * 2.0f) + f24, rectF9.right, rectF9.top, f23, f24, pointF3);
            if (this.q == null) {
                this.q = new PointF();
            }
            PointF pointF4 = this.q;
            RectF rectF10 = this.f5534k;
            float f25 = rectF10.right;
            pointF4.x = f25;
            float f26 = rectF10.bottom;
            pointF4.y = f26;
            RectF rectF11 = this.f5535l;
            l(f25 - (max5 * 2.0f), f26 - (2.0f * max6), f25, f26, rectF11.right, rectF11.bottom, f25, f26, pointF4);
        }
    }

    private void C() {
        c cVar = this.f5527d;
        PathEffect h2 = cVar != null ? c.h(cVar, n()) : null;
        this.f5528e = h2;
        this.u.setPathEffect(h2);
    }

    private static int a(float f2, float f3) {
        return ((((int) f2) << 24) & (-16777216)) | (((int) f3) & 16777215);
    }

    private void b(Canvas canvas, int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (i2 == 0) {
            return;
        }
        if (this.f5532i == null) {
            this.f5532i = new Path();
        }
        this.u.setColor(i2);
        this.f5532i.reset();
        this.f5532i.moveTo(f2, f3);
        this.f5532i.lineTo(f4, f5);
        this.f5532i.lineTo(f6, f7);
        this.f5532i.lineTo(f8, f9);
        this.f5532i.lineTo(f2, f3);
        canvas.drawPath(this.f5532i, this.u);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(android.graphics.Canvas r25) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.d.c(android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.graphics.Canvas r23) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.d.d(android.graphics.Canvas):void");
    }

    private static int e(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = (i5 > 0 ? i9 : -1) & (i2 > 0 ? i6 : -1) & (i3 > 0 ? i7 : -1) & (i4 > 0 ? i8 : -1);
        if (i2 <= 0) {
            i6 = 0;
        }
        if (i3 <= 0) {
            i7 = 0;
        }
        int i11 = i6 | i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        int i12 = i11 | i8;
        if (i5 <= 0) {
            i9 = 0;
        }
        if (i10 == (i12 | i9)) {
            return i10;
        }
        return 0;
    }

    private int f(int i2) {
        g0 g0Var = this.f5525b;
        float a2 = g0Var != null ? g0Var.a(i2) : 0.0f;
        g0 g0Var2 = this.f5526c;
        return a(g0Var2 != null ? g0Var2.a(i2) : 255.0f, a2);
    }

    private static void l(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, PointF pointF) {
        double d10 = (d2 + d4) / 2.0d;
        double d11 = (d3 + d5) / 2.0d;
        double d12 = d6 - d10;
        double d13 = d7 - d11;
        double abs = Math.abs(d4 - d2) / 2.0d;
        double abs2 = Math.abs(d5 - d3) / 2.0d;
        double d14 = ((d9 - d11) - d13) / ((d8 - d10) - d12);
        double d15 = d13 - (d12 * d14);
        double d16 = abs2 * abs2;
        double d17 = abs * abs;
        double d18 = d16 + (d17 * d14 * d14);
        double d19 = abs * 2.0d * abs * d15 * d14;
        double d20 = (-(d17 * ((d15 * d15) - d16))) / d18;
        double d21 = d18 * 2.0d;
        double sqrt = ((-d19) / d21) - Math.sqrt(d20 + Math.pow(d19 / d21, 2.0d));
        double d22 = sqrt + d10;
        double d23 = (d14 * sqrt) + d15 + d11;
        if (Double.isNaN(d22) || Double.isNaN(d23)) {
            return;
        }
        pointF.x = (float) d22;
        pointF.y = (float) d23;
    }

    private boolean q(int i2) {
        g0 g0Var = this.f5525b;
        float a2 = g0Var != null ? g0Var.a(i2) : Float.NaN;
        g0 g0Var2 = this.f5526c;
        return (com.facebook.yoga.g.a(a2) || com.facebook.yoga.g.a(g0Var2 != null ? g0Var2.a(i2) : Float.NaN)) ? false : true;
    }

    private void s(int i2, float f2) {
        if (this.f5526c == null) {
            this.f5526c = new g0(255.0f);
        }
        if (com.facebook.react.uimanager.d.a(this.f5526c.b(i2), f2)) {
            return;
        }
        this.f5526c.d(i2, f2);
        invalidateSelf();
    }

    private void u(int i2, float f2) {
        if (this.f5525b == null) {
            this.f5525b = new g0(0.0f);
        }
        if (com.facebook.react.uimanager.d.a(this.f5525b.b(i2), f2)) {
            return;
        }
        this.f5525b.d(i2, f2);
        invalidateSelf();
    }

    public boolean A(int i2) {
        if (this.z != i2) {
            this.z = i2;
            return r(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        C();
        if (!p()) {
            c(canvas);
        } else {
            d(canvas);
        }
    }

    public float g(b bVar) {
        return h(Float.NaN, bVar);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.w;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return com.facebook.react.views.view.a.a(com.facebook.react.views.view.a.b(this.v, this.w));
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (Build.VERSION.SDK_INT < 21) {
            super.getOutline(outline);
        } else if ((!com.facebook.yoga.g.a(this.t) && this.t > 0.0f) || this.x != null) {
            B();
            outline.setConvexPath(this.f5531h);
        } else {
            outline.setRect(getBounds());
        }
    }

    public float h(float f2, b bVar) {
        float[] fArr = this.x;
        if (fArr == null) {
            return f2;
        }
        float f3 = fArr[bVar.ordinal()];
        return com.facebook.yoga.g.a(f3) ? f2 : f3;
    }

    public float i(float f2, int i2) {
        g0 g0Var = this.a;
        if (g0Var == null) {
            return f2;
        }
        float b2 = g0Var.b(i2);
        return com.facebook.yoga.g.a(b2) ? f2 : b2;
    }

    public int j() {
        return this.v;
    }

    public RectF k() {
        float i2 = i(0.0f, 8);
        float i3 = i(i2, 1);
        float i4 = i(i2, 3);
        float i5 = i(i2, 0);
        float i6 = i(i2, 2);
        if (Build.VERSION.SDK_INT >= 17 && this.a != null) {
            boolean z = o() == 1;
            float b2 = this.a.b(4);
            float b3 = this.a.b(5);
            if (com.facebook.react.modules.i18nmanager.a.d().b(this.y)) {
                if (!com.facebook.yoga.g.a(b2)) {
                    i5 = b2;
                }
                if (!com.facebook.yoga.g.a(b3)) {
                    i6 = b3;
                }
                float f2 = z ? i6 : i5;
                if (z) {
                    i6 = i5;
                }
                i5 = f2;
            } else {
                float f3 = z ? b3 : b2;
                if (!z) {
                    b2 = b3;
                }
                if (!com.facebook.yoga.g.a(f3)) {
                    i5 = f3;
                }
                if (!com.facebook.yoga.g.a(b2)) {
                    i6 = b2;
                }
            }
        }
        return new RectF(i5, i3, i6, i4);
    }

    public float m() {
        if (com.facebook.yoga.g.a(this.t)) {
            return 0.0f;
        }
        return this.t;
    }

    public float n() {
        g0 g0Var = this.a;
        if (g0Var == null || com.facebook.yoga.g.a(g0Var.b(8))) {
            return 0.0f;
        }
        return this.a.b(8);
    }

    public int o() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.s = true;
    }

    public boolean p() {
        if (com.facebook.yoga.g.a(this.t) || this.t <= 0.0f) {
            float[] fArr = this.x;
            if (fArr != null) {
                for (float f2 : fArr) {
                    if (!com.facebook.yoga.g.a(f2) && f2 > 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public boolean r(int i2) {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (i2 != this.w) {
            this.w = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void t(int i2, float f2, float f3) {
        u(i2, f2);
        s(i2, f3);
    }

    public void v(String str) {
        c valueOf = str == null ? null : c.valueOf(str.toUpperCase(Locale.US));
        if (this.f5527d != valueOf) {
            this.f5527d = valueOf;
            this.s = true;
            invalidateSelf();
        }
    }

    public void w(int i2, float f2) {
        if (this.a == null) {
            this.a = new g0();
        }
        if (com.facebook.react.uimanager.d.a(this.a.b(i2), f2)) {
            return;
        }
        this.a.d(i2, f2);
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
            this.s = true;
        }
        invalidateSelf();
    }

    public void x(int i2) {
        this.v = i2;
        invalidateSelf();
    }

    public void y(float f2) {
        if (com.facebook.react.uimanager.d.a(this.t, f2)) {
            return;
        }
        this.t = f2;
        this.s = true;
        invalidateSelf();
    }

    public void z(float f2, int i2) {
        if (this.x == null) {
            float[] fArr = new float[8];
            this.x = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (com.facebook.react.uimanager.d.a(this.x[i2], f2)) {
            return;
        }
        this.x[i2] = f2;
        this.s = true;
        invalidateSelf();
    }
}