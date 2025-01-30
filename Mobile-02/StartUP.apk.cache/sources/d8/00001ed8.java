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

/* compiled from: LendInterstitialFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00032F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/o;", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "kotlin.jvm.PlatformType", "Lkotlin/x;", "<name for destructuring parameter 0>", "<anonymous>", "(Lkotlin/o;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class LendInterstitialFragment$setupObservers$2 extends o implements l<kotlin.o<? extends ViewModelNavRoute, ? extends x>, x> {
    final /* synthetic */ LendInterstitialFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendInterstitialFragment$setupObservers$2(LendInterstitialFragment lendInterstitialFragment) {
        super(1);
        this.this$0 = lendInterstitialFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(kotlin.o<? extends ViewModelNavRoute, ? extends x> oVar) {
        invoke2((kotlin.o<ViewModelNavRoute, x>) oVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(kotlin.o<ViewModelNavRoute, x> oVar) {
        ViewModelNavRoute a = oVar.a();
        p a2 = new p.a().b(R.anim.fade_in).c(R.anim.fade_out).e(R.anim.fade_in).f(R.anim.fade_out).a();
        m.f(a2, "Builder()\n                    .setEnterAnim(R.anim.fade_in)\n                    .setExitAnim(R.anim.fade_out)\n                    .setPopEnterAnim(R.anim.fade_in)\n                    .setPopExitAnim(R.anim.fade_out)\n                    .build()");
        Fragment_CommonKt.navigate$default(this.this$0, a.getResourceId(), a.getArgs(), a2, null, 8, null);
    }
}