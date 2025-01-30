package e.f.j.d;

import android.net.Uri;

/* compiled from: DefaultCacheKeyFactory.java */
/* loaded from: classes2.dex */
public class j implements f {
    private static j a;

    protected j() {
    }

    public static synchronized j f() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    @Override // e.f.j.d.f
    public e.f.b.a.d a(com.facebook.imagepipeline.request.b bVar, Object obj) {
        return new c(e(bVar.q()).toString(), bVar.m(), bVar.o(), bVar.d(), null, null, obj);
    }

    @Override // e.f.j.d.f
    public e.f.b.a.d b(com.facebook.imagepipeline.request.b bVar, Uri uri, Object obj) {
        return new e.f.b.a.i(e(uri).toString());
    }

    @Override // e.f.j.d.f
    public e.f.b.a.d c(com.facebook.imagepipeline.request.b bVar, Object obj) {
        e.f.b.a.d dVar;
        String str;
        com.facebook.imagepipeline.request.c g2 = bVar.g();
        if (g2 != null) {
            e.f.b.a.d c2 = g2.c();
            str = g2.getClass().getName();
            dVar = c2;
        } else {
            dVar = null;
            str = null;
        }
        return new c(e(bVar.q()).toString(), bVar.m(), bVar.o(), bVar.d(), dVar, str, obj);
    }

    @Override // e.f.j.d.f
    public e.f.b.a.d d(com.facebook.imagepipeline.request.b bVar, Object obj) {
        return b(bVar, bVar.q(), obj);
    }

    protected Uri e(Uri uri) {
        return uri;
    }
}