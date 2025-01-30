package e.j.l.p;

import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.user.extensions.StoreKeys_UserKt;
import com.toshi.model.local.authentication.AuthenticationMethod;
import java.security.Provider;
import javax.crypto.Cipher;
import kotlin.jvm.internal.m;

/* compiled from: CryptoErrorUtil.kt */
/* loaded from: classes2.dex */
public final class b {
    private final e.j.j.b a;

    /* renamed from: b  reason: collision with root package name */
    private final e.j.j.e f13725b;

    /* renamed from: c  reason: collision with root package name */
    private final StoreInterface f13726c;

    public b(e.j.j.b appPrefs, e.j.j.e lockPrefs, StoreInterface store) {
        m.g(appPrefs, "appPrefs");
        m.g(lockPrefs, "lockPrefs");
        m.g(store, "store");
        this.a = appPrefs;
        this.f13725b = lockPrefs;
        this.f13726c = store;
    }

    private final a a() {
        return new a(Boolean.valueOf(this.a.n()), Boolean.valueOf(this.a.c()), Boolean.valueOf(!this.f13726c.has(StoreKeys_UserKt.getActiveUser(StoreKeys.INSTANCE))));
    }

    private final AuthenticationMethod b() {
        return this.f13725b.getAuthenticationMethod();
    }

    private final f c(Cipher cipher, AuthenticationMethod authenticationMethod, a aVar) {
        String algorithm = cipher.getAlgorithm();
        Integer valueOf = Integer.valueOf(cipher.getBlockSize());
        Provider provider = cipher.getProvider();
        return new f(algorithm, valueOf, provider == null ? null : provider.getName(), authenticationMethod == null ? null : authenticationMethod.name(), aVar.b(), aVar.a(), aVar.c());
    }

    public final void d(String message, Exception e2, Cipher cipher) {
        m.g(message, "message");
        m.g(e2, "e");
        m.g(cipher, "cipher");
        try {
            f c2 = c(cipher, b(), a());
            l.a.a.f(e2, message + ": " + c2, new Object[0]);
        } catch (Error e3) {
            l.a.a.f(e3, message + ": " + e3, new Object[0]);
        }
    }
}