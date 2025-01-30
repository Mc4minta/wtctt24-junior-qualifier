package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFeeFragment_MembersInjector implements f.b<AdjustableMinerFeeFragment> {
    private final Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> adjustableMinerFeeSharedFactoryProvider;
    private final Provider<AdjustableMinerFeeViewModel.Factory> viewModelFactoryProvider;

    public AdjustableMinerFeeFragment_MembersInjector(Provider<AdjustableMinerFeeViewModel.Factory> provider, Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> provider2) {
        this.viewModelFactoryProvider = provider;
        this.adjustableMinerFeeSharedFactoryProvider = provider2;
    }

    public static f.b<AdjustableMinerFeeFragment> create(Provider<AdjustableMinerFeeViewModel.Factory> provider, Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> provider2) {
        return new AdjustableMinerFeeFragment_MembersInjector(provider, provider2);
    }

    public static void injectAdjustableMinerFeeSharedFactory(AdjustableMinerFeeFragment adjustableMinerFeeFragment, GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory) {
        adjustableMinerFeeFragment.adjustableMinerFeeSharedFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(AdjustableMinerFeeFragment adjustableMinerFeeFragment, AdjustableMinerFeeViewModel.Factory factory) {
        adjustableMinerFeeFragment.viewModelFactory = factory;
    }

    public void injectMembers(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
        injectViewModelFactory(adjustableMinerFeeFragment, this.viewModelFactoryProvider.get());
        injectAdjustableMinerFeeSharedFactory(adjustableMinerFeeFragment, this.adjustableMinerFeeSharedFactoryProvider.get());
    }
}