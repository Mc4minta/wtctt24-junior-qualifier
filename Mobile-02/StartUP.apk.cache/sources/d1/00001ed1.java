package com.coinbase.wallet.features.lend.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendDashboardFragment_MembersInjector implements f.b<LendDashboardFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LendDashboardViewModel>> viewModelFactoryProvider;

    public LendDashboardFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendDashboardViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<LendDashboardFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendDashboardViewModel>> provider2) {
        return new LendDashboardFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(LendDashboardFragment lendDashboardFragment, GenericViewModelFactory<LendDashboardViewModel> genericViewModelFactory) {
        lendDashboardFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(LendDashboardFragment lendDashboardFragment) {
        i.a(lendDashboardFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(lendDashboardFragment, this.viewModelFactoryProvider.get());
    }
}