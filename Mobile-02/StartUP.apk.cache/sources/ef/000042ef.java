package com.toshi.view.fragment;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import e.j.n.s2;

/* compiled from: NetworkSwitcherFragment_MembersInjector.java */
/* loaded from: classes2.dex */
public final class l0 implements f.b<NetworkSwitcherFragment> {
    public static void a(NetworkSwitcherFragment networkSwitcherFragment, AuthenticationHelper authenticationHelper) {
        networkSwitcherFragment.f11278e = authenticationHelper;
    }

    public static void b(NetworkSwitcherFragment networkSwitcherFragment, GenericViewModelFactory<s2> genericViewModelFactory) {
        networkSwitcherFragment.a = genericViewModelFactory;
    }
}