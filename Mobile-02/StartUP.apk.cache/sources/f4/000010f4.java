package com.coinbase.resources.transactions.entities;

import com.coinbase.ApiConstants;
import com.coinbase.resources.base.DynamicResource;
import com.google.gson.annotations.b;

/* loaded from: classes.dex */
public class CryptoNetwork extends DynamicResource {
    @b(ApiConstants.CURRENCY)
    private String currency;

    public String getCurrency() {
        return this.currency;
    }
}