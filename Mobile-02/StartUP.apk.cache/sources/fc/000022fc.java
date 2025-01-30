package com.coinbase.wallet.features.walletlink.di;

import androidx.lifecycle.b0;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.model.Production;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkCompleteViewModel;
import com.coinbase.walletlink.WalletLink;
import com.coinbase.walletlink.WalletLinkInterface;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletLinkModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/di/WalletLinkModule;", "", "Lcom/coinbase/wallet/features/walletlink/viewmodels/WalletLinkCompleteViewModel;", "walletLinkCompleteViewModel", "Landroidx/lifecycle/b0;", "providesWalletLinkCompleteViewModel", "(Lcom/coinbase/wallet/features/walletlink/viewmodels/WalletLinkCompleteViewModel;)Landroidx/lifecycle/b0;", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WalletLinkModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: WalletLinkModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/walletlink/di/WalletLinkModule$Companion;", "", "Lcom/coinbase/wallet/application/BaseApplication;", "app", "Lcom/coinbase/walletlink/WalletLinkInterface;", "provideWalletLinkInterface", "(Lcom/coinbase/wallet/application/BaseApplication;)Lcom/coinbase/walletlink/WalletLinkInterface;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final WalletLinkInterface provideWalletLinkInterface(BaseApplication app) {
            m.g(app, "app");
            return new WalletLink(new URL(m.o(Production.walletApi, "/rpc/v2/publishWalletLinkNotification")), app);
        }
    }

    @ApplicationScoped
    public static final WalletLinkInterface provideWalletLinkInterface(BaseApplication baseApplication) {
        return Companion.provideWalletLinkInterface(baseApplication);
    }

    public abstract b0 providesWalletLinkCompleteViewModel(WalletLinkCompleteViewModel walletLinkCompleteViewModel);
}