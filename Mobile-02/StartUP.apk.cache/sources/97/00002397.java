package com.coinbase.wallet.features.wallets.views;

import com.coinbase.wallet.application.viewmodel.LoadingPillViewModel;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletsTabFragment_MembersInjector implements f.b<WalletsTabFragment> {
    private final Provider<GenericViewModelFactory<ActionItemsViewModel>> actionItemsViewModelFactoryProvider;
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LoadingPillViewModel>> loadingPillViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<ScrolledToTopViewModel>> scrolledToTopViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<WalletsTabViewModel>> walletsTabViewModelFactoryProvider;

    public WalletsTabFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<WalletsTabViewModel>> provider2, Provider<GenericViewModelFactory<ActionItemsViewModel>> provider3, Provider<GenericViewModelFactory<LoadingPillViewModel>> provider4, Provider<GenericViewModelFactory<ScrolledToTopViewModel>> provider5) {
        this.androidInjectorProvider = provider;
        this.walletsTabViewModelFactoryProvider = provider2;
        this.actionItemsViewModelFactoryProvider = provider3;
        this.loadingPillViewModelFactoryProvider = provider4;
        this.scrolledToTopViewModelFactoryProvider = provider5;
    }

    public static f.b<WalletsTabFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<WalletsTabViewModel>> provider2, Provider<GenericViewModelFactory<ActionItemsViewModel>> provider3, Provider<GenericViewModelFactory<LoadingPillViewModel>> provider4, Provider<GenericViewModelFactory<ScrolledToTopViewModel>> provider5) {
        return new WalletsTabFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectActionItemsViewModelFactory(WalletsTabFragment walletsTabFragment, GenericViewModelFactory<ActionItemsViewModel> genericViewModelFactory) {
        walletsTabFragment.actionItemsViewModelFactory = genericViewModelFactory;
    }

    public static void injectLoadingPillViewModelFactory(WalletsTabFragment walletsTabFragment, GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactory) {
        walletsTabFragment.loadingPillViewModelFactory = genericViewModelFactory;
    }

    public static void injectScrolledToTopViewModelFactory(WalletsTabFragment walletsTabFragment, GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactory) {
        walletsTabFragment.scrolledToTopViewModelFactory = genericViewModelFactory;
    }

    public static void injectWalletsTabViewModelFactory(WalletsTabFragment walletsTabFragment, GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactory) {
        walletsTabFragment.walletsTabViewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(WalletsTabFragment walletsTabFragment) {
        i.a(walletsTabFragment, this.androidInjectorProvider.get());
        injectWalletsTabViewModelFactory(walletsTabFragment, this.walletsTabViewModelFactoryProvider.get());
        injectActionItemsViewModelFactory(walletsTabFragment, this.actionItemsViewModelFactoryProvider.get());
        injectLoadingPillViewModelFactory(walletsTabFragment, this.loadingPillViewModelFactoryProvider.get());
        injectScrolledToTopViewModelFactory(walletsTabFragment, this.scrolledToTopViewModelFactoryProvider.get());
    }
}