package com.coinbase.wallet.features.walletlink.repositories;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.user.models.User;
import com.coinbase.wallet.user.repositories.UserRepository;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletLinkRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lh/c/s;", "Lcom/coinbase/wallet/user/models/User;", "<anonymous>", "()Lh/c/s;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletLinkRepository$activeUserObservable$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<h.c.s<User>> {
    final /* synthetic */ WalletLinkRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletLinkRepository$activeUserObservable$2(WalletLinkRepository walletLinkRepository) {
        super(0);
        this.this$0 = walletLinkRepository;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final h.c.s<User> invoke() {
        UserRepository userRepository;
        userRepository = this.this$0.userRepository;
        h.c.s map = userRepository.getActiveUserObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$activeUserObservable$2$invoke$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository$activeUserObservable$2$invoke$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map;
    }
}