package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerError;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.swap.models.SwapAsset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.t0;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$proceedToConfirmTx$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ SwapAsset $source;
    final /* synthetic */ SwapAsset $target;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$proceedToConfirmTx$2(SwapAmountPickerViewModel swapAmountPickerViewModel, SwapAsset swapAsset, SwapAsset swapAsset2) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
        this.$source = swapAsset;
        this.$target = swapAsset2;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable error) {
        SwapAmountPickerViewState swapAmountPickerViewState;
        SwapAmountPickerViewState copy;
        Set set;
        Set i2;
        kotlin.jvm.internal.m.g(error, "error");
        SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
        swapAmountPickerViewState = swapAmountPickerViewModel.state;
        copy = swapAmountPickerViewState.copy((r32 & 1) != 0 ? swapAmountPickerViewState.isInitialized : false, (r32 & 2) != 0 ? swapAmountPickerViewState.pickerItems : null, (r32 & 4) != 0 ? swapAmountPickerViewState.activeCurrencyCard : null, (r32 & 8) != 0 ? swapAmountPickerViewState.sourceSwapAsset : null, (r32 & 16) != 0 ? swapAmountPickerViewState.targetSwapAsset : null, (r32 & 32) != 0 ? swapAmountPickerViewState.error : null, (r32 & 64) != 0 ? swapAmountPickerViewState.isLoading : false, (r32 & 128) != 0 ? swapAmountPickerViewState.nextButtonTitle : null, (r32 & 256) != 0 ? swapAmountPickerViewState.fiatAmountText : null, (r32 & 512) != 0 ? swapAmountPickerViewState.equivalentAmountInCrypto : null, (r32 & 1024) != 0 ? swapAmountPickerViewState.focusedCryptoInputField : null, (r32 & PKIFailureInfo.wrongIntegrity) != 0 ? swapAmountPickerViewState.equivalentAmountInFiat : null, (r32 & 4096) != 0 ? swapAmountPickerViewState.cryptoSourceAmount : null, (r32 & PKIFailureInfo.certRevoked) != 0 ? swapAmountPickerViewState.cryptoTargetAmount : null, (r32 & 16384) != 0 ? swapAmountPickerViewState.isTargetFieldDisabled : false);
        swapAmountPickerViewModel.setState(copy);
        SwapAmountPickerViewModel swapAmountPickerViewModel2 = this.this$0;
        set = swapAmountPickerViewModel2.errorSet;
        i2 = t0.i(set, SwapAmountPickerError.GenericError);
        swapAmountPickerViewModel2.setErrorSet(i2);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapAmountPickerGenericError(AnalyticsEvent.Companion, error.getMessage(), this.$source.getCurrencyCode().getCode(), this.$target.getCurrencyCode().getCode()));
    }
}