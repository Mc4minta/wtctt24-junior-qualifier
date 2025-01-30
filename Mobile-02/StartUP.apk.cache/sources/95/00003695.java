package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.b1;
import com.google.android.gms.internal.measurement.t0;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.gms.internal.measurement.x0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class m7 extends k9 {
    public m7(j9 j9Var) {
        super(j9Var);
    }

    private static String k(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.k9
    protected final boolean w() {
        return false;
    }

    public final byte[] x(p pVar, String str) {
        s9 s9Var;
        x0.a aVar;
        f4 f4Var;
        w0.a aVar2;
        Bundle bundle;
        byte[] bArr;
        long j2;
        l a;
        d();
        this.a.t();
        com.google.android.gms.common.internal.t.k(pVar);
        com.google.android.gms.common.internal.t.g(str);
        if (!o().D(str, r.Z)) {
            f().O().b("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        } else if (!"_iap".equals(pVar.a) && !"_iapx".equals(pVar.a)) {
            f().O().c("Generating a payload for this event is not available. package_name, event_name", str, pVar.a);
            return null;
        } else {
            w0.a F = com.google.android.gms.internal.measurement.w0.F();
            r().w0();
            try {
                f4 k0 = r().k0(str);
                if (k0 == null) {
                    f().O().b("Log and bundle not available. package_name", str);
                    return new byte[0];
                } else if (!k0.e0()) {
                    f().O().b("Log and bundle disabled. package_name", str);
                    return new byte[0];
                } else {
                    x0.a E = com.google.android.gms.internal.measurement.x0.R0().u(1).E("android");
                    if (!TextUtils.isEmpty(k0.t())) {
                        E.j0(k0.t());
                    }
                    if (!TextUtils.isEmpty(k0.X())) {
                        E.e0(k0.X());
                    }
                    if (!TextUtils.isEmpty(k0.T())) {
                        E.p0(k0.T());
                    }
                    if (k0.V() != -2147483648L) {
                        E.r0((int) k0.V());
                    }
                    E.i0(k0.Z()).F0(k0.d0());
                    if (com.google.android.gms.internal.measurement.ka.b() && o().D(k0.t(), r.r0)) {
                        if (!TextUtils.isEmpty(k0.A())) {
                            E.G0(k0.A());
                        } else if (!TextUtils.isEmpty(k0.G())) {
                            E.R0(k0.G());
                        } else if (!TextUtils.isEmpty(k0.D())) {
                            E.P0(k0.D());
                        }
                    } else if (!TextUtils.isEmpty(k0.A())) {
                        E.G0(k0.A());
                    } else if (!TextUtils.isEmpty(k0.D())) {
                        E.P0(k0.D());
                    }
                    E.t0(k0.b0());
                    if (this.a.q() && o().F(E.D0())) {
                        E.D0();
                        if (!TextUtils.isEmpty(null)) {
                            E.O0(null);
                        }
                    }
                    Pair<String, Boolean> v = n().v(k0.t());
                    if (k0.l() && v != null && !TextUtils.isEmpty((CharSequence) v.first)) {
                        E.u0(k((String) v.first, Long.toString(pVar.f7792d)));
                        Object obj = v.second;
                        if (obj != null) {
                            E.F(((Boolean) obj).booleanValue());
                        }
                    }
                    e().q();
                    x0.a S = E.S(Build.MODEL);
                    e().q();
                    S.L(Build.VERSION.RELEASE).h0((int) e().w()).W(e().x());
                    E.A0(k(k0.x(), Long.toString(pVar.f7792d)));
                    if (!TextUtils.isEmpty(k0.M())) {
                        E.J0(k0.M());
                    }
                    String t = k0.t();
                    List<s9> J = r().J(t);
                    Iterator<s9> it = J.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            s9Var = null;
                            break;
                        }
                        s9Var = it.next();
                        if ("_lte".equals(s9Var.f7861c)) {
                            break;
                        }
                    }
                    if (s9Var == null || s9Var.f7863e == null) {
                        s9 s9Var2 = new s9(t, "auto", "_lte", i().a(), 0L);
                        J.add(s9Var2);
                        r().U(s9Var2);
                    }
                    r9 q = q();
                    q.f().P().a("Checking account type status for ad personalization signals");
                    if (q.e().A()) {
                        String t2 = k0.t();
                        if (k0.l() && q.s().I(t2)) {
                            q.f().O().a("Turning off ad personalization due to account type");
                            Iterator<s9> it2 = J.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(it2.next().f7861c)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            J.add(new s9(t2, "auto", "_npa", q.i().a(), 1L));
                        }
                    }
                    com.google.android.gms.internal.measurement.b1[] b1VarArr = new com.google.android.gms.internal.measurement.b1[J.size()];
                    for (int i2 = 0; i2 < J.size(); i2++) {
                        b1.a w = com.google.android.gms.internal.measurement.b1.X().x(J.get(i2).f7861c).w(J.get(i2).f7862d);
                        q().L(w, J.get(i2).f7863e);
                        b1VarArr[i2] = (com.google.android.gms.internal.measurement.b1) ((com.google.android.gms.internal.measurement.n4) w.j());
                    }
                    E.K(Arrays.asList(b1VarArr));
                    Bundle l1 = pVar.f7790b.l1();
                    l1.putLong("_c", 1L);
                    f().O().a("Marking in-app purchase as real-time");
                    l1.putLong("_r", 1L);
                    l1.putString("_o", pVar.f7791c);
                    if (m().C0(E.D0())) {
                        m().N(l1, "_dbg", 1L);
                        m().N(l1, "_r", 1L);
                    }
                    l F2 = r().F(str, pVar.a);
                    if (F2 == null) {
                        f4Var = k0;
                        aVar = E;
                        aVar2 = F;
                        bundle = l1;
                        bArr = null;
                        a = new l(str, pVar.a, 0L, 0L, pVar.f7792d, 0L, null, null, null, null);
                        j2 = 0;
                    } else {
                        aVar = E;
                        f4Var = k0;
                        aVar2 = F;
                        bundle = l1;
                        bArr = null;
                        j2 = F2.f7729f;
                        a = F2.a(pVar.f7792d);
                    }
                    r().O(a);
                    m mVar = new m(this.a, pVar.f7791c, str, pVar.a, pVar.f7792d, j2, bundle);
                    t0.a G = com.google.android.gms.internal.measurement.t0.b0().w(mVar.f7752d).B(mVar.f7750b).G(mVar.f7753e);
                    Iterator<String> it3 = mVar.f7754f.iterator();
                    while (it3.hasNext()) {
                        String next = it3.next();
                        v0.a A = com.google.android.gms.internal.measurement.v0.c0().A(next);
                        q().K(A, mVar.f7754f.k1(next));
                        G.x(A);
                    }
                    x0.a aVar3 = aVar;
                    aVar3.y(G).A(com.google.android.gms.internal.measurement.y0.B().u(com.google.android.gms.internal.measurement.u0.B().u(a.f7726c).v(pVar.a)));
                    aVar3.R(p().y(f4Var.t(), Collections.emptyList(), aVar3.Y(), Long.valueOf(G.K()), Long.valueOf(G.K())));
                    if (G.J()) {
                        aVar3.J(G.K()).Q(G.K());
                    }
                    long R = f4Var.R();
                    int i3 = (R > 0L ? 1 : (R == 0L ? 0 : -1));
                    if (i3 != 0) {
                        aVar3.c0(R);
                    }
                    long P = f4Var.P();
                    if (P != 0) {
                        aVar3.T(P);
                    } else if (i3 != 0) {
                        aVar3.T(R);
                    }
                    f4Var.i0();
                    aVar3.m0((int) f4Var.f0()).n0(o().E()).x(i().a()).M(true);
                    w0.a aVar4 = aVar2;
                    aVar4.u(aVar3);
                    f4 f4Var2 = f4Var;
                    f4Var2.a(aVar3.f0());
                    f4Var2.q(aVar3.l0());
                    r().P(f4Var2);
                    r().x();
                    try {
                        return q().Y(((com.google.android.gms.internal.measurement.w0) ((com.google.android.gms.internal.measurement.n4) aVar4.j())).l());
                    } catch (IOException e2) {
                        f().H().c("Data loss. Failed to bundle and serialize. appId", x3.y(str), e2);
                        return bArr;
                    }
                }
            } catch (SecurityException e3) {
                f().O().b("app instance id encryption failed", e3.getMessage());
                return new byte[0];
            } catch (SecurityException e4) {
                f().O().b("Resettable device id encryption failed", e4.getMessage());
                return new byte[0];
            } finally {
                r().B0();
            }
        }
    }
}