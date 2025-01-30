package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.ethereum.interfaces.EthereumTxSubmitting;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import kotlin.Metadata;

/* compiled from: EthereumTxSubmitting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxSubmitting;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "tx", "", "shouldResubmit", "Lh/c/b0;", "submitTx", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;Z)Lh/c/b0;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "getCipherCore", "()Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "getEthereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface EthereumTxSubmitting {

    /* compiled from: EthereumTxSubmitting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ EthereumSignedTx a(Optional optional) {
            return m1163submitTx$lambda1(optional);
        }

        public static /* synthetic */ h.c.h0 b(boolean z, EthereumSignedTx ethereumSignedTx, EthereumTxSubmitting ethereumTxSubmitting, byte[] bArr) {
            return m1162submitTx$lambda0(z, ethereumSignedTx, ethereumTxSubmitting, bArr);
        }

        public static h.c.b0<EthereumSignedTx> submitTx(final EthereumTxSubmitting ethereumTxSubmitting, final EthereumSignedTx tx, final boolean z) {
            kotlin.jvm.internal.m.g(ethereumTxSubmitting, "this");
            kotlin.jvm.internal.m.g(tx, "tx");
            h.c.b0 map = ethereumTxSubmitting.getCipherCore().submitSignedEthereumTransaction(tx.getSignedTxData(), tx.getChainId()).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.m1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSubmitting.DefaultImpls.b(z, tx, ethereumTxSubmitting, (byte[]) obj);
                }
            }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.ethereum.interfaces.l1
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return EthereumTxSubmitting.DefaultImpls.a((Optional) obj);
                }
            });
            kotlin.jvm.internal.m.f(map, "cipherCore.submitSignedEthereumTransaction(tx.signedTxData, chainId = tx.chainId)\n        .flatMap {\n            when {\n                !shouldResubmit -> Single.just(Optional(tx))\n                else -> ethereumSignedTxDao.insertSignedTransaction(tx)\n            }\n        }\n        .map { it.value ?: throw EthereumException.TransactionSignatureMissing }");
            return Single_AnalyticsKt.logError$default(map, null, null, 3, null);
        }

        /* renamed from: submitTx$lambda-0 */
        public static h.c.h0 m1162submitTx$lambda0(boolean z, EthereumSignedTx tx, EthereumTxSubmitting this$0, byte[] it) {
            kotlin.jvm.internal.m.g(tx, "$tx");
            kotlin.jvm.internal.m.g(this$0, "this$0");
            kotlin.jvm.internal.m.g(it, "it");
            if (!z) {
                h.c.b0 just = h.c.b0.just(new Optional(tx));
                kotlin.jvm.internal.m.f(just, "just(Optional(tx))");
                return just;
            }
            return this$0.getEthereumSignedTxDao().insertSignedTransaction(tx);
        }

        /* renamed from: submitTx$lambda-1 */
        public static EthereumSignedTx m1163submitTx$lambda1(Optional it) {
            kotlin.jvm.internal.m.g(it, "it");
            EthereumSignedTx ethereumSignedTx = (EthereumSignedTx) it.getValue();
            if (ethereumSignedTx != null) {
                return ethereumSignedTx;
            }
            throw EthereumException.TransactionSignatureMissing.INSTANCE;
        }
    }

    CipherCoreInterface getCipherCore();

    EthereumSignedTxDao getEthereumSignedTxDao();

    h.c.b0<EthereumSignedTx> submitTx(EthereumSignedTx ethereumSignedTx, boolean z);
}