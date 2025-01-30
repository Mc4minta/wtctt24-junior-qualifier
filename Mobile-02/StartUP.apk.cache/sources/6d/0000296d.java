package com.coinbase.wallet.wallets.dtos;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetL2CryptoExchangeRatesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J \u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoExchangeRatesDTO;", "", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "toExchangeRates", "()Ljava/util/List;", "Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoPriceDTO;", "component1", "rates", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/wallets/dtos/GetL2CryptoExchangeRatesDTO;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRates", "<init>", "(Ljava/util/List;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetL2CryptoExchangeRatesDTO {
    private final List<GetL2CryptoPriceDTO> rates;

    public GetL2CryptoExchangeRatesDTO(@Json(name = "rates") List<GetL2CryptoPriceDTO> rates) {
        m.g(rates, "rates");
        this.rates = rates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetL2CryptoExchangeRatesDTO copy$default(GetL2CryptoExchangeRatesDTO getL2CryptoExchangeRatesDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = getL2CryptoExchangeRatesDTO.rates;
        }
        return getL2CryptoExchangeRatesDTO.copy(list);
    }

    public final List<GetL2CryptoPriceDTO> component1() {
        return this.rates;
    }

    public final GetL2CryptoExchangeRatesDTO copy(@Json(name = "rates") List<GetL2CryptoPriceDTO> rates) {
        m.g(rates, "rates");
        return new GetL2CryptoExchangeRatesDTO(rates);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetL2CryptoExchangeRatesDTO) && m.c(this.rates, ((GetL2CryptoExchangeRatesDTO) obj).rates);
    }

    public final List<GetL2CryptoPriceDTO> getRates() {
        return this.rates;
    }

    public int hashCode() {
        return this.rates.hashCode();
    }

    public final List<ExchangeRate> toExchangeRates() {
        List<GetL2CryptoPriceDTO> list = this.rates;
        ArrayList arrayList = new ArrayList();
        for (GetL2CryptoPriceDTO getL2CryptoPriceDTO : list) {
            String currencyCode = getL2CryptoPriceDTO.getCurrencyCode();
            Locale US = Locale.US;
            m.f(US, "US");
            Objects.requireNonNull(currencyCode, "null cannot be cast to non-null type java.lang.String");
            String upperCase = currencyCode.toUpperCase(US);
            m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            boolean c2 = m.c(upperCase, "USDC");
            m.c(upperCase, "ETH");
            BigDecimal bigDecimal = c2 ? new BigDecimal(1) : getL2CryptoPriceDTO.getPrice();
            ExchangeRate exchangeRate = bigDecimal.compareTo(BigDecimal.ZERO) > 0 ? new ExchangeRate(new CurrencyCode(upperCase), bigDecimal, getL2CryptoPriceDTO.getContractAddress(), Integer.valueOf(getL2CryptoPriceDTO.getChainId()), getL2CryptoPriceDTO.getName()) : null;
            if (exchangeRate != null) {
                arrayList.add(exchangeRate);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "GetL2CryptoExchangeRatesDTO(rates=" + this.rates + ')';
    }
}