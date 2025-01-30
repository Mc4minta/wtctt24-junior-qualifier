package e.f.j.f;

import android.graphics.Bitmap;

/* compiled from: BaseBitmapDataSubscriber.java */
/* loaded from: classes2.dex */
public abstract class b extends e.f.e.b<com.facebook.common.references.a<e.f.j.i.b>> {
    @Override // e.f.e.b
    public void f(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
        if (cVar.b()) {
            com.facebook.common.references.a<e.f.j.i.b> f2 = cVar.f();
            Bitmap bitmap = null;
            if (f2 != null && (f2.n() instanceof e.f.j.i.a)) {
                bitmap = ((e.f.j.i.a) f2.n()).d();
            }
            try {
                g(bitmap);
            } finally {
                com.facebook.common.references.a.f(f2);
            }
        }
    }

    protected abstract void g(Bitmap bitmap);
}