package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.bip44wallets.exceptions.BIP44Exception;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.send.models.SendAmounts;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.send.models.SendConfirmationState;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendConfirmationViewModel$fetchReceiptInformation$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ SendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SendConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendAmounts;", "sendAmounts", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/SendAmounts;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.viewmodels.SendConfirmationViewModel$fetchReceiptInformation$3$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SendAmounts, kotlin.x> {
        final /* synthetic */ SendConfirmationState $errorState;
        final /* synthetic */ SendConfirmationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SendConfirmationState sendConfirmationState, SendConfirmationViewModel sendConfirmationViewModel) {
            super(1);
            this.$errorState = sendConfirmationState;
            this.this$0 = sendConfirmationViewModel;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(SendAmounts sendAmounts) {
            invoke2(sendAmounts);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(SendAmounts sendAmounts) {
            h.c.v0.b bVar;
            kotlin.jvm.internal.m.g(sendAmounts, "sendAmounts");
            SendConfirmationResult sendConfirmationResult = new SendConfirmationResult(this.$errorState, sendAmounts.getFiat(), sendAmounts.getCrypto(), null, null, null, null, 120, null);
            bVar = this.this$0.sendConfirmationSubject;
            bVar.onNext(sendConfirmationResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendConfirmationViewModel$fetchReceiptInformation$3(SendConfirmationViewModel sendConfirmationViewModel) {
        super(1);
        this.this$0 = sendConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable error) {
        String h0;
        CharSequence h1;
        kotlin.jvm.internal.m.g(error, "error");
        SendConfirmationState insufficientBalance = new SendConfirmationState.InsufficientBalance(LocalizedStrings.INSTANCE.get(R.string.confirmation_error_coin_selection));
        if (error instanceof CompositeException) {
            CompositeException compositeException = (CompositeException) error;
            if (!compositeException.b().contains(BIP44Exception.UnableToSelectCoins.INSTANCE)) {
                List<Throwable> b2 = compositeException.b();
                kotlin.jvm.internal.m.f(b2, "error.exceptions");
                ArrayList arrayList = new ArrayList();
                for (Throwable th : b2) {
                    String localizedMessage = th.getLocalizedMessage();
                    if (localizedMessage != null) {
                        arrayList.add(localizedMessage);
                    }
                }
                h0 = kotlin.a0.z.h0(arrayList, "\n", null, null, 0, null, null, 62, null);
                Objects.requireNonNull(h0, "null cannot be cast to non-null type kotlin.CharSequence");
                h1 = kotlin.l0.y.h1(h0);
                insufficientBalance = new SendConfirmationState.Error(h1.toString());
            }
        } else if (!(error instanceof BIP44Exception.UnableToSelectCoins)) {
            String localizedMessage2 = error.getLocalizedMessage();
            kotlin.jvm.internal.m.f(localizedMessage2, "error.localizedMessage");
            insufficientBalance = new SendConfirmationState.Error(localizedMessage2);
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.txGenerationError(AnalyticsEvent.Companion));
        h.c.t0.g.i(Single_AnalyticsKt.logError$default(this.this$0.getSendAmounts(), null, null, 3, null), null, new AnonymousClass1(insufficientBalance, this.this$0), 1, null);
    }
}