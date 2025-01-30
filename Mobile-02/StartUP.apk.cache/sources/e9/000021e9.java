package com.coinbase.wallet.features.swap.models;

import android.os.Bundle;
import androidx.core.os.b;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: SwapCompleteFragmentArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapCompleteFragmentArgs;", "", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Landroid/os/Bundle;", "createArguments", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Landroid/os/Bundle;", "", "currencyCodeKey", "Ljava/lang/String;", "getCurrencyCodeKey", "()Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapCompleteFragmentArgs {
    public static final SwapCompleteFragmentArgs INSTANCE = new SwapCompleteFragmentArgs();
    private static final String currencyCodeKey = AppsFlyerProperties.CURRENCY_CODE;

    private SwapCompleteFragmentArgs() {
    }

    public final Bundle createArguments(CurrencyCode currencyCode) {
        m.g(currencyCode, "currencyCode");
        return b.a(u.a(currencyCodeKey, currencyCode));
    }

    public final String getCurrencyCodeKey() {
        return currencyCodeKey;
    }
}