package com.coinbase.wallet.features.swap.views;

import android.view.View;
import androidx.navigation.p;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel;
import com.uber.autodispose.a0;
import com.uber.autodispose.d;
import com.uber.autodispose.y;
import h.c.b0;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwapDisclaimerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapDisclaimerFragment$onViewCreated$2 extends o implements l<View, x> {
    final /* synthetic */ SwapDisclaimerFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwapDisclaimerFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "route", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.features.swap.views.SwapDisclaimerFragment$onViewCreated$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends o implements l<ViewModelNavRoute, x> {
        final /* synthetic */ SwapDisclaimerFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SwapDisclaimerFragment swapDisclaimerFragment) {
            super(1);
            this.this$0 = swapDisclaimerFragment;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(ViewModelNavRoute viewModelNavRoute) {
            invoke2(viewModelNavRoute);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ViewModelNavRoute viewModelNavRoute) {
            p a = Fragment_CommonKt.getFadeInNavOptionsBuilder(this.this$0).g(R.id.swapUserAgreementFragment, true).a();
            m.f(a, "fadeInNavOptionsBuilder\n                        .setPopUpTo(R.id.swapUserAgreementFragment, true)\n                        .build()");
            Fragment_CommonKt.navigate$default(this.this$0, viewModelNavRoute.getResourceId(), viewModelNavRoute.getArgs(), a, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapDisclaimerFragment$onViewCreated$2(SwapDisclaimerFragment swapDisclaimerFragment) {
        super(1);
        this.this$0 = swapDisclaimerFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(View view) {
        invoke2(view);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View it) {
        SwapDisclaimerViewModel viewModel;
        y scopeProvider;
        m.g(it, "it");
        viewModel = this.this$0.getViewModel();
        b0<ViewModelNavRoute> proceedToSwapFlow = viewModel.proceedToSwapFlow();
        scopeProvider = this.this$0.getScopeProvider();
        Object as = proceedToSwapFlow.as(d.a(scopeProvider));
        m.f(as, "viewModel.proceedToSwapFlow()\n                .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new AnonymousClass1(this.this$0), 1, null);
    }
}