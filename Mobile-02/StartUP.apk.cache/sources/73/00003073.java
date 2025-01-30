package com.facebook.systrace;

import android.os.Build;
import android.os.Trace;

/* compiled from: Systrace.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: Systrace.java */
    /* renamed from: com.facebook.systrace.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0129a {
        THREAD('t'),
        PROCESS('p'),
        GLOBAL('g');
        

        /* renamed from: e  reason: collision with root package name */
        private final char f5651e;

        EnumC0129a(char c2) {
            this.f5651e = c2;
        }
    }

    public static void a(long j2, String str, int i2) {
    }

    public static void b(long j2, String str, int i2, long j3) {
    }

    public static void c(long j2, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void d(long j2, String str, int i2) {
    }

    public static void e(long j2, String str, int i2) {
    }

    public static void f(long j2, String str, int i2, long j3) {
    }

    public static void g(long j2) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static boolean h(long j2) {
        return false;
    }

    public static void i(TraceListener traceListener) {
    }

    public static void j(long j2, String str, int i2) {
    }

    public static void k(long j2, String str, int i2) {
    }

    public static void l(long j2, String str, EnumC0129a enumC0129a) {
    }

    public static void m(TraceListener traceListener) {
    }
}