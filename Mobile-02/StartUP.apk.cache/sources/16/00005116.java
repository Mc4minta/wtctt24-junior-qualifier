package j;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import okhttp3.internal.connection.RealConnection;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class f implements h, g, Cloneable, ByteChannel {
    public z a;

    /* renamed from: b  reason: collision with root package name */
    private long f17144b;

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Closeable {
        public f a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17145b;

        /* renamed from: c  reason: collision with root package name */
        private z f17146c;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f17148e;

        /* renamed from: d  reason: collision with root package name */
        public long f17147d = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f17149f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f17150g = -1;

        public final z a() {
            return this.f17146c;
        }

        public final int b() {
            long j2 = this.f17147d;
            f fVar = this.a;
            kotlin.jvm.internal.m.e(fVar);
            if (j2 != fVar.O0()) {
                long j3 = this.f17147d;
                return d(j3 == -1 ? 0L : j3 + (this.f17150g - this.f17149f));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long c(long j2) {
            f fVar = this.a;
            if (fVar != null) {
                if (this.f17145b) {
                    long O0 = fVar.O0();
                    int i2 = (j2 > O0 ? 1 : (j2 == O0 ? 0 : -1));
                    int i3 = 1;
                    if (i2 <= 0) {
                        if (j2 >= 0) {
                            long j3 = O0 - j2;
                            while (true) {
                                if (j3 <= 0) {
                                    break;
                                }
                                z zVar = fVar.a;
                                kotlin.jvm.internal.m.e(zVar);
                                z zVar2 = zVar.f17193h;
                                kotlin.jvm.internal.m.e(zVar2);
                                int i4 = zVar2.f17189d;
                                long j4 = i4 - zVar2.f17188c;
                                if (j4 <= j3) {
                                    fVar.a = zVar2.b();
                                    a0.b(zVar2);
                                    j3 -= j4;
                                } else {
                                    zVar2.f17189d = i4 - ((int) j3);
                                    break;
                                }
                            }
                            e(null);
                            this.f17147d = j2;
                            this.f17148e = null;
                            this.f17149f = -1;
                            this.f17150g = -1;
                        } else {
                            throw new IllegalArgumentException(("newSize < 0: " + j2).toString());
                        }
                    } else if (i2 > 0) {
                        long j5 = j2 - O0;
                        boolean z = true;
                        while (j5 > 0) {
                            z S0 = fVar.S0(i3);
                            int min = (int) Math.min(j5, 8192 - S0.f17189d);
                            S0.f17189d += min;
                            j5 -= min;
                            if (z) {
                                e(S0);
                                this.f17147d = O0;
                                this.f17148e = S0.f17187b;
                                int i5 = S0.f17189d;
                                this.f17149f = i5 - min;
                                this.f17150g = i5;
                                z = false;
                            }
                            i3 = 1;
                        }
                    }
                    fVar.M0(j2);
                    return O0;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a != null) {
                this.a = null;
                e(null);
                this.f17147d = -1L;
                this.f17148e = null;
                this.f17149f = -1;
                this.f17150g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int d(long j2) {
            z zVar;
            f fVar = this.a;
            if (fVar != null) {
                if (j2 >= -1 && j2 <= fVar.O0()) {
                    if (j2 != -1 && j2 != fVar.O0()) {
                        long j3 = 0;
                        long O0 = fVar.O0();
                        z zVar2 = fVar.a;
                        if (a() != null) {
                            long j4 = this.f17147d;
                            int i2 = this.f17149f;
                            z a = a();
                            kotlin.jvm.internal.m.e(a);
                            long j5 = j4 - (i2 - a.f17188c);
                            if (j5 > j2) {
                                zVar2 = a();
                                O0 = j5;
                                zVar = zVar2;
                            } else {
                                zVar = a();
                                j3 = j5;
                            }
                        } else {
                            zVar = zVar2;
                        }
                        if (O0 - j2 > j2 - j3) {
                            while (true) {
                                kotlin.jvm.internal.m.e(zVar);
                                int i3 = zVar.f17189d;
                                int i4 = zVar.f17188c;
                                if (j2 < (i3 - i4) + j3) {
                                    break;
                                }
                                j3 += i3 - i4;
                                zVar = zVar.f17192g;
                            }
                        } else {
                            while (O0 > j2) {
                                kotlin.jvm.internal.m.e(zVar2);
                                zVar2 = zVar2.f17193h;
                                kotlin.jvm.internal.m.e(zVar2);
                                O0 -= zVar2.f17189d - zVar2.f17188c;
                            }
                            j3 = O0;
                            zVar = zVar2;
                        }
                        if (this.f17145b) {
                            kotlin.jvm.internal.m.e(zVar);
                            if (zVar.f17190e) {
                                z f2 = zVar.f();
                                if (fVar.a == zVar) {
                                    fVar.a = f2;
                                }
                                zVar = zVar.c(f2);
                                z zVar3 = zVar.f17193h;
                                kotlin.jvm.internal.m.e(zVar3);
                                zVar3.b();
                            }
                        }
                        e(zVar);
                        this.f17147d = j2;
                        kotlin.jvm.internal.m.e(zVar);
                        this.f17148e = zVar.f17187b;
                        int i5 = zVar.f17188c + ((int) (j2 - j3));
                        this.f17149f = i5;
                        int i6 = zVar.f17189d;
                        this.f17150g = i6;
                        return i6 - i5;
                    }
                    e(null);
                    this.f17147d = j2;
                    this.f17148e = null;
                    this.f17149f = -1;
                    this.f17150g = -1;
                    return -1;
                }
                throw new ArrayIndexOutOfBoundsException("offset=" + j2 + " > size=" + fVar.O0());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final void e(z zVar) {
            this.f17146c = zVar;
        }
    }

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return f.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            f.this.R(i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int i2, int i3) {
            kotlin.jvm.internal.m.g(data, "data");
            f.this.write(data, i2, i3);
        }
    }

    public static /* synthetic */ a x0(f fVar, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = new a();
        }
        return fVar.r0(aVar);
    }

    public final byte A(long j2) {
        j.c.b(O0(), j2, 1L);
        z zVar = this.a;
        if (zVar != null) {
            if (O0() - j2 < j2) {
                long O0 = O0();
                while (O0 > j2) {
                    zVar = zVar.f17193h;
                    kotlin.jvm.internal.m.e(zVar);
                    O0 -= zVar.f17189d - zVar.f17188c;
                }
                kotlin.jvm.internal.m.e(zVar);
                return zVar.f17187b[(int) ((zVar.f17188c + j2) - O0)];
            }
            long j3 = 0;
            while (true) {
                long j4 = (zVar.f17189d - zVar.f17188c) + j3;
                if (j4 > j2) {
                    kotlin.jvm.internal.m.e(zVar);
                    return zVar.f17187b[(int) ((zVar.f17188c + j2) - j3)];
                }
                zVar = zVar.f17192g;
                kotlin.jvm.internal.m.e(zVar);
                j3 = j4;
            }
        } else {
            kotlin.jvm.internal.m.e(null);
            throw null;
        }
    }

    @Override // j.h
    public int C() throws EOFException {
        if (O0() >= 4) {
            z zVar = this.a;
            kotlin.jvm.internal.m.e(zVar);
            int i2 = zVar.f17188c;
            int i3 = zVar.f17189d;
            if (i3 - i2 < 4) {
                return ((m0() & 255) << 24) | ((m0() & 255) << 16) | ((m0() & 255) << 8) | (m0() & 255);
            }
            byte[] bArr = zVar.f17187b;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i7 = i5 + 1;
            int i8 = i6 | ((bArr[i5] & 255) << 8);
            int i9 = i7 + 1;
            int i10 = i8 | (bArr[i7] & 255);
            M0(O0() - 4);
            if (i9 == i3) {
                this.a = zVar.b();
                a0.b(zVar);
            } else {
                zVar.f17188c = i9;
            }
            return i10;
        }
        throw new EOFException();
    }

    @Override // j.h
    public String C0() throws EOFException {
        return Z(Long.MAX_VALUE);
    }

    @Override // j.h
    public int D0() throws EOFException {
        return j.c.c(C());
    }

    @Override // j.h
    public byte[] E0(long j2) throws EOFException {
        if (j2 >= 0 && j2 <= ((long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO)) {
            if (O0() >= j2) {
                byte[] bArr = new byte[(int) j2];
                readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    public long G(byte b2, long j2, long j3) {
        z zVar;
        int i2;
        long j4 = 0;
        if (0 <= j2 && j3 >= j2) {
            if (j3 > O0()) {
                j3 = O0();
            }
            if (j2 == j3 || (zVar = this.a) == null) {
                return -1L;
            }
            if (O0() - j2 < j2) {
                j4 = O0();
                while (j4 > j2) {
                    zVar = zVar.f17193h;
                    kotlin.jvm.internal.m.e(zVar);
                    j4 -= zVar.f17189d - zVar.f17188c;
                }
                while (j4 < j3) {
                    byte[] bArr = zVar.f17187b;
                    int min = (int) Math.min(zVar.f17189d, (zVar.f17188c + j3) - j4);
                    i2 = (int) ((zVar.f17188c + j2) - j4);
                    while (i2 < min) {
                        if (bArr[i2] != b2) {
                            i2++;
                        }
                    }
                    j4 += zVar.f17189d - zVar.f17188c;
                    zVar = zVar.f17192g;
                    kotlin.jvm.internal.m.e(zVar);
                    j2 = j4;
                }
                return -1L;
            }
            while (true) {
                long j5 = (zVar.f17189d - zVar.f17188c) + j4;
                if (j5 > j2) {
                    break;
                }
                zVar = zVar.f17192g;
                kotlin.jvm.internal.m.e(zVar);
                j4 = j5;
            }
            while (j4 < j3) {
                byte[] bArr2 = zVar.f17187b;
                int min2 = (int) Math.min(zVar.f17189d, (zVar.f17188c + j3) - j4);
                i2 = (int) ((zVar.f17188c + j2) - j4);
                while (i2 < min2) {
                    if (bArr2[i2] != b2) {
                        i2++;
                    }
                }
                j4 += zVar.f17189d - zVar.f17188c;
                zVar = zVar.f17192g;
                kotlin.jvm.internal.m.e(zVar);
                j2 = j4;
            }
            return -1L;
            return (i2 - zVar.f17188c) + j4;
        }
        throw new IllegalArgumentException(("size=" + O0() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
    }

    @Override // j.h
    public String G0() {
        return J0(this.f17144b, kotlin.l0.d.a);
    }

    @Override // j.h
    public long H() throws EOFException {
        if (O0() >= 8) {
            z zVar = this.a;
            kotlin.jvm.internal.m.e(zVar);
            int i2 = zVar.f17188c;
            int i3 = zVar.f17189d;
            if (i3 - i2 < 8) {
                return ((C() & 4294967295L) << 32) | (4294967295L & C());
            }
            byte[] bArr = zVar.f17187b;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            long j2 = ((bArr[i2] & 255) << 56) | ((bArr[i4] & 255) << 48) | ((bArr[i5] & 255) << 40) | ((bArr[i6] & 255) << 32) | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 16);
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j3 = j2 | ((bArr[i9] & 255) << 8) | (bArr[i10] & 255);
            M0(O0() - 8);
            if (i11 == i3) {
                this.a = zVar.b();
                a0.b(zVar);
            } else {
                zVar.f17188c = i11;
            }
            return j3;
        }
        throw new EOFException();
    }

    @Override // j.h
    public byte[] J() {
        return E0(O0());
    }

    public String J0(long j2, Charset charset) throws EOFException {
        kotlin.jvm.internal.m.g(charset, "charset");
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0 && j2 <= ((long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO)) {
            if (this.f17144b >= j2) {
                if (i2 == 0) {
                    return "";
                }
                z zVar = this.a;
                kotlin.jvm.internal.m.e(zVar);
                int i3 = zVar.f17188c;
                if (i3 + j2 > zVar.f17189d) {
                    return new String(E0(j2), charset);
                }
                int i4 = (int) j2;
                String str = new String(zVar.f17187b, i3, i4, charset);
                int i5 = zVar.f17188c + i4;
                zVar.f17188c = i5;
                this.f17144b -= j2;
                if (i5 == zVar.f17189d) {
                    this.a = zVar.b();
                    a0.b(zVar);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    public long K(i bytes, long j2) throws IOException {
        long j3 = j2;
        kotlin.jvm.internal.m.g(bytes, "bytes");
        if (bytes.Q() > 0) {
            long j4 = 0;
            if (j3 >= 0) {
                z zVar = this.a;
                if (zVar != null) {
                    if (O0() - j3 < j3) {
                        long O0 = O0();
                        while (O0 > j3) {
                            zVar = zVar.f17193h;
                            kotlin.jvm.internal.m.e(zVar);
                            O0 -= zVar.f17189d - zVar.f17188c;
                        }
                        byte[] G = bytes.G();
                        byte b2 = G[0];
                        int Q = bytes.Q();
                        long O02 = (O0() - Q) + 1;
                        while (O0 < O02) {
                            byte[] bArr = zVar.f17187b;
                            long j5 = O0;
                            int min = (int) Math.min(zVar.f17189d, (zVar.f17188c + O02) - O0);
                            for (int i2 = (int) ((zVar.f17188c + j3) - j5); i2 < min; i2++) {
                                if (bArr[i2] == b2 && j.h0.a.c(zVar, i2 + 1, G, 1, Q)) {
                                    return (i2 - zVar.f17188c) + j5;
                                }
                            }
                            O0 = j5 + (zVar.f17189d - zVar.f17188c);
                            zVar = zVar.f17192g;
                            kotlin.jvm.internal.m.e(zVar);
                            j3 = O0;
                        }
                    } else {
                        while (true) {
                            long j6 = (zVar.f17189d - zVar.f17188c) + j4;
                            if (j6 > j3) {
                                break;
                            }
                            zVar = zVar.f17192g;
                            kotlin.jvm.internal.m.e(zVar);
                            j4 = j6;
                        }
                        byte[] G2 = bytes.G();
                        byte b3 = G2[0];
                        int Q2 = bytes.Q();
                        long O03 = (O0() - Q2) + 1;
                        while (j4 < O03) {
                            byte[] bArr2 = zVar.f17187b;
                            long j7 = O03;
                            int min2 = (int) Math.min(zVar.f17189d, (zVar.f17188c + O03) - j4);
                            for (int i3 = (int) ((zVar.f17188c + j3) - j4); i3 < min2; i3++) {
                                if (bArr2[i3] == b3 && j.h0.a.c(zVar, i3 + 1, G2, 1, Q2)) {
                                    return (i3 - zVar.f17188c) + j4;
                                }
                            }
                            j4 += zVar.f17189d - zVar.f17188c;
                            zVar = zVar.f17192g;
                            kotlin.jvm.internal.m.e(zVar);
                            j3 = j4;
                            O03 = j7;
                        }
                    }
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public int L0() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (O0() != 0) {
            byte A = A(0L);
            if ((A & 128) == 0) {
                i2 = A & Byte.MAX_VALUE;
                i4 = 0;
                i3 = 1;
            } else if ((A & 224) == 192) {
                i2 = A & 31;
                i3 = 2;
                i4 = 128;
            } else if ((A & 240) == 224) {
                i2 = A & 15;
                i3 = 3;
                i4 = PKIFailureInfo.wrongIntegrity;
            } else if ((A & 248) != 240) {
                skip(1L);
                return 65533;
            } else {
                i2 = A & 7;
                i3 = 4;
                i4 = 65536;
            }
            long j2 = i3;
            if (O0() >= j2) {
                for (int i5 = 1; i5 < i3; i5++) {
                    long j3 = i5;
                    byte A2 = A(j3);
                    if ((A2 & 192) != 128) {
                        skip(j3);
                        return 65533;
                    }
                    i2 = (i2 << 6) | (A2 & 63);
                }
                skip(j2);
                if (i2 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i2 && 57343 >= i2) || i2 < i4) {
                    return 65533;
                }
                return i2;
            }
            throw new EOFException("size < " + i3 + ": " + O0() + " (to read code point prefixed 0x" + j.c.f(A) + ')');
        }
        throw new EOFException();
    }

    @Override // j.h
    public long M(i bytes) throws IOException {
        kotlin.jvm.internal.m.g(bytes, "bytes");
        return K(bytes, 0L);
    }

    public final void M0(long j2) {
        this.f17144b = j2;
    }

    public long N(i targetBytes, long j2) {
        int i2;
        int i3;
        kotlin.jvm.internal.m.g(targetBytes, "targetBytes");
        long j3 = 0;
        if (j2 >= 0) {
            z zVar = this.a;
            if (zVar != null) {
                if (O0() - j2 < j2) {
                    j3 = O0();
                    while (j3 > j2) {
                        zVar = zVar.f17193h;
                        kotlin.jvm.internal.m.e(zVar);
                        j3 -= zVar.f17189d - zVar.f17188c;
                    }
                    if (targetBytes.Q() == 2) {
                        byte A = targetBytes.A(0);
                        byte A2 = targetBytes.A(1);
                        while (j3 < O0()) {
                            byte[] bArr = zVar.f17187b;
                            i2 = (int) ((zVar.f17188c + j2) - j3);
                            int i4 = zVar.f17189d;
                            while (i2 < i4) {
                                byte b2 = bArr[i2];
                                if (b2 != A && b2 != A2) {
                                    i2++;
                                }
                                i3 = zVar.f17188c;
                            }
                            j3 += zVar.f17189d - zVar.f17188c;
                            zVar = zVar.f17192g;
                            kotlin.jvm.internal.m.e(zVar);
                            j2 = j3;
                        }
                        return -1L;
                    }
                    byte[] G = targetBytes.G();
                    while (j3 < O0()) {
                        byte[] bArr2 = zVar.f17187b;
                        i2 = (int) ((zVar.f17188c + j2) - j3);
                        int i5 = zVar.f17189d;
                        while (i2 < i5) {
                            byte b3 = bArr2[i2];
                            for (byte b4 : G) {
                                if (b3 == b4) {
                                    i3 = zVar.f17188c;
                                }
                            }
                            i2++;
                        }
                        j3 += zVar.f17189d - zVar.f17188c;
                        zVar = zVar.f17192g;
                        kotlin.jvm.internal.m.e(zVar);
                        j2 = j3;
                    }
                    return -1L;
                }
                while (true) {
                    long j4 = (zVar.f17189d - zVar.f17188c) + j3;
                    if (j4 > j2) {
                        break;
                    }
                    zVar = zVar.f17192g;
                    kotlin.jvm.internal.m.e(zVar);
                    j3 = j4;
                }
                if (targetBytes.Q() == 2) {
                    byte A3 = targetBytes.A(0);
                    byte A4 = targetBytes.A(1);
                    while (j3 < O0()) {
                        byte[] bArr3 = zVar.f17187b;
                        i2 = (int) ((zVar.f17188c + j2) - j3);
                        int i6 = zVar.f17189d;
                        while (i2 < i6) {
                            byte b5 = bArr3[i2];
                            if (b5 != A3 && b5 != A4) {
                                i2++;
                            }
                            i3 = zVar.f17188c;
                        }
                        j3 += zVar.f17189d - zVar.f17188c;
                        zVar = zVar.f17192g;
                        kotlin.jvm.internal.m.e(zVar);
                        j2 = j3;
                    }
                    return -1L;
                }
                byte[] G2 = targetBytes.G();
                while (j3 < O0()) {
                    byte[] bArr4 = zVar.f17187b;
                    i2 = (int) ((zVar.f17188c + j2) - j3);
                    int i7 = zVar.f17189d;
                    while (i2 < i7) {
                        byte b6 = bArr4[i2];
                        for (byte b7 : G2) {
                            if (b6 == b7) {
                                i3 = zVar.f17188c;
                            }
                        }
                        i2++;
                    }
                    j3 += zVar.f17189d - zVar.f17188c;
                    zVar = zVar.f17192g;
                    kotlin.jvm.internal.m.e(zVar);
                    j2 = j3;
                }
                return -1L;
                return (i2 - i3) + j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
    }

    public final long O0() {
        return this.f17144b;
    }

    @Override // j.h
    public long P0() throws EOFException {
        return j.c.d(H());
    }

    @Override // j.h
    public boolean Q() {
        return this.f17144b == 0;
    }

    public final i Q0() {
        if (O0() <= ((long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO)) {
            return R0((int) O0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + O0()).toString());
    }

    public final i R0(int i2) {
        if (i2 == 0) {
            return i.a;
        }
        j.c.b(O0(), 0L, i2);
        z zVar = this.a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            kotlin.jvm.internal.m.e(zVar);
            int i6 = zVar.f17189d;
            int i7 = zVar.f17188c;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                zVar = zVar.f17192g;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5];
        int[] iArr = new int[i5 * 2];
        z zVar2 = this.a;
        int i8 = 0;
        while (i3 < i2) {
            kotlin.jvm.internal.m.e(zVar2);
            bArr[i8] = zVar2.f17187b;
            i3 += zVar2.f17189d - zVar2.f17188c;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = zVar2.f17188c;
            zVar2.f17190e = true;
            i8++;
            zVar2 = zVar2.f17192g;
        }
        return new b0(bArr, iArr);
    }

    public final z S0(int i2) {
        boolean z = true;
        if ((i2 < 1 || i2 > 8192) ? false : false) {
            z zVar = this.a;
            if (zVar == null) {
                z c2 = a0.c();
                this.a = c2;
                c2.f17193h = c2;
                c2.f17192g = c2;
                return c2;
            }
            kotlin.jvm.internal.m.e(zVar);
            z zVar2 = zVar.f17193h;
            kotlin.jvm.internal.m.e(zVar2);
            return (zVar2.f17189d + i2 > 8192 || !zVar2.f17191f) ? zVar2.c(a0.c()) : zVar2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // j.h
    public long T0(c0 sink) throws IOException {
        kotlin.jvm.internal.m.g(sink, "sink");
        long O0 = O0();
        if (O0 > 0) {
            sink.write(this, O0);
        }
        return O0;
    }

    @Override // j.h
    public void U(f sink, long j2) throws EOFException {
        kotlin.jvm.internal.m.g(sink, "sink");
        if (O0() >= j2) {
            sink.write(this, j2);
        } else {
            sink.write(this, O0());
            throw new EOFException();
        }
    }

    @Override // j.h
    public short U0() throws EOFException {
        if (O0() >= 2) {
            z zVar = this.a;
            kotlin.jvm.internal.m.e(zVar);
            int i2 = zVar.f17188c;
            int i3 = zVar.f17189d;
            if (i3 - i2 < 2) {
                return (short) (((m0() & 255) << 8) | (m0() & 255));
            }
            byte[] bArr = zVar.f17187b;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            M0(O0() - 2);
            if (i5 == i3) {
                this.a = zVar.b();
                a0.b(zVar);
            } else {
                zVar.f17188c = i5;
            }
            return (short) i6;
        }
        throw new EOFException();
    }

    @Override // j.h
    public long W(i targetBytes) {
        kotlin.jvm.internal.m.g(targetBytes, "targetBytes");
        return N(targetBytes, 0L);
    }

    @Override // j.g
    /* renamed from: W0 */
    public f K0(i byteString) {
        kotlin.jvm.internal.m.g(byteString, "byteString");
        byteString.V(this, 0, byteString.Q());
        return this;
    }

    public f X0(e0 source, long j2) throws IOException {
        kotlin.jvm.internal.m.g(source, "source");
        while (j2 > 0) {
            long read = source.read(this, j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 -= read;
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c1 A[EDGE_INSN: B:50:0x00c1->B:41:0x00c1 ?: BREAK  , SYNTHETIC] */
    @Override // j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long Y() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j.f.Y():long");
    }

    @Override // j.h
    public String Z(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = j2 != Long.MAX_VALUE ? j2 + 1 : Long.MAX_VALUE;
            byte b2 = (byte) 10;
            long G = G(b2, 0L, j3);
            if (G != -1) {
                return j.h0.a.d(this, G);
            }
            if (j3 < O0() && A(j3 - 1) == ((byte) 13) && A(j3) == b2) {
                return j.h0.a.d(this, j3);
            }
            f fVar = new f();
            f(fVar, 0L, Math.min(32, O0()));
            throw new EOFException("\\n not found: limit=" + Math.min(O0(), j2) + " content=" + fVar.v0().F() + (char) 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    @Override // j.h
    public void Z0(long j2) throws EOFException {
        if (this.f17144b < j2) {
            throw new EOFException();
        }
    }

    public final void b() {
        skip(O0());
    }

    /* renamed from: c */
    public f clone() {
        return e();
    }

    @Override // j.g
    public OutputStream c1() {
        return new c();
    }

    @Override // j.e0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final long d() {
        long O0 = O0();
        if (O0 == 0) {
            return 0L;
        }
        z zVar = this.a;
        kotlin.jvm.internal.m.e(zVar);
        z zVar2 = zVar.f17193h;
        kotlin.jvm.internal.m.e(zVar2);
        int i2 = zVar2.f17189d;
        if (i2 < 8192 && zVar2.f17191f) {
            O0 -= i2 - zVar2.f17188c;
        }
        return O0;
    }

    @Override // j.g
    /* renamed from: d1 */
    public f write(byte[] source) {
        kotlin.jvm.internal.m.g(source, "source");
        return write(source, 0, source.length);
    }

    public final f e() {
        f fVar = new f();
        if (O0() != 0) {
            z zVar = this.a;
            kotlin.jvm.internal.m.e(zVar);
            z d2 = zVar.d();
            fVar.a = d2;
            d2.f17193h = d2;
            d2.f17192g = d2;
            for (z zVar2 = zVar.f17192g; zVar2 != zVar; zVar2 = zVar2.f17192g) {
                z zVar3 = d2.f17193h;
                kotlin.jvm.internal.m.e(zVar3);
                kotlin.jvm.internal.m.e(zVar2);
                zVar3.c(zVar2.d());
            }
            fVar.M0(O0());
        }
        return fVar;
    }

    public boolean e0(long j2, i bytes, int i2, int i3) {
        kotlin.jvm.internal.m.g(bytes, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || O0() - j2 < i3 || bytes.Q() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (A(i4 + j2) != bytes.A(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae A[EDGE_INSN: B:42:0x00ae->B:37:0x00ae ?: BREAK  , SYNTHETIC] */
    @Override // j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long e1() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.O0()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb8
            r0 = 0
            r1 = r0
            r4 = r2
        Ld:
            j.z r6 = r14.a
            kotlin.jvm.internal.m.e(r6)
            byte[] r7 = r6.f17187b
            int r8 = r6.f17188c
            int r9 = r6.f17189d
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            j.f r0 = new j.f
            r0.<init>()
            j.f r0 = r0.u0(r4)
            j.f r0 = r0.R(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.G0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = j.c.f(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L9a:
            if (r8 != r9) goto La6
            j.z r7 = r6.b()
            r14.a = r7
            j.a0.b(r6)
            goto La8
        La6:
            r6.f17188c = r8
        La8:
            if (r1 != 0) goto Lae
            j.z r6 = r14.a
            if (r6 != 0) goto Ld
        Lae:
            long r1 = r14.O0()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.M0(r1)
            return r4
        Lb8:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.f.e1():long");
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (O0() != fVar.O0()) {
                return false;
            }
            if (O0() != 0) {
                z zVar = this.a;
                kotlin.jvm.internal.m.e(zVar);
                z zVar2 = fVar.a;
                kotlin.jvm.internal.m.e(zVar2);
                int i2 = zVar.f17188c;
                int i3 = zVar2.f17188c;
                long j2 = 0;
                while (j2 < O0()) {
                    long min = Math.min(zVar.f17189d - i2, zVar2.f17189d - i3);
                    long j3 = 0;
                    while (j3 < min) {
                        int i4 = i2 + 1;
                        int i5 = i3 + 1;
                        if (zVar.f17187b[i2] != zVar2.f17187b[i3]) {
                            return false;
                        }
                        j3++;
                        i2 = i4;
                        i3 = i5;
                    }
                    if (i2 == zVar.f17189d) {
                        zVar = zVar.f17192g;
                        kotlin.jvm.internal.m.e(zVar);
                        i2 = zVar.f17188c;
                    }
                    if (i3 == zVar2.f17189d) {
                        zVar2 = zVar2.f17192g;
                        kotlin.jvm.internal.m.e(zVar2);
                        i3 = zVar2.f17188c;
                    }
                    j2 += min;
                }
            }
        }
        return true;
    }

    public final f f(f out, long j2, long j3) {
        kotlin.jvm.internal.m.g(out, "out");
        j.c.b(O0(), j2, j3);
        if (j3 != 0) {
            out.M0(out.O0() + j3);
            z zVar = this.a;
            while (true) {
                kotlin.jvm.internal.m.e(zVar);
                int i2 = zVar.f17189d;
                int i3 = zVar.f17188c;
                if (j2 < i2 - i3) {
                    break;
                }
                j2 -= i2 - i3;
                zVar = zVar.f17192g;
            }
            while (j3 > 0) {
                kotlin.jvm.internal.m.e(zVar);
                z d2 = zVar.d();
                int i4 = d2.f17188c + ((int) j2);
                d2.f17188c = i4;
                d2.f17189d = Math.min(i4 + ((int) j3), d2.f17189d);
                z zVar2 = out.a;
                if (zVar2 == null) {
                    d2.f17193h = d2;
                    d2.f17192g = d2;
                    out.a = d2;
                } else {
                    kotlin.jvm.internal.m.e(zVar2);
                    z zVar3 = zVar2.f17193h;
                    kotlin.jvm.internal.m.e(zVar3);
                    zVar3.c(d2);
                }
                j3 -= d2.f17189d - d2.f17188c;
                zVar = zVar.f17192g;
                j2 = 0;
            }
        }
        return this;
    }

    @Override // j.g
    /* renamed from: f1 */
    public f write(byte[] source, int i2, int i3) {
        kotlin.jvm.internal.m.g(source, "source");
        long j2 = i3;
        j.c.b(source.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            z S0 = S0(1);
            int min = Math.min(i4 - i2, 8192 - S0.f17189d);
            int i5 = i2 + min;
            kotlin.a0.j.d(source, S0.f17187b, S0.f17189d, i2, i5);
            S0.f17189d += min;
            i2 = i5;
        }
        M0(O0() + j2);
        return this;
    }

    @Override // j.g, j.c0, java.io.Flushable
    public void flush() {
    }

    @Override // j.h
    public InputStream g1() {
        return new b();
    }

    @Override // j.h, j.g
    public f getBuffer() {
        return this;
    }

    @Override // j.h
    public int h1(t options) {
        kotlin.jvm.internal.m.g(options, "options");
        int f2 = j.h0.a.f(this, options, false, 2, null);
        if (f2 == -1) {
            return -1;
        }
        skip(options.m()[f2].Q());
        return f2;
    }

    public int hashCode() {
        z zVar = this.a;
        if (zVar != null) {
            int i2 = 1;
            do {
                int i3 = zVar.f17189d;
                for (int i4 = zVar.f17188c; i4 < i3; i4++) {
                    i2 = (i2 * 31) + zVar.f17187b[i4];
                }
                zVar = zVar.f17192g;
                kotlin.jvm.internal.m.e(zVar);
            } while (zVar != this.a);
            return i2;
        }
        return 0;
    }

    @Override // j.h, j.g
    public f i() {
        return this;
    }

    @Override // j.g
    /* renamed from: i1 */
    public f R(int i2) {
        z S0 = S0(1);
        byte[] bArr = S0.f17187b;
        int i3 = S0.f17189d;
        S0.f17189d = i3 + 1;
        bArr[i3] = (byte) i2;
        M0(O0() + 1);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // j.h
    public boolean j0(long j2, i bytes) {
        kotlin.jvm.internal.m.g(bytes, "bytes");
        return e0(j2, bytes, 0, bytes.Q());
    }

    @Override // j.g
    /* renamed from: j1 */
    public f a1(long j2) {
        int i2;
        int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i3 == 0) {
            return R(48);
        }
        boolean z = false;
        int i4 = 1;
        if (i3 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return h0("-9223372036854775808");
            }
            z = true;
        }
        if (j2 < 100000000) {
            if (j2 >= 10000) {
                i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
            } else if (j2 >= 100) {
                i2 = j2 < 1000 ? 3 : 4;
            } else if (j2 >= 10) {
                i4 = 2;
            }
            i4 = i2;
        } else if (j2 < 1000000000000L) {
            if (j2 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i4 = j2 < 1000000000 ? 9 : 10;
            } else {
                i2 = j2 < 100000000000L ? 11 : 12;
                i4 = i2;
            }
        } else if (j2 >= 1000000000000000L) {
            i4 = j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 < 10000000000000L) {
            i4 = 13;
        } else {
            i2 = j2 < 100000000000000L ? 14 : 15;
            i4 = i2;
        }
        if (z) {
            i4++;
        }
        z S0 = S0(i4);
        byte[] bArr = S0.f17187b;
        int i5 = S0.f17189d + i4;
        while (j2 != 0) {
            long j3 = 10;
            i5--;
            bArr[i5] = j.h0.a.b()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i5 - 1] = (byte) 45;
        }
        S0.f17189d += i4;
        M0(O0() + i4);
        return this;
    }

    @Override // j.g
    /* renamed from: k1 */
    public f u0(long j2) {
        if (j2 == 0) {
            return R(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        z S0 = S0(i2);
        byte[] bArr = S0.f17187b;
        int i3 = S0.f17189d;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = j.h0.a.b()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        S0.f17189d += i2;
        M0(O0() + i2);
        return this;
    }

    @Override // j.h
    public String l0(Charset charset) {
        kotlin.jvm.internal.m.g(charset, "charset");
        return J0(this.f17144b, charset);
    }

    @Override // j.g
    /* renamed from: l1 */
    public f D(int i2) {
        z S0 = S0(4);
        byte[] bArr = S0.f17187b;
        int i3 = S0.f17189d;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        S0.f17189d = i6 + 1;
        M0(O0() + 4);
        return this;
    }

    @Override // j.h
    public byte m0() throws EOFException {
        if (O0() != 0) {
            z zVar = this.a;
            kotlin.jvm.internal.m.e(zVar);
            int i2 = zVar.f17188c;
            int i3 = zVar.f17189d;
            int i4 = i2 + 1;
            byte b2 = zVar.f17187b[i2];
            M0(O0() - 1);
            if (i4 == i3) {
                this.a = zVar.b();
                a0.b(zVar);
            } else {
                zVar.f17188c = i4;
            }
            return b2;
        }
        throw new EOFException();
    }

    @Override // j.g
    /* renamed from: m1 */
    public f P(int i2) {
        return D(j.c.c(i2));
    }

    @Override // j.g
    /* renamed from: n */
    public f w() {
        return this;
    }

    public int n0(byte[] sink, int i2, int i3) {
        kotlin.jvm.internal.m.g(sink, "sink");
        j.c.b(sink.length, i2, i3);
        z zVar = this.a;
        if (zVar != null) {
            int min = Math.min(i3, zVar.f17189d - zVar.f17188c);
            byte[] bArr = zVar.f17187b;
            int i4 = zVar.f17188c;
            kotlin.a0.j.d(bArr, sink, i2, i4, i4 + min);
            zVar.f17188c += min;
            M0(O0() - min);
            if (zVar.f17188c == zVar.f17189d) {
                this.a = zVar.b();
                a0.b(zVar);
                return min;
            }
            return min;
        }
        return -1;
    }

    public f n1(long j2) {
        z S0 = S0(8);
        byte[] bArr = S0.f17187b;
        int i2 = S0.f17189d;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        S0.f17189d = i9 + 1;
        M0(O0() + 8);
        return this;
    }

    @Override // j.g
    /* renamed from: o1 */
    public f F(long j2) {
        return n1(j.c.d(j2));
    }

    @Override // j.h
    public String p(long j2) throws EOFException {
        return J0(j2, kotlin.l0.d.a);
    }

    @Override // j.g
    /* renamed from: p1 */
    public f x(int i2) {
        z S0 = S0(2);
        byte[] bArr = S0.f17187b;
        int i3 = S0.f17189d;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        S0.f17189d = i4 + 1;
        M0(O0() + 2);
        return this;
    }

    @Override // j.h
    public h peek() {
        return q.d(new v(this));
    }

    public f q1(String string, int i2, int i3, Charset charset) {
        kotlin.jvm.internal.m.g(string, "string");
        kotlin.jvm.internal.m.g(charset, "charset");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (i3 <= string.length()) {
                if (kotlin.jvm.internal.m.c(charset, kotlin.l0.d.a)) {
                    return q0(string, i2, i3);
                }
                String substring = string.substring(i2, i3);
                kotlin.jvm.internal.m.f(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
                byte[] bytes = substring.getBytes(charset);
                kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
                return write(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + string.length()).toString());
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    public final a r0(a unsafeCursor) {
        kotlin.jvm.internal.m.g(unsafeCursor, "unsafeCursor");
        return j.h0.a.a(this, unsafeCursor);
    }

    public f r1(String string, Charset charset) {
        kotlin.jvm.internal.m.g(string, "string");
        kotlin.jvm.internal.m.g(charset, "charset");
        return q1(string, 0, string.length(), charset);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        kotlin.jvm.internal.m.g(sink, "sink");
        z zVar = this.a;
        if (zVar != null) {
            int min = Math.min(sink.remaining(), zVar.f17189d - zVar.f17188c);
            sink.put(zVar.f17187b, zVar.f17188c, min);
            int i2 = zVar.f17188c + min;
            zVar.f17188c = i2;
            this.f17144b -= min;
            if (i2 == zVar.f17189d) {
                this.a = zVar.b();
                a0.b(zVar);
            }
            return min;
        }
        return -1;
    }

    @Override // j.h
    public void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.m.g(sink, "sink");
        int i2 = 0;
        while (i2 < sink.length) {
            int n0 = n0(sink, i2, sink.length - i2);
            if (n0 == -1) {
                throw new EOFException();
            }
            i2 += n0;
        }
    }

    @Override // j.h
    public boolean request(long j2) {
        return this.f17144b >= j2;
    }

    @Override // j.h
    public i s(long j2) throws EOFException {
        if (j2 >= 0 && j2 <= ((long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO)) {
            if (O0() >= j2) {
                if (j2 >= 4096) {
                    i R0 = R0((int) j2);
                    skip(j2);
                    return R0;
                }
                return new i(E0(j2));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j2).toString());
    }

    @Override // j.g
    /* renamed from: s1 */
    public f h0(String string) {
        kotlin.jvm.internal.m.g(string, "string");
        return q0(string, 0, string.length());
    }

    @Override // j.h
    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            z zVar = this.a;
            if (zVar != null) {
                int min = (int) Math.min(j2, zVar.f17189d - zVar.f17188c);
                long j3 = min;
                M0(O0() - j3);
                j2 -= j3;
                int i2 = zVar.f17188c + min;
                zVar.f17188c = i2;
                if (i2 == zVar.f17189d) {
                    this.a = zVar.b();
                    a0.b(zVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // j.g
    public long t0(e0 source) throws IOException {
        kotlin.jvm.internal.m.g(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(this, (long) PKIFailureInfo.certRevoked);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    @Override // j.g
    /* renamed from: t1 */
    public f q0(String string, int i2, int i3) {
        kotlin.jvm.internal.m.g(string, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (i3 >= i2) {
            if (!(i3 <= string.length())) {
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + string.length()).toString());
            }
            while (i2 < i3) {
                char charAt = string.charAt(i2);
                if (charAt < 128) {
                    z S0 = S0(1);
                    byte[] bArr = S0.f17187b;
                    int i4 = S0.f17189d - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = string.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) charAt2;
                        i5++;
                    }
                    int i6 = S0.f17189d;
                    int i7 = (i4 + i5) - i6;
                    S0.f17189d = i6 + i7;
                    M0(O0() + i7);
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        z S02 = S0(2);
                        byte[] bArr2 = S02.f17187b;
                        int i8 = S02.f17189d;
                        bArr2[i8] = (byte) ((charAt >> 6) | 192);
                        bArr2[i8 + 1] = (byte) ((charAt & '?') | 128);
                        S02.f17189d = i8 + 2;
                        M0(O0() + 2);
                    } else if (charAt >= 55296 && charAt <= 57343) {
                        int i9 = i2 + 1;
                        char charAt3 = i9 < i3 ? string.charAt(i9) : (char) 0;
                        if (charAt <= 56319 && 56320 <= charAt3 && 57343 >= charAt3) {
                            int i10 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                            z S03 = S0(4);
                            byte[] bArr3 = S03.f17187b;
                            int i11 = S03.f17189d;
                            bArr3[i11] = (byte) ((i10 >> 18) | 240);
                            bArr3[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                            bArr3[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                            bArr3[i11 + 3] = (byte) ((i10 & 63) | 128);
                            S03.f17189d = i11 + 4;
                            M0(O0() + 4);
                            i2 += 2;
                        } else {
                            R(63);
                            i2 = i9;
                        }
                    } else {
                        z S04 = S0(3);
                        byte[] bArr4 = S04.f17187b;
                        int i12 = S04.f17189d;
                        bArr4[i12] = (byte) ((charAt >> '\f') | 224);
                        bArr4[i12 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                        bArr4[i12 + 2] = (byte) ((charAt & '?') | 128);
                        S04.f17189d = i12 + 3;
                        M0(O0() + 3);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
    }

    @Override // j.e0
    public f0 timeout() {
        return f0.NONE;
    }

    public String toString() {
        return Q0().toString();
    }

    public f u1(int i2) {
        if (i2 < 128) {
            R(i2);
        } else if (i2 < 2048) {
            z S0 = S0(2);
            byte[] bArr = S0.f17187b;
            int i3 = S0.f17189d;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            S0.f17189d = i3 + 2;
            M0(O0() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            R(63);
        } else if (i2 < 65536) {
            z S02 = S0(3);
            byte[] bArr2 = S02.f17187b;
            int i4 = S02.f17189d;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            S02.f17189d = i4 + 3;
            M0(O0() + 3);
        } else if (i2 <= 1114111) {
            z S03 = S0(4);
            byte[] bArr3 = S03.f17187b;
            int i5 = S03.f17189d;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            S03.f17189d = i5 + 4;
            M0(O0() + 4);
        } else {
            throw new IllegalArgumentException("Unexpected code point: 0x" + j.c.g(i2));
        }
        return this;
    }

    @Override // j.g
    /* renamed from: v */
    public f X() {
        return this;
    }

    @Override // j.h
    public i v0() {
        return s(O0());
    }

    public short y0() throws EOFException {
        return j.c.e(U0());
    }

    /* compiled from: Buffer.kt */
    /* loaded from: classes3.dex */
    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(f.this.O0(), (long) RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (f.this.O0() > 0) {
                return f.this.m0() & 255;
            }
            return -1;
        }

        public String toString() {
            return f.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int i2, int i3) {
            kotlin.jvm.internal.m.g(sink, "sink");
            return f.this.n0(sink, i2, i3);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        kotlin.jvm.internal.m.g(source, "source");
        int remaining = source.remaining();
        int i2 = remaining;
        while (i2 > 0) {
            z S0 = S0(1);
            int min = Math.min(i2, 8192 - S0.f17189d);
            source.get(S0.f17187b, S0.f17189d, min);
            i2 -= min;
            S0.f17189d += min;
        }
        this.f17144b += remaining;
        return remaining;
    }

    @Override // j.e0
    public long read(f sink, long j2) {
        kotlin.jvm.internal.m.g(sink, "sink");
        if (j2 >= 0) {
            if (O0() == 0) {
                return -1L;
            }
            if (j2 > O0()) {
                j2 = O0();
            }
            sink.write(this, j2);
            return j2;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.c0
    public void write(f source, long j2) {
        z zVar;
        z zVar2;
        kotlin.jvm.internal.m.g(source, "source");
        if (source != this) {
            j.c.b(source.O0(), 0L, j2);
            while (j2 > 0) {
                z zVar3 = source.a;
                kotlin.jvm.internal.m.e(zVar3);
                int i2 = zVar3.f17189d;
                kotlin.jvm.internal.m.e(source.a);
                if (j2 < i2 - zVar.f17188c) {
                    z zVar4 = this.a;
                    if (zVar4 != null) {
                        kotlin.jvm.internal.m.e(zVar4);
                        zVar2 = zVar4.f17193h;
                    } else {
                        zVar2 = null;
                    }
                    if (zVar2 != null && zVar2.f17191f) {
                        if ((zVar2.f17189d + j2) - (zVar2.f17190e ? 0 : zVar2.f17188c) <= ((long) PKIFailureInfo.certRevoked)) {
                            z zVar5 = source.a;
                            kotlin.jvm.internal.m.e(zVar5);
                            zVar5.g(zVar2, (int) j2);
                            source.M0(source.O0() - j2);
                            M0(O0() + j2);
                            return;
                        }
                    }
                    z zVar6 = source.a;
                    kotlin.jvm.internal.m.e(zVar6);
                    source.a = zVar6.e((int) j2);
                }
                z zVar7 = source.a;
                kotlin.jvm.internal.m.e(zVar7);
                long j3 = zVar7.f17189d - zVar7.f17188c;
                source.a = zVar7.b();
                z zVar8 = this.a;
                if (zVar8 == null) {
                    this.a = zVar7;
                    zVar7.f17193h = zVar7;
                    zVar7.f17192g = zVar7;
                } else {
                    kotlin.jvm.internal.m.e(zVar8);
                    z zVar9 = zVar8.f17193h;
                    kotlin.jvm.internal.m.e(zVar9);
                    zVar9.c(zVar7).a();
                }
                source.M0(source.O0() - j3);
                M0(O0() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}