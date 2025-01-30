package com.coinbase.wallet.db;

import androidx.room.a;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.b;
import c.r.a.c;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.spongycastle.i18n.MessageBundle;

/* loaded from: classes.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile SuggestedRoomRecipientDao _suggestedRoomRecipientDao;
    private volatile TxAddressRoomDAO _txAddressRoomDAO;
    private volatile TxHistoryRoomDao _txHistoryRoomDao;

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `Recipient`");
            b2.t("DELETE FROM `Transaction`");
            b2.t("DELETE FROM `TxAddress`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.i0("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.F0()) {
                b2.t("VACUUM");
            }
        }
    }

    @Override // androidx.room.j
    protected g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "Recipient", "Transaction", "TxAddress");
    }

    @Override // androidx.room.j
    protected c createOpenHelper(a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new l.a(5) { // from class: com.coinbase.wallet.db.AppDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(b bVar) {
                bVar.t("CREATE TABLE IF NOT EXISTS `Recipient` (`id` TEXT NOT NULL COLLATE NOCASE, `destination` TEXT NOT NULL, `blockchain` TEXT NOT NULL, `sendCount` INTEGER NOT NULL, `lastUsed` INTEGER NOT NULL, `recipientType` INTEGER NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `metadataKey` TEXT, `metadata` TEXT, `network` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_Recipient_blockchain_currencyCode_network` ON `Recipient` (`blockchain`, `currencyCode`, `network`)");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_Recipient_blockchain_currencyCode_network_recipientType_destination_metadataKey_metadata` ON `Recipient` (`blockchain`, `currencyCode`, `network`, `recipientType`, `destination`, `metadataKey`, `metadata`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `Transaction` (`id` TEXT NOT NULL COLLATE NOCASE, `createdAt` INTEGER NOT NULL, `confirmedAt` INTEGER, `blockchain` TEXT NOT NULL, `currencyCode` TEXT NOT NULL, `feeCurrencyCode` TEXT NOT NULL, `toAddress` TEXT COLLATE NOCASE, `fromAddress` TEXT COLLATE NOCASE, `amount` TEXT NOT NULL, `fee` TEXT NOT NULL, `lowerBoundFee` TEXT, `state` INTEGER NOT NULL, `metadata` TEXT NOT NULL, `network` TEXT NOT NULL, `txHash` TEXT COLLATE NOCASE, `isSent` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `blockchain_currency_code_network` ON `Transaction` (`blockchain`, `currencyCode`, `network`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `blockchain_currency_code_network_from_address` ON `Transaction` (`blockchain`, `currencyCode`, `network`, `fromAddress`)");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `blockchain_currency_code_tx_hash` ON `Transaction` (`blockchain`, `currencyCode`, `txHash`, `amount`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `TxAddress` (`id` TEXT NOT NULL COLLATE NOCASE, `title` TEXT NOT NULL, `blockchain` TEXT NOT NULL, `currencyCode` TEXT NOT NULL, `address` TEXT NOT NULL, `recipientType` INTEGER NOT NULL, `metadataKey` TEXT, `metadata` TEXT, `network` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_TxAddress_blockchain_currencyCode_network` ON `TxAddress` (`blockchain`, `currencyCode`, `network`)");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_TxAddress_blockchain_currencyCode_network_address_metadataKey_metadata` ON `TxAddress` (`blockchain`, `currencyCode`, `network`, `address`, `metadataKey`, `metadata`)");
                bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9ba249076207321cd476f0e94e0d0e8e')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(b bVar) {
                bVar.t("DROP TABLE IF EXISTS `Recipient`");
                bVar.t("DROP TABLE IF EXISTS `Transaction`");
                bVar.t("DROP TABLE IF EXISTS `TxAddress`");
                if (((j) AppDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) AppDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) AppDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(b bVar) {
                if (((j) AppDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) AppDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) AppDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(b bVar) {
                ((j) AppDatabase_Impl.this).mDatabase = bVar;
                AppDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((j) AppDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) AppDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) AppDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onPostMigrate(b bVar) {
            }

            @Override // androidx.room.l.a
            public void onPreMigrate(b bVar) {
                androidx.room.t.c.a(bVar);
            }

            @Override // androidx.room.l.a
            protected l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(10);
                hashMap.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap.put("destination", new f.a("destination", "TEXT", true, 0, null, 1));
                hashMap.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap.put("sendCount", new f.a("sendCount", "INTEGER", true, 0, null, 1));
                hashMap.put("lastUsed", new f.a("lastUsed", "INTEGER", true, 0, null, 1));
                hashMap.put("recipientType", new f.a("recipientType", "INTEGER", true, 0, null, 1));
                hashMap.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap.put("metadataKey", new f.a("metadataKey", "TEXT", false, 0, null, 1));
                hashMap.put(SendConfirmationArgs.metadataKey, new f.a(SendConfirmationArgs.metadataKey, "TEXT", false, 0, null, 1));
                hashMap.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new f.d("index_Recipient_blockchain_currencyCode_network", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network")));
                hashSet2.add(new f.d("index_Recipient_blockchain_currencyCode_network_recipientType_destination_metadataKey_metadata", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", "recipientType", "destination", "metadataKey", SendConfirmationArgs.metadataKey)));
                f fVar = new f("Recipient", hashMap, hashSet, hashSet2);
                f a = f.a(bVar, "Recipient");
                if (!fVar.equals(a)) {
                    return new l.b(false, "Recipient(com.coinbase.wallet.features.send.models.Recipient).\n Expected:\n" + fVar + "\n Found:\n" + a);
                }
                HashMap hashMap2 = new HashMap(16);
                hashMap2.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap2.put("createdAt", new f.a("createdAt", "INTEGER", true, 0, null, 1));
                hashMap2.put("confirmedAt", new f.a("confirmedAt", "INTEGER", false, 0, null, 1));
                hashMap2.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap2.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap2.put("feeCurrencyCode", new f.a("feeCurrencyCode", "TEXT", true, 0, null, 1));
                hashMap2.put("toAddress", new f.a("toAddress", "TEXT", false, 0, null, 1));
                hashMap2.put("fromAddress", new f.a("fromAddress", "TEXT", false, 0, null, 1));
                hashMap2.put("amount", new f.a("amount", "TEXT", true, 0, null, 1));
                hashMap2.put(ApiConstants.FEE, new f.a(ApiConstants.FEE, "TEXT", true, 0, null, 1));
                hashMap2.put("lowerBoundFee", new f.a("lowerBoundFee", "TEXT", false, 0, null, 1));
                hashMap2.put(ApiConstants.STATE, new f.a(ApiConstants.STATE, "INTEGER", true, 0, null, 1));
                hashMap2.put(SendConfirmationArgs.metadataKey, new f.a(SendConfirmationArgs.metadataKey, "TEXT", true, 0, null, 1));
                hashMap2.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                hashMap2.put("txHash", new f.a("txHash", "TEXT", false, 0, null, 1));
                hashMap2.put("isSent", new f.a("isSent", "INTEGER", true, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(3);
                hashSet4.add(new f.d("blockchain_currency_code_network", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network")));
                hashSet4.add(new f.d("blockchain_currency_code_network_from_address", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", "fromAddress")));
                hashSet4.add(new f.d("blockchain_currency_code_tx_hash", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "txHash", "amount")));
                f fVar2 = new f("Transaction", hashMap2, hashSet3, hashSet4);
                f a2 = f.a(bVar, "Transaction");
                if (!fVar2.equals(a2)) {
                    return new l.b(false, "Transaction(com.coinbase.wallet.blockchains.models.Transaction).\n Expected:\n" + fVar2 + "\n Found:\n" + a2);
                }
                HashMap hashMap3 = new HashMap(9);
                hashMap3.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap3.put(MessageBundle.TITLE_ENTRY, new f.a(MessageBundle.TITLE_ENTRY, "TEXT", true, 0, null, 1));
                hashMap3.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap3.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap3.put("address", new f.a("address", "TEXT", true, 0, null, 1));
                hashMap3.put("recipientType", new f.a("recipientType", "INTEGER", true, 0, null, 1));
                hashMap3.put("metadataKey", new f.a("metadataKey", "TEXT", false, 0, null, 1));
                hashMap3.put(SendConfirmationArgs.metadataKey, new f.a(SendConfirmationArgs.metadataKey, "TEXT", false, 0, null, 1));
                hashMap3.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(2);
                hashSet6.add(new f.d("index_TxAddress_blockchain_currencyCode_network", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network")));
                hashSet6.add(new f.d("index_TxAddress_blockchain_currencyCode_network_address_metadataKey_metadata", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", "address", "metadataKey", SendConfirmationArgs.metadataKey)));
                f fVar3 = new f("TxAddress", hashMap3, hashSet5, hashSet6);
                f a3 = f.a(bVar, "TxAddress");
                if (!fVar3.equals(a3)) {
                    return new l.b(false, "TxAddress(com.coinbase.wallet.txhistory.models.TxAddress).\n Expected:\n" + fVar3 + "\n Found:\n" + a3);
                }
                return new l.b(true, null);
            }
        }, "9ba249076207321cd476f0e94e0d0e8e", "37bf85ce161a672edf3794396968ea2a")).a());
    }

    @Override // com.coinbase.wallet.db.AppDatabase
    public SuggestedRoomRecipientDao getSuggestedRecipientDao() {
        SuggestedRoomRecipientDao suggestedRoomRecipientDao;
        if (this._suggestedRoomRecipientDao != null) {
            return this._suggestedRoomRecipientDao;
        }
        synchronized (this) {
            if (this._suggestedRoomRecipientDao == null) {
                this._suggestedRoomRecipientDao = new SuggestedRoomRecipientDao_Impl(this);
            }
            suggestedRoomRecipientDao = this._suggestedRoomRecipientDao;
        }
        return suggestedRoomRecipientDao;
    }

    @Override // com.coinbase.wallet.db.AppDatabase
    public TxAddressRoomDAO getTxAddressDAO() {
        TxAddressRoomDAO txAddressRoomDAO;
        if (this._txAddressRoomDAO != null) {
            return this._txAddressRoomDAO;
        }
        synchronized (this) {
            if (this._txAddressRoomDAO == null) {
                this._txAddressRoomDAO = new TxAddressRoomDAO_Impl(this);
            }
            txAddressRoomDAO = this._txAddressRoomDAO;
        }
        return txAddressRoomDAO;
    }

    @Override // com.coinbase.wallet.db.AppDatabase
    public TxHistoryRoomDao getTxHistoryDao() {
        TxHistoryRoomDao txHistoryRoomDao;
        if (this._txHistoryRoomDao != null) {
            return this._txHistoryRoomDao;
        }
        synchronized (this) {
            if (this._txHistoryRoomDao == null) {
                this._txHistoryRoomDao = new TxHistoryRoomDao_Impl(this);
            }
            txHistoryRoomDao = this._txHistoryRoomDao;
        }
        return txHistoryRoomDao;
    }
}