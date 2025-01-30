package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.signer.viewmodel.SwitchEthereumChainViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SwitchEthereumChainFragment_MembersInjector implements f.b<SwitchEthereumChainFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<SwitchEthereumChainViewModel>> viewModelFactoryProvider;

    public SwitchEthereumChainFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SwitchEthereumChainViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SwitchEthereumChainFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SwitchEthereumChainViewModel>> provider2) {
        return new SwitchEthereumChainFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SwitchEthereumChainFragment switchEthereumChainFragment, GenericViewModelFactory<SwitchEthereumChainViewModel> genericViewModelFactory) {
        switchEthereumChainFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(SwitchEthereumChainFragment switchEthereumChainFragment) {
        dagger.android.g.e.a(switchEthereumChainFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(switchEthereumChainFragment, this.viewModelFactoryProvider.get());
    }
}