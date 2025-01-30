package com.coinbase.wallet.features.wallets.views;

import android.os.Bundle;
import androidx.navigation.fragment.b;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WalletsTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "navRoute", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletsTabFragment$setupObservers$4 extends o implements l<ViewModelNavRoute, x> {
    final /* synthetic */ WalletsTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletsTabFragment$setupObservers$4(WalletsTabFragment walletsTabFragment) {
        super(1);
        this.this$0 = walletsTabFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(ViewModelNavRoute viewModelNavRoute) {
        invoke2(viewModelNavRoute);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ViewModelNavRoute viewModelNavRoute) {
        b.C0036b c0036b;
        int resourceId = viewModelNavRoute.getResourceId();
        Bundle args = viewModelNavRoute.getArgs();
        c0036b = this.this$0.fragmentNavigatorExtras;
        Fragment_CommonKt.navigate(this.this$0, resourceId, args, viewModelNavRoute.getNavOptions(), c0036b);
    }
}