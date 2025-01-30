package com.coinbase.resources.trades;

import com.coinbase.resources.base.ResourceTypeDeserializer;
import com.coinbase.resources.buys.Buy;
import com.coinbase.resources.deposits.Deposit;
import com.coinbase.resources.sells.Sell;
import com.coinbase.resources.withdrawals.Withdrawal;

/* loaded from: classes.dex */
public final class TradesDeserializer extends ResourceTypeDeserializer<Trade> {
    public TradesDeserializer() {
        this.typeMapping.put("buy", Buy.class);
        this.typeMapping.put("sell", Sell.class);
        this.typeMapping.put("deposit", Deposit.class);
        this.typeMapping.put("withdrawal", Withdrawal.class);
    }
}