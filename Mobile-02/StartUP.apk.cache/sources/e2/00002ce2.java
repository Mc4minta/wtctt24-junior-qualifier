package com.facebook.imageutils;

import e.f.d.c.i;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpStatus;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: JfifUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static int a(int i2) {
        return e.a(i2);
    }

    public static int b(InputStream inputStream) {
        try {
            int d2 = d(inputStream);
            if (d2 == 0) {
                return 0;
            }
            return e.d(inputStream, d2);
        } catch (IOException unused) {
            return 0;
        }
    }

    private static boolean c(int i2) {
        switch (i2) {
            case 192:
            case CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256 /* 193 */:
            case CipherSuite.TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256 /* 194 */:
            case CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256 /* 195 */:
            case CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256 /* 197 */:
            case 198:
            case 199:
            case HttpStatus.SC_CREATED /* 201 */:
            case HttpStatus.SC_ACCEPTED /* 202 */:
            case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /* 203 */:
            case HttpStatus.SC_RESET_CONTENT /* 205 */:
            case HttpStatus.SC_PARTIAL_CONTENT /* 206 */:
            case HttpStatus.SC_MULTI_STATUS /* 207 */:
                return true;
            case CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256 /* 196 */:
            case 200:
            case HttpStatus.SC_NO_CONTENT /* 204 */:
            default:
                return false;
        }
    }

    private static int d(InputStream inputStream) throws IOException {
        int a;
        if (e(inputStream, 225) && (a = d.a(inputStream, 2, false) - 2) > 6) {
            int a2 = d.a(inputStream, 4, false);
            int a3 = d.a(inputStream, 2, false);
            int i2 = (a - 4) - 2;
            if (a2 == 1165519206 && a3 == 0) {
                return i2;
            }
        }
        return 0;
    }

    public static boolean e(InputStream inputStream, int i2) throws IOException {
        i.g(inputStream);
        while (d.a(inputStream, 1, false) == 255) {
            int i3 = 255;
            while (i3 == 255) {
                i3 = d.a(inputStream, 1, false);
            }
            if ((i2 != 192 || !c(i3)) && i3 != i2) {
                if (i3 != 216 && i3 != 1) {
                    if (i3 == 217 || i3 == 218) {
                        break;
                    }
                    inputStream.skip(d.a(inputStream, 2, false) - 2);
                }
            } else {
                return true;
            }
        }
        return false;
    }
}