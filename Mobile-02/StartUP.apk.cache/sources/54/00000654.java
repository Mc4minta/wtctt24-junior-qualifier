package c.s;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: GhostViewPlatform.java */
/* loaded from: classes.dex */
class k implements i {
    private static Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3317b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f3318c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f3319d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f3320e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f3321f;

    /* renamed from: g  reason: collision with root package name */
    private final View f3322g;

    private k(View view) {
        this.f3322g = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f3318c;
        if (method != null) {
            try {
                return new k((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void c() {
        if (f3319d) {
            return;
        }
        try {
            d();
            Method declaredMethod = a.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f3318c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        f3319d = true;
    }

    private static void d() {
        if (f3317b) {
            return;
        }
        try {
            a = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        f3317b = true;
    }

    private static void e() {
        if (f3321f) {
            return;
        }
        try {
            d();
            Method declaredMethod = a.getDeclaredMethod("removeGhost", View.class);
            f3320e = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        f3321f = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view) {
        e();
        Method method = f3320e;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // c.s.i
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // c.s.i
    public void setVisibility(int i2) {
        this.f3322g.setVisibility(i2);
    }
}