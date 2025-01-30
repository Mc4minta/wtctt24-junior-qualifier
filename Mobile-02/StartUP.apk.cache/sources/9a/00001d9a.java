package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.cloudbackup.viewModel.CreatePasswordViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CreatePasswordFragment_MembersInjector implements f.b<CreatePasswordFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<CreatePasswordViewModel>> viewModelFactoryProvider;

    public CreatePasswordFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<CreatePasswordViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<CreatePasswordFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<CreatePasswordViewModel>> provider2) {
        return new CreatePasswordFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(CreatePasswordFragment createPasswordFragment, GenericViewModelFactory<CreatePasswordViewModel> genericViewModelFactory) {
        createPasswordFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(CreatePasswordFragment createPasswordFragment) {
        dagger.android.g.i.a(createPasswordFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(createPasswordFragment, this.viewModelFactoryProvider.get());
    }
}