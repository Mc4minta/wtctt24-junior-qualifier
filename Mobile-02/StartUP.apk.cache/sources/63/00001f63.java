package com.coinbase.wallet.features.send.daos;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.core.extensions.Single_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.features.send.models.Recipient;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.db.Storage;
import com.coinbase.wallet.libraries.databases.exceptions.DatabaseException;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.libraries.databases.model.DatabaseOperation;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.models.RecipientType;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.h0;
import h.c.m0.f;
import h.c.m0.n;
import h.c.t0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.p;
import kotlin.a0.r;
import kotlin.a0.s;
import kotlin.jvm.internal.m;
import kotlin.l0.q;
import kotlin.o;
import kotlin.t;
import kotlin.u;
import kotlin.x;

/* compiled from: RecipientDao.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!¢\u0006\u0004\b$\u0010%J!\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019JU\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u0006\u0012\u0002\b\u00030!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/coinbase/wallet/features/send/daos/RecipientDao;", "", "Lcom/coinbase/wallet/features/send/models/Recipient;", "recipient", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "save", "(Lcom/coinbase/wallet/features/send/models/Recipient;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Blockchain;", RouteActionKey.RouteActionKeys.BLOCKCHAIN, "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "getRecipients", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "recipientType", "Lkotlin/x;", "deleteRecipients", "(Lcom/coinbase/wallet/txhistory/models/RecipientType;)Lh/c/b0;", "type", "", "hasRecipient", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/txhistory/models/RecipientType;)Lh/c/b0;", "", "destination", "Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;", "metadataKey", SendConfirmationArgs.metadataKey, "getRecipient", "(Lcom/coinbase/wallet/blockchains/models/Blockchain;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/TxMetadataKey;Ljava/lang/String;)Lh/c/b0;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "database", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "<init>", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecipientDao {
    private final Database<?> database;

    public RecipientDao(Database<?> database) {
        m.g(database, "database");
        this.database = database;
    }

    public static /* synthetic */ h0 a(RecipientDao recipientDao, List list) {
        return m1330deleteRecipients$lambda1(recipientDao, list);
    }

    public static /* synthetic */ Boolean b(Integer num) {
        return m1331hasRecipient$lambda2(num);
    }

    /* renamed from: deleteRecipients$lambda-1 */
    public static final h0 m1330deleteRecipients$lambda1(RecipientDao this$0, List records) {
        int r;
        List g2;
        m.g(this$0, "this$0");
        m.g(records, "records");
        r = s.r(records, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = records.iterator();
        while (it.hasNext()) {
            final Recipient recipient = (Recipient) it.next();
            final Storage<?> storage = this$0.database.getStorage();
            final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
            b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$deleteRecipients$lambda-1$lambda-0$$inlined$delete$1
                @Override // h.c.f0
                public final void subscribe(d0<Boolean> emitter) {
                    Lock readLock;
                    m.g(emitter, "emitter");
                    int i2 = RecipientDao$deleteRecipients$lambda1$lambda0$$inlined$delete$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                    DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Recipient.class);
                    DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                    if (databaseDaoInterface2 == null) {
                        emitter.onError(new DatabaseException.MissingDao(Recipient.class));
                        return;
                    }
                    readLock.lock();
                    if (storage.isDestroyed()) {
                        readLock.unlock();
                        emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                        return;
                    }
                    try {
                        databaseDaoInterface2.delete(recipient);
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
        e eVar = e.a;
        if (arrayList.isEmpty()) {
            g2 = r.g();
            b0 just = b0.just(g2);
            m.f(just, "just(emptyList())");
            return just;
        }
        b0 zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$deleteRecipients$lambda-1$$inlined$zipOrEmpty$1
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

    /* renamed from: hasRecipient$lambda-2 */
    public static final Boolean m1331hasRecipient$lambda2(Integer it) {
        m.g(it, "it");
        return Boolean.valueOf(it.intValue() > 0);
    }

    public final b0<x> deleteRecipients(RecipientType recipientType) {
        m.g(recipientType, "recipientType");
        final Database<?> database = this.database;
        final Object[] objArr = {Integer.valueOf(recipientType.getRawValue())};
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$deleteRecipients$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = RecipientDao$deleteRecipients$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Recipient.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Recipient.class));
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
        b0 flatMap = observeOn.flatMap(new n() { // from class: com.coinbase.wallet.features.send.daos.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientDao.a(RecipientDao.this, (List) obj);
            }
        });
        m.f(flatMap, "database.fetch<Recipient>(query, recipientType.rawValue)\n            .flatMap { records -> records.map { database.delete(it) }.zipOrEmpty() }");
        return Single_CoreKt.asUnit(flatMap);
    }

    public final b0<Optional<Recipient>> getRecipient(Blockchain blockchain, CurrencyCode currencyCode, Network network, RecipientType recipientType, String destination, TxMetadataKey txMetadataKey, String str) {
        List g2;
        o a;
        final String f2;
        List m;
        List j2;
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(recipientType, "recipientType");
        m.g(destination, "destination");
        if (txMetadataKey == null || str == null) {
            String empty = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            g2 = r.g();
            a = u.a(empty, g2);
        } else {
            j2 = r.j(txMetadataKey.getRawValue(), str);
            a = u.a("AND metadataKey = ? AND metadata = ?", j2);
        }
        f2 = q.f("\n           SELECT *\n            FROM Recipient\n           WHERE blockchain = ?\n             AND currencyCode = ?\n             AND network = ?\n             AND recipientType = ?\n             AND destination = ?\n             " + ((String) a.a()) + "\n        ");
        m = r.m(blockchain.getRawValue(), currencyCode.getRawValue(), network.getRawValue(), Integer.valueOf(recipientType.getRawValue()), destination);
        m.addAll((List) a.b());
        Object[] array = m.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        final Database<?> database = this.database;
        Object[] copyOf = Arrays.copyOf(array, array.length);
        final Object[] copyOf2 = Arrays.copyOf(copyOf, copyOf.length);
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$getRecipient$$inlined$fetchOne$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = RecipientDao$getRecipient$$inlined$fetchOne$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Recipient.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Recipient.class));
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
                    String str2 = f2;
                    Object[] objArr = copyOf2;
                    o<String, Object[]> buildSQLQuery = database2.buildSQLQuery(str2, Arrays.copyOf(objArr, objArr.length));
                    String a2 = buildSQLQuery.a();
                    Object[] b2 = buildSQLQuery.b();
                    if (b2.length != 0) {
                        z = false;
                    }
                    if (z) {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a2));
                    } else {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a2, b2));
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
        b0<Optional<Recipient>> map = observeOn.map(new n() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$getRecipient$$inlined$fetchOne$2
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

    public final b0<List<Recipient>> getRecipients(Blockchain blockchain, CurrencyCode currencyCode, Network network) {
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        final Database<?> database = this.database;
        final Object[] objArr = {currencyCode.getRawValue(), blockchain.getRawValue(), network.getRawValue()};
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0<List<Recipient>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$getRecipients$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = RecipientDao$getRecipients$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Recipient.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Recipient.class));
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

    public final b0<Boolean> hasRecipient(Blockchain blockchain, CurrencyCode currencyCode, Network network, RecipientType type) {
        m.g(blockchain, "blockchain");
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        m.g(type, "type");
        b0 map = this.database.count("SELECT *\nFROM Recipient\nWHERE currencyCode = ?\nAND blockchain = ?\nAND network = ?\nAND recipientType = ?", currencyCode.getRawValue(), blockchain.getRawValue(), network.getRawValue(), Integer.valueOf(type.getRawValue())).map(new n() { // from class: com.coinbase.wallet.features.send.daos.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return RecipientDao.b((Integer) obj);
            }
        });
        m.f(map, "database\n            .count(query, currencyCode.rawValue, blockchain.rawValue, network.rawValue, type.rawValue)\n            .map { it > 0 }");
        return map;
    }

    public final b0<Optional<Recipient>> save(Recipient recipient) {
        final List b2;
        m.g(recipient, "recipient");
        final Database<?> database = this.database;
        b2 = kotlin.a0.q.b(recipient);
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$save$$inlined$addOrUpdate$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = RecipientDao$save$$inlined$addOrUpdate$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Recipient.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Recipient.class));
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
        b0 doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$save$$inlined$addOrUpdate$2
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<DatabaseModelObject> list = b2;
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
                                h.c.v0.b<?> bVar2 = storage2.getObservers().get(Recipient.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    storage2.getObservers().put(Recipient.class, bVar);
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
        b0<Optional<Recipient>> map = doAfterSuccess.map(new n() { // from class: com.coinbase.wallet.features.send.daos.RecipientDao$save$$inlined$addOrUpdate$3
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
}