package com.coinbase.wallet.wallets.di;

import android.app.Application;
import androidx.room.s.a;
import c.r.a.b;
import com.coinbase.wallet.bip44wallets.daos.BIP44SignedTxDao;
import com.coinbase.wallet.blockchains.daos.AddressDao;
import com.coinbase.wallet.blockchains.daos.WalletDao;
import com.coinbase.wallet.compoundfinance.daos.CompoundTokenDAO;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.ripple.daos.XRPSignedTxDAO;
import com.coinbase.wallet.stellar.daos.StellarSignedTxDao;
import com.coinbase.wallet.wallets.daos.CryptoCurrencyDAO;
import com.coinbase.wallet.wallets.daos.FiatCurrencyDAO;
import com.coinbase.wallet.wallets.daos.FiatExchangeRateDAO;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: DAOModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/wallets/di/DAOModule;", "", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "database", "providesWalletsDatabase", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/libraries/databases/db/Database;", "<init>", "()V", "Companion", "wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class DAOModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: DAOModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u00182\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001f\u001a\u00020\u001c2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020#2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020&2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u00020)2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/coinbase/wallet/wallets/di/DAOModule$Companion;", "", "", "Landroidx/room/s/a;", "providesMigrations", "()Ljava/util/List;", "Landroid/app/Application;", "app", "migrations", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/wallets/db/WalletsDatabase;", "providesDatabase", "(Landroid/app/Application;Ljava/util/List;)Lcom/coinbase/wallet/libraries/databases/db/Database;", "database", "Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "providesAddressDao", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/blockchains/daos/AddressDao;", "Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "providesWalletDao", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/blockchains/daos/WalletDao;", "Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;", "providesCryptoCurrencyDao$wallets_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/wallets/daos/CryptoCurrencyDAO;", "providesCryptoCurrencyDao", "Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;", "providesFiatCurrencyDao$wallets_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/wallets/daos/FiatCurrencyDAO;", "providesFiatCurrencyDao", "Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;", "providesFiatExchangeRateDao$wallets_release", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/wallets/daos/FiatExchangeRateDAO;", "providesFiatExchangeRateDao", "Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;", "providesCompoundTokenDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/compoundfinance/daos/CompoundTokenDAO;", "Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;", "providesBtcTxDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/bip44wallets/daos/BIP44SignedTxDao;", "Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "providesXrpTxDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/ripple/daos/XRPSignedTxDAO;", "Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;", "providesStellarTxDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/stellar/daos/StellarSignedTxDao;", "<init>", "()V", "wallets_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AddressDao providesAddressDao(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new AddressDao(database);
        }

        public final BIP44SignedTxDao providesBtcTxDAO(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new BIP44SignedTxDao(database);
        }

        public final CompoundTokenDAO providesCompoundTokenDAO(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new CompoundTokenDAO(database);
        }

        public final CryptoCurrencyDAO providesCryptoCurrencyDao$wallets_release(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new CryptoCurrencyDAO(database);
        }

        public final Database<WalletsDatabase> providesDatabase(Application app, List<a> migrations) {
            m.g(app, "app");
            m.g(migrations, "migrations");
            return new Database<>(new DiskOptions(app, WalletsDatabase.class, "Database", migrations, false, 16, null));
        }

        public final FiatCurrencyDAO providesFiatCurrencyDao$wallets_release(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new FiatCurrencyDAO(database);
        }

        public final FiatExchangeRateDAO providesFiatExchangeRateDao$wallets_release(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new FiatExchangeRateDAO(database);
        }

        public final List<a> providesMigrations() {
            List<a> j2;
            j2 = r.j(new a() { // from class: com.coinbase.wallet.wallets.di.DAOModule$Companion$providesMigrations$deleteErc20Migration1To2$1
                @Override // androidx.room.s.a
                public void migrate(b database) {
                    m.g(database, "database");
                    database.t("DELETE FROM Address WHERE contractAddress IS NOT NULL");
                }
            }, new a() { // from class: com.coinbase.wallet.wallets.di.DAOModule$Companion$providesMigrations$migrate2to3$1
                @Override // androidx.room.s.a
                public void migrate(b database) {
                    m.g(database, "database");
                    database.t("ALTER TABLE EthereumSignedTx ADD COLUMN notFoundCount INTEGER DEFAULT 0 NOT NULL");
                }
            }, new a() { // from class: com.coinbase.wallet.wallets.di.DAOModule$Companion$providesMigrations$migrate3to4$1
                @Override // androidx.room.s.a
                public void migrate(b database) {
                    m.g(database, "database");
                    database.t("DROP TABLE IF EXISTS tempTable");
                    database.t("CREATE TABLE IF NOT EXISTS `tempTable` (`id` TEXT NOT NULL COLLATE NOCASE, `fromAddress`\nTEXT NOT NULL COLLATE NOCASE, `toAddress` TEXT COLLATE NOCASE, `nonce` INTEGER NOT NULL,\n`chainId` INTEGER NOT NULL, `signedTxData` BLOB NOT NULL, `txHash` TEXT NOT NULL,\n`weiValue` TEXT NOT NULL, `erc20Value` TEXT, `blockchain` TEXT NOT NULL, `currencyCode`\nTEXT NOT NULL COLLATE NOCASE, `state` INTEGER NOT NULL, `notFoundCount` INTEGER NOT NULL,\nPRIMARY KEY(`id`))");
                    database.t("INSERT INTO tempTable (id, fromAddress, toAddress, nonce, chainId, signedTxData, txHash,\nweiValue, erc20Value, blockchain, currencyCode, state, notFoundCount) SELECT id, fromAddress,\ntoAddress, nonce, chainId, signedTxData, txHash, weiValue, erc20Value, blockchain,\ncurrencyCode, state, notFoundCount FROM EthereumSignedTx;");
                    database.t("DROP TABLE EthereumSignedTx");
                    database.t("ALTER TABLE tempTable RENAME TO `EthereumSignedTx`");
                    database.t("CREATE INDEX `index_EthereumSignedTx_state_chainId` ON `EthereumSignedTx` (`state`, `chainId`)");
                    database.t("CREATE INDEX `index_EthereumSignedTx_chainId_fromAddress_nonce` ON `EthereumSignedTx` (`chainId`, `fromAddress`, `nonce`)");
                    database.t("CREATE INDEX `index_EthereumSignedTx_chainId_nonce_fromAddress_currencyCode_state` ON `EthereumSignedTx` (`chainId`, `nonce`, `fromAddress`, `currencyCode`, `state`)");
                    database.t("CREATE INDEX `index_EthereumSignedTx_chainId_nonce_fromAddress_toAddress_state` ON `EthereumSignedTx` (`chainId`, `nonce`, `fromAddress`, `toAddress`, `state`)");
                }
            }, new a() { // from class: com.coinbase.wallet.wallets.di.DAOModule$Companion$providesMigrations$migrate4to5$1
                @Override // androidx.room.s.a
                public void migrate(b database) {
                    m.g(database, "database");
                    database.t("DROP TABLE IF EXISTS tempTable");
                    database.t("CREATE TABLE IF NOT EXISTS `tempTable` (`id` TEXT NOT NULL, `currencyCode`\nTEXT NOT NULL, `rate` TEXT NOT NULL, `contractAddress` TEXT, `chainId` INTEGER, \n`name` TEXT NOT NULL, PRIMARY KEY(`id`))");
                    database.t("DROP TABLE ExchangeRate");
                    database.t("ALTER TABLE tempTable RENAME TO `ExchangeRate`");
                    database.t("CREATE INDEX `index_ExchangeRate_currencyCode` ON `ExchangeRate` (`currencyCode`)");
                }
            }, new a() { // from class: com.coinbase.wallet.wallets.di.DAOModule$Companion$providesMigrations$migrate5to6$1
                @Override // androidx.room.s.a
                public void migrate(b database) {
                    m.g(database, "database");
                    database.t("ALTER TABLE CompoundToken ADD COLUMN underlyingContractAddress TEXT");
                    database.t("ALTER TABLE CompoundToken ADD COLUMN name TEXT DEFAULT '' NOT NULL");
                    database.t("ALTER TABLE CompoundToken ADD COLUMN underlyingDecimals INTEGER DEFAULT 18 NOT NULL");
                }
            }, new a() { // from class: com.coinbase.wallet.wallets.di.DAOModule$Companion$providesMigrations$clearExchangeRates$1
                @Override // androidx.room.s.a
                public void migrate(b database) {
                    m.g(database, "database");
                    database.t("DELETE FROM ExchangeRate");
                }
            });
            return j2;
        }

        public final StellarSignedTxDao providesStellarTxDAO(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new StellarSignedTxDao(database);
        }

        public final WalletDao providesWalletDao(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new WalletDao(database);
        }

        public final XRPSignedTxDAO providesXrpTxDAO(Database<WalletsDatabase> database) {
            m.g(database, "database");
            return new XRPSignedTxDAO(database);
        }
    }

    public static final AddressDao providesAddressDao(Database<WalletsDatabase> database) {
        return Companion.providesAddressDao(database);
    }

    public static final BIP44SignedTxDao providesBtcTxDAO(Database<WalletsDatabase> database) {
        return Companion.providesBtcTxDAO(database);
    }

    public static final CompoundTokenDAO providesCompoundTokenDAO(Database<WalletsDatabase> database) {
        return Companion.providesCompoundTokenDAO(database);
    }

    public static final Database<WalletsDatabase> providesDatabase(Application application, List<a> list) {
        return Companion.providesDatabase(application, list);
    }

    public static final List<a> providesMigrations() {
        return Companion.providesMigrations();
    }

    public static final StellarSignedTxDao providesStellarTxDAO(Database<WalletsDatabase> database) {
        return Companion.providesStellarTxDAO(database);
    }

    public static final WalletDao providesWalletDao(Database<WalletsDatabase> database) {
        return Companion.providesWalletDao(database);
    }

    public static final XRPSignedTxDAO providesXrpTxDAO(Database<WalletsDatabase> database) {
        return Companion.providesXrpTxDAO(database);
    }

    @com.coinbase.wallet.blockchains.annotations.WalletsDatabase
    public abstract Database<?> providesWalletsDatabase(Database<WalletsDatabase> database);
}