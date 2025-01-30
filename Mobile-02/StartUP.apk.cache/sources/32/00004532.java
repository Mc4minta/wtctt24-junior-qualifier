package e.f.b.a;

import e.f.b.a.a;

/* compiled from: NoOpCacheErrorLogger.java */
/* loaded from: classes2.dex */
public class g implements a {
    private static g a;

    private g() {
    }

    public static synchronized g b() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    @Override // e.f.b.a.a
    public void a(a.EnumC0260a enumC0260a, Class<?> cls, String str, Throwable th) {
    }
}