package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "", "", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$applyStyle$1$9 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends Float, ? extends Boolean>, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$applyStyle$1$9(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends Float, ? extends Boolean> oVar) {
        invoke2((kotlin.o<Float, Boolean>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<Float, Boolean> oVar) {
        AmountPickerViewModel amountPickerViewModel;
        AmountFragment amountFragment;
        AmountPickerViewModel amountPickerViewModel2;
        float floatValue = oVar.a().floatValue();
        boolean booleanValue = oVar.b().booleanValue();
        amountPickerViewModel = this.this$0.viewModel;
        if (amountPickerViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        String formatCryptoAmount = amountPickerViewModel.formatCryptoAmount(floatValue);
        if (formatCryptoAmount == null) {
            return;
        }
        amountFragment = this.this$0.amountFragment;
        if (amountFragment != null) {
            amountFragment.updateCryptoAmount(formatCryptoAmount);
            amountPickerViewModel2 = this.this$0.viewModel;
            if (amountPickerViewModel2 != null) {
                amountPickerViewModel2.updateSendAmount(formatCryptoAmount, Boolean.valueOf(booleanValue));
                return;
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("amountFragment");
        throw null;
    }
}