package com.coinbase.resources.paymentmethods.models;

import com.coinbase.resources.transactions.MoneyHash;

/* loaded from: classes.dex */
public class NextRequirement {
    public static final String BUY_HISTORY = "buy_history";
    public static final String IDENTITY_VERIFICATION = "identity_verification";
    public static final String JUMIO = "jumio";
    public static final String VERIFIED_PHONE = "verified_phone";
    private MoneyHash amountRemaining;
    private Long timeAfterStarting;
    private String type;
    private MoneyHash volume;

    public MoneyHash getAmountRemaining() {
        return this.amountRemaining;
    }

    public Long getTimeAfterStarting() {
        return this.timeAfterStarting;
    }

    public String getType() {
        return this.type;
    }

    public MoneyHash getVolume() {
        return this.volume;
    }
}