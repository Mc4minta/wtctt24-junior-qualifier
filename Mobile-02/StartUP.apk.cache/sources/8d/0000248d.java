package com.coinbase.wallet.libraries.databases.db;

import android.database.Cursor;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.libraries.databases.db.RoomDatabaseProvider;
import com.coinbase.wallet.libraries.databases.db.Storage$perform$1;
import com.coinbase.wallet.libraries.databases.exceptions.DatabaseException;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.libraries.databases.model.DatabaseOperation;
import com.coinbase.wallet.libraries.databases.model.DiskOptions;
import com.coinbase.wallet.libraries.databases.model.MemoryOptions;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.m0.f;
import h.c.m0.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.j;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.a0.z;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.l0.y;
import kotlin.o;
import kotlin.t;

/* compiled from: Database.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b3\u0010%B\u0017\b\u0016\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004¢\u0006\u0004\b3\u00106B\u0017\b\u0016\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007¢\u0006\u0004\b3\u00109J0\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b\b\u0010\tJ<\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0086\b¢\u0006\u0004\b\b\u0010\fJ0\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b\r\u0010\tJ<\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0086\b¢\u0006\u0004\b\r\u0010\fJ0\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b\u000e\u0010\tJ<\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0086\b¢\u0006\u0004\b\u000e\u0010\fJD\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011\"\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014JD\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011\"\u00020\u0003H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0014J*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b\u0017\u0010\tJ/\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011\"\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0014JC\u0010\u001b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001a0\n0\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011\"\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0014J0\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001e\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001cH\u0086\b¢\u0006\u0004\b\u001f\u0010 J8\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001e\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c2\u0006\u0010!\u001a\u00020\u000fH\u0086\b¢\u0006\u0004\b\u001f\u0010\"J\r\u0010$\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b'\u0010(J=\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110)2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0011\"\u00020\u0003H\u0001¢\u0006\u0004\b*\u0010+R6\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0000@BX\u0081.¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010%\u001a\u0004\b0\u00101¨\u0006:"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/libraries/databases/db/RoomDatabaseProvider;", "T", "", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "model", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "add", "(Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;)Lh/c/b0;", "", "models", "(Ljava/util/List;)Lh/c/b0;", "addOrUpdate", "update", "", "query", "", "args", "fetch", "(Ljava/lang/String;[Ljava/lang/Object;)Lh/c/b0;", "fetchOne", "", "delete", "", "count", "", "distinct", "Ljava/lang/Class;", "clazz", "Lh/c/s;", "observe", "(Ljava/lang/Class;)Lh/c/s;", "id", "(Ljava/lang/Class;Ljava/lang/String;)Lh/c/s;", "Lkotlin/x;", "destroy", "()V", "Landroid/database/Cursor;", "reset", "()Landroid/database/Cursor;", "Lkotlin/o;", "buildSQLQuery", "(Ljava/lang/String;[Ljava/lang/Object;)Lkotlin/o;", "Lcom/coinbase/wallet/libraries/databases/db/Storage;", "<set-?>", "storage", "Lcom/coinbase/wallet/libraries/databases/db/Storage;", "getStorage", "()Lcom/coinbase/wallet/libraries/databases/db/Storage;", "getStorage$annotations", "<init>", "Lcom/coinbase/wallet/libraries/databases/model/DiskOptions;", "disk", "(Lcom/coinbase/wallet/libraries/databases/model/DiskOptions;)V", "Lcom/coinbase/wallet/libraries/databases/model/MemoryOptions;", "memory", "(Lcom/coinbase/wallet/libraries/databases/model/MemoryOptions;)V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Database<T extends RoomDatabaseProvider> {
    private Storage<T> storage;

    private Database() {
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;>(TT;)Lh/c/b0<Lcom/coinbase/wallet/core/util/Optional<TT;>;>; */
    public final /* synthetic */ b0 add(DatabaseModelObject model) {
        final List b2;
        m.g(model, "model");
        b2 = q.b(model);
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$add$$inlined$add$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.add(b2);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(b2);
                    if (optional2 instanceof Optional) {
                        optional = optional2;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (optional != null) {
                    emitter.onSuccess(optional);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        m.k();
        b0 doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.libraries.databases.db.Database$add$$inlined$add$2
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<DatabaseModelObject> list = b2;
                Database database = this;
                for (DatabaseModelObject databaseModelObject : list) {
                    Storage storage2 = database.getStorage();
                    Optional optional2 = OptionalKt.toOptional(databaseModelObject);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject2 != null) {
                            m.l(4, "T");
                            synchronized (storage2) {
                                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage2.getObservers();
                                m.l(4, "T");
                                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage2.getObservers();
                                    m.l(4, "T");
                                    observers2.put(DatabaseModelObject.class, bVar);
                                }
                            }
                            t tVar = new t(bVar, Boolean.valueOf(storage2.isDestroyed()), databaseModelObject2);
                            readLock.unlock();
                            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
                            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
                            DatabaseModelObject databaseModelObject3 = (DatabaseModelObject) tVar.c();
                            if (booleanValue) {
                                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                            } else {
                                bVar3.onNext(databaseModelObject3);
                            }
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            }

            @Override // h.c.m0.f
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept((Optional) ((Optional) obj));
            }
        });
        m.f(doAfterSuccess, "T : RoomDatabaseProvider> private constructor() {\n    /**\n     * Manages the data underlying storage.\n     */\n    @PublishedApi\n    internal lateinit var storage: Storage<T>\n        private set\n\n    constructor(disk: DiskOptions<T>) : this() {\n        storage = Storage(disk)\n    }\n\n    constructor(memory: MemoryOptions<T>) : this() {\n        storage = Storage(memory)\n    }\n\n    /**\n     * Adds a new model to the database.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> add(\n        model: T\n    ): Single<Optional<T>> = add(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models to the database.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> add(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.add(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }");
        b0 map = doAfterSuccess.map(new n() { // from class: com.coinbase.wallet.libraries.databases.db.Database$add$1
            public final Optional<T> apply(Optional<? extends List<? extends T>> it) {
                m.g(it, "it");
                List<? extends T> value = it.getValue();
                return OptionalKt.toOptional(value == null ? null : (DatabaseModelObject) p.a0(value));
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "add(listOf(model)).map { it.value?.firstOrNull().toOptional() }");
        return map;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;>(TT;)Lh/c/b0<Lcom/coinbase/wallet/core/util/Optional<TT;>;>; */
    public final /* synthetic */ b0 addOrUpdate(DatabaseModelObject model) {
        final List b2;
        m.g(model, "model");
        b2 = q.b(model);
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$addOrUpdate$$inlined$addOrUpdate$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.addOrUpdate(b2);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(b2);
                    if (optional2 instanceof Optional) {
                        optional = optional2;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (optional != null) {
                    emitter.onSuccess(optional);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        m.k();
        b0 doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.libraries.databases.db.Database$addOrUpdate$$inlined$addOrUpdate$2
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<DatabaseModelObject> list = b2;
                Database database = this;
                for (DatabaseModelObject databaseModelObject : list) {
                    Storage storage2 = database.getStorage();
                    Optional optional2 = OptionalKt.toOptional(databaseModelObject);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject2 != null) {
                            m.l(4, "T");
                            synchronized (storage2) {
                                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage2.getObservers();
                                m.l(4, "T");
                                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage2.getObservers();
                                    m.l(4, "T");
                                    observers2.put(DatabaseModelObject.class, bVar);
                                }
                            }
                            t tVar = new t(bVar, Boolean.valueOf(storage2.isDestroyed()), databaseModelObject2);
                            readLock.unlock();
                            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
                            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
                            DatabaseModelObject databaseModelObject3 = (DatabaseModelObject) tVar.c();
                            if (booleanValue) {
                                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                            } else {
                                bVar3.onNext(databaseModelObject3);
                            }
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            }

            @Override // h.c.m0.f
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept((Optional) ((Optional) obj));
            }
        });
        m.f(doAfterSuccess, "T : RoomDatabaseProvider> private constructor() {\n    /**\n     * Manages the data underlying storage.\n     */\n    @PublishedApi\n    internal lateinit var storage: Storage<T>\n        private set\n\n    constructor(disk: DiskOptions<T>) : this() {\n        storage = Storage(disk)\n    }\n\n    constructor(memory: MemoryOptions<T>) : this() {\n        storage = Storage(memory)\n    }\n\n    /**\n     * Adds a new model to the database.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> add(\n        model: T\n    ): Single<Optional<T>> = add(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models to the database.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> add(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.add(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }\n\n    /**\n     * Adds a new model or update if an existing record is found.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add/update succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        model: T\n    ): Single<Optional<T>> = addOrUpdate(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models or update if existing records are found.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add/update succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.addOrUpdate(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }");
        b0 map = doAfterSuccess.map(new n() { // from class: com.coinbase.wallet.libraries.databases.db.Database$addOrUpdate$1
            public final Optional<T> apply(Optional<? extends List<? extends T>> it) {
                m.g(it, "it");
                List<? extends T> value = it.getValue();
                return OptionalKt.toOptional(value == null ? null : (DatabaseModelObject) p.a0(value));
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "addOrUpdate(listOf(model)).map { it.value?.firstOrNull().toOptional() }");
        return map;
    }

    public final o<String, Object[]> buildSQLQuery(String query, Object... args) {
        List K0;
        int r;
        String h0;
        String h02;
        m.g(query, "query");
        m.g(args, "args");
        ArrayList arrayList = new ArrayList(args.length);
        for (Object obj : args) {
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        if (!(args.length == 0)) {
            int i2 = 0;
            for (int i3 = 0; i3 < query.length(); i3++) {
                if (query.charAt(i3) == '?') {
                    i2++;
                }
            }
            if (i2 == args.length) {
                ArrayList arrayList2 = new ArrayList();
                K0 = y.K0(query, new String[]{"?"}, false, 0, 6, null);
                r = s.r(K0, 10);
                ArrayList arrayList3 = new ArrayList(r);
                int i4 = 0;
                for (Object obj2 : K0) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        r.q();
                    }
                    String str = (String) obj2;
                    Object D = j.D(args, i4);
                    Collection collection = D instanceof Collection ? (Collection) D : null;
                    if (collection == null) {
                        Collection b2 = D != null ? q.b(D) : null;
                        collection = b2 == null ? r.g() : b2;
                    }
                    h02 = z.h0(collection, ",", null, null, 0, null, Database$buildSQLQuery$newQuery$1$placeholders$1.INSTANCE, 30, null);
                    arrayList2.addAll(collection);
                    arrayList3.add(m.o(str, h02));
                    i4 = i5;
                }
                h0 = z.h0(arrayList3, Strings_CoreKt.getEmpty(Strings.INSTANCE), null, null, 0, null, null, 62, null);
                Object[] array2 = arrayList2.toArray(new Object[0]);
                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                return new o<>(h0, array2);
            }
        }
        return new o<>(query, array);
    }

    public final b0<Integer> count(String query, Object... args) {
        m.g(query, "query");
        m.g(args, "args");
        return getStorage().count(query, Arrays.copyOf(args, args.length));
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;>(TT;)Lh/c/b0<Ljava/lang/Boolean;>; */
    public final /* synthetic */ b0 delete(final DatabaseModelObject model) {
        m.g(model, "model");
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$delete$$inlined$perform$1
            @Override // h.c.f0
            public final void subscribe(d0<Boolean> emitter) {
                Lock readLock;
                Boolean valueOf;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.delete(model);
                } catch (Throwable unused) {
                    z = false;
                }
                try {
                    valueOf = Boolean.valueOf(z);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (valueOf != null) {
                    emitter.onSuccess(valueOf);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        return observeOn;
    }

    public final void destroy() {
        getStorage().destroy();
    }

    public final b0<List<Map<String, Object>>> distinct(String query, Object... args) {
        m.g(query, "query");
        m.g(args, "args");
        o<String, Object[]> buildSQLQuery = buildSQLQuery(query, Arrays.copyOf(args, args.length));
        return getStorage().distinct(buildSQLQuery.a(), buildSQLQuery.b());
    }

    public final /* synthetic */ <T extends DatabaseModelObject> b0<List<T>> fetch(final String query, final Object... args) {
        m.g(query, "query");
        m.g(args, "args");
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        m.k();
        b0<List<T>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$fetch$$inlined$perform$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    Database database = this;
                    String str = query;
                    Object[] objArr = args;
                    o<String, Object[]> buildSQLQuery = database.buildSQLQuery(str, Arrays.copyOf(objArr, objArr.length));
                    String a = buildSQLQuery.a();
                    Object[] b2 = buildSQLQuery.b();
                    if (b2.length != 0) {
                        z = false;
                    }
                    if (z) {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a));
                    } else {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a, b2));
                    }
                    if (fetch instanceof List) {
                        list = fetch;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (list != null) {
                    emitter.onSuccess(list);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        return observeOn;
    }

    public final /* synthetic */ <T extends DatabaseModelObject> b0<Optional<T>> fetchOne(final String query, Object... args) {
        m.g(query, "query");
        m.g(args, "args");
        final Object[] copyOf = Arrays.copyOf(args, args.length);
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$fetchOne$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                boolean z = true;
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    Database database = this;
                    String str = query;
                    Object[] objArr = copyOf;
                    o<String, Object[]> buildSQLQuery = database.buildSQLQuery(str, Arrays.copyOf(objArr, objArr.length));
                    String a = buildSQLQuery.a();
                    Object[] b2 = buildSQLQuery.b();
                    if (b2.length != 0) {
                        z = false;
                    }
                    if (z) {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a));
                    } else {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a, b2));
                    }
                    if (fetch instanceof List) {
                        list = fetch;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (list != null) {
                    emitter.onSuccess(list);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        b0<Optional<T>> map = observeOn.map(new n() { // from class: com.coinbase.wallet.libraries.databases.db.Database$fetchOne$1
            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((List) ((List) obj));
            }

            public final Optional<T> apply(List<? extends T> records) {
                m.g(records, "records");
                if (records.size() <= 1) {
                    return OptionalKt.toOptional(p.a0(records));
                }
                throw DatabaseException.MultipleRowsFetched.INSTANCE;
            }
        });
        m.f(map, "fetch<T>(query, *args)\n        .map { records ->\n            if (records.count() > 1) {\n                throw DatabaseException.MultipleRowsFetched\n            }\n\n            records.firstOrNull().toOptional()\n        }");
        return map;
    }

    public final Storage<T> getStorage() {
        Storage<T> storage = this.storage;
        if (storage != null) {
            return storage;
        }
        m.w("storage");
        throw null;
    }

    public final /* synthetic */ <T extends DatabaseModelObject> h.c.s<T> observe(Class<T> clazz) {
        h.c.v0.b<?> bVar;
        h.c.s<T> sVar;
        m.g(clazz, "clazz");
        Storage<T> storage = getStorage();
        ReentrantReadWriteLock.ReadLock readLock = storage.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (storage.isDestroyed()) {
                sVar = h.c.s.error(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                synchronized (storage) {
                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage.getObservers();
                    m.l(4, "T");
                    h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                    bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                    if (bVar == null) {
                        bVar = h.c.v0.b.d();
                        ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage.getObservers();
                        m.l(4, "T");
                        observers2.put(DatabaseModelObject.class, bVar);
                    }
                    l.b(1);
                }
                l.a(1);
                sVar = (h.c.s<T>) bVar.hide();
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

    public final Cursor reset() {
        return getStorage().reset();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;>(TT;)Lh/c/b0<Lcom/coinbase/wallet/core/util/Optional<TT;>;>; */
    public final /* synthetic */ b0 update(DatabaseModelObject model) {
        final List b2;
        m.g(model, "model");
        b2 = q.b(model);
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$update$$inlined$update$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.update(b2);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(b2);
                    if (optional2 instanceof Optional) {
                        optional = optional2;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (optional != null) {
                    emitter.onSuccess(optional);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        m.k();
        b0 doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.libraries.databases.db.Database$update$$inlined$update$2
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<DatabaseModelObject> list = b2;
                Database database = this;
                for (DatabaseModelObject databaseModelObject : list) {
                    Storage storage2 = database.getStorage();
                    Optional optional2 = OptionalKt.toOptional(databaseModelObject);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject2 != null) {
                            m.l(4, "T");
                            synchronized (storage2) {
                                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage2.getObservers();
                                m.l(4, "T");
                                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage2.getObservers();
                                    m.l(4, "T");
                                    observers2.put(DatabaseModelObject.class, bVar);
                                }
                            }
                            t tVar = new t(bVar, Boolean.valueOf(storage2.isDestroyed()), databaseModelObject2);
                            readLock.unlock();
                            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
                            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
                            DatabaseModelObject databaseModelObject3 = (DatabaseModelObject) tVar.c();
                            if (booleanValue) {
                                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                            } else {
                                bVar3.onNext(databaseModelObject3);
                            }
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            }

            @Override // h.c.m0.f
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept((Optional) ((Optional) obj));
            }
        });
        m.f(doAfterSuccess, "T : RoomDatabaseProvider> private constructor() {\n    /**\n     * Manages the data underlying storage.\n     */\n    @PublishedApi\n    internal lateinit var storage: Storage<T>\n        private set\n\n    constructor(disk: DiskOptions<T>) : this() {\n        storage = Storage(disk)\n    }\n\n    constructor(memory: MemoryOptions<T>) : this() {\n        storage = Storage(memory)\n    }\n\n    /**\n     * Adds a new model to the database.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> add(\n        model: T\n    ): Single<Optional<T>> = add(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models to the database.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> add(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.add(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }\n\n    /**\n     * Adds a new model or update if an existing record is found.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add/update succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        model: T\n    ): Single<Optional<T>> = addOrUpdate(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models or update if existing records are found.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add/update succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.addOrUpdate(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }\n\n    /**\n     * Updates the object in the data store.\n     *\n     * @param model The object to update in the database.\n     *\n     * @return A Single representing whether the update succeeded. Succeeds is false if the object is not already\n     *     in the database.\n     */\n    inline fun <reified T : DatabaseModelObject> update(\n        model: T\n    ): Single<Optional<T>> = update(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Updates the objects in the datastore\n     *\n     * @param models The objects to update in the database\n     *\n     * @return A Single representing whether the update succeeded. Succeeds is false if the object is not already\n     *         in the database.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> update(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.update(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }");
        b0 map = doAfterSuccess.map(new n() { // from class: com.coinbase.wallet.libraries.databases.db.Database$update$1
            public final Optional<T> apply(Optional<? extends List<? extends T>> it) {
                m.g(it, "it");
                List<? extends T> value = it.getValue();
                return OptionalKt.toOptional(value == null ? null : (DatabaseModelObject) p.a0(value));
            }

            @Override // h.c.m0.n
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Optional) ((Optional) obj));
            }
        });
        m.f(map, "update(listOf(model)).map { it.value?.firstOrNull().toOptional() }");
        return map;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Database(DiskOptions<T> disk) {
        this();
        m.g(disk, "disk");
        this.storage = new Storage<>(disk);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Database(MemoryOptions<T> memory) {
        this();
        m.g(memory, "memory");
        this.storage = new Storage<>(memory);
    }

    public final /* synthetic */ <T extends DatabaseModelObject> b0<Optional<List<T>>> add(final List<? extends T> models) {
        m.g(models, "models");
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$add$$inlined$perform$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.add(models);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(models);
                    if (optional2 instanceof Optional) {
                        optional = optional2;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (optional != null) {
                    emitter.onSuccess(optional);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        m.k();
        b0<Optional<List<T>>> doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.libraries.databases.db.Database$add$3
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<T> list = models;
                Database<T> database = this;
                for (T t : list) {
                    Storage<T> storage2 = database.getStorage();
                    Optional optional2 = OptionalKt.toOptional(t);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject != null) {
                            m.l(4, "T");
                            synchronized (storage2) {
                                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage2.getObservers();
                                m.l(4, "T");
                                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage2.getObservers();
                                    m.l(4, "T");
                                    observers2.put(DatabaseModelObject.class, bVar);
                                }
                            }
                            t tVar = new t(bVar, Boolean.valueOf(storage2.isDestroyed()), databaseModelObject);
                            readLock.unlock();
                            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
                            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
                            DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) tVar.c();
                            if (booleanValue) {
                                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                            } else {
                                bVar3.onNext(databaseModelObject2);
                            }
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            }

            @Override // h.c.m0.f
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept((Optional) ((Optional) obj));
            }
        });
        m.f(doAfterSuccess, "T : RoomDatabaseProvider> private constructor() {\n    /**\n     * Manages the data underlying storage.\n     */\n    @PublishedApi\n    internal lateinit var storage: Storage<T>\n        private set\n\n    constructor(disk: DiskOptions<T>) : this() {\n        storage = Storage(disk)\n    }\n\n    constructor(memory: MemoryOptions<T>) : this() {\n        storage = Storage(memory)\n    }\n\n    /**\n     * Adds a new model to the database.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> add(\n        model: T\n    ): Single<Optional<T>> = add(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models to the database.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> add(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.add(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }");
        return doAfterSuccess;
    }

    public final /* synthetic */ <T extends DatabaseModelObject> b0<Optional<List<T>>> addOrUpdate(final List<? extends T> models) {
        m.g(models, "models");
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$addOrUpdate$$inlined$perform$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.addOrUpdate(models);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(models);
                    if (optional2 instanceof Optional) {
                        optional = optional2;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (optional != null) {
                    emitter.onSuccess(optional);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        m.k();
        b0<Optional<List<T>>> doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.libraries.databases.db.Database$addOrUpdate$3
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<T> list = models;
                Database<T> database = this;
                for (T t : list) {
                    Storage<T> storage2 = database.getStorage();
                    Optional optional2 = OptionalKt.toOptional(t);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject != null) {
                            m.l(4, "T");
                            synchronized (storage2) {
                                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage2.getObservers();
                                m.l(4, "T");
                                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage2.getObservers();
                                    m.l(4, "T");
                                    observers2.put(DatabaseModelObject.class, bVar);
                                }
                            }
                            t tVar = new t(bVar, Boolean.valueOf(storage2.isDestroyed()), databaseModelObject);
                            readLock.unlock();
                            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
                            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
                            DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) tVar.c();
                            if (booleanValue) {
                                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                            } else {
                                bVar3.onNext(databaseModelObject2);
                            }
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            }

            @Override // h.c.m0.f
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept((Optional) ((Optional) obj));
            }
        });
        m.f(doAfterSuccess, "T : RoomDatabaseProvider> private constructor() {\n    /**\n     * Manages the data underlying storage.\n     */\n    @PublishedApi\n    internal lateinit var storage: Storage<T>\n        private set\n\n    constructor(disk: DiskOptions<T>) : this() {\n        storage = Storage(disk)\n    }\n\n    constructor(memory: MemoryOptions<T>) : this() {\n        storage = Storage(memory)\n    }\n\n    /**\n     * Adds a new model to the database.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> add(\n        model: T\n    ): Single<Optional<T>> = add(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models to the database.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> add(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.add(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }\n\n    /**\n     * Adds a new model or update if an existing record is found.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add/update succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        model: T\n    ): Single<Optional<T>> = addOrUpdate(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models or update if existing records are found.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add/update succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.addOrUpdate(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }");
        return doAfterSuccess;
    }

    public final /* synthetic */ <T extends DatabaseModelObject> b0<Optional<List<T>>> update(final List<? extends T> models) {
        m.g(models, "models");
        final Storage<T> storage = getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        m.k();
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.libraries.databases.db.Database$update$$inlined$perform$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = Storage$perform$1.WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                Map<Class<?>, DatabaseDaoInterface<?>> modelDaos = storage.getModelDaos();
                m.l(4, "T");
                DatabaseDaoInterface<?> databaseDaoInterface = modelDaos.get(Object.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    m.l(4, "T");
                    emitter.onError(new DatabaseException.MissingDao(Object.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.update(models);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(models);
                    if (optional2 instanceof Optional) {
                        optional = optional2;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (optional != null) {
                    emitter.onSuccess(optional);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        m.k();
        b0<Optional<List<T>>> doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.libraries.databases.db.Database$update$3
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<T> list = models;
                Database<T> database = this;
                for (T t : list) {
                    Storage<T> storage2 = database.getStorage();
                    Optional optional2 = OptionalKt.toOptional(t);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject != null) {
                            m.l(4, "T");
                            synchronized (storage2) {
                                ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage2.getObservers();
                                m.l(4, "T");
                                h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage2.getObservers();
                                    m.l(4, "T");
                                    observers2.put(DatabaseModelObject.class, bVar);
                                }
                            }
                            t tVar = new t(bVar, Boolean.valueOf(storage2.isDestroyed()), databaseModelObject);
                            readLock.unlock();
                            h.c.v0.b bVar3 = (h.c.v0.b) tVar.a();
                            boolean booleanValue = ((Boolean) tVar.b()).booleanValue();
                            DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) tVar.c();
                            if (booleanValue) {
                                bVar3.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                            } else {
                                bVar3.onNext(databaseModelObject2);
                            }
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            }

            @Override // h.c.m0.f
            public /* bridge */ /* synthetic */ void accept(Object obj) {
                accept((Optional) ((Optional) obj));
            }
        });
        m.f(doAfterSuccess, "T : RoomDatabaseProvider> private constructor() {\n    /**\n     * Manages the data underlying storage.\n     */\n    @PublishedApi\n    internal lateinit var storage: Storage<T>\n        private set\n\n    constructor(disk: DiskOptions<T>) : this() {\n        storage = Storage(disk)\n    }\n\n    constructor(memory: MemoryOptions<T>) : this() {\n        storage = Storage(memory)\n    }\n\n    /**\n     * Adds a new model to the database.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> add(\n        model: T\n    ): Single<Optional<T>> = add(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models to the database.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> add(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.add(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }\n\n    /**\n     * Adds a new model or update if an existing record is found.\n     *\n     * @param model The model to add to the database.\n     *\n     * @return A Single wrapping an optional model indicating whether the add/update succeeded.\n     */\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        model: T\n    ): Single<Optional<T>> = addOrUpdate(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Adds new models or update if existing records are found.\n     *\n     * @param models The models to add to the database.\n     *\n     * @return A Single wrapping an optional list of models indicating whether the add/update succeeded.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> addOrUpdate(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.addOrUpdate(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }\n\n    /**\n     * Updates the object in the data store.\n     *\n     * @param model The object to update in the database.\n     *\n     * @return A Single representing whether the update succeeded. Succeeds is false if the object is not already\n     *     in the database.\n     */\n    inline fun <reified T : DatabaseModelObject> update(\n        model: T\n    ): Single<Optional<T>> = update(listOf(model)).map { it.value?.firstOrNull().toOptional() }\n\n    /**\n     * Updates the objects in the datastore\n     *\n     * @param models The objects to update in the database\n     *\n     * @return A Single representing whether the update succeeded. Succeeds is false if the object is not already\n     *         in the database.\n     */\n    @Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T : DatabaseModelObject> update(\n        models: List<T>\n    ): Single<Optional<List<T>>> = storage\n        .perform<T, Optional<List<T>>>(DatabaseOperation.WRITE) { dao ->\n            dao.update(models)\n\n            models.toOptional()\n        }\n        .doAfterSuccess { models.forEach { storage.notifyObservers(it.toOptional()) } }");
        return doAfterSuccess;
    }

    public final /* synthetic */ <T extends DatabaseModelObject> h.c.s<T> observe(Class<T> clazz, final String id) {
        h.c.v0.b<?> bVar;
        h.c.s<?> hide;
        m.g(clazz, "clazz");
        m.g(id, "id");
        Storage<T> storage = getStorage();
        ReentrantReadWriteLock.ReadLock readLock = storage.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (storage.isDestroyed()) {
                hide = h.c.s.error(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                synchronized (storage) {
                    ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers = storage.getObservers();
                    m.l(4, "T");
                    h.c.v0.b<?> bVar2 = observers.get(DatabaseModelObject.class);
                    bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                    if (bVar == null) {
                        bVar = h.c.v0.b.d();
                        ConcurrentHashMap<Class<?>, h.c.v0.b<?>> observers2 = storage.getObservers();
                        m.l(4, "T");
                        observers2.put(DatabaseModelObject.class, bVar);
                    }
                    l.b(1);
                }
                l.a(1);
                hide = bVar.hide();
            }
            l.b(1);
            readLock.unlock();
            l.a(1);
            m.f(hide, "multiReadSingleWriteLock.read {\n        if (isDestroyed) {\n            return@read Observable.error(DatabaseException.DatabaseDestroyed)\n        }\n\n        getOrCreateSubject(clazz).hide()\n    }");
            h.c.s<T> sVar = (h.c.s<T>) hide.filter(new h.c.m0.p() { // from class: com.coinbase.wallet.libraries.databases.db.Database$observe$1
                /* JADX WARN: Incorrect types in method signature: (TT;)Z */
                @Override // h.c.m0.p
                public final boolean test(DatabaseModelObject it) {
                    m.g(it, "it");
                    return m.c(it.getId(), id);
                }
            });
            m.f(sVar, "id: String\n    ): Observable<T> = observe(clazz).filter { it.id == id }");
            return sVar;
        } catch (Throwable th) {
            l.b(1);
            readLock.unlock();
            l.a(1);
            throw th;
        }
    }
}