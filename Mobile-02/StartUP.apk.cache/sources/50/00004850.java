package e.g.a.e.h.b;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.u;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public class a extends com.google.android.gms.common.internal.h<f> implements e.g.a.e.h.e {
    private final boolean G;
    private final com.google.android.gms.common.internal.d H;
    private final Bundle I;
    private Integer J;

    private a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.d dVar, Bundle bundle, d.a aVar, d.b bVar) {
        super(context, looper, 44, dVar, aVar, bVar);
        this.G = true;
        this.H = dVar;
        this.I = bundle;
        this.J = dVar.f();
    }

    public static Bundle m0(com.google.android.gms.common.internal.d dVar) {
        e.g.a.e.h.a j2 = dVar.j();
        Integer f2 = dVar.f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", dVar.a());
        if (f2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", f2.intValue());
        }
        if (j2 != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", j2.h());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", j2.g());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", j2.e());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", j2.f());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", j2.b());
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", j2.c());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", j2.i());
            if (j2.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", j2.a().longValue());
            }
            if (j2.d() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", j2.d().longValue());
            }
        }
        return bundle;
    }

    @Override // e.g.a.e.h.e
    public final void c(d dVar) {
        t.l(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c2 = this.H.c();
            ((f) B()).P0(new j(new u(c2, this.J.intValue(), "<<default account>>".equals(c2.name) ? com.google.android.gms.auth.api.signin.internal.c.b(x()).c() : null)), dVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                dVar.I(new l(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    @Override // e.g.a.e.h.e
    public final void g() {
        f(new c.d());
    }

    @Override // com.google.android.gms.common.internal.c
    protected String k() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected /* synthetic */ IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof f) {
            return (f) queryLocalInterface;
        }
        return new h(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int n() {
        return com.google.android.gms.common.h.a;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public boolean p() {
        return this.G;
    }

    @Override // com.google.android.gms.common.internal.c
    protected String q() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.c
    protected Bundle y() {
        if (!x().getPackageName().equals(this.H.h())) {
            this.I.putString("com.google.android.gms.signin.internal.realClientPackageName", this.H.h());
        }
        return this.I;
    }

    public a(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.d dVar, e.g.a.e.h.a aVar, d.a aVar2, d.b bVar) {
        this(context, looper, true, dVar, m0(dVar), aVar2, bVar);
    }
}