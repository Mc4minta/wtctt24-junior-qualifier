package e.j.n;

import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.user.repositories.UserRepository;

/* compiled from: PickUsernameViewModel.kt */
/* loaded from: classes2.dex */
public final class w2 extends androidx.lifecycle.b0 {
    private final MnemonicRepositoryInterface a;

    /* renamed from: b */
    private final UserRepository f13994b;

    public w2(MnemonicRepositoryInterface mnemonicRepository, UserRepository userRepository) {
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        this.a = mnemonicRepository;
        this.f13994b = userRepository;
    }

    public static /* synthetic */ h3 b(String str, Boolean bool) {
        return e(str, bool);
    }

    public static final h3 e(String query, Boolean available) {
        kotlin.jvm.internal.m.g(query, "$query");
        kotlin.jvm.internal.m.g(available, "available");
        return new h3(available.booleanValue(), query);
    }

    public final h.c.b0<String> a() {
        return this.a.createMnemonic();
    }

    public final h.c.b0<Boolean> c(String query) {
        kotlin.jvm.internal.m.g(query, "query");
        return this.f13994b.validateUsername(query);
    }

    public final h.c.b0<h3> d(final String query) {
        kotlin.jvm.internal.m.g(query, "query");
        h.c.b0 map = this.f13994b.validateUsername(query).map(new h.c.m0.n() { // from class: e.j.n.u0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return w2.b(query, (Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "userRepository\n        .validateUsername(query)\n        .map { available -> Username(available, query) }");
        return map;
    }
}