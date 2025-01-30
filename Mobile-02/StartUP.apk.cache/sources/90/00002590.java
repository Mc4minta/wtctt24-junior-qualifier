package com.coinbase.wallet.ripple.interfaces;

import com.coinbase.wallet.ripple.models.XRPSignedTx;
import com.coinbase.walletengine.services.xrp.TransactionResult;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: XRPBalanceManaging.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/ripple/interfaces/SignedXrpTxResult;", "", "Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "component1", "()Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "Lcom/coinbase/wallet/ripple/models/XRPSignedTx;", "component2", "()Lcom/coinbase/wallet/ripple/models/XRPSignedTx;", "result", "tx", "copy", "(Lcom/coinbase/walletengine/services/xrp/TransactionResult;Lcom/coinbase/wallet/ripple/models/XRPSignedTx;)Lcom/coinbase/wallet/ripple/interfaces/SignedXrpTxResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletengine/services/xrp/TransactionResult;", "getResult", "Lcom/coinbase/wallet/ripple/models/XRPSignedTx;", "getTx", "<init>", "(Lcom/coinbase/walletengine/services/xrp/TransactionResult;Lcom/coinbase/wallet/ripple/models/XRPSignedTx;)V", "ripple_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignedXrpTxResult {
    private final TransactionResult result;
    private final XRPSignedTx tx;

    public SignedXrpTxResult(TransactionResult transactionResult, XRPSignedTx tx) {
        m.g(tx, "tx");
        this.result = transactionResult;
        this.tx = tx;
    }

    public static /* synthetic */ SignedXrpTxResult copy$default(SignedXrpTxResult signedXrpTxResult, TransactionResult transactionResult, XRPSignedTx xRPSignedTx, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            transactionResult = signedXrpTxResult.result;
        }
        if ((i2 & 2) != 0) {
            xRPSignedTx = signedXrpTxResult.tx;
        }
        return signedXrpTxResult.copy(transactionResult, xRPSignedTx);
    }

    public final TransactionResult component1() {
        return this.result;
    }

    public final XRPSignedTx component2() {
        return this.tx;
    }

    public final SignedXrpTxResult copy(TransactionResult transactionResult, XRPSignedTx tx) {
        m.g(tx, "tx");
        return new SignedXrpTxResult(transactionResult, tx);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignedXrpTxResult) {
            SignedXrpTxResult signedXrpTxResult = (SignedXrpTxResult) obj;
            return m.c(this.result, signedXrpTxResult.result) && m.c(this.tx, signedXrpTxResult.tx);
        }
        return false;
    }

    public final TransactionResult getResult() {
        return this.result;
    }

    public final XRPSignedTx getTx() {
        return this.tx;
    }

    public int hashCode() {
        TransactionResult transactionResult = this.result;
        return ((transactionResult == null ? 0 : transactionResult.hashCode()) * 31) + this.tx.hashCode();
    }

    public String toString() {
        return "SignedXrpTxResult(result=" + this.result + ", tx=" + this.tx + ')';
    }
}