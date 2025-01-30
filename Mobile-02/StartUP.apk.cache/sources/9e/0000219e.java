package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.signer.viewmodel.ParentRequestEthereumAccountsViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class ParentRequestEthereumAccountsFragment_MembersInjector implements f.b<ParentRequestEthereumAccountsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<ParentRequestEthereumAccountsViewModel>> viewModelFactoryProvider;

    public ParentRequestEthereumAccountsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ParentRequestEthereumAccountsViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<ParentRequestEthereumAccountsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<ParentRequestEthereumAccountsViewModel>> provider2) {
        return new ParentRequestEthereumAccountsFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment, GenericViewModelFactory<ParentRequestEthereumAccountsViewModel> genericViewModelFactory) {
        parentRequestEthereumAccountsFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
        dagger.android.g.e.a(parentRequestEthereumAccountsFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(parentRequestEthereumAccountsFragment, this.viewModelFactoryProvider.get());
    }
}