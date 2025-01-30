package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.ethereum.models.ContractAddress;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: ContractAddress+Swap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ContractAddress$Companion;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "swapProxySpender$delegate", "Lkotlin/h;", "getSwapProxySpender", "(Lcom/coinbase/wallet/ethereum/models/ContractAddress$Companion;)Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "swapProxySpender", "swapProxy$delegate", "getSwapProxy", "swapProxy", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ContractAddress_SwapKt {
    private static final h swapProxy$delegate;
    private static final h swapProxySpender$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(ContractAddress_SwapKt$swapProxy$2.INSTANCE);
        swapProxy$delegate = b2;
        b3 = k.b(ContractAddress_SwapKt$swapProxySpender$2.INSTANCE);
        swapProxySpender$delegate = b3;
    }

    public static final ContractAddress getSwapProxy(ContractAddress.Companion companion) {
        m.g(companion, "<this>");
        return (ContractAddress) swapProxy$delegate.getValue();
    }

    public static final ContractAddress getSwapProxySpender(ContractAddress.Companion companion) {
        m.g(companion, "<this>");
        return (ContractAddress) swapProxySpender$delegate.getValue();
    }
}