package e.g.a.e.d.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
/* loaded from: classes2.dex */
public final class i {
    private static final OutputStream a = new h();

    public static InputStream a(InputStream inputStream, long j2) {
        return new k(inputStream, 1048577L);
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        g.a(inputStream);
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i2 = PKIFailureInfo.certRevoked;
        int i3 = 0;
        while (i3 < 2147483639) {
            int min = Math.min(i2, 2147483639 - i3);
            byte[] bArr = new byte[min];
            arrayDeque.add(bArr);
            int i4 = 0;
            while (i4 < min) {
                int read = inputStream.read(bArr, i4, min - i4);
                if (read == -1) {
                    return c(arrayDeque, i3);
                }
                i4 += read;
                i3 += read;
            }
            i2 = m.a(i2, 2);
        }
        if (inputStream.read() == -1) {
            return c(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] c(Deque<byte[]> deque, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = i2;
        while (i3 > 0) {
            byte[] removeFirst = deque.removeFirst();
            int min = Math.min(i3, removeFirst.length);
            System.arraycopy(removeFirst, 0, bArr, i2 - i3, min);
            i3 -= min;
        }
        return bArr;
    }
}