package h.c.n0.e.e;

/* compiled from: ObservableBlockingSubscribe.java */
/* loaded from: classes3.dex */
public final class k {
    public static <T> void a(h.c.x<? extends T> xVar) {
        h.c.n0.j.f fVar = new h.c.n0.j.f();
        h.c.n0.d.t tVar = new h.c.n0.d.t(h.c.n0.b.a.h(), fVar, fVar, h.c.n0.b.a.h());
        xVar.subscribe(tVar);
        h.c.n0.j.e.a(fVar, tVar);
        Throwable th = fVar.a;
        if (th != null) {
            throw h.c.n0.j.j.e(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> void b(h.c.x<? extends T> r4, h.c.z<? super T> r5) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            h.c.n0.d.i r1 = new h.c.n0.d.i
            r1.<init>(r0)
            r5.onSubscribe(r1)
            r4.subscribe(r1)
        L10:
            boolean r2 = r1.isDisposed()
            if (r2 == 0) goto L17
            goto L3a
        L17:
            java.lang.Object r2 = r0.poll()
            if (r2 != 0) goto L2a
            java.lang.Object r2 = r0.take()     // Catch: java.lang.InterruptedException -> L22
            goto L2a
        L22:
            r4 = move-exception
            r1.dispose()
            r5.onError(r4)
            return
        L2a:
            boolean r3 = r1.isDisposed()
            if (r3 != 0) goto L3a
            java.lang.Object r3 = h.c.n0.d.i.a
            if (r4 == r3) goto L3a
            boolean r2 = h.c.n0.j.m.q(r2, r5)
            if (r2 == 0) goto L10
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.c.n0.e.e.k.b(h.c.x, h.c.z):void");
    }

    public static <T> void c(h.c.x<? extends T> xVar, h.c.m0.f<? super T> fVar, h.c.m0.f<? super Throwable> fVar2, h.c.m0.a aVar) {
        h.c.n0.b.b.e(fVar, "onNext is null");
        h.c.n0.b.b.e(fVar2, "onError is null");
        h.c.n0.b.b.e(aVar, "onComplete is null");
        b(xVar, new h.c.n0.d.t(fVar, fVar2, aVar, h.c.n0.b.a.h()));
    }
}