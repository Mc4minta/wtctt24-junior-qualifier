package e.f.h.c;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import e.f.d.c.h;
import e.f.d.c.i;
import e.f.h.b.a;
import e.f.h.b.b;
import e.f.h.g.a;
import java.util.concurrent.Executor;

/* compiled from: AbstractDraweeController.java */
/* loaded from: classes2.dex */
public abstract class a<T, INFO> implements e.f.h.h.a, a.b, a.InterfaceC0269a {
    private static final Class<?> a = a.class;

    /* renamed from: c  reason: collision with root package name */
    private final e.f.h.b.a f12202c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f12203d;

    /* renamed from: e  reason: collision with root package name */
    private e.f.h.b.c f12204e;

    /* renamed from: f  reason: collision with root package name */
    private e.f.h.g.a f12205f;

    /* renamed from: g  reason: collision with root package name */
    private e f12206g;

    /* renamed from: h  reason: collision with root package name */
    protected d<INFO> f12207h;

    /* renamed from: i  reason: collision with root package name */
    private e.f.h.h.c f12208i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f12209j;

    /* renamed from: k  reason: collision with root package name */
    private String f12210k;

    /* renamed from: l  reason: collision with root package name */
    private Object f12211l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private e.f.e.c<T> s;
    private T t;
    private Drawable u;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.h.b.b f12201b = e.f.h.b.b.a();
    private boolean v = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractDraweeController.java */
    /* renamed from: e.f.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0266a extends e.f.e.b<T> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12212b;

        C0266a(String str, boolean z) {
            this.a = str;
            this.f12212b = z;
        }

        @Override // e.f.e.b, e.f.e.e
        public void d(e.f.e.c<T> cVar) {
            boolean b2 = cVar.b();
            a.this.F(this.a, cVar, cVar.d(), b2);
        }

        @Override // e.f.e.b
        public void e(e.f.e.c<T> cVar) {
            a.this.C(this.a, cVar, cVar.c(), true);
        }

        @Override // e.f.e.b
        public void f(e.f.e.c<T> cVar) {
            boolean b2 = cVar.b();
            boolean e2 = cVar.e();
            float d2 = cVar.d();
            T f2 = cVar.f();
            if (f2 != null) {
                a.this.E(this.a, cVar, f2, d2, b2, this.f12212b, e2);
            } else if (b2) {
                a.this.C(this.a, cVar, new NullPointerException(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractDraweeController.java */
    /* loaded from: classes2.dex */
    public static class b<INFO> extends f<INFO> {
        private b() {
        }

        public static <INFO> b<INFO> k(d<? super INFO> dVar, d<? super INFO> dVar2) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("AbstractDraweeController#createInternal");
            }
            b<INFO> bVar = new b<>();
            bVar.g(dVar);
            bVar.g(dVar2);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return bVar;
        }
    }

    public a(e.f.h.b.a aVar, Executor executor, String str, Object obj) {
        this.f12202c = aVar;
        this.f12203d = executor;
        x(str, obj);
    }

    private void A(String str, Throwable th) {
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.t(a, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f12210k, str, th);
        }
    }

    private void B(String str, T t) {
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.u(a, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.f12210k, str, t(t), Integer.valueOf(u(t)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, e.f.e.c<T> cVar, Throwable th, boolean z) {
        Drawable drawable;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractDraweeController#onFailureInternal");
        }
        if (!z(str, cVar)) {
            A("ignore_old_datasource @ onFailure", th);
            cVar.close();
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
                return;
            }
            return;
        }
        this.f12201b.b(z ? b.a.ON_DATASOURCE_FAILURE : b.a.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            A("final_failed @ onFailure", th);
            this.s = null;
            this.p = true;
            if (this.q && (drawable = this.u) != null) {
                this.f12208i.f(drawable, 1.0f, true);
            } else if (Q()) {
                this.f12208i.b(th);
            } else {
                this.f12208i.c(th);
            }
            o().c(this.f12210k, th);
        } else {
            A("intermediate_failed @ onFailure", th);
            o().f(this.f12210k, th);
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, e.f.e.c<T> cVar, T t, float f2, boolean z, boolean z2, boolean z3) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("AbstractDraweeController#onNewResultInternal");
            }
            if (!z(str, cVar)) {
                B("ignore_old_datasource @ onNewResult", t);
                I(t);
                cVar.close();
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                    return;
                }
                return;
            }
            this.f12201b.b(z ? b.a.ON_DATASOURCE_RESULT : b.a.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable l2 = l(t);
                T t2 = this.t;
                Drawable drawable = this.u;
                this.t = t;
                this.u = l2;
                if (z) {
                    B("set_final_result @ onNewResult", t);
                    this.s = null;
                    this.f12208i.f(l2, 1.0f, z2);
                    o().b(str, v(t), m());
                } else if (z3) {
                    B("set_temporary_result @ onNewResult", t);
                    this.f12208i.f(l2, 1.0f, z2);
                    o().b(str, v(t), m());
                } else {
                    B("set_intermediate_result @ onNewResult", t);
                    this.f12208i.f(l2, f2, z2);
                    o().a(str, v(t));
                }
                if (drawable != null && drawable != l2) {
                    G(drawable);
                }
                if (t2 != null && t2 != t) {
                    B("release_previous_result @ onNewResult", t2);
                    I(t2);
                }
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            } catch (Exception e2) {
                B("drawable_failed @ onNewResult", t);
                I(t);
                C(str, cVar, e2, z);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        } catch (Throwable th) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, e.f.e.c<T> cVar, float f2, boolean z) {
        if (!z(str, cVar)) {
            A("ignore_old_datasource @ onProgress", null);
            cVar.close();
        } else if (z) {
        } else {
            this.f12208i.d(f2, false);
        }
    }

    private void H() {
        boolean z = this.n;
        this.n = false;
        this.p = false;
        e.f.e.c<T> cVar = this.s;
        if (cVar != null) {
            cVar.close();
            this.s = null;
        }
        Drawable drawable = this.u;
        if (drawable != null) {
            G(drawable);
        }
        if (this.r != null) {
            this.r = null;
        }
        this.u = null;
        T t = this.t;
        if (t != null) {
            B("release", t);
            I(this.t);
            this.t = null;
        }
        if (z) {
            o().d(this.f12210k);
        }
    }

    private boolean Q() {
        e.f.h.b.c cVar;
        return this.p && (cVar = this.f12204e) != null && cVar.e();
    }

    private synchronized void x(String str, Object obj) {
        e.f.h.b.a aVar;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractDraweeController#init");
        }
        this.f12201b.b(b.a.ON_INIT_CONTROLLER);
        if (!this.v && (aVar = this.f12202c) != null) {
            aVar.c(this);
        }
        this.m = false;
        this.o = false;
        H();
        this.q = false;
        e.f.h.b.c cVar = this.f12204e;
        if (cVar != null) {
            cVar.a();
        }
        e.f.h.g.a aVar2 = this.f12205f;
        if (aVar2 != null) {
            aVar2.a();
            this.f12205f.f(this);
        }
        d<INFO> dVar = this.f12207h;
        if (dVar instanceof b) {
            ((b) dVar).h();
        } else {
            this.f12207h = null;
        }
        this.f12206g = null;
        e.f.h.h.c cVar2 = this.f12208i;
        if (cVar2 != null) {
            cVar2.reset();
            this.f12208i.a(null);
            this.f12208i = null;
        }
        this.f12209j = null;
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.s(a, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f12210k, str);
        }
        this.f12210k = str;
        this.f12211l = obj;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    private boolean z(String str, e.f.e.c<T> cVar) {
        if (cVar == null && this.s == null) {
            return true;
        }
        return str.equals(this.f12210k) && cVar == this.s && this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(String str, T t) {
    }

    protected abstract void G(Drawable drawable);

    protected abstract void I(T t);

    public void J(d<? super INFO> dVar) {
        i.g(dVar);
        d<INFO> dVar2 = this.f12207h;
        if (dVar2 instanceof b) {
            ((b) dVar2).j(dVar);
        } else if (dVar2 == dVar) {
            this.f12207h = null;
        }
    }

    public void K(String str) {
        this.r = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(Drawable drawable) {
        this.f12209j = drawable;
        e.f.h.h.c cVar = this.f12208i;
        if (cVar != null) {
            cVar.a(drawable);
        }
    }

    public void M(e eVar) {
        this.f12206g = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(e.f.h.g.a aVar) {
        this.f12205f = aVar;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(boolean z) {
        this.q = z;
    }

    protected boolean P() {
        return Q();
    }

    protected void R() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractDraweeController#submitRequest");
        }
        T n = n();
        if (n != null) {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("AbstractDraweeController#submitRequest->cache");
            }
            this.s = null;
            this.n = true;
            this.p = false;
            this.f12201b.b(b.a.ON_SUBMIT_CACHE_HIT);
            o().e(this.f12210k, this.f12211l);
            D(this.f12210k, n);
            E(this.f12210k, this.s, n, 1.0f, true, true, true);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
                return;
            }
            return;
        }
        this.f12201b.b(b.a.ON_DATASOURCE_SUBMIT);
        o().e(this.f12210k, this.f12211l);
        this.f12208i.d(0.0f, true);
        this.n = true;
        this.p = false;
        this.s = q();
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.s(a, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f12210k, Integer.valueOf(System.identityHashCode(this.s)));
        }
        this.s.g(new C0266a(this.f12210k, this.s.a()), this.f12203d);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    @Override // e.f.h.b.a.b
    public void a() {
        this.f12201b.b(b.a.ON_RELEASE_CONTROLLER);
        e.f.h.b.c cVar = this.f12204e;
        if (cVar != null) {
            cVar.c();
        }
        e.f.h.g.a aVar = this.f12205f;
        if (aVar != null) {
            aVar.e();
        }
        e.f.h.h.c cVar2 = this.f12208i;
        if (cVar2 != null) {
            cVar2.reset();
        }
        H();
    }

    @Override // e.f.h.h.a
    public void b() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractDraweeController#onDetach");
        }
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.r(a, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f12210k);
        }
        this.f12201b.b(b.a.ON_DETACH_CONTROLLER);
        this.m = false;
        this.f12202c.f(this);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    @Override // e.f.h.h.a
    public e.f.h.h.b c() {
        return this.f12208i;
    }

    @Override // e.f.h.h.a
    public boolean d(MotionEvent motionEvent) {
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.s(a, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f12210k, motionEvent);
        }
        e.f.h.g.a aVar = this.f12205f;
        if (aVar == null) {
            return false;
        }
        if (aVar.b() || P()) {
            this.f12205f.d(motionEvent);
            return true;
        }
        return false;
    }

    @Override // e.f.h.g.a.InterfaceC0269a
    public boolean e() {
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.r(a, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f12210k);
        }
        if (Q()) {
            this.f12204e.b();
            this.f12208i.reset();
            R();
            return true;
        }
        return false;
    }

    @Override // e.f.h.h.a
    public void f() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractDraweeController#onAttach");
        }
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.s(a, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f12210k, this.n ? "request already submitted" : "request needs submit");
        }
        this.f12201b.b(b.a.ON_ATTACH_CONTROLLER);
        i.g(this.f12208i);
        this.f12202c.c(this);
        this.m = true;
        if (!this.n) {
            R();
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    @Override // e.f.h.h.a
    public void g(e.f.h.h.b bVar) {
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.s(a, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f12210k, bVar);
        }
        this.f12201b.b(bVar != null ? b.a.ON_SET_HIERARCHY : b.a.ON_CLEAR_HIERARCHY);
        if (this.n) {
            this.f12202c.c(this);
            a();
        }
        e.f.h.h.c cVar = this.f12208i;
        if (cVar != null) {
            cVar.a(null);
            this.f12208i = null;
        }
        if (bVar != null) {
            i.b(bVar instanceof e.f.h.h.c);
            e.f.h.h.c cVar2 = (e.f.h.h.c) bVar;
            this.f12208i = cVar2;
            cVar2.a(this.f12209j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(d<? super INFO> dVar) {
        i.g(dVar);
        d<INFO> dVar2 = this.f12207h;
        if (dVar2 instanceof b) {
            ((b) dVar2).g(dVar);
        } else if (dVar2 != null) {
            this.f12207h = b.k(dVar2, dVar);
        } else {
            this.f12207h = dVar;
        }
    }

    protected abstract Drawable l(T t);

    public Animatable m() {
        Drawable drawable = this.u;
        if (drawable instanceof Animatable) {
            return (Animatable) drawable;
        }
        return null;
    }

    protected T n() {
        return null;
    }

    protected d<INFO> o() {
        d<INFO> dVar = this.f12207h;
        return dVar == null ? c.g() : dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable p() {
        return this.f12209j;
    }

    protected abstract e.f.e.c<T> q();

    /* JADX INFO: Access modifiers changed from: protected */
    public e.f.h.g.a r() {
        return this.f12205f;
    }

    public String s() {
        return this.f12210k;
    }

    protected String t(T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    public String toString() {
        return h.d(this).c("isAttached", this.m).c("isRequestSubmitted", this.n).c("hasFetchFailed", this.p).a("fetchedImage", u(this.t)).b("events", this.f12201b.toString()).toString();
    }

    protected int u(T t) {
        return System.identityHashCode(t);
    }

    protected abstract INFO v(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public e.f.h.b.c w() {
        if (this.f12204e == null) {
            this.f12204e = new e.f.h.b.c();
        }
        return this.f12204e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(String str, Object obj) {
        x(str, obj);
        this.v = false;
    }
}