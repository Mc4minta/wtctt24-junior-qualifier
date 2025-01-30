package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.internal.measurement.rc;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class v9 extends w5 {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f7912c = {"firebase_", "google_", "ga_"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f7913d = {"_err"};

    /* renamed from: e  reason: collision with root package name */
    private SecureRandom f7914e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicLong f7915f;

    /* renamed from: g  reason: collision with root package name */
    private int f7916g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f7917h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v9(b5 b5Var) {
        super(b5Var);
        this.f7917h = null;
        this.f7915f = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long A(byte[] bArr) {
        com.google.android.gms.common.internal.t.k(bArr);
        int i2 = 0;
        com.google.android.gms.common.internal.t.n(bArr.length > 0);
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j2 += (bArr[length] & 255) << i2;
            i2 += 8;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean B0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static Bundle E(List<q9> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (q9 q9Var : list) {
            String str = q9Var.f7827f;
            if (str != null) {
                bundle.putString(q9Var.f7823b, str);
            } else {
                Long l2 = q9Var.f7825d;
                if (l2 != null) {
                    bundle.putLong(q9Var.f7823b, l2.longValue());
                } else {
                    Double d2 = q9Var.f7829h;
                    if (d2 != null) {
                        bundle.putDouble(q9Var.f7823b, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static boolean E0(String str) {
        for (String str2 : f7913d) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private final int F0(String str) {
        if (f0("event param", str)) {
            if (k0("event param", null, str)) {
                return !e0("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    private final Object G(int i2, Object obj, boolean z, boolean z2) {
        Parcelable[] parcelableArr;
        Bundle C;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.K0) && o().u(r.J0) && z2 && ((obj instanceof Bundle[]) || (obj instanceof Parcelable[]))) {
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if ((parcelable instanceof Bundle) && (C = C((Bundle) parcelable)) != null && !C.isEmpty()) {
                            arrayList.add(C);
                        }
                    }
                    return arrayList.toArray(new Bundle[arrayList.size()]);
                }
                return null;
            }
            return I(String.valueOf(obj), i2, z);
        }
    }

    private final int H0(String str) {
        if (t0("event param", str)) {
            if (k0("event param", null, str)) {
                return !e0("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    public static String I(String str, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i2) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
            }
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest I0() {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    private static boolean K0(String str) {
        com.google.android.gms.common.internal.t.k(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static void L(Bundle bundle, int i2, String str, String str2, Object obj) {
        if (s0(bundle, i2)) {
            bundle.putString("_ev", I(str, 40, true));
            if (obj != null) {
                com.google.android.gms.common.internal.t.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    private final int L0(String str) {
        if ("_ldl".equals(str)) {
            return PKIFailureInfo.wrongIntegrity;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return (o().u(r.o0) && "_lgclid".equals(str)) ? 100 : 36;
    }

    private final void W(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int F0;
        String str4;
        int w;
        String sb;
        if (bundle == null) {
            return;
        }
        boolean u = o().u(r.L0);
        int B = u ? 0 : o().B();
        int i2 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                F0 = z ? F0(str5) : 0;
                if (F0 == 0) {
                    F0 = H0(str5);
                }
            } else {
                F0 = 0;
            }
            if (F0 != 0) {
                L(bundle, F0, str5, str5, F0 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (b0(bundle.get(str5))) {
                    f().M().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    w = 22;
                    str4 = str5;
                } else {
                    str4 = str5;
                    w = w(str, str2, str5, bundle.get(str5), bundle, list, z, false);
                }
                if (w != 0 && !"_ev".equals(str4)) {
                    L(bundle, w, str4, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (c0(str4) && (!u || !j0(str4, a6.f7488d))) {
                    int i3 = i2 + 1;
                    if (i3 > B) {
                        if (u) {
                            sb = "Item cannot contain custom parameters";
                        } else {
                            StringBuilder sb2 = new StringBuilder(63);
                            sb2.append("Child bundles can't contain more than ");
                            sb2.append(B);
                            sb2.append(" custom params");
                            sb = sb2.toString();
                        }
                        f().J().c(sb, j().x(str2), j().v(bundle));
                        s0(bundle, u ? 23 : 5);
                        bundle.remove(str4);
                    }
                    i2 = i3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean X(Context context, boolean z) {
        com.google.android.gms.common.internal.t.k(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return r0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return r0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Y(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Z(Bundle bundle, int i2) {
        int i3 = 0;
        if (bundle.size() <= i2) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i3++;
            if (i3 > i2) {
                bundle.remove(str);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a0(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c0(String str) {
        com.google.android.gms.common.internal.t.g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        } else if (TextUtils.isEmpty(str4)) {
            return false;
        } else {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    private static boolean j0(String str, String[] strArr) {
        com.google.android.gms.common.internal.t.k(strArr);
        for (String str2 : strArr) {
            if (z0(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l0(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] m0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static Bundle p0(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static ArrayList<Bundle> q0(List<ia> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (ia iaVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", iaVar.a);
            bundle.putString("origin", iaVar.f7653b);
            bundle.putLong("creation_timestamp", iaVar.f7655d);
            bundle.putString(ApiConstants.NAME, iaVar.f7654c.f7823b);
            y5.b(bundle, iaVar.f7654c.i1());
            bundle.putBoolean(AppStateModule.APP_STATE_ACTIVE, iaVar.f7656e);
            String str = iaVar.f7657f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            p pVar = iaVar.f7658g;
            if (pVar != null) {
                bundle.putString("timed_out_event_name", pVar.a);
                o oVar = iaVar.f7658g.f7790b;
                if (oVar != null) {
                    bundle.putBundle("timed_out_event_params", oVar.l1());
                }
            }
            bundle.putLong("trigger_timeout", iaVar.f7659h);
            p pVar2 = iaVar.f7660j;
            if (pVar2 != null) {
                bundle.putString("triggered_event_name", pVar2.a);
                o oVar2 = iaVar.f7660j.f7790b;
                if (oVar2 != null) {
                    bundle.putBundle("triggered_event_params", oVar2.l1());
                }
            }
            bundle.putLong("triggered_timestamp", iaVar.f7654c.f7824c);
            bundle.putLong("time_to_live", iaVar.f7661k);
            p pVar3 = iaVar.f7662l;
            if (pVar3 != null) {
                bundle.putString("expired_event_name", pVar3.a);
                o oVar3 = iaVar.f7662l.f7790b;
                if (oVar3 != null) {
                    bundle.putBundle("expired_event_params", oVar3.l1());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static boolean r0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s0(Bundle bundle, int i2) {
        if (bundle != null && bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i2);
            return true;
        }
        return false;
    }

    private final boolean u0(String str, String str2, int i2, Object obj) {
        int size;
        if (obj instanceof Parcelable[]) {
            size = ((Parcelable[]) obj).length;
        } else {
            if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            return true;
        }
        if (size > i2) {
            f().M().d("Parameter array is too long; discarded. Value kind, name, array length", str, str2, Integer.valueOf(size));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] v0(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int w(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21, android.os.Bundle r22, java.util.List<java.lang.String> r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.v9.w(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public static long x(long j2, long j3) {
        return (j2 + (j3 * 60000)) / 86400000;
    }

    private final boolean y0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e2 = com.google.android.gms.common.n.c.a(context).e(str, 64);
            if (e2 == null || (signatureArr = e2.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e3) {
            f().H().b("Package name not found", e3);
            return true;
        } catch (CertificateException e4) {
            f().H().b("Error obtaining certificate", e4);
            return true;
        }
    }

    public static long z(o oVar) {
        long j2 = 0;
        if (oVar == null) {
            return 0L;
        }
        Iterator<String> it = oVar.iterator();
        while (it.hasNext()) {
            Object k1 = oVar.k1(it.next());
            if (k1 instanceof Parcelable[]) {
                j2 += ((Parcelable[]) k1).length;
            }
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean z0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean A0(String str) {
        d();
        if (com.google.android.gms.common.n.c.a(h()).a(str) == 0) {
            return true;
        }
        f().O().b("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle B(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(Payload.SOURCE, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            f().K().b("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle C(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object H = H(str, bundle.get(str));
                if (H == null) {
                    f().M().b("Param value can't be null", j().A(str));
                } else {
                    N(bundle2, str, H);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean C0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String P = o().P();
        g();
        return P.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle D(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        Set<String> keySet;
        int F0;
        int i2;
        Bundle bundle2;
        v9 v9Var = this;
        List<String> list2 = list;
        boolean z3 = com.google.android.gms.internal.measurement.t8.b() && o().u(r.L0);
        boolean j0 = z3 ? j0(str2, b6.f7515c) : z2;
        if (bundle != null) {
            Bundle bundle3 = new Bundle(bundle);
            int B = o().B();
            if (o().D(str, r.d0)) {
                keySet = new TreeSet<>(bundle.keySet());
            } else {
                keySet = bundle.keySet();
            }
            int i3 = 0;
            for (String str3 : keySet) {
                if (list2 == null || !list2.contains(str3)) {
                    F0 = z ? v9Var.F0(str3) : 0;
                    if (F0 == 0) {
                        F0 = v9Var.H0(str3);
                    }
                } else {
                    F0 = 0;
                }
                if (F0 != 0) {
                    L(bundle3, F0, str3, str3, F0 == 3 ? str3 : null);
                    bundle3.remove(str3);
                    i2 = B;
                    bundle2 = bundle3;
                } else {
                    i2 = B;
                    bundle2 = bundle3;
                    int w = w(str, str2, str3, bundle.get(str3), bundle3, list, z, j0);
                    if (z3 && w == 17) {
                        L(bundle2, w, str3, str3, Boolean.FALSE);
                    } else if (w != 0 && !"_ev".equals(str3)) {
                        L(bundle2, w, w == 21 ? str2 : str3, str3, bundle.get(str3));
                        bundle2.remove(str3);
                    }
                    if (c0(str3)) {
                        int i4 = i3 + 1;
                        if (i4 > i2) {
                            StringBuilder sb = new StringBuilder(48);
                            sb.append("Event can't contain more than ");
                            sb.append(i2);
                            sb.append(" params");
                            f().J().c(sb.toString(), j().x(str2), j().v(bundle));
                            s0(bundle2, 5);
                            bundle2.remove(str3);
                            i3 = i4;
                            B = i2;
                            bundle3 = bundle2;
                            v9Var = this;
                            list2 = list;
                        } else {
                            i3 = i4;
                        }
                    }
                }
                B = i2;
                bundle3 = bundle2;
                v9Var = this;
                list2 = list;
            }
            return bundle3;
        }
        return null;
    }

    public final long D0() {
        long andIncrement;
        long j2;
        if (this.f7915f.get() == 0) {
            synchronized (this.f7915f) {
                long nextLong = new Random(System.nanoTime() ^ i().a()).nextLong();
                int i2 = this.f7916g + 1;
                this.f7916g = i2;
                j2 = nextLong + i2;
            }
            return j2;
        }
        synchronized (this.f7915f) {
            this.f7915f.compareAndSet(-1L, 1L);
            andIncrement = this.f7915f.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final p F(String str, String str2, Bundle bundle, String str3, long j2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (n0(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            return new p(str2, new o(C(D(str, str2, bundle2, com.google.android.gms.common.util.f.b("_o"), false, false))), str3, j2);
        }
        f().H().b("Invalid conditional property event name", j().B(str2));
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecureRandom G0() {
        d();
        if (this.f7914e == null) {
            this.f7914e = new SecureRandom();
        }
        return this.f7914e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object H(String str, Object obj) {
        if ("_ev".equals(str)) {
            return G(256, obj, true, true);
        }
        return G(B0(str) ? 256 : 100, obj, false, true);
    }

    public final URL J(long j2, String str, String str2, long j3) {
        try {
            com.google.android.gms.common.internal.t.g(str2);
            com.google.android.gms.common.internal.t.g(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j2), Integer.valueOf(J0())), str2, str, Long.valueOf(j3));
            if (str.equals(o().Q())) {
                format = format.concat("&ddl_test=1");
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e2) {
            f().H().b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    public final int J0() {
        if (this.f7917h == null) {
            this.f7917h = Integer.valueOf(com.google.android.gms.common.f.f().a(h()) / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
        }
        return this.f7917h.intValue();
    }

    public final void K(int i2, String str, String str2, int i3) {
        V(null, i2, str, str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M(Bundle bundle, long j2) {
        long j3 = bundle.getLong("_et");
        if (j3 != 0) {
            f().K().b("Params already contained engagement", Long.valueOf(j3));
        }
        bundle.putLong("_et", j2 + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String M0() {
        byte[] bArr = new byte[16];
        G0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void N(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (com.google.android.gms.internal.measurement.t8.b() && o().u(r.K0) && o().u(r.J0) && (obj instanceof Bundle[])) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            f().M().c("Not putting event parameter. Invalid value type. name, type", j().A(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final boolean N0() {
        try {
            h().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void O(rc rcVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning int value to wrapper", e2);
        }
    }

    public final void P(rc rcVar, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j2);
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning long value to wrapper", e2);
        }
    }

    public final void Q(rc rcVar, Bundle bundle) {
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning bundle value to wrapper", e2);
        }
    }

    public final void R(rc rcVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning string value to wrapper", e2);
        }
    }

    public final void S(rc rcVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning bundle list to wrapper", e2);
        }
    }

    public final void T(rc rcVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning boolean value to wrapper", e2);
        }
    }

    public final void U(rc rcVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            rcVar.g(bundle);
        } catch (RemoteException e2) {
            this.a.f().K().b("Error returning byte array to wrapper", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void V(String str, int i2, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        s0(bundle, i2);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", i3);
        }
        this.a.g();
        this.a.G().S("auto", "_err", bundle);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ApplySharedPref"})
    public final boolean d0(String str, double d2) {
        try {
            SharedPreferences.Editor edit = h().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d2));
            return edit.commit();
        } catch (Exception e2) {
            f().H().b("Failed to persist Deferred Deep Link. exception", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e0(String str, int i2, String str2) {
        if (str2 == null) {
            f().J().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i2) {
            f().J().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
            return false;
        } else {
            return true;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f0(String str, String str2) {
        if (str2 == null) {
            f().J().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            f().J().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                f().J().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    f().J().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g0(String str, String str2, int i2, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                f().M().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h0(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (K0(str)) {
                return true;
            }
            if (this.a.K()) {
                f().J().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", x3.y(str));
            }
            return false;
        } else if (com.google.android.gms.internal.measurement.ka.b() && o().u(r.r0) && !TextUtils.isEmpty(str3)) {
            return true;
        } else {
            if (!TextUtils.isEmpty(str2)) {
                if (K0(str2)) {
                    return true;
                }
                f().J().b("Invalid admob_app_id. Analytics disabled.", x3.y(str2));
                return false;
            }
            if (this.a.K()) {
                f().J().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k0(String str, String[] strArr, String str2) {
        boolean z;
        if (str2 == null) {
            f().J().b("Name is required and can't be null. Type", str);
            return false;
        }
        com.google.android.gms.common.internal.t.k(str2);
        String[] strArr2 = f7912c;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            f().J().c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !j0(str2, strArr)) {
            return true;
        } else {
            f().J().c("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int n0(String str) {
        if (t0("event", str)) {
            if (k0("event", b6.a, str)) {
                return !e0("event", 40, str) ? 2 : 0;
            }
            return 13;
        }
        return 2;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int o0(String str, Object obj) {
        boolean g0;
        if ("_ldl".equals(str)) {
            g0 = g0("user property referrer", str, L0(str), obj);
        } else {
            g0 = g0("user property", str, L0(str), obj);
        }
        return g0 ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final void p() {
        d();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                f().K().a("Utils falling back to Random for random id");
            }
        }
        this.f7915f.set(nextLong);
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t0(String str, String str2) {
        if (str2 == null) {
            f().J().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            f().J().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt) && codePointAt != 95) {
                f().J().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                    f().J().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
                charCount += Character.charCount(codePointAt2);
            }
            return true;
        }
    }

    public final int v(int i2) {
        return com.google.android.gms.common.f.f().h(h(), com.google.android.gms.common.h.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int w0(String str) {
        if (t0("user property", str)) {
            if (k0("user property", d6.a, str)) {
                return !e0("user property", 24, str) ? 6 : 0;
            }
            return 15;
        }
        return 6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object x0(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return G(L0(str), obj, true, false);
        }
        return G(L0(str), obj, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0065 -> B:17:0x0072). Please submit an issue!!! */
    public final long y(Context context, String str) {
        d();
        com.google.android.gms.common.internal.t.k(context);
        com.google.android.gms.common.internal.t.g(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest I0 = I0();
        long j2 = -1;
        if (I0 == null) {
            f().H().a("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                } catch (PackageManager.NameNotFoundException e2) {
                    f().H().b("Package name not found", e2);
                }
                if (!y0(context, str)) {
                    Signature[] signatureArr = com.google.android.gms.common.n.c.a(context).e(h().getPackageName(), 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        j2 = A(I0.digest(signatureArr[0].toByteArray()));
                    } else {
                        f().K().a("Could not get signatures");
                    }
                }
            }
            j2 = 0;
        }
        return j2;
    }
}