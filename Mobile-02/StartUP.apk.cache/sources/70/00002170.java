package com.coinbase.wallet.features.signer.viewmodel;

import com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.ethereum.exceptions.EthereumException;
import com.coinbase.wallet.features.send.models.SendBalances;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TxSignerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxSignerViewModel$fetchReceiptInformation$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, x> {
    final /* synthetic */ TxSignerViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TxSignerViewModel$fetchReceiptInformation$3(TxSignerViewModel txSignerViewModel) {
        super(1);
        this.this$0 = txSignerViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Throwable th) {
        invoke2(th);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable error) {
        SendConfirmationState error2;
        SendBalances sendAmounts;
        SendBalances sendAmounts2;
        h.c.v0.b bVar;
        kotlin.jvm.internal.m.g(error, "error");
        if (error instanceof EthereumException.UnableToEstimateGas) {
            error2 = new SendConfirmationState.FeeCalculationFailed(LocalizedStrings.INSTANCE.get(R.string.send_confirm_calculation_error));
        } else if (error instanceof BIP44Exception.UnableToSelectCoins) {
            error2 = new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.confirmation_error_coin_selection));
        } else {
            error2 = new SendConfirmationState.Error(LocalizedStrings.INSTANCE.get(R.string.send_fee_error));
        }
        SendConfirmationState sendConfirmationState = error2;
        sendAmounts = this.this$0.getSendAmounts();
        String fiatBalance = sendAmounts.getFiatBalance();
        if (fiatBalance == null) {
            fiatBalance = Strings_CoreKt.getEllipsis(Strings.INSTANCE);
        }
        String str = fiatBalance;
        sendAmounts2 = this.this$0.getSendAmounts();
        SendConfirmationResult sendConfirmationResult = new SendConfirmationResult(sendConfirmationState, str, sendAmounts2.getCryptoBalance(), null, null, null, null, 120, null);
        bVar = this.this$0.signConfirmationSubject;
        bVar.onNext(sendConfirmationResult);
    }
}