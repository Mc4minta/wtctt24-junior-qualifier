package com.google.firebase.crashlytics.c.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import org.apache.http.message.TokenParser;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class h {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static long f8683b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<File> f8684c = new a();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements Comparator<File> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    enum b {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: l  reason: collision with root package name */
        private static final Map<String, b> f8694l;

        static {
            b bVar = X86_32;
            b bVar2 = ARMV6;
            b bVar3 = ARMV7;
            b bVar4 = ARM64;
            HashMap hashMap = new HashMap(4);
            f8694l = hashMap;
            hashMap.put("armeabi-v7a", bVar3);
            hashMap.put("armeabi", bVar2);
            hashMap.put("arm64-v8a", bVar4);
            hashMap.put("x86", bVar);
        }

        static b h() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                com.google.firebase.crashlytics.c.b.f().b("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            b bVar = f8694l.get(str.toLowerCase(Locale.US));
            return bVar == null ? UNKNOWN : bVar;
        }
    }

    public static boolean A(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean B() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static boolean C(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        String str = Build.PRODUCT;
        return "sdk".equals(str) || "google_sdk".equals(str) || string == null;
    }

    public static boolean D(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean E(Context context) {
        boolean C = C(context);
        String str = Build.TAGS;
        if ((C || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !C && new File("/system/xbin/su").exists();
        }
        return true;
    }

    public static String F(int i2) {
        if (i2 >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i2)).replace(TokenParser.SP, '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    public static String G(Context context) {
        int s = s(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (s != 0) {
            String string = context.getResources().getString(s);
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("Unity Editor version is: " + string);
            return string;
        }
        return null;
    }

    public static String H(InputStream inputStream) {
        return w(inputStream, "SHA-1");
    }

    public static String I(String str) {
        return x(str, "SHA-1");
    }

    public static String J(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String str) {
        StatFs statFs;
        long blockSize = new StatFs(str).getBlockSize();
        return (statFs.getBlockCount() * blockSize) - (blockSize * statFs.getAvailableBlocks());
    }

    @SuppressLint({"MissingPermission"})
    public static boolean c(Context context) {
        if (d(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return true;
    }

    public static boolean d(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static void e(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b.f().e(str, e2);
            }
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    static long g(String str, String str2, int i2) {
        return Long.parseLong(str.split(str2)[0].trim()) * i2;
    }

    public static String h(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            sb.append(str2);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return I(sb2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        r2 = r3[1];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String i(java.io.File r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "Failed to close system file reader."
            boolean r1 = r6.exists()
            r2 = 0
            if (r1 == 0) goto L5f
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
        L15:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            if (r3 == 0) goto L36
            java.lang.String r4 = "\\s*:\\s*"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            r5 = 2
            java.lang.String[] r3 = r4.split(r3, r5)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            int r4 = r3.length     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            r5 = 1
            if (r4 <= r5) goto L15
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            boolean r4 = r4.equals(r7)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            if (r4 == 0) goto L15
            r6 = r3[r5]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L59
            r2 = r6
        L36:
            e(r1, r0)
            goto L5f
        L3a:
            r7 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L5b
        L3e:
            r7 = move-exception
            r1 = r2
        L40:
            com.google.firebase.crashlytics.c.b r3 = com.google.firebase.crashlytics.c.b.f()     // Catch: java.lang.Throwable -> L59
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r5 = "Error parsing "
            r4.append(r5)     // Catch: java.lang.Throwable -> L59
            r4.append(r6)     // Catch: java.lang.Throwable -> L59
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L59
            r3.e(r6, r7)     // Catch: java.lang.Throwable -> L59
            goto L36
        L59:
            r6 = move-exception
            r2 = r1
        L5b:
            e(r2, r0)
            throw r6
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.c.g.h.i(java.io.File, java.lang.String):java.lang.String");
    }

    public static void j(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e2) {
                com.google.firebase.crashlytics.c.b.f().e(str, e2);
            }
        }
    }

    public static ActivityManager.RunningAppProcessInfo k(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static boolean l(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int s = s(context, str, "bool");
            if (s > 0) {
                return resources.getBoolean(s);
            }
            int s2 = s(context, str, "string");
            if (s2 > 0) {
                return Boolean.parseBoolean(context.getString(s2));
            }
        }
        return z;
    }

    public static int m() {
        return b.h().ordinal();
    }

    public static int n(Context context) {
        int i2 = C(context) ? 1 : 0;
        if (E(context)) {
            i2 |= 2;
        }
        return B() ? i2 | 4 : i2;
    }

    public static SharedPreferences o(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String p(Context context) {
        int s = s(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
        if (s == 0) {
            s = s(context, "com.crashlytics.android.build_id", "string");
        }
        if (s != 0) {
            return context.getResources().getString(s);
        }
        return null;
    }

    public static boolean q(Context context) {
        return (C(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    public static String r(Context context) {
        int i2 = context.getApplicationContext().getApplicationInfo().icon;
        if (i2 > 0) {
            try {
                return context.getResources().getResourcePackageName(i2);
            } catch (Resources.NotFoundException unused) {
                return context.getPackageName();
            }
        }
        return context.getPackageName();
    }

    public static int s(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, r(context));
    }

    public static SharedPreferences t(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    public static String u(Context context, String str) {
        int s = s(context, str, "string");
        return s > 0 ? context.getString(s) : "";
    }

    public static synchronized long v() {
        long j2;
        synchronized (h.class) {
            if (f8683b == -1) {
                long j3 = 0;
                String i2 = i(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(i2)) {
                    String upperCase = i2.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j3 = g(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j3 = g(upperCase, "MB", PKIFailureInfo.badCertTemplate);
                        } else if (upperCase.endsWith("GB")) {
                            j3 = g(upperCase, "GB", 1073741824);
                        } else {
                            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                            f2.b("Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e2) {
                        com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
                        f3.e("Unexpected meminfo format while computing RAM: " + upperCase, e2);
                    }
                }
                f8683b = j3;
            }
            j2 = f8683b;
        }
        return j2;
    }

    private static String w(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return z(messageDigest.digest());
                }
            }
        } catch (Exception e2) {
            com.google.firebase.crashlytics.c.b.f().e("Could not calculate hash for app icon.", e2);
            return "";
        }
    }

    private static String x(String str, String str2) {
        return y(str.getBytes(), str2);
    }

    private static String y(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return z(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.e("Could not create hashing algorithm: " + str + ", returning empty string.", e2);
            return "";
        }
    }

    public static String z(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }
}