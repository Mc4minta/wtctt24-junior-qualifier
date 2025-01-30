package com.coinbase.wallet.features.send.views;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdjustableMinerFeeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeeFragment$setupViewModel$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.x, kotlin.x> {
    final /* synthetic */ AdjustableMinerFeeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFeeFragment$setupViewModel$3(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
        super(1);
        this.this$0 = adjustableMinerFeeFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.x xVar) {
        invoke2(xVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.x xVar) {
        View view = this.this$0.getView();
        View minerFeePresetList = view == null ? null : view.findViewById(e.j.a.minerFeePresetList);
        kotlin.jvm.internal.m.f(minerFeePresetList, "minerFeePresetList");
        minerFeePresetList.setVisibility(0);
        View view2 = this.this$0.getView();
        View retryButton = view2 == null ? null : view2.findViewById(e.j.a.retryButton);
        kotlin.jvm.internal.m.f(retryButton, "retryButton");
        retryButton.setVisibility(8);
        View view3 = this.this$0.getView();
        View errorText = view3 != null ? view3.findViewById(e.j.a.errorText) : null;
        kotlin.jvm.internal.m.f(errorText, "errorText");
        errorText.setVisibility(8);
    }
}