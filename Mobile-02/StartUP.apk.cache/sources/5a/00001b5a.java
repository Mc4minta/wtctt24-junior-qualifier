package com.coinbase.wallet.di;

import com.coinbase.wallet.core.interfaces.Refreshable;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RefreshablesModule_ProvidesRefreshableListFactory implements f.c.d<List<Refreshable>> {
    private final Provider<Map<Integer, Refreshable>> refreshableMapProvider;

    public RefreshablesModule_ProvidesRefreshableListFactory(Provider<Map<Integer, Refreshable>> provider) {
        this.refreshableMapProvider = provider;
    }

    public static RefreshablesModule_ProvidesRefreshableListFactory create(Provider<Map<Integer, Refreshable>> provider) {
        return new RefreshablesModule_ProvidesRefreshableListFactory(provider);
    }

    public static List<Refreshable> providesRefreshableList(Map<Integer, Refreshable> map) {
        return (List) f.c.h.f(RefreshablesModule.providesRefreshableList(map));
    }

    @Override // javax.inject.Provider
    public List<Refreshable> get() {
        return providesRefreshableList(this.refreshableMapProvider.get());
    }
}