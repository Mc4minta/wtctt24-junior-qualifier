package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.f;
import androidx.core.util.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class FactoryPools {
    private static final int DEFAULT_POOL_SIZE = 20;
    private static final Resetter<Object> EMPTY_RESETTER = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void reset(Object obj) {
        }
    };
    private static final String TAG = "FactoryPools";

    /* loaded from: classes.dex */
    public interface Factory<T> {
        T create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class FactoryPool<T> implements f<T> {
        private final Factory<T> factory;
        private final f<T> pool;
        private final Resetter<T> resetter;

        FactoryPool(f<T> fVar, Factory<T> factory, Resetter<T> resetter) {
            this.pool = fVar;
            this.factory = factory;
            this.resetter = resetter;
        }

        @Override // androidx.core.util.f
        public T acquire() {
            T acquire = this.pool.acquire();
            if (acquire == null) {
                acquire = this.factory.create();
                if (Log.isLoggable(FactoryPools.TAG, 2)) {
                    Log.v(FactoryPools.TAG, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).getVerifier().setRecycled(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.f
        public boolean release(T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).getVerifier().setRecycled(true);
            }
            this.resetter.reset(t);
            return this.pool.release(t);
        }
    }

    /* loaded from: classes.dex */
    public interface Poolable {
        StateVerifier getVerifier();
    }

    /* loaded from: classes.dex */
    public interface Resetter<T> {
        void reset(T t);
    }

    private FactoryPools() {
    }

    private static <T extends Poolable> f<T> build(f<T> fVar, Factory<T> factory) {
        return build(fVar, factory, emptyResetter());
    }

    private static <T> Resetter<T> emptyResetter() {
        return (Resetter<T>) EMPTY_RESETTER;
    }

    public static <T extends Poolable> f<T> simple(int i2, Factory<T> factory) {
        return build(new Pools$SimplePool(i2), factory);
    }

    public static <T extends Poolable> f<T> threadSafe(int i2, Factory<T> factory) {
        return build(new g(i2), factory);
    }

    public static <T> f<List<T>> threadSafeList() {
        return threadSafeList(20);
    }

    private static <T> f<T> build(f<T> fVar, Factory<T> factory, Resetter<T> resetter) {
        return new FactoryPool(fVar, factory, resetter);
    }

    public static <T> f<List<T>> threadSafeList(int i2) {
        return build(new g(i2), new Factory<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public List<T> create() {
                return new ArrayList();
            }
        }, new Resetter<List<T>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            public /* bridge */ /* synthetic */ void reset(Object obj) {
                reset((List) ((List) obj));
            }

            public void reset(List<T> list) {
                list.clear();
            }
        });
    }
}