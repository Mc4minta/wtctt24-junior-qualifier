package com.coinbase.wallet.application.extensions;

import com.coinbase.wallet.common.extensions.BigInteger_CommonKt;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BigInteger+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/math/BigInteger;", "", "isMoreThanZero", "(Ljava/math/BigInteger;)Z", "", "decimals", "Ljava/math/BigDecimal;", "asBigDecimal", "(Ljava/math/BigInteger;I)Ljava/math/BigDecimal;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigInteger_ApplicationKt {
    public static final BigDecimal asBigDecimal(BigInteger bigInteger, int i2) {
        m.g(bigInteger, "<this>");
        return BigInteger_CommonKt.asBigDecimal(bigInteger, i2);
    }

    public static final boolean isMoreThanZero(BigInteger bigInteger) {
        m.g(bigInteger, "<this>");
        return bigInteger.compareTo(BigInteger.ZERO) > 0;
    }
}