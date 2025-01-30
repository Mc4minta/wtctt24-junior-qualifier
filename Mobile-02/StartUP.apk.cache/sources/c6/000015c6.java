package com.coinbase.wallet.consumer.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.models.ConsumerAsset;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAssetDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007JX\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0003\u0010\u0015\u001a\u00020\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\rJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b\"\u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\rR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTO;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerAsset;", "asModel", "()Lcom/coinbase/wallet/consumer/models/ConsumerAsset;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()I", "component6", "component7", "id", "symbol", ApiConstants.NAME, "color", "exponent", "imageUrl", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/dtos/ConsumerAssetDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "getImageUrl", "I", "getExponent", "getContractAddress", "getSymbol", "getColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAssetDTO {
    private final String color;
    private final String contractAddress;
    private final int exponent;
    private final String id;
    private final String imageUrl;
    private final String name;
    private final String symbol;

    public ConsumerAssetDTO(String id, String symbol, String name, String color, int i2, @Json(name = "image_url") String imageUrl, @Json(name = "contract_address") String str) {
        m.g(id, "id");
        m.g(symbol, "symbol");
        m.g(name, "name");
        m.g(color, "color");
        m.g(imageUrl, "imageUrl");
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.color = color;
        this.exponent = i2;
        this.imageUrl = imageUrl;
        this.contractAddress = str;
    }

    public static /* synthetic */ ConsumerAssetDTO copy$default(ConsumerAssetDTO consumerAssetDTO, String str, String str2, String str3, String str4, int i2, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = consumerAssetDTO.id;
        }
        if ((i3 & 2) != 0) {
            str2 = consumerAssetDTO.symbol;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = consumerAssetDTO.name;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = consumerAssetDTO.color;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            i2 = consumerAssetDTO.exponent;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            str5 = consumerAssetDTO.imageUrl;
        }
        String str10 = str5;
        if ((i3 & 64) != 0) {
            str6 = consumerAssetDTO.contractAddress;
        }
        return consumerAssetDTO.copy(str, str7, str8, str9, i4, str10, str6);
    }

    public final ConsumerAsset asModel() {
        return new ConsumerAsset(this.id, this.symbol, this.imageUrl, this.contractAddress);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.symbol;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.color;
    }

    public final int component5() {
        return this.exponent;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.contractAddress;
    }

    public final ConsumerAssetDTO copy(String id, String symbol, String name, String color, int i2, @Json(name = "image_url") String imageUrl, @Json(name = "contract_address") String str) {
        m.g(id, "id");
        m.g(symbol, "symbol");
        m.g(name, "name");
        m.g(color, "color");
        m.g(imageUrl, "imageUrl");
        return new ConsumerAssetDTO(id, symbol, name, color, i2, imageUrl, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAssetDTO) {
            ConsumerAssetDTO consumerAssetDTO = (ConsumerAssetDTO) obj;
            return m.c(this.id, consumerAssetDTO.id) && m.c(this.symbol, consumerAssetDTO.symbol) && m.c(this.name, consumerAssetDTO.name) && m.c(this.color, consumerAssetDTO.color) && this.exponent == consumerAssetDTO.exponent && m.c(this.imageUrl, consumerAssetDTO.imageUrl) && m.c(this.contractAddress, consumerAssetDTO.contractAddress);
        }
        return false;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final int getExponent() {
        return this.exponent;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.id.hashCode() * 31) + this.symbol.hashCode()) * 31) + this.name.hashCode()) * 31) + this.color.hashCode()) * 31) + this.exponent) * 31) + this.imageUrl.hashCode()) * 31;
        String str = this.contractAddress;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConsumerAssetDTO(id=" + this.id + ", symbol=" + this.symbol + ", name=" + this.name + ", color=" + this.color + ", exponent=" + this.exponent + ", imageUrl=" + this.imageUrl + ", contractAddress=" + ((Object) this.contractAddress) + ')';
    }
}