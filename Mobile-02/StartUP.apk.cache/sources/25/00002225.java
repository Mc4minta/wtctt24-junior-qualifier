package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.features.swap.models.SwapAmountPickerError;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.swap.models.AmountBase;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapQuote;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.t0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/swap/models/AmountBase;", "Lcom/coinbase/wallet/swap/models/SwapQuote;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$setup$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends AmountBase, ? extends SwapQuote>, kotlin.x> {
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$setup$4(SwapAmountPickerViewModel swapAmountPickerViewModel) {
        super(1);
        this.this$0 = swapAmountPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends AmountBase, ? extends SwapQuote> oVar) {
        invoke2((kotlin.o<? extends AmountBase, SwapQuote>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends AmountBase, SwapQuote> oVar) {
        Set set;
        Set g2;
        Set set2;
        Set g3;
        kotlin.o oVar2;
        String amountString;
        Set set3;
        Set g4;
        SwapAmountPickerViewState swapAmountPickerViewState;
        SwapAmountPickerViewState swapAmountPickerViewState2;
        Set set4;
        Set i2;
        String amountString2;
        AmountBase a = oVar.a();
        SwapQuote b2 = oVar.b();
        SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
        set = swapAmountPickerViewModel.errorSet;
        g2 = t0.g(set, SwapAmountPickerError.LowLiquidity);
        swapAmountPickerViewModel.setErrorSet(g2);
        SwapAmountPickerViewModel swapAmountPickerViewModel2 = this.this$0;
        set2 = swapAmountPickerViewModel2.errorSet;
        g3 = t0.g(set2, SwapAmountPickerError.GenericError);
        swapAmountPickerViewModel2.setErrorSet(g3);
        AmountBase.Target target = AmountBase.Target.INSTANCE;
        if (kotlin.jvm.internal.m.c(a, target)) {
            SwapAsset fromAsset = b2.getFromAsset();
            amountString2 = this.this$0.toAmountString(b2.getFromAsset(), b2.getFromAmount());
            oVar2 = new kotlin.o(fromAsset, amountString2);
        } else {
            SwapAsset toAsset = b2.getToAsset();
            amountString = this.this$0.toAmountString(b2.getToAsset(), b2.getToAmount());
            oVar2 = new kotlin.o(toAsset, amountString);
        }
        SwapAsset swapAsset = (SwapAsset) oVar2.a();
        String str = (String) oVar2.b();
        if (b2.getHighPriceImpact()) {
            SwapAmountPickerViewModel swapAmountPickerViewModel3 = this.this$0;
            set4 = swapAmountPickerViewModel3.errorSet;
            i2 = t0.i(set4, SwapAmountPickerError.HighPriceImpact);
            swapAmountPickerViewModel3.setErrorSet(i2);
        } else {
            SwapAmountPickerViewModel swapAmountPickerViewModel4 = this.this$0;
            set3 = swapAmountPickerViewModel4.errorSet;
            g4 = t0.g(set3, SwapAmountPickerError.HighPriceImpact);
            swapAmountPickerViewModel4.setErrorSet(g4);
        }
        if (kotlin.jvm.internal.m.c(a, AmountBase.Source.INSTANCE)) {
            swapAmountPickerViewState2 = this.this$0.state;
            if (swapAmountPickerViewState2.getCryptoSourceAmount().isNotZero()) {
                SwapAmountPickerViewModel.updateInputs$default(this.this$0, null, null, str, 3, null);
            }
        }
        if (kotlin.jvm.internal.m.c(a, target)) {
            swapAmountPickerViewState = this.this$0.state;
            if (swapAmountPickerViewState.getCryptoTargetAmount().isNotZero()) {
                this.this$0.updateSourceFromTarget(str, swapAsset);
            }
        }
    }
}