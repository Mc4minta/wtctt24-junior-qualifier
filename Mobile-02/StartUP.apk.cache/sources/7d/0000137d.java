package com.coinbase.wallet.bitcoincash.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44CoinSelection;
import com.coinbase.walletengine.services.bitcoincash.CoinSelection;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CoinSelection+BitcoinCash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/walletengine/services/bitcoincash/CoinSelection;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "asBIP44CoinSelection", "(Lcom/coinbase/walletengine/services/bitcoincash/CoinSelection;)Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "bitcoincash_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CoinSelection_BitcoinCashKt {
    public static final BIP44CoinSelection asBIP44CoinSelection(CoinSelection coinSelection) {
        m.g(coinSelection, "<this>");
        return new BIP44CoinSelection(UTXO_BitcoinCashKt.asBIP44TXOs(coinSelection.getInputs()), Output_BitcoinCashKt.asBIP44Outputs(coinSelection.getOutputs()), coinSelection.getFee());
    }
}