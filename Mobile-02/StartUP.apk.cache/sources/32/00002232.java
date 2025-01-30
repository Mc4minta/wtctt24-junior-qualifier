package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.models.SwapAssetPickerArgs;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAssetPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAssetPickerViewModel$selectAsset$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
    final /* synthetic */ SwapAsset $swapAsset;
    final /* synthetic */ SwapAssetPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAssetPickerViewModel$selectAsset$1(SwapAssetPickerViewModel swapAssetPickerViewModel, SwapAsset swapAsset) {
        super(1);
        this.this$0 = swapAssetPickerViewModel;
        this.$swapAsset = swapAsset;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
        invoke2(xVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.x xVar) {
        AmountBase amountBase;
        String str;
        h.c.v0.b bVar;
        amountBase = this.this$0.amountBase;
        if (amountBase instanceof AmountBase.Source) {
            str = SwapAssetPickerArgs.Result.sourceSwapAssetKey;
        } else if (!(amountBase instanceof AmountBase.Target)) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = SwapAssetPickerArgs.Result.targetSwapAssetKey;
        }
        bVar = this.this$0.selectedAssetSubject;
        bVar.onNext(new kotlin.o(str, this.$swapAsset));
    }
}