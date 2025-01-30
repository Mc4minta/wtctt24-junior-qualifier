package e.g.b.a.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LoggingInputStream.java */
/* loaded from: classes2.dex */
public class s extends FilterInputStream {
    private final r a;

    public s(InputStream inputStream, Logger logger, Level level, int i2) {
        super(inputStream);
        this.a = new r(logger, level, i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        this.a.write(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = super.read(bArr, i2, i3);
        if (read > 0) {
            this.a.write(bArr, i2, read);
        }
        return read;
    }
}