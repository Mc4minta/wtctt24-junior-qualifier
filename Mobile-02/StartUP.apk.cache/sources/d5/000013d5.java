package com.coinbase.wallet.blockchains.dbconverters;

import com.coinbase.wallet.blockchains.models.TxState;
import kotlin.Metadata;

/* compiled from: TxStateConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/blockchains/dbconverters/TxStateConverter;", "", "", "value", "Lcom/coinbase/wallet/blockchains/models/TxState;", "fromInt", "(Ljava/lang/Integer;)Lcom/coinbase/wallet/blockchains/models/TxState;", "toInt", "(Lcom/coinbase/wallet/blockchains/models/TxState;)Ljava/lang/Integer;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxStateConverter {
    public final TxState fromInt(Integer num) {
        if (num == null) {
            return null;
        }
        return TxState.Companion.create(num.intValue());
    }

    public final Integer toInt(TxState txState) {
        if (txState == null) {
            return null;
        }
        return Integer.valueOf(txState.getRawValue());
    }
}