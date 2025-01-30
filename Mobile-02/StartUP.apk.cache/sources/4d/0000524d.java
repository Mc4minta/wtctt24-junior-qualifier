package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics.java */
/* loaded from: classes3.dex */
public class m {
    private m() {
    }

    public static boolean a(Double d2, double d3) {
        return d2 != null && d2.doubleValue() == d3;
    }

    public static boolean b(Float f2, float f3) {
        return f2 != null && f2.floatValue() == f3;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) m(new IllegalStateException(str + " must not be null")));
    }

    public static void e(Object obj) {
        if (obj == null) {
            p();
        }
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m(new NullPointerException(str + " must not be null")));
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            r(str);
        }
    }

    public static int i(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    private static String j(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void k() {
        t();
    }

    public static void l(int i2, String str) {
        t();
    }

    private static <T extends Throwable> T m(T t) {
        return (T) n(t, m.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T n(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }

    public static String o(String str, Object obj) {
        return str + obj;
    }

    public static void p() {
        throw ((NullPointerException) m(new NullPointerException()));
    }

    public static void q() {
        throw ((KotlinNullPointerException) m(new KotlinNullPointerException()));
    }

    private static void r(String str) {
        throw ((IllegalArgumentException) m(new IllegalArgumentException(j(str))));
    }

    private static void s(String str) {
        throw ((NullPointerException) m(new NullPointerException(j(str))));
    }

    public static void t() {
        u("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void u(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void v(String str) {
        throw ((UninitializedPropertyAccessException) m(new UninitializedPropertyAccessException(str)));
    }

    public static void w(String str) {
        v("lateinit property " + str + " has not been initialized");
    }
}