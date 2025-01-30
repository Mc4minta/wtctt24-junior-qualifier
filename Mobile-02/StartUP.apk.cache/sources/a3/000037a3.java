package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.s0;
import c.h.k.v;

/* compiled from: CollapsingTextHelper.java */
/* loaded from: classes2.dex */
public final class b {
    private static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f8178b;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private final TextPaint J;
    private final TextPaint K;
    private TimeInterpolator L;
    private TimeInterpolator M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private int U;

    /* renamed from: c  reason: collision with root package name */
    private final View f8179c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8180d;

    /* renamed from: e  reason: collision with root package name */
    private float f8181e;

    /* renamed from: f  reason: collision with root package name */
    private final Rect f8182f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f8183g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f8184h;

    /* renamed from: i  reason: collision with root package name */
    private int f8185i = 16;

    /* renamed from: j  reason: collision with root package name */
    private int f8186j = 16;

    /* renamed from: k  reason: collision with root package name */
    private float f8187k = 15.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f8188l = 15.0f;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;

    static {
        a = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        f8178b = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public b(View view) {
        this.f8179c = view;
        TextPaint textPaint = new TextPaint(129);
        this.J = textPaint;
        this.K = new TextPaint(textPaint);
        this.f8183g = new Rect();
        this.f8182f = new Rect();
        this.f8184h = new RectF();
    }

    private Typeface B(int i2) {
        TypedArray obtainStyledAttributes = this.f8179c.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean D(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void Q(float f2) {
        g(f2);
        boolean z = a && this.F != 1.0f;
        this.A = z;
        if (z) {
            j();
        }
        v.b0(this.f8179c);
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    private void b() {
        float f2 = this.G;
        g(this.f8188l);
        CharSequence charSequence = this.y;
        float measureText = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int b2 = c.h.k.d.b(this.f8186j, this.z ? 1 : 0);
        int i2 = b2 & 112;
        if (i2 == 48) {
            this.p = this.f8183g.top - this.J.ascent();
        } else if (i2 != 80) {
            this.p = this.f8183g.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.p = this.f8183g.bottom;
        }
        int i3 = b2 & 8388615;
        if (i3 == 1) {
            this.r = this.f8183g.centerX() - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.r = this.f8183g.left;
        } else {
            this.r = this.f8183g.right - measureText;
        }
        g(this.f8187k);
        CharSequence charSequence2 = this.y;
        float measureText2 = charSequence2 != null ? this.J.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int b3 = c.h.k.d.b(this.f8185i, this.z ? 1 : 0);
        int i4 = b3 & 112;
        if (i4 == 48) {
            this.o = this.f8182f.top - this.J.ascent();
        } else if (i4 != 80) {
            this.o = this.f8182f.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.o = this.f8182f.bottom;
        }
        int i5 = b3 & 8388615;
        if (i5 == 1) {
            this.q = this.f8182f.centerX() - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.q = this.f8182f.left;
        } else {
            this.q = this.f8182f.right - measureText2;
        }
        h();
        Q(f2);
    }

    private void d() {
        f(this.f8181e);
    }

    private boolean e(CharSequence charSequence) {
        return (v.y(this.f8179c) == 1 ? c.h.j.d.f2992d : c.h.j.d.f2991c).a(charSequence, 0, charSequence.length());
    }

    private void f(float f2) {
        w(f2);
        this.s = z(this.q, this.r, f2, this.L);
        this.t = z(this.o, this.p, f2, this.L);
        Q(z(this.f8187k, this.f8188l, f2, this.M));
        if (this.n != this.m) {
            this.J.setColor(a(q(), p(), f2));
        } else {
            this.J.setColor(p());
        }
        this.J.setShadowLayer(z(this.R, this.N, f2, null), z(this.S, this.O, f2, null), z(this.T, this.P, f2, null), a(this.U, this.Q, f2));
        v.b0(this.f8179c);
    }

    private void g(float f2) {
        boolean z;
        float f3;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float width = this.f8183g.width();
        float width2 = this.f8182f.width();
        if (x(f2, this.f8188l)) {
            f3 = this.f8188l;
            this.F = 1.0f;
            Typeface typeface = this.w;
            Typeface typeface2 = this.u;
            if (typeface != typeface2) {
                this.w = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f4 = this.f8187k;
            Typeface typeface3 = this.w;
            Typeface typeface4 = this.v;
            if (typeface3 != typeface4) {
                this.w = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (x(f2, f4)) {
                this.F = 1.0f;
            } else {
                this.F = f2 / this.f8187k;
            }
            float f5 = this.f8188l / this.f8187k;
            width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
            f3 = f4;
            z2 = z;
        }
        if (width > 0.0f) {
            z2 = this.G != f3 || this.I || z2;
            this.G = f3;
            this.I = false;
        }
        if (this.y == null || z2) {
            this.J.setTextSize(this.G);
            this.J.setTypeface(this.w);
            this.J.setLinearText(this.F != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.y)) {
                return;
            }
            this.y = ellipsize;
            this.z = e(ellipsize);
        }
    }

    private void h() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private void j() {
        if (this.B != null || this.f8182f.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        f(0.0f);
        this.D = this.J.ascent();
        this.E = this.J.descent();
        TextPaint textPaint = this.J;
        CharSequence charSequence = this.y;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.E - this.D);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        CharSequence charSequence2 = this.y;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.J.descent(), this.J);
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private int q() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.m.getColorForState(iArr, 0);
        }
        return this.m.getDefaultColor();
    }

    private void v(TextPaint textPaint) {
        textPaint.setTextSize(this.f8188l);
        textPaint.setTypeface(this.u);
    }

    private void w(float f2) {
        this.f8184h.left = z(this.f8182f.left, this.f8183g.left, f2, this.L);
        this.f8184h.top = z(this.o, this.p, f2, this.L);
        this.f8184h.right = z(this.f8182f.right, this.f8183g.right, f2, this.L);
        this.f8184h.bottom = z(this.f8182f.bottom, this.f8183g.bottom, f2, this.L);
    }

    private static boolean x(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static float z(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return e.g.a.f.l.a.a(f2, f3, f4);
    }

    void A() {
        this.f8180d = this.f8183g.width() > 0 && this.f8183g.height() > 0 && this.f8182f.width() > 0 && this.f8182f.height() > 0;
    }

    public void C() {
        if (this.f8179c.getHeight() <= 0 || this.f8179c.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }

    public void E(int i2, int i3, int i4, int i5) {
        if (D(this.f8183g, i2, i3, i4, i5)) {
            return;
        }
        this.f8183g.set(i2, i3, i4, i5);
        this.I = true;
        A();
    }

    public void F(int i2) {
        s0 t = s0.t(this.f8179c.getContext(), i2, c.a.j.X2);
        int i3 = c.a.j.b3;
        if (t.s(i3)) {
            this.n = t.c(i3);
        }
        int i4 = c.a.j.Y2;
        if (t.s(i4)) {
            this.f8188l = t.f(i4, (int) this.f8188l);
        }
        this.Q = t.k(c.a.j.e3, 0);
        this.O = t.i(c.a.j.f3, 0.0f);
        this.P = t.i(c.a.j.g3, 0.0f);
        this.N = t.i(c.a.j.h3, 0.0f);
        t.w();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = B(i2);
        }
        C();
    }

    public void G(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            C();
        }
    }

    public void H(int i2) {
        if (this.f8186j != i2) {
            this.f8186j = i2;
            C();
        }
    }

    public void I(Typeface typeface) {
        if (this.u != typeface) {
            this.u = typeface;
            C();
        }
    }

    public void J(int i2, int i3, int i4, int i5) {
        if (D(this.f8182f, i2, i3, i4, i5)) {
            return;
        }
        this.f8182f.set(i2, i3, i4, i5);
        this.I = true;
        A();
    }

    public void K(int i2) {
        s0 t = s0.t(this.f8179c.getContext(), i2, c.a.j.X2);
        int i3 = c.a.j.b3;
        if (t.s(i3)) {
            this.m = t.c(i3);
        }
        int i4 = c.a.j.Y2;
        if (t.s(i4)) {
            this.f8187k = t.f(i4, (int) this.f8187k);
        }
        this.U = t.k(c.a.j.e3, 0);
        this.S = t.i(c.a.j.f3, 0.0f);
        this.T = t.i(c.a.j.g3, 0.0f);
        this.R = t.i(c.a.j.h3, 0.0f);
        t.w();
        if (Build.VERSION.SDK_INT >= 16) {
            this.v = B(i2);
        }
        C();
    }

    public void L(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            C();
        }
    }

    public void M(int i2) {
        if (this.f8185i != i2) {
            this.f8185i = i2;
            C();
        }
    }

    public void N(float f2) {
        if (this.f8187k != f2) {
            this.f8187k = f2;
            C();
        }
    }

    public void O(Typeface typeface) {
        if (this.v != typeface) {
            this.v = typeface;
            C();
        }
    }

    public void P(float f2) {
        float a2 = c.h.h.a.a(f2, 0.0f, 1.0f);
        if (a2 != this.f8181e) {
            this.f8181e = a2;
            d();
        }
    }

    public void R(TimeInterpolator timeInterpolator) {
        this.L = timeInterpolator;
        C();
    }

    public final boolean S(int[] iArr) {
        this.H = iArr;
        if (y()) {
            C();
            return true;
        }
        return false;
    }

    public void T(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            h();
            C();
        }
    }

    public void U(TimeInterpolator timeInterpolator) {
        this.M = timeInterpolator;
        C();
    }

    public void V(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        C();
    }

    public float c() {
        if (this.x == null) {
            return 0.0f;
        }
        v(this.K);
        TextPaint textPaint = this.K;
        CharSequence charSequence = this.x;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void i(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.y != null && this.f8180d) {
            float f2 = this.s;
            float f3 = this.t;
            boolean z = this.A && this.B != null;
            if (z) {
                ascent = this.D * this.F;
            } else {
                ascent = this.J.ascent() * this.F;
                this.J.descent();
            }
            if (z) {
                f3 += ascent;
            }
            float f4 = f3;
            float f5 = this.F;
            if (f5 != 1.0f) {
                canvas.scale(f5, f5, f2, f4);
            }
            if (z) {
                canvas.drawBitmap(this.B, f2, f4, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f2, f4, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    public void k(RectF rectF) {
        boolean e2 = e(this.x);
        Rect rect = this.f8183g;
        float c2 = !e2 ? rect.left : rect.right - c();
        rectF.left = c2;
        Rect rect2 = this.f8183g;
        rectF.top = rect2.top;
        rectF.right = !e2 ? c2 + c() : rect2.right;
        rectF.bottom = this.f8183g.top + n();
    }

    public ColorStateList l() {
        return this.n;
    }

    public int m() {
        return this.f8186j;
    }

    public float n() {
        v(this.K);
        return -this.K.ascent();
    }

    public Typeface o() {
        Typeface typeface = this.u;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int p() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.n.getColorForState(iArr, 0);
        }
        return this.n.getDefaultColor();
    }

    public int r() {
        return this.f8185i;
    }

    public Typeface s() {
        Typeface typeface = this.v;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float t() {
        return this.f8181e;
    }

    public CharSequence u() {
        return this.x;
    }

    public final boolean y() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.n;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.m) != null && colorStateList.isStateful());
    }
}