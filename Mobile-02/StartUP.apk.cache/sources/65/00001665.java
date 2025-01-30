package com.coinbase.wallet.consumer.models;

import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAvailableTransferContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u000b¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAvailableTransferContainer;", "", "Ljava/math/BigInteger;", "component1", "()Ljava/math/BigInteger;", "", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "component2", "()Ljava/util/List;", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "component3", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "transferAmount", "availableTransfers", "account", "copy", "(Ljava/math/BigInteger;Ljava/util/List;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)Lcom/coinbase/wallet/consumer/models/ConsumerAvailableTransferContainer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAvailableTransfers", "Ljava/math/BigInteger;", "getTransferAmount", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "getAccount", "<init>", "(Ljava/math/BigInteger;Ljava/util/List;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailableTransferContainer {
    private final ConsumerAccount account;
    private final List<AvailableTransfer> availableTransfers;
    private final BigInteger transferAmount;

    /* JADX WARN: Multi-variable type inference failed */
    public ConsumerAvailableTransferContainer(BigInteger transferAmount, List<? extends AvailableTransfer> availableTransfers, ConsumerAccount account) {
        m.g(transferAmount, "transferAmount");
        m.g(availableTransfers, "availableTransfers");
        m.g(account, "account");
        this.transferAmount = transferAmount;
        this.availableTransfers = availableTransfers;
        this.account = account;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsumerAvailableTransferContainer copy$default(ConsumerAvailableTransferContainer consumerAvailableTransferContainer, BigInteger bigInteger, List list, ConsumerAccount consumerAccount, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigInteger = consumerAvailableTransferContainer.transferAmount;
        }
        if ((i2 & 2) != 0) {
            list = consumerAvailableTransferContainer.availableTransfers;
        }
        if ((i2 & 4) != 0) {
            consumerAccount = consumerAvailableTransferContainer.account;
        }
        return consumerAvailableTransferContainer.copy(bigInteger, list, consumerAccount);
    }

    public final BigInteger component1() {
        return this.transferAmount;
    }

    public final List<AvailableTransfer> component2() {
        return this.availableTransfers;
    }

    public final ConsumerAccount component3() {
        return this.account;
    }

    public final ConsumerAvailableTransferContainer copy(BigInteger transferAmount, List<? extends AvailableTransfer> availableTransfers, ConsumerAccount account) {
        m.g(transferAmount, "transferAmount");
        m.g(availableTransfers, "availableTransfers");
        m.g(account, "account");
        return new ConsumerAvailableTransferContainer(transferAmount, availableTransfers, account);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAvailableTransferContainer) {
            ConsumerAvailableTransferContainer consumerAvailableTransferContainer = (ConsumerAvailableTransferContainer) obj;
            return m.c(this.transferAmount, consumerAvailableTransferContainer.transferAmount) && m.c(this.availableTransfers, consumerAvailableTransferContainer.availableTransfers) && m.c(this.account, consumerAvailableTransferContainer.account);
        }
        return false;
    }

    public final ConsumerAccount getAccount() {
        return this.account;
    }

    public final List<AvailableTransfer> getAvailableTransfers() {
        return this.availableTransfers;
    }

    public final BigInteger getTransferAmount() {
        return this.transferAmount;
    }

    public int hashCode() {
        return (((this.transferAmount.hashCode() * 31) + this.availableTransfers.hashCode()) * 31) + this.account.hashCode();
    }

    public String toString() {
        return "ConsumerAvailableTransferContainer(transferAmount=" + this.transferAmount + ", availableTransfers=" + this.availableTransfers + ", account=" + this.account + ')';
    }
}