package e.f.j.l;

import com.facebook.imagepipeline.request.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseProducerContext.java */
/* loaded from: classes2.dex */
public class d implements k0 {
    private final com.facebook.imagepipeline.request.b a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12591b;

    /* renamed from: c  reason: collision with root package name */
    private final m0 f12592c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f12593d;

    /* renamed from: e  reason: collision with root package name */
    private final b.EnumC0109b f12594e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12595f;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.imagepipeline.common.d f12596g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12597h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12598i = false;

    /* renamed from: j  reason: collision with root package name */
    private final List<l0> f12599j = new ArrayList();

    public d(com.facebook.imagepipeline.request.b bVar, String str, m0 m0Var, Object obj, b.EnumC0109b enumC0109b, boolean z, boolean z2, com.facebook.imagepipeline.common.d dVar) {
        this.a = bVar;
        this.f12591b = str;
        this.f12592c = m0Var;
        this.f12593d = obj;
        this.f12594e = enumC0109b;
        this.f12595f = z;
        this.f12596g = dVar;
        this.f12597h = z2;
    }

    public static void i(List<l0> list) {
        if (list == null) {
            return;
        }
        for (l0 l0Var : list) {
            l0Var.a();
        }
    }

    public static void j(List<l0> list) {
        if (list == null) {
            return;
        }
        for (l0 l0Var : list) {
            l0Var.b();
        }
    }

    public static void k(List<l0> list) {
        if (list == null) {
            return;
        }
        for (l0 l0Var : list) {
            l0Var.d();
        }
    }

    public static void l(List<l0> list) {
        if (list == null) {
            return;
        }
        for (l0 l0Var : list) {
            l0Var.c();
        }
    }

    @Override // e.f.j.l.k0
    public Object a() {
        return this.f12593d;
    }

    @Override // e.f.j.l.k0
    public synchronized com.facebook.imagepipeline.common.d b() {
        return this.f12596g;
    }

    @Override // e.f.j.l.k0
    public com.facebook.imagepipeline.request.b c() {
        return this.a;
    }

    @Override // e.f.j.l.k0
    public void d(l0 l0Var) {
        boolean z;
        synchronized (this) {
            this.f12599j.add(l0Var);
            z = this.f12598i;
        }
        if (z) {
            l0Var.a();
        }
    }

    @Override // e.f.j.l.k0
    public synchronized boolean e() {
        return this.f12595f;
    }

    @Override // e.f.j.l.k0
    public m0 f() {
        return this.f12592c;
    }

    @Override // e.f.j.l.k0
    public synchronized boolean g() {
        return this.f12597h;
    }

    @Override // e.f.j.l.k0
    public String getId() {
        return this.f12591b;
    }

    @Override // e.f.j.l.k0
    public b.EnumC0109b h() {
        return this.f12594e;
    }

    public void m() {
        i(n());
    }

    public synchronized List<l0> n() {
        if (this.f12598i) {
            return null;
        }
        this.f12598i = true;
        return new ArrayList(this.f12599j);
    }

    public synchronized List<l0> o(boolean z) {
        if (z == this.f12597h) {
            return null;
        }
        this.f12597h = z;
        return new ArrayList(this.f12599j);
    }

    public synchronized List<l0> p(boolean z) {
        if (z == this.f12595f) {
            return null;
        }
        this.f12595f = z;
        return new ArrayList(this.f12599j);
    }

    public synchronized List<l0> q(com.facebook.imagepipeline.common.d dVar) {
        if (dVar == this.f12596g) {
            return null;
        }
        this.f12596g = dVar;
        return new ArrayList(this.f12599j);
    }
}