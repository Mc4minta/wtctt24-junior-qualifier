package com.toshi.db;

import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.c;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.user.daos.UserDao;
import com.coinbase.wallet.user.daos.UserDao_Impl;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class DerivedDatabase_Impl extends DerivedDatabase {

    /* renamed from: h  reason: collision with root package name */
    private volatile com.toshi.db.i.a f11080h;

    /* renamed from: i  reason: collision with root package name */
    private volatile com.toshi.db.h.a f11081i;

    /* renamed from: j  reason: collision with root package name */
    private volatile UserDao f11082j;

    /* loaded from: classes2.dex */
    class a extends l.a {
        a(int i2) {
            super(i2);
        }

        @Override // androidx.room.l.a
        public void createAllTables(c.r.a.b bVar) {
            bVar.t("CREATE TABLE IF NOT EXISTS `collectible_types` (`name` TEXT NOT NULL, `contract_address` TEXT NOT NULL COLLATE NOCASE, `address` TEXT NOT NULL, `count` INTEGER NOT NULL, `image` TEXT, `chain_id` INTEGER NOT NULL, PRIMARY KEY(`contract_address`))");
            bVar.t("CREATE TABLE IF NOT EXISTS `erc721_token` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `contract_address` TEXT NOT NULL, `chain_id` INTEGER NOT NULL, `image` TEXT, PRIMARY KEY(`id`))");
            bVar.t("CREATE TABLE IF NOT EXISTS `user` (`toshi_id` TEXT NOT NULL, `payment_address` TEXT NOT NULL, `avatar` TEXT, `username` TEXT NOT NULL, `display_name` TEXT, PRIMARY KEY(`toshi_id`))");
            bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c7fa67edad961d07973a5a5438ddaf14')");
        }

        @Override // androidx.room.l.a
        public void dropAllTables(c.r.a.b bVar) {
            bVar.t("DROP TABLE IF EXISTS `collectible_types`");
            bVar.t("DROP TABLE IF EXISTS `erc721_token`");
            bVar.t("DROP TABLE IF EXISTS `user`");
            if (((j) DerivedDatabase_Impl.this).mCallbacks != null) {
                int size = ((j) DerivedDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((j.b) ((j) DerivedDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        protected void onCreate(c.r.a.b bVar) {
            if (((j) DerivedDatabase_Impl.this).mCallbacks != null) {
                int size = ((j) DerivedDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((j.b) ((j) DerivedDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        public void onOpen(c.r.a.b bVar) {
            ((j) DerivedDatabase_Impl.this).mDatabase = bVar;
            DerivedDatabase_Impl.this.internalInitInvalidationTracker(bVar);
            if (((j) DerivedDatabase_Impl.this).mCallbacks != null) {
                int size = ((j) DerivedDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((j.b) ((j) DerivedDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
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
            HashMap hashMap = new HashMap(6);
            hashMap.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
            hashMap.put("contract_address", new f.a("contract_address", "TEXT", true, 1, null, 1));
            hashMap.put("address", new f.a("address", "TEXT", true, 0, null, 1));
            hashMap.put("count", new f.a("count", "INTEGER", true, 0, null, 1));
            hashMap.put("image", new f.a("image", "TEXT", false, 0, null, 1));
            hashMap.put("chain_id", new f.a("chain_id", "INTEGER", true, 0, null, 1));
            androidx.room.t.f fVar = new androidx.room.t.f("collectible_types", hashMap, new HashSet(0), new HashSet(0));
            androidx.room.t.f a = androidx.room.t.f.a(bVar, "collectible_types");
            if (!fVar.equals(a)) {
                return new l.b(false, "collectible_types(com.toshi.model.local.room.CollectibleType).\n Expected:\n" + fVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(6);
            hashMap2.put("id", new f.a("id", "TEXT", true, 1, null, 1));
            hashMap2.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
            hashMap2.put("address", new f.a("address", "TEXT", true, 0, null, 1));
            hashMap2.put("contract_address", new f.a("contract_address", "TEXT", true, 0, null, 1));
            hashMap2.put("chain_id", new f.a("chain_id", "INTEGER", true, 0, null, 1));
            hashMap2.put("image", new f.a("image", "TEXT", false, 0, null, 1));
            androidx.room.t.f fVar2 = new androidx.room.t.f("erc721_token", hashMap2, new HashSet(0), new HashSet(0));
            androidx.room.t.f a2 = androidx.room.t.f.a(bVar, "erc721_token");
            if (!fVar2.equals(a2)) {
                return new l.b(false, "erc721_token(com.toshi.model.local.room.Erc721Token).\n Expected:\n" + fVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(5);
            hashMap3.put("toshi_id", new f.a("toshi_id", "TEXT", true, 1, null, 1));
            hashMap3.put("payment_address", new f.a("payment_address", "TEXT", true, 0, null, 1));
            hashMap3.put("avatar", new f.a("avatar", "TEXT", false, 0, null, 1));
            hashMap3.put("username", new f.a("username", "TEXT", true, 0, null, 1));
            hashMap3.put("display_name", new f.a("display_name", "TEXT", false, 0, null, 1));
            androidx.room.t.f fVar3 = new androidx.room.t.f(ApiConstants.USER, hashMap3, new HashSet(0), new HashSet(0));
            androidx.room.t.f a3 = androidx.room.t.f.a(bVar, ApiConstants.USER);
            if (!fVar3.equals(a3)) {
                return new l.b(false, "user(com.coinbase.wallet.user.models.LegacyUser).\n Expected:\n" + fVar3 + "\n Found:\n" + a3);
            }
            return new l.b(true, null);
        }
    }

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        c.r.a.b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `collectible_types`");
            b2.t("DELETE FROM `erc721_token`");
            b2.t("DELETE FROM `user`");
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
        return new g(this, new HashMap(0), new HashMap(0), "collectible_types", "erc721_token", ApiConstants.USER);
    }

    @Override // androidx.room.j
    protected c.r.a.c createOpenHelper(androidx.room.a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new a(6), "c7fa67edad961d07973a5a5438ddaf14", "4b46bbe531e946e112b485bc4a195772")).a());
    }

    @Override // com.toshi.db.DerivedDatabase
    public com.toshi.db.h.a h() {
        com.toshi.db.h.a aVar;
        if (this.f11081i != null) {
            return this.f11081i;
        }
        synchronized (this) {
            if (this.f11081i == null) {
                this.f11081i = new com.toshi.db.h.c(this);
            }
            aVar = this.f11081i;
        }
        return aVar;
    }

    @Override // com.toshi.db.DerivedDatabase
    public com.toshi.db.i.a i() {
        com.toshi.db.i.a aVar;
        if (this.f11080h != null) {
            return this.f11080h;
        }
        synchronized (this) {
            if (this.f11080h == null) {
                this.f11080h = new com.toshi.db.i.c(this);
            }
            aVar = this.f11080h;
        }
        return aVar;
    }

    @Override // com.toshi.db.DerivedDatabase
    public UserDao j() {
        UserDao userDao;
        if (this.f11082j != null) {
            return this.f11082j;
        }
        synchronized (this) {
            if (this.f11082j == null) {
                this.f11082j = new UserDao_Impl(this);
            }
            userDao = this.f11082j;
        }
        return userDao;
    }
}