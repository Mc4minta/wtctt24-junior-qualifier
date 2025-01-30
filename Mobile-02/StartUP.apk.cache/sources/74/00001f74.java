package com.coinbase.wallet.features.send.di;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.resolver.ResolverService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ENSModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/features/send/di/ENSModule;", "", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ENSModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ENSModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/di/ENSModule$Companion;", "", "Lcom/coinbase/walletengine/WalletEngine;", "walletEngine", "Lcom/coinbase/walletengine/services/resolver/ResolverService;", "providesResolverService", "(Lcom/coinbase/walletengine/WalletEngine;)Lcom/coinbase/walletengine/services/resolver/ResolverService;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final ResolverService providesResolverService(WalletEngine walletEngine) {
            m.g(walletEngine, "walletEngine");
            return new ResolverService(walletEngine);
        }
    }

    @ApplicationScoped
    public static final ResolverService providesResolverService(WalletEngine walletEngine) {
        return Companion.providesResolverService(walletEngine);
    }
}