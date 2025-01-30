package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamProcessor.java */
/* loaded from: classes2.dex */
class d {
    public static int a(InputStream inputStream, int i2, boolean z) throws IOException {
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int read = inputStream.read();
            if (read == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i3 = (read & 255) << (i5 * 8);
            } else {
                i4 <<= 8;
                i3 = read & 255;
            }
            i4 |= i3;
        }
        return i4;
    }
}