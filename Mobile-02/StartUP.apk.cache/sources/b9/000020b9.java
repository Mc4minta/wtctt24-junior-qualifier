package com.coinbase.wallet.features.send.views;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerFragment$setupObservables$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
    final /* synthetic */ SendDestinationPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationPickerFragment$setupObservables$6(SendDestinationPickerFragment sendDestinationPickerFragment) {
        super(1);
        this.this$0 = sendDestinationPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
        invoke2(xVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.x xVar) {
        SendDestinationAdapter sendDestinationAdapter;
        SendDestinationPickerViewModel sendDestinationPickerViewModel;
        SendDestinationPickerViewModel sendDestinationPickerViewModel2;
        sendDestinationAdapter = this.this$0.adapter;
        if (sendDestinationAdapter == null) {
            kotlin.jvm.internal.m.w("adapter");
            throw null;
        }
        sendDestinationPickerViewModel = this.this$0.viewModel;
        if (sendDestinationPickerViewModel != null) {
            sendDestinationAdapter.setItems(sendDestinationPickerViewModel.getSections());
            sendDestinationPickerViewModel2 = this.this$0.viewModel;
            if (sendDestinationPickerViewModel2 != null) {
                boolean z = !sendDestinationPickerViewModel2.getSections().isEmpty();
                View view = this.this$0.getView();
                ((RecyclerView) (view == null ? null : view.findViewById(e.j.a.recyclerView))).setVisibility(z ? 0 : 4);
                View view2 = this.this$0.getView();
                ((ConstraintLayout) (view2 != null ? view2.findViewById(e.j.a.emptyStateContainerView) : null)).setVisibility(z ? 4 : 0);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}