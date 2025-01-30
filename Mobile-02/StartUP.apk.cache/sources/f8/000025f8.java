package com.coinbase.wallet.routing.viewmodels;

import android.net.Uri;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.routing.models.RouteScheme;
import f.c.d;
import java.util.Map;
import javax.inject.Provider;
import kotlin.e0.c.l;

/* loaded from: classes2.dex */
public final class DeepLinkViewModel_Factory implements d<DeepLinkViewModel> {
    private final Provider<Map<RouteActionKey, l<Uri, RouteAction>>> actionRoutesProvider;
    private final Provider<Map<RouteScheme, l<Uri, RouteAction>>> schemeRoutesProvider;

    public DeepLinkViewModel_Factory(Provider<Map<RouteScheme, l<Uri, RouteAction>>> provider, Provider<Map<RouteActionKey, l<Uri, RouteAction>>> provider2) {
        this.schemeRoutesProvider = provider;
        this.actionRoutesProvider = provider2;
    }

    public static DeepLinkViewModel_Factory create(Provider<Map<RouteScheme, l<Uri, RouteAction>>> provider, Provider<Map<RouteActionKey, l<Uri, RouteAction>>> provider2) {
        return new DeepLinkViewModel_Factory(provider, provider2);
    }

    public static DeepLinkViewModel newInstance(Map<RouteScheme, l<Uri, RouteAction>> map, Map<RouteActionKey, l<Uri, RouteAction>> map2) {
        return new DeepLinkViewModel(map, map2);
    }

    @Override // javax.inject.Provider
    public DeepLinkViewModel get() {
        return newInstance(this.schemeRoutesProvider.get(), this.actionRoutesProvider.get());
    }
}