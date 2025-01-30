package com.coinbase.wallet.wallets.dtos;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetCryptoExchangeRatesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetCryptoPriceDTO;", "", "Ljava/math/BigDecimal;", "component1", "()Ljava/math/BigDecimal;", "", "component2", "()Ljava/lang/String;", "component3", "component4", ApiConstants.PRICE, AppsFlyerProperties.CURRENCY_CODE, ApiConstants.NAME, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "copy", "(Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/wallets/dtos/GetCryptoPriceDTO;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/math/BigDecimal;", "getPrice", "Ljava/lang/String;", "getName", "getCurrencyCode", "getContractAddress", "<init>", "(Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetCryptoPriceDTO {
    private final String contractAddress;
    private final String currencyCode;
    private final String name;
    private final BigDecimal price;

    public GetCryptoPriceDTO(BigDecimal price, @Json(name = "symbol") String currencyCode, String name, String str) {
        m.g(price, "price");
        m.g(currencyCode, "currencyCode");
        m.g(name, "name");
        this.price = price;
        this.currencyCode = currencyCode;
        this.name = name;
        this.contractAddress = str;
    }

    public static /* synthetic */ GetCryptoPriceDTO copy$default(GetCryptoPriceDTO getCryptoPriceDTO, BigDecimal bigDecimal, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bigDecimal = getCryptoPriceDTO.price;
        }
        if ((i2 & 2) != 0) {
            str = getCryptoPriceDTO.currencyCode;
        }
        if ((i2 & 4) != 0) {
            str2 = getCryptoPriceDTO.name;
        }
        if ((i2 & 8) != 0) {
            str3 = getCryptoPriceDTO.contractAddress;
        }
        return getCryptoPriceDTO.copy(bigDecimal, str, str2, str3);
    }

    public final BigDecimal component1() {
        return this.price;
    }

    public final String component2() {
        return this.currencyCode;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.contractAddress;
    }

    public final GetCryptoPriceDTO copy(BigDecimal price, @Json(name = "symbol") String currencyCode, String name, String str) {
        m.g(price, "price");
        m.g(currencyCode, "currencyCode");
        m.g(name, "name");
        return new GetCryptoPriceDTO(price, currencyCode, name, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetCryptoPriceDTO) {
            GetCryptoPriceDTO getCryptoPriceDTO = (GetCryptoPriceDTO) obj;
            return m.c(this.price, getCryptoPriceDTO.price) && m.c(this.currencyCode, getCryptoPriceDTO.currencyCode) && m.c(this.name, getCryptoPriceDTO.name) && m.c(this.contractAddress, getCryptoPriceDTO.contractAddress);
        }
        return false;
    }

    public final String getContractAddress() {
        return this.contractAddress;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getName() {
        return this.name;
    }

    public final BigDecimal getPrice() {
        return this.price;
    }

    public int hashCode() {
        int hashCode = ((((this.price.hashCode() * 31) + this.currencyCode.hashCode()) * 31) + this.name.hashCode()) * 31;
        String str = this.contractAddress;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "GetCryptoPriceDTO(price=" + this.price + ", currencyCode=" + this.currencyCode + ", name=" + this.name + ", contractAddress=" + ((Object) this.contractAddress) + ')';
    }
}