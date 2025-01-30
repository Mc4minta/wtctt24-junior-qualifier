package com.coinbase.wallet.commonui.di;

import androidx.lifecycle.b0;
import f.a;
import f.c.c;
import f.c.d;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class GenericViewModelFactory_Factory<T extends b0> implements d<GenericViewModelFactory<T>> {
    private final Provider<T> viewModelProvider;

    public GenericViewModelFactory_Factory(Provider<T> provider) {
        this.viewModelProvider = provider;
    }

    public static <T extends b0> GenericViewModelFactory_Factory<T> create(Provider<T> provider) {
        return new GenericViewModelFactory_Factory<>(provider);
    }

    public static <T extends b0> GenericViewModelFactory<T> newInstance(a<T> aVar) {
        return new GenericViewModelFactory<>(aVar);
    }

    @Override // javax.inject.Provider
    public GenericViewModelFactory<T> get() {
        return newInstance(c.a(this.viewModelProvider));
    }
}