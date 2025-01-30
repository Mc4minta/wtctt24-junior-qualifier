package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import org.apache.commons.io.b.b;

/* compiled from: IOUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static final char a = File.separatorChar;

    /* renamed from: b  reason: collision with root package name */
    public static final String f17575b;

    static {
        b bVar = new b(4);
        PrintWriter printWriter = new PrintWriter(bVar);
        printWriter.println();
        f17575b = bVar.toString();
        printWriter.close();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long c2 = c(inputStream, outputStream);
        if (c2 > 2147483647L) {
            return -1;
        }
        return (int) c2;
    }

    public static long b(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        return d(inputStream, outputStream, new byte[i2]);
    }

    public static long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        return b(inputStream, outputStream, 4096);
    }

    public static long d(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
    }

    public static byte[] e(InputStream inputStream) throws IOException {
        org.apache.commons.io.b.a aVar = new org.apache.commons.io.b.a();
        a(inputStream, aVar);
        return aVar.b();
    }
}