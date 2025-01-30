package e.g.a.c.i.v;

import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import e.g.a.c.i.l;
import e.g.a.c.i.q;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
public class c implements e {
    private static final Logger a = Logger.getLogger(q.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private final s f13026b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f13027c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.backends.e f13028d;

    /* renamed from: e  reason: collision with root package name */
    private final e.g.a.c.i.v.j.c f13029e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.synchronization.a f13030f;

    public c(Executor executor, com.google.android.datatransport.runtime.backends.e eVar, s sVar, e.g.a.c.i.v.j.c cVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        this.f13027c = executor;
        this.f13028d = eVar;
        this.f13026b = sVar;
        this.f13029e = cVar;
        this.f13030f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object b(c cVar, l lVar, e.g.a.c.i.h hVar) {
        cVar.f13029e.H0(lVar, hVar);
        cVar.f13026b.a(lVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(c cVar, l lVar, e.g.a.c.h hVar, e.g.a.c.i.h hVar2) {
        try {
            m a2 = cVar.f13028d.a(lVar.b());
            if (a2 == null) {
                String format = String.format("Transport backend '%s' is not registered", lVar.b());
                a.warning(format);
                hVar.a(new IllegalArgumentException(format));
                return;
            }
            cVar.f13030f.a(b.a(cVar, lVar, a2.b(hVar2)));
            hVar.a(null);
        } catch (Exception e2) {
            Logger logger = a;
            logger.warning("Error scheduling event " + e2.getMessage());
            hVar.a(e2);
        }
    }

    @Override // e.g.a.c.i.v.e
    public void a(l lVar, e.g.a.c.i.h hVar, e.g.a.c.h hVar2) {
        this.f13027c.execute(a.a(this, lVar, hVar2, hVar));
    }
}