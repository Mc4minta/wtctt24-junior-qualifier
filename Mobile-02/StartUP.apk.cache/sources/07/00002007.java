package com.coinbase.wallet.features.send.viewmodels;

import androidx.navigation.p;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.interfaces.SignedTx;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.common.models.UserProperties;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/coinbase/wallet/blockchains/interfaces/SignedTx;", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendConfirmationViewModel$confirmLend$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends SignedTx>, kotlin.x> {
    final /* synthetic */ LendConfirmationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LendConfirmationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel$confirmLend$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
        final /* synthetic */ LendConfirmationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LendConfirmationViewModel lendConfirmationViewModel) {
            super(1);
            this.this$0 = lendConfirmationViewModel;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
            invoke2(xVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(kotlin.x xVar) {
            List g2;
            h.c.v0.b bVar;
            Analytics.INSTANCE.setUserProperties(UserProperties.INSTANCE.getLendActivated());
            LendConfirmationViewModel lendConfirmationViewModel = this.this$0;
            g2 = kotlin.a0.r.g();
            lendConfirmationViewModel.lendingTxs = g2;
            androidx.navigation.p a = new p.a().g(R.id.lendInterstitialFragment, false).a();
            kotlin.jvm.internal.m.f(a, "Builder()\n                                    .setPopUpTo(R.id.lendInterstitialFragment, false)\n                                    .build()");
            ViewModelNavRoute viewModelNavRoute = new ViewModelNavRoute(R.id.action_confirmationFragment_to_lendDashboardFragment, this.this$0.getArgs(), a);
            bVar = this.this$0.navigateToSendCompleteViewSubject;
            bVar.onNext(viewModelNavRoute);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendConfirmationViewModel$confirmLend$2(LendConfirmationViewModel lendConfirmationViewModel) {
        super(1);
        this.this$0 = lendConfirmationViewModel;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(List<? extends SignedTx> list) {
        invoke2(list);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends SignedTx> list) {
        TransferValue amount;
        ILendRepository iLendRepository;
        h.c.a0 mainScheduler;
        Analytics analytics = Analytics.INSTANCE;
        AnalyticsEvent.Companion companion = AnalyticsEvent.Companion;
        amount = this.this$0.getAmount();
        analytics.log(AnalyticsEvent_ApplicationKt.lendConfirmationTxSubmitted(companion, amount.isMax()));
        iLendRepository = this.this$0.lendRepository;
        h.c.b0<kotlin.x> refresh = iLendRepository.refresh(true);
        mainScheduler = this.this$0.getMainScheduler();
        h.c.b0<kotlin.x> observeOn = refresh.observeOn(mainScheduler);
        kotlin.jvm.internal.m.f(observeOn, "lendRepository.refresh(true)\n                        .observeOn(mainScheduler)");
        h.c.t0.g.i(Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null), null, new AnonymousClass1(this.this$0), 1, null);
    }
}