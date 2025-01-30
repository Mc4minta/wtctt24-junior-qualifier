package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.features.lend.models.LendProviderPickerArgs;
import com.coinbase.wallet.lending.models.LendToken;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendProviderPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/coinbase/wallet/lending/models/LendToken;", "kotlin.jvm.PlatformType", "<anonymous>", "()Ljava/util/ArrayList;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProviderPickerViewModel$lendTokens$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<ArrayList<LendToken>> {
    final /* synthetic */ LendProviderPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendProviderPickerViewModel$lendTokens$2(LendProviderPickerViewModel lendProviderPickerViewModel) {
        super(0);
        this.this$0 = lendProviderPickerViewModel;
    }

    @Override // kotlin.e0.c.a
    public final ArrayList<LendToken> invoke() {
        ArrayList<LendToken> parcelableArrayList = this.this$0.getArgs().getParcelableArrayList(LendProviderPickerArgs.lendTokensKey);
        kotlin.jvm.internal.m.e(parcelableArrayList);
        return parcelableArrayList;
    }
}