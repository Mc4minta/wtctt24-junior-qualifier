package com.coinbase.wallet.features.collectibles;

import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import e.j.n.d2;
import f.b;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CollectibleTypesTabFragment_MembersInjector implements b<CollectibleTypesTabFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<ScrolledToTopViewModel>> scrolledToTopViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<d2>> viewModelFactoryProvider;

    public CollectibleTypesTabFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<d2>> provider2, Provider<GenericViewModelFactory<ScrolledToTopViewModel>> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.scrolledToTopViewModelFactoryProvider = provider3;
    }

    public static b<CollectibleTypesTabFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<d2>> provider2, Provider<GenericViewModelFactory<ScrolledToTopViewModel>> provider3) {
        return new CollectibleTypesTabFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectScrolledToTopViewModelFactory(CollectibleTypesTabFragment collectibleTypesTabFragment, GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory) {
        collectibleTypesTabFragment.scrolledToTopViewModelFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(CollectibleTypesTabFragment collectibleTypesTabFragment, GenericViewModelFactory<d2> genericViewModelFactory) {
        collectibleTypesTabFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(CollectibleTypesTabFragment collectibleTypesTabFragment) {
        i.a(collectibleTypesTabFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(collectibleTypesTabFragment, this.viewModelFactoryProvider.get());
        injectScrolledToTopViewModelFactory(collectibleTypesTabFragment, this.scrolledToTopViewModelFactoryProvider.get());
    }
}