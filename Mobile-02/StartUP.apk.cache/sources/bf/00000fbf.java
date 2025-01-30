package com.coinbase.ciphercore;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: CipherCoreConfig.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/coinbase/ciphercore/EthereumConfig;", "", "", "", "Lcom/coinbase/ciphercore/EthereumNetworkConfig;", "component1", "()Ljava/util/Map;", "networks", "copy", "(Ljava/util/Map;)Lcom/coinbase/ciphercore/EthereumConfig;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getNetworks", "setNetworks", "(Ljava/util/Map;)V", "<init>", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumConfig {
    @Json(name = "networks")
    private Map<Integer, EthereumNetworkConfig> networks;

    public EthereumConfig(Map<Integer, EthereumNetworkConfig> networks) {
        kotlin.jvm.internal.m.g(networks, "networks");
        this.networks = networks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EthereumConfig copy$default(EthereumConfig ethereumConfig, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = ethereumConfig.networks;
        }
        return ethereumConfig.copy(map);
    }

    public final Map<Integer, EthereumNetworkConfig> component1() {
        return this.networks;
    }

    public final EthereumConfig copy(Map<Integer, EthereumNetworkConfig> networks) {
        kotlin.jvm.internal.m.g(networks, "networks");
        return new EthereumConfig(networks);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EthereumConfig) && kotlin.jvm.internal.m.c(this.networks, ((EthereumConfig) obj).networks);
    }

    public final Map<Integer, EthereumNetworkConfig> getNetworks() {
        return this.networks;
    }

    public int hashCode() {
        return this.networks.hashCode();
    }

    public final void setNetworks(Map<Integer, EthereumNetworkConfig> map) {
        kotlin.jvm.internal.m.g(map, "<set-?>");
        this.networks = map;
    }

    public String toString() {
        return "EthereumConfig(networks=" + this.networks + ')';
    }
}