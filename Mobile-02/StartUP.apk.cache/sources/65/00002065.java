package com.coinbase.wallet.features.send.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdjustableMinerFee1559Fragment_MembersInjector implements f.b<AdjustableMinerFee1559Fragment> {
    private final Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> adjustableMinerFeeSharedFactoryProvider;
    private final Provider<AdjustableMinerFee1559ViewModel.Factory> viewModelFactoryProvider;

    public AdjustableMinerFee1559Fragment_MembersInjector(Provider<AdjustableMinerFee1559ViewModel.Factory> provider, Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> provider2) {
        this.viewModelFactoryProvider = provider;
        this.adjustableMinerFeeSharedFactoryProvider = provider2;
    }

    public static f.b<AdjustableMinerFee1559Fragment> create(Provider<AdjustableMinerFee1559ViewModel.Factory> provider, Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> provider2) {
        return new AdjustableMinerFee1559Fragment_MembersInjector(provider, provider2);
    }

    public static void injectAdjustableMinerFeeSharedFactory(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment, GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory) {
        adjustableMinerFee1559Fragment.adjustableMinerFeeSharedFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment, AdjustableMinerFee1559ViewModel.Factory factory) {
        adjustableMinerFee1559Fragment.viewModelFactory = factory;
    }

    public void injectMembers(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
        injectViewModelFactory(adjustableMinerFee1559Fragment, this.viewModelFactoryProvider.get());
        injectAdjustableMinerFeeSharedFactory(adjustableMinerFee1559Fragment, this.adjustableMinerFeeSharedFactoryProvider.get());
    }
}