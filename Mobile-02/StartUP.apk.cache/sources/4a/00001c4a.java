package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.CurrencyDecimal;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* compiled from: WalletConfiguration+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/EthereumBasedConfiguration;", "<anonymous>", "()Lcom/coinbase/wallet/ethereum/models/EthereumBasedConfiguration;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class WalletConfiguration_EthereumKt$ETH$2 extends o implements kotlin.e0.c.a<EthereumBasedConfiguration> {
    public static final WalletConfiguration_EthereumKt$ETH$2 INSTANCE = new WalletConfiguration_EthereumKt$ETH$2();

    WalletConfiguration_EthereumKt$ETH$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final EthereumBasedConfiguration invoke() {
        URL url = new URL("https://wallet-api-production.s3.amazonaws.com/uploads/tokens/eth_288.png");
        return new EthereumBasedConfiguration(Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion), NetworkSetting_EthereumKt.getETH(NetworkSetting.Companion), 30L, CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion), CurrencyDecimal_EthereumKt.getETH(CurrencyDecimal.INSTANCE), url, AddressKind_EthereumKt.getEthereum(AddressType.Companion), true, true);
    }
}