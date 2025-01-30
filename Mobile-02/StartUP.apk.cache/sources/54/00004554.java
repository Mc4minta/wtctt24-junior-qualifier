package e.f.d.a;

/* compiled from: NoOpDiskTrimmableRegistry.java */
/* loaded from: classes2.dex */
public class c implements b {
    private static c a;

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    @Override // e.f.d.a.b
    public void a(a aVar) {
    }
}