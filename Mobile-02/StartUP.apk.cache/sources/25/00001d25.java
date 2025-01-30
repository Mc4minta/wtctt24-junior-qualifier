package com.coinbase.wallet.featureflags.models;

import kotlin.Metadata;

/* compiled from: FeatureFlag.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/featureflags/models/FeatureFlag;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "MCD_POPUP", "ENS", "SOCIAL_SEND", "LENDING", "ONRAMP_USA", "NATIVE_DEX", "ONRAMP_EU", "ADJUSTABLE_MINER_FEE", "OPTIMISM_L2_BETA_PROMPT", "XRP_SKIP_PROXY", "POLYGON_ENABLED", "BSC_ENABLED", "FANTOM_ENABLED", "ARBITRUM_ENABLED", "XDAI_ENABLED", "AVALANCHE_ENABLED", "L2_POLYGON_DEX", "featureflags_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum FeatureFlag {
    MCD_POPUP("mcd_popup"),
    ENS("ens"),
    SOCIAL_SEND("social_send"),
    LENDING("lending"),
    ONRAMP_USA("onramp_usa"),
    NATIVE_DEX("native_dex"),
    ONRAMP_EU("onramp_eu"),
    ADJUSTABLE_MINER_FEE("adjustable_miner_fee"),
    OPTIMISM_L2_BETA_PROMPT("optimism_l2_beta_prompt"),
    XRP_SKIP_PROXY("xrp_skip_proxy"),
    POLYGON_ENABLED("polygon_enabled"),
    BSC_ENABLED("bsc_enabled"),
    FANTOM_ENABLED("fantom_enabled"),
    ARBITRUM_ENABLED("arbitrum_enabled"),
    XDAI_ENABLED("xdai_enabled"),
    AVALANCHE_ENABLED("avalanche_enabled"),
    L2_POLYGON_DEX("l2_polygon_dex");
    
    private final String value;

    FeatureFlag(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}