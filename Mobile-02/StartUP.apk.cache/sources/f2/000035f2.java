package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.coinbase.ApiConstants;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.measurement.internal.b5;
import com.google.android.gms.measurement.internal.e7;
import com.google.android.gms.measurement.internal.f6;
import com.google.android.gms.measurement.internal.q9;
import com.google.android.gms.measurement.internal.y5;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
@Deprecated
/* loaded from: classes2.dex */
public class AppMeasurement {
    private static volatile AppMeasurement a;

    /* renamed from: b  reason: collision with root package name */
    private final b5 f7470b;

    /* renamed from: c  reason: collision with root package name */
    private final e7 f7471c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7472d;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
    /* loaded from: classes2.dex */
    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString(ApiConstants.NAME, str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                y5.b(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean(AppStateModule.APP_STATE_ACTIVE, this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }

        ConditionalUserProperty(Bundle bundle) {
            t.k(bundle);
            this.mAppId = (String) y5.a(bundle, "app_id", String.class, null);
            this.mOrigin = (String) y5.a(bundle, "origin", String.class, null);
            this.mName = (String) y5.a(bundle, ApiConstants.NAME, String.class, null);
            this.mValue = y5.a(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) y5.a(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) y5.a(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) y5.a(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) y5.a(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) y5.a(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) y5.a(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) y5.a(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) y5.a(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) y5.a(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) y5.a(bundle, AppStateModule.APP_STATE_ACTIVE, Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) y5.a(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) y5.a(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
    /* loaded from: classes2.dex */
    public interface a extends f6 {
    }

    private AppMeasurement(b5 b5Var) {
        t.k(b5Var);
        this.f7470b = b5Var;
        this.f7471c = null;
        this.f7472d = false;
    }

    public static AppMeasurement d(Context context, Bundle bundle) {
        if (a == null) {
            synchronized (AppMeasurement.class) {
                if (a == null) {
                    e7 g2 = g(context, bundle);
                    if (g2 != null) {
                        a = new AppMeasurement(g2);
                    } else {
                        a = new AppMeasurement(b5.b(context, null, null, bundle));
                    }
                }
            }
        }
        return a;
    }

    private static AppMeasurement e(Context context, String str, String str2) {
        if (a == null) {
            synchronized (AppMeasurement.class) {
                if (a == null) {
                    e7 g2 = g(context, null);
                    if (g2 != null) {
                        a = new AppMeasurement(g2);
                    } else {
                        a = new AppMeasurement(b5.b(context, null, null, null));
                    }
                }
            }
        }
        return a;
    }

    private static e7 g(Context context, Bundle bundle) {
        try {
            return (e7) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, bundle);
        } catch (ClassNotFoundException | Exception unused) {
            return null;
        }
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return e(context, null, null);
    }

    public Map<String, Object> a(boolean z) {
        if (this.f7472d) {
            return this.f7471c.l(null, null, z);
        }
        List<q9> x0 = this.f7470b.G().x0(z);
        c.e.a aVar = new c.e.a(x0.size());
        for (q9 q9Var : x0) {
            aVar.put(q9Var.f7823b, q9Var.i1());
        }
        return aVar;
    }

    public void b(a aVar) {
        if (this.f7472d) {
            this.f7471c.m(aVar);
        } else {
            this.f7470b.G().K(aVar);
        }
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        if (this.f7472d) {
            this.f7471c.f(str);
        } else {
            this.f7470b.T().A(str, this.f7470b.i().b());
        }
    }

    public void c(String str, String str2, Object obj) {
        t.g(str);
        if (this.f7472d) {
            this.f7471c.p(str, str2, obj);
        } else {
            this.f7470b.G().W(str, str2, obj, true);
        }
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (this.f7472d) {
            this.f7471c.n(str, str2, bundle);
        } else {
            this.f7470b.G().z0(str, str2, bundle);
        }
    }

    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        if (!this.f7472d) {
            this.f7470b.G().Y(str, str2, str3, bundle);
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    public void endAdUnitExposure(String str) {
        if (this.f7472d) {
            this.f7471c.i(str);
        } else {
            this.f7470b.T().E(str, this.f7470b.i().b());
        }
    }

    public final void f(boolean z) {
        if (this.f7472d) {
            this.f7471c.j(z);
        } else {
            this.f7470b.G().w0(z);
        }
    }

    @Keep
    public long generateEventId() {
        if (this.f7472d) {
            return this.f7471c.e();
        }
        return this.f7470b.H().D0();
    }

    @Keep
    public String getAppInstanceId() {
        if (this.f7472d) {
            return this.f7471c.c();
        }
        return this.f7470b.G().g0();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> C;
        if (this.f7472d) {
            C = this.f7471c.k(str, str2);
        } else {
            C = this.f7470b.G().C(str, str2);
        }
        ArrayList arrayList = new ArrayList(C == null ? 0 : C.size());
        for (Bundle bundle : C) {
            arrayList.add(new ConditionalUserProperty(bundle));
        }
        return arrayList;
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        if (!this.f7472d) {
            ArrayList<Bundle> D = this.f7470b.G().D(str, str2, str3);
            int i2 = 0;
            ArrayList arrayList = new ArrayList(D == null ? 0 : D.size());
            int size = D.size();
            while (i2 < size) {
                Bundle bundle = D.get(i2);
                i2++;
                arrayList.add(new ConditionalUserProperty(bundle));
            }
            return arrayList;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    public String getCurrentScreenClass() {
        if (this.f7472d) {
            return this.f7471c.b();
        }
        return this.f7470b.G().j0();
    }

    @Keep
    public String getCurrentScreenName() {
        if (this.f7472d) {
            return this.f7471c.a();
        }
        return this.f7470b.G().i0();
    }

    @Keep
    public String getGmpAppId() {
        if (this.f7472d) {
            return this.f7471c.d();
        }
        return this.f7470b.G().k0();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        if (this.f7472d) {
            return this.f7471c.h(str);
        }
        this.f7470b.G();
        t.g(str);
        return 25;
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        if (this.f7472d) {
            return this.f7471c.l(str, str2, z);
        }
        return this.f7470b.G().F(str, str2, z);
    }

    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        if (!this.f7472d) {
            return this.f7470b.G().E(str, str2, str3, z);
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f7472d) {
            this.f7471c.o(str, str2, bundle);
        } else {
            this.f7470b.G().S(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        t.k(conditionalUserProperty);
        if (this.f7472d) {
            this.f7471c.g(conditionalUserProperty.a());
        } else {
            this.f7470b.G().H(conditionalUserProperty.a());
        }
    }

    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        t.k(conditionalUserProperty);
        if (!this.f7472d) {
            this.f7470b.G().p0(conditionalUserProperty.a());
            return;
        }
        throw new IllegalStateException("Unexpected call on client side");
    }

    private AppMeasurement(e7 e7Var) {
        t.k(e7Var);
        this.f7471c = e7Var;
        this.f7470b = null;
        this.f7472d = true;
    }
}