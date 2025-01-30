package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import c.r.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: RoomDatabase.java */
/* loaded from: classes.dex */
public abstract class j {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    @Deprecated
    protected List<b> mCallbacks;
    @Deprecated
    protected volatile c.r.a.b mDatabase;
    private c.r.a.c mOpenHelper;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private final Map<String, Object> mBackingFieldMap = new ConcurrentHashMap();
    private final g mInvalidationTracker = createInvalidationTracker();

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static class a<T extends j> {
        private final Class<T> a;

        /* renamed from: b  reason: collision with root package name */
        private final String f2264b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f2265c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<b> f2266d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f2267e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f2268f;

        /* renamed from: g  reason: collision with root package name */
        private c.InterfaceC0085c f2269g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f2270h;

        /* renamed from: j  reason: collision with root package name */
        private boolean f2272j;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2274l;
        private Set<Integer> n;
        private Set<Integer> o;
        private String p;
        private File q;

        /* renamed from: i  reason: collision with root package name */
        private c f2271i = c.AUTOMATIC;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2273k = true;
        private final d m = new d();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, Class<T> cls, String str) {
            this.f2265c = context;
            this.a = cls;
            this.f2264b = str;
        }

        public a<T> a(androidx.room.s.a... aVarArr) {
            if (this.o == null) {
                this.o = new HashSet();
            }
            for (androidx.room.s.a aVar : aVarArr) {
                this.o.add(Integer.valueOf(aVar.startVersion));
                this.o.add(Integer.valueOf(aVar.endVersion));
            }
            this.m.b(aVarArr);
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T b() {
            Executor executor;
            if (this.f2265c != null) {
                if (this.a != null) {
                    Executor executor2 = this.f2267e;
                    if (executor2 == null && this.f2268f == null) {
                        Executor e2 = c.b.a.a.a.e();
                        this.f2268f = e2;
                        this.f2267e = e2;
                    } else if (executor2 != null && this.f2268f == null) {
                        this.f2268f = executor2;
                    } else if (executor2 == null && (executor = this.f2268f) != null) {
                        this.f2267e = executor;
                    }
                    Set<Integer> set = this.o;
                    if (set != null && this.n != null) {
                        for (Integer num : set) {
                            if (this.n.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    if (this.f2269g == null) {
                        this.f2269g = new c.r.a.g.c();
                    }
                    String str = this.p;
                    if (str != null || this.q != null) {
                        if (this.f2264b != null) {
                            if (str != null && this.q != null) {
                                throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                            }
                            this.f2269g = new p(str, this.q, this.f2269g);
                        } else {
                            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                        }
                    }
                    Context context = this.f2265c;
                    androidx.room.a aVar = new androidx.room.a(context, this.f2264b, this.f2269g, this.m, this.f2266d, this.f2270h, this.f2271i.n(context), this.f2267e, this.f2268f, this.f2272j, this.f2273k, this.f2274l, this.n, this.p, this.q);
                    T t = (T) i.b(this.a, j.DB_IMPL_SUFFIX);
                    t.init(aVar);
                    return t;
                }
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }

        public a<T> c() {
            this.f2273k = false;
            this.f2274l = true;
            return this;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(c.r.a.b bVar) {
        }

        public void b(c.r.a.b bVar) {
        }

        public void c(c.r.a.b bVar) {
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean h(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }

        @SuppressLint({"NewApi"})
        c n(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !h(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* loaded from: classes.dex */
    public static class d {
        private HashMap<Integer, TreeMap<Integer, androidx.room.s.a>> a = new HashMap<>();

        private void a(androidx.room.s.a aVar) {
            int i2 = aVar.startVersion;
            int i3 = aVar.endVersion;
            TreeMap<Integer, androidx.room.s.a> treeMap = this.a.get(Integer.valueOf(i2));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.a.put(Integer.valueOf(i2), treeMap);
            }
            androidx.room.s.a aVar2 = treeMap.get(Integer.valueOf(i3));
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i3), aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.List<androidx.room.s.a> d(java.util.List<androidx.room.s.a> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L58
                goto L7
            L5:
                if (r9 <= r10) goto L58
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.s.a>> r0 = r6.a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L54
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                if (r8 == 0) goto L40
                if (r3 > r10) goto L45
                if (r3 <= r9) goto L45
            L3e:
                r5 = r4
                goto L45
            L40:
                if (r3 < r10) goto L45
                if (r3 >= r9) goto L45
                goto L3e
            L45:
                if (r5 == 0) goto L26
                java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
                java.lang.Object r9 = r0.get(r9)
                r7.add(r9)
                r9 = r3
                goto L55
            L54:
                r4 = r5
            L55:
                if (r4 != 0) goto L0
                return r1
            L58:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.j.d.d(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(androidx.room.s.a... aVarArr) {
            for (androidx.room.s.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public List<androidx.room.s.a> c(int i2, int i3) {
            if (i2 == i3) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i3 > i2, i2, i3);
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        c.r.a.b b2 = this.mOpenHelper.b();
        this.mInvalidationTracker.n(b2);
        b2.o();
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            try {
                writeLock.lock();
                this.mInvalidationTracker.k();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public c.r.a.f compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.b().B(str);
    }

    protected abstract g createInvalidationTracker();

    protected abstract c.r.a.c createOpenHelper(androidx.room.a aVar);

    @Deprecated
    public void endTransaction() {
        this.mOpenHelper.b().p0();
        if (inTransaction()) {
            return;
        }
        this.mInvalidationTracker.f();
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public g getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public c.r.a.c getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.b().F0();
    }

    public void init(androidx.room.a aVar) {
        c.r.a.c createOpenHelper = createOpenHelper(aVar);
        this.mOpenHelper = createOpenHelper;
        if (createOpenHelper instanceof o) {
            ((o) createOpenHelper).e(aVar);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            r2 = aVar.f2226g == c.WRITE_AHEAD_LOGGING;
            this.mOpenHelper.a(r2);
        }
        this.mCallbacks = aVar.f2224e;
        this.mQueryExecutor = aVar.f2227h;
        this.mTransactionExecutor = new r(aVar.f2228i);
        this.mAllowMainThreadQueries = aVar.f2225f;
        this.mWriteAheadLoggingEnabled = r2;
        if (aVar.f2229j) {
            this.mInvalidationTracker.i(aVar.f2221b, aVar.f2222c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void internalInitInvalidationTracker(c.r.a.b bVar) {
        this.mInvalidationTracker.d(bVar);
    }

    public boolean isOpen() {
        c.r.a.b bVar = this.mDatabase;
        return bVar != null && bVar.isOpen();
    }

    public Cursor query(String str, Object[] objArr) {
        return this.mOpenHelper.b().A0(new c.r.a.a(str, objArr));
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.b().c0();
    }

    public Cursor query(c.r.a.e eVar) {
        return query(eVar, (CancellationSignal) null);
    }

    public Cursor query(c.r.a.e eVar, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null && Build.VERSION.SDK_INT >= 16) {
            return this.mOpenHelper.b().S(eVar, cancellationSignal);
        }
        return this.mOpenHelper.b().A0(eVar);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            try {
                V call = callable.call();
                setTransactionSuccessful();
                endTransaction();
                return call;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                androidx.room.t.e.a(e3);
                endTransaction();
                return null;
            }
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }
}