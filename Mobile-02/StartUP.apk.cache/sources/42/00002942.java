package com.coinbase.wallet.wallets.di;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bitcoin.repositories.BTCWalletRepository;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.bitcoincash.repositories.BCHWalletRepository;
import com.coinbase.wallet.bitcoincash.services.BCHService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.dogecoin.repositories.DOGEWalletRepository;
import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.wallet.litecoin.repositories.LTCWalletRepository;
import com.coinbase.wallet.litecoin.services.LTCService;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.ripple.repositories.XRPWalletRepository;
import com.coinbase.wallet.stellar.repositories.StellarWalletRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.apis.ExchangeRateAPI;
import com.coinbase.wallet.wallets.apis.FiatCurrencyAPI;
import com.coinbase.wallet.wallets.daos.FiatCurrencyDAO;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.repositories.ExchangeRateRepository;
import com.coinbase.wallet.wallets.repositories.FiatCurrencyRepository;
import com.coinbase.walletengine.services.stellar.StellarService;
import com.coinbase.walletengine.services.xrp.XRPService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletsRepositoriesModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsRepositoriesModule;", "", "<init>", "()V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletsRepositoriesModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: WalletsRepositoriesModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b>\u0010?JG\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJG\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ?\u0010#\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J/\u0010'\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J'\u00100\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0001¢\u0006\u0004\b.\u0010/J?\u0010=\u001a\u00020:2\u0006\u00101\u001a\u00020-2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u0002082\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsRepositoriesModule$Companion;", "", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/bitcoin/services/BTCService;", "btcService", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "providesBTCWalletRepository", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/bitcoin/services/BTCService;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/wallet/bitcoincash/services/BCHService;", "bchService", "providesBCHWalletRepository", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/bitcoincash/services/BCHService;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/wallet/litecoin/services/LTCService;", "ltcService", "providesLTCWalletRepository", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/litecoin/services/LTCService;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/wallet/dogecoin/services/DOGEService;", "dogeService", "providesDOGEWalletRepository", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/dogecoin/services/DOGEService;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "xrpService", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "xrpSignedTxDAO", "providesXRPWalletRepository", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/walletengine/services/xrp/XRPService;Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "stellarService", "providesStellarWalletRepository", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/walletengine/services/stellar/StellarService;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;", "fiatCurrencyAPI", "Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;", "fiatCurrencyDAO", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "provideFiatCurrencyRepository$wallets_release", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/wallets/apis/FiatCurrencyAPI;Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;)Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "provideFiatCurrencyRepository", "fiatCurrencyRepository", "Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;", "exchangeRateApi", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;", "exchangeRateDAO", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "provideExchangeRateRepository$wallets_release", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;Lcom/coinbase/wallet/wallets/apis/ExchangeRateAPI;Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/core/interfaces/Tracing;)Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "provideExchangeRateRepository", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IExchangeRateRepository provideExchangeRateRepository$wallets_release(IFiatCurrencyRepository fiatCurrencyRepository, ExchangeRateAPI exchangeRateApi, CompoundFinanceRepository compoundFinanceRepository, FiatExchangeRateDAO exchangeRateDAO, IWalletRepository walletRepository, Tracing tracer) {
            m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
            m.g(exchangeRateApi, "exchangeRateApi");
            m.g(compoundFinanceRepository, "compoundFinanceRepository");
            m.g(exchangeRateDAO, "exchangeRateDAO");
            m.g(walletRepository, "walletRepository");
            m.g(tracer, "tracer");
            return new ExchangeRateRepository(fiatCurrencyRepository.getActiveCurrencyObservable(), exchangeRateApi, compoundFinanceRepository, exchangeRateDAO, walletRepository, tracer);
        }

        public final IFiatCurrencyRepository provideFiatCurrencyRepository$wallets_release(StoreInterface store, FiatCurrencyAPI fiatCurrencyAPI, FiatCurrencyDAO fiatCurrencyDAO) {
            m.g(store, "store");
            m.g(fiatCurrencyAPI, "fiatCurrencyAPI");
            m.g(fiatCurrencyDAO, "fiatCurrencyDAO");
            return new FiatCurrencyRepository(fiatCurrencyAPI, store, fiatCurrencyDAO);
        }

        public final WalletManaging providesBCHWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface store, CipherCoreInterface cipherCore, BCHService bchService, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(bchService, "bchService");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new BCHWalletRepository(addressDao, walletDao, bchService, store, cipherCore, tracer, batchBalanceAPI);
        }

        public final WalletManaging providesBTCWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface store, CipherCoreInterface cipherCore, BTCService btcService, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(btcService, "btcService");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new BTCWalletRepository(store, addressDao, walletDao, btcService, cipherCore, tracer, batchBalanceAPI);
        }

        public final WalletManaging providesDOGEWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface store, CipherCoreInterface cipherCore, DOGEService dogeService, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(dogeService, "dogeService");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new DOGEWalletRepository(addressDao, walletDao, dogeService, store, cipherCore, tracer, batchBalanceAPI);
        }

        public final WalletManaging providesLTCWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface store, CipherCoreInterface cipherCore, LTCService ltcService, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(ltcService, "ltcService");
            m.g(tracer, "tracer");
            m.g(batchBalanceAPI, "batchBalanceAPI");
            return new LTCWalletRepository(addressDao, walletDao, store, ltcService, cipherCore, tracer, batchBalanceAPI);
        }

        public final WalletManaging providesStellarWalletRepository(AddressDao addressDao, WalletDao walletDao, CipherCoreInterface cipherCore, StellarService stellarService) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(cipherCore, "cipherCore");
            m.g(stellarService, "stellarService");
            return new StellarWalletRepository(cipherCore, addressDao, walletDao, stellarService);
        }

        public final WalletManaging providesXRPWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface store, CipherCoreInterface cipherCore, XRPService xrpService, XRPSignedTxDAO xrpSignedTxDAO) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(xrpService, "xrpService");
            m.g(xrpSignedTxDAO, "xrpSignedTxDAO");
            return new XRPWalletRepository(cipherCore, addressDao, walletDao, xrpService, store, xrpSignedTxDAO);
        }
    }

    public static final WalletManaging providesBCHWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, BCHService bCHService, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return Companion.providesBCHWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, bCHService, tracing, batchBalanceAPI);
    }

    public static final WalletManaging providesBTCWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, BTCService bTCService, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return Companion.providesBTCWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, bTCService, tracing, batchBalanceAPI);
    }

    public static final WalletManaging providesDOGEWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, DOGEService dOGEService, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return Companion.providesDOGEWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, dOGEService, tracing, batchBalanceAPI);
    }

    public static final WalletManaging providesLTCWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, LTCService lTCService, Tracing tracing, BatchBalanceAPI batchBalanceAPI) {
        return Companion.providesLTCWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, lTCService, tracing, batchBalanceAPI);
    }

    public static final WalletManaging providesStellarWalletRepository(AddressDao addressDao, WalletDao walletDao, CipherCoreInterface cipherCoreInterface, StellarService stellarService) {
        return Companion.providesStellarWalletRepository(addressDao, walletDao, cipherCoreInterface, stellarService);
    }

    public static final WalletManaging providesXRPWalletRepository(AddressDao addressDao, WalletDao walletDao, StoreInterface storeInterface, CipherCoreInterface cipherCoreInterface, XRPService xRPService, XRPSignedTxDAO xRPSignedTxDAO) {
        return Companion.providesXRPWalletRepository(addressDao, walletDao, storeInterface, cipherCoreInterface, xRPService, xRPSignedTxDAO);
    }
}