package com.coinbase.wallet.di;

import android.net.Uri;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Map;
import javax.inject.Provider;
import kotlin.e0.c.l;

/* loaded from: classes.dex */
public final class RouteActionModule_ProvidesRouteActionsFactory implements f.c.d<Map<RouteActionKey, l<Uri, RouteAction>>> {
    private final Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private final RouteActionModule module;

    public RouteActionModule_ProvidesRouteActionsFactory(RouteActionModule routeActionModule, Provider<ConsumerUserRepository> provider) {
        this.module = routeActionModule;
        this.consumerUserRepositoryProvider = provider;
    }

    public static RouteActionModule_ProvidesRouteActionsFactory create(RouteActionModule routeActionModule, Provider<ConsumerUserRepository> provider) {
        return new RouteActionModule_ProvidesRouteActionsFactory(routeActionModule, provider);
    }

    public static Map<RouteActionKey, l<Uri, RouteAction>> providesRouteActions(RouteActionModule routeActionModule, ConsumerUserRepository consumerUserRepository) {
        return (Map) f.c.h.f(routeActionModule.providesRouteActions(consumerUserRepository));
    }

    @Override // javax.inject.Provider
    public Map<RouteActionKey, l<Uri, RouteAction>> get() {
        return providesRouteActions(this.module, this.consumerUserRepositoryProvider.get());
    }
}