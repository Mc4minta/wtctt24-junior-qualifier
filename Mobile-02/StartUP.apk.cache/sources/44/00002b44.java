package com.coinbase.walletlink;

import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.c;
import com.coinbase.ApiConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class WalletLinkDatabase_Impl extends WalletLinkDatabase {
    private volatile DappRoomDao _dappRoomDao;

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        c.r.a.b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `Dapp`");
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
    protected androidx.room.g createInvalidationTracker() {
        return new androidx.room.g(this, new HashMap(0), new HashMap(0), "Dapp");
    }

    @Override // androidx.room.j
    protected c.r.a.c createOpenHelper(androidx.room.a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new l.a(1) { // from class: com.coinbase.walletlink.WalletLinkDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(c.r.a.b bVar) {
                bVar.t("CREATE TABLE IF NOT EXISTS `Dapp` (`id` TEXT NOT NULL COLLATE NOCASE, `url` TEXT NOT NULL, `name` TEXT, `logoURL` TEXT, PRIMARY KEY(`id`))");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_Dapp_url` ON `Dapp` (`url`)");
                bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dce55d52c3dfee428d85324e86e8cd24')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(c.r.a.b bVar) {
                bVar.t("DROP TABLE IF EXISTS `Dapp`");
                if (((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(c.r.a.b bVar) {
                if (((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(c.r.a.b bVar) {
                ((androidx.room.j) WalletLinkDatabase_Impl.this).mDatabase = bVar;
                WalletLinkDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks != null) {
                    int size = ((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((androidx.room.j) WalletLinkDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onPostMigrate(c.r.a.b bVar) {
            }

            @Override // androidx.room.l.a
            public void onPreMigrate(c.r.a.b bVar) {
                androidx.room.t.c.a(bVar);
            }

            @Override // androidx.room.l.a
            protected l.b onValidateSchema(c.r.a.b bVar) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap.put("url", new f.a("url", "TEXT", true, 0, null, 1));
                hashMap.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", false, 0, null, 1));
                hashMap.put("logoURL", new f.a("logoURL", "TEXT", false, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new f.d("index_Dapp_url", true, Arrays.asList("url")));
                androidx.room.t.f fVar = new androidx.room.t.f("Dapp", hashMap, hashSet, hashSet2);
                androidx.room.t.f a = androidx.room.t.f.a(bVar, "Dapp");
                if (!fVar.equals(a)) {
                    return new l.b(false, "Dapp(com.coinbase.walletlink.models.Dapp).\n Expected:\n" + fVar + "\n Found:\n" + a);
                }
                return new l.b(true, null);
            }
        }, "dce55d52c3dfee428d85324e86e8cd24", "ea6e2b21bb3751b19ee788ca8e7f36ea")).a());
    }

    @Override // com.coinbase.walletlink.WalletLinkDatabase
    public DappRoomDao getDappDao() {
        DappRoomDao dappRoomDao;
        if (this._dappRoomDao != null) {
            return this._dappRoomDao;
        }
        synchronized (this) {
            if (this._dappRoomDao == null) {
                this._dappRoomDao = new DappRoomDao_Impl(this);
            }
            dappRoomDao = this._dappRoomDao;
        }
        return dappRoomDao;
    }
}