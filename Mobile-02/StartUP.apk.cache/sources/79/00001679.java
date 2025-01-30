package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ConsumerOnboardingArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerOnboardingArgs;", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "forwardingCurrencyCode", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "connectStatus", "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;)Landroid/os/Bundle;", "", "forwadingCurrencyCodeKey", "Ljava/lang/String;", "connectStatusKey", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingArgs {
    public static final ConsumerOnboardingArgs INSTANCE = new ConsumerOnboardingArgs();
    public static final String connectStatusKey = "connect_status";
    public static final String forwadingCurrencyCodeKey = "forwarding_currency";

    private ConsumerOnboardingArgs() {
    }

    public final Bundle createArguments(CurrencyCode currencyCode, ConsumerConnectionStatus connectStatus) {
        m.g(connectStatus, "connectStatus");
        return b.a(u.a(connectStatusKey, connectStatus), u.a(forwadingCurrencyCodeKey, currencyCode));
    }
}