package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SignerViewFragment_MembersInjector implements f.b<SignerViewFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<SignerViewModel>> viewModelFactoryProvider;

    public SignerViewFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SignerViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<SignerViewFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<SignerViewModel>> provider2) {
        return new SignerViewFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(SignerViewFragment signerViewFragment, GenericViewModelFactory<SignerViewModel> genericViewModelFactory) {
        signerViewFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(SignerViewFragment signerViewFragment) {
        dagger.android.g.i.a(signerViewFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(signerViewFragment, this.viewModelFactoryProvider.get());
    }
}