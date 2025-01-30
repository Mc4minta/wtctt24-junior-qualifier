package com.coinbase.wallet.features.lend.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.lend.viewmodels.LendViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendInterstitialFragment_MembersInjector implements f.b<LendInterstitialFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LendViewModel>> lendViewModelFactoryProvider;

    public LendInterstitialFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.lendViewModelFactoryProvider = provider2;
    }

    public static f.b<LendInterstitialFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendViewModel>> provider2) {
        return new LendInterstitialFragment_MembersInjector(provider, provider2);
    }

    public static void injectLendViewModelFactory(LendInterstitialFragment lendInterstitialFragment, GenericViewModelFactory<LendViewModel> genericViewModelFactory) {
        lendInterstitialFragment.lendViewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(LendInterstitialFragment lendInterstitialFragment) {
        i.a(lendInterstitialFragment, this.androidInjectorProvider.get());
        injectLendViewModelFactory(lendInterstitialFragment, this.lendViewModelFactoryProvider.get());
    }
}