package com.coinbase.wallet.di;

import android.net.Uri;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.routing.models.RouteScheme;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: RouteActionModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016JS\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u00022\u001a\u0010\u0005\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0012\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/di/RouteActionModule;", "", "", "Ljava/lang/Class;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "parsers", "Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "walletRepository", "Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;", "swapRepository", "Lcom/coinbase/wallet/routing/models/RouteScheme;", "Lkotlin/Function1;", "Landroid/net/Uri;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "providesPaymentRouteActions", "(Ljava/util/Map;Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/swap/interfaces/ISwapRepository;)Ljava/util/Map;", "Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;", "consumerUserRepository", "Lcom/coinbase/wallet/routing/models/RouteActionKey;", "providesRouteActions", "(Lcom/coinbase/wallet/consumer/repositories/ConsumerUserRepository;)Ljava/util/Map;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RouteActionModule {
    public final Map<RouteScheme, l<Uri, RouteAction>> providesPaymentRouteActions(Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> parsers, IWalletRepository walletRepository, ISwapRepository swapRepository) {
        Map<RouteScheme, l<Uri, RouteAction>> l2;
        m.g(parsers, "parsers");
        m.g(walletRepository, "walletRepository");
        m.g(swapRepository, "swapRepository");
        RouteActionModule$providesPaymentRouteActions$bitcoinPaymentRouteAction$1 routeActionModule$providesPaymentRouteActions$bitcoinPaymentRouteAction$1 = new RouteActionModule$providesPaymentRouteActions$bitcoinPaymentRouteAction$1(parsers, walletRepository);
        RouteActionModule$providesPaymentRouteActions$bitcoinCashPaymentRouteAction$1 routeActionModule$providesPaymentRouteActions$bitcoinCashPaymentRouteAction$1 = new RouteActionModule$providesPaymentRouteActions$bitcoinCashPaymentRouteAction$1(parsers, walletRepository);
        RouteActionModule$providesPaymentRouteActions$litecoinPaymentRouteAction$1 routeActionModule$providesPaymentRouteActions$litecoinPaymentRouteAction$1 = new RouteActionModule$providesPaymentRouteActions$litecoinPaymentRouteAction$1(parsers, walletRepository);
        RouteActionModule$providesPaymentRouteActions$dogecoinPaymentRouteAction$1 routeActionModule$providesPaymentRouteActions$dogecoinPaymentRouteAction$1 = new RouteActionModule$providesPaymentRouteActions$dogecoinPaymentRouteAction$1(parsers, walletRepository);
        RouteActionModule$providesPaymentRouteActions$stellarPaymentRouteAction$1 routeActionModule$providesPaymentRouteActions$stellarPaymentRouteAction$1 = new RouteActionModule$providesPaymentRouteActions$stellarPaymentRouteAction$1(parsers, walletRepository);
        RouteActionModule$providesPaymentRouteActions$xrpPaymentRouteAction$1 routeActionModule$providesPaymentRouteActions$xrpPaymentRouteAction$1 = new RouteActionModule$providesPaymentRouteActions$xrpPaymentRouteAction$1(parsers, walletRepository);
        l2 = m0.l(u.a(RouteScheme.BITCOIN, routeActionModule$providesPaymentRouteActions$bitcoinPaymentRouteAction$1), u.a(RouteScheme.BITCOINCASH, routeActionModule$providesPaymentRouteActions$bitcoinCashPaymentRouteAction$1), u.a(RouteScheme.LITECOIN, routeActionModule$providesPaymentRouteActions$litecoinPaymentRouteAction$1), u.a(RouteScheme.DOGECOIN, routeActionModule$providesPaymentRouteActions$dogecoinPaymentRouteAction$1), u.a(RouteScheme.STELLAR, routeActionModule$providesPaymentRouteActions$stellarPaymentRouteAction$1), u.a(RouteScheme.WEBSTELLAR, routeActionModule$providesPaymentRouteActions$stellarPaymentRouteAction$1), u.a(RouteScheme.XRP, routeActionModule$providesPaymentRouteActions$xrpPaymentRouteAction$1), u.a(RouteScheme.RIPPLE, routeActionModule$providesPaymentRouteActions$xrpPaymentRouteAction$1), u.a(RouteScheme.ETHEREUM, new RouteActionModule$providesPaymentRouteActions$ethereumPaymentRouteAction$1(parsers, walletRepository)), u.a(RouteScheme.SWAP, new RouteActionModule$providesPaymentRouteActions$walletSwapRouteAction$1(swapRepository)));
        return l2;
    }

    public final Map<RouteActionKey, l<Uri, RouteAction>> providesRouteActions(ConsumerUserRepository consumerUserRepository) {
        Map<RouteActionKey, l<Uri, RouteAction>> l2;
        m.g(consumerUserRepository, "consumerUserRepository");
        l2 = m0.l(u.a(RouteActionKey.DAPP, RouteActionModule$providesRouteActions$1.INSTANCE), u.a(RouteActionKey.SHOW_QR_CODE, RouteActionModule$providesRouteActions$2.INSTANCE), u.a(RouteActionKey.CONSUMER_CONNECT, new RouteActionModule$providesRouteActions$3(consumerUserRepository)));
        return l2;
    }
}