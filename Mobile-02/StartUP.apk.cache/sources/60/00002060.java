package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFee1559Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "maxPriorityFee", "maxBaseFee", "gasLimit", AdjustableMinerFeeArgs.NONCE, "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFee1559Fragment$onViewCreated$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.r<String, String, String, String, kotlin.x> {
    final /* synthetic */ AdjustableMinerFee1559Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFee1559Fragment$onViewCreated$4(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
        super(4);
        this.this$0 = adjustableMinerFee1559Fragment;
    }

    @Override // kotlin.e0.c.r
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str, String str2, String str3, String str4) {
        invoke2(str, str2, str3, str4);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str, String str2, String str3, String str4) {
        AdjustableMinerFee1559ViewModel viewModel;
        viewModel = this.this$0.getViewModel();
        viewModel.customValueChanged(str, str2, str3, str4);
    }
}