package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.widget.i0;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class h {
    private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static h f804b;

    /* renamed from: c  reason: collision with root package name */
    private i0 f805c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public class a implements i0.e {
        private final int[] a = {c.a.e.S, c.a.e.Q, c.a.e.a};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f806b = {c.a.e.o, c.a.e.B, c.a.e.t, c.a.e.p, c.a.e.q, c.a.e.s, c.a.e.r};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f807c = {c.a.e.P, c.a.e.R, c.a.e.f2458k, c.a.e.I, c.a.e.J, c.a.e.L, c.a.e.N, c.a.e.K, c.a.e.M, c.a.e.O};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f808d = {c.a.e.w, c.a.e.f2456i, c.a.e.v};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f809e = {c.a.e.H, c.a.e.T};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f810f = {c.a.e.f2450c, c.a.e.f2454g, c.a.e.f2451d, c.a.e.f2455h};

        a() {
        }

        private boolean f(int[] iArr, int i2) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList g(Context context) {
            return h(context, 0);
        }

        private ColorStateList h(Context context, int i2) {
            int c2 = n0.c(context, c.a.a.v);
            return new ColorStateList(new int[][]{n0.f860b, n0.f863e, n0.f861c, n0.f867i}, new int[]{n0.b(context, c.a.a.t), c.h.e.a.e(c2, i2), c.h.e.a.e(c2, i2), i2});
        }

        private ColorStateList i(Context context) {
            return h(context, n0.c(context, c.a.a.s));
        }

        private ColorStateList j(Context context) {
            return h(context, n0.c(context, c.a.a.t));
        }

        private ColorStateList k(Context context) {
            int[][] iArr = new int[3];
            int[] iArr2 = new int[3];
            int i2 = c.a.a.y;
            ColorStateList e2 = n0.e(context, i2);
            if (e2 != null && e2.isStateful()) {
                iArr[0] = n0.f860b;
                iArr2[0] = e2.getColorForState(iArr[0], 0);
                iArr[1] = n0.f864f;
                iArr2[1] = n0.c(context, c.a.a.u);
                iArr[2] = n0.f867i;
                iArr2[2] = e2.getDefaultColor();
            } else {
                iArr[0] = n0.f860b;
                iArr2[0] = n0.b(context, i2);
                iArr[1] = n0.f864f;
                iArr2[1] = n0.c(context, c.a.a.u);
                iArr[2] = n0.f867i;
                iArr2[2] = n0.c(context, i2);
            }
            return new ColorStateList(iArr, iArr2);
        }

        private void l(Drawable drawable, int i2, PorterDuff.Mode mode) {
            if (z.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = h.a;
            }
            drawable.setColorFilter(h.e(i2, mode));
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
        @Override // androidx.appcompat.widget.i0.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.h.a()
                int[] r1 = r6.a
                boolean r1 = r6.f(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L17
                int r2 = c.a.a.w
            L14:
                r8 = r3
            L15:
                r1 = r5
                goto L44
            L17:
                int[] r1 = r6.f807c
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L22
                int r2 = c.a.a.u
                goto L14
            L22:
                int[] r1 = r6.f808d
                boolean r1 = r6.f(r1, r8)
                if (r1 == 0) goto L2d
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L14
            L2d:
                int r1 = c.a.e.u
                if (r8 != r1) goto L3c
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                goto L15
            L3c:
                int r1 = c.a.e.f2459l
                if (r8 != r1) goto L41
                goto L14
            L41:
                r8 = r3
                r1 = r4
                r2 = r1
            L44:
                if (r1 == 0) goto L61
                boolean r1 = androidx.appcompat.widget.z.a(r9)
                if (r1 == 0) goto L50
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L50:
                int r7 = androidx.appcompat.widget.n0.c(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.h.e(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r3) goto L60
                r9.setAlpha(r8)
            L60:
                return r5
            L61:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h.a.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        @Override // androidx.appcompat.widget.i0.e
        public PorterDuff.Mode b(int i2) {
            if (i2 == c.a.e.F) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.i0.e
        public Drawable c(i0 i0Var, Context context, int i2) {
            if (i2 == c.a.e.f2457j) {
                return new LayerDrawable(new Drawable[]{i0Var.j(context, c.a.e.f2456i), i0Var.j(context, c.a.e.f2458k)});
            }
            return null;
        }

        @Override // androidx.appcompat.widget.i0.e
        public ColorStateList d(Context context, int i2) {
            if (i2 == c.a.e.m) {
                return c.a.k.a.a.c(context, c.a.c.f2434e);
            }
            if (i2 == c.a.e.G) {
                return c.a.k.a.a.c(context, c.a.c.f2437h);
            }
            if (i2 == c.a.e.F) {
                return k(context);
            }
            if (i2 == c.a.e.f2453f) {
                return j(context);
            }
            if (i2 == c.a.e.f2449b) {
                return g(context);
            }
            if (i2 == c.a.e.f2452e) {
                return i(context);
            }
            if (i2 != c.a.e.D && i2 != c.a.e.E) {
                if (f(this.f806b, i2)) {
                    return n0.e(context, c.a.a.w);
                }
                if (f(this.f809e, i2)) {
                    return c.a.k.a.a.c(context, c.a.c.f2433d);
                }
                if (f(this.f810f, i2)) {
                    return c.a.k.a.a.c(context, c.a.c.f2432c);
                }
                if (i2 == c.a.e.A) {
                    return c.a.k.a.a.c(context, c.a.c.f2435f);
                }
                return null;
            }
            return c.a.k.a.a.c(context, c.a.c.f2436g);
        }

        @Override // androidx.appcompat.widget.i0.e
        public boolean e(Context context, int i2, Drawable drawable) {
            if (i2 == c.a.e.C) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int i3 = c.a.a.w;
                l(findDrawableByLayerId, n0.c(context, i3), h.a);
                l(layerDrawable.findDrawableByLayerId(16908303), n0.c(context, i3), h.a);
                l(layerDrawable.findDrawableByLayerId(16908301), n0.c(context, c.a.a.u), h.a);
                return true;
            } else if (i2 == c.a.e.y || i2 == c.a.e.x || i2 == c.a.e.z) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                l(layerDrawable2.findDrawableByLayerId(16908288), n0.b(context, c.a.a.w), h.a);
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                int i4 = c.a.a.u;
                l(findDrawableByLayerId2, n0.c(context, i4), h.a);
                l(layerDrawable2.findDrawableByLayerId(16908301), n0.c(context, i4), h.a);
                return true;
            } else {
                return false;
            }
        }
    }

    public static synchronized h b() {
        h hVar;
        synchronized (h.class) {
            if (f804b == null) {
                h();
            }
            hVar = f804b;
        }
        return hVar;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter l2;
        synchronized (h.class) {
            l2 = i0.l(i2, mode);
        }
        return l2;
    }

    public static synchronized void h() {
        synchronized (h.class) {
            if (f804b == null) {
                h hVar = new h();
                f804b = hVar;
                hVar.f805c = i0.h();
                f804b.f805c.u(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Drawable drawable, q0 q0Var, int[] iArr) {
        i0.w(drawable, q0Var, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f805c.j(context, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i2, boolean z) {
        return this.f805c.k(context, i2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i2) {
        return this.f805c.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f805c.s(context);
    }
}