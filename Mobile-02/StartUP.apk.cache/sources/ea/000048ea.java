package e.g.b.a.d;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LoggingOutputStream.java */
/* loaded from: classes2.dex */
public class t extends FilterOutputStream {
    private final r a;

    public t(OutputStream outputStream, Logger logger, Level level, int i2) {
        super(outputStream);
        this.a = new r(logger, level, i2);
    }

    public final r a() {
        return this.a;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        ((FilterOutputStream) this).out.write(i2);
        this.a.write(i2);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i2, i3);
        this.a.write(bArr, i2, i3);
    }
}