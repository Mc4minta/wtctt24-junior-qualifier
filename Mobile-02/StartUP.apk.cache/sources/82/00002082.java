package com.coinbase.wallet.features.send.views;

import android.view.View;
import android.widget.Button;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.views.CurrencyPickerView;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AmountPickerFragment$onAttachFragment$setupWallet$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Wallet, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$onAttachFragment$setupWallet$1(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Wallet wallet) {
        invoke2(wallet);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Wallet wallet) {
        AmountPickerViewModel amountPickerViewModel;
        AmountPickerViewModel amountPickerViewModel2;
        kotlin.jvm.internal.m.g(wallet, "wallet");
        View view = this.this$0.getView();
        ((CurrencyPickerView) (view == null ? null : view.findViewById(e.j.a.k1))).setCoin(wallet);
        this.this$0.setupSendAmountView(wallet);
        amountPickerViewModel = this.this$0.viewModel;
        if (amountPickerViewModel != null) {
            amountPickerViewModel.restoreCachedCryptoAmount();
            View view2 = this.this$0.getView();
            ((Button) (view2 == null ? null : view2.findViewById(e.j.a.N3))).setClickable(true);
            AmountPickerFragment amountPickerFragment = this.this$0;
            amountPickerViewModel2 = amountPickerFragment.viewModel;
            if (amountPickerViewModel2 != null) {
                amountPickerFragment.setSwapButtonEnabled(amountPickerViewModel2.getHasFiatRepresentation());
                return;
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}