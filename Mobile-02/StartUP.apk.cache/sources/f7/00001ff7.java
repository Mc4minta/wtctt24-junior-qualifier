package com.coinbase.wallet.features.send.viewmodels;

import java.math.BigInteger;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFeeViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Ljava/math/BigInteger;", "value", "", "changeDirectionFrom", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/lang/String;", "", "(II)Ljava/lang/String;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String changeDirectionFrom(int i2, int i3) {
        return i2 > i3 ? "Up" : i2 < i3 ? "Down" : "None";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String changeDirectionFrom(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(bigInteger2) > 0 ? "Up" : bigInteger.compareTo(bigInteger2) < 0 ? "Down" : "None";
    }
}