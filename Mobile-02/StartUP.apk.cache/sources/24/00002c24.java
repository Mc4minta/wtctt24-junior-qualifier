package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: PooledByteBufferFactory.java */
/* loaded from: classes2.dex */
public interface g {
    i a();

    PooledByteBuffer b(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream) throws IOException;

    PooledByteBuffer d(InputStream inputStream, int i2) throws IOException;

    i e(int i2);
}