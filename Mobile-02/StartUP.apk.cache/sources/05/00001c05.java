package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ERC20IconDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\t\u001a\u00020\u00002\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R+\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "", "", "", "", "Lcom/coinbase/wallet/ethereum/dtos/ERC20IconDTO;", "component1", "()Ljava/util/Map;", "icons", "copy", "(Ljava/util/Map;)Lcom/coinbase/wallet/ethereum/dtos/GetERC20IconsDTO;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getIcons", "<init>", "(Ljava/util/Map;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20IconsDTO {
    private final Map<String, List<ERC20IconDTO>> icons;

    /* JADX WARN: Multi-variable type inference failed */
    public GetERC20IconsDTO(Map<String, ? extends List<ERC20IconDTO>> icons) {
        m.g(icons, "icons");
        this.icons = icons;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetERC20IconsDTO copy$default(GetERC20IconsDTO getERC20IconsDTO, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = getERC20IconsDTO.icons;
        }
        return getERC20IconsDTO.copy(map);
    }

    public final Map<String, List<ERC20IconDTO>> component1() {
        return this.icons;
    }

    public final GetERC20IconsDTO copy(Map<String, ? extends List<ERC20IconDTO>> icons) {
        m.g(icons, "icons");
        return new GetERC20IconsDTO(icons);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetERC20IconsDTO) && m.c(this.icons, ((GetERC20IconsDTO) obj).icons);
    }

    public final Map<String, List<ERC20IconDTO>> getIcons() {
        return this.icons;
    }

    public int hashCode() {
        return this.icons.hashCode();
    }

    public String toString() {
        return "GetERC20IconsDTO(icons=" + this.icons + ')';
    }
}