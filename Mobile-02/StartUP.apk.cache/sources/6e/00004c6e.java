package h.c.n0.e.b;

import h.c.n0.e.b.z3;

/* compiled from: FlowableTakePublisher.java */
/* loaded from: classes3.dex */
public final class d4<T> extends h.c.h<T> {
    final k.a.b<T> a;

    /* renamed from: b  reason: collision with root package name */
    final long f14327b;

    public d4(k.a.b<T> bVar, long j2) {
        this.a = bVar;
        this.f14327b = j2;
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super T> cVar) {
        this.a.subscribe(new z3.a(cVar, this.f14327b));
    }
}