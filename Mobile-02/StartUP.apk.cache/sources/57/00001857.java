package com.coinbase.wallet.consumer.views;

import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel;
import com.coinbase.wallet.consumer.views.ConsumerWebViewClient;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsumerOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;", "kotlin.jvm.PlatformType", "status", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/views/ConsumerWebViewClient$ConnectionStatus;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerOnboardingFragment$startWebView$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerWebViewClient.ConnectionStatus, kotlin.x> {
    final /* synthetic */ ConsumerOnboardingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingFragment$startWebView$3(ConsumerOnboardingFragment consumerOnboardingFragment) {
        super(1);
        this.this$0 = consumerOnboardingFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerWebViewClient.ConnectionStatus connectionStatus) {
        invoke2(connectionStatus);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerWebViewClient.ConnectionStatus connectionStatus) {
        ConsumerOnboardingViewModel onboardingViewModel;
        if (kotlin.jvm.internal.m.c(connectionStatus, ConsumerWebViewClient.ConnectionStatus.Loaded.INSTANCE)) {
            this.this$0.switchToWebView();
        } else if (kotlin.jvm.internal.m.c(connectionStatus, ConsumerWebViewClient.ConnectionStatus.Connected.INSTANCE)) {
            onboardingViewModel = this.this$0.getOnboardingViewModel();
            onboardingViewModel.setConnectionSuccessful();
        }
    }
}