package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.DynamiteApi;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class DynamiteModule {
    private static Boolean a = null;

    /* renamed from: b  reason: collision with root package name */
    private static j f6349b = null;

    /* renamed from: c  reason: collision with root package name */
    private static l f6350c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f6351d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f6352e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<b> f6353f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    private static final a.b f6354g = new com.google.android.gms.dynamite.a();

    /* renamed from: h  reason: collision with root package name */
    public static final a f6355h = new com.google.android.gms.dynamite.c();

    /* renamed from: i  reason: collision with root package name */
    public static final a f6356i = new com.google.android.gms.dynamite.b();

    /* renamed from: j  reason: collision with root package name */
    public static final a f6357j = new e();

    /* renamed from: k  reason: collision with root package name */
    public static final a f6358k = new d();

    /* renamed from: l  reason: collision with root package name */
    public static final a f6359l = new g();
    private static final a m = new f();
    private final Context n;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    @DynamiteApi
    /* loaded from: classes2.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, com.google.android.gms.dynamite.a aVar) {
            this(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public interface a {

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0146a {
            public int a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f6360b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f6361c = 0;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* loaded from: classes2.dex */
        public interface b {
            int a(Context context, String str);

            int b(Context context, String str, boolean z) throws LoadingException;
        }

        C0146a a(Context context, String str, b bVar) throws LoadingException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static class b {
        public Cursor a;

        private b() {
        }

        /* synthetic */ b(com.google.android.gms.dynamite.a aVar) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    private static class c implements a.b {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6362b = 0;

        public c(int i2, int i3) {
            this.a = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int a(Context context, String str) {
            return this.a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.b
        public final int b(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.n = (Context) t.k(context);
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
                sb2.append("Module descriptor id '");
                sb2.append(valueOf);
                sb2.append("' didn't match expected id '");
                sb2.append(str);
                sb2.append("'");
                Log.e("DynamiteModule", sb2.toString());
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    public static DynamiteModule e(Context context, a aVar, String str) throws LoadingException {
        ThreadLocal<b> threadLocal = f6353f;
        b bVar = threadLocal.get();
        b bVar2 = new b(null);
        threadLocal.set(bVar2);
        try {
            a.C0146a a2 = aVar.a(context, str, f6354g);
            int i2 = a2.a;
            int i3 = a2.f6360b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = a2.f6361c;
            if (i4 == 0 || ((i4 == -1 && a2.a == 0) || (i4 == 1 && a2.f6360b == 0))) {
                int i5 = a2.a;
                int i6 = a2.f6360b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (com.google.android.gms.dynamite.a) null);
            } else if (i4 == -1) {
                DynamiteModule m2 = m(context, str);
                Cursor cursor = bVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bVar);
                return m2;
            } else if (i4 == 1) {
                try {
                    DynamiteModule g2 = g(context, str, a2.f6360b);
                    Cursor cursor2 = bVar2.a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(bVar);
                    return g2;
                } catch (LoadingException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    int i7 = a2.a;
                    if (i7 != 0 && aVar.a(context, str, new c(i7, 0)).f6361c == -1) {
                        DynamiteModule m3 = m(context, str);
                        Cursor cursor3 = bVar2.a;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        f6353f.set(bVar);
                        return m3;
                    }
                    throw new LoadingException("Remote load failed. No local fallback found.", e2, null);
                }
            } else {
                int i8 = a2.f6361c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i8);
                throw new LoadingException(sb3.toString(), (com.google.android.gms.dynamite.a) null);
            }
        } catch (Throwable th) {
            Cursor cursor4 = bVar2.a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f6353f.set(bVar);
            throw th;
        }
    }

    public static int f(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        ClassLoader hVar;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = a;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    h(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int l2 = l(context, str, z);
                                String str2 = f6351d;
                                if (str2 != null && !str2.isEmpty()) {
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        hVar = new DelegateLastClassLoader(f6351d, ClassLoader.getSystemClassLoader());
                                    } else {
                                        hVar = new h(f6351d, ClassLoader.getSystemClassLoader());
                                    }
                                    h(hVar);
                                    declaredField.set(null, hVar);
                                    a = Boolean.TRUE;
                                    return l2;
                                }
                                return l2;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        a = bool2;
                    }
                }
                if (bool2.booleanValue()) {
                    try {
                        return l(context, str, z);
                    } catch (LoadingException e3) {
                        String valueOf2 = String.valueOf(e3.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return j(context, str, z);
            }
        } catch (Throwable th) {
            com.google.android.gms.common.util.g.a(context, th);
            throw th;
        }
    }

    private static DynamiteModule g(Context context, String str, int i2) throws LoadingException {
        Boolean bool;
        com.google.android.gms.dynamic.a O;
        try {
            synchronized (DynamiteModule.class) {
                bool = a;
            }
            if (bool != null) {
                if (bool.booleanValue()) {
                    return k(context, str, i2);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                j n = n(context);
                if (n != null) {
                    if (n.J0() >= 2) {
                        O = n.u0(com.google.android.gms.dynamic.b.Y0(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        O = n.O(com.google.android.gms.dynamic.b.Y0(context), str, i2);
                    }
                    if (com.google.android.gms.dynamic.b.q(O) != null) {
                        return new DynamiteModule((Context) com.google.android.gms.dynamic.b.q(O));
                    }
                    throw new LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.a) null);
            }
            throw new LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.a) null);
        } catch (RemoteException e2) {
            throw new LoadingException("Failed to load remote module.", e2, null);
        } catch (LoadingException e3) {
            throw e3;
        } catch (Throwable th) {
            com.google.android.gms.common.util.g.a(context, th);
            throw new LoadingException("Failed to load remote module.", th, null);
        }
    }

    private static void h(ClassLoader classLoader) throws LoadingException {
        l kVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                kVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof l) {
                    kVar = (l) queryLocalInterface;
                } else {
                    kVar = new k(iBinder);
                }
            }
            f6350c = kVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, null);
        }
    }

    private static Boolean i() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f6352e >= 2);
        }
        return valueOf;
    }

    private static int j(Context context, String str, boolean z) {
        j n = n(context);
        if (n == null) {
            return 0;
        }
        try {
            if (n.J0() >= 2) {
                return n.c0(com.google.android.gms.dynamic.b.Y0(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return n.s0(com.google.android.gms.dynamic.b.Y0(context), str, z);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule k(Context context, String str, int i2) throws LoadingException, RemoteException {
        l lVar;
        com.google.android.gms.dynamic.a A;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            lVar = f6350c;
        }
        if (lVar != null) {
            b bVar = f6353f.get();
            if (bVar != null && bVar.a != null) {
                Context applicationContext = context.getApplicationContext();
                Cursor cursor = bVar.a;
                com.google.android.gms.dynamic.b.Y0(null);
                if (i().booleanValue()) {
                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                    A = lVar.B(com.google.android.gms.dynamic.b.Y0(applicationContext), str, i2, com.google.android.gms.dynamic.b.Y0(cursor));
                } else {
                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                    A = lVar.A(com.google.android.gms.dynamic.b.Y0(applicationContext), str, i2, com.google.android.gms.dynamic.b.Y0(cursor));
                }
                Context context2 = (Context) com.google.android.gms.dynamic.b.q(A);
                if (context2 != null) {
                    return new DynamiteModule(context2);
                }
                throw new LoadingException("Failed to get module context", (com.google.android.gms.dynamite.a) null);
            }
            throw new LoadingException("No result cursor", (com.google.android.gms.dynamite.a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.a) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int l(android.content.Context r8, java.lang.String r9, boolean r10) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2.append(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r8 == 0) goto L83
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 == 0) goto L83
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r9 <= 0) goto L7c
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f6351d = r1     // Catch: java.lang.Throwable -> L79
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L79
            if (r1 < 0) goto L67
            int r1 = r8.getInt(r1)     // Catch: java.lang.Throwable -> L79
            com.google.android.gms.dynamite.DynamiteModule.f6352e = r1     // Catch: java.lang.Throwable -> L79
        L67:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$b> r10 = com.google.android.gms.dynamite.DynamiteModule.f6353f     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$b r10 = (com.google.android.gms.dynamite.DynamiteModule.b) r10     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r10 == 0) goto L7c
            android.database.Cursor r1 = r10.a     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            if (r1 != 0) goto L7c
            r10.a = r8     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            goto L7d
        L79:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L79
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L7c:
            r0 = r8
        L7d:
            if (r0 == 0) goto L82
            r0.close()
        L82:
            return r9
        L83:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
            throw r9     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L96
        L92:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lae
        L96:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9f
        L9b:
            r8 = move-exception
            goto Lae
        L9d:
            r8 = move-exception
            r9 = r0
        L9f:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch: java.lang.Throwable -> Lac
            if (r10 == 0) goto La4
            throw r8     // Catch: java.lang.Throwable -> Lac
        La4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch: java.lang.Throwable -> Lac
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> Lac
            throw r10     // Catch: java.lang.Throwable -> Lac
        Lac:
            r8 = move-exception
            r0 = r9
        Lae:
            if (r0 == 0) goto Lb3
            r0.close()
        Lb3:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.l(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule m(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static j n(Context context) {
        j iVar;
        synchronized (DynamiteModule.class) {
            j jVar = f6349b;
            if (jVar != null) {
                return jVar;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    iVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof j) {
                        iVar = (j) queryLocalInterface;
                    } else {
                        iVar = new i(iBinder);
                    }
                }
                if (iVar != null) {
                    f6349b = iVar;
                    return iVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    public final Context b() {
        return this.n;
    }

    public final IBinder d(String str) throws LoadingException {
        try {
            return (IBinder) this.n.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
        }
    }
}