package com.coinbase.wallet.application;

import com.coinbase.wallet.application.util.ContactUsLauncher;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.routing.viewmodels.DeepLinkViewModel;
import dagger.android.DispatchingAndroidInjector;
import e.j.n.a2;
import e.j.n.o2;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MainActivity_MembersInjector implements f.b<MainActivity> {
    private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;
    private final Provider<AuthenticationHelper> authenticationHelperProvider;
    private final Provider<GenericViewModelFactory<a2>> bannedLocationViewModelFactoryProvider;
    private final Provider<ContactUsLauncher> contactUsLauncherProvider;
    private final Provider<GenericViewModelFactory<DeepLinkViewModel>> deepLinkViewModelFactoryProvider;
    private final Provider<GenericViewModelFactory<o2>> viewModelFactoryProvider;

    public MainActivity_MembersInjector(Provider<DispatchingAndroidInjector<Object>> provider, Provider<AuthenticationHelper> provider2, Provider<GenericViewModelFactory<o2>> provider3, Provider<GenericViewModelFactory<DeepLinkViewModel>> provider4, Provider<GenericViewModelFactory<a2>> provider5, Provider<ContactUsLauncher> provider6) {
        this.androidInjectorProvider = provider;
        this.authenticationHelperProvider = provider2;
        this.viewModelFactoryProvider = provider3;
        this.deepLinkViewModelFactoryProvider = provider4;
        this.bannedLocationViewModelFactoryProvider = provider5;
        this.contactUsLauncherProvider = provider6;
    }

    public static f.b<MainActivity> create(Provider<DispatchingAndroidInjector<Object>> provider, Provider<AuthenticationHelper> provider2, Provider<GenericViewModelFactory<o2>> provider3, Provider<GenericViewModelFactory<DeepLinkViewModel>> provider4, Provider<GenericViewModelFactory<a2>> provider5, Provider<ContactUsLauncher> provider6) {
        return new MainActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectAuthenticationHelper(MainActivity mainActivity, AuthenticationHelper authenticationHelper) {
        mainActivity.authenticationHelper = authenticationHelper;
    }

    public static void injectBannedLocationViewModelFactory(MainActivity mainActivity, GenericViewModelFactory<a2> genericViewModelFactory) {
        mainActivity.bannedLocationViewModelFactory = genericViewModelFactory;
    }

    public static void injectContactUsLauncher(MainActivity mainActivity, ContactUsLauncher contactUsLauncher) {
        mainActivity.contactUsLauncher = contactUsLauncher;
    }

    public static void injectDeepLinkViewModelFactory(MainActivity mainActivity, GenericViewModelFactory<DeepLinkViewModel> genericViewModelFactory) {
        mainActivity.deepLinkViewModelFactory = genericViewModelFactory;
    }

    public static void injectViewModelFactory(MainActivity mainActivity, GenericViewModelFactory<o2> genericViewModelFactory) {
        mainActivity.viewModelFactory = genericViewModelFactory;
    }

    public void injectMembers(MainActivity mainActivity) {
        dagger.android.g.c.a(mainActivity, this.androidInjectorProvider.get());
        injectAuthenticationHelper(mainActivity, this.authenticationHelperProvider.get());
        injectViewModelFactory(mainActivity, this.viewModelFactoryProvider.get());
        injectDeepLinkViewModelFactory(mainActivity, this.deepLinkViewModelFactoryProvider.get());
        injectBannedLocationViewModelFactory(mainActivity, this.bannedLocationViewModelFactoryProvider.get());
        injectContactUsLauncher(mainActivity, this.contactUsLauncherProvider.get());
    }
}