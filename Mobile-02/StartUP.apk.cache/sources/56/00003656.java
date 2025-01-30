package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class h5 extends s3 {
    private final j9 a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f7620b;

    /* renamed from: c  reason: collision with root package name */
    private String f7621c;

    public h5(j9 j9Var) {
        this(j9Var, null);
    }

    private final void Y0(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f7620b == null) {
                        if (!"com.google.android.gms".equals(this.f7621c) && !com.google.android.gms.common.util.o.a(this.a.h(), Binder.getCallingUid()) && !com.google.android.gms.common.i.a(this.a.h()).c(Binder.getCallingUid())) {
                            z2 = false;
                            this.f7620b = Boolean.valueOf(z2);
                        }
                        z2 = true;
                        this.f7620b = Boolean.valueOf(z2);
                    }
                    if (this.f7620b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.a.f().H().b("Measurement Service called with invalid calling package. appId", x3.y(str));
                    throw e2;
                }
            }
            if (this.f7621c == null && com.google.android.gms.common.h.l(this.a.h(), Binder.getCallingUid(), str)) {
                this.f7621c = str;
            }
            if (str.equals(this.f7621c)) {
                return;
            }
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
        this.a.f().H().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    private final void a1(z9 z9Var, boolean z) {
        com.google.android.gms.common.internal.t.k(z9Var);
        Y0(z9Var.a, false);
        this.a.a0().h0(z9Var.f7972b, z9Var.v, z9Var.z);
    }

    private final void q(Runnable runnable) {
        com.google.android.gms.common.internal.t.k(runnable);
        if (this.a.l().I()) {
            runnable.run();
        } else {
            this.a.l().A(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<q9> E(String str, String str2, String str3, boolean z) {
        Y0(str, true);
        try {
            List<s9> list = (List) this.a.l().x(new l5(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (s9 s9Var : list) {
                if (z || !v9.B0(s9Var.f7861c)) {
                    arrayList.add(new q9(s9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.f().H().c("Failed to get user properties as. appId", x3.y(str), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final byte[] G0(p pVar, String str) {
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(pVar);
        Y0(str, true);
        this.a.f().O().b("Log and bundle. event", this.a.Z().x(pVar.a));
        long nanoTime = this.a.i().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.a.l().C(new r5(this, pVar, str)).get();
            if (bArr == null) {
                this.a.f().H().b("Log and bundle returned null. appId", x3.y(str));
                bArr = new byte[0];
            }
            this.a.f().O().d("Log and bundle processed. event, size, time_ms", this.a.Z().x(pVar.a), Integer.valueOf(bArr.length), Long.valueOf((this.a.i().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.f().H().d("Failed to log and bundle. appId, event, error", x3.y(str), this.a.Z().x(pVar.a), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final String M(z9 z9Var) {
        a1(z9Var, false);
        return this.a.T(z9Var);
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void R(long j2, String str, String str2, String str3) {
        q(new v5(this, str2, str3, str, j2));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void U(z9 z9Var) {
        Y0(z9Var.a, false);
        q(new m5(this, z9Var));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<ia> V(String str, String str2, String str3) {
        Y0(str, true);
        try {
            return (List) this.a.l().x(new n5(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.a.f().H().b("Failed to get conditional user properties as", e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<ia> W(String str, String str2, z9 z9Var) {
        a1(z9Var, false);
        try {
            return (List) this.a.l().x(new k5(this, z9Var, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.a.f().H().b("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p Z0(p pVar, z9 z9Var) {
        o oVar;
        boolean z = false;
        if ("_cmp".equals(pVar.a) && (oVar = pVar.f7790b) != null && oVar.i1() != 0) {
            String o1 = pVar.f7790b.o1("_cis");
            if (!TextUtils.isEmpty(o1) && (("referrer broadcast".equals(o1) || "referrer API".equals(o1)) && this.a.H().D(z9Var.a, r.T))) {
                z = true;
            }
        }
        if (z) {
            this.a.f().N().b("Event has been filtered ", pVar.toString());
            return new p("_cmpx", pVar.f7790b, pVar.f7791c, pVar.f7792d);
        }
        return pVar;
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<q9> e0(String str, String str2, boolean z, z9 z9Var) {
        a1(z9Var, false);
        try {
            List<s9> list = (List) this.a.l().x(new i5(this, z9Var, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (s9 s9Var : list) {
                if (z || !v9.B0(s9Var.f7861c)) {
                    arrayList.add(new q9(s9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.f().H().c("Failed to query user properties. appId", x3.y(z9Var.a), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final List<q9> f0(z9 z9Var, boolean z) {
        a1(z9Var, false);
        try {
            List<s9> list = (List) this.a.l().x(new t5(this, z9Var)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (s9 s9Var : list) {
                if (z || !v9.B0(s9Var.f7861c)) {
                    arrayList.add(new q9(s9Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.a.f().H().c("Failed to get user properties. appId", x3.y(z9Var.a), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void g0(z9 z9Var) {
        a1(z9Var, false);
        q(new s5(this, z9Var));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void m0(ia iaVar) {
        com.google.android.gms.common.internal.t.k(iaVar);
        com.google.android.gms.common.internal.t.k(iaVar.f7654c);
        Y0(iaVar.a, true);
        q(new j5(this, new ia(iaVar)));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void n0(p pVar, z9 z9Var) {
        com.google.android.gms.common.internal.t.k(pVar);
        a1(z9Var, false);
        q(new p5(this, pVar, z9Var));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void r(ia iaVar, z9 z9Var) {
        com.google.android.gms.common.internal.t.k(iaVar);
        com.google.android.gms.common.internal.t.k(iaVar.f7654c);
        a1(z9Var, false);
        ia iaVar2 = new ia(iaVar);
        iaVar2.a = z9Var.a;
        q(new u5(this, iaVar2, z9Var));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void r0(p pVar, String str, String str2) {
        com.google.android.gms.common.internal.t.k(pVar);
        com.google.android.gms.common.internal.t.g(str);
        Y0(str, true);
        q(new o5(this, pVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void t0(z9 z9Var) {
        a1(z9Var, false);
        q(new g5(this, z9Var));
    }

    @Override // com.google.android.gms.measurement.internal.p3
    public final void v0(q9 q9Var, z9 z9Var) {
        com.google.android.gms.common.internal.t.k(q9Var);
        a1(z9Var, false);
        q(new q5(this, q9Var, z9Var));
    }

    private h5(j9 j9Var, String str) {
        com.google.android.gms.common.internal.t.k(j9Var);
        this.a = j9Var;
        this.f7621c = null;
    }
}