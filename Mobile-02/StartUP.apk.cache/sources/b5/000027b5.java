package com.coinbase.wallet.txhistory.views;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.g.i;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TxHistoryDetailFragment_MembersInjector implements f.b<TxHistoryDetailFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<TxHistoryDetailViewModel>> viewModelFactoryProvider;

    public TxHistoryDetailFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<TxHistoryDetailViewModel>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<TxHistoryDetailFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<TxHistoryDetailViewModel>> provider2) {
        return new TxHistoryDetailFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(TxHistoryDetailFragment txHistoryDetailFragment, GenericViewModelFactory<TxHistoryDetailViewModel> genericViewModelFactory) {
        txHistoryDetailFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(TxHistoryDetailFragment txHistoryDetailFragment) {
        i.a(txHistoryDetailFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(txHistoryDetailFragment, this.viewModelFactoryProvider.get());
    }
}