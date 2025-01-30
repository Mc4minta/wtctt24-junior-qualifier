package org.spongycastle.asn1;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes3.dex */
class StreamUtil {
    private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();

    StreamUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calculateBodyLength(int i2) {
        int i3 = 1;
        if (i2 > 127) {
            int i4 = 1;
            while (true) {
                i2 >>>= 8;
                if (i2 == 0) {
                    break;
                }
                i4++;
            }
            for (int i5 = (i4 - 1) * 8; i5 >= 0; i5 -= 8) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calculateTagLength(int i2) throws IOException {
        if (i2 >= 31) {
            if (i2 < 128) {
                return 2;
            }
            byte[] bArr = new byte[5];
            int i3 = 4;
            do {
                i2 >>= 7;
                i3--;
                bArr[i3] = (byte) ((i2 & 127) | 128);
            } while (i2 > 127);
            return 1 + (5 - i3);
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int findLimit(InputStream inputStream) {
        if (inputStream instanceof LimitedInputStream) {
            return ((LimitedInputStream) inputStream).getRemaining();
        }
        if (inputStream instanceof ASN1InputStream) {
            return ((ASN1InputStream) inputStream).getLimit();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j2 = MAX_MEMORY;
        return j2 > 2147483647L ? RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO : (int) j2;
    }
}