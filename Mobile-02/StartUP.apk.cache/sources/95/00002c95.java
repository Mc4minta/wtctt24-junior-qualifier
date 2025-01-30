package com.facebook.imagepipeline.memory;

import java.io.IOException;

/* loaded from: classes2.dex */
public class MemoryPooledByteBufferOutputStream extends com.facebook.common.memory.i {
    private final u a;

    /* renamed from: b  reason: collision with root package name */
    private com.facebook.common.references.a<t> f4556b;

    /* renamed from: c  reason: collision with root package name */
    private int f4557c;

    /* loaded from: classes2.dex */
    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(u uVar) {
        this(uVar, uVar.x());
    }

    private void b() {
        if (!com.facebook.common.references.a.G(this.f4556b)) {
            throw new InvalidStreamException();
        }
    }

    void c(int i2) {
        b();
        if (i2 <= this.f4556b.n().getSize()) {
            return;
        }
        t tVar = this.a.get(i2);
        this.f4556b.n().b(0, tVar, 0, this.f4557c);
        this.f4556b.close();
        this.f4556b = com.facebook.common.references.a.e0(tVar, this.a);
    }

    @Override // com.facebook.common.memory.i, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.f(this.f4556b);
        this.f4556b = null;
        this.f4557c = -1;
        super.close();
    }

    @Override // com.facebook.common.memory.i
    /* renamed from: d */
    public w a() {
        b();
        return new w(this.f4556b, this.f4557c);
    }

    @Override // com.facebook.common.memory.i
    public int size() {
        return this.f4557c;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public MemoryPooledByteBufferOutputStream(u uVar, int i2) {
        e.f.d.c.i.b(i2 > 0);
        u uVar2 = (u) e.f.d.c.i.g(uVar);
        this.a = uVar2;
        this.f4557c = 0;
        this.f4556b = com.facebook.common.references.a.e0(uVar2.get(i2), uVar2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            b();
            c(this.f4557c + i3);
            this.f4556b.n().c(this.f4557c, bArr, i2, i3);
            this.f4557c += i3;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
    }
}