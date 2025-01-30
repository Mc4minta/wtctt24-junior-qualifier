package androidx.room;

import android.database.Cursor;
import c.r.a.c;
import java.util.List;

/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class l extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private androidx.room.a f2278b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2279c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2280d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2281e;

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public final int version;

        public a(int i2) {
            this.version = i2;
        }

        protected abstract void createAllTables(c.r.a.b bVar);

        protected abstract void dropAllTables(c.r.a.b bVar);

        protected abstract void onCreate(c.r.a.b bVar);

        protected abstract void onOpen(c.r.a.b bVar);

        protected abstract void onPostMigrate(c.r.a.b bVar);

        protected abstract void onPreMigrate(c.r.a.b bVar);

        protected abstract b onValidateSchema(c.r.a.b bVar);

        @Deprecated
        protected void validateMigration(c.r.a.b bVar) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2282b;

        public b(boolean z, String str) {
            this.a = z;
            this.f2282b = str;
        }
    }

    public l(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.version);
        this.f2278b = aVar;
        this.f2279c = aVar2;
        this.f2280d = str;
        this.f2281e = str2;
    }

    private void h(c.r.a.b bVar) {
        if (k(bVar)) {
            Cursor A0 = bVar.A0(new c.r.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                String string = A0.moveToFirst() ? A0.getString(0) : null;
                A0.close();
                if (!this.f2280d.equals(string) && !this.f2281e.equals(string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th) {
                A0.close();
                throw th;
            }
        }
        b onValidateSchema = this.f2279c.onValidateSchema(bVar);
        if (onValidateSchema.a) {
            this.f2279c.onPostMigrate(bVar);
            l(bVar);
            return;
        }
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f2282b);
    }

    private void i(c.r.a.b bVar) {
        bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(c.r.a.b bVar) {
        Cursor i0 = bVar.i0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (i0.moveToFirst()) {
                if (i0.getInt(0) == 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            i0.close();
        }
    }

    private static boolean k(c.r.a.b bVar) {
        Cursor i0 = bVar.i0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (i0.moveToFirst()) {
                if (i0.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            i0.close();
        }
    }

    private void l(c.r.a.b bVar) {
        i(bVar);
        bVar.t(k.a(this.f2280d));
    }

    @Override // c.r.a.c.a
    public void b(c.r.a.b bVar) {
        super.b(bVar);
    }

    @Override // c.r.a.c.a
    public void d(c.r.a.b bVar) {
        boolean j2 = j(bVar);
        this.f2279c.createAllTables(bVar);
        if (!j2) {
            b onValidateSchema = this.f2279c.onValidateSchema(bVar);
            if (!onValidateSchema.a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.f2282b);
            }
        }
        l(bVar);
        this.f2279c.onCreate(bVar);
    }

    @Override // c.r.a.c.a
    public void e(c.r.a.b bVar, int i2, int i3) {
        g(bVar, i2, i3);
    }

    @Override // c.r.a.c.a
    public void f(c.r.a.b bVar) {
        super.f(bVar);
        h(bVar);
        this.f2279c.onOpen(bVar);
        this.f2278b = null;
    }

    @Override // c.r.a.c.a
    public void g(c.r.a.b bVar, int i2, int i3) {
        boolean z;
        List<androidx.room.s.a> c2;
        androidx.room.a aVar = this.f2278b;
        if (aVar == null || (c2 = aVar.f2223d.c(i2, i3)) == null) {
            z = false;
        } else {
            this.f2279c.onPreMigrate(bVar);
            for (androidx.room.s.a aVar2 : c2) {
                aVar2.migrate(bVar);
            }
            b onValidateSchema = this.f2279c.onValidateSchema(bVar);
            if (onValidateSchema.a) {
                this.f2279c.onPostMigrate(bVar);
                l(bVar);
                z = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.f2282b);
            }
        }
        if (z) {
            return;
        }
        androidx.room.a aVar3 = this.f2278b;
        if (aVar3 != null && !aVar3.a(i2, i3)) {
            this.f2279c.dropAllTables(bVar);
            this.f2279c.createAllTables(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}