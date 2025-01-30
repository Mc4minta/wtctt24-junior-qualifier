package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel;
import kotlin.Metadata;

/* compiled from: AdjustableMinerFeeFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "gasPrice", "gasLimit", AdjustableMinerFeeArgs.NONCE, "Lkotlin/x;", "<anonymous>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class AdjustableMinerFeeFragment$onViewCreated$4 extends kotlin.jvm.internal.o implements kotlin.e0.c.q<String, String, String, kotlin.x> {
    final /* synthetic */ AdjustableMinerFeeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustableMinerFeeFragment$onViewCreated$4(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
        super(3);
        this.this$0 = adjustableMinerFeeFragment;
    }

    @Override // kotlin.e0.c.q
    public /* bridge */ /* synthetic */ kotlin.x invoke(String str, String str2, String str3) {
        invoke2(str, str2, str3);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str, String str2, String str3) {
        AdjustableMinerFeeViewModel viewModel;
        FragmentLifecycleScopeProvider scopeProvider;
        viewModel = this.this$0.getViewModel();
        h.c.b0<kotlin.x> customValueChanged = viewModel.customValueChanged(str, str2, str3);
        scopeProvider = this.this$0.getScopeProvider();
        ((com.uber.autodispose.a0) customValueChanged.as(com.uber.autodispose.d.a(scopeProvider))).subscribe();
    }
}