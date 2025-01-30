package com.coinbase.wallet.consumer.daos;

import com.coinbase.wallet.consumer.exceptions.ConsumerException;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.db.Storage;
import com.coinbase.wallet.libraries.databases.exceptions.DatabaseException;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.libraries.databases.model.DatabaseOperation;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.h0;
import h.c.m0.n;
import h.c.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;

/* compiled from: ConsumerAvailablePaymentMethodsDAO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\b\u0010\u0006J'\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\f¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "", "Lh/c/b0;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "getPaymentMethods", "()Lh/c/b0;", "Lkotlin/x;", "deleteAll", "availablePaymentMethods", "save", "(Ljava/util/List;)Lh/c/b0;", "Lh/c/s;", "observeAvailablePaymentMethods", "()Lh/c/s;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "db", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "<init>", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsDAO {
    private final Database<?> db;

    public ConsumerAvailablePaymentMethodsDAO(Database<?> db) {
        m.g(db, "db");
        this.db = db;
    }

    public static /* synthetic */ h0 a(ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO, List list) {
        return m855deleteAll$lambda1(consumerAvailablePaymentMethodsDAO, list);
    }

    public static /* synthetic */ List b(Optional optional) {
        return m857save$lambda2(optional);
    }

    public static /* synthetic */ x c(ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO, ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
        return m856observeAvailablePaymentMethods$lambda3(consumerAvailablePaymentMethodsDAO, consumerAvailablePaymentMethod);
    }

    /* renamed from: deleteAll$lambda-1 */
    public static final h0 m855deleteAll$lambda1(ConsumerAvailablePaymentMethodsDAO this$0, List records) {
        int r;
        List g2;
        m.g(this$0, "this$0");
        m.g(records, "records");
        r = s.r(records, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = records.iterator();
        while (it.hasNext()) {
            final ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod = (ConsumerAvailablePaymentMethod) it.next();
            final Storage<?> storage = this$0.db.getStorage();
            final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
            b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO$deleteAll$lambda-1$lambda-0$$inlined$delete$1
                @Override // h.c.f0
                public final void subscribe(d0<Boolean> emitter) {
                    Lock readLock;
                    m.g(emitter, "emitter");
                    int i2 = ConsumerAvailablePaymentMethodsDAO$deleteAll$lambda1$lambda0$$inlined$delete$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                    DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(ConsumerAvailablePaymentMethod.class);
                    DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                    if (databaseDaoInterface2 == null) {
                        emitter.onError(new DatabaseException.MissingDao(ConsumerAvailablePaymentMethod.class));
                        return;
                    }
                    readLock.lock();
                    if (storage.isDestroyed()) {
                        readLock.unlock();
                        emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                        return;
                    }
                    try {
                        databaseDaoInterface2.delete(consumerAvailablePaymentMethod);
                    } catch (Throwable unused) {
                        z = false;
                    }
                    try {
                        emitter.onSuccess(Boolean.valueOf(z));
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
            m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
            arrayList.add(observeOn);
        }
        h.c.t0.e eVar = h.c.t0.e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            b0 just = b0.just(g2);
            m.f(just, "just(emptyList())");
            return just;
        }
        b0 zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO$deleteAll$lambda-1$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it2) {
                List<T> g3;
                m.g(it2, "it");
                if (it2.length == 0) {
                    g3 = r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : it2) {
                    if (obj instanceof Boolean) {
                        arrayList2.add(obj);
                    }
                }
                return arrayList2;
            }
        });
        m.f(zip, "zip(singles) { if (it.isEmpty()) emptyList() else it.filterIsInstance<T>() }");
        return zip;
    }

    private final b0<List<ConsumerAvailablePaymentMethod>> getPaymentMethods() {
        final Database<?> database = this.db;
        final Object[] objArr = new Object[0];
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0<List<ConsumerAvailablePaymentMethod>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO$getPaymentMethods$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = ConsumerAvailablePaymentMethodsDAO$getPaymentMethods$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(ConsumerAvailablePaymentMethod.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(ConsumerAvailablePaymentMethod.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    Database database2 = database;
                    String str = r4;
                    Object[] objArr2 = objArr;
                    o<String, Object[]> buildSQLQuery = database2.buildSQLQuery(str, Arrays.copyOf(objArr2, objArr2.length));
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

    /* renamed from: observeAvailablePaymentMethods$lambda-3 */
    public static final x m856observeAvailablePaymentMethods$lambda3(ConsumerAvailablePaymentMethodsDAO this$0, ConsumerAvailablePaymentMethod it) {
        m.g(this$0, "this$0");
        m.g(it, "it");
        return this$0.getPaymentMethods().toObservable();
    }

    /* renamed from: save$lambda-2 */
    public static final List m857save$lambda2(Optional it) {
        m.g(it, "it");
        List list = (List) it.toNullable();
        if (list != null) {
            return list;
        }
        throw new ConsumerException.UnableToSaveConsumerAccount("Couldn't save consumer paymentMethods");
    }

    public final b0<kotlin.x> deleteAll() {
        final Database<?> database = this.db;
        final Object[] objArr = new Object[0];
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO$deleteAll$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = ConsumerAvailablePaymentMethodsDAO$deleteAll$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(ConsumerAvailablePaymentMethod.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(ConsumerAvailablePaymentMethod.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    Database database2 = database;
                    String str = r4;
                    Object[] objArr2 = objArr;
                    o<String, Object[]> buildSQLQuery = database2.buildSQLQuery(str, Arrays.copyOf(objArr2, objArr2.length));
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
        b0 flatMap = observeOn.flatMap(new n() { // from class: com.coinbase.wallet.consumer.daos.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAvailablePaymentMethodsDAO.a(ConsumerAvailablePaymentMethodsDAO.this, (List) obj);
            }
        });
        m.f(flatMap, "db.fetch<ConsumerAvailablePaymentMethod>(query)\n            .flatMap { records -> records.map { db.delete(it) }.zipOrEmpty() }");
        return Single_CoreKt.asUnit(flatMap);
    }

    public final h.c.s<List<ConsumerAvailablePaymentMethod>> observeAvailablePaymentMethods() {
        h.c.v0.b<?> bVar;
        h.c.s<?> hide;
        Storage<?> storage = this.db.getStorage();
        ReentrantReadWriteLock.ReadLock readLock = storage.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (storage.isDestroyed()) {
                hide = h.c.s.error(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                synchronized (storage) {
                    h.c.v0.b<?> bVar2 = storage.getObservers().get(ConsumerAvailablePaymentMethod.class);
                    bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                    if (bVar == null) {
                        bVar = h.c.v0.b.d();
                        storage.getObservers().put(ConsumerAvailablePaymentMethod.class, bVar);
                    }
                }
                hide = bVar.hide();
            }
            readLock.unlock();
            m.f(hide, "multiReadSingleWriteLock.read {\n        if (isDestroyed) {\n            return@read Observable.error(DatabaseException.DatabaseDestroyed)\n        }\n\n        getOrCreateSubject(clazz).hide()\n    }");
            h.c.s<List<ConsumerAvailablePaymentMethod>> distinctUntilChanged = h.c.s.merge(getPaymentMethods().toObservable(), hide.throttleLast(500L, TimeUnit.MILLISECONDS).flatMap(new n() { // from class: com.coinbase.wallet.consumer.daos.f
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return ConsumerAvailablePaymentMethodsDAO.c(ConsumerAvailablePaymentMethodsDAO.this, (ConsumerAvailablePaymentMethod) obj);
                }
            }).distinctUntilChanged()).distinctUntilChanged();
            m.f(distinctUntilChanged, "merge(getPaymentMethods().toObservable(), continuousObserver)\n            .distinctUntilChanged()");
            return distinctUntilChanged;
        } catch (Throwable th) {
            readLock.unlock();
            throw th;
        }
    }

    public final b0<List<ConsumerAvailablePaymentMethod>> save(final List<ConsumerAvailablePaymentMethod> availablePaymentMethods) {
        m.g(availablePaymentMethods, "availablePaymentMethods");
        final Database<?> database = this.db;
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO$save$$inlined$addOrUpdate$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = ConsumerAvailablePaymentMethodsDAO$save$$inlined$addOrUpdate$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(ConsumerAvailablePaymentMethod.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(ConsumerAvailablePaymentMethod.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.addOrUpdate(availablePaymentMethods);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(availablePaymentMethods);
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
        b0 doAfterSuccess = observeOn.doAfterSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO$save$$inlined$addOrUpdate$2
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<DatabaseModelObject> list = availablePaymentMethods;
                Database database2 = database;
                for (DatabaseModelObject databaseModelObject : list) {
                    Storage storage2 = database2.getStorage();
                    Optional optional2 = OptionalKt.toOptional(databaseModelObject);
                    ReentrantReadWriteLock.ReadLock readLock = storage2.getMultiReadSingleWriteLock().readLock();
                    readLock.lock();
                    try {
                        DatabaseModelObject databaseModelObject2 = (DatabaseModelObject) optional2.toNullable();
                        if (databaseModelObject2 != null) {
                            synchronized (storage2) {
                                h.c.v0.b<?> bVar2 = storage2.getObservers().get(ConsumerAvailablePaymentMethod.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    storage2.getObservers().put(ConsumerAvailablePaymentMethod.class, bVar);
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
        b0<List<ConsumerAvailablePaymentMethod>> map = doAfterSuccess.map(new n() { // from class: com.coinbase.wallet.consumer.daos.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return ConsumerAvailablePaymentMethodsDAO.b((Optional) obj);
            }
        });
        m.f(map, "db.addOrUpdate(models = availablePaymentMethods)\n            .map {\n                it.toNullable()\n                    ?: throw ConsumerException.UnableToSaveConsumerAccount(\"Couldn't save consumer paymentMethods\")\n            }");
        return map;
    }
}