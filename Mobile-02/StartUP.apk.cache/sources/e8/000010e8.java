package com.coinbase.resources.transactions;

/* loaded from: classes.dex */
public class MoneyRequest extends TransactionRequest {
    private String description;

    public MoneyRequest(String str, String str2, String str3) {
        super("request", str, str2, str3);
    }

    public String getDescription() {
        return this.description;
    }

    public MoneyRequest setDescription(String str) {
        this.description = str;
        return this;
    }
}