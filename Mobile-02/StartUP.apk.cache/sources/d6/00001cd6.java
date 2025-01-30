package com.coinbase.wallet.ethereum.repositories;

import com.coinbase.ciphercore.EthereumTransactionReceipt;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EthereumBasedBalanceRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/ethereum/repositories/SignedERC20TxReceipt;", "", "Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "component1", "()Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "component2", "()Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "receipt", "tx", "copy", "(Lcom/coinbase/ciphercore/EthereumTransactionReceipt;Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;)Lcom/coinbase/wallet/ethereum/repositories/SignedERC20TxReceipt;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;", "getTx", "Lcom/coinbase/ciphercore/EthereumTransactionReceipt;", "getReceipt", "<init>", "(Lcom/coinbase/ciphercore/EthereumTransactionReceipt;Lcom/coinbase/wallet/ethereum/models/EthereumSignedTx;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignedERC20TxReceipt {
    private final EthereumTransactionReceipt receipt;
    private final EthereumSignedTx tx;

    public SignedERC20TxReceipt(EthereumTransactionReceipt ethereumTransactionReceipt, EthereumSignedTx tx) {
        kotlin.jvm.internal.m.g(tx, "tx");
        this.receipt = ethereumTransactionReceipt;
        this.tx = tx;
    }

    public static /* synthetic */ SignedERC20TxReceipt copy$default(SignedERC20TxReceipt signedERC20TxReceipt, EthereumTransactionReceipt ethereumTransactionReceipt, EthereumSignedTx ethereumSignedTx, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ethereumTransactionReceipt = signedERC20TxReceipt.receipt;
        }
        if ((i2 & 2) != 0) {
            ethereumSignedTx = signedERC20TxReceipt.tx;
        }
        return signedERC20TxReceipt.copy(ethereumTransactionReceipt, ethereumSignedTx);
    }

    public final EthereumTransactionReceipt component1() {
        return this.receipt;
    }

    public final EthereumSignedTx component2() {
        return this.tx;
    }

    public final SignedERC20TxReceipt copy(EthereumTransactionReceipt ethereumTransactionReceipt, EthereumSignedTx tx) {
        kotlin.jvm.internal.m.g(tx, "tx");
        return new SignedERC20TxReceipt(ethereumTransactionReceipt, tx);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SignedERC20TxReceipt) {
            SignedERC20TxReceipt signedERC20TxReceipt = (SignedERC20TxReceipt) obj;
            return kotlin.jvm.internal.m.c(this.receipt, signedERC20TxReceipt.receipt) && kotlin.jvm.internal.m.c(this.tx, signedERC20TxReceipt.tx);
        }
        return false;
    }

    public final EthereumTransactionReceipt getReceipt() {
        return this.receipt;
    }

    public final EthereumSignedTx getTx() {
        return this.tx;
    }

    public int hashCode() {
        EthereumTransactionReceipt ethereumTransactionReceipt = this.receipt;
        return ((ethereumTransactionReceipt == null ? 0 : ethereumTransactionReceipt.hashCode()) * 31) + this.tx.hashCode();
    }

    public String toString() {
        return "SignedERC20TxReceipt(receipt=" + this.receipt + ", tx=" + this.tx + ')';
    }
}