package e.f.h.a.a.i;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ImagePerfMonitor.java */
/* loaded from: classes2.dex */
public class g {
    private final e.f.h.a.a.d a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.common.time.b f12159b;

    /* renamed from: c  reason: collision with root package name */
    private final h f12160c = new h();

    /* renamed from: d  reason: collision with root package name */
    private c f12161d;

    /* renamed from: e  reason: collision with root package name */
    private b f12162e;

    /* renamed from: f  reason: collision with root package name */
    private e.f.h.a.a.i.i.c f12163f;

    /* renamed from: g  reason: collision with root package name */
    private e.f.h.a.a.i.i.a f12164g;

    /* renamed from: h  reason: collision with root package name */
    private e.f.j.j.b f12165h;

    /* renamed from: i  reason: collision with root package name */
    private List<f> f12166i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12167j;

    public g(com.facebook.common.time.b bVar, e.f.h.a.a.d dVar) {
        this.f12159b = bVar;
        this.a = dVar;
    }

    private void h() {
        if (this.f12164g == null) {
            this.f12164g = new e.f.h.a.a.i.i.a(this.f12159b, this.f12160c, this);
        }
        if (this.f12163f == null) {
            this.f12163f = new e.f.h.a.a.i.i.c(this.f12159b, this.f12160c);
        }
        if (this.f12162e == null) {
            this.f12162e = new e.f.h.a.a.i.i.b(this.f12160c, this);
        }
        c cVar = this.f12161d;
        if (cVar == null) {
            this.f12161d = new c(this.a.s(), this.f12162e);
        } else {
            cVar.l(this.a.s());
        }
        if (this.f12165h == null) {
            this.f12165h = new e.f.j.j.b(this.f12163f, this.f12161d);
        }
    }

    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f12166i == null) {
            this.f12166i = new LinkedList();
        }
        this.f12166i.add(fVar);
    }

    public void b() {
        e.f.h.h.b c2 = this.a.c();
        if (c2 == null || c2.e() == null) {
            return;
        }
        Rect bounds = c2.e().getBounds();
        this.f12160c.r(bounds.width());
        this.f12160c.q(bounds.height());
    }

    public void c() {
        List<f> list = this.f12166i;
        if (list != null) {
            list.clear();
        }
    }

    public void d(h hVar, int i2) {
        List<f> list;
        if (!this.f12167j || (list = this.f12166i) == null || list.isEmpty()) {
            return;
        }
        e x = hVar.x();
        for (f fVar : this.f12166i) {
            fVar.b(x, i2);
        }
    }

    public void e(h hVar, int i2) {
        List<f> list;
        hVar.k(i2);
        if (!this.f12167j || (list = this.f12166i) == null || list.isEmpty()) {
            return;
        }
        if (i2 == 3) {
            b();
        }
        e x = hVar.x();
        for (f fVar : this.f12166i) {
            fVar.a(x, i2);
        }
    }

    public void f() {
        c();
        g(false);
        this.f12160c.b();
    }

    public void g(boolean z) {
        this.f12167j = z;
        if (z) {
            h();
            b bVar = this.f12162e;
            if (bVar != null) {
                this.a.S(bVar);
            }
            e.f.h.a.a.i.i.a aVar = this.f12164g;
            if (aVar != null) {
                this.a.k(aVar);
            }
            e.f.j.j.b bVar2 = this.f12165h;
            if (bVar2 != null) {
                this.a.T(bVar2);
                return;
            }
            return;
        }
        b bVar3 = this.f12162e;
        if (bVar3 != null) {
            this.a.h0(bVar3);
        }
        e.f.h.a.a.i.i.a aVar2 = this.f12164g;
        if (aVar2 != null) {
            this.a.J(aVar2);
        }
        e.f.j.j.b bVar4 = this.f12165h;
        if (bVar4 != null) {
            this.a.i0(bVar4);
        }
    }
}