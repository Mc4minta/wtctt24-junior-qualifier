package com.coinbase.wallet.consumer.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsState;
import com.coinbase.wallet.consumer.views.adapter.TransferMethodsAdapter;
import kotlin.Metadata;

/* compiled from: ConsumerTransferMethodsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConsumerTransferMethodsFragment$onViewCreated$5 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ConsumerTransferMethodsState, kotlin.x> {
    final /* synthetic */ ConsumerTransferMethodsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferMethodsFragment$onViewCreated$5(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
        super(1);
        this.this$0 = consumerTransferMethodsFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ConsumerTransferMethodsState consumerTransferMethodsState) {
        invoke2(consumerTransferMethodsState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ConsumerTransferMethodsState consumerTransferMethodsState) {
        TransferMethodsAdapter transferMethodsAdapter;
        View view = this.this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(R.id.transferMethodHeader))).setText(consumerTransferMethodsState.getTitle());
        View view2 = this.this$0.getView();
        ((TextView) (view2 == null ? null : view2.findViewById(R.id.transferMethodSubtitle))).setText(consumerTransferMethodsState.getDescription());
        transferMethodsAdapter = this.this$0.transferMethodAdapter;
        if (transferMethodsAdapter != null) {
            transferMethodsAdapter.submitList(consumerTransferMethodsState.getTransferMethodOptions());
        } else {
            kotlin.jvm.internal.m.w("transferMethodAdapter");
            throw null;
        }
    }
}