package c.f.b.k.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GuidelineReference.java */
/* loaded from: classes.dex */
public class h extends m {
    public h(c.f.b.k.e eVar) {
        super(eVar);
        eVar.f2805f.f();
        eVar.f2806g.f();
        this.f2882f = ((c.f.b.k.h) eVar).L0();
    }

    private void q(f fVar) {
        this.f2884h.f2858k.add(fVar);
        fVar.f2859l.add(this.f2884h);
    }

    @Override // c.f.b.k.n.m, c.f.b.k.n.d
    public void a(d dVar) {
        f fVar = this.f2884h;
        if (fVar.f2850c && !fVar.f2857j) {
            this.f2884h.d((int) ((fVar.f2859l.get(0).f2854g * ((c.f.b.k.h) this.f2878b).O0()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void d() {
        c.f.b.k.h hVar = (c.f.b.k.h) this.f2878b;
        int M0 = hVar.M0();
        int N0 = hVar.N0();
        hVar.O0();
        if (hVar.L0() == 1) {
            if (M0 != -1) {
                this.f2884h.f2859l.add(this.f2878b.Q.f2805f.f2884h);
                this.f2878b.Q.f2805f.f2884h.f2858k.add(this.f2884h);
                this.f2884h.f2853f = M0;
            } else if (N0 != -1) {
                this.f2884h.f2859l.add(this.f2878b.Q.f2805f.f2885i);
                this.f2878b.Q.f2805f.f2885i.f2858k.add(this.f2884h);
                this.f2884h.f2853f = -N0;
            } else {
                f fVar = this.f2884h;
                fVar.f2849b = true;
                fVar.f2859l.add(this.f2878b.Q.f2805f.f2885i);
                this.f2878b.Q.f2805f.f2885i.f2858k.add(this.f2884h);
            }
            q(this.f2878b.f2805f.f2884h);
            q(this.f2878b.f2805f.f2885i);
            return;
        }
        if (M0 != -1) {
            this.f2884h.f2859l.add(this.f2878b.Q.f2806g.f2884h);
            this.f2878b.Q.f2806g.f2884h.f2858k.add(this.f2884h);
            this.f2884h.f2853f = M0;
        } else if (N0 != -1) {
            this.f2884h.f2859l.add(this.f2878b.Q.f2806g.f2885i);
            this.f2878b.Q.f2806g.f2885i.f2858k.add(this.f2884h);
            this.f2884h.f2853f = -N0;
        } else {
            f fVar2 = this.f2884h;
            fVar2.f2849b = true;
            fVar2.f2859l.add(this.f2878b.Q.f2806g.f2885i);
            this.f2878b.Q.f2806g.f2885i.f2858k.add(this.f2884h);
        }
        q(this.f2878b.f2806g.f2884h);
        q(this.f2878b.f2806g.f2885i);
    }

    @Override // c.f.b.k.n.m
    public void e() {
        if (((c.f.b.k.h) this.f2878b).L0() == 1) {
            this.f2878b.G0(this.f2884h.f2854g);
        } else {
            this.f2878b.H0(this.f2884h.f2854g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void f() {
        this.f2884h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public boolean m() {
        return false;
    }
}