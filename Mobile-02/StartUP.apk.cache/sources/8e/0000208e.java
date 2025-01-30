package com.coinbase.wallet.features.send.views;

import android.view.View;
import com.coinbase.wallet.features.commonui.views.AmountSliderView;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupOnClickListeners$5 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupOnClickListeners$5(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        AmountFragment amountFragment;
        AmountPickerViewModel amountPickerViewModel;
        AmountPickerViewModel amountPickerViewModel2;
        AmountFragment amountFragment2;
        AmountSliderView amountSliderView;
        AmountSliderView amountSliderView2;
        AmountPickerViewModel amountPickerViewModel3;
        AmountFragment amountFragment3;
        kotlin.jvm.internal.m.g(it, "it");
        amountFragment = this.this$0.amountFragment;
        if (amountFragment != null) {
            if (!amountFragment.isFiatSelected()) {
                amountFragment3 = this.this$0.amountFragment;
                if (amountFragment3 == null) {
                    kotlin.jvm.internal.m.w("amountFragment");
                    throw null;
                }
                amountFragment3.swapFields();
            }
            amountPickerViewModel = this.this$0.viewModel;
            if (amountPickerViewModel != null) {
                amountPickerViewModel.setFiatSelected(true);
                amountPickerViewModel2 = this.this$0.viewModel;
                if (amountPickerViewModel2 == null) {
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
                amountFragment2 = this.this$0.amountFragment;
                if (amountFragment2 != null) {
                    float cryptoPercentage = amountPickerViewModel2.getCryptoPercentage(amountFragment2.getRawCryptoAmount());
                    amountSliderView = this.this$0.amountSliderView;
                    if (amountSliderView != null) {
                        amountSliderView.setCurrentValue(cryptoPercentage);
                    }
                    amountSliderView2 = this.this$0.amountSliderView;
                    if (amountSliderView2 != null) {
                        amountSliderView2.updateSliderValueIfNeeded();
                    }
                    amountPickerViewModel3 = this.this$0.viewModel;
                    if (amountPickerViewModel3 != null) {
                        amountPickerViewModel3.onSliderToggled();
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                }
                kotlin.jvm.internal.m.w("amountFragment");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("amountFragment");
        throw null;
    }
}