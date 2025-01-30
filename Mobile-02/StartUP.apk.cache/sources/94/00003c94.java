package com.google.protobuf;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* compiled from: CodedInputStream.java */
/* loaded from: classes2.dex */
public final class f {
    private final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9694b;

    /* renamed from: c  reason: collision with root package name */
    private int f9695c;

    /* renamed from: d  reason: collision with root package name */
    private int f9696d;

    /* renamed from: e  reason: collision with root package name */
    private int f9697e;

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f9698f;

    /* renamed from: g  reason: collision with root package name */
    private int f9699g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9700h;

    /* renamed from: i  reason: collision with root package name */
    private int f9701i;

    /* renamed from: j  reason: collision with root package name */
    private int f9702j;

    /* renamed from: k  reason: collision with root package name */
    private int f9703k;

    /* renamed from: l  reason: collision with root package name */
    private int f9704l;
    private int m;
    private a n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CodedInputStream.java */
    /* loaded from: classes2.dex */
    public interface a {
        void onRefill();
    }

    private f(byte[] bArr, int i2, int i3, boolean z) {
        this.f9700h = false;
        this.f9702j = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f9704l = 100;
        this.m = 67108864;
        this.n = null;
        this.a = bArr;
        this.f9695c = i3 + i2;
        this.f9697e = i2;
        this.f9701i = -i2;
        this.f9698f = null;
        this.f9694b = z;
    }

    private void A() {
        int i2 = this.f9695c + this.f9696d;
        this.f9695c = i2;
        int i3 = this.f9701i + i2;
        int i4 = this.f9702j;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f9696d = i5;
            this.f9695c = i2 - i5;
            return;
        }
        this.f9696d = 0;
    }

    private void B(int i2) throws IOException {
        if (!I(i2)) {
            throw InvalidProtocolBufferException.j();
        }
    }

    private void F(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f9701i;
            int i4 = this.f9697e;
            int i5 = i3 + i4 + i2;
            int i6 = this.f9702j;
            if (i5 <= i6) {
                int i7 = this.f9695c;
                int i8 = i7 - i4;
                this.f9697e = i7;
                B(1);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.f9695c;
                    if (i9 > i10) {
                        i8 += i10;
                        this.f9697e = i10;
                        B(1);
                    } else {
                        this.f9697e = i9;
                        return;
                    }
                }
            } else {
                E((i6 - i3) - i4);
                throw InvalidProtocolBufferException.j();
            }
        } else {
            throw InvalidProtocolBufferException.f();
        }
    }

    private void G() throws IOException {
        int i2 = this.f9695c;
        int i3 = this.f9697e;
        if (i2 - i3 >= 10) {
            byte[] bArr = this.a;
            int i4 = 0;
            while (i4 < 10) {
                int i5 = i3 + 1;
                if (bArr[i3] >= 0) {
                    this.f9697e = i5;
                    return;
                } else {
                    i4++;
                    i3 = i5;
                }
            }
        }
        H();
    }

    private void H() throws IOException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (q() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.e();
    }

    private boolean I(int i2) throws IOException {
        int i3 = this.f9697e;
        if (i3 + i2 > this.f9695c) {
            if (this.f9701i + i3 + i2 > this.f9702j) {
                return false;
            }
            a aVar = this.n;
            if (aVar != null) {
                aVar.onRefill();
            }
            if (this.f9698f != null) {
                int i4 = this.f9697e;
                if (i4 > 0) {
                    int i5 = this.f9695c;
                    if (i5 > i4) {
                        byte[] bArr = this.a;
                        System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                    }
                    this.f9701i += i4;
                    this.f9695c -= i4;
                    this.f9697e = 0;
                }
                InputStream inputStream = this.f9698f;
                byte[] bArr2 = this.a;
                int i6 = this.f9695c;
                int read = inputStream.read(bArr2, i6, bArr2.length - i6);
                if (read == 0 || read < -1 || read > this.a.length) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read > 0) {
                    this.f9695c += read;
                    if ((this.f9701i + i2) - this.m <= 0) {
                        A();
                        if (this.f9695c >= i2) {
                            return true;
                        }
                        return I(i2);
                    }
                    throw InvalidProtocolBufferException.i();
                }
            }
            return false;
        }
        throw new IllegalStateException("refillBuffer() called when " + i2 + " bytes were already available in buffer");
    }

    public static f c(InputStream inputStream) {
        return new f(inputStream, 4096);
    }

    public static f d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static f e(byte[] bArr, int i2, int i3) {
        return f(bArr, i2, i3, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f f(byte[] bArr, int i2, int i3, boolean z) {
        f fVar = new f(bArr, i2, i3, z);
        try {
            fVar.h(i3);
            return fVar;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    private byte[] r(int i2) throws IOException {
        if (i2 <= 0) {
            if (i2 == 0) {
                return k.f9729c;
            }
            throw InvalidProtocolBufferException.f();
        }
        int i3 = this.f9701i;
        int i4 = this.f9697e;
        int i5 = i3 + i4 + i2;
        if (i5 <= this.m) {
            int i6 = this.f9702j;
            if (i5 <= i6) {
                InputStream inputStream = this.f9698f;
                if (inputStream != null) {
                    int i7 = this.f9695c;
                    int i8 = i7 - i4;
                    this.f9701i = i3 + i7;
                    this.f9697e = 0;
                    this.f9695c = 0;
                    int i9 = i2 - i8;
                    if (i9 >= 4096 && i9 > inputStream.available()) {
                        ArrayList<byte[]> arrayList = new ArrayList();
                        while (i9 > 0) {
                            int min = Math.min(i9, 4096);
                            byte[] bArr = new byte[min];
                            int i10 = 0;
                            while (i10 < min) {
                                int read = this.f9698f.read(bArr, i10, min - i10);
                                if (read == -1) {
                                    throw InvalidProtocolBufferException.j();
                                }
                                this.f9701i += read;
                                i10 += read;
                            }
                            i9 -= min;
                            arrayList.add(bArr);
                        }
                        byte[] bArr2 = new byte[i2];
                        System.arraycopy(this.a, i4, bArr2, 0, i8);
                        for (byte[] bArr3 : arrayList) {
                            System.arraycopy(bArr3, 0, bArr2, i8, bArr3.length);
                            i8 += bArr3.length;
                        }
                        return bArr2;
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.a, i4, bArr4, 0, i8);
                    while (i8 < i2) {
                        int read2 = this.f9698f.read(bArr4, i8, i2 - i8);
                        if (read2 == -1) {
                            throw InvalidProtocolBufferException.j();
                        }
                        this.f9701i += read2;
                        i8 += read2;
                    }
                    return bArr4;
                }
                throw InvalidProtocolBufferException.j();
            }
            E((i6 - i3) - i4);
            throw InvalidProtocolBufferException.j();
        }
        throw InvalidProtocolBufferException.i();
    }

    public boolean C(int i2) throws IOException {
        int b2 = y.b(i2);
        if (b2 == 0) {
            G();
            return true;
        } else if (b2 == 1) {
            E(8);
            return true;
        } else if (b2 == 2) {
            E(u());
            return true;
        } else if (b2 == 3) {
            D();
            a(y.c(y.a(i2), 4));
            return true;
        } else if (b2 != 4) {
            if (b2 == 5) {
                E(4);
                return true;
            }
            throw InvalidProtocolBufferException.d();
        } else {
            return false;
        }
    }

    public void D() throws IOException {
        int z;
        do {
            z = z();
            if (z == 0) {
                return;
            }
        } while (C(z));
    }

    public void E(int i2) throws IOException {
        int i3 = this.f9695c;
        int i4 = this.f9697e;
        if (i2 <= i3 - i4 && i2 >= 0) {
            this.f9697e = i4 + i2;
        } else {
            F(i2);
        }
    }

    public void a(int i2) throws InvalidProtocolBufferException {
        if (this.f9699g != i2) {
            throw InvalidProtocolBufferException.a();
        }
    }

    public boolean b() throws IOException {
        return this.f9697e == this.f9695c && !I(1);
    }

    public void g(int i2) {
        this.f9702j = i2;
        A();
    }

    public int h(int i2) throws InvalidProtocolBufferException {
        if (i2 >= 0) {
            int i3 = i2 + this.f9701i + this.f9697e;
            int i4 = this.f9702j;
            if (i3 <= i4) {
                this.f9702j = i3;
                A();
                return i4;
            }
            throw InvalidProtocolBufferException.j();
        }
        throw InvalidProtocolBufferException.f();
    }

    public boolean i() throws IOException {
        return v() != 0;
    }

    public e j() throws IOException {
        e l2;
        int u = u();
        int i2 = this.f9695c;
        int i3 = this.f9697e;
        if (u > i2 - i3 || u <= 0) {
            if (u == 0) {
                return e.a;
            }
            return e.w(r(u));
        }
        if (this.f9694b && this.f9700h) {
            l2 = e.x(this.a, i3, u);
        } else {
            l2 = e.l(this.a, i3, u);
        }
        this.f9697e += u;
        return l2;
    }

    public int k() throws IOException {
        return u();
    }

    public int l() throws IOException {
        return s();
    }

    public long m() throws IOException {
        return t();
    }

    public int n() throws IOException {
        return u();
    }

    public long o() throws IOException {
        return v();
    }

    public <T extends n> T p(q<T> qVar, h hVar) throws IOException {
        int u = u();
        if (this.f9703k < this.f9704l) {
            int h2 = h(u);
            this.f9703k++;
            T b2 = qVar.b(this, hVar);
            a(0);
            this.f9703k--;
            g(h2);
            return b2;
        }
        throw InvalidProtocolBufferException.g();
    }

    public byte q() throws IOException {
        if (this.f9697e == this.f9695c) {
            B(1);
        }
        byte[] bArr = this.a;
        int i2 = this.f9697e;
        this.f9697e = i2 + 1;
        return bArr[i2];
    }

    public int s() throws IOException {
        int i2 = this.f9697e;
        if (this.f9695c - i2 < 4) {
            B(4);
            i2 = this.f9697e;
        }
        byte[] bArr = this.a;
        this.f9697e = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public long t() throws IOException {
        int i2 = this.f9697e;
        if (this.f9695c - i2 < 8) {
            B(8);
            i2 = this.f9697e;
        }
        byte[] bArr = this.a;
        this.f9697e = i2 + 8;
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int u() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f9697e
            int r1 = r5.f9695c
            if (r1 != r0) goto L7
            goto L6a
        L7:
            byte[] r2 = r5.a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.f9697e = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L18
            goto L6a
        L18:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L24
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L70
        L24:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L31
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2f:
            r1 = r3
            goto L70
        L31:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L70
        L3f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L70
        L6a:
            long r0 = r5.w()
            int r0 = (int) r0
            return r0
        L70:
            r5.f9697e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.u():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if (r2[r0] < 0) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long v() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.v():long");
    }

    long w() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte q = q();
            j2 |= (q & Byte.MAX_VALUE) << i2;
            if ((q & 128) == 0) {
                return j2;
            }
        }
        throw InvalidProtocolBufferException.e();
    }

    public String x() throws IOException {
        int u = u();
        int i2 = this.f9695c;
        if (u <= i2 - this.f9697e && u > 0) {
            String str = new String(this.a, this.f9697e, u, k.a);
            this.f9697e += u;
            return str;
        } else if (u == 0) {
            return "";
        } else {
            if (u <= i2) {
                B(u);
                String str2 = new String(this.a, this.f9697e, u, k.a);
                this.f9697e += u;
                return str2;
            }
            return new String(r(u), k.a);
        }
    }

    public String y() throws IOException {
        byte[] r;
        int u = u();
        int i2 = this.f9697e;
        int i3 = this.f9695c;
        if (u <= i3 - i2 && u > 0) {
            r = this.a;
            this.f9697e = i2 + u;
        } else if (u == 0) {
            return "";
        } else {
            if (u <= i3) {
                B(u);
                r = this.a;
                this.f9697e = u + 0;
            } else {
                r = r(u);
            }
            i2 = 0;
        }
        if (x.i(r, i2, i2 + u)) {
            return new String(r, i2, u, k.a);
        }
        throw InvalidProtocolBufferException.c();
    }

    public int z() throws IOException {
        if (b()) {
            this.f9699g = 0;
            return 0;
        }
        int u = u();
        this.f9699g = u;
        if (y.a(u) != 0) {
            return this.f9699g;
        }
        throw InvalidProtocolBufferException.b();
    }

    private f(InputStream inputStream, int i2) {
        this.f9700h = false;
        this.f9702j = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
        this.f9704l = 100;
        this.m = 67108864;
        this.n = null;
        this.a = new byte[i2];
        this.f9697e = 0;
        this.f9701i = 0;
        this.f9698f = inputStream;
        this.f9694b = false;
    }
}