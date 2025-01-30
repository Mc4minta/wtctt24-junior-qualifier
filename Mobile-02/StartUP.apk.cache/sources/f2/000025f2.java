package com.coinbase.wallet.routing.repositories;

import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DeepLinkRepository_Factory implements f.c.d<DeepLinkRepository> {
    private final Provider<io.branch.referral.b> branchProvider;

    public DeepLinkRepository_Factory(Provider<io.branch.referral.b> provider) {
        this.branchProvider = provider;
    }

    public static DeepLinkRepository_Factory create(Provider<io.branch.referral.b> provider) {
        return new DeepLinkRepository_Factory(provider);
    }

    public static DeepLinkRepository newInstance(io.branch.referral.b bVar) {
        return new DeepLinkRepository(bVar);
    }

    @Override // javax.inject.Provider
    public DeepLinkRepository get() {
        return newInstance(this.branchProvider.get());
    }
}