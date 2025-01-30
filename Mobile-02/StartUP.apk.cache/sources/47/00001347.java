package com.coinbase.wallet.bitcoin.extensions;

import com.coinbase.wallet.bip44wallets.models.BIP44CoinSelection;
import com.coinbase.walletengine.services.bitcoin.CoinSelection;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BIP44CoinSelection+Bitcoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "Lcom/coinbase/walletengine/services/bitcoin/CoinSelection;", "asCoinSelection", "(Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;)Lcom/coinbase/walletengine/services/bitcoin/CoinSelection;", "bitcoin_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44CoinSelection_BitcoinKt {
    public static final CoinSelection asCoinSelection(BIP44CoinSelection bIP44CoinSelection) {
        m.g(bIP44CoinSelection, "<this>");
        return new CoinSelection(BIP44UTXO_BitcoinKt.asUTXOs(bIP44CoinSelection.getInputs()), BIP44Output_BitcoinKt.asOutputs(bIP44CoinSelection.getOutputs()), bIP44CoinSelection.getFee());
    }
}