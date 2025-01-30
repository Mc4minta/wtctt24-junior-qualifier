package e.a.a.u.b;

import e.a.a.u.c.a;
import e.a.a.w.k.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class s implements c, a.b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11686b;

    /* renamed from: c  reason: collision with root package name */
    private final List<a.b> f11687c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final q.a f11688d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11689e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11690f;

    /* renamed from: g  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Float> f11691g;

    public s(e.a.a.w.l.a aVar, e.a.a.w.k.q qVar) {
        this.a = qVar.c();
        this.f11686b = qVar.g();
        this.f11688d = qVar.f();
        e.a.a.u.c.a<Float, Float> a = qVar.e().a();
        this.f11689e = a;
        e.a.a.u.c.a<Float, Float> a2 = qVar.b().a();
        this.f11690f = a2;
        e.a.a.u.c.a<Float, Float> a3 = qVar.d().a();
        this.f11691g = a3;
        aVar.i(a);
        aVar.i(a2);
        aVar.i(a3);
        a.a(this);
        a2.a(this);
        a3.a(this);
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        for (int i2 = 0; i2 < this.f11687c.size(); i2++) {
            this.f11687c.get(i2).a();
        }
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a.b bVar) {
        this.f11687c.add(bVar);
    }

    public e.a.a.u.c.a<?, Float> e() {
        return this.f11690f;
    }

    public e.a.a.u.c.a<?, Float> g() {
        return this.f11691g;
    }

    public e.a.a.u.c.a<?, Float> h() {
        return this.f11689e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q.a i() {
        return this.f11688d;
    }

    public boolean j() {
        return this.f11686b;
    }
}