package com.coinbase.wallet.bitcoin.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedWalletManaging;
import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import com.coinbase.wallet.bitcoin.extensions.BIP44Configuration_BitcoinKt;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BTCWalletRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/bitcoin/repositories/BTCWalletRepository;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BasedWalletManaging;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/bitcoin/services/BTCService;", "walletService", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bitcoin/services/BTCService;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)V", "bitcoin_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BTCWalletRepository extends BIP44BasedWalletManaging {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BTCWalletRepository(StoreInterface store, AddressDao addressDao, WalletDao walletDao, BTCService walletService, CipherCoreInterface cipherCore, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
        super(cipherCore, walletService, BIP44Configuration_BitcoinKt.getBTC(BIP44Configuration.Companion), walletDao, addressDao, store, tracer, batchBalanceAPI);
        m.g(store, "store");
        m.g(addressDao, "addressDao");
        m.g(walletDao, "walletDao");
        m.g(walletService, "walletService");
        m.g(cipherCore, "cipherCore");
        m.g(tracer, "tracer");
        m.g(batchBalanceAPI, "batchBalanceAPI");
    }
}