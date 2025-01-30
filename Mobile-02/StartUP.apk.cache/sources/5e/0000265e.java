package com.coinbase.wallet.store;

import android.content.Context;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.store.exceptions.StoreException;
import com.coinbase.wallet.store.interfaces.Storage;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKey;
import com.coinbase.wallet.store.models.StoreKind;
import com.coinbase.wallet.store.storages.EncryptedSharedPreferencesStorage;
import com.coinbase.wallet.store.storages.MemoryStorage;
import com.coinbase.wallet.store.storages.SharedPreferencesStorage;
import h.c.a0;
import h.c.s;
import h.c.u0.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: Store.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000f\"\b\b\u0000\u0010\b*\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0019\u001a\u00020\u0005\"\b\b\u0000\u0010\b*\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010\u0018\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u00020\u0015\"\b\b\u0000\u0010\b*\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u001f\"\b\b\u0000\u0010\b*\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010$\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b$\u0010\u0007R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R$\u0010,\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010'R\"\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/store/Store;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "", "Lcom/coinbase/wallet/store/models/StoreKind;", "kinds", "Lkotlin/x;", "deleteAllEntries", "([Lcom/coinbase/wallet/store/models/StoreKind;)V", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "key", "Lcom/coinbase/wallet/store/interfaces/Storage;", "storageForKey", "(Lcom/coinbase/wallet/store/models/StoreKey;)Lcom/coinbase/wallet/store/interfaces/Storage;", "", "Lh/c/v0/a;", "Lcom/coinbase/wallet/core/util/Optional;", "observer", "(Lcom/coinbase/wallet/store/models/StoreKey;)Lh/c/v0/a;", "", "keyName", "", "hasObserver", "(Ljava/lang/String;)Z", "value", "set", "(Lcom/coinbase/wallet/store/models/StoreKey;Ljava/lang/Object;)V", "get", "(Lcom/coinbase/wallet/store/models/StoreKey;)Ljava/lang/Object;", "has", "(Lcom/coinbase/wallet/store/models/StoreKey;)Z", "Lh/c/s;", "observe", "(Lcom/coinbase/wallet/store/models/StoreKey;)Lh/c/s;", "destroy", "()V", "removeAll", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "changeObserversLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Lcom/coinbase/wallet/store/storages/SharedPreferencesStorage;", "prefsStorage", "Lcom/coinbase/wallet/store/storages/SharedPreferencesStorage;", "<set-?>", "isDestroyed", "Z", "()Z", "Lcom/coinbase/wallet/store/storages/MemoryStorage;", "memoryStorage", "Lcom/coinbase/wallet/store/storages/MemoryStorage;", "accessLock", "", "changeObservers", "Ljava/util/Map;", "Lcom/coinbase/wallet/store/storages/EncryptedSharedPreferencesStorage;", "encryptedPrefsStorage", "Lcom/coinbase/wallet/store/storages/EncryptedSharedPreferencesStorage;", "Lh/c/a0;", "observerScheduler", "Lh/c/a0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Store implements StoreInterface {
    private final ReentrantReadWriteLock accessLock;
    private final Map<String, Object> changeObservers;
    private final ReentrantReadWriteLock changeObserversLock;
    private final EncryptedSharedPreferencesStorage encryptedPrefsStorage;
    private boolean isDestroyed;
    private final MemoryStorage memoryStorage;
    private final a0 observerScheduler;
    private final SharedPreferencesStorage prefsStorage;

    /* compiled from: Store.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StoreKind.values().length];
            iArr[StoreKind.SHARED_PREFERENCES.ordinal()] = 1;
            iArr[StoreKind.ENCRYPTED_SHARED_PREFERENCES.ordinal()] = 2;
            iArr[StoreKind.MEMORY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Store(Context context) {
        m.g(context, "context");
        this.prefsStorage = new SharedPreferencesStorage(context);
        this.encryptedPrefsStorage = new EncryptedSharedPreferencesStorage(context);
        this.memoryStorage = new MemoryStorage();
        this.changeObservers = new LinkedHashMap();
        this.accessLock = new ReentrantReadWriteLock();
        this.changeObserversLock = new ReentrantReadWriteLock();
        a0 c2 = a.c();
        m.f(c2, "io()");
        this.observerScheduler = c2;
    }

    private final void deleteAllEntries(StoreKind[] storeKindArr) {
        for (StoreKind storeKind : storeKindArr) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[storeKind.ordinal()];
            if (i2 == 1) {
                this.prefsStorage.destroy();
            } else if (i2 == 2) {
                this.encryptedPrefsStorage.destroy();
            } else if (i2 == 3) {
                this.memoryStorage.destroy();
            }
        }
    }

    private final boolean hasObserver(String str) {
        ReentrantReadWriteLock.ReadLock readLock = this.changeObserversLock.readLock();
        readLock.lock();
        try {
            return this.changeObservers.get(str) != null;
        } finally {
            readLock.unlock();
        }
    }

    /* JADX WARN: Finally extract failed */
    private final <T> h.c.v0.a<Optional<T>> observer(StoreKey<T> storeKey) {
        ReentrantReadWriteLock.ReadLock readLock = this.changeObserversLock.readLock();
        readLock.lock();
        try {
            Object obj = this.changeObservers.get(storeKey.getName());
            h.c.v0.a<Optional<T>> aVar = obj instanceof h.c.v0.a ? (h.c.v0.a) obj : null;
            x xVar = x.a;
            if (aVar != null) {
                return aVar;
            }
            Object obj2 = get(storeKey);
            ReentrantReadWriteLock reentrantReadWriteLock = this.changeObserversLock;
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            int i2 = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                Object obj3 = this.changeObservers.get(storeKey.getName());
                if (obj3 == null) {
                    h.c.v0.a<Optional<T>> d2 = h.c.v0.a.d();
                    m.f(d2, "create<Optional<T>>()");
                    this.changeObservers.put(storeKey.getName(), d2);
                    x xVar2 = x.a;
                    while (i2 < readHoldCount) {
                        readLock2.lock();
                        i2++;
                    }
                    writeLock.unlock();
                    d2.onNext(OptionalKt.toOptional(obj2));
                    return d2;
                }
                h.c.v0.a<Optional<T>> aVar2 = (h.c.v0.a) obj3;
                while (i2 < readHoldCount) {
                    readLock2.lock();
                    i2++;
                }
                writeLock.unlock();
                return aVar2;
            } catch (Throwable th) {
                while (i2 < readHoldCount) {
                    readLock2.lock();
                    i2++;
                }
                writeLock.unlock();
                throw th;
            }
        } finally {
            readLock.unlock();
        }
    }

    private final <T> Storage storageForKey(StoreKey<T> storeKey) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[storeKey.getKind().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return this.memoryStorage;
                }
                throw new NoWhenBranchMatchedException();
            }
            return this.encryptedPrefsStorage;
        }
        return this.prefsStorage;
    }

    @Override // com.coinbase.wallet.store.interfaces.StoreInterface
    public void destroy() {
        ReentrantReadWriteLock reentrantReadWriteLock = this.accessLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (isDestroyed()) {
                return;
            }
            this.isDestroyed = true;
            deleteAllEntries(StoreKind.values());
            x xVar = x.a;
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.coinbase.wallet.store.interfaces.StoreInterface
    public <T> T get(StoreKey<T> key) {
        m.g(key, "key");
        ReentrantReadWriteLock.ReadLock readLock = this.accessLock.readLock();
        readLock.lock();
        try {
            if (isDestroyed()) {
                return null;
            }
            return (T) storageForKey(key).get(key);
        } finally {
            readLock.unlock();
        }
    }

    @Override // com.coinbase.wallet.store.interfaces.StoreInterface
    public <T> boolean has(StoreKey<T> key) {
        m.g(key, "key");
        ReentrantReadWriteLock.ReadLock readLock = this.accessLock.readLock();
        readLock.lock();
        try {
            if (isDestroyed()) {
                return false;
            }
            return get(key) != null;
        } finally {
            readLock.unlock();
        }
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    @Override // com.coinbase.wallet.store.interfaces.StoreInterface
    public <T> s<Optional<T>> observe(StoreKey<T> key) {
        m.g(key, "key");
        ReentrantReadWriteLock.ReadLock readLock = this.accessLock.readLock();
        readLock.lock();
        try {
            s<Optional<T>> observeOn = (isDestroyed() ? s.error(new StoreException.StoreDestroyed()) : observer(key).hide()).observeOn(this.observerScheduler);
            m.f(observeOn, "observable.observeOn(observerScheduler)");
            return observeOn;
        } finally {
            readLock.unlock();
        }
    }

    @Override // com.coinbase.wallet.store.interfaces.StoreInterface
    public void removeAll(StoreKind[] kinds) {
        m.g(kinds, "kinds");
        ReentrantReadWriteLock reentrantReadWriteLock = this.accessLock;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            if (isDestroyed()) {
                return;
            }
            deleteAllEntries(kinds);
            x xVar = x.a;
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            for (Object obj : this.changeObservers.values()) {
                h.c.v0.a aVar = obj instanceof h.c.v0.a ? (h.c.v0.a) obj : null;
                if (aVar != null) {
                    aVar.onNext(OptionalKt.toOptional(null));
                }
            }
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    @Override // com.coinbase.wallet.store.interfaces.StoreInterface
    public <T> void set(StoreKey<T> key, T t) {
        m.g(key, "key");
        ReentrantReadWriteLock.ReadLock readLock = this.accessLock.readLock();
        readLock.lock();
        try {
            boolean hasObserver = hasObserver(key.getName());
            if (isDestroyed()) {
                return;
            }
            storageForKey(key).set(key, t);
            x xVar = x.a;
            if (hasObserver && this.isDestroyed) {
                observer(key).onError(new StoreException.StoreDestroyed());
            } else if (this.isDestroyed) {
            } else {
                observer(key).onNext(OptionalKt.toOptional(t));
            }
        } finally {
            readLock.unlock();
        }
    }
}