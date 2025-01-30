package com.facebook.common.memory;

import e.f.d.c.n;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: PooledByteBufferOutputStream.java */
/* loaded from: classes2.dex */
public abstract class i extends OutputStream {
    public abstract PooledByteBuffer a();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e2) {
            n.a(e2);
        }
    }

    public abstract int size();
}