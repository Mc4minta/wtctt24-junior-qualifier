package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t3 extends f5 {

    /* renamed from: c  reason: collision with root package name */
    private final w3 f7864c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7865d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t3(b5 b5Var) {
        super(b5Var);
        this.f7864c = new w3(this, h(), "google_app_measurement_local.db");
    }

    private static long C(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", DiskLruCache.VERSION_1);
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                cursor.close();
                return j2;
            }
            cursor.close();
            return -1L;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0126  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean E(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t3.E(int, byte[]):boolean");
    }

    private final SQLiteDatabase L() throws SQLiteException {
        if (this.f7865d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f7864c.getWritableDatabase();
        if (writableDatabase == null) {
            this.f7865d = true;
            return null;
        }
        return writableDatabase;
    }

    private final boolean M() {
        return h().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.f5
    protected final boolean B() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01f0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.a> D(int r22) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.t3.D(int):java.util.List");
    }

    public final boolean F(p pVar) {
        Parcel obtain = Parcel.obtain();
        pVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            f().I().a("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return E(0, marshall);
    }

    public final boolean G(q9 q9Var) {
        Parcel obtain = Parcel.obtain();
        q9Var.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            f().I().a("User property too long for local database. Sending directly to service");
            return false;
        }
        return E(1, marshall);
    }

    public final boolean H(ia iaVar) {
        m();
        byte[] m0 = v9.m0(iaVar);
        if (m0.length > 131072) {
            f().I().a("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return E(2, m0);
    }

    public final void I() {
        b();
        d();
        try {
            int delete = L().delete("messages", null, null) + 0;
            if (delete > 0) {
                f().P().b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            f().H().b("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean J() {
        return E(3, new byte[0]);
    }

    public final boolean K() {
        d();
        b();
        if (!this.f7865d && M()) {
            int i2 = 5;
            for (int i3 = 0; i3 < 5; i3++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        SQLiteDatabase L = L();
                        if (L == null) {
                            this.f7865d = true;
                            if (L != null) {
                                L.close();
                            }
                            return false;
                        }
                        L.beginTransaction();
                        L.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                        L.setTransactionSuccessful();
                        L.endTransaction();
                        L.close();
                        return true;
                    } catch (SQLiteDatabaseLockedException unused) {
                        SystemClock.sleep(i2);
                        i2 += 20;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    } catch (SQLiteException e2) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        f().H().b("Error deleting app launch break from local database", e2);
                        this.f7865d = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteFullException e3) {
                    f().H().b("Error deleting app launch break from local database", e3);
                    this.f7865d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            f().K().a("Error deleting app launch break from local database in reasonable time");
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.d2, com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ a p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ i6 q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u3 r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ s7 s() {
        return super.s();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ n7 t() {
        return super.t();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ t3 u() {
        return super.u();
    }

    @Override // com.google.android.gms.measurement.internal.d2
    public final /* bridge */ /* synthetic */ u8 v() {
        return super.v();
    }
}