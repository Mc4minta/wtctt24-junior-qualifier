package com.coinbase.wallet.txhistory.repositories;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.bitcoin.extensions.Blockchain_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.Blockchain_BitcoinCashKt;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.extensions.TxMetadataKey_ConsumerConnectKt;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.dogecoin.extensions.Blockchain_DogecoinKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.Blockchain_LitecoinKt;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.apis.TxHistoryApi;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.extensions.AnalyticsEvent_TxHistoryKt;
import com.coinbase.wallet.txhistory.extensions.Blockchain_TxHistoryKt;
import com.coinbase.wallet.txhistory.extensions.StoreKeys_TxHistoryKt;
import com.coinbase.wallet.txhistory.extensions.TraceKey_TxHistoryKt;
import com.coinbase.wallet.txhistory.models.TxAddress;
import com.coinbase.wallet.txhistory.operations.SyncEthereumTxHistoryOperation;
import com.coinbase.wallet.txhistory.operations.SyncHdWalletTxHistoryOperation;
import com.coinbase.wallet.txhistory.operations.SyncXrpTxHistoryOperation;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.services.xrp.XRPService;
import h.c.a0;
import h.c.b0;
import h.c.h0;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: TxHistoryRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0095\u0001\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\u0006\u0010G\u001a\u00020F\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010`\u001a\u00020_\u0012\u0006\u0010c\u001a\u00020b\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010[\u001a\u00020Z\u0012\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0/\u0012\u0012\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150/\u0012(\u0010A\u001a$\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060>j\u0002`@\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bk\u0010lJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b \u0010!J'\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0004\b#\u0010\u0018J!\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u00062\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b$\u0010\u0014J/\u0010(\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n '*\n\u0012\u0004\u0012\u00020\n\u0018\u00010&0&0\u00062\u0006\u0010%\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u0006¢\u0006\u0004\b*\u0010!J#\u00100\u001a\b\u0012\u0004\u0012\u00020\u000e0/2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0/¢\u0006\u0004\b2\u00103J3\u00107\u001a\b\u0012\u0004\u0012\u00020\u00070/2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00104\u001a\u00020\u000b2\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J1\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00150\u00062\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u00106\u001a\u000205¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b<\u0010=R8\u0010A\u001a$\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00060>j\u0002`@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00150/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020]0/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010MR\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010j¨\u0006m"}, d2 = {"Lcom/coinbase/wallet/txhistory/repositories/TxHistoryRepository;", "Lcom/coinbase/wallet/core/interfaces/Startable;", "Lcom/coinbase/wallet/core/interfaces/Refreshable;", "Lcom/coinbase/wallet/core/interfaces/Destroyable;", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "tx", "Lh/c/b0;", "", "updateTxState", "(Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "", "accountId", "consumerTxId", "Lkotlin/x;", "updateConsumerTx", "(Lcom/coinbase/wallet/blockchains/models/Transaction;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "updateWalletTxHistory", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)Lh/c/b0;", "", "coins", "updateWalletsTxHistory", "(Ljava/util/List;)Lh/c/b0;", "saveTx", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)Lh/c/b0;", "start", "()V", "isForced", "refresh", "(Z)Lh/c/b0;", "destroy", "()Lh/c/b0;", "wallets", "filterWalletsWithTx", "getTxs", "id", "Lcom/coinbase/wallet/core/util/Optional;", "kotlin.jvm.PlatformType", "getTxById", "(Ljava/lang/String;)Lh/c/b0;", "getPendingTxs", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lh/c/s;", "observeHistoryUpdates", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/s;", "observeAllHistoryUpdates", "()Lh/c/s;", "address", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "hasSyncedHistoryObservable", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/s;", "Lcom/coinbase/wallet/txhistory/models/TxAddress;", "getTxAddresses", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "canShowFullHistory", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Z", "Lkotlin/Function3;", "Lcom/coinbase/wallet/blockchains/models/TxState;", "Lcom/coinbase/wallet/txhistory/repositories/TxStateFetcher;", "getTxState", "Lkotlin/e0/c/q;", "Lh/c/a0;", "serialTxHistoryScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;", "txAddressDAO", "Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "walletsObservable", "Lh/c/s;", "Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "txHistoryAPI", "Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "txHistoryDAO", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "", "droppedTxs", "Ljava/util/Set;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "xrpService", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "txUpdateObservable", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "consumerAPI", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "Ljava/util/concurrent/locks/ReentrantLock;", "analyticsLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "<init>", "(Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/walletengine/services/xrp/XRPService;Lh/c/s;Lh/c/s;Lkotlin/e0/c/q;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryRepository implements Startable, Refreshable, Destroyable {
    private final ReentrantLock analyticsLock;
    private final ConsumerAPI consumerAPI;
    private final h.c.k0.a disposeBag;
    private Set<String> droppedTxs;
    private final kotlin.e0.c.q<Blockchain, Network, String, b0<TxState>> getTxState;
    private final a0 serialTxHistoryScheduler;
    private final StoreInterface store;
    private final Tracing tracer;
    private final TxAddressDAO txAddressDAO;
    private final TxHistoryApi txHistoryAPI;
    private final TxHistoryDAO txHistoryDAO;
    private final h.c.s<TxUpdate> txUpdateObservable;
    private final IWalletRepository walletRepository;
    private final h.c.s<List<Wallet>> walletsObservable;
    private final XRPService xrpService;

    public TxHistoryRepository(TxHistoryDAO txHistoryDAO, TxAddressDAO txAddressDAO, TxHistoryApi txHistoryAPI, IWalletRepository walletRepository, ConsumerAPI consumerAPI, StoreInterface store, XRPService xrpService, h.c.s<TxUpdate> txUpdateObservable, h.c.s<List<Wallet>> walletsObservable, kotlin.e0.c.q<Blockchain, Network, String, b0<TxState>> getTxState, Tracing tracer) {
        kotlin.jvm.internal.m.g(txHistoryDAO, "txHistoryDAO");
        kotlin.jvm.internal.m.g(txAddressDAO, "txAddressDAO");
        kotlin.jvm.internal.m.g(txHistoryAPI, "txHistoryAPI");
        kotlin.jvm.internal.m.g(walletRepository, "walletRepository");
        kotlin.jvm.internal.m.g(consumerAPI, "consumerAPI");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(xrpService, "xrpService");
        kotlin.jvm.internal.m.g(txUpdateObservable, "txUpdateObservable");
        kotlin.jvm.internal.m.g(walletsObservable, "walletsObservable");
        kotlin.jvm.internal.m.g(getTxState, "getTxState");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.txHistoryDAO = txHistoryDAO;
        this.txAddressDAO = txAddressDAO;
        this.txHistoryAPI = txHistoryAPI;
        this.walletRepository = walletRepository;
        this.consumerAPI = consumerAPI;
        this.store = store;
        this.xrpService = xrpService;
        this.txUpdateObservable = txUpdateObservable;
        this.walletsObservable = walletsObservable;
        this.getTxState = getTxState;
        this.tracer = tracer;
        this.disposeBag = new h.c.k0.a();
        this.serialTxHistoryScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
        this.analyticsLock = new ReentrantLock();
        this.droppedTxs = new LinkedHashSet();
    }

    public static /* synthetic */ h0 b(SignedTx signedTx, TxHistoryRepository txHistoryRepository, List list) {
        return m1785updateTxState$lambda18(signedTx, txHistoryRepository, list);
    }

    public static /* synthetic */ x c(Transaction transaction) {
        return m1771observeHistoryUpdates$lambda12(transaction);
    }

    public static /* synthetic */ x d(List list) {
        return m1788updateWalletsTxHistory$lambda33(list);
    }

    public static /* synthetic */ x e(Throwable th) {
        return m1787updateWalletsTxHistory$lambda32$lambda31(th);
    }

    public static /* synthetic */ h0 f(Transaction transaction, TxHistoryRepository txHistoryRepository, kotlin.t tVar) {
        return m1782updateConsumerTx$lambda28(transaction, txHistoryRepository, tVar);
    }

    public static /* synthetic */ Boolean g(Optional optional) {
        return m1769hasSyncedHistoryObservable$lambda14(optional);
    }

    /* renamed from: getTxs$lambda-10 */
    public static final List m1767getTxs$lambda10(List txs) {
        int r;
        kotlin.jvm.internal.m.g(txs, "txs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = txs.iterator();
        while (it.hasNext()) {
            Transaction transaction = (Transaction) it.next();
            String txHash = transaction.getTxHash();
            if (txHash != null) {
                List list = (List) linkedHashMap.get(txHash);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(transaction);
                linkedHashMap.put(txHash, list);
            }
        }
        Set<Map.Entry> entrySet = linkedHashMap.entrySet();
        r = kotlin.a0.s.r(entrySet, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Map.Entry entry : entrySet) {
            List list2 = (List) entry.getValue();
            if (list2.size() > 1) {
                kotlin.a0.v.x(list2, new Comparator<T>() { // from class: com.coinbase.wallet.txhistory.repositories.TxHistoryRepository$getTxs$lambda-10$lambda-9$$inlined$sortBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int c2;
                        c2 = kotlin.b0.b.c(((Transaction) t).getAmount(), ((Transaction) t2).getAmount());
                        return c2;
                    }
                });
            }
            arrayList.add((Transaction) kotlin.a0.p.j0((List) entry.getValue()));
        }
        return arrayList;
    }

    public static /* synthetic */ h.c.x h(TxHistoryRepository txHistoryRepository, TxUpdate txUpdate) {
        return m1777start$lambda0(txHistoryRepository, txUpdate);
    }

    /* renamed from: hasSyncedHistoryObservable$lambda-13 */
    public static final Boolean m1768hasSyncedHistoryObservable$lambda13(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(kotlin.jvm.internal.m.c(it.toNullable(), Boolean.TRUE));
    }

    /* renamed from: hasSyncedHistoryObservable$lambda-14 */
    public static final Boolean m1769hasSyncedHistoryObservable$lambda14(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(kotlin.jvm.internal.m.c(it.toNullable(), Boolean.TRUE));
    }

    public static /* synthetic */ Boolean i(Optional optional) {
        return m1776saveTx$lambda34(optional);
    }

    public static /* synthetic */ Boolean k(Optional optional) {
        return m1768hasSyncedHistoryObservable$lambda13(optional);
    }

    public static /* synthetic */ h0 l(TxHistoryRepository txHistoryRepository, List list) {
        return m1774refresh$lambda5(txHistoryRepository, list);
    }

    public static /* synthetic */ kotlin.t m(String str, kotlin.o oVar) {
        return m1781updateConsumerTx$lambda22$lambda21(str, oVar);
    }

    public static /* synthetic */ h0 n(TxHistoryRepository txHistoryRepository, List list) {
        return m1773refresh$lambda4(txHistoryRepository, list);
    }

    public static /* synthetic */ h0 o(TxHistoryRepository txHistoryRepository, List list) {
        return m1772refresh$lambda3(txHistoryRepository, list);
    }

    /* renamed from: observeHistoryUpdates$lambda-11 */
    public static final boolean m1770observeHistoryUpdates$lambda11(CurrencyCode currencyCode, Blockchain blockchain, Transaction it) {
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(blockchain, "$blockchain");
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.jvm.internal.m.c(it.getCurrencyCode(), currencyCode) && kotlin.jvm.internal.m.c(it.getBlockchain(), blockchain);
    }

    /* renamed from: observeHistoryUpdates$lambda-12 */
    public static final x m1771observeHistoryUpdates$lambda12(Transaction it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ TxState p(Throwable th) {
        return m1780updateConsumerTx$lambda22$lambda20(th);
    }

    public static /* synthetic */ Boolean q(Optional optional) {
        return m1786updateTxState$lambda19(optional);
    }

    public static /* synthetic */ x r(kotlin.o oVar) {
        return m1784updateConsumerTx$lambda28$lambda27(oVar);
    }

    /* renamed from: refresh$lambda-3 */
    public static final h0 m1772refresh$lambda3(TxHistoryRepository this$0, List txs) {
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(txs, "txs");
        ArrayList arrayList = new ArrayList();
        Iterator it = txs.iterator();
        while (it.hasNext()) {
            Transaction transaction = (Transaction) it.next();
            b0<x> b0Var = null;
            if (transaction.getState() == TxState.PENDING) {
                TxMetadata metadata = transaction.getMetadata();
                TxMetadataKey.Companion companion = TxMetadataKey.Companion;
                Object obj = metadata.get(TxMetadataKey_ConsumerConnectKt.getConsumerAccountID(companion));
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    Object obj2 = transaction.getMetadata().get(TxMetadataKey_ConsumerConnectKt.getConsumerTxID(companion));
                    String str2 = obj2 instanceof String ? (String) obj2 : null;
                    if (str2 != null) {
                        b0Var = this$0.updateConsumerTx(transaction, str, str2);
                    }
                }
            }
            if (b0Var != null) {
                arrayList.add(b0Var);
            }
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            b0 just = b0.just(g2);
            kotlin.jvm.internal.m.f(just, "just(emptyList())");
            return just;
        }
        b0 zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.TxHistoryRepository$refresh$lambda-3$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                kotlin.jvm.internal.m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = kotlin.a0.r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : it2) {
                    if (obj3 instanceof x) {
                        arrayList2.add(obj3);
                    }
                }
                return arrayList2;
            }
        });
        kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    /* renamed from: refresh$lambda-4 */
    public static final h0 m1773refresh$lambda4(TxHistoryRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return Observable_CoreKt.takeSingle(this$0.walletsObservable);
    }

    /* renamed from: refresh$lambda-5 */
    public static final h0 m1774refresh$lambda5(TxHistoryRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.updateWalletsTxHistory(it);
    }

    /* renamed from: refresh$lambda-6 */
    public static final x m1775refresh$lambda6(x it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ h.c.x s(TxHistoryRepository txHistoryRepository, List list) {
        return m1778start$lambda1(txHistoryRepository, list);
    }

    private final b0<Boolean> saveTx(Transaction transaction) {
        b0<Boolean> map = Single_AnalyticsKt.logError$default(this.txHistoryDAO.saveTx(transaction), null, null, 3, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.i((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "txHistoryDAO.saveTx(tx).logError().map { it.toNullable() != null }");
        return map;
    }

    /* renamed from: saveTx$lambda-34 */
    public static final Boolean m1776saveTx$lambda34(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.toNullable() != null);
    }

    /* renamed from: start$lambda-0 */
    public static final h.c.x m1777start$lambda0(TxHistoryRepository this$0, TxUpdate it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        if (it instanceof TxUpdate.Submitted) {
            return this$0.saveTx(((TxUpdate.Submitted) it).getTx()).toObservable();
        }
        if (it instanceof TxUpdate.Update) {
            return this$0.updateTxState(((TxUpdate.Update) it).getTx()).toObservable();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: start$lambda-1 */
    public static final h.c.x m1778start$lambda1(TxHistoryRepository this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.updateWalletsTxHistory(it).toObservable();
    }

    public static /* synthetic */ List t(List list) {
        return m1767getTxs$lambda10(list);
    }

    public static /* synthetic */ x u(Optional optional) {
        return m1783updateConsumerTx$lambda28$lambda26(optional);
    }

    private final b0<x> updateConsumerTx(final Transaction transaction, String str, String str2) {
        b0 flatMap = this.consumerAPI.getTxStatus(str, str2, transaction.getBlockchain()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.v
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.w(TxHistoryRepository.this, transaction, (kotlin.o) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.f(Transaction.this, this, (kotlin.t) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "consumerAPI\n        .getTxStatus(accountId, consumerTxId, tx.blockchain)\n        .flatMap { (hash, state) ->\n            if (hash == null) {\n                return@flatMap Single.just(\n                    Triple<String?, TxState, List<Transaction>>(null, state, emptyList())\n                )\n            }\n\n            val stateSingle = if (state != TxState.PENDING) {\n                Single.just(state)\n            } else {\n                getTxState(tx.blockchain, tx.network, hash)\n                    .onErrorReturn { TxState.PENDING }\n            }\n\n            Singles.zip(stateSingle, txHistoryDAO.getTxsByHash(hash)).map {\n                Triple<String?, TxState, List<Transaction>>(hash, it.first, it.second)\n            }\n        }\n        .flatMap { (hash, state, fetchedTxs) ->\n            val fetchedTx = fetchedTxs.firstOrNull { it.id != tx.id }\n            val map = (fetchedTx?.metadata ?: TxMetadata()).toMutableMap()\n            tx.metadata.toMap().forEach { (key, value) -> map[key] = value }\n\n            val updatedTx = Transaction(\n                id = tx.id,\n                createdAt = fetchedTx?.createdAt ?: tx.createdAt,\n                confirmedAt = fetchedTx?.confirmedAt ?: tx.confirmedAt,\n                blockchain = fetchedTx?.blockchain ?: tx.blockchain,\n                currencyCode = fetchedTx?.currencyCode ?: tx.currencyCode,\n                feeCurrencyCode = fetchedTx?.feeCurrencyCode ?: tx.feeCurrencyCode,\n                toAddress = fetchedTx?.toAddress ?: tx.toAddress,\n                fromAddress = fetchedTx?.fromAddress ?: tx.fromAddress,\n                amount = fetchedTx?.amount ?: tx.amount,\n                fee = fetchedTx?.fee ?: tx.fee,\n                metadata = TxMetadata(map),\n                state = fetchedTx?.state ?: state,\n                network = fetchedTx?.network ?: tx.network,\n                txHash = fetchedTx?.txHash ?: hash ?: tx.txHash,\n                isSent = fetchedTx?.isSent ?: tx.isSent\n            )\n\n            val txsToDelete = fetchedTxs.filter { it.id != tx.id }\n\n            if (txsToDelete.isEmpty()) {\n                txHistoryDAO.saveTx(updatedTx).map { Unit }\n            } else {\n                Singles.zip(txHistoryDAO.saveTx(updatedTx), txHistoryDAO.delete(txsToDelete)).map { Unit }\n            }\n        }");
        b0<x> onErrorReturnItem = Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null).onErrorReturnItem(x.a);
        kotlin.jvm.internal.m.f(onErrorReturnItem, "consumerAPI\n        .getTxStatus(accountId, consumerTxId, tx.blockchain)\n        .flatMap { (hash, state) ->\n            if (hash == null) {\n                return@flatMap Single.just(\n                    Triple<String?, TxState, List<Transaction>>(null, state, emptyList())\n                )\n            }\n\n            val stateSingle = if (state != TxState.PENDING) {\n                Single.just(state)\n            } else {\n                getTxState(tx.blockchain, tx.network, hash)\n                    .onErrorReturn { TxState.PENDING }\n            }\n\n            Singles.zip(stateSingle, txHistoryDAO.getTxsByHash(hash)).map {\n                Triple<String?, TxState, List<Transaction>>(hash, it.first, it.second)\n            }\n        }\n        .flatMap { (hash, state, fetchedTxs) ->\n            val fetchedTx = fetchedTxs.firstOrNull { it.id != tx.id }\n            val map = (fetchedTx?.metadata ?: TxMetadata()).toMutableMap()\n            tx.metadata.toMap().forEach { (key, value) -> map[key] = value }\n\n            val updatedTx = Transaction(\n                id = tx.id,\n                createdAt = fetchedTx?.createdAt ?: tx.createdAt,\n                confirmedAt = fetchedTx?.confirmedAt ?: tx.confirmedAt,\n                blockchain = fetchedTx?.blockchain ?: tx.blockchain,\n                currencyCode = fetchedTx?.currencyCode ?: tx.currencyCode,\n                feeCurrencyCode = fetchedTx?.feeCurrencyCode ?: tx.feeCurrencyCode,\n                toAddress = fetchedTx?.toAddress ?: tx.toAddress,\n                fromAddress = fetchedTx?.fromAddress ?: tx.fromAddress,\n                amount = fetchedTx?.amount ?: tx.amount,\n                fee = fetchedTx?.fee ?: tx.fee,\n                metadata = TxMetadata(map),\n                state = fetchedTx?.state ?: state,\n                network = fetchedTx?.network ?: tx.network,\n                txHash = fetchedTx?.txHash ?: hash ?: tx.txHash,\n                isSent = fetchedTx?.isSent ?: tx.isSent\n            )\n\n            val txsToDelete = fetchedTxs.filter { it.id != tx.id }\n\n            if (txsToDelete.isEmpty()) {\n                txHistoryDAO.saveTx(updatedTx).map { Unit }\n            } else {\n                Singles.zip(txHistoryDAO.saveTx(updatedTx), txHistoryDAO.delete(txsToDelete)).map { Unit }\n            }\n        }\n        .logError()\n        .onErrorReturnItem(Unit)");
        return onErrorReturnItem;
    }

    /* renamed from: updateConsumerTx$lambda-22 */
    public static final h0 m1779updateConsumerTx$lambda22(TxHistoryRepository this$0, Transaction tx, kotlin.o dstr$hash$state) {
        b0<TxState> onErrorReturn;
        List g2;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(dstr$hash$state, "$dstr$hash$state");
        final String str = (String) dstr$hash$state.a();
        TxState txState = (TxState) dstr$hash$state.b();
        if (str == null) {
            g2 = kotlin.a0.r.g();
            return b0.just(new kotlin.t(null, txState, g2));
        }
        if (txState != TxState.PENDING) {
            onErrorReturn = b0.just(txState);
        } else {
            onErrorReturn = this$0.getTxState.invoke(tx.getBlockchain(), tx.getNetwork(), str).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.o
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxHistoryRepository.p((Throwable) obj);
                }
            });
        }
        kotlin.jvm.internal.m.f(onErrorReturn, "if (state != TxState.PENDING) {\n                Single.just(state)\n            } else {\n                getTxState(tx.blockchain, tx.network, hash)\n                    .onErrorReturn { TxState.PENDING }\n            }");
        return h.c.t0.e.a.a(onErrorReturn, this$0.txHistoryDAO.getTxsByHash(str)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.m(str, (kotlin.o) obj);
            }
        });
    }

    /* renamed from: updateConsumerTx$lambda-22$lambda-20 */
    public static final TxState m1780updateConsumerTx$lambda22$lambda20(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return TxState.PENDING;
    }

    /* renamed from: updateConsumerTx$lambda-22$lambda-21 */
    public static final kotlin.t m1781updateConsumerTx$lambda22$lambda21(String str, kotlin.o it) {
        kotlin.jvm.internal.m.g(it, "it");
        Object c2 = it.c();
        kotlin.jvm.internal.m.f(c2, "it.first");
        Object d2 = it.d();
        kotlin.jvm.internal.m.f(d2, "it.second");
        return new kotlin.t(str, c2, d2);
    }

    /* renamed from: updateConsumerTx$lambda-28 */
    public static final h0 m1782updateConsumerTx$lambda28(Transaction tx, TxHistoryRepository this$0, kotlin.t dstr$hash$state$fetchedTxs) {
        Object obj;
        String str;
        TxState state;
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(dstr$hash$state$fetchedTxs, "$dstr$hash$state$fetchedTxs");
        String str2 = (String) dstr$hash$state$fetchedTxs.a();
        TxState txState = (TxState) dstr$hash$state$fetchedTxs.b();
        List list = (List) dstr$hash$state$fetchedTxs.c();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!kotlin.jvm.internal.m.c(((Transaction) obj).getId(), tx.getId())) {
                break;
            }
        }
        Transaction transaction = (Transaction) obj;
        TxMetadata metadata = transaction == null ? null : transaction.getMetadata();
        if (metadata == null) {
            metadata = new TxMetadata(null, 1, null);
        }
        Map<TxMetadataKey, Object> mutableMap = metadata.toMutableMap();
        for (Map.Entry<TxMetadataKey, Object> entry : tx.getMetadata().toMap().entrySet()) {
            mutableMap.put(entry.getKey(), entry.getValue());
        }
        String id = tx.getId();
        Date createdAt = transaction == null ? null : transaction.getCreatedAt();
        if (createdAt == null) {
            createdAt = tx.getCreatedAt();
        }
        Date date = createdAt;
        Date confirmedAt = transaction == null ? null : transaction.getConfirmedAt();
        if (confirmedAt == null) {
            confirmedAt = tx.getConfirmedAt();
        }
        Date date2 = confirmedAt;
        Blockchain blockchain = transaction == null ? null : transaction.getBlockchain();
        if (blockchain == null) {
            blockchain = tx.getBlockchain();
        }
        Blockchain blockchain2 = blockchain;
        CurrencyCode currencyCode = transaction == null ? null : transaction.getCurrencyCode();
        if (currencyCode == null) {
            currencyCode = tx.getCurrencyCode();
        }
        CurrencyCode currencyCode2 = currencyCode;
        CurrencyCode feeCurrencyCode = transaction == null ? null : transaction.getFeeCurrencyCode();
        if (feeCurrencyCode == null) {
            feeCurrencyCode = tx.getFeeCurrencyCode();
        }
        CurrencyCode currencyCode3 = feeCurrencyCode;
        String toAddress = transaction == null ? null : transaction.getToAddress();
        if (toAddress == null) {
            toAddress = tx.getToAddress();
        }
        String str3 = toAddress;
        String fromAddress = transaction == null ? null : transaction.getFromAddress();
        if (fromAddress == null) {
            fromAddress = tx.getFromAddress();
        }
        String str4 = fromAddress;
        BigInteger amount = transaction == null ? null : transaction.getAmount();
        if (amount == null) {
            amount = tx.getAmount();
        }
        BigInteger bigInteger = amount;
        BigInteger fee = transaction == null ? null : transaction.getFee();
        if (fee == null) {
            fee = tx.getFee();
        }
        BigInteger bigInteger2 = fee;
        TxMetadata txMetadata = new TxMetadata(mutableMap);
        TxState txState2 = (transaction == null || (state = transaction.getState()) == null) ? txState : state;
        Network network = transaction == null ? null : transaction.getNetwork();
        if (network == null) {
            network = tx.getNetwork();
        }
        Network network2 = network;
        String txHash = transaction == null ? null : transaction.getTxHash();
        if (txHash == null) {
            if (str2 == null) {
                str2 = tx.getTxHash();
            }
            str = str2;
        } else {
            str = txHash;
        }
        Boolean valueOf = transaction != null ? Boolean.valueOf(transaction.isSent()) : null;
        Transaction transaction2 = new Transaction(id, date, date2, blockchain2, currencyCode2, currencyCode3, str3, str4, bigInteger, bigInteger2, null, txState2, txMetadata, network2, str, valueOf == null ? tx.isSent() : valueOf.booleanValue(), 1024, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (!kotlin.jvm.internal.m.c(((Transaction) obj2).getId(), tx.getId())) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.isEmpty()) {
            return this$0.txHistoryDAO.saveTx(transaction2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.t
                @Override // h.c.m0.n
                public final Object apply(Object obj3) {
                    return TxHistoryRepository.u((Optional) obj3);
                }
            });
        }
        return h.c.t0.e.a.a(this$0.txHistoryDAO.saveTx(transaction2), this$0.txHistoryDAO.delete(arrayList)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.q
            @Override // h.c.m0.n
            public final Object apply(Object obj3) {
                return TxHistoryRepository.r((kotlin.o) obj3);
            }
        });
    }

    /* renamed from: updateConsumerTx$lambda-28$lambda-26 */
    public static final x m1783updateConsumerTx$lambda28$lambda26(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: updateConsumerTx$lambda-28$lambda-27 */
    public static final x m1784updateConsumerTx$lambda28$lambda27(kotlin.o it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    private final b0<Boolean> updateTxState(final SignedTx signedTx) {
        b0<Boolean> map = this.txHistoryDAO.getTxsByHash(signedTx.getTxHash()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.b(SignedTx.this, this, (List) obj);
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.p
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.q((Optional) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "txHistoryDAO.getTxsByHash(tx.txHash)\n        .flatMap { fetchedTxs ->\n            val firstTx = fetchedTxs.firstOrNull()\n            if ((tx.state == TxState.FAILED || tx.state == TxState.DROPPED) && firstTx?.state == TxState.PENDING) {\n                val txSource = firstTx.metadata[TxMetadataKey.txSource] as? String ?: \"\"\n                val chainId = firstTx.network.asEthereumChain?.chainId ?: -1\n                val chainName = firstTx.network.asEthereumChain?.displayName ?: \"\"\n                analyticsLock.withLock {\n                    if (!droppedTxs.contains(tx.txHash)) {\n                        if (tx.state == TxState.DROPPED) {\n                            Analytics.log(\n                                AnalyticsEvent.txDropped(txSource, tx.blockchain, chainId, chainName)\n                            )\n                        }\n\n                        if (tx.state == TxState.FAILED) {\n                            Analytics.log(\n                                AnalyticsEvent.txFailed(txSource, tx.blockchain, tx.txHash, chainId, chainName)\n                            )\n                        }\n\n                        droppedTxs.add(tx.txHash)\n                    }\n                }\n            }\n\n            val filteredTxs = fetchedTxs\n                .filter { fetchedTx -> tx.state != fetchedTx.state }\n                .map { fetchedTx ->\n                    fetchedTx.copy(state = tx.state)\n                }\n\n            if (filteredTxs.isEmpty()) return@flatMap Single.just(Optional(null))\n\n            txHistoryDAO.saveTxs(filteredTxs)\n        }\n        .map { it.toNullable() != null }");
        return map;
    }

    /* renamed from: updateTxState$lambda-18 */
    public static final h0 m1785updateTxState$lambda18(SignedTx tx, TxHistoryRepository this$0, List fetchedTxs) {
        String displayName;
        int r;
        Transaction copy;
        kotlin.jvm.internal.m.g(tx, "$tx");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(fetchedTxs, "fetchedTxs");
        Transaction transaction = (Transaction) kotlin.a0.p.a0(fetchedTxs);
        TxState state = tx.getState();
        TxState txState = TxState.FAILED;
        if (state == txState || tx.getState() == TxState.DROPPED) {
            if ((transaction == null ? null : transaction.getState()) == TxState.PENDING) {
                Object obj = transaction.getMetadata().get(TxMetadataKey_EthereumKt.getTxSource(TxMetadataKey.Companion));
                String str = obj instanceof String ? (String) obj : null;
                String str2 = str == null ? "" : str;
                EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(transaction.getNetwork());
                int chainId = asEthereumChain == null ? -1 : asEthereumChain.getChainId();
                EthereumChain asEthereumChain2 = Network_EthereumKt.getAsEthereumChain(transaction.getNetwork());
                String str3 = (asEthereumChain2 == null || (displayName = asEthereumChain2.getDisplayName()) == null) ? "" : displayName;
                ReentrantLock reentrantLock = this$0.analyticsLock;
                reentrantLock.lock();
                try {
                    if (!this$0.droppedTxs.contains(tx.getTxHash())) {
                        if (tx.getState() == TxState.DROPPED) {
                            Analytics.INSTANCE.log(AnalyticsEvent_TxHistoryKt.txDropped(AnalyticsEvent.Companion, str2, tx.getBlockchain(), chainId, str3));
                        }
                        if (tx.getState() == txState) {
                            Analytics.INSTANCE.log(AnalyticsEvent_TxHistoryKt.txFailed(AnalyticsEvent.Companion, str2, tx.getBlockchain(), tx.getTxHash(), chainId, str3));
                        }
                        this$0.droppedTxs.add(tx.getTxHash());
                    }
                    x xVar = x.a;
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
        ArrayList<Transaction> arrayList = new ArrayList();
        for (Object obj2 : fetchedTxs) {
            if (tx.getState() != ((Transaction) obj2).getState()) {
                arrayList.add(obj2);
            }
        }
        r = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (Transaction transaction2 : arrayList) {
            copy = transaction2.copy((r34 & 1) != 0 ? transaction2.getId() : null, (r34 & 2) != 0 ? transaction2.createdAt : null, (r34 & 4) != 0 ? transaction2.confirmedAt : null, (r34 & 8) != 0 ? transaction2.blockchain : null, (r34 & 16) != 0 ? transaction2.currencyCode : null, (r34 & 32) != 0 ? transaction2.feeCurrencyCode : null, (r34 & 64) != 0 ? transaction2.toAddress : null, (r34 & 128) != 0 ? transaction2.fromAddress : null, (r34 & 256) != 0 ? transaction2.amount : null, (r34 & 512) != 0 ? transaction2.fee : null, (r34 & 1024) != 0 ? transaction2.lowerBoundFee : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? transaction2.state : tx.getState(), (r34 & 4096) != 0 ? transaction2.metadata : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? transaction2.network : null, (r34 & 16384) != 0 ? transaction2.txHash : null, (r34 & 32768) != 0 ? transaction2.isSent : false);
            arrayList2.add(copy);
        }
        return arrayList2.isEmpty() ? b0.just(new Optional(null)) : this$0.txHistoryDAO.saveTxs(arrayList2);
    }

    /* renamed from: updateTxState$lambda-19 */
    public static final Boolean m1786updateTxState$lambda19(Optional it) {
        kotlin.jvm.internal.m.g(it, "it");
        return Boolean.valueOf(it.toNullable() != null);
    }

    private final b0<x> updateWalletTxHistory(Wallet wallet) {
        Blockchain blockchain = wallet.getBlockchain();
        Blockchain.Companion companion = Blockchain.Companion;
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
            b0<x> syncTxHistory = asEthereumChain == null ? null : new SyncEthereumTxHistoryOperation(wallet.getPrimaryAddress(), this.txHistoryAPI, asEthereumChain, this.txHistoryDAO, this.store).syncTxHistory();
            if (syncTxHistory == null) {
                b0<x> just = b0.just(x.a);
                kotlin.jvm.internal.m.f(just, "just(Unit)");
                return just;
            }
            return syncTxHistory;
        }
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_BitcoinKt.getBITCOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_LitecoinKt.getLITECOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_DogecoinKt.getDOGECOIN(companion))) {
            return new SyncHdWalletTxHistoryOperation(this.txHistoryAPI, this.walletRepository, wallet.getBlockchain(), wallet.getCurrencyCode(), wallet.getNetwork(), this.txHistoryDAO, this.store).syncTxHistory();
        }
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
            return new SyncXrpTxHistoryOperation(wallet.getPrimaryAddress(), this.xrpService, wallet.getCurrencyCode(), wallet.getNetwork(), this.txHistoryDAO, this.store).syncTxHistory();
        }
        b0<x> just2 = b0.just(x.a);
        kotlin.jvm.internal.m.f(just2, "{\n            Single.just(Unit)\n        }");
        return just2;
    }

    private final b0<x> updateWalletsTxHistory(List<Wallet> list) {
        int r;
        b0 zip;
        List g2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Wallet wallet : list) {
            linkedHashMap.put(wallet.getBlockchain(), wallet);
        }
        Collection<Wallet> values = linkedHashMap.values();
        r = kotlin.a0.s.r(values, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Wallet wallet2 : values) {
            arrayList.add(updateWalletTxHistory(wallet2).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.d
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxHistoryRepository.e((Throwable) obj);
                }
            }));
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.TxHistoryRepository$updateWalletsTxHistory$$inlined$zipOrEmpty$1
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
                        if (obj != null ? obj instanceof x : true) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        b0<x> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.d((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "Singles.zipOrEmpty(singles).map { Unit }");
        return map;
    }

    /* renamed from: updateWalletsTxHistory$lambda-32$lambda-31 */
    public static final x m1787updateWalletsTxHistory$lambda32$lambda31(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    /* renamed from: updateWalletsTxHistory$lambda-33 */
    public static final x m1788updateWalletsTxHistory$lambda33(List it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ x v(x xVar) {
        return m1775refresh$lambda6(xVar);
    }

    public static /* synthetic */ h0 w(TxHistoryRepository txHistoryRepository, Transaction transaction, kotlin.o oVar) {
        return m1779updateConsumerTx$lambda22(txHistoryRepository, transaction, oVar);
    }

    public final boolean canShowFullHistory(Blockchain blockchain) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        Blockchain.Companion companion = Blockchain.Companion;
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_BitcoinKt.getBITCOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_LitecoinKt.getLITECOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_DogecoinKt.getDOGECOIN(companion))) {
            return true;
        }
        return kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion));
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public b0<Boolean> destroy() {
        this.disposeBag.d();
        b0<Boolean> just = b0.just(Boolean.TRUE);
        kotlin.jvm.internal.m.f(just, "just(true)");
        return just;
    }

    public final b0<List<Wallet>> filterWalletsWithTx(List<Wallet> wallets) {
        kotlin.jvm.internal.m.g(wallets, "wallets");
        return this.txHistoryDAO.filterWalletsWithTx(wallets);
    }

    public final b0<List<Transaction>> getPendingTxs() {
        return this.txHistoryDAO.getPendingTxs();
    }

    public final b0<List<TxAddress>> getTxAddresses(Blockchain blockchain, CurrencyCode currencyCode, Network network) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(network, "network");
        return this.txAddressDAO.getTxAddresses(blockchain, currencyCode, network);
    }

    public final b0<Optional<Transaction>> getTxById(String id) {
        kotlin.jvm.internal.m.g(id, "id");
        b0<Optional<Transaction>> subscribeOn = this.txHistoryDAO.getTxById(id).subscribeOn(h.c.u0.a.c());
        kotlin.jvm.internal.m.f(subscribeOn, "txHistoryDAO.getTxById(id).subscribeOn(Schedulers.io())");
        return Single_AnalyticsKt.logError$default(subscribeOn, null, null, 3, null);
    }

    public final b0<List<Transaction>> getTxs(Wallet wallet) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        b0 map = this.txHistoryDAO.getTxsWithAdditionalParams(wallet.getCurrencyCode(), wallet.getNetwork(), kotlin.jvm.internal.m.c(wallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) ? wallet.getPrimaryAddress() : null, !Blockchain_TxHistoryKt.canShowFullTxHistory(wallet.getBlockchain())).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.s
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.t((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "txHistoryDAO\n            .getTxsWithAdditionalParams(\n                currencyCode = wallet.currencyCode,\n                network = wallet.network,\n                walletAddress = walletAddress,\n                txHashCanBeNil = !wallet.blockchain.canShowFullTxHistory()\n            )\n            .map { txs ->\n                val txMap = txs\n                    .reduceIntoMap(mutableMapOf<String, MutableList<Transaction>>()) { mutableMap, transaction ->\n                        val txHash = transaction.txHash ?: return@reduceIntoMap\n                        val list = mutableMap[txHash] ?: mutableListOf()\n                        list.add(transaction)\n                        mutableMap[txHash] = list\n                    }\n\n                txMap.entries.map { mapEntry ->\n                    mapEntry.value.sortBy { it.amount }\n                    mapEntry.value.last()\n                }\n            }");
        return map;
    }

    public final h.c.s<Boolean> hasSyncedHistoryObservable(Blockchain blockchain, CurrencyCode currencyCode, String address, Network network) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(network, "network");
        Blockchain.Companion companion = Blockchain.Companion;
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
            h.c.s<Boolean> map = this.store.observe(StoreKeys_TxHistoryKt.hasSyncedEthereumTxHistory(StoreKeys.INSTANCE, address, network)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxHistoryRepository.k((Optional) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "{\n            store\n                .observe(StoreKeys.hasSyncedEthereumTxHistory(address, network))\n                .map { it.toNullable() == true }\n        }");
            return map;
        }
        if (kotlin.jvm.internal.m.c(blockchain, Blockchain_BitcoinKt.getBITCOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_LitecoinKt.getLITECOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_DogecoinKt.getDOGECOIN(companion)) ? true : kotlin.jvm.internal.m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
            h.c.s<Boolean> map2 = this.store.observe(StoreKeys_TxHistoryKt.hasSyncedTxHistory(StoreKeys.INSTANCE, currencyCode, network)).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.f
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxHistoryRepository.g((Optional) obj);
                }
            });
            kotlin.jvm.internal.m.f(map2, "{\n            store\n                .observe(StoreKeys.hasSyncedTxHistory(currencyCode, network))\n                .map { it.toNullable() == true }\n        }");
            return map2;
        }
        h.c.s<Boolean> just = h.c.s.just(Boolean.FALSE);
        kotlin.jvm.internal.m.f(just, "just(false)");
        return just;
    }

    public final h.c.s<x> observeAllHistoryUpdates() {
        h.c.s<Transaction> throttleLast = this.txHistoryDAO.getHistoryUpdatedObservable().throttleLast(500L, TimeUnit.MILLISECONDS);
        kotlin.jvm.internal.m.f(throttleLast, "txHistoryDAO.historyUpdatedObservable\n            .throttleLast(500, TimeUnit.MILLISECONDS)");
        h.c.s<x> startWith = Observable_CoreKt.asUnit(throttleLast).startWith((h.c.s<x>) x.a);
        kotlin.jvm.internal.m.f(startWith, "txHistoryDAO.historyUpdatedObservable\n            .throttleLast(500, TimeUnit.MILLISECONDS)\n            .asUnit()\n            .startWith(Unit)");
        return startWith;
    }

    public final h.c.s<x> observeHistoryUpdates(final Blockchain blockchain, final CurrencyCode currencyCode) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(currencyCode, "currencyCode");
        h.c.s map = this.txHistoryDAO.getHistoryUpdatedObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.txhistory.repositories.i
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                boolean m1770observeHistoryUpdates$lambda11;
                m1770observeHistoryUpdates$lambda11 = TxHistoryRepository.m1770observeHistoryUpdates$lambda11(CurrencyCode.this, blockchain, (Transaction) obj);
                return m1770observeHistoryUpdates$lambda11;
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.c((Transaction) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "txHistoryDAO.historyUpdatedObservable\n        .filter { it.currencyCode == currencyCode && it.blockchain == blockchain }\n        .map { Unit }");
        return map;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public b0<x> refresh(boolean z) {
        b0 flatMap = this.txHistoryDAO.getPendingTxs().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.n
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.o(TxHistoryRepository.this, (List) obj);
            }
        }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.m
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.n(TxHistoryRepository.this, (List) obj);
            }
        }).observeOn(this.serialTxHistoryScheduler).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.l(TxHistoryRepository.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "txHistoryDAO.getPendingTxs()\n            .flatMap { txs ->\n                val updateConsumerTxSingles = txs.mapNotNull { tx ->\n                    if (tx.state != TxState.PENDING) return@mapNotNull null\n                    val accountId = tx.metadata[TxMetadataKey.consumerAccountID] as? String\n                        ?: return@mapNotNull null\n                    val consumerTxId = tx.metadata[TxMetadataKey.consumerTxID] as? String\n                        ?: return@mapNotNull null\n\n                    updateConsumerTx(tx, accountId, consumerTxId)\n                }\n\n                Singles.zipOrEmpty(updateConsumerTxSingles)\n            }\n            .flatMap { walletsObservable.takeSingle() }\n            .observeOn(serialTxHistoryScheduler)\n            .flatMap { updateWalletsTxHistory(it) }");
        b0 trace = Single_CoreKt.trace(flatMap, TraceKey_TxHistoryKt.traceHistoryRefreshTrace(TraceKey.Companion), this.tracer);
        kotlin.jvm.internal.m.f(trace, "txHistoryDAO.getPendingTxs()\n            .flatMap { txs ->\n                val updateConsumerTxSingles = txs.mapNotNull { tx ->\n                    if (tx.state != TxState.PENDING) return@mapNotNull null\n                    val accountId = tx.metadata[TxMetadataKey.consumerAccountID] as? String\n                        ?: return@mapNotNull null\n                    val consumerTxId = tx.metadata[TxMetadataKey.consumerTxID] as? String\n                        ?: return@mapNotNull null\n\n                    updateConsumerTx(tx, accountId, consumerTxId)\n                }\n\n                Singles.zipOrEmpty(updateConsumerTxSingles)\n            }\n            .flatMap { walletsObservable.takeSingle() }\n            .observeOn(serialTxHistoryScheduler)\n            .flatMap { updateWalletsTxHistory(it) }\n            .trace(TraceKey.traceHistoryRefreshTrace(), tracer)");
        b0<x> map = Single_AnalyticsKt.logError$default(trace, null, null, 3, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.u
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.v((x) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "txHistoryDAO.getPendingTxs()\n            .flatMap { txs ->\n                val updateConsumerTxSingles = txs.mapNotNull { tx ->\n                    if (tx.state != TxState.PENDING) return@mapNotNull null\n                    val accountId = tx.metadata[TxMetadataKey.consumerAccountID] as? String\n                        ?: return@mapNotNull null\n                    val consumerTxId = tx.metadata[TxMetadataKey.consumerTxID] as? String\n                        ?: return@mapNotNull null\n\n                    updateConsumerTx(tx, accountId, consumerTxId)\n                }\n\n                Singles.zipOrEmpty(updateConsumerTxSingles)\n            }\n            .flatMap { walletsObservable.takeSingle() }\n            .observeOn(serialTxHistoryScheduler)\n            .flatMap { updateWalletsTxHistory(it) }\n            .trace(TraceKey.traceHistoryRefreshTrace(), tracer)\n            .logError()\n            .map { Unit }");
        return map;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        h.c.k0.b subscribe = this.txUpdateObservable.flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.h(TxHistoryRepository.this, (TxUpdate) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe, "txUpdateObservable\n            .flatMap {\n                when (it) {\n                    is TxUpdate.Submitted -> saveTx(it.tx).toObservable()\n                    is TxUpdate.Update -> updateTxState(it.tx).toObservable()\n                }\n            }\n            .subscribe()");
        h.c.t0.a.a(subscribe, this.disposeBag);
        h.c.k0.b subscribe2 = this.walletsObservable.throttleLast(3L, TimeUnit.SECONDS, this.serialTxHistoryScheduler).distinctUntilChanged().flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.txhistory.repositories.r
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryRepository.s(TxHistoryRepository.this, (List) obj);
            }
        }).subscribe();
        kotlin.jvm.internal.m.f(subscribe2, "walletsObservable\n            .throttleLast(3, TimeUnit.SECONDS, serialTxHistoryScheduler)\n            .distinctUntilChanged()\n            .flatMap { updateWalletsTxHistory(it).toObservable() }\n            .subscribe()");
        h.c.t0.a.a(subscribe2, this.disposeBag);
    }
}