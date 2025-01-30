package com.coinbase.wallet.wallets.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.bitcoin.extensions.CurrencyCode_BitcoinKt;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.exceptions.WalletException;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.RefreshContext;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.blockchains.models.WalletConfiguration;
import com.coinbase.wallet.compoundfinance.models.CompoundToken;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.core.extensions.Map_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.apis.CryptoCurrencyAPI;
import com.coinbase.wallet.wallets.apis.WatchAddressAPI;
import com.coinbase.wallet.wallets.daos.CryptoCurrencyDAO;
import com.coinbase.wallet.wallets.exceptions.CryptoCurrencyException;
import com.coinbase.wallet.wallets.extensions.AnalyticsEvent_WalletsKt;
import com.coinbase.wallet.wallets.extensions.CurrencyCode_WalletsKt;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.extensions.TraceKey_WalletsKt;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import com.coinbase.wallet.wallets.models.WalletRefreshState;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: WalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001Bd\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010p\u001a\u00020o\u0012\u0006\u0010|\u001a\u00020{\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010d\u001a\u00020c\u0012\u0006\u0010W\u001a\u00020V\u0012\f\u0010~\u001a\b\u0012\u0004\u0012\u00020J0\r\u0012\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\fH\u0016¢\u0006\u0004\b \u0010\u0010J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r0&2\u0006\u0010%\u001a\u00020\u001fH\u0016¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r0\fH\u0016¢\u0006\u0004\b)\u0010\u0010J\u001b\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190*0&H\u0016¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130&2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010.J%\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0&2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0013H\u0016¢\u0006\u0004\b0\u00101J+\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\rH\u0016¢\u0006\u0004\b4\u00105J-\u00108\u001a\b\u0012\u0004\u0012\u00020\u001f0\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00106\u001a\u0002022\u0006\u00107\u001a\u00020!H\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010:\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0013H\u0016¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0016H\u0016¢\u0006\u0004\b=\u0010>J+\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\r0\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0013H\u0016¢\u0006\u0004\b@\u0010AJ!\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020C0B0\fH\u0016¢\u0006\u0004\bD\u0010\u0010J\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010E\u001a\u00020\u001fH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010\u0004J\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001f0\fH\u0016¢\u0006\u0004\bI\u0010\u0010R\"\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020J0B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001d\u0010^\u001a\u00020Y8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R0\u0010a\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 `*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r0\r0_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR0\u0010f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 `*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r0\r0_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010bR\"\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010LR$\u0010h\u001a\u0010\u0012\f\u0012\n `*\u0004\u0018\u00010\u001f0\u001f0_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010bR$\u0010j\u001a\u0010\u0012\f\u0012\n `*\u0004\u0018\u00010\u00020\u00020i8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010m\u001a\u00020l8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR)\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020v0u8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010[\u001a\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2 = {"Lcom/coinbase/wallet/wallets/repositories/WalletRepository;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lkotlin/x;", "observeWalletUpdates", "()V", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "repository", "Lcom/coinbase/wallet/blockchains/models/RefreshContext;", "context", "Lh/c/k0/b;", "refreshRepository", "(Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;Lcom/coinbase/wallet/blockchains/models/RefreshContext;)Lh/c/k0/b;", "Lh/c/b0;", "", "Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "getUserOwnedCryptoCurrencies", "()Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/blockchains/models/Network;", "", "getActiveIndex", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Ljava/lang/Integer;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallets", "filterActiveWallets", "(Ljava/util/List;)Ljava/util/List;", "watchAddresses", "()Lh/c/k0/b;", "", "hasWallets", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "createWallets", "(Ljava/lang/String;)Lh/c/b0;", "onlyUsable", "Lh/c/s;", "observeWallets", "(Z)Lh/c/s;", "getAllActiveEthWallets", "", "consumerWalletsObservableAVAXFix", "()Lh/c/s;", "observeNetwork", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/s;", "network", "isSynced", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "currencyCodes", "getCryptoCurrencies", "(Ljava/util/List;)Lh/c/b0;", AppsFlyerProperties.CURRENCY_CODE, "address", "containsAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;)Lh/c/b0;", "switchNetwork", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)V", "index", "switchIndex", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;I)V", "Lcom/coinbase/wallet/blockchains/models/Address;", "getUsedAddresses", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/WalletAddress;", "getPrimaryReceiveAddresses", "isForced", "refresh", "(Z)Lh/c/b0;", "start", "destroy", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networks", "Ljava/util/Map;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "compoundFinanceRepository", "Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;", "Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;", "watchAddressAPI", "Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lh/c/a0;", "refreshScheduler$delegate", "Lkotlin/h;", "getRefreshScheduler", "()Lh/c/a0;", "refreshScheduler", "Lh/c/v0/c;", "kotlin.jvm.PlatformType", "usableWalletsSubject", "Lh/c/v0/c;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "allWalletsSubject", "repositories", "isReadySubject", "Lh/c/v0/a;", "reloadWalletsSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;", "cryptoCurrencyDAO", "Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/coinbase/wallet/wallets/models/WalletRefreshState;", "refreshStates$delegate", "getRefreshStates", "()Ljava/util/concurrent/ConcurrentHashMap;", "refreshStates", "Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;", "cryptoCurrencyAPI", "Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;", "networkSettings", "<init>", "(Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/compoundfinance/repositories/CompoundFinanceRepository;Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;Lcom/coinbase/wallet/wallets/apis/CryptoCurrencyAPI;Lcom/coinbase/wallet/wallets/apis/WatchAddressAPI;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/util/List;Ljava/util/List;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletRepository implements IWalletRepository {
    private final AddressDao addressDao;
    private final h.c.v0.c<List<Wallet>> allWalletsSubject;
    private final CompoundFinanceRepository compoundFinanceRepository;
    private final CryptoCurrencyAPI cryptoCurrencyAPI;
    private final CryptoCurrencyDAO cryptoCurrencyDAO;
    private final h.c.k0.a disposeBag;
    private final h.c.v0.c<Boolean> isReadySubject;
    private final Map<Blockchain, NetworkSetting> networks;
    private final kotlin.h refreshScheduler$delegate;
    private final kotlin.h refreshStates$delegate;
    private final h.c.v0.a<kotlin.x> reloadWalletsSubject;
    private final Map<Blockchain, WalletManaging> repositories;
    private final StoreInterface store;
    private final Tracing tracer;
    private final h.c.v0.c<List<Wallet>> usableWalletsSubject;
    private final WalletDao walletDao;
    private final WatchAddressAPI watchAddressAPI;

    public WalletRepository(WalletDao walletDao, StoreInterface store, CompoundFinanceRepository compoundFinanceRepository, CryptoCurrencyDAO cryptoCurrencyDAO, CryptoCurrencyAPI cryptoCurrencyAPI, WatchAddressAPI watchAddressAPI, AddressDao addressDao, Tracing tracer, List<NetworkSetting> networkSettings, List<? extends WalletManaging> repositories) {
        kotlin.h b2;
        int r;
        Map<Blockchain, WalletManaging> r2;
        int r3;
        Map<Blockchain, NetworkSetting> r4;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(walletDao, "walletDao");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(compoundFinanceRepository, "compoundFinanceRepository");
        kotlin.jvm.internal.m.g(cryptoCurrencyDAO, "cryptoCurrencyDAO");
        kotlin.jvm.internal.m.g(cryptoCurrencyAPI, "cryptoCurrencyAPI");
        kotlin.jvm.internal.m.g(watchAddressAPI, "watchAddressAPI");
        kotlin.jvm.internal.m.g(addressDao, "addressDao");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        kotlin.jvm.internal.m.g(networkSettings, "networkSettings");
        kotlin.jvm.internal.m.g(repositories, "repositories");
        this.walletDao = walletDao;
        this.store = store;
        this.compoundFinanceRepository = compoundFinanceRepository;
        this.cryptoCurrencyDAO = cryptoCurrencyDAO;
        this.cryptoCurrencyAPI = cryptoCurrencyAPI;
        this.watchAddressAPI = watchAddressAPI;
        this.addressDao = addressDao;
        this.tracer = tracer;
        h.c.v0.c<Boolean> d2 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d2, "createWithSize<Boolean>(1)");
        this.isReadySubject = d2;
        h.c.v0.a<kotlin.x> e2 = h.c.v0.a.e(kotlin.x.a);
        kotlin.jvm.internal.m.f(e2, "createDefault(Unit)");
        this.reloadWalletsSubject = e2;
        b2 = kotlin.k.b(WalletRepository$refreshScheduler$2.INSTANCE);
        this.refreshScheduler$delegate = b2;
        h.c.v0.c<List<Wallet>> d3 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d3, "createWithSize<List<Wallet>>(1)");
        this.usableWalletsSubject = d3;
        h.c.v0.c<List<Wallet>> d4 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d4, "createWithSize<List<Wallet>>(1)");
        this.allWalletsSubject = d4;
        r = kotlin.a0.s.r(repositories, 10);
        ArrayList arrayList = new ArrayList(r);
        for (WalletManaging walletManaging : repositories) {
            arrayList.add(kotlin.u.a(walletManaging.getConfiguration().getBlockchain(), walletManaging));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        this.repositories = r2;
        r3 = kotlin.a0.s.r(networkSettings, 10);
        ArrayList arrayList2 = new ArrayList(r3);
        for (NetworkSetting networkSetting : networkSettings) {
            arrayList2.add(kotlin.u.a(networkSetting.getBlockchain(), networkSetting));
        }
        r4 = kotlin.a0.m0.r(arrayList2);
        this.networks = r4;
        this.disposeBag = new h.c.k0.a();
        b3 = kotlin.k.b(new WalletRepository$refreshStates$2(repositories));
        this.refreshStates$delegate = b3;
        observeWalletUpdates();
    }

    public static /* synthetic */ kotlin.o A(WalletConfiguration walletConfiguration, Optional optional) {
        return m1897getPrimaryReceiveAddresses$lambda20$lambda19(walletConfiguration, optional);
    }

    public static /* synthetic */ List B(Optional optional) {
        return m1893getCryptoCurrencies$lambda12$lambda11(optional);
    }

    public static /* synthetic */ h.c.x C(WalletRepository walletRepository, List list) {
        return m1905observeWalletUpdates$lambda37(walletRepository, list);
    }

    public static /* synthetic */ kotlin.o D(WalletRepository walletRepository, List list) {
        return m1913observeWalletUpdates$lambda41(walletRepository, list);
    }

    public static /* synthetic */ h.c.x E(WalletRepository walletRepository, kotlin.x xVar) {
        return m1917watchAddresses$lambda53(walletRepository, xVar);
    }

    public static /* synthetic */ Set F(kotlin.o oVar) {
        return m1888consumerWalletsObservableAVAXFix$lambda7(oVar);
    }

    public static /* synthetic */ h.c.h0 G(WalletRepository walletRepository, kotlin.x xVar) {
        return m1904observeWalletUpdates$lambda24(walletRepository, xVar);
    }

    public static /* synthetic */ List b(List list) {
        return m1918watchAddresses$lambda53$lambda52$lambda50(list);
    }

    public static /* synthetic */ List c(WalletRepository walletRepository, List list) {
        return m1899getUserOwnedCryptoCurrencies$lambda44(walletRepository, list);
    }

    /* renamed from: consumerWalletsObservableAVAXFix$lambda-7 */
    public static final Set m1888consumerWalletsObservableAVAXFix$lambda7(kotlin.o dstr$allActiveWallets$allEvmWallets) {
        List t0;
        Set M0;
        kotlin.jvm.internal.m.g(dstr$allActiveWallets$allEvmWallets, "$dstr$allActiveWallets$allEvmWallets");
        List allEvmWallets = (List) dstr$allActiveWallets$allEvmWallets.b();
        kotlin.jvm.internal.m.f(allEvmWallets, "allEvmWallets");
        t0 = kotlin.a0.z.t0((List) dstr$allActiveWallets$allEvmWallets.a(), allEvmWallets);
        M0 = kotlin.a0.z.M0(t0);
        return M0;
    }

    /* renamed from: containsAddress$lambda-18 */
    public static final Boolean m1889containsAddress$lambda18(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.getValue() != null);
    }

    public static /* synthetic */ boolean d(Boolean bool) {
        return m1914observeWalletUpdates$lambda42(bool);
    }

    public static /* synthetic */ List e(List list) {
        return m1900getUserOwnedCryptoCurrencies$lambda46(list);
    }

    public static /* synthetic */ Network f(WalletRepository walletRepository, Blockchain blockchain, List list) {
        return m1903observeNetwork$lambda8(walletRepository, blockchain, list);
    }

    private final List<Wallet> filterActiveWallets(List<Wallet> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Blockchain blockchain : this.repositories.keySet()) {
            linkedHashMap.put(blockchain, getNetwork(blockchain));
            linkedHashMap2.put(blockchain, getActiveIndex(blockchain));
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Wallet wallet = (Wallet) obj;
            Blockchain blockchain2 = wallet.getBlockchain();
            boolean isWalletIndexSwitchable = ((WalletManaging) Map_CoreKt.require(this.repositories, blockchain2)).getConfiguration().isWalletIndexSwitchable();
            boolean z = false;
            if (kotlin.jvm.internal.m.c(wallet.getNetwork(), linkedHashMap.get(blockchain2)) && (!isWalletIndexSwitchable || kotlin.jvm.internal.m.c(wallet.getSelectedIndex(), linkedHashMap2.get(blockchain2)))) {
                z = true;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ h.c.h0 g(WalletRepository walletRepository, List list) {
        return m1892getCryptoCurrencies$lambda12$lambda10(walletRepository, list);
    }

    private final Integer getActiveIndex(Blockchain blockchain) {
        WalletManaging walletManaging = this.repositories.get(blockchain);
        WalletConfiguration configuration = walletManaging == null ? null : walletManaging.getConfiguration();
        if (configuration != null && configuration.isWalletIndexSwitchable()) {
            Integer num = (Integer) this.store.get(StoreKeys_WalletsKt.activeIndex(StoreKeys.INSTANCE, blockchain));
            return Integer.valueOf(num == null ? 0 : num.intValue());
        }
        return null;
    }

    /* renamed from: getAllActiveEthWallets$lambda-6 */
    public static final List m1890getAllActiveEthWallets$lambda6(WalletRepository this$0, List wallets) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : wallets) {
            Wallet wallet = (Wallet) obj;
            Blockchain blockchain = wallet.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion)) && kotlin.jvm.internal.m.c(wallet.getSelectedIndex(), this$0.getActiveIndex(Blockchain_EthereumKt.getETHEREUM(companion)))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: getCryptoCurrencies$lambda-12 */
    public static final h.c.h0 m1891getCryptoCurrencies$lambda12(WalletRepository this$0, Throwable it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.cryptoCurrencyAPI.getCryptoCurrencies(1).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.q0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.g(WalletRepository.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.l1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.B((Optional) obj);
            }
        });
    }

    /* renamed from: getCryptoCurrencies$lambda-12$lambda-10 */
    public static final h.c.h0 m1892getCryptoCurrencies$lambda12$lambda10(WalletRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.cryptoCurrencyDAO.saveCryptoCurrencies(it);
    }

    /* renamed from: getCryptoCurrencies$lambda-12$lambda-11 */
    public static final List m1893getCryptoCurrencies$lambda12$lambda11(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        List list = (List) it.toNullable();
        if (list != null) {
            return list;
        }
        throw CryptoCurrencyException.UnableToFindCryptoCurrency.INSTANCE;
    }

    /* renamed from: getCryptoCurrencies$lambda-13 */
    public static final List m1894getCryptoCurrencies$lambda13(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        if (it.isEmpty()) {
            throw CryptoCurrencyException.UnableToFindCryptoCurrency.INSTANCE;
        }
        return it;
    }

    /* renamed from: getCryptoCurrencies$lambda-17 */
    public static final h.c.h0 m1895getCryptoCurrencies$lambda17(List list, WalletRepository this$0, Throwable it) {
        int r;
        final List P;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        if (list == null) {
            return this$0.getUserOwnedCryptoCurrencies();
        }
        r = kotlin.a0.s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add((CurrencyCode) it2.next());
        }
        P = kotlin.a0.z.P(arrayList);
        return this$0.getUserOwnedCryptoCurrencies().map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.u0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.k(P, (List) obj);
            }
        });
    }

    /* renamed from: getCryptoCurrencies$lambda-17$lambda-16 */
    public static final List m1896getCryptoCurrencies$lambda17$lambda16(List distinctCurrencyCodes, List currencies) {
        kotlin.jvm.internal.m.g(distinctCurrencyCodes, "$distinctCurrencyCodes");
        kotlin.jvm.internal.m.g(currencies, "currencies");
        ArrayList arrayList = new ArrayList();
        for (Object obj : currencies) {
            if (distinctCurrencyCodes.contains(((CryptoCurrency) obj).getCode())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final Network getNetwork(Blockchain blockchain) {
        Network network = (Network) this.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, blockchain));
        return network == null ? ((NetworkSetting) Map_CoreKt.require(this.networks, blockchain)).getMainnetNetworkSettingItem().getNetwork() : network;
    }

    /* renamed from: getPrimaryReceiveAddresses$lambda-20$lambda-19 */
    public static final kotlin.o m1897getPrimaryReceiveAddresses$lambda20$lambda19(WalletConfiguration config, Optional it) {
        kotlin.jvm.internal.m.g(config, "$config");
        kotlin.jvm.internal.m.g(it, "it");
        Address address = (Address) it.toNullable();
        if (address != null) {
            return kotlin.u.a(config.getBlockchain(), new WalletAddress(address.getType(), address.getAddress(), address.getIndex()));
        }
        throw new WalletException.UnableToFindPrimaryAddress(config.getBlockchain());
    }

    /* renamed from: getPrimaryReceiveAddresses$lambda-21 */
    public static final Map m1898getPrimaryReceiveAddresses$lambda21(List it) {
        Map r;
        kotlin.jvm.internal.m.g(it, "it");
        r = kotlin.a0.m0.r(it);
        return r;
    }

    private final h.c.a0 getRefreshScheduler() {
        return (h.c.a0) this.refreshScheduler$delegate.getValue();
    }

    private final ConcurrentHashMap<Blockchain, WalletRefreshState> getRefreshStates() {
        return (ConcurrentHashMap) this.refreshStates$delegate.getValue();
    }

    private final h.c.b0<List<CryptoCurrency>> getUserOwnedCryptoCurrencies() {
        h.c.b0<List<CryptoCurrency>> map = this.walletDao.getWallets().map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.m0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.c(WalletRepository.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.o0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.e((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletDao\n        .getWallets()\n        .map { filterActiveWallets(it) }\n        .map { wallets ->\n            wallets.mapIndexed { index, wallet ->\n                CryptoCurrency(\n                    code = wallet.currencyCode,\n                    name = wallet.displayName,\n                    imageUrl = wallet.imageURL,\n                    decimals = wallet.decimals,\n                    blockchain = wallet.blockchain,\n                    sortIndex = index\n                )\n            }\n        }");
        return map;
    }

    /* renamed from: getUserOwnedCryptoCurrencies$lambda-44 */
    public static final List m1899getUserOwnedCryptoCurrencies$lambda44(WalletRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.filterActiveWallets(it);
    }

    /* renamed from: getUserOwnedCryptoCurrencies$lambda-46 */
    public static final List m1900getUserOwnedCryptoCurrencies$lambda46(List wallets) {
        int r;
        kotlin.jvm.internal.m.g(wallets, "wallets");
        r = kotlin.a0.s.r(wallets, 10);
        ArrayList arrayList = new ArrayList(r);
        int i2 = 0;
        for (Object obj : wallets) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a0.r.q();
            }
            Wallet wallet = (Wallet) obj;
            arrayList.add(new CryptoCurrency(wallet.getCurrencyCode(), wallet.getDisplayName(), wallet.getImageURL(), wallet.getDecimals(), wallet.getBlockchain(), i2));
            i2 = i3;
        }
        return arrayList;
    }

    public static /* synthetic */ Map h(List list) {
        return m1898getPrimaryReceiveAddresses$lambda21(list);
    }

    /* renamed from: hasWallets$lambda-3 */
    public static final Boolean m1901hasWallets$lambda3(List result) {
        kotlin.jvm.internal.m.g(result, "result");
        return Boolean.valueOf(!result.contains(Boolean.FALSE));
    }

    public static /* synthetic */ Optional i(Throwable th) {
        return m1912observeWalletUpdates$lambda39(th);
    }

    /* renamed from: isSynced$lambda-9 */
    public static final Boolean m1902isSynced$lambda9(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        Boolean bool = (Boolean) it.toNullable();
        return Boolean.valueOf(bool == null ? false : bool.booleanValue());
    }

    public static /* synthetic */ Optional j(List list) {
        return m1911observeWalletUpdates$lambda38(list);
    }

    public static /* synthetic */ List k(List list, List list2) {
        return m1896getCryptoCurrencies$lambda17$lambda16(list, list2);
    }

    public static /* synthetic */ int l(Map map, Wallet wallet, Wallet wallet2) {
        return m1910observeWalletUpdates$lambda37$lambda36$lambda35(map, wallet, wallet2);
    }

    public static /* synthetic */ List m(Throwable th) {
        return m1906observeWalletUpdates$lambda37$lambda25(th);
    }

    public static /* synthetic */ Boolean n(Optional optional) {
        return m1889containsAddress$lambda18(optional);
    }

    public static /* synthetic */ Boolean o(List list) {
        return m1901hasWallets$lambda3(list);
    }

    /* renamed from: observeNetwork$lambda-8 */
    public static final Network m1903observeNetwork$lambda8(WalletRepository this$0, Blockchain blockchain, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(it, "it");
        Network network = (Network) this$0.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, blockchain));
        return network == null ? ((NetworkSetting) Map_CoreKt.require(this$0.networks, blockchain)).getMainnetNetworkSettingItem().getNetwork() : network;
    }

    private final void observeWalletUpdates() {
        h.c.s map = h.c.s.merge(this.reloadWalletsSubject.flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.q1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.G(WalletRepository.this, (kotlin.x) obj);
            }
        }), this.walletDao.observeWallets()).concatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.m1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.C(WalletRepository.this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.t0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.j((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "merge(\n                reloadWalletsSubject.flatMapSingle { walletDao.getWallets() },\n                walletDao.observeWallets()\n            )\n            .concatMap { observedWallets ->\n                val wallets = filterActiveWallets(observedWallets)\n                if (wallets.isEmpty()) {\n                    return@concatMap Observable.just(emptyList<Wallet>())\n                }\n\n                compoundFinanceRepository.supportedTokens()\n                    .onErrorReturn { emptyList() }\n                    .flatMap { compoundTokens ->\n                        val compoundCurrencyCodes = compoundTokens.map { it.underlyingCode }\n                        val currencyCodes = wallets.map { it.currencyCode } + compoundCurrencyCodes\n                        val getCryptoCurrencies = getCryptoCurrencies(currencyCodes)\n                            .onErrorReturn { emptyList() }\n\n                        Singles.zip(getCryptoCurrencies, Single.just(compoundTokens))\n                    }\n                    .map { (cryptoCurrencies, compoundSupportedTokens) ->\n                        // generate a map of cryptocurrency code -> sort index\n                        // the lower the sort index, the higher the market cap\n                        val cryptoCurrenciesSortOrder = cryptoCurrencies\n                            .map { it.code to it.sortIndex.toDouble() }.toMap().toMutableMap()\n\n                        // group CETH and USDC near ETH\n                        cryptoCurrenciesSortOrder[CurrencyCode.ETH]?.also { ethIndex ->\n                            cryptoCurrenciesSortOrder[CurrencyCode.WETH] = ethIndex + 0.1\n                            cryptoCurrenciesSortOrder[CurrencyCode.CETH] = ethIndex + 0.2\n                            cryptoCurrenciesSortOrder[CurrencyCode.USDC] = ethIndex + 0.3\n                        }\n\n                        cryptoCurrenciesSortOrder[CurrencyCode.BTC]?.also { btcIndex ->\n                            cryptoCurrenciesSortOrder[CurrencyCode.WBTC] = btcIndex + 0.1\n                            cryptoCurrenciesSortOrder[CurrencyCode.CWBTC] = btcIndex + 0.2\n                        }\n\n                        // group rest of compound finance tokens near their relevant tokens\n                        // e.g CZRX will be right under ZRX\n                        compoundSupportedTokens\n                            .filter { it.code != CurrencyCode.CETH && it.code != CurrencyCode.CWBTC }\n                            .forEach { cToken ->\n                                val targetTokenIndex = cryptoCurrenciesSortOrder[cToken.underlyingCode]\n                                    ?: return@forEach\n\n                                cryptoCurrenciesSortOrder[cToken.code] = targetTokenIndex + 0.5\n                            }\n\n                        // sort the coins by marketcap DESC\n                        wallets.sortedWith(\n                            Comparator { lhs, rhs ->\n                                val lhsSortIndex = cryptoCurrenciesSortOrder[lhs.currencyCode] ?: Double.MAX_VALUE\n                                val rhsSortIndex = cryptoCurrenciesSortOrder[rhs.currencyCode] ?: Double.MAX_VALUE\n\n                                lhsSortIndex.compareTo(rhsSortIndex)\n                            }\n                        )\n                    }\n                    .toObservable()\n            }\n            .map { it.toOptional() }");
        h.c.s onErrorReturn = Observable_AnalyticsKt.logError$default(map, "Error while observing WalletRepository.wallets", null, 2, null).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.s0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.i((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "merge(\n                reloadWalletsSubject.flatMapSingle { walletDao.getWallets() },\n                walletDao.observeWallets()\n            )\n            .concatMap { observedWallets ->\n                val wallets = filterActiveWallets(observedWallets)\n                if (wallets.isEmpty()) {\n                    return@concatMap Observable.just(emptyList<Wallet>())\n                }\n\n                compoundFinanceRepository.supportedTokens()\n                    .onErrorReturn { emptyList() }\n                    .flatMap { compoundTokens ->\n                        val compoundCurrencyCodes = compoundTokens.map { it.underlyingCode }\n                        val currencyCodes = wallets.map { it.currencyCode } + compoundCurrencyCodes\n                        val getCryptoCurrencies = getCryptoCurrencies(currencyCodes)\n                            .onErrorReturn { emptyList() }\n\n                        Singles.zip(getCryptoCurrencies, Single.just(compoundTokens))\n                    }\n                    .map { (cryptoCurrencies, compoundSupportedTokens) ->\n                        // generate a map of cryptocurrency code -> sort index\n                        // the lower the sort index, the higher the market cap\n                        val cryptoCurrenciesSortOrder = cryptoCurrencies\n                            .map { it.code to it.sortIndex.toDouble() }.toMap().toMutableMap()\n\n                        // group CETH and USDC near ETH\n                        cryptoCurrenciesSortOrder[CurrencyCode.ETH]?.also { ethIndex ->\n                            cryptoCurrenciesSortOrder[CurrencyCode.WETH] = ethIndex + 0.1\n                            cryptoCurrenciesSortOrder[CurrencyCode.CETH] = ethIndex + 0.2\n                            cryptoCurrenciesSortOrder[CurrencyCode.USDC] = ethIndex + 0.3\n                        }\n\n                        cryptoCurrenciesSortOrder[CurrencyCode.BTC]?.also { btcIndex ->\n                            cryptoCurrenciesSortOrder[CurrencyCode.WBTC] = btcIndex + 0.1\n                            cryptoCurrenciesSortOrder[CurrencyCode.CWBTC] = btcIndex + 0.2\n                        }\n\n                        // group rest of compound finance tokens near their relevant tokens\n                        // e.g CZRX will be right under ZRX\n                        compoundSupportedTokens\n                            .filter { it.code != CurrencyCode.CETH && it.code != CurrencyCode.CWBTC }\n                            .forEach { cToken ->\n                                val targetTokenIndex = cryptoCurrenciesSortOrder[cToken.underlyingCode]\n                                    ?: return@forEach\n\n                                cryptoCurrenciesSortOrder[cToken.code] = targetTokenIndex + 0.5\n                            }\n\n                        // sort the coins by marketcap DESC\n                        wallets.sortedWith(\n                            Comparator { lhs, rhs ->\n                                val lhsSortIndex = cryptoCurrenciesSortOrder[lhs.currencyCode] ?: Double.MAX_VALUE\n                                val rhsSortIndex = cryptoCurrenciesSortOrder[rhs.currencyCode] ?: Double.MAX_VALUE\n\n                                lhsSortIndex.compareTo(rhsSortIndex)\n                            }\n                        )\n                    }\n                    .toObservable()\n            }\n            .map { it.toOptional() }\n            .logError(\"Error while observing WalletRepository.wallets\")\n            .onErrorReturn { null.toOptional() }");
        h.c.s map2 = onErrorReturn.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.wallets.repositories.WalletRepository$observeWalletUpdates$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.WalletRepository$observeWalletUpdates$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map2, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        h.c.s observeWalletChanges = map2.map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.n1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.D(WalletRepository.this, (List) obj);
            }
        }).distinctUntilChanged();
        h.c.t0.c cVar = h.c.t0.c.a;
        kotlin.jvm.internal.m.f(observeWalletChanges, "observeWalletChanges");
        h.c.s<Boolean> hide = this.isReadySubject.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.wallets.repositories.n0
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return WalletRepository.d((Boolean) obj);
            }
        }).hide();
        kotlin.jvm.internal.m.f(hide, "isReadySubject.filter { it }.hide()");
        h.c.s a = cVar.a(observeWalletChanges, hide);
        kotlin.jvm.internal.m.f(a, "Observables.combineLatest(observeWalletChanges, isReadySubject.filter { it }.hide())");
        h.c.t0.a.a(h.c.t0.g.h(a, null, null, new WalletRepository$observeWalletUpdates$2(this), 3, null), this.disposeBag);
    }

    /* renamed from: observeWalletUpdates$lambda-24 */
    public static final h.c.h0 m1904observeWalletUpdates$lambda24(WalletRepository this$0, kotlin.x it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.walletDao.getWallets();
    }

    /* renamed from: observeWalletUpdates$lambda-37 */
    public static final h.c.x m1905observeWalletUpdates$lambda37(final WalletRepository this$0, List observedWallets) {
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(observedWallets, "observedWallets");
        final List<Wallet> filterActiveWallets = this$0.filterActiveWallets(observedWallets);
        if (filterActiveWallets.isEmpty()) {
            g2 = kotlin.a0.r.g();
            return h.c.s.just(g2);
        }
        return this$0.compoundFinanceRepository.supportedTokens().onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.w0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.m((Throwable) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.c1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.s(filterActiveWallets, this$0, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.f1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.v(filterActiveWallets, (kotlin.o) obj);
            }
        }).toObservable();
    }

    /* renamed from: observeWalletUpdates$lambda-37$lambda-25 */
    public static final List m1906observeWalletUpdates$lambda37$lambda25(Throwable it) {
        List g2;
        kotlin.jvm.internal.m.g(it, "it");
        g2 = kotlin.a0.r.g();
        return g2;
    }

    /* renamed from: observeWalletUpdates$lambda-37$lambda-29 */
    public static final h.c.h0 m1907observeWalletUpdates$lambda37$lambda29(List wallets, WalletRepository this$0, List compoundTokens) {
        int r;
        int r2;
        List<CurrencyCode> t0;
        kotlin.jvm.internal.m.g(wallets, "$wallets");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(compoundTokens, "compoundTokens");
        r = kotlin.a0.s.r(compoundTokens, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = compoundTokens.iterator();
        while (it.hasNext()) {
            arrayList.add(((CompoundToken) it.next()).getUnderlyingCode());
        }
        r2 = kotlin.a0.s.r(wallets, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        Iterator it2 = wallets.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Wallet) it2.next()).getCurrencyCode());
        }
        t0 = kotlin.a0.z.t0(arrayList2, arrayList);
        h.c.b0<List<CryptoCurrency>> onErrorReturn = this$0.getCryptoCurrencies(t0).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.b1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.r((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorReturn, "getCryptoCurrencies(currencyCodes)\n                            .onErrorReturn { emptyList() }");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(compoundTokens);
        kotlin.jvm.internal.m.f(just, "just(compoundTokens)");
        return eVar.a(onErrorReturn, just);
    }

    /* renamed from: observeWalletUpdates$lambda-37$lambda-29$lambda-28 */
    public static final List m1908observeWalletUpdates$lambda37$lambda29$lambda28(Throwable it) {
        List g2;
        kotlin.jvm.internal.m.g(it, "it");
        g2 = kotlin.a0.r.g();
        return g2;
    }

    /* renamed from: observeWalletUpdates$lambda-37$lambda-36 */
    public static final List m1909observeWalletUpdates$lambda37$lambda36(List wallets, kotlin.o dstr$cryptoCurrencies$compoundSupportedTokens) {
        int r;
        Map r2;
        final Map v;
        List B0;
        kotlin.jvm.internal.m.g(wallets, "$wallets");
        kotlin.jvm.internal.m.g(dstr$cryptoCurrencies$compoundSupportedTokens, "$dstr$cryptoCurrencies$compoundSupportedTokens");
        List<CryptoCurrency> cryptoCurrencies = (List) dstr$cryptoCurrencies$compoundSupportedTokens.a();
        List compoundSupportedTokens = (List) dstr$cryptoCurrencies$compoundSupportedTokens.b();
        kotlin.jvm.internal.m.f(cryptoCurrencies, "cryptoCurrencies");
        r = kotlin.a0.s.r(cryptoCurrencies, 10);
        ArrayList arrayList = new ArrayList(r);
        for (CryptoCurrency cryptoCurrency : cryptoCurrencies) {
            arrayList.add(kotlin.u.a(cryptoCurrency.getCode(), Double.valueOf(cryptoCurrency.getSortIndex())));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        v = kotlin.a0.m0.v(r2);
        CurrencyCode.Companion companion = CurrencyCode.Companion;
        Double d2 = (Double) v.get(CurrencyCode_EthereumKt.getETH(companion));
        if (d2 != null) {
            double doubleValue = d2.doubleValue();
            v.put(CurrencyCode_EthereumKt.getWETH(companion), Double.valueOf(doubleValue + 0.1d));
            v.put(CurrencyCode_WalletsKt.getCETH(companion), Double.valueOf(doubleValue + 0.2d));
            v.put(companion.getUSDC(), Double.valueOf(doubleValue + 0.3d));
        }
        Double d3 = (Double) v.get(CurrencyCode_BitcoinKt.getBTC(companion));
        if (d3 != null) {
            double doubleValue2 = d3.doubleValue();
            v.put(CurrencyCode_WalletsKt.getWBTC(companion), Double.valueOf(0.1d + doubleValue2));
            v.put(CurrencyCode_WalletsKt.getCWBTC(companion), Double.valueOf(doubleValue2 + 0.2d));
        }
        kotlin.jvm.internal.m.f(compoundSupportedTokens, "compoundSupportedTokens");
        ArrayList<CompoundToken> arrayList2 = new ArrayList();
        for (Object obj : compoundSupportedTokens) {
            CompoundToken compoundToken = (CompoundToken) obj;
            CurrencyCode code = compoundToken.getCode();
            CurrencyCode.Companion companion2 = CurrencyCode.Companion;
            if ((kotlin.jvm.internal.m.c(code, CurrencyCode_WalletsKt.getCETH(companion2)) || kotlin.jvm.internal.m.c(compoundToken.getCode(), CurrencyCode_WalletsKt.getCWBTC(companion2))) ? false : true) {
                arrayList2.add(obj);
            }
        }
        for (CompoundToken compoundToken2 : arrayList2) {
            Double d4 = (Double) v.get(compoundToken2.getUnderlyingCode());
            if (d4 != null) {
                v.put(compoundToken2.getCode(), Double.valueOf(d4.doubleValue() + 0.5d));
            }
        }
        B0 = kotlin.a0.z.B0(wallets, new Comparator() { // from class: com.coinbase.wallet.wallets.repositories.v0
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return WalletRepository.l(v, (Wallet) obj2, (Wallet) obj3);
            }
        });
        return B0;
    }

    /* renamed from: observeWalletUpdates$lambda-37$lambda-36$lambda-35 */
    public static final int m1910observeWalletUpdates$lambda37$lambda36$lambda35(Map cryptoCurrenciesSortOrder, Wallet wallet, Wallet wallet2) {
        kotlin.jvm.internal.m.g(cryptoCurrenciesSortOrder, "$cryptoCurrenciesSortOrder");
        Double d2 = (Double) cryptoCurrenciesSortOrder.get(wallet.getCurrencyCode());
        double doubleValue = d2 == null ? Double.MAX_VALUE : d2.doubleValue();
        Double d3 = (Double) cryptoCurrenciesSortOrder.get(wallet2.getCurrencyCode());
        return Double.compare(doubleValue, d3 != null ? d3.doubleValue() : Double.MAX_VALUE);
    }

    /* renamed from: observeWalletUpdates$lambda-38 */
    public static final Optional m1911observeWalletUpdates$lambda38(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    /* renamed from: observeWalletUpdates$lambda-39 */
    public static final Optional m1912observeWalletUpdates$lambda39(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    /* renamed from: observeWalletUpdates$lambda-41 */
    public static final kotlin.o m1913observeWalletUpdates$lambda41(WalletRepository this$0, List wallets) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(wallets, "wallets");
        ArrayList arrayList = new ArrayList();
        for (Object obj : wallets) {
            Wallet wallet = (Wallet) obj;
            if (!kotlin.jvm.internal.m.c(wallet.getBalance(), BigInteger.ZERO) && kotlin.jvm.internal.m.c(this$0.store.get(StoreKeys_WalletsKt.isWalletSynced(StoreKeys.INSTANCE, wallet.getBlockchain(), wallet.getNetwork())), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        return new kotlin.o(wallets, arrayList);
    }

    /* renamed from: observeWalletUpdates$lambda-42 */
    public static final boolean m1914observeWalletUpdates$lambda42(Boolean it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.booleanValue();
    }

    public static /* synthetic */ h.c.h0 p(WalletRepository walletRepository, List list) {
        return m1916start$lambda23(walletRepository, list);
    }

    public static /* synthetic */ List q(WalletRepository walletRepository, List list) {
        return m1890getAllActiveEthWallets$lambda6(walletRepository, list);
    }

    public static /* synthetic */ List r(Throwable th) {
        return m1908observeWalletUpdates$lambda37$lambda29$lambda28(th);
    }

    private final h.c.k0.b refreshRepository(final WalletManaging walletManaging, final RefreshContext refreshContext) {
        h.c.k0.b c2 = getRefreshScheduler().c(new Runnable() { // from class: com.coinbase.wallet.wallets.repositories.h1
            @Override // java.lang.Runnable
            public final void run() {
                WalletRepository.x(WalletManaging.this, this, refreshContext);
            }
        });
        kotlin.jvm.internal.m.f(c2, "refreshScheduler.scheduleDirect {\n        val isSyncingRequired = repository.configuration.isSyncingRequired\n        val blockchain = repository.configuration.blockchain\n        val refreshState = refreshStates[blockchain] ?: return@scheduleDirect\n\n        if (context.isForced) {\n            refreshState.cancel()\n        }\n\n        if (!refreshState.canRefresh()) {\n            return@scheduleDirect\n        }\n\n        val requestId = refreshState.start()\n        val repoName = repository.configuration.blockchain.rawValue\n        repository.refresh(context)\n            .trace(TraceKey.walletRepositoryRefreshTrace(repoName, requestId), tracer)\n            .subscribeBy(\n                onSuccess = {\n                    refreshState.completed(requestId)\n\n                    val isWalletSyncedKey = StoreKeys.isWalletSynced(blockchain, context.network)\n\n                    if (store.get(isWalletSyncedKey) == true) {\n                        return@subscribeBy\n                    }\n\n                    // If syncing is required, then full refresh is needed before marking blockchain as synced.\n                    // Otherwise, mark blockchain as synced once a refresh successfully completes\n                    if ((isSyncingRequired && context.mode == Full) || !isSyncingRequired) {\n                        store.set(isWalletSyncedKey, true)\n                        reloadWalletsSubject.onNext(Unit)\n                    }\n                },\n                onError = { refreshState.failed(requestId) }\n            )\n            .addTo(refreshState.disposeBag)\n    }");
        return c2;
    }

    /* renamed from: refreshRepository$lambda-43 */
    public static final void m1915refreshRepository$lambda43(WalletManaging repository, WalletRepository this$0, RefreshContext context) {
        kotlin.jvm.internal.m.g(repository, "$repository");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(context, "$context");
        boolean isSyncingRequired = repository.getConfiguration().isSyncingRequired();
        Blockchain blockchain = repository.getConfiguration().getBlockchain();
        WalletRefreshState walletRefreshState = this$0.getRefreshStates().get(blockchain);
        if (walletRefreshState == null) {
            return;
        }
        if (context.isForced()) {
            walletRefreshState.cancel();
        }
        if (walletRefreshState.canRefresh()) {
            String start = walletRefreshState.start();
            h.c.b0 trace = Single_CoreKt.trace(repository.refresh(context), TraceKey_WalletsKt.walletRepositoryRefreshTrace(TraceKey.Companion, repository.getConfiguration().getBlockchain().getRawValue(), start), this$0.tracer);
            kotlin.jvm.internal.m.f(trace, "repository.refresh(context)\n            .trace(TraceKey.walletRepositoryRefreshTrace(repoName, requestId), tracer)");
            h.c.t0.a.a(h.c.t0.g.f(trace, new WalletRepository$refreshRepository$1$1(walletRefreshState, start), new WalletRepository$refreshRepository$1$2(walletRefreshState, start, blockchain, context, this$0, isSyncingRequired)), walletRefreshState.getDisposeBag());
        }
    }

    public static /* synthetic */ h.c.h0 s(List list, WalletRepository walletRepository, List list2) {
        return m1907observeWalletUpdates$lambda37$lambda29(list, walletRepository, list2);
    }

    /* renamed from: start$lambda-23 */
    public static final h.c.h0 m1916start$lambda23(WalletRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.cryptoCurrencyDAO.saveCryptoCurrencies(it);
    }

    public static /* synthetic */ h.c.x t(WalletRepository walletRepository, kotlin.o oVar) {
        return m1919watchAddresses$lambda53$lambda52$lambda51(walletRepository, oVar);
    }

    public static /* synthetic */ List u(List list) {
        return m1894getCryptoCurrencies$lambda13(list);
    }

    public static /* synthetic */ List v(List list, kotlin.o oVar) {
        return m1909observeWalletUpdates$lambda37$lambda36(list, oVar);
    }

    public static /* synthetic */ h.c.h0 w(WalletRepository walletRepository, Throwable th) {
        return m1891getCryptoCurrencies$lambda12(walletRepository, th);
    }

    private final h.c.k0.b watchAddresses() {
        h.c.s concatMap = h.c.s.just(kotlin.x.a).delay(10L, TimeUnit.SECONDS).concatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.o1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.E(WalletRepository.this, (kotlin.x) obj);
            }
        });
        kotlin.jvm.internal.m.f(concatMap, "just(Unit)\n        .delay(10, TimeUnit.SECONDS)\n        .concatMap {\n            networks.values\n                .mapNotNull { networkSetting ->\n                    when (networkSetting.blockchain) {\n                        Blockchain.ETHEREUM, Blockchain.ETHEREUM_CLASSIC -> { null }\n                        else -> {\n                            val repository = repositories.require(networkSetting.blockchain)\n                            val addressSingle = addressDao\n                                .getOrderedAddresses(\n                                    blockchain = networkSetting.blockchain,\n                                    currencyCode = repository.configuration.currencyCode,\n                                    network = networkSetting.mainnetNetworkSettingItem.network\n                                )\n                                .map { addresses -> addresses.map { it.address } }\n                                .toObservable()\n\n                            Observables.zip(Observable.just(networkSetting.blockchain), addressSingle)\n                                .concatMap { (blockchain, addresses) ->\n                                    watchAddressAPI.watchAddresses(addresses, blockchain)\n                                        .logError()\n                                        .onErrorReturnItem(Unit)\n                                        .toObservable()\n                                }\n                        }\n                    }\n                }\n                .concatAll()\n        }");
        return h.c.t0.a.a(h.c.t0.g.h(concatMap, null, null, null, 7, null), this.disposeBag);
    }

    /* renamed from: watchAddresses$lambda-53 */
    public static final h.c.x m1917watchAddresses$lambda53(WalletRepository this$0, kotlin.x it) {
        h.c.s concatMap;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        Collection<NetworkSetting> values = this$0.networks.values();
        ArrayList arrayList = new ArrayList();
        for (NetworkSetting networkSetting : values) {
            Blockchain blockchain = networkSetting.getBlockchain();
            Blockchain.Companion companion = Blockchain.Companion;
            if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
                concatMap = null;
            } else {
                h.c.s addressSingle = this$0.addressDao.getOrderedAddresses(networkSetting.getBlockchain(), ((WalletManaging) Map_CoreKt.require(this$0.repositories, networkSetting.getBlockchain())).getConfiguration().getCurrencyCode(), networkSetting.getMainnetNetworkSettingItem().getNetwork()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.l0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return WalletRepository.b((List) obj);
                    }
                }).toObservable();
                h.c.t0.c cVar = h.c.t0.c.a;
                h.c.s just = h.c.s.just(networkSetting.getBlockchain());
                kotlin.jvm.internal.m.f(just, "just(networkSetting.blockchain)");
                kotlin.jvm.internal.m.f(addressSingle, "addressSingle");
                concatMap = cVar.c(just, addressSingle).concatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.d1
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return WalletRepository.t(WalletRepository.this, (kotlin.o) obj);
                    }
                });
            }
            if (concatMap != null) {
                arrayList.add(concatMap);
            }
        }
        return h.c.t0.b.a(arrayList);
    }

    /* renamed from: watchAddresses$lambda-53$lambda-52$lambda-50 */
    public static final List m1918watchAddresses$lambda53$lambda52$lambda50(List addresses) {
        int r;
        kotlin.jvm.internal.m.g(addresses, "addresses");
        r = kotlin.a0.s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = addresses.iterator();
        while (it.hasNext()) {
            arrayList.add(((Address) it.next()).getAddress());
        }
        return arrayList;
    }

    /* renamed from: watchAddresses$lambda-53$lambda-52$lambda-51 */
    public static final h.c.x m1919watchAddresses$lambda53$lambda52$lambda51(WalletRepository this$0, kotlin.o dstr$blockchain$addresses) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$blockchain$addresses, "$dstr$blockchain$addresses");
        Blockchain blockchain = (Blockchain) dstr$blockchain$addresses.a();
        List<String> addresses = (List) dstr$blockchain$addresses.b();
        WatchAddressAPI watchAddressAPI = this$0.watchAddressAPI;
        kotlin.jvm.internal.m.f(addresses, "addresses");
        kotlin.jvm.internal.m.f(blockchain, "blockchain");
        return Single_AnalyticsKt.logError$default(watchAddressAPI.watchAddresses(addresses, blockchain), null, null, 3, null).onErrorReturnItem(kotlin.x.a).toObservable();
    }

    public static /* synthetic */ void x(WalletManaging walletManaging, WalletRepository walletRepository, RefreshContext refreshContext) {
        m1915refreshRepository$lambda43(walletManaging, walletRepository, refreshContext);
    }

    public static /* synthetic */ Boolean y(Optional optional) {
        return m1902isSynced$lambda9(optional);
    }

    public static /* synthetic */ h.c.h0 z(List list, WalletRepository walletRepository, Throwable th) {
        return m1895getCryptoCurrencies$lambda17(list, walletRepository, th);
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.s<Set<Wallet>> consumerWalletsObservableAVAXFix() {
        h.c.t0.c cVar = h.c.t0.c.a;
        h.c.s<List<Wallet>> observeWallets = observeWallets(false);
        h.c.s<List<Wallet>> observable = getAllActiveEthWallets().toObservable();
        kotlin.jvm.internal.m.f(observable, "getAllActiveEthWallets().toObservable()");
        h.c.s<Set<Wallet>> map = cVar.a(observeWallets, observable).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.p1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.F((kotlin.o) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Observables.combineLatest(\n            observeWallets(false),\n            getAllActiveEthWallets().toObservable()\n        ).map { (allActiveWallets, allEvmWallets) ->\n            (allActiveWallets + allEvmWallets).toSet()\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<Boolean> containsAddress(Blockchain blockchain, CurrencyCode currencyCode, String address) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(address, "address");
        h.c.b0 map = this.addressDao.getAddress(blockchain, currencyCode, getNetwork(blockchain), address).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.x0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.n((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "addressDao\n        .getAddress(\n            blockchain = blockchain,\n            currencyCode = currencyCode,\n            network = getNetwork(blockchain),\n            address = address\n        )\n        .map { it.value != null }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<kotlin.x> createWallets(String mnemonic) {
        int r;
        h.c.b0 zip;
        List g2;
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        Collection<WalletManaging> values = this.repositories.values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (WalletManaging walletManaging : values) {
            String uuid = UUID.randomUUID().toString();
            kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
            CurrencyCode currencyCode = walletManaging.getConfiguration().getCurrencyCode();
            h.c.b0<kotlin.x> createWallets = walletManaging.createWallets(mnemonic);
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            arrayList.add(Single_AnalyticsKt.onEventTrack(createWallets, AnalyticsEvent_WalletsKt.createWalletStart(companion, currencyCode.getRawValue(), uuid), AnalyticsEvent_WalletsKt.createWalletSuccess(companion, currencyCode.getRawValue(), uuid), AnalyticsEvent_WalletsKt.createWalletFail$default(companion, currencyCode.getRawValue(), null, uuid, 2, null)));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.WalletRepository$createWallets$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof kotlin.x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        return Single_CoreKt.asUnit(zip);
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        List<Wallet> g2;
        List<Wallet> g3;
        this.disposeBag.d();
        this.isReadySubject.onNext(Boolean.FALSE);
        h.c.v0.c<List<Wallet>> cVar = this.usableWalletsSubject;
        g2 = kotlin.a0.r.g();
        cVar.onNext(g2);
        h.c.v0.c<List<Wallet>> cVar2 = this.allWalletsSubject;
        g3 = kotlin.a0.r.g();
        cVar2.onNext(g3);
        h.c.b0<Boolean> just = h.c.b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "just(true)");
        return just;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<List<Wallet>> getAllActiveEthWallets() {
        h.c.b0 map = this.walletDao.getWallets().map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.a1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.q(WalletRepository.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "walletDao.getWallets().map { wallets ->\n            wallets.filter { wallet ->\n                wallet.blockchain == Blockchain.ETHEREUM && wallet.selectedIndex == getActiveIndex(Blockchain.ETHEREUM)\n            }\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<List<CryptoCurrency>> getCryptoCurrencies(final List<CurrencyCode> list) {
        h.c.b0<List<CryptoCurrency>> cryptoCurrencies;
        if (list == null) {
            cryptoCurrencies = this.cryptoCurrencyDAO.getCryptoCurrencies();
        } else {
            cryptoCurrencies = this.cryptoCurrencyDAO.getCryptoCurrencies(list);
        }
        h.c.b0 onErrorResumeNext = Single_AnalyticsKt.logError$default(cryptoCurrencies, null, null, 3, null).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.g1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.w(WalletRepository.this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext, "getCurrencies\n            .logError()\n            .onErrorResumeNext {\n                cryptoCurrencyAPI.getCryptoCurrencies(chainId = 1)\n                    .flatMap { cryptoCurrencyDAO.saveCryptoCurrencies(it) }\n                    .map { it.toNullable() ?: throw CryptoCurrencyException.UnableToFindCryptoCurrency }\n            }");
        h.c.b0<List<CryptoCurrency>> onErrorResumeNext2 = Single_AnalyticsKt.logError$default(onErrorResumeNext, null, null, 3, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.e1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.u((List) obj);
            }
        }).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.j1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.z(list, this, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.f(onErrorResumeNext2, "getCurrencies\n            .logError()\n            .onErrorResumeNext {\n                cryptoCurrencyAPI.getCryptoCurrencies(chainId = 1)\n                    .flatMap { cryptoCurrencyDAO.saveCryptoCurrencies(it) }\n                    .map { it.toNullable() ?: throw CryptoCurrencyException.UnableToFindCryptoCurrency }\n            }\n            .logError()\n            .map { if (it.isEmpty()) throw CryptoCurrencyException.UnableToFindCryptoCurrency else it }\n            .onErrorResumeNext {\n                if (currencyCodes == null) {\n                    getUserOwnedCryptoCurrencies()\n                } else {\n                    val distinctCurrencyCodes = currencyCodes.map { it }.distinct()\n                    getUserOwnedCryptoCurrencies()\n                        .map { currencies -> currencies.filter { distinctCurrencyCodes.contains(it.code) } }\n                }\n            }");
        return onErrorResumeNext2;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<Map<Blockchain, WalletAddress>> getPrimaryReceiveAddresses() {
        int r;
        h.c.b0 zip;
        List g2;
        Collection<WalletManaging> values = this.repositories.values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (WalletManaging walletManaging : values) {
            final WalletConfiguration configuration = walletManaging.getConfiguration();
            arrayList.add(this.addressDao.getAddressForIndex(configuration.getBlockchain(), configuration.getCurrencyCode(), configuration.getNetworkSetting().getMainnetNetworkSettingItem().getNetwork(), configuration.getDefaultReceiveType(), false, 0).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.k1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return WalletRepository.A(WalletConfiguration.this, (Optional) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.WalletRepository$getPrimaryReceiveAddresses$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int length = it.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it[i2];
                        if (obj != null ? obj instanceof kotlin.o : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0<Map<Blockchain, WalletAddress>> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.r0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.h((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "repositories.values\n        .map { repo ->\n            val config = repo.configuration\n            val mainNetwork = config.networkSetting.mainnetNetworkSettingItem.network\n            addressDao\n                .getAddressForIndex(\n                    blockchain = config.blockchain,\n                    currencyCode = config.currencyCode,\n                    network = mainNetwork,\n                    addressType = config.defaultReceiveType,\n                    isChangeAddress = false,\n                    index = 0\n                )\n                .map {\n                    val address = it.toNullable()\n                        ?: throw WalletException.UnableToFindPrimaryAddress(config.blockchain)\n\n                    config.blockchain to WalletAddress(address.type, address.address, address.index)\n                }\n        }\n        .zipOrEmpty()\n        .map { it.toMap() }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<List<Address>> getUsedAddresses(Blockchain blockchain, Network network) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(network, "network");
        return this.addressDao.getUsedAddresses(blockchain, network);
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.b0<Boolean> hasWallets() {
        int r;
        h.c.b0 zip;
        List g2;
        Collection<WalletManaging> values = this.repositories.values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (WalletManaging walletManaging : values) {
            arrayList.add(walletManaging.hasWallets());
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.WalletRepository$hasWallets$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof Boolean) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0<Boolean> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.y0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.o((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "repositories\n        .values\n        .map { it.hasWallets() }\n        .zipOrEmpty()\n        .map { result -> !result.contains(false) }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.s<Boolean> isSynced(Blockchain blockchain, Network network) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(network, "network");
        h.c.s<Boolean> map = this.store.observe(StoreKeys_WalletsKt.isWalletSynced(StoreKeys.INSTANCE, blockchain, network)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.i1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.y((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "store.observe(StoreKeys.isWalletSynced(blockchain, network))\n        .map { it.toNullable() ?: false }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.s<Network> observeNetwork(final Blockchain blockchain) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        h.c.s map = observeWallets(false).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.p0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.f(WalletRepository.this, blockchain, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "observeWallets(false)\n        .map {\n            store.get(StoreKeys.activeNetwork(blockchain)) ?: networks\n                .require(blockchain).mainnetNetworkSettingItem.network\n        }");
        return map;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public h.c.s<List<Wallet>> observeWallets(boolean z) {
        h.c.s<List<Wallet>> hide;
        String str;
        if (z) {
            hide = this.usableWalletsSubject.hide();
            str = "usableWalletsSubject.hide()";
        } else {
            hide = this.allWalletsSubject.hide();
            str = "allWalletsSubject.hide()";
        }
        kotlin.jvm.internal.m.f(hide, str);
        return hide;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        for (WalletManaging walletManaging : this.repositories.values()) {
            Blockchain blockchain = walletManaging.getConfiguration().getBlockchain();
            refreshRepository(walletManaging, new RefreshContext(getNetwork(blockchain), getActiveIndex(blockchain), RefreshContext.Mode.Full.INSTANCE, z));
        }
        h.c.b0<kotlin.x> just = h.c.b0.just(kotlin.x.a);
        kotlin.jvm.internal.m.f(just, "just(Unit)");
        return just;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = this.cryptoCurrencyAPI.getCryptoCurrencies(1).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.z0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository.p(WalletRepository.this, (List) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "cryptoCurrencyAPI.getCryptoCurrencies(chainId = 1)\n            .flatMap { cryptoCurrencyDAO.saveCryptoCurrencies(it) }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
        this.isReadySubject.onNext(Boolean.TRUE);
        watchAddresses();
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public void switchIndex(Blockchain blockchain, int i2) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        WalletManaging walletManaging = this.repositories.get(blockchain);
        if (walletManaging != null) {
            if (walletManaging.getConfiguration().isWalletIndexSwitchable()) {
                this.store.set(StoreKeys_WalletsKt.activeIndex(StoreKeys.INSTANCE, blockchain), Integer.valueOf(i2));
                RefreshContext refreshContext = new RefreshContext(getNetwork(blockchain), getActiveIndex(blockchain), RefreshContext.Mode.Quick.INSTANCE, true);
                this.reloadWalletsSubject.onNext(kotlin.x.a);
                refreshRepository(walletManaging, refreshContext);
                return;
            }
            throw new WalletException.UnsupportedIndexSwitch(blockchain);
        }
        throw new WalletException.UnsupportedIndexSwitch(blockchain);
    }

    @Override // com.coinbase.wallet.wallets.interfaces.IWalletRepository
    public void switchNetwork(Blockchain blockchain, Network network) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(network, "network");
        WalletManaging walletManaging = this.repositories.get(blockchain);
        if (walletManaging != null) {
            NetworkSetting networkSetting = this.networks.get(blockchain);
            if (networkSetting != null) {
                if (networkSetting.getNetworkSettingItems().size() > 1) {
                    StoreInterface storeInterface = this.store;
                    StoreKeys storeKeys = StoreKeys.INSTANCE;
                    storeInterface.set(StoreKeys_WalletsKt.activeNetwork(storeKeys, blockchain), network);
                    RefreshContext refreshContext = new RefreshContext(getNetwork(blockchain), getActiveIndex(blockchain), (!walletManaging.getConfiguration().isSyncingRequired() || kotlin.jvm.internal.m.c(this.store.get(StoreKeys_WalletsKt.isWalletSynced(storeKeys, blockchain, network)), Boolean.TRUE)) ? RefreshContext.Mode.Quick.INSTANCE : RefreshContext.Mode.Full.INSTANCE, true);
                    this.reloadWalletsSubject.onNext(kotlin.x.a);
                    refreshRepository(walletManaging, refreshContext);
                    return;
                }
                throw new NetworkException.UnsupportedNetworkSwitch(network);
            }
            throw new NetworkException.UnsupportedNetworkSwitch(network);
        }
        throw new NetworkException.UnsupportedNetworkSwitch(network);
    }
}