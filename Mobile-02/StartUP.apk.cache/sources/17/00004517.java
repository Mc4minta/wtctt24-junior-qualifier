package e.b.a;

import java.security.DigestException;
import java.security.MessageDigest;

/* compiled from: MD5.java */
/* loaded from: classes.dex */
public final class a extends MessageDigest implements Cloneable {
    private long a;

    /* renamed from: b  reason: collision with root package name */
    private int f11971b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f11972c;

    /* renamed from: d  reason: collision with root package name */
    private int f11973d;

    /* renamed from: e  reason: collision with root package name */
    private int f11974e;

    /* renamed from: f  reason: collision with root package name */
    private int f11975f;

    /* renamed from: g  reason: collision with root package name */
    private int f11976g;

    public a() {
        super("MD5");
        this.f11972c = new byte[64];
        c();
    }

    /*  JADX ERROR: Type inference failed with exception
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r13v153 ?? I:int)
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:114)
        */
    private final void b(byte[] r28, int r29) {
        /*
            Method dump skipped, instructions count: 1558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.a.b(byte[], int):void");
    }

    protected void c() {
        this.f11973d = 1732584193;
        this.f11974e = -271733879;
        this.f11975f = -1732584194;
        this.f11976g = 271733878;
    }

    @Override // java.security.MessageDigest, java.security.MessageDigestSpi
    public Object clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        aVar.f11972c = (byte[]) this.f11972c.clone();
        return aVar;
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        try {
            byte[] bArr = new byte[16];
            engineDigest(bArr, 0, 16);
            return bArr;
        } catch (DigestException unused) {
            return null;
        }
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return 16;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.f11971b = 0;
        this.a = 0L;
        byte[] bArr = this.f11972c;
        int i2 = 60;
        do {
            bArr[i2 - 4] = 0;
            bArr[i2 - 3] = 0;
            bArr[i2 - 2] = 0;
            bArr[i2 - 1] = 0;
            bArr[i2] = 0;
            bArr[i2 + 1] = 0;
            bArr[i2 + 2] = 0;
            bArr[i2 + 3] = 0;
            i2 -= 8;
        } while (i2 >= 0);
        c();
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b2) {
        this.a++;
        int i2 = this.f11971b;
        if (i2 < 63) {
            byte[] bArr = this.f11972c;
            this.f11971b = i2 + 1;
            bArr[i2] = b2;
            return;
        }
        byte[] bArr2 = this.f11972c;
        bArr2[63] = b2;
        b(bArr2, i2);
        this.f11971b = 0;
    }

    @Override // java.security.MessageDigestSpi
    public int engineDigest(byte[] bArr, int i2, int i3) throws DigestException {
        if (i3 >= 16) {
            if (bArr.length - i2 >= 16) {
                byte[] bArr2 = this.f11972c;
                int i4 = this.f11971b;
                bArr2[i4] = Byte.MIN_VALUE;
                switch (i4) {
                    case 56:
                        bArr2[57] = 0;
                    case 57:
                        bArr2[58] = 0;
                    case 58:
                        bArr2[59] = 0;
                    case 59:
                        bArr2[60] = 0;
                    case 60:
                        bArr2[61] = 0;
                    case 61:
                        bArr2[62] = 0;
                    case 62:
                        bArr2[63] = 0;
                    case 63:
                        b(bArr2, 0);
                        i4 = -1;
                        break;
                }
                switch (i4 & 7) {
                    case 0:
                        i4 += 4;
                        bArr2[i4 - 3] = 0;
                        bArr2[i4 - 2] = 0;
                        bArr2[i4 - 1] = 0;
                        bArr2[i4] = 0;
                        bArr2[i4 + 1] = 0;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 1:
                        i4 += 3;
                        bArr2[i4 - 2] = 0;
                        bArr2[i4 - 1] = 0;
                        bArr2[i4] = 0;
                        bArr2[i4 + 1] = 0;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 2:
                        i4 += 2;
                        bArr2[i4 - 1] = 0;
                        bArr2[i4] = 0;
                        bArr2[i4 + 1] = 0;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 3:
                        i4++;
                        bArr2[i4] = 0;
                        bArr2[i4 + 1] = 0;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 4:
                        bArr2[i4 + 1] = 0;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 5:
                        i4--;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 6:
                        i4 -= 2;
                        bArr2[i4 + 3] = 0;
                        break;
                    case 7:
                        i4 -= 3;
                        break;
                }
                while (true) {
                    i4 += 8;
                    if (i4 <= 52) {
                        bArr2[i4 - 4] = 0;
                        bArr2[i4 - 3] = 0;
                        bArr2[i4 - 2] = 0;
                        bArr2[i4 - 1] = 0;
                        bArr2[i4] = 0;
                        bArr2[i4 + 1] = 0;
                        bArr2[i4 + 2] = 0;
                        bArr2[i4 + 3] = 0;
                    } else {
                        long j2 = this.a;
                        int i5 = ((int) j2) << 3;
                        bArr2[56] = (byte) i5;
                        bArr2[57] = (byte) (i5 >>> 8);
                        bArr2[58] = (byte) (i5 >>> 16);
                        bArr2[59] = (byte) (i5 >>> 24);
                        int i6 = (int) (j2 >>> 29);
                        bArr2[60] = (byte) i6;
                        bArr2[61] = (byte) (i6 >>> 8);
                        bArr2[62] = (byte) (i6 >>> 16);
                        bArr2[63] = (byte) (i6 >>> 24);
                        b(bArr2, 0);
                        int i7 = this.f11973d;
                        bArr[i2] = (byte) i7;
                        bArr[i2 + 1] = (byte) (i7 >>> 8);
                        bArr[i2 + 2] = (byte) (i7 >>> 16);
                        bArr[i2 + 3] = (byte) (i7 >>> 24);
                        int i8 = this.f11974e;
                        bArr[i2 + 4] = (byte) i8;
                        bArr[i2 + 5] = (byte) (i8 >>> 8);
                        int i9 = i2 + 10;
                        bArr[i9 - 4] = (byte) (i8 >>> 16);
                        bArr[i9 - 3] = (byte) (i8 >>> 24);
                        int i10 = this.f11975f;
                        bArr[i9 - 2] = (byte) i10;
                        bArr[i9 - 1] = (byte) (i10 >>> 8);
                        bArr[i9] = (byte) (i10 >>> 16);
                        bArr[i9 + 1] = (byte) (i10 >>> 24);
                        int i11 = this.f11976g;
                        bArr[i9 + 2] = (byte) i11;
                        bArr[i9 + 3] = (byte) (i11 >>> 8);
                        bArr[i9 + 4] = (byte) (i11 >>> 16);
                        bArr[i9 + 5] = (byte) (i11 >>> 24);
                        engineReset();
                        return 16;
                    }
                }
            } else {
                throw new DigestException("insufficient space in output buffer to store the digest");
            }
        } else {
            throw new DigestException("partial digests not returned");
        }
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            this.a += i3;
            int i4 = this.f11971b;
            if (i4 > 0 && i4 + i3 >= 64) {
                int i5 = 64 - i4;
                System.arraycopy(bArr, i2, this.f11972c, i4, i5);
                byte[] bArr2 = this.f11972c;
                this.f11971b = 0;
                b(bArr2, 0);
                i2 += i5;
                i3 -= i5;
            }
            while (i3 >= 512) {
                b(bArr, i2);
                b(bArr, i2 + 64);
                b(bArr, i2 + 128);
                b(bArr, i2 + 192);
                b(bArr, i2 + 256);
                b(bArr, i2 + 320);
                b(bArr, i2 + 384);
                b(bArr, i2 + 448);
                i2 += 512;
                i3 -= 512;
            }
            while (i3 >= 64) {
                b(bArr, i2);
                i2 += 64;
                i3 -= 64;
            }
            if (i3 > 0) {
                System.arraycopy(bArr, i2, this.f11972c, this.f11971b, i3);
                this.f11971b += i3;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i2);
    }
}