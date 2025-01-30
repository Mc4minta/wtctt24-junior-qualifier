package com.coinbase.wallet.features.walletlink.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import f.b;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WalletLinkSettingsFragment_MembersInjector implements b<WalletLinkSettingsFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<WalletLinkSettingsViewModel>> viewModelFactoryProvider;

    public WalletLinkSettingsFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<WalletLinkSettingsViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static b<WalletLinkSettingsFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<WalletLinkSettingsViewModel>> provider2) {
        return new WalletLinkSettingsFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(WalletLinkSettingsFragment walletLinkSettingsFragment, GenericViewModelFactory<WalletLinkSettingsViewModel> genericViewModelFactory) {
        walletLinkSettingsFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(WalletLinkSettingsFragment walletLinkSettingsFragment) {
        i.a(walletLinkSettingsFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(walletLinkSettingsFragment, this.viewModelFactoryProvider.get());
    }
}