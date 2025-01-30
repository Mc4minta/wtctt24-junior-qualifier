package com.coinbase.resources.buys;

import com.coinbase.resources.trades.Trade;
import com.coinbase.resources.transactions.MoneyHash;

/* loaded from: classes.dex */
public class Buy extends Trade {
    private Boolean instant;
    private Boolean isFirstBuy;
    private Boolean requiresCompletionStep;
    private MoneyHash total;

    public Boolean getInstant() {
        return this.instant;
    }

    public Boolean getIsFirstBuy() {
        return this.isFirstBuy;
    }

    public Boolean getRequiresCompletionStep() {
        return this.requiresCompletionStep;
    }

    public MoneyHash getTotal() {
        return this.total;
    }
}