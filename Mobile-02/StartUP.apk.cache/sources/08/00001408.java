package com.coinbase.wallet.blockchains.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NetworkSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "", "", "component1", "()Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/Network;", "component2", "()Lcom/coinbase/wallet/blockchains/models/Network;", ApiConstants.NAME, "network", "copy", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Lcom/coinbase/wallet/blockchains/models/Network;", "getNetwork", "<init>", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NetworkSettingItem {
    public static final Companion Companion = new Companion(null);
    private final String name;
    private final Network network;

    /* compiled from: NetworkSetting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem$Companion;", "", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NetworkSettingItem(String name, Network network) {
        m.g(name, "name");
        m.g(network, "network");
        this.name = name;
        this.network = network;
    }

    public static /* synthetic */ NetworkSettingItem copy$default(NetworkSettingItem networkSettingItem, String str, Network network, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = networkSettingItem.name;
        }
        if ((i2 & 2) != 0) {
            network = networkSettingItem.network;
        }
        return networkSettingItem.copy(str, network);
    }

    public final String component1() {
        return this.name;
    }

    public final Network component2() {
        return this.network;
    }

    public final NetworkSettingItem copy(String name, Network network) {
        m.g(name, "name");
        m.g(network, "network");
        return new NetworkSettingItem(name, network);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NetworkSettingItem) {
            NetworkSettingItem networkSettingItem = (NetworkSettingItem) obj;
            return m.c(this.name, networkSettingItem.name) && m.c(this.network, networkSettingItem.network);
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final Network getNetwork() {
        return this.network;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.network.hashCode();
    }

    public String toString() {
        return "NetworkSettingItem(name=" + this.name + ", network=" + this.network + ')';
    }
}