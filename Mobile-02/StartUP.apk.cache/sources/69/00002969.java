package com.coinbase.wallet.wallets.dtos;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetFiatExchangeRatesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0001\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ&\u0010\f\u001a\u00020\u00002\u0014\b\u0003\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/wallets/dtos/GetFiatExchangeRatesDTO;", "", "", "Lcom/coinbase/wallet/wallets/models/ExchangeRate;", "toExchangeRates", "()Ljava/util/List;", "", "", "", "component1", "()Ljava/util/Map;", "rates", "copy", "(Ljava/util/Map;)Lcom/coinbase/wallet/wallets/dtos/GetFiatExchangeRatesDTO;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getRates", "<init>", "(Ljava/util/Map;)V", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GetFiatExchangeRatesDTO {
    private final Map<String, Double> rates;

    public GetFiatExchangeRatesDTO(@Json(name = "rates") Map<String, Double> rates) {
        m.g(rates, "rates");
        this.rates = rates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetFiatExchangeRatesDTO copy$default(GetFiatExchangeRatesDTO getFiatExchangeRatesDTO, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = getFiatExchangeRatesDTO.rates;
        }
        return getFiatExchangeRatesDTO.copy(map);
    }

    public final Map<String, Double> component1() {
        return this.rates;
    }

    public final GetFiatExchangeRatesDTO copy(@Json(name = "rates") Map<String, Double> rates) {
        m.g(rates, "rates");
        return new GetFiatExchangeRatesDTO(rates);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetFiatExchangeRatesDTO) && m.c(this.rates, ((GetFiatExchangeRatesDTO) obj).rates);
    }

    public final Map<String, Double> getRates() {
        return this.rates;
    }

    public int hashCode() {
        return this.rates.hashCode();
    }

    public final List<ExchangeRate> toExchangeRates() {
        Map<String, Double> map = this.rates;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String key = entry.getKey();
            double doubleValue = entry.getValue().doubleValue();
            ExchangeRate exchangeRate = doubleValue > 0.0d ? new ExchangeRate(new CurrencyCode(key), new BigDecimal(String.valueOf(doubleValue)), null, null, null, 28, null) : null;
            if (exchangeRate != null) {
                arrayList.add(exchangeRate);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "GetFiatExchangeRatesDTO(rates=" + this.rates + ')';
    }
}