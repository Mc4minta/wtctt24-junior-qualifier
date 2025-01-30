package com.coinbase.ciphercore;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: types.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\r\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/coinbase/ciphercore/ERC20Info;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()I", "address", ApiConstants.NAME, "symbol", "decimals", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/ciphercore/ERC20Info;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getSymbol", "I", "getDecimals", "getAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ERC20Info {
    @Json(name = "address")
    private final String address;
    @Json(name = "decimals")
    private final int decimals;
    @Json(name = ApiConstants.NAME)
    private final String name;
    @Json(name = "symbol")
    private final String symbol;

    public ERC20Info(String address, String name, String symbol, int i2) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(symbol, "symbol");
        this.address = address;
        this.name = name;
        this.symbol = symbol;
        this.decimals = i2;
    }

    public static /* synthetic */ ERC20Info copy$default(ERC20Info eRC20Info, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eRC20Info.address;
        }
        if ((i3 & 2) != 0) {
            str2 = eRC20Info.name;
        }
        if ((i3 & 4) != 0) {
            str3 = eRC20Info.symbol;
        }
        if ((i3 & 8) != 0) {
            i2 = eRC20Info.decimals;
        }
        return eRC20Info.copy(str, str2, str3, i2);
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

    public final ERC20Info copy(String address, String name, String symbol, int i2) {
        kotlin.jvm.internal.m.g(address, "address");
        kotlin.jvm.internal.m.g(name, "name");
        kotlin.jvm.internal.m.g(symbol, "symbol");
        return new ERC20Info(address, name, symbol, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ERC20Info) {
            ERC20Info eRC20Info = (ERC20Info) obj;
            return kotlin.jvm.internal.m.c(this.address, eRC20Info.address) && kotlin.jvm.internal.m.c(this.name, eRC20Info.name) && kotlin.jvm.internal.m.c(this.symbol, eRC20Info.symbol) && this.decimals == eRC20Info.decimals;
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
        return "ERC20Info(address=" + this.address + ", name=" + this.name + ", symbol=" + this.symbol + ", decimals=" + this.decimals + ')';
    }
}