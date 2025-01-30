package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel;
import com.coinbase.wallet.swap.models.SwapTrade;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072Ë\u0001\u0010\u0006\u001aÆ\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012@\u0012>\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0002*\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00000\u0000 \u0002*b\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012@\u0012>\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0002*\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlin/t;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "Ljava/math/BigInteger;", "", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapConfirmationViewModel$SwapTxPair;", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/t;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewModel$fetchReceiptInformation$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.t<? extends Wallet, ? extends Wallet, ? extends kotlin.t<? extends BigInteger, ? extends BigInteger, ? extends List<? extends SwapConfirmationViewModel.SwapTxPair>>>, kotlin.x> {
    final /* synthetic */ SwapConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationViewModel$fetchReceiptInformation$2(SwapConfirmationViewModel swapConfirmationViewModel) {
        super(1);
        this.this$0 = swapConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.t<? extends Wallet, ? extends Wallet, ? extends kotlin.t<? extends BigInteger, ? extends BigInteger, ? extends List<? extends SwapConfirmationViewModel.SwapTxPair>>> tVar) {
        invoke2((kotlin.t<Wallet, Wallet, ? extends kotlin.t<? extends BigInteger, ? extends BigInteger, ? extends List<SwapConfirmationViewModel.SwapTxPair>>>) tVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.t<Wallet, Wallet, ? extends kotlin.t<? extends BigInteger, ? extends BigInteger, ? extends List<SwapConfirmationViewModel.SwapTxPair>>> tVar) {
        SwapTrade swapTrade;
        Wallet ethWallet = tVar.a();
        Wallet sourceWallet = tVar.b();
        kotlin.t<? extends BigInteger, ? extends BigInteger, ? extends List<SwapConfirmationViewModel.SwapTxPair>> c2 = tVar.c();
        BigInteger d2 = c2.d();
        BigInteger e2 = c2.e();
        this.this$0.swapTxs = c2.f();
        swapTrade = this.this$0.swapTrade;
        kotlin.jvm.internal.m.f(sourceWallet, "sourceWallet");
        kotlin.jvm.internal.m.f(ethWallet, "ethWallet");
        SwapConfirmationViewModel.ConfirmationResult confirmationResult = new SwapConfirmationViewModel.ConfirmationResult(swapTrade, d2, e2, sourceWallet, ethWallet);
        this.this$0.coinbaseFeePercentage = confirmationResult.getTrade().getFee().getDisplayPercentage();
        this.this$0.handleUnsignedSwapTxs(confirmationResult);
    }
}