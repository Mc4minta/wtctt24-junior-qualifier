package j.h0;

import j.f;
import j.t;
import j.z;
import kotlin.jvm.internal.m;

/* compiled from: Buffer.kt */
/* loaded from: classes3.dex */
public final class a {
    private static final byte[] a = j.b.a("0123456789abcdef");

    public static final f.a a(f commonReadAndWriteUnsafe, f.a unsafeCursor) {
        m.g(commonReadAndWriteUnsafe, "$this$commonReadAndWriteUnsafe");
        m.g(unsafeCursor, "unsafeCursor");
        if (unsafeCursor.a == null) {
            unsafeCursor.a = commonReadAndWriteUnsafe;
            unsafeCursor.f17145b = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte[] b() {
        return a;
    }

    public static final boolean c(z segment, int i2, byte[] bytes, int i3, int i4) {
        m.g(segment, "segment");
        m.g(bytes, "bytes");
        int i5 = segment.f17189d;
        byte[] bArr = segment.f17187b;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.f17192g;
                m.e(segment);
                byte[] bArr2 = segment.f17187b;
                bArr = bArr2;
                i2 = segment.f17188c;
                i5 = segment.f17189d;
            }
            if (bArr[i2] != bytes[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public static final String d(f readUtf8Line, long j2) {
        m.g(readUtf8Line, "$this$readUtf8Line");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (readUtf8Line.A(j3) == ((byte) 13)) {
                String p = readUtf8Line.p(j3);
                readUtf8Line.skip(2L);
                return p;
            }
        }
        String p2 = readUtf8Line.p(j2);
        readUtf8Line.skip(1L);
        return p2;
    }

    public static final int e(f selectPrefix, t options, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        z zVar;
        m.g(selectPrefix, "$this$selectPrefix");
        m.g(options, "options");
        z zVar2 = selectPrefix.a;
        if (zVar2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = zVar2.f17187b;
        int i6 = zVar2.f17188c;
        int i7 = zVar2.f17189d;
        int[] o = options.o();
        z zVar3 = zVar2;
        int i8 = -1;
        int i9 = 0;
        loop0: while (true) {
            int i10 = i9 + 1;
            int i11 = o[i9];
            int i12 = i10 + 1;
            int i13 = o[i10];
            if (i13 != -1) {
                i8 = i13;
            }
            if (zVar3 == null) {
                break;
            }
            if (i11 >= 0) {
                i2 = i6 + 1;
                int i14 = bArr[i6] & 255;
                int i15 = i12 + i11;
                while (i12 != i15) {
                    if (i14 == o[i12]) {
                        i3 = o[i12 + i11];
                        if (i2 == i7) {
                            zVar3 = zVar3.f17192g;
                            m.e(zVar3);
                            i2 = zVar3.f17188c;
                            bArr = zVar3.f17187b;
                            i7 = zVar3.f17189d;
                            if (zVar3 == zVar2) {
                                zVar3 = null;
                            }
                        }
                    } else {
                        i12++;
                    }
                }
                return i8;
            }
            int i16 = i12 + (i11 * (-1));
            while (true) {
                int i17 = i6 + 1;
                int i18 = i12 + 1;
                if ((bArr[i6] & 255) != o[i12]) {
                    return i8;
                }
                boolean z2 = i18 == i16;
                if (i17 == i7) {
                    m.e(zVar3);
                    z zVar4 = zVar3.f17192g;
                    m.e(zVar4);
                    i5 = zVar4.f17188c;
                    byte[] bArr2 = zVar4.f17187b;
                    i4 = zVar4.f17189d;
                    if (zVar4 != zVar2) {
                        zVar = zVar4;
                        bArr = bArr2;
                    } else if (!z2) {
                        break loop0;
                    } else {
                        bArr = bArr2;
                        zVar = null;
                    }
                } else {
                    z zVar5 = zVar3;
                    i4 = i7;
                    i5 = i17;
                    zVar = zVar5;
                }
                if (z2) {
                    i3 = o[i18];
                    i2 = i5;
                    i7 = i4;
                    zVar3 = zVar;
                    break;
                }
                i6 = i5;
                i7 = i4;
                i12 = i18;
                zVar3 = zVar;
            }
            if (i3 >= 0) {
                return i3;
            }
            i9 = -i3;
            i6 = i2;
        }
        if (z) {
            return -2;
        }
        return i8;
    }

    public static /* synthetic */ int f(f fVar, t tVar, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return e(fVar, tVar, z);
    }
}