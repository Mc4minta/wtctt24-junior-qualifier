package io.branch.referral;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemObserver.java */
/* loaded from: classes2.dex */
public abstract class g0 {
    private String a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f16964b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemObserver.java */
    /* loaded from: classes2.dex */
    public interface a {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SystemObserver.java */
    /* loaded from: classes2.dex */
    public class b extends io.branch.referral.c<Void, Void, Void> {
        private WeakReference<Context> a;

        /* renamed from: b  reason: collision with root package name */
        private final a f16965b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SystemObserver.java */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            final /* synthetic */ CountDownLatch a;

            a(CountDownLatch countDownLatch) {
                this.a = countDownLatch;
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context = (Context) b.this.a.get();
                if (context != null) {
                    Process.setThreadPriority(-19);
                    Object g2 = b.this.g(context);
                    b.this.i(g2);
                    b.this.j(g2);
                }
                this.a.countDown();
            }
        }

        public b(Context context, a aVar) {
            this.a = new WeakReference<>(context);
            this.f16965b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object g(Context context) {
            if (context != null) {
                try {
                    return Class.forName("e.g.a.e.a.a.a").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(Object obj) {
            try {
                Method method = obj.getClass().getMethod("getId", new Class[0]);
                g0.this.a = (String) method.invoke(obj, new Object[0]);
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Object obj) {
            try {
                Method method = obj.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
                g0.this.f16964b = ((Boolean) method.invoke(obj, new Object[0])).booleanValue() ? 1 : 0;
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f */
        public Void doInBackground(Void... voidArr) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new a(countDownLatch)).start();
            try {
                countDownLatch.await(1500L, TimeUnit.MILLISECONDS);
                return null;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: h */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            a aVar = this.f16965b;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemObserver.java */
    /* loaded from: classes2.dex */
    public static class c {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f16968b;

        c(Context context, boolean z) {
            this.f16968b = !z;
            this.a = "bnc_no_value";
            String str = null;
            if (context != null && !z && !io.branch.referral.b.p0()) {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            }
            if (str == null) {
                str = UUID.randomUUID().toString();
                this.f16968b = false;
            }
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String a() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b() {
            return this.f16968b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                return this.a.equals(cVar.a) && this.f16968b == cVar.f16968b;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.f16968b ? 1 : 0) + 1) * 31;
            String str = this.a;
            return i2 + (str == null ? 0 : str.hashCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r2) {
        /*
            if (r2 == 0) goto L18
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch: java.lang.Exception -> L12
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Exception -> L12
            r1 = 0
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r1)     // Catch: java.lang.Exception -> L12
            java.lang.String r2 = r2.versionName     // Catch: java.lang.Exception -> L12
            goto L1a
        L12:
            r2 = move-exception
            java.lang.String r0 = "Error obtaining AppVersion"
            io.branch.referral.q.c(r0, r2)
        L18:
            java.lang.String r2 = ""
        L1a:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L22
            java.lang.String r2 = "bnc_no_value"
        L22:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.g0.c(android.content.Context):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            } catch (Exception e2) {
                q.c("Error obtaining FirstInstallTime", e2);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        return Locale.getDefault() != null ? Locale.getDefault().getCountry() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        return Locale.getDefault() != null ? Locale.getDefault().getLanguage() : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long i(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            } catch (Exception e2) {
                q.c("Error obtaining LastUpdateTime", e2);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j() {
        String str = "";
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator it = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (hostAddress.indexOf(58) < 0) {
                                str = hostAddress;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String k() {
        return "Android";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l() {
        return Build.VERSION.SDK_INT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m() {
        return Build.MANUFACTURER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n() {
        return Build.MODEL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayMetrics o(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String p(Context context) {
        UiModeManager uiModeManager;
        String str;
        if (context != null) {
            try {
                uiModeManager = (UiModeManager) context.getSystemService("uimode");
            } catch (Exception unused) {
                return "UI_MODE_TYPE_UNDEFINED";
            }
        } else {
            uiModeManager = null;
        }
        if (uiModeManager != null) {
            switch (uiModeManager.getCurrentModeType()) {
                case 1:
                    str = "UI_MODE_TYPE_NORMAL";
                    break;
                case 2:
                    str = "UI_MODE_TYPE_DESK";
                    break;
                case 3:
                    str = "UI_MODE_TYPE_CAR";
                    break;
                case 4:
                    str = "UI_MODE_TYPE_TELEVISION";
                    break;
                case 5:
                    str = "UI_MODE_TYPE_APPLIANCE";
                    break;
                case 6:
                    str = "UI_MODE_TYPE_WATCH";
                    break;
                default:
                    return "UI_MODE_TYPE_UNDEFINED";
            }
            return str;
        }
        return "UI_MODE_TYPE_UNDEFINED";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c q(Context context, boolean z) {
        return new c(context, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
        return networkInfo != null && networkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(Context context) {
        List<ResolveInfo> queryIntentActivities;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                if (launchIntentForPackage == null || (queryIntentActivities = packageManager.queryIntentActivities(launchIntentForPackage, 65536)) == null) {
                    return false;
                }
                return queryIntentActivities.size() > 0;
            } catch (Exception e2) {
                q.c("Error obtaining PackageInfo", e2);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f16964b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(Context context, a aVar) {
        if (TextUtils.isEmpty(this.a)) {
            new b(context, aVar).a(new Void[0]);
            return true;
        }
        return false;
    }
}