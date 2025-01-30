package h.c.n0.e.b;

import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: FlowableBlockingSubscribe.java */
/* loaded from: classes3.dex */
public final class k {
    public static <T> void a(k.a.b<? extends T> bVar) {
        h.c.n0.j.f fVar = new h.c.n0.j.f();
        h.c.n0.h.l lVar = new h.c.n0.h.l(h.c.n0.b.a.h(), fVar, fVar, h.c.n0.b.a.f14105l);
        bVar.subscribe(lVar);
        h.c.n0.j.e.a(fVar, lVar);
        Throwable th = fVar.a;
        if (th != null) {
            throw h.c.n0.j.j.e(th);
        }
    }

    public static <T> void b(k.a.b<? extends T> bVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        d(bVar, new h.c.n0.h.l(fVar, fVar2, aVar, h.c.n0.b.a.f14105l));
    }

    public static <T> void c(k.a.b<? extends T> bVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar, int i2) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        h.c.n0.b.b.f(i2, "number > 0 required");
        d(bVar, new h.c.n0.h.g(fVar, fVar2, aVar, h.c.n0.b.a.d(i2), i2));
    }

    public static <T> void d(k.a.b<? extends T> bVar, k.a.c<? super T> cVar) {
        Object poll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        h.c.n0.h.f fVar = new h.c.n0.h.f(linkedBlockingQueue);
        bVar.subscribe(fVar);
        do {
            try {
                if (fVar.a()) {
                    return;
                }
                poll = linkedBlockingQueue.poll();
                if (poll == null) {
                    if (fVar.a()) {
                        return;
                    }
                    h.c.n0.j.e.b();
                    poll = linkedBlockingQueue.take();
                }
                if (fVar.a() || poll == h.c.n0.h.f.a) {
                    return;
                }
            } catch (InterruptedException e2) {
                fVar.cancel();
                cVar.onError(e2);
                return;
            }
        } while (!h.c.n0.j.m.s(poll, cVar));
    }
}