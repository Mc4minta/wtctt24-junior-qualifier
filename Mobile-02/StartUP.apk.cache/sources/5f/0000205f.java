package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFee1559Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "it", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFee1559Fragment$onViewCreated$3 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AdjustableMinerFee1559ViewInfoState, kotlin.x> {
    final /* synthetic */ AdjustableMinerFee1559Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFee1559Fragment$onViewCreated$3(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
        super(1);
        this.this$0 = adjustableMinerFee1559Fragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState) {
        invoke2(adjustableMinerFee1559ViewInfoState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AdjustableMinerFee1559ViewInfoState it) {
        AdjustableMinerFee1559ViewModel viewModel;
        FragmentLifecycleScopeProvider scopeProvider;
        kotlin.jvm.internal.m.g(it, "it");
        viewModel = this.this$0.getViewModel();
        h.c.b0<kotlin.x> presetSelected = viewModel.presetSelected(it.getPresetSpeed());
        scopeProvider = this.this$0.getScopeProvider();
        ((com.uber.autodispose.a0) presetSelected.as(com.uber.autodispose.d.a(scopeProvider))).subscribe();
    }
}