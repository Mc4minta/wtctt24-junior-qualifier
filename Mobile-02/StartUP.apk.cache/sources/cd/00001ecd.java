package com.coinbase.wallet.features.lend.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.features.lend.models.LendDashboardState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendDashboardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/lend/models/LendDashboardState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/lend/models/LendDashboardState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendDashboardFragment$onViewCreated$7 extends o implements l<LendDashboardState, x> {
    final /* synthetic */ LendDashboardFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendDashboardFragment$onViewCreated$7(LendDashboardFragment lendDashboardFragment) {
        super(1);
        this.this$0 = lendDashboardFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(LendDashboardState lendDashboardState) {
        invoke2(lendDashboardState);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(LendDashboardState lendDashboardState) {
        View view = this.this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.K6))).setText(LocalizedStrings.INSTANCE.get(R.string.lend_balance_toolbar, lendDashboardState.getBalance()));
        View view2 = this.this$0.getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.A6))).setText(lendDashboardState.getInterestAPRTitle());
        View view3 = this.this$0.getView();
        ((TextView) (view3 != null ? view3.findViewById(e.j.a.earnedInterest) : null)).setText(lendDashboardState.getLifetimeInterestEarned());
        if (lendDashboardState.getShowLendingActionSheet()) {
            this.this$0.showLendingActionSheet();
        } else {
            this.this$0.hideLendingActionSheet();
        }
    }
}