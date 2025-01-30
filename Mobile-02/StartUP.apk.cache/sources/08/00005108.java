package j;

import j.i;
import java.util.Arrays;

/* compiled from: -Base64.kt */
/* loaded from: classes3.dex */
public final class a {
    private static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f17135b;

    static {
        i.a aVar = i.f17151b;
        a = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").B();
        f17135b = aVar.d("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").B();
    }

    public static final byte[] a(String decodeBase64ToArray) {
        int i2;
        char charAt;
        kotlin.jvm.internal.m.g(decodeBase64ToArray, "$this$decodeBase64ToArray");
        int length = decodeBase64ToArray.length();
        while (length > 0 && ((charAt = decodeBase64ToArray.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i3 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char charAt2 = decodeBase64ToArray.charAt(i7);
            if ('A' <= charAt2 && 'Z' >= charAt2) {
                i2 = charAt2 - 'A';
            } else if ('a' <= charAt2 && 'z' >= charAt2) {
                i2 = charAt2 - 'G';
            } else if ('0' <= charAt2 && '9' >= charAt2) {
                i2 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i2 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i2 = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i5 = (i5 << 6) | i2;
            i4++;
            if (i4 % 4 == 0) {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i5 >> 16);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >> 8);
                bArr[i9] = (byte) i5;
                i6 = i9 + 1;
            }
        }
        int i10 = i4 % 4;
        if (i10 != 1) {
            if (i10 == 2) {
                bArr[i6] = (byte) ((i5 << 12) >> 16);
                i6++;
            } else if (i10 == 3) {
                int i11 = i5 << 6;
                int i12 = i6 + 1;
                bArr[i6] = (byte) (i11 >> 16);
                i6 = i12 + 1;
                bArr[i12] = (byte) (i11 >> 8);
            }
            if (i6 == i3) {
                return bArr;
            }
            byte[] copyOf = Arrays.copyOf(bArr, i6);
            kotlin.jvm.internal.m.f(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            return copyOf;
        }
        return null;
    }

    public static final String b(byte[] encodeBase64, byte[] map) {
        kotlin.jvm.internal.m.g(encodeBase64, "$this$encodeBase64");
        kotlin.jvm.internal.m.g(map, "map");
        byte[] bArr = new byte[((encodeBase64.length + 2) / 3) * 4];
        int length = encodeBase64.length - (encodeBase64.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            byte b2 = encodeBase64[i2];
            int i5 = i4 + 1;
            byte b3 = encodeBase64[i4];
            int i6 = i5 + 1;
            byte b4 = encodeBase64[i5];
            int i7 = i3 + 1;
            bArr[i3] = map[(b2 & 255) >> 2];
            int i8 = i7 + 1;
            bArr[i7] = map[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i9 = i8 + 1;
            bArr[i8] = map[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i3 = i9 + 1;
            bArr[i9] = map[b4 & 63];
            i2 = i6;
        }
        int length2 = encodeBase64.length - length;
        if (length2 == 1) {
            byte b5 = encodeBase64[i2];
            int i10 = i3 + 1;
            bArr[i3] = map[(b5 & 255) >> 2];
            int i11 = i10 + 1;
            bArr[i10] = map[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr[i11] = b6;
            bArr[i11 + 1] = b6;
        } else if (length2 == 2) {
            int i12 = i2 + 1;
            byte b7 = encodeBase64[i2];
            byte b8 = encodeBase64[i12];
            int i13 = i3 + 1;
            bArr[i3] = map[(b7 & 255) >> 2];
            int i14 = i13 + 1;
            bArr[i13] = map[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr[i14] = map[(b8 & 15) << 2];
            bArr[i14 + 1] = (byte) 61;
        }
        return b.b(bArr);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bArr2 = a;
        }
        return b(bArr, bArr2);
    }
}