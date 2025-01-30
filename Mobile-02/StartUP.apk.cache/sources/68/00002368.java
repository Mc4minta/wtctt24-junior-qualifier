package com.coinbase.wallet.features.wallets.viewmodels;

import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionItemsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ActionItemsViewModel$onLendItemClick$1 extends o implements kotlin.e0.c.l<Wallet, x> {
    final /* synthetic */ ActionItemsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionItemsViewModel$onLendItemClick$1(ActionItemsViewModel actionItemsViewModel) {
        super(1);
        this.this$0 = actionItemsViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Wallet wallet) {
        invoke2(wallet);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Wallet wallet) {
        h.c.v0.b bVar;
        h.c.v0.b bVar2;
        kotlin.jvm.internal.m.g(wallet, "wallet");
        if (wallet.getNetwork().isTestnet()) {
            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.lendEarnInterestTestnet(AnalyticsEvent.Companion));
            bVar2 = this.this$0.testNetDialogSubject;
            bVar2.onNext(x.a);
            return;
        }
        ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_walletFragment_to_lendInterstitialFragment, null, Fragment_CommonKt.getHoldNavOptions(this.this$0), 2, null);
        bVar = this.this$0.navigationSubject;
        bVar.onNext(viewModelNavRoute);
    }
}