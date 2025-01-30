package e.f.j.e;

import e.f.b.b.e;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: DiskStorageCacheFactory.java */
/* loaded from: classes2.dex */
public class c implements g {
    private d a;

    public c(d dVar) {
        this.a = dVar;
    }

    public static e.f.b.b.e b(e.f.b.b.c cVar, e.f.b.b.d dVar) {
        return c(cVar, dVar, Executors.newSingleThreadExecutor());
    }

    public static e.f.b.b.e c(e.f.b.b.c cVar, e.f.b.b.d dVar, Executor executor) {
        return new e.f.b.b.e(dVar, cVar.h(), new e.c(cVar.k(), cVar.j(), cVar.f()), cVar.d(), cVar.c(), cVar.g(), cVar.e(), executor, cVar.i());
    }

    @Override // e.f.j.e.g
    public e.f.b.b.i a(e.f.b.b.c cVar) {
        return b(cVar, this.a.a(cVar));
    }
}