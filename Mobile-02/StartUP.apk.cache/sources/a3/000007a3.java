package com.bugsnag.android;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URLConnection;

/* compiled from: IOUtils.java */
/* loaded from: classes.dex */
class l0 {
    public static void a(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static int c(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        long j2 = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                break;
            }
            writer.write(cArr, 0, read);
            j2 += read;
        }
        if (j2 > 2147483647L) {
            return -1;
        }
        return (int) j2;
    }
}