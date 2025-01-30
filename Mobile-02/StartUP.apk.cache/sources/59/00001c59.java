package com.coinbase.wallet.ethereum.interfaces;

import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EthereumTxResubmitting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxReceiptsResult;", "", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "component1", "()Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "", "component2", "()Z", "tx", "isSuccessful", "copy", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;Z)Lcom/coinbase/wallet/ethereum/interfaces/EthereumTxReceiptsResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "getTx", "<init>", "(Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;Z)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumTxReceiptsResult {
    private final boolean isSuccessful;
    private final EthereumSignedTx tx;

    public EthereumTxReceiptsResult(EthereumSignedTx tx, boolean z) {
        kotlin.jvm.internal.m.g(tx, "tx");
        this.tx = tx;
        this.isSuccessful = z;
    }

    public static /* synthetic */ EthereumTxReceiptsResult copy$default(EthereumTxReceiptsResult ethereumTxReceiptsResult, EthereumSignedTx ethereumSignedTx, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ethereumSignedTx = ethereumTxReceiptsResult.tx;
        }
        if ((i2 & 2) != 0) {
            z = ethereumTxReceiptsResult.isSuccessful;
        }
        return ethereumTxReceiptsResult.copy(ethereumSignedTx, z);
    }

    public final EthereumSignedTx component1() {
        return this.tx;
    }

    public final boolean component2() {
        return this.isSuccessful;
    }

    public final EthereumTxReceiptsResult copy(EthereumSignedTx tx, boolean z) {
        kotlin.jvm.internal.m.g(tx, "tx");
        return new EthereumTxReceiptsResult(tx, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumTxReceiptsResult) {
            EthereumTxReceiptsResult ethereumTxReceiptsResult = (EthereumTxReceiptsResult) obj;
            return kotlin.jvm.internal.m.c(this.tx, ethereumTxReceiptsResult.tx) && this.isSuccessful == ethereumTxReceiptsResult.isSuccessful;
        }
        return false;
    }

    public final EthereumSignedTx getTx() {
        return this.tx;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.tx.hashCode() * 31;
        boolean z = this.isSuccessful;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    public String toString() {
        return "EthereumTxReceiptsResult(tx=" + this.tx + ", isSuccessful=" + this.isSuccessful + ')';
    }
}