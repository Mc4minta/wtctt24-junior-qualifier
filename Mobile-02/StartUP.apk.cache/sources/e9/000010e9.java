package com.coinbase.resources.transactions;

/* loaded from: classes.dex */
public class Network {
    public static final String STATUS_CONFIRMED = "confirmed";
    public static final String STATUS_OFF_BLOCKCHAIN = "off_blockchain";
    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_UNCONFIRMED = "unconfirmed";
    private Integer confirmations;
    private String hash;
    private String status;
    private MoneyHash transactionAmount;
    private MoneyHash transactionFee;

    public Integer getConfirmations() {
        return this.confirmations;
    }

    public String getHash() {
        return this.hash;
    }

    public String getStatus() {
        return this.status;
    }

    public MoneyHash getTransactionAmount() {
        return this.transactionAmount;
    }

    public MoneyHash getTransactionFee() {
        return this.transactionFee;
    }
}