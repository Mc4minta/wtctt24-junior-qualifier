package com.coinbase.wallet.features.swap.views;

import android.view.View;
import com.coinbase.wallet.common.extensions.SafeWhen_CommonKt;
import com.coinbase.wallet.features.swap.models.SwapConfirmationEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwapConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;", "kotlin.jvm.PlatformType", "event", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/swap/models/SwapConfirmationEvent;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapConfirmationFragment$setupObservables$2 extends o implements l<SwapConfirmationEvent, x> {
    final /* synthetic */ SwapConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapConfirmationFragment$setupObservables$2(SwapConfirmationFragment swapConfirmationFragment) {
        super(1);
        this.this$0 = swapConfirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(SwapConfirmationEvent swapConfirmationEvent) {
        invoke2(swapConfirmationEvent);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SwapConfirmationEvent swapConfirmationEvent) {
        if (m.c(swapConfirmationEvent, SwapConfirmationEvent.ToggleDetails.INSTANCE)) {
            SwapConfirmationFragment swapConfirmationFragment = this.this$0;
            View view = swapConfirmationFragment.getView();
            View detailsTab = view == null ? null : view.findViewById(e.j.a.J1);
            m.f(detailsTab, "detailsTab");
            swapConfirmationFragment.updateDetailsView(!(detailsTab.getVisibility() == 0));
        } else if (m.c(swapConfirmationEvent, SwapConfirmationEvent.ExpandDetails.INSTANCE)) {
            this.this$0.updateDetailsView(true);
        } else if (m.c(swapConfirmationEvent, SwapConfirmationEvent.CollapseDetails.INSTANCE)) {
            this.this$0.updateDetailsView(false);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        SafeWhen_CommonKt.getSafe(x.a);
    }
}