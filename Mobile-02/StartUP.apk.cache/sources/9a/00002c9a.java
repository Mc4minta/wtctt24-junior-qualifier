package com.facebook.imagepipeline.memory;

import java.util.LinkedList;

/* compiled from: OOMSoftReferenceBucket.java */
/* loaded from: classes2.dex */
class a0<V> extends e<V> {

    /* renamed from: f  reason: collision with root package name */
    private LinkedList<com.facebook.common.references.b<V>> f4564f;

    public a0(int i2, int i3, int i4) {
        super(i2, i3, i4, false);
        this.f4564f = new LinkedList<>();
    }

    @Override // com.facebook.imagepipeline.memory.e
    void a(V v) {
        com.facebook.common.references.b<V> poll = this.f4564f.poll();
        if (poll == null) {
            poll = new com.facebook.common.references.b<>();
        }
        poll.c(v);
        this.f4598c.add(poll);
    }

    @Override // com.facebook.imagepipeline.memory.e
    public V g() {
        com.facebook.common.references.b<V> bVar = (com.facebook.common.references.b) this.f4598c.poll();
        V b2 = bVar.b();
        bVar.a();
        this.f4564f.add(bVar);
        return b2;
    }
}