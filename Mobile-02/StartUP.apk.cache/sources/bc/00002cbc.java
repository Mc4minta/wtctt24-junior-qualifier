package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: MemoryPooledByteBufferFactory.java */
/* loaded from: classes2.dex */
public class x implements com.facebook.common.memory.g {
    private final com.facebook.common.memory.j a;

    /* renamed from: b  reason: collision with root package name */
    private final u f4623b;

    public x(u uVar, com.facebook.common.memory.j jVar) {
        this.f4623b = uVar;
        this.a = jVar;
    }

    w f(InputStream inputStream, MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream) throws IOException {
        this.a.a(inputStream, memoryPooledByteBufferOutputStream);
        return memoryPooledByteBufferOutputStream.a();
    }

    @Override // com.facebook.common.memory.g
    /* renamed from: g */
    public w c(InputStream inputStream) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f4623b);
        try {
            return f(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.g
    /* renamed from: h */
    public w d(InputStream inputStream, int i2) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f4623b, i2);
        try {
            return f(inputStream, memoryPooledByteBufferOutputStream);
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.g
    /* renamed from: i */
    public w b(byte[] bArr) {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f4623b, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return memoryPooledByteBufferOutputStream.a();
            } catch (IOException e2) {
                throw e.f.d.c.n.a(e2);
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.g
    /* renamed from: j */
    public MemoryPooledByteBufferOutputStream a() {
        return new MemoryPooledByteBufferOutputStream(this.f4623b);
    }

    @Override // com.facebook.common.memory.g
    /* renamed from: k */
    public MemoryPooledByteBufferOutputStream e(int i2) {
        return new MemoryPooledByteBufferOutputStream(this.f4623b, i2);
    }
}