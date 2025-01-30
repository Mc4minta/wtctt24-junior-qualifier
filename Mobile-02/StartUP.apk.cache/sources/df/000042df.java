package com.toshi.view.fragment;

import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import e.j.n.y1;

/* compiled from: AuthenticationFragment_MembersInjector.java */
/* loaded from: classes2.dex */
public final class d0 implements f.b<AuthenticationFragment> {
    public static void a(AuthenticationFragment authenticationFragment, AuthenticationHelper authenticationHelper) {
        authenticationFragment.f11240d = authenticationHelper;
    }

    public static void b(AuthenticationFragment authenticationFragment, e.j.l.n.b bVar) {
        authenticationFragment.f11241e = bVar;
    }

    public static void c(AuthenticationFragment authenticationFragment, GenericViewModelFactory<y1> genericViewModelFactory) {
        authenticationFragment.f11242f = genericViewModelFactory;
    }
}