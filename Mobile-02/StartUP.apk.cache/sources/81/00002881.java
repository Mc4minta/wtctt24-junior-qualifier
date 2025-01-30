package com.coinbase.wallet.wallets.daos;

import com.coinbase.wallet.libraries.databases.model.DatabaseOperation;
import kotlin.Metadata;

/* compiled from: Storage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public /* synthetic */ class FiatCurrencyDAO$getCurrencies$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[DatabaseOperation.values().length];
        iArr[DatabaseOperation.READ.ordinal()] = 1;
        iArr[DatabaseOperation.WRITE.ordinal()] = 2;
        $EnumSwitchMapping$0 = iArr;
    }
}