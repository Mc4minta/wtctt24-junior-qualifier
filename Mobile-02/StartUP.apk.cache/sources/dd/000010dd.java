package com.coinbase.resources.trades;

import com.coinbase.resources.trades.PlaceTradeOrderBody;

/* loaded from: classes.dex */
public abstract class PlaceTradeOrderBody<T extends PlaceTradeOrderBody> {
    private String amount;
    private Boolean commit;
    private String currency;
    private String paymentMethod;

    public PlaceTradeOrderBody(String str, String str2, String str3) {
        this.currency = str2;
        this.paymentMethod = str3;
        this.amount = str;
    }

    private T getThis() {
        return this;
    }

    public String getAmount() {
        return this.amount;
    }

    public Boolean getCommit() {
        return this.commit;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public T setCommit(Boolean bool) {
        this.commit = bool;
        return getThis();
    }

    public T setCurrency(String str) {
        this.currency = str;
        return getThis();
    }

    public T setPaymentMethod(String str) {
        this.paymentMethod = str;
        return getThis();
    }
}