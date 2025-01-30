package c.h.k;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class d0 {
    public static final d0 a;

    /* renamed from: b  reason: collision with root package name */
    private final l f3002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        private static Field a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f3003b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f3004c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f3005d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f3003b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f3004c = declaredField3;
                declaredField3.setAccessible(true);
                f3005d = true;
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        public static d0 a(View view) {
            if (f3005d && view.isAttachedToWindow()) {
                try {
                    Object obj = a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f3003b.get(obj);
                        Rect rect2 = (Rect) f3004c.get(obj);
                        if (rect != null && rect2 != null) {
                            d0 a2 = new b().b(c.h.e.b.c(rect)).c(c.h.e.b.c(rect2)).a();
                            a2.s(a2);
                            a2.d(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        e(d0 d0Var) {
            super(d0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class f {
        private final d0 a;

        /* renamed from: b  reason: collision with root package name */
        c.h.e.b[] f3013b;

        f() {
            this(new d0((d0) null));
        }

        protected final void a() {
            c.h.e.b[] bVarArr = this.f3013b;
            if (bVarArr != null) {
                c.h.e.b bVar = bVarArr[m.a(1)];
                c.h.e.b bVar2 = this.f3013b[m.a(2)];
                if (bVar != null && bVar2 != null) {
                    f(c.h.e.b.a(bVar, bVar2));
                } else if (bVar != null) {
                    f(bVar);
                } else if (bVar2 != null) {
                    f(bVar2);
                }
                c.h.e.b bVar3 = this.f3013b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                c.h.e.b bVar4 = this.f3013b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                c.h.e.b bVar5 = this.f3013b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        d0 b() {
            a();
            return this.a;
        }

        void c(c.h.e.b bVar) {
        }

        void d(c.h.e.b bVar) {
        }

        void e(c.h.e.b bVar) {
        }

        void f(c.h.e.b bVar) {
        }

        void g(c.h.e.b bVar) {
        }

        f(d0 d0Var) {
            this.a = d0Var;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class i extends h {
        i(d0 d0Var, WindowInsets windowInsets) {
            super(d0Var, windowInsets);
        }

        @Override // c.h.k.d0.l
        d0 a() {
            return d0.v(this.f3020i.consumeDisplayCutout());
        }

        @Override // c.h.k.d0.g, c.h.k.d0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                return Objects.equals(this.f3020i, iVar.f3020i) && Objects.equals(this.m, iVar.m);
            }
            return false;
        }

        @Override // c.h.k.d0.l
        c.h.k.c f() {
            return c.h.k.c.e(this.f3020i.getDisplayCutout());
        }

        @Override // c.h.k.d0.l
        public int hashCode() {
            return this.f3020i.hashCode();
        }

        i(d0 d0Var, i iVar) {
            super(d0Var, iVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class k extends j {
        static final d0 r = d0.v(WindowInsets.CONSUMED);

        k(d0 d0Var, WindowInsets windowInsets) {
            super(d0Var, windowInsets);
        }

        @Override // c.h.k.d0.g, c.h.k.d0.l
        final void d(View view) {
        }

        @Override // c.h.k.d0.g, c.h.k.d0.l
        public c.h.e.b g(int i2) {
            return c.h.e.b.d(this.f3020i.getInsetsIgnoringVisibility(n.a(i2)));
        }

        k(d0 d0Var, k kVar) {
            super(d0Var, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class l {
        static final d0 a = new b().a().a().b().c();

        /* renamed from: b  reason: collision with root package name */
        final d0 f3024b;

        l(d0 d0Var) {
            this.f3024b = d0Var;
        }

        d0 a() {
            return this.f3024b;
        }

        d0 b() {
            return this.f3024b;
        }

        d0 c() {
            return this.f3024b;
        }

        void d(View view) {
        }

        void e(d0 d0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof l) {
                l lVar = (l) obj;
                return o() == lVar.o() && n() == lVar.n() && androidx.core.util.d.a(k(), lVar.k()) && androidx.core.util.d.a(i(), lVar.i()) && androidx.core.util.d.a(f(), lVar.f());
            }
            return false;
        }

        c.h.k.c f() {
            return null;
        }

        c.h.e.b g(int i2) {
            if ((i2 & 8) == 0) {
                return c.h.e.b.a;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        c.h.e.b h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.d.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        c.h.e.b i() {
            return c.h.e.b.a;
        }

        c.h.e.b j() {
            return k();
        }

        c.h.e.b k() {
            return c.h.e.b.a;
        }

        c.h.e.b l() {
            return k();
        }

        d0 m(int i2, int i3, int i4, int i5) {
            return a;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(c.h.e.b[] bVarArr) {
        }

        void q(c.h.e.b bVar) {
        }

        void r(d0 d0Var) {
        }

        public void s(c.h.e.b bVar) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        if (i2 != 8) {
                            if (i2 != 16) {
                                if (i2 != 32) {
                                    if (i2 != 64) {
                                        if (i2 != 128) {
                                            if (i2 == 256) {
                                                return 8;
                                            }
                                            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }

        public static int b() {
            return 2;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i2) {
            int statusBars;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i2 & i4) != 0) {
                    if (i4 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i3 |= statusBars;
                }
            }
            return i3;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            a = k.r;
        } else {
            a = l.a;
        }
    }

    private d0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f3002b = new k(this, windowInsets);
        } else if (i2 >= 29) {
            this.f3002b = new j(this, windowInsets);
        } else if (i2 >= 28) {
            this.f3002b = new i(this, windowInsets);
        } else if (i2 >= 21) {
            this.f3002b = new h(this, windowInsets);
        } else if (i2 >= 20) {
            this.f3002b = new g(this, windowInsets);
        } else {
            this.f3002b = new l(this);
        }
    }

    static c.h.e.b n(c.h.e.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f2925b - i2);
        int max2 = Math.max(0, bVar.f2926c - i3);
        int max3 = Math.max(0, bVar.f2927d - i4);
        int max4 = Math.max(0, bVar.f2928e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : c.h.e.b.b(max, max2, max3, max4);
    }

    public static d0 v(WindowInsets windowInsets) {
        return w(windowInsets, null);
    }

    public static d0 w(WindowInsets windowInsets, View view) {
        d0 d0Var = new d0((WindowInsets) androidx.core.util.h.b(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            d0Var.s(v.F(view));
            d0Var.d(view.getRootView());
        }
        return d0Var;
    }

    @Deprecated
    public d0 a() {
        return this.f3002b.a();
    }

    @Deprecated
    public d0 b() {
        return this.f3002b.b();
    }

    @Deprecated
    public d0 c() {
        return this.f3002b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f3002b.d(view);
    }

    public c.h.k.c e() {
        return this.f3002b.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            return androidx.core.util.d.a(this.f3002b, ((d0) obj).f3002b);
        }
        return false;
    }

    public c.h.e.b f(int i2) {
        return this.f3002b.g(i2);
    }

    @Deprecated
    public c.h.e.b g() {
        return this.f3002b.i();
    }

    @Deprecated
    public c.h.e.b h() {
        return this.f3002b.j();
    }

    public int hashCode() {
        l lVar = this.f3002b;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f3002b.k().f2928e;
    }

    @Deprecated
    public int j() {
        return this.f3002b.k().f2925b;
    }

    @Deprecated
    public int k() {
        return this.f3002b.k().f2927d;
    }

    @Deprecated
    public int l() {
        return this.f3002b.k().f2926c;
    }

    public d0 m(int i2, int i3, int i4, int i5) {
        return this.f3002b.m(i2, i3, i4, i5);
    }

    public boolean o() {
        return this.f3002b.n();
    }

    @Deprecated
    public d0 p(int i2, int i3, int i4, int i5) {
        return new b(this).c(c.h.e.b.b(i2, i3, i4, i5)).a();
    }

    void q(c.h.e.b[] bVarArr) {
        this.f3002b.p(bVarArr);
    }

    void r(c.h.e.b bVar) {
        this.f3002b.q(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(d0 d0Var) {
        this.f3002b.r(d0Var);
    }

    void t(c.h.e.b bVar) {
        this.f3002b.s(bVar);
    }

    public WindowInsets u() {
        l lVar = this.f3002b;
        if (lVar instanceof g) {
            return ((g) lVar).f3020i;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class c extends f {

        /* renamed from: c  reason: collision with root package name */
        private static Field f3006c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f3007d;

        /* renamed from: e  reason: collision with root package name */
        private static Constructor<WindowInsets> f3008e;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f3009f;

        /* renamed from: g  reason: collision with root package name */
        private WindowInsets f3010g;

        /* renamed from: h  reason: collision with root package name */
        private c.h.e.b f3011h;

        c() {
            this.f3010g = h();
        }

        private static WindowInsets h() {
            if (!f3007d) {
                try {
                    f3006c = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f3007d = true;
            }
            Field field = f3006c;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f3009f) {
                try {
                    f3008e = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f3009f = true;
            }
            Constructor<WindowInsets> constructor = f3008e;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // c.h.k.d0.f
        d0 b() {
            a();
            d0 v = d0.v(this.f3010g);
            v.q(this.f3013b);
            v.t(this.f3011h);
            return v;
        }

        @Override // c.h.k.d0.f
        void d(c.h.e.b bVar) {
            this.f3011h = bVar;
        }

        @Override // c.h.k.d0.f
        void f(c.h.e.b bVar) {
            WindowInsets windowInsets = this.f3010g;
            if (windowInsets != null) {
                this.f3010g = windowInsets.replaceSystemWindowInsets(bVar.f2925b, bVar.f2926c, bVar.f2927d, bVar.f2928e);
            }
        }

        c(d0 d0Var) {
            this.f3010g = d0Var.u();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f3012c;

        d() {
            this.f3012c = new WindowInsets.Builder();
        }

        @Override // c.h.k.d0.f
        d0 b() {
            a();
            d0 v = d0.v(this.f3012c.build());
            v.q(this.f3013b);
            return v;
        }

        @Override // c.h.k.d0.f
        void c(c.h.e.b bVar) {
            this.f3012c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // c.h.k.d0.f
        void d(c.h.e.b bVar) {
            this.f3012c.setStableInsets(bVar.e());
        }

        @Override // c.h.k.d0.f
        void e(c.h.e.b bVar) {
            this.f3012c.setSystemGestureInsets(bVar.e());
        }

        @Override // c.h.k.d0.f
        void f(c.h.e.b bVar) {
            this.f3012c.setSystemWindowInsets(bVar.e());
        }

        @Override // c.h.k.d0.f
        void g(c.h.e.b bVar) {
            this.f3012c.setTappableElementInsets(bVar.e());
        }

        d(d0 d0Var) {
            WindowInsets.Builder builder;
            WindowInsets u = d0Var.u();
            if (u != null) {
                builder = new WindowInsets.Builder(u);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f3012c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class h extends g {
        private c.h.e.b n;

        h(d0 d0Var, WindowInsets windowInsets) {
            super(d0Var, windowInsets);
            this.n = null;
        }

        @Override // c.h.k.d0.l
        d0 b() {
            return d0.v(this.f3020i.consumeStableInsets());
        }

        @Override // c.h.k.d0.l
        d0 c() {
            return d0.v(this.f3020i.consumeSystemWindowInsets());
        }

        @Override // c.h.k.d0.l
        final c.h.e.b i() {
            if (this.n == null) {
                this.n = c.h.e.b.b(this.f3020i.getStableInsetLeft(), this.f3020i.getStableInsetTop(), this.f3020i.getStableInsetRight(), this.f3020i.getStableInsetBottom());
            }
            return this.n;
        }

        @Override // c.h.k.d0.l
        boolean n() {
            return this.f3020i.isConsumed();
        }

        @Override // c.h.k.d0.l
        public void s(c.h.e.b bVar) {
            this.n = bVar;
        }

        h(d0 d0Var, h hVar) {
            super(d0Var, hVar);
            this.n = null;
            this.n = hVar.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class g extends l {

        /* renamed from: c  reason: collision with root package name */
        private static boolean f3014c;

        /* renamed from: d  reason: collision with root package name */
        private static Method f3015d;

        /* renamed from: e  reason: collision with root package name */
        private static Class<?> f3016e;

        /* renamed from: f  reason: collision with root package name */
        private static Class<?> f3017f;

        /* renamed from: g  reason: collision with root package name */
        private static Field f3018g;

        /* renamed from: h  reason: collision with root package name */
        private static Field f3019h;

        /* renamed from: i  reason: collision with root package name */
        final WindowInsets f3020i;

        /* renamed from: j  reason: collision with root package name */
        private c.h.e.b[] f3021j;

        /* renamed from: k  reason: collision with root package name */
        private c.h.e.b f3022k;

        /* renamed from: l  reason: collision with root package name */
        private d0 f3023l;
        c.h.e.b m;

        g(d0 d0Var, WindowInsets windowInsets) {
            super(d0Var);
            this.f3022k = null;
            this.f3020i = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private c.h.e.b t(int i2, boolean z) {
            c.h.e.b bVar = c.h.e.b.a;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    bVar = c.h.e.b.a(bVar, u(i3, z));
                }
            }
            return bVar;
        }

        private c.h.e.b v() {
            d0 d0Var = this.f3023l;
            if (d0Var != null) {
                return d0Var.g();
            }
            return c.h.e.b.a;
        }

        private c.h.e.b w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f3014c) {
                    x();
                }
                Method method = f3015d;
                if (method != null && f3017f != null && f3018g != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f3018g.get(f3019h.get(invoke));
                        if (rect != null) {
                            return c.h.e.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f3015d = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f3016e = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f3017f = cls;
                f3018g = cls.getDeclaredField("mVisibleInsets");
                f3019h = f3016e.getDeclaredField("mAttachInfo");
                f3018g.setAccessible(true);
                f3019h.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f3014c = true;
        }

        @Override // c.h.k.d0.l
        void d(View view) {
            c.h.e.b w = w(view);
            if (w == null) {
                w = c.h.e.b.a;
            }
            q(w);
        }

        @Override // c.h.k.d0.l
        void e(d0 d0Var) {
            d0Var.s(this.f3023l);
            d0Var.r(this.m);
        }

        @Override // c.h.k.d0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.m, ((g) obj).m);
            }
            return false;
        }

        @Override // c.h.k.d0.l
        public c.h.e.b g(int i2) {
            return t(i2, true);
        }

        @Override // c.h.k.d0.l
        final c.h.e.b k() {
            if (this.f3022k == null) {
                this.f3022k = c.h.e.b.b(this.f3020i.getSystemWindowInsetLeft(), this.f3020i.getSystemWindowInsetTop(), this.f3020i.getSystemWindowInsetRight(), this.f3020i.getSystemWindowInsetBottom());
            }
            return this.f3022k;
        }

        @Override // c.h.k.d0.l
        d0 m(int i2, int i3, int i4, int i5) {
            b bVar = new b(d0.v(this.f3020i));
            bVar.c(d0.n(k(), i2, i3, i4, i5));
            bVar.b(d0.n(i(), i2, i3, i4, i5));
            return bVar.a();
        }

        @Override // c.h.k.d0.l
        boolean o() {
            return this.f3020i.isRound();
        }

        @Override // c.h.k.d0.l
        public void p(c.h.e.b[] bVarArr) {
            this.f3021j = bVarArr;
        }

        @Override // c.h.k.d0.l
        void q(c.h.e.b bVar) {
            this.m = bVar;
        }

        @Override // c.h.k.d0.l
        void r(d0 d0Var) {
            this.f3023l = d0Var;
        }

        protected c.h.e.b u(int i2, boolean z) {
            c.h.e.b g2;
            int i3;
            c.h.k.c f2;
            if (i2 == 1) {
                if (z) {
                    return c.h.e.b.b(0, Math.max(v().f2926c, k().f2926c), 0, 0);
                }
                return c.h.e.b.b(0, k().f2926c, 0, 0);
            }
            if (i2 == 2) {
                if (z) {
                    c.h.e.b v = v();
                    c.h.e.b i4 = i();
                    return c.h.e.b.b(Math.max(v.f2925b, i4.f2925b), 0, Math.max(v.f2927d, i4.f2927d), Math.max(v.f2928e, i4.f2928e));
                }
                c.h.e.b k2 = k();
                d0 d0Var = this.f3023l;
                g2 = d0Var != null ? d0Var.g() : null;
                int i5 = k2.f2928e;
                if (g2 != null) {
                    i5 = Math.min(i5, g2.f2928e);
                }
                return c.h.e.b.b(k2.f2925b, 0, k2.f2927d, i5);
            } else if (i2 != 8) {
                if (i2 != 16) {
                    if (i2 != 32) {
                        if (i2 != 64) {
                            if (i2 != 128) {
                                return c.h.e.b.a;
                            }
                            d0 d0Var2 = this.f3023l;
                            if (d0Var2 != null) {
                                f2 = d0Var2.e();
                            } else {
                                f2 = f();
                            }
                            if (f2 != null) {
                                return c.h.e.b.b(f2.b(), f2.d(), f2.c(), f2.a());
                            }
                            return c.h.e.b.a;
                        }
                        return l();
                    }
                    return h();
                }
                return j();
            } else {
                c.h.e.b[] bVarArr = this.f3021j;
                g2 = bVarArr != null ? bVarArr[m.a(8)] : null;
                if (g2 != null) {
                    return g2;
                }
                c.h.e.b k3 = k();
                c.h.e.b v2 = v();
                int i6 = k3.f2928e;
                if (i6 > v2.f2928e) {
                    return c.h.e.b.b(0, 0, 0, i6);
                }
                c.h.e.b bVar = this.m;
                if (bVar != null && !bVar.equals(c.h.e.b.a) && (i3 = this.m.f2928e) > v2.f2928e) {
                    return c.h.e.b.b(0, 0, 0, i3);
                }
                return c.h.e.b.a;
            }
        }

        g(d0 d0Var, g gVar) {
            this(d0Var, new WindowInsets(gVar.f3020i));
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class j extends i {
        private c.h.e.b o;
        private c.h.e.b p;
        private c.h.e.b q;

        j(d0 d0Var, WindowInsets windowInsets) {
            super(d0Var, windowInsets);
            this.o = null;
            this.p = null;
            this.q = null;
        }

        @Override // c.h.k.d0.l
        c.h.e.b h() {
            if (this.p == null) {
                this.p = c.h.e.b.d(this.f3020i.getMandatorySystemGestureInsets());
            }
            return this.p;
        }

        @Override // c.h.k.d0.l
        c.h.e.b j() {
            if (this.o == null) {
                this.o = c.h.e.b.d(this.f3020i.getSystemGestureInsets());
            }
            return this.o;
        }

        @Override // c.h.k.d0.l
        c.h.e.b l() {
            if (this.q == null) {
                this.q = c.h.e.b.d(this.f3020i.getTappableElementInsets());
            }
            return this.q;
        }

        @Override // c.h.k.d0.g, c.h.k.d0.l
        d0 m(int i2, int i3, int i4, int i5) {
            return d0.v(this.f3020i.inset(i2, i3, i4, i5));
        }

        @Override // c.h.k.d0.h, c.h.k.d0.l
        public void s(c.h.e.b bVar) {
        }

        j(d0 d0Var, j jVar) {
            super(d0Var, jVar);
            this.o = null;
            this.p = null;
            this.q = null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final f a;

        public b() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.a = new e();
            } else if (i2 >= 29) {
                this.a = new d();
            } else if (i2 >= 20) {
                this.a = new c();
            } else {
                this.a = new f();
            }
        }

        public d0 a() {
            return this.a.b();
        }

        @Deprecated
        public b b(c.h.e.b bVar) {
            this.a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(c.h.e.b bVar) {
            this.a.f(bVar);
            return this;
        }

        public b(d0 d0Var) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                this.a = new e(d0Var);
            } else if (i2 >= 29) {
                this.a = new d(d0Var);
            } else if (i2 >= 20) {
                this.a = new c(d0Var);
            } else {
                this.a = new f(d0Var);
            }
        }
    }

    public d0(d0 d0Var) {
        if (d0Var != null) {
            l lVar = d0Var.f3002b;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30 && (lVar instanceof k)) {
                this.f3002b = new k(this, (k) lVar);
            } else if (i2 >= 29 && (lVar instanceof j)) {
                this.f3002b = new j(this, (j) lVar);
            } else if (i2 >= 28 && (lVar instanceof i)) {
                this.f3002b = new i(this, (i) lVar);
            } else if (i2 >= 21 && (lVar instanceof h)) {
                this.f3002b = new h(this, (h) lVar);
            } else if (i2 >= 20 && (lVar instanceof g)) {
                this.f3002b = new g(this, (g) lVar);
            } else {
                this.f3002b = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f3002b = new l(this);
    }
}