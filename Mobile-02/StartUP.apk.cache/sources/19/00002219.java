package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "fiat", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$onSourceAssetSelected$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ SwapAsset $asset;
    final /* synthetic */ SwapAsset $target;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$onSourceAssetSelected$3(SwapAmountPickerViewModel swapAmountPickerViewModel, SwapAsset swapAsset, SwapAsset swapAsset2) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
        this.$asset = swapAsset;
        this.$target = swapAsset2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        SwapAmountPickerViewState swapAmountPickerViewState;
        swapAmountPickerViewState = this.this$0.state;
        SwapAmountPickerViewModel.updateInputs$default(this.this$0, str, String_CommonKt.isNonZeroAmount(swapAmountPickerViewState.getCryptoSourceAmount().getRawString()) ^ true ? Strings.zero : null, null, 4, null);
        this.this$0.onAssetChanged(this.$asset, this.$target);
    }
}