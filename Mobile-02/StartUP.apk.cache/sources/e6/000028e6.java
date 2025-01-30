package com.coinbase.wallet.wallets.di;

import android.app.Application;
import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreConfig;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.EthereumNetworkConfig;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.core.extensions.Map_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.wallets.di.qualifier.WalletApiUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CryptoModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/wallets/di/CryptoModule;", "", "<init>", "()V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class CryptoModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: CryptoModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/wallets/di/CryptoModule$Companion;", "", "Landroid/app/Application;", "app", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "", "walletApiServiceUrl", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "providesCipherCoreInterface", "(Landroid/app/Application;Lcom/coinbase/wallet/core/interfaces/Tracing;Ljava/lang/String;)Lcom/coinbase/ciphercore/CipherCoreInterface;", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CipherCoreInterface providesCipherCoreInterface(Application app, Tracing tracer, @WalletApiUrl String walletApiServiceUrl) {
            m.g(app, "app");
            m.g(tracer, "tracer");
            m.g(walletApiServiceUrl, "walletApiServiceUrl");
            CipherCoreConfig create = CipherCoreConfig.Companion.create(walletApiServiceUrl);
            create.getEthereum().getNetworks().put(Integer.valueOf(EthereumChain.ETHEREUM_CLASSIC_MAINNET.getChainId()), new EthereumNetworkConfig("Ethereum Classic", "https://etc.wallet.coinbase.com/api/", Strings_CoreKt.getEmpty(Strings.INSTANCE)));
            ((EthereumNetworkConfig) Map_CoreKt.require(create.getEthereum().getNetworks(), Integer.valueOf(EthereumChain.ETHEREUM_MAINNET.getChainId()))).setGasStationUrl(m.o(walletApiServiceUrl, "/rpc/v2/getMainnetGasPrices"));
            CipherCore cipherCore = new CipherCore(tracer);
            cipherCore.initialize(app, walletApiServiceUrl, create);
            return cipherCore;
        }
    }

    public static final CipherCoreInterface providesCipherCoreInterface(Application application, Tracing tracing, @WalletApiUrl String str) {
        return Companion.providesCipherCoreInterface(application, tracing, str);
    }
}