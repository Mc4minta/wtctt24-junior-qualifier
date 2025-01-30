package e.j.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.wallet.common.annotations.AppCoreScoped;

/* compiled from: AppPrefs.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    private final Context f13681b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.h f13682c;

    /* compiled from: AppPrefs.kt */
    /* renamed from: e.j.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0322a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<SharedPreferences> {
        C0322a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final SharedPreferences invoke() {
            return a.this.f13681b.getSharedPreferences("usm", 0);
        }
    }

    public a(Context context) {
        kotlin.h b2;
        kotlin.jvm.internal.m.g(context, "context");
        this.f13681b = context;
        b2 = kotlin.k.b(new C0322a());
        this.f13682c = b2;
    }

    private final SharedPreferences t() {
        Object value = this.f13682c.getValue();
        kotlin.jvm.internal.m.f(value, "<get-prefs>(...)");
        return (SharedPreferences) value;
    }

    @Override // e.j.j.b
    public boolean a() {
        return t().getBoolean("hasBackedUpPhraseToCloud", false);
    }

    @Override // e.j.j.b
    public boolean b() {
        return t().getBoolean("hasUserActivated", false);
    }

    @Override // e.j.j.b
    public boolean c() {
        return t().getBoolean("hasBackedUpPhrase", false);
    }

    @Override // e.j.j.b
    public void d(int i2) {
        t().edit().putInt("hasLatestVersion", i2).apply();
    }

    @Override // e.j.j.b
    public boolean e() {
        return t().getBoolean("hasSeenGooglePlayServicesWarning", false);
    }

    @Override // e.j.j.b
    public boolean f() {
        return t().getBoolean("isWebViewDebuggable", false);
    }

    @Override // e.j.j.b
    public void g(boolean z) {
        t().edit().putBoolean("isWebViewDebuggable", z).apply();
    }

    @Override // e.j.j.b
    public void h(boolean z) {
        t().edit().putBoolean("hasBackedUpPhraseToCloud", z).apply();
    }

    @Override // e.j.j.b
    public void i(String notificationKey) {
        kotlin.jvm.internal.m.g(notificationKey, "notificationKey");
        t().edit().putBoolean(notificationKey, true).apply();
    }

    @Override // e.j.j.b
    public boolean j(String notificationKey) {
        kotlin.jvm.internal.m.g(notificationKey, "notificationKey");
        return t().getBoolean(notificationKey, false);
    }

    @Override // e.j.j.b
    public void k(boolean z) {
        t().edit().putBoolean("isNewUser", z).apply();
    }

    @Override // e.j.j.b
    public int l() {
        return t().getInt("sessionNumber", 0);
    }

    @Override // e.j.j.b
    public void m() {
        t().edit().putBoolean("hasSeenGooglePlayServicesWarning", true).apply();
    }

    @Override // e.j.j.b
    public boolean n() {
        return t().getBoolean("hasOnboarded", false);
    }

    @Override // e.j.j.b
    public void o(boolean z) {
        t().edit().putBoolean("hasUserActivated", z).apply();
    }

    @Override // e.j.j.b
    public boolean p() {
        return t().getBoolean("isNewUser", false);
    }

    @Override // e.j.j.b
    @SuppressLint({"ApplySharedPref"})
    public void q() {
        t().edit().putInt("sessionNumber", l() + 1).commit();
    }

    @Override // e.j.j.b
    public void r(boolean z) {
        t().edit().putBoolean("hasBackedUpPhrase", z).apply();
    }
}