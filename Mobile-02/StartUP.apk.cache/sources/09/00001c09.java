package com.coinbase.wallet.ethereum.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetERC20InfoResultDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/GetERC20InfoDTO;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "address", ApiConstants.NAME, "symbol", "decimals", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/ethereum/dtos/GetERC20InfoDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getDecimals", "Ljava/lang/String;", "getSymbol", "getAddress", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetERC20InfoDTO {
    private final String address;
    private final int decimals;
    private final String name;
    private final String symbol;

    public GetERC20InfoDTO(String address, String name, String symbol, int i2) {
        m.g(address, "address");
        m.g(name, "name");
        m.g(symbol, "symbol");
        this.address = address;
        this.name = name;
        this.symbol = symbol;
        this.decimals = i2;
    }

    public static /* synthetic */ GetERC20InfoDTO copy$default(GetERC20InfoDTO getERC20InfoDTO, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = getERC20InfoDTO.address;
        }
        if ((i3 & 2) != 0) {
            str2 = getERC20InfoDTO.name;
        }
        if ((i3 & 4) != 0) {
            str3 = getERC20InfoDTO.symbol;
        }
        if ((i3 & 8) != 0) {
            i2 = getERC20InfoDTO.decimals;
        }
        return getERC20InfoDTO.copy(str, str2, str3, i2);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.symbol;
    }

    public final int component4() {
        return this.decimals;
    }

    public final GetERC20InfoDTO copy(String address, String name, String symbol, int i2) {
        m.g(address, "address");
        m.g(name, "name");
        m.g(symbol, "symbol");
        return new GetERC20InfoDTO(address, name, symbol, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetERC20InfoDTO) {
            GetERC20InfoDTO getERC20InfoDTO = (GetERC20InfoDTO) obj;
            return m.c(this.address, getERC20InfoDTO.address) && m.c(this.name, getERC20InfoDTO.name) && m.c(this.symbol, getERC20InfoDTO.symbol) && this.decimals == getERC20InfoDTO.decimals;
        }
        return false;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        return (((((this.address.hashCode() * 31) + this.name.hashCode()) * 31) + this.symbol.hashCode()) * 31) + this.decimals;
    }

    public String toString() {
        return "GetERC20InfoDTO(address=" + this.address + ", name=" + this.name + ", symbol=" + this.symbol + ", decimals=" + this.decimals + ')';
    }
}