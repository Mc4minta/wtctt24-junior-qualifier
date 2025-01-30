package com.coinbase.wallet.application;

import android.app.Application;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.blockchains.models.WalletAddress;
import com.coinbase.wallet.common.extensions.WalletRepository_CommonKt;
import com.coinbase.wallet.consumer.di.ConsumerCoreComponent;
import com.coinbase.wallet.consumer.di.DaggerConsumerCoreComponent;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.di.AppComponent;
import com.coinbase.wallet.di.AppCoreComponent;
import com.coinbase.wallet.di.DaggerAppComponent;
import com.coinbase.wallet.di.DaggerAppCoreComponent;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.featureflags.models.FeatureFlag;
import com.coinbase.wallet.features.debugmenu.util.DebugSettings;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.lending.di.DaggerLendComponent;
import com.coinbase.wallet.lending.di.LendComponent;
import com.coinbase.wallet.performance.Tracer;
import com.coinbase.wallet.swap.di.DaggerSwapComponent;
import com.coinbase.wallet.wallets.di.CryptoContainer;
import com.coinbase.wallet.wallets.di.WalletsContainer;
import com.coinbase.walletengine.WalletEngine;
import h.c.s;
import h.c.x;
import java.net.URL;
import kotlin.Metadata;

/* compiled from: BaseApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/di/AppComponent;", "<anonymous>", "()Lcom/coinbase/wallet/di/AppComponent;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class BaseApplication$Companion$component$2 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<AppComponent> {
    public static final BaseApplication$Companion$component$2 INSTANCE = new BaseApplication$Companion$component$2();

    BaseApplication$Companion$component$2() {
        super(0);
    }

    public static /* synthetic */ WalletAddress a(Wallet wallet) {
        return m634invoke$lambda1$lambda0(wallet);
    }

    public static /* synthetic */ x b(WalletsContainer walletsContainer, Network network) {
        return m633invoke$lambda1(walletsContainer, network);
    }

    /* renamed from: invoke$lambda-1 */
    public static final x m633invoke$lambda1(WalletsContainer walletsContainer, Network network) {
        kotlin.jvm.internal.m.g(walletsContainer, "$walletsContainer");
        kotlin.jvm.internal.m.g(network, "network");
        s<Optional<Wallet>> observeWallet = WalletRepository_CommonKt.observeWallet(walletsContainer.walletRepository(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(network));
        kotlin.jvm.internal.m.f(observeWallet, "walletsContainer.walletRepository()\n                        .observeWallet(\n                            Blockchain.ETHEREUM,\n                            EthereumBasedConfiguration.ETH.currencyCodeForNetwork(network)\n                        )");
        s<R> map = observeWallet.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.application.BaseApplication$Companion$component$2$invoke$lambda-1$$inlined$unwrap$1
            public final boolean test(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable() != null;
            }

            @Override // h.c.m0.p
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test((Optional) ((Optional) obj));
            }
        }).map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.BaseApplication$Companion$component$2$invoke$lambda-1$$inlined$unwrap$2
            public final T apply(Optional<? extends T> it) {
                kotlin.jvm.internal.m.g(it, "it");
                return it.toNullable();
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        kotlin.jvm.internal.m.f(map, "this\n    .filter { it.toNullable() != null }\n    .map { it.toNullable() }");
        return map.map(new h.c.m0.n() { // from class: com.coinbase.wallet.application.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BaseApplication$Companion$component$2.a((Wallet) obj);
            }
        });
    }

    /* renamed from: invoke$lambda-1$lambda-0 */
    public static final WalletAddress m634invoke$lambda1$lambda0(Wallet it) {
        kotlin.jvm.internal.m.g(it, "it");
        return (WalletAddress) kotlin.a0.p.Y(it.getAddresses());
    }

    @Override // kotlin.e0.c.a
    public final AppComponent invoke() {
        DebugSettings debugSettings = new DebugSettings();
        BaseApplication.Companion companion = BaseApplication.Companion;
        BaseApplication companion2 = companion.getInstance();
        Tracing tracing = Tracer.INSTANCE;
        CryptoContainer cryptoContainer = new CryptoContainer(companion2, tracing, debugSettings.getWalletApiUrl());
        AppCoreComponent create = DaggerAppCoreComponent.factory().create(companion.getInstance(), cryptoContainer, debugSettings.getWalletApiUrl());
        ConsumerCoreComponent create2 = DaggerConsumerCoreComponent.factory().create(create.store(), create.baseApplication(), create.moshi(), create.buildConfigWrapper(), debugSettings.getConsumerNetworkConfig(), debugSettings.getConsumerWebviewConfig());
        final WalletsContainer walletsContainer = new WalletsContainer(create.retrofitWalletService(), create.store(), create2.coinbaseSdk(), cryptoContainer, tracing, debugSettings.getWalletApiUrl(), debugSettings.getWalletBlockchainUrl(), debugSettings.getWalletXRPNodeUrl(create.featureFlagsRepository().valueSync(FeatureFlag.XRP_SKIP_PROXY)));
        s<R> walletAddressObservable = walletsContainer.walletRepository().observeNetwork(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)).flatMap(new h.c.m0.n() { // from class: com.coinbase.wallet.application.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return BaseApplication$Companion$component$2.b(WalletsContainer.this, (Network) obj);
            }
        });
        LendComponent.Factory factory = DaggerLendComponent.factory();
        Application companion3 = companion.getInstance();
        WalletEngine walletEngine = walletsContainer.walletEngine();
        kotlin.jvm.internal.m.f(walletAddressObservable, "walletAddressObservable");
        return DaggerAppComponent.factory().create(cryptoContainer, walletsContainer, create, factory.create(companion3, walletEngine, walletAddressObservable, tracing, debugSettings.getWalletApiUrl(), create.store()), create2, DaggerSwapComponent.factory().create(companion.getInstance(), cryptoContainer.cipherCore(), walletsContainer.addressDao(), walletsContainer.erc20ContractAPI(), walletsContainer.minerFeeAPI(), new HTTPService(new URL(create.walletApiUrl())), create.store()));
    }
}