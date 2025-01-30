package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.h;

/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {
    private static final Interpolator a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f2344b = new c.m.a.a.b();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f2345c = {-16777216};

    /* renamed from: d  reason: collision with root package name */
    private final c f2346d;

    /* renamed from: e  reason: collision with root package name */
    private float f2347e;

    /* renamed from: f  reason: collision with root package name */
    private Resources f2348f;

    /* renamed from: g  reason: collision with root package name */
    private Animator f2349g;

    /* renamed from: h  reason: collision with root package name */
    float f2350h;

    /* renamed from: j  reason: collision with root package name */
    boolean f2351j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(floatValue, this.a);
            b.this.b(floatValue, this.a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: androidx.swiperefreshlayout.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b implements Animator.AnimatorListener {
        final /* synthetic */ c a;

        C0045b(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.a, true);
            this.a.A();
            this.a.l();
            b bVar = b.this;
            if (bVar.f2351j) {
                bVar.f2351j = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.a.x(false);
                return;
            }
            bVar.f2350h += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f2350h = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public static class c {
        final RectF a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f2354b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f2355c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f2356d;

        /* renamed from: e  reason: collision with root package name */
        float f2357e;

        /* renamed from: f  reason: collision with root package name */
        float f2358f;

        /* renamed from: g  reason: collision with root package name */
        float f2359g;

        /* renamed from: h  reason: collision with root package name */
        float f2360h;

        /* renamed from: i  reason: collision with root package name */
        int[] f2361i;

        /* renamed from: j  reason: collision with root package name */
        int f2362j;

        /* renamed from: k  reason: collision with root package name */
        float f2363k;

        /* renamed from: l  reason: collision with root package name */
        float f2364l;
        float m;
        boolean n;
        Path o;
        float p;
        float q;
        int r;
        int s;
        int t;
        int u;

        c() {
            Paint paint = new Paint();
            this.f2354b = paint;
            Paint paint2 = new Paint();
            this.f2355c = paint2;
            Paint paint3 = new Paint();
            this.f2356d = paint3;
            this.f2357e = 0.0f;
            this.f2358f = 0.0f;
            this.f2359g = 0.0f;
            this.f2360h = 5.0f;
            this.p = 1.0f;
            this.t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f2363k = this.f2357e;
            this.f2364l = this.f2358f;
            this.m = this.f2359g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            float f2 = this.q;
            float f3 = (this.f2360h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.f2360h / 2.0f);
            }
            rectF.set(rect.centerX() - f3, rect.centerY() - f3, rect.centerX() + f3, rect.centerY() + f3);
            float f4 = this.f2357e;
            float f5 = this.f2359g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f2358f + f5) * 360.0f) - f6;
            this.f2354b.setColor(this.u);
            this.f2354b.setAlpha(this.t);
            float f8 = this.f2360h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f2356d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f2354b);
            b(canvas, f6, f7, rectF);
        }

        void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f4 = this.p;
                path3.lineTo((this.r * f4) / 2.0f, this.s * f4);
                this.o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.r * this.p) / 2.0f), rectF.centerY() + (this.f2360h / 2.0f));
                this.o.close();
                this.f2355c.setColor(this.u);
                this.f2355c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f2355c);
                canvas.restore();
            }
        }

        int c() {
            return this.t;
        }

        float d() {
            return this.f2358f;
        }

        int e() {
            return this.f2361i[f()];
        }

        int f() {
            return (this.f2362j + 1) % this.f2361i.length;
        }

        float g() {
            return this.f2357e;
        }

        int h() {
            return this.f2361i[this.f2362j];
        }

        float i() {
            return this.f2364l;
        }

        float j() {
            return this.m;
        }

        float k() {
            return this.f2363k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f2363k = 0.0f;
            this.f2364l = 0.0f;
            this.m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        void n(int i2) {
            this.t = i2;
        }

        void o(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        void p(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }

        void q(float f2) {
            this.q = f2;
        }

        void r(int i2) {
            this.u = i2;
        }

        void s(ColorFilter colorFilter) {
            this.f2354b.setColorFilter(colorFilter);
        }

        void t(int i2) {
            this.f2362j = i2;
            this.u = this.f2361i[i2];
        }

        void u(int[] iArr) {
            this.f2361i = iArr;
            t(0);
        }

        void v(float f2) {
            this.f2358f = f2;
        }

        void w(float f2) {
            this.f2359g = f2;
        }

        void x(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void y(float f2) {
            this.f2357e = f2;
        }

        void z(float f2) {
            this.f2360h = f2;
            this.f2354b.setStrokeWidth(f2);
        }
    }

    public b(Context context) {
        this.f2348f = ((Context) h.b(context)).getResources();
        c cVar = new c();
        this.f2346d = cVar;
        cVar.u(f2345c);
        k(2.5f);
        m();
    }

    private void a(float f2, c cVar) {
        n(f2, cVar);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f2));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((((float) (Math.floor(cVar.j() / 0.8f) + 1.0d)) - cVar.j()) * f2));
    }

    private int c(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
    }

    private void h(float f2) {
        this.f2347e = f2;
    }

    private void i(float f2, float f3, float f4, float f5) {
        c cVar = this.f2346d;
        float f6 = this.f2348f.getDisplayMetrics().density;
        cVar.z(f3 * f6);
        cVar.q(f2 * f6);
        cVar.t(0);
        cVar.o(f4 * f6, f5 * f6);
    }

    private void m() {
        c cVar = this.f2346d;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(a);
        ofFloat.addListener(new C0045b(cVar));
        this.f2349g = ofFloat;
    }

    void b(float f2, c cVar, boolean z) {
        float interpolation;
        float f3;
        if (this.f2351j) {
            a(f2, cVar);
        } else if (f2 != 1.0f || z) {
            float j2 = cVar.j();
            if (f2 < 0.5f) {
                interpolation = cVar.k();
                f3 = (f2344b.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float k2 = cVar.k() + 0.79f;
                interpolation = k2 - (((1.0f - f2344b.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = k2;
            }
            cVar.y(interpolation);
            cVar.v(f3);
            cVar.w(j2 + (0.20999998f * f2));
            h((f2 + this.f2350h) * 216.0f);
        }
    }

    public void d(boolean z) {
        this.f2346d.x(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f2347e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f2346d.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f2) {
        this.f2346d.p(f2);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f2346d.u(iArr);
        this.f2346d.t(0);
        invalidateSelf();
    }

    public void g(float f2) {
        this.f2346d.w(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2346d.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f2349g.isRunning();
    }

    public void j(float f2, float f3) {
        this.f2346d.y(f2);
        this.f2346d.v(f3);
        invalidateSelf();
    }

    public void k(float f2) {
        this.f2346d.z(f2);
        invalidateSelf();
    }

    public void l(int i2) {
        if (i2 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f2, c cVar) {
        if (f2 > 0.75f) {
            cVar.r(c((f2 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f2346d.n(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2346d.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f2349g.cancel();
        this.f2346d.A();
        if (this.f2346d.d() != this.f2346d.g()) {
            this.f2351j = true;
            this.f2349g.setDuration(666L);
            this.f2349g.start();
            return;
        }
        this.f2346d.t(0);
        this.f2346d.m();
        this.f2349g.setDuration(1332L);
        this.f2349g.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f2349g.cancel();
        h(0.0f);
        this.f2346d.x(false);
        this.f2346d.t(0);
        this.f2346d.m();
        invalidateSelf();
    }
}