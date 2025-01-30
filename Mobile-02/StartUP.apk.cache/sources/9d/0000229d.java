package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapAmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(J)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapAmountPickerFragment$onStart$1 extends o implements l<Long, x> {
    final /* synthetic */ SwapAmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerFragment$onStart$1(SwapAmountPickerFragment swapAmountPickerFragment) {
        super(1);
        this.this$0 = swapAmountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Long l2) {
        invoke2(l2);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Long l2) {
        SwapAmountPickerViewModel viewModel;
        viewModel = this.this$0.getViewModel();
        viewModel.refreshQuote();
    }
}