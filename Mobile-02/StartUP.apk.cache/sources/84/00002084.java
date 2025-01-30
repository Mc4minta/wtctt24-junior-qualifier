package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupObservers$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<String, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupObservers$3(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str) {
        invoke2(str);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String it) {
        AmountPickerViewModel amountPickerViewModel;
        amountPickerViewModel = this.this$0.viewModel;
        if (amountPickerViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(it, "it");
        amountPickerViewModel.updateSendAmount(it, Boolean.TRUE);
    }
}