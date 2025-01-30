package com.coinbase.wallet.core.util;

import android.util.LruCache;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

/* compiled from: ConcurrentLruCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0006\u001a\n \u0005*\u0004\u0018\u00018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\t\u001a\n \u0005*\u0004\u0018\u00018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/core/util/ConcurrentLruCache;", "K", "V", "", "key", "kotlin.jvm.PlatformType", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "set", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/x;", "remove", "(Ljava/lang/Object;)V", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "accessLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "", "maxSize", "I", "getMaxSize", "()I", "Landroid/util/LruCache;", "cache", "Landroid/util/LruCache;", "<init>", "(I)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConcurrentLruCache<K, V> {
    private final ReentrantReadWriteLock accessLock = new ReentrantReadWriteLock();
    private final LruCache<K, V> cache;
    private final int maxSize;

    public ConcurrentLruCache(int i2) {
        this.maxSize = i2;
        this.cache = new LruCache<>(i2);
    }

    public final V get(K k2) {
        ReentrantReadWriteLock.ReadLock readLock = this.accessLock.readLock();
        readLock.lock();
        try {
            return this.cache.get(k2);
        } finally {
            readLock.unlock();
        }
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final void remove(K k2) {
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
            this.cache.remove(k2);
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }

    public final V set(K k2, V v) {
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
            return this.cache.put(k2, v);
        } finally {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        }
    }
}