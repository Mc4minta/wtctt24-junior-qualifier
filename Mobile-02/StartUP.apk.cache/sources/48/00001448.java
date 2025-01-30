package com.coinbase.wallet.common.extensions;

import com.coinbase.wallet.core.extensions.Strings;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.a0;
import kotlin.l0.i;
import kotlin.l0.k;

/* compiled from: BigDecimal+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Ljava/math/BigDecimal;", "", "decimals", "Ljava/math/BigInteger;", "asBigInteger", "(Ljava/math/BigDecimal;I)Ljava/math/BigInteger;", "", "asPercentage", "(Ljava/math/BigDecimal;I)Ljava/lang/String;", "asRoundedPercentage", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigDecimal_CommonKt {
    public static final BigInteger asBigInteger(BigDecimal bigDecimal, int i2) {
        m.g(bigDecimal, "<this>");
        BigInteger bigInteger = bigDecimal.multiply(BigDecimal.TEN.pow(i2)).toBigInteger();
        m.f(bigInteger, "this.multiply(BigDecimal.TEN.pow(decimals)).toBigInteger()");
        return bigInteger;
    }

    public static final String asPercentage(BigDecimal bigDecimal, int i2) {
        Character m1;
        String ch;
        m.g(bigDecimal, "<this>");
        String result = bigDecimal.movePointRight(2).stripTrailingZeros().round(new MathContext(i2 + 1, RoundingMode.DOWN)).toPlainString();
        m.f(result, "result");
        m1 = a0.m1(result);
        if (m1 == null || (ch = m1.toString()) == null) {
            ch = Strings.zero;
        }
        int i3 = m.c(ch, Strings.zero) ? 2 : 1;
        i b2 = k.b(new k("(^[0-9]*)(.)([^1-9]*[0-9]{" + i3 + "})"), result, 0, 2, null);
        String value = b2 != null ? b2.getValue() : null;
        return value == null ? result : value;
    }

    public static /* synthetic */ String asPercentage$default(BigDecimal bigDecimal, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8;
        }
        return asPercentage(bigDecimal, i2);
    }

    public static final String asRoundedPercentage(BigDecimal bigDecimal, int i2) {
        Character m1;
        String ch;
        m.g(bigDecimal, "<this>");
        String result = bigDecimal.movePointRight(2).stripTrailingZeros().round(new MathContext(i2 + 1, RoundingMode.HALF_UP)).toPlainString();
        m.f(result, "result");
        m1 = a0.m1(result);
        if (m1 == null || (ch = m1.toString()) == null) {
            ch = Strings.zero;
        }
        int i3 = m.c(ch, Strings.zero) ? 2 : 1;
        i b2 = k.b(new k("(^[0-9]*)(.)([^1-9]*[0-9]{" + i3 + "})"), result, 0, 2, null);
        String value = b2 != null ? b2.getValue() : null;
        return value == null ? result : value;
    }

    public static /* synthetic */ String asRoundedPercentage$default(BigDecimal bigDecimal, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8;
        }
        return asRoundedPercentage(bigDecimal, i2);
    }
}