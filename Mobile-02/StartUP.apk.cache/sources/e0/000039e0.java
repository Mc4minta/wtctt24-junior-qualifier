package com.google.firebase.crashlytics.c.h;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class c implements Closeable {
    private static final Logger a = Logger.getLogger(c.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final RandomAccessFile f8812b;

    /* renamed from: c  reason: collision with root package name */
    int f8813c;

    /* renamed from: d  reason: collision with root package name */
    private int f8814d;

    /* renamed from: e  reason: collision with root package name */
    private b f8815e;

    /* renamed from: f  reason: collision with root package name */
    private b f8816f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f8817g = new byte[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class a implements d {
        boolean a = true;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ StringBuilder f8818b;

        a(StringBuilder sb) {
            this.f8818b = sb;
        }

        @Override // com.google.firebase.crashlytics.c.h.c.d
        public void read(InputStream inputStream, int i2) throws IOException {
            if (this.a) {
                this.a = false;
            } else {
                this.f8818b.append(", ");
            }
            this.f8818b.append(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static class b {
        static final b a = new b(0, 0);

        /* renamed from: b  reason: collision with root package name */
        final int f8820b;

        /* renamed from: c  reason: collision with root package name */
        final int f8821c;

        b(int i2, int i3) {
            this.f8820b = i2;
            this.f8821c = i3;
        }

        public String toString() {
            return b.class.getSimpleName() + "[position = " + this.f8820b + ", length = " + this.f8821c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0169c extends InputStream {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f8822b;

        /* synthetic */ C0169c(c cVar, b bVar, a aVar) {
            this(bVar);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            c.z(bArr, "buffer");
            if ((i2 | i3) >= 0 && i3 <= bArr.length - i2) {
                int i4 = this.f8822b;
                if (i4 > 0) {
                    if (i3 > i4) {
                        i3 = i4;
                    }
                    c.this.a0(this.a, bArr, i2, i3);
                    this.a = c.this.k0(this.a + i3);
                    this.f8822b -= i3;
                    return i3;
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private C0169c(b bVar) {
            this.a = c.this.k0(bVar.f8820b + 4);
            this.f8822b = bVar.f8821c;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f8822b == 0) {
                return -1;
            }
            c.this.f8812b.seek(this.a);
            int read = c.this.f8812b.read();
            this.a = c.this.k0(this.a + 1);
            this.f8822b--;
            return read;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public interface d {
        void read(InputStream inputStream, int i2) throws IOException;
    }

    public c(File file) throws IOException {
        if (!file.exists()) {
            n(file);
        }
        this.f8812b = A(file);
        K();
    }

    private static RandomAccessFile A(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private b G(int i2) throws IOException {
        if (i2 == 0) {
            return b.a;
        }
        this.f8812b.seek(i2);
        return new b(i2, this.f8812b.readInt());
    }

    private void K() throws IOException {
        this.f8812b.seek(0L);
        this.f8812b.readFully(this.f8817g);
        int N = N(this.f8817g, 0);
        this.f8813c = N;
        if (N <= this.f8812b.length()) {
            this.f8814d = N(this.f8817g, 4);
            int N2 = N(this.f8817g, 8);
            int N3 = N(this.f8817g, 12);
            this.f8815e = G(N2);
            this.f8816f = G(N3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f8813c + ", Actual length: " + this.f8812b.length());
    }

    private static int N(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    private int O() {
        return this.f8813c - g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int k0 = k0(i2);
        int i5 = k0 + i4;
        int i6 = this.f8813c;
        if (i5 <= i6) {
            this.f8812b.seek(k0);
            this.f8812b.readFully(bArr, i3, i4);
            return;
        }
        int i7 = i6 - k0;
        this.f8812b.seek(k0);
        this.f8812b.readFully(bArr, i3, i7);
        this.f8812b.seek(16L);
        this.f8812b.readFully(bArr, i3 + i7, i4 - i7);
    }

    private void d0(int i2, byte[] bArr, int i3, int i4) throws IOException {
        int k0 = k0(i2);
        int i5 = k0 + i4;
        int i6 = this.f8813c;
        if (i5 <= i6) {
            this.f8812b.seek(k0);
            this.f8812b.write(bArr, i3, i4);
            return;
        }
        int i7 = i6 - k0;
        this.f8812b.seek(k0);
        this.f8812b.write(bArr, i3, i7);
        this.f8812b.seek(16L);
        this.f8812b.write(bArr, i3 + i7, i4 - i7);
    }

    private void e0(int i2) throws IOException {
        this.f8812b.setLength(i2);
        this.f8812b.getChannel().force(true);
    }

    private void j(int i2) throws IOException {
        int i3 = i2 + 4;
        int O = O();
        if (O >= i3) {
            return;
        }
        int i4 = this.f8813c;
        do {
            O += i4;
            i4 <<= 1;
        } while (O < i3);
        e0(i4);
        b bVar = this.f8816f;
        int k0 = k0(bVar.f8820b + 4 + bVar.f8821c);
        if (k0 < this.f8815e.f8820b) {
            FileChannel channel = this.f8812b.getChannel();
            channel.position(this.f8813c);
            long j2 = k0 - 4;
            if (channel.transferTo(16L, j2, channel) != j2) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i5 = this.f8816f.f8820b;
        int i6 = this.f8815e.f8820b;
        if (i5 < i6) {
            int i7 = (this.f8813c + i5) - 16;
            n0(i4, this.f8814d, i6, i7);
            this.f8816f = new b(i7, this.f8816f.f8821c);
        } else {
            n0(i4, this.f8814d, i6, i5);
        }
        this.f8813c = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k0(int i2) {
        int i3 = this.f8813c;
        return i2 < i3 ? i2 : (i2 + 16) - i3;
    }

    private static void n(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile A = A(file2);
        try {
            A.setLength(4096L);
            A.seek(0L);
            byte[] bArr = new byte[16];
            r0(bArr, 4096, 0, 0, 0);
            A.write(bArr);
            A.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            A.close();
            throw th;
        }
    }

    private void n0(int i2, int i3, int i4, int i5) throws IOException {
        r0(this.f8817g, i2, i3, i4, i5);
        this.f8812b.seek(0L);
        this.f8812b.write(this.f8817g);
    }

    private static void o0(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    private static void r0(byte[] bArr, int... iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            o0(bArr, i2, i3);
            i2 += 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T z(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public synchronized void V() throws IOException {
        if (!v()) {
            if (this.f8814d == 1) {
                g();
            } else {
                b bVar = this.f8815e;
                int k0 = k0(bVar.f8820b + 4 + bVar.f8821c);
                a0(k0, this.f8817g, 0, 4);
                int N = N(this.f8817g, 0);
                n0(this.f8813c, this.f8814d - 1, k0, this.f8816f.f8820b);
                this.f8814d--;
                this.f8815e = new b(k0, N);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f8812b.close();
    }

    public void e(byte[] bArr) throws IOException {
        f(bArr, 0, bArr.length);
    }

    public synchronized void f(byte[] bArr, int i2, int i3) throws IOException {
        int k0;
        z(bArr, "buffer");
        if ((i2 | i3) >= 0 && i3 <= bArr.length - i2) {
            j(i3);
            boolean v = v();
            if (v) {
                k0 = 16;
            } else {
                b bVar = this.f8816f;
                k0 = k0(bVar.f8820b + 4 + bVar.f8821c);
            }
            b bVar2 = new b(k0, i3);
            o0(this.f8817g, 0, i3);
            d0(bVar2.f8820b, this.f8817g, 0, 4);
            d0(bVar2.f8820b + 4, bArr, i2, i3);
            n0(this.f8813c, this.f8814d + 1, v ? bVar2.f8820b : this.f8815e.f8820b, bVar2.f8820b);
            this.f8816f = bVar2;
            this.f8814d++;
            if (v) {
                this.f8815e = bVar2;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void g() throws IOException {
        n0(4096, 0, 0, 0);
        this.f8814d = 0;
        b bVar = b.a;
        this.f8815e = bVar;
        this.f8816f = bVar;
        if (this.f8813c > 4096) {
            e0(4096);
        }
        this.f8813c = 4096;
    }

    public int g0() {
        if (this.f8814d == 0) {
            return 16;
        }
        b bVar = this.f8816f;
        int i2 = bVar.f8820b;
        int i3 = this.f8815e.f8820b;
        if (i2 >= i3) {
            return (i2 - i3) + 4 + bVar.f8821c + 16;
        }
        return (((i2 + 4) + bVar.f8821c) + this.f8813c) - i3;
    }

    public synchronized void m(d dVar) throws IOException {
        int i2 = this.f8815e.f8820b;
        for (int i3 = 0; i3 < this.f8814d; i3++) {
            b G = G(i2);
            dVar.read(new C0169c(this, G, null), G.f8821c);
            i2 = k0(G.f8820b + 4 + G.f8821c);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f8813c);
        sb.append(", size=");
        sb.append(this.f8814d);
        sb.append(", first=");
        sb.append(this.f8815e);
        sb.append(", last=");
        sb.append(this.f8816f);
        sb.append(", element lengths=[");
        try {
            m(new a(sb));
        } catch (IOException e2) {
            a.log(Level.WARNING, "read error", (Throwable) e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    public synchronized boolean v() {
        return this.f8814d == 0;
    }
}