package e.f.i;

import e.f.d.c.i;
import java.io.UnsupportedEncodingException;
import org.apache.http.protocol.HTTP;

/* compiled from: ImageFormatCheckerUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static byte[] a(String str) {
        i.g(str);
        try {
            return str.getBytes(HTTP.ASCII);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        i.g(bArr);
        i.g(bArr2);
        if (i3 > i2) {
            return -1;
        }
        int i4 = 0;
        byte b2 = bArr2[0];
        int i5 = i2 - i3;
        while (i4 <= i5) {
            if (bArr[i4] != b2) {
                do {
                    i4++;
                    if (i4 > i5) {
                        break;
                    }
                } while (bArr[i4] != b2);
            }
            if (i4 <= i5) {
                int i6 = i4 + 1;
                int i7 = (i6 + i3) - 1;
                for (int i8 = 1; i6 < i7 && bArr[i6] == bArr2[i8]; i8++) {
                    i6++;
                }
                if (i6 == i7) {
                    return i4;
                }
            }
            i4++;
        }
        return -1;
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        i.g(bArr);
        i.g(bArr2);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}