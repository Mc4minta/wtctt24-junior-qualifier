package com.bugsnag.android;

import android.annotation.SuppressLint;
import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class NativeInterface {
    @SuppressLint({"StaticFieldLeak"})
    private static q client;

    /* loaded from: classes.dex */
    static class a implements p {
        final /* synthetic */ Severity a;

        a(Severity severity) {
            this.a = severity;
        }

        @Override // com.bugsnag.android.p
        public void a(v0 v0Var) {
            c0 a = v0Var.a();
            if (a != null) {
                Severity severity = this.a;
                if (severity != null) {
                    a.r(severity);
                }
                a.f().e(Constants.URL_CAMPAIGN);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public final c a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f3577b;

        public b(c cVar, Object obj) {
            this.a = cVar;
            this.f3577b = obj;
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        ADD_BREADCRUMB,
        ADD_METADATA,
        CLEAR_BREADCRUMBS,
        CLEAR_METADATA_TAB,
        DELIVER_PENDING,
        INSTALL,
        NOTIFY_HANDLED,
        NOTIFY_UNHANDLED,
        REMOVE_METADATA,
        START_SESSION,
        STOP_SESSION,
        UPDATE_APP_VERSION,
        UPDATE_BUILD_UUID,
        UPDATE_CONTEXT,
        UPDATE_IN_FOREGROUND,
        UPDATE_LOW_MEMORY,
        UPDATE_METADATA,
        UPDATE_ORIENTATION,
        UPDATE_RELEASE_STAGE,
        UPDATE_USER_EMAIL,
        UPDATE_USER_NAME,
        UPDATE_USER_ID
    }

    public static void addToTab(String str, String str2, Object obj) {
        getClient().b(str, str2, obj);
    }

    public static void clearTab(String str) {
        getClient().d(str);
    }

    @Deprecated
    public static void configureClientObservers(q qVar) {
        setClient(qVar);
    }

    public static void deliverReport(String str, String str2) {
        q client2 = getClient();
        if (str == null || str.length() == 0 || client2.l().X(str)) {
            client2.o().d(str2);
            client2.o().i();
        }
    }

    public static Map<String, Object> getAppData() {
        HashMap hashMap = new HashMap();
        com.bugsnag.android.c k2 = getClient().k();
        hashMap.putAll(k2.f());
        hashMap.putAll(k2.g());
        return hashMap;
    }

    public static String getAppVersion() {
        return getClient().l().d();
    }

    public static List<Breadcrumb> getBreadcrumbs() {
        return new ArrayList(getClient().f3687e.store);
    }

    private static q getClient() {
        q qVar = client;
        return qVar != null ? qVar : j.b();
    }

    public static String getContext() {
        return getClient().m();
    }

    public static String[] getCpuAbi() {
        return getClient().f3685c.n;
    }

    public static Map<String, Object> getDeviceData() {
        HashMap hashMap = new HashMap();
        b0 n = getClient().n();
        hashMap.putAll(n.i());
        hashMap.putAll(n.g());
        return hashMap;
    }

    public static String getEndpoint() {
        return getClient().l().p();
    }

    public static boolean getLoggingEnabled() {
        return q0.a();
    }

    public static Map<String, Object> getMetaData() {
        return new HashMap(getClient().q().a);
    }

    public static String getNativeReportPath() {
        return getClient().f3684b.getCacheDir().getAbsolutePath() + "/bugsnag-native/";
    }

    public static String[] getNotifyReleaseStages() {
        return getClient().l().v();
    }

    public static String getReleaseStage() {
        return getClient().l().y();
    }

    public static String getSessionEndpoint() {
        return getClient().l().C();
    }

    public static Map<String, String> getUserData() {
        HashMap hashMap = new HashMap();
        d1 s = getClient().s();
        hashMap.put("id", s.b());
        hashMap.put(ApiConstants.NAME, s.c());
        hashMap.put("email", s.a());
        return hashMap;
    }

    public static void leaveBreadcrumb(String str, BreadcrumbType breadcrumbType) {
        getClient().u(str, breadcrumbType, new HashMap());
    }

    public static void notify(String str, String str2, Severity severity, StackTraceElement[] stackTraceElementArr) {
        getClient().y(str, str2, stackTraceElementArr, new a(severity));
    }

    public static void registerSession(long j2, String str, int i2, int i3) {
        q client2 = getClient();
        client2.r().o(j2 > 0 ? new Date(j2) : null, str, client2.s(), i2, i3);
    }

    public static void setAppVersion(String str) {
        getClient().F(str);
    }

    public static void setBinaryArch(String str) {
        getClient().H(str);
    }

    public static void setClient(q qVar) {
        client = qVar;
    }

    public static void setContext(String str) {
        getClient().I(str);
    }

    public static void setEndpoint(String str) {
        getClient().l().N(str);
    }

    public static void setNotifyReleaseStages(String[] strArr) {
        getClient().l().Q(strArr);
    }

    public static void setReleaseStage(String str) {
        getClient().M(str);
    }

    public static void setSessionEndpoint(String str) {
        getClient().l().V(str);
    }

    public static void setUser(String str, String str2, String str3) {
        q client2 = getClient();
        client2.P(str);
        client2.O(str2);
        client2.Q(str3);
    }

    public static void leaveBreadcrumb(String str, String str2, Map<String, String> map) {
        String upperCase = str2.toUpperCase(Locale.US);
        if (map == null) {
            map = new HashMap<>();
        }
        getClient().u(str, BreadcrumbType.valueOf(upperCase), map);
    }
}