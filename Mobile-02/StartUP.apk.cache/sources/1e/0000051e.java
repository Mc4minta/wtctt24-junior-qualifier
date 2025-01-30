package c.f.b.k.n;

import c.f.b.k.n.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DimensionDependency.java */
/* loaded from: classes.dex */
public class g extends f {
    public int m;

    public g(m mVar) {
        super(mVar);
        if (mVar instanceof j) {
            this.f2852e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f2852e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // c.f.b.k.n.f
    public void d(int i2) {
        if (this.f2857j) {
            return;
        }
        this.f2857j = true;
        this.f2854g = i2;
        for (d dVar : this.f2858k) {
            dVar.a(dVar);
        }
    }
}