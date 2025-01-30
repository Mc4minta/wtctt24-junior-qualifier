package com.coinbase.wallet.txhistory.operations;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.apis.TxHistoryApi;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.extensions.StoreKeys_TxHistoryKt;
import com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;

/* compiled from: SyncEthereumTxHistoryOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001c\u001a\u00020\u0011\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/JC\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJY\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJk\u0010\u0014\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0013*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u00072\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JY\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ)\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0013*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00060"}, d2 = {"Lcom/coinbase/wallet/txhistory/operations/SyncEthereumTxHistoryOperation;", "Lcom/coinbase/wallet/txhistory/interfaces/TxHistorySyncing;", "", "perPage", "Lkotlin/Function1;", "", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "Lh/c/b0;", "", "fetchCompletionCondition", "getAllErc20Txs", "(ILkotlin/e0/c/l;)Lh/c/b0;", "after", "page", "getErc20Txs", "(Ljava/util/List;IILkotlin/e0/c/l;)Lh/c/b0;", "", "", "erc20Txs", "kotlin.jvm.PlatformType", "getAllEthereumTxs", "(Ljava/util/Map;ILkotlin/e0/c/l;)Lh/c/b0;", "getEthereumTxs", "getTransactions", "()Lh/c/b0;", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "chain", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "address", "Ljava/lang/String;", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "hasSyncedTxsKey", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "getHasSyncedTxsKey", "()Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "isSyncingTxsKey", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "()Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "api", "Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "dao", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;Lcom/coinbase/ciphercore/ethereum/EthereumChain;Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SyncEthereumTxHistoryOperation extends TxHistorySyncing {
    private final String address;
    private final TxHistoryApi api;
    private final EthereumChain chain;
    private final SharedPrefsStoreKey<Boolean> hasSyncedTxsKey;
    private final MemoryStoreKey<Boolean> isSyncingTxsKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncEthereumTxHistoryOperation(String address, TxHistoryApi api, EthereumChain chain, TxHistoryDAO dao, StoreInterface store) {
        super(CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion), EthereumChain_EthereumKt.getAsNetwork(chain), dao, store);
        m.g(address, "address");
        m.g(api, "api");
        m.g(chain, "chain");
        m.g(dao, "dao");
        m.g(store, "store");
        this.address = address;
        this.api = api;
        this.chain = chain;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        this.isSyncingTxsKey = StoreKeys_TxHistoryKt.isSyncingEthereumTxHistory(storeKeys, address, EthereumChain_EthereumKt.getAsNetwork(chain));
        this.hasSyncedTxsKey = StoreKeys_TxHistoryKt.hasSyncedEthereumTxHistory(storeKeys, address, EthereumChain_EthereumKt.getAsNetwork(chain));
    }

    private final b0<List<Transaction>> getAllErc20Txs(int i2, kotlin.e0.c.l<? super List<Transaction>, ? extends b0<Boolean>> lVar) {
        List<Transaction> g2;
        g2 = r.g();
        return getErc20Txs(g2, 1, i2, lVar);
    }

    private final b0<List<Transaction>> getAllEthereumTxs(final Map<String, ? extends List<Transaction>> map, int i2, kotlin.e0.c.l<? super List<Transaction>, ? extends b0<Boolean>> lVar) {
        List<Transaction> g2;
        g2 = r.g();
        b0 map2 = getEthereumTxs(g2, 1, i2, lVar).map(new n() { // from class: com.coinbase.wallet.txhistory.operations.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.m(map, (List) obj);
            }
        });
        m.f(map2, "getEthereumTxs(emptyList(), 1, perPage, fetchCompletionCondition)\n        .map { txs ->\n            txs\n                .reduceIntoMap(mutableMapOf<String, Transaction>()) { result, tx ->\n                    tx.txHash?.let { result[it] = tx }\n                }\n                .values\n                .filter { tx ->\n                    tx.txHash?.let { erc20Txs[it] == null } ?: false\n                }\n        }");
        return map2;
    }

    /* renamed from: getAllEthereumTxs$lambda-10 */
    public static final List m1755getAllEthereumTxs$lambda10(Map erc20Txs, List txs) {
        m.g(erc20Txs, "$erc20Txs");
        m.g(txs, "txs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = txs.iterator();
        while (it.hasNext()) {
            Transaction transaction = (Transaction) it.next();
            String txHash = transaction.getTxHash();
            if (txHash != null) {
                linkedHashMap.put(txHash, transaction);
            }
        }
        Collection values = linkedHashMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            String txHash2 = ((Transaction) obj).getTxHash();
            boolean z = false;
            if (txHash2 != null && erc20Txs.get(txHash2) == null) {
                z = true;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final b0<List<Transaction>> getErc20Txs(final List<Transaction> list, final int i2, final int i3, final kotlin.e0.c.l<? super List<Transaction>, ? extends b0<Boolean>> lVar) {
        if (i2 > getMaximumPages()) {
            b0<List<Transaction>> just = b0.just(list);
            m.f(just, "{\n        Single.just(after)\n    }");
            return just;
        }
        b0<List<Transaction>> flatMap = this.api.getErc20Txs(this.address, this.chain, i2, i3).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.n(list, lVar, (List) obj);
            }
        }).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.l(SyncEthereumTxHistoryOperation.this, i2, i3, lVar, (o) obj);
            }
        });
        m.f(flatMap, "{\n        api.getErc20Txs(address, chain, page, perPage)\n            .flatMap { Singles.zip(Single.just(after + it), fetchCompletionCondition(it)) }\n            .flatMap { (txs, done) ->\n                if (done) return@flatMap Single.just(txs)\n\n                getErc20Txs(txs, page + 1, perPage, fetchCompletionCondition)\n            }\n    }");
        return flatMap;
    }

    /* renamed from: getErc20Txs$lambda-4 */
    public static final h0 m1756getErc20Txs$lambda4(List after, kotlin.e0.c.l fetchCompletionCondition, List it) {
        List t0;
        m.g(after, "$after");
        m.g(fetchCompletionCondition, "$fetchCompletionCondition");
        m.g(it, "it");
        h.c.t0.e eVar = h.c.t0.e.a;
        t0 = z.t0(after, it);
        b0 just = b0.just(t0);
        m.f(just, "just(after + it)");
        return eVar.a(just, (h0) fetchCompletionCondition.invoke(it));
    }

    /* renamed from: getErc20Txs$lambda-5 */
    public static final h0 m1757getErc20Txs$lambda5(SyncEthereumTxHistoryOperation this$0, int i2, int i3, kotlin.e0.c.l fetchCompletionCondition, o dstr$txs$done) {
        m.g(this$0, "this$0");
        m.g(fetchCompletionCondition, "$fetchCompletionCondition");
        m.g(dstr$txs$done, "$dstr$txs$done");
        List<Transaction> txs = (List) dstr$txs$done.a();
        Boolean done = (Boolean) dstr$txs$done.b();
        m.f(done, "done");
        if (done.booleanValue()) {
            return b0.just(txs);
        }
        m.f(txs, "txs");
        return this$0.getErc20Txs(txs, i2 + 1, i3, fetchCompletionCondition);
    }

    private final b0<List<Transaction>> getEthereumTxs(final List<Transaction> list, final int i2, final int i3, final kotlin.e0.c.l<? super List<Transaction>, ? extends b0<Boolean>> lVar) {
        if (i2 > getMaximumPages()) {
            b0<List<Transaction>> just = b0.just(list);
            m.f(just, "{\n        Single.just(after)\n    }");
            return just;
        }
        b0<List<Transaction>> flatMap = this.api.getEthereumTxs(this.address, this.chain, i2, i3).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.i(list, lVar, (List) obj);
            }
        }).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.h(SyncEthereumTxHistoryOperation.this, i2, i3, lVar, (o) obj);
            }
        });
        m.f(flatMap, "{\n        api.getEthereumTxs(address, chain, page, perPage)\n            .flatMap { Singles.zip(Single.just(after + it), fetchCompletionCondition(it)) }\n            .flatMap { (txs, done) ->\n                if (done) return@flatMap Single.just(txs)\n\n                getEthereumTxs(txs, page + 1, perPage, fetchCompletionCondition)\n            }\n    }");
        return flatMap;
    }

    /* renamed from: getEthereumTxs$lambda-11 */
    public static final h0 m1758getEthereumTxs$lambda11(List after, kotlin.e0.c.l fetchCompletionCondition, List it) {
        List t0;
        m.g(after, "$after");
        m.g(fetchCompletionCondition, "$fetchCompletionCondition");
        m.g(it, "it");
        h.c.t0.e eVar = h.c.t0.e.a;
        t0 = z.t0(after, it);
        b0 just = b0.just(t0);
        m.f(just, "just(after + it)");
        return eVar.a(just, (h0) fetchCompletionCondition.invoke(it));
    }

    /* renamed from: getEthereumTxs$lambda-12 */
    public static final h0 m1759getEthereumTxs$lambda12(SyncEthereumTxHistoryOperation this$0, int i2, int i3, kotlin.e0.c.l fetchCompletionCondition, o dstr$txs$done) {
        m.g(this$0, "this$0");
        m.g(fetchCompletionCondition, "$fetchCompletionCondition");
        m.g(dstr$txs$done, "$dstr$txs$done");
        List<Transaction> txs = (List) dstr$txs$done.a();
        Boolean done = (Boolean) dstr$txs$done.b();
        m.f(done, "done");
        if (done.booleanValue()) {
            return b0.just(txs);
        }
        m.f(txs, "txs");
        return this$0.getEthereumTxs(txs, i2 + 1, i3, fetchCompletionCondition);
    }

    /* renamed from: getTransactions$lambda-3 */
    public static final h0 m1760getTransactions$lambda3(SyncEthereumTxHistoryOperation this$0, final List erc20Txs) {
        m.g(this$0, "this$0");
        m.g(erc20Txs, "erc20Txs");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = erc20Txs.iterator();
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
        return this$0.getAllEthereumTxs(linkedHashMap, this$0.getPerPage(), this$0.getFetchCompletionCondition()).map(new n() { // from class: com.coinbase.wallet.txhistory.operations.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.k(erc20Txs, (List) obj);
            }
        });
    }

    /* renamed from: getTransactions$lambda-3$lambda-2 */
    public static final List m1761getTransactions$lambda3$lambda2(List erc20Txs, List it) {
        List t0;
        m.g(erc20Txs, "$erc20Txs");
        m.g(it, "it");
        t0 = z.t0(it, erc20Txs);
        return t0;
    }

    public static /* synthetic */ h0 h(SyncEthereumTxHistoryOperation syncEthereumTxHistoryOperation, int i2, int i3, kotlin.e0.c.l lVar, o oVar) {
        return m1759getEthereumTxs$lambda12(syncEthereumTxHistoryOperation, i2, i3, lVar, oVar);
    }

    public static /* synthetic */ h0 i(List list, kotlin.e0.c.l lVar, List list2) {
        return m1758getEthereumTxs$lambda11(list, lVar, list2);
    }

    public static /* synthetic */ h0 j(SyncEthereumTxHistoryOperation syncEthereumTxHistoryOperation, List list) {
        return m1760getTransactions$lambda3(syncEthereumTxHistoryOperation, list);
    }

    public static /* synthetic */ List k(List list, List list2) {
        return m1761getTransactions$lambda3$lambda2(list, list2);
    }

    public static /* synthetic */ h0 l(SyncEthereumTxHistoryOperation syncEthereumTxHistoryOperation, int i2, int i3, kotlin.e0.c.l lVar, o oVar) {
        return m1757getErc20Txs$lambda5(syncEthereumTxHistoryOperation, i2, i3, lVar, oVar);
    }

    public static /* synthetic */ List m(Map map, List list) {
        return m1755getAllEthereumTxs$lambda10(map, list);
    }

    public static /* synthetic */ h0 n(List list, kotlin.e0.c.l lVar, List list2) {
        return m1756getErc20Txs$lambda4(list, lVar, list2);
    }

    @Override // com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing
    public b0<List<Transaction>> getTransactions() {
        b0<R> flatMap = getAllErc20Txs(getPerPage(), getFetchCompletionCondition()).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncEthereumTxHistoryOperation.j(SyncEthereumTxHistoryOperation.this, (List) obj);
            }
        });
        m.f(flatMap, "getAllErc20Txs(perPage, fetchCompletionCondition)\n        .flatMap { erc20Txs ->\n            val txMap = erc20Txs.reduceIntoMap(mutableMapOf<String, MutableList<Transaction>>()) { result, tx ->\n                tx.txHash?.let { txHash ->\n                    val txs = result[txHash] ?: mutableListOf()\n                    txs.add(tx)\n                    result[txHash] = txs\n                }\n            }\n\n            getAllEthereumTxs(txMap, perPage, fetchCompletionCondition).map { it + erc20Txs }\n        }");
        return Single_AnalyticsKt.logError$default(flatMap, null, null, 3, null);
    }

    @Override // com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing
    public SharedPrefsStoreKey<Boolean> getHasSyncedTxsKey() {
        return this.hasSyncedTxsKey;
    }

    @Override // com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing
    public MemoryStoreKey<Boolean> isSyncingTxsKey() {
        return this.isSyncingTxsKey;
    }
}