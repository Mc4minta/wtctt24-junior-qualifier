package com.coinbase.wallet.wallets.dtos;

import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.unauthed.hydrated_view_service_unauthed.a;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CryptoCurrenciesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0007\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0012\u001a\u00020\u00072\b\b\u0003\u0010\u0013\u001a\u00020\u00072\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\u0015\u001a\u00020\u00022\b\b\u0003\u0010\u0016\u001a\u00020\u00072\b\b\u0003\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001a\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\rJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\tR\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\rR\u0019\u0010\u0013\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b&\u0010\tR\u0019\u0010\u0016\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b'\u0010\tR\u0019\u0010\u0012\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b(\u0010\t¨\u0006+"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/CryptoCurrencyElementDTO;", "", "", "sortIndex", "Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "asCryptoCurrency", "(I)Lcom/coinbase/wallet/wallets/models/CryptoCurrency;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()I", "component5", "", "component6", "()D", ApiConstants.NAME, "code", "imageUrl", "decimals", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "marketCap", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;D)Lcom/coinbase/wallet/wallets/dtos/CryptoCurrencyElementDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImageUrl", "D", "getMarketCap", "I", "getDecimals", "getCode", "getBlockchain", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;D)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CryptoCurrencyElementDTO {
    private final String blockchain;
    private final String code;
    private final int decimals;
    private final String imageUrl;
    private final double marketCap;
    private final String name;

    public CryptoCurrencyElementDTO(@Json(name = "name") String name, @Json(name = "code") String code, @Json(name = "imageUrl") String str, @Json(name = "decimals") int i2, @Json(name = "blockchain") String blockchain, @Json(name = "marketCap") double d2) {
        m.g(name, "name");
        m.g(code, "code");
        m.g(blockchain, "blockchain");
        this.name = name;
        this.code = code;
        this.imageUrl = str;
        this.decimals = i2;
        this.blockchain = blockchain;
        this.marketCap = d2;
    }

    public static /* synthetic */ CryptoCurrencyElementDTO copy$default(CryptoCurrencyElementDTO cryptoCurrencyElementDTO, String str, String str2, String str3, int i2, String str4, double d2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cryptoCurrencyElementDTO.name;
        }
        if ((i3 & 2) != 0) {
            str2 = cryptoCurrencyElementDTO.code;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = cryptoCurrencyElementDTO.imageUrl;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            i2 = cryptoCurrencyElementDTO.decimals;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str4 = cryptoCurrencyElementDTO.blockchain;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            d2 = cryptoCurrencyElementDTO.marketCap;
        }
        return cryptoCurrencyElementDTO.copy(str, str5, str6, i4, str7, d2);
    }

    public final CryptoCurrency asCryptoCurrency(int i2) {
        CurrencyCode currencyCode = new CurrencyCode(this.code);
        String str = this.name;
        String str2 = this.imageUrl;
        URL asURL = str2 == null ? null : String_CoreKt.getAsURL(str2);
        int i3 = this.decimals;
        String str3 = this.blockchain;
        Locale US = Locale.US;
        m.f(US, "US");
        Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
        String upperCase = str3.toUpperCase(US);
        m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return new CryptoCurrency(currencyCode, str, asURL, i3, new Blockchain(upperCase), i2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final int component4() {
        return this.decimals;
    }

    public final String component5() {
        return this.blockchain;
    }

    public final double component6() {
        return this.marketCap;
    }

    public final CryptoCurrencyElementDTO copy(@Json(name = "name") String name, @Json(name = "code") String code, @Json(name = "imageUrl") String str, @Json(name = "decimals") int i2, @Json(name = "blockchain") String blockchain, @Json(name = "marketCap") double d2) {
        m.g(name, "name");
        m.g(code, "code");
        m.g(blockchain, "blockchain");
        return new CryptoCurrencyElementDTO(name, code, str, i2, blockchain, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CryptoCurrencyElementDTO) {
            CryptoCurrencyElementDTO cryptoCurrencyElementDTO = (CryptoCurrencyElementDTO) obj;
            return m.c(this.name, cryptoCurrencyElementDTO.name) && m.c(this.code, cryptoCurrencyElementDTO.code) && m.c(this.imageUrl, cryptoCurrencyElementDTO.imageUrl) && this.decimals == cryptoCurrencyElementDTO.decimals && m.c(this.blockchain, cryptoCurrencyElementDTO.blockchain) && m.c(Double.valueOf(this.marketCap), Double.valueOf(cryptoCurrencyElementDTO.marketCap));
        }
        return false;
    }

    public final String getBlockchain() {
        return this.blockchain;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getDecimals() {
        return this.decimals;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final double getMarketCap() {
        return this.marketCap;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.code.hashCode()) * 31;
        String str = this.imageUrl;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.decimals) * 31) + this.blockchain.hashCode()) * 31) + a.a(this.marketCap);
    }

    public String toString() {
        return "CryptoCurrencyElementDTO(name=" + this.name + ", code=" + this.code + ", imageUrl=" + ((Object) this.imageUrl) + ", decimals=" + this.decimals + ", blockchain=" + this.blockchain + ", marketCap=" + this.marketCap + ')';
    }
}