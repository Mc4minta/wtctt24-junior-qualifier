package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.jvm.internal.o;

/* compiled from: NetworkSetting+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "<anonymous>", "()Lcom/coinbase/wallet/blockchains/models/NetworkSetting;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class NetworkSetting_EthereumKt$ETC$2 extends o implements kotlin.e0.c.a<NetworkSetting> {
    public static final NetworkSetting_EthereumKt$ETC$2 INSTANCE = new NetworkSetting_EthereumKt$ETC$2();

    NetworkSetting_EthereumKt$ETC$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final NetworkSetting invoke() {
        List b2;
        NetworkSettingItem networkSettingItem = new NetworkSettingItem("Mainnet", EthereumChain_EthereumKt.getAsNetwork(EthereumChain.ETHEREUM_CLASSIC_MAINNET));
        Blockchain ethereum_classic = Blockchain_EthereumKt.getETHEREUM_CLASSIC(Blockchain.Companion);
        b2 = q.b(networkSettingItem);
        return new NetworkSetting(ethereum_classic, networkSettingItem, b2);
    }
}