package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.wallet.blockchains.models.NetworkSetting;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: NetworkSetting+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"!\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\t\u001a\u00020\u0001*\u00020\u00008F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSetting$Companion;", "Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "ETC$delegate", "Lkotlin/h;", "getETC", "(Lcom/coinbase/wallet/blockchains/models/NetworkSetting$Companion;)Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "ETC", "ETH$delegate", "getETH", "ETH", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NetworkSetting_EthereumKt {
    private static final h ETC$delegate;
    private static final h ETH$delegate;

    static {
        h b2;
        h b3;
        b2 = k.b(NetworkSetting_EthereumKt$ETC$2.INSTANCE);
        ETC$delegate = b2;
        b3 = k.b(NetworkSetting_EthereumKt$ETH$2.INSTANCE);
        ETH$delegate = b3;
    }

    public static final NetworkSetting getETC(NetworkSetting.Companion companion) {
        m.g(companion, "<this>");
        return (NetworkSetting) ETC$delegate.getValue();
    }

    public static final NetworkSetting getETH(NetworkSetting.Companion companion) {
        m.g(companion, "<this>");
        return (NetworkSetting) ETH$delegate.getValue();
    }
}