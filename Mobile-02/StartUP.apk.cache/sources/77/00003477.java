package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
/* loaded from: classes2.dex */
public class bd {
    private static volatile bd a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f7044b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f7045c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f7046d = false;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f7047e = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f7048f = "use_dynamite_api";

    /* renamed from: g  reason: collision with root package name */
    private static String f7049g = "allow_remote_dynamite";

    /* renamed from: h  reason: collision with root package name */
    private static boolean f7050h = true;

    /* renamed from: i  reason: collision with root package name */
    private final String f7051i;

    /* renamed from: j  reason: collision with root package name */
    protected final com.google.android.gms.common.util.e f7052j;

    /* renamed from: k  reason: collision with root package name */
    private final ExecutorService f7053k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.gms.measurement.a.a f7054l;
    private List<Pair<com.google.android.gms.measurement.internal.f6, c>> m;
    private int n;
    private boolean o;
    private String p;
    private h9 q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
    /* loaded from: classes2.dex */
    public abstract class a implements Runnable {
        final long a;

        /* renamed from: b  reason: collision with root package name */
        final long f7055b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7056c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(bd bdVar) {
            this(true);
        }

        abstract void a() throws RemoteException;

        protected void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bd.this.o) {
                b();
                return;
            }
            try {
                a();
            } catch (Exception e2) {
                bd.this.n(e2, false, this.f7056c);
                b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(boolean z) {
            this.a = bd.this.f7052j.a();
            this.f7055b = bd.this.f7052j.b();
            this.f7056c = z;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
    /* loaded from: classes2.dex */
    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            bd.this.j(new v(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            bd.this.j(new a0(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            bd.this.j(new w(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            bd.this.j(new x(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            ia iaVar = new ia();
            bd.this.j(new y(this, activity, iaVar));
            Bundle Y0 = iaVar.Y0(50L);
            if (Y0 != null) {
                bundle.putAll(Y0);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            bd.this.j(new u(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            bd.this.j(new z(this, activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.0 */
    /* loaded from: classes2.dex */
    public static class c extends vc {
        private final com.google.android.gms.measurement.internal.f6 a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(com.google.android.gms.measurement.internal.f6 f6Var) {
            this.a = f6Var;
        }

        @Override // com.google.android.gms.internal.measurement.sc
        public final int a() {
            return System.identityHashCode(this.a);
        }

        @Override // com.google.android.gms.internal.measurement.sc
        public final void l0(String str, String str2, Bundle bundle, long j2) {
            this.a.a(str, str2, bundle, j2);
        }
    }

    private bd(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str != null && G(str2, str3)) {
            this.f7051i = str;
        } else {
            this.f7051i = "FA";
        }
        this.f7052j = com.google.android.gms.common.util.h.c();
        this.f7053k = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f7054l = new com.google.android.gms.measurement.a.a(this);
        if (!(!O(context) || U())) {
            this.p = null;
            this.o = true;
            Log.w(this.f7051i, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!G(str2, str3)) {
            this.p = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.f7051i, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f7051i, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        } else {
            this.p = str2;
        }
        j(new ad(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f7051i, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new b());
        }
    }

    public static boolean B(Context context) {
        S(context);
        synchronized (bd.class) {
            if (!f7046d) {
                try {
                    String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "measurement.dynamite.enabled", "");
                    if ("true".equals(str)) {
                        f7047e = Boolean.TRUE;
                    } else if ("false".equals(str)) {
                        f7047e = Boolean.FALSE;
                    } else {
                        f7047e = null;
                    }
                    f7046d = true;
                } catch (Exception e2) {
                    Log.e("FA", "Unable to call SystemProperties.get()", e2);
                    f7047e = null;
                    f7046d = true;
                }
            }
        }
        Boolean bool = f7047e;
        if (bool == null) {
            bool = f7044b;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean G(String str, String str2) {
        return (str2 == null || str == null || U()) ? false : true;
    }

    private static boolean O(Context context) {
        return new com.google.android.gms.common.internal.x(context).a("google_app_id") != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int P(Context context) {
        return DynamiteModule.c(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int R(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Context context) {
        synchronized (bd.class) {
            try {
            } catch (Exception e2) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e2);
                f7044b = Boolean.valueOf(f7050h);
                f7045c = Boolean.FALSE;
            }
            if (f7044b == null || f7045c == null) {
                if (t(context, "app_measurement_internal_disable_startup_flags")) {
                    f7044b = Boolean.valueOf(f7050h);
                    f7045c = Boolean.FALSE;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                f7044b = Boolean.valueOf(sharedPreferences.getBoolean(f7048f, f7050h));
                f7045c = Boolean.valueOf(sharedPreferences.getBoolean(f7049g, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(f7048f);
                edit.remove(f7049g);
                edit.apply();
            }
        }
    }

    private static boolean U() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static bd c(Context context) {
        return d(context, null, null, null, null);
    }

    public static bd d(Context context, String str, String str2, String str3, Bundle bundle) {
        com.google.android.gms.common.internal.t.k(context);
        if (a == null) {
            synchronized (bd.class) {
                if (a == null) {
                    a = new bd(context, str, str2, str3, bundle);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(a aVar) {
        this.f7053k.execute(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Exception exc, boolean z, boolean z2) {
        this.o |= z;
        if (z) {
            Log.w(this.f7051i, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            g(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.f7051i, "Error with data collection. Data lost.", exc);
    }

    private final void q(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l2) {
        j(new q(this, l2, str, str2, bundle, z, z2));
    }

    private final void s(String str, String str2, Object obj, boolean z) {
        j(new t(this, str, str2, obj, z));
    }

    private static boolean t(Context context, String str) {
        Bundle bundle;
        com.google.android.gms.common.internal.t.g(str);
        try {
            ApplicationInfo c2 = com.google.android.gms.common.n.c.a(context).c(context.getPackageName(), 128);
            if (c2 != null && (bundle = c2.metaData) != null) {
                return bundle.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void A(boolean z) {
        j(new p(this, z));
    }

    public final String D() {
        ia iaVar = new ia();
        j(new g(this, iaVar));
        return iaVar.q(500L);
    }

    public final void F(String str) {
        j(new e(this, str));
    }

    public final int I(String str) {
        ia iaVar = new ia();
        j(new n(this, str, iaVar));
        Integer num = (Integer) ia.p(iaVar.Y0(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String J() {
        ia iaVar = new ia();
        j(new i(this, iaVar));
        return iaVar.q(50L);
    }

    public final long M() {
        ia iaVar = new ia();
        j(new h(this, iaVar));
        Long l2 = (Long) ia.p(iaVar.Y0(500L), Long.class);
        if (l2 == null) {
            long nextLong = new Random(System.nanoTime() ^ this.f7052j.a()).nextLong();
            int i2 = this.n + 1;
            this.n = i2;
            return nextLong + i2;
        }
        return l2.longValue();
    }

    public final String N() {
        ia iaVar = new ia();
        j(new k(this, iaVar));
        return iaVar.q(500L);
    }

    public final String Q() {
        ia iaVar = new ia();
        j(new j(this, iaVar));
        return iaVar.q(500L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final h9 a(Context context, boolean z) {
        DynamiteModule.a aVar;
        try {
            if (z) {
                aVar = DynamiteModule.f6359l;
            } else {
                aVar = DynamiteModule.f6356i;
            }
            return kc.asInterface(DynamiteModule.e(context, aVar, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e2) {
            n(e2, true, false);
            return null;
        }
    }

    public final Map<String, Object> f(String str, String str2, boolean z) {
        ia iaVar = new ia();
        j(new m(this, str, str2, z, iaVar));
        Bundle Y0 = iaVar.Y0(5000L);
        if (Y0 != null && Y0.size() != 0) {
            HashMap hashMap = new HashMap(Y0.size());
            for (String str3 : Y0.keySet()) {
                Object obj = Y0.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public final void g(int i2, String str, Object obj, Object obj2, Object obj3) {
        j(new l(this, false, 5, str, obj, null, null));
    }

    public final void h(Activity activity, String str, String str2) {
        j(new d(this, activity, str, str2));
    }

    public final void i(Bundle bundle) {
        j(new s(this, bundle));
    }

    public final void m(com.google.android.gms.measurement.internal.f6 f6Var) {
        com.google.android.gms.common.internal.t.k(f6Var);
        j(new o(this, f6Var));
    }

    public final void o(String str, Bundle bundle) {
        q(null, str, bundle, false, true, null);
    }

    public final void p(String str, String str2, Bundle bundle) {
        q(str, str2, bundle, true, true, null);
    }

    public final void r(String str, String str2, Object obj) {
        s(str, str2, obj, true);
    }

    public final List<Bundle> x(String str, String str2) {
        ia iaVar = new ia();
        j(new com.google.android.gms.internal.measurement.b(this, str, str2, iaVar));
        List<Bundle> list = (List) ia.p(iaVar.Y0(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void y(String str) {
        j(new f(this, str));
    }

    public final void z(String str, String str2, Bundle bundle) {
        j(new com.google.android.gms.internal.measurement.c(this, str, str2, bundle));
    }
}