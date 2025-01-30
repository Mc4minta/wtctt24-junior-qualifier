package c.f.b;

import c.f.b.d;
import c.f.b.i;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: e  reason: collision with root package name */
    public a f2722e;
    i a = null;

    /* renamed from: b  reason: collision with root package name */
    float f2719b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f2720c = false;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<i> f2721d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    boolean f2723f = false;

    /* compiled from: ArrayRow.java */
    /* loaded from: classes.dex */
    public interface a {
        i a(int i2);

        float b(int i2);

        void c(i iVar, float f2, boolean z);

        void clear();

        float d(i iVar);

        boolean e(i iVar);

        float f(b bVar, boolean z);

        void g(i iVar, float f2);

        int getCurrentSize();

        float h(i iVar, boolean z);

        void i(float f2);

        void invert();
    }

    public b() {
    }

    private boolean v(i iVar, d dVar) {
        return iVar.n <= 1;
    }

    private i x(boolean[] zArr, i iVar) {
        i.a aVar;
        int currentSize = this.f2722e.getCurrentSize();
        i iVar2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < currentSize; i2++) {
            float b2 = this.f2722e.b(i2);
            if (b2 < 0.0f) {
                i a2 = this.f2722e.a(i2);
                if ((zArr == null || !zArr[a2.f2750d]) && a2 != iVar && (((aVar = a2.f2757k) == i.a.SLACK || aVar == i.a.ERROR) && b2 < f2)) {
                    f2 = b2;
                    iVar2 = a2;
                }
            }
        }
        return iVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String A() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.b.b.A():java.lang.String");
    }

    public void B(d dVar, i iVar, boolean z) {
        if (iVar.f2754h) {
            this.f2719b += iVar.f2753g * this.f2722e.d(iVar);
            this.f2722e.h(iVar, z);
            if (z) {
                iVar.c(this);
            }
        }
    }

    public void C(b bVar, boolean z) {
        this.f2719b += bVar.f2719b * this.f2722e.f(bVar, z);
        if (z) {
            bVar.a.c(this);
        }
    }

    public void D(d dVar) {
        if (dVar.f2736k.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int currentSize = this.f2722e.getCurrentSize();
            for (int i2 = 0; i2 < currentSize; i2++) {
                i a2 = this.f2722e.a(i2);
                if (a2.f2751e != -1 || a2.f2754h) {
                    this.f2721d.add(a2);
                }
            }
            if (this.f2721d.size() > 0) {
                Iterator<i> it = this.f2721d.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (next.f2754h) {
                        B(dVar, next, true);
                    } else {
                        C(dVar.f2736k[next.f2751e], true);
                    }
                }
                this.f2721d.clear();
            } else {
                z = true;
            }
        }
    }

    @Override // c.f.b.d.a
    public void a(i iVar) {
        int i2 = iVar.f2752f;
        float f2 = 1.0f;
        if (i2 != 1) {
            if (i2 == 2) {
                f2 = 1000.0f;
            } else if (i2 == 3) {
                f2 = 1000000.0f;
            } else if (i2 == 4) {
                f2 = 1.0E9f;
            } else if (i2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f2722e.g(iVar, f2);
    }

    @Override // c.f.b.d.a
    public i b(d dVar, boolean[] zArr) {
        return x(zArr, null);
    }

    @Override // c.f.b.d.a
    public void c(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.a = null;
            this.f2722e.clear();
            for (int i2 = 0; i2 < bVar.f2722e.getCurrentSize(); i2++) {
                this.f2722e.c(bVar.f2722e.a(i2), bVar.f2722e.b(i2), true);
            }
        }
    }

    @Override // c.f.b.d.a
    public void clear() {
        this.f2722e.clear();
        this.a = null;
        this.f2719b = 0.0f;
    }

    public b d(d dVar, int i2) {
        this.f2722e.g(dVar.o(i2, "ep"), 1.0f);
        this.f2722e.g(dVar.o(i2, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(i iVar, int i2) {
        this.f2722e.g(iVar, i2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z;
        i g2 = g(dVar);
        if (g2 == null) {
            z = true;
        } else {
            y(g2);
            z = false;
        }
        if (this.f2722e.getCurrentSize() == 0) {
            this.f2723f = true;
        }
        return z;
    }

    i g(d dVar) {
        boolean v;
        boolean v2;
        int currentSize = this.f2722e.getCurrentSize();
        i iVar = null;
        boolean z = false;
        boolean z2 = false;
        float f2 = 0.0f;
        float f3 = 0.0f;
        i iVar2 = null;
        for (int i2 = 0; i2 < currentSize; i2++) {
            float b2 = this.f2722e.b(i2);
            i a2 = this.f2722e.a(i2);
            if (a2.f2757k == i.a.UNRESTRICTED) {
                if (iVar == null) {
                    v2 = v(a2, dVar);
                } else if (f2 > b2) {
                    v2 = v(a2, dVar);
                } else if (!z && v(a2, dVar)) {
                    f2 = b2;
                    iVar = a2;
                    z = true;
                }
                z = v2;
                f2 = b2;
                iVar = a2;
            } else if (iVar == null && b2 < 0.0f) {
                if (iVar2 == null) {
                    v = v(a2, dVar);
                } else if (f3 > b2) {
                    v = v(a2, dVar);
                } else if (!z2 && v(a2, dVar)) {
                    f3 = b2;
                    iVar2 = a2;
                    z2 = true;
                }
                z2 = v;
                f3 = b2;
                iVar2 = a2;
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // c.f.b.d.a
    public i getKey() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3) {
        if (iVar2 == iVar3) {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar4, 1.0f);
            this.f2722e.g(iVar2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
            this.f2722e.g(iVar3, -1.0f);
            this.f2722e.g(iVar4, 1.0f);
            if (i2 > 0 || i3 > 0) {
                this.f2719b = (-i2) + i3;
            }
        } else if (f2 <= 0.0f) {
            this.f2722e.g(iVar, -1.0f);
            this.f2722e.g(iVar2, 1.0f);
            this.f2719b = i2;
        } else if (f2 >= 1.0f) {
            this.f2722e.g(iVar4, -1.0f);
            this.f2722e.g(iVar3, 1.0f);
            this.f2719b = -i3;
        } else {
            float f3 = 1.0f - f2;
            this.f2722e.g(iVar, f3 * 1.0f);
            this.f2722e.g(iVar2, f3 * (-1.0f));
            this.f2722e.g(iVar3, (-1.0f) * f2);
            this.f2722e.g(iVar4, 1.0f * f2);
            if (i2 > 0 || i3 > 0) {
                this.f2719b = ((-i2) * f3) + (i3 * f2);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(i iVar, int i2) {
        this.a = iVar;
        float f2 = i2;
        iVar.f2753g = f2;
        this.f2719b = f2;
        this.f2723f = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(i iVar, i iVar2, float f2) {
        this.f2722e.g(iVar, -1.0f);
        this.f2722e.g(iVar2, f2);
        return this;
    }

    public b k(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2722e.g(iVar, -1.0f);
        this.f2722e.g(iVar2, 1.0f);
        this.f2722e.g(iVar3, f2);
        this.f2722e.g(iVar4, -f2);
        return this;
    }

    public b l(float f2, float f3, float f4, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f2719b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
            this.f2722e.g(iVar4, 1.0f);
            this.f2722e.g(iVar3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f2722e.g(iVar3, 1.0f);
            this.f2722e.g(iVar4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
            this.f2722e.g(iVar4, f5);
            this.f2722e.g(iVar3, -f5);
        }
        return this;
    }

    public b m(i iVar, int i2) {
        if (i2 < 0) {
            this.f2719b = i2 * (-1);
            this.f2722e.g(iVar, 1.0f);
        } else {
            this.f2719b = i2;
            this.f2722e.g(iVar, -1.0f);
        }
        return this;
    }

    public b n(i iVar, i iVar2, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2719b = i2;
        }
        if (!z) {
            this.f2722e.g(iVar, -1.0f);
            this.f2722e.g(iVar2, 1.0f);
        } else {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
        }
        return this;
    }

    public b o(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2719b = i2;
        }
        if (!z) {
            this.f2722e.g(iVar, -1.0f);
            this.f2722e.g(iVar2, 1.0f);
            this.f2722e.g(iVar3, 1.0f);
        } else {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
            this.f2722e.g(iVar3, -1.0f);
        }
        return this;
    }

    public b p(i iVar, i iVar2, i iVar3, int i2) {
        boolean z = false;
        if (i2 != 0) {
            if (i2 < 0) {
                i2 *= -1;
                z = true;
            }
            this.f2719b = i2;
        }
        if (!z) {
            this.f2722e.g(iVar, -1.0f);
            this.f2722e.g(iVar2, 1.0f);
            this.f2722e.g(iVar3, -1.0f);
        } else {
            this.f2722e.g(iVar, 1.0f);
            this.f2722e.g(iVar2, -1.0f);
            this.f2722e.g(iVar3, 1.0f);
        }
        return this;
    }

    public b q(i iVar, i iVar2, i iVar3, i iVar4, float f2) {
        this.f2722e.g(iVar3, 0.5f);
        this.f2722e.g(iVar4, 0.5f);
        this.f2722e.g(iVar, -0.5f);
        this.f2722e.g(iVar2, -0.5f);
        this.f2719b = -f2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f2 = this.f2719b;
        if (f2 < 0.0f) {
            this.f2719b = f2 * (-1.0f);
            this.f2722e.invert();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        i iVar = this.a;
        return iVar != null && (iVar.f2757k == i.a.UNRESTRICTED || this.f2719b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(i iVar) {
        return this.f2722e.e(iVar);
    }

    public String toString() {
        return A();
    }

    public boolean u() {
        return this.a == null && this.f2719b == 0.0f && this.f2722e.getCurrentSize() == 0;
    }

    public i w(i iVar) {
        return x(null, iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(i iVar) {
        i iVar2 = this.a;
        if (iVar2 != null) {
            this.f2722e.g(iVar2, -1.0f);
            this.a = null;
        }
        float h2 = this.f2722e.h(iVar, true) * (-1.0f);
        this.a = iVar;
        if (h2 == 1.0f) {
            return;
        }
        this.f2719b /= h2;
        this.f2722e.i(h2);
    }

    public void z() {
        this.a = null;
        this.f2722e.clear();
        this.f2719b = 0.0f;
        this.f2723f = false;
    }

    public b(c cVar) {
        this.f2722e = new c.f.b.a(this, cVar);
    }
}