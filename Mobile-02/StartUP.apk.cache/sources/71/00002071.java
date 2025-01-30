package com.coinbase.wallet.features.send.views;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewState;
import com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter;
import java.util.List;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFeeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFeeFragment$onViewCreated$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AdjustableMinerFeeViewState, kotlin.x> {
    final /* synthetic */ AdjustableMinerFeeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFeeFragment$onViewCreated$6(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
        super(1);
        this.this$0 = adjustableMinerFeeFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(AdjustableMinerFeeViewState adjustableMinerFeeViewState) {
        invoke2(adjustableMinerFeeViewState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AdjustableMinerFeeViewState adjustableMinerFeeViewState) {
        AdjustableMinerFeePresetAdapter adjustableMinerFeePresetAdapter;
        List<? extends AdjustableMinerFeeViewInfoState> j2;
        adjustableMinerFeePresetAdapter = this.this$0.adjustableAdjustableMinerFeeAdapter;
        if (adjustableMinerFeePresetAdapter == null) {
            kotlin.jvm.internal.m.w("adjustableAdjustableMinerFeeAdapter");
            throw null;
        }
        j2 = kotlin.a0.r.j(adjustableMinerFeeViewState.getSlowPresetInfo(), adjustableMinerFeeViewState.getNormalPresetInfo(), adjustableMinerFeeViewState.getFastPresetInfo(), adjustableMinerFeeViewState.getCustomPresetInfo());
        adjustableMinerFeePresetAdapter.updateMinerFeeInfo(j2);
    }
}