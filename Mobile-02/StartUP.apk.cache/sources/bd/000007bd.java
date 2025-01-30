package com.bugsnag.android;

import android.text.TextUtils;
import com.bugsnag.android.NativeInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Configuration.java */
/* loaded from: classes.dex */
public class s extends Observable implements Observer {
    private String C;
    private String D;
    private z E;
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private String f3698b;

    /* renamed from: c  reason: collision with root package name */
    private String f3699c;

    /* renamed from: d  reason: collision with root package name */
    private String f3700d;

    /* renamed from: g  reason: collision with root package name */
    private String[] f3703g;

    /* renamed from: j  reason: collision with root package name */
    private String[] f3705j;

    /* renamed from: k  reason: collision with root package name */
    private String f3706k;
    private boolean v;
    private s0 x;

    /* renamed from: e  reason: collision with root package name */
    private volatile String f3701e = "https://notify.bugsnag.com";

    /* renamed from: f  reason: collision with root package name */
    private volatile String f3702f = "https://sessions.bugsnag.com";

    /* renamed from: h  reason: collision with root package name */
    private String[] f3704h = null;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3707l = true;
    private boolean m = true;
    private boolean n = false;
    private long p = 5000;
    private boolean q = true;
    private boolean t = true;
    private boolean u = false;
    private long w = 5000;
    private final Collection<f> y = new ConcurrentLinkedQueue();
    private final Collection<h> z = new ConcurrentLinkedQueue();
    private final Collection<g> A = new ConcurrentLinkedQueue();
    private final Collection<i> B = new ConcurrentLinkedQueue();
    private int F = 32;

    public s(String str) {
        this.a = str;
        s0 s0Var = new s0();
        this.x = s0Var;
        s0Var.addObserver(this);
        try {
            this.v = Class.forName("com.bugsnag.android.n").getDeclaredField("DETECT_NDK_CRASHES").getBoolean(null);
        } catch (Throwable unused) {
            this.v = false;
        }
    }

    public Map<String, String> A() {
        HashMap hashMap = new HashMap();
        hashMap.put("Bugsnag-Payload-Version", "1.0");
        hashMap.put("Bugsnag-Api-Key", this.a);
        hashMap.put("Bugsnag-Sent-At", x.b(new Date()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<i> B() {
        return this.B;
    }

    public String C() {
        return this.f3702f;
    }

    public boolean D() {
        return this.t;
    }

    public void E(String str) {
        this.f3699c = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_APP_VERSION, str));
    }

    public void F(boolean z) {
        this.q = z;
    }

    public void G(boolean z) {
        this.t = z;
    }

    public void H(String str) {
        this.f3698b = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_BUILD_UUID, str));
    }

    public void I(String str) {
        this.f3700d = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_CONTEXT, str));
    }

    public void J(z zVar) {
        if (zVar != null) {
            this.E = zVar;
            return;
        }
        throw new IllegalArgumentException("Delivery cannot be null");
    }

    public void K(boolean z) {
        this.u = z;
    }

    public void L(boolean z) {
        this.v = z;
    }

    public void M(boolean z) {
        this.m = z;
    }

    @Deprecated
    public void N(String str) {
        this.f3701e = str;
    }

    public void O(String str, String str2) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str)) {
            this.f3701e = str;
            if (TextUtils.isEmpty(str2)) {
                q0.d("The session tracking endpoint has not been set. Session tracking is disabled");
                this.f3702f = null;
                this.q = false;
                return;
            }
            this.f3702f = str2;
            return;
        }
        throw new IllegalArgumentException("Notify endpoint cannot be empty or null.");
    }

    public void P(String[] strArr) {
        this.f3703g = strArr;
    }

    public void Q(String[] strArr) {
        this.f3704h = strArr;
    }

    public void R(boolean z) {
        this.n = z;
    }

    public void S(String[] strArr) {
        this.f3705j = strArr;
    }

    public void T(String str) {
        this.f3706k = str;
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_RELEASE_STAGE, str));
    }

    public void U(boolean z) {
        this.f3707l = z;
    }

    @Deprecated
    public void V(String str) {
        this.f3702f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean W(String str) {
        String[] strArr = this.f3703g;
        if (strArr == null) {
            return false;
        }
        return Arrays.asList(strArr).contains(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean X(String str) {
        String[] strArr = this.f3704h;
        if (strArr == null) {
            return true;
        }
        return Arrays.asList(strArr).contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        this.B.add(iVar);
    }

    public void b(h hVar) {
        if (this.z.contains(hVar)) {
            return;
        }
        this.z.add(hVar);
    }

    public String c() {
        return this.a;
    }

    public String d() {
        return this.f3699c;
    }

    public boolean e() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<f> f() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<g> g() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<h> h() {
        return this.z;
    }

    public String i() {
        return this.f3698b;
    }

    public String j() {
        return this.C;
    }

    public String k() {
        return this.f3700d;
    }

    public z l() {
        return this.E;
    }

    public boolean m() {
        return this.u;
    }

    public boolean n() {
        return this.v;
    }

    public boolean o() {
        return this.m;
    }

    public String p() {
        return this.f3701e;
    }

    public Map<String, String> q() {
        HashMap hashMap = new HashMap();
        hashMap.put("Bugsnag-Payload-Version", "4.0");
        hashMap.put("Bugsnag-Api-Key", this.a);
        hashMap.put("Bugsnag-Sent-At", x.b(new Date()));
        return hashMap;
    }

    public long r() {
        return this.p;
    }

    public int s() {
        return this.F;
    }

    public s0 t() {
        return this.x;
    }

    public String u() {
        return this.D;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof NativeInterface.b) {
            setChanged();
            notifyObservers(obj);
        }
    }

    public String[] v() {
        return this.f3704h;
    }

    public boolean w() {
        return this.n;
    }

    public String[] x() {
        return this.f3705j;
    }

    public String y() {
        return this.f3706k;
    }

    public boolean z() {
        return this.f3707l;
    }
}