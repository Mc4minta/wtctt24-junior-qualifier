package e.g.b.a.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LoggingByteArrayOutputStream.java */
/* loaded from: classes2.dex */
public class r extends ByteArrayOutputStream {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13456b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13457c;

    /* renamed from: d  reason: collision with root package name */
    private final Level f13458d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f13459e;

    public r(Logger logger, Level level, int i2) {
        this.f13459e = (Logger) y.d(logger);
        this.f13458d = (Level) y.d(level);
        y.a(i2 >= 0);
        this.f13456b = i2;
    }

    private static void a(StringBuilder sb, int i2) {
        if (i2 == 1) {
            sb.append("1 byte");
            return;
        }
        sb.append(NumberFormat.getInstance().format(i2));
        sb.append(" bytes");
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.f13457c) {
            if (this.a != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Total: ");
                a(sb, this.a);
                int i2 = ((ByteArrayOutputStream) this).count;
                if (i2 != 0 && i2 < this.a) {
                    sb.append(" (logging first ");
                    a(sb, ((ByteArrayOutputStream) this).count);
                    sb.append(")");
                }
                this.f13459e.config(sb.toString());
                if (((ByteArrayOutputStream) this).count != 0) {
                    this.f13459e.log(this.f13458d, toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.f13457c = true;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i2) {
        y.a(!this.f13457c);
        this.a++;
        if (((ByteArrayOutputStream) this).count < this.f13456b) {
            super.write(i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) {
        y.a(!this.f13457c);
        this.a += i3;
        int i4 = ((ByteArrayOutputStream) this).count;
        int i5 = this.f13456b;
        if (i4 < i5) {
            int i6 = i4 + i3;
            if (i6 > i5) {
                i3 += i5 - i6;
            }
            super.write(bArr, i2, i3);
        }
    }
}