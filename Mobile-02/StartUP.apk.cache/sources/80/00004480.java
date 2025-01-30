package e.a.a.u.b;

import android.graphics.Path;
import e.a.a.u.c.a;
import e.a.a.w.k.q;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
public class q implements m, a.b {

    /* renamed from: b  reason: collision with root package name */
    private final String f11680b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11681c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.g f11682d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.u.c.a<?, Path> f11683e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11684f;
    private final Path a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private b f11685g = new b();

    public q(e.a.a.g gVar, e.a.a.w.l.a aVar, e.a.a.w.k.o oVar) {
        this.f11680b = oVar.b();
        this.f11681c = oVar.d();
        this.f11682d = gVar;
        e.a.a.u.c.a<e.a.a.w.k.l, Path> a = oVar.c().a();
        this.f11683e = a;
        aVar.i(a);
        a.a(this);
    }

    private void c() {
        this.f11684f = false;
        this.f11682d.invalidateSelf();
    }

    @Override // e.a.a.u.c.a.b
    public void a() {
        c();
    }

    @Override // e.a.a.u.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.i() == q.a.SIMULTANEOUSLY) {
                    this.f11685g.a(sVar);
                    sVar.c(this);
                }
            }
        }
    }

    @Override // e.a.a.u.b.m
    public Path getPath() {
        if (this.f11684f) {
            return this.a;
        }
        this.a.reset();
        if (this.f11681c) {
            this.f11684f = true;
            return this.a;
        }
        this.a.set(this.f11683e.h());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f11685g.b(this.a);
        this.f11684f = true;
        return this.a;
    }
}