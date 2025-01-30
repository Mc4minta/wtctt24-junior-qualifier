package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.appsflyer.internal.referrer.Payload;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DatabaseHelper.java */
/* loaded from: classes.dex */
public class f extends SQLiteOpenHelper {
    static final Map<String, f> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final d f3545b = d.d();

    /* renamed from: c  reason: collision with root package name */
    File f3546c;

    /* renamed from: d  reason: collision with root package name */
    private String f3547d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3548e;

    /* renamed from: f  reason: collision with root package name */
    private g f3549f;

    protected f(Context context, String str) {
        super(context, m(str), (SQLiteDatabase.CursorFactory) null, 3);
        this.f3548e = true;
        this.f3546c = context.getDatabasePath(m(str));
        this.f3547d = l.c(str);
    }

    private synchronized void J0(String str, long j2) {
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.delete(str, "id <= " + j2, null);
            } catch (StackOverflowError e2) {
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("removeEvents from %s failed", str), e2);
                i.d().f(String.format("DB: Failed to removeEvents from table %s", str), e2);
                e();
            }
        } catch (SQLiteException e3) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("removeEvents from %s failed", str), e3);
            i.d().f(String.format("DB: Failed to removeEvents from table %s", str), e3);
            e();
        }
        close();
    }

    private void O0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    private synchronized long V(String str, long j2) {
        long j3;
        j3 = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                SQLiteStatement compileStatement = readableDatabase.compileStatement("SELECT id FROM " + str + " LIMIT 1 OFFSET " + (j2 - 1));
                try {
                    j3 = compileStatement.simpleQueryForLong();
                } catch (SQLiteDoneException e2) {
                    f3545b.g("com.amplitude.api.DatabaseHelper", e2);
                }
                if (compileStatement != null) {
                    compileStatement.close();
                }
            } catch (SQLiteException e3) {
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getNthEventId from %s failed", str), e3);
                i.d().f(String.format("DB: Failed to getNthEventId from table %s", str), e3);
                e();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            }
        } catch (StackOverflowError e4) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getNthEventId from %s failed", str), e4);
            i.d().f(String.format("DB: Failed to getNthEventId from table %s", str), e4);
            e();
            if (0 != 0) {
                sQLiteStatement.close();
            }
        }
        close();
        return j3;
    }

    private synchronized long b(String str, String str2) {
        StackOverflowError e2;
        long j2;
        SQLiteException e3;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("event", str2);
            j2 = k0(writableDatabase, str, contentValues);
            if (j2 == -1) {
                try {
                    f3545b.f("com.amplitude.api.DatabaseHelper", String.format("Insert into %s failed", str));
                } catch (SQLiteException e4) {
                    e3 = e4;
                    f3545b.c("com.amplitude.api.DatabaseHelper", String.format("addEvent to %s failed", str), e3);
                    i.d().f(String.format("DB: Failed to addEvent: %s", str2), e3);
                    e();
                    close();
                    return j2;
                } catch (StackOverflowError e5) {
                    e2 = e5;
                    f3545b.c("com.amplitude.api.DatabaseHelper", String.format("addEvent to %s failed", str), e2);
                    i.d().f(String.format("DB: Failed to addEvent: %s", str2), e2);
                    e();
                    close();
                    return j2;
                }
            }
        } catch (SQLiteException e6) {
            e3 = e6;
            j2 = -1;
        } catch (StackOverflowError e7) {
            e2 = e7;
            j2 = -1;
        }
        close();
        return j2;
    }

    private static void d(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (!l.b(message) && message.startsWith("Cursor window allocation of")) {
            throw new CursorWindowAllocationException(message);
        }
        throw runtimeException;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e9, code lost:
        if (r3.isOpen() != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00eb, code lost:
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0112, code lost:
        if (r3.isOpen() != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.f.e():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static f g(Context context) {
        return j(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized f j(Context context, String str) {
        f fVar;
        synchronized (f.class) {
            String c2 = l.c(str);
            Map<String, f> map = a;
            fVar = map.get(c2);
            if (fVar == null) {
                fVar = new f(context.getApplicationContext(), c2);
                map.put(c2, fVar);
            }
        }
        return fVar;
    }

    private static String m(String str) {
        if (l.b(str) || str.equals("$default_instance")) {
            return "com.amplitude.api";
        }
        return "com.amplitude.api_" + str;
    }

    private synchronized long v(String str) {
        long j2;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                sQLiteStatement = readableDatabase.compileStatement("SELECT COUNT(*) FROM " + str);
                j2 = sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
                close();
            } catch (StackOverflowError e2) {
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getNumberRows for %s failed", str), e2);
                i.d().f(String.format("DB: Failed to getNumberRows for table %s", str), e2);
                e();
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                close();
                j2 = 0;
                return j2;
            }
        } catch (SQLiteException e3) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getNumberRows for %s failed", str), e3);
            i.d().f(String.format("DB: Failed to getNumberRows for table %s", str), e3);
            e();
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
            close();
            j2 = 0;
            return j2;
        }
        return j2;
    }

    private synchronized void z0(String str, long j2) {
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.delete(str, "id = " + j2, null);
            } catch (StackOverflowError e2) {
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("removeEvent from %s failed", str), e2);
                i.d().f(String.format("DB: Failed to removeEvent from table %s", str), e2);
                e();
            }
        } catch (SQLiteException e3) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("removeEvent from %s failed", str), e3);
            i.d().f(String.format("DB: Failed to removeEvent from table %s", str), e3);
            e();
        }
        close();
    }

    protected synchronized List<JSONObject> A(String str, long j2, long j3) throws JSONException {
        LinkedList linkedList;
        String str2;
        String str3;
        linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            String[] strArr = {"id", "event"};
            if (j2 >= 0) {
                str2 = "id <= " + j2;
            } else {
                str2 = null;
            }
            if (j3 >= 0) {
                str3 = "" + j3;
            } else {
                str3 = null;
            }
            cursor = x0(readableDatabase, str, strArr, str2, null, null, null, "id ASC", str3);
            while (cursor.moveToNext()) {
                long j4 = cursor.getLong(0);
                String string = cursor.getString(1);
                if (!l.b(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    jSONObject.put("event_id", j4);
                    linkedList.add(jSONObject);
                }
            }
            cursor.close();
        } catch (SQLiteException e2) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getEvents from %s failed", str), e2);
            i.d().f(String.format("DB: Failed to getEventsFromTable %s", str), e2);
            e();
            if (cursor != null) {
                cursor.close();
            }
        } catch (RuntimeException e3) {
            i.d().f(String.format("DB: Failed to getEventsFromTable %s", str), e3);
            d(e3);
            if (cursor != null) {
                cursor.close();
            }
        } catch (StackOverflowError e4) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getEvents from %s failed", str), e4);
            i.d().f(String.format("DB: Failed to getEventsFromTable %s", str), e4);
            e();
            if (cursor != null) {
                cursor.close();
            }
        }
        close();
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long G() {
        return v("identifys");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void I0(long j2) {
        J0("events", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> K(long j2, long j3) throws JSONException {
        return A("identifys", j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void L0(long j2) {
        z0("identifys", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void M0(long j2) {
        J0("identifys", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Long N(String str) {
        return (Long) g0("long_store", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long O(long j2) {
        return V("events", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q0(g gVar) {
        this.f3549f = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long a(String str) {
        return b("events", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long a0(long j2) {
        return V("identifys", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long c(String str) {
        return b("identifys", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long d0() {
        return n() + G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String e0(String str) {
        return (String) g0(Payload.TYPE_STORE, str);
    }

    synchronized long f(String str, String str2) {
        long j2;
        try {
            j2 = getWritableDatabase().delete(str, "key=?", new String[]{str2});
            close();
        } catch (SQLiteException e2) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("deleteKey from %s failed", str), e2);
            i.d().f(String.format("DB: Failed to deleteKey: %s", str2), e2);
            e();
            close();
            j2 = -1;
            return j2;
        } catch (StackOverflowError e3) {
            f3545b.c("com.amplitude.api.DatabaseHelper", String.format("deleteKey from %s failed", str), e3);
            i.d().f(String.format("DB: Failed to deleteKey: %s", str2), e3);
            e();
            close();
            j2 = -1;
            return j2;
        }
        return j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00c7: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:44:0x00c7 */
    protected synchronized Object g0(String str, String str2) {
        Cursor cursor;
        Object obj;
        Cursor cursor2;
        cursor = null;
        try {
            try {
                cursor2 = x0(getReadableDatabase(), str, new String[]{"key", "value"}, "key = ?", new String[]{str2}, null, null, null, null);
            } catch (SQLiteException e2) {
                e = e2;
                cursor2 = null;
            } catch (RuntimeException e3) {
                e = e3;
                cursor2 = null;
            } catch (StackOverflowError e4) {
                e = e4;
                cursor2 = null;
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                close();
                throw th;
            }
            try {
                if (cursor2.moveToFirst()) {
                    cursor = str.equals(Payload.TYPE_STORE) ? cursor2.getString(1) : Long.valueOf(cursor2.getLong(1));
                }
                cursor2.close();
            } catch (SQLiteException e5) {
                e = e5;
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getValue from %s failed", str), e);
                i.d().f(String.format("DB: Failed to getValue: %s", str2), e);
                e();
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                return cursor;
            } catch (RuntimeException e6) {
                e = e6;
                i.d().f(String.format("DB: Failed to getValue: %s", str2), e);
                d(e);
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                return cursor;
            } catch (StackOverflowError e7) {
                e = e7;
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("getValue from %s failed", str), e);
                i.d().f(String.format("DB: Failed to getValue: %s", str2), e);
                e();
                if (cursor2 != null) {
                    cursor2.close();
                }
                close();
                return cursor;
            }
            close();
        } catch (Throwable th2) {
            th = th2;
            cursor = obj;
        }
        return cursor;
    }

    synchronized long k0(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long n() {
        return v("events");
    }

    synchronized long n0(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long o0(String str, Long l2) {
        long w0;
        if (l2 == null) {
            w0 = f("long_store", str);
        } else {
            w0 = w0("long_store", str, l2);
        }
        return w0;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
        g gVar = this.f3549f;
        if (gVar == null || !this.f3548e) {
            return;
        }
        try {
            try {
                this.f3548e = false;
                gVar.a(sQLiteDatabase);
            } catch (SQLiteException e2) {
                f3545b.c("com.amplitude.api.DatabaseHelper", String.format("databaseReset callback failed during onCreate", new Object[0]), e2);
                i.d().f(String.format("DB: Failed to run databaseReset callback during onCreate", new Object[0]), e2);
            }
        } finally {
            this.f3548e = true;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i2 > i3) {
            f3545b.b("com.amplitude.api.DatabaseHelper", "onUpgrade() with invalid oldVersion and newVersion");
            O0(sQLiteDatabase);
        } else if (i3 <= 1) {
        } else {
            if (i2 == 1) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);");
                if (i3 <= 2) {
                    return;
                }
            } else if (i2 != 2) {
                if (i2 != 3) {
                    d dVar = f3545b;
                    dVar.b("com.amplitude.api.DatabaseHelper", "onUpgrade() with unknown oldVersion " + i2);
                    O0(sQLiteDatabase);
                    return;
                }
                return;
            }
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long r0(String str, String str2) {
        long w0;
        if (str2 == null) {
            w0 = f(Payload.TYPE_STORE, str);
        } else {
            w0 = w0(Payload.TYPE_STORE, str, str2);
        }
        return w0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long s0(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws SQLiteException, StackOverflowError {
        long n0;
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        n0 = n0(sQLiteDatabase, str, contentValues);
        if (n0 == -1) {
            f3545b.f("com.amplitude.api.DatabaseHelper", "Insert failed");
        }
        return n0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
        if (r2.isOpen() != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        if (r2.isOpen() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    synchronized long w0(java.lang.String r8, java.lang.String r9, java.lang.Object r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            r1 = 1
            r2 = 0
            android.database.sqlite.SQLiteDatabase r2 = r7.getWritableDatabase()     // Catch: java.lang.Throwable -> L18 java.lang.StackOverflowError -> L1a android.database.sqlite.SQLiteException -> L4c
            long r8 = r7.s0(r2, r8, r9, r10)     // Catch: java.lang.Throwable -> L18 java.lang.StackOverflowError -> L1a android.database.sqlite.SQLiteException -> L4c
            if (r2 == 0) goto L7d
            boolean r10 = r2.isOpen()     // Catch: java.lang.Throwable -> L8b
            if (r10 == 0) goto L7d
            r7.close()     // Catch: java.lang.Throwable -> L8b
            goto L7d
        L18:
            r8 = move-exception
            goto L7f
        L1a:
            r10 = move-exception
            com.amplitude.api.d r3 = com.amplitude.api.f.f3545b     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r5 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L18
            r6[r0] = r8     // Catch: java.lang.Throwable -> L18
            java.lang.String r8 = java.lang.String.format(r5, r6)     // Catch: java.lang.Throwable -> L18
            r3.c(r4, r8, r10)     // Catch: java.lang.Throwable -> L18
            com.amplitude.api.i r8 = com.amplitude.api.i.d()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = "DB: Failed to insertOrReplaceKeyValue %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L18
            r1[r0] = r9     // Catch: java.lang.Throwable -> L18
            java.lang.String r9 = java.lang.String.format(r3, r1)     // Catch: java.lang.Throwable -> L18
            r8.f(r9, r10)     // Catch: java.lang.Throwable -> L18
            r7.e()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L7b
            boolean r8 = r2.isOpen()     // Catch: java.lang.Throwable -> L8b
            if (r8 == 0) goto L7b
        L48:
            r7.close()     // Catch: java.lang.Throwable -> L8b
            goto L7b
        L4c:
            r10 = move-exception
            com.amplitude.api.d r3 = com.amplitude.api.f.f3545b     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r5 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L18
            r6[r0] = r8     // Catch: java.lang.Throwable -> L18
            java.lang.String r8 = java.lang.String.format(r5, r6)     // Catch: java.lang.Throwable -> L18
            r3.c(r4, r8, r10)     // Catch: java.lang.Throwable -> L18
            com.amplitude.api.i r8 = com.amplitude.api.i.d()     // Catch: java.lang.Throwable -> L18
            java.lang.String r3 = "DB: Failed to insertOrReplaceKeyValue %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L18
            r1[r0] = r9     // Catch: java.lang.Throwable -> L18
            java.lang.String r9 = java.lang.String.format(r3, r1)     // Catch: java.lang.Throwable -> L18
            r8.f(r9, r10)     // Catch: java.lang.Throwable -> L18
            r7.e()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L7b
            boolean r8 = r2.isOpen()     // Catch: java.lang.Throwable -> L8b
            if (r8 == 0) goto L7b
            goto L48
        L7b:
            r8 = -1
        L7d:
            monitor-exit(r7)
            return r8
        L7f:
            if (r2 == 0) goto L8a
            boolean r9 = r2.isOpen()     // Catch: java.lang.Throwable -> L8b
            if (r9 == 0) goto L8a
            r7.close()     // Catch: java.lang.Throwable -> L8b
        L8a:
            throw r8     // Catch: java.lang.Throwable -> L8b
        L8b:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.f.w0(java.lang.String, java.lang.String, java.lang.Object):long");
    }

    Cursor x0(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void y0(long j2) {
        z0("events", j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<JSONObject> z(long j2, long j3) throws JSONException {
        return A("events", j2, j3);
    }
}