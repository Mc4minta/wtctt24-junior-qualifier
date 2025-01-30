package com.coinbase.wallet.features.send.extensions;

import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BigDecimal+Send.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "toWei", "(Ljava/math/BigDecimal;)Ljava/math/BigInteger;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigDecimal_SendKt {
    public static final BigInteger toWei(BigDecimal bigDecimal) {
        m.g(bigDecimal, "<this>");
        BigDecimal pow = BigDecimal.TEN.pow(9);
        m.f(pow, "TEN.pow(9)");
        BigDecimal multiply = bigDecimal.multiply(pow);
        m.f(multiply, "this.multiply(other)");
        BigInteger bigInteger = multiply.toBigInteger();
        m.f(bigInteger, "this.times(BigDecimal.TEN.pow(9)).toBigInteger()");
        return bigInteger;
    }
}