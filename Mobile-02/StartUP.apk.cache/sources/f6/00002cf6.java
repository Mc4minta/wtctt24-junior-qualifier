package com.facebook.jni;

import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.soloader.o.a;

@DoNotStrip
/* loaded from: classes2.dex */
public class ThreadScopeSupport {
    static {
        a.c("fbjni");
    }

    @DoNotStrip
    private static void runStdFunction(long j2) {
        runStdFunctionImpl(j2);
    }

    private static native void runStdFunctionImpl(long j2);
}