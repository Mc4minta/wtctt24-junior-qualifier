package com.coinbase.wallet.features.swap.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: Currency+Swap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "", "getShortName", "(Lcom/coinbase/wallet/wallets/models/FiatCurrency;)Ljava/lang/String;", "shortName", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Currency_SwapKt {
    public static final String getShortName(FiatCurrency fiatCurrency) {
        m.g(fiatCurrency, "<this>");
        CurrencyCode code = fiatCurrency.getCode();
        CurrencyCode.Companion companion = CurrencyCode.Companion;
        return m.c(code, companion.getUSD()) ? LocalizedStrings.INSTANCE.get(R.string.fiat_short_name_usd) : m.c(code, companion.getEUR()) ? LocalizedStrings.INSTANCE.get(R.string.fiat_short_name_eur) : m.c(code, companion.getGBP()) ? LocalizedStrings.INSTANCE.get(R.string.fiat_short_name_gbp) : fiatCurrency.getCode().getCode();
    }
}