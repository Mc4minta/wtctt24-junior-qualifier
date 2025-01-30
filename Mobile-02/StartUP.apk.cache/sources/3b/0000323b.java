package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class m {
    private static String a;

    /* renamed from: b  reason: collision with root package name */
    private static int f6330b;

    public static String a() {
        if (a == null) {
            if (f6330b == 0) {
                f6330b = Process.myPid();
            }
            a = b(f6330b);
        }
        return a;
    }

    private static String b(int i2) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        if (i2 <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i2);
            sb.append("/cmdline");
            bufferedReader = c(sb.toString());
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            str = bufferedReader.readLine().trim();
            k.a(bufferedReader);
        } catch (IOException unused2) {
            k.a(bufferedReader);
            return str;
        } catch (Throwable th3) {
            th = th3;
            k.a(bufferedReader);
            throw th;
        }
        return str;
    }

    private static BufferedReader c(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}