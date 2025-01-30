package com.coinbase.wallet.features.send.extensions;

import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BigInteger+Send.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ljava/math/BigInteger;", "Ljava/math/BigDecimal;", "toGwei", "(Ljava/math/BigInteger;)Ljava/math/BigDecimal;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigInteger_SendKt {
    public static final BigDecimal toGwei(BigInteger bigInteger) {
        m.g(bigInteger, "<this>");
        BigDecimal divide = new BigDecimal(bigInteger).divide(BigDecimal.TEN.pow(9));
        m.f(divide, "this.toBigDecimal().divide(BigDecimal.TEN.pow(9))");
        return divide;
    }
}