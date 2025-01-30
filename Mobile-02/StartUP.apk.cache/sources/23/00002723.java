package com.coinbase.wallet.txhistory.daos;

import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.libraries.databases.db.Storage;
import com.coinbase.wallet.libraries.databases.exceptions.DatabaseException;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import com.coinbase.wallet.libraries.databases.model.DatabaseOperation;
import com.coinbase.wallet.routing.models.RouteActionKey;
import h.c.b0;
import h.c.d0;
import h.c.f0;
import h.c.m0.f;
import h.c.m0.n;
import h.c.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;
import kotlin.u;

/* compiled from: TxHistoryDAO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010$\u001a\u0006\u0012\u0002\b\u00030#¢\u0006\u0004\b+\u0010,J!\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00042\u0006\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001aJ\u0019\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\b0\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\b¢\u0006\u0004\b!\u0010\u000bJ'\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\b0\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\"\u0010\u000bR\u001a\u0010$\u001a\u0006\u0012\u0002\b\u00030#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/txhistory/daos/TxHistoryDAO;", "", "Lcom/coinbase/wallet/blockchains/models/Transaction;", "tx", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "saveTx", "(Lcom/coinbase/wallet/blockchains/models/Transaction;)Lh/c/b0;", "", "txs", "saveTxs", "(Ljava/util/List;)Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lcom/coinbase/wallet/blockchains/models/Network;", "network", "", "walletAddress", "", "txHashCanBeNil", "getTxsWithAdditionalParams", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;Ljava/lang/String;Z)Lh/c/b0;", "getTxs", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Lcom/coinbase/wallet/blockchains/models/Network;)Lh/c/b0;", "id", "getTxById", "(Ljava/lang/String;)Lh/c/b0;", "hash", "getTxsByHash", "getPendingTxs", "()Lh/c/b0;", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallets", "filterWalletsWithTx", "delete", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "database", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lh/c/s;", "historyUpdatedObservable", "Lh/c/s;", "getHistoryUpdatedObservable", "()Lh/c/s;", "<init>", "(Lcom/coinbase/wallet/libraries/databases/db/Database;)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TxHistoryDAO {
    private final Database<?> database;
    private final s<Transaction> historyUpdatedObservable;

    public TxHistoryDAO(Database<?> database) {
        h.c.v0.b<?> bVar;
        s sVar;
        m.g(database, "database");
        this.database = database;
        Storage<?> storage = database.getStorage();
        ReentrantReadWriteLock.ReadLock readLock = storage.getMultiReadSingleWriteLock().readLock();
        readLock.lock();
        try {
            if (storage.isDestroyed()) {
                sVar = s.error(DatabaseException.DatabaseDestroyed.INSTANCE);
            } else {
                synchronized (storage) {
                    h.c.v0.b<?> bVar2 = storage.getObservers().get(Transaction.class);
                    bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                    if (bVar == null) {
                        bVar = h.c.v0.b.d();
                        storage.getObservers().put(Transaction.class, bVar);
                    }
                }
                sVar = bVar.hide();
            }
            readLock.unlock();
            m.f(sVar, "multiReadSingleWriteLock.read {\n        if (isDestroyed) {\n            return@read Observable.error(DatabaseException.DatabaseDestroyed)\n        }\n\n        getOrCreateSubject(clazz).hide()\n    }");
            this.historyUpdatedObservable = sVar;
        } catch (Throwable th) {
            readLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ Set a(List list) {
        return m1743filterWalletsWithTx$lambda2(list);
    }

    public static /* synthetic */ List b(List list, List list2) {
        return m1745filterWalletsWithTx$lambda6(list, list2);
    }

    public static /* synthetic */ List c(List list) {
        return m1742filterWalletsWithTx$lambda1(list);
    }

    public static /* synthetic */ List d(List list, Set set) {
        return m1744filterWalletsWithTx$lambda4(list, set);
    }

    /* renamed from: filterWalletsWithTx$lambda-1 */
    public static final List m1742filterWalletsWithTx$lambda1(List results) {
        int r;
        m.g(results, "results");
        r = kotlin.a0.s.r(results, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = results.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (map.size() == 3) {
                Object obj = map.get(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
                String str = obj instanceof String ? (String) obj : null;
                Object obj2 = map.get(AppsFlyerProperties.CURRENCY_CODE);
                String str2 = obj2 instanceof String ? (String) obj2 : null;
                Object obj3 = map.get("network");
                String str3 = obj3 instanceof String ? (String) obj3 : null;
                if (str != null && str2 != null && str3 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((Object) str);
                    sb.append('/');
                    sb.append((Object) str2);
                    sb.append('/');
                    sb.append((Object) str3);
                    arrayList.add(sb.toString());
                } else {
                    throw new IllegalStateException("Couldn't unmarshal values from db");
                }
            } else {
                throw new IllegalStateException(m.o("Unexpected result size ", Integer.valueOf(map.size())));
            }
        }
        return arrayList;
    }

    /* renamed from: filterWalletsWithTx$lambda-2 */
    public static final Set m1743filterWalletsWithTx$lambda2(List it) {
        Set M0;
        m.g(it, "it");
        M0 = z.M0(it);
        return M0;
    }

    /* renamed from: filterWalletsWithTx$lambda-4 */
    public static final List m1744filterWalletsWithTx$lambda4(List wallets, Set walletTxs) {
        int r;
        m.g(wallets, "$wallets");
        m.g(walletTxs, "walletTxs");
        r = kotlin.a0.s.r(wallets, 10);
        ArrayList arrayList = new ArrayList(r);
        Iterator it = wallets.iterator();
        while (it.hasNext()) {
            Wallet wallet = (Wallet) it.next();
            String rawValue = wallet.getBlockchain().getRawValue();
            String rawValue2 = wallet.getCurrencyCode().getRawValue();
            String rawValue3 = wallet.getNetwork().getRawValue();
            arrayList.add(Boolean.valueOf(walletTxs.contains(rawValue + '/' + rawValue2 + '/' + rawValue3)));
        }
        return arrayList;
    }

    /* renamed from: filterWalletsWithTx$lambda-6 */
    public static final List m1745filterWalletsWithTx$lambda6(List wallets, List walletTxCounts) {
        m.g(wallets, "$wallets");
        m.g(walletTxCounts, "walletTxCounts");
        ArrayList arrayList = new ArrayList(wallets.size());
        int i2 = 0;
        for (Object obj : walletTxCounts) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                r.q();
            }
            Wallet wallet = ((Boolean) obj).booleanValue() ? (Wallet) wallets.get(i2) : null;
            if (wallet != null) {
                arrayList.add(wallet);
            }
            i2 = i3;
        }
        return arrayList;
    }

    public final b0<List<Boolean>> delete(List<Transaction> txs) {
        int r;
        List g2;
        m.g(txs, "txs");
        h.c.t0.e eVar = h.c.t0.e.a;
        r = kotlin.a0.s.r(txs, 10);
        ArrayList arrayList = new ArrayList(r);
        for (final Transaction transaction : txs) {
            final Storage<?> storage = this.database.getStorage();
            final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
            b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$delete$lambda-7$$inlined$delete$1
                @Override // h.c.f0
                public final void subscribe(d0<Boolean> emitter) {
                    Lock readLock;
                    m.g(emitter, "emitter");
                    int i2 = TxHistoryDAO$delete$lambda7$$inlined$delete$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                    DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                    DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                    if (databaseDaoInterface2 == null) {
                        emitter.onError(new DatabaseException.MissingDao(Transaction.class));
                        return;
                    }
                    readLock.lock();
                    if (storage.isDestroyed()) {
                        readLock.unlock();
                        emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                        return;
                    }
                    try {
                        databaseDaoInterface2.delete(transaction);
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
        if (arrayList.isEmpty()) {
            g2 = r.g();
            b0<List<Boolean>> just = b0.just(g2);
            m.f(just, "just(emptyList())");
            return just;
        }
        b0<List<Boolean>> zip = b0.zip(arrayList, new n() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$delete$$inlined$zipOrEmpty$1
            @Override // h.c.m0.n
            public final List<T> apply(Object[] it) {
                List<T> g3;
                m.g(it, "it");
                if (it.length == 0) {
                    g3 = r.g();
                    return g3;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : it) {
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

    public final b0<List<Wallet>> filterWalletsWithTx(final List<Wallet> wallets) {
        m.g(wallets, "wallets");
        b0<List<Wallet>> map = this.database.distinct("SELECT DISTINCT blockchain,currencyCode,network FROM `Transaction`", new Object[0]).map(new n() { // from class: com.coinbase.wallet.txhistory.daos.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryDAO.c((List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.txhistory.daos.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryDAO.a((List) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.txhistory.daos.e
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryDAO.d(wallets, (Set) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.txhistory.daos.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TxHistoryDAO.b(wallets, (List) obj);
            }
        });
        m.f(map, "database.distinct(\"SELECT DISTINCT blockchain,currencyCode,network FROM `Transaction`\")\n            .map { results ->\n                results.map { uniqueWalletTx ->\n                    if (uniqueWalletTx.size != 3) {\n                        throw IllegalStateException(\"Unexpected result size ${uniqueWalletTx.size}\")\n                    }\n\n                    val blockchain = (uniqueWalletTx[\"blockchain\"] as? String)\n                    val currencyCode = (uniqueWalletTx[\"currencyCode\"] as? String)\n                    val network = (uniqueWalletTx[\"network\"] as? String)\n\n                    if (blockchain == null || currencyCode == null || network == null) {\n                        throw IllegalStateException(\"Couldn't unmarshal values from db\")\n                    }\n                    \"$blockchain/$currencyCode/$network\"\n                }\n            }\n            .map { it.toSet() }\n            .map { walletTxs ->\n                wallets.map { wallet ->\n                    val blockchain = wallet.blockchain.rawValue\n                    val currencyCode = wallet.currencyCode.rawValue\n                    val network = wallet.network.rawValue\n                    walletTxs.contains(\"$blockchain/$currencyCode/$network\")\n                }\n            }\n            .map { walletTxCounts ->\n                val dest = ArrayList<Wallet>(wallets.size)\n                walletTxCounts.mapIndexedNotNullTo(dest) { index, hasTx -> if (hasTx) wallets[index] else null }\n            }");
        return map;
    }

    public final s<Transaction> getHistoryUpdatedObservable() {
        return this.historyUpdatedObservable;
    }

    public final b0<List<Transaction>> getPendingTxs() {
        final Database<?> database = this.database;
        final Object[] objArr = {Integer.valueOf(TxState.PENDING.getRawValue())};
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0<List<Transaction>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$getPendingTxs$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$getPendingTxs$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
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

    public final b0<Optional<Transaction>> getTxById(String id) {
        m.g(id, "id");
        final Database<?> database = this.database;
        final Object[] copyOf = Arrays.copyOf(new Object[]{id}, 1);
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$getTxById$$inlined$fetchOne$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$getTxById$$inlined$fetchOne$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
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
                    Object[] objArr = copyOf;
                    o<String, Object[]> buildSQLQuery = database2.buildSQLQuery(str, Arrays.copyOf(objArr, objArr.length));
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
        b0<Optional<Transaction>> map = observeOn.map(new n() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$getTxById$$inlined$fetchOne$2
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

    public final b0<List<Transaction>> getTxs(CurrencyCode currencyCode, Network network) {
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        final Database<?> database = this.database;
        final Object[] objArr = {currencyCode.getRawValue(), network.getRawValue()};
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0<List<Transaction>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$getTxs$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$getTxs$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
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

    public final b0<List<Transaction>> getTxsByHash(String hash) {
        m.g(hash, "hash");
        final Database<?> database = this.database;
        final Object[] objArr = {hash, m.o("0x", hash)};
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0<List<Transaction>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$getTxsByHash$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$getTxsByHash$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
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
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                List<? extends T> list = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
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

    public final b0<List<Transaction>> getTxsWithAdditionalParams(CurrencyCode currencyCode, Network network, String str, boolean z) {
        List m;
        o a;
        List m2;
        m.g(currencyCode, "currencyCode");
        m.g(network, "network");
        if (str != null) {
            m2 = r.m(currencyCode.getRawValue(), network.getRawValue(), str);
            a = u.a("  AND (fromAddress = :walletAddress OR (isSent = 0 AND toAddress = :walletAddress))", m2);
        } else {
            String empty = Strings_CoreKt.getEmpty(Strings.INSTANCE);
            m = r.m(currencyCode.getRawValue(), network.getRawValue());
            a = u.a(empty, m);
        }
        String str2 = (String) a.a();
        List list = (List) a.b();
        if (!z) {
            str2 = m.o(str2, " AND (txHash NOT null OR state = :state)");
            list.add(Integer.valueOf(TxState.PENDING.getRawValue()));
        }
        final Database<?> database = this.database;
        final String format = String.format("SELECT * FROM `Transaction` WHERE \n  currencyCode = :currencyCode\n  AND network = :network\n%s\n  ORDER BY createdAt DESC, txHash DESC", Arrays.copyOf(new Object[]{str2}, 1));
        m.f(format, "java.lang.String.format(this, *args)");
        Object[] array = list.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        final Object[] copyOf = Arrays.copyOf(array, array.length);
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.READ;
        b0<List<Transaction>> observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$getTxsWithAdditionalParams$$inlined$fetch$1
            @Override // h.c.f0
            public final void subscribe(d0<List<? extends T>> emitter) {
                Lock readLock;
                List<? extends T> fetch;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$getTxsWithAdditionalParams$$inlined$fetch$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                boolean z2 = true;
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                List<? extends T> list2 = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
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
                    String str3 = format;
                    Object[] objArr = copyOf;
                    o<String, Object[]> buildSQLQuery = database2.buildSQLQuery(str3, Arrays.copyOf(objArr, objArr.length));
                    String a2 = buildSQLQuery.a();
                    Object[] b2 = buildSQLQuery.b();
                    if (b2.length != 0) {
                        z2 = false;
                    }
                    if (z2) {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a2));
                    } else {
                        fetch = databaseDaoInterface2.fetch(new c.r.a.a(a2, b2));
                    }
                    if (fetch instanceof List) {
                        list2 = fetch;
                    }
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (list2 != null) {
                    emitter.onSuccess(list2);
                    return;
                }
                throw new IllegalArgumentException("Invalid result");
            }
        }).subscribeOn(storage.getScheduler()).observeOn(storage.getScheduler());
        m.f(observeOn, "@Suppress(\"UNCHECKED_CAST\")\n    inline fun <reified T, reified R> perform(\n        operation: DatabaseOperation,\n        crossinline work: (dao: DatabaseDaoInterface<T>) -> R\n    ): Single<R> = Single\n        .create<R> { emitter ->\n            val lock: Lock = when (operation) {\n                DatabaseOperation.READ -> multiReadSingleWriteLock.readLock()\n                DatabaseOperation.WRITE -> multiReadSingleWriteLock.writeLock()\n            }\n\n            val dao = modelDaos[T::class.java] as? DatabaseDaoInterface<T>\n                ?: return@create emitter.onError(DatabaseException.MissingDao(T::class.java))\n\n            lock.lock()\n\n            if (isDestroyed) {\n                lock.unlock()\n                return@create emitter.onError(DatabaseException.DatabaseDestroyed)\n            }\n\n            try {\n                val result = work(dao) as? R ?: throw IllegalArgumentException(\"Invalid result\")\n                emitter.onSuccess(result)\n            } catch (err: Throwable) {\n                emitter.onError(err)\n            } finally {\n                lock.unlock()\n            }\n        }\n        .subscribeOn(scheduler)\n        .observeOn(scheduler)");
        return observeOn;
    }

    public final b0<Optional<Transaction>> saveTx(Transaction tx) {
        final List b2;
        m.g(tx, "tx");
        final Database<?> database = this.database;
        b2 = q.b(tx);
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$saveTx$$inlined$addOrUpdate$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$saveTx$$inlined$addOrUpdate$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
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
        b0 doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$saveTx$$inlined$addOrUpdate$2
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
                                h.c.v0.b<?> bVar2 = storage2.getObservers().get(Transaction.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    storage2.getObservers().put(Transaction.class, bVar);
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
        b0<Optional<Transaction>> map = doAfterSuccess.map(new n() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$saveTx$$inlined$addOrUpdate$3
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

    public final b0<Optional<List<Transaction>>> saveTxs(final List<Transaction> txs) {
        m.g(txs, "txs");
        final Database<?> database = this.database;
        final Storage<?> storage = database.getStorage();
        final DatabaseOperation databaseOperation = DatabaseOperation.WRITE;
        b0 observeOn = b0.create(new f0() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$saveTxs$$inlined$addOrUpdate$1
            @Override // h.c.f0
            public final void subscribe(d0<Optional<? extends List<? extends T>>> emitter) {
                Lock readLock;
                m.g(emitter, "emitter");
                int i2 = TxHistoryDAO$saveTxs$$inlined$addOrUpdate$1$1$wm$Storage$perform$1$WhenMappings.$EnumSwitchMapping$0[DatabaseOperation.this.ordinal()];
                if (i2 == 1) {
                    readLock = storage.getMultiReadSingleWriteLock().readLock();
                    m.f(readLock, "multiReadSingleWriteLock.readLock()");
                } else if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    readLock = storage.getMultiReadSingleWriteLock().writeLock();
                    m.f(readLock, "multiReadSingleWriteLock.writeLock()");
                }
                DatabaseDaoInterface<?> databaseDaoInterface = storage.getModelDaos().get(Transaction.class);
                Optional<? extends List<? extends T>> optional = null;
                DatabaseDaoInterface<?> databaseDaoInterface2 = databaseDaoInterface instanceof DatabaseDaoInterface ? databaseDaoInterface : null;
                if (databaseDaoInterface2 == null) {
                    emitter.onError(new DatabaseException.MissingDao(Transaction.class));
                    return;
                }
                readLock.lock();
                if (storage.isDestroyed()) {
                    readLock.unlock();
                    emitter.onError(DatabaseException.DatabaseDestroyed.INSTANCE);
                    return;
                }
                try {
                    databaseDaoInterface2.addOrUpdate(txs);
                    Optional<? extends List<? extends T>> optional2 = OptionalKt.toOptional(txs);
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
        b0<Optional<List<Transaction>>> doAfterSuccess = observeOn.doAfterSuccess(new f() { // from class: com.coinbase.wallet.txhistory.daos.TxHistoryDAO$saveTxs$$inlined$addOrUpdate$2
            public final void accept(Optional<? extends List<? extends T>> optional) {
                h.c.v0.b<?> bVar;
                List<DatabaseModelObject> list = txs;
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
                                h.c.v0.b<?> bVar2 = storage2.getObservers().get(Transaction.class);
                                bVar = bVar2 instanceof h.c.v0.b ? bVar2 : null;
                                if (bVar == null) {
                                    bVar = h.c.v0.b.d();
                                    storage2.getObservers().put(Transaction.class, bVar);
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
        return doAfterSuccess;
    }
}