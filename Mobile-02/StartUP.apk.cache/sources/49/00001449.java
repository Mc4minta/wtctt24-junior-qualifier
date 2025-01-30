package com.coinbase.wallet.common.extensions;

import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BigInteger+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ljava/math/BigInteger;", "", "decimals", "", "asPercentage", "(Ljava/math/BigInteger;I)Ljava/lang/String;", "asRoundedPercentage", "Ljava/math/BigDecimal;", "asBigDecimal", "(Ljava/math/BigInteger;I)Ljava/math/BigDecimal;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigInteger_CommonKt {
    public static final BigDecimal asBigDecimal(BigInteger bigInteger, int i2) {
        m.g(bigInteger, "<this>");
        BigDecimal divide = new BigDecimal(bigInteger).divide(BigDecimal.TEN.pow(i2));
        m.f(divide, "this.toBigDecimal().divide(BigDecimal.TEN.pow(decimals))");
        return divide;
    }

    public static final String asPercentage(BigInteger bigInteger, int i2) {
        m.g(bigInteger, "<this>");
        BigDecimal movePointLeft = new BigDecimal(bigInteger).movePointLeft(i2);
        m.f(movePointLeft, "this.toBigDecimal()\n        .movePointLeft(decimals)");
        return BigDecimal_CommonKt.asPercentage(movePointLeft, i2);
    }

    public static final String asRoundedPercentage(BigInteger bigInteger, int i2) {
        m.g(bigInteger, "<this>");
        BigDecimal movePointLeft = new BigDecimal(bigInteger).movePointLeft(i2);
        m.f(movePointLeft, "this.toBigDecimal()\n        .movePointLeft(decimals)");
        return BigDecimal_CommonKt.asRoundedPercentage(movePointLeft, i2);
    }
}