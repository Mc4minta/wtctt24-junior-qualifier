package com.coinbase.wallet.features.lend.views;

import androidx.navigation.p;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LendUserAgreementFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "routeArgs", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendUserAgreementFragment$setupObservers$2 extends o implements l<ViewModelNavRoute, x> {
    final /* synthetic */ LendUserAgreementFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendUserAgreementFragment$setupObservers$2(LendUserAgreementFragment lendUserAgreementFragment) {
        super(1);
        this.this$0 = lendUserAgreementFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(ViewModelNavRoute viewModelNavRoute) {
        invoke2(viewModelNavRoute);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ViewModelNavRoute viewModelNavRoute) {
        p a = Fragment_CommonKt.getFadeInNavOptionsBuilder(this.this$0).g(R.id.lendUserAgreementFragment, true).a();
        m.f(a, "fadeInNavOptionsBuilder\n                    .setPopUpTo(R.id.lendUserAgreementFragment, true)\n                    .build()");
        Fragment_CommonKt.navigate$default(this.this$0, viewModelNavRoute.getResourceId(), viewModelNavRoute.getArgs(), a, null, 8, null);
    }
}