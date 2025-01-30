package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rc;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class s7 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    private final l8 f7852c;

    /* renamed from: d  reason: collision with root package name */
    private p3 f7853d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f7854e;

    /* renamed from: f  reason: collision with root package name */
    private final h f7855f;

    /* renamed from: g  reason: collision with root package name */
    private final f9 f7856g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Runnable> f7857h;

    /* renamed from: i  reason: collision with root package name */
    private final h f7858i;

    /* JADX INFO: Access modifiers changed from: protected */
    public s7(b5 b5Var) {
        super(b5Var);
        this.f7857h = new ArrayList();
        this.f7856g = new f9(b5Var.i());
        this.f7852c = new l8(this);
        this.f7855f = new r7(this, b5Var);
        this.f7858i = new c8(this, b5Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ p3 C(s7 s7Var, p3 p3Var) {
        s7Var.f7853d = null;
        return null;
    }

    private final z9 E(boolean z) {
        g();
        return r().C(z ? f().Q() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(ComponentName componentName) {
        d();
        if (this.f7853d != null) {
            this.f7853d = null;
            f().P().b("Disconnected from device MeasurementService", componentName);
            d();
            a0();
        }
    }

    private final void R(Runnable runnable) throws IllegalStateException {
        d();
        if (W()) {
            runnable.run();
        } else if (this.f7857h.size() >= 1000) {
            f().H().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f7857h.add(runnable);
            this.f7858i.c(60000L);
            a0();
        }
    }

    private final boolean e0() {
        g();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        d();
        this.f7856g.a();
        this.f7855f.c(r.K.a(null).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean g0() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.s7.g0():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        d();
        if (W()) {
            f().P().a("Inactivity, disconnecting from the service");
            c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        d();
        f().P().b("Processing queued up service tasks", Integer.valueOf(this.f7857h.size()));
        for (Runnable runnable : this.f7857h) {
            try {
                runnable.run();
            } catch (Exception e2) {
                f().H().b("Task exception while flushing queue", e2);
            }
        }
        this.f7857h.clear();
        this.f7858i.e();
    }

    @Override // com.google.android.gms.measurement.internal.f5
    protected final boolean B() {
        return false;
    }

    public final void G(rc rcVar) {
        d();
        y();
        R(new y7(this, E(false), rcVar));
    }

    public final void H(rc rcVar, p pVar, String str) {
        d();
        y();
        if (m().v(com.google.android.gms.common.h.a) != 0) {
            f().K().a("Not bundling data. Service unavailable or out of date");
            m().U(rcVar, new byte[0]);
            return;
        }
        R(new z7(this, pVar, str, rcVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(rc rcVar, String str, String str2) {
        d();
        y();
        R(new f8(this, str, str2, E(false), rcVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(rc rcVar, String str, String str2, boolean z) {
        d();
        y();
        R(new i8(this, str, str2, z, E(false), rcVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(p pVar, String str) {
        com.google.android.gms.common.internal.t.k(pVar);
        d();
        y();
        boolean e0 = e0();
        R(new e8(this, e0, e0 && u().F(pVar), pVar, E(true), str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(p3 p3Var) {
        d();
        com.google.android.gms.common.internal.t.k(p3Var);
        this.f7853d = p3Var;
        f0();
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(p3 p3Var, com.google.android.gms.common.internal.safeparcel.a aVar, z9 z9Var) {
        int i2;
        List<com.google.android.gms.common.internal.safeparcel.a> D;
        d();
        b();
        y();
        boolean e0 = e0();
        int i3 = 0;
        int i4 = 100;
        while (i3 < 1001 && i4 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!e0 || (D = u().D(100)) == null) {
                i2 = 0;
            } else {
                arrayList.addAll(D);
                i2 = D.size();
            }
            if (aVar != null && i2 < 100) {
                arrayList.add(aVar);
            }
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                com.google.android.gms.common.internal.safeparcel.a aVar2 = (com.google.android.gms.common.internal.safeparcel.a) obj;
                if (aVar2 instanceof p) {
                    try {
                        p3Var.n0((p) aVar2, z9Var);
                    } catch (RemoteException e2) {
                        f().H().b("Failed to send event to the service", e2);
                    }
                } else if (aVar2 instanceof q9) {
                    try {
                        p3Var.v0((q9) aVar2, z9Var);
                    } catch (RemoteException e3) {
                        f().H().b("Failed to send user property to the service", e3);
                    }
                } else if (aVar2 instanceof ia) {
                    try {
                        p3Var.r((ia) aVar2, z9Var);
                    } catch (RemoteException e4) {
                        f().H().b("Failed to send conditional user property to the service", e4);
                    }
                } else {
                    f().H().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i3++;
            i4 = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(o7 o7Var) {
        d();
        y();
        R(new a8(this, o7Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(q9 q9Var) {
        d();
        y();
        R(new u7(this, e0() && u().G(q9Var), q9Var, E(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(ia iaVar) {
        com.google.android.gms.common.internal.t.k(iaVar);
        d();
        y();
        g();
        R(new d8(this, true, u().H(iaVar), new ia(iaVar), E(true), iaVar));
    }

    public final void S(AtomicReference<String> atomicReference) {
        d();
        y();
        R(new v7(this, atomicReference, E(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T(AtomicReference<List<ia>> atomicReference, String str, String str2, String str3) {
        d();
        y();
        R(new g8(this, atomicReference, str, str2, str3, E(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(AtomicReference<List<q9>> atomicReference, String str, String str2, String str3, boolean z) {
        d();
        y();
        R(new j8(this, atomicReference, str, str2, str3, z, E(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void V(AtomicReference<List<q9>> atomicReference, boolean z) {
        d();
        y();
        R(new t7(this, atomicReference, E(false), z));
    }

    public final boolean W() {
        d();
        y();
        return this.f7853d != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X() {
        d();
        y();
        R(new b8(this, E(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y() {
        d();
        b();
        y();
        z9 E = E(false);
        if (e0()) {
            u().I();
        }
        R(new w7(this, E));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z() {
        d();
        y();
        z9 E = E(true);
        u().J();
        R(new x7(this, E));
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a0() {
        d();
        y();
        if (W()) {
            return;
        }
        if (g0()) {
            this.f7852c.d();
        } else if (o().R()) {
        } else {
            g();
            List<ResolveInfo> queryIntentServices = h().getPackageManager().queryIntentServices(new Intent().setClassName(h(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context h2 = h();
                g();
                intent.setComponent(new ComponentName(h2, "com.google.android.gms.measurement.AppMeasurementService"));
                this.f7852c.b(intent);
                return;
            }
            f().H().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean b0() {
        return this.f7854e;
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public final void c0() {
        d();
        y();
        this.f7852c.a();
        try {
            com.google.android.gms.common.stats.a.b().c(h(), this.f7852c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f7853d = null;
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d0() {
        d();
        y();
        return !g0() || m().J0() >= 200900;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ a p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ i6 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u3 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ s7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ n7 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ t3 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u8 v() {
        return super.v();
    }
}