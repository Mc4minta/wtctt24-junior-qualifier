package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.swap.models.SwapAsset;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/swap/models/SwapAsset;", "kotlin.jvm.PlatformType", "asset", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/swap/models/SwapAsset;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$preselectAsset$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SwapAsset, kotlin.x> {
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$preselectAsset$2(SwapAmountPickerViewModel swapAmountPickerViewModel) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SwapAsset swapAsset) {
        invoke2(swapAsset);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapAsset asset) {
        SwapAmountPickerViewState swapAmountPickerViewState;
        String zeroString;
        SwapAmountPickerViewState swapAmountPickerViewState2;
        SwapAmountPickerViewState copy;
        swapAmountPickerViewState = this.this$0.state;
        if (swapAmountPickerViewState.getSourceSwapAsset() == null) {
            SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
            kotlin.jvm.internal.m.f(asset, "asset");
            zeroString = swapAmountPickerViewModel.getZeroString(asset);
            swapAmountPickerViewState2 = this.this$0.state;
            copy = swapAmountPickerViewState2.copy((r32 & 1) != 0 ? swapAmountPickerViewState2.isInitialized : true, (r32 & 2) != 0 ? swapAmountPickerViewState2.pickerItems : null, (r32 & 4) != 0 ? swapAmountPickerViewState2.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState2.sourceSwapAsset : asset, (r32 & 16) != 0 ? swapAmountPickerViewState2.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState2.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState2.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState2.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState2.fiatAmountText : null, (r32 & 512) != 0 ? swapAmountPickerViewState2.equivalentAmountInCrypto : zeroString, (r32 & 1024) != 0 ? swapAmountPickerViewState2.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState2.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? swapAmountPickerViewState2.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState2.cryptoTargetAmount : null, (r32 & 16384) != 0 ? swapAmountPickerViewState2.isTargetFieldDisabled : false);
            swapAmountPickerViewModel.setState(copy);
        }
    }
}