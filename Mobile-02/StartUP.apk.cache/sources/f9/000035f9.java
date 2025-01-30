package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.kc;
import com.google.android.gms.internal.measurement.rc;
import com.google.android.gms.internal.measurement.sc;
import com.google.android.gms.internal.measurement.xc;
import com.google.android.gms.internal.measurement.zc;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
@DynamiteApi
/* loaded from: classes2.dex */
public class AppMeasurementDynamiteService extends kc {
    b5 a = null;

    /* renamed from: b  reason: collision with root package name */
    private Map<Integer, f6> f7474b = new c.e.a();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
    /* loaded from: classes2.dex */
    class a implements f6 {
        private sc a;

        a(sc scVar) {
            this.a = scVar;
        }

        @Override // com.google.android.gms.measurement.internal.f6
        public final void a(String str, String str2, Bundle bundle, long j2) {
            try {
                this.a.l0(str, str2, bundle, j2);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.a.f().K().b("Event listener threw exception", e2);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.0 */
    /* loaded from: classes2.dex */
    class b implements c6 {
        private sc a;

        b(sc scVar) {
            this.a = scVar;
        }

        @Override // com.google.android.gms.measurement.internal.c6
        public final void a(String str, String str2, Bundle bundle, long j2) {
            try {
                this.a.l0(str, str2, bundle, j2);
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.a.f().K().b("Event interceptor threw exception", e2);
            }
        }
    }

    private final void p() {
        if (this.a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void q(rc rcVar, String str) {
        this.a.H().R(rcVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void beginAdUnitExposure(String str, long j2) throws RemoteException {
        p();
        this.a.T().A(str, j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        p();
        this.a.G().z0(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void endAdUnitExposure(String str, long j2) throws RemoteException {
        p();
        this.a.T().E(str, j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void generateEventId(rc rcVar) throws RemoteException {
        p();
        this.a.H().P(rcVar, this.a.H().D0());
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getAppInstanceId(rc rcVar) throws RemoteException {
        p();
        this.a.l().A(new g6(this, rcVar));
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getCachedAppInstanceId(rc rcVar) throws RemoteException {
        p();
        q(rcVar, this.a.G().g0());
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getConditionalUserProperties(String str, String str2, rc rcVar) throws RemoteException {
        p();
        this.a.l().A(new x9(this, rcVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getCurrentScreenClass(rc rcVar) throws RemoteException {
        p();
        q(rcVar, this.a.G().j0());
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getCurrentScreenName(rc rcVar) throws RemoteException {
        p();
        q(rcVar, this.a.G().i0());
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getGmpAppId(rc rcVar) throws RemoteException {
        p();
        q(rcVar, this.a.G().k0());
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getMaxUserProperties(String str, rc rcVar) throws RemoteException {
        p();
        this.a.G();
        com.google.android.gms.common.internal.t.g(str);
        this.a.H().O(rcVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getTestFlag(rc rcVar, int i2) throws RemoteException {
        p();
        if (i2 == 0) {
            this.a.H().R(rcVar, this.a.G().c0());
        } else if (i2 == 1) {
            this.a.H().P(rcVar, this.a.G().d0().longValue());
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.a.H().O(rcVar, this.a.G().e0().intValue());
            } else if (i2 != 4) {
            } else {
                this.a.H().T(rcVar, this.a.G().b0().booleanValue());
            }
        } else {
            v9 H = this.a.H();
            double doubleValue = this.a.G().f0().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                rcVar.g(bundle);
            } catch (RemoteException e2) {
                H.a.f().K().b("Error returning double value to wrapper", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void getUserProperties(String str, String str2, boolean z, rc rcVar) throws RemoteException {
        p();
        this.a.l().A(new g7(this, rcVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void initForTests(Map map) throws RemoteException {
        p();
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void initialize(com.google.android.gms.dynamic.a aVar, zc zcVar, long j2) throws RemoteException {
        Context context = (Context) com.google.android.gms.dynamic.b.q(aVar);
        b5 b5Var = this.a;
        if (b5Var == null) {
            this.a = b5.a(context, zcVar, Long.valueOf(j2));
        } else {
            b5Var.f().K().a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void isDataCollectionEnabled(rc rcVar) throws RemoteException {
        p();
        this.a.l().A(new i9(this, rcVar));
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        p();
        this.a.G().U(str, str2, bundle, z, z2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void logEventAndBundle(String str, String str2, Bundle bundle, rc rcVar, long j2) throws RemoteException {
        p();
        com.google.android.gms.common.internal.t.g(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.a.l().A(new h8(this, rcVar, new p(str2, new o(bundle), "app", j2), str));
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void logHealthData(int i2, String str, com.google.android.gms.dynamic.a aVar, com.google.android.gms.dynamic.a aVar2, com.google.android.gms.dynamic.a aVar3) throws RemoteException {
        p();
        this.a.f().C(i2, true, false, str, aVar == null ? null : com.google.android.gms.dynamic.b.q(aVar), aVar2 == null ? null : com.google.android.gms.dynamic.b.q(aVar2), aVar3 != null ? com.google.android.gms.dynamic.b.q(aVar3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivityCreated(com.google.android.gms.dynamic.a aVar, Bundle bundle, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivityCreated((Activity) com.google.android.gms.dynamic.b.q(aVar), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivityDestroyed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivityDestroyed((Activity) com.google.android.gms.dynamic.b.q(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivityPaused(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivityPaused((Activity) com.google.android.gms.dynamic.b.q(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivityResumed(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivityResumed((Activity) com.google.android.gms.dynamic.b.q(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivitySaveInstanceState(com.google.android.gms.dynamic.a aVar, rc rcVar, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        Bundle bundle = new Bundle();
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivitySaveInstanceState((Activity) com.google.android.gms.dynamic.b.q(aVar), bundle);
        }
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning bundle value to wrapper", e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivityStarted(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivityStarted((Activity) com.google.android.gms.dynamic.b.q(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void onActivityStopped(com.google.android.gms.dynamic.a aVar, long j2) throws RemoteException {
        p();
        c7 c7Var = this.a.G().f7639c;
        if (c7Var != null) {
            this.a.G().a0();
            c7Var.onActivityStopped((Activity) com.google.android.gms.dynamic.b.q(aVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void performAction(Bundle bundle, rc rcVar, long j2) throws RemoteException {
        p();
        rcVar.g(null);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void registerOnMeasurementEventListener(sc scVar) throws RemoteException {
        p();
        f6 f6Var = this.f7474b.get(Integer.valueOf(scVar.a()));
        if (f6Var == null) {
            f6Var = new a(scVar);
            this.f7474b.put(Integer.valueOf(scVar.a()), f6Var);
        }
        this.a.G().K(f6Var);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void resetAnalyticsData(long j2) throws RemoteException {
        p();
        this.a.G().A0(j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        p();
        if (bundle == null) {
            this.a.f().H().a("Conditional user property must not be null");
        } else {
            this.a.G().I(bundle, j2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setCurrentScreen(com.google.android.gms.dynamic.a aVar, String str, String str2, long j2) throws RemoteException {
        p();
        this.a.P().G((Activity) com.google.android.gms.dynamic.b.q(aVar), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        p();
        this.a.G().w0(z);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setDefaultEventParameters(Bundle bundle) {
        p();
        final i6 G = this.a.G();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        G.l().A(new Runnable(G, bundle2) { // from class: com.google.android.gms.measurement.internal.h6
            private final i6 a;

            /* renamed from: b  reason: collision with root package name */
            private final Bundle f7622b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = G;
                this.f7622b = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i6 i6Var = this.a;
                Bundle bundle3 = this.f7622b;
                if (com.google.android.gms.internal.measurement.la.b() && i6Var.o().u(r.R0)) {
                    if (bundle3 == null) {
                        i6Var.n().E.b(new Bundle());
                        return;
                    }
                    Bundle a2 = i6Var.n().E.a();
                    for (String str : bundle3.keySet()) {
                        Object obj = bundle3.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            i6Var.m();
                            if (v9.b0(obj)) {
                                i6Var.m().K(27, null, null, 0);
                            }
                            i6Var.f().M().c("Invalid default event parameter type. Name, value", str, obj);
                        } else if (v9.B0(str)) {
                            i6Var.f().M().b("Invalid default event parameter name. Name", str);
                        } else if (obj == null) {
                            a2.remove(str);
                        } else if (i6Var.m().g0("param", str, 100, obj)) {
                            i6Var.m().N(a2, str, obj);
                        }
                    }
                    i6Var.m();
                    if (v9.Z(a2, i6Var.o().B())) {
                        i6Var.m().K(26, null, null, 0);
                        i6Var.f().M().a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                    i6Var.n().E.b(a2);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setEventInterceptor(sc scVar) throws RemoteException {
        p();
        i6 G = this.a.G();
        b bVar = new b(scVar);
        G.b();
        G.y();
        G.l().A(new r6(G, bVar));
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setInstanceIdProvider(xc xcVar) throws RemoteException {
        p();
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setMeasurementEnabled(boolean z, long j2) throws RemoteException {
        p();
        this.a.G().Z(z);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setMinimumSessionDuration(long j2) throws RemoteException {
        p();
        this.a.G().G(j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setSessionTimeoutDuration(long j2) throws RemoteException {
        p();
        this.a.G().o0(j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setUserId(String str, long j2) throws RemoteException {
        p();
        this.a.G().X(null, "_id", str, true, j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void setUserProperty(String str, String str2, com.google.android.gms.dynamic.a aVar, boolean z, long j2) throws RemoteException {
        p();
        this.a.G().X(str, str2, com.google.android.gms.dynamic.b.q(aVar), z, j2);
    }

    @Override // com.google.android.gms.internal.measurement.h9
    public void unregisterOnMeasurementEventListener(sc scVar) throws RemoteException {
        p();
        f6 remove = this.f7474b.remove(Integer.valueOf(scVar.a()));
        if (remove == null) {
            remove = new a(scVar);
        }
        this.a.G().r0(remove);
    }
}