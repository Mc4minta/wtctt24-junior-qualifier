package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class o6 {
    private static final Class<?> a = F();

    /* renamed from: b  reason: collision with root package name */
    private static final d7<?, ?> f7283b = g(false);

    /* renamed from: c  reason: collision with root package name */
    private static final d7<?, ?> f7284c = g(true);

    /* renamed from: d  reason: collision with root package name */
    private static final d7<?, ?> f7285d = new f7();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i5) {
            i5 i5Var = (i5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.n0(i5Var.c(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.n0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static d7<?, ?> B() {
        return f7285d;
    }

    public static void C(int i2, List<Long> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.j(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzel.g0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(List<Integer> list) {
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
                i2 += zzel.B0(o4Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.B0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    private static Class<?> F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void G(int i2, List<Long> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.v(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return I(list) + (size * zzel.g0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(List<Integer> list) {
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
                i2 += zzel.k0(o4Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.k0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    private static Class<?> J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void K(int i2, List<Long> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.u(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * zzel.g0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(List<Integer> list) {
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
                i2 += zzel.o0(o4Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.o0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void N(int i2, List<Long> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.s(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int O(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * zzel.g0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(List<Integer> list) {
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
                i2 += zzel.s0(o4Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.s0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void Q(int i2, List<Long> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.k(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int R(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzel.x0(i2, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int S(List<?> list) {
        return list.size() << 2;
    }

    public static void T(int i2, List<Integer> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.e(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int U(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzel.q0(i2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int V(List<?> list) {
        return list.size() << 3;
    }

    public static void W(int i2, List<Integer> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.n(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int X(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzel.H(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Y(List<?> list) {
        return list.size();
    }

    public static void Z(int i2, List<Integer> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.w(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, Object obj, m6 m6Var) {
        if (obj instanceof c5) {
            return zzel.c(i2, (c5) obj);
        }
        return zzel.F(i2, (u5) obj, m6Var);
    }

    public static void a0(int i2, List<Integer> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.l(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i2, List<?> list) {
        int K;
        int K2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int g0 = zzel.g0(i2) * size;
        if (list instanceof e5) {
            e5 e5Var = (e5) list;
            while (i3 < size) {
                Object c2 = e5Var.c(i3);
                if (c2 instanceof h3) {
                    K2 = zzel.I((h3) c2);
                } else {
                    K2 = zzel.K((String) c2);
                }
                g0 += K2;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof h3) {
                    K = zzel.I((h3) obj);
                } else {
                    K = zzel.K((String) obj);
                }
                g0 += K;
                i3++;
            }
        }
        return g0;
    }

    public static void b0(int i2, List<Integer> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.o(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, List<?> list, m6 m6Var) {
        int e2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g0 = zzel.g0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof c5) {
                e2 = zzel.d((c5) obj);
            } else {
                e2 = zzel.e((u5) obj, m6Var);
            }
            g0 += e2;
        }
        return g0;
    }

    public static void c0(int i2, List<Integer> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.g(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * zzel.g0(i2));
    }

    public static void d0(int i2, List<Boolean> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.b(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i5) {
            i5 i5Var = (i5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.d0(i5Var.c(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.d0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static d7<?, ?> f() {
        return f7283b;
    }

    private static d7<?, ?> g(boolean z) {
        try {
            Class<?> J = J();
            if (J == null) {
                return null;
            }
            return (d7) J.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB h(int i2, int i3, UB ub, d7<UT, UB> d7Var) {
        if (ub == null) {
            ub = d7Var.a();
        }
        d7Var.b(ub, i2, i3);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB i(int i2, List<Integer> list, r4 r4Var, UB ub, d7<UT, UB> d7Var) {
        if (r4Var == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (r4Var.f(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) h(i2, intValue, ub, d7Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!r4Var.f(intValue2)) {
                    ub = (UB) h(i2, intValue2, ub, d7Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void j(int i2, List<String> list, w7 w7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.B(i2, list);
    }

    public static void k(int i2, List<?> list, w7 w7Var, m6 m6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.M(i2, list, m6Var);
    }

    public static void l(int i2, List<Double> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.x(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends e4<FT>> void m(b4<FT> b4Var, T t, T t2) {
        c4<FT> b2 = b4Var.b(t2);
        if (b2.f7070b.isEmpty()) {
            return;
        }
        b4Var.f(t).f(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void n(r5 r5Var, T t, T t2, long j2) {
        j7.j(t, j2, r5Var.f(j7.F(t, j2), j7.F(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void o(d7<UT, UB> d7Var, T t, T t2) {
        d7Var.e(t, d7Var.i(d7Var.f(t), d7Var.f(t2)));
    }

    public static void p(Class<?> cls) {
        Class<?> cls2;
        if (!n4.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(int i2, List<h3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g0 = size * zzel.g0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            g0 += zzel.I(list.get(i3));
        }
        return g0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i2, List<u5> list, m6 m6Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzel.U(i2, list.get(i4), m6Var);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return u(list) + (size * zzel.g0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i5) {
            i5 i5Var = (i5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.i0(i5Var.c(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzel.i0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static d7<?, ?> v() {
        return f7284c;
    }

    public static void w(int i2, List<h3> list, w7 w7Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.y(i2, list);
    }

    public static void x(int i2, List<?> list, w7 w7Var, m6 m6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.K(i2, list, m6Var);
    }

    public static void y(int i2, List<Float> list, w7 w7Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        w7Var.z(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzel.g0(i2));
    }
}