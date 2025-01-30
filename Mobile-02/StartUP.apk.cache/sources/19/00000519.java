package c.f.b.k.n;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ChainRun.java */
/* loaded from: classes.dex */
public class c extends m {

    /* renamed from: k  reason: collision with root package name */
    ArrayList<m> f2839k;

    /* renamed from: l  reason: collision with root package name */
    private int f2840l;

    public c(c.f.b.k.e eVar, int i2) {
        super(eVar);
        this.f2839k = new ArrayList<>();
        this.f2882f = i2;
        q();
    }

    private void q() {
        c.f.b.k.e eVar;
        c.f.b.k.e eVar2 = this.f2878b;
        c.f.b.k.e I = eVar2.I(this.f2882f);
        while (true) {
            c.f.b.k.e eVar3 = I;
            eVar = eVar2;
            eVar2 = eVar3;
            if (eVar2 == null) {
                break;
            }
            I = eVar2.I(this.f2882f);
        }
        this.f2878b = eVar;
        this.f2839k.add(eVar.K(this.f2882f));
        c.f.b.k.e G = eVar.G(this.f2882f);
        while (G != null) {
            this.f2839k.add(G.K(this.f2882f));
            G = G.G(this.f2882f);
        }
        Iterator<m> it = this.f2839k.iterator();
        while (it.hasNext()) {
            m next = it.next();
            int i2 = this.f2882f;
            if (i2 == 0) {
                next.f2878b.f2803d = this;
            } else if (i2 == 1) {
                next.f2878b.f2804e = this;
            }
        }
        if ((this.f2882f == 0 && ((c.f.b.k.f) this.f2878b.H()).d1()) && this.f2839k.size() > 1) {
            ArrayList<m> arrayList = this.f2839k;
            this.f2878b = arrayList.get(arrayList.size() - 1).f2878b;
        }
        this.f2840l = this.f2882f == 0 ? this.f2878b.y() : this.f2878b.M();
    }

    private c.f.b.k.e r() {
        for (int i2 = 0; i2 < this.f2839k.size(); i2++) {
            m mVar = this.f2839k.get(i2);
            if (mVar.f2878b.P() != 8) {
                return mVar.f2878b;
            }
        }
        return null;
    }

    private c.f.b.k.e s() {
        for (int size = this.f2839k.size() - 1; size >= 0; size--) {
            m mVar = this.f2839k.get(size);
            if (mVar.f2878b.P() != 8) {
                return mVar.f2878b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x01a5, code lost:
        if (r1 != r7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cb, code lost:
        if (r1 != r7) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01cd, code lost:
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01d0, code lost:
        r9.f2881e.d(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0418, code lost:
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    @Override // c.f.b.k.n.m, c.f.b.k.n.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(c.f.b.k.n.d r26) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.b.k.n.c.a(c.f.b.k.n.d):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void d() {
        Iterator<m> it = this.f2839k.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f2839k.size();
        if (size < 1) {
            return;
        }
        c.f.b.k.e eVar = this.f2839k.get(0).f2878b;
        c.f.b.k.e eVar2 = this.f2839k.get(size - 1).f2878b;
        if (this.f2882f == 0) {
            c.f.b.k.d dVar = eVar.E;
            c.f.b.k.d dVar2 = eVar2.G;
            f i2 = i(dVar, 0);
            int c2 = dVar.c();
            c.f.b.k.e r = r();
            if (r != null) {
                c2 = r.E.c();
            }
            if (i2 != null) {
                b(this.f2884h, i2, c2);
            }
            f i3 = i(dVar2, 0);
            int c3 = dVar2.c();
            c.f.b.k.e s = s();
            if (s != null) {
                c3 = s.G.c();
            }
            if (i3 != null) {
                b(this.f2885i, i3, -c3);
            }
        } else {
            c.f.b.k.d dVar3 = eVar.F;
            c.f.b.k.d dVar4 = eVar2.H;
            f i4 = i(dVar3, 1);
            int c4 = dVar3.c();
            c.f.b.k.e r2 = r();
            if (r2 != null) {
                c4 = r2.F.c();
            }
            if (i4 != null) {
                b(this.f2884h, i4, c4);
            }
            f i5 = i(dVar4, 1);
            int c5 = dVar4.c();
            c.f.b.k.e s2 = s();
            if (s2 != null) {
                c5 = s2.H.c();
            }
            if (i5 != null) {
                b(this.f2885i, i5, -c5);
            }
        }
        this.f2884h.a = this;
        this.f2885i.a = this;
    }

    @Override // c.f.b.k.n.m
    public void e() {
        for (int i2 = 0; i2 < this.f2839k.size(); i2++) {
            this.f2839k.get(i2).e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public void f() {
        this.f2879c = null;
        Iterator<m> it = this.f2839k.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // c.f.b.k.n.m
    public long j() {
        int size = this.f2839k.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.f2839k.get(i2);
            j2 = j2 + mVar.f2884h.f2853f + mVar.j() + mVar.f2885i.f2853f;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // c.f.b.k.n.m
    public boolean m() {
        int size = this.f2839k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f2839k.get(i2).m()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        Iterator<m> it;
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f2882f == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        while (this.f2839k.iterator().hasNext()) {
            sb2 = ((sb2 + "<") + it.next()) + "> ";
        }
        return sb2;
    }
}