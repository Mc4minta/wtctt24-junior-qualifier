package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public class SoLoader {
    static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    static k f5596b;

    /* renamed from: f  reason: collision with root package name */
    private static n[] f5600f;

    /* renamed from: g  reason: collision with root package name */
    private static com.facebook.soloader.b f5601g;

    /* renamed from: l  reason: collision with root package name */
    private static int f5606l;
    private static boolean m;

    /* renamed from: c  reason: collision with root package name */
    private static final ReentrantReadWriteLock f5597c = new ReentrantReadWriteLock();

    /* renamed from: d  reason: collision with root package name */
    private static l[] f5598d = null;

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f5599e = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final HashSet<String> f5602h = new HashSet<>();

    /* renamed from: i  reason: collision with root package name */
    private static final Map<String, Object> f5603i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static final Set<String> f5604j = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: k  reason: collision with root package name */
    private static m f5605k = null;

    /* JADX INFO: Access modifiers changed from: private */
    @d
    @TargetApi(14)
    /* loaded from: classes2.dex */
    public static class Api14Utils {
        private Api14Utils() {
        }

        public static String a() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e2);
                }
            }
            throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements k {
        final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5607b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f5608c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runtime f5609d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Method f5610e;

        a(boolean z, String str, String str2, Runtime runtime, Method method) {
            this.a = z;
            this.f5607b = str;
            this.f5608c = str2;
            this.f5609d = runtime;
            this.f5610e = method;
        }

        private String b(String str) {
            try {
                File file = new File(str);
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String format = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                            fileInputStream.close();
                            return format;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                return e2.toString();
            } catch (SecurityException e3) {
                return e3.toString();
            } catch (NoSuchAlgorithmException e4) {
                return e4.toString();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
            if (r1 == null) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
            android.util.Log.e("SoLoader", "Error when loading lib: " + r1 + " lib hash: " + b(r9) + " search path is " + r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2 */
        @Override // com.facebook.soloader.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.lang.String r9, int r10) {
            /*
                Method dump skipped, instructions count: 205
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.a.a(java.lang.String, int):void");
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends UnsatisfiedLinkError {
        b(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.g()) + " error: " + str);
            initCause(th);
        }
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        a = z;
    }

    private static void a() {
        ReentrantReadWriteLock reentrantReadWriteLock = f5597c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f5598d != null) {
                reentrantReadWriteLock.readLock().unlock();
                return;
            }
            throw new RuntimeException("SoLoader.init() not yet called");
        } catch (Throwable th) {
            f5597c.readLock().unlock();
            throw th;
        }
    }

    private static boolean b(Context context) {
        return (context == null || (context.getApplicationInfo().flags & 129) == 0) ? false : true;
    }

    private static void c(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        boolean z;
        UnsatisfiedLinkError unsatisfiedLinkError;
        boolean z2;
        ReentrantReadWriteLock reentrantReadWriteLock = f5597c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f5598d != null) {
                reentrantReadWriteLock.readLock().unlock();
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z = true;
                } else {
                    z = false;
                }
                if (a) {
                    Api18TraceUtils.a("SoLoader.loadLibrary[", str, "]");
                }
                int i3 = 0;
                do {
                    try {
                        f5597c.readLock().lock();
                        int i4 = f5599e;
                        int i5 = 0;
                        while (true) {
                            if (i3 != 0) {
                                break;
                            }
                            l[] lVarArr = f5598d;
                            if (i5 < lVarArr.length) {
                                i3 = lVarArr[i5].a(str, i2, threadPolicy);
                                if (i3 == 3 && f5600f != null) {
                                    Log.d("SoLoader", "Trying backup SoSource for " + str);
                                    n[] nVarArr = f5600f;
                                    int length = nVarArr.length;
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= length) {
                                            break;
                                        }
                                        n nVar = nVarArr[i6];
                                        nVar.n(str);
                                        int a2 = nVar.a(str, i2, threadPolicy);
                                        if (a2 == 1) {
                                            i3 = a2;
                                            break;
                                        }
                                        i6++;
                                    }
                                } else {
                                    i5++;
                                }
                            } else {
                                break;
                            }
                        }
                        ReentrantReadWriteLock reentrantReadWriteLock2 = f5597c;
                        reentrantReadWriteLock2.readLock().unlock();
                        if ((i2 & 2) == 2 && i3 == 0) {
                            reentrantReadWriteLock2.writeLock().lock();
                            com.facebook.soloader.b bVar = f5601g;
                            if (bVar != null && bVar.d()) {
                                f5599e++;
                            }
                            z2 = f5599e != i4;
                            reentrantReadWriteLock2.writeLock().unlock();
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                    } finally {
                        if (i3 == 0 || i3 == r7) {
                        }
                    }
                } while (z2);
                if (a) {
                    Api18TraceUtils.b();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i3 == 0 || i3 == 3) {
                    String str2 = ("couldn't find DSO to load: " + str) + " result: " + i3;
                    Log.e("SoLoader", str2);
                    throw new UnsatisfiedLinkError(str2);
                }
                return;
            }
            Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
            throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
        } catch (Throwable th) {
            f5597c.readLock().unlock();
            throw th;
        }
    }

    private static Method d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 && i2 <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e2) {
                Log.w("SoLoader", "Cannot get nativeLoad method", e2);
            }
        }
        return null;
    }

    public static void e(Context context, int i2) throws IOException {
        f(context, i2, null);
    }

    public static void f(Context context, int i2, k kVar) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            m = b(context);
            h(kVar);
            i(context, i2, kVar);
            if (!com.facebook.soloader.o.a.b()) {
                com.facebook.soloader.o.a.a(new j());
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static void g(Context context, boolean z) {
        try {
            e(context, z ? 1 : 0);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static synchronized void h(k kVar) {
        synchronized (SoLoader.class) {
            if (kVar != null) {
                f5596b = kVar;
                return;
            }
            Runtime runtime = Runtime.getRuntime();
            Method d2 = d();
            boolean z = d2 != null;
            String a2 = z ? Api14Utils.a() : null;
            f5596b = new a(z, a2, n(a2), runtime, d2);
        }
    }

    private static void i(Context context, int i2, k kVar) throws IOException {
        int i3;
        com.facebook.soloader.a aVar;
        f5597c.writeLock().lock();
        try {
            if (f5598d == null) {
                Log.d("SoLoader", "init start");
                f5606l = i2;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = "/vendor/lib:/system/lib";
                }
                String[] split = str.split(":");
                for (int i4 = 0; i4 < split.length; i4++) {
                    Log.d("SoLoader", "adding system library source: " + split[i4]);
                    arrayList.add(new c(new File(split[i4]), 2));
                }
                if (context != null) {
                    if ((i2 & 1) != 0) {
                        f5600f = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new e(context, "lib-main"));
                    } else {
                        if (m) {
                            i3 = 0;
                        } else {
                            f5601g = new com.facebook.soloader.b(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            Log.d("SoLoader", "adding application source: " + f5601g.toString());
                            arrayList.add(0, f5601g);
                            i3 = 1;
                        }
                        if ((f5606l & 8) != 0) {
                            f5600f = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new com.facebook.soloader.a(context, file, "lib-main", i3));
                            Log.d("SoLoader", "adding backup source from : " + aVar.toString());
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i5 = 0;
                                int i6 = 0;
                                while (i5 < length) {
                                    File file2 = new File(strArr[i5]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("lib-");
                                    sb.append(i6);
                                    com.facebook.soloader.a aVar2 = new com.facebook.soloader.a(context, file2, sb.toString(), i3);
                                    Log.d("SoLoader", "adding backup source: " + aVar2.toString());
                                    arrayList2.add(aVar2);
                                    i5++;
                                    i6++;
                                }
                            }
                            f5600f = (n[]) arrayList2.toArray(new n[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                l[] lVarArr = (l[]) arrayList.toArray(new l[arrayList.size()]);
                int o = o();
                int length2 = lVarArr.length;
                while (true) {
                    int i7 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d("SoLoader", "Preparing SO source: " + lVarArr[i7]);
                    lVarArr[i7].b(o);
                    length2 = i7;
                }
                f5598d = lVarArr;
                f5599e++;
                Log.d("SoLoader", "init finish: " + f5598d.length + " SO sources prepared");
            }
        } finally {
            Log.d("SoLoader", "init exiting");
            f5597c.writeLock().unlock();
        }
    }

    public static boolean j(String str) {
        return k(str, 0);
    }

    public static boolean k(String str, int i2) throws UnsatisfiedLinkError {
        m mVar;
        boolean z;
        ReentrantReadWriteLock reentrantReadWriteLock = f5597c;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (f5598d == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    a();
                } else {
                    synchronized (SoLoader.class) {
                        z = !f5602h.contains(str);
                        if (z) {
                            m mVar2 = f5605k;
                            if (mVar2 != null) {
                                mVar2.a(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return z;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            if (m && (mVar = f5605k) != null) {
                mVar.a(str);
                return true;
            }
            String b2 = h.b(str);
            return m(System.mapLibraryName(b2 != null ? b2 : str), str, b2, i2 | 2, null);
        } catch (Throwable th) {
            f5597c.readLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        m(str, null, null, i2, threadPolicy);
    }

    private static boolean m(String str, String str2, String str3, int i2, StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        boolean z2 = false;
        if (TextUtils.isEmpty(str2) || !f5604j.contains(str2)) {
            synchronized (SoLoader.class) {
                HashSet<String> hashSet = f5602h;
                if (!hashSet.contains(str)) {
                    z = false;
                } else if (str3 == null) {
                    return false;
                } else {
                    z = true;
                }
                Map<String, Object> map = f5603i;
                if (map.containsKey(str)) {
                    obj = map.get(str);
                } else {
                    Object obj2 = new Object();
                    map.put(str, obj2);
                    obj = obj2;
                }
                synchronized (obj) {
                    if (!z) {
                        synchronized (SoLoader.class) {
                            if (hashSet.contains(str)) {
                                if (str3 == null) {
                                    return false;
                                }
                                z = true;
                            }
                            if (!z) {
                                try {
                                    Log.d("SoLoader", "About to load: " + str);
                                    c(str, i2, threadPolicy);
                                    synchronized (SoLoader.class) {
                                        Log.d("SoLoader", "Loaded: " + str);
                                        hashSet.add(str);
                                    }
                                } catch (IOException e2) {
                                    throw new RuntimeException(e2);
                                } catch (UnsatisfiedLinkError e3) {
                                    String message = e3.getMessage();
                                    if (message != null && message.contains("unexpected e_machine:")) {
                                        throw new b(e3, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                    }
                                    throw e3;
                                }
                            }
                        }
                    }
                    if ((i2 & 16) == 0) {
                        if (!TextUtils.isEmpty(str2) && f5604j.contains(str2)) {
                            z2 = true;
                        }
                        if (str3 != null && !z2) {
                            boolean z3 = a;
                            if (z3) {
                                Api18TraceUtils.a("MergedSoMapping.invokeJniOnload[", str2, "]");
                            }
                            Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                            h.a(str2);
                            f5604j.add(str2);
                            if (z3) {
                                Api18TraceUtils.b();
                            }
                        }
                    }
                    return !z;
                }
            }
        }
        return false;
    }

    public static String n(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    private static int o() {
        ReentrantReadWriteLock reentrantReadWriteLock = f5597c;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i2 = (f5606l & 2) != 0 ? 1 : 0;
            reentrantReadWriteLock.writeLock().unlock();
            return i2;
        } catch (Throwable th) {
            f5597c.writeLock().unlock();
            throw th;
        }
    }

    public static File p(String str) throws UnsatisfiedLinkError {
        a();
        try {
            return q(System.mapLibraryName(str));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    static File q(String str) throws IOException {
        f5597c.readLock().lock();
        int i2 = 0;
        while (true) {
            try {
                l[] lVarArr = f5598d;
                if (i2 < lVarArr.length) {
                    File c2 = lVarArr[i2].c(str);
                    if (c2 != null) {
                        return c2;
                    }
                    i2++;
                } else {
                    f5597c.readLock().unlock();
                    throw new FileNotFoundException(str);
                }
            } finally {
                f5597c.readLock().unlock();
            }
        }
    }
}