package com.coinbase.wallet.wallets.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.exceptions.TxException;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.UnsignedTxResult;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.extensions.Map_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.models.TraceKey;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.wallets.extensions.AnalyticsEvent_WalletsKt;
import com.coinbase.wallet.wallets.extensions.StoreKeys_WalletsKt;
import com.coinbase.wallet.wallets.extensions.TraceKey_WalletsKt;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.models.RxTask;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;

/* compiled from: TxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B3\u0012\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00050D\u0012\u0006\u0010H\u001a\u00020G\u0012\f\u0010W\u001a\b\u0012\u0004\u0012\u00020M0D\u0012\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bX\u0010YJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J_\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b \u0010!Js\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u001a2\b\u0010$\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b%\u0010&JA\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0016¢\u0006\u0004\b(\u0010)J-\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00042\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0004\b/\u00100J-\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010\u0010J\u000f\u00104\u001a\u00020'H\u0016¢\u0006\u0004\b4\u00105J\u0015\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016¢\u0006\u0004\b6\u00107J\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020'0\u00042\u0006\u00108\u001a\u00020\u000eH\u0016¢\u0006\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00050D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\"\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020M0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010OR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR,\u0010V\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030U0T0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010O¨\u0006Z"}, d2 = {"Lcom/coinbase/wallet/wallets/repositories/TxRepository;", "Lcom/coinbase/wallet/wallets/interfaces/ITxRepository;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "transactionRepository", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "address", "", "isValidAddress", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", SendConfirmationArgs.recipientAddressKey, "", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "", SendConfirmationArgs.metadataKey, "Ljava/math/BigInteger;", "gasPrice", "gasLimit", "", AdjustableMinerFeeArgs.NONCE, "Lcom/coinbase/wallet/blockchains/models/UnsignedTxResult;", "generateUnsignedTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "maxFeePerGas", "baseFeePerGas", "maxPriorityFeePerGas", "generateUnsigned1559Tx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/math/BigInteger;Ljava/lang/Integer;)Lh/c/b0;", "Lkotlin/x;", "validateTransferTx", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Lcom/coinbase/wallet/blockchains/models/TransferValue;Ljava/lang/String;Ljava/util/Map;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;", "unsignedTx", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "refreshBalances", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "signAndSubmit", "(Lcom/coinbase/wallet/blockchains/interfaces/UnsignedTx;Ljava/lang/String;Z)Lh/c/b0;", "txHash", "Lcom/coinbase/wallet/blockchains/models/TxState;", "getTxState", "start", "()V", "destroy", "()Lh/c/b0;", "isForced", "refresh", "(Z)Lh/c/b0;", "Lh/c/a0;", "serialTxRepositoryScheduler", "Lh/c/a0;", "Lh/c/s;", "Lcom/coinbase/wallet/blockchains/models/TxUpdate;", "txUpdatesObservable", "Lh/c/s;", "getTxUpdatesObservable", "()Lh/c/s;", "", "repositories", "Ljava/util/List;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "networks", "Ljava/util/Map;", "mapping", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "Lh/c/v0/b;", "Lcom/coinbase/wallet/wallets/models/RxTask;", "submissionSubjects", "networkSettings", "<init>", "(Ljava/util/List;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Ljava/util/List;Lcom/coinbase/wallet/core/interfaces/Tracing;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxRepository implements ITxRepository {
    private final h.c.k0.a disposeBag;
    private final Map<Blockchain, TxManaging> mapping;
    private final Map<Blockchain, NetworkSetting> networks;
    private final List<TxManaging> repositories;
    private final h.c.a0 serialTxRepositoryScheduler;
    private final StoreInterface store;
    private final Map<Blockchain, h.c.v0.b<RxTask<?>>> submissionSubjects;
    private final Tracing tracer;
    private final h.c.s<TxUpdate> txUpdatesObservable;

    public TxRepository(List<TxManaging> repositories, StoreInterface store, List<NetworkSetting> networkSettings, Tracing tracer) {
        int r;
        Map<Blockchain, NetworkSetting> r2;
        int r3;
        kotlin.jvm.internal.m.g(repositories, "repositories");
        kotlin.jvm.internal.m.g(store, "store");
        kotlin.jvm.internal.m.g(networkSettings, "networkSettings");
        kotlin.jvm.internal.m.g(tracer, "tracer");
        this.repositories = repositories;
        this.store = store;
        this.tracer = tracer;
        this.serialTxRepositoryScheduler = RxSchedulers.INSTANCE.newSerialScheduler();
        r = kotlin.a0.s.r(networkSettings, 10);
        ArrayList arrayList = new ArrayList(r);
        for (NetworkSetting networkSetting : networkSettings) {
            arrayList.add(kotlin.u.a(networkSetting.getBlockchain(), networkSetting));
        }
        r2 = kotlin.a0.m0.r(arrayList);
        this.networks = r2;
        this.disposeBag = new h.c.k0.a();
        List<TxManaging> list = this.repositories;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TxManaging txManaging : list) {
            linkedHashMap.put(txManaging.getConfiguration().getBlockchain(), txManaging);
        }
        this.mapping = linkedHashMap;
        List<TxManaging> list2 = this.repositories;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (TxManaging txManaging2 : list2) {
            Blockchain blockchain = txManaging2.getConfiguration().getBlockchain();
            h.c.v0.b d2 = h.c.v0.b.d();
            kotlin.jvm.internal.m.f(d2, "create<RxTask<*>>()");
            linkedHashMap2.put(blockchain, d2);
        }
        this.submissionSubjects = linkedHashMap2;
        List<TxManaging> list3 = this.repositories;
        r3 = kotlin.a0.s.r(list3, 10);
        ArrayList arrayList2 = new ArrayList(r3);
        for (TxManaging txManaging3 : list3) {
            arrayList2.add(txManaging3.getTxUpdatesObservable());
        }
        this.txUpdatesObservable = h.c.t0.b.b(arrayList2);
    }

    public static /* synthetic */ h.c.h0 b(Wallet wallet, TransferValue transferValue, String str, Map map, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, TxManaging txManaging) {
        return m1875generateUnsigned1559Tx$lambda6(wallet, transferValue, str, map, bigInteger, bigInteger2, bigInteger3, bigInteger4, num, txManaging);
    }

    public static /* synthetic */ kotlin.x c(Throwable th) {
        return m1885start$lambda15$lambda13$lambda12(th);
    }

    public static /* synthetic */ kotlin.x d(Throwable th) {
        return m1880refresh$lambda20$lambda18(th);
    }

    /* renamed from: destroy$lambda-16 */
    public static final Boolean m1874destroy$lambda16(TxRepository this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.disposeBag.d();
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean e(TxRepository txRepository) {
        return m1874destroy$lambda16(txRepository);
    }

    public static /* synthetic */ h.c.h0 f(String str, Network network, TxManaging txManaging) {
        return m1877getTxState$lambda11(str, network, txManaging);
    }

    public static /* synthetic */ h.c.h0 g(String str, Network network, TxManaging txManaging) {
        return m1878isValidAddress$lambda4(str, network, txManaging);
    }

    /* renamed from: generateUnsigned1559Tx$lambda-6 */
    public static final h.c.h0 m1875generateUnsigned1559Tx$lambda6(Wallet wallet, TransferValue amount, String recipientAddress, Map metadata, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, Integer num, TxManaging repository) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(repository, "repository");
        IETHTxRepository iETHTxRepository = repository instanceof IETHTxRepository ? (IETHTxRepository) repository : null;
        if (iETHTxRepository == null) {
            return null;
        }
        return iETHTxRepository.generateUnsignedEthereum1559Tx(wallet, amount, recipientAddress, metadata, bigInteger, bigInteger2, bigInteger3, bigInteger4, num);
    }

    /* renamed from: generateUnsignedTx$lambda-5 */
    public static final h.c.h0 m1876generateUnsignedTx$lambda5(Wallet wallet, TransferValue amount, String recipientAddress, Map metadata, BigInteger bigInteger, BigInteger bigInteger2, Integer num, TxManaging repository) {
        kotlin.jvm.internal.m.g(wallet, "$wallet");
        kotlin.jvm.internal.m.g(amount, "$amount");
        kotlin.jvm.internal.m.g(recipientAddress, "$recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "$metadata");
        kotlin.jvm.internal.m.g(repository, "repository");
        return repository.generateUnsignedTx(wallet, amount, recipientAddress, metadata, bigInteger, bigInteger2, num);
    }

    private final Network getNetwork(Blockchain blockchain) {
        Network network = (Network) this.store.get(StoreKeys_WalletsKt.activeNetwork(StoreKeys.INSTANCE, blockchain));
        return network == null ? ((NetworkSetting) Map_CoreKt.require(this.networks, blockchain)).getMainnetNetworkSettingItem().getNetwork() : network;
    }

    /* renamed from: getTxState$lambda-11 */
    public static final h.c.h0 m1877getTxState$lambda11(String txHash, Network network, TxManaging it) {
        kotlin.jvm.internal.m.g(txHash, "$txHash");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(it, "it");
        return it.getTxState(txHash, network);
    }

    public static /* synthetic */ void h(List list, TxRepository txRepository, h.c.k0.b bVar) {
        m1881refresh$lambda23(list, txRepository, bVar);
    }

    public static /* synthetic */ kotlin.x i(UnsignedTxResult unsignedTxResult) {
        return m1887validateTransferTx$lambda8(unsignedTxResult);
    }

    /* renamed from: isValidAddress$lambda-4 */
    public static final h.c.h0 m1878isValidAddress$lambda4(String address, Network network, TxManaging it) {
        kotlin.jvm.internal.m.g(address, "$address");
        kotlin.jvm.internal.m.g(network, "$network");
        kotlin.jvm.internal.m.g(it, "it");
        return it.isValidAddress(address, network);
    }

    public static /* synthetic */ h.c.x j(RxTask rxTask) {
        return m1884start$lambda15$lambda13(rxTask);
    }

    public static /* synthetic */ h.c.h0 k(UnsignedTx unsignedTx, String str, TxManaging txManaging) {
        return m1883signAndSubmit$lambda9(unsignedTx, str, txManaging);
    }

    public static /* synthetic */ void l(TxRepository txRepository, UnsignedTx unsignedTx, RxTask rxTask, h.c.k0.b bVar) {
        m1882signAndSubmit$lambda10(txRepository, unsignedTx, rxTask, bVar);
    }

    public static /* synthetic */ void m(CurrencyCode currencyCode, String str, Throwable th) {
        m1879refresh$lambda20$lambda17(currencyCode, str, th);
    }

    public static /* synthetic */ kotlin.x n(Throwable th) {
        return m1886start$lambda15$lambda14(th);
    }

    public static /* synthetic */ h.c.h0 o(Wallet wallet, TransferValue transferValue, String str, Map map, BigInteger bigInteger, BigInteger bigInteger2, Integer num, TxManaging txManaging) {
        return m1876generateUnsignedTx$lambda5(wallet, transferValue, str, map, bigInteger, bigInteger2, num, txManaging);
    }

    /* renamed from: refresh$lambda-20$lambda-17 */
    public static final void m1879refresh$lambda20$lambda17(CurrencyCode currencyCode, String uuid, Throwable th) {
        kotlin.jvm.internal.m.g(currencyCode, "$currencyCode");
        kotlin.jvm.internal.m.g(uuid, "$uuid");
        AnalyticsEvent_WalletsKt.txResubmitJobFail$default(AnalyticsEvent.Companion, currencyCode.getRawValue(), uuid, null, 4, null);
    }

    /* renamed from: refresh$lambda-20$lambda-18 */
    public static final kotlin.x m1880refresh$lambda20$lambda18(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: refresh$lambda-23 */
    public static final void m1881refresh$lambda23(List tasks, TxRepository this$0, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(tasks, "$tasks");
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Iterator it = tasks.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            ((h.c.v0.b) Map_CoreKt.require(this$0.submissionSubjects, oVar.c())).onNext(oVar.d());
        }
    }

    /* renamed from: signAndSubmit$lambda-10 */
    public static final void m1882signAndSubmit$lambda10(TxRepository this$0, UnsignedTx unsignedTx, RxTask task, h.c.k0.b bVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(task, "$task");
        ((h.c.v0.b) Map_CoreKt.require(this$0.submissionSubjects, unsignedTx.getBlockchain())).onNext(task);
    }

    /* renamed from: signAndSubmit$lambda-9 */
    public static final h.c.h0 m1883signAndSubmit$lambda9(UnsignedTx unsignedTx, String mnemonic, TxManaging it) {
        kotlin.jvm.internal.m.g(unsignedTx, "$unsignedTx");
        kotlin.jvm.internal.m.g(mnemonic, "$mnemonic");
        kotlin.jvm.internal.m.g(it, "it");
        return it.signAndSubmit(unsignedTx, mnemonic, true);
    }

    /* renamed from: start$lambda-15$lambda-13 */
    public static final h.c.x m1884start$lambda15$lambda13(RxTask task) {
        kotlin.jvm.internal.m.g(task, "task");
        return Single_CoreKt.asUnit(task.execute()).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.y
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.c((Throwable) obj);
            }
        }).toObservable();
    }

    /* renamed from: start$lambda-15$lambda-13$lambda-12 */
    public static final kotlin.x m1885start$lambda15$lambda13$lambda12(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    /* renamed from: start$lambda-15$lambda-14 */
    public static final kotlin.x m1886start$lambda15$lambda14(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return kotlin.x.a;
    }

    private final h.c.b0<TxManaging> transactionRepository(Blockchain blockchain) {
        TxManaging txManaging = this.mapping.get(blockchain);
        if (txManaging == null) {
            h.c.b0<TxManaging> error = h.c.b0.error(new TxException.MissingTxManaging(blockchain));
            kotlin.jvm.internal.m.f(error, "error(TxException.MissingTxManaging(blockchain))");
            return error;
        }
        h.c.b0<TxManaging> just = h.c.b0.just(txManaging);
        kotlin.jvm.internal.m.f(just, "just(repository)");
        return just;
    }

    /* renamed from: validateTransferTx$lambda-8 */
    public static final kotlin.x m1887validateTransferTx$lambda8(UnsignedTxResult it) {
        kotlin.jvm.internal.m.g(it, "it");
        Throwable error = it.getError();
        if (error == null) {
            return kotlin.x.a;
        }
        throw error;
    }

    @Override // com.coinbase.wallet.core.interfaces.Destroyable
    public h.c.b0<Boolean> destroy() {
        h.c.b0<Boolean> fromCallable = h.c.b0.fromCallable(new Callable() { // from class: com.coinbase.wallet.wallets.repositories.a0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TxRepository.e(TxRepository.this);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        disposeBag.clear()\n        true\n    }");
        return fromCallable;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.b0<UnsignedTxResult> generateUnsigned1559Tx(final Wallet wallet, final TransferValue amount, final String recipientAddress, final Map<TxMetadataKey, ? extends Object> metadata, final BigInteger bigInteger, final BigInteger bigInteger2, final BigInteger bigInteger3, final BigInteger bigInteger4, final Integer num) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
        boolean z = amount instanceof TransferValue.EntireBalance;
        h.c.b0<R> flatMap = transactionRepository(wallet.getBlockchain()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.x
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.b(Wallet.this, amount, recipientAddress, metadata, bigInteger, bigInteger2, bigInteger3, bigInteger4, num, (TxManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "transactionRepository(wallet.blockchain)\n            .flatMap { repository ->\n                val ethRepository = repository as? IETHTxRepository\n                ethRepository?.generateUnsignedEthereum1559Tx(\n                    wallet = wallet,\n                    amount = amount,\n                    recipientAddress = recipientAddress,\n                    metadata = metadata,\n                    maxFeePerGas = maxFeePerGas,\n                    baseFeePerGas = baseFeePerGas,\n                    maxPriorityFeePerGas = maxPriorityFeePerGas,\n                    gasLimit = gasLimit,\n                    nonce = nonce\n                )\n            }");
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        h.c.b0<UnsignedTxResult> onEventTrack = Single_AnalyticsKt.onEventTrack(flatMap, AnalyticsEvent_WalletsKt.txGenerationStart(companion, wallet.getCurrencyCode().getRawValue(), uuid, z), AnalyticsEvent_WalletsKt.txGenerationSuccess(companion, wallet.getCurrencyCode().getRawValue(), uuid, z), AnalyticsEvent_WalletsKt.txGenerationFail(companion, wallet.getCurrencyCode().getRawValue(), uuid, z));
        kotlin.jvm.internal.m.f(onEventTrack, "transactionRepository(wallet.blockchain)\n            .flatMap { repository ->\n                val ethRepository = repository as? IETHTxRepository\n                ethRepository?.generateUnsignedEthereum1559Tx(\n                    wallet = wallet,\n                    amount = amount,\n                    recipientAddress = recipientAddress,\n                    metadata = metadata,\n                    maxFeePerGas = maxFeePerGas,\n                    baseFeePerGas = baseFeePerGas,\n                    maxPriorityFeePerGas = maxPriorityFeePerGas,\n                    gasLimit = gasLimit,\n                    nonce = nonce\n                )\n            }\n            .onEventTrack(\n                subscribe = AnalyticsEvent.txGenerationStart(wallet.currencyCode.rawValue, uuid, isMax),\n                success = AnalyticsEvent.txGenerationSuccess(wallet.currencyCode.rawValue, uuid, isMax),\n                error = AnalyticsEvent.txGenerationFail(wallet.currencyCode.rawValue, uuid, isMax)\n            )");
        return onEventTrack;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.b0<UnsignedTxResult> generateUnsignedTx(final Wallet wallet, final TransferValue amount, final String recipientAddress, final Map<TxMetadataKey, ? extends Object> metadata, final BigInteger bigInteger, final BigInteger bigInteger2, final Integer num) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
        boolean z = amount instanceof TransferValue.EntireBalance;
        h.c.b0<R> flatMap = transactionRepository(wallet.getBlockchain()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.k0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.o(Wallet.this, amount, recipientAddress, metadata, bigInteger, bigInteger2, num, (TxManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "transactionRepository(wallet.blockchain)\n            .flatMap { repository ->\n                repository.generateUnsignedTx(\n                    wallet = wallet,\n                    amount = amount,\n                    recipientAddress = recipientAddress,\n                    metadata = metadata,\n                    gasPrice = gasPrice,\n                    gasLimit = gasLimit,\n                    nonce = nonce\n                )\n            }");
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        h.c.b0<UnsignedTxResult> onEventTrack = Single_AnalyticsKt.onEventTrack(flatMap, AnalyticsEvent_WalletsKt.txGenerationStart(companion, wallet.getCurrencyCode().getRawValue(), uuid, z), AnalyticsEvent_WalletsKt.txGenerationSuccess(companion, wallet.getCurrencyCode().getRawValue(), uuid, z), AnalyticsEvent_WalletsKt.txGenerationFail(companion, wallet.getCurrencyCode().getRawValue(), uuid, z));
        kotlin.jvm.internal.m.f(onEventTrack, "transactionRepository(wallet.blockchain)\n            .flatMap { repository ->\n                repository.generateUnsignedTx(\n                    wallet = wallet,\n                    amount = amount,\n                    recipientAddress = recipientAddress,\n                    metadata = metadata,\n                    gasPrice = gasPrice,\n                    gasLimit = gasLimit,\n                    nonce = nonce\n                )\n            }\n            .onEventTrack(\n                subscribe = AnalyticsEvent.txGenerationStart(wallet.currencyCode.rawValue, uuid, isMax),\n                success = AnalyticsEvent.txGenerationSuccess(wallet.currencyCode.rawValue, uuid, isMax),\n                error = AnalyticsEvent.txGenerationFail(wallet.currencyCode.rawValue, uuid, isMax)\n            )");
        return onEventTrack;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.b0<TxState> getTxState(Blockchain blockchain, final Network network, final String txHash) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(network, "network");
        kotlin.jvm.internal.m.g(txHash, "txHash");
        h.c.b0 flatMap = transactionRepository(blockchain).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.b0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.f(txHash, network, (TxManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "transactionRepository(blockchain).flatMap { it.getTxState(txHash, network) }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.s<TxUpdate> getTxUpdatesObservable() {
        return this.txUpdatesObservable;
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.b0<Boolean> isValidAddress(Blockchain blockchain, final Network network, final String address) {
        kotlin.jvm.internal.m.g(blockchain, "blockchain");
        kotlin.jvm.internal.m.g(network, "network");
        kotlin.jvm.internal.m.g(address, "address");
        h.c.b0 flatMap = transactionRepository(blockchain).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.c0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.g(address, network, (TxManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "transactionRepository(blockchain).flatMap { it.isValidAddress(address, network) }");
        return flatMap;
    }

    @Override // com.coinbase.wallet.core.interfaces.Refreshable
    public h.c.b0<kotlin.x> refresh(boolean z) {
        int r;
        int r2;
        h.c.b0 zip;
        List g2;
        List<TxManaging> list = this.repositories;
        r = kotlin.a0.s.r(list, 10);
        final ArrayList<kotlin.o> arrayList = new ArrayList(r);
        for (TxManaging txManaging : list) {
            final String uuid = UUID.randomUUID().toString();
            kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
            Network network = getNetwork(txManaging.getConfiguration().getBlockchain());
            final CurrencyCode currencyCodeForNetwork = txManaging.getConfiguration().currencyCodeForNetwork(network);
            h.c.b0<kotlin.x> it = Single_CoreKt.asUnit(txManaging.resubmitPendingTxs(network)).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.wallets.repositories.i0
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    TxRepository.m(CurrencyCode.this, uuid, (Throwable) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.z
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxRepository.d((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(it, "it");
            arrayList.add(new kotlin.o(txManaging.getConfiguration().getBlockchain(), new RxTask(it)));
        }
        r2 = kotlin.a0.s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r2);
        for (kotlin.o oVar : arrayList) {
            arrayList2.add(((RxTask) oVar.d()).getOnCompletion());
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList2.isEmpty()) {
            g2 = kotlin.a0.r.g();
            zip = h.c.b0.just(g2);
            kotlin.jvm.internal.m.f(zip, "just(emptyList())");
        } else {
            zip = h.c.b0.zip(arrayList2, new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.TxRepository$refresh$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    int length = it2.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = it2[i2];
                        if (obj != null ? obj instanceof kotlin.x : true) {
                            arrayList3.add(obj);
                        }
                    }
                    return arrayList3;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        h.c.b0 doOnSubscribe = Single_CoreKt.trace(zip, TraceKey_WalletsKt.txRepositoryRefreshTrace(TraceKey.Companion), this.tracer).doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.wallets.repositories.d0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                TxRepository.h(arrayList, this, (h.c.k0.b) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSubscribe, "tasks.map { it.second.onCompletion }\n            .zipOrEmpty()\n            .trace(TraceKey.txRepositoryRefreshTrace(), tracer)\n            .doOnSubscribe { tasks.forEach { submissionSubjects.require(it.first).onNext(it.second) } }");
        return Single_CoreKt.asUnit(doOnSubscribe);
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.b0<SignedTx> signAndSubmit(final UnsignedTx unsignedTx, final String mnemonic, boolean z) {
        kotlin.jvm.internal.m.g(unsignedTx, "unsignedTx");
        kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
        String uuid = UUID.randomUUID().toString();
        kotlin.jvm.internal.m.f(uuid, "randomUUID().toString()");
        h.c.b0<R> flatMap = transactionRepository(unsignedTx.getBlockchain()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.g0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.k(UnsignedTx.this, mnemonic, (TxManaging) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMap, "transactionRepository(unsignedTx.blockchain)\n            .flatMap { it.signAndSubmit(unsignedTx, mnemonic, true) }");
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        h.c.b0 signAndSubmitSingle = Single_AnalyticsKt.onEventTrack(flatMap, AnalyticsEvent_WalletsKt.txSubmittedStart(companion, unsignedTx.getCurrencyCode().getRawValue(), uuid), AnalyticsEvent_WalletsKt.txSubmittedSuccess(companion, unsignedTx.getCurrencyCode().getRawValue(), uuid), AnalyticsEvent_WalletsKt.txSubmittedFail(companion, unsignedTx.getCurrencyCode().getRawValue(), uuid));
        kotlin.jvm.internal.m.f(signAndSubmitSingle, "signAndSubmitSingle");
        final RxTask rxTask = new RxTask(signAndSubmitSingle);
        h.c.b0<SignedTx> doOnSubscribe = rxTask.getOnCompletion().doOnSubscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.wallets.repositories.h0
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                TxRepository.l(TxRepository.this, unsignedTx, rxTask, (h.c.k0.b) obj);
            }
        });
        kotlin.jvm.internal.m.f(doOnSubscribe, "task.onCompletion.doOnSubscribe { submissionSubjects.require(unsignedTx.blockchain).onNext(task) }");
        return doOnSubscribe;
    }

    @Override // com.coinbase.wallet.core.interfaces.Startable
    public void start() {
        Iterator<T> it = this.submissionSubjects.values().iterator();
        while (it.hasNext()) {
            h.c.k0.b subscribe = ((h.c.v0.b) it.next()).observeOn(this.serialTxRepositoryScheduler).concatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.f0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxRepository.j((RxTask) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.j0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return TxRepository.n((Throwable) obj);
                }
            }).subscribe();
            kotlin.jvm.internal.m.f(subscribe, "subject\n                .observeOn(serialTxRepositoryScheduler)\n                .concatMap { task ->\n                    task.execute()\n                        .asUnit()\n                        .onErrorReturn { Unit }\n                        .toObservable()\n                }\n                .onErrorReturn { Unit }\n                .subscribe()");
            h.c.t0.a.a(subscribe, this.disposeBag);
        }
    }

    @Override // com.coinbase.wallet.wallets.interfaces.ITxRepository
    public h.c.b0<kotlin.x> validateTransferTx(Wallet wallet, TransferValue amount, String recipientAddress, Map<TxMetadataKey, ? extends Object> metadata) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        kotlin.jvm.internal.m.g(amount, "amount");
        kotlin.jvm.internal.m.g(recipientAddress, "recipientAddress");
        kotlin.jvm.internal.m.g(metadata, "metadata");
        h.c.b0<kotlin.x> map = ITxRepository.DefaultImpls.generateUnsignedTx$default(this, wallet, amount, recipientAddress, metadata, null, null, null, 112, null).map(new h.c.m0.n() { // from class: com.coinbase.wallet.wallets.repositories.e0
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxRepository.i((UnsignedTxResult) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "generateUnsignedTx(wallet, amount, recipientAddress, metadata)\n        .map { it.error?.let { err -> throw err } ?: Unit }");
        return map;
    }
}