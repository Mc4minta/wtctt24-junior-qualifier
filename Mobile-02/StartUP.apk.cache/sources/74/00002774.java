package com.coinbase.wallet.txhistory.operations;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.bip44wallets.extensions.TxMetadataKey_BIP44WalletsKt;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.apis.TxHistoryApi;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.dtos.GetHdWalletTxsInputOutput;
import com.coinbase.wallet.txhistory.dtos.GetHdWalletTxsResponse;
import com.coinbase.wallet.txhistory.extensions.StoreKeys_TxHistoryKt;
import com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.reactnativecommunity.webview.RNCWebViewManager;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.a0.m0;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;
import kotlin.u;

/* compiled from: SyncHdWalletTxHistoryOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102Jq\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001a8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\"8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b#\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u00063"}, d2 = {"Lcom/coinbase/wallet/txhistory/operations/SyncHdWalletTxHistoryOperation;", "Lcom/coinbase/wallet/txhistory/interfaces/TxHistorySyncing;", "", "", ApiConstants.ADDRESSES, "Lcom/coinbase/wallet/blockchains/models/Transaction;", "after", "pagingToken", "", "page", "perPage", "Lkotlin/Function1;", "Lh/c/b0;", "", "fetchCompletionCondition", "getHdWalletTxs", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILkotlin/e0/c/l;)Lh/c/b0;", "Lcom/coinbase/wallet/txhistory/dtos/GetHdWalletTxsResponse;", "responses", "parseHdWalletTxResponse", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "getTransactions", "()Lh/c/b0;", "Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "api", "Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "hasSyncedTxsKey", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "getHasSyncedTxsKey", "()Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "isSyncingTxsKey", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "()Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "dao", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "<init>", "(Lcom/coinbase/wallet/txhistory/apis/TxHistoryApi;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SyncHdWalletTxHistoryOperation extends TxHistorySyncing {
    private final TxHistoryApi api;
    private final Blockchain blockchain;
    private final SharedPrefsStoreKey<Boolean> hasSyncedTxsKey;
    private final MemoryStoreKey<Boolean> isSyncingTxsKey;
    private final IWalletRepository walletRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncHdWalletTxHistoryOperation(TxHistoryApi api, IWalletRepository walletRepository, Blockchain blockchain, CurrencyCode currencyCode, Network network, TxHistoryDAO dao, StoreInterface store) {
        super(currencyCode, network, dao, store);
        m.g(api, "api");
        m.g(walletRepository, "walletRepository");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(dao, "dao");
        m.g(store, "store");
        this.api = api;
        this.walletRepository = walletRepository;
        this.blockchain = blockchain;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        this.isSyncingTxsKey = StoreKeys_TxHistoryKt.isSyncingTxHistory(storeKeys, currencyCode, network);
        this.hasSyncedTxsKey = StoreKeys_TxHistoryKt.hasSyncedTxHistory(storeKeys, currencyCode, network);
    }

    private final b0<List<Transaction>> getHdWalletTxs(final List<String> list, final List<Transaction> list2, String str, final int i2, final int i3, final kotlin.e0.c.l<? super List<Transaction>, ? extends b0<Boolean>> lVar) {
        if (i2 >= getMaximumPages()) {
            b0<List<Transaction>> just = b0.just(list2);
            m.f(just, "{\n        Single.just(after)\n    }");
            return just;
        }
        b0<List<Transaction>> flatMap = this.api.getHdWalletTxs(getCurrencyCode(), list, getNetwork().isTestnet(), str, i3).map(new n() { // from class: com.coinbase.wallet.txhistory.operations.j
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncHdWalletTxHistoryOperation.j(SyncHdWalletTxHistoryOperation.this, list, (o) obj);
            }
        }).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.h
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncHdWalletTxHistoryOperation.h(list2, lVar, (o) obj);
            }
        }).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.k
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncHdWalletTxHistoryOperation.k(SyncHdWalletTxHistoryOperation.this, list, i2, i3, lVar, (t) obj);
            }
        });
        m.f(flatMap, "{\n        api.getHdWalletTxs(currencyCode, addresses, network.isTestnet, pagingToken, perPage)\n            .map { (response, pagingToken) ->\n                parseHdWalletTxResponse(response, addresses) to pagingToken\n            }\n            .flatMap { (txs, pagingToken) ->\n                Singles.zip(Single.just(after + txs), Single.just(pagingToken), fetchCompletionCondition(txs))\n            }\n            .flatMap { (txs, newPagingToken, done) ->\n                if (done || newPagingToken.replace(\"\\\\s\".toRegex(), \"\").isEmpty()) {\n                    return@flatMap Single.just(txs)\n                }\n\n                getHdWalletTxs(addresses, txs, newPagingToken, page + 1, perPage, fetchCompletionCondition)\n            }\n    }");
        return flatMap;
    }

    /* renamed from: getHdWalletTxs$lambda-2 */
    public static final o m1762getHdWalletTxs$lambda2(SyncHdWalletTxHistoryOperation this$0, List addresses, o dstr$response$pagingToken) {
        m.g(this$0, "this$0");
        m.g(addresses, "$addresses");
        m.g(dstr$response$pagingToken, "$dstr$response$pagingToken");
        return u.a(this$0.parseHdWalletTxResponse((List) dstr$response$pagingToken.a(), addresses), (String) dstr$response$pagingToken.b());
    }

    /* renamed from: getHdWalletTxs$lambda-3 */
    public static final h0 m1763getHdWalletTxs$lambda3(List after, kotlin.e0.c.l fetchCompletionCondition, o dstr$txs$pagingToken) {
        List t0;
        m.g(after, "$after");
        m.g(fetchCompletionCondition, "$fetchCompletionCondition");
        m.g(dstr$txs$pagingToken, "$dstr$txs$pagingToken");
        List list = (List) dstr$txs$pagingToken.a();
        h.c.t0.e eVar = h.c.t0.e.a;
        t0 = z.t0(after, list);
        b0 just = b0.just(t0);
        m.f(just, "just(after + txs)");
        b0 just2 = b0.just((String) dstr$txs$pagingToken.b());
        m.f(just2, "just(pagingToken)");
        return eVar.b(just, just2, (h0) fetchCompletionCondition.invoke(list));
    }

    /* renamed from: getHdWalletTxs$lambda-4 */
    public static final h0 m1764getHdWalletTxs$lambda4(SyncHdWalletTxHistoryOperation this$0, List addresses, int i2, int i3, kotlin.e0.c.l fetchCompletionCondition, t dstr$txs$newPagingToken$done) {
        m.g(this$0, "this$0");
        m.g(addresses, "$addresses");
        m.g(fetchCompletionCondition, "$fetchCompletionCondition");
        m.g(dstr$txs$newPagingToken$done, "$dstr$txs$newPagingToken$done");
        List<Transaction> txs = (List) dstr$txs$newPagingToken$done.a();
        String newPagingToken = (String) dstr$txs$newPagingToken$done.b();
        Boolean done = (Boolean) dstr$txs$newPagingToken$done.c();
        m.f(done, "done");
        if (!done.booleanValue()) {
            m.f(newPagingToken, "newPagingToken");
            if (!(new kotlin.l0.k("\\s").e(newPagingToken, "").length() == 0)) {
                m.f(txs, "txs");
                return this$0.getHdWalletTxs(addresses, txs, newPagingToken, i2 + 1, i3, fetchCompletionCondition);
            }
        }
        return b0.just(txs);
    }

    /* renamed from: getTransactions$lambda-1 */
    public static final h0 m1765getTransactions$lambda1(SyncHdWalletTxHistoryOperation this$0, List addresses) {
        int r;
        List<Transaction> g2;
        m.g(this$0, "this$0");
        m.g(addresses, "addresses");
        r = s.r(addresses, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = addresses.iterator();
        while (it.hasNext()) {
            arrayList.add(((Address) it.next()).getAddress());
        }
        g2 = r.g();
        return this$0.getHdWalletTxs(arrayList, g2, null, 0, this$0.getPerPage(), this$0.getFetchCompletionCondition());
    }

    public static /* synthetic */ h0 h(List list, kotlin.e0.c.l lVar, o oVar) {
        return m1763getHdWalletTxs$lambda3(list, lVar, oVar);
    }

    public static /* synthetic */ h0 i(SyncHdWalletTxHistoryOperation syncHdWalletTxHistoryOperation, List list) {
        return m1765getTransactions$lambda1(syncHdWalletTxHistoryOperation, list);
    }

    public static /* synthetic */ o j(SyncHdWalletTxHistoryOperation syncHdWalletTxHistoryOperation, List list, o oVar) {
        return m1762getHdWalletTxs$lambda2(syncHdWalletTxHistoryOperation, list, oVar);
    }

    public static /* synthetic */ h0 k(SyncHdWalletTxHistoryOperation syncHdWalletTxHistoryOperation, List list, int i2, int i3, kotlin.e0.c.l lVar, t tVar) {
        return m1764getHdWalletTxs$lambda4(syncHdWalletTxHistoryOperation, list, i2, i3, lVar, tVar);
    }

    private final List<Transaction> parseHdWalletTxResponse(List<GetHdWalletTxsResponse> list, List<String> list2) {
        int r;
        Date date;
        BigInteger bigInteger;
        List B0;
        Object obj;
        List B02;
        Object obj2;
        Map l2;
        HashSet hashSet = new HashSet(list2);
        r = s.r(list, 10);
        ArrayList arrayList = new ArrayList(r);
        for (GetHdWalletTxsResponse getHdWalletTxsResponse : list) {
            Date date2 = new Date(((long) getHdWalletTxsResponse.getTime()) * ((long) RNCWebViewManager.COMMAND_CLEAR_FORM_DATA));
            BigInteger bigInteger2 = new BigInteger(Strings.zero);
            BigInteger bigInteger3 = new BigInteger(Strings.zero);
            for (GetHdWalletTxsInputOutput getHdWalletTxsInputOutput : getHdWalletTxsResponse.getInputs()) {
                BigInteger value = getHdWalletTxsInputOutput.getValue();
                bigInteger2 = bigInteger2.add(value);
                m.f(bigInteger2, "this.add(other)");
                if (hashSet.contains(getHdWalletTxsInputOutput.getAddress())) {
                    bigInteger3 = bigInteger3.add(value);
                    m.f(bigInteger3, "this.add(other)");
                }
            }
            BigInteger bigInteger4 = new BigInteger(Strings.zero);
            BigInteger bigInteger5 = new BigInteger(Strings.zero);
            for (GetHdWalletTxsInputOutput getHdWalletTxsInputOutput2 : getHdWalletTxsResponse.getOutputs()) {
                BigInteger value2 = getHdWalletTxsInputOutput2.getValue();
                bigInteger4 = bigInteger4.add(value2);
                m.f(bigInteger4, "this.add(other)");
                if (hashSet.contains(getHdWalletTxsInputOutput2.getAddress())) {
                    bigInteger5 = bigInteger5.add(value2);
                    m.f(bigInteger5, "this.add(other)");
                }
            }
            boolean z = bigInteger3.compareTo(bigInteger5) > 0;
            BigInteger subtract = bigInteger2.subtract(bigInteger4);
            m.f(subtract, "this.subtract(other)");
            if (getHdWalletTxsResponse.getOutputs().size() > 2) {
                date = date2;
                BigInteger valueOf = BigInteger.valueOf(getHdWalletTxsResponse.getOutputs().size());
                m.f(valueOf, "BigInteger.valueOf(this.toLong())");
                subtract = subtract.divide(valueOf);
            } else {
                date = date2;
            }
            BigInteger fee = subtract;
            if (z) {
                BigInteger subtract2 = bigInteger2.subtract(bigInteger5);
                m.f(subtract2, "this.subtract(other)");
                m.f(fee, "fee");
                BigInteger subtract3 = subtract2.subtract(fee);
                m.f(subtract3, "this.subtract(other)");
                bigInteger = subtract3;
            } else {
                bigInteger = bigInteger5;
            }
            B0 = z.B0(getHdWalletTxsResponse.getOutputs(), new Comparator<T>() { // from class: com.coinbase.wallet.txhistory.operations.SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$lambda-9$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int c2;
                    c2 = kotlin.b0.b.c(((GetHdWalletTxsInputOutput) t2).getValue(), ((GetHdWalletTxsInputOutput) t).getValue());
                    return c2;
                }
            });
            SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$toAddressFilter$1 syncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$toAddressFilter$1 = new SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$toAddressFilter$1(z, hashSet);
            Iterator it = B0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (syncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$toAddressFilter$1.invoke((SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$toAddressFilter$1) obj).booleanValue()) {
                    break;
                }
            }
            GetHdWalletTxsInputOutput getHdWalletTxsInputOutput3 = (GetHdWalletTxsInputOutput) obj;
            if (getHdWalletTxsInputOutput3 == null) {
                getHdWalletTxsInputOutput3 = (GetHdWalletTxsInputOutput) p.a0(B0);
            }
            String address = getHdWalletTxsInputOutput3 == null ? null : getHdWalletTxsInputOutput3.getAddress();
            B02 = z.B0(getHdWalletTxsResponse.getInputs(), new Comparator<T>() { // from class: com.coinbase.wallet.txhistory.operations.SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$lambda-9$$inlined$sortedByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int c2;
                    c2 = kotlin.b0.b.c(((GetHdWalletTxsInputOutput) t2).getValue(), ((GetHdWalletTxsInputOutput) t).getValue());
                    return c2;
                }
            });
            SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1 syncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1 = new SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1(z, hashSet);
            Iterator it2 = B02.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (syncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1.invoke((SyncHdWalletTxHistoryOperation$parseHdWalletTxResponse$1$fromAddressFilter$1) obj2).booleanValue()) {
                    break;
                }
            }
            GetHdWalletTxsInputOutput getHdWalletTxsInputOutput4 = (GetHdWalletTxsInputOutput) obj2;
            if (getHdWalletTxsInputOutput4 == null) {
                getHdWalletTxsInputOutput4 = (GetHdWalletTxsInputOutput) p.a0(B02);
            }
            String address2 = getHdWalletTxsInputOutput4 == null ? null : getHdWalletTxsInputOutput4.getAddress();
            TxMetadataKey.Companion companion = TxMetadataKey.Companion;
            l2 = m0.l(u.a(TxMetadataKey_BIP44WalletsKt.getInputCount(companion), UInt.h(UInt.s(getHdWalletTxsResponse.getInputs().size()))), u.a(TxMetadataKey_BIP44WalletsKt.getOutputCount(companion), UInt.h(UInt.s(getHdWalletTxsResponse.getOutputs().size()))));
            TxMetadata txMetadata = new TxMetadata(l2);
            String uuid = UUID.randomUUID().toString();
            Blockchain blockchain = this.blockchain;
            CurrencyCode currencyCode = getCurrencyCode();
            CurrencyCode currencyCode2 = getCurrencyCode();
            TxState txState = TxState.CONFIRMED;
            Network network = getNetwork();
            String hash = getHdWalletTxsResponse.getHash();
            m.f(uuid, "toString()");
            m.f(fee, "fee");
            arrayList.add(new Transaction(uuid, date, date, blockchain, currencyCode, currencyCode2, address, address2, bigInteger, fee, null, txState, txMetadata, network, hash, z, 1024, null));
        }
        return arrayList;
    }

    @Override // com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing
    public b0<List<Transaction>> getTransactions() {
        b0 flatMap = this.walletRepository.getUsedAddresses(this.blockchain, getNetwork()).flatMap(new n() { // from class: com.coinbase.wallet.txhistory.operations.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncHdWalletTxHistoryOperation.i(SyncHdWalletTxHistoryOperation.this, (List) obj);
            }
        });
        m.f(flatMap, "walletRepository.getUsedAddresses(blockchain, network)\n        .flatMap { addresses ->\n            getHdWalletTxs(\n                addresses = addresses.map { it.address },\n                after = emptyList(),\n                pagingToken = null,\n                page = 0,\n                perPage = perPage,\n                fetchCompletionCondition = fetchCompletionCondition\n            )\n        }");
        return flatMap;
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