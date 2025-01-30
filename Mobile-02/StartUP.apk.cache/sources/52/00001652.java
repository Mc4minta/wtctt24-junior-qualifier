package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.u;

/* compiled from: ConsumerAccountsArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAccountsArgs;", "", "", "onrampEnabled", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "forwardingCurrencyCode", "newSignIn", "Landroid/os/Bundle;", "createArguments", "(ZLcom/coinbase/wallet/blockchains/models/CurrencyCode;Z)Landroid/os/Bundle;", "", "onrampEnabledKey", "Ljava/lang/String;", "newSignInKey", "forwardingCurrencyKey", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsArgs {
    public static final ConsumerAccountsArgs INSTANCE = new ConsumerAccountsArgs();
    public static final String forwardingCurrencyKey = "FORWARDING_CURRENCY_CODE";
    public static final String newSignInKey = "new_sign_in";
    public static final String onrampEnabledKey = "ONRAMP_USA";

    private ConsumerAccountsArgs() {
    }

    public static /* synthetic */ Bundle createArguments$default(ConsumerAccountsArgs consumerAccountsArgs, boolean z, CurrencyCode currencyCode, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            currencyCode = null;
        }
        return consumerAccountsArgs.createArguments(z, currencyCode, z2);
    }

    public final Bundle createArguments(boolean z, CurrencyCode currencyCode, boolean z2) {
        return b.a(u.a("ONRAMP_USA", Boolean.valueOf(z)), u.a(forwardingCurrencyKey, currencyCode), u.a(newSignInKey, Boolean.valueOf(z2)));
    }
}