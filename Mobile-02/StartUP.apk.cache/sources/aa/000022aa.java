package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAsset;", "kotlin.jvm.PlatformType", "swapAsset", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerFragment$setupObservers$6 extends o implements l<SwapAsset, x> {
    final /* synthetic */ SwapAmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerFragment$setupObservers$6(SwapAmountPickerFragment swapAmountPickerFragment) {
        super(1);
        this.this$0 = swapAmountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SwapAsset swapAsset) {
        invoke2(swapAsset);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapAsset swapAsset) {
        SwapAmountPickerViewModel viewModel;
        viewModel = this.this$0.getViewModel();
        m.f(swapAsset, "swapAsset");
        viewModel.onTargetAssetSelected(swapAsset);
    }
}