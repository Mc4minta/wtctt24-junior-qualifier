package com.coinbase.wallet.consumer.extensions;

import com.appsflyer.AppsFlyerProperties;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BigDecimal+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a!\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Ljava/math/BigDecimal;", "", AppsFlyerProperties.CURRENCY_CODE, "", "maxDecimals", "toFormattedCurrencyString", "(Ljava/math/BigDecimal;Ljava/lang/String;I)Ljava/lang/String;", "toFormattedCurrencyStringExactDigits", "(Ljava/math/BigDecimal;Ljava/lang/String;)Ljava/lang/String;", "getZeroOrAmount", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "exponentialDecimals", "multiplyTenToPow", "(Ljava/math/BigDecimal;I)Ljava/math/BigDecimal;", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigDecimal_ConsumerKt {
    public static final BigDecimal getZeroOrAmount(BigDecimal bigDecimal) {
        m.g(bigDecimal, "<this>");
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            BigDecimal ZERO = BigDecimal.ZERO;
            m.f(ZERO, "ZERO");
            return ZERO;
        }
        return bigDecimal;
    }

    public static final BigDecimal multiplyTenToPow(BigDecimal bigDecimal, int i2) {
        m.g(bigDecimal, "<this>");
        BigDecimal multiply = bigDecimal.multiply(BigDecimal.TEN.pow(i2));
        m.f(multiply, "this.multiply(BigDecimal.TEN.pow(exponentialDecimals))");
        return multiply;
    }

    public static final String toFormattedCurrencyString(BigDecimal bigDecimal, String currencyCode, int i2) {
        m.g(bigDecimal, "<this>");
        m.g(currencyCode, "currencyCode");
        Currency currency = Currency.getInstance(currencyCode);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(currency);
        currencyInstance.setMaximumFractionDigits(i2);
        currencyInstance.setRoundingMode(RoundingMode.DOWN);
        String format = currencyInstance.format(bigDecimal);
        m.f(format, "format.format(this)");
        return format;
    }

    public static final String toFormattedCurrencyStringExactDigits(BigDecimal bigDecimal, String currencyCode) {
        m.g(bigDecimal, "<this>");
        m.g(currencyCode, "currencyCode");
        Currency currency = Currency.getInstance(currencyCode);
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(currency);
        currencyInstance.setMaximumFractionDigits(bigDecimal.scale());
        currencyInstance.setMinimumFractionDigits(bigDecimal.scale());
        currencyInstance.setRoundingMode(RoundingMode.UNNECESSARY);
        String format = currencyInstance.format(bigDecimal);
        m.f(format, "format.format(this)");
        return format;
    }
}