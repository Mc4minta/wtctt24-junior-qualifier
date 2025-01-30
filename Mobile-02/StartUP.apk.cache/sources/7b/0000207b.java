package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "<anonymous>", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$attributes$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<StyledFragment.Attributes> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$attributes$2(AmountPickerFragment amountPickerFragment) {
        super(0);
        this.this$0 = amountPickerFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final StyledFragment.Attributes invoke() {
        AmountPickerViewModel amountPickerViewModel;
        AmountPickerViewModel amountPickerViewModel2;
        StyledFragment.Attributes attributes = StyledFragment.DefaultImpls.getAttributes(this.this$0);
        amountPickerViewModel = this.this$0.viewModel;
        if (amountPickerViewModel != null) {
            boolean isSend = amountPickerViewModel.getSettings().isSend();
            amountPickerViewModel2 = this.this$0.viewModel;
            if (amountPickerViewModel2 != null) {
                return attributes.copy(true, isSend, amountPickerViewModel2.getSettings().isSend());
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}