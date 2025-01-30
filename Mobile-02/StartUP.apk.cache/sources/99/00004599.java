package e.f.h.a.a;

import android.content.res.Resources;
import e.f.d.c.l;
import e.f.j.d.p;
import java.util.concurrent.Executor;

/* compiled from: PipelineDraweeControllerFactory.java */
/* loaded from: classes2.dex */
public class g {
    private Resources a;

    /* renamed from: b  reason: collision with root package name */
    private e.f.h.b.a f12141b;

    /* renamed from: c  reason: collision with root package name */
    private e.f.j.h.a f12142c;

    /* renamed from: d  reason: collision with root package name */
    private Executor f12143d;

    /* renamed from: e  reason: collision with root package name */
    private p<e.f.b.a.d, e.f.j.i.b> f12144e;

    /* renamed from: f  reason: collision with root package name */
    private e.f.d.c.e<e.f.j.h.a> f12145f;

    /* renamed from: g  reason: collision with root package name */
    private l<Boolean> f12146g;

    public void a(Resources resources, e.f.h.b.a aVar, e.f.j.h.a aVar2, Executor executor, p<e.f.b.a.d, e.f.j.i.b> pVar, e.f.d.c.e<e.f.j.h.a> eVar, l<Boolean> lVar) {
        this.a = resources;
        this.f12141b = aVar;
        this.f12142c = aVar2;
        this.f12143d = executor;
        this.f12144e = pVar;
        this.f12145f = eVar;
        this.f12146g = lVar;
    }

    protected d b(Resources resources, e.f.h.b.a aVar, e.f.j.h.a aVar2, Executor executor, p<e.f.b.a.d, e.f.j.i.b> pVar, e.f.d.c.e<e.f.j.h.a> eVar) {
        return new d(resources, aVar, aVar2, executor, pVar, eVar);
    }

    public d c() {
        d b2 = b(this.a, this.f12141b, this.f12142c, this.f12143d, this.f12144e, this.f12145f);
        l<Boolean> lVar = this.f12146g;
        if (lVar != null) {
            b2.k0(lVar.get().booleanValue());
        }
        return b2;
    }
}