package com.coinbase.wallet.features.swap.views;

import androidx.navigation.p;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.NavController_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwapInterstitialFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00032F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "Lkotlin/x;", "<name for destructuring parameter 0>", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapInterstitialFragment$onViewCreated$1 extends o implements l<kotlin.o<? extends ViewModelNavRoute, ? extends x>, x> {
    final /* synthetic */ SwapInterstitialFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapInterstitialFragment$onViewCreated$1(SwapInterstitialFragment swapInterstitialFragment) {
        super(1);
        this.this$0 = swapInterstitialFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends ViewModelNavRoute, ? extends x> oVar) {
        invoke2((kotlin.o<ViewModelNavRoute, x>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<ViewModelNavRoute, x> oVar) {
        SwapInterstitialViewModel viewModel;
        p a;
        ViewModelNavRoute a2 = oVar.a();
        viewModel = this.this$0.getViewModel();
        if (viewModel.getHasSharedElementTransition()) {
            a = Fragment_CommonKt.getFadeInNavOptions(this.this$0);
        } else {
            a = NavController_CommonKt.getVerticalNavOptionsBuilder().g(R.id.swapInterstitialFragment, true).a();
            m.f(a, "{\n                    verticalNavOptionsBuilder\n                        .setPopUpTo(R.id.swapInterstitialFragment, true)\n                        .build()\n                }");
        }
        Fragment_CommonKt.navigate$default(this.this$0, a2.getResourceId(), a2.getArgs(), a, null, 8, null);
    }
}