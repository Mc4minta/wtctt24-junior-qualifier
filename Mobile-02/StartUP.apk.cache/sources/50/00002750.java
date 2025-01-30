package com.coinbase.wallet.txhistory.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.bitcoin.extensions.Blockchain_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.Blockchain_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.dogecoin.extensions.Blockchain_DogecoinKt;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.Blockchain_LitecoinKt;
import com.coinbase.wallet.ripple.extensions.Blockchain_RippleKt;
import com.coinbase.wallet.stellar.extensions.Blockchain_StellarKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Blockchain+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Blockchain;", "", "canShowFullTxHistory", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;)Z", "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "blockExplorerTitle", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/Network;)Ljava/lang/String;", "txHash", "Ljava/net/URL;", "blockExplorerUrl", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/Network;)Ljava/net/URL;", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Blockchain_TxHistoryKt {
    public static final String blockExplorerTitle(Blockchain blockchain, Network network) {
        m.g(blockchain, "<this>");
        m.g(network, "network");
        Blockchain.Companion companion = Blockchain.Companion;
        if (m.c(blockchain, Blockchain_BitcoinKt.getBITCOIN(companion))) {
            if (network.isTestnet()) {
                return "BlockCypher";
            }
        } else if (!m.c(blockchain, Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion))) {
            if (m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
                return "block explorer";
            }
            if (m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
                return "Gastracker";
            }
            if (m.c(blockchain, Blockchain_LitecoinKt.getLITECOIN(companion))) {
                return "Insight";
            }
            if (m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
                if (!network.isTestnet()) {
                    return "XRP Scan";
                }
            } else if (m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion))) {
                if (!network.isTestnet()) {
                    return "Stellar Explorer";
                }
            } else if (m.c(blockchain, Blockchain_DogecoinKt.getDOGECOIN(companion))) {
                return network.isTestnet() ? "chain.so" : "BlockCypher";
            }
            return null;
        } else if (network.isTestnet()) {
            return "bitcoin.com";
        }
        return "BTC.com";
    }

    public static final URL blockExplorerUrl(Blockchain blockchain, String txHash, Network network) {
        String o;
        EthereumChain asEthereumChain;
        m.g(blockchain, "<this>");
        m.g(txHash, "txHash");
        m.g(network, "network");
        boolean isTestnet = network.isTestnet();
        Blockchain.Companion companion = Blockchain.Companion;
        if (m.c(blockchain, Blockchain_BitcoinKt.getBITCOIN(companion))) {
            if (isTestnet) {
                o = m.o("https://live.blockcypher.com/btc-testnet/tx/", txHash);
            } else {
                o = m.o("https://btc.com/", txHash);
            }
        } else if (m.c(blockchain, Blockchain_BitcoinCashKt.getBITCOIN_CASH(companion))) {
            if (isTestnet) {
                o = m.o("https://explorer.bitcoin.com/tbch/tx/", txHash);
            } else {
                o = m.o("https://bch.btc.com/", txHash);
            }
        } else if (m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(companion))) {
            if (Network_EthereumKt.getAsEthereumChain(network) != null) {
                o = asEthereumChain.getBlockExplorerUrl() + "/tx/" + txHash;
            }
            o = null;
        } else if (m.c(blockchain, Blockchain_EthereumKt.getETHEREUM_CLASSIC(companion))) {
            o = m.o("https://gastracker.io/tx/", txHash);
        } else if (m.c(blockchain, Blockchain_LitecoinKt.getLITECOIN(companion))) {
            if (isTestnet) {
                o = m.o("https://testnet.litecore.io/tx/", txHash);
            } else {
                o = m.o("https://insight.litecore.io/tx/", txHash);
            }
        } else if (m.c(blockchain, Blockchain_DogecoinKt.getDOGECOIN(companion))) {
            if (isTestnet) {
                o = m.o("https://chain.so/tx/DOGETEST/", txHash);
            } else {
                o = m.o("https://live.blockcypher.com/doge/tx/", txHash);
            }
        } else if (m.c(blockchain, Blockchain_RippleKt.getXRP(companion))) {
            if (!isTestnet) {
                o = m.o("https://xrpscan.com/tx/", txHash);
            }
            o = null;
        } else {
            if (m.c(blockchain, Blockchain_StellarKt.getSTELLAR(companion)) && !isTestnet) {
                o = m.o("https://steexp.com/tx/", txHash);
            }
            o = null;
        }
        if (o == null) {
            return null;
        }
        return String_CoreKt.getAsURL(o);
    }

    public static final boolean canShowFullTxHistory(Blockchain blockchain) {
        m.g(blockchain, "<this>");
        return m.c(blockchain, Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion));
    }
}