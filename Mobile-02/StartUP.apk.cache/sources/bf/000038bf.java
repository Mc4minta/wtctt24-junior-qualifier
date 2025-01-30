package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Method;

/* compiled from: Throwables.java */
/* loaded from: classes2.dex */
public final class q {
    private static final Object a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f8455b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f8456c;

    static {
        Object b2 = b();
        a = b2;
        f8455b = b2 == null ? null : a();
        f8456c = b2 != null ? d() : null;
    }

    private static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d() {
        return c("getStackTraceDepth", Throwable.class);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public static RuntimeException e(Throwable th) {
        f(th);
        throw new RuntimeException(th);
    }

    public static void f(Throwable th) {
        l.i(th);
        if (!(th instanceof RuntimeException)) {
            if (th instanceof Error) {
                throw ((Error) th);
            }
            return;
        }
        throw ((RuntimeException) th);
    }
}