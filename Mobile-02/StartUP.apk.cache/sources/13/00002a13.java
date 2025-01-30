package com.coinbase.walletengine.models;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: BTCLikeServiceConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "", "", "component1", "()Ljava/lang/String;", "serviceUrl", "copy", "(Ljava/lang/String;)Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getServiceUrl", "<init>", "(Ljava/lang/String;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class BTCLikeServiceConfig {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<BTCLikeServiceConfig> jsonAdapter;
    private static final Moshi moshi;
    @Json(name = "serviceUrl")
    private final String serviceUrl;

    /* compiled from: BTCLikeServiceConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/models/BTCLikeServiceConfig$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$wallet_engine_release", "()Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<BTCLikeServiceConfig> getJsonAdapter$wallet_engine_release() {
            return BTCLikeServiceConfig.jsonAdapter;
        }
    }

    static {
        Moshi build = new Moshi.Builder().build();
        moshi = build;
        jsonAdapter = build.adapter(BTCLikeServiceConfig.class);
    }

    public BTCLikeServiceConfig(String serviceUrl) {
        m.g(serviceUrl, "serviceUrl");
        this.serviceUrl = serviceUrl;
    }

    public static /* synthetic */ BTCLikeServiceConfig copy$default(BTCLikeServiceConfig bTCLikeServiceConfig, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bTCLikeServiceConfig.serviceUrl;
        }
        return bTCLikeServiceConfig.copy(str);
    }

    public final String component1() {
        return this.serviceUrl;
    }

    public final BTCLikeServiceConfig copy(String serviceUrl) {
        m.g(serviceUrl, "serviceUrl");
        return new BTCLikeServiceConfig(serviceUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BTCLikeServiceConfig) && m.c(this.serviceUrl, ((BTCLikeServiceConfig) obj).serviceUrl);
    }

    public final String getServiceUrl() {
        return this.serviceUrl;
    }

    public int hashCode() {
        return this.serviceUrl.hashCode();
    }

    public String toString() {
        return "BTCLikeServiceConfig(serviceUrl=" + this.serviceUrl + ')';
    }
}