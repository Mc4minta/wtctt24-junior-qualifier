package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import c.h.k.v;
import org.apache.http.HttpStatus;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int a = ViewConfiguration.getTapTimeout();

    /* renamed from: d  reason: collision with root package name */
    final View f1556d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1557e;

    /* renamed from: h  reason: collision with root package name */
    private int f1560h;

    /* renamed from: j  reason: collision with root package name */
    private int f1561j;
    private boolean n;
    boolean p;
    boolean q;
    boolean t;
    private boolean u;
    private boolean v;

    /* renamed from: b  reason: collision with root package name */
    final C0030a f1554b = new C0030a();

    /* renamed from: c  reason: collision with root package name */
    private final Interpolator f1555c = new AccelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private float[] f1558f = {0.0f, 0.0f};

    /* renamed from: g  reason: collision with root package name */
    private float[] f1559g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: k  reason: collision with root package name */
    private float[] f1562k = {0.0f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    private float[] f1563l = {0.0f, 0.0f};
    private float[] m = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030a {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f1564b;

        /* renamed from: c  reason: collision with root package name */
        private float f1565c;

        /* renamed from: d  reason: collision with root package name */
        private float f1566d;

        /* renamed from: j  reason: collision with root package name */
        private float f1572j;

        /* renamed from: k  reason: collision with root package name */
        private int f1573k;

        /* renamed from: e  reason: collision with root package name */
        private long f1567e = Long.MIN_VALUE;

        /* renamed from: i  reason: collision with root package name */
        private long f1571i = -1;

        /* renamed from: f  reason: collision with root package name */
        private long f1568f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f1569g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f1570h = 0;

        C0030a() {
        }

        private float e(long j2) {
            long j3 = this.f1567e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f1571i;
            if (j4 >= 0 && j2 >= j4) {
                float f2 = this.f1572j;
                return (1.0f - f2) + (f2 * a.e(((float) (j2 - j4)) / this.f1573k, 0.0f, 1.0f));
            }
            return a.e(((float) (j2 - j3)) / this.a, 0.0f, 1.0f) * 0.5f;
        }

        private float g(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f1568f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g2 = g(e(currentAnimationTimeMillis));
                this.f1568f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f1568f)) * g2;
                this.f1569g = (int) (this.f1565c * f2);
                this.f1570h = (int) (f2 * this.f1566d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f1569g;
        }

        public int c() {
            return this.f1570h;
        }

        public int d() {
            float f2 = this.f1565c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f1566d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.f1571i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1571i + ((long) this.f1573k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1573k = a.f((int) (currentAnimationTimeMillis - this.f1567e), 0, this.f1564b);
            this.f1572j = e(currentAnimationTimeMillis);
            this.f1571i = currentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f1564b = i2;
        }

        public void k(int i2) {
            this.a = i2;
        }

        public void l(float f2, float f3) {
            this.f1565c = f2;
            this.f1566d = f3;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1567e = currentAnimationTimeMillis;
            this.f1571i = -1L;
            this.f1568f = currentAnimationTimeMillis;
            this.f1572j = 0.5f;
            this.f1569g = 0;
            this.f1570h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.t) {
                if (aVar.p) {
                    aVar.p = false;
                    aVar.f1554b.m();
                }
                C0030a c0030a = a.this.f1554b;
                if (!c0030a.h() && a.this.u()) {
                    a aVar2 = a.this;
                    if (aVar2.q) {
                        aVar2.q = false;
                        aVar2.c();
                    }
                    c0030a.a();
                    a.this.j(c0030a.b(), c0030a.c());
                    v.c0(a.this.f1556d, this);
                    return;
                }
                a.this.t = false;
            }
        }
    }

    public a(View view) {
        this.f1556d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        o(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(a);
        r(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        q(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    private float d(int i2, float f2, float f3, float f4) {
        float h2 = h(this.f1558f[i2], f3, this.f1559g[i2], f2);
        int i3 = (h2 > 0.0f ? 1 : (h2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0.0f;
        }
        float f5 = this.f1562k[i2];
        float f6 = this.f1563l[i2];
        float f7 = this.m[i2];
        float f8 = f5 * f4;
        if (i3 > 0) {
            return e(h2 * f8, f6, f7);
        }
        return -e((-h2) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f1560h;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.t && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float interpolation;
        float e2 = e(f2 * f3, 0.0f, f4);
        float g2 = g(f3 - f5, e2) - g(f5, e2);
        if (g2 < 0.0f) {
            interpolation = -this.f1555c.getInterpolation(-g2);
        } else if (g2 <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.f1555c.getInterpolation(g2);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.p) {
            this.t = false;
        } else {
            this.f1554b.i();
        }
    }

    private void v() {
        int i2;
        if (this.f1557e == null) {
            this.f1557e = new b();
        }
        this.t = true;
        this.p = true;
        if (!this.n && (i2 = this.f1561j) > 0) {
            v.d0(this.f1556d, this.f1557e, i2);
        } else {
            this.f1557e.run();
        }
        this.n = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1556d.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i2, int i3);

    public a k(int i2) {
        this.f1561j = i2;
        return this;
    }

    public a l(int i2) {
        this.f1560h = i2;
        return this;
    }

    public a m(boolean z) {
        if (this.u && !z) {
            i();
        }
        this.u = z;
        return this;
    }

    public a n(float f2, float f3) {
        float[] fArr = this.f1559g;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a o(float f2, float f3) {
        float[] fArr = this.m;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.u
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.q = r2
            r5.n = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1556d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1556d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f1554b
            r7.l(r0, r6)
            boolean r6 = r5.t
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.v
            if (r6 == 0) goto L61
            boolean r6 = r5.t
            if (r6 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f2, float f3) {
        float[] fArr = this.f1563l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a q(int i2) {
        this.f1554b.j(i2);
        return this;
    }

    public a r(int i2) {
        this.f1554b.k(i2);
        return this;
    }

    public a s(float f2, float f3) {
        float[] fArr = this.f1558f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a t(float f2, float f3) {
        float[] fArr = this.f1562k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    boolean u() {
        C0030a c0030a = this.f1554b;
        int f2 = c0030a.f();
        int d2 = c0030a.d();
        return (f2 != 0 && b(f2)) || (d2 != 0 && a(d2));
    }
}