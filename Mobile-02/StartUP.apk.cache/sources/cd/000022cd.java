package com.coinbase.wallet.features.swap.views;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.coinbase.wallet.commonui.views.ProgressBarButton;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lkotlin/x;", "<anonymous>", "(J)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationFragment$handleErrorState$1 extends o implements l<Long, x> {
    final /* synthetic */ SwapConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationFragment$handleErrorState$1(SwapConfirmationFragment swapConfirmationFragment) {
        super(1);
        this.this$0 = swapConfirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Long l2) {
        invoke2(l2);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Long l2) {
        long shortAnimDuration;
        View view = this.this$0.getView();
        ViewPropertyAnimator alpha = ((ProgressBarButton) (view == null ? null : view.findViewById(e.j.a.convertButton))).animate().alpha(1.0f);
        shortAnimDuration = this.this$0.getShortAnimDuration();
        alpha.setDuration(shortAnimDuration);
        View view2 = this.this$0.getView();
        ((ProgressBarButton) (view2 == null ? null : view2.findViewById(e.j.a.convertButton))).setProgressBarText(this.this$0.getString(R.string.swap_confirmation_high_price_impact_convert_anyway));
        View view3 = this.this$0.getView();
        ((ProgressBarButton) (view3 != null ? view3.findViewById(e.j.a.convertButton) : null)).setClickable(true);
    }
}