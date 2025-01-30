package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AmountFragment_MembersInjector implements f.b<AmountFragment> {
    private final Provider<GenericViewModelFactory<AmountViewModel>> amountViewModelFactoryProvider;
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

    public AmountFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<AmountViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.amountViewModelFactoryProvider = provider2;
    }

    public static f.b<AmountFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<AmountViewModel>> provider2) {
        return new AmountFragment_MembersInjector(provider, provider2);
    }

    public static void injectAmountViewModelFactory(AmountFragment amountFragment, GenericViewModelFactory<AmountViewModel> genericViewModelFactory) {
        amountFragment.amountViewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(AmountFragment amountFragment) {
        dagger.android.g.i.a(amountFragment, this.androidInjectorProvider.get());
        injectAmountViewModelFactory(amountFragment, this.amountViewModelFactoryProvider.get());
    }
}