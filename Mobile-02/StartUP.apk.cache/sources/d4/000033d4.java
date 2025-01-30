package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.o6  reason: invalid package */
/* loaded from: classes2.dex */
final class o6 {
    private static final Class<?> a = K();

    /* renamed from: b  reason: collision with root package name */
    private static final e7<?, ?> f6881b = D(false);

    /* renamed from: c  reason: collision with root package name */
    private static final e7<?, ?> f6882c = D(true);

    /* renamed from: d  reason: collision with root package name */
    private static final e7<?, ?> f6883d = new g7();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o4) {
            o4 o4Var = (o4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.r(o4Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.r(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void B(int i2, List<Integer> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.e(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o4) {
            o4 o4Var = (o4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.s(o4Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.s(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    private static e7<?, ?> D(boolean z) {
        try {
            Class<?> L = L();
            if (L == null) {
                return null;
            }
            return (e7) L.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void E(int i2, List<Integer> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.n(i2, list, z);
    }

    public static e7<?, ?> F() {
        return f6881b;
    }

    public static e7<?, ?> G() {
        return f6882c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(List<?> list) {
        return list.size() << 2;
    }

    public static void I(int i2, List<Integer> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.w(i2, list, z);
    }

    public static e7<?, ?> J() {
        return f6883d;
    }

    private static Class<?> K() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> L() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(List<?> list) {
        return list.size() << 3;
    }

    public static void N(int i2, List<Integer> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.l(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int O(List<?> list) {
        return list.size();
    }

    public static void P(int i2, List<Integer> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.o(i2, list, z);
    }

    public static void Q(int i2, List<Integer> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.g(i2, list, z);
    }

    public static void R(int i2, List<Boolean> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.b(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int S(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return m(list) + (list.size() * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int T(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return q(list) + (size * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int U(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return s(list) + (size * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int V(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return v(list) + (size * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int W(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return y(list) + (size * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int X(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Y(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return C(list) + (size * zzev.F0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Z(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.y0(i2, 0);
    }

    public static void a(int i2, List<String> list, y7 y7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.B(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.n0(i2, 0L);
    }

    public static void b(int i2, List<?> list, y7 y7Var, m6 m6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.G(i2, list, m6Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.R(i2, true);
    }

    public static void c(int i2, List<Double> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.x(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends g4<FT>> void d(c4<FT> c4Var, T t, T t2) {
        e4<FT> c2 = c4Var.c(t2);
        if (c2.f6712b.isEmpty()) {
            return;
        }
        c4Var.d(t).h(c2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void e(o5 o5Var, T t, T t2, long j2) {
        k7.g(t, j2, o5Var.c(k7.G(t, j2), k7.G(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void f(e7<UT, UB> e7Var, T t, T t2) {
        e7Var.d(t, e7Var.e(e7Var.g(t), e7Var.g(t2)));
    }

    public static void g(int i2, List<i3> list, y7 y7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.y(i2, list);
    }

    public static void h(int i2, List<?> list, y7 y7Var, m6 m6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.E(i2, list, m6Var);
    }

    public static void i(int i2, List<Float> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.z(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i2, Object obj, m6 m6Var) {
        if (obj instanceof z4) {
            return zzev.c(i2, (z4) obj);
        }
        return zzev.P(i2, (v5) obj, m6Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i2, List<?> list) {
        int A;
        int A2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int F0 = zzev.F0(i2) * size;
        if (list instanceof b5) {
            b5 b5Var = (b5) list;
            while (i3 < size) {
                Object n = b5Var.n(i3);
                if (n instanceof i3) {
                    A2 = zzev.S((i3) n);
                } else {
                    A2 = zzev.A((String) n);
                }
                F0 += A2;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof i3) {
                    A = zzev.S((i3) obj);
                } else {
                    A = zzev.A((String) obj);
                }
                F0 += A;
                i3++;
            }
        }
        return F0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(int i2, List<?> list, m6 m6Var) {
        int e2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int F0 = zzev.F0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof z4) {
                e2 = zzev.d((z4) obj);
            } else {
                e2 = zzev.e((v5) obj, m6Var);
            }
            F0 += e2;
        }
        return F0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof j5) {
            j5 j5Var = (j5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.E(j5Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.E(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void n(int i2, List<Long> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.j(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i2, List<i3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int F0 = size * zzev.F0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            F0 += zzev.S(list.get(i3));
        }
        return F0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i2, List<v5> list, m6 m6Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzev.b0(i2, list.get(i4), m6Var);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof j5) {
            j5 j5Var = (j5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.F(j5Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.F(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void r(int i2, List<Long> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.v(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof j5) {
            j5 j5Var = (j5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.G(j5Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.G(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void t(int i2, List<Long> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.u(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean u(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o4) {
            o4 o4Var = (o4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.v(o4Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.v(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void w(int i2, List<Long> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.s(i2, list, z);
    }

    public static void x(Class<?> cls) {
        Class<?> cls2;
        if (!m4.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof o4) {
            o4 o4Var = (o4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.G0(o4Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzev.G0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void z(int i2, List<Long> list, y7 y7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y7Var.k(i2, list, z);
    }
}