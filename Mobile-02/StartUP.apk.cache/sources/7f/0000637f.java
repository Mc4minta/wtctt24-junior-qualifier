package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class TlsOutputStream extends OutputStream {
    private byte[] buf = new byte[1];
    private TlsProtocol handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TlsOutputStream(TlsProtocol tlsProtocol) {
        this.handler = tlsProtocol;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.handler.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.handler.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.handler.writeData(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.buf;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }
}