package com.toshi.db;

import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.c;
import java.util.HashMap;
import java.util.HashSet;
import org.spongycastle.i18n.MessageBundle;

/* loaded from: classes2.dex */
public final class WalletDatabase_Impl extends WalletDatabase {

    /* renamed from: h  reason: collision with root package name */
    private volatile com.toshi.db.g.a f11089h;

    /* loaded from: classes2.dex */
    class a extends l.a {
        a(int i2) {
            super(i2);
        }

        @Override // androidx.room.l.a
        public void createAllTables(c.r.a.b bVar) {
            bVar.t("CREATE TABLE IF NOT EXISTS `bookmark` (`url` TEXT NOT NULL, `title` TEXT NOT NULL, `created_at` INTEGER NOT NULL, PRIMARY KEY(`url`))");
            bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3b29cffd2d7f75ae5ed7da4180d93f2d')");
        }

        @Override // androidx.room.l.a
        public void dropAllTables(c.r.a.b bVar) {
            bVar.t("DROP TABLE IF EXISTS `bookmark`");
            if (((j) WalletDatabase_Impl.this).mCallbacks != null) {
                int size = ((j) WalletDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((j.b) ((j) WalletDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        protected void onCreate(c.r.a.b bVar) {
            if (((j) WalletDatabase_Impl.this).mCallbacks != null) {
                int size = ((j) WalletDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((j.b) ((j) WalletDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                }
            }
        }

        @Override // androidx.room.l.a
        public void onOpen(c.r.a.b bVar) {
            ((j) WalletDatabase_Impl.this).mDatabase = bVar;
            WalletDatabase_Impl.this.internalInitInvalidationTracker(bVar);
            if (((j) WalletDatabase_Impl.this).mCallbacks != null) {
                int size = ((j) WalletDatabase_Impl.this).mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((j.b) ((j) WalletDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
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
            HashMap hashMap = new HashMap(3);
            hashMap.put("url", new f.a("url", "TEXT", true, 1, null, 1));
            hashMap.put(MessageBundle.TITLE_ENTRY, new f.a(MessageBundle.TITLE_ENTRY, "TEXT", true, 0, null, 1));
            hashMap.put("created_at", new f.a("created_at", "INTEGER", true, 0, null, 1));
            androidx.room.t.f fVar = new androidx.room.t.f("bookmark", hashMap, new HashSet(0), new HashSet(0));
            androidx.room.t.f a = androidx.room.t.f.a(bVar, "bookmark");
            if (!fVar.equals(a)) {
                return new l.b(false, "bookmark(com.toshi.model.local.room.Bookmark).\n Expected:\n" + fVar + "\n Found:\n" + a);
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
            b2.t("DELETE FROM `bookmark`");
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
        return new g(this, new HashMap(0), new HashMap(0), "bookmark");
    }

    @Override // androidx.room.j
    protected c.r.a.c createOpenHelper(androidx.room.a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new a(17), "3b29cffd2d7f75ae5ed7da4180d93f2d", "e76db01e4c9e681dc12a2bce0275485b")).a());
    }

    @Override // com.toshi.db.WalletDatabase
    public com.toshi.db.g.a h() {
        com.toshi.db.g.a aVar;
        if (this.f11089h != null) {
            return this.f11089h;
        }
        synchronized (this) {
            if (this.f11089h == null) {
                this.f11089h = new com.toshi.db.g.c(this);
            }
            aVar = this.f11089h;
        }
        return aVar;
    }
}