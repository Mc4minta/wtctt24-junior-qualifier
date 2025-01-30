package com.coinbase.wallet.lending.db;

import androidx.room.a;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.b;
import c.r.a.c;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class LendDatabase_Impl extends LendDatabase {
    private volatile LendTokenRoomDAO _lendTokenRoomDAO;

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `LendToken`");
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
        return new g(this, new HashMap(0), new HashMap(0), "LendToken");
    }

    @Override // androidx.room.j
    protected c createOpenHelper(a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new l.a(3) { // from class: com.coinbase.wallet.lending.db.LendDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(b bVar) {
                bVar.t("CREATE TABLE IF NOT EXISTS `LendToken` (`id` TEXT NOT NULL COLLATE NOCASE, `walletAddress` TEXT NOT NULL COLLATE NOCASE, `name` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `decimals` INTEGER NOT NULL, `imageURL` TEXT, `contractAddress` TEXT COLLATE NOCASE, `supplyBalance` TEXT NOT NULL, `supplyInterestRate` TEXT NOT NULL, `globalSuppliedAmount` TEXT NOT NULL, `utilizationRate` TEXT NOT NULL, `collateralRate` TEXT NOT NULL, `isCollateralRateApplicable` INTEGER NOT NULL, `providerID` TEXT NOT NULL, `providerName` TEXT NOT NULL, `providerWebsiteURL` TEXT NOT NULL, `providerImageURL` TEXT NOT NULL, `rateDecimals` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_LendToken_walletAddress` ON `LendToken` (`walletAddress`)");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_LendToken_providerID_currencyCode_walletAddress` ON `LendToken` (`providerID`, `currencyCode`, `walletAddress`)");
                bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '389a5b2726aa11a63d5657eb3a35001f')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(b bVar) {
                bVar.t("DROP TABLE IF EXISTS `LendToken`");
                if (((j) LendDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) LendDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) LendDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(b bVar) {
                if (((j) LendDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) LendDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) LendDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(b bVar) {
                ((j) LendDatabase_Impl.this).mDatabase = bVar;
                LendDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((j) LendDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) LendDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) LendDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
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
                HashMap hashMap = new HashMap(18);
                hashMap.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap.put("walletAddress", new f.a("walletAddress", "TEXT", true, 0, null, 1));
                hashMap.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                hashMap.put("imageURL", new f.a("imageURL", "TEXT", false, 0, null, 1));
                hashMap.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", false, 0, null, 1));
                hashMap.put("supplyBalance", new f.a("supplyBalance", "TEXT", true, 0, null, 1));
                hashMap.put("supplyInterestRate", new f.a("supplyInterestRate", "TEXT", true, 0, null, 1));
                hashMap.put("globalSuppliedAmount", new f.a("globalSuppliedAmount", "TEXT", true, 0, null, 1));
                hashMap.put("utilizationRate", new f.a("utilizationRate", "TEXT", true, 0, null, 1));
                hashMap.put("collateralRate", new f.a("collateralRate", "TEXT", true, 0, null, 1));
                hashMap.put("isCollateralRateApplicable", new f.a("isCollateralRateApplicable", "INTEGER", true, 0, null, 1));
                hashMap.put("providerID", new f.a("providerID", "TEXT", true, 0, null, 1));
                hashMap.put("providerName", new f.a("providerName", "TEXT", true, 0, null, 1));
                hashMap.put("providerWebsiteURL", new f.a("providerWebsiteURL", "TEXT", true, 0, null, 1));
                hashMap.put("providerImageURL", new f.a("providerImageURL", "TEXT", true, 0, null, 1));
                hashMap.put("rateDecimals", new f.a("rateDecimals", "INTEGER", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new f.d("index_LendToken_walletAddress", false, Arrays.asList("walletAddress")));
                hashSet2.add(new f.d("index_LendToken_providerID_currencyCode_walletAddress", true, Arrays.asList("providerID", AppsFlyerProperties.CURRENCY_CODE, "walletAddress")));
                f fVar = new f("LendToken", hashMap, hashSet, hashSet2);
                f a = f.a(bVar, "LendToken");
                if (!fVar.equals(a)) {
                    return new l.b(false, "LendToken(com.coinbase.wallet.lending.models.LendToken).\n Expected:\n" + fVar + "\n Found:\n" + a);
                }
                return new l.b(true, null);
            }
        }, "389a5b2726aa11a63d5657eb3a35001f", "72b13dfa24b4858ac4099599c331a14e")).a());
    }

    @Override // com.coinbase.wallet.lending.db.LendDatabase
    public LendTokenRoomDAO getLendTokenRoomDao() {
        LendTokenRoomDAO lendTokenRoomDAO;
        if (this._lendTokenRoomDAO != null) {
            return this._lendTokenRoomDAO;
        }
        synchronized (this) {
            if (this._lendTokenRoomDAO == null) {
                this._lendTokenRoomDAO = new LendTokenRoomDAO_Impl(this);
            }
            lendTokenRoomDAO = this._lendTokenRoomDAO;
        }
        return lendTokenRoomDAO;
    }
}