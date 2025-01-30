package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.qr.models.WalletConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: HTTPService+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPService$Companion;", "", RouteActionKey.RouteActionKeys.CHAIN_ID, "Lcom/coinbase/wallet/http/models/HTTPService;", WalletConstants.URIPrefixes.ETH, "(Lcom/coinbase/wallet/http/models/HTTPService$Companion;I)Lcom/coinbase/wallet/http/models/HTTPService;", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HTTPService_EthereumKt {
    public static final HTTPService ethereum(HTTPService.Companion companion, int i2) {
        m.g(companion, "<this>");
        EthereumChain fromChainId = EthereumChain.Companion.fromChainId(i2);
        m.e(fromChainId);
        return new HTTPService(new URL(fromChainId.getRpcUrl()));
    }
}