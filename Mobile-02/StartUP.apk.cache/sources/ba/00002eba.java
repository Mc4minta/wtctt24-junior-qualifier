package com.facebook.react.modules.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: ReactDatabaseSupplier.java */
/* loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {
    private static c a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5015b;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f5016c;

    /* renamed from: d  reason: collision with root package name */
    private long f5017d;

    private c(Context context) {
        super(context, "RKStorage", (SQLiteDatabase.CursorFactory) null, 1);
        this.f5017d = 6291456L;
        this.f5015b = context;
    }

    private synchronized void c() {
        SQLiteDatabase sQLiteDatabase = this.f5016c;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.f5016c.close();
            this.f5016c = null;
        }
    }

    private synchronized boolean d() {
        c();
        return this.f5015b.deleteDatabase("RKStorage");
    }

    public static c g(Context context) {
        if (a == null) {
            a = new c(context.getApplicationContext());
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        f().delete("catalystLocalStorage", null, null);
    }

    public synchronized void b() throws RuntimeException {
        try {
            a();
            c();
            e.f.d.d.a.b("ReactNative", "Cleaned RKStorage");
        } catch (Exception unused) {
            if (d()) {
                e.f.d.d.a.b("ReactNative", "Deleted Local Database RKStorage");
                return;
            }
            throw new RuntimeException("Clearing and deleting database RKStorage failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean e() {
        SQLiteDatabase sQLiteDatabase = this.f5016c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            SQLiteException e2 = null;
            for (int i2 = 0; i2 < 2; i2++) {
                if (i2 > 0) {
                    try {
                        d();
                    } catch (SQLiteException e3) {
                        e2 = e3;
                        try {
                            Thread.sleep(30L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                this.f5016c = getWritableDatabase();
            }
            SQLiteDatabase sQLiteDatabase2 = this.f5016c;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.setMaximumSize(this.f5017d);
                return true;
            }
            throw e2;
        }
        return true;
    }

    public synchronized SQLiteDatabase f() {
        e();
        return this.f5016c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 != i3) {
            d();
            onCreate(sQLiteDatabase);
        }
    }
}