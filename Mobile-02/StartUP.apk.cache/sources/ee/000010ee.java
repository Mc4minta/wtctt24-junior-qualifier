package com.coinbase.resources.transactions;

/* loaded from: classes.dex */
public abstract class TransactionRequest {
    protected final String amount;
    protected final String currency;
    protected final String to;
    protected final String type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransactionRequest(String str, String str2, String str3, String str4) {
        this.type = str;
        this.currency = str4;
        this.amount = str3;
        this.to = str2;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getTo() {
        return this.to;
    }

    public String getType() {
        return this.type;
    }
}