package com.coinbase.wallet.features.lend.viewmodels;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.utilities.ActionSheetDialogHelper;
import com.coinbase.wallet.features.lend.models.LendCoinPickerItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendCoinPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isSwapEnabled", "Lkotlin/x;", "<anonymous>", "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendCoinPickerViewModel$onItemClicked$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Boolean, x> {
    final /* synthetic */ LendCoinPickerItem $item;
    final /* synthetic */ LendCoinPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendCoinPickerViewModel$onItemClicked$1(LendCoinPickerViewModel lendCoinPickerViewModel, LendCoinPickerItem lendCoinPickerItem) {
        super(1);
        this.this$0 = lendCoinPickerViewModel;
        this.$item = lendCoinPickerItem;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Boolean bool) {
        invoke2(bool);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean isSwapEnabled) {
        List fundActions;
        h.c.v0.b bVar;
        String str = LocalizedStrings.INSTANCE.get(R.string.you_dont_have_this_crypto);
        LendCoinPickerViewModel lendCoinPickerViewModel = this.this$0;
        kotlin.jvm.internal.m.f(isSwapEnabled, "isSwapEnabled");
        fundActions = lendCoinPickerViewModel.fundActions(isSwapEnabled.booleanValue(), this.$item.getWallet());
        ActionSheetDialogHelper.Properties properties = new ActionSheetDialogHelper.Properties(str, fundActions, false, null, null, 28, null);
        bVar = this.this$0.actionSheetSubject;
        bVar.onNext(properties);
    }
}