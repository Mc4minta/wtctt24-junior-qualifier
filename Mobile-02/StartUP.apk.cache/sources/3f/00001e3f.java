package com.coinbase.wallet.features.ethereum.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import com.toshi.model.local.room.Erc721Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: GetCollectibleItemResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO;", "", "", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO$CollectibleItemDetail;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "CollectibleItemDetail", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetCollectibleItemResponseDTO {
    private final List<CollectibleItemDetail> items;

    /* compiled from: GetCollectibleItemResponseDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001d\u0010\u000b¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO$CollectibleItemDetail;", "", "", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "walletAddress", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/toshi/model/local/room/Erc721Token;", "asErc721Token", "(Ljava/lang/String;Ljava/lang/String;I)Lcom/toshi/model/local/room/Erc721Token;", "component1", "()Ljava/lang/String;", "component2", "component3", "tokenId", ApiConstants.NAME, "imageUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleItemResponseDTO$CollectibleItemDetail;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getTokenId", "getImageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class CollectibleItemDetail {
        private final String imageUrl;
        private final String name;
        private final String tokenId;

        public CollectibleItemDetail(String tokenId, String name, String imageUrl) {
            m.g(tokenId, "tokenId");
            m.g(name, "name");
            m.g(imageUrl, "imageUrl");
            this.tokenId = tokenId;
            this.name = name;
            this.imageUrl = imageUrl;
        }

        public static /* synthetic */ CollectibleItemDetail copy$default(CollectibleItemDetail collectibleItemDetail, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = collectibleItemDetail.tokenId;
            }
            if ((i2 & 2) != 0) {
                str2 = collectibleItemDetail.name;
            }
            if ((i2 & 4) != 0) {
                str3 = collectibleItemDetail.imageUrl;
            }
            return collectibleItemDetail.copy(str, str2, str3);
        }

        public final Erc721Token asErc721Token(String contractAddress, String walletAddress, int i2) {
            m.g(contractAddress, "contractAddress");
            m.g(walletAddress, "walletAddress");
            return new Erc721Token(this.tokenId, this.name, walletAddress, contractAddress, i2, this.imageUrl);
        }

        public final String component1() {
            return this.tokenId;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.imageUrl;
        }

        public final CollectibleItemDetail copy(String tokenId, String name, String imageUrl) {
            m.g(tokenId, "tokenId");
            m.g(name, "name");
            m.g(imageUrl, "imageUrl");
            return new CollectibleItemDetail(tokenId, name, imageUrl);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CollectibleItemDetail) {
                CollectibleItemDetail collectibleItemDetail = (CollectibleItemDetail) obj;
                return m.c(this.tokenId, collectibleItemDetail.tokenId) && m.c(this.name, collectibleItemDetail.name) && m.c(this.imageUrl, collectibleItemDetail.imageUrl);
            }
            return false;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getName() {
            return this.name;
        }

        public final String getTokenId() {
            return this.tokenId;
        }

        public int hashCode() {
            return (((this.tokenId.hashCode() * 31) + this.name.hashCode()) * 31) + this.imageUrl.hashCode();
        }

        public String toString() {
            return "CollectibleItemDetail(tokenId=" + this.tokenId + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ')';
        }
    }

    public GetCollectibleItemResponseDTO() {
        this(null, 1, null);
    }

    public GetCollectibleItemResponseDTO(List<CollectibleItemDetail> items) {
        m.g(items, "items");
        this.items = items;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetCollectibleItemResponseDTO copy$default(GetCollectibleItemResponseDTO getCollectibleItemResponseDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getCollectibleItemResponseDTO.items;
        }
        return getCollectibleItemResponseDTO.copy(list);
    }

    public final List<CollectibleItemDetail> component1() {
        return this.items;
    }

    public final GetCollectibleItemResponseDTO copy(List<CollectibleItemDetail> items) {
        m.g(items, "items");
        return new GetCollectibleItemResponseDTO(items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetCollectibleItemResponseDTO) && m.c(this.items, ((GetCollectibleItemResponseDTO) obj).items);
    }

    public final List<CollectibleItemDetail> getItems() {
        return this.items;
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "GetCollectibleItemResponseDTO(items=" + this.items + ')';
    }

    public /* synthetic */ GetCollectibleItemResponseDTO(List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list);
    }
}