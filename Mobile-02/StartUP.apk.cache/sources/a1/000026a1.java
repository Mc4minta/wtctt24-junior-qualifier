package com.coinbase.wallet.swap.db;

import androidx.room.a;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.b;
import c.r.a.c;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class SwapDatabase_Impl extends SwapDatabase {
    private volatile SwapAssetStatsRoomDAO _swapAssetStatsRoomDAO;

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `SwapAssetStats`");
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
        return new g(this, new HashMap(0), new HashMap(0), "SwapAssetStats");
    }

    @Override // androidx.room.j
    protected c createOpenHelper(a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new l.a(1) { // from class: com.coinbase.wallet.swap.db.SwapDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(b bVar) {
                bVar.t("CREATE TABLE IF NOT EXISTS `SwapAssetStats` (`id` TEXT NOT NULL, `blockchain` TEXT NOT NULL, `currencyCode` TEXT NOT NULL, `contractAddress` TEXT, `selectedCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_SwapAssetStats_blockchain_currencyCode_contractAddress` ON `SwapAssetStats` (`blockchain`, `currencyCode`, `contractAddress`)");
                bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f111f1f3d3c5321c1cb9b2063809edba')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(b bVar) {
                bVar.t("DROP TABLE IF EXISTS `SwapAssetStats`");
                if (((j) SwapDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) SwapDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) SwapDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(b bVar) {
                if (((j) SwapDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) SwapDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) SwapDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(b bVar) {
                ((j) SwapDatabase_Impl.this).mDatabase = bVar;
                SwapDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((j) SwapDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) SwapDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) SwapDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
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
                HashMap hashMap = new HashMap(5);
                hashMap.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", false, 0, null, 1));
                hashMap.put("selectedCount", new f.a("selectedCount", "INTEGER", true, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new f.d("index_SwapAssetStats_blockchain_currencyCode_contractAddress", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS)));
                f fVar = new f("SwapAssetStats", hashMap, hashSet, hashSet2);
                f a = f.a(bVar, "SwapAssetStats");
                if (!fVar.equals(a)) {
                    return new l.b(false, "SwapAssetStats(com.coinbase.wallet.swap.models.SwapAssetStats).\n Expected:\n" + fVar + "\n Found:\n" + a);
                }
                return new l.b(true, null);
            }
        }, "f111f1f3d3c5321c1cb9b2063809edba", "e0a7c7619ccddf6ce11fc22f94ef99c7")).a());
    }

    @Override // com.coinbase.wallet.swap.db.SwapDatabase
    public SwapAssetStatsRoomDAO getSwapAssetStatsRoomDAO() {
        SwapAssetStatsRoomDAO swapAssetStatsRoomDAO;
        if (this._swapAssetStatsRoomDAO != null) {
            return this._swapAssetStatsRoomDAO;
        }
        synchronized (this) {
            if (this._swapAssetStatsRoomDAO == null) {
                this._swapAssetStatsRoomDAO = new SwapAssetStatsRoomDAO_Impl(this);
            }
            swapAssetStatsRoomDAO = this._swapAssetStatsRoomDAO;
        }
        return swapAssetStatsRoomDAO;
    }
}