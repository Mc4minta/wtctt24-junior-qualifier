package com.toshi.view.fragment.toplevel;

import com.coinbase.wallet.application.util.ContactUsLauncher;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel;
import e.j.n.b3;

/* compiled from: SettingsFragment_MembersInjector.java */
/* loaded from: classes2.dex */
public final class e0 implements f.b<SettingsFragment> {
    public static void a(SettingsFragment settingsFragment, GenericViewModelFactory<ConsumerSettingViewModel> genericViewModelFactory) {
        settingsFragment.f11408e = genericViewModelFactory;
    }

    public static void b(SettingsFragment settingsFragment, ContactUsLauncher contactUsLauncher) {
        settingsFragment.f11409f = contactUsLauncher;
    }

    public static void c(SettingsFragment settingsFragment, GenericViewModelFactory<b3> genericViewModelFactory) {
        settingsFragment.f11407d = genericViewModelFactory;
    }
}