package com.coinbase.wallet.ethereum.extensions;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.NetworkSettingItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.o;

/* compiled from: NetworkSetting+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/coinbase/wallet/blockchains/models/NetworkSetting;", "<anonymous>", "()Lcom/coinbase/wallet/blockchains/models/NetworkSetting;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class NetworkSetting_EthereumKt$ETH$2 extends o implements kotlin.e0.c.a<NetworkSetting> {
    public static final NetworkSetting_EthereumKt$ETH$2 INSTANCE = new NetworkSetting_EthereumKt$ETH$2();

    NetworkSetting_EthereumKt$ETH$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final NetworkSetting invoke() {
        int r;
        List B0;
        List b2;
        List t0;
        EthereumChain[] values = EthereumChain.values();
        ArrayList<EthereumChain> arrayList = new ArrayList();
        int length = values.length;
        for (int i2 = 0; i2 < length; i2++) {
            EthereumChain ethereumChain = values[i2];
            if ((ethereumChain == EthereumChain.ETHEREUM_CLASSIC_MAINNET || ethereumChain == EthereumChain.ETHEREUM_MAINNET) ? false : true) {
                arrayList.add(ethereumChain);
            }
        }
        r = s.r(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(r);
        for (EthereumChain ethereumChain2 : arrayList) {
            arrayList2.add(NetworkSettingItem_EthereumKt.fromEthereumChain(NetworkSettingItem.Companion, ethereumChain2));
        }
        B0 = z.B0(arrayList2, new Comparator<T>() { // from class: com.coinbase.wallet.ethereum.extensions.NetworkSetting_EthereumKt$ETH$2$invoke$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int c2;
                c2 = kotlin.b0.b.c(((NetworkSettingItem) t).getName(), ((NetworkSettingItem) t2).getName());
                return c2;
            }
        });
        EthereumChain ethereumChain3 = EthereumChain.ETHEREUM_MAINNET;
        NetworkSettingItem networkSettingItem = new NetworkSettingItem(ethereumChain3.getDisplayName(), EthereumChain_EthereumKt.getAsNetwork(ethereumChain3));
        Blockchain ethereum = Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion);
        b2 = q.b(networkSettingItem);
        t0 = z.t0(b2, B0);
        return new NetworkSetting(ethereum, networkSettingItem, t0);
    }
}