package com.coinbase.resources.rates;

import java.util.Map;

/* loaded from: classes.dex */
public class ExchangeRates {
    private String currency;
    private Map<String, String> rates;

    public String getCurrency() {
        return this.currency;
    }

    public Map<String, String> getRates() {
        return this.rates;
    }
}