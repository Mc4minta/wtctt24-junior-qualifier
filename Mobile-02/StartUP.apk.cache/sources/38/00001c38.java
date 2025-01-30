package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Network;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import kotlin.l0.w;
import kotlin.l0.y;

/* compiled from: EthereumChain+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0017\u0010\u000b\u001a\u00020\b*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/coinbase/ciphercore/ethereum/EthereumChain$Companion;", "", "rawValue", "Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "fromNetworkRawValue", "(Lcom/coinbase/ciphercore/ethereum/EthereumChain$Companion;Ljava/lang/String;)Lcom/coinbase/ciphercore/ethereum/EthereumChain;", "ETHEREUM_PREFIX", "Ljava/lang/String;", "Lcom/coinbase/wallet/blockchains/models/Network;", "getAsNetwork", "(Lcom/coinbase/ciphercore/ethereum/EthereumChain;)Lcom/coinbase/wallet/blockchains/models/Network;", "asNetwork", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class EthereumChain_EthereumKt {
    public static final String ETHEREUM_PREFIX = "ETHEREUM_CHAIN";

    public static final EthereumChain fromNetworkRawValue(EthereumChain.Companion companion, String rawValue) {
        List K0;
        EthereumChain[] values;
        m.g(companion, "<this>");
        m.g(rawValue, "rawValue");
        K0 = y.K0(rawValue, new String[]{"/"}, false, 0, 6, null);
        if (K0.size() != 2) {
            return null;
        }
        String str = (String) p.a0(K0);
        List K02 = str == null ? null : y.K0(str, new String[]{":"}, false, 0, 6, null);
        if (K02 == null) {
            K02 = r.g();
        }
        if (K02.size() == 2 && m.c(ETHEREUM_PREFIX, p.b0(K02, 0))) {
            String str2 = (String) p.b0(K02, 1);
            Integer q = str2 == null ? null : w.q(str2);
            if (q == null) {
                return null;
            }
            int intValue = q.intValue();
            for (EthereumChain ethereumChain : EthereumChain.values()) {
                if (ethereumChain.getChainId() == intValue) {
                    return ethereumChain;
                }
            }
            return null;
        }
        return null;
    }

    public static final Network getAsNetwork(EthereumChain ethereumChain) {
        m.g(ethereumChain, "<this>");
        return new Network(m.o("ETHEREUM_CHAIN:", Integer.valueOf(ethereumChain.getChainId())), ethereumChain.isTestnet());
    }
}