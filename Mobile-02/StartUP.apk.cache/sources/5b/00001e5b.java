package com.coinbase.wallet.features.lend.interfaces;

import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.ethereum.extensions.CurrencyCode_EthereumKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.features.lend.interfaces.LendWalletMapping;
import h.c.b0;
import h.c.m0.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendWalletMapping.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\b0\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/features/lend/interfaces/LendWalletMapping;", "", "Lh/c/b0;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWalletsSingle", "()Lh/c/b0;", "walletsSingle", "", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", "getWalletMapSingle", "walletMapSingle", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface LendWalletMapping {

    /* compiled from: LendWalletMapping.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        /* renamed from: _get_walletMapSingle_$lambda-2 */
        public static Map m1272_get_walletMapSingle_$lambda2(List wallets) {
            m.g(wallets, "wallets");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = wallets.iterator();
            while (it.hasNext()) {
                Wallet wallet = (Wallet) it.next();
                if (m.c(wallet.getCurrencyCode(), CurrencyCode_EthereumKt.getETH(CurrencyCode.Companion))) {
                    linkedHashMap.put(null, wallet);
                } else {
                    String contractAddress = wallet.getContractAddress();
                    if (contractAddress != null) {
                        linkedHashMap.put(new ContractAddress(contractAddress), wallet);
                    }
                }
            }
            return linkedHashMap;
        }

        public static /* synthetic */ Map a(List list) {
            return m1272_get_walletMapSingle_$lambda2(list);
        }

        public static b0<Map<ContractAddress, Wallet>> getWalletMapSingle(LendWalletMapping lendWalletMapping) {
            m.g(lendWalletMapping, "this");
            b0 map = lendWalletMapping.getWalletsSingle().map(new n() { // from class: com.coinbase.wallet.features.lend.interfaces.e
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return LendWalletMapping.DefaultImpls.a((List) obj);
                }
            });
            m.f(map, "walletsSingle.map { wallets ->\n            wallets.reduceIntoMap<ContractAddress?, Wallet, Wallet> { walletMap, wallet ->\n                if (wallet.currencyCode == CurrencyCode.ETH) {\n                    walletMap[null] = wallet\n                } else {\n                    wallet.contractAddress?.let { walletMap[ContractAddress(it)] = wallet }\n                }\n            }\n        }");
            return map;
        }
    }

    b0<Map<ContractAddress, Wallet>> getWalletMapSingle();

    b0<List<Wallet>> getWalletsSingle();
}