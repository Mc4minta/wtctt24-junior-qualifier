package com.coinbase.wallet.consumer.repositories;

import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.consumer.models.AvailableBuyAndSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableSendTransfer;
import com.coinbase.wallet.consumer.models.AvailableTransfer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: ConsumerTransferRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/TransferValue$Amount;", "amount", "Ljava/util/Comparator;", "Lcom/coinbase/wallet/consumer/models/AvailableTransfer;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/TransferValue$Amount;)Ljava/util/Comparator;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferRepository$amountComparator$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<TransferValue.Amount, Comparator<AvailableTransfer>> {
    public static final ConsumerTransferRepository$amountComparator$1 INSTANCE = new ConsumerTransferRepository$amountComparator$1();

    ConsumerTransferRepository$amountComparator$1() {
        super(1);
    }

    public static /* synthetic */ int a(TransferValue.Amount amount, AvailableTransfer availableTransfer, AvailableTransfer availableTransfer2) {
        return m939invoke$lambda0(amount, availableTransfer, availableTransfer2);
    }

    /* renamed from: invoke$lambda-0 */
    public static final int m939invoke$lambda0(TransferValue.Amount amount, AvailableTransfer availableTransfer, AvailableTransfer availableTransfer2) {
        kotlin.jvm.internal.m.g(amount, "$amount");
        BigInteger value = amount.getValue();
        if (availableTransfer.getTransferAmount().compareTo(value) < 0 || !(availableTransfer instanceof AvailableSendTransfer)) {
            if (availableTransfer2.getTransferAmount().compareTo(value) >= 0 && (availableTransfer2 instanceof AvailableSendTransfer)) {
                return 1;
            }
            if (availableTransfer.getTransferAmount().compareTo(value) < 0 || availableTransfer2.getTransferAmount().compareTo(value) >= 0) {
                if (availableTransfer2.getTransferAmount().compareTo(value) < 0 || availableTransfer.getTransferAmount().compareTo(value) >= 0) {
                    if (availableTransfer.getTransferAmount().compareTo(value) < 0 || availableTransfer2.getTransferAmount().compareTo(value) < 0 || !(availableTransfer instanceof AvailableBuyAndSendTransfer) || !(availableTransfer2 instanceof AvailableBuyAndSendTransfer)) {
                        return 0;
                    }
                    BigDecimal coinbaseFee = ((AvailableBuyAndSendTransfer) availableTransfer).getCoinbaseFee();
                    if (coinbaseFee == null) {
                        return -1;
                    }
                    BigDecimal coinbaseFee2 = ((AvailableBuyAndSendTransfer) availableTransfer2).getCoinbaseFee();
                    if (coinbaseFee2 == null) {
                        return 1;
                    }
                    return coinbaseFee.compareTo(coinbaseFee2);
                }
                return 1;
            }
        }
        return -1;
    }

    @Override // kotlin.e0.c.l
    public final Comparator<AvailableTransfer> invoke(final TransferValue.Amount amount) {
        kotlin.jvm.internal.m.g(amount, "amount");
        return new Comparator() { // from class: com.coinbase.wallet.consumer.repositories.u1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ConsumerTransferRepository$amountComparator$1.a(TransferValue.Amount.this, (AvailableTransfer) obj, (AvailableTransfer) obj2);
            }
        };
    }
}