package com.coinbase.walletengine.models;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: StellarServiceConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/coinbase/walletengine/models/StellarServiceConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "horizonUrl", "testnetHorizonUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/walletengine/models/StellarServiceConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getHorizonUrl", "getTestnetHorizonUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StellarServiceConfig {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<StellarServiceConfig> jsonAdapter;
    private static final Moshi moshi;
    @Json(name = "horizonUrl")
    private final String horizonUrl;
    @Json(name = "testnetHorizonUrl")
    private final String testnetHorizonUrl;

    /* compiled from: StellarServiceConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/models/StellarServiceConfig$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/StellarServiceConfig;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$wallet_engine_release", "()Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<StellarServiceConfig> getJsonAdapter$wallet_engine_release() {
            return StellarServiceConfig.jsonAdapter;
        }
    }

    static {
        Moshi build = new Moshi.Builder().build();
        moshi = build;
        jsonAdapter = build.adapter(StellarServiceConfig.class);
    }

    public StellarServiceConfig(String horizonUrl, String testnetHorizonUrl) {
        m.g(horizonUrl, "horizonUrl");
        m.g(testnetHorizonUrl, "testnetHorizonUrl");
        this.horizonUrl = horizonUrl;
        this.testnetHorizonUrl = testnetHorizonUrl;
    }

    public static /* synthetic */ StellarServiceConfig copy$default(StellarServiceConfig stellarServiceConfig, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stellarServiceConfig.horizonUrl;
        }
        if ((i2 & 2) != 0) {
            str2 = stellarServiceConfig.testnetHorizonUrl;
        }
        return stellarServiceConfig.copy(str, str2);
    }

    public final String component1() {
        return this.horizonUrl;
    }

    public final String component2() {
        return this.testnetHorizonUrl;
    }

    public final StellarServiceConfig copy(String horizonUrl, String testnetHorizonUrl) {
        m.g(horizonUrl, "horizonUrl");
        m.g(testnetHorizonUrl, "testnetHorizonUrl");
        return new StellarServiceConfig(horizonUrl, testnetHorizonUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StellarServiceConfig) {
            StellarServiceConfig stellarServiceConfig = (StellarServiceConfig) obj;
            return m.c(this.horizonUrl, stellarServiceConfig.horizonUrl) && m.c(this.testnetHorizonUrl, stellarServiceConfig.testnetHorizonUrl);
        }
        return false;
    }

    public final String getHorizonUrl() {
        return this.horizonUrl;
    }

    public final String getTestnetHorizonUrl() {
        return this.testnetHorizonUrl;
    }

    public int hashCode() {
        return (this.horizonUrl.hashCode() * 31) + this.testnetHorizonUrl.hashCode();
    }

    public String toString() {
        return "StellarServiceConfig(horizonUrl=" + this.horizonUrl + ", testnetHorizonUrl=" + this.testnetHorizonUrl + ')';
    }
}