package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.signer.viewmodel.RequestEthereumAccountsViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RequestEthereumAccountsFragment_MembersInjector implements f.b<RequestEthereumAccountsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<RequestEthereumAccountsViewModel>> viewModelFactoryProvider;

    public RequestEthereumAccountsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<RequestEthereumAccountsViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<RequestEthereumAccountsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<RequestEthereumAccountsViewModel>> provider2) {
        return new RequestEthereumAccountsFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(RequestEthereumAccountsFragment requestEthereumAccountsFragment, GenericViewModelFactory<RequestEthereumAccountsViewModel> genericViewModelFactory) {
        requestEthereumAccountsFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(RequestEthereumAccountsFragment requestEthereumAccountsFragment) {
        dagger.android.g.e.a(requestEthereumAccountsFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(requestEthereumAccountsFragment, this.viewModelFactoryProvider.get());
    }
}