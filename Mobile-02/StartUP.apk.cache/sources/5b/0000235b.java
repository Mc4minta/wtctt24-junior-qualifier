package com.coinbase.wallet.features.wallets.extensions.legacy;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.ethereum.extensions.EthereumChain_EthereumKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Network+Application.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Network;", "", "asChainId", "(Lcom/coinbase/wallet/blockchains/models/Network;)I", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Network_ApplicationKt {
    public static final int asChainId(Network network) {
        m.g(network, "<this>");
        EthereumChain fromNetworkRawValue = EthereumChain_EthereumKt.fromNetworkRawValue(EthereumChain.Companion, network.getRawValue());
        Integer valueOf = fromNetworkRawValue == null ? null : Integer.valueOf(fromNetworkRawValue.getChainId());
        if (valueOf != null) {
            return valueOf.intValue();
        }
        throw new IllegalStateException("Couldn't get chain id");
    }
}