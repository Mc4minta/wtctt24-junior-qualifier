package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ConsumerTransferMethodsArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsArgs;", "", "Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;", "transferRequest", "Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;", "addedPaymentMethodResult", "Landroid/os/Bundle;", "createArgs", "(Lcom/coinbase/wallet/consumer/models/TransferMoneyRequest;Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVResult;)Landroid/os/Bundle;", "", "transferRequestKey", "Ljava/lang/String;", "getTransferRequestKey", "()Ljava/lang/String;", "resultKey", "getResultKey", "addedPaymentMethodResultKey", "getAddedPaymentMethodResultKey", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferMethodsArgs {
    public static final ConsumerTransferMethodsArgs INSTANCE = new ConsumerTransferMethodsArgs();
    private static final String transferRequestKey = "transfer_request_key";
    private static final String addedPaymentMethodResultKey = "add_payment_method_result_key";
    private static final String resultKey = "transfer_method_result_key";

    private ConsumerTransferMethodsArgs() {
    }

    public static /* synthetic */ Bundle createArgs$default(ConsumerTransferMethodsArgs consumerTransferMethodsArgs, TransferMoneyRequest transferMoneyRequest, ConsumerCardCDVResult consumerCardCDVResult, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            consumerCardCDVResult = null;
        }
        return consumerTransferMethodsArgs.createArgs(transferMoneyRequest, consumerCardCDVResult);
    }

    public final Bundle createArgs(TransferMoneyRequest transferRequest, ConsumerCardCDVResult consumerCardCDVResult) {
        m.g(transferRequest, "transferRequest");
        return b.a(u.a(transferRequestKey, transferRequest), u.a(addedPaymentMethodResultKey, consumerCardCDVResult));
    }

    public final String getAddedPaymentMethodResultKey() {
        return addedPaymentMethodResultKey;
    }

    public final String getResultKey() {
        return resultKey;
    }

    public final String getTransferRequestKey() {
        return transferRequestKey;
    }
}