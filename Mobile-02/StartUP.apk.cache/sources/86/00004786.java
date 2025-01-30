package e.g.a.c.i;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class q implements p {
    private static volatile r a;

    /* renamed from: b  reason: collision with root package name */
    private final e.g.a.c.i.w.a f13013b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.i.w.a f13014c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.i.v.e f13015d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.m f13016e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(e.g.a.c.i.w.a aVar, e.g.a.c.i.w.a aVar2, e.g.a.c.i.v.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.m mVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.q qVar) {
        this.f13013b = aVar;
        this.f13014c = aVar2;
        this.f13015d = eVar;
        this.f13016e = mVar;
        qVar.a();
    }

    private h b(k kVar) {
        return h.a().i(this.f13013b.a()).k(this.f13014c.a()).j(kVar.g()).h(new g(kVar.b(), kVar.d())).g(kVar.c().a()).d();
    }

    public static q c() {
        r rVar = a;
        if (rVar != null) {
            return rVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<e.g.a.c.b> d(e eVar) {
        if (eVar instanceof f) {
            return Collections.unmodifiableSet(((f) eVar).a());
        }
        return Collections.singleton(e.g.a.c.b.b("proto"));
    }

    public static void f(Context context) {
        if (a == null) {
            synchronized (q.class) {
                if (a == null) {
                    a = d.c().a(context).build();
                }
            }
        }
    }

    @Override // e.g.a.c.i.p
    public void a(k kVar, e.g.a.c.h hVar) {
        this.f13015d.a(kVar.f().e(kVar.c().c()), b(kVar), hVar);
    }

    public com.google.android.datatransport.runtime.scheduling.jobscheduling.m e() {
        return this.f13016e;
    }

    public e.g.a.c.g g(e eVar) {
        return new m(d(eVar), l.a().b(eVar.getName()).c(eVar.b()).a(), this);
    }
}