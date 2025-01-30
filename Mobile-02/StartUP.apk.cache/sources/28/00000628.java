package c.s;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: CanvasUtils.java */
/* loaded from: classes.dex */
class c {
    private static Method a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f3225b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3226c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(Canvas canvas, boolean z) {
        Method method;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            return;
        }
        if (i2 >= 29) {
            if (z) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (i2 != 28) {
            if (!f3226c) {
                try {
                    Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    a = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                    f3225b = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f3226c = true;
            }
            if (z) {
                try {
                    Method method2 = a;
                    if (method2 != null) {
                        method2.invoke(canvas, new Object[0]);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
            if (z || (method = f3225b) == null) {
                return;
            }
            method.invoke(canvas, new Object[0]);
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}