package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SendDestinationPickerFragment_MembersInjector implements f.b<SendDestinationPickerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<e.j.h.a.j>> qrScannerViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<SendDestinationPickerViewModel>> viewModelFactoryProvider;

    public SendDestinationPickerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SendDestinationPickerViewModel>> provider2, Provider<GenericViewModelFactory<e.j.h.a.j>> provider3) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.qrScannerViewModelFactoryProvider = provider3;
    }

    public static f.b<SendDestinationPickerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SendDestinationPickerViewModel>> provider2, Provider<GenericViewModelFactory<e.j.h.a.j>> provider3) {
        return new SendDestinationPickerFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectQrScannerViewModelFactory(SendDestinationPickerFragment sendDestinationPickerFragment, GenericViewModelFactory<e.j.h.a.j> genericViewModelFactory) {
        sendDestinationPickerFragment.qrScannerViewModelFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(SendDestinationPickerFragment sendDestinationPickerFragment, GenericViewModelFactory<SendDestinationPickerViewModel> genericViewModelFactory) {
        sendDestinationPickerFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(SendDestinationPickerFragment sendDestinationPickerFragment) {
        dagger.android.g.i.a(sendDestinationPickerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(sendDestinationPickerFragment, this.viewModelFactoryProvider.get());
        injectQrScannerViewModelFactory(sendDestinationPickerFragment, this.qrScannerViewModelFactoryProvider.get());
    }
}