package com.coinbase.wallet.features.swap.views;

import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;
import kotlin.x;

/* compiled from: SwapInterstitialFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/x;", "kotlin.jvm.PlatformType", "it", "<anonymous>", "(V)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class SwapInterstitialFragment$onViewCreated$2 extends o implements l<x, x> {
    final /* synthetic */ SwapInterstitialFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwapInterstitialFragment$onViewCreated$2(SwapInterstitialFragment swapInterstitialFragment) {
        super(1);
        this.this$0 = swapInterstitialFragment;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(x xVar) {
        invoke2(xVar);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(x xVar) {
        Fragment_CommonKt.navigateUp(this.this$0);
    }
}