package com.coinbase.wallet.features.lend.views;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import h.c.a0;
import h.c.b0;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LendUserAgreementFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendUserAgreementFragment$setupClickListeners$2 extends o implements l<View, x> {
    final /* synthetic */ LendUserAgreementFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendUserAgreementFragment$setupClickListeners$2(LendUserAgreementFragment lendUserAgreementFragment) {
        super(1);
        this.this$0 = lendUserAgreementFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        a0 mainScheduler;
        FragmentLifecycleScopeProvider scopeProvider;
        m.g(it, "it");
        if (this.this$0.getViewModel().getState().getShouldProceedToLending()) {
            b0<x> proceedToLendFlow = this.this$0.getViewModel().proceedToLendFlow();
            mainScheduler = this.this$0.getMainScheduler();
            b0<x> observeOn = proceedToLendFlow.observeOn(mainScheduler);
            scopeProvider = this.this$0.getScopeProvider();
            Object as = observeOn.as(com.uber.autodispose.d.a(scopeProvider));
            m.f(as, "viewModel.proceedToLendFlow()\n                    .observeOn(mainScheduler)\n                    .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, null, 3, null);
            return;
        }
        View view = this.this$0.getView();
        ((ViewPager) (view != null ? view.findViewById(e.j.a.introViewPager) : null)).setCurrentItem(1);
    }
}