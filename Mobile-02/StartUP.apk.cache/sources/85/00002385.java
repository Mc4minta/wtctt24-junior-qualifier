package com.coinbase.wallet.features.wallets.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendCoinPickerFragment_MembersInjector implements f.b<SendCoinPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<WalletsTabViewModel>> viewModelFactoryProvider;

    public SendCoinPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<WalletsTabViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SendCoinPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<WalletsTabViewModel>> provider2) {
        return new SendCoinPickerFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SendCoinPickerFragment sendCoinPickerFragment, GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactory) {
        sendCoinPickerFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(SendCoinPickerFragment sendCoinPickerFragment) {
        i.a(sendCoinPickerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(sendCoinPickerFragment, this.viewModelFactoryProvider.get());
    }
}