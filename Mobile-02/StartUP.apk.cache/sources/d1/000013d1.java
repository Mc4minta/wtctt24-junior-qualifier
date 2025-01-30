package com.coinbase.wallet.blockchains.dbconverters;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import kotlin.Metadata;

/* compiled from: CurrencyCodeConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/blockchains/dbconverters/CurrencyCodeConverter;", "", "", "value", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "fromString", "(Ljava/lang/String;)Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", "toString", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Ljava/lang/String;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CurrencyCodeConverter {
    public final CurrencyCode fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return new CurrencyCode(str);
    }

    public final String toString(CurrencyCode currencyCode) {
        if (currencyCode == null) {
            return null;
        }
        return currencyCode.getRawValue();
    }
}