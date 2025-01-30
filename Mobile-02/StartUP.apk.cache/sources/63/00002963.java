package com.coinbase.wallet.wallets.dtos;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetCryptoExchangeRatesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u000e\u001a\u00020\u00002\u0014\b\u0003\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesDTO;", "", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "toExchangeRates", "(Ljava/lang/Integer;)Ljava/util/List;", "", "", "Lcom/coinbase/wallet/wallets/dtos/GetCryptoPriceDTO;", "component1", "()Ljava/util/Map;", "rates", "copy", "(Ljava/util/Map;)Lcom/coinbase/wallet/wallets/dtos/GetCryptoExchangeRatesDTO;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getRates", "<init>", "(Ljava/util/Map;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetCryptoExchangeRatesDTO {
    private final Map<String, GetCryptoPriceDTO> rates;

    public GetCryptoExchangeRatesDTO(@Json(name = "rates") Map<String, GetCryptoPriceDTO> rates) {
        m.g(rates, "rates");
        this.rates = rates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetCryptoExchangeRatesDTO copy$default(GetCryptoExchangeRatesDTO getCryptoExchangeRatesDTO, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = getCryptoExchangeRatesDTO.rates;
        }
        return getCryptoExchangeRatesDTO.copy(map);
    }

    public final Map<String, GetCryptoPriceDTO> component1() {
        return this.rates;
    }

    public final GetCryptoExchangeRatesDTO copy(@Json(name = "rates") Map<String, GetCryptoPriceDTO> rates) {
        m.g(rates, "rates");
        return new GetCryptoExchangeRatesDTO(rates);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetCryptoExchangeRatesDTO) && m.c(this.rates, ((GetCryptoExchangeRatesDTO) obj).rates);
    }

    public final Map<String, GetCryptoPriceDTO> getRates() {
        return this.rates;
    }

    public int hashCode() {
        return this.rates.hashCode();
    }

    public final List<ExchangeRate> toExchangeRates(Integer num) {
        Collection<GetCryptoPriceDTO> values = this.rates.values();
        ArrayList arrayList = new ArrayList();
        for (GetCryptoPriceDTO getCryptoPriceDTO : values) {
            String currencyCode = getCryptoPriceDTO.getCurrencyCode();
            Locale US = Locale.US;
            m.f(US, "US");
            Objects.requireNonNull(currencyCode, "null cannot be cast to non-null type java.lang.String");
            String upperCase = currencyCode.toUpperCase(US);
            m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            boolean c2 = m.c(upperCase, "USDC");
            boolean c3 = m.c(upperCase, "ETH");
            BigDecimal bigDecimal = c2 ? new BigDecimal(1) : getCryptoPriceDTO.getPrice();
            ExchangeRate exchangeRate = null;
            if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                exchangeRate = new ExchangeRate(new CurrencyCode(upperCase), bigDecimal, getCryptoPriceDTO.getContractAddress(), (c3 || getCryptoPriceDTO.getContractAddress() != null) ? num : null, getCryptoPriceDTO.getName());
            }
            if (exchangeRate != null) {
                arrayList.add(exchangeRate);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "GetCryptoExchangeRatesDTO(rates=" + this.rates + ')';
    }
}