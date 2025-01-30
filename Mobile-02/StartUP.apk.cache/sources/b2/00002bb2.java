package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3RequestDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/walletlink/dtos/SubmitEthereumTransactionParams;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "signedTransaction", RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Ljava/lang/String;I)Lcom/coinbase/walletlink/dtos/SubmitEthereumTransactionParams;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getChainId", "Ljava/lang/String;", "getSignedTransaction", "<init>", "(Ljava/lang/String;I)V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SubmitEthereumTransactionParams {
    private final int chainId;
    private final String signedTransaction;

    public SubmitEthereumTransactionParams(String signedTransaction, int i2) {
        m.g(signedTransaction, "signedTransaction");
        this.signedTransaction = signedTransaction;
        this.chainId = i2;
    }

    public static /* synthetic */ SubmitEthereumTransactionParams copy$default(SubmitEthereumTransactionParams submitEthereumTransactionParams, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = submitEthereumTransactionParams.signedTransaction;
        }
        if ((i3 & 2) != 0) {
            i2 = submitEthereumTransactionParams.chainId;
        }
        return submitEthereumTransactionParams.copy(str, i2);
    }

    public final String component1() {
        return this.signedTransaction;
    }

    public final int component2() {
        return this.chainId;
    }

    public final SubmitEthereumTransactionParams copy(String signedTransaction, int i2) {
        m.g(signedTransaction, "signedTransaction");
        return new SubmitEthereumTransactionParams(signedTransaction, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubmitEthereumTransactionParams) {
            SubmitEthereumTransactionParams submitEthereumTransactionParams = (SubmitEthereumTransactionParams) obj;
            return m.c(this.signedTransaction, submitEthereumTransactionParams.signedTransaction) && this.chainId == submitEthereumTransactionParams.chainId;
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public final String getSignedTransaction() {
        return this.signedTransaction;
    }

    public int hashCode() {
        return (this.signedTransaction.hashCode() * 31) + this.chainId;
    }

    public String toString() {
        return "SubmitEthereumTransactionParams(signedTransaction=" + this.signedTransaction + ", chainId=" + this.chainId + ')';
    }
}