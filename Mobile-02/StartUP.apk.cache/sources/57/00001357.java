package com.coinbase.wallet.bitcoin.repositories;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.bip44wallets.apis.BatchBalanceAPI;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.bip44wallets.interfaces.BIP44BasedTxManaging;
import com.coinbase.wallet.bip44wallets.models.BIP44Configuration;
import com.coinbase.wallet.bitcoin.extensions.BIP44Configuration_BitcoinKt;
import com.coinbase.wallet.bitcoin.services.BTCService;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BTCTxRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/bitcoin/repositories/BTCTxRepository;", "Lcom/coinbase/wallet/bip44wallets/interfaces/BIP44BasedTxManaging;", "Lcom/coinbase/wallet/bitcoin/services/BTCService;", "walletService", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;", "txDao", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/core/interfaces/Tracing;", "tracer", "Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;", "batchBalanceAPI", "<init>", "(Lcom/coinbase/wallet/bitcoin/services/BTCService;Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/wallet/core/interfaces/Tracing;Lcom/coinbase/wallet/bip44wallets/apis/BatchBalanceAPI;)V", "bitcoin_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BTCTxRepository extends BIP44BasedTxManaging {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BTCTxRepository(BTCService walletService, AddressDao addressDao, WalletDao walletDao, BIP44SignedTxDao txDao, CipherCoreInterface cipherCore, StoreInterface store, Tracing tracer, BatchBalanceAPI batchBalanceAPI) {
        super(txDao, cipherCore, BIP44Configuration_BitcoinKt.getBTC(BIP44Configuration.Companion), addressDao, walletDao, walletService, store, tracer, batchBalanceAPI);
        m.g(walletService, "walletService");
        m.g(addressDao, "addressDao");
        m.g(walletDao, "walletDao");
        m.g(txDao, "txDao");
        m.g(cipherCore, "cipherCore");
        m.g(store, "store");
        m.g(tracer, "tracer");
        m.g(batchBalanceAPI, "batchBalanceAPI");
    }
}