package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.features.commonui.views.AmountSliderView;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "amount", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupObservers$7 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupObservers$7(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String amount) {
        AmountFragment amountFragment;
        AmountPickerViewModel amountPickerViewModel;
        AmountSliderView amountSliderView;
        AmountPickerViewModel amountPickerViewModel2;
        amountFragment = this.this$0.amountFragment;
        if (amountFragment != null) {
            kotlin.jvm.internal.m.f(amount, "amount");
            amountFragment.updateCryptoAmount(amount);
            amountPickerViewModel = this.this$0.viewModel;
            if (amountPickerViewModel != null) {
                AmountPickerViewModel.updateSendAmount$default(amountPickerViewModel, amount, null, 2, null);
                amountSliderView = this.this$0.amountSliderView;
                if (amountSliderView == null) {
                    return;
                }
                amountPickerViewModel2 = this.this$0.viewModel;
                if (amountPickerViewModel2 != null) {
                    amountSliderView.setCurrentValue(amountPickerViewModel2.getCryptoPercentage(amount));
                    return;
                } else {
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("amountFragment");
        throw null;
    }
}