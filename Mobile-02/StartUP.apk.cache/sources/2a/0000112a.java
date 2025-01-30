package com.coinbase.wallet.analytics;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.appsflyer.AppsFlyerLib;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.analytics.models.AnalyticsUserProperty;
import com.coinbase.wallet.analytics.models.EventType;
import com.google.firebase.analytics.FirebaseAnalytics;
import h.c.a0;
import h.c.b0;
import h.c.t0.g;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.l0.x;
import org.apache.http.message.TokenParser;
import org.json.JSONObject;

/* compiled from: Analytics.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b:\u0010;J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\u00020\u001c8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR%\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R%\u00104\u001a\n \"*\u0004\u0018\u000100008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0016\u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0002058B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/analytics/Analytics;", "", "Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;", "event", "Lh/c/k0/b;", "log", "(Lcom/coinbase/wallet/analytics/models/AnalyticsEvent;)Lh/c/k0/b;", "Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;", "userProperty", "setUserProperties", "(Lcom/coinbase/wallet/analytics/models/AnalyticsUserProperty;)Lh/c/k0/b;", "Landroid/app/Application;", "app", "", "amplitudeKey", "Lh/c/b0;", "userID", "Lkotlin/x;", "setup", "(Landroid/app/Application;Ljava/lang/String;Lh/c/b0;)V", "Lh/c/k0/a;", "disposeBag$delegate", "Lkotlin/h;", "getDisposeBag", "()Lh/c/k0/a;", "disposeBag", "appInstance", "Landroid/app/Application;", "Lcom/google/firebase/crashlytics/b;", "crashlytics$delegate", "getCrashlytics", "()Lcom/google/firebase/crashlytics/b;", "crashlytics", "Lcom/appsflyer/AppsFlyerLib;", "kotlin.jvm.PlatformType", "appsFlyer$delegate", "getAppsFlyer", "()Lcom/appsflyer/AppsFlyerLib;", "appsFlyer", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "googleAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "", "isDebugToastEnabled", "Z", "()Z", "setDebugToastEnabled", "(Z)V", "Lcom/amplitude/api/c;", "amplitude$delegate", "getAmplitude", "()Lcom/amplitude/api/c;", "amplitude", "Lh/c/a0;", "logSerialQueue$delegate", "getLogSerialQueue", "()Lh/c/a0;", "logSerialQueue", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Analytics {
    public static final Analytics INSTANCE = new Analytics();
    private static final h amplitude$delegate;
    private static Application appInstance;
    private static final h appsFlyer$delegate;
    private static final h crashlytics$delegate;
    private static final h disposeBag$delegate;
    private static FirebaseAnalytics googleAnalytics;
    private static boolean isDebugToastEnabled;
    private static final h logSerialQueue$delegate;

    static {
        h b2;
        h b3;
        h b4;
        h b5;
        h b6;
        b2 = k.b(Analytics$disposeBag$2.INSTANCE);
        disposeBag$delegate = b2;
        b3 = k.b(Analytics$logSerialQueue$2.INSTANCE);
        logSerialQueue$delegate = b3;
        b4 = k.b(Analytics$crashlytics$2.INSTANCE);
        crashlytics$delegate = b4;
        b5 = k.b(Analytics$amplitude$2.INSTANCE);
        amplitude$delegate = b5;
        b6 = k.b(Analytics$appsFlyer$2.INSTANCE);
        appsFlyer$delegate = b6;
    }

    private Analytics() {
    }

    public static /* synthetic */ void a(AnalyticsUserProperty analyticsUserProperty) {
        m625setUserProperties$lambda4(analyticsUserProperty);
    }

    public static /* synthetic */ void b(String str, AnalyticsEvent analyticsEvent) {
        m624log$lambda3$lambda2(str, analyticsEvent);
    }

    public static /* synthetic */ void c(AnalyticsEvent analyticsEvent) {
        m623log$lambda3(analyticsEvent);
    }

    public final com.amplitude.api.c getAmplitude() {
        return (com.amplitude.api.c) amplitude$delegate.getValue();
    }

    private final AppsFlyerLib getAppsFlyer() {
        return (AppsFlyerLib) appsFlyer$delegate.getValue();
    }

    private final com.google.firebase.crashlytics.b getCrashlytics() {
        return (com.google.firebase.crashlytics.b) crashlytics$delegate.getValue();
    }

    private final h.c.k0.a getDisposeBag() {
        return (h.c.k0.a) disposeBag$delegate.getValue();
    }

    private final a0 getLogSerialQueue() {
        return (a0) logSerialQueue$delegate.getValue();
    }

    /* renamed from: log$lambda-3 */
    public static final void m623log$lambda3(final AnalyticsEvent event) {
        final String K;
        Set set;
        String K2;
        m.g(event, "$event");
        JSONObject jSONObject = new JSONObject(event.getProperties());
        INSTANCE.getAmplitude().I(event.getName(), jSONObject);
        K = x.K(event.getName(), ".", "_", false, 4, null);
        if (event.getType() == EventType.DIAGNOSTIC && googleAnalytics != null) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : event.getProperties().entrySet()) {
                K2 = x.K(entry.getKey(), ".", "_", false, 4, null);
                bundle.putString(K2, entry.getValue());
            }
            FirebaseAnalytics firebaseAnalytics = googleAnalytics;
            if (firebaseAnalytics == null) {
                m.w("googleAnalytics");
                throw null;
            }
            firebaseAnalytics.a(K, bundle);
        }
        set = AnalyticsKt.appsFlyerEventNames;
        if (set.contains(event.getName())) {
            AppsFlyerLib appsFlyer = INSTANCE.getAppsFlyer();
            Application application = appInstance;
            if (application == null) {
                m.w("appInstance");
                throw null;
            }
            appsFlyer.trackEvent(application, event.getName(), event.getProperties());
        }
        Analytics analytics = INSTANCE;
        if (analytics.isDebugToastEnabled() && !event.isNoisy()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.coinbase.wallet.analytics.b
                @Override // java.lang.Runnable
                public final void run() {
                    Analytics.b(K, event);
                }
            });
        }
        if (event.getType() != EventType.DIAGNOSTIC) {
            com.google.firebase.crashlytics.b crashlytics = analytics.getCrashlytics();
            crashlytics.c(K + TokenParser.SP + jSONObject);
        }
    }

    /* renamed from: log$lambda-3$lambda-2 */
    public static final void m624log$lambda3$lambda2(String name, AnalyticsEvent event) {
        m.g(name, "$name");
        m.g(event, "$event");
        String str = name + " properties=" + event.getProperties();
        Application application = appInstance;
        if (application != null) {
            Toast.makeText(application, str, 1).show();
        } else {
            m.w("appInstance");
            throw null;
        }
    }

    /* renamed from: setUserProperties$lambda-4 */
    public static final void m625setUserProperties$lambda4(AnalyticsUserProperty userProperty) {
        m.g(userProperty, "$userProperty");
        INSTANCE.getAmplitude().g0(new JSONObject(userProperty.asDictionary$analytics_release()));
    }

    public final boolean isDebugToastEnabled() {
        return isDebugToastEnabled;
    }

    public final h.c.k0.b log(final AnalyticsEvent event) {
        m.g(event, "event");
        h.c.k0.b c2 = getLogSerialQueue().c(new Runnable() { // from class: com.coinbase.wallet.analytics.c
            @Override // java.lang.Runnable
            public final void run() {
                Analytics.c(AnalyticsEvent.this);
            }
        });
        m.f(c2, "logSerialQueue.scheduleDirect {\n        val json = JSONObject(event.properties)\n        amplitude.logEvent(event.name, json)\n        val name = event.name.replace(\".\", \"_\")\n\n        if (event.type == EventType.DIAGNOSTIC && this::googleAnalytics.isInitialized) {\n            val params = Bundle().apply {\n                event.properties.forEach { putString(it.key.replace(\".\", \"_\"), it.value) }\n            }\n\n            googleAnalytics.logEvent(name, params)\n        }\n\n        if (appsFlyerEventNames.contains(event.name)) {\n            appsFlyer.trackEvent(appInstance, event.name, event.properties)\n        }\n\n        if (isDebugToastEnabled && !event.isNoisy) {\n            Handler(Looper.getMainLooper()).post {\n                val toastText = \"$name properties=${event.properties}\"\n                Toast.makeText(appInstance, toastText, Toast.LENGTH_LONG).show()\n            }\n        }\n\n        /**\n         * Firebase Crashlytics may blacklist apps that send more than 1 event per second per app\n         * https://groups.google.com/forum/#!topic/firebase-talk/-jv0Tk6RVf8\n         * We're really interested in what product steps lead to these crashes\n         */\n        if (event.type != EventType.DIAGNOSTIC) {\n            crashlytics.log(\"$name $json\")\n        }\n    }");
        return c2;
    }

    public final void setDebugToastEnabled(boolean z) {
        isDebugToastEnabled = z;
    }

    public final h.c.k0.b setUserProperties(final AnalyticsUserProperty userProperty) {
        m.g(userProperty, "userProperty");
        h.c.k0.b c2 = getLogSerialQueue().c(new Runnable() { // from class: com.coinbase.wallet.analytics.a
            @Override // java.lang.Runnable
            public final void run() {
                Analytics.a(AnalyticsUserProperty.this);
            }
        });
        m.f(c2, "logSerialQueue.scheduleDirect {\n        amplitude.setUserProperties(JSONObject(userProperty.asDictionary()))\n    }");
        return c2;
    }

    public final void setup(Application app, String amplitudeKey, b0<String> userID) {
        m.g(app, "app");
        m.g(amplitudeKey, "amplitudeKey");
        m.g(userID, "userID");
        appInstance = app;
        getAmplitude().C(app, amplitudeKey).u(app);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(app);
        m.f(firebaseAnalytics, "getInstance(app)");
        googleAnalytics = firebaseAnalytics;
        h.c.t0.a.a(g.i(userID, null, Analytics$setup$1.INSTANCE, 1, null), getDisposeBag());
    }
}