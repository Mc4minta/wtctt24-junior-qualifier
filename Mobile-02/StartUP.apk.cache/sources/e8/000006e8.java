package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import com.appsflyer.AFFacebookDeferredDeeplink;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.Foreground;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.internal.aa;
import com.appsflyer.internal.ab;
import com.appsflyer.internal.ac;
import com.appsflyer.internal.ad;
import com.appsflyer.internal.ae;
import com.appsflyer.internal.af;
import com.appsflyer.internal.ag;
import com.appsflyer.internal.ah;
import com.appsflyer.internal.ai;
import com.appsflyer.internal.c;
import com.appsflyer.internal.d;
import com.appsflyer.internal.j;
import com.appsflyer.internal.model.event.AdRevenue;
import com.appsflyer.internal.model.event.Attr;
import com.appsflyer.internal.model.event.BackgroundEvent;
import com.appsflyer.internal.model.event.BackgroundReferrerLaunch;
import com.appsflyer.internal.model.event.CachedEvent;
import com.appsflyer.internal.model.event.InAppEvent;
import com.appsflyer.internal.model.event.Launch;
import com.appsflyer.internal.model.event.ProxyEvent;
import com.appsflyer.internal.model.event.Stats;
import com.appsflyer.internal.model.event.UninstallTokenEvent;
import com.appsflyer.internal.referrer.GoogleReferrer;
import com.appsflyer.internal.referrer.HuaweiReferrer;
import com.appsflyer.internal.referrer.MandatoryFields;
import com.appsflyer.internal.referrer.Payload;
import com.appsflyer.internal.s;
import com.appsflyer.internal.t;
import com.appsflyer.internal.v;
import com.appsflyer.internal.w;
import com.appsflyer.internal.x;
import com.appsflyer.internal.y;
import com.appsflyer.internal.z;
import com.appsflyer.share.Constants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppsFlyerLibCore extends AppsFlyerLib {
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static String FIRST_LAUNCHES_URL = null;
    public static final String INSTALL_REFERRER_PREF = "rfr";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_5.4.0";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";
    public static String REFERRER_TRACKING_URL = null;
    public static String REGISTER_URL = null;
    public static AppsFlyerLibCore instance = null;

    /* renamed from: ı  reason: contains not printable characters */
    public static final String f58 = "5.4";

    /* renamed from: Ɩ  reason: contains not printable characters */
    private static final String f59;

    /* renamed from: ǃ  reason: contains not printable characters */
    public static AppsFlyerInAppPurchaseValidatorListener f60 = null;

    /* renamed from: ɩ  reason: contains not printable characters */
    public static final String f61 = "38";

    /* renamed from: ɪ  reason: contains not printable characters */
    private static AppsFlyerConversionListener f62;

    /* renamed from: ɹ  reason: contains not printable characters */
    private static String f63;

    /* renamed from: ɾ  reason: contains not printable characters */
    private static String f64;

    /* renamed from: І  reason: contains not printable characters */
    private static String f65;

    /* renamed from: і  reason: contains not printable characters */
    private static final String f66;

    /* renamed from: ӏ  reason: contains not printable characters */
    private static final List<String> f67;

    /* renamed from: ſ  reason: contains not printable characters */
    private long f70;

    /* renamed from: Ɨ  reason: contains not printable characters */
    private String f71;

    /* renamed from: ƚ  reason: contains not printable characters */
    private Map<Long, String> f72;

    /* renamed from: ǀ  reason: contains not printable characters */
    private boolean f73;

    /* renamed from: ɨ  reason: contains not printable characters */
    private String f78;

    /* renamed from: ɺ  reason: contains not printable characters */
    private boolean f79;

    /* renamed from: ʅ  reason: contains not printable characters */
    private long f82;

    /* renamed from: ʟ  reason: contains not printable characters */
    private GoogleReferrer f83;

    /* renamed from: ͻ  reason: contains not printable characters */
    private Map<String, Object> f84;

    /* renamed from: Ι  reason: contains not printable characters */
    public String f85;

    /* renamed from: ι  reason: contains not printable characters */
    public String f86;

    /* renamed from: ϲ  reason: contains not printable characters */
    private Map<String, Object> f87;

    /* renamed from: ϳ  reason: contains not printable characters */
    private Application f88;

    /* renamed from: т  reason: contains not printable characters */
    private HuaweiReferrer f92;

    /* renamed from: х  reason: contains not printable characters */
    private String f93;

    /* renamed from: Ӏ  reason: contains not printable characters */
    long f94;
    protected Uri latestDeepLink = null;

    /* renamed from: ȷ  reason: contains not printable characters */
    private long f74 = -1;

    /* renamed from: ŀ  reason: contains not printable characters */
    private long f68 = -1;

    /* renamed from: ɿ  reason: contains not printable characters */
    private long f81 = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: г  reason: contains not printable characters */
    private boolean f90 = false;

    /* renamed from: ł  reason: contains not printable characters */
    private ScheduledExecutorService f69 = null;

    /* renamed from: ɍ  reason: contains not printable characters */
    private boolean f75 = false;

    /* renamed from: ɟ  reason: contains not printable characters */
    private ag f77 = new ag();

    /* renamed from: ɔ  reason: contains not printable characters */
    private boolean f76 = false;

    /* renamed from: ɼ  reason: contains not printable characters */
    private boolean f80 = false;

    /* renamed from: Ј  reason: contains not printable characters */
    private boolean f89 = false;

    /* renamed from: с  reason: contains not printable characters */
    private boolean f91 = false;

    /* renamed from: com.appsflyer.AppsFlyerLibCore$10  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: ι  reason: contains not printable characters */
        static final /* synthetic */ int[] f97;

        static {
            int[] iArr = new int[AppsFlyerProperties.EmailsCryptType.values().length];
            f97 = iArr;
            try {
                iArr[AppsFlyerProperties.EmailsCryptType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f97[AppsFlyerProperties.EmailsCryptType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: ɩ  reason: contains not printable characters */
        private final AFEvent f111;

        /* synthetic */ a(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b2) {
            this(aFEvent);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v30 */
        @Override // java.lang.Runnable
        public final void run() {
            String str;
            Map<String, Object> params = this.f111.params();
            boolean m5 = this.f111.m5();
            String urlString = this.f111.urlString();
            AFEvent aFEvent = this.f111;
            int i2 = aFEvent.f11;
            Context context = aFEvent.context();
            if (AppsFlyerLibCore.this.isTrackingStopped()) {
                return;
            }
            byte[] bArr = new byte[0];
            if (m5 && i2 <= 2) {
                ArrayList arrayList = new ArrayList();
                if (AppsFlyerLibCore.this.m69()) {
                    params.put(AppsFlyerLibCore.INSTALL_REFERRER_PREF, AppsFlyerLibCore.this.f83.oldMap);
                    AppsFlyerLibCore.getSharedPreferences(context).edit().putBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, true).apply();
                    arrayList.add(AppsFlyerLibCore.this.f83.newMap);
                }
                if (AppsFlyerLibCore.this.f92 != null) {
                    Map<String, Object> map = AppsFlyerLibCore.this.f92.map;
                    if (map == null) {
                        if (AppsFlyerLibCore.this.f92.valid() && i2 == 2) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(Payload.SOURCE, Payload.SOURCE_HUAWEI);
                            hashMap.put(Payload.RESPONSE, Payload.RESPONSE_TIMEOUT);
                            hashMap.putAll(new MandatoryFields());
                            arrayList.add(hashMap);
                        }
                    } else {
                        arrayList.add(map);
                    }
                }
                if (!arrayList.isEmpty()) {
                    params.put(Payload.RFRS, arrayList);
                }
                if (AppsFlyerLibCore.this.f84 != null) {
                    params.put("fb_ddl", AppsFlyerLibCore.this.f84);
                }
                if (!AppsFlyerLibCore.this.m95()) {
                    if (AppsFlyerLibCore.this.f91) {
                        AppsFlyerLibCore.this.f87 = new HashMap();
                        AppsFlyerLibCore.this.f87.put("error", "operation timed out.");
                    }
                } else {
                    params.put("lvl", AppsFlyerLibCore.this.f87);
                }
            }
            if (!(this.f111 instanceof AdRevenue)) {
                params.putAll(new c.a(params, context));
            }
            OutputStreamWriter outputStreamWriter = null;
            outputStreamWriter = 0;
            outputStreamWriter = 0;
            outputStreamWriter = null;
            try {
                try {
                    AFEvent aFEvent2 = this.f111;
                    if (aFEvent2 instanceof AdRevenue) {
                        str = (String) params.get("af_key");
                    } else {
                        str = (String) params.get("appsflyerKey");
                    }
                    aFEvent2.key(str);
                    synchronized (params) {
                        try {
                            byte[] bArr2 = (byte[]) ((Class) d.m176(48, (char) 11758, 24)).getMethod("ɩ", AFEvent.class).invoke(null, this.f111);
                            try {
                                try {
                                    AppsFlyerLibCore.m44(AppsFlyerLibCore.this, this.f111.post(bArr2));
                                    return;
                                } catch (IOException e2) {
                                    e = e2;
                                    bArr = bArr2;
                                    AFLogger.afErrorLog("Exception while sending request to server. ", e);
                                    if (bArr == null || context == null || urlString.contains("&isCachedRequest=true&timeincache=")) {
                                        return;
                                    }
                                    aa.m116();
                                    j jVar = new j(urlString, bArr, "5.4.0");
                                    try {
                                        try {
                                            File m119 = aa.m119(context);
                                            if (!m119.exists()) {
                                                m119.mkdir();
                                            } else {
                                                File[] listFiles = m119.listFiles();
                                                if (listFiles != null && listFiles.length > 40) {
                                                    Log.i(AppsFlyerLibCore.LOG_TAG, "reached cache limit, not caching request");
                                                } else {
                                                    Log.i(AppsFlyerLibCore.LOG_TAG, "caching request...");
                                                    File file = new File(aa.m119(context), Long.toString(System.currentTimeMillis()));
                                                    file.createNewFile();
                                                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file.getPath(), true));
                                                    try {
                                                        outputStreamWriter2.write("version=");
                                                        outputStreamWriter2.write(jVar.f266);
                                                        outputStreamWriter = 10;
                                                        outputStreamWriter2.write(10);
                                                        outputStreamWriter2.write("url=");
                                                        outputStreamWriter2.write(jVar.f264);
                                                        outputStreamWriter2.write(10);
                                                        outputStreamWriter2.write("data=");
                                                        outputStreamWriter2.write(Base64.encodeToString(jVar.m181(), 2));
                                                        outputStreamWriter2.write(10);
                                                        outputStreamWriter2.flush();
                                                    } catch (Exception unused) {
                                                        outputStreamWriter = outputStreamWriter2;
                                                        Log.i(AppsFlyerLibCore.LOG_TAG, "Could not cache request");
                                                        if (outputStreamWriter != null) {
                                                            outputStreamWriter.close();
                                                        }
                                                        AFLogger.afErrorLog(e.getMessage(), e);
                                                        return;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        outputStreamWriter = outputStreamWriter2;
                                                        if (outputStreamWriter != null) {
                                                            try {
                                                                outputStreamWriter.close();
                                                            } catch (IOException unused2) {
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                    try {
                                                        outputStreamWriter2.close();
                                                    } catch (IOException unused3) {
                                                        AFLogger.afErrorLog(e.getMessage(), e);
                                                        return;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } catch (Exception unused4) {
                                    }
                                    AFLogger.afErrorLog(e.getMessage(), e);
                                    return;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bArr = bArr2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th5) {
                AFLogger.afErrorLog(th5.getMessage(), th5);
            }
        }

        private a(AFEvent aFEvent) {
            this.f111 = aFEvent.weakContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Runnable {

        /* renamed from: ı  reason: contains not printable characters */
        private static String f113 = "https://%sgcdsdk.%s/install_data/v4.0/";

        /* renamed from: ι  reason: contains not printable characters */
        private static final List<String> f114 = Arrays.asList("googleplay", "playstore", "googleplaystore");

        /* renamed from: ǃ  reason: contains not printable characters */
        private final String f115;

        /* renamed from: ɩ  reason: contains not printable characters */
        private final Application f116;

        /* renamed from: ɹ  reason: contains not printable characters */
        private AppsFlyerLibCore f117;

        /* renamed from: Ι  reason: contains not printable characters */
        final ScheduledExecutorService f118;

        /* renamed from: І  reason: contains not printable characters */
        private final AtomicInteger f119;

        /* renamed from: і  reason: contains not printable characters */
        private final int f120;

        /* synthetic */ b(AppsFlyerLibCore appsFlyerLibCore, Application application, String str, byte b2) {
            this(appsFlyerLibCore, application, str);
        }

        /* renamed from: Ι  reason: contains not printable characters */
        private void m110(String str, int i2) {
            if (500 <= i2 && i2 < 600) {
                if (this.f120 == 2) {
                    AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                    AppsFlyerLibCore.f62.onConversionDataFail(str);
                    return;
                }
                b bVar = new b(this);
                AppsFlyerLibCore.m68(bVar.f118, bVar, 10L, TimeUnit.MILLISECONDS);
                return;
            }
            AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            AppsFlyerLibCore.f62.onConversionDataFail(str);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(17:15|16|(2:18|(14:20|21|(1:23)|24|26|27|(1:29)|30|(6:34|(1:36)|37|38|39|40)|41|(13:43|(1:45)|(1:49)|50|51|(2:53|(1:55)(1:56))|57|(1:59)|60|61|(1:63)(1:77)|64|(5:68|69|(1:71)|73|74))|38|39|40)(1:94))|95|21|(0)|24|26|27|(0)|30|(6:34|(0)|37|38|39|40)|41|(0)|38|39|40) */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x026e, code lost:
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x026f, code lost:
            r2 = r7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0276, code lost:
            if (com.appsflyer.AppsFlyerLibCore.f62 != null) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0278, code lost:
            m110(r0.getMessage(), 0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x027f, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x0296, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0297, code lost:
            r14.f119.decrementAndGet();
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x029c, code lost:
            if (r2 != null) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x029e, code lost:
            r2.disconnect();
         */
        /* JADX WARN: Code restructure failed: missing block: B:90:0x02a1, code lost:
            throw r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: all -> 0x0271, TryCatch #0 {all -> 0x0271, blocks: (B:11:0x0020, B:15:0x002a, B:18:0x003f, B:20:0x004b, B:23:0x0060, B:25:0x009f, B:26:0x00a6, B:21:0x0052), top: B:92:0x0020 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f1 A[Catch: all -> 0x026e, TryCatch #3 {all -> 0x026e, blocks: (B:27:0x00cf, B:29:0x00f1, B:30:0x00f8, B:34:0x0113, B:36:0x0119, B:37:0x0126, B:38:0x0141, B:40:0x0160, B:42:0x016e, B:44:0x0188, B:46:0x018e, B:47:0x0199, B:50:0x01a3, B:52:0x01a9, B:53:0x01bd, B:54:0x01ce, B:56:0x01d4, B:57:0x01e7, B:60:0x01f9, B:62:0x0204, B:64:0x0220, B:66:0x0228, B:68:0x023c, B:72:0x0249, B:71:0x0244, B:61:0x01ff), top: B:98:0x00cf, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0119 A[Catch: all -> 0x026e, TryCatch #3 {all -> 0x026e, blocks: (B:27:0x00cf, B:29:0x00f1, B:30:0x00f8, B:34:0x0113, B:36:0x0119, B:37:0x0126, B:38:0x0141, B:40:0x0160, B:42:0x016e, B:44:0x0188, B:46:0x018e, B:47:0x0199, B:50:0x01a3, B:52:0x01a9, B:53:0x01bd, B:54:0x01ce, B:56:0x01d4, B:57:0x01e7, B:60:0x01f9, B:62:0x0204, B:64:0x0220, B:66:0x0228, B:68:0x023c, B:72:0x0249, B:71:0x0244, B:61:0x01ff), top: B:98:0x00cf, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0160 A[Catch: all -> 0x026e, TryCatch #3 {all -> 0x026e, blocks: (B:27:0x00cf, B:29:0x00f1, B:30:0x00f8, B:34:0x0113, B:36:0x0119, B:37:0x0126, B:38:0x0141, B:40:0x0160, B:42:0x016e, B:44:0x0188, B:46:0x018e, B:47:0x0199, B:50:0x01a3, B:52:0x01a9, B:53:0x01bd, B:54:0x01ce, B:56:0x01d4, B:57:0x01e7, B:60:0x01f9, B:62:0x0204, B:64:0x0220, B:66:0x0228, B:68:0x023c, B:72:0x0249, B:71:0x0244, B:61:0x01ff), top: B:98:0x00cf, inners: #1 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 675
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.b.run():void");
        }

        private b(AppsFlyerLibCore appsFlyerLibCore, Application application, String str) {
            this.f118 = AFExecutor.getInstance().m8();
            this.f119 = new AtomicInteger(0);
            this.f117 = appsFlyerLibCore;
            this.f116 = application;
            this.f115 = str;
            this.f120 = 0;
        }

        private b(b bVar) {
            this.f118 = AFExecutor.getInstance().m8();
            this.f119 = new AtomicInteger(0);
            this.f117 = bVar.f117;
            this.f116 = bVar.f116;
            this.f115 = bVar.f115;
            this.f120 = bVar.f120 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: ι  reason: contains not printable characters */
        private WeakReference<Context> f122;

        public c(Context context) {
            this.f122 = null;
            this.f122 = new WeakReference<>(context);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (AppsFlyerLibCore.this.f90) {
                return;
            }
            AppsFlyerLibCore.this.f94 = System.currentTimeMillis();
            if (this.f122 == null) {
                return;
            }
            AppsFlyerLibCore.this.f90 = true;
            try {
                try {
                    String m55 = AppsFlyerLibCore.m55(AppsFlyerProperties.AF_KEY);
                    synchronized (this.f122) {
                        aa.m116();
                        for (j jVar : aa.m117(this.f122.get())) {
                            StringBuilder sb = new StringBuilder("resending request: ");
                            sb.append(jVar.f264);
                            AFLogger.afInfoLog(sb.toString());
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                long parseLong = Long.parseLong(jVar.f265, 10);
                                AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                                CachedEvent cachedEvent = new CachedEvent();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(jVar.f264);
                                sb2.append("&isCachedRequest=true&timeincache=");
                                sb2.append((currentTimeMillis - parseLong) / 1000);
                                AFEvent key = cachedEvent.urlString(sb2.toString()).post(jVar.m181()).key(m55);
                                key.f7 = this.f122;
                                key.f14 = jVar.f265;
                                key.f10 = false;
                                AppsFlyerLibCore.m44(appsFlyerLibCore, key);
                            } catch (Exception e2) {
                                AFLogger.afErrorLog("Failed to resend cached request", e2);
                            }
                        }
                    }
                } catch (Exception e3) {
                    AFLogger.afErrorLog("failed to check cache. ", e3);
                }
                AppsFlyerLibCore.this.f90 = false;
                AppsFlyerLibCore.this.f69.shutdown();
                AppsFlyerLibCore.m98(AppsFlyerLibCore.this);
            } catch (Throwable th) {
                AppsFlyerLibCore.this.f90 = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: ı  reason: contains not printable characters */
        private AFEvent f123;

        /* synthetic */ e(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b2) {
            this(aFEvent);
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
            AFEvent aFEvent = this.f123;
            aFEvent.f18 = aFEvent.f7.get();
            appsFlyerLibCore.m43(aFEvent);
        }

        private e(AFEvent aFEvent) {
            this.f123 = aFEvent;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f58);
        sb.append("/androidevent?buildnumber=5.4.0&app_id=");
        String obj = sb.toString();
        f59 = obj;
        StringBuilder sb2 = new StringBuilder("https://%sregister.%s/api/v");
        sb2.append(obj);
        REGISTER_URL = sb2.toString();
        StringBuilder sb3 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb3.append(f58);
        sb3.append("/android?buildnumber=5.4.0&app_id=");
        f65 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(f58);
        sb4.append("/androidevent?app_id=");
        String obj2 = sb4.toString();
        f66 = obj2;
        StringBuilder sb5 = new StringBuilder("https://%sconversions.%s/api/v");
        sb5.append(obj2);
        FIRST_LAUNCHES_URL = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%slaunches.%s/api/v");
        sb6.append(obj2);
        f63 = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sinapps.%s/api/v");
        sb7.append(obj2);
        f64 = sb7.toString();
        StringBuilder sb8 = new StringBuilder("https://%sattr.%s/api/v");
        sb8.append(obj2);
        REFERRER_TRACKING_URL = sb8.toString();
        f67 = Arrays.asList("is_cache");
        f60 = null;
        f62 = null;
        instance = new AppsFlyerLibCore();
    }

    public AppsFlyerLibCore() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLibCore getInstance() {
        return instance;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
    }

    /* renamed from: ӏ  reason: contains not printable characters */
    static /* synthetic */ ScheduledExecutorService m98(AppsFlyerLibCore appsFlyerLibCore) {
        appsFlyerLibCore.f69 = null;
        return null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void enableFacebookDeferredApplinks(boolean z) {
        this.f89 = z;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.f75 = z;
        return this;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public String getAppsFlyerUID(Context context) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "getAppsFlyerUID", new String[0]);
        return ae.m125(new WeakReference(context));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public String getAttributionId(Context context) {
        try {
            return new ac(context).m122();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public String getConfiguredChannel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = context == null ? null : m64("CHANNEL", context.getPackageManager(), context.getPackageName());
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    protected void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        f62 = new AppsFlyerConversionListener() { // from class: com.appsflyer.AppsFlyerLibCore.6
            @Override // com.appsflyer.AppsFlyerConversionListener
            public final void onAppOpenAttribution(Map<String, String> map) {
            }

            @Override // com.appsflyer.AppsFlyerConversionListener
            public final void onAttributionFailure(String str) {
            }

            @Override // com.appsflyer.AppsFlyerConversionListener
            public final void onConversionDataFail(String str) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                ConversionDataListener.this.onConversionFailure(str);
            }

            @Override // com.appsflyer.AppsFlyerConversionListener
            public final void onConversionDataSuccess(Map<String, Object> map) {
                StringBuilder sb = new StringBuilder("Calling onConversionDataLoaded with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                ConversionDataListener.this.onConversionDataLoaded(map);
            }
        };
    }

    @Override // com.appsflyer.AppsFlyerLib
    public String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : ServerParameters.DEFAULT_HOST;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    public final int getLaunchCounter(SharedPreferences sharedPreferences, boolean z) {
        return m51(sharedPreferences, "appsFlyerCount", z);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String m64 = context == null ? null : m64("AF_STORE", context.getPackageManager(), context.getPackageName());
        if (m64 != null) {
            return m64;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public String getSdkVersion() {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 5.4.0 (build ");
        sb.append(f61);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleDeepLinkCallback(Context context, Map<String, Object> map, Uri uri) {
        String obj = uri.toString();
        if (obj == null) {
            obj = null;
        } else if (obj.matches("fb\\d*?://authorize.*") && obj.contains("access_token")) {
            int indexOf = obj.indexOf(63);
            String substring = indexOf == -1 ? "" : obj.substring(indexOf);
            if (substring.length() != 0) {
                ArrayList arrayList = new ArrayList();
                if (substring.contains("&")) {
                    arrayList = new ArrayList(Arrays.asList(substring.split("&")));
                } else {
                    arrayList.add(substring);
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str.contains("access_token")) {
                        it.remove();
                    } else {
                        if (sb.length() != 0) {
                            sb.append("&");
                        } else if (!str.startsWith("?")) {
                            sb.append("?");
                        }
                        sb.append(str);
                    }
                }
                obj = obj.replace(substring, sb.toString());
            }
        }
        if (!map.containsKey("af_deeplink")) {
            map.put("af_deeplink", obj);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        final WeakReference weakReference = new WeakReference(context);
        ab abVar = new ab(uri, this);
        abVar.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        if (abVar.m120()) {
            abVar.f166 = new ab.b() { // from class: com.appsflyer.AppsFlyerLibCore.8
                /* renamed from: ι  reason: contains not printable characters */
                private void m107(Map<String, String> map2) {
                    if (weakReference.get() != null) {
                        AppsFlyerLibCore.m59((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map2).toString());
                    }
                }

                @Override // com.appsflyer.internal.ab.b
                /* renamed from: ı  reason: contains not printable characters */
                public final void mo108(String str2) {
                    if (AppsFlyerLibCore.f62 != null) {
                        m107(hashMap);
                        AFLogger.afDebugLog("Calling onAttributionFailure with:\n".concat(String.valueOf(str2)));
                        AppsFlyerLibCore.f62.onAttributionFailure(str2);
                    }
                }

                @Override // com.appsflyer.internal.ab.b
                /* renamed from: ɩ  reason: contains not printable characters */
                public final void mo109(Map<String, String> map2) {
                    for (String str2 : map2.keySet()) {
                        hashMap.put(str2, map2.get(str2));
                    }
                    m107(hashMap);
                    AppsFlyerLibCore.m78(hashMap);
                }
            };
            AFExecutor.getInstance().getThreadPoolExecutor().execute(abVar);
            return;
        }
        m78(AndroidUtils.m35(context, hashMap, uri));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, final Context context) {
        if (context != null) {
            this.f88 = (Application) context.getApplicationContext();
            if (GoogleReferrer.allow(this, context)) {
                if (this.f83 == null) {
                    this.f83 = new GoogleReferrer();
                    AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                    this.f83.start(context, new Runnable() { // from class: com.appsflyer.AppsFlyerLibCore.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                AFLogger.afDebugLog("Install Referrer collected locally");
                                AppsFlyerLibCore.m77(AppsFlyerLibCore.this);
                            } catch (Throwable th) {
                                AFLogger.afErrorLog(th.getMessage(), th);
                            }
                        }
                    });
                } else {
                    AFLogger.afWarnLog("GoogleReferrer instance already created");
                }
            }
            final SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (getLaunchCounter(sharedPreferences, false) < 2) {
                HuaweiReferrer huaweiReferrer = new HuaweiReferrer(new Runnable() { // from class: com.appsflyer.AppsFlyerLibCore.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (AppsFlyerLibCore.this.getLaunchCounter(sharedPreferences, false) == 1) {
                            if (!GoogleReferrer.allow(AppsFlyerLibCore.this, context) || sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false)) {
                                AppsFlyerLibCore.this.m43(new Attr().context(context));
                            }
                        }
                    }
                }, context);
                this.f92 = huaweiReferrer;
                huaweiReferrer.start();
            }
            this.f91 = m80(context);
        } else {
            AFLogger.afWarnLog("init :: context is null, Google Install Referrer will be not initialized!");
        }
        return init(str, appsFlyerConversionListener);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public boolean isPreInstalledApp(Context context) {
        try {
        } catch (PackageManager.NameNotFoundException e2) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e2);
        }
        return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public boolean isTrackingStopped() {
        return this.f80;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void onPause(Context context) {
        Foreground.Listener listener = Foreground.listener;
        if (listener != null) {
            listener.onBecameBackground(context);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void performOnAppAttribution(Context context, URI uri) {
        if (uri == null || uri.toString().isEmpty()) {
            AppsFlyerConversionListener appsFlyerConversionListener = f62;
            if (appsFlyerConversionListener != null) {
                StringBuilder sb = new StringBuilder("Link is \"");
                sb.append(uri);
                sb.append("\"");
                appsFlyerConversionListener.onAttributionFailure(sb.toString());
            }
        } else if (context == null) {
            AppsFlyerConversionListener appsFlyerConversionListener2 = f62;
            if (appsFlyerConversionListener2 != null) {
                StringBuilder sb2 = new StringBuilder("Context is \"");
                sb2.append(context);
                sb2.append("\"");
                appsFlyerConversionListener2.onAttributionFailure(sb2.toString());
            }
        } else {
            AFDeepLinkManager.getInstance();
            AFDeepLinkManager.m3(context, new HashMap(), Uri.parse(uri.toString()));
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            f62 = appsFlyerConversionListener;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            f60 = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void reportTrackSession(Context context) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "reportTrackSession", new String[0]);
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.f188 = false;
        AFEvent context2 = new InAppEvent().context(context);
        context2.f21 = null;
        context2.f17 = null;
        m101(context2);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void sendAdRevenue(Context context, Map<String, Object> map) {
        AFEvent context2 = new AdRevenue().context(context);
        context2.f17 = map;
        Context context3 = context2.context();
        String url = ServerConfigHandler.getUrl(f65);
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(context3.getPackageName());
        String obj = sb.toString();
        SharedPreferences sharedPreferences = getSharedPreferences(context3);
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        int m51 = m51(sharedPreferences, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", context2.f17);
        hashMap.put("adrevenue_counter", Integer.valueOf(m51));
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", string);
        hashMap.put("launch_counter", Integer.valueOf(launchCounter));
        hashMap.put("af_timestamp", Long.toString(new Date().getTime()));
        hashMap.put("uid", ae.m125(new WeakReference(context3)));
        String string2 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        hashMap.put("advertiserIdEnabled", AppsFlyerProperties.getInstance().getString("advertiserIdEnabled"));
        if (string2 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string2);
        }
        hashMap.put("device", Build.DEVICE);
        m60(context3, hashMap);
        try {
            PackageInfo packageInfo = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            long j2 = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("install_date", simpleDateFormat.format(new Date(j2)));
            String string3 = sharedPreferences.getString("appsFlyerFirstInstall", null);
            if (string3 == null) {
                string3 = m84(simpleDateFormat, context3);
            }
            hashMap.put("first_launch_date", string3);
        } catch (Throwable th) {
            AFLogger.afErrorLog("AdRevenue - Exception while collecting app version data ", th);
        }
        AFEvent m4 = context2.urlString(obj).params(hashMap).m4();
        m4.f11 = launchCounter;
        m68(AFExecutor.getInstance().m8(), new a(this, m4.key(string), (byte) 0), 1L, TimeUnit.MILLISECONDS);
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public void sendDeepLinkData(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai aiVar = ai.f183;
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            aiVar.m141("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), sb.toString());
        } else if (activity != null) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m141("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m141("public_api_call", "sendDeepLinkData", "activity_null");
        }
        try {
            startTracking(activity);
            StringBuilder sb2 = new StringBuilder("getDeepLinkData with activity ");
            sb2.append(activity.getIntent().getDataString());
            AFLogger.afInfoLog(sb2.toString());
        } catch (Exception e2) {
            AFLogger.afInfoLog("getDeepLinkData Exception: ".concat(String.valueOf(e2)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
    @Override // com.appsflyer.AppsFlyerLib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendPushNotificationData(android.app.Activity r17) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.sendPushNotificationData(android.app.Activity):void");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setAdditionalData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m141("public_api_call", "setAdditionalData", hashMap.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setAndroidIdData(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setAndroidIdData", str);
        this.f86 = str;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setAppId(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setAppId", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_ID, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setAppInviteOneLink(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_ID, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setCollectAndroidID(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setCollectIMEI(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setCollectOaid(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setCollectOaid", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setConsumeAFDeepLinks(boolean z) {
        AppsFlyerProperties.getInstance().set("consumeAfDeepLink", z);
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setConsumeAFDeepLinks: ".concat(String.valueOf(z)), new String[0]);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setCurrencyCode(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setCustomerIdAndTrack(String str, Context context) {
        if (context != null) {
            if (m89()) {
                setCustomerUserId(str);
                AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
                StringBuilder sb = new StringBuilder("CustomerUserId set: ");
                sb.append(str);
                sb.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                if (referrer == null) {
                    referrer = "";
                }
                m42(context, string, referrer, context instanceof Activity ? ((Activity) context).getIntent() : null);
                if (AppsFlyerProperties.getInstance().getString("afUninstallToken") != null) {
                    m103(context, AppsFlyerProperties.getInstance().getString("afUninstallToken"));
                    return;
                }
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setCustomerUserId(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setDebugLog(boolean z) {
        setLogLevel(z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
    }

    protected void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    StringBuilder sb = new StringBuilder("Unity setDeepLinkData = ");
                    sb.append(this.latestDeepLink);
                    AFLogger.afDebugLog(sb.toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while setting deeplink data (unity). ", th);
            }
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setDeviceTrackingDisabled(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setDeviceTrackingDisabled", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setExtension(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 != null && !str2.isEmpty()) {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        } else {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public void setHostName(String str) {
        AppsFlyerProperties.getInstance().set("custom_host", str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setImeiData(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setImeiData", str);
        this.f85 = str;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setIsUpdate(boolean z) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setLogLevel(AFLogger.LogLevel logLevel) {
        boolean z = logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel();
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setMinTimeBetweenSessions(int i2) {
        this.f81 = TimeUnit.SECONDS.toMillis(i2);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setOaidData(String str) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setOaidData", str);
        this.f78 = str;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setOneLinkCustomDomain(String... strArr) {
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", Arrays.toString(strArr)));
        AFDeepLinkManager.f0 = strArr;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.m22("Cannot set setOutOfStore with null");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setPhoneNumber(String str) {
        this.f93 = z.m207(str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setPluginDeepLinkData(Intent intent) {
        setDeepLinkData(intent);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put(Constants.URL_MEDIA_SOURCE, str);
            } catch (JSONException e2) {
                AFLogger.afErrorLog(e2.getMessage(), e2);
            }
        }
        if (str2 != null) {
            jSONObject.put(Constants.URL_CAMPAIGN, str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has(Constants.URL_MEDIA_SOURCE)) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", Arrays.toString(strArr)));
        AFDeepLinkManager.f1 = strArr;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[strArr.length + 1]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArr) {
            if (AnonymousClass10.f97[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(z.m207(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void startTracking(Context context) {
        startTracking(context, null);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void stopTracking(boolean z, Context context) {
        File[] listFiles;
        this.f80 = z;
        aa.m116();
        try {
            File m119 = aa.m119(context);
            if (!m119.exists()) {
                m119.mkdir();
            } else {
                for (File file : m119.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file.getName());
                    Log.i(LOG_TAG, sb.toString());
                    aa.m118(aa.m115(file).f265, context);
                }
            }
        } catch (Exception unused) {
            Log.i(LOG_TAG, "Could not cache request");
        }
        if (this.f80) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            edit.apply();
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public void trackAppLaunch(Context context, String str) {
        if (GoogleReferrer.allow(this, context)) {
            if (this.f83 == null) {
                this.f83 = new GoogleReferrer();
                AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                this.f83.start(context, new Runnable() { // from class: com.appsflyer.AppsFlyerLibCore.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            AFLogger.afDebugLog("Install Referrer collected locally");
                            AppsFlyerLibCore.m77(AppsFlyerLibCore.this);
                        } catch (Throwable th) {
                            AFLogger.afErrorLog(th.getMessage(), th);
                        }
                    }
                });
            } else {
                AFLogger.afWarnLog("GoogleReferrer instance already created");
            }
        }
        m42(context, str, "", null);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void trackEvent(Context context, String str, Map<String, Object> map, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        AFEvent context2 = new InAppEvent().context(context);
        context2.f21 = str;
        context2.f17 = map == null ? null : new HashMap(map);
        context2.f12 = appsFlyerTrackingRequestListener;
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        String[] strArr = new String[2];
        strArr[0] = str;
        Map map2 = context2.f17;
        if (map2 == null) {
            map2 = new HashMap();
        }
        strArr[1] = new JSONObject(map2).toString();
        aiVar.m141("public_api_call", "trackEvent", strArr);
        if (str != null) {
            AFSensorManager m27 = AFSensorManager.m27(context);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = m27.f47;
            if (j2 != 0) {
                m27.f42++;
                if (j2 - currentTimeMillis < 500) {
                    m27.f41.removeCallbacks(m27.f51);
                    m27.f41.post(m27.f46);
                }
            } else {
                m27.f41.post(m27.f50);
                m27.f41.post(m27.f46);
            }
            m27.f47 = currentTimeMillis;
        }
        m101(context2);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void trackLocation(Context context, double d2, double d3) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "trackLocation", String.valueOf(d2), String.valueOf(d3));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d3));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d2));
        AFEvent context2 = new InAppEvent().context(context);
        context2.f21 = AFInAppEventType.LOCATION_COORDINATES;
        context2.f17 = hashMap;
        m101(context2);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void unregisterConversionListener() {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "unregisterConversionListener", new String[0]);
        f62 = null;
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void updateServerUninstallToken(Context context, String str) {
        af.m126(context, str);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str3;
        strArr[3] = str4;
        strArr[4] = str5;
        strArr[5] = map == null ? "" : map.toString();
        aiVar.m141("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str3);
            sb.append(" ");
            sb.append(str4);
            sb.append(" ");
            sb.append(str5);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str != null && str4 != null && str2 != null && str5 != null && str3 != null) {
            new Thread(new x(context.getApplicationContext(), AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY), str, str2, str3, str4, str5, map, context instanceof Activity ? ((Activity) context).getIntent() : null)).start();
            return;
        }
        AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = f60;
        if (appsFlyerInAppPurchaseValidatorListener != null) {
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    /* renamed from: Ɩ  reason: contains not printable characters */
    private static boolean m49(Context context) {
        return (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !m90(context);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static void m67(Context context) {
        int i2;
        if (AndroidUtils.m33()) {
            i2 = 23;
            AFLogger.afRDLog("OPPO device found");
        } else {
            i2 = 18;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= i2 && !m91(AppsFlyerProperties.DISABLE_KEYSTORE)) {
            StringBuilder sb = new StringBuilder("OS SDK is=");
            sb.append(i3);
            sb.append("; use KeyStore");
            AFLogger.afRDLog(sb.toString());
            AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(context);
            if (!aFKeystoreWrapper.m13()) {
                aFKeystoreWrapper.f35 = ae.m125(new WeakReference(context));
                aFKeystoreWrapper.f33 = 0;
                aFKeystoreWrapper.m15(aFKeystoreWrapper.m14());
            } else {
                String m14 = aFKeystoreWrapper.m14();
                synchronized (aFKeystoreWrapper.f31) {
                    aFKeystoreWrapper.f33++;
                    AFLogger.afInfoLog("Deleting key with alias: ".concat(String.valueOf(m14)));
                    try {
                        synchronized (aFKeystoreWrapper.f31) {
                            aFKeystoreWrapper.f34.deleteEntry(m14);
                        }
                    } catch (KeyStoreException e2) {
                        StringBuilder sb2 = new StringBuilder("Exception ");
                        sb2.append(e2.getMessage());
                        sb2.append(" occurred");
                        AFLogger.afErrorLog(sb2.toString(), e2);
                    }
                }
                aFKeystoreWrapper.m15(aFKeystoreWrapper.m14());
            }
            AppsFlyerProperties.getInstance().set("KSAppsFlyerId", aFKeystoreWrapper.m12());
            AppsFlyerProperties.getInstance().set("KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper.m16()));
            return;
        }
        StringBuilder sb3 = new StringBuilder("OS SDK is=");
        sb3.append(i3);
        sb3.append("; no KeyStore usage");
        AFLogger.afRDLog(sb3.toString());
    }

    /* renamed from: ɹ  reason: contains not printable characters */
    private static File m71(String str) {
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    return new File(str.trim());
                }
                return null;
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: і  reason: contains not printable characters */
    public boolean m95() {
        Map<String, Object> map = this.f87;
        return (map == null || map.isEmpty()) ? false : true;
    }

    /* renamed from: Ӏ  reason: contains not printable characters */
    private static boolean m96(Context context) {
        return !getSharedPreferences(context).contains("appsFlyerCount");
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void startTracking(Context context, String str) {
        startTracking(context, str, null);
    }

    /* renamed from: і  reason: contains not printable characters */
    private static float m93(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            return (intExtra / intExtra2) * 100.0f;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return 1.0f;
        }
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void startTracking(Context context, final String str, final AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        if (!this.f79) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
            if (str == null) {
                return;
            }
        }
        if (Foreground.listener != null) {
            return;
        }
        this.f88 = (Application) context.getApplicationContext();
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "startTracking", str);
        String str2 = f61;
        AFLogger.afInfoLog(String.format("Starting AppsFlyer Tracking: (v%s.%s)", "5.4.0", str2));
        StringBuilder sb = new StringBuilder("Build Number: ");
        sb.append(str2);
        AFLogger.afInfoLog(sb.toString());
        AppsFlyerProperties.getInstance().loadProperties(this.f88.getApplicationContext());
        if (!TextUtils.isEmpty(str)) {
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
            ah.m133(str);
        } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY))) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
            return;
        }
        Context baseContext = this.f88.getBaseContext();
        try {
            if ((baseContext.getPackageManager().getPackageInfo(baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                    AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                } else {
                    AFLogger.m22("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                }
            }
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("checkBackupRules Exception: ");
            sb2.append(e2.toString());
            AFLogger.afRDLog(sb2.toString());
        }
        if (this.f89) {
            Context applicationContext = this.f88.getApplicationContext();
            this.f84 = new HashMap();
            final long currentTimeMillis = System.currentTimeMillis();
            final AFFacebookDeferredDeeplink.AppLinkFetchEvents appLinkFetchEvents = new AFFacebookDeferredDeeplink.AppLinkFetchEvents() { // from class: com.appsflyer.AppsFlyerLibCore.1
                @Override // com.appsflyer.AFFacebookDeferredDeeplink.AppLinkFetchEvents
                public final void onAppLinkFetchFailed(String str3) {
                    AppsFlyerLibCore.this.f84.put("error", str3);
                }

                @Override // com.appsflyer.AFFacebookDeferredDeeplink.AppLinkFetchEvents
                public final void onAppLinkFetchFinished(String str3, String str4, String str5) {
                    if (str3 != null) {
                        AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(str3));
                        AppsFlyerLibCore.this.f84.put("link", str3);
                        if (str4 != null) {
                            AppsFlyerLibCore.this.f84.put("target_url", str4);
                        }
                        if (str5 != null) {
                            HashMap hashMap = new HashMap();
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("promo_code", str5);
                            hashMap.put("deeplink_context", hashMap2);
                            AppsFlyerLibCore.this.f84.put("extras", hashMap);
                        }
                    } else {
                        AppsFlyerLibCore.this.f84.put("link", "");
                    }
                    AppsFlyerLibCore.this.f84.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            };
            try {
                Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", Context.class).invoke(null, applicationContext);
                final Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
                Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                Method method = cls.getMethod("fetchDeferredAppLinkData", Context.class, String.class, cls2);
                Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.appsflyer.AFFacebookDeferredDeeplink.5
                    @Override // java.lang.reflect.InvocationHandler
                    public final Object invoke(Object obj, Method method2, Object[] objArr) throws Throwable {
                        String str3;
                        String str4;
                        String str5;
                        Bundle bundle;
                        if (method2.getName().equals("onDeferredAppLinkDataFetched")) {
                            if (objArr[0] != null) {
                                Bundle bundle2 = (Bundle) Bundle.class.cast(cls.getMethod("getArgumentBundle", new Class[0]).invoke(cls.cast(objArr[0]), new Object[0]));
                                if (bundle2 != null) {
                                    str4 = bundle2.getString("com.facebook.platform.APPLINK_NATIVE_URL");
                                    str5 = bundle2.getString("target_url");
                                    Bundle bundle3 = bundle2.getBundle("extras");
                                    str3 = (bundle3 == null || (bundle = bundle3.getBundle("deeplink_context")) == null) ? null : bundle.getString("promo_code");
                                } else {
                                    str3 = null;
                                    str4 = null;
                                    str5 = null;
                                }
                                AppLinkFetchEvents appLinkFetchEvents2 = appLinkFetchEvents;
                                if (appLinkFetchEvents2 != null) {
                                    appLinkFetchEvents2.onAppLinkFetchFinished(str4, str5, str3);
                                }
                            } else {
                                AppLinkFetchEvents appLinkFetchEvents3 = appLinkFetchEvents;
                                if (appLinkFetchEvents3 != null) {
                                    appLinkFetchEvents3.onAppLinkFetchFinished(null, null, null);
                                }
                            }
                            return null;
                        }
                        AppLinkFetchEvents appLinkFetchEvents4 = appLinkFetchEvents;
                        if (appLinkFetchEvents4 != null) {
                            appLinkFetchEvents4.onAppLinkFetchFailed("onDeferredAppLinkDataFetched invocation failed");
                        }
                        return null;
                    }
                });
                String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", "string", applicationContext.getPackageName()));
                if (TextUtils.isEmpty(string)) {
                    appLinkFetchEvents.onAppLinkFetchFailed("Facebook app id not defined in resources");
                } else {
                    method.invoke(null, applicationContext, string, newProxyInstance);
                }
            } catch (ClassNotFoundException e3) {
                appLinkFetchEvents.onAppLinkFetchFailed(e3.toString());
            } catch (IllegalAccessException e4) {
                appLinkFetchEvents.onAppLinkFetchFailed(e4.toString());
            } catch (NoSuchMethodException e5) {
                appLinkFetchEvents.onAppLinkFetchFailed(e5.toString());
            } catch (InvocationTargetException e6) {
                appLinkFetchEvents.onAppLinkFetchFailed(e6.toString());
            }
        }
        Foreground.m112(context, new Foreground.Listener() { // from class: com.appsflyer.AppsFlyerLibCore.2
            @Override // com.appsflyer.Foreground.Listener
            public final void onBecameBackground(Context context2) {
                AFLogger.afInfoLog("onBecameBackground");
                AppsFlyerLibCore.this.f70 = System.currentTimeMillis();
                AFLogger.afInfoLog("callStatsBackground background call");
                AppsFlyerLibCore.this.m104(new WeakReference<>(context2));
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai aiVar = ai.f183;
                if (aiVar.m148()) {
                    aiVar.m147();
                    if (context2 != null) {
                        String packageName = context2.getPackageName();
                        PackageManager packageManager = context2.getPackageManager();
                        try {
                            if (ai.f183 == null) {
                                ai.f183 = new ai();
                            }
                            ai.f183.m146(packageName, packageManager);
                            if (ai.f183 == null) {
                                ai.f183 = new ai();
                            }
                            BackgroundEvent trackingStopped = new ProxyEvent().body(ai.f183.m145()).trackingStopped(AppsFlyerLib.getInstance().isTrackingStopped());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(ServerConfigHandler.getUrl("https://%smonitorsdk.%s/remote-debug?app_id="));
                            sb3.append(packageName);
                            new Thread(new ad((BackgroundEvent) trackingStopped.urlString(sb3.toString()))).start();
                        } catch (Throwable unused) {
                        }
                    }
                    aiVar.m143();
                } else {
                    AFLogger.afDebugLog("RD status is OFF");
                }
                AFExecutor aFExecutor = AFExecutor.getInstance();
                try {
                    AFExecutor.m7(aFExecutor.f26);
                    Executor executor = aFExecutor.f27;
                    if (executor instanceof ThreadPoolExecutor) {
                        AFExecutor.m7((ThreadPoolExecutor) executor);
                    }
                } catch (Throwable th) {
                    AFLogger.afErrorLog("failed to stop Executors", th);
                }
                AFSensorManager m27 = AFSensorManager.m27(context2);
                m27.f41.post(m27.f50);
            }

            @Override // com.appsflyer.Foreground.Listener
            public final void onBecameForeground(Activity activity) {
                if (AppsFlyerLibCore.this.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(activity), false) < 2) {
                    AFSensorManager m27 = AFSensorManager.m27(activity);
                    m27.f41.post(m27.f50);
                    m27.f41.post(m27.f46);
                }
                AFLogger.afInfoLog("onBecameForeground");
                AppsFlyerLibCore.this.f82 = System.currentTimeMillis();
                AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                AFEvent key = new Launch().context(activity).key(str);
                key.f12 = appsFlyerTrackingRequestListener;
                appsFlyerLibCore.m101(key);
                AFLogger.resetDeltaTime();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ı  reason: contains not printable characters */
    public static void m41(Context context, String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = getSharedPreferences(context).getString("extraReferrers", null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray2 = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
                jSONArray2 = jSONArray;
                jSONObject = jSONObject2;
            }
            if (jSONArray2.length() < 5) {
                jSONArray2.put(currentTimeMillis);
            }
            if (jSONObject.length() >= 4) {
                m62(jSONObject);
            }
            jSONObject.put(str, jSONArray2.toString());
            String jSONObject3 = jSONObject.toString();
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString("extraReferrers", jSONObject3);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m80(Context context) {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.f87 = new ConcurrentHashMap();
            final t.d dVar = new t.d() { // from class: com.appsflyer.AppsFlyerLibCore.4
                @Override // com.appsflyer.internal.t.d
                /* renamed from: ı  reason: contains not printable characters */
                public final void mo105(String str, String str2) {
                    AppsFlyerLibCore.this.f87.put("signedData", str);
                    AppsFlyerLibCore.this.f87.put("signature", str2);
                    AppsFlyerLibCore.this.f87.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }

                @Override // com.appsflyer.internal.t.d
                /* renamed from: ǃ  reason: contains not printable characters */
                public final void mo106(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AppsFlyerLibCore.this.f87.put("error", message);
                    AFLogger.afErrorLog(str, exc, true);
                }
            };
            try {
                try {
                    Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                    Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                    cls.getMethod("checkLicense", Long.TYPE, Context.class, cls2).invoke(null, Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.appsflyer.internal.t.3
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method.getName().equals("onLvlResult")) {
                                String str = objArr[0] != null ? (String) objArr[0] : null;
                                String str2 = objArr[1] != null ? (String) objArr[1] : null;
                                d dVar2 = dVar;
                                if (dVar2 == null) {
                                    AFLogger.afDebugLog("onLvlResult invocation succeeded, but listener is null");
                                } else if (str != null && str2 != null) {
                                    dVar2.mo105(str, str2);
                                } else if (str2 == null) {
                                    dVar2.mo106("onLvlResult with error", new Exception("AFLVL Invalid signature"));
                                } else {
                                    dVar2.mo106("onLvlResult with error", new Exception("AFLVL Invalid signedData"));
                                }
                            } else if (method.getName().equals("onLvlFailure")) {
                                d dVar3 = dVar;
                                if (dVar3 != null) {
                                    if (objArr[0] != null) {
                                        dVar3.mo106("onLvlFailure with exception", (Exception) objArr[0]);
                                    } else {
                                        dVar3.mo106("onLvlFailure", new Exception("unknown"));
                                    }
                                } else {
                                    AFLogger.afDebugLog("onLvlFailure: listener is null");
                                }
                            } else {
                                d dVar4 = dVar;
                                if (dVar4 != null) {
                                    dVar4.mo106("lvlInvocation failed", new Exception("com.appsflyer.lvl.AppsFlyerLVL$resultListener invocation failed"));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (NoSuchMethodException e2) {
                    dVar.mo106(e2.getClass().getSimpleName(), e2);
                } catch (InvocationTargetException e3) {
                    dVar.mo106(e3.getClass().getSimpleName(), e3);
                }
            } catch (ClassNotFoundException e4) {
                dVar.mo106(e4.getClass().getSimpleName(), e4);
            } catch (IllegalAccessException e5) {
                dVar.mo106(e5.getClass().getSimpleName(), e5);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ι  reason: contains not printable characters */
    public static void m85(Context context, String str, long j2) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(str, j2);
        edit.apply();
    }

    /* renamed from: ɹ  reason: contains not printable characters */
    private static boolean m73(Context context) {
        if (context != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network network : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                        if (networkCapabilities.hasTransport(4) && !networkCapabilities.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e2);
                }
            } else if (i2 >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e3);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ǃ  reason: contains not printable characters */
    public final void m100(Context context, Intent intent) {
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            getInstance();
            String stringExtra = intent.getStringExtra("appsflyer_preinstall");
            try {
                if (new JSONObject(stringExtra).has(Constants.URL_MEDIA_SOURCE)) {
                    AppsFlyerProperties.getInstance().set("preInstallName", stringExtra);
                } else {
                    AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e2) {
                AFLogger.afErrorLog("Error parsing JSON for preinstall", e2);
            }
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String stringExtra2 = intent.getStringExtra(Payload.REFERRER);
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString(Payload.REFERRER, stringExtra2);
            edit.apply();
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                AFEvent weakContext = new BackgroundReferrerLaunch().context(context).m4().weakContext();
                weakContext.f8 = stringExtra2;
                weakContext.f9 = intent;
                if (stringExtra2.length() <= 5 || !m48(weakContext, getSharedPreferences(context))) {
                    return;
                }
                m68(AFExecutor.getInstance().m8(), new e(this, weakContext, (byte) 0), 5L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static boolean m91(String str) {
        return AppsFlyerProperties.getInstance().getBoolean(str, false);
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static boolean m89() {
        return m91(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null;
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static boolean m90(Context context) {
        try {
            if (com.google.android.gms.common.e.o().g(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e2);
            return false;
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static String m84(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = getSharedPreferences(context).getString("appsFlyerFirstInstall", null);
        if (string == null) {
            if (m96(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString("appsFlyerFirstInstall", string);
            edit.apply();
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    @Override // com.appsflyer.AppsFlyerLib
    @Deprecated
    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        aiVar.m141("public_api_call", "init", strArr);
        AFLogger.m19(String.format("Initializing AppsFlyer SDK: (v%s.%s)", "5.4.0", f61));
        this.f79 = true;
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        ah.m133(str);
        f62 = appsFlyerConversionListener;
        return this;
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private void m76(AFEvent aFEvent) {
        aFEvent.m4();
        boolean z = aFEvent.f21 == null;
        if (m89()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        if (z) {
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                if (m79()) {
                    return;
                }
            } else {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            }
            this.f74 = System.currentTimeMillis();
        }
        m68(AFExecutor.getInstance().m8(), new e(this, aFEvent.weakContext(), (byte) 0), 150L, TimeUnit.MILLISECONDS);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void setUserEmails(String... strArr) {
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    @Override // com.appsflyer.AppsFlyerLib
    public void trackEvent(Context context, String str, Map<String, Object> map) {
        trackEvent(context, str, map, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ı  reason: contains not printable characters */
    public static Map<String, Object> m39(Context context) throws y {
        String string = getSharedPreferences(context).getString("attributionId", null);
        if (string != null && string.length() > 0) {
            return m66(string);
        }
        throw new y();
    }

    /* renamed from: ι  reason: contains not printable characters */
    private static void m86(Context context, Map<String, ? super String> map) {
        s sVar = s.d.f295;
        s.a m192 = s.m192(context);
        map.put("network", m192.f292);
        String str = m192.f294;
        if (str != null) {
            map.put("operator", str);
        }
        String str2 = m192.f293;
        if (str2 != null) {
            map.put("carrier", str2);
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    final void m104(WeakReference<Context> weakReference) {
        if (weakReference.get() == null) {
            return;
        }
        AFLogger.afInfoLog("app went to background");
        SharedPreferences sharedPreferences = getSharedPreferences(weakReference.get());
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        long j2 = this.f70 - this.f82;
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        w m198 = v.m198(weakReference.get().getContentResolver());
        if (m198 != null) {
            hashMap.put("amazon_aid", m198.f303);
            hashMap.put("amazon_aid_limit", String.valueOf(m198.m200()));
        }
        String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string3 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
        }
        hashMap.put("app_id", weakReference.get().getPackageName());
        hashMap.put("devkey", string);
        hashMap.put("uid", ae.m125(weakReference));
        hashMap.put("time_in_app", String.valueOf(j2 / 1000));
        hashMap.put("statType", "user_closed_app");
        hashMap.put("platform", "Android");
        hashMap.put("launch_counter", Integer.toString(getLaunchCounter(sharedPreferences, false)));
        hashMap.put(AppsFlyerProperties.CHANNEL, getConfiguredChannel(weakReference.get()));
        if (string2 == null) {
            string2 = "";
        }
        hashMap.put("originalAppsflyerId", string2);
        if (this.f76) {
            try {
                AFLogger.afDebugLog("Running callStats task");
                new Thread(new ad((BackgroundEvent) new Stats().trackingStopped(isTrackingStopped()).params(hashMap).urlString(ServerConfigHandler.getUrl("https://%sstats.%s/stats")))).start();
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("Could not send callStats request", th);
                return;
            }
        }
        AFLogger.afDebugLog("Stats call is disabled, ignore ...");
    }

    /* renamed from: ı  reason: contains not printable characters */
    private void m42(Context context, String str, String str2, Intent intent) {
        AFEvent context2 = new Launch().context(context);
        context2.f21 = null;
        AFEvent key = context2.key(str);
        key.f17 = null;
        key.f8 = str2;
        key.f9 = intent;
        key.f19 = null;
        m76(key);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean m79() {
        if (this.f74 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f74;
            Locale locale = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", locale);
            long j2 = this.f74;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(j2));
            long j3 = this.f68;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format2 = simpleDateFormat.format(new Date(j3));
            if (currentTimeMillis < this.f81 && !isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.f81)));
                return true;
            } else if (!isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(locale, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", format, format2, Long.valueOf(currentTimeMillis)));
            }
        } else if (!isTrackingStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* renamed from: ι  reason: contains not printable characters */
    private void m87(AFEvent aFEvent) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        URL url = new URL(aFEvent.f20);
        byte[] m6 = aFEvent.m6();
        String key = aFEvent.key();
        String str = aFEvent.f14;
        boolean m5 = aFEvent.m5();
        Context context = aFEvent.context();
        AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener = aFEvent.f12;
        boolean z = m5 && f62 != null;
        try {
            httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        } catch (Throwable th) {
            th = th;
            httpURLConnection = null;
        }
        try {
            httpURLConnection2.setRequestMethod(HttpPost.METHOD_NAME);
            httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(m6.length));
            httpURLConnection2.setRequestProperty("Content-Type", aFEvent.isEncrypt() ? "application/octet-stream" : "application/json");
            httpURLConnection2.setConnectTimeout(10000);
            httpURLConnection2.setDoOutput(true);
            try {
                dataOutputStream2 = new DataOutputStream(httpURLConnection2.getOutputStream());
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = null;
            }
            try {
                dataOutputStream2.write(m6);
                dataOutputStream2.close();
                int responseCode = httpURLConnection2.getResponseCode();
                String m99 = m99(httpURLConnection2);
                if (ai.f183 == null) {
                    ai.f183 = new ai();
                }
                ai.f183.m141("server_response", url.toString(), String.valueOf(responseCode), m99);
                AFLogger.afInfoLog("response code: ".concat(String.valueOf(responseCode)));
                SharedPreferences sharedPreferences = getSharedPreferences(context);
                if (responseCode == 200) {
                    if (context != null && m5) {
                        this.f68 = System.currentTimeMillis();
                    }
                    if (appsFlyerTrackingRequestListener != null) {
                        appsFlyerTrackingRequestListener.onTrackingRequestSuccess();
                    }
                    if (str != null) {
                        aa.m116();
                        aa.m118(str, context);
                    } else {
                        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
                        edit.putString("sentSuccessfully", "true");
                        edit.apply();
                        if (!this.f90 && System.currentTimeMillis() - this.f94 >= 15000 && this.f69 == null) {
                            this.f69 = AFExecutor.getInstance().m8();
                            m68(this.f69, new c(context), 1L, TimeUnit.SECONDS);
                        }
                    }
                    String string = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                    if (string != null) {
                        AFLogger.afDebugLog("Uninstall Token exists: ".concat(string));
                        if (!sharedPreferences.getBoolean("sentRegisterRequestToAF", false)) {
                            AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(string));
                            af.m126(context, string);
                        }
                    }
                    if (this.latestDeepLink != null) {
                        this.latestDeepLink = null;
                    }
                    this.f76 = ServerConfigHandler.m114(m99).optBoolean("send_background", false);
                } else if (appsFlyerTrackingRequestListener != null) {
                    appsFlyerTrackingRequestListener.onTrackingRequestFailure("Failure: ".concat(String.valueOf(responseCode)));
                }
                long j2 = sharedPreferences.getLong("appsflyerConversionDataCacheExpiration", 0L);
                if (j2 != 0 && System.currentTimeMillis() - j2 > 5184000000L) {
                    SharedPreferences.Editor edit2 = getSharedPreferences(context).edit();
                    edit2.putBoolean("sixtyDayConversionData", true);
                    edit2.apply();
                    SharedPreferences.Editor edit3 = getSharedPreferences(context).edit();
                    edit3.putString("attributionId", null);
                    edit3.apply();
                    m85(context, "appsflyerConversionDataCacheExpiration", 0L);
                }
                if (sharedPreferences.getString("attributionId", null) == null && key != null && z) {
                    b bVar = new b(this, (Application) context.getApplicationContext(), key, (byte) 0);
                    m68(bVar.f118, bVar, 10L, TimeUnit.MILLISECONDS);
                } else if (key == null) {
                    AFLogger.afWarnLog("AppsFlyer dev key is missing.");
                } else if (z && sharedPreferences.getString("attributionId", null) != null && getLaunchCounter(sharedPreferences, false) > 1) {
                    try {
                        Map<String, Object> m39 = m39(context);
                        if (m39 != null) {
                            try {
                                if (!m39.containsKey("is_first_launch")) {
                                    m39.put("is_first_launch", Boolean.FALSE);
                                }
                                StringBuilder sb = new StringBuilder("Calling onConversionDataSuccess with:\n");
                                sb.append(m39.toString());
                                AFLogger.afDebugLog(sb.toString());
                                f62.onConversionDataSuccess(m39);
                            } catch (Throwable th3) {
                                AFLogger.afErrorLog(th3.getLocalizedMessage(), th3);
                            }
                        }
                    } catch (y e2) {
                        AFLogger.afErrorLog(e2.getMessage(), e2);
                    }
                }
                httpURLConnection2.disconnect();
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = dataOutputStream2;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                } else if (appsFlyerTrackingRequestListener != null) {
                    appsFlyerTrackingRequestListener.onTrackingRequestFailure("No Connectivity");
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = httpURLConnection2;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static void m62(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2: while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i3 = 0;
                    while (i3 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i3) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i3) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i3) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i3++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException unused2) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x016e, code lost:
        if (m95() == false) goto L72;
     */
    /* renamed from: ı  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m43(com.appsflyer.AFEvent r10) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m43(com.appsflyer.AFEvent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ι  reason: contains not printable characters */
    public static void m78(Map<String, String> map) {
        if (f62 != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                f62.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: Ι  reason: contains not printable characters */
    static /* synthetic */ void m77(AppsFlyerLibCore appsFlyerLibCore) {
        AFEvent context = new Attr().context(appsFlyerLibCore.f88);
        if (appsFlyerLibCore.m69() && appsFlyerLibCore.m48(context, getSharedPreferences(appsFlyerLibCore.f88))) {
            appsFlyerLibCore.m43(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* renamed from: ǃ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void m101(com.appsflyer.AFEvent r7) {
        /*
            r6 = this;
            android.content.Context r0 = r7.context()
            boolean r1 = r0 instanceof android.app.Activity
            java.lang.String r2 = ""
            if (r1 == 0) goto L1c
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            android.content.Intent r3 = r1.getIntent()
            android.net.Uri r1 = com.appsflyer.internal.ActivityCompat.getReferrer(r1)
            if (r1 == 0) goto L1d
            java.lang.String r1 = r1.toString()
            goto L1e
        L1c:
            r3 = 0
        L1d:
            r1 = r2
        L1e:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "AppsFlyerKey"
            java.lang.String r4 = r4.getString(r5)
            if (r4 != 0) goto L30
            java.lang.String r7 = "[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r7)
            return
        L30:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r4.getReferrer(r0)
            if (r0 != 0) goto L3b
            goto L3c
        L3b:
            r2 = r0
        L3c:
            r7.f8 = r2
            r7.f9 = r3
            r7.f19 = r1
            r6.m76(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m101(com.appsflyer.AFEvent):void");
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final void m103(Context context, String str) {
        if (m89()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            hashMap.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j2 = packageInfo.firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("installDate", simpleDateFormat.format(new Date(j2)));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        m86(context, hashMap);
        String string2 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string2 != null) {
            hashMap.put("appUserId", string2);
        }
        try {
            hashMap.put("model", Build.MODEL);
            hashMap.put("brand", Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        w m198 = v.m198(context.getContentResolver());
        if (m198 != null) {
            hashMap.put("amazon_aid", m198.f303);
            hashMap.put("amazon_aid_limit", String.valueOf(m198.m200()));
        }
        String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string3 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
        }
        hashMap.put("devkey", string);
        hashMap.put("uid", ae.m125(new WeakReference(context)));
        hashMap.put("af_gcm_token", str);
        hashMap.put("launch_counter", Integer.toString(getLaunchCounter(getSharedPreferences(context), false)));
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String configuredChannel = getConfiguredChannel(context);
        if (configuredChannel != null) {
            hashMap.put(AppsFlyerProperties.CHANNEL, configuredChannel);
        }
        try {
            AFEvent context2 = new UninstallTokenEvent().trackingStopped(isTrackingStopped()).params(hashMap).context(context);
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(REGISTER_URL));
            sb.append(packageName);
            new Thread(new ad((BackgroundEvent) context2.urlString(sb.toString()))).start();
        } catch (Throwable th3) {
            AFLogger.afErrorLog(th3.getMessage(), th3);
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static void m60(Context context, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : "l" : "p");
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static String m54(File file, String str) {
        FileReader fileReader;
        try {
            try {
                try {
                    Properties properties = new Properties();
                    fileReader = new FileReader(file);
                    try {
                        properties.load(fileReader);
                        AFLogger.afInfoLog("Found PreInstall property!");
                        String property = properties.getProperty(str);
                        try {
                            fileReader.close();
                        } catch (Throwable th) {
                            AFLogger.afErrorLog(th.getMessage(), th);
                        }
                        return property;
                    } catch (FileNotFoundException unused) {
                        StringBuilder sb = new StringBuilder("PreInstall file wasn't found: ");
                        sb.append(file.getAbsolutePath());
                        AFLogger.afDebugLog(sb.toString());
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        AFLogger.afErrorLog(th.getMessage(), th);
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException unused2) {
                    fileReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileReader = null;
                }
            } catch (Throwable th4) {
                AFLogger.afErrorLog(th4.getMessage(), th4);
                return null;
            }
        } catch (Throwable th5) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable th6) {
                    AFLogger.afErrorLog(th6.getMessage(), th6);
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ǃ  reason: contains not printable characters */
    public static String m53(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", null);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString("CACHED_CHANNEL", str);
        edit.apply();
        return str;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static int m51(SharedPreferences sharedPreferences, String str, boolean z) {
        int i2 = sharedPreferences.getInt(str, 0);
        if (z) {
            i2++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i2);
            edit.apply();
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        if (ai.f183.m148()) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m144(String.valueOf(i2));
        }
        return i2;
    }

    /* renamed from: ı  reason: contains not printable characters */
    private boolean m48(AFEvent aFEvent, SharedPreferences sharedPreferences) {
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        return (!sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false) && launchCounter == 1) || (launchCounter == 1 && !(aFEvent instanceof Attr));
    }

    /* renamed from: ı  reason: contains not printable characters */
    private boolean m46() {
        Map<String, Object> map = this.f84;
        return (map == null || map.isEmpty()) ? false : true;
    }

    /* renamed from: ı  reason: contains not printable characters */
    public static boolean m47(SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", null));
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static String m38(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r3 != null) goto L16;
     */
    /* renamed from: ǃ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m99(java.net.HttpURLConnection r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r8.getErrorStream()     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L10
            java.io.InputStream r2 = r8.getInputStream()     // Catch: java.lang.Throwable -> L37
        L10:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L37
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L37
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L35
        L1a:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L29
            r0.append(r1)     // Catch: java.lang.Throwable -> L30
            r1 = 10
            r0.append(r1)     // Catch: java.lang.Throwable -> L30
            goto L1a
        L29:
            r2.close()     // Catch: java.lang.Throwable -> L5a
        L2c:
            r3.close()     // Catch: java.lang.Throwable -> L5a
            goto L5a
        L30:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L39
        L35:
            r2 = move-exception
            goto L39
        L37:
            r2 = move-exception
            r3 = r1
        L39:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7d
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L7d
            java.net.URL r8 = r8.getURL()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L7d
            r4.append(r8)     // Catch: java.lang.Throwable -> L7d
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L7d
            com.appsflyer.AFLogger.afErrorLog(r8, r2)     // Catch: java.lang.Throwable -> L7d
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Throwable -> L5a
        L57:
            if (r3 == 0) goto L5a
            goto L2c
        L5a:
            java.lang.String r8 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L64
            r0.<init>(r8)     // Catch: org.json.JSONException -> L64
            return r8
        L64:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r8)     // Catch: org.json.JSONException -> L73
            java.lang.String r8 = r0.toString()     // Catch: org.json.JSONException -> L73
            return r8
        L73:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r8 = r8.toString()
            return r8
        L7d:
            r8 = move-exception
            if (r1 == 0) goto L83
            r1.close()     // Catch: java.lang.Throwable -> L88
        L83:
            if (r3 == 0) goto L88
            r3.close()     // Catch: java.lang.Throwable -> L88
        L88:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m99(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: ı  reason: contains not printable characters */
    static /* synthetic */ void m44(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent) throws IOException {
        String jSONObject;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(aFEvent.urlString());
        AFLogger.afInfoLog(sb.toString());
        if (aFEvent.f14 != null) {
            jSONObject = Base64.encodeToString(aFEvent.m6(), 2);
            AFLogger.afInfoLog("cached data: ".concat(String.valueOf(jSONObject)));
        } else {
            jSONObject = new JSONObject(aFEvent.params()).toString();
            ah.m134("data: ".concat(String.valueOf(jSONObject)));
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141("server_request", aFEvent.urlString(), jSONObject);
        try {
            appsFlyerLibCore.m87(aFEvent);
        } catch (IOException e2) {
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", e2);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLibCore.m87(aFEvent.urlString(aFEvent.urlString().replace("https:", "http:")));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send requeset to server. ");
            sb2.append(e2.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static Map<String, Object> m66(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!f67.contains(next)) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e2) {
            AFLogger.afErrorLog(e2.getMessage(), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public boolean m69() {
        GoogleReferrer googleReferrer = this.f83;
        return googleReferrer != null && googleReferrer.oldMap.size() > 0;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:385:0x0804
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* renamed from: ɩ  reason: contains not printable characters */
    public final java.util.Map<java.lang.String, java.lang.Object> m102(com.appsflyer.AFEvent r32) {
        /*
            Method dump skipped, instructions count: 2973
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m102(com.appsflyer.AFEvent):java.util.Map");
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    static /* synthetic */ void m59(Context context, String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    static /* synthetic */ String m55(String str) {
        return AppsFlyerProperties.getInstance().getString(str);
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static String m64(String str, PackageManager packageManager, String str2) {
        Object obj;
        try {
            Bundle bundle = ((PackageItemInfo) packageManager.getApplicationInfo(str2, 128)).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (!obj2.replaceAll("\\p{C}", "").equals(obj2)) {
                StringBuilder sb = new StringBuilder("Manifest meta-data ");
                sb.append(str);
                sb.append(": ");
                sb.append(obj2);
                sb.append(" contains non-printing characters");
                AFLogger.afWarnLog(sb.toString());
            }
            return obj2;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Could not find ");
            sb2.append(str);
            sb2.append(" value in the manifest");
            AFLogger.afErrorLog(sb2.toString(), th);
            return null;
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static boolean m70(File file) {
        return file == null || !file.exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ɩ  reason: contains not printable characters */
    public static void m68(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j2, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j2, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e2) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e2);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }
}