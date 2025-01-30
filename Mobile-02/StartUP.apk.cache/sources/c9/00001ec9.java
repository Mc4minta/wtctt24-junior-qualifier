package com.coinbase.wallet.features.lend.views;

import android.view.View;
import android.widget.FrameLayout;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendDashboardFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"com/coinbase/wallet/features/lend/views/LendDashboardFragment$onViewCreated$13", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$c;", "Landroid/view/View;", "p0", "", "percent", "Lkotlin/x;", "onSlide", "(Landroid/view/View;F)V", "", ApiConstants.STATE, "onStateChanged", "(Landroid/view/View;I)V", "", "dragging", "Z", "getDragging", "()Z", "setDragging", "(Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendDashboardFragment$onViewCreated$13 extends BottomSheetBehavior.c {
    private boolean dragging;
    final /* synthetic */ LendDashboardFragment this$0;

    public LendDashboardFragment$onViewCreated$13(LendDashboardFragment lendDashboardFragment) {
        this.this$0 = lendDashboardFragment;
    }

    public static /* synthetic */ void a(LendDashboardFragment lendDashboardFragment, View view) {
        m1293onStateChanged$lambda0(lendDashboardFragment, view);
    }

    /* renamed from: onStateChanged$lambda-0 */
    public static final void m1293onStateChanged$lambda0(LendDashboardFragment this$0, View view) {
        LendDashboardViewModel lendDashboardViewModel;
        m.g(this$0, "this$0");
        lendDashboardViewModel = this$0.viewModel;
        if (lendDashboardViewModel != null) {
            lendDashboardViewModel.hideLendingActionSheet();
        } else {
            m.w("viewModel");
            throw null;
        }
    }

    public final boolean getDragging() {
        return this.dragging;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
    public void onSlide(View p0, float f2) {
        m.g(p0, "p0");
        if (this.dragging) {
            View view = this.this$0.getView();
            ((FrameLayout) (view == null ? null : view.findViewById(e.j.a.lendBottomSheetBackground))).setAlpha(f2);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
    public void onStateChanged(View p0, int i2) {
        LendDashboardViewModel lendDashboardViewModel;
        m.g(p0, "p0");
        View view = this.this$0.getView();
        if ((view == null ? null : view.findViewById(e.j.a.lendBottomSheetBackground)) == null) {
            return;
        }
        this.dragging = i2 == 1;
        if (i2 == 3) {
            View view2 = this.this$0.getView();
            View findViewById = view2 == null ? null : view2.findViewById(e.j.a.lendBottomSheetBackground);
            final LendDashboardFragment lendDashboardFragment = this.this$0;
            ((FrameLayout) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.lend.views.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LendDashboardFragment$onViewCreated$13.a(LendDashboardFragment.this, view3);
                }
            });
            View view3 = this.this$0.getView();
            ((FrameLayout) (view3 != null ? view3.findViewById(e.j.a.lendBottomSheetBackground) : null)).setAlpha(1.0f);
        } else if (i2 != 4) {
        } else {
            View view4 = this.this$0.getView();
            View findViewById2 = view4 == null ? null : view4.findViewById(e.j.a.lendBottomSheetBackground);
            int i3 = e.j.a.lendBottomSheetBackground;
            ((FrameLayout) ((FrameLayout) findViewById2).findViewById(i3)).setClickable(false);
            View view5 = this.this$0.getView();
            ((FrameLayout) (view5 == null ? null : view5.findViewById(i3))).setAlpha(0.0f);
            lendDashboardViewModel = this.this$0.viewModel;
            if (lendDashboardViewModel != null) {
                lendDashboardViewModel.hideLendingActionSheet();
            } else {
                m.w("viewModel");
                throw null;
            }
        }
    }

    public final void setDragging(boolean z) {
        this.dragging = z;
    }
}