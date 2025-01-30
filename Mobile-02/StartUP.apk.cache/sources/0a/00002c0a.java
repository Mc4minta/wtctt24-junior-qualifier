package com.dieam.reactnativepushnotification.modules;

import android.os.Bundle;
import android.util.Log;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: RNPushNotificationAttributes.java */
/* loaded from: classes2.dex */
public class b {
    private final String A;
    private final String B;
    private final double C;
    private final double D;
    private final boolean E;
    private final double F;
    private final boolean G;
    private final boolean H;
    private final boolean I;
    private final boolean J;
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4465b;

    /* renamed from: c  reason: collision with root package name */
    private final double f4466c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4467d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4468e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4469f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4470g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4471h;

    /* renamed from: i  reason: collision with root package name */
    private final String f4472i;

    /* renamed from: j  reason: collision with root package name */
    private final String f4473j;

    /* renamed from: k  reason: collision with root package name */
    private final String f4474k;

    /* renamed from: l  reason: collision with root package name */
    private final String f4475l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final boolean t;
    private final String u;
    private final boolean v;
    private final boolean w;
    private final double x;
    private final String y;
    private final boolean z;

    /* compiled from: RNPushNotificationAttributes.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            a = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public b(Bundle bundle) {
        this.a = bundle.getString("id");
        this.f4465b = bundle.getString(ApiConstants.MESSAGE);
        this.f4466c = bundle.getDouble("fireDate");
        this.f4467d = bundle.getString(MessageBundle.TITLE_ENTRY);
        this.f4468e = bundle.getString("ticker");
        this.f4469f = bundle.getBoolean("showWhen");
        this.f4470g = bundle.getBoolean("autoCancel");
        this.f4471h = bundle.getString("largeIcon");
        this.f4472i = bundle.getString("largeIconUrl");
        this.f4473j = bundle.getString("smallIcon");
        this.f4474k = bundle.getString("bigText");
        this.f4475l = bundle.getString("subText");
        this.m = bundle.getString("bigPictureUrl");
        this.n = bundle.getString("shortcutId");
        this.o = bundle.getString("number");
        this.p = bundle.getString("channelId");
        this.q = bundle.getString("sound");
        this.r = bundle.getString("color");
        this.s = bundle.getString("group");
        this.t = bundle.getBoolean("groupSummary");
        this.u = bundle.getString("messageId");
        this.v = bundle.getBoolean("playSound");
        this.w = bundle.getBoolean("vibrate");
        this.x = bundle.getDouble("vibration");
        this.y = bundle.getString("actions");
        this.z = bundle.getBoolean("invokeApp");
        this.A = bundle.getString("tag");
        this.B = bundle.getString("repeatType");
        this.C = bundle.getDouble("repeatTime");
        this.D = bundle.getDouble("when");
        this.E = bundle.getBoolean("usesChronometer");
        this.F = bundle.getDouble("timeoutAfter");
        this.G = bundle.getBoolean("onlyAlertOnce");
        this.H = bundle.getBoolean("ongoing");
        this.I = bundle.getBoolean("allowWhileIdle");
        this.J = bundle.getBoolean("ignoreInForeground");
    }

    public static b a(String str) throws JSONException {
        return new b(new JSONObject(str));
    }

    public double b() {
        return this.f4466c;
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f4465b;
    }

    public String e() {
        return this.o;
    }

    public String f() {
        return this.B;
    }

    public String g() {
        return this.q;
    }

    public String h() {
        return this.f4467d;
    }

    public boolean i(ReadableMap readableMap) {
        Bundle j2 = j();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (j2.containsKey(nextKey)) {
                switch (a.a[readableMap.getType(nextKey).ordinal()]) {
                    case 1:
                        if (j2.get(nextKey) == null) {
                            break;
                        } else {
                            return false;
                        }
                    case 2:
                        if (readableMap.getBoolean(nextKey) == j2.getBoolean(nextKey)) {
                            break;
                        } else {
                            return false;
                        }
                    case 3:
                        if (readableMap.getDouble(nextKey) != j2.getDouble(nextKey) && readableMap.getInt(nextKey) != j2.getInt(nextKey)) {
                            return false;
                        }
                        break;
                    case 4:
                        if (readableMap.getString(nextKey).equals(j2.getString(nextKey))) {
                            break;
                        } else {
                            return false;
                        }
                    case 5:
                    case 6:
                        return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.a);
        bundle.putString(ApiConstants.MESSAGE, this.f4465b);
        bundle.putDouble("fireDate", this.f4466c);
        bundle.putString(MessageBundle.TITLE_ENTRY, this.f4467d);
        bundle.putString("ticker", this.f4468e);
        bundle.putBoolean("showWhen", this.f4469f);
        bundle.putBoolean("autoCancel", this.f4470g);
        bundle.putString("largeIcon", this.f4471h);
        bundle.putString("largeIconUrl", this.f4472i);
        bundle.putString("smallIcon", this.f4473j);
        bundle.putString("bigText", this.f4474k);
        bundle.putString("subText", this.f4475l);
        bundle.putString("bigPictureUrl", this.m);
        bundle.putString("shortcutId", this.n);
        bundle.putString("number", this.o);
        bundle.putString("channelId", this.p);
        bundle.putString("sound", this.q);
        bundle.putString("color", this.r);
        bundle.putString("group", this.s);
        bundle.putBoolean("groupSummary", this.t);
        bundle.putString("messageId", this.u);
        bundle.putBoolean("playSound", this.v);
        bundle.putBoolean("vibrate", this.w);
        bundle.putDouble("vibration", this.x);
        bundle.putString("actions", this.y);
        bundle.putBoolean("invokeApp", this.z);
        bundle.putString("tag", this.A);
        bundle.putString("repeatType", this.B);
        bundle.putDouble("repeatTime", this.C);
        bundle.putDouble("when", this.D);
        bundle.putBoolean("usesChronometer", this.E);
        bundle.putDouble("timeoutAfter", this.F);
        bundle.putBoolean("onlyAlertOnce", this.G);
        bundle.putBoolean("ongoing", this.H);
        bundle.putBoolean("allowWhileIdle", this.I);
        bundle.putBoolean("ignoreInForeground", this.J);
        return bundle;
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.a);
            jSONObject.put(ApiConstants.MESSAGE, this.f4465b);
            jSONObject.put("fireDate", this.f4466c);
            jSONObject.put(MessageBundle.TITLE_ENTRY, this.f4467d);
            jSONObject.put("ticker", this.f4468e);
            jSONObject.put("showWhen", this.f4469f);
            jSONObject.put("autoCancel", this.f4470g);
            jSONObject.put("largeIcon", this.f4471h);
            jSONObject.put("largeIconUrl", this.f4472i);
            jSONObject.put("smallIcon", this.f4473j);
            jSONObject.put("bigText", this.f4474k);
            jSONObject.put("bigPictureUrl", this.m);
            jSONObject.put("subText", this.f4475l);
            jSONObject.put("shortcutId", this.n);
            jSONObject.put("number", this.o);
            jSONObject.put("channelId", this.p);
            jSONObject.put("sound", this.q);
            jSONObject.put("color", this.r);
            jSONObject.put("group", this.s);
            jSONObject.put("groupSummary", this.t);
            jSONObject.put("messageId", this.u);
            jSONObject.put("playSound", this.v);
            jSONObject.put("vibrate", this.w);
            jSONObject.put("vibration", this.x);
            jSONObject.put("actions", this.y);
            jSONObject.put("invokeApp", this.z);
            jSONObject.put("tag", this.A);
            jSONObject.put("repeatType", this.B);
            jSONObject.put("repeatTime", this.C);
            jSONObject.put("when", this.D);
            jSONObject.put("usesChronometer", this.E);
            jSONObject.put("timeoutAfter", this.F);
            jSONObject.put("onlyAlertOnce", this.G);
            jSONObject.put("ongoing", this.H);
            jSONObject.put("allowWhileIdle", this.I);
            jSONObject.put("ignoreInForeground", this.J);
            return jSONObject;
        } catch (JSONException e2) {
            Log.e(RNPushNotification.LOG_TAG, "Exception while converting RNPushNotificationAttributes to JSON. Returning an empty object", e2);
            return new JSONObject();
        }
    }

    public String toString() {
        return "RNPushNotificationAttributes{id='" + this.a + "', message='" + this.f4465b + "', fireDate=" + this.f4466c + ", title='" + this.f4467d + "', ticker='" + this.f4468e + "', showWhen=" + this.f4469f + ", autoCancel=" + this.f4470g + ", largeIcon='" + this.f4471h + "', largeIconUrl='" + this.f4472i + "', smallIcon='" + this.f4473j + "', bigText='" + this.f4474k + "', subText='" + this.f4475l + "', bigPictureUrl='" + this.m + "', shortcutId='" + this.n + "', number='" + this.o + "', channelId='" + this.p + "', sound='" + this.q + "', color='" + this.r + "', group='" + this.s + "', groupSummary='" + this.t + "', messageId='" + this.u + "', playSound=" + this.v + ", vibrate=" + this.w + ", vibration=" + this.x + ", actions='" + this.y + "', invokeApp=" + this.z + ", tag='" + this.A + "', repeatType='" + this.B + "', repeatTime=" + this.C + ", when=" + this.D + ", usesChronometer=" + this.E + ", timeoutAfter=" + this.F + ", onlyAlertOnce=" + this.G + ", ongoing=" + this.H + ", allowWhileIdle=" + this.I + ", ignoreInForeground=" + this.J + '}';
    }

    private b(JSONObject jSONObject) {
        try {
            this.a = jSONObject.has("id") ? jSONObject.getString("id") : null;
            this.f4465b = jSONObject.has(ApiConstants.MESSAGE) ? jSONObject.getString(ApiConstants.MESSAGE) : null;
            this.f4466c = jSONObject.has("fireDate") ? jSONObject.getDouble("fireDate") : 0.0d;
            this.f4467d = jSONObject.has(MessageBundle.TITLE_ENTRY) ? jSONObject.getString(MessageBundle.TITLE_ENTRY) : null;
            this.f4468e = jSONObject.has("ticker") ? jSONObject.getString("ticker") : null;
            this.f4469f = jSONObject.has("showWhen") ? jSONObject.getBoolean("showWhen") : true;
            this.f4470g = jSONObject.has("autoCancel") ? jSONObject.getBoolean("autoCancel") : true;
            this.f4471h = jSONObject.has("largeIcon") ? jSONObject.getString("largeIcon") : null;
            this.f4472i = jSONObject.has("largeIconUrl") ? jSONObject.getString("largeIconUrl") : null;
            this.f4473j = jSONObject.has("smallIcon") ? jSONObject.getString("smallIcon") : null;
            this.f4474k = jSONObject.has("bigText") ? jSONObject.getString("bigText") : null;
            this.f4475l = jSONObject.has("subText") ? jSONObject.getString("subText") : null;
            this.m = jSONObject.has("bigPictureUrl") ? jSONObject.getString("bigPictureUrl") : null;
            this.n = jSONObject.has("shortcutId") ? jSONObject.getString("shortcutId") : null;
            this.o = jSONObject.has("number") ? jSONObject.getString("number") : null;
            this.p = jSONObject.has("channelId") ? jSONObject.getString("channelId") : null;
            this.q = jSONObject.has("sound") ? jSONObject.getString("sound") : null;
            this.r = jSONObject.has("color") ? jSONObject.getString("color") : null;
            this.s = jSONObject.has("group") ? jSONObject.getString("group") : null;
            this.t = jSONObject.has("groupSummary") ? jSONObject.getBoolean("groupSummary") : false;
            this.u = jSONObject.has("messageId") ? jSONObject.getString("messageId") : null;
            this.v = jSONObject.has("playSound") ? jSONObject.getBoolean("playSound") : true;
            this.w = jSONObject.has("vibrate") ? jSONObject.getBoolean("vibrate") : true;
            this.x = jSONObject.has("vibration") ? jSONObject.getDouble("vibration") : 1000.0d;
            this.y = jSONObject.has("actions") ? jSONObject.getString("actions") : null;
            this.z = jSONObject.has("invokeApp") ? jSONObject.getBoolean("invokeApp") : true;
            this.A = jSONObject.has("tag") ? jSONObject.getString("tag") : null;
            this.B = jSONObject.has("repeatType") ? jSONObject.getString("repeatType") : null;
            this.C = jSONObject.has("repeatTime") ? jSONObject.getDouble("repeatTime") : 0.0d;
            this.D = jSONObject.has("when") ? jSONObject.getDouble("when") : -1.0d;
            this.E = jSONObject.has("usesChronometer") ? jSONObject.getBoolean("usesChronometer") : false;
            this.F = jSONObject.has("timeoutAfter") ? jSONObject.getDouble("timeoutAfter") : -1.0d;
            this.G = jSONObject.has("onlyAlertOnce") ? jSONObject.getBoolean("onlyAlertOnce") : false;
            this.H = jSONObject.has("ongoing") ? jSONObject.getBoolean("ongoing") : false;
            this.I = jSONObject.has("allowWhileIdle") ? jSONObject.getBoolean("allowWhileIdle") : false;
            this.J = jSONObject.has("ignoreInForeground") ? jSONObject.getBoolean("ignoreInForeground") : false;
        } catch (JSONException e2) {
            throw new IllegalStateException("Exception while initializing RNPushNotificationAttributes from JSON", e2);
        }
    }
}