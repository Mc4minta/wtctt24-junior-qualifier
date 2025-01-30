package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* compiled from: BufferMemoryChunk.java */
/* loaded from: classes2.dex */
public class h implements t, Closeable {
    private ByteBuffer a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4612b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4613c = System.identityHashCode(this);

    public h(int i2) {
        this.a = ByteBuffer.allocateDirect(i2);
        this.f4612b = i2;
    }

    private void f(int i2, t tVar, int i3, int i4) {
        if (tVar instanceof h) {
            e.f.d.c.i.i(!isClosed());
            e.f.d.c.i.i(!tVar.isClosed());
            v.b(i2, tVar.getSize(), i3, i4, this.f4612b);
            this.a.position(i2);
            tVar.d().position(i3);
            byte[] bArr = new byte[i4];
            this.a.get(bArr, 0, i4);
            tVar.d().put(bArr, 0, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long a() {
        return this.f4613c;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void b(int i2, t tVar, int i3, int i4) {
        e.f.d.c.i.g(tVar);
        if (tVar.a() == a()) {
            Log.w("BufferMemoryChunk", "Copying from BufferMemoryChunk " + Long.toHexString(a()) + " to BufferMemoryChunk " + Long.toHexString(tVar.a()) + " which are the same ");
            e.f.d.c.i.b(false);
        }
        if (tVar.a() < a()) {
            synchronized (tVar) {
                synchronized (this) {
                    f(i2, tVar, i3, i4);
                }
            }
            return;
        }
        synchronized (this) {
            synchronized (tVar) {
                f(i2, tVar, i3, i4);
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int c(int i2, byte[] bArr, int i3, int i4) {
        int a;
        e.f.d.c.i.g(bArr);
        e.f.d.c.i.i(!isClosed());
        a = v.a(i2, i4, this.f4612b);
        v.b(i2, bArr.length, i3, a, this.f4612b);
        this.a.position(i2);
        this.a.put(bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.a = null;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized ByteBuffer d() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long e() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int getSize() {
        return this.f4612b;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized boolean isClosed() {
        return this.a == null;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized byte k(int i2) {
        boolean z = true;
        e.f.d.c.i.i(!isClosed());
        e.f.d.c.i.b(i2 >= 0);
        if (i2 >= this.f4612b) {
            z = false;
        }
        e.f.d.c.i.b(z);
        return this.a.get(i2);
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int l(int i2, byte[] bArr, int i3, int i4) {
        int a;
        e.f.d.c.i.g(bArr);
        e.f.d.c.i.i(!isClosed());
        a = v.a(i2, i4, this.f4612b);
        v.b(i2, bArr.length, i3, a, this.f4612b);
        this.a.position(i2);
        this.a.get(bArr, i3, a);
        return a;
    }
}