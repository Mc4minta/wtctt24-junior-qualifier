package com.coinbase.wallet.features.send.views;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewState;
import com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFee1559PresetAdapter;
import java.util.List;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFee1559Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;", "kotlin.jvm.PlatformType", ApiConstants.STATE, "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewState;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFee1559Fragment$onViewCreated$6 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<AdjustableMinerFee1559ViewState, kotlin.x> {
    final /* synthetic */ AdjustableMinerFee1559Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFee1559Fragment$onViewCreated$6(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
        super(1);
        this.this$0 = adjustableMinerFee1559Fragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(AdjustableMinerFee1559ViewState adjustableMinerFee1559ViewState) {
        invoke2(adjustableMinerFee1559ViewState);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(AdjustableMinerFee1559ViewState adjustableMinerFee1559ViewState) {
        AdjustableMinerFee1559PresetAdapter adjustableMinerFee1559PresetAdapter;
        List<? extends AdjustableMinerFee1559ViewInfoState> j2;
        adjustableMinerFee1559PresetAdapter = this.this$0.adjustableAdjustableMinerFeeAdapter;
        if (adjustableMinerFee1559PresetAdapter == null) {
            kotlin.jvm.internal.m.w("adjustableAdjustableMinerFeeAdapter");
            throw null;
        }
        j2 = kotlin.a0.r.j(adjustableMinerFee1559ViewState.getSlowPresetInfo(), adjustableMinerFee1559ViewState.getNormalPresetInfo(), adjustableMinerFee1559ViewState.getFastPresetInfo(), adjustableMinerFee1559ViewState.getCustomPresetInfo());
        adjustableMinerFee1559PresetAdapter.updateMinerFeeInfo(j2);
    }
}