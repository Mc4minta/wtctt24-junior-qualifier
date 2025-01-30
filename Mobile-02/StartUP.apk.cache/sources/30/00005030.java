package h.c.n0.i;

/* compiled from: EmptySubscription.java */
/* loaded from: classes3.dex */
public enum d implements h.c.n0.c.g<Object> {
    INSTANCE;

    public static void h(k.a.c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void q(Throwable th, k.a.c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    @Override // k.a.d
    public void cancel() {
    }

    @Override // h.c.n0.c.j
    public void clear() {
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return true;
    }

    @Override // h.c.n0.c.f
    public int n(int i2) {
        return i2 & 2;
    }

    @Override // h.c.n0.c.j
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.c.n0.c.j
    public Object poll() {
        return null;
    }

    @Override // k.a.d
    public void request(long j2) {
        g.B(j2);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}