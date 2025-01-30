package com.coinbase.wallet.consumer.repositories;

import com.coinbase.wallet.bitcoin.extensions.NetworkSetting_BitcoinKt;
import com.coinbase.wallet.bitcoincash.extensions.NetworkSetting_BitcoinCashKt;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.ethereum.extensions.NetworkSetting_EthereumKt;
import com.coinbase.wallet.litecoin.extensions.NetworkSetting_LitecoinKt;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.wallet.ripple.extensions.NetworkSetting_RippleKt;
import com.coinbase.wallet.stellar.extensions.NetworkSetting_StellarKt;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ConsumerAccountsRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "consumerNetworkToNetworkSetting", "Ljava/util/Map;", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAccountsRepositoryKt {
    private static final Map<String, NetworkSetting> consumerNetworkToNetworkSetting;

    static {
        Map<String, NetworkSetting> l2;
        NetworkSetting.Companion companion = NetworkSetting.Companion;
        l2 = kotlin.a0.m0.l(kotlin.u.a(WalletConstants.URIPrefixes.ETH, NetworkSetting_EthereumKt.getETH(companion)), kotlin.u.a(WalletConstants.URIPrefixes.XLM_ALT, NetworkSetting_StellarKt.getXLM(companion)), kotlin.u.a(WalletConstants.URIPrefixes.XRP, NetworkSetting_RippleKt.getXRP(companion)), kotlin.u.a("bitcoin_cash", NetworkSetting_BitcoinCashKt.getBCH(companion)), kotlin.u.a(WalletConstants.URIPrefixes.ETC, NetworkSetting_EthereumKt.getETC(companion)), kotlin.u.a("bitcoin", NetworkSetting_BitcoinKt.getBTC(companion)), kotlin.u.a("litecoin", NetworkSetting_LitecoinKt.getLTC(companion)));
        consumerNetworkToNetworkSetting = l2;
    }
}