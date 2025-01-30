package com.coinbase.wallet.features.signer.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TxSignerFragment_MembersInjector implements f.b<TxSignerFragment> {
    private final Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> adjustableMinerFeesFactoryProvider;
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<TxSignerViewModel>> viewModelFactoryProvider;

    public TxSignerFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> provider2, Provider<GenericViewModelFactory<TxSignerViewModel>> provider3) {
        this.androidInjectorProvider = provider;
        this.adjustableMinerFeesFactoryProvider = provider2;
        this.viewModelFactoryProvider = provider3;
    }

    public static f.b<TxSignerFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<AdjustableMinerFeeSharedViewModel>> provider2, Provider<GenericViewModelFactory<TxSignerViewModel>> provider3) {
        return new TxSignerFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectAdjustableMinerFeesFactory(TxSignerFragment txSignerFragment, GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactory) {
        txSignerFragment.adjustableMinerFeesFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(TxSignerFragment txSignerFragment, GenericViewModelFactory<TxSignerViewModel> genericViewModelFactory) {
        txSignerFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(TxSignerFragment txSignerFragment) {
        dagger.android.g.e.a(txSignerFragment, this.androidInjectorProvider.get());
        injectAdjustableMinerFeesFactory(txSignerFragment, this.adjustableMinerFeesFactoryProvider.get());
        injectViewModelFactory(txSignerFragment, this.viewModelFactoryProvider.get());
    }
}