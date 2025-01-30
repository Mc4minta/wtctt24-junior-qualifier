package com.coinbase.wallet.features.wallets.extensions.legacy;

import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Wallet+Erc20.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "", "isErc20", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)Z", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Wallet_Erc20Kt {
    public static final boolean isErc20(Wallet wallet) {
        m.g(wallet, "<this>");
        return m.c(wallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && !m.c(wallet.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion));
    }
}