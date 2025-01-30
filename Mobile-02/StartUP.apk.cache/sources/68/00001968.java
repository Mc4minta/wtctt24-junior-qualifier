package com.coinbase.wallet.di;

import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.service.WalletFirebaseMessagingService;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.di.ConsumerCoreComponent;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.lending.di.LendContainer;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.swap.di.SwapComponent;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import com.coinbase.wallet.wallets.di.CryptoContainer;
import com.coinbase.wallet.wallets.di.WalletsContainer;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;

/* compiled from: AppComponent.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0006\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/di/AppComponent;", "Ldagger/android/b;", "Lcom/coinbase/wallet/application/BaseApplication;", "Lcom/toshi/view/fragment/r0/e;", "pinLockDialog", "Lkotlin/x;", "inject", "(Lcom/toshi/view/fragment/r0/e;)V", "Lcom/toshi/view/fragment/r0/g;", "infoDialog", "(Lcom/toshi/view/fragment/r0/g;)V", "Lcom/squareup/moshi/Moshi;", "moshi", "()Lcom/squareup/moshi/Moshi;", "Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "featureFlagsRepository", "()Lcom/coinbase/wallet/featureflags/repositories/FeatureFlagsRepository;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "walletsDatabase", "()Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/application/service/WalletFirebaseMessagingService;", "walletFirebaseMessagingService", "(Lcom/coinbase/wallet/application/service/WalletFirebaseMessagingService;)V", "Factory", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface AppComponent extends dagger.android.b<BaseApplication> {

    /* compiled from: AppComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/di/AppComponent$Factory;", "", "Lcom/coinbase/wallet/wallets/di/CryptoContainer;", "cryptoContainer", "Lcom/coinbase/wallet/wallets/di/WalletsContainer;", "walletsContainer", "Lcom/coinbase/wallet/di/AppCoreComponent;", "appCoreComponent", "Lcom/coinbase/wallet/lending/di/LendContainer;", "lendContainer", "Lcom/coinbase/wallet/consumer/di/ConsumerCoreComponent;", "consumerCoreComponent", "Lcom/coinbase/wallet/swap/di/SwapComponent;", "swapComponent", "Lcom/coinbase/wallet/di/AppComponent;", "create", "(Lcom/coinbase/wallet/wallets/di/CryptoContainer;Lcom/coinbase/wallet/wallets/di/WalletsContainer;Lcom/coinbase/wallet/di/AppCoreComponent;Lcom/coinbase/wallet/lending/di/LendContainer;Lcom/coinbase/wallet/consumer/di/ConsumerCoreComponent;Lcom/coinbase/wallet/swap/di/SwapComponent;)Lcom/coinbase/wallet/di/AppComponent;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        AppComponent create(CryptoContainer cryptoContainer, WalletsContainer walletsContainer, AppCoreComponent appCoreComponent, LendContainer lendContainer, ConsumerCoreComponent consumerCoreComponent, SwapComponent swapComponent);
    }

    FeatureFlagsRepository featureFlagsRepository();

    void inject(WalletFirebaseMessagingService walletFirebaseMessagingService);

    void inject(com.toshi.view.fragment.r0.e eVar);

    void inject(com.toshi.view.fragment.r0.g gVar);

    @Override // dagger.android.b
    /* synthetic */ void inject(T t);

    Moshi moshi();

    Database<WalletsDatabase> walletsDatabase();
}