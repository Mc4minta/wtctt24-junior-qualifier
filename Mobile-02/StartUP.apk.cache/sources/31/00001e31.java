package com.coinbase.wallet.features.debugmenu.util;

import com.coinbase.wallet.application.model.Production;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.models.ConsumerProduction;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: DebugSettings.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001d\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/features/debugmenu/util/DebugSettings;", "", "Lkotlin/x;", "setup", "()V", "", "skipProxy", "", "getWalletXRPNodeUrl", "(Z)Ljava/lang/String;", "url", "setWalletXRPNodeUrl", "(Ljava/lang/String;)V", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebviewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "getConsumerWebviewConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "walletBlockchainUrl", "Ljava/lang/String;", "getWalletBlockchainUrl", "()Ljava/lang/String;", "walletApiUrl", "getWalletApiUrl", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "consumerNetworkConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "getConsumerNetworkConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DebugSettings {
    private final ConsumerNetworkConfig consumerNetworkConfig;
    private final ConsumerWebViewConfig consumerWebviewConfig;
    private final String walletApiUrl = Production.walletApi;
    private final String walletBlockchainUrl = Production.walletBlockchain;

    public DebugSettings() {
        ConsumerProduction consumerProduction = ConsumerProduction.INSTANCE;
        this.consumerNetworkConfig = consumerProduction.getNetworkConfig();
        this.consumerWebviewConfig = consumerProduction.getWebviewConfig();
    }

    public final ConsumerNetworkConfig getConsumerNetworkConfig() {
        return this.consumerNetworkConfig;
    }

    public final ConsumerWebViewConfig getConsumerWebviewConfig() {
        return this.consumerWebviewConfig;
    }

    public final String getWalletApiUrl() {
        return this.walletApiUrl;
    }

    public final String getWalletBlockchainUrl() {
        return this.walletBlockchainUrl;
    }

    public final String getWalletXRPNodeUrl(boolean z) {
        return z ? Production.walletXRPNodeUrlDirect : Production.walletXRPNodeUrlProxy;
    }

    public final void setWalletXRPNodeUrl(String url) {
        m.g(url, "url");
    }

    public final void setup() {
    }
}