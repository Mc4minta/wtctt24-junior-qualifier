package e.j.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.toshi.model.local.authentication.AuthenticationMethod;
import e.j.f.s;

/* compiled from: LockPrefs.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class d implements e {

    /* renamed from: b  reason: collision with root package name */
    private final Context f13683b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f13684c;

    /* compiled from: LockPrefs.kt */
    /* loaded from: classes2.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<SharedPreferences> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final SharedPreferences invoke() {
            return d.this.f13683b.getSharedPreferences("lp", 0);
        }
    }

    public d(Context context) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(context, "context");
        this.f13683b = context;
        b2 = kotlin.k.b(new a());
        this.f13684c = b2;
    }

    private final SharedPreferences d() {
        return (SharedPreferences) this.f13684c.getValue();
    }

    @Override // e.j.j.e
    public void a(boolean z) {
        SharedPreferences prefs = d();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        s.a(prefs, "auth_required_for_app_access", z);
    }

    @Override // e.j.j.e
    public boolean b() {
        return d().getBoolean("auth_required_for_app_access", false);
    }

    @Override // e.j.j.e
    public AuthenticationMethod getAuthenticationMethod() {
        return AuthenticationMethod.Companion.get(d().getInt("authentication_type", 0));
    }

    @Override // e.j.j.e
    public boolean isTxAuthRequired() {
        return d().getBoolean("auth_required_for_transactions", true);
    }

    @Override // e.j.j.e
    public void setAuthenticationMethod(AuthenticationMethod authenticationMethod) {
        SharedPreferences prefs = d();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        s.c(prefs, "authentication_type", authenticationMethod == null ? 0 : authenticationMethod.getRawValue());
    }

    @Override // e.j.j.e
    public void setTxAuthRequired(boolean z) {
        SharedPreferences prefs = d();
        kotlin.jvm.internal.m.f(prefs, "prefs");
        s.a(prefs, "auth_required_for_transactions", z);
    }
}