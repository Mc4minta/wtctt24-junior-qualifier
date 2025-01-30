package com.coinbase.wallet.txhistory.operations;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.ripple.extensions.CurrencyCode_RippleKt;
import com.coinbase.wallet.ripple.extensions.TxMetadataKey_RippleKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.extensions.StoreKeys_TxHistoryKt;
import com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing;
import com.coinbase.walletengine.services.xrp.XRPService;
import h.c.b0;
import h.c.m0.n;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.m;

/* compiled from: SyncXrpTxHistoryOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lcom/coinbase/wallet/txhistory/operations/SyncXrpTxHistoryOperation;", "Lcom/coinbase/wallet/txhistory/interfaces/TxHistorySyncing;", "Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "getTransactions", "()Lh/c/b0;", "Ljava/text/SimpleDateFormat;", "dateFormatter$delegate", "Lkotlin/h;", "getDateFormatter", "()Ljava/text/SimpleDateFormat;", "dateFormatter", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "", "isSyncingTxsKey", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "()Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "xrpService", "Lcom/coinbase/walletengine/services/xrp/XRPService;", "", "address", "Ljava/lang/String;", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "hasSyncedTxsKey", "Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "getHasSyncedTxsKey", "()Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "dao", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "<init>", "(Ljava/lang/String;Lcom/coinbase/walletengine/services/xrp/XRPService;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SyncXrpTxHistoryOperation extends TxHistorySyncing {
    private final String address;
    private final kotlin.h dateFormatter$delegate;
    private final SharedPrefsStoreKey<Boolean> hasSyncedTxsKey;
    private final MemoryStoreKey<Boolean> isSyncingTxsKey;
    private final XRPService xrpService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncXrpTxHistoryOperation(String address, XRPService xrpService, CurrencyCode currencyCode, Network network, TxHistoryDAO dao, StoreInterface store) {
        super(currencyCode, network, dao, store);
        kotlin.h b2;
        m.g(address, "address");
        m.g(xrpService, "xrpService");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(dao, "dao");
        m.g(store, "store");
        this.address = address;
        this.xrpService = xrpService;
        b2 = kotlin.k.b(SyncXrpTxHistoryOperation$dateFormatter$2.INSTANCE);
        this.dateFormatter$delegate = b2;
        StoreKeys storeKeys = StoreKeys.INSTANCE;
        this.isSyncingTxsKey = StoreKeys_TxHistoryKt.isSyncingTxHistory(storeKeys, currencyCode, network);
        this.hasSyncedTxsKey = StoreKeys_TxHistoryKt.hasSyncedTxHistory(storeKeys, currencyCode, network);
    }

    private final SimpleDateFormat getDateFormatter() {
        return (SimpleDateFormat) this.dateFormatter$delegate.getValue();
    }

    /* renamed from: getTransactions$lambda-2 */
    public static final List m1766getTransactions$lambda2(SyncXrpTxHistoryOperation this$0, List txs) {
        Transaction transaction;
        m.g(this$0, "this$0");
        m.g(txs, "txs");
        ArrayList arrayList = new ArrayList();
        Iterator it = txs.iterator();
        while (it.hasNext()) {
            com.coinbase.walletengine.services.xrp.Transaction transaction2 = (com.coinbase.walletengine.services.xrp.Transaction) it.next();
            try {
                Date date = this$0.getDateFormatter().parse(transaction2.getTimestamp());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                UInt m2101getDestinationTag0hXNFcg = transaction2.m2101getDestinationTag0hXNFcg();
                if (m2101getDestinationTag0hXNFcg != null) {
                    linkedHashMap.put(TxMetadataKey_RippleKt.getDestinationTag(TxMetadataKey.Companion), UInt.h(m2101getDestinationTag0hXNFcg.B()));
                }
                String uuid = UUID.randomUUID().toString();
                Blockchain xrp = Blockchain_RippleKt.getXRP(Blockchain.Companion);
                CurrencyCode.Companion companion = CurrencyCode.Companion;
                CurrencyCode xrp2 = CurrencyCode_RippleKt.getXRP(companion);
                CurrencyCode xrp3 = CurrencyCode_RippleKt.getXRP(companion);
                String destination = transaction2.getDestination();
                String address = transaction2.getAddress();
                BigInteger amount = transaction2.getAmount();
                BigInteger fee = transaction2.getFee();
                TxMetadata txMetadata = new TxMetadata(linkedHashMap);
                TxState txState = TxState.CONFIRMED;
                Network network = this$0.getNetwork();
                String txHash = transaction2.getTxHash();
                boolean z = !m.c(transaction2.getDestination(), this$0.address);
                m.f(uuid, "toString()");
                m.f(date, "date");
                transaction = new Transaction(uuid, date, date, xrp, xrp2, xrp3, destination, address, amount, fee, null, txState, txMetadata, network, txHash, z, 1024, null);
            } catch (Exception e2) {
                l.a.a.e(e2);
                transaction = null;
            }
            if (transaction != null) {
                arrayList.add(transaction);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List h(SyncXrpTxHistoryOperation syncXrpTxHistoryOperation, List list) {
        return m1766getTransactions$lambda2(syncXrpTxHistoryOperation, list);
    }

    @Override // com.coinbase.wallet.txhistory.interfaces.TxHistorySyncing
    public b0<List<Transaction>> getTransactions() {
        b0 map = this.xrpService.getTransactions(this.address, getNetwork().isTestnet()).map(new n() { // from class: com.coinbase.wallet.txhistory.operations.l
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return SyncXrpTxHistoryOperation.h(SyncXrpTxHistoryOperation.this, (List) obj);
            }
        });
        m.f(map, "xrpService.getTransactions(\n        address,\n        network.isTestnet\n    )\n    .map { txs ->\n        txs.mapNotNull { tx ->\n            try {\n                val date = dateFormatter.parse(tx.timestamp)\n                val map = mutableMapOf<TxMetadataKey, Any>()\n                tx.destinationTag?.let { map[TxMetadataKey.destinationTag] = it }\n\n                Transaction(\n                    id = UUID.randomUUID().toString(),\n                    createdAt = date,\n                    confirmedAt = date,\n                    blockchain = Blockchain.XRP,\n                    currencyCode = CurrencyCode.XRP,\n                    feeCurrencyCode = CurrencyCode.XRP,\n                    toAddress = tx.destination,\n                    fromAddress = tx.address,\n                    amount = tx.amount,\n                    fee = tx.fee,\n                    metadata = TxMetadata(map),\n                    state = TxState.CONFIRMED,\n                    network = network,\n                    txHash = tx.txHash,\n                    isSent = tx.destination != address\n                )\n            } catch (e: Exception) {\n                Timber.e(e)\n                null\n            }\n        }\n    }");
        return map;
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