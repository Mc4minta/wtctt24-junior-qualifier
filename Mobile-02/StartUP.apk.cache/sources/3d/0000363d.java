package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class f4 {
    private long A;
    private long B;
    private long C;
    private String D;
    private boolean E;
    private long F;
    private long G;
    private final b5 a;

    /* renamed from: b  reason: collision with root package name */
    private final String f7574b;

    /* renamed from: c  reason: collision with root package name */
    private String f7575c;

    /* renamed from: d  reason: collision with root package name */
    private String f7576d;

    /* renamed from: e  reason: collision with root package name */
    private String f7577e;

    /* renamed from: f  reason: collision with root package name */
    private String f7578f;

    /* renamed from: g  reason: collision with root package name */
    private long f7579g;

    /* renamed from: h  reason: collision with root package name */
    private long f7580h;

    /* renamed from: i  reason: collision with root package name */
    private long f7581i;

    /* renamed from: j  reason: collision with root package name */
    private String f7582j;

    /* renamed from: k  reason: collision with root package name */
    private long f7583k;

    /* renamed from: l  reason: collision with root package name */
    private String f7584l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private String s;
    private Boolean t;
    private long u;
    private List<String> v;
    private String w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f4(b5 b5Var, String str) {
        com.google.android.gms.common.internal.t.k(b5Var);
        com.google.android.gms.common.internal.t.g(str);
        this.a = b5Var;
        this.f7574b = str;
        b5Var.l().d();
    }

    public final String A() {
        this.a.l().d();
        return this.f7576d;
    }

    public final void B(long j2) {
        this.a.l().d();
        this.E |= this.n != j2;
        this.n = j2;
    }

    public final void C(String str) {
        this.a.l().d();
        this.E |= !v9.z0(this.f7577e, str);
        this.f7577e = str;
    }

    public final String D() {
        this.a.l().d();
        return this.s;
    }

    public final void E(long j2) {
        this.a.l().d();
        this.E |= this.u != j2;
        this.u = j2;
    }

    public final void F(String str) {
        this.a.l().d();
        this.E |= !v9.z0(this.f7578f, str);
        this.f7578f = str;
    }

    public final String G() {
        this.a.l().d();
        return this.w;
    }

    public final void H(long j2) {
        com.google.android.gms.common.internal.t.a(j2 >= 0);
        this.a.l().d();
        this.E |= this.f7579g != j2;
        this.f7579g = j2;
    }

    public final void I(String str) {
        this.a.l().d();
        this.E |= !v9.z0(this.f7582j, str);
        this.f7582j = str;
    }

    public final String J() {
        this.a.l().d();
        return this.f7577e;
    }

    public final void K(long j2) {
        this.a.l().d();
        this.E |= this.F != j2;
        this.F = j2;
    }

    public final void L(String str) {
        this.a.l().d();
        this.E |= !v9.z0(this.f7584l, str);
        this.f7584l = str;
    }

    public final String M() {
        this.a.l().d();
        return this.f7578f;
    }

    public final void N(long j2) {
        this.a.l().d();
        this.E |= this.G != j2;
        this.G = j2;
    }

    public final void O(String str) {
        this.a.l().d();
        this.E |= !v9.z0(this.D, str);
        this.D = str;
    }

    public final long P() {
        this.a.l().d();
        return this.f7580h;
    }

    public final void Q(long j2) {
        this.a.l().d();
        this.E |= this.x != j2;
        this.x = j2;
    }

    public final long R() {
        this.a.l().d();
        return this.f7581i;
    }

    public final void S(long j2) {
        this.a.l().d();
        this.E |= this.y != j2;
        this.y = j2;
    }

    public final String T() {
        this.a.l().d();
        return this.f7582j;
    }

    public final void U(long j2) {
        this.a.l().d();
        this.E |= this.z != j2;
        this.z = j2;
    }

    public final long V() {
        this.a.l().d();
        return this.f7583k;
    }

    public final void W(long j2) {
        this.a.l().d();
        this.E |= this.A != j2;
        this.A = j2;
    }

    public final String X() {
        this.a.l().d();
        return this.f7584l;
    }

    public final void Y(long j2) {
        this.a.l().d();
        this.E |= this.C != j2;
        this.C = j2;
    }

    public final long Z() {
        this.a.l().d();
        return this.m;
    }

    public final void a(long j2) {
        this.a.l().d();
        this.E |= this.f7580h != j2;
        this.f7580h = j2;
    }

    public final void a0(long j2) {
        this.a.l().d();
        this.E |= this.B != j2;
        this.B = j2;
    }

    public final void b(Boolean bool) {
        this.a.l().d();
        this.E |= !v9.a0(this.t, bool);
        this.t = bool;
    }

    public final long b0() {
        this.a.l().d();
        return this.n;
    }

    public final void c(String str) {
        this.a.l().d();
        this.E |= !v9.z0(this.f7575c, str);
        this.f7575c = str;
    }

    public final void c0(long j2) {
        this.a.l().d();
        this.E |= this.p != j2;
        this.p = j2;
    }

    public final void d(List<String> list) {
        this.a.l().d();
        if (v9.l0(this.v, list)) {
            return;
        }
        this.E = true;
        this.v = list != null ? new ArrayList(list) : null;
    }

    public final long d0() {
        this.a.l().d();
        return this.u;
    }

    public final void e(boolean z) {
        this.a.l().d();
        this.E |= this.o != z;
        this.o = z;
    }

    public final boolean e0() {
        this.a.l().d();
        return this.o;
    }

    public final boolean f() {
        this.a.l().d();
        return this.E;
    }

    public final long f0() {
        this.a.l().d();
        return this.f7579g;
    }

    public final long g() {
        this.a.l().d();
        return this.C;
    }

    public final long g0() {
        this.a.l().d();
        return this.F;
    }

    public final long h() {
        this.a.l().d();
        return this.B;
    }

    public final long h0() {
        this.a.l().d();
        return this.G;
    }

    public final String i() {
        this.a.l().d();
        return this.D;
    }

    public final void i0() {
        this.a.l().d();
        long j2 = this.f7579g + 1;
        if (j2 > 2147483647L) {
            this.a.f().K().b("Bundle index overflow. appId", x3.y(this.f7574b));
            j2 = 0;
        }
        this.E = true;
        this.f7579g = j2;
    }

    public final String j() {
        this.a.l().d();
        String str = this.D;
        O(null);
        return str;
    }

    public final long j0() {
        this.a.l().d();
        return this.x;
    }

    public final long k() {
        this.a.l().d();
        return this.p;
    }

    public final long k0() {
        this.a.l().d();
        return this.y;
    }

    public final boolean l() {
        this.a.l().d();
        return this.q;
    }

    public final long l0() {
        this.a.l().d();
        return this.z;
    }

    public final boolean m() {
        this.a.l().d();
        return this.r;
    }

    public final long m0() {
        this.a.l().d();
        return this.A;
    }

    public final Boolean n() {
        this.a.l().d();
        return this.t;
    }

    public final List<String> o() {
        this.a.l().d();
        return this.v;
    }

    public final void p() {
        this.a.l().d();
        this.E = false;
    }

    public final void q(long j2) {
        this.a.l().d();
        this.E |= this.f7581i != j2;
        this.f7581i = j2;
    }

    public final void r(String str) {
        this.a.l().d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !v9.z0(this.f7576d, str);
        this.f7576d = str;
    }

    public final void s(boolean z) {
        this.a.l().d();
        this.E |= this.q != z;
        this.q = z;
    }

    public final String t() {
        this.a.l().d();
        return this.f7574b;
    }

    public final void u(long j2) {
        this.a.l().d();
        this.E |= this.f7583k != j2;
        this.f7583k = j2;
    }

    public final void v(String str) {
        this.a.l().d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !v9.z0(this.s, str);
        this.s = str;
    }

    public final void w(boolean z) {
        this.a.l().d();
        this.E |= this.r != z;
        this.r = z;
    }

    public final String x() {
        this.a.l().d();
        return this.f7575c;
    }

    public final void y(long j2) {
        this.a.l().d();
        this.E |= this.m != j2;
        this.m = j2;
    }

    public final void z(String str) {
        this.a.l().d();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.E |= !v9.z0(this.w, str);
        this.w = str;
    }
}