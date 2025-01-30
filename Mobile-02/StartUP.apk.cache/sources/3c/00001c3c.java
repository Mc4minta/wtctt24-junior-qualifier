package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: NetworkSettingItem+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem$Companion;", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "chain", "Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "fromEthereumChain", "(Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem$Companion;Lcom/coinbase/ciphercore/ethereum/EthereumChain;)Lcom/coinbase/wallet/blockchains/models/NetworkSettingItem;", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NetworkSettingItem_EthereumKt {
    public static final NetworkSettingItem fromEthereumChain(NetworkSettingItem.Companion companion, EthereumChain chain) {
        m.g(companion, "<this>");
        m.g(chain, "chain");
        return new NetworkSettingItem(chain.getDisplayName(), EthereumChain_EthereumKt.getAsNetwork(chain));
    }
}