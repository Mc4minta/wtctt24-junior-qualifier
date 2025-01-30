package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Network+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Network;", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "getAsEthereumChain", "(Lcom/coinbase/wallet/blockchains/models/Network;)Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "asEthereumChain", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Network_EthereumKt {
    public static final EthereumChain getAsEthereumChain(Network network) {
        m.g(network, "<this>");
        return EthereumChain_EthereumKt.fromNetworkRawValue(EthereumChain.Companion, network.getRawValue());
    }
}