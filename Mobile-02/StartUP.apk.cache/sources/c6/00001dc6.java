package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.cloudbackup.viewModel.RestoreWalletViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class RestoreWalletFragment_MembersInjector implements f.b<RestoreWalletFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<RestoreWalletViewModel>> viewModelFactoryProvider;

    public RestoreWalletFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<RestoreWalletViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<RestoreWalletFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<RestoreWalletViewModel>> provider2) {
        return new RestoreWalletFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(RestoreWalletFragment restoreWalletFragment, GenericViewModelFactory<RestoreWalletViewModel> genericViewModelFactory) {
        restoreWalletFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(RestoreWalletFragment restoreWalletFragment) {
        dagger.android.g.i.a(restoreWalletFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(restoreWalletFragment, this.viewModelFactoryProvider.get());
    }
}