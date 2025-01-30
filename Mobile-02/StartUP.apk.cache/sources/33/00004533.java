package e.f.b.a;

/* compiled from: NoOpCacheEventListener.java */
/* loaded from: classes2.dex */
public class h implements c {
    private static h a;

    private h() {
    }

    public static synchronized h i() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
            hVar = a;
        }
        return hVar;
    }

    @Override // e.f.b.a.c
    public void a(b bVar) {
    }

    @Override // e.f.b.a.c
    public void b(b bVar) {
    }

    @Override // e.f.b.a.c
    public void c() {
    }

    @Override // e.f.b.a.c
    public void d(b bVar) {
    }

    @Override // e.f.b.a.c
    public void e(b bVar) {
    }

    @Override // e.f.b.a.c
    public void f(b bVar) {
    }

    @Override // e.f.b.a.c
    public void g(b bVar) {
    }

    @Override // e.f.b.a.c
    public void h(b bVar) {
    }
}