package com.toshi.view.fragment;

import com.squareup.moshi.Moshi;
import javax.inject.Provider;

/* compiled from: DisplayCoinAddressFragmentFactory_Factory.java */
/* loaded from: classes2.dex */
public final class i0 implements f.c.d<h0> {
    private final Provider<Moshi> a;

    public i0(Provider<Moshi> provider) {
        this.a = provider;
    }

    public static i0 a(Provider<Moshi> provider) {
        return new i0(provider);
    }

    public static h0 c(Moshi moshi) {
        return new h0(moshi);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public h0 get() {
        return c(this.a.get());
    }
}