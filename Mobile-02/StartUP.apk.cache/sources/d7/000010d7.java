package com.coinbase.resources.sells;

import com.coinbase.resources.trades.Trade;
import com.coinbase.resources.transactions.MoneyHash;

/* loaded from: classes.dex */
public class Sell extends Trade {
    private Boolean instant;
    private MoneyHash total;

    public Boolean getInstant() {
        return this.instant;
    }

    public MoneyHash getTotal() {
        return this.total;
    }
}