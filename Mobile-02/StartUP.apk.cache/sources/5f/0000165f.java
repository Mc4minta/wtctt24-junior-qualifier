package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.routing.models.RouteActionKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAsset.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J:\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAsset;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "id", "symbol", "imageUrl", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerAsset;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContractAddress", "getImageUrl", "getId", "getSymbol", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAsset {
    private final String contractAddress;
    private final String id;
    private final String imageUrl;
    private final String symbol;

    public ConsumerAsset(String id, String symbol, String imageUrl, String str) {
        m.g(id, "id");
        m.g(symbol, "symbol");
        m.g(imageUrl, "imageUrl");
        this.id = id;
        this.symbol = symbol;
        this.imageUrl = imageUrl;
        this.contractAddress = str;
    }

    public static /* synthetic */ ConsumerAsset copy$default(ConsumerAsset consumerAsset, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = consumerAsset.id;
        }
        if ((i2 & 2) != 0) {
            str2 = consumerAsset.symbol;
        }
        if ((i2 & 4) != 0) {
            str3 = consumerAsset.imageUrl;
        }
        if ((i2 & 8) != 0) {
            str4 = consumerAsset.contractAddress;
        }
        return consumerAsset.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.symbol;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final ConsumerAsset copy(String id, String symbol, String imageUrl, String str) {
        m.g(id, "id");
        m.g(symbol, "symbol");
        m.g(imageUrl, "imageUrl");
        return new ConsumerAsset(id, symbol, imageUrl, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAsset) {
            ConsumerAsset consumerAsset = (ConsumerAsset) obj;
            return m.c(this.id, consumerAsset.id) && m.c(this.symbol, consumerAsset.symbol) && m.c(this.imageUrl, consumerAsset.imageUrl) && m.c(this.contractAddress, consumerAsset.contractAddress);
        }
        return false;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.symbol.hashCode()) * 31) + this.imageUrl.hashCode()) * 31;
        String str = this.contractAddress;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConsumerAsset(id=" + this.id + ", symbol=" + this.symbol + ", imageUrl=" + this.imageUrl + ", contractAddress=" + ((Object) this.contractAddress) + ')';
    }
}