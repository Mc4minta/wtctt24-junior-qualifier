package com.google.firebase.crashlytics.c.m;

import android.app.ActivityManager;
import com.coinbase.wallet.core.extensions.Strings;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class d {
    private static final a a = a.c(Strings.zero);

    /* renamed from: b  reason: collision with root package name */
    private static final a f8999b = a.c("Unity");

    private static void A(c cVar, a aVar) throws Exception {
        if (aVar != null) {
            cVar.Y(6, 2);
            cVar.T(h(aVar));
            cVar.B(1, aVar);
        }
    }

    public static void B(c cVar, String str, String str2, boolean z) throws Exception {
        a c2 = a.c(str);
        a c3 = a.c(str2);
        cVar.Y(8, 2);
        cVar.T(m(c2, c3, z));
        cVar.E(1, 3);
        cVar.B(2, c2);
        cVar.B(3, c3);
        cVar.z(4, z);
    }

    public static void C(c cVar, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        a c2 = a.c(str);
        a o = o(str2);
        a o2 = o(str3);
        int c3 = c.c(1, c2) + 0;
        if (str2 != null) {
            c3 += c.c(2, o);
        }
        if (str3 != null) {
            c3 += c.c(3, o2);
        }
        cVar.Y(6, 2);
        cVar.T(c3);
        cVar.B(1, c2);
        if (str2 != null) {
            cVar.B(2, o);
        }
        if (str3 != null) {
            cVar.B(3, o2);
        }
    }

    private static void D(c cVar, Thread thread, StackTraceElement[] stackTraceElementArr, int i2, boolean z) throws Exception {
        cVar.Y(1, 2);
        cVar.T(n(thread, stackTraceElementArr, i2, z));
        cVar.B(1, a.c(thread.getName()));
        cVar.Z(2, i2);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            q(cVar, 3, stackTraceElement, z);
        }
    }

    private static int a(a aVar, a aVar2) {
        int r = c.r(1, 0L) + 0 + c.r(2, 0L) + c.c(3, aVar);
        return aVar2 != null ? r + c.c(4, aVar2) : r;
    }

    private static int b(String str, String str2) {
        int c2 = c.c(1, a.c(str));
        if (str2 == null) {
            str2 = "";
        }
        return c2 + c.c(2, a.c(str2));
    }

    private static int c(com.google.firebase.crashlytics.c.q.e eVar, int i2, int i3) {
        int i4 = 0;
        int c2 = c.c(1, a.c(eVar.f9074b)) + 0;
        String str = eVar.a;
        if (str != null) {
            c2 += c.c(3, a.c(str));
        }
        for (StackTraceElement stackTraceElement : eVar.f9075c) {
            int i5 = i(stackTraceElement, true);
            c2 += c.o(4) + c.k(i5) + i5;
        }
        com.google.firebase.crashlytics.c.q.e eVar2 = eVar.f9076d;
        if (eVar2 != null) {
            if (i2 < i3) {
                int c3 = c(eVar2, i2 + 1, i3);
                return c2 + c.o(6) + c.k(c3) + c3;
            }
            while (eVar2 != null) {
                eVar2 = eVar2.f9076d;
                i4++;
            }
            return c2 + c.p(7, i4);
        }
        return c2;
    }

    private static int d() {
        a aVar = a;
        return c.c(1, aVar) + 0 + c.c(2, aVar) + c.r(3, 0L);
    }

    private static int e(com.google.firebase.crashlytics.c.q.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, a aVar, a aVar2) {
        int n = n(thread, stackTraceElementArr, 4, true);
        int o = c.o(1) + c.k(n) + n + 0;
        int length = threadArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int n2 = n(threadArr[i3], list.get(i3), 0, false);
            o += c.o(1) + c.k(n2) + n2;
        }
        int c2 = c(eVar, 1, i2);
        int d2 = d();
        int a2 = a(aVar, aVar2);
        return o + c.o(2) + c.k(c2) + c2 + c.o(3) + c.k(d2) + d2 + c.o(3) + c.k(a2) + a2;
    }

    private static int f(com.google.firebase.crashlytics.c.q.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, a aVar, a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3) {
        int e2 = e(eVar, thread, stackTraceElementArr, threadArr, list, i2, aVar, aVar2);
        int o = c.o(1) + c.k(e2) + e2 + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int b2 = b(entry.getKey(), entry.getValue());
                o += c.o(2) + c.k(b2) + b2;
            }
        }
        if (runningAppProcessInfo != null) {
            o += c.a(3, runningAppProcessInfo.importance != 100);
        }
        return o + c.p(4, i3);
    }

    private static int g(Float f2, int i2, boolean z, int i3, long j2, long j3) {
        return (f2 != null ? 0 + c.g(1, f2.floatValue()) : 0) + c.m(2, i2) + c.a(3, z) + c.p(4, i3) + c.r(5, j2) + c.r(6, j3);
    }

    private static int h(a aVar) {
        return c.c(1, aVar);
    }

    private static int i(StackTraceElement stackTraceElement, boolean z) {
        int r;
        if (stackTraceElement.isNativeMethod()) {
            r = c.r(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            r = c.r(1, 0L);
        }
        int c2 = r + 0 + c.c(2, a.c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            c2 += c.c(3, a.c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            c2 += c.r(4, stackTraceElement.getLineNumber());
        }
        return c2 + c.p(5, z ? 2 : 0);
    }

    private static int j(a aVar, a aVar2, a aVar3, a aVar4, int i2, a aVar5) {
        int c2 = c.c(1, aVar) + 0 + c.c(2, aVar2) + c.c(3, aVar3) + c.c(6, aVar4);
        if (aVar5 != null) {
            c2 = c2 + c.c(8, f8999b) + c.c(9, aVar5);
        }
        return c2 + c.e(10, i2);
    }

    private static int k(int i2, a aVar, int i3, long j2, long j3, boolean z, int i4, a aVar2, a aVar3) {
        return c.e(3, i2) + 0 + (aVar == null ? 0 : c.c(4, aVar)) + c.p(5, i3) + c.r(6, j2) + c.r(7, j3) + c.a(10, z) + c.p(12, i4) + (aVar2 == null ? 0 : c.c(13, aVar2)) + (aVar3 != null ? c.c(14, aVar3) : 0);
    }

    private static int l(long j2, String str, com.google.firebase.crashlytics.c.q.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3, a aVar, a aVar2, Float f2, int i4, boolean z, long j3, long j4, a aVar3) {
        int r = c.r(1, j2) + 0 + c.c(2, a.c(str));
        int f3 = f(eVar, thread, stackTraceElementArr, threadArr, list, i2, aVar, aVar2, map, runningAppProcessInfo, i3);
        int g2 = g(f2, i4, z, i3, j3, j4);
        int o = r + c.o(3) + c.k(f3) + f3 + c.o(5) + c.k(g2) + g2;
        if (aVar3 != null) {
            int h2 = h(aVar3);
            return o + c.o(6) + c.k(h2) + h2;
        }
        return o;
    }

    private static int m(a aVar, a aVar2, boolean z) {
        return c.e(1, 3) + 0 + c.c(2, aVar) + c.c(3, aVar2) + c.a(4, z);
    }

    private static int n(Thread thread, StackTraceElement[] stackTraceElementArr, int i2, boolean z) {
        int c2 = c.c(1, a.c(thread.getName())) + c.p(2, i2);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int i3 = i(stackTraceElement, z);
            c2 += c.o(3) + c.k(i3) + i3;
        }
        return c2;
    }

    private static a o(String str) {
        if (str == null) {
            return null;
        }
        return a.c(str);
    }

    public static void p(c cVar, String str, String str2, long j2) throws Exception {
        cVar.B(1, a.c(str2));
        cVar.B(2, a.c(str));
        cVar.b0(3, j2);
    }

    private static void q(c cVar, int i2, StackTraceElement stackTraceElement, boolean z) throws Exception {
        cVar.Y(i2, 2);
        cVar.T(i(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            cVar.b0(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            cVar.b0(1, 0L);
        }
        cVar.B(2, a.c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            cVar.B(3, a.c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            cVar.b0(4, stackTraceElement.getLineNumber());
        }
        cVar.Z(5, z ? 4 : 0);
    }

    public static void r(c cVar, String str, String str2, String str3, String str4, int i2, String str5) throws Exception {
        a c2 = a.c(str);
        a c3 = a.c(str2);
        a c4 = a.c(str3);
        a c5 = a.c(str4);
        a c6 = str5 != null ? a.c(str5) : null;
        cVar.Y(7, 2);
        cVar.T(j(c2, c3, c4, c5, i2, c6));
        cVar.B(1, c2);
        cVar.B(2, c3);
        cVar.B(3, c4);
        cVar.B(6, c5);
        if (c6 != null) {
            cVar.B(8, f8999b);
            cVar.B(9, c6);
        }
        cVar.E(10, i2);
    }

    public static void s(c cVar, String str) throws Exception {
        a c2 = a.c(str);
        cVar.Y(7, 2);
        int c3 = c.c(2, c2);
        cVar.T(c.o(5) + c.k(c3) + c3);
        cVar.Y(5, 2);
        cVar.T(c3);
        cVar.B(2, c2);
    }

    public static void t(c cVar, int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) throws Exception {
        a o = o(str);
        a o2 = o(str3);
        a o3 = o(str2);
        cVar.Y(9, 2);
        cVar.T(k(i2, o, i3, j2, j3, z, i4, o3, o2));
        cVar.E(3, i2);
        cVar.B(4, o);
        cVar.Z(5, i3);
        cVar.b0(6, j2);
        cVar.b0(7, j3);
        cVar.z(10, z);
        cVar.Z(12, i4);
        if (o3 != null) {
            cVar.B(13, o3);
        }
        if (o2 != null) {
            cVar.B(14, o2);
        }
    }

    public static void u(c cVar, long j2, String str, com.google.firebase.crashlytics.c.q.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3, String str2, String str3, Float f2, int i4, boolean z, long j3, long j4) throws Exception {
        a c2 = a.c(str2);
        a aVar = null;
        a c3 = str3 == null ? null : a.c(str3.replace("-", ""));
        if (bArr != null) {
            aVar = a.a(bArr);
        } else {
            com.google.firebase.crashlytics.c.b.f().b("No log data to include with this event.");
        }
        a aVar2 = aVar;
        cVar.Y(10, 2);
        cVar.T(l(j2, str, eVar, thread, stackTraceElementArr, threadArr, list, i2, map, runningAppProcessInfo, i3, c2, c3, f2, i4, z, j3, j4, aVar2));
        cVar.b0(1, j2);
        cVar.B(2, a.c(str));
        v(cVar, eVar, thread, stackTraceElementArr, threadArr, list, i2, c2, c3, map, runningAppProcessInfo, i3);
        z(cVar, f2, i4, z, i3, j3, j4);
        A(cVar, aVar2);
    }

    private static void v(c cVar, com.google.firebase.crashlytics.c.q.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, a aVar, a aVar2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i3) throws Exception {
        cVar.Y(3, 2);
        cVar.T(f(eVar, thread, stackTraceElementArr, threadArr, list, i2, aVar, aVar2, map, runningAppProcessInfo, i3));
        x(cVar, eVar, thread, stackTraceElementArr, threadArr, list, i2, aVar, aVar2);
        if (map != null && !map.isEmpty()) {
            w(cVar, map);
        }
        if (runningAppProcessInfo != null) {
            cVar.z(3, runningAppProcessInfo.importance != 100);
        }
        cVar.Z(4, i3);
    }

    private static void w(c cVar, Map<String, String> map) throws Exception {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            cVar.Y(2, 2);
            cVar.T(b(entry.getKey(), entry.getValue()));
            cVar.B(1, a.c(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            cVar.B(2, a.c(value));
        }
    }

    private static void x(c cVar, com.google.firebase.crashlytics.c.q.e eVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i2, a aVar, a aVar2) throws Exception {
        cVar.Y(1, 2);
        cVar.T(e(eVar, thread, stackTraceElementArr, threadArr, list, i2, aVar, aVar2));
        D(cVar, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            D(cVar, threadArr[i3], list.get(i3), 0, false);
        }
        y(cVar, eVar, 1, i2, 2);
        cVar.Y(3, 2);
        cVar.T(d());
        a aVar3 = a;
        cVar.B(1, aVar3);
        cVar.B(2, aVar3);
        cVar.b0(3, 0L);
        cVar.Y(4, 2);
        cVar.T(a(aVar, aVar2));
        cVar.b0(1, 0L);
        cVar.b0(2, 0L);
        cVar.B(3, aVar);
        if (aVar2 != null) {
            cVar.B(4, aVar2);
        }
    }

    private static void y(c cVar, com.google.firebase.crashlytics.c.q.e eVar, int i2, int i3, int i4) throws Exception {
        cVar.Y(i4, 2);
        cVar.T(c(eVar, 1, i3));
        cVar.B(1, a.c(eVar.f9074b));
        String str = eVar.a;
        if (str != null) {
            cVar.B(3, a.c(str));
        }
        int i5 = 0;
        for (StackTraceElement stackTraceElement : eVar.f9075c) {
            q(cVar, 4, stackTraceElement, true);
        }
        com.google.firebase.crashlytics.c.q.e eVar2 = eVar.f9076d;
        if (eVar2 != null) {
            if (i2 < i3) {
                y(cVar, eVar2, i2 + 1, i3, 6);
                return;
            }
            while (eVar2 != null) {
                eVar2 = eVar2.f9076d;
                i5++;
            }
            cVar.Z(7, i5);
        }
    }

    private static void z(c cVar, Float f2, int i2, boolean z, int i3, long j2, long j3) throws Exception {
        cVar.Y(5, 2);
        cVar.T(g(f2, i2, z, i3, j2, j3));
        if (f2 != null) {
            cVar.H(1, f2.floatValue());
        }
        cVar.V(2, i2);
        cVar.z(3, z);
        cVar.Z(4, i3);
        cVar.b0(5, j2);
        cVar.b0(6, j3);
    }
}