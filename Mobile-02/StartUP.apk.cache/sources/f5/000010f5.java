package com.coinbase.resources.transactions.entities;

import com.coinbase.resources.base.DynamicResource;

/* loaded from: classes.dex */
public class EmailResource extends DynamicResource {
    private String currency;
    private String email;

    public String getCurrency() {
        return this.currency;
    }

    public String getEmail() {
        return this.email;
    }
}