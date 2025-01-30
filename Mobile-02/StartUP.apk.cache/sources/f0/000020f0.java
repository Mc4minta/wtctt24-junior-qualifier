package com.coinbase.wallet.features.send.views.adapters;

import android.view.View;
import com.coinbase.wallet.features.send.models.SendDestinationPickerRow;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SendDestinationAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SendDestinationAdapter$onBindViewHolder$1 extends o implements l<View, x> {
    final /* synthetic */ SendDestinationPickerRow $viewModel;
    final /* synthetic */ SendDestinationAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendDestinationAdapter$onBindViewHolder$1(SendDestinationPickerRow sendDestinationPickerRow, SendDestinationAdapter sendDestinationAdapter) {
        super(1);
        this.$viewModel = sendDestinationPickerRow;
        this.this$0 = sendDestinationAdapter;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.this$0.onSendDestinationClickListener;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(android.view.View r2) {
        /*
            r1 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.m.g(r2, r0)
            com.coinbase.wallet.features.send.models.SendDestinationPickerRow r2 = r1.$viewModel
            boolean r2 = r2 instanceof com.coinbase.wallet.features.send.models.SendDestinationPickerRow.Destination
            if (r2 == 0) goto L19
            com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter r2 = r1.this$0
            kotlin.e0.c.l r2 = com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter.access$getOnSendDestinationClickListener$p(r2)
            if (r2 != 0) goto L14
            goto L19
        L14:
            com.coinbase.wallet.features.send.models.SendDestinationPickerRow r0 = r1.$viewModel
            r2.invoke(r0)
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter$onBindViewHolder$1.invoke2(android.view.View):void");
    }
}