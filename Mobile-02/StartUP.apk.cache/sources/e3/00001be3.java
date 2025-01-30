package com.coinbase.wallet.ethereum.di;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.blockchains.annotations.WalletsDatabase;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.blockchains.interfaces.TxManaging;
import com.coinbase.wallet.blockchains.interfaces.WalletManaging;
import com.coinbase.wallet.ethereum.apis.ERC20TokenAPI;
import com.coinbase.wallet.ethereum.apis.ERC20TokenHTTP;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.apis.MinerFeeHTTP;
import com.coinbase.wallet.ethereum.daos.ERC20Dao;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.IERC20Fetching;
import com.coinbase.wallet.ethereum.interfaces.IETCTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETCWalletRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.ethereum.repositories.ERC20Fetching;
import com.coinbase.wallet.ethereum.repositories.ETCTxRepository;
import com.coinbase.wallet.ethereum.repositories.ETCWalletRepository;
import com.coinbase.wallet.ethereum.repositories.ETHTxRepository;
import com.coinbase.wallet.ethereum.repositories.ETHWalletRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import retrofit2.t;

/* compiled from: EthereumModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H!¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH!¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH!¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H!¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/ethereum/di/EthereumModule;", "", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "ethWalletRepository", "Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "providesETHWalletManaging$ethereum_release", "(Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "providesETHWalletManaging", "Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "etcWalletRepository", "providesETCWalletManaging$ethereum_release", "(Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;)Lcom/coinbase/wallet/blockchains/interfaces/WalletManaging;", "providesETCWalletManaging", "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "ethTxRepository", "Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesETHTxManaging$ethereum_release", "(Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesETHTxManaging", "Lcom/coinbase/wallet/ethereum/interfaces/IETCTxRepository;", "etcTxRepository", "providesETCTxManaging$ethereum_release", "(Lcom/coinbase/wallet/ethereum/interfaces/IETCTxRepository;)Lcom/coinbase/wallet/blockchains/interfaces/TxManaging;", "providesETCTxManaging", "<init>", "()V", "Companion", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class EthereumModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: EthereumModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b5\u00106J\u001d\u0010\u0007\u001a\u00020\u00042\f\b\u0001\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\b2\f\b\u0001\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0013\u0010\u0014JO\u0010$\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b\"\u0010#JO\u0010(\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b&\u0010'JG\u0010,\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\bH\u0001¢\u0006\u0004\b*\u0010+JG\u00100\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\bH\u0001¢\u0006\u0004\b.\u0010/J\u0017\u00104\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/coinbase/wallet/ethereum/di/EthereumModule$Companion;", "", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "database", "Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "providesERC20Dao$ethereum_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;", "providesERC20Dao", "Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "providesEthTxDAO$ethereum_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;", "providesEthTxDAO", "Lretrofit2/t;", "retrofit", "Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "erc20API$ethereum_release", "(Lretrofit2/t;)Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;", "erc20API", "Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI$ethereum_release", "(Lretrofit2/t;)Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;", "minerFeeAPI", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "addressDao", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "walletDao", "ethereumSignedTxDao", "erc20Dao", "erc20TokenAPI", "Lcom/coinbase/ciphercore/CipherCoreInterface;", "cipherCore", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "providesETHTxRepository$ethereum_release", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/ethereum/interfaces/IETHTxRepository;", "providesETHTxRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETCTxRepository;", "providesETCTxRepository$ethereum_release", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/MinerFeeAPI;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/store/interfaces/StoreInterface;)Lcom/coinbase/wallet/ethereum/interfaces/IETCTxRepository;", "providesETCTxRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "providesETHWalletRepository$ethereum_release", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;)Lcom/coinbase/wallet/ethereum/interfaces/IETHWalletRepository;", "providesETHWalletRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "providesETCWalletRepository$ethereum_release", "(Lcom/coinbase/wallet/blockchains/daos/AddressDao;Lcom/coinbase/wallet/blockchains/daos/WalletDao;Lcom/coinbase/wallet/ethereum/daos/ERC20Dao;Lcom/coinbase/wallet/ethereum/apis/ERC20TokenAPI;Lcom/coinbase/wallet/store/interfaces/StoreInterface;Lcom/coinbase/ciphercore/CipherCoreInterface;Lcom/coinbase/wallet/ethereum/daos/EthereumSignedTxDao;)Lcom/coinbase/wallet/ethereum/interfaces/IETCWalletRepository;", "providesETCWalletRepository", "Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "providesERC20Fetching$ethereum_release", "(Lcom/coinbase/ciphercore/CipherCoreInterface;)Lcom/coinbase/wallet/ethereum/interfaces/IERC20Fetching;", "providesERC20Fetching", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ERC20TokenAPI erc20API$ethereum_release(t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(ERC20TokenHTTP.class);
            m.f(c2, "retrofit.create(ERC20TokenHTTP::class.java)");
            return new ERC20TokenAPI((ERC20TokenHTTP) c2);
        }

        public final MinerFeeAPI minerFeeAPI$ethereum_release(t retrofit) {
            m.g(retrofit, "retrofit");
            Object c2 = retrofit.c(MinerFeeHTTP.class);
            m.f(c2, "retrofit.create(MinerFeeHTTP::class.java)");
            return new MinerFeeAPI((MinerFeeHTTP) c2);
        }

        public final ERC20Dao providesERC20Dao$ethereum_release(@WalletsDatabase Database<?> database) {
            m.g(database, "database");
            return new ERC20Dao(database);
        }

        public final IERC20Fetching providesERC20Fetching$ethereum_release(CipherCoreInterface cipherCore) {
            m.g(cipherCore, "cipherCore");
            return new ERC20Fetching(cipherCore);
        }

        public final IETCTxRepository providesETCTxRepository$ethereum_release(AddressDao addressDao, EthereumSignedTxDao ethereumSignedTxDao, WalletDao walletDao, ERC20Dao erc20Dao, MinerFeeAPI minerFeeAPI, ERC20TokenAPI erc20TokenAPI, CipherCoreInterface cipherCore, StoreInterface store) {
            m.g(addressDao, "addressDao");
            m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
            m.g(walletDao, "walletDao");
            m.g(erc20Dao, "erc20Dao");
            m.g(minerFeeAPI, "minerFeeAPI");
            m.g(erc20TokenAPI, "erc20TokenAPI");
            m.g(cipherCore, "cipherCore");
            m.g(store, "store");
            return new ETCTxRepository(cipherCore, addressDao, walletDao, minerFeeAPI, ethereumSignedTxDao, store, erc20Dao, erc20TokenAPI);
        }

        public final IETCWalletRepository providesETCWalletRepository$ethereum_release(AddressDao addressDao, WalletDao walletDao, ERC20Dao erc20Dao, ERC20TokenAPI erc20API, StoreInterface store, CipherCoreInterface cipherCore, EthereumSignedTxDao ethereumSignedTxDao) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(erc20Dao, "erc20Dao");
            m.g(erc20API, "erc20API");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
            return new ETCWalletRepository(addressDao, walletDao, store, cipherCore, erc20Dao, erc20API, ethereumSignedTxDao);
        }

        public final IETHTxRepository providesETHTxRepository$ethereum_release(AddressDao addressDao, WalletDao walletDao, EthereumSignedTxDao ethereumSignedTxDao, ERC20Dao erc20Dao, MinerFeeAPI minerFeeAPI, ERC20TokenAPI erc20TokenAPI, CipherCoreInterface cipherCore, StoreInterface store) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
            m.g(erc20Dao, "erc20Dao");
            m.g(minerFeeAPI, "minerFeeAPI");
            m.g(erc20TokenAPI, "erc20TokenAPI");
            m.g(cipherCore, "cipherCore");
            m.g(store, "store");
            return new ETHTxRepository(cipherCore, addressDao, walletDao, minerFeeAPI, ethereumSignedTxDao, store, erc20Dao, erc20TokenAPI);
        }

        public final IETHWalletRepository providesETHWalletRepository$ethereum_release(AddressDao addressDao, WalletDao walletDao, ERC20Dao erc20Dao, ERC20TokenAPI erc20API, StoreInterface store, CipherCoreInterface cipherCore, EthereumSignedTxDao ethereumSignedTxDao) {
            m.g(addressDao, "addressDao");
            m.g(walletDao, "walletDao");
            m.g(erc20Dao, "erc20Dao");
            m.g(erc20API, "erc20API");
            m.g(store, "store");
            m.g(cipherCore, "cipherCore");
            m.g(ethereumSignedTxDao, "ethereumSignedTxDao");
            return new ETHWalletRepository(addressDao, walletDao, store, cipherCore, ethereumSignedTxDao, erc20Dao, erc20API);
        }

        public final EthereumSignedTxDao providesEthTxDAO$ethereum_release(@WalletsDatabase Database<?> database) {
            m.g(database, "database");
            return new EthereumSignedTxDao(database);
        }
    }

    public abstract TxManaging providesETCTxManaging$ethereum_release(IETCTxRepository iETCTxRepository);

    public abstract WalletManaging providesETCWalletManaging$ethereum_release(IETCWalletRepository iETCWalletRepository);

    public abstract TxManaging providesETHTxManaging$ethereum_release(IETHTxRepository iETHTxRepository);

    public abstract WalletManaging providesETHWalletManaging$ethereum_release(IETHWalletRepository iETHWalletRepository);
}