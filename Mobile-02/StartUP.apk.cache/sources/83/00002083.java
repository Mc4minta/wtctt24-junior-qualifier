package com.coinbase.wallet.features.send.views;

import android.view.View;
import com.coinbase.wallet.commonui.views.CurrencyPickerView;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendBalances;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/SendBalances;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupObservers$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SendBalances, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupObservers$1(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SendBalances sendBalances) {
        invoke2(sendBalances);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SendBalances sendBalances) {
        AmountPickerViewModel amountPickerViewModel;
        View view = this.this$0.getView();
        CurrencyPickerView currencyPickerView = (CurrencyPickerView) (view == null ? null : view.findViewById(e.j.a.k1));
        amountPickerViewModel = this.this$0.viewModel;
        if (amountPickerViewModel != null) {
            currencyPickerView.setCoin(amountPickerViewModel.getWallet());
            View view2 = this.this$0.getView();
            ((CurrencyPickerView) (view2 == null ? null : view2.findViewById(e.j.a.k1))).setFiatBalance(sendBalances.getFiatBalance());
            View view3 = this.this$0.getView();
            ((CurrencyPickerView) (view3 != null ? view3.findViewById(e.j.a.k1) : null)).setCryptoBalance(sendBalances.getCryptoBalance());
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}