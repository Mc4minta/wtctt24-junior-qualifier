package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerError;
import com.coinbase.wallet.features.wallets.extensions.Wallet_ApplicationKt;
import java.math.BigInteger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.t0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapAmountPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "wallet", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerViewModel$checkBalance$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Wallet, kotlin.x> {
    final /* synthetic */ BigInteger $amount;
    final /* synthetic */ SwapAmountPickerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapAmountPickerViewModel$checkBalance$1(BigInteger bigInteger, SwapAmountPickerViewModel swapAmountPickerViewModel) {
        super(1);
        this.$amount = bigInteger;
        this.this$0 = swapAmountPickerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Wallet wallet) {
        invoke2(wallet);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Wallet wallet) {
        Set set;
        Set g2;
        Set set2;
        Set i2;
        BigInteger bigInteger = this.$amount;
        kotlin.jvm.internal.m.f(wallet, "wallet");
        if (bigInteger.compareTo(Wallet_ApplicationKt.maximumAvailableBalance(wallet)) > 0) {
            SwapAmountPickerViewModel swapAmountPickerViewModel = this.this$0;
            set2 = swapAmountPickerViewModel.errorSet;
            i2 = t0.i(set2, SwapAmountPickerError.InsufficientBalance);
            swapAmountPickerViewModel.setErrorSet(i2);
            return;
        }
        SwapAmountPickerViewModel swapAmountPickerViewModel2 = this.this$0;
        set = swapAmountPickerViewModel2.errorSet;
        g2 = t0.g(set, SwapAmountPickerError.InsufficientBalance);
        swapAmountPickerViewModel2.setErrorSet(g2);
    }
}