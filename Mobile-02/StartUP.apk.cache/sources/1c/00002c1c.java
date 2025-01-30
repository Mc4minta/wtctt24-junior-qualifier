package com.facebook.common.memory;

import java.io.Closeable;

/* loaded from: classes2.dex */
public interface PooledByteBuffer extends Closeable {

    /* loaded from: classes2.dex */
    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    boolean isClosed();

    byte k(int i2);

    int l(int i2, byte[] bArr, int i3, int i4);

    int size();
}