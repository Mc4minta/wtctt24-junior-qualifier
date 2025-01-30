package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ConsumerCardCDVArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerCardCDVArgs;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;", "paymentMethod", "Landroid/os/Bundle;", "createArgs", "(Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethod;)Landroid/os/Bundle;", "", "PAYMENT_METHOD", "Ljava/lang/String;", "RESULT_KEY", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerCardCDVArgs {
    public static final ConsumerCardCDVArgs INSTANCE = new ConsumerCardCDVArgs();
    public static final String PAYMENT_METHOD = "payment_method";
    public static final String RESULT_KEY = "cardCDVResult";

    private ConsumerCardCDVArgs() {
    }

    public final Bundle createArgs(ConsumerPaymentMethod paymentMethod) {
        m.g(paymentMethod, "paymentMethod");
        return b.a(u.a("payment_method", paymentMethod));
    }
}