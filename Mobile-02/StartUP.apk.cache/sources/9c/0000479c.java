package e.g.a.c.i.v.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.coinbase.ApiConstants;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import e.g.a.c.i.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class b0 implements e.g.a.c.i.v.j.c, com.google.android.datatransport.runtime.synchronization.a {
    private static final e.g.a.c.b a = e.g.a.c.b.b("proto");

    /* renamed from: b  reason: collision with root package name */
    private final h0 f13050b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.w.a f13051c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.i.w.a f13052d;

    /* renamed from: e  reason: collision with root package name */
    private final e.g.a.c.i.v.j.d f13053e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public interface b<T, U> {
        U apply(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static class c {
        final String a;

        /* renamed from: b  reason: collision with root package name */
        final String f13054b;

        private c(String str, String str2) {
            this.a = str;
            this.f13054b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(e.g.a.c.i.w.a aVar, e.g.a.c.i.w.a aVar2, e.g.a.c.i.v.j.d dVar, h0 h0Var) {
        this.f13050b = h0Var;
        this.f13051c = aVar;
        this.f13052d = aVar2;
        this.f13053e = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object A(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SQLiteDatabase G(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    private static e.g.a.c.b I0(String str) {
        if (str == null) {
            return a;
        }
        return e.g.a.c.b.b(str);
    }

    private static String J0(Iterable<i> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<i> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long K(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    private static <T> T L0(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long N(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean O(b0 b0Var, e.g.a.c.i.l lVar, SQLiteDatabase sQLiteDatabase) {
        Long g2 = b0Var.g(sQLiteDatabase, lVar);
        if (g2 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) L0(b0Var.d().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{g2.toString()}), u.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List V(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(e.g.a.c.i.l.a().b(cursor.getString(1)).d(e.g.a.c.i.x.a.b(cursor.getInt(2))).c(x0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List a0(SQLiteDatabase sQLiteDatabase) {
        return (List) L0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), t.a());
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        z0(q.b(sQLiteDatabase), r.a());
    }

    private long c(SQLiteDatabase sQLiteDatabase, e.g.a.c.i.l lVar) {
        Long g2 = g(sQLiteDatabase, lVar);
        if (g2 != null) {
            return g2.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", lVar.b());
        contentValues.put("priority", Integer.valueOf(e.g.a.c.i.x.a.a(lVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (lVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(lVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List d0(b0 b0Var, e.g.a.c.i.l lVar, SQLiteDatabase sQLiteDatabase) {
        List<i> s0 = b0Var.s0(sQLiteDatabase, lVar);
        return b0Var.n(s0, b0Var.w0(sQLiteDatabase, s0));
    }

    private long e() {
        return d().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object e0(b0 b0Var, List list, e.g.a.c.i.l lVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            h.a k2 = e.g.a.c.i.h.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z) {
                k2.h(new e.g.a.c.i.g(I0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                k2.h(new e.g.a.c.i.g(I0(cursor.getString(4)), b0Var.y0(j2)));
            }
            if (!cursor.isNull(6)) {
                k2.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(i.a(j2, lVar, k2.d()));
        }
        return null;
    }

    private long f() {
        return d().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private Long g(SQLiteDatabase sQLiteDatabase, e.g.a.c.i.l lVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(lVar.b(), String.valueOf(e.g.a.c.i.x.a.a(lVar.d()))));
        if (lVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(lVar.c(), 0));
        }
        return (Long) L0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), x.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object g0(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j2));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j2), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    private <T> T j(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase d2 = d();
        d2.beginTransaction();
        try {
            T apply = bVar.apply(d2);
            d2.setTransactionSuccessful();
            return apply;
        } finally {
            d2.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long k0(b0 b0Var, e.g.a.c.i.l lVar, e.g.a.c.i.h hVar, SQLiteDatabase sQLiteDatabase) {
        if (b0Var.m()) {
            return -1L;
        }
        long c2 = b0Var.c(sQLiteDatabase, lVar);
        int e2 = b0Var.f13053e.e();
        byte[] a2 = hVar.e().a();
        boolean z = a2.length <= e2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(c2));
        contentValues.put("transport_name", hVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(hVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(hVar.k()));
        contentValues.put("payload_encoding", hVar.e().b().a());
        contentValues.put("code", hVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? a2 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(a2.length / e2);
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i2 - 1) * e2, Math.min(i2 * e2, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i2));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : hVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put(ApiConstants.NAME, entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    private boolean m() {
        return e() * f() >= this.f13053e.f();
    }

    private List<i> n(List<i> list, Map<Long, Set<c>> map) {
        ListIterator<i> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            i next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                h.a l2 = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    l2.c(cVar.a, cVar.f13054b);
                }
                listIterator.set(i.a(next.c(), next.d(), l2.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] n0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i2 += blob.length;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object o0(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object r0(long j2, e.g.a.c.i.l lVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{lVar.b(), String.valueOf(e.g.a.c.i.x.a.a(lVar.d()))}) < 1) {
            contentValues.put("backend_name", lVar.b());
            contentValues.put("priority", Integer.valueOf(e.g.a.c.i.x.a.a(lVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private List<i> s0(SQLiteDatabase sQLiteDatabase, e.g.a.c.i.l lVar) {
        ArrayList arrayList = new ArrayList();
        Long g2 = g(sQLiteDatabase, lVar);
        if (g2 == null) {
            return arrayList;
        }
        L0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{g2.toString()}, null, null, null, String.valueOf(this.f13053e.d())), n.a(this, arrayList, lVar));
        return arrayList;
    }

    private Map<Long, Set<c>> w0(SQLiteDatabase sQLiteDatabase, List<i> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).c());
            if (i2 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        L0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", ApiConstants.NAME, "value"}, sb.toString(), null, null, null, null), p.a(hashMap));
        return hashMap;
    }

    private static byte[] x0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private byte[] y0(long j2) {
        return (byte[]) L0(d().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num"), o.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object z(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    private <T> T z0(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.f13052d.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f13052d.a() >= this.f13053e.b() + a2) {
                    return bVar.apply(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // e.g.a.c.i.v.j.c
    public Iterable<i> E(e.g.a.c.i.l lVar) {
        return (Iterable) j(k.a(this, lVar));
    }

    @Override // e.g.a.c.i.v.j.c
    public i H0(e.g.a.c.i.l lVar, e.g.a.c.i.h hVar) {
        e.g.a.c.i.t.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", lVar.d(), hVar.j(), lVar.b());
        long longValue = ((Long) j(w.a(this, lVar, hVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return i.a(longValue, lVar, hVar);
    }

    @Override // e.g.a.c.i.v.j.c
    public void L(e.g.a.c.i.l lVar, long j2) {
        j(j.a(j2, lVar));
    }

    @Override // e.g.a.c.i.v.j.c
    public long N0(e.g.a.c.i.l lVar) {
        return ((Long) L0(d().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{lVar.b(), String.valueOf(e.g.a.c.i.x.a.a(lVar.d()))}), z.a())).longValue();
    }

    @Override // e.g.a.c.i.v.j.c
    public Iterable<e.g.a.c.i.l> T() {
        return (Iterable) j(l.a());
    }

    @Override // e.g.a.c.i.v.j.c
    public boolean V0(e.g.a.c.i.l lVar) {
        return ((Boolean) j(a0.a(this, lVar))).booleanValue();
    }

    @Override // e.g.a.c.i.v.j.c
    public void Y0(Iterable<i> iterable) {
        if (iterable.iterator().hasNext()) {
            j(y.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + J0(iterable)));
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a
    public <T> T a(a.InterfaceC0134a<T> interfaceC0134a) {
        SQLiteDatabase d2 = d();
        b(d2);
        try {
            T execute = interfaceC0134a.execute();
            d2.setTransactionSuccessful();
            return execute;
        } finally {
            d2.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13050b.close();
    }

    SQLiteDatabase d() {
        h0 h0Var = this.f13050b;
        h0Var.getClass();
        return (SQLiteDatabase) z0(s.b(h0Var), v.a());
    }

    @Override // e.g.a.c.i.v.j.c
    public int h() {
        return ((Integer) j(m.a(this.f13051c.a() - this.f13053e.c()))).intValue();
    }

    @Override // e.g.a.c.i.v.j.c
    public void q(Iterable<i> iterable) {
        if (iterable.iterator().hasNext()) {
            d().compileStatement("DELETE FROM events WHERE _id in " + J0(iterable)).execute();
        }
    }
}