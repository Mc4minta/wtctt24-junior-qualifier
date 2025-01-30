package com.coinbase.wallet.txhistory.interfaces;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.extensions.TxMetadataKey_BlockchainsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.TxMetadataKey_EthereumKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKey;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.extensions.AnalyticsEvent_TxHistoryKt;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: TxHistorySyncing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010/\u001a\u00020.\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b<\u0010=JC\u0010\b\u001a(\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0007*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00060\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ7\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0007*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u00020\u000f8\u0004@\u0004X\u0084D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00148\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010%\u001a\u00020$8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u0010,\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001c\u0010/\u001a\u00020.8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0013\u00104\u001a\u00020\u000f8F@\u0006¢\u0006\u0006\u001a\u0004\b3\u0010\u0013R\u001c\u00106\u001a\u0002058\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a0)8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010+¨\u0006>"}, d2 = {"Lcom/coinbase/wallet/txhistory/interfaces/TxHistorySyncing;", "", "", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "txs", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "kotlin.jvm.PlatformType", "deduplicateAndSave", "(Ljava/util/List;)Lh/c/b0;", "deduplicate", "getTransactions", "()Lh/c/b0;", "Lkotlin/x;", "syncTxHistory", "", "maximumPages", "I", "getMaximumPages", "()I", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lkotlin/Function1;", "", "getFetchCompletionCondition", "()Lkotlin/e0/c/l;", "fetchCompletionCondition", "newValue", "getHasSyncedTxs", "()Z", "setHasSyncedTxs", "(Z)V", "hasSyncedTxs", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "()Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/wallet/store/models/StoreKey;", "isSyncingTxsKey", "()Lcom/coinbase/wallet/store/models/StoreKey;", "isSyncingTxs", "setSyncingTxs", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "()Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getPerPage", "perPage", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "dao", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "getDao", "()Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "getHasSyncedTxsKey", "hasSyncedTxsKey", "<init>", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class TxHistorySyncing {
    private final CurrencyCode currencyCode;
    private final TxHistoryDAO dao;
    private final int maximumPages;
    private final Network network;
    private final StoreInterface store;

    public TxHistorySyncing(CurrencyCode currencyCode, Network network, TxHistoryDAO dao, StoreInterface store) {
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(dao, "dao");
        m.g(store, "store");
        this.currencyCode = currencyCode;
        this.network = network;
        this.dao = dao;
        this.store = store;
        this.maximumPages = 20;
    }

    public static /* synthetic */ x a(TxHistorySyncing txHistorySyncing, Optional optional) {
        return m1751syncTxHistory$lambda1(txHistorySyncing, optional);
    }

    public static /* synthetic */ Map b(List list) {
        return m1748deduplicate$lambda8(list);
    }

    public static /* synthetic */ h0 c(TxHistorySyncing txHistorySyncing, List list) {
        return m1749deduplicateAndSave$lambda3(txHistorySyncing, list);
    }

    public static /* synthetic */ h0 d(TxHistorySyncing txHistorySyncing, List list) {
        return m1750syncTxHistory$lambda0(txHistorySyncing, list);
    }

    private final b0<List<Transaction>> deduplicate(final List<Transaction> list) {
        int r;
        b0 zip;
        List g2;
        h.c.t0.e eVar = h.c.t0.e.a;
        ArrayList<String> arrayList = new ArrayList();
        for (Transaction transaction : list) {
            String txHash = transaction.getTxHash();
            if (txHash != null) {
                arrayList.add(txHash);
            }
        }
        r = s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (String str : arrayList) {
            arrayList2.add(getDao().getTxsByHash(str));
        }
        if (arrayList2.isEmpty()) {
            g2 = r.g();
            zip = b0.just(g2);
            m.f(zip, "just(emptyList())");
        } else {
            zip = b0.zip(arrayList2, new n() { // from class: com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing$deduplicate$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g3;
                    m.g(it, "it");
                    if (it.length == 0) {
                        g3 = r.g();
                        return g3;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : it) {
                        if (obj instanceof List) {
                            arrayList3.add(obj);
                        }
                    }
                    return arrayList3;
                }
            });
            m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        }
        b0<List<Transaction>> map = zip.map(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistorySyncing.f((List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistorySyncing.b((List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistorySyncing.g(list, (Map) obj);
            }
        });
        m.f(map, "Singles\n        .zipOrEmpty(txs.mapNotNull { it.txHash }.map { dao.getTxsByHash(it) })\n        .map { it.flatten() }\n        .map { fetchedTxs ->\n            fetchedTxs.reduceIntoMap(mutableMapOf<String, MutableList<Transaction>>()) { mutableMap, tx ->\n                val txHash = tx.txHash ?: return@reduceIntoMap\n\n                val txsWithHash = mutableMap[txHash] ?: mutableListOf()\n                txsWithHash.add(tx)\n                mutableMap[txHash] = txsWithHash\n            }\n        }\n        .map { fetchedTxMap ->\n            txs\n                .map { tx ->\n                    tx.txHash\n                        ?.let { fetchedTxMap[it] }\n                        ?.let { fetchedTxs ->\n                            // We save multiple transfers that happen within a single Eth tx as individual transactions\n                            // with the same tx hash. We want to store the multiple transfers that happen within an Eth tx\n                            // as individual Transaction rows so that we can opt to show the user the meaningful (non-zero)\n                            // transfer within an Eth tx.\n                            fetchedTxs.firstOrNull {\n                                it.currencyCode == tx.currencyCode && it.amount == tx.amount\n                            }\n                        }\n                        ?.let { fetchedTx ->\n                            // default to true otherwise we'll record an event for all pre-existing tx's\n                            val hasRecordedConfirmEvent = fetchedTx.metadata[TxMetadataKey.hasRecordedConfirmEvent] as?\n                                Boolean ?: true\n                            if (!hasRecordedConfirmEvent) {\n                                val confirmedAt = tx.confirmedAt\n                                val minutesToConfirm = if (confirmedAt != null) {\n                                    val diffMs = confirmedAt.time - fetchedTx.createdAt.time\n                                    diffMs.milliseconds.inMinutes.toString()\n                                } else {\n                                    \"\"\n                                }\n\n                                val txSource = fetchedTx.metadata[TxMetadataKey.txSource] as? String ?: \"\"\n                                val chainId = fetchedTx.network.asEthereumChain?.chainId ?: -1\n                                val chainName = fetchedTx.network.asEthereumChain?.displayName ?: \"\"\n                                Analytics.log(\n                                    AnalyticsEvent.txConfirmed(\n                                        minutesToConfirm,\n                                        txSource,\n                                        tx.blockchain,\n                                        chainId,\n                                        chainName\n                                    )\n                                )\n                            }\n\n                            val newMetadata = fetchedTx.metadata.toMutableMap()\n                            newMetadata[TxMetadataKey.hasRecordedConfirmEvent] = true\n\n                            tx.copy(\n                                id = fetchedTx.id,\n                                createdAt = fetchedTx.createdAt,\n                                confirmedAt = tx.confirmedAt ?: fetchedTx.confirmedAt,\n                                metadata = TxMetadata(newMetadata)\n                            )\n                        } ?: tx\n                }\n        }");
        return map;
    }

    /* renamed from: deduplicate$lambda-14 */
    public static final List m1746deduplicate$lambda14(List txs, Map fetchedTxMap) {
        int r;
        List list;
        Object obj;
        Transaction copy;
        String displayName;
        boolean z;
        m.g(txs, "$txs");
        m.g(fetchedTxMap, "fetchedTxMap");
        r = s.r(txs, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = txs.iterator();
        while (it.hasNext()) {
            Transaction transaction = (Transaction) it.next();
            String txHash = transaction.getTxHash();
            if (txHash != null && (list = (List) fetchedTxMap.get(txHash)) != null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    Transaction transaction2 = (Transaction) obj;
                    if (m.c(transaction2.getCurrencyCode(), transaction.getCurrencyCode()) && m.c(transaction2.getAmount(), transaction.getAmount())) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                Transaction transaction3 = (Transaction) obj;
                if (transaction3 != null) {
                    TxMetadata metadata = transaction3.getMetadata();
                    TxMetadataKey.Companion companion = TxMetadataKey.Companion;
                    Object obj2 = metadata.get(TxMetadataKey_BlockchainsKt.getHasRecordedConfirmEvent(companion));
                    Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                    if (!(bool != null ? bool.booleanValue() : true)) {
                        Date confirmedAt = transaction.getConfirmedAt();
                        String valueOf = confirmedAt != null ? String.valueOf(kotlin.m0.a.n(kotlin.m0.b.d(confirmedAt.getTime() - transaction3.getCreatedAt().getTime()))) : "";
                        Object obj3 = transaction3.getMetadata().get(TxMetadataKey_EthereumKt.getTxSource(companion));
                        String str = obj3 instanceof String ? (String) obj3 : null;
                        String str2 = str == null ? "" : str;
                        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(transaction3.getNetwork());
                        int chainId = asEthereumChain == null ? -1 : asEthereumChain.getChainId();
                        EthereumChain asEthereumChain2 = Network_EthereumKt.getAsEthereumChain(transaction3.getNetwork());
                        Analytics.INSTANCE.log(AnalyticsEvent_TxHistoryKt.txConfirmed(AnalyticsEvent.Companion, valueOf, str2, transaction.getBlockchain(), chainId, (asEthereumChain2 == null || (displayName = asEthereumChain2.getDisplayName()) == null) ? "" : displayName));
                    }
                    Map<TxMetadataKey, Object> mutableMap = transaction3.getMetadata().toMutableMap();
                    mutableMap.put(TxMetadataKey_BlockchainsKt.getHasRecordedConfirmEvent(companion), Boolean.TRUE);
                    String id = transaction3.getId();
                    Date createdAt = transaction3.getCreatedAt();
                    Date confirmedAt2 = transaction.getConfirmedAt();
                    copy = transaction.copy((r34 & 1) != 0 ? transaction.getId() : id, (r34 & 2) != 0 ? transaction.createdAt : createdAt, (r34 & 4) != 0 ? transaction.confirmedAt : confirmedAt2 == null ? transaction3.getConfirmedAt() : confirmedAt2, (r34 & 8) != 0 ? transaction.blockchain : null, (r34 & 16) != 0 ? transaction.currencyCode : null, (r34 & 32) != 0 ? transaction.feeCurrencyCode : null, (r34 & 64) != 0 ? transaction.toAddress : null, (r34 & 128) != 0 ? transaction.fromAddress : null, (r34 & 256) != 0 ? transaction.amount : null, (r34 & 512) != 0 ? transaction.fee : null, (r34 & 1024) != 0 ? transaction.lowerBoundFee : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? transaction.state : null, (r34 & 4096) != 0 ? transaction.metadata : new TxMetadata(mutableMap), (r34 & PKIFailureInfo.certRevoked) != 0 ? transaction.network : null, (r34 & 16384) != 0 ? transaction.txHash : null, (r34 & 32768) != 0 ? transaction.isSent : false);
                    if (copy != null) {
                        transaction = copy;
                    }
                }
            }
            arrayList.add(transaction);
        }
        return arrayList;
    }

    /* renamed from: deduplicate$lambda-6 */
    public static final List m1747deduplicate$lambda6(List it) {
        List u;
        m.g(it, "it");
        u = s.u(it);
        return u;
    }

    /* renamed from: deduplicate$lambda-8 */
    public static final Map m1748deduplicate$lambda8(List fetchedTxs) {
        m.g(fetchedTxs, "fetchedTxs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = fetchedTxs.iterator();
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
        return linkedHashMap;
    }

    private final b0<Optional<List<Transaction>>> deduplicateAndSave(List<Transaction> list) {
        b0 flatMap = deduplicate(list).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistorySyncing.c(TxHistorySyncing.this, (List) obj);
            }
        });
        m.f(flatMap, "deduplicate(txs).flatMap { dao.saveTxs(it) }");
        return flatMap;
    }

    /* renamed from: deduplicateAndSave$lambda-3 */
    public static final h0 m1749deduplicateAndSave$lambda3(TxHistorySyncing this$0, List it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.getDao().saveTxs(it);
    }

    public static /* synthetic */ void e(TxHistorySyncing txHistorySyncing, Throwable th) {
        m1752syncTxHistory$lambda2(txHistorySyncing, th);
    }

    public static /* synthetic */ List f(List list) {
        return m1747deduplicate$lambda6(list);
    }

    public static /* synthetic */ List g(List list, Map map) {
        return m1746deduplicate$lambda14(list, map);
    }

    /* renamed from: syncTxHistory$lambda-0 */
    public static final h0 m1750syncTxHistory$lambda0(TxHistorySyncing this$0, List it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.deduplicateAndSave(it);
    }

    /* renamed from: syncTxHistory$lambda-1 */
    public static final x m1751syncTxHistory$lambda1(TxHistorySyncing this$0, Optional it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        this$0.setHasSyncedTxs(true);
        this$0.setSyncingTxs(false);
        return x.a;
    }

    /* renamed from: syncTxHistory$lambda-2 */
    public static final void m1752syncTxHistory$lambda2(TxHistorySyncing this$0, Throwable th) {
        m.g(this$0, "this$0");
        this$0.setSyncingTxs(false);
    }

    public final CurrencyCode getCurrencyCode() {
        return this.currencyCode;
    }

    public final TxHistoryDAO getDao() {
        return this.dao;
    }

    public final l<List<Transaction>, b0<Boolean>> getFetchCompletionCondition() {
        return !getHasSyncedTxs() ? new TxHistorySyncing$fetchCompletionCondition$1(this) : new TxHistorySyncing$fetchCompletionCondition$2(this);
    }

    public final boolean getHasSyncedTxs() {
        return m.c(this.store.get(getHasSyncedTxsKey()), Boolean.TRUE);
    }

    public abstract StoreKey<Boolean> getHasSyncedTxsKey();

    public final int getMaximumPages() {
        return this.maximumPages;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public final int getPerPage() {
        return getHasSyncedTxs() ? 10 : 50;
    }

    protected final StoreInterface getStore() {
        return this.store;
    }

    public abstract b0<List<Transaction>> getTransactions();

    public final boolean isSyncingTxs() {
        return m.c(this.store.get(isSyncingTxsKey()), Boolean.TRUE);
    }

    public abstract StoreKey<Boolean> isSyncingTxsKey();

    public final void setHasSyncedTxs(boolean z) {
        this.store.set(getHasSyncedTxsKey(), Boolean.valueOf(z));
    }

    public final void setSyncingTxs(boolean z) {
        this.store.set(isSyncingTxsKey(), Boolean.valueOf(z));
    }

    public final b0<x> syncTxHistory() {
        if (isSyncingTxs()) {
            b0<x> just = b0.just(x.a);
            m.f(just, "just(Unit)");
            return just;
        }
        setSyncingTxs(true);
        b0<x> doOnError = getTransactions().flatMap(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistorySyncing.d(TxHistorySyncing.this, (List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.txhistory.interfaces.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistorySyncing.a(TxHistorySyncing.this, (Optional) obj);
            }
        }).doOnError(new h.c.m0.f() { // from class: com.coinbase.wallet.txhistory.interfaces.e
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                TxHistorySyncing.e(TxHistorySyncing.this, (Throwable) obj);
            }
        });
        m.f(doOnError, "getTransactions()\n            .flatMap { deduplicateAndSave(it) }\n            .map {\n                hasSyncedTxs = true\n                isSyncingTxs = false\n            }\n            .doOnError {\n                isSyncingTxs = false\n            }");
        return doOnError;
    }
}