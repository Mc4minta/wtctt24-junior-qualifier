package com.coinbase.wallet.stellar.repositories;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.stellar.extensions.CipherCoreInterface_StellarKt;
import com.coinbase.wallet.stellar.extensions.WalletConfiguration_StellarKt;
import com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging;
import com.coinbase.walletengine.services.stellar.StellarService;
import h.c.b0;
import h.c.h0;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: StellarWalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b'\u0010(J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/coinbase/wallet/stellar/repositories/StellarWalletRepository;", "Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedWalletManaging;", "Lcom/coinbase/wallet/stellar/interfaces/StellarBalanceManaging;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lh/c/b0;", "Lkotlin/x;", "refresh", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "numberOfAddress", "(Lcom/coinbase/wallet/blockchains/models/Network;)I", "index", "", "derivationPath", "(ILcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "", "seed", "deriveAddress", "([BLjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "walletService", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "getWalletService", "()Lcom/coinbase/walletengine/services/stellar/StellarService;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/walletengine/services/stellar/StellarService;)V", "stellar_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarWalletRepository extends AccountBasedWalletManaging implements StellarBalanceManaging {
    private final AddressDao addressDao;
    private final WalletDao walletDao;
    private final StellarService walletService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StellarWalletRepository(CipherCoreInterface cipherCore, AddressDao addressDao, WalletDao walletDao, StellarService walletService) {
        super(addressDao, walletDao, WalletConfiguration_StellarKt.getXLM(WalletConfiguration.Companion), cipherCore);
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(walletService, "walletService");
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        this.walletService = walletService;
    }

    /* renamed from: deriveAddress$lambda-0 */
    public static final h0 m1719deriveAddress$lambda0(StellarWalletRepository this$0, KeyPair it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getWalletService().deriveAddressFromPublicKey(it.getPublicKey());
    }

    public static /* synthetic */ h0 h(StellarWalletRepository stellarWalletRepository, KeyPair keyPair) {
        return m1719deriveAddress$lambda0(stellarWalletRepository, keyPair);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public String derivationPath(int i2, Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return CipherCoreInterface_StellarKt.stellarDerivationPath(getCipherCore(), 0);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public b0<String> deriveAddress(byte[] seed, String derivationPath) {
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        b0 flatMap = getCipherCore().deriveEd25519KeyPair(seed, derivationPath).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.stellar.repositories.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return StellarWalletRepository.h(StellarWalletRepository.this, (KeyPair) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "cipherCore.deriveEd25519KeyPair(seed, derivationPath)\n        .flatMap { walletService.deriveAddressFromPublicKey(publicKey = it.publicKey) }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getBalance(String str, Network network) {
        return StellarBalanceManaging.DefaultImpls.getBalance(this, str, network);
    }

    @Override // com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getMinimumBalance(Network network) {
        return StellarBalanceManaging.DefaultImpls.getMinimumBalance(this, network);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public WalletDao getWalletDao() {
        return this.walletDao;
    }

    @Override // com.coinbase.wallet.stellar.interfaces.StellarBalanceManaging
    public StellarService getWalletService() {
        return this.walletService;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public int numberOfAddress(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return 1;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public b0<x> refresh(RefreshContext context) {
        kotlin.jvm.internal.m.g(context, "context");
        return refreshBalances(context);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public b0<x> refreshBalances(RefreshContext refreshContext) {
        return StellarBalanceManaging.DefaultImpls.refreshBalances(this, refreshContext);
    }
}