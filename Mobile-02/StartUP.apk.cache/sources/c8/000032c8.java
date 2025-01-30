package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.e1;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class n0 implements l4 {
    private final zzbn a;

    private n0(zzbn zzbnVar) {
        zzbn zzbnVar2 = (zzbn) g1.e(zzbnVar, "output");
        this.a = zzbnVar2;
        zzbnVar2.f6673c = this;
    }

    public static n0 a(zzbn zzbnVar) {
        n0 n0Var = zzbnVar.f6673c;
        return n0Var != null ? n0Var : new n0(zzbnVar);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void A(int i2, int i3) throws IOException {
        this.a.f0(i2, i3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void B(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (!(list instanceof r1)) {
            while (i3 < list.size()) {
                this.a.p(i2, list.get(i3));
                i3++;
            }
            return;
        }
        r1 r1Var = (r1) list;
        while (i3 < list.size()) {
            Object n = r1Var.n(i3);
            if (n instanceof String) {
                this.a.p(i2, (String) n);
            } else {
                this.a.m(i2, (a0) n);
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void D(int i2, long j2) throws IOException {
        this.a.U(i2, j2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void E(int i2, int i3) throws IOException {
        this.a.T(i2, i3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void F(int i2, long j2) throws IOException {
        this.a.l(i2, j2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void G(int i2, int i3) throws IOException {
        this.a.b0(i2, i3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void H(int i2, List<?> list, z2 z2Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            P(i2, list.get(i3), z2Var);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void I(int i2, boolean z) throws IOException {
        this.a.K(i2, z);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void J(int i2, List<?> list, z2 z2Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            N(i2, list.get(i3), z2Var);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void K(int i2) throws IOException {
        this.a.G(i2, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void L(int i2, int i3) throws IOException {
        this.a.T(i2, i3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void M(int i2, a0 a0Var) throws IOException {
        this.a.m(i2, a0Var);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void N(int i2, Object obj, z2 z2Var) throws IOException {
        this.a.o(i2, (i2) obj, z2Var);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void O(int i2) throws IOException {
        this.a.G(i2, 3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void P(int i2, Object obj, z2 z2Var) throws IOException {
        zzbn zzbnVar = this.a;
        zzbnVar.G(i2, 3);
        z2Var.g((i2) obj, zzbnVar.f6673c);
        zzbnVar.G(i2, 4);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final int Q() {
        return e1.e.f6412l;
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final <K, V> void R(int i2, b2<K, V> b2Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.G(i2, 2);
            this.a.y0(a2.a(b2Var, entry.getKey(), entry.getValue()));
            a2.b(this.a, b2Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void S(int i2, int i3) throws IOException {
        this.a.i0(i2, i3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void b(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.K(i2, list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.F(list.get(i5).booleanValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.t(list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void d(int i2, long j2) throws IOException {
        this.a.H(i2, j2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void e(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.T(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.C0(list.get(i5).intValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.x0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void g(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.T(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.H0(list.get(i5).intValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.x0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void h(int i2, long j2) throws IOException {
        this.a.U(i2, j2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void i(int i2, Object obj) throws IOException {
        if (obj instanceof a0) {
            this.a.I(i2, (a0) obj);
        } else {
            this.a.J(i2, (i2) obj);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void j(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.l(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.e0(list.get(i5).longValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.L(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void k(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.U(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.s0(list.get(i5).longValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.c0(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void l(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.i0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.F0(list.get(i5).intValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.A0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void m(int i2, String str) throws IOException {
        this.a.p(i2, str);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.b0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.D0(list.get(i5).intValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.y0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.i0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.G0(list.get(i5).intValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.A0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void p(int i2, long j2) throws IOException {
        this.a.l(i2, j2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void q(int i2, double d2) throws IOException {
        this.a.j(i2, d2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void r(int i2, float f2) throws IOException {
        this.a.k(i2, f2);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void s(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.U(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.p0(list.get(i5).longValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.c0(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void t(int i2, int i3) throws IOException {
        this.a.i0(i2, i3);
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.H(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.l0(list.get(i5).longValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.V(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void v(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.l(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.h0(list.get(i5).longValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.L(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void w(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.f0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.E0(list.get(i5).intValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.z0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void x(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.j(i2, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.w(list.get(i5).doubleValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.h(list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void y(int i2, List<a0> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.m(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.clearcut.l4
    public final void z(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.k(i2, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        this.a.G(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += zzbn.x(list.get(i5).floatValue());
        }
        this.a.y0(i4);
        while (i3 < list.size()) {
            this.a.i(list.get(i3).floatValue());
            i3++;
        }
    }
}