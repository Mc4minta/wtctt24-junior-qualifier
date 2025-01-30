package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.internal.measurement.c0;
import com.google.android.gms.internal.measurement.d0;
import com.google.android.gms.internal.measurement.n4;
import com.google.android.gms.internal.measurement.t0;
import com.google.android.gms.internal.measurement.v0;
import com.google.android.gms.internal.measurement.x0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class e extends k9 {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f7545d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f7546e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f7547f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f7548g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f7549h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f7550i = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f7551j = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f7552k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: l  reason: collision with root package name */
    private final f f7553l;
    private final f9 m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(j9 j9Var) {
        super(j9Var);
        this.m = new f9(i());
        this.f7553l = new f(this, h(), "google_app_measurement.db");
    }

    private final long B(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            try {
                cursor = y().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j3 = cursor.getLong(0);
                    cursor.close();
                    return j3;
                }
                cursor.close();
                return j2;
            } catch (SQLiteException e2) {
                f().H().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final Object H(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            f().H().a("Loaded invalid null value from database");
            return null;
        } else if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        f().H().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                        return null;
                    }
                    f().H().a("Loaded invalid blob type value, ignoring it");
                    return null;
                }
                return cursor.getString(i2);
            }
            return Double.valueOf(cursor.getDouble(i2));
        } else {
            return Long.valueOf(cursor.getLong(i2));
        }
    }

    private static void N(ContentValues contentValues, String str, Object obj) {
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final boolean W(String str, int i2, com.google.android.gms.internal.measurement.d0 d0Var) {
        u();
        d();
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(d0Var);
        if (TextUtils.isEmpty(d0Var.I())) {
            f().K().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", x3.y(str), Integer.valueOf(i2), String.valueOf(d0Var.G() ? Integer.valueOf(d0Var.H()) : null));
            return false;
        }
        byte[] l2 = d0Var.l();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", d0Var.G() ? Integer.valueOf(d0Var.H()) : null);
        contentValues.put("event_name", d0Var.I());
        contentValues.put("session_scoped", d0Var.P() ? Boolean.valueOf(d0Var.Q()) : null);
        contentValues.put("data", l2);
        try {
            if (y().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                f().H().b("Failed to insert event filter (got -1). appId", x3.y(str));
                return true;
            }
            return true;
        } catch (SQLiteException e2) {
            f().H().c("Error storing event filter. appId", x3.y(str), e2);
            return false;
        }
    }

    private final boolean X(String str, int i2, com.google.android.gms.internal.measurement.g0 g0Var) {
        u();
        d();
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(g0Var);
        if (TextUtils.isEmpty(g0Var.F())) {
            f().K().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", x3.y(str), Integer.valueOf(i2), String.valueOf(g0Var.D() ? Integer.valueOf(g0Var.E()) : null));
            return false;
        }
        byte[] l2 = g0Var.l();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", g0Var.D() ? Integer.valueOf(g0Var.E()) : null);
        contentValues.put("property_name", g0Var.F());
        contentValues.put("session_scoped", g0Var.J() ? Boolean.valueOf(g0Var.K()) : null);
        contentValues.put("data", l2);
        try {
            if (y().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                f().H().b("Failed to insert property filter (got -1). appId", x3.y(str));
                return false;
            }
            return true;
        } catch (SQLiteException e2) {
            f().H().c("Error storing property filter. appId", x3.y(str), e2);
            return false;
        }
    }

    private final boolean i0() {
        return h().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long j0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = y().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j2 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j2;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                f().H().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean n0(String str, List<Integer> list) {
        com.google.android.gms.common.internal.t.g(str);
        u();
        d();
        SQLiteDatabase y = y();
        try {
            long j0 = j0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, o().w(str, r.G)));
            if (j0 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return y.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            f().H().c("Database error querying filters. appId", x3.y(str), e2);
            return false;
        }
    }

    public final long A(com.google.android.gms.internal.measurement.x0 x0Var) throws IOException {
        d();
        u();
        com.google.android.gms.common.internal.t.k(x0Var);
        com.google.android.gms.common.internal.t.g(x0Var.M2());
        byte[] l2 = x0Var.l();
        long y = q().y(l2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", x0Var.M2());
        contentValues.put("metadata_fingerprint", Long.valueOf(y));
        contentValues.put(SendConfirmationArgs.metadataKey, l2);
        try {
            y().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return y;
        } catch (SQLiteException e2) {
            f().H().c("Error storing raw event metadata. appId", x3.y(x0Var.M2()), e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long A0(String str, String str2) {
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.g(str2);
        d();
        u();
        SQLiteDatabase y = y();
        y.beginTransaction();
        long j2 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
                sb.append("select ");
                sb.append(str2);
                sb.append(" from app2 where app_id=?");
                long B = B(sb.toString(), new String[]{str}, -1L);
                if (B == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (y.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        f().H().c("Failed to insert column (got -1). appId", x3.y(str), str2);
                        return -1L;
                    }
                    B = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + B));
                    if (y.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        f().H().c("Failed to update column (got 0). appId", x3.y(str), str2);
                        return -1L;
                    }
                    y.setTransactionSuccessful();
                    return B;
                } catch (SQLiteException e2) {
                    e = e2;
                    j2 = B;
                    f().H().d("Error inserting column. appId", x3.y(str), str2, e);
                    y.endTransaction();
                    return j2;
                }
            } catch (SQLiteException e3) {
                e = e3;
            }
        } finally {
            y.endTransaction();
        }
    }

    public final void B0() {
        u();
        y().endTransaction();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.t0, java.lang.Long> C(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.d()
            r7.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.y()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.x3 r8 = r7.f()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.z3 r8 = r8.P()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.String r9 = "Main event not found"
            r8.a(r9)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r0
        L35:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.t0$a r4 = com.google.android.gms.internal.measurement.t0.b0()     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.x5 r2 = com.google.android.gms.measurement.internal.r9.B(r4, r2)     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.t0$a r2 = (com.google.android.gms.internal.measurement.t0.a) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.u5 r2 = r2.j()     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.n4 r2 = (com.google.android.gms.internal.measurement.n4) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.t0 r2 = (com.google.android.gms.internal.measurement.t0) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r8
        L5b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.x3 r3 = r7.f()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.x3.y(r8)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r3.d(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r0
        L71:
            r8 = move-exception
            goto L77
        L73:
            r8 = move-exception
            goto L8c
        L75:
            r8 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.x3 r9 = r7.f()     // Catch: java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.z3 r9 = r9.H()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = "Error selecting main event"
            r9.b(r2, r8)     // Catch: java.lang.Throwable -> L8a
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            r8 = move-exception
            r0 = r1
        L8c:
            if (r0 == 0) goto L91
            r0.close()
        L91:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.C(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean C0() {
        return j0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final d D(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        com.google.android.gms.common.internal.t.g(str);
        d();
        u();
        String[] strArr = {str};
        d dVar = new d();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase y = y();
                Cursor query = y.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    f().K().b("Not updating daily counts, app is not known. appId", x3.y(str));
                    query.close();
                    return dVar;
                }
                if (query.getLong(0) == j2) {
                    dVar.f7531b = query.getLong(1);
                    dVar.a = query.getLong(2);
                    dVar.f7532c = query.getLong(3);
                    dVar.f7533d = query.getLong(4);
                    dVar.f7534e = query.getLong(5);
                }
                if (z) {
                    dVar.f7531b += j3;
                }
                if (z2) {
                    dVar.a += j3;
                }
                if (z3) {
                    dVar.f7532c += j3;
                }
                if (z4) {
                    dVar.f7533d += j3;
                }
                if (z5) {
                    dVar.f7534e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(dVar.a));
                contentValues.put("daily_events_count", Long.valueOf(dVar.f7531b));
                contentValues.put("daily_conversions_count", Long.valueOf(dVar.f7532c));
                contentValues.put("daily_error_events_count", Long.valueOf(dVar.f7533d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(dVar.f7534e));
                y.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return dVar;
            } catch (SQLiteException e2) {
                f().H().c("Error updating daily counts. appId", x3.y(str), e2);
                if (0 != 0) {
                    cursor.close();
                }
                return dVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D0() {
        int delete;
        d();
        u();
        if (i0()) {
            long a = n().f7708i.a();
            long b2 = i().b();
            if (Math.abs(b2 - a) > r.z.a(null).longValue()) {
                n().f7708i.b(b2);
                d();
                u();
                if (!i0() || (delete = y().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(i().a()), String.valueOf(ka.N())})) <= 0) {
                    return;
                }
                f().P().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final d E(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return D(j2, str, 1L, false, false, z3, false, z5);
    }

    public final long E0() {
        return B("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE  (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.l F(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.F(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.l");
    }

    public final long F0() {
        return B("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean G0() {
        return j0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean H0() {
        return j0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String I(long r5) {
        /*
            r4 = this;
            r4.d()
            r4.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.y()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            if (r1 != 0) goto L32
            com.google.android.gms.measurement.internal.x3 r6 = r4.f()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.z3 r6 = r6.P()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r0
        L32:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r6
        L3a:
            r6 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L55
        L3e:
            r6 = move-exception
            r5 = r0
        L40:
            com.google.android.gms.measurement.internal.x3 r1 = r4.f()     // Catch: java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.z3 r1 = r1.H()     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "Error selecting expired configs"
            r1.b(r2, r6)     // Catch: java.lang.Throwable -> L53
            if (r5 == 0) goto L52
            r5.close()
        L52:
            return r0
        L53:
            r6 = move-exception
            r0 = r5
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.I(long):java.lang.String");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x009a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x009a */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.s9> J(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.t.g(r14)
            r13.d()
            r13.u()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.y()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r12 = 0
            r6[r12] = r14     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L80
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r3 != 0) goto L3d
            r2.close()
            return r0
        L3d:
            java.lang.String r7 = r2.getString(r12)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.String r3 = r2.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r3 != 0) goto L49
            java.lang.String r3 = ""
        L49:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r3 = 3
            java.lang.Object r10 = r13.H(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r10 != 0) goto L68
            com.google.android.gms.measurement.internal.x3 r3 = r13.f()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.x3.y(r14)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r3.b(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            goto L72
        L68:
            com.google.android.gms.measurement.internal.s9 r3 = new com.google.android.gms.measurement.internal.s9     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
        L72:
            boolean r3 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7c java.lang.Throwable -> L99
            if (r3 != 0) goto L3d
            r2.close()
            return r0
        L7c:
            r0 = move-exception
            goto L82
        L7e:
            r14 = move-exception
            goto L9b
        L80:
            r0 = move-exception
            r2 = r1
        L82:
            com.google.android.gms.measurement.internal.x3 r3 = r13.f()     // Catch: java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: java.lang.Throwable -> L99
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.x3.y(r14)     // Catch: java.lang.Throwable -> L99
            r3.c(r4, r14, r0)     // Catch: java.lang.Throwable -> L99
            if (r2 == 0) goto L98
            r2.close()
        L98:
            return r1
        L99:
            r14 = move-exception
            r1 = r2
        L9b:
            if (r1 == 0) goto La0
            r1.close()
        La0:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.J(java.lang.String):java.util.List");
    }

    public final List<Pair<com.google.android.gms.internal.measurement.x0, Long>> K(String str, int i2, int i3) {
        byte[] X;
        d();
        u();
        com.google.android.gms.common.internal.t.a(i2 > 0);
        com.google.android.gms.common.internal.t.a(i3 > 0);
        com.google.android.gms.common.internal.t.g(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = y().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!query.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.measurement.x0, Long>> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                do {
                    long j2 = query.getLong(0);
                    try {
                        X = q().X(query.getBlob(1));
                    } catch (IOException e2) {
                        f().H().c("Failed to unzip queued bundle. appId", x3.y(str), e2);
                    }
                    if (!arrayList.isEmpty() && X.length + i4 > i3) {
                        break;
                    }
                    try {
                        x0.a aVar = (x0.a) r9.B(com.google.android.gms.internal.measurement.x0.R0(), X);
                        if (!query.isNull(2)) {
                            aVar.x0(query.getInt(2));
                        }
                        i4 += X.length;
                        arrayList.add(Pair.create((com.google.android.gms.internal.measurement.x0) ((com.google.android.gms.internal.measurement.n4) aVar.j()), Long.valueOf(j2)));
                    } catch (IOException e3) {
                        f().H().c("Failed to merge queued bundle. appId", x3.y(str), e3);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i4 <= i3);
                query.close();
                return arrayList;
            } catch (SQLiteException e4) {
                f().H().c("Error querying bundles. appId", x3.y(str), e4);
                List<Pair<com.google.android.gms.internal.measurement.x0, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008e, code lost:
        f().H().b("Read more than the max allowed user properties, ignoring excess", java.lang.Integer.valueOf((int) com.reactnativecommunity.webview.RNCWebViewManager.COMMAND_CLEAR_FORM_DATA));
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.s9> L(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.L(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
        f().H().b("Read more than the max allowed conditional properties, ignoring extra", java.lang.Integer.valueOf((int) com.reactnativecommunity.webview.RNCWebViewManager.COMMAND_CLEAR_FORM_DATA));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.ia> M(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.M(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void O(l lVar) {
        com.google.android.gms.common.internal.t.k(lVar);
        d();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lVar.a);
        contentValues.put(ApiConstants.NAME, lVar.f7725b);
        contentValues.put("lifetime_count", Long.valueOf(lVar.f7726c));
        contentValues.put("current_bundle_count", Long.valueOf(lVar.f7727d));
        contentValues.put("last_fire_timestamp", Long.valueOf(lVar.f7729f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(lVar.f7730g));
        contentValues.put("last_bundled_day", lVar.f7731h);
        contentValues.put("last_sampled_complex_event_id", lVar.f7732i);
        contentValues.put("last_sampling_rate", lVar.f7733j);
        contentValues.put("current_session_count", Long.valueOf(lVar.f7728e));
        Boolean bool = lVar.f7734k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (y().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                f().H().b("Failed to insert/update event aggregates (got -1). appId", x3.y(lVar.a));
            }
        } catch (SQLiteException e2) {
            f().H().c("Error storing event aggregates. appId", x3.y(lVar.a), e2);
        }
    }

    public final void P(f4 f4Var) {
        com.google.android.gms.common.internal.t.k(f4Var);
        d();
        u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", f4Var.t());
        contentValues.put("app_instance_id", f4Var.x());
        contentValues.put("gmp_app_id", f4Var.A());
        contentValues.put("resettable_device_id_hash", f4Var.J());
        contentValues.put("last_bundle_index", Long.valueOf(f4Var.f0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(f4Var.P()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(f4Var.R()));
        contentValues.put("app_version", f4Var.T());
        contentValues.put("app_store", f4Var.X());
        contentValues.put("gmp_version", Long.valueOf(f4Var.Z()));
        contentValues.put("dev_cert_hash", Long.valueOf(f4Var.b0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(f4Var.e0()));
        contentValues.put("day", Long.valueOf(f4Var.j0()));
        contentValues.put("daily_public_events_count", Long.valueOf(f4Var.k0()));
        contentValues.put("daily_events_count", Long.valueOf(f4Var.l0()));
        contentValues.put("daily_conversions_count", Long.valueOf(f4Var.m0()));
        contentValues.put("config_fetched_time", Long.valueOf(f4Var.g0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(f4Var.h0()));
        contentValues.put("app_version_int", Long.valueOf(f4Var.V()));
        contentValues.put("firebase_instance_id", f4Var.M());
        contentValues.put("daily_error_events_count", Long.valueOf(f4Var.h()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(f4Var.g()));
        contentValues.put("health_monitor_sample", f4Var.i());
        contentValues.put("android_id", Long.valueOf(f4Var.k()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(f4Var.l()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(f4Var.m()));
        contentValues.put("admob_app_id", f4Var.D());
        contentValues.put("dynamite_version", Long.valueOf(f4Var.d0()));
        if (f4Var.o() != null) {
            if (f4Var.o().size() == 0) {
                f().K().b("Safelisted events should not be an empty list. appId", f4Var.t());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", f4Var.o()));
            }
        }
        if (com.google.android.gms.internal.measurement.ka.b() && o().D(f4Var.t(), r.r0)) {
            contentValues.put("ga_app_id", f4Var.G());
        }
        try {
            SQLiteDatabase y = y();
            if (y.update("apps", contentValues, "app_id = ?", new String[]{f4Var.t()}) == 0 && y.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                f().H().b("Failed to insert/update app (got -1). appId", x3.y(f4Var.t()));
            }
        } catch (SQLiteException e2) {
            f().H().c("Error storing app. appId", x3.y(f4Var.t()), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q(String str, List<com.google.android.gms.internal.measurement.c0> list) {
        boolean z;
        boolean z2;
        com.google.android.gms.common.internal.t.k(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            c0.a x = list.get(i2).x();
            if (x.y() != 0) {
                for (int i3 = 0; i3 < x.y(); i3++) {
                    d0.a x2 = x.A(i3).x();
                    d0.a aVar = (d0.a) ((n4.a) x2.clone());
                    String b2 = b6.b(x2.x());
                    if (b2 != null) {
                        aVar.v(b2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i4 = 0; i4 < x2.y(); i4++) {
                        com.google.android.gms.internal.measurement.e0 w = x2.w(i4);
                        String a = a6.a(w.K());
                        if (a != null) {
                            aVar.u(i4, (com.google.android.gms.internal.measurement.e0) ((com.google.android.gms.internal.measurement.n4) w.x().u(a).j()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        x = x.v(i3, aVar);
                        list.set(i2, (com.google.android.gms.internal.measurement.c0) ((com.google.android.gms.internal.measurement.n4) x.j()));
                    }
                }
            }
            if (x.u() != 0) {
                for (int i5 = 0; i5 < x.u(); i5++) {
                    com.google.android.gms.internal.measurement.g0 x3 = x.x(i5);
                    String a2 = d6.a(x3.F());
                    if (a2 != null) {
                        x = x.w(i5, x3.x().u(a2));
                        list.set(i2, (com.google.android.gms.internal.measurement.c0) ((com.google.android.gms.internal.measurement.n4) x.j()));
                    }
                }
            }
        }
        u();
        d();
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(list);
        SQLiteDatabase y = y();
        y.beginTransaction();
        try {
            u();
            d();
            com.google.android.gms.common.internal.t.g(str);
            SQLiteDatabase y2 = y();
            y2.delete("property_filters", "app_id=?", new String[]{str});
            y2.delete("event_filters", "app_id=?", new String[]{str});
            for (com.google.android.gms.internal.measurement.c0 c0Var : list) {
                u();
                d();
                com.google.android.gms.common.internal.t.g(str);
                com.google.android.gms.common.internal.t.k(c0Var);
                if (!c0Var.G()) {
                    f().K().b("Audience with no ID. appId", x3.y(str));
                } else {
                    int H = c0Var.H();
                    Iterator<com.google.android.gms.internal.measurement.d0> it = c0Var.L().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().G()) {
                                f().K().c("Event filter with no ID. Audience definition ignored. appId, audienceId", x3.y(str), Integer.valueOf(H));
                                break;
                            }
                        } else {
                            Iterator<com.google.android.gms.internal.measurement.g0> it2 = c0Var.J().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().D()) {
                                        f().K().c("Property filter with no ID. Audience definition ignored. appId, audienceId", x3.y(str), Integer.valueOf(H));
                                        break;
                                    }
                                } else {
                                    Iterator<com.google.android.gms.internal.measurement.d0> it3 = c0Var.L().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!W(str, H, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<com.google.android.gms.internal.measurement.g0> it4 = c0Var.J().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!X(str, H, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        u();
                                        d();
                                        com.google.android.gms.common.internal.t.g(str);
                                        SQLiteDatabase y3 = y();
                                        y3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(H)});
                                        y3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(H)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.c0 c0Var2 : list) {
                arrayList.add(c0Var2.G() ? Integer.valueOf(c0Var2.H()) : null);
            }
            n0(str, arrayList);
            y.setTransactionSuccessful();
        } finally {
            y.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void R(List<Long> list) {
        d();
        u();
        com.google.android.gms.common.internal.t.k(list);
        com.google.android.gms.common.internal.t.m(list.size());
        if (i0()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (j0(sb3.toString(), null) > 0) {
                f().K().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase y = y();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                y.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                f().H().b("Error incrementing retry count. error", e2);
            }
        }
    }

    public final boolean S(com.google.android.gms.internal.measurement.x0 x0Var, boolean z) {
        d();
        u();
        com.google.android.gms.common.internal.t.k(x0Var);
        com.google.android.gms.common.internal.t.g(x0Var.M2());
        com.google.android.gms.common.internal.t.n(x0Var.n2());
        D0();
        long a = i().a();
        if (x0Var.o2() < a - ka.N() || x0Var.o2() > ka.N() + a) {
            f().K().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", x3.y(x0Var.M2()), Long.valueOf(a), Long.valueOf(x0Var.o2()));
        }
        try {
            byte[] Y = q().Y(x0Var.l());
            f().P().b("Saving bundle, size", Integer.valueOf(Y.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", x0Var.M2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(x0Var.o2()));
            contentValues.put("data", Y);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (x0Var.y0()) {
                contentValues.put("retry_count", Integer.valueOf(x0Var.M0()));
            }
            try {
                if (y().insert("queue", null, contentValues) == -1) {
                    f().H().b("Failed to insert bundle (got -1). appId", x3.y(x0Var.M2()));
                    return false;
                }
                return true;
            } catch (SQLiteException e2) {
                f().H().c("Error storing bundle. appId", x3.y(x0Var.M2()), e2);
                return false;
            }
        } catch (IOException e3) {
            f().H().c("Data loss. Failed to serialize bundle. appId", x3.y(x0Var.M2()), e3);
            return false;
        }
    }

    public final boolean T(m mVar, long j2, boolean z) {
        d();
        u();
        com.google.android.gms.common.internal.t.k(mVar);
        com.google.android.gms.common.internal.t.g(mVar.a);
        t0.a G = com.google.android.gms.internal.measurement.t0.b0().G(mVar.f7753e);
        Iterator<String> it = mVar.f7754f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            v0.a A = com.google.android.gms.internal.measurement.v0.c0().A(next);
            q().K(A, mVar.f7754f.k1(next));
            G.x(A);
        }
        byte[] l2 = ((com.google.android.gms.internal.measurement.t0) ((com.google.android.gms.internal.measurement.n4) G.j())).l();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", mVar.a);
        contentValues.put(ApiConstants.NAME, mVar.f7750b);
        contentValues.put("timestamp", Long.valueOf(mVar.f7752d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", l2);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (y().insert("raw_events", null, contentValues) == -1) {
                f().H().b("Failed to insert raw event (got -1). appId", x3.y(mVar.a));
                return false;
            }
            return true;
        } catch (SQLiteException e2) {
            f().H().c("Error storing raw event. appId", x3.y(mVar.a), e2);
            return false;
        }
    }

    public final boolean U(s9 s9Var) {
        com.google.android.gms.common.internal.t.k(s9Var);
        d();
        u();
        if (p0(s9Var.a, s9Var.f7861c) == null) {
            if (v9.c0(s9Var.f7861c)) {
                if (j0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{s9Var.a}) >= o().y(s9Var.a)) {
                    return false;
                }
            } else if (!"_npa".equals(s9Var.f7861c) && j0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{s9Var.a, s9Var.f7860b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", s9Var.a);
        contentValues.put("origin", s9Var.f7860b);
        contentValues.put(ApiConstants.NAME, s9Var.f7861c);
        contentValues.put("set_timestamp", Long.valueOf(s9Var.f7862d));
        N(contentValues, "value", s9Var.f7863e);
        try {
            if (y().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                f().H().b("Failed to insert/update user property (got -1). appId", x3.y(s9Var.a));
            }
        } catch (SQLiteException e2) {
            f().H().c("Error storing user property. appId", x3.y(s9Var.a), e2);
        }
        return true;
    }

    public final boolean V(ia iaVar) {
        com.google.android.gms.common.internal.t.k(iaVar);
        d();
        u();
        if (p0(iaVar.a, iaVar.f7654c.f7823b) != null || j0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{iaVar.a}) < 1000) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", iaVar.a);
            contentValues.put("origin", iaVar.f7653b);
            contentValues.put(ApiConstants.NAME, iaVar.f7654c.f7823b);
            N(contentValues, "value", iaVar.f7654c.i1());
            contentValues.put(AppStateModule.APP_STATE_ACTIVE, Boolean.valueOf(iaVar.f7656e));
            contentValues.put("trigger_event_name", iaVar.f7657f);
            contentValues.put("trigger_timeout", Long.valueOf(iaVar.f7659h));
            m();
            contentValues.put("timed_out_event", v9.m0(iaVar.f7658g));
            contentValues.put("creation_timestamp", Long.valueOf(iaVar.f7655d));
            m();
            contentValues.put("triggered_event", v9.m0(iaVar.f7660j));
            contentValues.put("triggered_timestamp", Long.valueOf(iaVar.f7654c.f7824c));
            contentValues.put("time_to_live", Long.valueOf(iaVar.f7661k));
            m();
            contentValues.put("expired_event", v9.m0(iaVar.f7662l));
            try {
                if (y().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                    f().H().b("Failed to insert/update conditional user property (got -1)", x3.y(iaVar.a));
                }
            } catch (SQLiteException e2) {
                f().H().c("Error storing conditional user property", x3.y(iaVar.a), e2);
            }
            return true;
        }
        return false;
    }

    public final boolean Y(String str, Long l2, long j2, com.google.android.gms.internal.measurement.t0 t0Var) {
        d();
        u();
        com.google.android.gms.common.internal.t.k(t0Var);
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.k(l2);
        byte[] l3 = t0Var.l();
        f().P().c("Saving complex main event, appId, data size", j().x(str), Integer.valueOf(l3.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", l3);
        try {
            if (y().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                f().H().b("Failed to insert complex main event (got -1). appId", x3.y(str));
                return false;
            }
            return true;
        } catch (SQLiteException e2) {
            f().H().c("Error storing complex main event. appId", x3.y(str), e2);
            return false;
        }
    }

    public final long Z() {
        Cursor cursor = null;
        try {
            try {
                cursor = y().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return -1L;
                }
                long j2 = cursor.getLong(0);
                cursor.close();
                return j2;
            } catch (SQLiteException e2) {
                f().H().b("Error querying raw events", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x011d A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0157 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0185 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a2 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b1 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c9 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e7 A[Catch: SQLiteException -> 0x01fc, all -> 0x0225, TRY_LEAVE, TryCatch #1 {all -> 0x0225, blocks: (B:10:0x006d, B:12:0x00ce, B:17:0x00d8, B:21:0x0122, B:23:0x0157, B:27:0x0165, B:26:0x0161, B:28:0x0168, B:30:0x0170, B:35:0x017a, B:37:0x0185, B:41:0x018d, B:45:0x01a6, B:47:0x01b1, B:48:0x01c3, B:50:0x01c9, B:52:0x01d5, B:53:0x01de, B:55:0x01e7, B:44:0x01a2, B:20:0x011d, B:68:0x020e), top: B:77:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0229  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.f4 k0(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.k0(java.lang.String):com.google.android.gms.measurement.internal.f4");
    }

    public final List<ia> l0(String str, String str2, String str3) {
        com.google.android.gms.common.internal.t.g(str);
        d();
        u();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return M(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final void m0(String str, String str2) {
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.g(str2);
        d();
        u();
        try {
            y().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            f().H().d("Error deleting user property. appId", x3.y(str), j().B(str2), e2);
        }
    }

    public final long o0(String str) {
        com.google.android.gms.common.internal.t.g(str);
        d();
        u();
        try {
            return y().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, o().w(str, r.q))))});
        } catch (SQLiteException e2) {
            f().H().c("Error deleting over the limit events. appId", x3.y(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.s9 p0(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.t.g(r19)
            com.google.android.gms.common.internal.t.g(r20)
            r18.d()
            r18.u()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.y()     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7e
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L76
            if (r3 != 0) goto L3d
            r10.close()
            return r9
        L3d:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteException -> L76
            r11 = r18
            java.lang.Object r7 = r11.H(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.s9 r0 = new com.google.android.gms.measurement.internal.s9     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            if (r1 == 0) goto L6c
            com.google.android.gms.measurement.internal.x3 r1 = r18.f()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.z3 r1 = r1.H()     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.x3.y(r19)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
            r1.b(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L70 java.lang.Throwable -> La1
        L6c:
            r10.close()
            return r0
        L70:
            r0 = move-exception
            goto L82
        L72:
            r0 = move-exception
            r11 = r18
            goto La2
        L76:
            r0 = move-exception
            r11 = r18
            goto L82
        L7a:
            r0 = move-exception
            r11 = r18
            goto La3
        L7e:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L82:
            com.google.android.gms.measurement.internal.x3 r1 = r18.f()     // Catch: java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.z3 r1 = r1.H()     // Catch: java.lang.Throwable -> La1
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.x3.y(r19)     // Catch: java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.v3 r4 = r18.j()     // Catch: java.lang.Throwable -> La1
            java.lang.String r4 = r4.B(r8)     // Catch: java.lang.Throwable -> La1
            r1.d(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La1
            if (r10 == 0) goto La0
            r10.close()
        La0:
            return r9
        La1:
            r0 = move-exception
        La2:
            r9 = r10
        La3:
            if (r9 == 0) goto La8
            r9.close()
        La8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.p0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.s9");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.ia q0(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.q0(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.ia");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006c: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] r0(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.t.g(r11)
            r10.d()
            r10.u()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.y()     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L50 android.database.sqlite.SQLiteException -> L52
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            if (r2 != 0) goto L2f
            r1.close()
            return r0
        L2f:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            if (r3 == 0) goto L4a
            com.google.android.gms.measurement.internal.x3 r3 = r10.f()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.x3.y(r11)     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
            r3.b(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L4e java.lang.Throwable -> L6b
        L4a:
            r1.close()
            return r2
        L4e:
            r2 = move-exception
            goto L54
        L50:
            r11 = move-exception
            goto L6d
        L52:
            r2 = move-exception
            r1 = r0
        L54:
            com.google.android.gms.measurement.internal.x3 r3 = r10.f()     // Catch: java.lang.Throwable -> L6b
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.x3.y(r11)     // Catch: java.lang.Throwable -> L6b
            r3.c(r4, r11, r2)     // Catch: java.lang.Throwable -> L6b
            if (r1 == 0) goto L6a
            r1.close()
        L6a:
            return r0
        L6b:
            r11 = move-exception
            r0 = r1
        L6d:
            if (r0 == 0) goto L72
            r0.close()
        L72:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.r0(java.lang.String):byte[]");
    }

    public final int s0(String str, String str2) {
        com.google.android.gms.common.internal.t.g(str);
        com.google.android.gms.common.internal.t.g(str2);
        d();
        u();
        try {
            return y().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            f().H().d("Error deleting conditional property", x3.y(str), j().B(str2), e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<com.google.android.gms.internal.measurement.d0>> t0(String str) {
        com.google.android.gms.common.internal.t.g(str);
        c.e.a aVar = new c.e.a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = y().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<com.google.android.gms.internal.measurement.d0>> emptyMap = Collections.emptyMap();
                    query.close();
                    return emptyMap;
                }
                do {
                    try {
                        com.google.android.gms.internal.measurement.d0 d0Var = (com.google.android.gms.internal.measurement.d0) ((com.google.android.gms.internal.measurement.n4) ((d0.a) r9.B(com.google.android.gms.internal.measurement.d0.R(), query.getBlob(1))).j());
                        if (d0Var.L()) {
                            int i2 = query.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i2));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i2), list);
                            }
                            list.add(d0Var);
                        }
                    } catch (IOException e2) {
                        f().H().c("Failed to merge filter. appId", x3.y(str), e2);
                    }
                } while (query.moveToNext());
                query.close();
                return aVar;
            } catch (SQLiteException e3) {
                f().H().c("Database error querying filters. appId", x3.y(str), e3);
                Map<Integer, List<com.google.android.gms.internal.measurement.d0>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> u0(java.lang.String r8) {
        /*
            r7 = this;
            r7.u()
            r7.d()
            com.google.android.gms.common.internal.t.g(r8)
            c.e.a r0 = new c.e.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.y()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            if (r3 != 0) goto L30
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            r1.close()
            return r8
        L30:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            if (r4 != 0) goto L4c
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
        L4c:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L61 java.lang.Throwable -> L7e
            if (r3 != 0) goto L30
            r1.close()
            return r0
        L61:
            r0 = move-exception
            goto L67
        L63:
            r8 = move-exception
            goto L80
        L65:
            r0 = move-exception
            r1 = r2
        L67:
            com.google.android.gms.measurement.internal.x3 r3 = r7.f()     // Catch: java.lang.Throwable -> L7e
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.x3.y(r8)     // Catch: java.lang.Throwable -> L7e
            r3.c(r4, r8, r0)     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L7d
            r1.close()
        L7d:
            return r2
        L7e:
            r8 = move-exception
            r2 = r1
        L80:
            if (r2 == 0) goto L85
            r2.close()
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.u0(java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.d0>> v0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.u()
            r12.d()
            com.google.android.gms.common.internal.t.g(r13)
            com.google.android.gms.common.internal.t.g(r14)
            c.e.a r0 = new c.e.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.y()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            if (r1 != 0) goto L40
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r14.close()
            return r13
        L40:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.d0$a r2 = com.google.android.gms.internal.measurement.d0.R()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.x5 r1 = com.google.android.gms.measurement.internal.r9.B(r2, r1)     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.d0$a r1 = (com.google.android.gms.internal.measurement.d0.a) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.u5 r1 = r1.j()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.n4 r1 = (com.google.android.gms.internal.measurement.n4) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.d0 r1 = (com.google.android.gms.internal.measurement.d0) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            if (r3 != 0) goto L72
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
        L72:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            goto L88
        L76:
            r1 = move-exception
            com.google.android.gms.measurement.internal.x3 r2 = r12.f()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.measurement.internal.z3 r2 = r2.H()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.x3.y(r13)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r2.c(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
        L88:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            if (r1 != 0) goto L40
            r14.close()
            return r0
        L92:
            r0 = move-exception
            goto L98
        L94:
            r13 = move-exception
            goto Lb1
        L96:
            r0 = move-exception
            r14 = r9
        L98:
            com.google.android.gms.measurement.internal.x3 r1 = r12.f()     // Catch: java.lang.Throwable -> Laf
            com.google.android.gms.measurement.internal.z3 r1 = r1.H()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.x3.y(r13)     // Catch: java.lang.Throwable -> Laf
            r1.c(r2, r13, r0)     // Catch: java.lang.Throwable -> Laf
            if (r14 == 0) goto Lae
            r14.close()
        Lae:
            return r9
        Laf:
            r13 = move-exception
            r9 = r14
        Lb1:
            if (r9 == 0) goto Lb6
            r9.close()
        Lb6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.v0(java.lang.String, java.lang.String):java.util.Map");
    }

    @Override // com.google.android.gms.measurement.internal.k9
    protected final boolean w() {
        return false;
    }

    public final void w0() {
        u();
        y().beginTransaction();
    }

    public final void x() {
        u();
        y().setTransactionSuccessful();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.z0> x0(java.lang.String r12) {
        /*
            r11 = this;
            r11.u()
            r11.d()
            com.google.android.gms.common.internal.t.g(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.y()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            r10 = 0
            r4[r10] = r12     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7a android.database.sqlite.SQLiteException -> L7c
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            if (r1 != 0) goto L31
            r0.close()
            return r8
        L31:
            c.e.a r1 = new c.e.a     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
        L36:
            int r2 = r0.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            byte[] r3 = r0.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.internal.measurement.z0$a r4 = com.google.android.gms.internal.measurement.z0.Z()     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.internal.measurement.x5 r3 = com.google.android.gms.measurement.internal.r9.B(r4, r3)     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.internal.measurement.z0$a r3 = (com.google.android.gms.internal.measurement.z0.a) r3     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.internal.measurement.u5 r3 = r3.j()     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.internal.measurement.n4 r3 = (com.google.android.gms.internal.measurement.n4) r3     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.internal.measurement.z0 r3 = (com.google.android.gms.internal.measurement.z0) r3     // Catch: java.io.IOException -> L58 android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            goto L6e
        L58:
            r3 = move-exception
            com.google.android.gms.measurement.internal.x3 r4 = r11.f()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            com.google.android.gms.measurement.internal.z3 r4 = r4.H()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.x3.y(r12)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            r4.d(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
        L6e:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L78 java.lang.Throwable -> L95
            if (r2 != 0) goto L36
            r0.close()
            return r1
        L78:
            r1 = move-exception
            goto L7e
        L7a:
            r12 = move-exception
            goto L97
        L7c:
            r1 = move-exception
            r0 = r8
        L7e:
            com.google.android.gms.measurement.internal.x3 r2 = r11.f()     // Catch: java.lang.Throwable -> L95
            com.google.android.gms.measurement.internal.z3 r2 = r2.H()     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.x3.y(r12)     // Catch: java.lang.Throwable -> L95
            r2.c(r3, r12, r1)     // Catch: java.lang.Throwable -> L95
            if (r0 == 0) goto L94
            r0.close()
        L94:
            return r8
        L95:
            r12 = move-exception
            r8 = r0
        L97:
            if (r8 == 0) goto L9c
            r8.close()
        L9c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.x0(java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase y() {
        d();
        try {
            return this.f7553l.getWritableDatabase();
        } catch (SQLiteException e2) {
            f().K().b("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.g0>> y0(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.u()
            r12.d()
            com.google.android.gms.common.internal.t.g(r13)
            com.google.android.gms.common.internal.t.g(r14)
            c.e.a r0 = new c.e.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.y()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L96
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            if (r1 != 0) goto L40
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r14.close()
            return r13
        L40:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.g0$a r2 = com.google.android.gms.internal.measurement.g0.L()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.x5 r1 = com.google.android.gms.measurement.internal.r9.B(r2, r1)     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.g0$a r1 = (com.google.android.gms.internal.measurement.g0.a) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.u5 r1 = r1.j()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.n4 r1 = (com.google.android.gms.internal.measurement.n4) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.internal.measurement.g0 r1 = (com.google.android.gms.internal.measurement.g0) r1     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            if (r3 != 0) goto L72
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
        L72:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            goto L88
        L76:
            r1 = move-exception
            com.google.android.gms.measurement.internal.x3 r2 = r12.f()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            com.google.android.gms.measurement.internal.z3 r2 = r2.H()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.x3.y(r13)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            r2.c(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
        L88:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Laf
            if (r1 != 0) goto L40
            r14.close()
            return r0
        L92:
            r0 = move-exception
            goto L98
        L94:
            r13 = move-exception
            goto Lb1
        L96:
            r0 = move-exception
            r14 = r9
        L98:
            com.google.android.gms.measurement.internal.x3 r1 = r12.f()     // Catch: java.lang.Throwable -> Laf
            com.google.android.gms.measurement.internal.z3 r1 = r1.H()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.x3.y(r13)     // Catch: java.lang.Throwable -> Laf
            r1.c(r2, r13, r0)     // Catch: java.lang.Throwable -> Laf
            if (r14 == 0) goto Lae
            r14.close()
        Lae:
            return r9
        Laf:
            r13 = move-exception
            r9 = r14
        Lb1:
            if (r9 == 0) goto Lb6
            r9.close()
        Lb6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.y0(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String z() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.y()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L25
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L27
        L20:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L25:
            r2 = move-exception
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.x3 r3 = r6.f()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.z3 r3 = r3.H()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.b(r4, r2)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            r1 = move-exception
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.e.z():java.lang.String");
    }

    public final long z0(String str) {
        com.google.android.gms.common.internal.t.g(str);
        return B("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }
}