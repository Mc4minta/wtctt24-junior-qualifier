package com.facebook.react.modules.systeminfo;

import android.os.Build;
import java.util.Locale;

/* compiled from: AndroidInfoHelpers.java */
/* loaded from: classes2.dex */
public class a {
    private static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static String f5018b;

    public static String a() {
        if (e()) {
            return Build.MODEL;
        }
        return Build.MODEL + " - " + Build.VERSION.RELEASE + " - API " + Build.VERSION.SDK_INT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized java.lang.String b() {
        /*
            java.lang.Class<com.facebook.react.modules.systeminfo.a> r0 = com.facebook.react.modules.systeminfo.a.class
            monitor-enter(r0)
            java.lang.String r1 = com.facebook.react.modules.systeminfo.a.f5018b     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto L9
            monitor-exit(r0)
            return r1
        L9:
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L52
            java.lang.String r3 = "/system/bin/getprop"
            java.lang.String r4 = "metro.host"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L52
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L52
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L48
            java.lang.String r1 = ""
        L30:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L6d
            if (r4 == 0) goto L38
            r1 = r4
            goto L30
        L38:
            com.facebook.react.modules.systeminfo.a.f5018b = r1     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L6d
            r3.close()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L79
        L3d:
            r2.destroy()     // Catch: java.lang.Throwable -> L79
            goto L69
        L41:
            r1 = move-exception
            goto L56
        L43:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L6e
        L48:
            r3 = move-exception
            r7 = r3
            r3 = r1
            r1 = r7
            goto L56
        L4d:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L6e
        L52:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L56:
            java.lang.String r4 = com.facebook.react.modules.systeminfo.a.a     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = "Failed to query for metro.host prop:"
            e.f.d.d.a.B(r4, r5, r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = ""
            com.facebook.react.modules.systeminfo.a.f5018b = r1     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L79
        L66:
            if (r2 == 0) goto L69
            goto L3d
        L69:
            java.lang.String r1 = com.facebook.react.modules.systeminfo.a.f5018b     // Catch: java.lang.Throwable -> L79
            monitor-exit(r0)
            return r1
        L6d:
            r1 = move-exception
        L6e:
            if (r3 == 0) goto L73
            r3.close()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L79
        L73:
            if (r2 == 0) goto L78
            r2.destroy()     // Catch: java.lang.Throwable -> L79
        L78:
            throw r1     // Catch: java.lang.Throwable -> L79
        L79:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.systeminfo.a.b():java.lang.String");
    }

    public static String c(Integer num) {
        return d(num.intValue());
    }

    private static String d(int i2) {
        String b2 = b();
        if (b2.equals("")) {
            if (e()) {
                b2 = "10.0.3.2";
            } else {
                b2 = f() ? "10.0.2.2" : "localhost";
            }
        }
        return String.format(Locale.US, "%s:%d", b2, Integer.valueOf(i2));
    }

    private static boolean e() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean f() {
        return Build.FINGERPRINT.contains("generic");
    }
}