package com.coinbase.wallet.features.swap.extensions;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.swap.models.SwapAsset;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.m;

/* compiled from: Wallet+Swap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/Wallet;", "Lcom/coinbase/wallet/swap/models/SwapAsset;", "asSwapAsset", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)Lcom/coinbase/wallet/swap/models/SwapAsset;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Wallet_SwapKt {
    public static final SwapAsset asSwapAsset(Wallet wallet) {
        List g2;
        m.g(wallet, "<this>");
        String displayName = wallet.getDisplayName();
        CurrencyCode currencyCode = wallet.getCurrencyCode();
        int decimals = wallet.getDecimals();
        URL imageURL = wallet.getImageURL();
        g2 = r.g();
        String contractAddress = wallet.getContractAddress();
        return new SwapAsset(displayName, currencyCode, contractAddress == null ? null : new ContractAddress(contractAddress), decimals, imageURL, true, g2);
    }
}