package com.coinbase.wallet.core.extensions;

import android.util.Base64;
import kotlin.Metadata;

/* compiled from: ByteArray+Core.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0003\"\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "", "base64EncodedString", "([B)Ljava/lang/String;", "toPrefixedHexString", "", "char", "", "isCharSupported", "(I)Z", "getAsUTF8String", "asUTF8String", "", "hexadecimalArray", "[C", "core_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ByteArray_CoreKt {
    private static final char[] hexadecimalArray;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        kotlin.jvm.internal.m.f(charArray, "(this as java.lang.String).toCharArray()");
        hexadecimalArray = charArray;
    }

    public static final String base64EncodedString(byte[] bArr) {
        kotlin.jvm.internal.m.g(bArr, "<this>");
        String encodeToString = Base64.encodeToString(bArr, 2);
        kotlin.jvm.internal.m.f(encodeToString, "encodeToString(this, Base64.NO_WRAP)");
        return encodeToString;
    }

    public static final String getAsUTF8String(byte[] bArr) {
        kotlin.jvm.internal.m.g(bArr, "<this>");
        String str = new String(bArr, kotlin.l0.d.a);
        char[] charArray = str.toCharArray();
        kotlin.jvm.internal.m.f(charArray, "(this as java.lang.String).toCharArray()");
        int length = charArray.length;
        int i2 = 0;
        while (i2 < length) {
            char c2 = charArray[i2];
            i2++;
            if (!isCharSupported(c2)) {
                return null;
            }
        }
        return str;
    }

    private static final boolean isCharSupported(int i2) {
        return ((((((((((((((((((((((((((((((((((((i2 == 9 || i2 == 10 || i2 == 13 || (32 <= i2 && i2 <= 160)) || (161 <= i2 && i2 <= 399)) || (417 <= i2 && i2 <= 431)) || (432 <= i2 && i2 <= 496)) || (507 <= i2 && i2 <= 536)) || (537 <= i2 && i2 <= 567)) || (711 <= i2 && i2 <= 713)) || (729 <= i2 && i2 <= 755)) || (769 <= i2 && i2 <= 771)) || (901 <= i2 && i2 <= 908)) || (911 <= i2 && i2 <= 931)) || (932 <= i2 && i2 <= 977)) || (978 <= i2 && i2 <= 982)) || (1025 <= i2 && i2 <= 1160)) || (1161 <= i2 && i2 <= 7680)) || (7681 <= i2 && i2 <= 7742)) || (7743 <= i2 && i2 <= 7808)) || (7809 <= i2 && i2 <= 7840)) || (7841 <= i2 && i2 <= 8013)) || (8193 <= i2 && i2 <= 8208)) || (8209 <= i2 && i2 <= 8211)) || (8212 <= i2 && i2 <= 8215)) || (8216 <= i2 && i2 <= 8224)) || (8225 <= i2 && i2 <= 8229)) || (8230 <= i2 && i2 <= 8240)) || (8243 <= i2 && i2 <= 8249)) || (8250 <= i2 && i2 <= 8252)) || (8356 <= i2 && i2 <= 8358)) || (8359 <= i2 && i2 <= 8369)) || (8378 <= i2 && i2 <= 8380)) || (8381 <= i2 && i2 <= 8453)) || (8540 <= i2 && i2 <= 8706)) || (8722 <= i2 && i2 <= 8730)) || (8805 <= i2 && i2 <= 9674)) || (60930 <= i2 && i2 <= 63171)) || (64258 <= i2 && i2 <= 65279)) || (65533 <= i2 && i2 <= 65534);
    }

    public static final String toPrefixedHexString(byte[] bArr) {
        Byte[] q;
        kotlin.jvm.internal.m.g(bArr, "<this>");
        int i2 = 0;
        if (bArr.length == 0) {
            return "0x";
        }
        char[] cArr = new char[(bArr.length * 2) + 2];
        cArr[0] = '0';
        cArr[1] = 'x';
        q = kotlin.a0.m.q(bArr);
        int length = q.length;
        int i3 = 2;
        while (i2 < length) {
            i2++;
            int byteValue = q[i2].byteValue() & 255;
            char[] cArr2 = hexadecimalArray;
            cArr[i3] = cArr2[byteValue / 16];
            cArr[i3 + 1] = cArr2[byteValue % 16];
            i3 += 2;
        }
        return new String(cArr);
    }
}