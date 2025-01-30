package e.g.b.a.d;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ByteCountingOutputStream.java */
/* loaded from: classes2.dex */
final class f extends OutputStream {
    long a;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.a += i3;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.a++;
    }
}