package com.coinbase.wallet.features.send.views;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AmountPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountPickerFragment$setupOnClickListeners$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, kotlin.x> {
    final /* synthetic */ AmountPickerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountPickerFragment$setupOnClickListeners$4(AmountPickerFragment amountPickerFragment) {
        super(1);
        this.this$0 = amountPickerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(View view) {
        invoke2(view);
        return kotlin.x.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
        if ((r5.getVisibility() == 0) == true) goto L10;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(android.view.View r5) {
        /*
            r4 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.m.g(r5, r0)
            com.coinbase.wallet.features.send.views.AmountPickerFragment r5 = r4.this$0
            com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel r5 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getViewModel$p(r5)
            r0 = 0
            java.lang.String r1 = "viewModel"
            if (r5 == 0) goto L45
            com.coinbase.wallet.features.send.models.AmountPickerSettings r5 = r5.getSettings()
            boolean r5 = r5.isSliderEnabled()
            if (r5 != 0) goto L1b
            return
        L1b:
            com.coinbase.wallet.features.send.views.AmountPickerFragment r5 = r4.this$0
            com.coinbase.wallet.features.commonui.views.AmountSliderView r5 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getAmountSliderView$p(r5)
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L27
        L25:
            r2 = r3
            goto L32
        L27:
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L2f
            r5 = r2
            goto L30
        L2f:
            r5 = r3
        L30:
            if (r5 != r2) goto L25
        L32:
            if (r2 == 0) goto L44
            com.coinbase.wallet.features.send.views.AmountPickerFragment r5 = r4.this$0
            com.coinbase.wallet.features.send.viewmodels.AmountPickerViewModel r5 = com.coinbase.wallet.features.send.views.AmountPickerFragment.access$getViewModel$p(r5)
            if (r5 == 0) goto L40
            r5.onSliderToggled()
            goto L44
        L40:
            kotlin.jvm.internal.m.w(r1)
            throw r0
        L44:
            return
        L45:
            kotlin.jvm.internal.m.w(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.AmountPickerFragment$setupOnClickListeners$4.invoke2(android.view.View):void");
    }
}