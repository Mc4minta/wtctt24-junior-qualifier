package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.b6;
import com.google.android.gms.measurement.internal.d6;
import com.google.android.gms.measurement.internal.l7;
import com.google.firebase.analytics.a.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.0 */
/* loaded from: classes2.dex */
public final class a {
    private static final Set<String> a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f8584b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f8585c = Arrays.asList("auto", "app", "am");

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f8586d = Arrays.asList("_r", "_dbg");

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f8587e = Arrays.asList((String[]) com.google.android.gms.common.util.b.a(d6.a, d6.f7536b));

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f8588f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static a.c a(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        a.c cVar = new a.c();
        cVar.a = conditionalUserProperty.mOrigin;
        cVar.n = conditionalUserProperty.mActive;
        cVar.m = conditionalUserProperty.mCreationTimestamp;
        cVar.f8579k = conditionalUserProperty.mExpiredEventName;
        if (conditionalUserProperty.mExpiredEventParams != null) {
            cVar.f8580l = new Bundle(conditionalUserProperty.mExpiredEventParams);
        }
        cVar.f8570b = conditionalUserProperty.mName;
        cVar.f8574f = conditionalUserProperty.mTimedOutEventName;
        if (conditionalUserProperty.mTimedOutEventParams != null) {
            cVar.f8575g = new Bundle(conditionalUserProperty.mTimedOutEventParams);
        }
        cVar.f8578j = conditionalUserProperty.mTimeToLive;
        cVar.f8576h = conditionalUserProperty.mTriggeredEventName;
        if (conditionalUserProperty.mTriggeredEventParams != null) {
            cVar.f8577i = new Bundle(conditionalUserProperty.mTriggeredEventParams);
        }
        cVar.o = conditionalUserProperty.mTriggeredTimestamp;
        cVar.f8572d = conditionalUserProperty.mTriggerEventName;
        cVar.f8573e = conditionalUserProperty.mTriggerTimeout;
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            cVar.f8571c = l7.a(obj);
        }
        return cVar;
    }

    public static boolean b(a.c cVar) {
        String str;
        if (cVar == null || (str = cVar.a) == null || str.isEmpty()) {
            return false;
        }
        Object obj = cVar.f8571c;
        if ((obj == null || l7.a(obj) != null) && c(str) && e(str, cVar.f8570b)) {
            String str2 = cVar.f8579k;
            if (str2 == null || (d(str2, cVar.f8580l) && f(str, cVar.f8579k, cVar.f8580l))) {
                String str3 = cVar.f8576h;
                if (str3 == null || (d(str3, cVar.f8577i) && f(str, cVar.f8576h, cVar.f8577i))) {
                    String str4 = cVar.f8574f;
                    if (str4 != null) {
                        return d(str4, cVar.f8575g) && f(str, cVar.f8574f, cVar.f8575g);
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean c(String str) {
        return !f8585c.contains(str);
    }

    public static boolean d(String str, Bundle bundle) {
        if (f8584b.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String str2 : f8586d) {
                if (bundle.containsKey(str2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean e(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        } else if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        } else if (f8587e.contains(str2)) {
            return false;
        } else {
            for (String str3 : f8588f) {
                if (str2.matches(str3)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean f(String str, String str2, Bundle bundle) {
        if ("_cmp".equals(str2)) {
            if (c(str) && bundle != null) {
                for (String str3 : f8586d) {
                    if (bundle.containsKey(str3)) {
                        return false;
                    }
                }
                str.hashCode();
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 101200:
                        if (str.equals("fcm")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 101230:
                        if (str.equals("fdl")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3142703:
                        if (str.equals("fiam")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        bundle.putString("_cis", "fcm_integration");
                        return true;
                    case 1:
                        bundle.putString("_cis", "fdl_integration");
                        return true;
                    case 2:
                        bundle.putString("_cis", "fiam_integration");
                        return true;
                    default:
                        return false;
                }
            }
            return false;
        }
        return true;
    }

    public static AppMeasurement.ConditionalUserProperty g(a.c cVar) {
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mOrigin = cVar.a;
        conditionalUserProperty.mActive = cVar.n;
        conditionalUserProperty.mCreationTimestamp = cVar.m;
        conditionalUserProperty.mExpiredEventName = cVar.f8579k;
        if (cVar.f8580l != null) {
            conditionalUserProperty.mExpiredEventParams = new Bundle(cVar.f8580l);
        }
        conditionalUserProperty.mName = cVar.f8570b;
        conditionalUserProperty.mTimedOutEventName = cVar.f8574f;
        if (cVar.f8575g != null) {
            conditionalUserProperty.mTimedOutEventParams = new Bundle(cVar.f8575g);
        }
        conditionalUserProperty.mTimeToLive = cVar.f8578j;
        conditionalUserProperty.mTriggeredEventName = cVar.f8576h;
        if (cVar.f8577i != null) {
            conditionalUserProperty.mTriggeredEventParams = new Bundle(cVar.f8577i);
        }
        conditionalUserProperty.mTriggeredTimestamp = cVar.o;
        conditionalUserProperty.mTriggerEventName = cVar.f8572d;
        conditionalUserProperty.mTriggerTimeout = cVar.f8573e;
        Object obj = cVar.f8571c;
        if (obj != null) {
            conditionalUserProperty.mValue = l7.a(obj);
        }
        return conditionalUserProperty;
    }

    public static void h(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean i(String str) {
        return !a.contains(str);
    }

    public static String j(String str) {
        String a2 = b6.a(str);
        return a2 != null ? a2 : str;
    }
}