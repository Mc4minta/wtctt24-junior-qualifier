package com.coinbase.wallet.ripple.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.ripple.extensions.CipherCoreInterface_RippleKt;
import com.coinbase.wallet.ripple.extensions.WalletConfiguration_RippleKt;
import com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.services.xrp.XRPService;
import h.c.b0;
import h.c.h0;
import java.math.BigInteger;
import kotlin.Metadata;

/* compiled from: XRPWalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b1\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u00020\u00168\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u00020%8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u00020*8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/coinbase/wallet/ripple/repositories/XRPWalletRepository;", "Lcom/coinbase/wallet/accountwallets/interfaces/AccountBasedWalletManaging;", "Lcom/coinbase/wallet/ripple/interfaces/XRPBalanceManaging;", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "numberOfAddress", "(Lcom/coinbase/wallet/blockchains/models/Network;)I", "index", "", "derivationPath", "(ILcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "", "seed", "Lh/c/b0;", "deriveAddress", "([BLjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lkotlin/x;", "refresh", "(Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "getWalletDao", "()Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "getAddressDao", "()Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "xrpSignedTxDAO", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "getXrpSignedTxDAO", "()Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "walletService", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "getWalletService", "()Lcom/coinbase/walletengine/services/xrp/XRPService;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/walletengine/services/xrp/XRPService;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;)V", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPWalletRepository extends AccountBasedWalletManaging implements XRPBalanceManaging {
    private final AddressDao addressDao;
    private final StoreInterface store;
    private final WalletDao walletDao;
    private final XRPService walletService;
    private final XRPSignedTxDAO xrpSignedTxDAO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XRPWalletRepository(CipherCoreInterface cipherCore, AddressDao addressDao, WalletDao walletDao, XRPService walletService, StoreInterface store, XRPSignedTxDAO xrpSignedTxDAO) {
        super(addressDao, walletDao, WalletConfiguration_RippleKt.getXRP(WalletConfiguration.Companion), cipherCore);
        kotlin.jvm.internal.m.g(cipherCore, "cipherCore");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(walletService, "walletService");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(xrpSignedTxDAO, "xrpSignedTxDAO");
        this.addressDao = addressDao;
        this.walletDao = walletDao;
        this.walletService = walletService;
        this.store = store;
        this.xrpSignedTxDAO = xrpSignedTxDAO;
    }

    /* renamed from: deriveAddress$lambda-0 */
    public static final h0 m1683deriveAddress$lambda0(XRPWalletRepository this$0, KeyPair it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.getWalletService().deriveAddressFromPublicKey(it.getPublicKey());
    }

    public static /* synthetic */ h0 h(XRPWalletRepository xRPWalletRepository, KeyPair keyPair) {
        return m1683deriveAddress$lambda0(xRPWalletRepository, keyPair);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public String derivationPath(int i2, Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return CipherCoreInterface_RippleKt.xrpDerivationPath(getCipherCore(), i2);
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public b0<String> deriveAddress(byte[] seed, String derivationPath) {
        kotlin.jvm.internal.m.g(seed, "seed");
        kotlin.jvm.internal.m.g(derivationPath, "derivationPath");
        b0 flatMap = getCipherCore().deriveKeyPair(seed, derivationPath).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ripple.repositories.w
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return XRPWalletRepository.h(XRPWalletRepository.this, (KeyPair) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "cipherCore.deriveKeyPair(seed, derivationPath)\n        .flatMap { walletService.deriveAddressFromPublicKey(it.publicKey) }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public AddressDao getAddressDao() {
        return this.addressDao;
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getBalance(String str, Network network) {
        return XRPBalanceManaging.DefaultImpls.getBalance(this, str, network);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public b0<Optional<BigInteger>> getMinimumBalance(Network network) {
        return XRPBalanceManaging.DefaultImpls.getMinimumBalance(this, network);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    public StoreInterface getStore() {
        return this.store;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging
    public WalletDao getWalletDao() {
        return this.walletDao;
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    public XRPService getWalletService() {
        return this.walletService;
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    /* renamed from: getXrpMaxLedgerVersion-pVg5ArA */
    public int mo1646getXrpMaxLedgerVersionpVg5ArA() {
        return XRPBalanceManaging.DefaultImpls.m1654getXrpMaxLedgerVersionpVg5ArA(this);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging
    public XRPSignedTxDAO getXrpSignedTxDAO() {
        return this.xrpSignedTxDAO;
    }

    @Override // com.coinbase.wallet.accountwallets.interfaces.AccountBasedWalletManaging
    public int numberOfAddress(Network network) {
        kotlin.jvm.internal.m.g(network, "network");
        return 1;
    }

    @Override // com.coinbase.wallet.blockchains.interfaces.WalletManaging
    public b0<kotlin.x> refresh(RefreshContext context) {
        kotlin.jvm.internal.m.g(context, "context");
        return refreshBalances(context);
    }

    @Override // com.coinbase.wallet.ripple.interfaces.XRPBalanceManaging, com.coinbase.wallet.accountwallets.interfaces.AccountBasedBalanceManaging, com.coinbase.wallet.blockchains.interfaces.BalanceManaging
    public b0<kotlin.x> refreshBalances(RefreshContext refreshContext) {
        return XRPBalanceManaging.DefaultImpls.refreshBalances(this, refreshContext);
    }
}