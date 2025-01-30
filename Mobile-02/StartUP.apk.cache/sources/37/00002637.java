package com.coinbase.wallet.stellar.interfaces;

import com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging;
import com.coinbase.walletengine.services.stellar.StellarService;
import h.c.b0;
import h.c.m0.n;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: StellarBalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/stellar/interfaces/StellarBalanceManaging;", "Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedBalanceManaging;", "", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Ljava/math/BigInteger;", "getBalance", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "getMinimumBalance", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "getWalletService", "()Lcom/coinbase/walletengine/services/stellar/StellarService;", "walletService", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface StellarBalanceManaging extends AccountBasedBalanceManaging {

    /* compiled from: StellarBalanceManaging.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Optional a(com.coinbase.walletengine.Optional optional) {
            return m1695getBalance$lambda0(optional);
        }

        public static /* synthetic */ Optional b(BigInteger bigInteger) {
            return m1696getMinimumBalance$lambda1(bigInteger);
        }

        public static b0<Optional<BigInteger>> getBalance(StellarBalanceManaging stellarBalanceManaging, String address, Network network) {
            m.g(stellarBalanceManaging, "this");
            m.g(address, "address");
            m.g(network, "network");
            b0 map = stellarBalanceManaging.getWalletService().getBalance(address, network.isTestnet()).map(new n() { // from class: com.coinbase.wallet.stellar.interfaces.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return StellarBalanceManaging.DefaultImpls.a((com.coinbase.walletengine.Optional) obj);
                }
            });
            m.f(map, "walletService.getBalance(address, network.isTestnet).map { it.value.toOptional() }");
            return map;
        }

        /* renamed from: getBalance$lambda-0 */
        public static Optional m1695getBalance$lambda0(com.coinbase.walletengine.Optional it) {
            m.g(it, "it");
            return OptionalKt.toOptional(it.getValue());
        }

        public static b0<Optional<BigInteger>> getMinimumBalance(StellarBalanceManaging stellarBalanceManaging, Network network) {
            m.g(stellarBalanceManaging, "this");
            m.g(network, "network");
            b0 map = stellarBalanceManaging.getWalletService().getMinimumBalance(network.isTestnet()).map(new n() { // from class: com.coinbase.wallet.stellar.interfaces.b
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return StellarBalanceManaging.DefaultImpls.b((BigInteger) obj);
                }
            });
            m.f(map, "walletService.getMinimumBalance(network.isTestnet).map { it.toOptional() }");
            return map;
        }

        /* renamed from: getMinimumBalance$lambda-1 */
        public static Optional m1696getMinimumBalance$lambda1(BigInteger it) {
            m.g(it, "it");
            return OptionalKt.toOptional(it);
        }

        public static b0<x> refreshBalances(StellarBalanceManaging stellarBalanceManaging, RefreshContext context) {
            m.g(stellarBalanceManaging, "this");
            m.g(context, "context");
            return AccountBasedBalanceManaging.DefaultImpls.refreshBalances(stellarBalanceManaging, context);
        }
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    b0<Optional<BigInteger>> getBalance(String str, Network network);

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    b0<Optional<BigInteger>> getMinimumBalance(Network network);

    StellarService getWalletService();
}