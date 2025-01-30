package com.coinbase.wallet.blockchains.models;

import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NetworkSetting.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "component1", "()Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "component2", "()Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "", "component3", "()Ljava/util/List;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "mainnetNetworkSettingItem", "networkSettingItems", "copy", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;Ljava/util/List;)Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "getMainnetNetworkSettingItem", "Ljava/util/List;", "getNetworkSettingItems", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", "getBlockchain", "<init>", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;Ljava/util/List;)V", "Companion", "blockchains_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NetworkSetting {
    public static final Companion Companion = new Companion(null);
    private final Blockchain blockchain;
    private final NetworkSettingItem mainnetNetworkSettingItem;
    private final List<NetworkSettingItem> networkSettingItems;

    /* compiled from: NetworkSetting.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSetting$Companion;", "", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "forTestnetBasedBlockchain", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "<init>", "()V", "blockchains_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NetworkSetting forTestnetBasedBlockchain(Blockchain blockchain) {
            List j2;
            m.g(blockchain, "blockchain");
            Network.Companion companion = Network.Companion;
            NetworkSettingItem networkSettingItem = new NetworkSettingItem("Mainnet", companion.createTestnetNetwork(false));
            j2 = r.j(networkSettingItem, new NetworkSettingItem("Testnet", companion.createTestnetNetwork(true)));
            return new NetworkSetting(blockchain, networkSettingItem, j2);
        }
    }

    public NetworkSetting(Blockchain blockchain, NetworkSettingItem mainnetNetworkSettingItem, List<NetworkSettingItem> networkSettingItems) {
        m.g(blockchain, "blockchain");
        m.g(mainnetNetworkSettingItem, "mainnetNetworkSettingItem");
        m.g(networkSettingItems, "networkSettingItems");
        this.blockchain = blockchain;
        this.mainnetNetworkSettingItem = mainnetNetworkSettingItem;
        this.networkSettingItems = networkSettingItems;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NetworkSetting copy$default(NetworkSetting networkSetting, Blockchain blockchain, NetworkSettingItem networkSettingItem, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            blockchain = networkSetting.blockchain;
        }
        if ((i2 & 2) != 0) {
            networkSettingItem = networkSetting.mainnetNetworkSettingItem;
        }
        if ((i2 & 4) != 0) {
            list = networkSetting.networkSettingItems;
        }
        return networkSetting.copy(blockchain, networkSettingItem, list);
    }

    public final Blockchain component1() {
        return this.blockchain;
    }

    public final NetworkSettingItem component2() {
        return this.mainnetNetworkSettingItem;
    }

    public final List<NetworkSettingItem> component3() {
        return this.networkSettingItems;
    }

    public final NetworkSetting copy(Blockchain blockchain, NetworkSettingItem mainnetNetworkSettingItem, List<NetworkSettingItem> networkSettingItems) {
        m.g(blockchain, "blockchain");
        m.g(mainnetNetworkSettingItem, "mainnetNetworkSettingItem");
        m.g(networkSettingItems, "networkSettingItems");
        return new NetworkSetting(blockchain, mainnetNetworkSettingItem, networkSettingItems);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NetworkSetting) {
            NetworkSetting networkSetting = (NetworkSetting) obj;
            return m.c(this.blockchain, networkSetting.blockchain) && m.c(this.mainnetNetworkSettingItem, networkSetting.mainnetNetworkSettingItem) && m.c(this.networkSettingItems, networkSetting.networkSettingItems);
        }
        return false;
    }

    public final Blockchain getBlockchain() {
        return this.blockchain;
    }

    public final NetworkSettingItem getMainnetNetworkSettingItem() {
        return this.mainnetNetworkSettingItem;
    }

    public final List<NetworkSettingItem> getNetworkSettingItems() {
        return this.networkSettingItems;
    }

    public int hashCode() {
        return (((this.blockchain.hashCode() * 31) + this.mainnetNetworkSettingItem.hashCode()) * 31) + this.networkSettingItems.hashCode();
    }

    public String toString() {
        return "NetworkSetting(blockchain=" + this.blockchain + ", mainnetNetworkSettingItem=" + this.mainnetNetworkSettingItem + ", networkSettingItems=" + this.networkSettingItems + ')';
    }
}