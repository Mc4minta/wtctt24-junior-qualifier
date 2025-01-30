package com.coinbase.walletengine.models;

import com.coinbase.wallet.qr.models.WalletConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonClass;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WalletEngineConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00011B?\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JV\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010\nR\u001c\u0010\u0017\u001a\u00020\u000e8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010\rR\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b.\u0010\u0004¨\u00062"}, d2 = {"Lcom/coinbase/walletengine/models/WalletEngineConfig;", "", "Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "component1", "()Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "component2", "component3", "component4", "Lcom/coinbase/walletengine/models/XRPServiceConfig;", "component5", "()Lcom/coinbase/walletengine/models/XRPServiceConfig;", "Lcom/coinbase/walletengine/models/StellarServiceConfig;", "component6", "()Lcom/coinbase/walletengine/models/StellarServiceConfig;", "Lcom/coinbase/walletengine/models/ResolverServiceConfig;", "component7", "()Lcom/coinbase/walletengine/models/ResolverServiceConfig;", "bitcoin", WalletConstants.URIPrefixes.BCH, "litecoin", "dogecoin", WalletConstants.URIPrefixes.XRP_ALT, WalletConstants.URIPrefixes.XLM_ALT, "resolver", "copy", "(Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/XRPServiceConfig;Lcom/coinbase/walletengine/models/StellarServiceConfig;Lcom/coinbase/walletengine/models/ResolverServiceConfig;)Lcom/coinbase/walletengine/models/WalletEngineConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;", "getBitcoin", "Lcom/coinbase/walletengine/models/XRPServiceConfig;", "getXrp", "Lcom/coinbase/walletengine/models/ResolverServiceConfig;", "getResolver", "Lcom/coinbase/walletengine/models/StellarServiceConfig;", "getStellar", "getBitcoincash", "getDogecoin", "getLitecoin", "<init>", "(Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/BTCLikeServiceConfig;Lcom/coinbase/walletengine/models/XRPServiceConfig;Lcom/coinbase/walletengine/models/StellarServiceConfig;Lcom/coinbase/walletengine/models/ResolverServiceConfig;)V", "Companion", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletEngineConfig {
    public static final Companion Companion = new Companion(null);
    private static final JsonAdapter<WalletEngineConfig> jsonAdapter;
    private static final Moshi moshi;
    @Json(name = "bitcoin")
    private final BTCLikeServiceConfig bitcoin;
    @Json(name = WalletConstants.URIPrefixes.BCH)
    private final BTCLikeServiceConfig bitcoincash;
    @Json(name = "dogecoin")
    private final BTCLikeServiceConfig dogecoin;
    @Json(name = "litecoin")
    private final BTCLikeServiceConfig litecoin;
    @Json(name = "resolver")
    private final ResolverServiceConfig resolver;
    @Json(name = WalletConstants.URIPrefixes.XLM_ALT)
    private final StellarServiceConfig stellar;
    @Json(name = WalletConstants.URIPrefixes.XRP_ALT)
    private final XRPServiceConfig xrp;

    /* compiled from: WalletEngineConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR@\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\n \u0004*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/walletengine/models/WalletEngineConfig$Companion;", "", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/coinbase/walletengine/models/WalletEngineConfig;", "kotlin.jvm.PlatformType", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "getJsonAdapter$wallet_engine_release", "()Lcom/squareup/moshi/JsonAdapter;", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "()V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JsonAdapter<WalletEngineConfig> getJsonAdapter$wallet_engine_release() {
            return WalletEngineConfig.jsonAdapter;
        }
    }

    static {
        Moshi build = new Moshi.Builder().build();
        moshi = build;
        jsonAdapter = build.adapter(WalletEngineConfig.class).serializeNulls();
    }

    public WalletEngineConfig(BTCLikeServiceConfig bitcoin, BTCLikeServiceConfig bitcoincash, BTCLikeServiceConfig litecoin, BTCLikeServiceConfig dogecoin, XRPServiceConfig xrp, StellarServiceConfig stellar, ResolverServiceConfig resolver) {
        m.g(bitcoin, "bitcoin");
        m.g(bitcoincash, "bitcoincash");
        m.g(litecoin, "litecoin");
        m.g(dogecoin, "dogecoin");
        m.g(xrp, "xrp");
        m.g(stellar, "stellar");
        m.g(resolver, "resolver");
        this.bitcoin = bitcoin;
        this.bitcoincash = bitcoincash;
        this.litecoin = litecoin;
        this.dogecoin = dogecoin;
        this.xrp = xrp;
        this.stellar = stellar;
        this.resolver = resolver;
    }

    public static /* synthetic */ WalletEngineConfig copy$default(WalletEngineConfig walletEngineConfig, BTCLikeServiceConfig bTCLikeServiceConfig, BTCLikeServiceConfig bTCLikeServiceConfig2, BTCLikeServiceConfig bTCLikeServiceConfig3, BTCLikeServiceConfig bTCLikeServiceConfig4, XRPServiceConfig xRPServiceConfig, StellarServiceConfig stellarServiceConfig, ResolverServiceConfig resolverServiceConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bTCLikeServiceConfig = walletEngineConfig.bitcoin;
        }
        if ((i2 & 2) != 0) {
            bTCLikeServiceConfig2 = walletEngineConfig.bitcoincash;
        }
        BTCLikeServiceConfig bTCLikeServiceConfig5 = bTCLikeServiceConfig2;
        if ((i2 & 4) != 0) {
            bTCLikeServiceConfig3 = walletEngineConfig.litecoin;
        }
        BTCLikeServiceConfig bTCLikeServiceConfig6 = bTCLikeServiceConfig3;
        if ((i2 & 8) != 0) {
            bTCLikeServiceConfig4 = walletEngineConfig.dogecoin;
        }
        BTCLikeServiceConfig bTCLikeServiceConfig7 = bTCLikeServiceConfig4;
        if ((i2 & 16) != 0) {
            xRPServiceConfig = walletEngineConfig.xrp;
        }
        XRPServiceConfig xRPServiceConfig2 = xRPServiceConfig;
        if ((i2 & 32) != 0) {
            stellarServiceConfig = walletEngineConfig.stellar;
        }
        StellarServiceConfig stellarServiceConfig2 = stellarServiceConfig;
        if ((i2 & 64) != 0) {
            resolverServiceConfig = walletEngineConfig.resolver;
        }
        return walletEngineConfig.copy(bTCLikeServiceConfig, bTCLikeServiceConfig5, bTCLikeServiceConfig6, bTCLikeServiceConfig7, xRPServiceConfig2, stellarServiceConfig2, resolverServiceConfig);
    }

    public final BTCLikeServiceConfig component1() {
        return this.bitcoin;
    }

    public final BTCLikeServiceConfig component2() {
        return this.bitcoincash;
    }

    public final BTCLikeServiceConfig component3() {
        return this.litecoin;
    }

    public final BTCLikeServiceConfig component4() {
        return this.dogecoin;
    }

    public final XRPServiceConfig component5() {
        return this.xrp;
    }

    public final StellarServiceConfig component6() {
        return this.stellar;
    }

    public final ResolverServiceConfig component7() {
        return this.resolver;
    }

    public final WalletEngineConfig copy(BTCLikeServiceConfig bitcoin, BTCLikeServiceConfig bitcoincash, BTCLikeServiceConfig litecoin, BTCLikeServiceConfig dogecoin, XRPServiceConfig xrp, StellarServiceConfig stellar, ResolverServiceConfig resolver) {
        m.g(bitcoin, "bitcoin");
        m.g(bitcoincash, "bitcoincash");
        m.g(litecoin, "litecoin");
        m.g(dogecoin, "dogecoin");
        m.g(xrp, "xrp");
        m.g(stellar, "stellar");
        m.g(resolver, "resolver");
        return new WalletEngineConfig(bitcoin, bitcoincash, litecoin, dogecoin, xrp, stellar, resolver);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WalletEngineConfig) {
            WalletEngineConfig walletEngineConfig = (WalletEngineConfig) obj;
            return m.c(this.bitcoin, walletEngineConfig.bitcoin) && m.c(this.bitcoincash, walletEngineConfig.bitcoincash) && m.c(this.litecoin, walletEngineConfig.litecoin) && m.c(this.dogecoin, walletEngineConfig.dogecoin) && m.c(this.xrp, walletEngineConfig.xrp) && m.c(this.stellar, walletEngineConfig.stellar) && m.c(this.resolver, walletEngineConfig.resolver);
        }
        return false;
    }

    public final BTCLikeServiceConfig getBitcoin() {
        return this.bitcoin;
    }

    public final BTCLikeServiceConfig getBitcoincash() {
        return this.bitcoincash;
    }

    public final BTCLikeServiceConfig getDogecoin() {
        return this.dogecoin;
    }

    public final BTCLikeServiceConfig getLitecoin() {
        return this.litecoin;
    }

    public final ResolverServiceConfig getResolver() {
        return this.resolver;
    }

    public final StellarServiceConfig getStellar() {
        return this.stellar;
    }

    public final XRPServiceConfig getXrp() {
        return this.xrp;
    }

    public int hashCode() {
        return (((((((((((this.bitcoin.hashCode() * 31) + this.bitcoincash.hashCode()) * 31) + this.litecoin.hashCode()) * 31) + this.dogecoin.hashCode()) * 31) + this.xrp.hashCode()) * 31) + this.stellar.hashCode()) * 31) + this.resolver.hashCode();
    }

    public String toString() {
        return "WalletEngineConfig(bitcoin=" + this.bitcoin + ", bitcoincash=" + this.bitcoincash + ", litecoin=" + this.litecoin + ", dogecoin=" + this.dogecoin + ", xrp=" + this.xrp + ", stellar=" + this.stellar + ", resolver=" + this.resolver + ')';
    }
}