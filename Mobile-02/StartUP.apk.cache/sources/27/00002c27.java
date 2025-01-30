package com.facebook.common.memory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: PooledByteStreams.java */
/* loaded from: classes2.dex */
public class j {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4492b;

    public j(a aVar) {
        this(aVar, 16384);
    }

    public long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f4492b.get(this.a);
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.a);
                if (read == -1) {
                    return j2;
                }
                outputStream.write(bArr, 0, read);
                j2 += read;
            } finally {
                this.f4492b.release(bArr);
            }
        }
    }

    public j(a aVar, int i2) {
        e.f.d.c.i.b(i2 > 0);
        this.a = i2;
        this.f4492b = aVar;
    }
}