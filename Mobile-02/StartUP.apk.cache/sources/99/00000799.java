package com.bugsnag.android;

import android.os.StrictMode;
import java.lang.Thread;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExceptionHandler.java */
/* loaded from: classes.dex */
public class g0 implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler a;

    /* renamed from: b  reason: collision with root package name */
    private final b1 f3651b = new b1();

    /* renamed from: c  reason: collision with root package name */
    final Map<q, Boolean> f3652c = new WeakHashMap();

    g0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(q qVar) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof g0) {
            g0 g0Var = (g0) defaultUncaughtExceptionHandler;
            g0Var.f3652c.remove(qVar);
            if (g0Var.f3652c.isEmpty()) {
                Thread.setDefaultUncaughtExceptionHandler(g0Var.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(q qVar) {
        g0 g0Var;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof g0) {
            g0Var = (g0) defaultUncaughtExceptionHandler;
        } else {
            g0 g0Var2 = new g0(defaultUncaughtExceptionHandler);
            Thread.setDefaultUncaughtExceptionHandler(g0Var2);
            g0Var = g0Var2;
        }
        g0Var.f3652c.put(qVar, Boolean.TRUE);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        s0 s0Var;
        String str;
        boolean c2 = this.f3651b.c(th);
        for (q qVar : this.f3652c.keySet()) {
            s0 s0Var2 = new s0();
            if (c2) {
                String b2 = this.f3651b.b(th.getMessage());
                s0 s0Var3 = new s0();
                s0Var3.a("StrictMode", "Violation", b2);
                str = b2;
                s0Var = s0Var3;
            } else {
                s0Var = s0Var2;
                str = null;
            }
            String str2 = c2 ? "strictMode" : "unhandledException";
            if (c2) {
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
                qVar.c(th, Severity.ERROR, s0Var, str2, str, thread);
                StrictMode.setThreadPolicy(threadPolicy);
            } else {
                qVar.c(th, Severity.ERROR, s0Var, str2, str, thread);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        System.err.printf("Exception in thread \"%s\" ", thread.getName());
        q0.e("Exception", th);
    }
}