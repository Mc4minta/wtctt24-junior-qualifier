package com.coinbase.wallet.features.lend.views;

import android.view.View;
import android.widget.Button;
import androidx.viewpager.widget.ViewPager;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.lend.models.LendUserAgreementState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: LendUserAgreementFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/lend/models/LendUserAgreementState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendUserAgreementFragment$setupObservers$1 extends o implements l<LendUserAgreementState, x> {
    final /* synthetic */ LendUserAgreementFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendUserAgreementFragment$setupObservers$1(LendUserAgreementFragment lendUserAgreementFragment) {
        super(1);
        this.this$0 = lendUserAgreementFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(LendUserAgreementState lendUserAgreementState) {
        invoke2(lendUserAgreementState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(LendUserAgreementState lendUserAgreementState) {
        View view = this.this$0.getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.startLendingButton))).setText(lendUserAgreementState.getButtonText());
        View view2 = this.this$0.getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.startLendingButton))).setEnabled(lendUserAgreementState.isButtonEnabled());
        View view3 = this.this$0.getView();
        View startLendingButton = view3 == null ? null : view3.findViewById(e.j.a.startLendingButton);
        m.f(startLendingButton, "startLendingButton");
        View_CommonKt.animateOpacity$default(startLendingButton, lendUserAgreementState.isButtonEnabled() ? 1.0f : 0.5f, 300L, null, 4, null);
        int currentPageIndex = lendUserAgreementState.getCurrentPageIndex();
        View view4 = this.this$0.getView();
        if (currentPageIndex != ((ViewPager) (view4 == null ? null : view4.findViewById(e.j.a.introViewPager))).getCurrentItem()) {
            View view5 = this.this$0.getView();
            ((ViewPager) (view5 != null ? view5.findViewById(e.j.a.introViewPager) : null)).setCurrentItem(lendUserAgreementState.getCurrentPageIndex());
        }
    }
}