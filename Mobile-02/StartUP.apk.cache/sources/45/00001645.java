package com.coinbase.wallet.consumer.models;

import android.os.Parcelable;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AvailableTransfer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B-\b\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u000e8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0002\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethod", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "getPaymentMethod", "()Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "Ljava/math/BigInteger;", "transferAmount", "Ljava/math/BigInteger;", "getTransferAmount", "()Ljava/math/BigInteger;", "sendFee", "getSendFee", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "account", "Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "getAccount", "()Lcom/coinbase/wallet/consumer/models/ConsumerAccount;", "<init>", "(Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerAccount;Ljava/math/BigInteger;Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;)V", "Lcom/coinbase/wallet/consumer/models/AvailableSendTransfer;", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AvailableTransfer implements Parcelable {
    private final ConsumerAccount account;
    private final ConsumerPaymentMethod paymentMethod;
    private final BigInteger sendFee;
    private final BigInteger transferAmount;

    private AvailableTransfer(BigInteger bigInteger, ConsumerAccount consumerAccount, BigInteger bigInteger2, ConsumerPaymentMethod consumerPaymentMethod) {
        this.sendFee = bigInteger;
        this.account = consumerAccount;
        this.transferAmount = bigInteger2;
        this.paymentMethod = consumerPaymentMethod;
    }

    public /* synthetic */ AvailableTransfer(BigInteger bigInteger, ConsumerAccount consumerAccount, BigInteger bigInteger2, ConsumerPaymentMethod consumerPaymentMethod, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, consumerAccount, bigInteger2, consumerPaymentMethod);
    }

    public ConsumerAccount getAccount() {
        return this.account;
    }

    public ConsumerPaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public BigInteger getSendFee() {
        return this.sendFee;
    }

    public BigInteger getTransferAmount() {
        return this.transferAmount;
    }

    public /* synthetic */ AvailableTransfer(BigInteger bigInteger, ConsumerAccount consumerAccount, BigInteger bigInteger2, ConsumerPaymentMethod consumerPaymentMethod, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigInteger, consumerAccount, bigInteger2, (i2 & 8) != 0 ? null : consumerPaymentMethod, null);
    }
}