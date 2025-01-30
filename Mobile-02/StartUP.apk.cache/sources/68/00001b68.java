package com.coinbase.wallet.di;

import android.net.Uri;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteScheme;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import java.util.Map;
import javax.inject.Provider;
import kotlin.e0.c.l;

/* loaded from: classes.dex */
public final class RouteActionModule_ProvidesPaymentRouteActionsFactory implements f.c.d<Map<RouteScheme, l<Uri, RouteAction>>> {
    private final RouteActionModule module;
    private final Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> parsersProvider;
    private final Provider<ISwapRepository> swapRepositoryProvider;
    private final Provider<IWalletRepository> walletRepositoryProvider;

    public RouteActionModule_ProvidesPaymentRouteActionsFactory(RouteActionModule routeActionModule, Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> provider, Provider<IWalletRepository> provider2, Provider<ISwapRepository> provider3) {
        this.module = routeActionModule;
        this.parsersProvider = provider;
        this.walletRepositoryProvider = provider2;
        this.swapRepositoryProvider = provider3;
    }

    public static RouteActionModule_ProvidesPaymentRouteActionsFactory create(RouteActionModule routeActionModule, Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> provider, Provider<IWalletRepository> provider2, Provider<ISwapRepository> provider3) {
        return new RouteActionModule_ProvidesPaymentRouteActionsFactory(routeActionModule, provider, provider2, provider3);
    }

    public static Map<RouteScheme, l<Uri, RouteAction>> providesPaymentRouteActions(RouteActionModule routeActionModule, Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> map, IWalletRepository iWalletRepository, ISwapRepository iSwapRepository) {
        return (Map) f.c.h.f(routeActionModule.providesPaymentRouteActions(map, iWalletRepository, iSwapRepository));
    }

    @Override // javax.inject.Provider
    public Map<RouteScheme, l<Uri, RouteAction>> get() {
        return providesPaymentRouteActions(this.module, this.parsersProvider.get(), this.walletRepositoryProvider.get(), this.swapRepositoryProvider.get());
    }
}