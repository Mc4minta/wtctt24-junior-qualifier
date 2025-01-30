package e.f.h.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import e.f.d.c.h;
import e.f.d.c.i;
import e.f.d.c.l;
import e.f.h.e.q;
import e.f.j.d.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: PipelineDraweeController.java */
/* loaded from: classes2.dex */
public class d extends e.f.h.c.a<com.facebook.common.references.a<e.f.j.i.b>, e.f.j.i.e> {
    private static final Class<?> w = d.class;
    private final p<e.f.b.a.d, e.f.j.i.b> A;
    private e.f.b.a.d B;
    private l<e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>>> C;
    private boolean D;
    private e.f.d.c.e<e.f.j.h.a> E;
    private e.f.h.a.a.i.g F;
    private Set<e.f.j.j.c> G;
    private e.f.h.a.a.i.b H;
    private e.f.h.a.a.h.a I;
    private final Resources x;
    private final e.f.j.h.a y;
    private final e.f.d.c.e<e.f.j.h.a> z;

    public d(Resources resources, e.f.h.b.a aVar, e.f.j.h.a aVar2, Executor executor, p<e.f.b.a.d, e.f.j.i.b> pVar, e.f.d.c.e<e.f.j.h.a> eVar) {
        super(aVar, executor, null, null);
        this.x = resources;
        this.y = new a(resources, aVar2);
        this.z = eVar;
        this.A = pVar;
    }

    private void a0(l<e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>>> lVar) {
        this.C = lVar;
        e0(null);
    }

    private Drawable d0(e.f.d.c.e<e.f.j.h.a> eVar, e.f.j.i.b bVar) {
        Drawable b2;
        if (eVar == null) {
            return null;
        }
        Iterator<e.f.j.h.a> it = eVar.iterator();
        while (it.hasNext()) {
            e.f.j.h.a next = it.next();
            if (next.a(bVar) && (b2 = next.b(bVar)) != null) {
                return b2;
            }
        }
        return null;
    }

    private void e0(e.f.j.i.b bVar) {
        if (this.D) {
            if (p() == null) {
                e.f.h.d.a aVar = new e.f.h.d.a();
                e.f.h.d.b.a aVar2 = new e.f.h.d.b.a(aVar);
                this.I = new e.f.h.a.a.h.a();
                k(aVar2);
                L(aVar);
            }
            if (this.H == null) {
                S(this.I);
            }
            if (p() instanceof e.f.h.d.a) {
                l0(bVar, (e.f.h.d.a) p());
            }
        }
    }

    @Override // e.f.h.c.a
    protected void G(Drawable drawable) {
        if (drawable instanceof e.f.g.a.a) {
            ((e.f.g.a.a) drawable).a();
        }
    }

    public synchronized void S(e.f.h.a.a.i.b bVar) {
        e.f.h.a.a.i.b bVar2 = this.H;
        if (bVar2 instanceof e.f.h.a.a.i.a) {
            ((e.f.h.a.a.i.a) bVar2).b(bVar);
        } else if (bVar2 != null) {
            this.H = new e.f.h.a.a.i.a(bVar2, bVar);
        } else {
            this.H = bVar;
        }
    }

    public synchronized void T(e.f.j.j.c cVar) {
        if (this.G == null) {
            this.G = new HashSet();
        }
        this.G.add(cVar);
    }

    protected void U() {
        synchronized (this) {
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.a
    /* renamed from: V */
    public Drawable l(com.facebook.common.references.a<e.f.j.i.b> aVar) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("PipelineDraweeController#createDrawable");
            }
            i.i(com.facebook.common.references.a.G(aVar));
            e.f.j.i.b n = aVar.n();
            e0(n);
            Drawable d0 = d0(this.E, n);
            if (d0 != null) {
                return d0;
            }
            Drawable d02 = d0(this.z, n);
            if (d02 != null) {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
                return d02;
            }
            Drawable b2 = this.y.b(n);
            if (b2 != null) {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
                return b2;
            }
            throw new UnsupportedOperationException("Unrecognized image class: " + n);
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.a
    /* renamed from: W */
    public com.facebook.common.references.a<e.f.j.i.b> n() {
        e.f.b.a.d dVar;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("PipelineDraweeController#getCachedImage");
        }
        try {
            p<e.f.b.a.d, e.f.j.i.b> pVar = this.A;
            if (pVar != null && (dVar = this.B) != null) {
                com.facebook.common.references.a<e.f.j.i.b> aVar = pVar.get(dVar);
                if (aVar != null && !aVar.n().a().a()) {
                    aVar.close();
                    return null;
                }
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
                return aVar;
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            return null;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.a
    /* renamed from: X */
    public int u(com.facebook.common.references.a<e.f.j.i.b> aVar) {
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.a
    /* renamed from: Y */
    public e.f.j.i.e v(com.facebook.common.references.a<e.f.j.i.b> aVar) {
        i.i(com.facebook.common.references.a.G(aVar));
        return aVar.n();
    }

    public synchronized e.f.j.j.c Z() {
        e.f.h.a.a.i.c cVar = this.H != null ? new e.f.h.a.a.i.c(s(), this.H) : null;
        Set<e.f.j.j.c> set = this.G;
        if (set != null) {
            e.f.j.j.b bVar = new e.f.j.j.b(set);
            if (cVar != null) {
                bVar.l(cVar);
            }
            return bVar;
        }
        return cVar;
    }

    public void b0(l<e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>>> lVar, String str, e.f.b.a.d dVar, Object obj, e.f.d.c.e<e.f.j.h.a> eVar, e.f.h.a.a.i.b bVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("PipelineDraweeController#initialize");
        }
        super.y(str, obj);
        a0(lVar);
        this.B = dVar;
        j0(eVar);
        U();
        e0(null);
        S(bVar);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c0(e.f.h.a.a.i.f fVar) {
        e.f.h.a.a.i.g gVar = this.F;
        if (gVar != null) {
            gVar.f();
        }
        if (fVar != null) {
            if (this.F == null) {
                this.F = new e.f.h.a.a.i.g(AwakeTimeSinceBootClock.get(), this);
            }
            this.F.a(fVar);
            this.F.g(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.a
    /* renamed from: f0 */
    public void D(String str, com.facebook.common.references.a<e.f.j.i.b> aVar) {
        super.D(str, aVar);
        synchronized (this) {
            e.f.h.a.a.i.b bVar = this.H;
            if (bVar != null) {
                bVar.a(str, 5, true, "PipelineDraweeController");
            }
        }
    }

    @Override // e.f.h.c.a, e.f.h.h.a
    public void g(e.f.h.h.b bVar) {
        super.g(bVar);
        e0(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.a
    /* renamed from: g0 */
    public void I(com.facebook.common.references.a<e.f.j.i.b> aVar) {
        com.facebook.common.references.a.f(aVar);
    }

    public synchronized void h0(e.f.h.a.a.i.b bVar) {
        e.f.h.a.a.i.b bVar2 = this.H;
        if (bVar2 instanceof e.f.h.a.a.i.a) {
            ((e.f.h.a.a.i.a) bVar2).c(bVar);
        } else if (bVar2 != null) {
            this.H = new e.f.h.a.a.i.a(bVar2, bVar);
        } else {
            this.H = bVar;
        }
    }

    public synchronized void i0(e.f.j.j.c cVar) {
        Set<e.f.j.j.c> set = this.G;
        if (set == null) {
            return;
        }
        set.remove(cVar);
    }

    public void j0(e.f.d.c.e<e.f.j.h.a> eVar) {
        this.E = eVar;
    }

    public void k0(boolean z) {
        this.D = z;
    }

    protected void l0(e.f.j.i.b bVar, e.f.h.d.a aVar) {
        e.f.h.e.p a;
        aVar.f(s());
        e.f.h.h.b c2 = c();
        q.b bVar2 = null;
        if (c2 != null && (a = q.a(c2.e())) != null) {
            bVar2 = a.r();
        }
        aVar.j(bVar2);
        aVar.i(this.I.b());
        if (bVar != null) {
            aVar.g(bVar.getWidth(), bVar.getHeight());
            aVar.h(bVar.b());
            return;
        }
        aVar.e();
    }

    @Override // e.f.h.c.a
    protected e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> q() {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("PipelineDraweeController#getDataSource");
        }
        if (e.f.d.d.a.o(2)) {
            e.f.d.d.a.q(w, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar = this.C.get();
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return cVar;
    }

    @Override // e.f.h.c.a
    public String toString() {
        return h.d(this).b("super", super.toString()).b("dataSourceSupplier", this.C).toString();
    }
}