package com.facebook.imagepipeline.memory;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

@e.f.d.c.d
/* loaded from: classes2.dex */
public class NativeMemoryChunk implements t, Closeable {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4558b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4559c;

    static {
        com.facebook.imagepipeline.nativecode.a.a();
    }

    public NativeMemoryChunk(int i2) {
        e.f.d.c.i.b(i2 > 0);
        this.f4558b = i2;
        this.a = nativeAllocate(i2);
        this.f4559c = false;
    }

    private void f(int i2, t tVar, int i3, int i4) {
        if (tVar instanceof NativeMemoryChunk) {
            e.f.d.c.i.i(!isClosed());
            e.f.d.c.i.i(!tVar.isClosed());
            v.b(i2, tVar.getSize(), i3, i4, this.f4558b);
            nativeMemcpy(tVar.e() + i3, this.a + i2, i4);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @e.f.d.c.d
    private static native long nativeAllocate(int i2);

    @e.f.d.c.d
    private static native void nativeCopyFromByteArray(long j2, byte[] bArr, int i2, int i3);

    @e.f.d.c.d
    private static native void nativeCopyToByteArray(long j2, byte[] bArr, int i2, int i3);

    @e.f.d.c.d
    private static native void nativeFree(long j2);

    @e.f.d.c.d
    private static native void nativeMemcpy(long j2, long j3, int i2);

    @e.f.d.c.d
    private static native byte nativeReadByte(long j2);

    @Override // com.facebook.imagepipeline.memory.t
    public long a() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public void b(int i2, t tVar, int i3, int i4) {
        e.f.d.c.i.g(tVar);
        if (tVar.a() == a()) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(tVar)) + " which share the same address " + Long.toHexString(this.a));
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
        a = v.a(i2, i4, this.f4558b);
        v.b(i2, bArr.length, i3, a, this.f4558b);
        nativeCopyFromByteArray(this.a + i2, bArr, i3, a);
        return a;
    }

    @Override // com.facebook.imagepipeline.memory.t, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f4559c) {
            this.f4559c = true;
            nativeFree(this.a);
        }
    }

    @Override // com.facebook.imagepipeline.memory.t
    public ByteBuffer d() {
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public long e() {
        return this.a;
    }

    protected void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.memory.t
    public int getSize() {
        return this.f4558b;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized boolean isClosed() {
        return this.f4559c;
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized byte k(int i2) {
        boolean z = true;
        e.f.d.c.i.i(!isClosed());
        e.f.d.c.i.b(i2 >= 0);
        if (i2 >= this.f4558b) {
            z = false;
        }
        e.f.d.c.i.b(z);
        return nativeReadByte(this.a + i2);
    }

    @Override // com.facebook.imagepipeline.memory.t
    public synchronized int l(int i2, byte[] bArr, int i3, int i4) {
        int a;
        e.f.d.c.i.g(bArr);
        e.f.d.c.i.i(!isClosed());
        a = v.a(i2, i4, this.f4558b);
        v.b(i2, bArr.length, i3, a, this.f4558b);
        nativeCopyToByteArray(this.a + i2, bArr, i3, a);
        return a;
    }

    public NativeMemoryChunk() {
        this.f4558b = 0;
        this.a = 0L;
        this.f4559c = true;
    }
}