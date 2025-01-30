package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes3.dex */
public class i0 {
    public static Collection a(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.n0.a) && !(obj instanceof kotlin.jvm.internal.n0.b)) {
            r(obj, "kotlin.collections.MutableCollection");
        }
        return g(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.n0.a) && !(obj instanceof kotlin.jvm.internal.n0.c)) {
            r(obj, "kotlin.collections.MutableIterable");
        }
        return h(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.n0.a) && !(obj instanceof kotlin.jvm.internal.n0.d)) {
            r(obj, "kotlin.collections.MutableList");
        }
        return i(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.n0.a) && !(obj instanceof kotlin.jvm.internal.n0.e)) {
            r(obj, "kotlin.collections.MutableMap");
        }
        return j(obj);
    }

    public static Set e(Object obj) {
        if ((obj instanceof kotlin.jvm.internal.n0.a) && !(obj instanceof kotlin.jvm.internal.n0.f)) {
            r(obj, "kotlin.collections.MutableSet");
        }
        return k(obj);
    }

    public static Object f(Object obj, int i2) {
        if (obj != null && !m(obj, i2)) {
            r(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static Collection g(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            throw q(e2);
        }
    }

    public static Iterable h(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e2) {
            throw q(e2);
        }
    }

    public static List i(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw q(e2);
        }
    }

    public static Map j(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e2) {
            throw q(e2);
        }
    }

    public static Set k(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e2) {
            throw q(e2);
        }
    }

    public static int l(Object obj) {
        if (obj instanceof i) {
            return ((i) obj).getArity();
        }
        if (obj instanceof kotlin.e0.c.a) {
            return 0;
        }
        if (obj instanceof kotlin.e0.c.l) {
            return 1;
        }
        if (obj instanceof kotlin.e0.c.p) {
            return 2;
        }
        if (obj instanceof kotlin.e0.c.q) {
            return 3;
        }
        if (obj instanceof kotlin.e0.c.r) {
            return 4;
        }
        if (obj instanceof kotlin.e0.c.s) {
            return 5;
        }
        if (obj instanceof kotlin.e0.c.t) {
            return 6;
        }
        if (obj instanceof kotlin.e0.c.u) {
            return 7;
        }
        if (obj instanceof kotlin.e0.c.v) {
            return 8;
        }
        if (obj instanceof kotlin.e0.c.w) {
            return 9;
        }
        if (obj instanceof kotlin.e0.c.b) {
            return 10;
        }
        if (obj instanceof kotlin.e0.c.c) {
            return 11;
        }
        if (obj instanceof kotlin.e0.c.d) {
            return 12;
        }
        if (obj instanceof kotlin.e0.c.e) {
            return 13;
        }
        if (obj instanceof kotlin.e0.c.f) {
            return 14;
        }
        if (obj instanceof kotlin.e0.c.g) {
            return 15;
        }
        if (obj instanceof kotlin.e0.c.h) {
            return 16;
        }
        if (obj instanceof kotlin.e0.c.i) {
            return 17;
        }
        if (obj instanceof kotlin.e0.c.j) {
            return 18;
        }
        if (obj instanceof kotlin.e0.c.k) {
            return 19;
        }
        if (obj instanceof kotlin.e0.c.m) {
            return 20;
        }
        if (obj instanceof kotlin.e0.c.n) {
            return 21;
        }
        return obj instanceof kotlin.e0.c.o ? 22 : -1;
    }

    public static boolean m(Object obj, int i2) {
        return (obj instanceof kotlin.d) && l(obj) == i2;
    }

    public static boolean n(Object obj) {
        return (obj instanceof List) && (!(obj instanceof kotlin.jvm.internal.n0.a) || (obj instanceof kotlin.jvm.internal.n0.d));
    }

    public static boolean o(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof kotlin.jvm.internal.n0.a) || (obj instanceof kotlin.jvm.internal.n0.e));
    }

    private static <T extends Throwable> T p(T t) {
        return (T) m.n(t, i0.class.getName());
    }

    public static ClassCastException q(ClassCastException classCastException) {
        throw ((ClassCastException) p(classCastException));
    }

    public static void r(Object obj, String str) {
        String name = obj == null ? "null" : obj.getClass().getName();
        s(name + " cannot be cast to " + str);
    }

    public static void s(String str) {
        throw q(new ClassCastException(str));
    }
}