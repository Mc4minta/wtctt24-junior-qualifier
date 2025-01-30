package com.coinbase.wallet.common.extensions;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import h.c.m0.n;
import h.c.s;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: WalletRepository+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a]\u0010\t\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006 \b*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "kotlin.jvm.PlatformType", "observeWallet", "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/s;", "Lcom/coinbase/wallet/ethereum/models/ContractAddress;", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "(Lcom/coinbase/wallet/wallets/interfaces/IWalletRepository;Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/ethereum/models/ContractAddress;)Lh/c/s;", "common_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class WalletRepository_CommonKt {
    public static /* synthetic */ Optional a(Blockchain blockchain, ContractAddress contractAddress, List list) {
        return m792observeWallet$lambda3(blockchain, contractAddress, list);
    }

    public static /* synthetic */ Optional b(CurrencyCode currencyCode, Blockchain blockchain, List list) {
        return m791observeWallet$lambda1(currencyCode, blockchain, list);
    }

    public static final s<Optional<Wallet>> observeWallet(IWalletRepository iWalletRepository, final Blockchain blockchain, final CurrencyCode currencyCode) {
        m.g(iWalletRepository, "<this>");
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        return iWalletRepository.observeWallets(false).map(new n() { // from class: com.coinbase.wallet.common.extensions.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository_CommonKt.b(CurrencyCode.this, blockchain, (List) obj);
            }
        });
    }

    /* renamed from: observeWallet$lambda-1 */
    public static final Optional m791observeWallet$lambda1(CurrencyCode currencyCode, Blockchain blockchain, List wallets) {
        Object obj;
        boolean z;
        m.g(currencyCode, "$currencyCode");
        m.g(blockchain, "$blockchain");
        m.g(wallets, "wallets");
        Iterator it = wallets.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Wallet wallet = (Wallet) obj;
            if (m.c(wallet.getCurrencyCode(), currencyCode) && m.c(wallet.getBlockchain(), blockchain)) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return OptionalKt.toOptional(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x003c A[SYNTHETIC] */
    /* renamed from: observeWallet$lambda-3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.coinbase.wallet.core.util.Optional m792observeWallet$lambda3(com.coinbase.wallet.blockchains.models.Blockchain r4, com.coinbase.wallet.ethereum.models.ContractAddress r5, java.util.List r6) {
        /*
            java.lang.String r0 = "$blockchain"
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "wallets"
            kotlin.jvm.internal.m.g(r6, r0)
            java.util.Iterator r6 = r6.iterator()
        Le:
            boolean r0 = r6.hasNext()
            r1 = 0
            if (r0 == 0) goto L3d
            java.lang.Object r0 = r6.next()
            r2 = r0
            com.coinbase.wallet.blockchains.models.Wallet r2 = (com.coinbase.wallet.blockchains.models.Wallet) r2
            com.coinbase.wallet.blockchains.models.Blockchain r3 = r2.getBlockchain()
            boolean r3 = kotlin.jvm.internal.m.c(r3, r4)
            if (r3 == 0) goto L39
            java.lang.String r2 = r2.getContractAddress()
            if (r5 != 0) goto L2d
            goto L31
        L2d:
            java.lang.String r1 = r5.getRawValue()
        L31:
            boolean r1 = kotlin.jvm.internal.m.c(r2, r1)
            if (r1 == 0) goto L39
            r1 = 1
            goto L3a
        L39:
            r1 = 0
        L3a:
            if (r1 == 0) goto Le
            r1 = r0
        L3d:
            com.coinbase.wallet.core.util.Optional r4 = com.coinbase.wallet.core.util.OptionalKt.toOptional(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.common.extensions.WalletRepository_CommonKt.m792observeWallet$lambda3(com.coinbase.wallet.blockchains.models.Blockchain, com.coinbase.wallet.ethereum.models.ContractAddress, java.util.List):com.coinbase.wallet.core.util.Optional");
    }

    public static final s<Optional<Wallet>> observeWallet(IWalletRepository iWalletRepository, final Blockchain blockchain, final ContractAddress contractAddress) {
        m.g(iWalletRepository, "<this>");
        m.g(blockchain, "blockchain");
        s map = iWalletRepository.observeWallets(false).map(new n() { // from class: com.coinbase.wallet.common.extensions.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return WalletRepository_CommonKt.a(Blockchain.this, contractAddress, (List) obj);
            }
        });
        m.f(map, "observeWallets(onlyUsable = false)\n        .map { wallets ->\n            wallets\n                .firstOrNull { it.blockchain == blockchain && it.contractAddress == contractAddress?.rawValue }\n                .toOptional()\n        }");
        return map;
    }
}