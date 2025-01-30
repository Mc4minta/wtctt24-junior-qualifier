package c.s;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtils.java */
/* loaded from: classes.dex */
class k0 {
    private static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Method f3323b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3324c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ViewGroup viewGroup, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i2);
        }
        if (!f3324c) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                f3323b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f3324c = true;
        }
        Method method = f3323b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i2))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j0 b(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new i0(viewGroup);
        }
        return h0.g(viewGroup);
    }

    @SuppressLint({"NewApi"})
    private static void c(ViewGroup viewGroup, boolean z) {
        if (a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(ViewGroup viewGroup, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            viewGroup.suppressLayout(z);
        } else if (i2 >= 18) {
            c(viewGroup, z);
        } else {
            l0.b(viewGroup, z);
        }
    }
}