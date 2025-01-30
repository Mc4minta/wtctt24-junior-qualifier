package com.coinbase.wallet.features.cloudbackup.view;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import dagger.android.DispatchingAndroidInjector;
import e.j.n.i3;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class VerifyManualBackupFragment_MembersInjector implements f.b<VerifyManualBackupFragment> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<GenericViewModelFactory<i3>> viewModelFactoryProvider;

    public VerifyManualBackupFragment_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<i3>> provider2) {
        this.androidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static f.b<VerifyManualBackupFragment> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<GenericViewModelFactory<i3>> provider2) {
        return new VerifyManualBackupFragment_MembersInjector(provider, provider2);
    }

    public static void injectViewModelFactory(VerifyManualBackupFragment verifyManualBackupFragment, GenericViewModelFactory<i3> genericViewModelFactory) {
        verifyManualBackupFragment.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(VerifyManualBackupFragment verifyManualBackupFragment) {
        dagger.android.g.i.a(verifyManualBackupFragment, this.androidInjectorProvider.get());
        injectViewModelFactory(verifyManualBackupFragment, this.viewModelFactoryProvider.get());
    }
}