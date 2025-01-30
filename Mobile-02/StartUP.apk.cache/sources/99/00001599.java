package com.coinbase.wallet.consumer.db;

import androidx.room.a;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.b;
import c.r.a.c;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class ConsumerDatabase_Impl extends ConsumerDatabase {
    private volatile ConsumerAccountsRoomDAO _consumerAccountsRoomDAO;
    private volatile ConsumerAvailablePaymentMethodsRoomDAO _consumerAvailablePaymentMethodsRoomDAO;
    private volatile ConsumerPaymentMethodsRoomDAO _consumerPaymentMethodsRoomDAO;

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `accounts`");
            b2.t("DELETE FROM `paymentMethods`");
            b2.t("DELETE FROM `availablePaymentMethods`");
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
        return new g(this, new HashMap(0), new HashMap(0), ApiConstants.ACCOUNTS, "paymentMethods", "availablePaymentMethods");
    }

    @Override // androidx.room.j
    protected c createOpenHelper(a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new l.a(12) { // from class: com.coinbase.wallet.consumer.db.ConsumerDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(b bVar) {
                bVar.t("CREATE TABLE IF NOT EXISTS `accounts` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `balance` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `currencyName` TEXT NOT NULL, `decimals` INTEGER NOT NULL, `type` TEXT NOT NULL, `imageUrl` TEXT, `destination_tag_name` TEXT, `asset_id` TEXT, PRIMARY KEY(`id`))");
                bVar.t("CREATE TABLE IF NOT EXISTS `paymentMethods` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `name` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `allow_buy` INTEGER NOT NULL, `allow_sell` INTEGER NOT NULL, `instant_buy` INTEGER NOT NULL, `buy_limit` TEXT NOT NULL, `verified` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE TABLE IF NOT EXISTS `availablePaymentMethods` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `name` TEXT, `description` TEXT, `additionalFees` TEXT, `buyingPower` TEXT, `buyTime` TEXT, `supportsBuy` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5ca1494276446f94cf9225fb79e9cd12')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(b bVar) {
                bVar.t("DROP TABLE IF EXISTS `accounts`");
                bVar.t("DROP TABLE IF EXISTS `paymentMethods`");
                bVar.t("DROP TABLE IF EXISTS `availablePaymentMethods`");
                if (((j) ConsumerDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) ConsumerDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) ConsumerDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(b bVar) {
                if (((j) ConsumerDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) ConsumerDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) ConsumerDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(b bVar) {
                ((j) ConsumerDatabase_Impl.this).mDatabase = bVar;
                ConsumerDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((j) ConsumerDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) ConsumerDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) ConsumerDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
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
                hashMap.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap.put("balance", new f.a("balance", "TEXT", true, 0, null, 1));
                hashMap.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap.put("currencyName", new f.a("currencyName", "TEXT", true, 0, null, 1));
                hashMap.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                hashMap.put("type", new f.a("type", "TEXT", true, 0, null, 1));
                hashMap.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0, null, 1));
                hashMap.put("destination_tag_name", new f.a("destination_tag_name", "TEXT", false, 0, null, 1));
                hashMap.put("asset_id", new f.a("asset_id", "TEXT", false, 0, null, 1));
                f fVar = new f(ApiConstants.ACCOUNTS, hashMap, new HashSet(0), new HashSet(0));
                f a = f.a(bVar, ApiConstants.ACCOUNTS);
                if (!fVar.equals(a)) {
                    return new l.b(false, "accounts(com.coinbase.wallet.consumer.models.ConsumerAccount).\n Expected:\n" + fVar + "\n Found:\n" + a);
                }
                HashMap hashMap2 = new HashMap(9);
                hashMap2.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap2.put("type", new f.a("type", "TEXT", true, 0, null, 1));
                hashMap2.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap2.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap2.put("allow_buy", new f.a("allow_buy", "INTEGER", true, 0, null, 1));
                hashMap2.put("allow_sell", new f.a("allow_sell", "INTEGER", true, 0, null, 1));
                hashMap2.put("instant_buy", new f.a("instant_buy", "INTEGER", true, 0, null, 1));
                hashMap2.put("buy_limit", new f.a("buy_limit", "TEXT", true, 0, null, 1));
                hashMap2.put("verified", new f.a("verified", "INTEGER", true, 0, null, 1));
                f fVar2 = new f("paymentMethods", hashMap2, new HashSet(0), new HashSet(0));
                f a2 = f.a(bVar, "paymentMethods");
                if (!fVar2.equals(a2)) {
                    return new l.b(false, "paymentMethods(com.coinbase.wallet.consumer.models.ConsumerPaymentMethod).\n Expected:\n" + fVar2 + "\n Found:\n" + a2);
                }
                HashMap hashMap3 = new HashMap(8);
                hashMap3.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap3.put("type", new f.a("type", "TEXT", true, 0, null, 1));
                hashMap3.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", false, 0, null, 1));
                hashMap3.put(ApiConstants.DESCRIPTION, new f.a(ApiConstants.DESCRIPTION, "TEXT", false, 0, null, 1));
                hashMap3.put("additionalFees", new f.a("additionalFees", "TEXT", false, 0, null, 1));
                hashMap3.put("buyingPower", new f.a("buyingPower", "TEXT", false, 0, null, 1));
                hashMap3.put("buyTime", new f.a("buyTime", "TEXT", false, 0, null, 1));
                hashMap3.put("supportsBuy", new f.a("supportsBuy", "INTEGER", true, 0, null, 1));
                f fVar3 = new f("availablePaymentMethods", hashMap3, new HashSet(0), new HashSet(0));
                f a3 = f.a(bVar, "availablePaymentMethods");
                if (!fVar3.equals(a3)) {
                    return new l.b(false, "availablePaymentMethods(com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod).\n Expected:\n" + fVar3 + "\n Found:\n" + a3);
                }
                return new l.b(true, null);
            }
        }, "5ca1494276446f94cf9225fb79e9cd12", "7ed1dc9e790e021c1297ff7a00c6470b")).a());
    }

    @Override // com.coinbase.wallet.consumer.db.ConsumerDatabase
    public ConsumerAccountsRoomDAO getConsumerAccountsDAO() {
        ConsumerAccountsRoomDAO consumerAccountsRoomDAO;
        if (this._consumerAccountsRoomDAO != null) {
            return this._consumerAccountsRoomDAO;
        }
        synchronized (this) {
            if (this._consumerAccountsRoomDAO == null) {
                this._consumerAccountsRoomDAO = new ConsumerAccountsRoomDAO_Impl(this);
            }
            consumerAccountsRoomDAO = this._consumerAccountsRoomDAO;
        }
        return consumerAccountsRoomDAO;
    }

    @Override // com.coinbase.wallet.consumer.db.ConsumerDatabase
    public ConsumerAvailablePaymentMethodsRoomDAO getConsumerAvailablePaymentMethodsDAO() {
        ConsumerAvailablePaymentMethodsRoomDAO consumerAvailablePaymentMethodsRoomDAO;
        if (this._consumerAvailablePaymentMethodsRoomDAO != null) {
            return this._consumerAvailablePaymentMethodsRoomDAO;
        }
        synchronized (this) {
            if (this._consumerAvailablePaymentMethodsRoomDAO == null) {
                this._consumerAvailablePaymentMethodsRoomDAO = new ConsumerAvailablePaymentMethodsRoomDAO_Impl(this);
            }
            consumerAvailablePaymentMethodsRoomDAO = this._consumerAvailablePaymentMethodsRoomDAO;
        }
        return consumerAvailablePaymentMethodsRoomDAO;
    }

    @Override // com.coinbase.wallet.consumer.db.ConsumerDatabase
    public ConsumerPaymentMethodsRoomDAO getConsumerPaymentMethodsDAO() {
        ConsumerPaymentMethodsRoomDAO consumerPaymentMethodsRoomDAO;
        if (this._consumerPaymentMethodsRoomDAO != null) {
            return this._consumerPaymentMethodsRoomDAO;
        }
        synchronized (this) {
            if (this._consumerPaymentMethodsRoomDAO == null) {
                this._consumerPaymentMethodsRoomDAO = new ConsumerPaymentMethodsRoomDAO_Impl(this);
            }
            consumerPaymentMethodsRoomDAO = this._consumerPaymentMethodsRoomDAO;
        }
        return consumerPaymentMethodsRoomDAO;
    }
}