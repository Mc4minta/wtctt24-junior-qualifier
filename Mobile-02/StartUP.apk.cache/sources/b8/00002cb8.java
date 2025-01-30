package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;

/* compiled from: MemoryChunk.java */
/* loaded from: classes2.dex */
public interface t {
    long a();

    void b(int i2, t tVar, int i3, int i4);

    int c(int i2, byte[] bArr, int i3, int i4);

    void close();

    ByteBuffer d();

    long e() throws UnsupportedOperationException;

    int getSize();

    boolean isClosed();

    byte k(int i2);

    int l(int i2, byte[] bArr, int i3, int i4);
}