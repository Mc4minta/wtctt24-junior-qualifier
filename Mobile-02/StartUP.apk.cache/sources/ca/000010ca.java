package com.coinbase.resources.paymentmethods.models;

import com.coinbase.resources.transactions.MoneyHash;

/* loaded from: classes.dex */
public class Limit {
    private String description;
    private String label;
    private NextRequirement nextRequirement;
    private Integer periodInDays;
    private MoneyHash remaining;
    private MoneyHash total;

    public String getDescription() {
        return this.description;
    }

    public String getLabel() {
        return this.label;
    }

    public NextRequirement getNextRequirement() {
        return this.nextRequirement;
    }

    public Integer getPeriodInDays() {
        return this.periodInDays;
    }

    public MoneyHash getRemaining() {
        return this.remaining;
    }

    public MoneyHash getTotal() {
        return this.total;
    }
}