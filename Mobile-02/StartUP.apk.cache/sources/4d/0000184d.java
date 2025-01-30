package com.coinbase.wallet.consumer.views;

import android.view.View;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel;
import com.uber.autodispose.a0;
import h.c.b0;
import kotlin.Metadata;

/* compiled from: ConsumerOnboardingFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerOnboardingFragment$onViewCreated$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ ConsumerOnboardingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConsumerOnboardingFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.consumer.views.ConsumerOnboardingFragment$onViewCreated$3$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
            invoke2(xVar);
            return kotlin.x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(kotlin.x xVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerOnboardingFragment$onViewCreated$3(ConsumerOnboardingFragment consumerOnboardingFragment) {
        super(1);
        this.this$0 = consumerOnboardingFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        ConsumerOnboardingViewModel onboardingViewModel;
        com.uber.autodispose.y scopeProvider;
        kotlin.jvm.internal.m.g(it, "it");
        onboardingViewModel = this.this$0.getOnboardingViewModel();
        b0<kotlin.x> onSecondaryButtonClicked = onboardingViewModel.onSecondaryButtonClicked();
        scopeProvider = this.this$0.getScopeProvider();
        Object as = onSecondaryButtonClicked.as(com.uber.autodispose.d.a(scopeProvider));
        kotlin.jvm.internal.m.f(as, "onboardingViewModel.onSecondaryButtonClicked()\n                .`as`(AutoDispose.autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, AnonymousClass1.INSTANCE, 1, null);
    }
}