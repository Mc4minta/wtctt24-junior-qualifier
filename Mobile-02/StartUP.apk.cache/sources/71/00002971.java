package com.coinbase.wallet.wallets.dtos;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetL2CryptoExchangeRatesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0015\u0010\fJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTO;", "", "Ljava/math/BigDecimal;", "component1", "()Ljava/math/BigDecimal;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()I", ApiConstants.PRICE, AppsFlyerProperties.CURRENCY_CODE, ApiConstants.NAME, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID, "copy", "(Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getCurrencyCode", "getContractAddress", "I", "getChainId", "Ljava/math/BigDecimal;", "getPrice", "<init>", "(Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetL2CryptoPriceDTO {
    private final int chainId;
    private final String contractAddress;
    private final String currencyCode;
    private final String name;
    private final BigDecimal price;

    public GetL2CryptoPriceDTO(BigDecimal price, @Json(name = "symbol") String currencyCode, String name, String str, int i2) {
        m.g(price, "price");
        m.g(currencyCode, "currencyCode");
        m.g(name, "name");
        this.price = price;
        this.currencyCode = currencyCode;
        this.name = name;
        this.contractAddress = str;
        this.chainId = i2;
    }

    public static /* synthetic */ GetL2CryptoPriceDTO copy$default(GetL2CryptoPriceDTO getL2CryptoPriceDTO, BigDecimal bigDecimal, String str, String str2, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bigDecimal = getL2CryptoPriceDTO.price;
        }
        if ((i3 & 2) != 0) {
            str = getL2CryptoPriceDTO.currencyCode;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = getL2CryptoPriceDTO.name;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            str3 = getL2CryptoPriceDTO.contractAddress;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            i2 = getL2CryptoPriceDTO.chainId;
        }
        return getL2CryptoPriceDTO.copy(bigDecimal, str4, str5, str6, i2);
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

    public final int component5() {
        return this.chainId;
    }

    public final GetL2CryptoPriceDTO copy(BigDecimal price, @Json(name = "symbol") String currencyCode, String name, String str, int i2) {
        m.g(price, "price");
        m.g(currencyCode, "currencyCode");
        m.g(name, "name");
        return new GetL2CryptoPriceDTO(price, currencyCode, name, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GetL2CryptoPriceDTO) {
            GetL2CryptoPriceDTO getL2CryptoPriceDTO = (GetL2CryptoPriceDTO) obj;
            return m.c(this.price, getL2CryptoPriceDTO.price) && m.c(this.currencyCode, getL2CryptoPriceDTO.currencyCode) && m.c(this.name, getL2CryptoPriceDTO.name) && m.c(this.contractAddress, getL2CryptoPriceDTO.contractAddress) && this.chainId == getL2CryptoPriceDTO.chainId;
        }
        return false;
    }

    public final int getChainId() {
        return this.chainId;
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
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.chainId;
    }

    public String toString() {
        return "GetL2CryptoPriceDTO(price=" + this.price + ", currencyCode=" + this.currencyCode + ", name=" + this.name + ", contractAddress=" + ((Object) this.contractAddress) + ", chainId=" + this.chainId + ')';
    }
}