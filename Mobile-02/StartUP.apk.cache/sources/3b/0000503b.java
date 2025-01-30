package h.c.n0.j;

import h.c.e0;
import h.c.z;

/* compiled from: EmptyComponent.java */
/* loaded from: classes3.dex */
public enum g implements h.c.m<Object>, z<Object>, h.c.p<Object>, e0<Object>, h.c.e, k.a.d, h.c.k0.b {
    INSTANCE;

    public static <T> z<T> n() {
        return INSTANCE;
    }

    public static <T> k.a.c<T> q() {
        return INSTANCE;
    }

    @Override // k.a.d
    public void cancel() {
    }

    @Override // h.c.k0.b
    public void dispose() {
    }

    @Override // h.c.k0.b
    public boolean isDisposed() {
        return true;
    }

    @Override // k.a.c
    public void onComplete() {
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        h.c.r0.a.u(th);
    }

    @Override // k.a.c
    public void onNext(Object obj) {
    }

    @Override // h.c.z
    public void onSubscribe(h.c.k0.b bVar) {
        bVar.dispose();
    }

    @Override // h.c.p
    public void onSuccess(Object obj) {
    }

    @Override // k.a.d
    public void request(long j2) {
    }

    @Override // h.c.m, k.a.c
    public void onSubscribe(k.a.d dVar) {
        dVar.cancel();
    }
}