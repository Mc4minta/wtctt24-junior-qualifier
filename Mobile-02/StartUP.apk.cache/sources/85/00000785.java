package com.bugsnag.android;

import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Error.java */
/* loaded from: classes.dex */
public class c0 implements o0.a {

    /* renamed from: d  reason: collision with root package name */
    private Severity f3620d;

    /* renamed from: f  reason: collision with root package name */
    private String f3622f;

    /* renamed from: g  reason: collision with root package name */
    private String f3623g;

    /* renamed from: h  reason: collision with root package name */
    final s f3624h;

    /* renamed from: j  reason: collision with root package name */
    private String[] f3625j;

    /* renamed from: k  reason: collision with root package name */
    private final h0 f3626k;

    /* renamed from: l  reason: collision with root package name */
    private Breadcrumbs f3627l;
    private final k m;
    private final k0 n;
    private final w0 p;
    private final c1 q;
    private Map<String, Object> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f3618b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private d1 f3619c = new d1();

    /* renamed from: e  reason: collision with root package name */
    private s0 f3621e = new s0();
    private boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(s sVar, Throwable th, k0 k0Var, Severity severity, w0 w0Var, c1 c1Var) {
        this.q = c1Var;
        this.f3624h = sVar;
        if (th instanceof k) {
            this.m = (k) th;
        } else {
            this.m = new k(th);
        }
        this.n = k0Var;
        this.f3620d = severity;
        this.p = w0Var;
        this.f3625j = sVar.x();
        this.f3626k = new h0(sVar, this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> a() {
        return this.a;
    }

    public String b() {
        return this.f3623g;
    }

    public Map<String, Object> c() {
        return this.f3618b;
    }

    public String d() {
        String message = this.m.getMessage();
        return message != null ? message : "";
    }

    public String e() {
        return this.m.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0 f() {
        return this.f3626k;
    }

    public k0 g() {
        return this.n;
    }

    public s0 h() {
        return this.f3621e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0 i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Map<String, Object> map) {
        this.a = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Breadcrumbs breadcrumbs) {
        this.f3627l = breadcrumbs;
    }

    public void l(String str) {
        this.f3623g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Map<String, Object> map) {
        this.f3618b = map;
    }

    public void n(String str) {
        this.m.c(str);
    }

    public void o(String str) {
        this.f3622f = str;
    }

    public void p(s0 s0Var) {
        if (s0Var == null) {
            this.f3621e = new s0();
        } else {
            this.f3621e = s0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String[] strArr) {
        this.f3625j = strArr;
        h0 h0Var = this.f3626k;
        if (h0Var != null) {
            h0Var.f(strArr);
        }
    }

    public void r(Severity severity) {
        if (severity != null) {
            this.f3620d = severity;
            this.n.d(severity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(d1 d1Var) {
        this.f3619c = d1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.f3624h.W(e());
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        s0 d2 = s0.d(this.f3624h.t(), this.f3621e);
        o0Var.d();
        o0Var.j("context").d0(this.f3623g);
        o0Var.j("metaData").n0(d2);
        o0Var.j("severity").n0(this.f3620d);
        o0Var.j("severityReason").n0(this.n);
        o0Var.j("unhandled").e0(this.n.b());
        o0Var.j("incomplete").e0(this.t);
        if (this.f3625j != null) {
            o0Var.j("projectPackages").c();
            for (String str : this.f3625j) {
                o0Var.d0(str);
            }
            o0Var.f();
        }
        o0Var.j("exceptions").n0(this.f3626k);
        o0Var.j(ApiConstants.USER).n0(this.f3619c);
        o0Var.j("app").r0(this.a);
        o0Var.j("device").r0(this.f3618b);
        o0Var.j("breadcrumbs").n0(this.f3627l);
        o0Var.j("groupingHash").d0(this.f3622f);
        if (this.f3624h.z()) {
            o0Var.j("threads").n0(this.q);
        }
        if (this.p != null) {
            o0Var.j("session").d();
            o0Var.j("id").d0(this.p.c());
            o0Var.j("startedAt").d0(x.b(this.p.d()));
            o0Var.j("events").d();
            o0Var.j("handled").O(this.p.b());
            o0Var.j("unhandled").O(this.p.e());
            o0Var.g();
            o0Var.g();
        }
        o0Var.g();
    }

    /* compiled from: Error.java */
    /* loaded from: classes.dex */
    static class a {
        private final s a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f3628b;

        /* renamed from: c  reason: collision with root package name */
        private final y0 f3629c;

        /* renamed from: d  reason: collision with root package name */
        private final c1 f3630d;

        /* renamed from: e  reason: collision with root package name */
        private Severity f3631e;

        /* renamed from: f  reason: collision with root package name */
        private s0 f3632f;

        /* renamed from: g  reason: collision with root package name */
        private String f3633g;

        /* renamed from: h  reason: collision with root package name */
        private String f3634h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(s sVar, Throwable th, y0 y0Var, Thread thread, boolean z) {
            this.f3631e = Severity.WARNING;
            this.f3630d = new c1(sVar, thread, Thread.getAllStackTraces(), z ? th : null);
            this.a = sVar;
            this.f3628b = th;
            this.f3634h = "userSpecifiedSeverity";
            this.f3629c = y0Var;
        }

        private w0 c(k0 k0Var) {
            w0 d2;
            y0 y0Var = this.f3629c;
            if (y0Var == null || (d2 = y0Var.d()) == null) {
                return null;
            }
            if (this.a.e() || !d2.h()) {
                if (k0Var.b()) {
                    return this.f3629c.h();
                }
                return this.f3629c.g();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            this.f3633g = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c0 b() {
            k0 c2 = k0.c(this.f3634h, this.f3631e, this.f3633g);
            c0 c0Var = new c0(this.a, this.f3628b, c2, this.f3631e, c(c2), this.f3630d);
            s0 s0Var = this.f3632f;
            if (s0Var != null) {
                c0Var.p(s0Var);
            }
            return c0Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a d(s0 s0Var) {
            this.f3632f = s0Var;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a e(Severity severity) {
            this.f3631e = severity;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a f(String str) {
            this.f3634h = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(s sVar, String str, String str2, StackTraceElement[] stackTraceElementArr, y0 y0Var, Thread thread) {
            this(sVar, new k(str, str2, stackTraceElementArr), y0Var, thread, false);
        }
    }
}