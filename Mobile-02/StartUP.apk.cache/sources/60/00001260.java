package com.coinbase.wallet.application.view;

import com.coinbase.wallet.application.viewmodel.LoadingPillViewModel;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import e.j.h.a.j;
import e.j.n.l2;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class HomeFragment_MembersInjector implements f.b<HomeFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LoadingPillViewModel>> loadingPillViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<j>> qrScannerViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<ScrolledToTopViewModel>> scrolledToTopViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<l2>> viewModelFactoryProvider;

    public HomeFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<l2>> provider2, Provider<GenericViewModelFactory<LoadingPillViewModel>> provider3, Provider<GenericViewModelFactory<ScrolledToTopViewModel>> provider4, Provider<GenericViewModelFactory<j>> provider5) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.loadingPillViewModelFactoryProvider = provider3;
        this.scrolledToTopViewModelFactoryProvider = provider4;
        this.qrScannerViewModelFactoryProvider = provider5;
    }

    public static f.b<HomeFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<l2>> provider2, Provider<GenericViewModelFactory<LoadingPillViewModel>> provider3, Provider<GenericViewModelFactory<ScrolledToTopViewModel>> provider4, Provider<GenericViewModelFactory<j>> provider5) {
        return new HomeFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectLoadingPillViewModelFactory(HomeFragment homeFragment, GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactory) {
        homeFragment.loadingPillViewModelFactory = genericViewModelFactory;
    }

    public static void injectQrScannerViewModelFactory(HomeFragment homeFragment, GenericViewModelFactory<j> genericViewModelFactory) {
        homeFragment.qrScannerViewModelFactory = genericViewModelFactory;
    }

    public static void injectScrolledToTopViewModelFactory(HomeFragment homeFragment, GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory) {
        homeFragment.scrolledToTopViewModelFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(HomeFragment homeFragment, GenericViewModelFactory<l2> genericViewModelFactory) {
        homeFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(HomeFragment homeFragment) {
        i.a(homeFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(homeFragment, this.viewModelFactoryProvider.get());
        injectLoadingPillViewModelFactory(homeFragment, this.loadingPillViewModelFactoryProvider.get());
        injectScrolledToTopViewModelFactory(homeFragment, this.scrolledToTopViewModelFactoryProvider.get());
        injectQrScannerViewModelFactory(homeFragment, this.qrScannerViewModelFactoryProvider.get());
    }
}