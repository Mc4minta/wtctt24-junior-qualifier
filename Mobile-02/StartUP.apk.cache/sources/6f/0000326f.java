package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class b3 {
    private static final Class<?> a = C();

    /* renamed from: b  reason: collision with root package name */
    private static final q3<?, ?> f6375b = w(false);

    /* renamed from: c  reason: collision with root package name */
    private static final q3<?, ?> f6376c = w(true);

    /* renamed from: d  reason: collision with root package name */
    private static final q3<?, ?> f6377d = new s3();

    public static q3<?, ?> A() {
        return f6376c;
    }

    public static q3<?, ?> B() {
        return f6377d;
    }

    private static Class<?> C() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.C0(f1Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.C0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void F(int i2, List<Long> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.u(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.D0(f1Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.D0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void H(int i2, List<Long> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.s(i2, list, z);
    }

    public static void I(Class<?> cls) {
        Class<?> cls2;
        if (!e1.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.E0(f1Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.E0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static void K(int i2, List<Long> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.k(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(List<?> list) {
        return list.size() << 2;
    }

    public static void M(int i2, List<Integer> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.e(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int N(List<?> list) {
        return list.size() << 3;
    }

    public static void O(int i2, List<Integer> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.n(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(List<?> list) {
        return list.size();
    }

    public static void Q(int i2, List<Integer> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.w(i2, list, z);
    }

    public static void R(int i2, List<Integer> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.l(i2, list, z);
    }

    public static void S(int i2, List<Integer> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.o(i2, list, z);
    }

    public static void T(int i2, List<Integer> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.g(i2, list, z);
    }

    public static void U(int i2, List<Boolean> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.b(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int V(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * zzbn.B0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int W(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzbn.B0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int X(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return q(list) + (size * zzbn.B0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Y(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return v(list) + (size * zzbn.B0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int Z(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzbn.B0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w1) {
            w1 w1Var = (w1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.e0(w1Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.e0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a0(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * zzbn.B0(i2));
    }

    private static <UT, UB> UB b(int i2, int i3, UB ub, q3<UT, UB> q3Var) {
        if (ub == null) {
            ub = q3Var.f();
        }
        q3Var.a(ub, i2, i3);
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b0(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return J(list) + (size * zzbn.B0(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB c(int i2, List<Integer> list, i1<?> i1Var, UB ub, q3<UT, UB> q3Var) {
        if (i1Var == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (i1Var.c(intValue) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) b(i2, intValue, ub, q3Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (i1Var.c(intValue2) == null) {
                    ub = (UB) b(i2, intValue2, ub, q3Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.t0(i2, 0);
    }

    public static void d(int i2, List<String> list, l4 l4Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.B(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.k0(i2, 0L);
    }

    public static void e(int i2, List<?> list, l4 l4Var, z2 z2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.J(i2, list, z2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.Q(i2, true);
    }

    public static void f(int i2, List<Double> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.x(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends y0<FT>> void g(r0<FT> r0Var, T t, T t2) {
        v0<FT> b2 = r0Var.b(t2);
        if (b2.b()) {
            return;
        }
        r0Var.e(t).h(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void h(d2 d2Var, T t, T t2, long j2) {
        x3.i(t, j2, d2Var.g(x3.M(t, j2), x3.M(t2, j2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void i(q3<UT, UB> q3Var, T t, T t2) {
        q3Var.g(t, q3Var.i(q3Var.k(t), q3Var.k(t2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w1) {
            w1 w1Var = (w1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.h0(w1Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.h0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void k(int i2, List<a0> list, l4 l4Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.y(i2, list);
    }

    public static void l(int i2, List<?> list, l4 l4Var, z2 z2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.H(i2, list, z2Var);
    }

    public static void m(int i2, List<Float> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.z(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(int i2, Object obj, z2 z2Var) {
        return obj instanceof p1 ? zzbn.d(i2, (p1) obj) : zzbn.B(i2, (i2) obj, z2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int B0 = zzbn.B0(i2) * size;
        if (list instanceof r1) {
            r1 r1Var = (r1) list;
            while (i3 < size) {
                Object n = r1Var.n(i3);
                B0 += n instanceof a0 ? zzbn.D((a0) n) : zzbn.q0((String) n);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                B0 += obj instanceof a0 ? zzbn.D((a0) obj) : zzbn.q0((String) obj);
                i3++;
            }
        }
        return B0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i2, List<?> list, z2 z2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int B0 = zzbn.B0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            B0 += obj instanceof p1 ? zzbn.e((p1) obj) : zzbn.E((i2) obj, z2Var);
        }
        return B0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w1) {
            w1 w1Var = (w1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.l0(w1Var.i(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.l0(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void r(int i2, List<Long> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.j(i2, list, z);
    }

    public static boolean s(int i2, int i3, int i4) {
        if (i3 < 40) {
            return true;
        }
        long j2 = i4;
        return ((((long) i3) - ((long) i2)) + 1) + 9 <= ((2 * j2) + 3) + ((j2 + 3) * 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(int i2, List<a0> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int B0 = size * zzbn.B0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            B0 += zzbn.D(list.get(i3));
        }
        return B0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i2, List<i2> list, z2 z2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzbn.P(i2, list.get(i4), z2Var);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f1) {
            f1 f1Var = (f1) list;
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.H0(f1Var.getInt(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += zzbn.H0(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    private static q3<?, ?> w(boolean z) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (q3) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void x(int i2, List<Long> list, l4 l4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        l4Var.v(i2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static q3<?, ?> z() {
        return f6375b;
    }
}