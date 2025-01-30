package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.swap.models.SwapConfirmationEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001 \u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/o;", "Ljava/math/BigDecimal;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewModel$handleFees$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends BigDecimal, ? extends BigDecimal>, kotlin.x> {
    final /* synthetic */ BigInteger $coinbaseFee;
    final /* synthetic */ BigInteger $estimatedMinerFee;
    final /* synthetic */ BigInteger $gasPrice;
    final /* synthetic */ Wallet $minerFeeWallet;
    final /* synthetic */ Wallet $sourceWallet;
    final /* synthetic */ SwapConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationViewModel$handleFees$2(BigInteger bigInteger, Wallet wallet, BigInteger bigInteger2, Wallet wallet2, SwapConfirmationViewModel swapConfirmationViewModel, BigInteger bigInteger3) {
        super(1);
        this.$estimatedMinerFee = bigInteger;
        this.$minerFeeWallet = wallet;
        this.$coinbaseFee = bigInteger2;
        this.$sourceWallet = wallet2;
        this.this$0 = swapConfirmationViewModel;
        this.$gasPrice = bigInteger3;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends BigDecimal, ? extends BigDecimal> oVar) {
        invoke2(oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<? extends BigDecimal, ? extends BigDecimal> oVar) {
        BigDecimal bigDecimal;
        HighMinerFeesPrompt highMinerFeesPrompt;
        h.c.v0.b bVar;
        h.c.v0.b bVar2;
        BigDecimal a = oVar.a();
        BigDecimal minerFee = new BigDecimal(this.$estimatedMinerFee).movePointLeft(this.$minerFeeWallet.getDecimals());
        kotlin.jvm.internal.m.f(minerFee, "minerFee");
        BigDecimal multiply = a.multiply(minerFee);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        BigDecimal cbFee = new BigDecimal(this.$coinbaseFee).movePointLeft(this.$sourceWallet.getDecimals());
        kotlin.jvm.internal.m.f(cbFee, "cbFee");
        BigDecimal multiply2 = oVar.b().multiply(cbFee);
        kotlin.jvm.internal.m.f(multiply2, "this.multiply(other)");
        BigDecimal add = multiply.add(multiply2);
        kotlin.jvm.internal.m.f(add, "this.add(other)");
        bigDecimal = this.this$0.highFeeThreshold;
        if (add.compareTo(bigDecimal) > 0) {
            bVar2 = this.this$0.eventSubject;
            bVar2.onNext(SwapConfirmationEvent.ExpandDetails.INSTANCE);
        }
        if (this.$gasPrice == null) {
            return;
        }
        highMinerFeesPrompt = this.this$0.highMinerFeesPrompt;
        PromptDialogHelper.Properties promptProperties = highMinerFeesPrompt.promptProperties(this.$minerFeeWallet, this.$gasPrice, a);
        if (promptProperties != null) {
            bVar = this.this$0.promptSubject;
            bVar.onNext(promptProperties);
        }
    }
}