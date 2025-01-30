package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.features.send.models.MinerFee1559Data;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFee1559Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/o;", "", "Lcom/coinbase/wallet/features/send/models/MinerFee1559Data;", "kotlin.jvm.PlatformType", "<name for destructuring parameter 0>", "Lkotlin/x;", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFee1559Fragment$onViewCreated$7 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<kotlin.o<? extends String, ? extends MinerFee1559Data>, kotlin.x> {
    final /* synthetic */ AdjustableMinerFee1559Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFee1559Fragment$onViewCreated$7(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
        super(1);
        this.this$0 = adjustableMinerFee1559Fragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(kotlin.o<? extends String, ? extends MinerFee1559Data> oVar) {
        invoke2((kotlin.o<String, MinerFee1559Data>) oVar);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<String, MinerFee1559Data> oVar) {
        String a = oVar.a();
        MinerFee1559Data b2 = oVar.b();
        try {
            Fragment_CommonKt.setNavigationResult(this.this$0, a, b2);
        } catch (Throwable unused) {
            AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment = this.this$0;
            androidx.lifecycle.b0 a2 = new androidx.lifecycle.d0(adjustableMinerFee1559Fragment.requireActivity(), adjustableMinerFee1559Fragment.getAdjustableMinerFeeSharedFactory()).a(AdjustableMinerFeeSharedViewModel.class);
            kotlin.jvm.internal.m.f(a2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
            ((AdjustableMinerFeeSharedViewModel) a2).sendResult(b2);
        }
        this.this$0.dismiss();
    }
}