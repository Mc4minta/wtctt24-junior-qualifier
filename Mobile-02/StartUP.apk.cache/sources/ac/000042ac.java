package com.toshi.view.fragment;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import e.j.n.w1;

/* compiled from: AppLockSettingsFragment_MembersInjector.java */
/* loaded from: classes2.dex */
public final class c0 implements f.b<AppLockSettingsFragment> {
    public static void a(AppLockSettingsFragment appLockSettingsFragment, AuthenticationHelper authenticationHelper) {
        appLockSettingsFragment.f11236e = authenticationHelper;
    }

    public static void b(AppLockSettingsFragment appLockSettingsFragment, e.j.l.n.b bVar) {
        appLockSettingsFragment.f11235d = bVar;
    }

    public static void c(AppLockSettingsFragment appLockSettingsFragment, GenericViewModelFactory<w1> genericViewModelFactory) {
        appLockSettingsFragment.f11234c = genericViewModelFactory;
    }
}