package com.facebook.common.util;

import e.f.d.c.i;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static long a(InputStream inputStream, long j2) throws IOException {
        i.g(inputStream);
        i.b(j2 >= 0);
        long j3 = j2;
        while (j3 > 0) {
            long skip = inputStream.skip(j3);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    return j2 - j3;
                }
                skip = 1;
            }
            j3 -= skip;
        }
        return j2;
    }
}