package com.coinbase.wallet.compoundfinance.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetCTokenInfoDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JD\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/compoundfinance/dtos/CTokenInfoDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", ApiConstants.NAME, "code", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "underlyingCode", "underlyingContractAddress", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/compoundfinance/dtos/CTokenInfoDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "getUnderlyingContractAddress", "getName", "getUnderlyingCode", "getContractAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "compoundfinance_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CTokenInfoDTO {
    private final String code;
    private final String contractAddress;
    private final String name;
    private final String underlyingCode;
    private final String underlyingContractAddress;

    public CTokenInfoDTO(@Json(name = "name") String name, @Json(name = "symbol") String code, @Json(name = "token_address") String contractAddress, @Json(name = "underlying_symbol") String underlyingCode, @Json(name = "underlying_address") String str) {
        m.g(name, "name");
        m.g(code, "code");
        m.g(contractAddress, "contractAddress");
        m.g(underlyingCode, "underlyingCode");
        this.name = name;
        this.code = code;
        this.contractAddress = contractAddress;
        this.underlyingCode = underlyingCode;
        this.underlyingContractAddress = str;
    }

    public static /* synthetic */ CTokenInfoDTO copy$default(CTokenInfoDTO cTokenInfoDTO, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cTokenInfoDTO.name;
        }
        if ((i2 & 2) != 0) {
            str2 = cTokenInfoDTO.code;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = cTokenInfoDTO.contractAddress;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = cTokenInfoDTO.underlyingCode;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = cTokenInfoDTO.underlyingContractAddress;
        }
        return cTokenInfoDTO.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.contractAddress;
    }

    public final String component4() {
        return this.underlyingCode;
    }

    public final String component5() {
        return this.underlyingContractAddress;
    }

    public final CTokenInfoDTO copy(@Json(name = "name") String name, @Json(name = "symbol") String code, @Json(name = "token_address") String contractAddress, @Json(name = "underlying_symbol") String underlyingCode, @Json(name = "underlying_address") String str) {
        m.g(name, "name");
        m.g(code, "code");
        m.g(contractAddress, "contractAddress");
        m.g(underlyingCode, "underlyingCode");
        return new CTokenInfoDTO(name, code, contractAddress, underlyingCode, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CTokenInfoDTO) {
            CTokenInfoDTO cTokenInfoDTO = (CTokenInfoDTO) obj;
            return m.c(this.name, cTokenInfoDTO.name) && m.c(this.code, cTokenInfoDTO.code) && m.c(this.contractAddress, cTokenInfoDTO.contractAddress) && m.c(this.underlyingCode, cTokenInfoDTO.underlyingCode) && m.c(this.underlyingContractAddress, cTokenInfoDTO.underlyingContractAddress);
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUnderlyingCode() {
        return this.underlyingCode;
    }

    public final String getUnderlyingContractAddress() {
        return this.underlyingContractAddress;
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.code.hashCode()) * 31) + this.contractAddress.hashCode()) * 31) + this.underlyingCode.hashCode()) * 31;
        String str = this.underlyingContractAddress;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CTokenInfoDTO(name=" + this.name + ", code=" + this.code + ", contractAddress=" + this.contractAddress + ", underlyingCode=" + this.underlyingCode + ", underlyingContractAddress=" + ((Object) this.underlyingContractAddress) + ')';
    }
}