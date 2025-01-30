package com.toshi.db;

import javax.inject.Provider;

/* compiled from: WalletDatabaseDestroyable_Factory.java */
/* loaded from: classes2.dex */
public final class f implements f.c.d<e> {
    private final Provider<WalletDatabase> a;

    public f(Provider<WalletDatabase> provider) {
        this.a = provider;
    }

    public static f a(Provider<WalletDatabase> provider) {
        return new f(provider);
    }

    public static e c(WalletDatabase walletDatabase) {
        return new e(walletDatabase);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public e get() {
        return c(this.a.get());
    }
}