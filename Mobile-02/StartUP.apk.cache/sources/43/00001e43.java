package com.coinbase.wallet.features.ethereum.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.JsonClass;
import com.toshi.model.local.room.CollectibleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetCollectibleTypesResponseDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO;", "", "", "Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;", "component1", "()Ljava/util/List;", "collectibles", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCollectibles", "<init>", "(Ljava/util/List;)V", "CollectibleTypeDetail", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetCollectibleTypesResponseDTO {
    private final List<CollectibleTypeDetail> collectibles;

    /* compiled from: GetCollectibleTypesResponseDTO.kt */
    @JsonClass(generateAdapter = true)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010#J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ<\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u0010\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001e\u0010\nR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\rR\u0019\u0010\u000f\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "", "address", "Lcom/toshi/model/local/room/CollectibleType;", "asCollectibleTypeModel", "(ILjava/lang/String;)Lcom/toshi/model/local/room/CollectibleType;", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/lang/Integer;", "component4", ApiConstants.NAME, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "count", "imageUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/coinbase/wallet/features/ethereum/dtos/GetCollectibleTypesResponseDTO$CollectibleTypeDetail;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImageUrl", "getContractAddress", "Ljava/lang/Integer;", "getCount", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class CollectibleTypeDetail {
        private final String contractAddress;
        private final Integer count;
        private final String imageUrl;
        private final String name;

        public CollectibleTypeDetail(String name, String contractAddress, Integer num, String str) {
            m.g(name, "name");
            m.g(contractAddress, "contractAddress");
            this.name = name;
            this.contractAddress = contractAddress;
            this.count = num;
            this.imageUrl = str;
        }

        public static /* synthetic */ CollectibleTypeDetail copy$default(CollectibleTypeDetail collectibleTypeDetail, String str, String str2, Integer num, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = collectibleTypeDetail.name;
            }
            if ((i2 & 2) != 0) {
                str2 = collectibleTypeDetail.contractAddress;
            }
            if ((i2 & 4) != 0) {
                num = collectibleTypeDetail.count;
            }
            if ((i2 & 8) != 0) {
                str3 = collectibleTypeDetail.imageUrl;
            }
            return collectibleTypeDetail.copy(str, str2, num, str3);
        }

        public final CollectibleType asCollectibleTypeModel(int i2, String address) {
            m.g(address, "address");
            String str = this.name;
            String str2 = this.contractAddress;
            Integer num = this.count;
            return new CollectibleType(str, str2, address, num == null ? 0 : num.intValue(), this.imageUrl, i2);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.contractAddress;
        }

        public final Integer component3() {
            return this.count;
        }

        public final String component4() {
            return this.imageUrl;
        }

        public final CollectibleTypeDetail copy(String name, String contractAddress, Integer num, String str) {
            m.g(name, "name");
            m.g(contractAddress, "contractAddress");
            return new CollectibleTypeDetail(name, contractAddress, num, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CollectibleTypeDetail) {
                CollectibleTypeDetail collectibleTypeDetail = (CollectibleTypeDetail) obj;
                return m.c(this.name, collectibleTypeDetail.name) && m.c(this.contractAddress, collectibleTypeDetail.contractAddress) && m.c(this.count, collectibleTypeDetail.count) && m.c(this.imageUrl, collectibleTypeDetail.imageUrl);
            }
            return false;
        }

        public final String getContractAddress() {
            return this.contractAddress;
        }

        public final Integer getCount() {
            return this.count;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            int hashCode = ((this.name.hashCode() * 31) + this.contractAddress.hashCode()) * 31;
            Integer num = this.count;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.imageUrl;
            return hashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "CollectibleTypeDetail(name=" + this.name + ", contractAddress=" + this.contractAddress + ", count=" + this.count + ", imageUrl=" + ((Object) this.imageUrl) + ')';
        }
    }

    public GetCollectibleTypesResponseDTO(List<CollectibleTypeDetail> collectibles) {
        m.g(collectibles, "collectibles");
        this.collectibles = collectibles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetCollectibleTypesResponseDTO copy$default(GetCollectibleTypesResponseDTO getCollectibleTypesResponseDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getCollectibleTypesResponseDTO.collectibles;
        }
        return getCollectibleTypesResponseDTO.copy(list);
    }

    public final List<CollectibleTypeDetail> component1() {
        return this.collectibles;
    }

    public final GetCollectibleTypesResponseDTO copy(List<CollectibleTypeDetail> collectibles) {
        m.g(collectibles, "collectibles");
        return new GetCollectibleTypesResponseDTO(collectibles);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetCollectibleTypesResponseDTO) && m.c(this.collectibles, ((GetCollectibleTypesResponseDTO) obj).collectibles);
    }

    public final List<CollectibleTypeDetail> getCollectibles() {
        return this.collectibles;
    }

    public int hashCode() {
        return this.collectibles.hashCode();
    }

    public String toString() {
        return "GetCollectibleTypesResponseDTO(collectibles=" + this.collectibles + ')';
    }
}