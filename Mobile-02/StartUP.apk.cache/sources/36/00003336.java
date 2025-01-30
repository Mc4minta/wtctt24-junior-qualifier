package com.google.android.gms.internal.p000firebaseperf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.a4  reason: invalid package */
/* loaded from: classes2.dex */
final class a4 implements y7 {
    private final zzev a;

    private a4(zzev zzevVar) {
        zzev zzevVar2 = (zzev) n4.b(zzevVar, "output");
        this.a = zzevVar2;
        zzevVar2.f7018c = this;
    }

    public static a4 a(zzev zzevVar) {
        a4 a4Var = zzevVar.f7018c;
        return a4Var != null ? a4Var : new a4(zzevVar);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void A(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void B(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof b5) {
            b5 b5Var = (b5) list;
            while (i3 < list.size()) {
                Object n = b5Var.n(i3);
                if (n instanceof String) {
                    this.a.n(i2, (String) n);
                } else {
                    this.a.k(i2, (i3) n);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.n(i2, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void C(int i2, boolean z) throws IOException {
        this.a.o(i2, z);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void D(int i2, long j2) throws IOException {
        this.a.e0(i2, j2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void E(int i2, List<?> list, m6 m6Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            N(i2, list.get(i3), m6Var);
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void F(int i2, long j2) throws IOException {
        this.a.j(i2, j2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void G(int i2, List<?> list, m6 m6Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            M(i2, list.get(i3), m6Var);
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final <K, V> void H(int i2, m5<K, V> m5Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.b(i2, 2);
            this.a.C0(n5.b(m5Var, entry.getKey(), entry.getValue()));
            zzev zzevVar = this.a;
            K key = entry.getKey();
            V value = entry.getValue();
            e4.g(zzevVar, m5Var.a, 1, key);
            e4.g(zzevVar, m5Var.f6834c, 2, value);
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void I(int i2, int i3) throws IOException {
        this.a.u0(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final int J() {
        return i6.f6759d;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void K(int i2) throws IOException {
        this.a.b(i2, 4);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void L(int i2, i3 i3Var) throws IOException {
        this.a.k(i2, i3Var);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void M(int i2, Object obj, m6 m6Var) throws IOException {
        this.a.m(i2, (v5) obj, m6Var);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void N(int i2, Object obj, m6 m6Var) throws IOException {
        zzev zzevVar = this.a;
        zzevVar.b(i2, 3);
        m6Var.b((v5) obj, zzevVar.f7018c);
        zzevVar.b(i2, 4);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void O(int i2, int i3) throws IOException {
        this.a.u0(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void P(int i2, int i3) throws IOException {
        this.a.p0(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void Q(int i2) throws IOException {
        this.a.b(i2, 3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void R(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void b(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.o0(list.get(i5).booleanValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.m0(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.o(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void d(int i2, long j2) throws IOException {
        this.a.V(i2, j2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void e(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.G0(list.get(i5).intValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.B0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void g(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.v(list.get(i5).intValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.B0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void h(int i2, long j2) throws IOException {
        this.a.e0(i2, j2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void i(int i2, Object obj) throws IOException {
        if (obj instanceof i3) {
            this.a.W(i2, (i3) obj);
        } else {
            this.a.l(i2, (v5) obj);
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void j(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.E(list.get(i5).longValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.B(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void k(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.I(list.get(i5).longValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.D(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.e0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void l(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.t(list.get(i5).intValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.E0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.u0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void m(int i2, String str) throws IOException {
        this.a.n(i2, str);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.r(list.get(i5).intValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.C0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.l0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.u(list.get(i5).intValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.E0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.u0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void p(int i2, long j2) throws IOException {
        this.a.j(i2, j2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void q(int i2, double d2) throws IOException {
        this.a.h(i2, d2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void r(int i2, float f2) throws IOException {
        this.a.i(i2, f2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void s(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.H(list.get(i5).longValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.D(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.e0(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void t(int i2, int i3) throws IOException {
        this.a.l0(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.G(list.get(i5).longValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.C(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.V(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void v(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.F(list.get(i5).longValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.B(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void w(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.s(list.get(i5).intValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.D0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.p0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void x(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.K(list.get(i5).doubleValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.g(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.h(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void y(int i2, List<i3> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.k(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.y7
    public final void z(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.b(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzev.Z(list.get(i5).floatValue());
            }
            this.a.C0(i4);
            while (i3 < list.size()) {
                this.a.U(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.i(i2, list.get(i3).floatValue());
            i3++;
        }
    }
}