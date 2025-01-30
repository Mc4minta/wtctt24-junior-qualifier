package com.coinbase.wallet.wallets.di;

import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.bitcoin.extensions.NetworkSetting_BitcoinKt;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.bitcoincash.extensions.NetworkSetting_BitcoinCashKt;
import com.coinbase.wallet.bitcoincash.services.BCHService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.compoundfinance.apis.CompoundFinanceAPI;
import com.coinbase.wallet.compoundfinance.daos.CompoundTokenDAO;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.dogecoin.extensions.NetworkSetting_DogecoinKt;
import com.coinbase.wallet.dogecoin.services.DOGEService;
import com.coinbase.wallet.ethereum.extensions.NetworkSetting_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.NetworkSetting_LitecoinKt;
import com.coinbase.wallet.litecoin.services.LTCService;
import com.coinbase.wallet.ripple.extensions.NetworkSetting_RippleKt;
import com.coinbase.wallet.stellar.extensions.NetworkSetting_StellarKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.wallets.apis.CryptoCurrencyAPI;
import com.coinbase.wallet.wallets.apis.WatchAddressAPI;
import com.coinbase.wallet.wallets.daos.CryptoCurrencyDAO;
import com.coinbase.wallet.wallets.di.qualifier.WalletApiUrl;
import com.coinbase.wallet.wallets.di.qualifier.WalletBlockchainUrl;
import com.coinbase.wallet.wallets.di.qualifier.XRPNodeUrl;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import com.coinbase.wallet.wallets.repositories.TxRepository;
import com.coinbase.wallet.wallets.repositories.WalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.models.BTCLikeServiceConfig;
import com.coinbase.walletengine.models.ResolverServiceConfig;
import com.coinbase.walletengine.models.StellarServiceConfig;
import com.coinbase.walletengine.models.WalletEngineConfig;
import com.coinbase.walletengine.models.XRPServiceConfig;
import com.coinbase.walletengine.services.stellar.StellarService;
import com.coinbase.walletengine.services.xrp.XRPService;
import h.c.s;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletsModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsModule;", "", "<init>", "()V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class WalletsModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: WalletsModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bP\u0010QJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005Jk\u0010\u001d\u001a\u00020\u001a2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ;\u0010\"\u001a\u00020\u001f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b \u0010!J\u001f\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J=\u00100\u001a\u00020/2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010,\u001a\u00020+2\b\b\u0001\u0010-\u001a\u00020+2\b\b\u0001\u0010.\u001a\u00020+H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u0002032\u0006\u00102\u001a\u00020/H\u0007¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u0002062\u0006\u00102\u001a\u00020/H\u0007¢\u0006\u0004\b7\u00108J\u0017\u0010:\u001a\u0002092\u0006\u00102\u001a\u00020/H\u0007¢\u0006\u0004\b:\u0010;J\u0017\u0010=\u001a\u00020<2\u0006\u00102\u001a\u00020/H\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020?2\u0006\u00102\u001a\u00020/H\u0007¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020B2\u0006\u00102\u001a\u00020/H\u0007¢\u0006\u0004\bC\u0010DJ\u001f\u0010H\u001a\u00020G2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020EH\u0007¢\u0006\u0004\bH\u0010IJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0L2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0004\bN\u0010O¨\u0006R"}, d2 = {"Lcom/coinbase/wallet/wallets/di/WalletsModule$Companion;", "", "", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "providesNetworkSettings", "()Ljava/util/List;", "", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "repositories", "networkSettings", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;", "cryptoCurrencyDAO", "Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;", "cryptoCurrencyAPI", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;", "watchAddressAPI", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "providesWalletRepository$wallets_release", "(Ljava/util/Set;Ljava/util/List;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;Lcom/coinbase/wallet/core/interfaces/Tracing;)Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "providesWalletRepository", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "providesTxRepository$wallets_release", "(Ljava/util/List;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Ljava/util/List;Lcom/coinbase/wallet/core/interfaces/Tracing;)Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "providesTxRepository", "Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;", "compoundFinanceAPI", "Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;", "compoundTokenDAO", "providesCompoundFinanceRepository", "(Lcom/coinbase/wallet/compoundfinance/apis/CompoundFinanceAPI;Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;)Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "Landroid/content/Context;", "context", "", "walletServiceUrl", "blockchainUrl", "xrpNodeUrl", "Lcom/coinbase/walletengine/WalletEngine;", "providesWalletEngine", "(Landroid/content/Context;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/wallet/bitcoin/services/BTCService;", "providesBTCService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/wallet/bitcoin/services/BTCService;", "Lcom/coinbase/wallet/bitcoincash/services/BCHService;", "providesBCHService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/wallet/bitcoincash/services/BCHService;", "Lcom/coinbase/wallet/dogecoin/services/DOGEService;", "providesDOGEService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/wallet/dogecoin/services/DOGEService;", "Lcom/coinbase/wallet/litecoin/services/LTCService;", "providesLTCService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/wallet/litecoin/services/LTCService;", "Lcom/coinbase/walletengine/services/stellar/StellarService;", "providesStellarService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/walletengine/services/stellar/StellarService;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "providesXRPService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/walletengine/services/xrp/XRPService;", "Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;", "exchangeRateRepository", "Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "currencyFormatter", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/wallets/interfaces/IExchangeRateRepository;)Lcom/coinbase/wallet/wallets/formatters/CurrencyFormatter;", "Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;", "fiatCurrencyRepository", "Lh/c/s;", "Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "providesActiveCurrencyObservable", "(Lcom/coinbase/wallet/wallets/interfaces/IFiatCurrencyRepository;)Lh/c/s;", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CurrencyFormatter currencyFormatter(StoreInterface store, IExchangeRateRepository exchangeRateRepository) {
            m.g(store, "store");
            m.g(exchangeRateRepository, "exchangeRateRepository");
            return new CurrencyFormatter(store, exchangeRateRepository.getExchangeRateObservable());
        }

        public final s<FiatCurrency> providesActiveCurrencyObservable(IFiatCurrencyRepository fiatCurrencyRepository) {
            m.g(fiatCurrencyRepository, "fiatCurrencyRepository");
            return fiatCurrencyRepository.getActiveCurrencyObservable();
        }

        public final BCHService providesBCHService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new BCHService(walletEngine);
        }

        public final BTCService providesBTCService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new BTCService(walletEngine);
        }

        public final CompoundFinanceRepository providesCompoundFinanceRepository(CompoundFinanceAPI compoundFinanceAPI, CompoundTokenDAO compoundTokenDAO) {
            m.g(compoundFinanceAPI, "compoundFinanceAPI");
            m.g(compoundTokenDAO, "compoundTokenDAO");
            return new CompoundFinanceRepository(compoundFinanceAPI, compoundTokenDAO);
        }

        public final DOGEService providesDOGEService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new DOGEService(walletEngine);
        }

        public final LTCService providesLTCService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new LTCService(walletEngine);
        }

        public final List<NetworkSetting> providesNetworkSettings() {
            List<NetworkSetting> j2;
            NetworkSetting.Companion companion = NetworkSetting.Companion;
            j2 = r.j(NetworkSetting_EthereumKt.getETH(companion), NetworkSetting_EthereumKt.getETC(companion), NetworkSetting_RippleKt.getXRP(companion), NetworkSetting_StellarKt.getXLM(companion), NetworkSetting_BitcoinKt.getBTC(companion), NetworkSetting_BitcoinCashKt.getBCH(companion), NetworkSetting_LitecoinKt.getLTC(companion), NetworkSetting_DogecoinKt.getDOGE(companion));
            return j2;
        }

        public final StellarService providesStellarService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new StellarService(walletEngine);
        }

        public final ITxRepository providesTxRepository$wallets_release(List<TxManaging> repositories, StoreInterface store, List<NetworkSetting> networkSettings, Tracing tracer) {
            m.g(repositories, "repositories");
            m.g(store, "store");
            m.g(networkSettings, "networkSettings");
            m.g(tracer, "tracer");
            return new TxRepository(repositories, store, networkSettings, tracer);
        }

        public final WalletEngine providesWalletEngine(Context context, Tracing tracer, @WalletApiUrl String walletServiceUrl, @WalletBlockchainUrl String blockchainUrl, @XRPNodeUrl String xrpNodeUrl) {
            m.g(context, "context");
            m.g(tracer, "tracer");
            m.g(walletServiceUrl, "walletServiceUrl");
            m.g(blockchainUrl, "blockchainUrl");
            m.g(xrpNodeUrl, "xrpNodeUrl");
            WalletEngineConfig walletEngineConfig = new WalletEngineConfig(new BTCLikeServiceConfig(m.o(blockchainUrl, "/btc")), new BTCLikeServiceConfig(m.o(blockchainUrl, "/bch")), new BTCLikeServiceConfig(m.o(blockchainUrl, "/ltc")), new BTCLikeServiceConfig(m.o(blockchainUrl, "/doge")), new XRPServiceConfig(xrpNodeUrl, "wss://testnet-ripple.wallet.coinbase.com"), new StellarServiceConfig("https://horizon.stellar.org", "https://horizon-testnet.stellar.org"), new ResolverServiceConfig("https://mainnet-infura.wallet.coinbase.com"));
            WalletEngine walletEngine = new WalletEngine();
            walletEngine.initialize(context, walletEngineConfig, tracer);
            return walletEngine;
        }

        public final IWalletRepository providesWalletRepository$wallets_release(Set<WalletManaging> repositories, List<NetworkSetting> networkSettings, WalletDao walletDao, CompoundFinanceRepository compoundFinanceRepository, StoreInterface store, CryptoCurrencyDAO cryptoCurrencyDAO, CryptoCurrencyAPI cryptoCurrencyAPI, AddressDao addressDao, WatchAddressAPI watchAddressAPI, Tracing tracer) {
            List I0;
            m.g(repositories, "repositories");
            m.g(networkSettings, "networkSettings");
            m.g(walletDao, "walletDao");
            m.g(compoundFinanceRepository, "compoundFinanceRepository");
            m.g(store, "store");
            m.g(cryptoCurrencyDAO, "cryptoCurrencyDAO");
            m.g(cryptoCurrencyAPI, "cryptoCurrencyAPI");
            m.g(addressDao, "addressDao");
            m.g(watchAddressAPI, "watchAddressAPI");
            m.g(tracer, "tracer");
            I0 = z.I0(repositories);
            return new WalletRepository(walletDao, store, compoundFinanceRepository, cryptoCurrencyDAO, cryptoCurrencyAPI, watchAddressAPI, addressDao, tracer, networkSettings, I0);
        }

        public final XRPService providesXRPService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new XRPService(walletEngine);
        }
    }

    public static final CurrencyFormatter currencyFormatter(StoreInterface storeInterface, IExchangeRateRepository iExchangeRateRepository) {
        return Companion.currencyFormatter(storeInterface, iExchangeRateRepository);
    }

    public static final s<FiatCurrency> providesActiveCurrencyObservable(IFiatCurrencyRepository iFiatCurrencyRepository) {
        return Companion.providesActiveCurrencyObservable(iFiatCurrencyRepository);
    }

    public static final BCHService providesBCHService(WalletEngine walletEngine) {
        return Companion.providesBCHService(walletEngine);
    }

    public static final BTCService providesBTCService(WalletEngine walletEngine) {
        return Companion.providesBTCService(walletEngine);
    }

    public static final CompoundFinanceRepository providesCompoundFinanceRepository(CompoundFinanceAPI compoundFinanceAPI, CompoundTokenDAO compoundTokenDAO) {
        return Companion.providesCompoundFinanceRepository(compoundFinanceAPI, compoundTokenDAO);
    }

    public static final DOGEService providesDOGEService(WalletEngine walletEngine) {
        return Companion.providesDOGEService(walletEngine);
    }

    public static final LTCService providesLTCService(WalletEngine walletEngine) {
        return Companion.providesLTCService(walletEngine);
    }

    public static final List<NetworkSetting> providesNetworkSettings() {
        return Companion.providesNetworkSettings();
    }

    public static final StellarService providesStellarService(WalletEngine walletEngine) {
        return Companion.providesStellarService(walletEngine);
    }

    public static final WalletEngine providesWalletEngine(Context context, Tracing tracing, @WalletApiUrl String str, @WalletBlockchainUrl String str2, @XRPNodeUrl String str3) {
        return Companion.providesWalletEngine(context, tracing, str, str2, str3);
    }

    public static final XRPService providesXRPService(WalletEngine walletEngine) {
        return Companion.providesXRPService(walletEngine);
    }
}