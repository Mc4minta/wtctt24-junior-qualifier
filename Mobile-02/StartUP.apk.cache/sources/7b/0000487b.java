package e.g.a.f.m;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import c.h.k.v;
import com.google.android.material.internal.i;
import e.g.a.f.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes2.dex */
public class c {
    private static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final a f13313b;

    /* renamed from: c  reason: collision with root package name */
    private int f13314c;

    /* renamed from: d  reason: collision with root package name */
    private int f13315d;

    /* renamed from: e  reason: collision with root package name */
    private int f13316e;

    /* renamed from: f  reason: collision with root package name */
    private int f13317f;

    /* renamed from: g  reason: collision with root package name */
    private int f13318g;

    /* renamed from: h  reason: collision with root package name */
    private int f13319h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f13320i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f13321j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f13322k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f13323l;
    private GradientDrawable p;
    private Drawable q;
    private GradientDrawable r;
    private Drawable s;
    private GradientDrawable t;
    private GradientDrawable u;
    private GradientDrawable v;
    private final Paint m = new Paint(1);
    private final Rect n = new Rect();
    private final RectF o = new RectF();
    private boolean w = false;

    static {
        a = Build.VERSION.SDK_INT >= 21;
    }

    public c(a aVar) {
        this.f13313b = aVar;
    }

    private Drawable a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.p = gradientDrawable;
        gradientDrawable.setCornerRadius(this.f13318g + 1.0E-5f);
        this.p.setColor(-1);
        Drawable r = androidx.core.graphics.drawable.a.r(this.p);
        this.q = r;
        androidx.core.graphics.drawable.a.o(r, this.f13321j);
        PorterDuff.Mode mode = this.f13320i;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(this.q, mode);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.r = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.f13318g + 1.0E-5f);
        this.r.setColor(-1);
        Drawable r2 = androidx.core.graphics.drawable.a.r(this.r);
        this.s = r2;
        androidx.core.graphics.drawable.a.o(r2, this.f13323l);
        return y(new LayerDrawable(new Drawable[]{this.q, this.s}));
    }

    @TargetApi(21)
    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.t = gradientDrawable;
        gradientDrawable.setCornerRadius(this.f13318g + 1.0E-5f);
        this.t.setColor(-1);
        x();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.u = gradientDrawable2;
        gradientDrawable2.setCornerRadius(this.f13318g + 1.0E-5f);
        this.u.setColor(0);
        this.u.setStroke(this.f13319h, this.f13322k);
        InsetDrawable y = y(new LayerDrawable(new Drawable[]{this.t, this.u}));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.v = gradientDrawable3;
        gradientDrawable3.setCornerRadius(this.f13318g + 1.0E-5f);
        this.v.setColor(-1);
        return new b(e.g.a.f.r.a.a(this.f13323l), y, this.v);
    }

    private GradientDrawable t() {
        if (!a || this.f13313b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f13313b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable u() {
        if (!a || this.f13313b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f13313b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void w() {
        boolean z = a;
        if (z && this.u != null) {
            this.f13313b.setInternalBackground(b());
        } else if (z) {
        } else {
            this.f13313b.invalidate();
        }
    }

    private void x() {
        GradientDrawable gradientDrawable = this.t;
        if (gradientDrawable != null) {
            androidx.core.graphics.drawable.a.o(gradientDrawable, this.f13321j);
            PorterDuff.Mode mode = this.f13320i;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.t, mode);
            }
        }
    }

    private InsetDrawable y(Drawable drawable) {
        return new InsetDrawable(drawable, this.f13314c, this.f13316e, this.f13315d, this.f13317f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Canvas canvas) {
        if (canvas == null || this.f13322k == null || this.f13319h <= 0) {
            return;
        }
        this.n.set(this.f13313b.getBackground().getBounds());
        RectF rectF = this.o;
        Rect rect = this.n;
        int i2 = this.f13319h;
        rectF.set(rect.left + (i2 / 2.0f) + this.f13314c, rect.top + (i2 / 2.0f) + this.f13316e, (rect.right - (i2 / 2.0f)) - this.f13315d, (rect.bottom - (i2 / 2.0f)) - this.f13317f);
        float f2 = this.f13318g - (this.f13319h / 2.0f);
        canvas.drawRoundRect(this.o, f2, f2, this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f13318g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.f13323l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f13322k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f13319h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f13321j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode i() {
        return this.f13320i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.w;
    }

    public void k(TypedArray typedArray) {
        this.f13314c = typedArray.getDimensionPixelOffset(k.F0, 0);
        this.f13315d = typedArray.getDimensionPixelOffset(k.G0, 0);
        this.f13316e = typedArray.getDimensionPixelOffset(k.H0, 0);
        this.f13317f = typedArray.getDimensionPixelOffset(k.I0, 0);
        this.f13318g = typedArray.getDimensionPixelSize(k.L0, 0);
        this.f13319h = typedArray.getDimensionPixelSize(k.U0, 0);
        this.f13320i = i.b(typedArray.getInt(k.K0, -1), PorterDuff.Mode.SRC_IN);
        this.f13321j = e.g.a.f.q.a.a(this.f13313b.getContext(), typedArray, k.J0);
        this.f13322k = e.g.a.f.q.a.a(this.f13313b.getContext(), typedArray, k.T0);
        this.f13323l = e.g.a.f.q.a.a(this.f13313b.getContext(), typedArray, k.S0);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setStrokeWidth(this.f13319h);
        Paint paint = this.m;
        ColorStateList colorStateList = this.f13322k;
        paint.setColor(colorStateList != null ? colorStateList.getColorForState(this.f13313b.getDrawableState(), 0) : 0);
        int D = v.D(this.f13313b);
        int paddingTop = this.f13313b.getPaddingTop();
        int C = v.C(this.f13313b);
        int paddingBottom = this.f13313b.getPaddingBottom();
        this.f13313b.setInternalBackground(a ? b() : a());
        v.x0(this.f13313b, D + this.f13314c, paddingTop + this.f13316e, C + this.f13315d, paddingBottom + this.f13317f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        boolean z = a;
        if (z && (gradientDrawable2 = this.t) != null) {
            gradientDrawable2.setColor(i2);
        } else if (z || (gradientDrawable = this.p) == null) {
        } else {
            gradientDrawable.setColor(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        this.w = true;
        this.f13313b.setSupportBackgroundTintList(this.f13321j);
        this.f13313b.setSupportBackgroundTintMode(this.f13320i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i2) {
        GradientDrawable gradientDrawable;
        if (this.f13318g != i2) {
            this.f13318g = i2;
            boolean z = a;
            if (!z || this.t == null || this.u == null || this.v == null) {
                if (z || (gradientDrawable = this.p) == null || this.r == null) {
                    return;
                }
                float f2 = i2 + 1.0E-5f;
                gradientDrawable.setCornerRadius(f2);
                this.r.setCornerRadius(f2);
                this.f13313b.invalidate();
                return;
            }
            if (Build.VERSION.SDK_INT == 21) {
                float f3 = i2 + 1.0E-5f;
                t().setCornerRadius(f3);
                u().setCornerRadius(f3);
            }
            float f4 = i2 + 1.0E-5f;
            this.t.setCornerRadius(f4);
            this.u.setCornerRadius(f4);
            this.v.setCornerRadius(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f13323l != colorStateList) {
            this.f13323l = colorStateList;
            boolean z = a;
            if (z && (this.f13313b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f13313b.getBackground()).setColor(colorStateList);
            } else if (z || (drawable = this.s) == null) {
            } else {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ColorStateList colorStateList) {
        if (this.f13322k != colorStateList) {
            this.f13322k = colorStateList;
            this.m.setColor(colorStateList != null ? colorStateList.getColorForState(this.f13313b.getDrawableState(), 0) : 0);
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i2) {
        if (this.f13319h != i2) {
            this.f13319h = i2;
            this.m.setStrokeWidth(i2);
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(ColorStateList colorStateList) {
        if (this.f13321j != colorStateList) {
            this.f13321j = colorStateList;
            if (a) {
                x();
                return;
            }
            Drawable drawable = this.q;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(PorterDuff.Mode mode) {
        if (this.f13320i != mode) {
            this.f13320i = mode;
            if (a) {
                x();
                return;
            }
            Drawable drawable = this.q;
            if (drawable == null || mode == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i2, int i3) {
        GradientDrawable gradientDrawable = this.v;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f13314c, this.f13316e, i3 - this.f13315d, i2 - this.f13317f);
        }
    }
}