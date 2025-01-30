package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.BuildConfig;
import kotlin.Metadata;

/* compiled from: ConsumerProduction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerProduction;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "webviewConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "getWebviewConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "networkConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "getNetworkConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerProduction {
    public static final ConsumerProduction INSTANCE = new ConsumerProduction();
    private static final ConsumerNetworkConfig networkConfig = new ConsumerNetworkConfig("https://api.coinbase.com/v2/", "https://api.coinbase.com/v3/", "https://www.coinbase.com/oauth/", BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, ApiConstants.VERSION, false, 64, null);
    private static final ConsumerWebViewConfig webviewConfig = new ConsumerWebViewConfig("https", "www.coinbase.com", null, "coinbase.com");

    private ConsumerProduction() {
    }

    public final ConsumerNetworkConfig getNetworkConfig() {
        return networkConfig;
    }

    public final ConsumerWebViewConfig getWebviewConfig() {
        return webviewConfig;
    }
}