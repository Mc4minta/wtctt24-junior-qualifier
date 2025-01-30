package com.coinbase.wallet.crypto.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ByteArray+Crypto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "toHexString", "([B)Ljava/lang/String;", "", "", "value", "and", "(BI)I", "crypto_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ByteArray_CryptoKt {
    private static final int and(byte b2, int i2) {
        return b2 & i2;
    }

    public static final String toHexString(byte[] bArr) {
        m.g(bArr, "<this>");
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            i2++;
            String num = Integer.toString(and(b2, 255) + 256, 16);
            m.f(num, "toString((byt and 0xff) + 0x100, 16)");
            String substring = num.substring(1);
            m.f(substring, "(this as java.lang.String).substring(startIndex)");
            stringBuffer.append(substring);
        }
        String stringBuffer2 = stringBuffer.toString();
        m.f(stringBuffer2, "result.toString()");
        return stringBuffer2;
    }
}