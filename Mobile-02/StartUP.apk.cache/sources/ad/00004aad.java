package e.j.n;

import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCore_wordListEnglishKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.common.exceptions.RPCException;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.toshi.exception.InvalidMasterSeedException;
import com.toshi.exception.InvalidOnboardingStateException;
import com.toshi.model.local.OnboardingState;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: SignInViewModel.kt */
/* loaded from: classes2.dex */
public final class d3 extends androidx.lifecycle.b0 {
    private final MnemonicRepositoryInterface a;

    /* renamed from: b */
    private final UserRepository f13821b;

    /* renamed from: c */
    private final h.c.a0 f13822c;

    /* renamed from: d */
    private final int f13823d;

    /* renamed from: e */
    private final kotlin.h f13824e;

    /* renamed from: f */
    private final kotlin.h f13825f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SignInViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.a<e.j.l.w.a> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final e.j.l.w.a invoke() {
            return new e.j.l.w.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SignInViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.jvm.internal.o implements kotlin.e0.c.a<List<? extends String>> {
        public static final b a = new b();

        b() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        public final List<? extends String> invoke() {
            return CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion);
        }
    }

    public d3(MnemonicRepositoryInterface mnemonicRepository, UserRepository userRepository) {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        kotlin.jvm.internal.m.g(userRepository, "userRepository");
        this.a = mnemonicRepository;
        this.f13821b = userRepository;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.f13822c = c2;
        this.f13823d = 6;
        b2 = kotlin.k.b(a.a);
        this.f13824e = b2;
        b3 = kotlin.k.b(b.a);
        this.f13825f = b3;
    }

    private final List<String> b(String str) {
        List<String> g2;
        List<String> b2 = c().b(f(), str, this.f13823d);
        if (b2 == null) {
            g2 = kotlin.a0.r.g();
            return g2;
        }
        return b2;
    }

    private final e.j.l.w.a c() {
        return (e.j.l.w.a) this.f13824e.getValue();
    }

    public static final List e(d3 this$0, String query) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(query, "$query");
        return this$0.b(query);
    }

    public static /* synthetic */ kotlin.o h(Throwable th) {
        return o(th);
    }

    public static /* synthetic */ List i(d3 d3Var, String str) {
        return e(d3Var, str);
    }

    public static /* synthetic */ kotlin.o j(User user) {
        return n(user);
    }

    public static /* synthetic */ h.c.h0 k(d3 d3Var, String str, String str2) {
        return m(d3Var, str, str2);
    }

    public static final h.c.h0 m(d3 this$0, String mnemonic, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f13821b.signIn(mnemonic);
    }

    public static final kotlin.o n(User it) {
        kotlin.jvm.internal.m.g(it, "it");
        return new kotlin.o(OnboardingState.EXISTING_USER, OptionalKt.toOptional(it.getUsername()));
    }

    public static final kotlin.o o(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        if (it instanceof InvalidMasterSeedException) {
            return new kotlin.o(OnboardingState.INVALID_MNEMONIC, OptionalKt.toOptional(null));
        }
        RPCException rPCException = it instanceof RPCException ? (RPCException) it : null;
        if (kotlin.jvm.internal.m.c(rPCException == null ? null : rPCException.getCode(), RPCException.ErrorCodes.invalidAddress)) {
            return new kotlin.o(OnboardingState.NEW_USER, OptionalKt.toOptional(null));
        }
        throw new InvalidOnboardingStateException("Error while validating new recovery phrase");
    }

    public final boolean a(String query) {
        kotlin.jvm.internal.m.g(query, "query");
        List<String> b2 = c().b(f(), query, this.f13823d);
        if (b2 == null) {
            return false;
        }
        return !b2.isEmpty();
    }

    public final h.c.b0<List<String>> d(final String query) {
        kotlin.jvm.internal.m.g(query, "query");
        h.c.b0<List<String>> subscribeOn = h.c.b0.fromCallable(new Callable() { // from class: e.j.n.i1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d3.i(d3.this, query);
            }
        }).subscribeOn(this.f13822c);
        kotlin.jvm.internal.m.f(subscribeOn, "fromCallable { findSuggestions(query) }\n        .subscribeOn(concurrentScheduler)");
        return subscribeOn;
    }

    public final List<String> f() {
        return (List) this.f13825f.getValue();
    }

    public final boolean g(String query) {
        kotlin.jvm.internal.m.g(query, "query");
        String str = (String) c().a(f(), query);
        return str != null && str.length() > 0;
    }

    public final h.c.b0<kotlin.o<OnboardingState, Optional<String>>> l(final String mnemonic) {
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        h.c.b0 map = this.a.validateMnemonic(mnemonic).flatMap(new h.c.m0.n() { // from class: e.j.n.k1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return d3.k(d3.this, mnemonic, (String) obj);
            }
        }).map(new h.c.m0.n() { // from class: e.j.n.j1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return d3.j((User) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "mnemonicRepository.validateMnemonic(mnemonic)\n        .flatMap { userRepository.signIn(mnemonic) }\n        .map { Pair(OnboardingState.EXISTING_USER, it.username.toOptional()) }");
        h.c.b0<kotlin.o<OnboardingState, Optional<String>>> onErrorReturn = Single_AnalyticsKt.logError$default(map, "Error while validating new recovery phrase", null, 2, null).onErrorReturn(new h.c.m0.n() { // from class: e.j.n.h1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return d3.h((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "mnemonicRepository.validateMnemonic(mnemonic)\n        .flatMap { userRepository.signIn(mnemonic) }\n        .map { Pair(OnboardingState.EXISTING_USER, it.username.toOptional()) }\n        .logError(\"Error while validating new recovery phrase\")\n        .onErrorReturn {\n            when {\n                it is InvalidMasterSeedException ->\n                    Pair(OnboardingState.INVALID_MNEMONIC, null.toOptional())\n                (it as? RPCException)?.code == RPCException.ErrorCodes.invalidAddress ->\n                    Pair(OnboardingState.NEW_USER, null.toOptional())\n                else ->\n                    throw (InvalidOnboardingStateException(\"Error while validating new recovery phrase\"))\n            }\n        }");
        return onErrorReturn;
    }
}