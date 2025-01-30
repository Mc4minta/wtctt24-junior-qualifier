package e.j.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.models.ConsumerAuthToken;
import kotlin.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.k;

/* compiled from: ConsumerOAuthPrefs.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class a {
    public static final C0316a a = new C0316a(null);

    /* renamed from: b  reason: collision with root package name */
    private final Context f13521b;

    /* renamed from: c  reason: collision with root package name */
    private final h f13522c;

    /* compiled from: ConsumerOAuthPrefs.kt */
    /* renamed from: e.j.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0316a {
        private C0316a() {
        }

        public /* synthetic */ C0316a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConsumerOAuthPrefs.kt */
    /* loaded from: classes2.dex */
    static final class b extends o implements kotlin.e0.c.a<SharedPreferences> {
        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.e0.c.a
        public final SharedPreferences invoke() {
            return a.this.f13521b.getSharedPreferences("consumer_prefs", 0);
        }
    }

    public a(Context context) {
        h b2;
        m.g(context, "context");
        this.f13521b = context;
        b2 = k.b(new b());
        this.f13522c = b2;
    }

    private final SharedPreferences d() {
        return (SharedPreferences) this.f13522c.getValue();
    }

    private final ConsumerAuthToken e() {
        String string;
        String string2;
        String string3;
        String string4 = d().getString("access_token", null);
        if (string4 == null || (string = d().getString("token_type", null)) == null) {
            return null;
        }
        long j2 = d().getLong("expires_in", -1L);
        if (j2 < 0 || (string2 = d().getString(ApiConstants.REFRESH_TOKEN, null)) == null || (string3 = d().getString("scope", null)) == null) {
            return null;
        }
        return new ConsumerAuthToken(string4, string, j2, string2, string3);
    }

    public final void b() {
        d().edit().clear().apply();
    }

    public final ConsumerAuthToken c() {
        return e();
    }
}