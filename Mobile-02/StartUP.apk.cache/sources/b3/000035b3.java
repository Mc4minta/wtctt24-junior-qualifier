package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.n4;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class w3 implements w7 {
    private final zzel a;

    private w3(zzel zzelVar) {
        zzel zzelVar2 = (zzel) q4.f(zzelVar, "output");
        this.a = zzelVar2;
        zzelVar2.f7465c = this;
    }

    public static w3 P(zzel zzelVar) {
        w3 w3Var = zzelVar.f7465c;
        return w3Var != null ? w3Var : new w3(zzelVar);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void A(int i2, int i3) throws IOException {
        this.a.X(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void B(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof e5) {
            e5 e5Var = (e5) list;
            while (i3 < list.size()) {
                Object c2 = e5Var.c(i3);
                if (c2 instanceof String) {
                    this.a.r(i2, (String) c2);
                } else {
                    this.a.o(i2, (h3) c2);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.r(i2, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void C(int i2, boolean z) throws IOException {
        this.a.s(i2, z);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void D(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void E(int i2, int i3) throws IOException {
        this.a.P(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void F(int i2, int i3) throws IOException {
        this.a.P(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void G(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void H(int i2, h3 h3Var) throws IOException {
        this.a.o(i2, h3Var);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final <K, V> void I(int i2, p5<K, V> p5Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.m(i2, 2);
            this.a.O(m5.a(p5Var, entry.getKey(), entry.getValue()));
            m5.b(this.a, p5Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void J(int i2, Object obj, m6 m6Var) throws IOException {
        this.a.q(i2, (u5) obj, m6Var);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void K(int i2, List<?> list, m6 m6Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            N(i2, list.get(i3), m6Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void L(int i2, long j2) throws IOException {
        this.a.Y(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void M(int i2, List<?> list, m6 m6Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            J(i2, list.get(i3), m6Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void N(int i2, Object obj, m6 m6Var) throws IOException {
        zzel zzelVar = this.a;
        zzelVar.m(i2, 3);
        m6Var.i((u5) obj, zzelVar.f7465c);
        zzelVar.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void O(int i2, long j2) throws IOException {
        this.a.Q(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final int a() {
        return n4.f.f7265l;
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void b(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.L(list.get(i5).booleanValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.y(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.s(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void c(int i2) throws IOException {
        this.a.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void d(int i2, long j2) throws IOException {
        this.a.Y(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void e(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.k0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.j(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.P(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void f(int i2) throws IOException {
        this.a.m(i2, 3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void g(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.B0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.j(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.P(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void h(int i2, long j2) throws IOException {
        this.a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void i(int i2, Object obj) throws IOException {
        if (obj instanceof h3) {
            this.a.R(i2, (h3) obj);
        } else {
            this.a.p(i2, (u5) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void j(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.d0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.t(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.n(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void k(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.v0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.Z(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.Y(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void l(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.w0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.e0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void m(int i2, String str) throws IOException {
        this.a.r(i2, str);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.o0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.O(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.X(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.z0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.e0(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.j0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void p(int i2, long j2) throws IOException {
        this.a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void q(int i2, double d2) throws IOException {
        this.a.k(i2, d2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void r(int i2, float f2) throws IOException {
        this.a.l(i2, f2);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void s(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.r0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.Z(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.Y(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void t(int i2, int i3) throws IOException {
        this.a.f0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.n0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.S(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.Q(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void v(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.i0(list.get(i5).longValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.t(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.n(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void w(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.s0(list.get(i5).intValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.W(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.f0(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void x(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.z(list.get(i5).doubleValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.h(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.k(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void y(int i2, List<h3> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.o(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.measurement.w7
    public final void z(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.a.m(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzel.A(list.get(i5).floatValue());
            }
            this.a.O(i4);
            while (i3 < list.size()) {
                this.a.i(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.a.l(i2, list.get(i3).floatValue());
            i3++;
        }
    }
}