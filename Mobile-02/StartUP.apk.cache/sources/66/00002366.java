package com.coinbase.wallet.features.wallets.viewmodels;

import android.content.DialogInterface;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.consumer.models.ConsumerConnectionStatus;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionItemsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "dialog", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ActionItemsViewModel$getFundActionSheetProperties$1$actions$1 extends o implements kotlin.e0.c.l<DialogInterface, x> {
    final /* synthetic */ ConsumerConnectionStatus $connectStatus;
    final /* synthetic */ boolean $isOnrampEnabled;
    final /* synthetic */ ActionItemsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionItemsViewModel$getFundActionSheetProperties$1$actions$1(ConsumerConnectionStatus consumerConnectionStatus, ActionItemsViewModel actionItemsViewModel, boolean z) {
        super(1);
        this.$connectStatus = consumerConnectionStatus;
        this.this$0 = actionItemsViewModel;
        this.$isOnrampEnabled = z;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface dialog) {
        h.c.v0.b bVar;
        kotlin.jvm.internal.m.g(dialog, "dialog");
        dialog.dismiss();
        ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_walletFragment_to_consumerNavGraph, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, true, this.$connectStatus, null, false, 12, null), Fragment_CommonKt.getHoldNavOptions(this.this$0));
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.walletsFundActionConsumerTapped(AnalyticsEvent.Companion, this.$isOnrampEnabled));
        bVar = this.this$0.navigationSubject;
        bVar.onNext(viewModelNavRoute);
    }
}