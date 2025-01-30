package com.coinbase.wallet.common.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Locale+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0017\u0010\b\u001a\u00020\u0005*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/util/Locale;", "Ljava/util/Currency;", "getCurrency", "(Ljava/util/Locale;)Ljava/util/Currency;", ApiConstants.CURRENCY, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "getCurrencyCode", "(Ljava/util/Locale;)Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Locale_CommonKt {
    public static final Currency getCurrency(Locale locale) {
        m.g(locale, "<this>");
        try {
            Currency currency = Currency.getInstance(locale);
            m.f(currency, "{\n            Currency.getInstance(this)\n        }");
            return currency;
        } catch (IllegalArgumentException e2) {
            l.a.a.f(e2, m.o("IllegalArgumentException when grabbing currency code for ", locale), new Object[0]);
            throw e2;
        } catch (NullPointerException e3) {
            l.a.a.f(e3, m.o("NullPointerException when grabbing currency code for ", locale), new Object[0]);
            throw e3;
        }
    }

    public static final CurrencyCode getCurrencyCode(Locale locale) {
        m.g(locale, "<this>");
        String currencyCode = getCurrency(locale).getCurrencyCode();
        m.f(currencyCode, "currency.currencyCode");
        return new CurrencyCode(currencyCode);
    }
}