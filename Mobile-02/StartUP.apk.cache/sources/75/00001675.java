package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ConsumerInterstitialArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerInterstitialArgs;", "", "", "hasSharedElementTransition", "Lcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;", "connectionStatus", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "forwardingCurrencyCode", "isDefaultTransition", "Landroid/os/Bundle;", "createArguments", "(ZLcom/coinbase/wallet/consumer/models/ConsumerConnectionStatus;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Z)Landroid/os/Bundle;", "", "forwardingCurrencyKey", "Ljava/lang/String;", "isDefaultTransitionKey", "connectionStatusKey", "hasSharedElementTransitionKey", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerInterstitialArgs {
    public static final ConsumerInterstitialArgs INSTANCE = new ConsumerInterstitialArgs();
    public static final String connectionStatusKey = "connection_status";
    public static final String forwardingCurrencyKey = "forwarding_currency_key";
    public static final String hasSharedElementTransitionKey = "hasSharedElementTransition";
    public static final String isDefaultTransitionKey = "default_transition";

    private ConsumerInterstitialArgs() {
    }

    public static /* synthetic */ Bundle createArguments$default(ConsumerInterstitialArgs consumerInterstitialArgs, boolean z, ConsumerConnectionStatus consumerConnectionStatus, CurrencyCode currencyCode, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            currencyCode = null;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        return consumerInterstitialArgs.createArguments(z, consumerConnectionStatus, currencyCode, z2);
    }

    public final Bundle createArguments(boolean z, ConsumerConnectionStatus connectionStatus, CurrencyCode currencyCode, boolean z2) {
        m.g(connectionStatus, "connectionStatus");
        return b.a(u.a(connectionStatusKey, connectionStatus), u.a(forwardingCurrencyKey, currencyCode), u.a("hasSharedElementTransition", Boolean.valueOf(z)), u.a(isDefaultTransitionKey, Boolean.valueOf(z2)));
    }
}