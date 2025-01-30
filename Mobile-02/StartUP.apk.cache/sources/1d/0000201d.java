package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.interfaces.UnsignedTx;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel$confirmSend$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ UnsignedTx $tx;
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$confirmSend$1(UnsignedTx unsignedTx, SendConfirmationViewModel sendConfirmationViewModel) {
        super(1);
        this.$tx = unsignedTx;
        this.this$0 = sendConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable it) {
        h.c.v0.b bVar;
        kotlin.jvm.internal.m.g(it, "it");
        String message = it.getMessage();
        if (message == null) {
            message = LocalizedStrings.INSTANCE.get(R.string.send_confirm_calculation_error);
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendConfirmErrorReceived(AnalyticsEvent.Companion, this.$tx.getCurrencyCode().getCode(), message));
        bVar = this.this$0.sendConfirmationSubject;
        bVar.onNext(new SendConfirmationResult(new SendConfirmationState.Error(message), null, null, null, null, null, null, 126, null));
    }
}