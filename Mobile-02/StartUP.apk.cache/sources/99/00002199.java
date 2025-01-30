package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.signer.viewmodel.MessageSignerViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MessageSignerFragment_MembersInjector implements f.b<MessageSignerFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<MessageSignerViewModel>> viewModelFactoryProvider;

    public MessageSignerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<MessageSignerViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<MessageSignerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<MessageSignerViewModel>> provider2) {
        return new MessageSignerFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(MessageSignerFragment messageSignerFragment, GenericViewModelFactory<MessageSignerViewModel> genericViewModelFactory) {
        messageSignerFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(MessageSignerFragment messageSignerFragment) {
        dagger.android.g.e.a(messageSignerFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(messageSignerFragment, this.viewModelFactoryProvider.get());
    }
}