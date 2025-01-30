package com.coinbase.wallet.store.storages;

import com.coinbase.wallet.store.interfaces.Storage;
import com.coinbase.wallet.store.models.StoreKey;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: MemoryStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\fJ-\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/store/storages/MemoryStorage;", "Lcom/coinbase/wallet/store/interfaces/Storage;", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "key", "value", "Lkotlin/x;", "set", "(Lcom/coinbase/wallet/store/models/StoreKey;Ljava/lang/Object;)V", "get", "(Lcom/coinbase/wallet/store/models/StoreKey;)Ljava/lang/Object;", "destroy", "()V", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "storage", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MemoryStorage implements Storage {
    private final ConcurrentHashMap<String, Object> storage = new ConcurrentHashMap<>();

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public void destroy() {
        this.storage.clear();
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public <T> T get(StoreKey<T> key) {
        m.g(key, "key");
        return (T) this.storage.get(key.getName());
    }

    @Override // com.coinbase.wallet.store.interfaces.Storage
    public <T> void set(StoreKey<T> key, T t) {
        m.g(key, "key");
        if (t == null) {
            this.storage.remove(key.getName());
        } else {
            this.storage.put(key.getName(), t);
        }
    }
}