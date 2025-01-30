package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.m;

/* compiled from: exceptionUtils.kt */
/* loaded from: classes3.dex */
public final class ExceptionUtilsKt {
    public static final boolean isProcessCanceledException(Throwable th) {
        m.g(th, "<this>");
        Class<?> cls = th.getClass();
        while (!m.c(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException rethrow(Throwable e2) {
        m.g(e2, "e");
        throw e2;
    }
}