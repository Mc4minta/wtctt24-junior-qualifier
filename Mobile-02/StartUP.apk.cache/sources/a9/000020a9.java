package com.coinbase.wallet.features.send.views;

import android.view.View;
import android.widget.TextView;
import com.coinbase.wallet.features.send.models.SendAmounts;
import kotlin.Metadata;

/* compiled from: ConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendAmounts;", "kotlin.jvm.PlatformType", "sendAmounts", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/SendAmounts;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConfirmationFragment$setupViews$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<SendAmounts, kotlin.x> {
    final /* synthetic */ ConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmationFragment$setupViews$2(ConfirmationFragment confirmationFragment) {
        super(1);
        this.this$0 = confirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(SendAmounts sendAmounts) {
        invoke2(sendAmounts);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SendAmounts sendAmounts) {
        View view = this.this$0.getView();
        ((TextView) (view == null ? null : view.findViewById(e.j.a.t2))).setText(sendAmounts.getFiat());
        View view2 = this.this$0.getView();
        ((TextView) (view2 != null ? view2.findViewById(e.j.a.a1) : null)).setText(sendAmounts.getCrypto());
    }
}