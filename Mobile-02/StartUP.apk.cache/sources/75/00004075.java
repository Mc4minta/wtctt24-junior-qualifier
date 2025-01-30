package com.toshi.db;

import javax.inject.Provider;

/* compiled from: DerivedDatabaseDestroyable_Factory.java */
/* loaded from: classes2.dex */
public final class d implements f.c.d<c> {
    private final Provider<DerivedDatabase> a;

    public d(Provider<DerivedDatabase> provider) {
        this.a = provider;
    }

    public static d a(Provider<DerivedDatabase> provider) {
        return new d(provider);
    }

    public static c c(DerivedDatabase derivedDatabase) {
        return new c(derivedDatabase);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public c get() {
        return c(this.a.get());
    }
}