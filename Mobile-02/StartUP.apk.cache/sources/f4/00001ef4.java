package com.coinbase.wallet.features.lend.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.lend.viewmodels.LendUserAgreementViewModel;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class LendUserAgreementFragment_MembersInjector implements f.b<LendUserAgreementFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<LendUserAgreementViewModel>> userAgreementViewModelFactoryProvider;

    public LendUserAgreementFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendUserAgreementViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.userAgreementViewModelFactoryProvider = provider2;
    }

    public static f.b<LendUserAgreementFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<LendUserAgreementViewModel>> provider2) {
        return new LendUserAgreementFragment_MembersInjector(provider, provider2);
    }

    public static void injectUserAgreementViewModelFactory(LendUserAgreementFragment lendUserAgreementFragment, GenericViewModelFactory<LendUserAgreementViewModel> genericViewModelFactory) {
        lendUserAgreementFragment.userAgreementViewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(LendUserAgreementFragment lendUserAgreementFragment) {
        i.a(lendUserAgreementFragment, this.androidInjectorProvider.get());
        injectUserAgreementViewModelFactory(lendUserAgreementFragment, this.userAgreementViewModelFactoryProvider.get());
    }
}