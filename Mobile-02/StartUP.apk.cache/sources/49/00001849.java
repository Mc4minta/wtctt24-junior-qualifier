package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.models.AppToAppResult;
import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel;
import kotlin.Metadata;

/* compiled from: ConsumerOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/AppToAppResult;", "kotlin.jvm.PlatformType", "appToAppStatus", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/AppToAppResult;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerOnboardingFragment$onActivityResult$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AppToAppResult, kotlin.x> {
    final /* synthetic */ ConsumerOnboardingFragment this$0;

    /* compiled from: ConsumerOnboardingFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppToAppResult.values().length];
            iArr[AppToAppResult.DISABLED.ordinal()] = 1;
            iArr[AppToAppResult.SUCCESS.ordinal()] = 2;
            iArr[AppToAppResult.ERROR.ordinal()] = 3;
            iArr[AppToAppResult.USER_CANCELLED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingFragment$onActivityResult$1(ConsumerOnboardingFragment consumerOnboardingFragment) {
        super(1);
        this.this$0 = consumerOnboardingFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(AppToAppResult appToAppResult) {
        invoke2(appToAppResult);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AppToAppResult appToAppResult) {
        ConsumerOnboardingViewModel onboardingViewModel;
        ConsumerOnboardingViewModel onboardingViewModel2;
        int i2 = appToAppResult == null ? -1 : WhenMappings.$EnumSwitchMapping$0[appToAppResult.ordinal()];
        if (i2 != -1) {
            if (i2 == 1) {
                this.this$0.startWebView(true);
                return;
            } else if (i2 == 2) {
                onboardingViewModel2 = this.this$0.getOnboardingViewModel();
                onboardingViewModel2.setConnectionSuccessful();
                return;
            } else if (i2 == 3) {
                this.this$0.startWebView(true);
                return;
            } else if (i2 != 4) {
                return;
            }
        }
        onboardingViewModel = this.this$0.getOnboardingViewModel();
        onboardingViewModel.onBackPressed();
    }
}