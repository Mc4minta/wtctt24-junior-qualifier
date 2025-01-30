package com.coinbase.wallet.ethereum.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.ethereum.interfaces.EthereumBasedWalletManaging;
import com.coinbase.wallet.ethereum.interfaces.IETCWalletRepository;
import kotlin.Metadata;

/* compiled from: ETCWalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/ethereum/repositories/ETCWalletRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumBasedWalletManaging;", "Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "erc20Dao", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "erc20TokenAPI", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "<init>", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ETCWalletRepository extends EthereumBasedWalletManaging implements IETCWalletRepository {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ETCWalletRepository(com.coinbase.wallet.blockchains.daos.AddressDao r15, com.coinbase.wallet.blockchains.daos.WalletDao r16, com.coinbase.wallet.store.interfaces.StoreInterface r17, com.coinbase.ciphercore.CipherCoreInterface r18, com.coinbase.wallet.ethereum.daos.ERC20Dao r19, com.coinbase.wallet.ethereum.apis.ERC20TokenAPI r20, com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao r21) {
        /*
            r14 = this;
            java.lang.String r0 = "addressDao"
            r10 = r15
            kotlin.jvm.internal.m.g(r15, r0)
            java.lang.String r0 = "walletDao"
            r11 = r16
            kotlin.jvm.internal.m.g(r11, r0)
            java.lang.String r0 = "store"
            r5 = r17
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.String r0 = "cipherCore"
            r12 = r18
            kotlin.jvm.internal.m.g(r12, r0)
            java.lang.String r0 = "erc20Dao"
            r8 = r19
            kotlin.jvm.internal.m.g(r8, r0)
            java.lang.String r0 = "erc20TokenAPI"
            r9 = r20
            kotlin.jvm.internal.m.g(r9, r0)
            java.lang.String r0 = "ethereumSignedTxDao"
            r6 = r21
            kotlin.jvm.internal.m.g(r6, r0)
            com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration$Companion r0 = com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration.Companion
            com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration r13 = com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt.getETC(r0)
            com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration r2 = com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt.getETC(r0)
            com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository r0 = new com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository
            r1 = r0
            r3 = r15
            r4 = r16
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r14
            r2 = r13
            r4 = r0
            r5 = r16
            r6 = r18
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.ethereum.repositories.ETCWalletRepository.<init>(com.coinbase.wallet.blockchains.daos.AddressDao, com.coinbase.wallet.blockchains.daos.WalletDao, com.coinbase.wallet.store.interfaces.StoreInterface, com.coinbase.ciphercore.CipherCoreInterface, com.coinbase.wallet.ethereum.daos.ERC20Dao, com.coinbase.wallet.ethereum.apis.ERC20TokenAPI, com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao):void");
    }
}