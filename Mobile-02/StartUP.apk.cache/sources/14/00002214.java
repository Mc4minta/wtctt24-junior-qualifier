package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.common.extensions.String_CommonKt;
import com.coinbase.wallet.commonui.extensions.RawStringResult;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "amount", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$handleFiatInput$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ RawStringResult $newAmount;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$handleFiatInput$2(SwapAmountPickerViewModel swapAmountPickerViewModel, RawStringResult rawStringResult) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
        this.$newAmount = rawStringResult;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String amount) {
        SwapAmountPickerViewModel.updateInputs$default(this.this$0, ((RawStringResult.Success) this.$newAmount).getRawString(), amount, null, 4, null);
        this.this$0.checkBalance();
        kotlin.jvm.internal.m.f(amount, "amount");
        if (String_CommonKt.isNonZeroAmount(amount)) {
            this.this$0.refreshQuote();
        } else {
            SwapAmountPickerViewModel.resetViewState$default(this.this$0, false, false, true, 3, null);
        }
    }
}