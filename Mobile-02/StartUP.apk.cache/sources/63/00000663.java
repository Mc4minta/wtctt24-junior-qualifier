package c.s;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class p0 {
    private static final v0 a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f3339b;

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Rect> f3340c;

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(p0.c(view));
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Float f2) {
            p0.h(view, f2.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Rect get(View view) {
            return c.h.k.v.r(view);
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(View view, Rect rect) {
            c.h.k.v.p0(view, rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            a = new u0();
        } else if (i2 >= 23) {
            a = new t0();
        } else if (i2 >= 22) {
            a = new s0();
        } else if (i2 >= 21) {
            a = new r0();
        } else if (i2 >= 19) {
            a = new q0();
        } else {
            a = new v0();
        }
        f3339b = new a(Float.class, "translationAlpha");
        f3340c = new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new n0(view);
        }
        return m0.e(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a1 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new z0(view);
        }
        return new y0(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        a.d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view, Matrix matrix) {
        a.e(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, int i2, int i3, int i4, int i5) {
        a.f(view, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, float f2) {
        a.g(view, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(View view, int i2) {
        a.h(view, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(View view, Matrix matrix) {
        a.i(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(View view, Matrix matrix) {
        a.j(view, matrix);
    }
}