package e.f.j.l;

import android.graphics.Bitmap;

/* compiled from: BitmapPrepareProducer.java */
/* loaded from: classes2.dex */
public class i implements j0<com.facebook.common.references.a<e.f.j.i.b>> {
    private final j0<com.facebook.common.references.a<e.f.j.i.b>> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12640b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12641c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12642d;

    /* compiled from: BitmapPrepareProducer.java */
    /* loaded from: classes2.dex */
    private static class a extends n<com.facebook.common.references.a<e.f.j.i.b>, com.facebook.common.references.a<e.f.j.i.b>> {

        /* renamed from: c  reason: collision with root package name */
        private final int f12643c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12644d;

        a(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, int i2, int i3) {
            super(kVar);
            this.f12643c = i2;
            this.f12644d = i3;
        }

        private void p(com.facebook.common.references.a<e.f.j.i.b> aVar) {
            e.f.j.i.b n;
            Bitmap d2;
            int rowBytes;
            if (aVar == null || !aVar.A() || (n = aVar.n()) == null || n.isClosed() || !(n instanceof e.f.j.i.c) || (d2 = ((e.f.j.i.c) n).d()) == null || (rowBytes = d2.getRowBytes() * d2.getHeight()) < this.f12643c || rowBytes > this.f12644d) {
                return;
            }
            d2.prepareToDraw();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: q */
        public void h(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            p(aVar);
            o().c(aVar, i2);
        }
    }

    public i(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var, int i2, int i3, boolean z) {
        e.f.d.c.i.b(i2 <= i3);
        this.a = (j0) e.f.d.c.i.g(j0Var);
        this.f12640b = i2;
        this.f12641c = i3;
        this.f12642d = z;
    }

    @Override // e.f.j.l.j0
    public void b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var) {
        if (k0Var.e() && !this.f12642d) {
            this.a.b(kVar, k0Var);
        } else {
            this.a.b(new a(kVar, this.f12640b, this.f12641c), k0Var);
        }
    }
}