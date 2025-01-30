package com.coinbase.wallet.features.send.viewmodels;

import android.os.Bundle;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.send.models.SendCompleteArgs;
import java.math.BigInteger;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel$confirmSend$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SignedTx, kotlin.x> {
    final /* synthetic */ UnsignedTx $tx;
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$confirmSend$2(SendConfirmationViewModel sendConfirmationViewModel, UnsignedTx unsignedTx) {
        super(1);
        this.this$0 = sendConfirmationViewModel;
        this.$tx = unsignedTx;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SignedTx signedTx) {
        invoke2(signedTx);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SignedTx signedTx) {
        TransferValue amount;
        String recipientAddress;
        h.c.v0.b bVar;
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        amount = this.this$0.getAmount();
        analytics.log(AnalyticsEvent_ApplicationKt.sendConfirmTxSubmitted(companion, amount.isMax()));
        SendCompleteArgs sendCompleteArgs = SendCompleteArgs.INSTANCE;
        Wallet wallet = this.this$0.getWallet();
        BigInteger transferValue = this.$tx.getTransferValue();
        recipientAddress = this.this$0.getRecipientAddress();
        Bundle createArgs = sendCompleteArgs.createArgs(wallet, transferValue, recipientAddress);
        createArgs.putSerializable(CompleteViewModel.class.getName(), SendCompleteViewModel.class);
        ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_confirmationFragment_to_completeFragment, createArgs, null, 4, null);
        bVar = this.this$0.navigateToSendCompleteViewSubject;
        bVar.onNext(viewModelNavRoute);
    }
}