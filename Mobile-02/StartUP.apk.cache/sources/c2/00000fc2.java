package com.coinbase.ciphercore;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: CipherCoreConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/coinbase/ciphercore/EthereumNetworkConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", ApiConstants.NAME, "rpcUrl", "gasStationUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/ciphercore/EthereumNetworkConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRpcUrl", "setRpcUrl", "(Ljava/lang/String;)V", "getName", "setName", "getGasStationUrl", "setGasStationUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumNetworkConfig {
    @Json(name = "gasStationUrl")
    private String gasStationUrl;
    @Json(name = ApiConstants.NAME)
    private String name;
    @Json(name = "rpcUrl")
    private String rpcUrl;

    public EthereumNetworkConfig(String name, String rpcUrl, String gasStationUrl) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(rpcUrl, "rpcUrl");
        kotlin.jvm.internal.m.g(gasStationUrl, "gasStationUrl");
        this.name = name;
        this.rpcUrl = rpcUrl;
        this.gasStationUrl = gasStationUrl;
    }

    public static /* synthetic */ EthereumNetworkConfig copy$default(EthereumNetworkConfig ethereumNetworkConfig, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = ethereumNetworkConfig.name;
        }
        if ((i2 & 2) != 0) {
            str2 = ethereumNetworkConfig.rpcUrl;
        }
        if ((i2 & 4) != 0) {
            str3 = ethereumNetworkConfig.gasStationUrl;
        }
        return ethereumNetworkConfig.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.rpcUrl;
    }

    public final String component3() {
        return this.gasStationUrl;
    }

    public final EthereumNetworkConfig copy(String name, String rpcUrl, String gasStationUrl) {
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(rpcUrl, "rpcUrl");
        kotlin.jvm.internal.m.g(gasStationUrl, "gasStationUrl");
        return new EthereumNetworkConfig(name, rpcUrl, gasStationUrl);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EthereumNetworkConfig) {
            EthereumNetworkConfig ethereumNetworkConfig = (EthereumNetworkConfig) obj;
            return kotlin.jvm.internal.m.c(this.name, ethereumNetworkConfig.name) && kotlin.jvm.internal.m.c(this.rpcUrl, ethereumNetworkConfig.rpcUrl) && kotlin.jvm.internal.m.c(this.gasStationUrl, ethereumNetworkConfig.gasStationUrl);
        }
        return false;
    }

    public final String getGasStationUrl() {
        return this.gasStationUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRpcUrl() {
        return this.rpcUrl;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.rpcUrl.hashCode()) * 31) + this.gasStationUrl.hashCode();
    }

    public final void setGasStationUrl(String str) {
        kotlin.jvm.internal.m.g(str, "<set-?>");
        this.gasStationUrl = str;
    }

    public final void setName(String str) {
        kotlin.jvm.internal.m.g(str, "<set-?>");
        this.name = str;
    }

    public final void setRpcUrl(String str) {
        kotlin.jvm.internal.m.g(str, "<set-?>");
        this.rpcUrl = str;
    }

    public String toString() {
        return "EthereumNetworkConfig(name=" + this.name + ", rpcUrl=" + this.rpcUrl + ", gasStationUrl=" + this.gasStationUrl + ')';
    }
}