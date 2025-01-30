package com.coinbase.wallet.features.send.views.adapters;

import android.view.View;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: AdjustableMinerFeePresetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFeePresetAdapter$MinerFeePresetHolder$bind$1 extends o implements l<View, x> {
    final /* synthetic */ l<AdjustableMinerFeeViewInfoState, x> $onItemClickListener;
    final /* synthetic */ AdjustableMinerFeeViewInfoState $presetInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdjustableMinerFeePresetAdapter$MinerFeePresetHolder$bind$1(l<? super AdjustableMinerFeeViewInfoState, x> lVar, AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState) {
        super(1);
        this.$onItemClickListener = lVar;
        this.$presetInfo = adjustableMinerFeeViewInfoState;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        m.g(it, "it");
        this.$onItemClickListener.invoke(this.$presetInfo);
    }
}