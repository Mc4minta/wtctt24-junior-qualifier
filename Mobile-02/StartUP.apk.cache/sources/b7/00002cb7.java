package com.facebook.imagepipeline.memory;

import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBucketsPoolBackend.java */
/* loaded from: classes2.dex */
public abstract class s<T> implements b0<T> {
    private final Set<T> a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final f<T> f4620b = new f<>();

    private T b(T t) {
        if (t != null) {
            synchronized (this) {
                this.a.remove(t);
            }
        }
        return t;
    }

    @Override // com.facebook.imagepipeline.memory.b0
    public T get(int i2) {
        return b(this.f4620b.a(i2));
    }

    @Override // com.facebook.imagepipeline.memory.b0
    public T pop() {
        return b(this.f4620b.f());
    }

    @Override // com.facebook.imagepipeline.memory.b0
    public void put(T t) {
        boolean add;
        synchronized (this) {
            add = this.a.add(t);
        }
        if (add) {
            this.f4620b.e(a(t), t);
        }
    }
}