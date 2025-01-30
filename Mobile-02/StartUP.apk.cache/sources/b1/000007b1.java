package com.bugsnag.android;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.c0;
import com.bugsnag.android.e0;
import com.coinbase.ApiConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Client.java */
/* loaded from: classes.dex */
public class q extends Observable implements Observer {
    protected final s a;

    /* renamed from: b  reason: collision with root package name */
    final Context f3684b;

    /* renamed from: c  reason: collision with root package name */
    protected final b0 f3685c;

    /* renamed from: d  reason: collision with root package name */
    protected final com.bugsnag.android.c f3686d;

    /* renamed from: e  reason: collision with root package name */
    final Breadcrumbs f3687e;

    /* renamed from: f  reason: collision with root package name */
    private final d1 f3688f;

    /* renamed from: g  reason: collision with root package name */
    protected final e0 f3689g;

    /* renamed from: h  reason: collision with root package name */
    final x0 f3690h;

    /* renamed from: j  reason: collision with root package name */
    final f0 f3691j;

    /* renamed from: k  reason: collision with root package name */
    final y0 f3692k;

    /* renamed from: l  reason: collision with root package name */
    final SharedPreferences f3693l;
    private final OrientationEventListener m;
    private final t n;

    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    class a implements kotlin.e0.c.l<Boolean, kotlin.x> {
        a() {
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public kotlin.x invoke(Boolean bool) {
            if (bool.booleanValue()) {
                q.this.f3689g.i();
                return null;
            }
            return null;
        }
    }

    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    class b implements e0.d {
        b() {
        }

        @Override // com.bugsnag.android.e0.d
        public void a(Exception exc, File file) {
            c0 b2 = new c0.a(q.this.a, exc, null, Thread.currentThread(), true).b();
            b2.l("Crash Report Deserialization");
            s0 h2 = b2.h();
            h2.a("BugsnagDiagnostics", "filename", file.getName());
            h2.a("BugsnagDiagnostics", "fileLength", Long.valueOf(file.length()));
            q.this.z(b2);
        }
    }

    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar = q.this;
            qVar.f3684b.registerReceiver(qVar.f3691j, f0.b());
        }
    }

    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    class d extends OrientationEventListener {
        final /* synthetic */ q a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context, q qVar) {
            super(context);
            this.a = qVar;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            this.a.setChanged();
            this.a.notifyObservers(new NativeInterface.b(NativeInterface.c.UPDATE_ORIENTATION, Integer.valueOf(i2)));
        }
    }

    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        final /* synthetic */ v0 a;

        f(v0 v0Var) {
            this.a = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                z l2 = q.this.a.l();
                if (l2 instanceof y) {
                    Map<String, String> q = q.this.a.q();
                    q.put("Bugsnag-Internal-Error", "true");
                    q.remove("Bugsnag-Api-Key");
                    ((y) l2).c(q.this.a.p(), this.a, q);
                }
            } catch (Exception e2) {
                q0.e("Failed to report internal error to Bugsnag", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        final /* synthetic */ v0 a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c0 f3696b;

        g(v0 v0Var, c0 c0Var) {
            this.a = v0Var;
            this.f3696b = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.f(this.a, this.f3696b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Client.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class h {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a0.values().length];
            a = iArr;
            try {
                iArr[a0.SAME_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a0.NO_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a0.ASYNC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a0.ASYNC_WITH_CACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public q(Context context, s sVar) {
        d1 d1Var = new d1();
        this.f3688f = d1Var;
        U(context);
        Context applicationContext = context.getApplicationContext();
        this.f3684b = applicationContext;
        this.a = sVar;
        x0 x0Var = new x0(sVar, applicationContext);
        this.f3690h = x0Var;
        v vVar = new v(applicationContext, new a());
        this.n = vVar;
        if (sVar.l() == null) {
            sVar.J(new y(vVar));
        }
        y0 y0Var = new y0(sVar, this, x0Var);
        this.f3692k = y0Var;
        this.f3691j = new f0(this);
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.bugsnag.android", 0);
        this.f3693l = sharedPreferences;
        this.f3686d = new com.bugsnag.android.c(applicationContext, applicationContext.getPackageManager(), sVar, y0Var);
        b0 b0Var = new b0(vVar, applicationContext, applicationContext.getResources(), sharedPreferences);
        this.f3685c = b0Var;
        this.f3687e = new Breadcrumbs(sVar);
        if (sVar.x() == null) {
            L(applicationContext.getPackageName());
        }
        String j2 = b0Var.j();
        String str = null;
        if (sVar.w()) {
            d1Var.e(sharedPreferences.getString("user.id", j2));
            d1Var.f(sharedPreferences.getString("user.name", null));
            d1Var.d(sharedPreferences.getString("user.email", null));
        } else {
            d1Var.e(j2);
        }
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(y0Var);
        } else {
            q0.d("Bugsnag is unable to setup automatic activity lifecycle breadcrumbs on API Levels below 14.");
        }
        if (sVar.i() == null) {
            try {
                str = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getString("com.bugsnag.android.BUILD_UUID");
            } catch (Exception unused) {
                q0.d("Bugsnag is unable to read build UUID from manifest.");
            }
            if (str != null) {
                this.a.H(str);
            }
        }
        this.f3689g = new e0(this.a, this.f3684b, new b());
        if (this.a.o()) {
            i();
        }
        try {
            com.bugsnag.android.e.a(new c());
        } catch (RejectedExecutionException e2) {
            q0.e("Failed to register for automatic breadcrumb broadcasts", e2);
        }
        this.n.a();
        q0.c(!"production".equals(this.f3686d.l()));
        this.a.addObserver(this);
        this.f3687e.addObserver(this);
        this.f3692k.addObserver(this);
        this.f3688f.addObserver(this);
        d dVar = new d(this.f3684b, this);
        this.m = dVar;
        try {
            dVar.enable();
        } catch (IllegalStateException e3) {
            q0.d("Failed to set up orientation tracking: " + e3);
        }
        this.f3689g.k();
        w();
    }

    private boolean B(Breadcrumb breadcrumb) {
        for (com.bugsnag.android.g gVar : this.a.g()) {
            try {
            } catch (Throwable th) {
                q0.e("BeforeRecordBreadcrumb threw an Exception", th);
            }
            if (!gVar.a(breadcrumb)) {
                return false;
            }
        }
        return true;
    }

    private boolean C(c0 c0Var) {
        for (com.bugsnag.android.f fVar : this.a.f()) {
            try {
            } catch (Throwable th) {
                q0.e("BeforeNotify threw an Exception", th);
            }
            if (!fVar.a(c0Var)) {
                return false;
            }
        }
        return true;
    }

    private boolean D(v0 v0Var) {
        for (com.bugsnag.android.h hVar : this.a.h()) {
            try {
            } catch (Throwable th) {
                q0.e("BeforeSend threw an Exception", th);
            }
            if (!hVar.a(v0Var)) {
                return false;
            }
        }
        return true;
    }

    private void T(String str, String str2) {
        this.f3684b.getSharedPreferences("com.bugsnag.android", 0).edit().putString(str, str2).apply();
    }

    private static void U(Context context) {
        if (context instanceof Application) {
            return;
        }
        q0.d("Warning - Non-Application context detected! Please ensure that you are initializing Bugsnag from a custom Application class.");
    }

    private void g(c0 c0Var, v0 v0Var) {
        try {
            com.bugsnag.android.e.a(new g(v0Var, c0Var));
        } catch (RejectedExecutionException unused) {
            this.f3689g.g(c0Var);
            q0.d("Exceeded max queue count, saving to disk to send later");
        }
    }

    private String p(Map<String, Object> map, String str, boolean z) {
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (z) {
            throw new IllegalStateException("Failed to set " + str + " in client data!");
        }
        return null;
    }

    private void v(c0 c0Var) {
        this.f3687e.add(new Breadcrumb(c0Var.e(), BreadcrumbType.ERROR, Collections.singletonMap(ApiConstants.MESSAGE, c0Var.d())));
    }

    private void w() {
        NativeInterface.setClient(this);
        m mVar = m.f3667b;
        if (this.a.n()) {
            try {
                mVar.c(Class.forName("com.bugsnag.android.NdkPlugin"));
            } catch (ClassNotFoundException unused) {
                q0.d("bugsnag-plugin-android-ndk artefact not found on classpath, NDK errors will not be captured.");
            }
        }
        if (this.a.m()) {
            try {
                mVar.c(Class.forName("com.bugsnag.android.AnrPlugin"));
            } catch (ClassNotFoundException unused2) {
                q0.d("bugsnag-plugin-android-anr artefact not found on classpath, ANR errors will not be captured.");
            }
        }
        mVar.b(this);
    }

    public final boolean A() {
        return this.f3692k.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        setChanged();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        super.notifyObservers(new NativeInterface.b(NativeInterface.c.INSTALL, arrayList));
        try {
            com.bugsnag.android.e.a(new e());
        } catch (RejectedExecutionException e2) {
            q0.e("Failed to enqueue native reports, will retry next launch: ", e2);
        }
    }

    public void F(String str) {
        this.a.E(str);
    }

    public void G(boolean z) {
        this.a.F(z);
        if (z) {
            this.f3692k.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str) {
        k().n(str);
    }

    public void I(String str) {
        this.a.I(str);
    }

    public void J(String... strArr) {
        this.a.P(strArr);
    }

    public void K(String... strArr) {
        this.a.Q(strArr);
    }

    @Deprecated
    public void L(String... strArr) {
        this.a.S(strArr);
    }

    public void M(String str) {
        this.a.T(str);
        q0.c(!"production".equals(str));
    }

    public void N(String str, String str2, String str3) {
        P(str);
        O(str2);
        Q(str3);
    }

    public void O(String str) {
        this.f3688f.d(str);
        if (this.a.w()) {
            T("user.email", str);
        }
    }

    public void P(String str) {
        this.f3688f.e(str);
        if (this.a.w()) {
            T("user.id", str);
        }
    }

    public void Q(String str) {
        this.f3688f.f(str);
        if (this.a.w()) {
            T("user.name", str);
        }
    }

    public void R() {
        this.f3692k.r(false);
    }

    public final void S() {
        this.f3692k.s();
    }

    public void b(String str, String str2, Object obj) {
        this.a.t().a(str, str2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Throwable th, Severity severity, s0 s0Var, String str, String str2, Thread thread) {
        x(new c0.a(this.a, th, this.f3692k, thread, true).e(severity).d(s0Var).f(str).a(str2).b(), a0.ASYNC_WITH_CACHE, null);
    }

    public void d(String str) {
        this.a.t().b(str);
    }

    public void e() {
        this.f3688f.e(r0.a("id", this.f3685c.g()));
        this.f3688f.d(null);
        this.f3688f.f(null);
        this.f3684b.getSharedPreferences("com.bugsnag.android", 0).edit().remove("user.id").remove("user.email").remove("user.name").apply();
    }

    void f(v0 v0Var, c0 c0Var) {
        if (!D(v0Var)) {
            q0.b("Skipping notification - beforeSend task returned false");
            return;
        }
        try {
            this.a.l().a(v0Var, this.a);
            q0.b("Sent 1 new error to Bugsnag");
            v(c0Var);
        } catch (DeliveryFailureException e2) {
            if (v0Var.c()) {
                return;
            }
            q0.e("Could not send error(s) to Bugsnag, saving to disk to send later", e2);
            this.f3689g.g(c0Var);
            v(c0Var);
        } catch (Exception e3) {
            q0.e("Problem sending error to Bugsnag", e3);
        }
    }

    protected void finalize() throws Throwable {
        f0 f0Var = this.f3691j;
        if (f0Var != null) {
            try {
                this.f3684b.unregisterReceiver(f0Var);
            } catch (IllegalArgumentException unused) {
                q0.d("Receiver not registered");
            }
        }
        super.finalize();
    }

    public void h() {
        g0.a(this);
    }

    public void i() {
        g0.b(this);
    }

    void j() {
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.DELIVER_PENDING, null));
    }

    public com.bugsnag.android.c k() {
        return this.f3686d;
    }

    public s l() {
        return this.a;
    }

    public String m() {
        return this.a.k();
    }

    public b0 n() {
        return this.f3685c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0 o() {
        return this.f3689g;
    }

    public s0 q() {
        return this.a.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0 r() {
        return this.f3692k;
    }

    public d1 s() {
        return this.f3688f;
    }

    public void t(Throwable th, Map<String, Object> map, boolean z, p pVar) {
        String p = p(map, "severity", true);
        String p2 = p(map, "severityReason", true);
        String p3 = p(map, "logLevel", false);
        q0.b(String.format("Internal client notify, severity = '%s', severityReason = '%s'", p, p2));
        x(new c0.a(this.a, th, this.f3692k, Thread.currentThread(), false).e(Severity.fromString(p)).f(p2).a(p3).b(), z ? a0.SAME_THREAD : a0.ASYNC, pVar);
    }

    public void u(String str, BreadcrumbType breadcrumbType, Map<String, String> map) {
        Breadcrumb breadcrumb = new Breadcrumb(str, breadcrumbType, map);
        if (B(breadcrumb)) {
            this.f3687e.add(breadcrumb);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof NativeInterface.b) {
            setChanged();
            super.notifyObservers(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(c0 c0Var, a0 a0Var, p pVar) {
        if (c0Var.t()) {
            return;
        }
        Map<String, Object> f2 = this.f3686d.f();
        if (this.a.X(r0.a("releaseStage", f2))) {
            c0Var.m(this.f3685c.g());
            c0Var.h().a.put("device", this.f3685c.i());
            c0Var.j(f2);
            c0Var.h().a.put("app", this.f3686d.g());
            c0Var.k(this.f3687e);
            c0Var.s(this.f3688f);
            if (TextUtils.isEmpty(c0Var.b())) {
                String k2 = this.a.k();
                if (k2 == null) {
                    k2 = this.f3686d.e();
                }
                c0Var.l(k2);
            }
            if (!C(c0Var)) {
                q0.b("Skipping notification - beforeNotify task returned false");
                return;
            }
            v0 v0Var = new v0(this.a.c(), c0Var);
            if (pVar != null) {
                pVar.a(v0Var);
            }
            if (c0Var.i() != null) {
                setChanged();
                if (c0Var.g().b()) {
                    notifyObservers(new NativeInterface.b(NativeInterface.c.NOTIFY_UNHANDLED, null));
                } else {
                    notifyObservers(new NativeInterface.b(NativeInterface.c.NOTIFY_HANDLED, c0Var.e()));
                }
            }
            int i2 = h.a[a0Var.ordinal()];
            if (i2 == 1) {
                f(v0Var, c0Var);
            } else if (i2 == 2) {
                v0Var.d(true);
                g(c0Var, v0Var);
            } else if (i2 == 3) {
                g(c0Var, v0Var);
            } else if (i2 != 4) {
            } else {
                this.f3689g.g(c0Var);
                this.f3689g.i();
            }
        }
    }

    public void y(String str, String str2, StackTraceElement[] stackTraceElementArr, p pVar) {
        x(new c0.a(this.a, str, str2, stackTraceElementArr, this.f3692k, Thread.currentThread()).f("handledException").b(), a0.ASYNC, pVar);
    }

    void z(c0 c0Var) {
        c0Var.j(this.f3686d.h());
        c0Var.m(this.f3685c.h());
        s0 h2 = c0Var.h();
        t0 a2 = t0.a();
        h2.a("BugsnagDiagnostics", "notifierName", a2.b());
        h2.a("BugsnagDiagnostics", "notifierVersion", a2.c());
        h2.a("BugsnagDiagnostics", "apiKey", this.a.c());
        h2.a("BugsnagDiagnostics", "packageName", this.f3686d.f().get("packageName"));
        try {
            com.bugsnag.android.e.a(new f(new v0(null, c0Var)));
        } catch (RejectedExecutionException unused) {
        }
    }
}