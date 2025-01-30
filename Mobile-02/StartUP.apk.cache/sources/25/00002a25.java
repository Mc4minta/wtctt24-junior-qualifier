package com.coinbase.walletengine.models;

import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotification;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: XRPServiceConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/walletengine/models/XRPServiceConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", WalletLinkPushNotification.serverUrlKey, "testnetServerUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletengine/models/XRPServiceConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTestnetServerUrl", "getServerUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class XRPServiceConfig {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<XRPServiceConfig> jsonAdapter;
    private static final Moshi moshi;
    @Json(name = WalletLinkPushNotification.serverUrlKey)
    private final String serverUrl;
    @Json(name = "testnetServerUrl")
    private final String testnetServerUrl;

    /* compiled from: XRPServiceConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/models/XRPServiceConfig$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/XRPServiceConfig;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$wallet_engine_release", "()Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<XRPServiceConfig> getJsonAdapter$wallet_engine_release() {
            return XRPServiceConfig.jsonAdapter;
        }
    }

    static {
        Moshi build = new Moshi.Builder().build();
        moshi = build;
        jsonAdapter = build.adapter(XRPServiceConfig.class);
    }

    public XRPServiceConfig(String serverUrl, String testnetServerUrl) {
        m.g(serverUrl, "serverUrl");
        m.g(testnetServerUrl, "testnetServerUrl");
        this.serverUrl = serverUrl;
        this.testnetServerUrl = testnetServerUrl;
    }

    public static /* synthetic */ XRPServiceConfig copy$default(XRPServiceConfig xRPServiceConfig, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = xRPServiceConfig.serverUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = xRPServiceConfig.testnetServerUrl;
        }
        return xRPServiceConfig.copy(str, str2);
    }

    public final String component1() {
        return this.serverUrl;
    }

    public final String component2() {
        return this.testnetServerUrl;
    }

    public final XRPServiceConfig copy(String serverUrl, String testnetServerUrl) {
        m.g(serverUrl, "serverUrl");
        m.g(testnetServerUrl, "testnetServerUrl");
        return new XRPServiceConfig(serverUrl, testnetServerUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof XRPServiceConfig) {
            XRPServiceConfig xRPServiceConfig = (XRPServiceConfig) obj;
            return m.c(this.serverUrl, xRPServiceConfig.serverUrl) && m.c(this.testnetServerUrl, xRPServiceConfig.testnetServerUrl);
        }
        return false;
    }

    public final String getServerUrl() {
        return this.serverUrl;
    }

    public final String getTestnetServerUrl() {
        return this.testnetServerUrl;
    }

    public int hashCode() {
        return (this.serverUrl.hashCode() * 31) + this.testnetServerUrl.hashCode();
    }

    public String toString() {
        return "XRPServiceConfig(serverUrl=" + this.serverUrl + ", testnetServerUrl=" + this.testnetServerUrl + ')';
    }
}