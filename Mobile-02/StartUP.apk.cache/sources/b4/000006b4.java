package com.amplitude.api;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Build;
import android.util.Pair;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.OkHttpClient;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AmplitudeClient.java */
/* loaded from: classes.dex */
public class c {
    private static final com.amplitude.api.d a = com.amplitude.api.d.d();
    private long A;
    private long B;
    private long C;
    private boolean D;
    private int E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private AtomicBoolean J;
    AtomicBoolean K;
    Throwable L;
    String M;
    m N;
    m O;

    /* renamed from: b  reason: collision with root package name */
    protected Context f3509b;

    /* renamed from: c  reason: collision with root package name */
    protected OkHttpClient f3510c;

    /* renamed from: d  reason: collision with root package name */
    protected com.amplitude.api.f f3511d;

    /* renamed from: e  reason: collision with root package name */
    protected String f3512e;

    /* renamed from: f  reason: collision with root package name */
    protected String f3513f;

    /* renamed from: g  reason: collision with root package name */
    protected String f3514g;

    /* renamed from: h  reason: collision with root package name */
    protected String f3515h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3516i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3517j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f3518k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3519l;
    private boolean m;
    k n;
    JSONObject o;
    protected String p;
    long q;
    long r;
    long s;
    long t;
    long u;
    long v;
    private com.amplitude.api.h w;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3520b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f3521c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f3522d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f3523e;

        /* compiled from: AmplitudeClient.java */
        /* renamed from: com.amplitude.api.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0094a implements com.amplitude.api.g {
            C0094a() {
            }

            @Override // com.amplitude.api.g
            public void a(SQLiteDatabase sQLiteDatabase) {
                a aVar = a.this;
                c.this.f3511d.s0(sQLiteDatabase, Payload.TYPE_STORE, "device_id", aVar.f3523e.f3515h);
                a aVar2 = a.this;
                c.this.f3511d.s0(sQLiteDatabase, Payload.TYPE_STORE, "user_id", aVar2.f3523e.f3514g);
                a aVar3 = a.this;
                c.this.f3511d.s0(sQLiteDatabase, "long_store", "opt_out", Long.valueOf(aVar3.f3523e.f3519l ? 1L : 0L));
                a aVar4 = a.this;
                c.this.f3511d.s0(sQLiteDatabase, "long_store", "previous_session_id", Long.valueOf(aVar4.f3523e.q));
                a aVar5 = a.this;
                c.this.f3511d.s0(sQLiteDatabase, "long_store", "last_event_time", Long.valueOf(aVar5.f3523e.u));
            }
        }

        a(Context context, boolean z, String str, String str2, c cVar) {
            this.a = context;
            this.f3520b = z;
            this.f3521c = str;
            this.f3522d = str2;
            this.f3523e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            if (cVar.f3518k) {
                return;
            }
            try {
                if (cVar.f3513f.equals("$default_instance")) {
                    c.p0(this.a);
                    c.r0(this.a);
                }
                c.this.f3510c = new OkHttpClient();
                c.this.w = new com.amplitude.api.h(this.a);
                c cVar2 = c.this;
                cVar2.f3515h = cVar2.F();
                if (this.f3520b) {
                    com.amplitude.api.i d2 = com.amplitude.api.i.d();
                    c cVar3 = c.this;
                    d2.b(cVar3.f3510c, this.f3521c, cVar3.f3515h);
                }
                c.this.w.s();
                String str = this.f3522d;
                if (str != null) {
                    this.f3523e.f3514g = str;
                    c.this.f3511d.r0("user_id", str);
                } else {
                    this.f3523e.f3514g = c.this.f3511d.e0("user_id");
                }
                Long N = c.this.f3511d.N("opt_out");
                c.this.f3519l = N != null && N.longValue() == 1;
                c cVar4 = c.this;
                cVar4.v = cVar4.x("previous_session_id", -1L);
                c cVar5 = c.this;
                long j2 = cVar5.v;
                if (j2 >= 0) {
                    cVar5.q = j2;
                }
                cVar5.r = cVar5.x("sequence_number", 0L);
                c cVar6 = c.this;
                cVar6.s = cVar6.x("last_event_id", -1L);
                c cVar7 = c.this;
                cVar7.t = cVar7.x("last_identify_id", -1L);
                c cVar8 = c.this;
                cVar8.u = cVar8.x("last_event_time", -1L);
                c.this.f3511d.Q0(new C0094a());
                c.this.f3518k = true;
            } catch (CursorWindowAllocationException e2) {
                c.a.b("com.amplitude.api.AmplitudeClient", String.format("Failed to initialize Amplitude SDK due to: %s", e2.getMessage()));
                com.amplitude.api.i.d().f("Failed to initialize Amplitude SDK", e2);
                this.f3523e.f3512e = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.J.set(false);
            c.this.m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* renamed from: com.amplitude.api.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0095c implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f3525b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f3526c;

        RunnableC0095c(String str, long j2, long j3) {
            this.a = str;
            this.f3525b = j2;
            this.f3526c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.N(cVar.f3510c, this.a, this.f3525b, this.f3526c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f3528b;

        /* compiled from: AmplitudeClient.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                cVar.n0(cVar.D);
            }
        }

        d(long j2, long j3) {
            this.a = j2;
            this.f3528b = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            long j2 = this.a;
            if (j2 >= 0) {
                c.this.f3511d.I0(j2);
            }
            long j3 = this.f3528b;
            if (j3 >= 0) {
                c.this.f3511d.M0(j3);
            }
            c.this.K.set(false);
            if (c.this.f3511d.d0() <= c.this.x) {
                c.this.D = false;
                c cVar = c.this;
                cVar.E = cVar.y;
                return;
            }
            c.this.N.a(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.K.set(false);
            c.this.n0(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ JSONObject f3530b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONObject f3531c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f3532d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ JSONObject f3533e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ JSONObject f3534f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f3535g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f3536h;

        f(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j2, boolean z) {
            this.a = str;
            this.f3530b = jSONObject;
            this.f3531c = jSONObject2;
            this.f3532d = jSONObject3;
            this.f3533e = jSONObject4;
            this.f3534f = jSONObject5;
            this.f3535g = j2;
            this.f3536h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.b(c.this.f3512e)) {
                return;
            }
            c.this.H(this.a, this.f3530b, this.f3531c, this.f3532d, this.f3533e, this.f3534f, this.f3535g, this.f3536h);
        }
    }

    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    class g implements Runnable {
        final /* synthetic */ long a;

        g(long j2) {
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.b(c.this.f3512e)) {
                return;
            }
            c.this.U(this.a);
            c.this.H = false;
            if (c.this.I) {
                c.this.m0();
            }
            c cVar = c.this;
            cVar.f3511d.r0("device_id", cVar.f3515h);
            c cVar2 = c.this;
            cVar2.f3511d.r0("user_id", cVar2.f3514g);
            c cVar3 = c.this;
            cVar3.f3511d.o0("opt_out", Long.valueOf(cVar3.f3519l ? 1L : 0L));
            c cVar4 = c.this;
            cVar4.f3511d.o0("previous_session_id", Long.valueOf(cVar4.q));
            c cVar5 = c.this;
            cVar5.f3511d.o0("last_event_time", Long.valueOf(cVar5.u));
        }
    }

    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    class h implements Runnable {
        final /* synthetic */ long a;

        h(long j2) {
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.b(c.this.f3512e)) {
                return;
            }
            c.this.i0(this.a);
            c.this.H = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3540b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f3541c;

        i(c cVar, boolean z, String str) {
            this.a = cVar;
            this.f3540b = z;
            this.f3541c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.b(this.a.f3512e)) {
                return;
            }
            if (this.f3540b && c.this.G) {
                c.this.Y("session_end");
            }
            c cVar = this.a;
            String str = this.f3541c;
            cVar.f3514g = str;
            c.this.f3511d.r0("user_id", str);
            if (this.f3540b) {
                long v = c.this.v();
                c.this.d0(v);
                c.this.U(v);
                if (c.this.G) {
                    c.this.Y("session_start");
                }
            }
        }
    }

    public c() {
        this(null);
    }

    private boolean B() {
        return this.q >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        Set<String> w = w();
        String e0 = this.f3511d.e0("device_id");
        if (l.b(e0) || w.contains(e0)) {
            if (!this.f3516i && this.f3517j && !this.w.q()) {
                String c2 = this.w.c();
                if (!l.b(c2) && !w.contains(c2)) {
                    this.f3511d.r0("device_id", c2);
                    return c2;
                }
            }
            String str = com.amplitude.api.h.b() + "R";
            this.f3511d.r0("device_id", str);
            return str;
        }
        return e0;
    }

    private boolean G(long j2) {
        return j2 - this.u < (this.F ? this.B : this.C);
    }

    private static void P(SharedPreferences sharedPreferences, String str, boolean z, com.amplitude.api.f fVar, String str2) {
        if (fVar.N(str2) != null) {
            return;
        }
        fVar.o0(str2, Long.valueOf(sharedPreferences.getBoolean(str, z) ? 1L : 0L));
        sharedPreferences.edit().remove(str).apply();
    }

    private static void Q(SharedPreferences sharedPreferences, String str, long j2, com.amplitude.api.f fVar, String str2) {
        if (fVar.N(str2) != null) {
            return;
        }
        fVar.o0(str2, Long.valueOf(sharedPreferences.getLong(str, j2)));
        sharedPreferences.edit().remove(str).apply();
    }

    private static void R(SharedPreferences sharedPreferences, String str, String str2, com.amplitude.api.f fVar, String str3) {
        if (l.b(fVar.e0(str3))) {
            String string = sharedPreferences.getString(str, str2);
            if (l.b(string)) {
                return;
            }
            fVar.r0(str3, string);
            sharedPreferences.edit().remove(str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(String str) {
        if (t(String.format("sendSessionEvent('%s')", str)) && B()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("special", str);
                H(str, null, jSONObject, null, null, null, this.u, false);
            } catch (JSONException e2) {
                com.amplitude.api.i.d().f(String.format("Failed to generate API Properties JSON for session event %s", str), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(long j2) {
        this.q = j2;
        c0(j2);
    }

    private void h0(long j2) {
        if (this.G) {
            Y("session_end");
        }
        d0(j2);
        U(j2);
        if (this.G) {
            Y("session_start");
        }
    }

    public static String j0(String str) {
        return str.length() <= 1024 ? str : str.substring(0, 1024);
    }

    private void o0(long j2) {
        if (this.J.getAndSet(true)) {
            return;
        }
        this.N.b(new b(), j2);
    }

    static boolean p0(Context context) {
        return q0(context, null, null);
    }

    static boolean q0(Context context, String str, String str2) {
        if (str == null) {
            try {
                str = com.amplitude.api.e.class.getPackage().getName();
            } catch (Exception unused) {
                str = "com.amplitude.api";
            }
        }
        if (str2 == null) {
            str2 = "com.amplitude.api";
        }
        try {
            if (str2.equals(str)) {
                return false;
            }
            String str3 = str + "." + context.getPackageName();
            SharedPreferences sharedPreferences = context.getSharedPreferences(str3, 0);
            if (sharedPreferences.getAll().size() == 0) {
                return false;
            }
            String str4 = str2 + "." + context.getPackageName();
            SharedPreferences.Editor edit = context.getSharedPreferences(str4, 0).edit();
            if (sharedPreferences.contains(str + ".previousSessionId")) {
                edit.putLong("com.amplitude.api.previousSessionId", sharedPreferences.getLong(str + ".previousSessionId", -1L));
            }
            if (sharedPreferences.contains(str + ".deviceId")) {
                edit.putString("com.amplitude.api.deviceId", sharedPreferences.getString(str + ".deviceId", null));
            }
            if (sharedPreferences.contains(str + ".userId")) {
                edit.putString("com.amplitude.api.userId", sharedPreferences.getString(str + ".userId", null));
            }
            if (sharedPreferences.contains(str + ".optOut")) {
                edit.putBoolean("com.amplitude.api.optOut", sharedPreferences.getBoolean(str + ".optOut", false));
            }
            edit.apply();
            sharedPreferences.edit().clear().apply();
            a.e("com.amplitude.api.AmplitudeClient", "Upgraded shared preferences from " + str3 + " to " + str4);
            return true;
        } catch (Exception e2) {
            a.c("com.amplitude.api.AmplitudeClient", "Error upgrading shared preferences", e2);
            com.amplitude.api.i.d().f("Failed to upgrade shared prefs", e2);
            return false;
        }
    }

    static boolean r0(Context context) {
        return s0(context, null);
    }

    static boolean s0(Context context, String str) {
        if (str == null) {
            str = "com.amplitude.api";
        }
        com.amplitude.api.f g2 = com.amplitude.api.f.g(context);
        String e0 = g2.e0("device_id");
        Long N = g2.N("previous_session_id");
        Long N2 = g2.N("last_event_time");
        if (l.b(e0) || N == null || N2 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str + "." + context.getPackageName(), 0);
            R(sharedPreferences, "com.amplitude.api.deviceId", null, g2, "device_id");
            Q(sharedPreferences, "com.amplitude.api.lastEventTime", -1L, g2, "last_event_time");
            Q(sharedPreferences, "com.amplitude.api.lastEventId", -1L, g2, "last_event_id");
            Q(sharedPreferences, "com.amplitude.api.lastIdentifyId", -1L, g2, "last_identify_id");
            Q(sharedPreferences, "com.amplitude.api.previousSessionId", -1L, g2, "previous_session_id");
            R(sharedPreferences, "com.amplitude.api.userId", null, g2, "user_id");
            P(sharedPreferences, "com.amplitude.api.optOut", false, g2, "opt_out");
            return true;
        }
        return true;
    }

    private Set<String> w() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add("Android");
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long x(String str, long j2) {
        Long N = this.f3511d.N(str);
        return N == null ? j2 : N.longValue();
    }

    public void A(j jVar, boolean z) {
        if (jVar == null || jVar.a.length() == 0 || !t("identify()")) {
            return;
        }
        M("$identify", null, null, jVar.a, null, null, v(), z);
    }

    public c C(Context context, String str) {
        return D(context, str, null);
    }

    public c D(Context context, String str, String str2) {
        return E(context, str, str2, null, false);
    }

    public synchronized c E(Context context, String str, String str2, String str3, boolean z) {
        if (context == null) {
            a.b("com.amplitude.api.AmplitudeClient", "Argument context cannot be null in initialize()");
            return this;
        } else if (l.b(str)) {
            a.b("com.amplitude.api.AmplitudeClient", "Argument apiKey cannot be null or blank in initialize()");
            return this;
        } else {
            Context applicationContext = context.getApplicationContext();
            this.f3509b = applicationContext;
            this.f3512e = str;
            this.f3511d = com.amplitude.api.f.j(applicationContext, this.f3513f);
            if (l.b(str3)) {
                str3 = "Android";
            }
            this.p = str3;
            W(new a(context, z, str, str2, this));
            return this;
        }
    }

    protected long H(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j2, boolean z) {
        String str2;
        JSONObject l0;
        JSONObject l02;
        JSONObject l03;
        Location l2;
        com.amplitude.api.d dVar = a;
        dVar.a("com.amplitude.api.AmplitudeClient", "Logged event to Amplitude: " + str);
        if (this.f3519l) {
            return -1L;
        }
        if (!(this.G && (str.equals("session_start") || str.equals("session_end"))) && !z) {
            if (!this.H) {
                i0(j2);
            } else {
                U(j2);
            }
        }
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6.put("event_type", V(str));
            jSONObject6.put("timestamp", j2);
            jSONObject6.put("user_id", V(this.f3514g));
            jSONObject6.put("device_id", V(this.f3515h));
            jSONObject6.put("session_id", z ? -1L : this.q);
            jSONObject6.put("uuid", UUID.randomUUID().toString());
            jSONObject6.put("sequence_number", y());
            if (this.n.m()) {
                jSONObject6.put("version_name", V(this.w.o()));
            }
            if (this.n.j()) {
                jSONObject6.put("os_name", V(this.w.m()));
            }
            if (this.n.k()) {
                jSONObject6.put("os_version", V(this.w.n()));
            }
            if (this.n.d()) {
                jSONObject6.put("device_brand", V(this.w.d()));
            }
            if (this.n.e()) {
                jSONObject6.put("device_manufacturer", V(this.w.j()));
            }
            if (this.n.f()) {
                jSONObject6.put("device_model", V(this.w.k()));
            }
            if (this.n.b()) {
                jSONObject6.put("carrier", V(this.w.f()));
            }
            if (this.n.c()) {
                jSONObject6.put("country", V(this.w.g()));
            }
            if (this.n.h()) {
                jSONObject6.put("language", V(this.w.i()));
            }
            if (this.n.l()) {
                jSONObject6.put("platform", this.p);
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(ApiConstants.NAME, "amplitude-android");
            jSONObject7.put(ClientCookie.VERSION_ATTR, "2.21.0");
            jSONObject6.put("library", jSONObject7);
            JSONObject jSONObject8 = jSONObject2 == null ? new JSONObject() : jSONObject2;
            JSONObject jSONObject9 = this.o;
            if (jSONObject9 != null && jSONObject9.length() > 0) {
                jSONObject8.put("tracking_options", this.o);
            }
            if (!this.n.i() || (l2 = this.w.l()) == null) {
                str2 = "com.amplitude.api.AmplitudeClient";
            } else {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("lat", l2.getLatitude());
                str2 = "com.amplitude.api.AmplitudeClient";
                try {
                    jSONObject10.put("lng", l2.getLongitude());
                    jSONObject8.put("location", jSONObject10);
                } catch (JSONException e2) {
                    e = e2;
                    a.b(str2, String.format("JSON Serialization of event type %s failed, skipping: %s", str, e.toString()));
                    com.amplitude.api.i.d().f(String.format("Failed to JSON serialize event type %s", str), e);
                    return -1L;
                }
            }
            if (this.n.a() && this.w.c() != null) {
                jSONObject8.put("androidADID", this.w.c());
            }
            jSONObject8.put("limit_ad_tracking", this.w.q());
            jSONObject8.put("gps_enabled", this.w.p());
            jSONObject6.put("api_properties", jSONObject8);
            if (jSONObject == null) {
                l0 = new JSONObject();
            } else {
                l0 = l0(jSONObject);
            }
            jSONObject6.put("event_properties", l0);
            if (jSONObject3 == null) {
                l02 = new JSONObject();
            } else {
                l02 = l0(jSONObject3);
            }
            jSONObject6.put("user_properties", l02);
            jSONObject6.put("groups", jSONObject4 == null ? new JSONObject() : l0(jSONObject4));
            if (jSONObject5 == null) {
                l03 = new JSONObject();
            } else {
                l03 = l0(jSONObject5);
            }
            jSONObject6.put("group_properties", l03);
            return X(str, jSONObject6);
        } catch (JSONException e3) {
            e = e3;
            str2 = "com.amplitude.api.AmplitudeClient";
        }
    }

    public void I(String str, JSONObject jSONObject) {
        L(str, jSONObject, false);
    }

    public void J(String str, JSONObject jSONObject, JSONObject jSONObject2, long j2, boolean z) {
        if (u0(str)) {
            M(str, jSONObject, null, null, jSONObject2, null, j2, z);
        }
    }

    public void K(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        J(str, jSONObject, jSONObject2, v(), z);
    }

    public void L(String str, JSONObject jSONObject, boolean z) {
        K(str, jSONObject, null, z);
    }

    protected void M(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j2, boolean z) {
        W(new f(str, jSONObject != null ? l.a(jSONObject) : jSONObject, jSONObject2 != null ? l.a(jSONObject2) : jSONObject2, jSONObject3 != null ? l.a(jSONObject3) : jSONObject3, jSONObject4 != null ? l.a(jSONObject4) : jSONObject4, jSONObject5 != null ? l.a(jSONObject5) : jSONObject5, j2, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void N(okhttp3.OkHttpClient r16, java.lang.String r17, long r18, long r20) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.c.N(okhttp3.OkHttpClient, java.lang.String, long, long):void");
    }

    protected Pair<Pair<Long, Long>, JSONArray> O(List<JSONObject> list, List<JSONObject> list2, long j2) throws JSONException {
        long j3;
        long j4;
        JSONArray jSONArray = new JSONArray();
        long j5 = -1;
        long j6 = -1;
        while (true) {
            if (jSONArray.length() >= j2) {
                break;
            }
            boolean isEmpty = list.isEmpty();
            boolean isEmpty2 = list2.isEmpty();
            if (isEmpty && isEmpty2) {
                a.f("com.amplitude.api.AmplitudeClient", String.format("mergeEventsAndIdentifys: number of events and identifys less than expected by %d", Long.valueOf(j2 - jSONArray.length())));
                break;
            }
            if (isEmpty2) {
                JSONObject remove = list.remove(0);
                j3 = remove.getLong("event_id");
                jSONArray.put(remove);
            } else {
                if (isEmpty) {
                    JSONObject remove2 = list2.remove(0);
                    j4 = remove2.getLong("event_id");
                    jSONArray.put(remove2);
                } else if (list.get(0).has("sequence_number") && list.get(0).getLong("sequence_number") >= list2.get(0).getLong("sequence_number")) {
                    JSONObject remove3 = list2.remove(0);
                    j4 = remove3.getLong("event_id");
                    jSONArray.put(remove3);
                } else {
                    JSONObject remove4 = list.remove(0);
                    j3 = remove4.getLong("event_id");
                    jSONArray.put(remove4);
                }
                j6 = j4;
            }
            j5 = j3;
        }
        return new Pair<>(new Pair(Long.valueOf(j5), Long.valueOf(j6)), jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(long j2) {
        W(new h(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(long j2) {
        W(new g(j2));
    }

    void U(long j2) {
        if (B()) {
            a0(j2);
        }
    }

    protected Object V(Object obj) {
        return obj == null ? JSONObject.NULL : obj;
    }

    protected void W(Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        m mVar = this.N;
        if (currentThread != mVar) {
            mVar.a(runnable);
        } else {
            runnable.run();
        }
    }

    protected long X(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        if (l.b(jSONObject2)) {
            a.b("com.amplitude.api.AmplitudeClient", String.format("Detected empty event string for event type %s, skipping", str));
            return -1L;
        }
        if (!str.equals("$identify") && !str.equals("$groupidentify")) {
            long a2 = this.f3511d.a(jSONObject2);
            this.s = a2;
            Z(a2);
        } else {
            long c2 = this.f3511d.c(jSONObject2);
            this.t = c2;
            b0(c2);
        }
        int min = Math.min(Math.max(1, this.z / 10), 20);
        if (this.f3511d.n() > this.z) {
            com.amplitude.api.f fVar = this.f3511d;
            fVar.I0(fVar.O(min));
        }
        if (this.f3511d.G() > this.z) {
            com.amplitude.api.f fVar2 = this.f3511d;
            fVar2.M0(fVar2.a0(min));
        }
        long d0 = this.f3511d.d0();
        int i2 = this.x;
        if (d0 % i2 == 0 && d0 >= i2) {
            m0();
        } else {
            o0(this.A);
        }
        return (str.equals("$identify") || str.equals("$groupidentify")) ? this.t : this.s;
    }

    void Z(long j2) {
        this.s = j2;
        this.f3511d.o0("last_event_id", Long.valueOf(j2));
    }

    void a0(long j2) {
        this.u = j2;
        this.f3511d.o0("last_event_time", Long.valueOf(j2));
    }

    void b0(long j2) {
        this.t = j2;
        this.f3511d.o0("last_identify_id", Long.valueOf(j2));
    }

    void c0(long j2) {
        this.v = j2;
        this.f3511d.o0("previous_session_id", Long.valueOf(j2));
    }

    public c e0(String str) {
        return f0(str, false);
    }

    public c f0(String str, boolean z) {
        if (t("setUserId()")) {
            W(new i(this, z, str));
            return this;
        }
        return this;
    }

    public void g0(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0 || !t("setUserProperties")) {
            return;
        }
        JSONObject l0 = l0(jSONObject);
        if (l0.length() == 0) {
            return;
        }
        j jVar = new j();
        Iterator<String> keys = l0.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jVar.b(next, l0.get(next));
            } catch (JSONException e2) {
                a.b("com.amplitude.api.AmplitudeClient", e2.toString());
                com.amplitude.api.i.d().f(String.format("Failed to set user property %s", next), e2);
            }
        }
        z(jVar);
    }

    boolean i0(long j2) {
        if (B()) {
            if (G(j2)) {
                U(j2);
                return false;
            }
            h0(j2);
            return true;
        } else if (G(j2)) {
            long j3 = this.v;
            if (j3 == -1) {
                h0(j2);
                return true;
            }
            d0(j3);
            U(j2);
            return false;
        } else {
            h0(j2);
            return true;
        }
    }

    public JSONArray k0(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return new JSONArray();
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj.getClass().equals(String.class)) {
                jSONArray.put(i2, j0((String) obj));
            } else if (obj.getClass().equals(JSONObject.class)) {
                jSONArray.put(i2, l0((JSONObject) obj));
            } else if (obj.getClass().equals(JSONArray.class)) {
                jSONArray.put(i2, k0((JSONArray) obj));
            }
        }
        return jSONArray;
    }

    public JSONObject l0(JSONObject jSONObject) {
        Object obj;
        if (jSONObject == null) {
            return new JSONObject();
        }
        if (jSONObject.length() > 1000) {
            a.f("com.amplitude.api.AmplitudeClient", "Warning: too many properties (more than 1000), ignoring");
            return new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                obj = jSONObject.get(next);
            } catch (JSONException e2) {
                a.b("com.amplitude.api.AmplitudeClient", e2.toString());
            }
            if (!next.equals("$receipt") && !next.equals("$receiptSig")) {
                if (obj.getClass().equals(String.class)) {
                    jSONObject.put(next, j0((String) obj));
                } else if (obj.getClass().equals(JSONObject.class)) {
                    jSONObject.put(next, l0((JSONObject) obj));
                } else if (obj.getClass().equals(JSONArray.class)) {
                    jSONObject.put(next, k0((JSONArray) obj));
                }
            }
            jSONObject.put(next, obj);
        }
        return jSONObject;
    }

    protected void m0() {
        n0(false);
        com.amplitude.api.i.d().c();
    }

    protected void n0(boolean z) {
        if (this.f3519l || this.m || this.K.getAndSet(true)) {
            return;
        }
        long min = Math.min(z ? this.E : this.y, this.f3511d.d0());
        if (min <= 0) {
            this.K.set(false);
            return;
        }
        try {
            Pair<Pair<Long, Long>, JSONArray> O = O(this.f3511d.z(this.s, min), this.f3511d.K(this.t, min), min);
            if (((JSONArray) O.second).length() == 0) {
                this.K.set(false);
            } else {
                this.O.a(new RunnableC0095c(((JSONArray) O.second).toString(), ((Long) ((Pair) O.first).first).longValue(), ((Long) ((Pair) O.first).second).longValue()));
            }
        } catch (CursorWindowAllocationException e2) {
            this.K.set(false);
            a.b("com.amplitude.api.AmplitudeClient", String.format("Caught Cursor window exception during event upload, deferring upload: %s", e2.getMessage()));
            com.amplitude.api.i.d().f("Failed to update server", e2);
        } catch (JSONException e3) {
            this.K.set(false);
            a.b("com.amplitude.api.AmplitudeClient", e3.toString());
            com.amplitude.api.i.d().f("Failed to update server", e3);
        }
    }

    protected String s(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            cArr2[i4] = cArr[i3 >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
        }
        return new String(cArr2);
    }

    protected synchronized boolean t(String str) {
        if (this.f3509b == null) {
            com.amplitude.api.d dVar = a;
            dVar.b("com.amplitude.api.AmplitudeClient", "context cannot be null, set context with initialize() before calling " + str);
            return false;
        } else if (l.b(this.f3512e)) {
            com.amplitude.api.d dVar2 = a;
            dVar2.b("com.amplitude.api.AmplitudeClient", "apiKey cannot be null or empty, set apiKey with initialize() before calling " + str);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0() {
        this.F = true;
    }

    public c u(Application application) {
        if (!this.F && t("enableForegroundTracking()") && Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(new com.amplitude.api.b(this));
        }
        return this;
    }

    protected boolean u0(String str) {
        if (l.b(str)) {
            a.b("com.amplitude.api.AmplitudeClient", "Argument eventType cannot be null or blank in logEvent()");
            return false;
        }
        return t("logEvent()");
    }

    protected long v() {
        return System.currentTimeMillis();
    }

    long y() {
        long j2 = this.r + 1;
        this.r = j2;
        this.f3511d.o0("sequence_number", Long.valueOf(j2));
        return this.r;
    }

    public void z(j jVar) {
        A(jVar, false);
    }

    public c(String str) {
        this.f3516i = false;
        this.f3517j = false;
        this.f3518k = false;
        this.f3519l = false;
        this.m = false;
        this.n = new k();
        this.q = -1L;
        this.r = 0L;
        this.s = -1L;
        this.t = -1L;
        this.u = -1L;
        this.v = -1L;
        this.x = 30;
        this.y = 50;
        this.z = RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
        this.A = 30000L;
        this.B = 300000L;
        this.C = 1800000L;
        this.D = false;
        this.E = 50;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = true;
        this.J = new AtomicBoolean(false);
        this.K = new AtomicBoolean(false);
        this.M = "https://api.amplitude.com/";
        this.N = new m("logThread");
        this.O = new m("httpThread");
        this.f3513f = l.c(str);
        this.N.start();
        this.O.start();
    }
}