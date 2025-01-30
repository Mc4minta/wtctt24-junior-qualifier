package com.coinbase.wallet.di;

import android.app.Application;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.features.send.daos.RecipientDao;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.toshi.db.DerivedDatabase;
import com.toshi.db.WalletDatabase;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: DatabaseModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/di/DatabaseModule;", "", "<init>", "()V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class DatabaseModule {
    public static final Companion Companion = new Companion(null);

    /* compiled from: DatabaseModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020 2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b!\u0010\"J\u001d\u0010$\u001a\u00020#2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/coinbase/wallet/di/DatabaseModule$Companion;", "", "Landroid/app/Application;", "app", "Lcom/toshi/db/DerivedDatabase;", "providesDerivedDatabase", "(Landroid/app/Application;)Lcom/toshi/db/DerivedDatabase;", "Lcom/toshi/db/WalletDatabase;", "providesWalletDatabase", "(Landroid/app/Application;)Lcom/toshi/db/WalletDatabase;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/db/AppDatabase;", "providesAppDatabase", "(Landroid/app/Application;)Lcom/coinbase/wallet/libraries/databases/db/Database;", "derivedDatabase", "Lcom/toshi/db/i/b;", "providesErc721TokenDao", "(Lcom/toshi/db/DerivedDatabase;)Lcom/toshi/db/i/b;", "walletDatabase", "Lcom/toshi/db/g/b;", "providesBookmarkDao", "(Lcom/toshi/db/WalletDatabase;)Lcom/toshi/db/g/b;", "Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "providesUserDao", "(Lcom/toshi/db/DerivedDatabase;)Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "Lcom/toshi/db/h/b;", "providesCollectibleTypeDao", "(Lcom/toshi/db/DerivedDatabase;)Lcom/toshi/db/h/b;", "db", "Lcom/coinbase/wallet/features/send/daos/RecipientDao;", "providesSuggestedRecipientDao", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/features/send/daos/RecipientDao;", "Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "providesTxHistoryDao", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;", "providesTxAddressDAO", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)Lcom/coinbase/wallet/txhistory/daos/TxAddressDAO;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ApplicationScoped
        public final Database<AppDatabase> providesAppDatabase(Application app) {
            List j2;
            m.g(app, "app");
            j2 = r.j(new androidx.room.s.a() { // from class: com.coinbase.wallet.di.DatabaseModule$Companion$providesAppDatabase$migration2To3$1
                @Override // androidx.room.s.a
                public void migrate(c.r.a.b database) {
                    m.g(database, "database");
                    database.t("CREATE TABLE `Recipient` (`id` TEXT NOT NULL COLLATE NOCASE, `destination` TEXT NOT NULL,\n `blockchain` TEXT NOT NULL, `sendCount` INTEGER NOT NULL, `lastUsed` INTEGER NOT NULL,\n `recipientType` INTEGER NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE,\n `metadataKey` TEXT, `metadata` TEXT, `network` TEXT NOT NULL, PRIMARY KEY(`id`));");
                    database.t("CREATE INDEX `index_Recipient_blockchain_currencyCode_network` ON `Recipient`\n (`blockchain`, `currencyCode`, `network`);");
                    database.t("CREATE UNIQUE INDEX `index_Recipient_blockchain_currencyCode_network_recipientType_destination_metadataKey_metadata`\n ON `Recipient` (`blockchain`, `currencyCode`, `network`, `recipientType`, `destination`,\n `metadataKey`, `metadata`);");
                    database.t("CREATE TABLE `TxAddress` (`id` TEXT NOT NULL COLLATE NOCASE, `title` TEXT NOT NULL,\n `blockchain` TEXT NOT NULL, `currencyCode` TEXT NOT NULL, `address` TEXT NOT NULL,\n `recipientType` INTEGER NOT NULL, `metadataKey` TEXT, `metadata` TEXT,\n `network` TEXT NOT NULL, PRIMARY KEY(`id`));");
                    database.t("CREATE INDEX `index_TxAddress_blockchain_currencyCode_network` ON `TxAddress`\n (`blockchain`, `currencyCode`, `network`);");
                    database.t("CREATE UNIQUE INDEX `index_TxAddress_blockchain_currencyCode_network_address_metadataKey_metadata`\n ON `TxAddress` (`blockchain`, `currencyCode`, `network`, `address`, `metadataKey`, `metadata`);");
                    database.t("DROP TABLE `SuggestedRecipient`");
                }
            }, new androidx.room.s.a() { // from class: com.coinbase.wallet.di.DatabaseModule$Companion$providesAppDatabase$migration3to4$1
                @Override // androidx.room.s.a
                public void migrate(c.r.a.b database) {
                    m.g(database, "database");
                    database.t("DROP INDEX IF EXISTS `blockchain_currency_code_tx_hash`;");
                    database.t("CREATE UNIQUE INDEX `blockchain_currency_code_tx_hash` on `Transaction` \n(blockchain, currencyCode, txHash, amount);");
                }
            });
            return new Database<>(new DiskOptions(app, AppDatabase.class, "AppDatabase", j2, true));
        }

        @ApplicationScoped
        public final com.toshi.db.g.b providesBookmarkDao(WalletDatabase walletDatabase) {
            m.g(walletDatabase, "walletDatabase");
            return walletDatabase.h();
        }

        @ApplicationScoped
        public final com.toshi.db.h.b providesCollectibleTypeDao(DerivedDatabase derivedDatabase) {
            m.g(derivedDatabase, "derivedDatabase");
            return derivedDatabase.h();
        }

        @ApplicationScoped
        public final DerivedDatabase providesDerivedDatabase(Application app) {
            m.g(app, "app");
            return DerivedDatabase.a.b(app);
        }

        @ApplicationScoped
        public final com.toshi.db.i.b providesErc721TokenDao(DerivedDatabase derivedDatabase) {
            m.g(derivedDatabase, "derivedDatabase");
            return derivedDatabase.i();
        }

        @ApplicationScoped
        public final RecipientDao providesSuggestedRecipientDao(Database<AppDatabase> db) {
            m.g(db, "db");
            return new RecipientDao(db);
        }

        @ApplicationScoped
        public final TxAddressDAO providesTxAddressDAO(Database<AppDatabase> db) {
            m.g(db, "db");
            return new TxAddressDAO(db);
        }

        @ApplicationScoped
        public final TxHistoryDAO providesTxHistoryDao(Database<AppDatabase> db) {
            m.g(db, "db");
            return new TxHistoryDAO(db);
        }

        @ApplicationScoped
        public final UserDaoInterface providesUserDao(DerivedDatabase derivedDatabase) {
            m.g(derivedDatabase, "derivedDatabase");
            return derivedDatabase.j();
        }

        @ApplicationScoped
        public final WalletDatabase providesWalletDatabase(Application app) {
            m.g(app, "app");
            return WalletDatabase.a.b(app);
        }
    }

    @ApplicationScoped
    public static final Database<AppDatabase> providesAppDatabase(Application application) {
        return Companion.providesAppDatabase(application);
    }

    @ApplicationScoped
    public static final com.toshi.db.g.b providesBookmarkDao(WalletDatabase walletDatabase) {
        return Companion.providesBookmarkDao(walletDatabase);
    }

    @ApplicationScoped
    public static final com.toshi.db.h.b providesCollectibleTypeDao(DerivedDatabase derivedDatabase) {
        return Companion.providesCollectibleTypeDao(derivedDatabase);
    }

    @ApplicationScoped
    public static final DerivedDatabase providesDerivedDatabase(Application application) {
        return Companion.providesDerivedDatabase(application);
    }

    @ApplicationScoped
    public static final com.toshi.db.i.b providesErc721TokenDao(DerivedDatabase derivedDatabase) {
        return Companion.providesErc721TokenDao(derivedDatabase);
    }

    @ApplicationScoped
    public static final RecipientDao providesSuggestedRecipientDao(Database<AppDatabase> database) {
        return Companion.providesSuggestedRecipientDao(database);
    }

    @ApplicationScoped
    public static final TxAddressDAO providesTxAddressDAO(Database<AppDatabase> database) {
        return Companion.providesTxAddressDAO(database);
    }

    @ApplicationScoped
    public static final TxHistoryDAO providesTxHistoryDao(Database<AppDatabase> database) {
        return Companion.providesTxHistoryDao(database);
    }

    @ApplicationScoped
    public static final UserDaoInterface providesUserDao(DerivedDatabase derivedDatabase) {
        return Companion.providesUserDao(derivedDatabase);
    }

    @ApplicationScoped
    public static final WalletDatabase providesWalletDatabase(Application application) {
        return Companion.providesWalletDatabase(application);
    }
}