package com.toshi.view.activity.pin;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import e.j.n.p3.s;

/* compiled from: SwitchPinLockFragment_MembersInjector.java */
/* loaded from: classes2.dex */
public final class l implements f.b<SwitchPinLockFragment> {
    public static void a(SwitchPinLockFragment switchPinLockFragment, AuthenticationHelper authenticationHelper) {
        switchPinLockFragment.f11134b = authenticationHelper;
    }

    public static void b(SwitchPinLockFragment switchPinLockFragment, GenericViewModelFactory<s> genericViewModelFactory) {
        switchPinLockFragment.f11135c = genericViewModelFactory;
    }
}