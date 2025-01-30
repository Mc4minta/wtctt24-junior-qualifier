package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerError;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.swap.models.SwapAsset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.t0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$updateSourceFromTarget$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ SwapAsset $source;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$updateSourceFromTarget$1(SwapAmountPickerViewModel swapAmountPickerViewModel, SwapAsset swapAsset) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
        this.$source = swapAsset;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable it) {
        Set set;
        Set i2;
        SwapAmountPickerViewState swapAmountPickerViewState;
        CurrencyCode currencyCode;
        kotlin.jvm.internal.m.g(it, "it");
        SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
        set = swapAmountPickerViewModel.errorSet;
        i2 = t0.i(set, SwapAmountPickerError.GenericError);
        swapAmountPickerViewModel.setErrorSet(i2);
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        String str = "conversion failed: " + this.$source.getCurrencyCode().getCode() + " to fiat";
        String code = this.$source.getCurrencyCode().getCode();
        swapAmountPickerViewState = this.this$0.state;
        SwapAsset targetSwapAsset = swapAmountPickerViewState.getTargetSwapAsset();
        String str2 = null;
        if (targetSwapAsset != null && (currencyCode = targetSwapAsset.getCurrencyCode()) != null) {
            str2 = currencyCode.getCode();
        }
        analytics.log(AnalyticsEvent_ApplicationKt.swapAmountPickerGenericError(companion, str, code, str2));
    }
}