package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;

/* compiled from: MemoryPooledByteBuffer.java */
/* loaded from: classes2.dex */
public class w implements PooledByteBuffer {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    com.facebook.common.references.a<t> f4622b;

    public w(com.facebook.common.references.a<t> aVar, int i2) {
        e.f.d.c.i.g(aVar);
        e.f.d.c.i.b(i2 >= 0 && i2 <= aVar.n().getSize());
        this.f4622b = aVar.clone();
        this.a = i2;
    }

    synchronized void a() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        com.facebook.common.references.a.f(this.f4622b);
        this.f4622b = null;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !com.facebook.common.references.a.G(this.f4622b);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte k(int i2) {
        a();
        boolean z = true;
        e.f.d.c.i.b(i2 >= 0);
        if (i2 >= this.a) {
            z = false;
        }
        e.f.d.c.i.b(z);
        return this.f4622b.n().k(i2);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int l(int i2, byte[] bArr, int i3, int i4) {
        a();
        e.f.d.c.i.b(i2 + i4 <= this.a);
        return this.f4622b.n().l(i2, bArr, i3, i4);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        a();
        return this.a;
    }
}