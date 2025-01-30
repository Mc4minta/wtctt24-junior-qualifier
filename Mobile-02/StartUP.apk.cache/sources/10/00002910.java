package com.coinbase.wallet.wallets.di;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.bitcoin.repositories.BTCTxRepository;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.bitcoincash.repositories.BCHTxRepository;
import com.coinbase.wallet.bitcoincash.services.BCHService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.dogecoin.repositories.DOGETxRepository;
import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.wallet.litecoin.repositories.LTCTxRepository;
import com.coinbase.wallet.litecoin.services.LTCService;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.ripple.repositories.XRPTxRepository;
import com.coinbase.wallet.stellar.api.TimeAPI;
import com.coinbase.wallet.stellar.daos.StellarSignedTxDao;
import com.coinbase.wallet.stellar.repositories.StellarTxRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.walletengine.services.stellar.StellarService;
import com.coinbase.walletengine.services.xrp.XRPService;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: TxManagingModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/di/TxManagingModule;", "", "<init>", "()V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class TxManagingModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: TxManagingModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b4\u00105JO\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0017\u0010\u0018JO\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010!\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u001f\u0010 J?\u0010'\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b%\u0010&J?\u0010.\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b,\u0010-J#\u00102\u001a\b\u0012\u0004\u0012\u00020\u0012012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120/H\u0007¢\u0006\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/coinbase/wallet/wallets/di/TxManagingModule$Companion;", "", "Lcom/coinbase/wallet/bitcoin/services/BTCService;", "walletService", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;", "txDao", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesBTCTxManaging$wallets_release", "(Lcom/coinbase/wallet/bitcoin/services/BTCService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesBTCTxManaging", "Lcom/coinbase/wallet/bitcoincash/services/BCHService;", "providesBCHTxManaging$wallets_release", "(Lcom/coinbase/wallet/bitcoincash/services/BCHService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesBCHTxManaging", "Lcom/coinbase/wallet/litecoin/services/LTCService;", "providesLTCTxManaging$wallets_release", "(Lcom/coinbase/wallet/litecoin/services/LTCService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesLTCTxManaging", "Lcom/coinbase/wallet/dogecoin/services/DOGEService;", "providesDOGETxManaging$wallets_release", "(Lcom/coinbase/wallet/dogecoin/services/DOGEService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesDOGETxManaging", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "xrpSignedTxDAO", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "providesXRPTxManaging$wallets_release", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;Lcom/coinbase/walletengine/services/xrp/XRPService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesXRPTxManaging", "Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;", "Lcom/coinbase/wallet/stellar/api/TimeAPI;", "timeAPI", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "providesStellarTxManaging$wallets_release", "(Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/stellar/api/TimeAPI;Lcom/coinbase/walletengine/services/stellar/StellarService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesStellarTxManaging", "", "txManagings", "", "providesTxManagingList", "(Ljava/util/Set;)Ljava/util/List;", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TxManaging providesBCHTxManaging$wallets_release(BCHService walletService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao txDao, CipherCoreInterface cipherCore, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(walletService, "walletService");
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(txDao, "txDao");
            m.g(cipherCore, "cipherCore");
            m.g(store, "store");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new BCHTxRepository(walletService, addressDao, walletDao, txDao, cipherCore, store, tracer, batchBalanceAPI);
        }

        public final TxManaging providesBTCTxManaging$wallets_release(BTCService walletService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao txDao, CipherCoreInterface cipherCore, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(walletService, "walletService");
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(txDao, "txDao");
            m.g(cipherCore, "cipherCore");
            m.g(store, "store");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new BTCTxRepository(walletService, addressDao, walletDao, txDao, cipherCore, store, tracer, batchBalanceAPI);
        }

        public final TxManaging providesDOGETxManaging$wallets_release(DOGEService walletService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao txDao, CipherCoreInterface cipherCore, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(walletService, "walletService");
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(txDao, "txDao");
            m.g(cipherCore, "cipherCore");
            m.g(store, "store");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new DOGETxRepository(walletService, addressDao, walletDao, txDao, cipherCore, store, tracer, batchBalanceAPI);
        }

        public final TxManaging providesLTCTxManaging$wallets_release(LTCService walletService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao txDao, CipherCoreInterface cipherCore, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(walletService, "walletService");
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(txDao, "txDao");
            m.g(cipherCore, "cipherCore");
            m.g(store, "store");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new LTCTxRepository(walletService, addressDao, walletDao, txDao, cipherCore, store, tracer, batchBalanceAPI);
        }

        public final TxManaging providesStellarTxManaging$wallets_release(StellarSignedTxDao txDao, CipherCoreInterface cipherCore, TimeAPI timeAPI, StellarService walletService, AddressDao addressDao, WalletDao walletDao) {
            m.g(txDao, "txDao");
            m.g(cipherCore, "cipherCore");
            m.g(timeAPI, "timeAPI");
            m.g(walletService, "walletService");
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            return new StellarTxRepository(txDao, cipherCore, timeAPI, walletService, addressDao, walletDao);
        }

        public final List<TxManaging> providesTxManagingList(Set<TxManaging> txManagings) {
            List<TxManaging> I0;
            m.g(txManagings, "txManagings");
            I0 = z.I0(txManagings);
            return I0;
        }

        public final TxManaging providesXRPTxManaging$wallets_release(CipherCoreInterface cipherCore, XRPSignedTxDAO xrpSignedTxDAO, XRPService walletService, AddressDao addressDao, WalletDao walletDao, StoreInterface store) {
            m.g(cipherCore, "cipherCore");
            m.g(xrpSignedTxDAO, "xrpSignedTxDAO");
            m.g(walletService, "walletService");
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(store, "store");
            return new XRPTxRepository(cipherCore, xrpSignedTxDAO, walletService, addressDao, walletDao, store);
        }
    }

    public static final List<TxManaging> providesTxManagingList(Set<TxManaging> set) {
        return Companion.providesTxManagingList(set);
    }
}