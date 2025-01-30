package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class ByteQueueOutputStream extends OutputStream {
    private ByteQueue buffer = new ByteQueue();

    public ByteQueue getBuffer() {
        return this.buffer;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.buffer.addData(new byte[]{(byte) i2}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.buffer.addData(bArr, i2, i3);
    }
}