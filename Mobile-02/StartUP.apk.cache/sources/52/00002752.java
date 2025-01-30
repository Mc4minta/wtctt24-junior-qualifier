package com.coinbase.wallet.txhistory.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.http.models.HTTPService;
import com.coinbase.wallet.txhistory.exceptions.TxHistoryException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: HTTPService+TxHistory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"!\u0010\n\u001a\u00020\u0003*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/http/models/HTTPService$Companion;", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "chain", "Lcom/coinbase/wallet/http/models/HTTPService;", "etherscan", "(Lcom/coinbase/wallet/http/models/HTTPService$Companion;Lcom/coinbase/ciphercore/ethereum/EthereumChain;)Lcom/coinbase/wallet/http/models/HTTPService;", "txHistory$delegate", "Lkotlin/h;", "getTxHistory", "(Lcom/coinbase/wallet/http/models/HTTPService$Companion;)Lcom/coinbase/wallet/http/models/HTTPService;", "txHistory", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class HTTPService_TxHistoryKt {
    private static final h txHistory$delegate;

    static {
        h b2;
        b2 = k.b(HTTPService_TxHistoryKt$txHistory$2.INSTANCE);
        txHistory$delegate = b2;
    }

    public static final HTTPService etherscan(HTTPService.Companion companion, EthereumChain chain) {
        m.g(companion, "<this>");
        m.g(chain, "chain");
        URL asURL = String_CoreKt.getAsURL(chain.getEtherscanCompatibleTxHistoryApi());
        if (asURL != null) {
            return new HTTPService(asURL);
        }
        throw TxHistoryException.InvalidEthereumNetwork.INSTANCE;
    }

    public static final HTTPService getTxHistory(HTTPService.Companion companion) {
        m.g(companion, "<this>");
        return (HTTPService) txHistory$delegate.getValue();
    }
}