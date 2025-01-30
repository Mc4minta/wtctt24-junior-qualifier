package com.coinbase.wallet.txhistory.dbconverters;

import com.coinbase.wallet.txhistory.models.RecipientType;
import kotlin.Metadata;

/* compiled from: RecipientTypeConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/txhistory/dbconverters/RecipientTypeConverter;", "", "", "value", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "fromInt", "(Ljava/lang/Integer;)Lcom/coinbase/wallet/txhistory/models/RecipientType;", "toInt", "(Lcom/coinbase/wallet/txhistory/models/RecipientType;)Ljava/lang/Integer;", "<init>", "()V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RecipientTypeConverter {
    public final RecipientType fromInt(Integer num) {
        if (num == null) {
            return null;
        }
        return RecipientType.Companion.from(num.intValue());
    }

    public final Integer toInt(RecipientType recipientType) {
        if (recipientType == null) {
            return null;
        }
        return Integer.valueOf(recipientType.getRawValue());
    }
}