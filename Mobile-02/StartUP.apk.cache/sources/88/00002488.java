package com.coinbase.wallet.libraries.databases.converters;

import java.math.BigDecimal;
import kotlin.Metadata;

/* compiled from: BigDecimalConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/converters/BigDecimalConverter;", "", "", "value", "Ljava/math/BigDecimal;", "fromString", "(Ljava/lang/String;)Ljava/math/BigDecimal;", "toString", "(Ljava/math/BigDecimal;)Ljava/lang/String;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BigDecimalConverter {
    public final BigDecimal fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return new BigDecimal(str);
    }

    public final String toString(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        return bigDecimal.toString();
    }
}