package com.coinbase.wallet.di;

import android.net.Uri;
import com.coinbase.wallet.consumer.models.ConsumerInterstitialArgs;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.routing.models.ConsumerConnectRouteAction;
import com.coinbase.wallet.routing.models.NavDeepLinkDestination;
import com.coinbase.wallet.routing.models.RouteAction;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import org.toshi.R;

/* compiled from: RouteActionModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/net/Uri;", "uri", "Lcom/coinbase/wallet/routing/models/RouteAction;", "<anonymous>", "(Landroid/net/Uri;)Lcom/coinbase/wallet/routing/models/RouteAction;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class RouteActionModule$providesRouteActions$3 extends o implements l<Uri, RouteAction> {
    final /* synthetic */ ConsumerUserRepository $consumerUserRepository;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteActionModule$providesRouteActions$3(ConsumerUserRepository consumerUserRepository) {
        super(1);
        this.$consumerUserRepository = consumerUserRepository;
    }

    @Override // kotlin.e0.c.l
    public final RouteAction invoke(Uri uri) {
        m.g(uri, "uri");
        return new ConsumerConnectRouteAction(uri, new NavDeepLinkDestination(R.id.action_walletFragment_to_consumerNavGraph, ConsumerInterstitialArgs.createArguments$default(ConsumerInterstitialArgs.INSTANCE, false, this.$consumerUserRepository.getConnectStatus(), null, false, 12, null)));
    }
}