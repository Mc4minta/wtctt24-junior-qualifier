package com.coinbase.wallet.common.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.bitcoin.extensions.Blockchain_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.Blockchain_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.dogecoin.extensions.Blockchain_DogecoinKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.Blockchain_LitecoinKt;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Network+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Blockchain;", "Lcom/coinbase/wallet/blockchains/models/Network;", "mainnetNetworkCode", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Lcom/coinbase/wallet/blockchains/models/Network;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Network_CommonKt {
    public static final Network mainnetNetworkCode(Blockchain blockchain) {
        m.g(blockchain, "<this>");
        Blockchain.Companion companion = Blockchain.Companion;
        if (m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
            return EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_MAINNET);
        }
        if (m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
            return EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_CLASSIC_MAINNET);
        }
        if (m.c(blockchain, Blockchain_BitcoinKt.getBITCOIN(companion)) ? true : m.c(blockchain, Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion)) ? true : m.c(blockchain, Blockchain_LitecoinKt.getLITECOIN(companion)) ? true : m.c(blockchain, Blockchain_DogecoinKt.getDOGECOIN(companion)) ? true : m.c(blockchain, Blockchain_RippleKt.getXRP(companion)) ? true : m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
            return Network.Companion.createTestnetNetwork(false);
        }
        return null;
    }
}