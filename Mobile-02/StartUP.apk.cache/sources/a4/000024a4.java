package com.coinbase.wallet.libraries.databases.db;

import android.database.Cursor;
import androidx.room.i;
import androidx.room.j;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.RxSchedulers;
import com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider;
import com.coinbase.wallet.libraries.databases.exceptions.DatabaseException;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.libraries.databases.interfaces.StorageOptions;
import com.coinbase.wallet.libraries.databases.model.DatabaseOperation;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.libraries.databases.model.MemoryOptions;
import h.c.a0;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.t;
import kotlin.x;

/* compiled from: Storage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\bH\u0010'B\u0017\b\u0016\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000I¢\u0006\u0004\bH\u0010KB\u0017\b\u0016\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000L¢\u0006\u0004\bH\u0010NJM\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\"\u0006\b\u0001\u0010\u0004\u0018\u0001\"\u0006\b\u0002\u0010\u0005\u0018\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u001a\b\u0004\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00028\u00020\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0010\"\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0017\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00160\u00150\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0004\b\u0017\u0010\u0014J0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0086\b¢\u0006\u0004\b\u001c\u0010\u001dJ*\u0010!\u001a\u00020 \"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0086\b¢\u0006\u0004\b!\u0010\"J0\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0086\b¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020 ¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b)\u0010*R$\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020+8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104RL\u00105\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00162\u001a\u0010,\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00168\u0006@BX\u0086.¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u0010:\u001a\u0002098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010?\u001a\u00020>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR-\u0010D\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\b\u0012\u0006\u0012\u0002\b\u00030#0C8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006O"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/db/Storage;", "Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "P", "", "T", "R", "Lcom/coinbase/wallet/libraries/databases/model/DatabaseOperation;", "operation", "Lkotlin/Function1;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseDaoInterface;", "work", "Lh/c/b0;", "perform", "(Lcom/coinbase/wallet/libraries/databases/model/DatabaseOperation;Lkotlin/e0/c/l;)Lh/c/b0;", "", "query", "", "args", "", "count", "(Ljava/lang/String;[Ljava/lang/Object;)Lh/c/b0;", "", "", "distinct", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "Ljava/lang/Class;", "clazz", "Lh/c/s;", "observe", "(Ljava/lang/Class;)Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "record", "Lkotlin/x;", "notifyObservers", "(Lcom/coinbase/wallet/core/util/Optional;)V", "Lh/c/v0/b;", "getOrCreateSubject", "(Ljava/lang/Class;)Lh/c/v0/b;", "destroy", "()V", "Landroid/database/Cursor;", "reset", "()Landroid/database/Cursor;", "", "<set-?>", "isDestroyed", "Z", "()Z", "Lcom/coinbase/wallet/libraries/databases/interfaces/StorageOptions;", "options", "Lcom/coinbase/wallet/libraries/databases/interfaces/StorageOptions;", "provider", "Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "modelDaos", "Ljava/util/Map;", "getModelDaos", "()Ljava/util/Map;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "multiReadSingleWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getMultiReadSingleWriteLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Lh/c/a0;", "scheduler", "Lh/c/a0;", "getScheduler", "()Lh/c/a0;", "Ljava/util/concurrent/ConcurrentHashMap;", "observers", "Ljava/util/concurrent/ConcurrentHashMap;", "getObservers", "()Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "Lcom/coinbase/wallet/libraries/databases/model/DiskOptions;", "disk", "(Lcom/coinbase/wallet/libraries/databases/model/DiskOptions;)V", "Lcom/coinbase/wallet/libraries/databases/model/MemoryOptions;", "memory", "(Lcom/coinbase/wallet/libraries/databases/model/MemoryOptions;)V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Storage<P extends RoomDatabaseProvider> {
    private boolean isDestroyed;
    private Map<Class<?>, ? extends DatabaseDaoInterface<?>> modelDaos;
    private final ReentrantReadWriteLock multiReadSingleWriteLock;
    private final ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers;
    private StorageOptions options;
    private RoomDatabaseProvider provider;
    private final a0 scheduler;

    private Storage() {
        this.observers = new ConcurrentHashMap<>();
        this.multiReadSingleWriteLock = new ReentrantReadWriteLock();
        this.scheduler = RxSchedulers.INSTANCE.newFixedThreadPool(64);
    }

    public static /* synthetic */ void a(Storage storage, String str, Object[] objArr, d0 d0Var) {
        m1610distinct$lambda5(storage, str, objArr, d0Var);
    }

    public static /* synthetic */ void b(Storage storage, String str, Object[] objArr, d0 d0Var) {
        m1609count$lambda2(storage, str, objArr, d0Var);
    }

    /* renamed from: count$lambda-2 */
    public static final void m1609count$lambda2(Storage this$0, String query, Object[] args, d0 emitter) {
        m.g(this$0, "this$0");
        m.g(query, "$query");
        m.g(args, "$args");
        m.g(emitter, "emitter");
        ReentrantReadWriteLock.ReadLock readLock = this$0.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (this$0.isDestroyed()) {
                emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                RoomDatabaseProvider roomDatabaseProvider = this$0.provider;
                if (roomDatabaseProvider != null) {
                    Cursor query2 = roomDatabaseProvider.query(new c.r.a.a(query, args));
                    m.f(query2, "provider.query(SimpleSQLiteQuery(query, args))");
                    int i2 = 0;
                    if (query2.getCount() != 0) {
                        query2.moveToNext();
                        i2 = query2.getInt(0);
                    }
                    emitter.onSuccess(Integer.valueOf(i2));
                } else {
                    m.w("provider");
                    throw null;
                }
            }
            x xVar = x.a;
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: distinct$lambda-5 */
    public static final void m1610distinct$lambda5(Storage this$0, String query, Object[] args, d0 emitter) {
        List list;
        Object obj;
        m.g(this$0, "this$0");
        m.g(query, "$query");
        m.g(args, "$args");
        m.g(emitter, "emitter");
        ReentrantReadWriteLock.ReadLock readLock = this$0.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (this$0.isDestroyed()) {
                emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                RoomDatabaseProvider roomDatabaseProvider = this$0.provider;
                if (roomDatabaseProvider != null) {
                    Cursor query2 = roomDatabaseProvider.query(new c.r.a.a(query, args));
                    m.f(query2, "provider.query(SimpleSQLiteQuery(query, args))");
                    if (query2.getCount() == 0) {
                        list = r.g();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        while (query2.moveToNext()) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            int i2 = 0;
                            int columnCount = query2.getColumnCount();
                            if (columnCount > 0) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (query2.isNull(i2)) {
                                        String str = query2.getColumnNames()[i2];
                                        m.f(str, "cursor.columnNames[i]");
                                        linkedHashMap.put(str, null);
                                    } else {
                                        int type = query2.getType(i2);
                                        if (type == 0) {
                                            obj = null;
                                        } else if (type == 1) {
                                            obj = Integer.valueOf(query2.getInt(i2));
                                        } else if (type == 2) {
                                            obj = Float.valueOf(query2.getFloat(i2));
                                        } else if (type == 3) {
                                            obj = query2.getString(i2);
                                        } else if (type == 4) {
                                            obj = (Serializable) query2.getBlob(i2);
                                        } else {
                                            throw new IllegalStateException(m.o("Unknown type ", Integer.valueOf(query2.getType(i2))));
                                        }
                                        String str2 = query2.getColumnNames()[i2];
                                        m.f(str2, "cursor.columnNames[i]");
                                        linkedHashMap.put(str2, obj);
                                    }
                                    if (i3 >= columnCount) {
                                        break;
                                    }
                                    i2 = i3;
                                }
                            }
                            arrayList.add(linkedHashMap);
                        }
                        list = arrayList;
                    }
                    emitter.onSuccess(list);
                } else {
                    m.w("provider");
                    throw null;
                }
            }
            x xVar = x.a;
        } finally {
            readLock.unlock();
        }
    }

    public final b0<Integer> count(final String query, final Object... args) {
        m.g(query, "query");
        m.g(args, "args");
        b0<Integer> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.b
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                Storage.b(Storage.this, query, args, d0Var);
            }
        }).subscribeOn(this.scheduler).observeOn(this.scheduler);
        m.f(observeOn, "create<Int> { emitter ->\n            multiReadSingleWriteLock.read {\n                if (isDestroyed) {\n                    return@read emitter.onError(DatabaseException.DatabaseDestroyed)\n                }\n\n                try {\n                    val cursor = provider.query(SimpleSQLiteQuery(query, args))\n                    val result = if (cursor.count == 0) {\n                        0\n                    } else {\n                        cursor.moveToNext()\n                        cursor.getInt(0)\n                    }\n\n                    emitter.onSuccess(result)\n                } catch (err: Throwable) {\n                    emitter.onError(err)\n                }\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        return observeOn;
    }

    public final void destroy() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.multiReadSingleWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (!isDestroyed()) {
                this.isDestroyed = true;
                reset();
            }
            x xVar = x.a;
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    public final b0<List<Map<String, Object>>> distinct(final String query, final Object[] args) {
        m.g(query, "query");
        m.g(args, "args");
        b0<List<Map<String, Object>>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.a
            @Override // h.c.f0
            public final void subscribe(d0 d0Var) {
                Storage.a(Storage.this, query, args, d0Var);
            }
        }).subscribeOn(this.scheduler).observeOn(this.scheduler);
        m.f(observeOn, "create<List<Map<String, Any?>>> { emitter ->\n                multiReadSingleWriteLock.read {\n                    if (isDestroyed) {\n                        return@read emitter.onError(DatabaseException.DatabaseDestroyed)\n                    }\n\n                    try {\n                        val cursor = provider.query(SimpleSQLiteQuery(query, args))\n                        val results: List<Map<String, Any?>> = if (cursor.count == 0) {\n                            emptyList()\n                        } else {\n                            mutableListOf<Map<String, Any?>>().apply {\n                                while (cursor.moveToNext()) {\n                                    val columnResults = mutableMapOf<String, Any?>()\n                                    for (i in 0 until cursor.columnCount) {\n                                        if (cursor.isNull(i)) {\n                                            columnResults[cursor.columnNames[i]] = null\n                                            continue\n                                        }\n\n                                        val columnValue = when (cursor.getType(i)) {\n                                            Cursor.FIELD_TYPE_NULL -> null\n                                            Cursor.FIELD_TYPE_INTEGER -> cursor.getInt(i)\n                                            Cursor.FIELD_TYPE_FLOAT -> cursor.getFloat(i)\n                                            Cursor.FIELD_TYPE_STRING -> cursor.getString(i)\n                                            Cursor.FIELD_TYPE_BLOB -> cursor.getBlob(i)\n                                            else -> throw IllegalStateException(\"Unknown type ${cursor.getType(i)}\")\n                                        }\n\n                                        columnResults[cursor.columnNames[i]] = columnValue\n                                    }\n                                    add(columnResults)\n                                }\n                            }\n                        }\n\n                        emitter.onSuccess(results)\n                    } catch (err: Throwable) {\n                        emitter.onError(err)\n                    }\n                }\n            }\n            .subscribeOn(scheduler)\n            .observeOn(scheduler)");
        return observeOn;
    }

    public final Map<Class<?>, DatabaseDaoInterface<?>> getModelDaos() {
        Map map = this.modelDaos;
        if (map != null) {
            return map;
        }
        m.w("modelDaos");
        throw null;
    }

    public final ReentrantReadWriteLock getMultiReadSingleWriteLock() {
        return this.multiReadSingleWriteLock;
    }

    public final ConcurrentHashMap<Class<?>, h.c.v0.b<?>> getObservers() {
        return this.observers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T extends DatabaseModelObject> h.c.v0.b<T> getOrCreateSubject(Class<T> clazz) {
        h.c.v0.b bVar;
        m.g(clazz, "clazz");
        synchronized (this) {
            try {
                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = getObservers();
                m.l(4, "T");
                h.c.v0.b bVar2 = observers.get(DatabaseModelObject.class);
                bVar = bVar2 instanceof h.c.v0.b ? (h.c.v0.b<T>) bVar2 : null;
                if (bVar == null) {
                    bVar = (h.c.v0.b<T>) h.c.v0.b.d();
                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = getObservers();
                    m.l(4, "T");
                    observers2.put(DatabaseModelObject.class, bVar);
                }
                l.b(1);
            } catch (Throwable th) {
                l.b(1);
                l.a(1);
                throw th;
            }
        }
        l.a(1);
        return (h.c.v0.b<T>) bVar;
    }

    public final a0 getScheduler() {
        return this.scheduler;
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    public final /* synthetic */ <T extends DatabaseModelObject> void notifyObservers(Optional<? extends T> record) {
        h.c.v0.b<?> bVar;
        m.g(record, "record");
        ReentrantReadWriteLock.ReadLock readLock = getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            T nullable = record.toNullable();
            if (nullable == null) {
                l.b(2);
                readLock.unlock();
                l.a(2);
                return;
            }
            m.l(4, "T");
            synchronized (this) {
                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = getObservers();
                m.l(4, "T");
                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                if (bVar == null) {
                    bVar = h.c.v0.b.d();
                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = getObservers();
                    m.l(4, "T");
                    observers2.put(DatabaseModelObject.class, bVar);
                }
                l.b(1);
            }
            l.a(1);
            t tVar = new t(bVar, Boolean.valueOf(isDestroyed()), nullable);
            l.b(1);
            readLock.unlock();
            l.a(1);
            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
            DatabaseModelObject databaseModelObject = (DatabaseModelObject) tVar.c();
            if (booleanValue) {
                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                bVar3.onNext(databaseModelObject);
            }
        } catch (Throwable th) {
            l.b(1);
            readLock.unlock();
            l.a(1);
            throw th;
        }
    }

    public final /* synthetic */ <T extends DatabaseModelObject> s<T> observe(Class<T> clazz) {
        h.c.v0.b<?> bVar;
        s<T> sVar;
        m.g(clazz, "clazz");
        ReentrantReadWriteLock.ReadLock readLock = getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (isDestroyed()) {
                sVar = s.error(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                synchronized (this) {
                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = getObservers();
                    m.l(4, "T");
                    h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                    bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                    if (bVar == null) {
                        bVar = h.c.v0.b.d();
                        ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = getObservers();
                        m.l(4, "T");
                        observers2.put(DatabaseModelObject.class, bVar);
                    }
                    l.b(1);
                }
                l.a(1);
                sVar = (s<T>) bVar.hide();
            }
            l.b(1);
            readLock.unlock();
            l.a(1);
            m.f(sVar, "multiReadSingleWriteLock.read {\n        if (isDestroyed) {\n            return@read Observable.error(DatabaseException.DatabaseDestroyed)\n        }\n\n        getOrCreateSubject(clazz).hide()\n    }");
            return sVar;
        } catch (Throwable th) {
            l.b(1);
            readLock.unlock();
            l.a(1);
            throw th;
        }
    }

    public final /* synthetic */ <T, R> b0<R> perform(final DatabaseOperation operation, final kotlin.e0.c.l<? super DatabaseDaoInterface<T>, ? extends R> work) {
        m.g(operation, "operation");
        m.g(work, "work");
        m.k();
        b0 b0Var = (b0<T>) b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Storage$perform$1

            /* compiled from: Storage.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[DatabaseOperation.values().length];
                    iArr[DatabaseOperation.READ.ordinal()] = 1;
                    iArr[DatabaseOperation.WRITE.ordinal()] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // h.c.f0
            public final void subscribe(d0<R> emitter) {
                Lock readLock;
                Object invoke;
                m.g(emitter, "emitter");
                int i2 = WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = this.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = this.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = this.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (this.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    invoke = work.invoke(databaseDaoInterface2);
                    m.l(2, "R");
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (invoke != null) {
                    emitter.onSuccess(invoke);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(getScheduler()).observeOn(getScheduler());
        m.f(b0Var, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        return b0Var;
    }

    public final Cursor reset() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.multiReadSingleWriteLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            RoomDatabaseProvider roomDatabaseProvider = this.provider;
            Cursor cursor = null;
            if (roomDatabaseProvider != null) {
                roomDatabaseProvider.beginTransaction();
                RoomDatabaseProvider roomDatabaseProvider2 = this.provider;
                if (roomDatabaseProvider2 != null) {
                    roomDatabaseProvider2.clearAllTables();
                    RoomDatabaseProvider roomDatabaseProvider3 = this.provider;
                    if (roomDatabaseProvider3 != null) {
                        roomDatabaseProvider3.setTransactionSuccessful();
                        RoomDatabaseProvider roomDatabaseProvider4 = this.provider;
                        if (roomDatabaseProvider4 != null) {
                            roomDatabaseProvider4.endTransaction();
                            StorageOptions storageOptions = this.options;
                            if (storageOptions == null) {
                                m.w("options");
                                throw null;
                            }
                            if ((storageOptions instanceof DiskOptions ? (DiskOptions) storageOptions : null) != null) {
                                RoomDatabaseProvider roomDatabaseProvider5 = this.provider;
                                if (roomDatabaseProvider5 == null) {
                                    m.w("provider");
                                    throw null;
                                }
                                cursor = roomDatabaseProvider5.query(new c.r.a.a("pragma wal_checkpoint(full)"));
                            }
                            return cursor;
                        }
                        m.w("provider");
                        throw null;
                    }
                    m.w("provider");
                    throw null;
                }
                m.w("provider");
                throw null;
            }
            m.w("provider");
            throw null;
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Storage(DiskOptions<P> disk) {
        this();
        m.g(disk, "disk");
        j.a a = i.a(disk.getContext(), disk.getProviderClass(), disk.getDbName());
        m.f(a, "databaseBuilder(disk.context, disk.providerClass, disk.dbName)");
        Iterator<T> it = disk.getMigrations().iterator();
        while (it.hasNext()) {
            a.a((androidx.room.s.a) it.next());
        }
        if (disk.getDestructiveFallback()) {
            a.c();
        }
        j b2 = a.b();
        m.f(b2, "builder.build()");
        RoomDatabaseProvider roomDatabaseProvider = (RoomDatabaseProvider) b2;
        this.provider = roomDatabaseProvider;
        if (roomDatabaseProvider != null) {
            this.modelDaos = roomDatabaseProvider.modelMappings();
            this.options = disk;
            return;
        }
        m.w("provider");
        throw null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Storage(MemoryOptions<P> memory) {
        this();
        m.g(memory, "memory");
        j b2 = i.c(memory.getContext(), memory.getProviderClazz()).b();
        m.f(b2, "inMemoryDatabaseBuilder(memory.context, memory.providerClazz).build()");
        RoomDatabaseProvider roomDatabaseProvider = (RoomDatabaseProvider) b2;
        this.provider = roomDatabaseProvider;
        if (roomDatabaseProvider != null) {
            this.modelDaos = roomDatabaseProvider.modelMappings();
            this.options = memory;
            return;
        }
        m.w("provider");
        throw null;
    }
}