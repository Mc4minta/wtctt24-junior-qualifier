package com.coinbase.resources.paymentmethods.models;

import java.util.List;

/* loaded from: classes.dex */
public class Limits {
    public static final String TYPE_BANK = "bank";
    public static final String TYPE_CARD = "card";
    public static final String TYPE_FIAT_ACCOUNT = "fiat_account";
    public static final String TYPE_INTRA_BANK = "intra_bank";
    public static final String TYPE_PAYPAL = "paypal";
    public static final String TYPE_WIRE = "wire";
    public static final String TYPE_XFERS = "xfers";
    private List<Limit> buy;
    private List<Limit> deposit;
    private List<Limit> instantBuy;
    private String name;
    private List<Limit> sell;
    private String type;

    public List<Limit> getBuy() {
        return this.buy;
    }

    public List<Limit> getDeposit() {
        return this.deposit;
    }

    public List<Limit> getInstantBuy() {
        return this.instantBuy;
    }

    public String getName() {
        return this.name;
    }

    public List<Limit> getSell() {
        return this.sell;
    }

    public String getType() {
        return this.type;
    }
}