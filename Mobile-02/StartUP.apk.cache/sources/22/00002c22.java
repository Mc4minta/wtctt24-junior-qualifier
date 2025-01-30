package com.facebook.common.memory;

/* compiled from: Pool.java */
/* loaded from: classes2.dex */
public interface e<V> extends com.facebook.common.references.c<V>, b {
    V get(int i2);

    @Override // com.facebook.common.references.c
    void release(V v);
}