package com.coinbase.wallet.features.swap.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.applock.exceptions.AppLockException;
import com.coinbase.wallet.features.swap.models.SwapConfirmationError;
import com.coinbase.wallet.features.swap.models.SwapConfirmationEvent;
import com.coinbase.wallet.features.swap.models.SwapConfirmationViewState;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.coinbase.wallet.swap.models.SwapMinerFeeException;
import io.reactivex.exceptions.CompositeException;
import kotlin.Metadata;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "Lkotlin/x;", "<anonymous>", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationViewModel$fetchReceiptInformation$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, kotlin.x> {
    final /* synthetic */ SwapConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationViewModel$fetchReceiptInformation$1(SwapConfirmationViewModel swapConfirmationViewModel) {
        super(1);
        this.this$0 = swapConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(Throwable th) {
        invoke2(th);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable error) {
        SwapConfirmationViewState swapConfirmationViewState;
        SwapConfirmationViewState copy;
        SwapAsset swapAsset;
        SwapAsset swapAsset2;
        h.c.v0.b bVar;
        h.c.v0.b bVar2;
        kotlin.jvm.internal.m.g(error, "error");
        if (error instanceof AppLockException.UserCancelledException) {
            bVar2 = this.this$0.dismissSubject;
            bVar2.onNext(kotlin.x.a);
        } else if ((error instanceof CompositeException) && ((CompositeException) error).b().contains(SwapMinerFeeException.NotEnoughFunds.INSTANCE)) {
            this.this$0.handleNotEnoughFundsError();
        } else {
            SwapConfirmationError.Error error2 = new SwapConfirmationError.Error(LocalizedStrings.INSTANCE.get(R.string.swap_confirmation_fee_calculation_failed));
            SwapConfirmationViewModel swapConfirmationViewModel = this.this$0;
            swapConfirmationViewState = swapConfirmationViewModel.state;
            copy = swapConfirmationViewState.copy((r34 & 1) != 0 ? swapConfirmationViewState.amountBase : null, (r34 & 2) != 0 ? swapConfirmationViewState.currencyType : null, (r34 & 4) != 0 ? swapConfirmationViewState.cardTitle : null, (r34 & 8) != 0 ? swapConfirmationViewState.isLoading : false, (r34 & 16) != 0 ? swapConfirmationViewState.isConverting : false, (r34 & 32) != 0 ? swapConfirmationViewState.isConvertButtonVisible : false, (r34 & 64) != 0 ? swapConfirmationViewState.targetCurrencyCode : null, (r34 & 128) != 0 ? swapConfirmationViewState.targetImageURL : null, (r34 & 256) != 0 ? swapConfirmationViewState.sourceCryptoAmount : null, (r34 & 512) != 0 ? swapConfirmationViewState.sourceFiatAmount : null, (r34 & 1024) != 0 ? swapConfirmationViewState.targetCryptoAmount : null, (r34 & PKIFailureInfo.wrongIntegrity) != 0 ? swapConfirmationViewState.minerFeeFiatAmount : null, (r34 & 4096) != 0 ? swapConfirmationViewState.minerFeeCryptoAmount : null, (r34 & PKIFailureInfo.certRevoked) != 0 ? swapConfirmationViewState.coinbaseFeeFiatAmount : null, (r34 & 16384) != 0 ? swapConfirmationViewState.coinbaseFeeCryptoAmount : null, (r34 & 32768) != 0 ? swapConfirmationViewState.error : error2);
            swapConfirmationViewModel.setState(copy);
            Analytics analytics = Analytics.INSTANCE;
            AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
            String description = error2.getDescription();
            swapAsset = this.this$0.sourceAsset;
            String code = swapAsset.getCurrencyCode().getCode();
            swapAsset2 = this.this$0.targetAsset;
            analytics.log(AnalyticsEvent_ApplicationKt.swapConfirmErrorReceived(companion, description, code, swapAsset2.getCurrencyCode().getCode()));
            bVar = this.this$0.eventSubject;
            bVar.onNext(SwapConfirmationEvent.ExpandDetails.INSTANCE);
        }
    }
}