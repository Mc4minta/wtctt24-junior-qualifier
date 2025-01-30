package org.apache.commons.codec.b;

import java.nio.charset.Charset;

/* compiled from: StringUtils.java */
/* loaded from: classes3.dex */
public class c {
    private static byte[] a(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return str.getBytes(charset);
    }

    public static byte[] b(String str) {
        return a(str, org.apache.commons.codec.a.f17556f);
    }

    private static String c(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String d(byte[] bArr) {
        return c(bArr, org.apache.commons.codec.a.f17556f);
    }
}