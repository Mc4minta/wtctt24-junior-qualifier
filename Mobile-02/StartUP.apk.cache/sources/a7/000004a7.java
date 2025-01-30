package c.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import org.spongycastle.crypto.tls.CipherSuite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {
    private c a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f2514b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f2515c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f2516d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2518f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2520h;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f2521j;

    /* renamed from: k  reason: collision with root package name */
    private long f2522k;

    /* renamed from: l  reason: collision with root package name */
    private long f2523l;
    private C0055b m;

    /* renamed from: e  reason: collision with root package name */
    private int f2517e = 255;

    /* renamed from: g  reason: collision with root package name */
    private int f2519g = -1;

    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* renamed from: c.a.l.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055b implements Drawable.Callback {
        private Drawable.Callback a;

        C0055b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.a;
            this.a = null;
            return callback;
        }

        public C0055b b(Drawable.Callback callback) {
            this.a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static abstract class c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;
        final b a;

        /* renamed from: b  reason: collision with root package name */
        Resources f2524b;

        /* renamed from: c  reason: collision with root package name */
        int f2525c;

        /* renamed from: d  reason: collision with root package name */
        int f2526d;

        /* renamed from: e  reason: collision with root package name */
        int f2527e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f2528f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f2529g;

        /* renamed from: h  reason: collision with root package name */
        int f2530h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2531i;

        /* renamed from: j  reason: collision with root package name */
        boolean f2532j;

        /* renamed from: k  reason: collision with root package name */
        Rect f2533k;

        /* renamed from: l  reason: collision with root package name */
        boolean f2534l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(c cVar, b bVar, Resources resources) {
            Resources resources2;
            this.f2525c = CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256;
            this.f2531i = false;
            this.f2534l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.f2524b : null;
            }
            this.f2524b = resources2;
            int f2 = b.f(resources, cVar != null ? cVar.f2525c : 0);
            this.f2525c = f2;
            if (cVar != null) {
                this.f2526d = cVar.f2526d;
                this.f2527e = cVar.f2527e;
                this.v = true;
                this.w = true;
                this.f2531i = cVar.f2531i;
                this.f2534l = cVar.f2534l;
                this.x = cVar.x;
                this.y = cVar.y;
                this.z = cVar.z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.f2525c == f2) {
                    if (cVar.f2532j) {
                        this.f2533k = new Rect(cVar.f2533k);
                        this.f2532j = true;
                    }
                    if (cVar.m) {
                        this.n = cVar.n;
                        this.o = cVar.o;
                        this.p = cVar.p;
                        this.q = cVar.q;
                        this.m = true;
                    }
                }
                if (cVar.r) {
                    this.s = cVar.s;
                    this.r = true;
                }
                if (cVar.t) {
                    this.u = cVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = cVar.f2529g;
                this.f2529g = new Drawable[drawableArr.length];
                this.f2530h = cVar.f2530h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f2528f;
                if (sparseArray != null) {
                    this.f2528f = sparseArray.clone();
                } else {
                    this.f2528f = new SparseArray<>(this.f2530h);
                }
                int i2 = this.f2530h;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f2528f.put(i3, constantState);
                        } else {
                            this.f2529g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f2529g = new Drawable[10];
            this.f2530h = 0;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f2528f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f2529g[this.f2528f.keyAt(i2)] = s(this.f2528f.valueAt(i2).newDrawable(this.f2524b));
                }
                this.f2528f = null;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f2530h;
            if (i2 >= this.f2529g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.a);
            this.f2529g[i2] = drawable;
            this.f2530h++;
            this.f2527e = drawable.getChangingConfigurations() | this.f2527e;
            p();
            this.f2533k = null;
            this.f2532j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f2530h;
                Drawable[] drawableArr = this.f2529g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        this.f2527e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                y(theme.getResources());
            }
        }

        public synchronized boolean c() {
            if (this.v) {
                return this.w;
            }
            e();
            this.v = true;
            int i2 = this.f2530h;
            Drawable[] drawableArr = this.f2529g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i2 = this.f2530h;
            Drawable[] drawableArr = this.f2529g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f2528f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        protected void d() {
            this.m = true;
            e();
            int i2 = this.f2530h;
            Drawable[] drawableArr = this.f2529g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f2529g.length;
        }

        public final Drawable g(int i2) {
            int indexOfKey;
            Drawable drawable = this.f2529g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f2528f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable s = s(this.f2528f.valueAt(indexOfKey).newDrawable(this.f2524b));
            this.f2529g[i2] = s;
            this.f2528f.removeAt(indexOfKey);
            if (this.f2528f.size() == 0) {
                this.f2528f = null;
            }
            return s;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2526d | this.f2527e;
        }

        public final int h() {
            return this.f2530h;
        }

        public final int i() {
            if (!this.m) {
                d();
            }
            return this.o;
        }

        public final int j() {
            if (!this.m) {
                d();
            }
            return this.q;
        }

        public final int k() {
            if (!this.m) {
                d();
            }
            return this.p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f2531i) {
                return null;
            }
            Rect rect2 = this.f2533k;
            if (rect2 != null || this.f2532j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f2530h;
            Drawable[] drawableArr = this.f2529g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f2532j = true;
            this.f2533k = rect;
            return rect;
        }

        public final int m() {
            if (!this.m) {
                d();
            }
            return this.n;
        }

        public final int n() {
            if (this.r) {
                return this.s;
            }
            e();
            int i2 = this.f2530h;
            Drawable[] drawableArr = this.f2529g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f2529g, 0, drawableArr, 0, i2);
            this.f2529g = drawableArr;
        }

        void p() {
            this.r = false;
            this.t = false;
        }

        public final boolean q() {
            return this.f2534l;
        }

        abstract void r();

        public final void t(boolean z) {
            this.f2534l = z;
        }

        public final void u(int i2) {
            this.A = i2;
        }

        public final void v(int i2) {
            this.B = i2;
        }

        final boolean w(int i2, int i3) {
            int i4 = this.f2530h;
            Drawable[] drawableArr = this.f2529g;
            boolean z = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                    if (i5 == i3) {
                        z = layoutDirection;
                    }
                }
            }
            this.z = i2;
            return z;
        }

        public final void x(boolean z) {
            this.f2531i = z;
        }

        final void y(Resources resources) {
            if (resources != null) {
                this.f2524b = resources;
                int f2 = b.f(resources, this.f2525c);
                int i2 = this.f2525c;
                this.f2525c = f2;
                if (i2 != f2) {
                    this.m = false;
                    this.f2532j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.m == null) {
            this.m = new C0055b();
        }
        drawable.setCallback(this.m.b(drawable.getCallback()));
        try {
            if (this.a.A <= 0 && this.f2518f) {
                drawable.setAlpha(this.f2517e);
            }
            c cVar = this.a;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    androidx.core.graphics.drawable.a.o(drawable, cVar.F);
                }
                c cVar2 = this.a;
                if (cVar2.I) {
                    androidx.core.graphics.drawable.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i2 >= 19) {
                drawable.setAutoMirrored(this.a.C);
            }
            Rect rect = this.f2514b;
            if (i2 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        return i2 == 0 ? CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256 : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f2518f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f2515c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L36
            long r9 = r13.f2522k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f2517e
            r3.setAlpha(r9)
            r13.f2522k = r7
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            c.a.l.a.b$c r10 = r13.a
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f2517e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.f2522k = r7
        L38:
            r3 = r6
        L39:
            android.graphics.drawable.Drawable r9 = r13.f2516d
            if (r9 == 0) goto L61
            long r10 = r13.f2523l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f2516d = r0
            r13.f2523l = r7
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            c.a.l.a.b$c r4 = r13.a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f2517e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.f2523l = r7
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            java.lang.Runnable r14 = r13.f2521j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.l.a.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.a.b(theme);
    }

    c b() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f2519g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f2516d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f2519g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            c.a.l.a.b$c r0 = r9.a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f2516d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f2515c
            if (r0 == 0) goto L29
            r9.f2516d = r0
            c.a.l.a.b$c r0 = r9.a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f2523l = r0
            goto L35
        L29:
            r9.f2516d = r4
            r9.f2523l = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f2515c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            c.a.l.a.b$c r0 = r9.a
            int r1 = r0.f2530h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f2515c = r0
            r9.f2519g = r10
            if (r0 == 0) goto L5a
            c.a.l.a.b$c r10 = r9.a
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f2522k = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f2515c = r4
            r10 = -1
            r9.f2519g = r10
        L5a:
            long r0 = r9.f2522k
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.f2523l
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L79
        L67:
            java.lang.Runnable r10 = r9.f2521j
            if (r10 != 0) goto L73
            c.a.l.a.b$a r10 = new c.a.l.a.b$a
            r10.<init>()
            r9.f2521j = r10
            goto L76
        L73:
            r9.unscheduleSelf(r10)
        L76:
            r9.a(r0)
        L79:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.l.a.b.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2517e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.a.c()) {
            this.a.f2526d = getChangingConfigurations();
            return this.a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2515c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f2514b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.a.q()) {
            return this.a.i();
        }
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.a.q()) {
            return this.a.m();
        }
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.a.q()) {
            return this.a.j();
        }
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.a.q()) {
            return this.a.k();
        }
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2515c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l2 = this.a.l();
        if (l2 != null) {
            rect.set(l2);
            padding = (l2.right | ((l2.left | l2.top) | l2.bottom)) != 0;
        } else {
            Drawable drawable = this.f2515c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(c cVar) {
        this.a = cVar;
        int i2 = this.f2519g;
        if (i2 >= 0) {
            Drawable g2 = cVar.g(i2);
            this.f2515c = g2;
            if (g2 != null) {
                d(g2);
            }
        }
        this.f2516d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.a.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f2515c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f2516d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f2516d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f2515c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f2518f) {
                this.f2515c.setAlpha(this.f2517e);
            }
        }
        if (this.f2523l != 0) {
            this.f2523l = 0L;
            z = true;
        }
        if (this.f2522k != 0) {
            this.f2522k = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2520h && super.mutate() == this) {
            c b2 = b();
            b2.r();
            h(b2);
            this.f2520h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2516d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f2515c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.a.w(i2, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f2516d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f2515c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2516d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f2515c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable != this.f2515c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f2518f && this.f2517e == i2) {
            return;
        }
        this.f2518f = true;
        this.f2517e = i2;
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            if (this.f2522k == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        c cVar = this.a;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f2515c;
            if (drawable != null) {
                androidx.core.graphics.drawable.a.j(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f2515c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        c cVar = this.a;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f2515c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f2514b;
        if (rect == null) {
            this.f2514b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f2515c;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.l(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            androidx.core.graphics.drawable.a.o(this.f2515c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            androidx.core.graphics.drawable.a.p(this.f2515c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f2516d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f2515c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f2515c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}