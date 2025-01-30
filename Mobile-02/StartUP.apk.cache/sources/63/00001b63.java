package com.coinbase.wallet.di;

import android.net.Uri;
import com.coinbase.wallet.routing.models.SwapRouteAction;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: RouteActionModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "uri", "Lcom/coinbase/wallet/routing/models/SwapRouteAction;", "<anonymous>", "(Landroid/net/Uri;)Lcom/coinbase/wallet/routing/models/SwapRouteAction;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class RouteActionModule$providesPaymentRouteActions$walletSwapRouteAction$1 extends o implements l<Uri, SwapRouteAction> {
    final /* synthetic */ ISwapRepository $swapRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteActionModule$providesPaymentRouteActions$walletSwapRouteAction$1(ISwapRepository iSwapRepository) {
        super(1);
        this.$swapRepository = iSwapRepository;
    }

    @Override // kotlin.e0.c.l
    public final SwapRouteAction invoke(Uri uri) {
        m.g(uri, "uri");
        return new SwapRouteAction(uri, this.$swapRepository);
    }
}