package com.coinbase.wallet.commonui.utilities;

import androidx.lifecycle.b0;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ViewModelFactoryWithMap_Factory implements f.c.d<ViewModelFactoryWithMap> {
    private final Provider<Map<Class<? extends b0>, Provider<b0>>> viewModelsProvider;

    public ViewModelFactoryWithMap_Factory(Provider<Map<Class<? extends b0>, Provider<b0>>> provider) {
        this.viewModelsProvider = provider;
    }

    public static ViewModelFactoryWithMap_Factory create(Provider<Map<Class<? extends b0>, Provider<b0>>> provider) {
        return new ViewModelFactoryWithMap_Factory(provider);
    }

    public static ViewModelFactoryWithMap newInstance(Map<Class<? extends b0>, Provider<b0>> map) {
        return new ViewModelFactoryWithMap(map);
    }

    @Override // javax.inject.Provider
    public ViewModelFactoryWithMap get() {
        return newInstance(this.viewModelsProvider.get());
    }
}