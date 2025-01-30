package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import kotlin.Metadata;

/* compiled from: ConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "navRoute", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConfirmationFragment$onViewCreated$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ViewModelNavRoute, kotlin.x> {
    final /* synthetic */ ConfirmationFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmationFragment$onViewCreated$2(ConfirmationFragment confirmationFragment) {
        super(1);
        this.this$0 = confirmationFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ kotlin.x invoke(ViewModelNavRoute viewModelNavRoute) {
        invoke2(viewModelNavRoute);
        return kotlin.x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ViewModelNavRoute viewModelNavRoute) {
        Fragment_CommonKt.navigate$default(this.this$0, viewModelNavRoute.getResourceId(), viewModelNavRoute.getArgs(), viewModelNavRoute.getNavOptions(), null, 8, null);
    }
}