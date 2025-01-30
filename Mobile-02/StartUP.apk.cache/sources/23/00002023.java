package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.ethereum.models.EthereumUnsigned1559Tx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedLegacyTx;
import com.coinbase.wallet.ethereum.models.EthereumUnsignedTx;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/math/BigDecimal;", "rate", "Lkotlin/x;", "<anonymous>", "(Ljava/math/BigDecimal;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel$handleUnsignedTx$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<BigDecimal, kotlin.x> {
    final /* synthetic */ Wallet $feeWallet;
    final /* synthetic */ boolean $forceExpand;
    final /* synthetic */ UnsignedTx $tx;
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$handleUnsignedTx$1(UnsignedTx unsignedTx, Wallet wallet, SendConfirmationViewModel sendConfirmationViewModel, boolean z) {
        super(1);
        this.$tx = unsignedTx;
        this.$feeWallet = wallet;
        this.this$0 = sendConfirmationViewModel;
        this.$forceExpand = z;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(BigDecimal bigDecimal) {
        invoke2(bigDecimal);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(BigDecimal rate) {
        BigDecimal bigDecimal;
        h.c.v0.b bVar;
        BigInteger maxFeePerGas;
        HighMinerFeesPrompt highMinerFeesPrompt;
        kotlin.jvm.internal.m.g(rate, "rate");
        BigDecimal fee = new BigDecimal(this.$tx.getEstimatedFee()).scaleByPowerOfTen(-this.$feeWallet.getDecimals());
        kotlin.jvm.internal.m.f(fee, "fee");
        BigDecimal multiply = rate.multiply(fee);
        kotlin.jvm.internal.m.f(multiply, "this.multiply(other)");
        bigDecimal = this.this$0.highFeeThreshold;
        if (multiply.compareTo(bigDecimal) > 0 || this.$forceExpand) {
            bVar = this.this$0.expandCardSubject;
            bVar.onNext(Boolean.TRUE);
        }
        UnsignedTx unsignedTx = this.$tx;
        if (unsignedTx instanceof EthereumUnsignedTx) {
            EthereumUnsignedTx ethereumUnsignedTx = (EthereumUnsignedTx) unsignedTx;
            if (ethereumUnsignedTx instanceof EthereumUnsignedLegacyTx) {
                maxFeePerGas = ((EthereumUnsignedLegacyTx) unsignedTx).getGasPrice();
            } else if (!(ethereumUnsignedTx instanceof EthereumUnsigned1559Tx)) {
                throw new NoWhenBranchMatchedException();
            } else {
                maxFeePerGas = ((EthereumUnsigned1559Tx) unsignedTx).getMaxFeePerGas();
            }
            highMinerFeesPrompt = this.this$0.highMinerFeesPrompt;
            PromptDialogHelper.Properties promptProperties = highMinerFeesPrompt.promptProperties(this.$feeWallet, maxFeePerGas, rate);
            if (promptProperties != null) {
                this.this$0.getPromptSubject().onNext(promptProperties);
            }
        }
    }
}