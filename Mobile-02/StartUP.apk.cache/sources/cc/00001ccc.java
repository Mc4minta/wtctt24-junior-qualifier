package com.coinbase.wallet.ethereum.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.EthereumBasedTxManaging;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import kotlin.Metadata;

/* compiled from: ETHTxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/ethereum/repositories/ETHTxRepository;", "Lcom/coinbase/wallet/ethereum/interfaces/EthereumBasedTxManaging;", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "ethereumSignedTxDao", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "getEthereumSignedTxDao", "()Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "getStore", "()Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "erc20Dao", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "erc20TokenAPI", "<init>", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ETHTxRepository extends EthereumBasedTxManaging implements IETHTxRepository {
    private final EthereumSignedTxDao ethereumSignedTxDao;
    private final StoreInterface store;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ETHTxRepository(com.coinbase.ciphercore.CipherCoreInterface r20, com.coinbase.wallet.blockchains.daos.AddressDao r21, com.coinbase.wallet.blockchains.daos.WalletDao r22, com.coinbase.wallet.ethereum.apis.MinerFeeAPI r23, com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao r24, com.coinbase.wallet.store.interfaces.StoreInterface r25, com.coinbase.wallet.ethereum.daos.ERC20Dao r26, com.coinbase.wallet.ethereum.apis.ERC20TokenAPI r27) {
        /*
            r19 = this;
            r7 = r19
            r6 = r24
            r5 = r25
            java.lang.String r0 = "cipherCore"
            r2 = r20
            kotlin.jvm.internal.m.g(r2, r0)
            java.lang.String r0 = "addressDao"
            r3 = r21
            kotlin.jvm.internal.m.g(r3, r0)
            java.lang.String r0 = "walletDao"
            r1 = r22
            kotlin.jvm.internal.m.g(r1, r0)
            java.lang.String r0 = "minerFeeAPI"
            r4 = r23
            kotlin.jvm.internal.m.g(r4, r0)
            java.lang.String r0 = "ethereumSignedTxDao"
            kotlin.jvm.internal.m.g(r6, r0)
            java.lang.String r0 = "store"
            kotlin.jvm.internal.m.g(r5, r0)
            java.lang.String r0 = "erc20Dao"
            r15 = r26
            kotlin.jvm.internal.m.g(r15, r0)
            java.lang.String r0 = "erc20TokenAPI"
            r14 = r27
            kotlin.jvm.internal.m.g(r14, r0)
            com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration$Companion r0 = com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration.Companion
            com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration r17 = com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt.getETH(r0)
            com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository r18 = new com.coinbase.wallet.ethereum.repositories.EthereumBasedBalanceRepository
            com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration r9 = com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt.getETH(r0)
            r8 = r18
            r10 = r21
            r11 = r22
            r12 = r25
            r13 = r24
            r14 = r20
            r16 = r27
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = r19
            r1 = r17
            r8 = r5
            r5 = r18
            r9 = r6
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.ethereumSignedTxDao = r9
            r7.store = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.ethereum.repositories.ETHTxRepository.<init>(com.coinbase.ciphercore.CipherCoreInterface, com.coinbase.wallet.blockchains.daos.AddressDao, com.coinbase.wallet.blockchains.daos.WalletDao, com.coinbase.wallet.ethereum.apis.MinerFeeAPI, com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao, com.coinbase.wallet.store.interfaces.StoreInterface, com.coinbase.wallet.ethereum.daos.ERC20Dao, com.coinbase.wallet.ethereum.apis.ERC20TokenAPI):void");
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxSubmitting, com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning, com.coinbase.wallet.ethereum.interfaces.EthereumTxResubmitting
    public EthereumSignedTxDao getEthereumSignedTxDao() {
        return this.ethereumSignedTxDao;
    }

    @Override // com.coinbase.wallet.ethereum.interfaces.EthereumTxSigning
    public StoreInterface getStore() {
        return this.store;
    }
}