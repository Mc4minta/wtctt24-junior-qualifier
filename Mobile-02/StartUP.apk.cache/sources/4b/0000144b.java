package com.coinbase.wallet.common.extensions;

import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: FiatCurrency+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/models/FiatCurrency;", "", "getSymbol", "(Lcom/coinbase/wallet/wallets/models/FiatCurrency;)Ljava/lang/String;", "symbol", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class FiatCurrency_CommonKt {
    public static final String getSymbol(FiatCurrency fiatCurrency) {
        m.g(fiatCurrency, "<this>");
        try {
            String symbol = Currency.getInstance(fiatCurrency.getCode().getRawValue()).getSymbol();
            m.f(symbol, "{\n        val currencyCode = this.code.rawValue\n        Currency.getInstance(currencyCode).symbol\n    }");
            return symbol;
        } catch (Exception unused) {
            String rawValue = fiatCurrency.getCode().getRawValue();
            Locale locale = Locale.getDefault();
            m.f(locale, "getDefault()");
            Objects.requireNonNull(rawValue, "null cannot be cast to non-null type java.lang.String");
            String upperCase = rawValue.toUpperCase(locale);
            m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
    }
}