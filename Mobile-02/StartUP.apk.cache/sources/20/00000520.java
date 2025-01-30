package c.f.b.k.n;

import c.f.b.k.n.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HelperReferences.java */
/* loaded from: classes.dex */
public class i extends m {
    public i(c.f.b.k.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f2884h.f2858k.add(fVar);
        fVar.f2859l.add(this.f2884h);
    }

    @Override // c.f.b.k.n.m, c.f.b.k.n.d
    public void a(d dVar) {
        c.f.b.k.a aVar = (c.f.b.k.a) this.f2878b;
        int M0 = aVar.M0();
        int i2 = 0;
        int i3 = -1;
        for (f fVar : this.f2884h.f2859l) {
            int i4 = fVar.f2854g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (M0 != 0 && M0 != 2) {
            this.f2884h.d(i2 + aVar.N0());
        } else {
            this.f2884h.d(i3 + aVar.N0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void d() {
        c.f.b.k.e eVar = this.f2878b;
        if (eVar instanceof c.f.b.k.a) {
            this.f2884h.f2849b = true;
            c.f.b.k.a aVar = (c.f.b.k.a) eVar;
            int M0 = aVar.M0();
            boolean L0 = aVar.L0();
            int i2 = 0;
            if (M0 == 0) {
                this.f2884h.f2852e = f.a.LEFT;
                while (i2 < aVar.H0) {
                    c.f.b.k.e eVar2 = aVar.G0[i2];
                    if (L0 || eVar2.P() != 8) {
                        f fVar = eVar2.f2805f.f2884h;
                        fVar.f2858k.add(this.f2884h);
                        this.f2884h.f2859l.add(fVar);
                    }
                    i2++;
                }
                q(this.f2878b.f2805f.f2884h);
                q(this.f2878b.f2805f.f2885i);
            } else if (M0 == 1) {
                this.f2884h.f2852e = f.a.RIGHT;
                while (i2 < aVar.H0) {
                    c.f.b.k.e eVar3 = aVar.G0[i2];
                    if (L0 || eVar3.P() != 8) {
                        f fVar2 = eVar3.f2805f.f2885i;
                        fVar2.f2858k.add(this.f2884h);
                        this.f2884h.f2859l.add(fVar2);
                    }
                    i2++;
                }
                q(this.f2878b.f2805f.f2884h);
                q(this.f2878b.f2805f.f2885i);
            } else if (M0 == 2) {
                this.f2884h.f2852e = f.a.TOP;
                while (i2 < aVar.H0) {
                    c.f.b.k.e eVar4 = aVar.G0[i2];
                    if (L0 || eVar4.P() != 8) {
                        f fVar3 = eVar4.f2806g.f2884h;
                        fVar3.f2858k.add(this.f2884h);
                        this.f2884h.f2859l.add(fVar3);
                    }
                    i2++;
                }
                q(this.f2878b.f2806g.f2884h);
                q(this.f2878b.f2806g.f2885i);
            } else if (M0 != 3) {
            } else {
                this.f2884h.f2852e = f.a.BOTTOM;
                while (i2 < aVar.H0) {
                    c.f.b.k.e eVar5 = aVar.G0[i2];
                    if (L0 || eVar5.P() != 8) {
                        f fVar4 = eVar5.f2806g.f2885i;
                        fVar4.f2858k.add(this.f2884h);
                        this.f2884h.f2859l.add(fVar4);
                    }
                    i2++;
                }
                q(this.f2878b.f2806g.f2884h);
                q(this.f2878b.f2806g.f2885i);
            }
        }
    }

    @Override // c.f.b.k.n.m
    public void e() {
        c.f.b.k.e eVar = this.f2878b;
        if (eVar instanceof c.f.b.k.a) {
            int M0 = ((c.f.b.k.a) eVar).M0();
            if (M0 != 0 && M0 != 1) {
                this.f2878b.H0(this.f2884h.f2854g);
            } else {
                this.f2878b.G0(this.f2884h.f2854g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void f() {
        this.f2879c = null;
        this.f2884h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public boolean m() {
        return false;
    }
}