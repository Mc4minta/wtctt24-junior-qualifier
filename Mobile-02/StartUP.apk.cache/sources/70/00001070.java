package com.coinbase.cipherwebview.util;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ByteArray+CipherWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "addPrefix", "", "toHexEncodedString", "([BZ)Ljava/lang/String;", "", "hexadecimalArray", "[C", "cipher-webview_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ByteArray_CipherWebViewKt {
    private static final char[] hexadecimalArray;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        m.f(charArray, "(this as java.lang.String).toCharArray()");
        hexadecimalArray = charArray;
    }

    public static final String toHexEncodedString(byte[] bArr, boolean z) {
        Byte[] q;
        m.g(bArr, "<this>");
        int i2 = 0;
        if (bArr.length == 0) {
            return z ? "0x" : "";
        }
        int i3 = z ? 2 : 0;
        char[] cArr = new char[(bArr.length * 2) + i3];
        if (z) {
            cArr[0] = '0';
            cArr[1] = 'x';
        }
        q = kotlin.a0.m.q(bArr);
        int length = q.length;
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

    public static /* synthetic */ String toHexEncodedString$default(byte[] bArr, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return toHexEncodedString(bArr, z);
    }
}