package com.bumptech.glide.load.engine;

import androidx.core.util.f;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    private static final f<LockedResource<?>> POOL = FactoryPools.threadSafe(20, new FactoryPools.Factory<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.LockedResource.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public LockedResource<?> create() {
            return new LockedResource<>();
        }
    });
    private boolean isLocked;
    private boolean isRecycled;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private Resource<Z> toWrap;

    LockedResource() {
    }

    private void init(Resource<Z> resource) {
        this.isRecycled = false;
        this.isLocked = true;
        this.toWrap = resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <Z> LockedResource<Z> obtain(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) Preconditions.checkNotNull(POOL.acquire());
        lockedResource.init(resource);
        return lockedResource;
    }

    private void release() {
        this.toWrap = null;
        POOL.release(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.toWrap.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.toWrap.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        this.stateVerifier.throwIfRecycled();
        this.isRecycled = true;
        if (!this.isLocked) {
            this.toWrap.recycle();
            release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void unlock() {
        this.stateVerifier.throwIfRecycled();
        if (this.isLocked) {
            this.isLocked = false;
            if (this.isRecycled) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }
}