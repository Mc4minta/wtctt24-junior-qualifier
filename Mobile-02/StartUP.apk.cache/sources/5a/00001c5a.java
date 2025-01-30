package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.ciphercore.CipherCoreBridgeException;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.EthereumTransactionReceipt;
import com.coinbase.ciphercore.Optional;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.blockchains.exceptions.NetworkException;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.extensions.AnalyticsEvent_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.apache.http.message.TokenParser;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: EthereumTxResubmitting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\t0\u000b0\b0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxResubmitting;", "", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "Lh/c/b0;", "Lkotlin/x;", "resubmitAllPendingTxs", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "txs", "Lkotlin/o;", "Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "getEthereumTxReceipts", "(Ljava/util/List;)Lh/c/b0;", "tx", "", "submitUnconfirmedSignedTransaction", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;)Lh/c/b0;", "submitUnconfirmedSignedTxs", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "getEthereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface EthereumTxResubmitting {

    /* compiled from: EthereumTxResubmitting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ List a(List list, List list2) {
            return m1142resubmitAllPendingTxs$lambda1$lambda0(list, list2);
        }

        public static /* synthetic */ kotlin.x b(Throwable th) {
            return m1149submitUnconfirmedSignedTxs$lambda18$lambda17$lambda16(th);
        }

        public static /* synthetic */ h.c.h0 c(EthereumSignedTx ethereumSignedTx, EthereumTxResubmitting ethereumTxResubmitting, ConnectionStatus connectionStatus) {
            return m1148x89700681(ethereumSignedTx, ethereumTxResubmitting, connectionStatus);
        }

        public static /* synthetic */ h.c.h0 d(EthereumTxResubmitting ethereumTxResubmitting, List list) {
            return m1145resubmitAllPendingTxs$lambda7(ethereumTxResubmitting, list);
        }

        public static /* synthetic */ h.c.h0 e(EthereumSignedTx ethereumSignedTx, EthereumTxResubmitting ethereumTxResubmitting, Optional optional) {
            return m1147submitUnconfirmedSignedTxs$lambda18$lambda17$lambda15(ethereumSignedTx, ethereumTxResubmitting, optional);
        }

        public static /* synthetic */ h.c.h0 f(EthereumTxResubmitting ethereumTxResubmitting, List list) {
            return m1143resubmitAllPendingTxs$lambda2(ethereumTxResubmitting, list);
        }

        public static /* synthetic */ com.coinbase.wallet.core.util.Optional g(kotlin.o oVar) {
            return m1138getEthereumTxReceipts$lambda10$lambda8(oVar);
        }

        private static h.c.b0<List<kotlin.o<EthereumTransactionReceipt, EthereumSignedTx>>> getEthereumTxReceipts(EthereumTxResubmitting ethereumTxResubmitting, List<EthereumSignedTx> list) {
            h.c.b0 zip;
            List g2;
            List g3;
            if (list.isEmpty()) {
                g3 = kotlin.a0.r.g();
                h.c.b0<List<kotlin.o<EthereumTransactionReceipt, EthereumSignedTx>>> just = h.c.b0.just(g3);
                kotlin.jvm.internal.m.f(just, "just(emptyList())");
                return just;
            }
            ArrayList arrayList = new ArrayList();
            for (EthereumSignedTx ethereumSignedTx : list) {
                byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(ethereumSignedTx.getTxHash());
                h.c.b0 b0Var = null;
                if (asHexEncodedData != null) {
                    h.c.b0<Optional<EthereumTransactionReceipt>> ethereumTransactionReceipt = ethereumTxResubmitting.getCipherCore().getEthereumTransactionReceipt(asHexEncodedData, ethereumSignedTx.getChainId(), null);
                    h.c.t0.e eVar = h.c.t0.e.a;
                    h.c.b0 just2 = h.c.b0.just(ethereumSignedTx);
                    kotlin.jvm.internal.m.f(just2, "just(it)");
                    b0Var = eVar.a(ethereumTransactionReceipt, just2).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.t0
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return EthereumTxResubmitting.DefaultImpls.g((kotlin.o) obj);
                        }
                    }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.v0
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return EthereumTxResubmitting.DefaultImpls.i((Throwable) obj);
                        }
                    });
                }
                if (b0Var != null) {
                    arrayList.add(b0Var);
                }
            }
            h.c.t0.e eVar2 = h.c.t0.e.a;
            if (arrayList.isEmpty()) {
                g2 = kotlin.a0.r.g();
                zip = h.c.b0.just(g2);
                kotlin.jvm.internal.m.f(zip, "just(emptyList())");
            } else {
                zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting$DefaultImpls$getEthereumTxReceipts$$inlined$zipOrEmpty$1
                    @Override // h.c.m0.n
                    public final List<T> apply(Object[] it) {
                        List<T> g4;
                        kotlin.jvm.internal.m.g(it, "it");
                        if (it.length == 0) {
                            g4 = kotlin.a0.r.g();
                            return g4;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int length = it.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj = it[i2];
                            if (obj != null ? obj instanceof com.coinbase.wallet.core.util.Optional : true) {
                                arrayList2.add(obj);
                            }
                        }
                        return arrayList2;
                    }
                });
                kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
            }
            h.c.b0<List<kotlin.o<EthereumTransactionReceipt, EthereumSignedTx>>> map = zip.map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.w0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.j((List) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "txs\n            .mapNotNull {\n                val txHashData = it.txHash.asHexEncodedData() ?: return@mapNotNull null\n\n                val receiptSingle = cipherCore.getEthereumTransactionReceipt(\n                    transactionHash = txHashData,\n                    chainId = it.chainId,\n                    blockHeight = null\n                )\n\n                Singles.zip(receiptSingle, Single.just(it))\n                    .map { (receipt, tx) -> Optional(Pair(receipt.value, tx)) }\n                    .onErrorReturn { Optional(null) }\n            }\n            .zipOrEmpty()\n            .map { entry -> entry.mapNotNull { it.value } }");
            return map;
        }

        /* renamed from: getEthereumTxReceipts$lambda-10$lambda-8 */
        public static com.coinbase.wallet.core.util.Optional m1138getEthereumTxReceipts$lambda10$lambda8(kotlin.o dstr$receipt$tx) {
            kotlin.jvm.internal.m.g(dstr$receipt$tx, "$dstr$receipt$tx");
            return new com.coinbase.wallet.core.util.Optional(new kotlin.o(((Optional) dstr$receipt$tx.a()).getValue(), (EthereumSignedTx) dstr$receipt$tx.b()));
        }

        /* renamed from: getEthereumTxReceipts$lambda-10$lambda-9 */
        public static com.coinbase.wallet.core.util.Optional m1139getEthereumTxReceipts$lambda10$lambda9(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            return new com.coinbase.wallet.core.util.Optional(null);
        }

        /* renamed from: getEthereumTxReceipts$lambda-12 */
        public static List m1140getEthereumTxReceipts$lambda12(List entry) {
            kotlin.jvm.internal.m.g(entry, "entry");
            ArrayList arrayList = new ArrayList();
            Iterator it = entry.iterator();
            while (it.hasNext()) {
                kotlin.o oVar = (kotlin.o) ((com.coinbase.wallet.core.util.Optional) it.next()).getValue();
                if (oVar != null) {
                    arrayList.add(oVar);
                }
            }
            return arrayList;
        }

        public static /* synthetic */ h.c.h0 h(EthereumTxResubmitting ethereumTxResubmitting, List list) {
            return m1141resubmitAllPendingTxs$lambda1(ethereumTxResubmitting, list);
        }

        public static /* synthetic */ com.coinbase.wallet.core.util.Optional i(Throwable th) {
            return m1139getEthereumTxReceipts$lambda10$lambda9(th);
        }

        public static /* synthetic */ List j(List list) {
            return m1140getEthereumTxReceipts$lambda12(list);
        }

        public static /* synthetic */ h.c.h0 k(EthereumSignedTx ethereumSignedTx, EthereumTxResubmitting ethereumTxResubmitting, Throwable th) {
            return m1146submitUnconfirmedSignedTxs$lambda18$lambda17(ethereumSignedTx, ethereumTxResubmitting, th);
        }

        public static /* synthetic */ List l(List list) {
            return m1144resubmitAllPendingTxs$lambda5(list);
        }

        public static h.c.b0<kotlin.x> resubmitAllPendingTxs(final EthereumTxResubmitting ethereumTxResubmitting, Network network) {
            kotlin.jvm.internal.m.g(ethereumTxResubmitting, "this");
            kotlin.jvm.internal.m.g(network, "network");
            EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(network);
            if (asEthereumChain == null) {
                h.c.b0<kotlin.x> error = h.c.b0.error(new NetworkException.InvalidNetwork(network));
                kotlin.jvm.internal.m.f(error, "error(NetworkException.InvalidNetwork(network))");
                return error;
            }
            h.c.b0 flatMap = ethereumTxResubmitting.getEthereumSignedTxDao().getUnminedSignedTxs(asEthereumChain).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.u0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.h(EthereumTxResubmitting.this, (List) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.s0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.f(EthereumTxResubmitting.this, (List) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.y0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.l((List) obj);
                }
            }).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.q0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.d(EthereumTxResubmitting.this, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMap, "ethereumSignedTxDao.getUnminedSignedTxs(ethereumChain)\n\n            // Submit the transactions using CipherCore\n            .flatMap { transactions ->\n                Timber.d(\"Unconfirmed signed transactions ${transactions.size} $transactions\")\n                submitUnconfirmedSignedTxs(transactions).map { transactions }\n            }\n\n            // Check status of all submitted transactions\n            .flatMap { getEthereumTxReceipts(it) }\n            .map {\n                it.mapNotNull { (receipt, tx) -> receipt?.let { EthereumTxReceiptsResult(tx, receipt.isSuccessful) } }\n            }\n\n            // If we receive a receipt, that means the transaction has been successfully submitted to ethereum\n            // note: this doesn't mean it will succeed. It only means that we don't have to keep resubmitting\n            // the pending transaction\n            .flatMap { ethereumTxReceipts ->\n                val confirmed = ethereumTxReceipts.map { entry ->\n                    val state = if (entry.isSuccessful) {\n                        TxState.CONFIRMED\n                    } else {\n                        Analytics.log(AnalyticsEvent.ethTxAcceptedButReverted())\n                        TxState.FAILED\n                    }\n\n                    ethereumSignedTxDao.save(entry.tx.copy(state = state))\n                }\n\n                Timber.d(\"Confirmed signed transactions ${confirmed.size}\")\n                Singles.zipOrEmpty(confirmed)\n            }");
            return Single_CoreKt.asUnit(flatMap);
        }

        /* renamed from: resubmitAllPendingTxs$lambda-1 */
        public static h.c.h0 m1141resubmitAllPendingTxs$lambda1(EthereumTxResubmitting this$0, final List transactions) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(transactions, "transactions");
            l.a.a.a("Unconfirmed signed transactions " + transactions.size() + TokenParser.SP + transactions, new Object[0]);
            return submitUnconfirmedSignedTxs(this$0, transactions).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.n0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.a(transactions, (List) obj);
                }
            });
        }

        /* renamed from: resubmitAllPendingTxs$lambda-1$lambda-0 */
        public static List m1142resubmitAllPendingTxs$lambda1$lambda0(List transactions, List it) {
            kotlin.jvm.internal.m.g(transactions, "$transactions");
            kotlin.jvm.internal.m.g(it, "it");
            return transactions;
        }

        /* renamed from: resubmitAllPendingTxs$lambda-2 */
        public static h.c.h0 m1143resubmitAllPendingTxs$lambda2(EthereumTxResubmitting this$0, List it) {
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(it, "it");
            return getEthereumTxReceipts(this$0, it);
        }

        /* renamed from: resubmitAllPendingTxs$lambda-5 */
        public static List m1144resubmitAllPendingTxs$lambda5(List it) {
            kotlin.jvm.internal.m.g(it, "it");
            ArrayList arrayList = new ArrayList();
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                kotlin.o oVar = (kotlin.o) it2.next();
                EthereumTransactionReceipt ethereumTransactionReceipt = (EthereumTransactionReceipt) oVar.a();
                EthereumTxReceiptsResult ethereumTxReceiptsResult = ethereumTransactionReceipt == null ? null : new EthereumTxReceiptsResult((EthereumSignedTx) oVar.b(), ethereumTransactionReceipt.isSuccessful());
                if (ethereumTxReceiptsResult != null) {
                    arrayList.add(ethereumTxReceiptsResult);
                }
            }
            return arrayList;
        }

        /* renamed from: resubmitAllPendingTxs$lambda-7 */
        public static h.c.h0 m1145resubmitAllPendingTxs$lambda7(EthereumTxResubmitting this$0, List ethereumTxReceipts) {
            int r;
            List g2;
            TxState txState;
            EthereumSignedTx copy;
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(ethereumTxReceipts, "ethereumTxReceipts");
            r = kotlin.a0.s.r(ethereumTxReceipts, 10);
            ArrayList arrayList = new ArrayList(r);
            Iterator it = ethereumTxReceipts.iterator();
            while (it.hasNext()) {
                EthereumTxReceiptsResult ethereumTxReceiptsResult = (EthereumTxReceiptsResult) it.next();
                if (ethereumTxReceiptsResult.isSuccessful()) {
                    txState = TxState.CONFIRMED;
                } else {
                    Analytics.INSTANCE.log(AnalyticsEvent_EthereumKt.ethTxAcceptedButReverted(AnalyticsEvent.Companion));
                    txState = TxState.FAILED;
                }
                TxState txState2 = txState;
                EthereumSignedTxDao ethereumSignedTxDao = this$0.getEthereumSignedTxDao();
                copy = r5.copy((r28 & 1) != 0 ? r5.getId() : null, (r28 & 2) != 0 ? r5.fromAddress : null, (r28 & 4) != 0 ? r5.toAddress : null, (r28 & 8) != 0 ? r5.nonce : 0, (r28 & 16) != 0 ? r5.chainId : 0, (r28 & 32) != 0 ? r5.signedTxData : null, (r28 & 64) != 0 ? r5.getTxHash() : null, (r28 & 128) != 0 ? r5.weiValue : null, (r28 & 256) != 0 ? r5.erc20Value : null, (r28 & 512) != 0 ? r5.getBlockchain() : null, (r28 & 1024) != 0 ? r5.getCurrencyCode() : null, (r28 & PKIFailureInfo.wrongIntegrity) != 0 ? r5.getState() : txState2, (r28 & 4096) != 0 ? ethereumTxReceiptsResult.getTx().notFoundCount : 0);
                arrayList.add(ethereumSignedTxDao.save(copy));
            }
            l.a.a.a(kotlin.jvm.internal.m.o("Confirmed signed transactions ", Integer.valueOf(arrayList.size())), new Object[0]);
            h.c.t0.e eVar = h.c.t0.e.a;
            if (arrayList.isEmpty()) {
                g2 = kotlin.a0.r.g();
                h.c.b0 just = h.c.b0.just(g2);
                kotlin.jvm.internal.m.f(just, "just(emptyList())");
                return just;
            }
            h.c.b0 zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting$DefaultImpls$resubmitAllPendingTxs$lambda-7$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it2) {
                    List<T> g3;
                    kotlin.jvm.internal.m.g(it2, "it");
                    if (it2.length == 0) {
                        g3 = kotlin.a0.r.g();
                        return g3;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : it2) {
                        if (obj instanceof com.coinbase.wallet.core.util.Optional) {
                            arrayList2.add(obj);
                        }
                    }
                    return arrayList2;
                }
            });
            kotlin.jvm.internal.m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
            return zip;
        }

        private static h.c.b0<byte[]> submitUnconfirmedSignedTransaction(EthereumTxResubmitting ethereumTxResubmitting, EthereumSignedTx ethereumSignedTx) {
            return ethereumTxResubmitting.getCipherCore().submitSignedEthereumTransaction(ethereumSignedTx.getSignedTxData(), ethereumSignedTx.getChainId());
        }

        private static h.c.b0<List<kotlin.x>> submitUnconfirmedSignedTxs(final EthereumTxResubmitting ethereumTxResubmitting, List<EthereumSignedTx> list) {
            int r;
            List g2;
            List g3;
            if (list.isEmpty()) {
                g3 = kotlin.a0.r.g();
                h.c.b0<List<kotlin.x>> just = h.c.b0.just(g3);
                kotlin.jvm.internal.m.f(just, "just(emptyList())");
                return just;
            }
            r = kotlin.a0.s.r(list, 10);
            ArrayList arrayList = new ArrayList(r);
            for (final EthereumSignedTx ethereumSignedTx : list) {
                arrayList.add(Single_CoreKt.asUnit(submitUnconfirmedSignedTransaction(ethereumTxResubmitting, ethereumSignedTx)).onErrorResumeNext(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.x0
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return EthereumTxResubmitting.DefaultImpls.k(EthereumSignedTx.this, ethereumTxResubmitting, (Throwable) obj);
                    }
                }));
            }
            h.c.t0.e eVar = h.c.t0.e.a;
            if (arrayList.isEmpty()) {
                g2 = kotlin.a0.r.g();
                h.c.b0<List<kotlin.x>> just2 = h.c.b0.just(g2);
                kotlin.jvm.internal.m.f(just2, "just(emptyList())");
                return just2;
            }
            h.c.b0<List<kotlin.x>> zip = h.c.b0.zip(arrayList, new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting$DefaultImpls$submitUnconfirmedSignedTxs$lambda-19$$inlined$zipOrEmpty$1
                @Override // h.c.m0.n
                public final List<T> apply(Object[] it) {
                    List<T> g4;
                    kotlin.jvm.internal.m.g(it, "it");
                    if (it.length == 0) {
                        g4 = kotlin.a0.r.g();
                        return g4;
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
            return zip;
        }

        /* renamed from: submitUnconfirmedSignedTxs$lambda-18$lambda-17 */
        public static h.c.h0 m1146submitUnconfirmedSignedTxs$lambda18$lambda17(final EthereumSignedTx tx, final EthereumTxResubmitting this$0, Throwable err) {
            EthereumSignedTx copy;
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(err, "err");
            if ((err instanceof CipherCoreBridgeException ? (CipherCoreBridgeException) err : null) == null) {
                return h.c.b0.just(kotlin.x.a);
            }
            byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(tx.getTxHash());
            if (asHexEncodedData == null) {
                Analytics.INSTANCE.log(AnalyticsEvent_EthereumKt.ethFailedToEncodeTxHash(AnalyticsEvent.Companion));
                EthereumSignedTxDao ethereumSignedTxDao = this$0.getEthereumSignedTxDao();
                copy = tx.copy((r28 & 1) != 0 ? tx.getId() : null, (r28 & 2) != 0 ? tx.fromAddress : null, (r28 & 4) != 0 ? tx.toAddress : null, (r28 & 8) != 0 ? tx.nonce : 0, (r28 & 16) != 0 ? tx.chainId : 0, (r28 & 32) != 0 ? tx.signedTxData : null, (r28 & 64) != 0 ? tx.getTxHash() : null, (r28 & 128) != 0 ? tx.weiValue : null, (r28 & 256) != 0 ? tx.erc20Value : null, (r28 & 512) != 0 ? tx.getBlockchain() : null, (r28 & 1024) != 0 ? tx.getCurrencyCode() : null, (r28 & PKIFailureInfo.wrongIntegrity) != 0 ? tx.getState() : TxState.FAILED, (r28 & 4096) != 0 ? tx.notFoundCount : 0);
                return Single_CoreKt.asUnit(ethereumSignedTxDao.save(copy));
            }
            return this$0.getCipherCore().getEthereumTransactionReceipt(asHexEncodedData, tx.getChainId(), null).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.r0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.e(EthereumSignedTx.this, this$0, (Optional) obj);
                }
            }).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.o0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.b((Throwable) obj);
                }
            });
        }

        /* renamed from: submitUnconfirmedSignedTxs$lambda-18$lambda-17$lambda-15 */
        public static h.c.h0 m1147submitUnconfirmedSignedTxs$lambda18$lambda17$lambda15(final EthereumSignedTx tx, final EthereumTxResubmitting this$0, Optional receipt) {
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(receipt, "receipt");
            if (receipt.getValue() != null) {
                return h.c.b0.just(kotlin.x.a);
            }
            h.c.s<ConnectionStatus> statusChanges = Internet.INSTANCE.getStatusChanges();
            kotlin.jvm.internal.m.f(statusChanges, "Internet.statusChanges");
            return Observable_CoreKt.takeSingle(statusChanges).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.p0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxResubmitting.DefaultImpls.c(EthereumSignedTx.this, this$0, (ConnectionStatus) obj);
                }
            });
        }

        /* renamed from: submitUnconfirmedSignedTxs$lambda-18$lambda-17$lambda-15$lambda-14 */
        public static h.c.h0 m1148x89700681(EthereumSignedTx tx, EthereumTxResubmitting this$0, ConnectionStatus status) {
            int i2;
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(status, "status");
            if (!status.isOnline()) {
                return h.c.b0.just(kotlin.x.a);
            }
            int notFoundCount = tx.getNotFoundCount();
            i2 = EthereumTxResubmittingKt.maxSubmissionAttempts;
            return Single_CoreKt.asUnit(this$0.getEthereumSignedTxDao().save(notFoundCount > i2 ? tx.copy((r28 & 1) != 0 ? tx.getId() : null, (r28 & 2) != 0 ? tx.fromAddress : null, (r28 & 4) != 0 ? tx.toAddress : null, (r28 & 8) != 0 ? tx.nonce : 0, (r28 & 16) != 0 ? tx.chainId : 0, (r28 & 32) != 0 ? tx.signedTxData : null, (r28 & 64) != 0 ? tx.getTxHash() : null, (r28 & 128) != 0 ? tx.weiValue : null, (r28 & 256) != 0 ? tx.erc20Value : null, (r28 & 512) != 0 ? tx.getBlockchain() : null, (r28 & 1024) != 0 ? tx.getCurrencyCode() : null, (r28 & PKIFailureInfo.wrongIntegrity) != 0 ? tx.getState() : TxState.DROPPED, (r28 & 4096) != 0 ? tx.notFoundCount : 0) : tx.copy((r28 & 1) != 0 ? tx.getId() : null, (r28 & 2) != 0 ? tx.fromAddress : null, (r28 & 4) != 0 ? tx.toAddress : null, (r28 & 8) != 0 ? tx.nonce : 0, (r28 & 16) != 0 ? tx.chainId : 0, (r28 & 32) != 0 ? tx.signedTxData : null, (r28 & 64) != 0 ? tx.getTxHash() : null, (r28 & 128) != 0 ? tx.weiValue : null, (r28 & 256) != 0 ? tx.erc20Value : null, (r28 & 512) != 0 ? tx.getBlockchain() : null, (r28 & 1024) != 0 ? tx.getCurrencyCode() : null, (r28 & PKIFailureInfo.wrongIntegrity) != 0 ? tx.getState() : null, (r28 & 4096) != 0 ? tx.notFoundCount : tx.getNotFoundCount() + 1)));
        }

        /* renamed from: submitUnconfirmedSignedTxs$lambda-18$lambda-17$lambda-16 */
        public static kotlin.x m1149submitUnconfirmedSignedTxs$lambda18$lambda17$lambda16(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            return kotlin.x.a;
        }
    }

    CipherCoreInterface getCipherCore();

    EthereumSignedTxDao getEthereumSignedTxDao();

    h.c.b0<kotlin.x> resubmitAllPendingTxs(Network network);
}