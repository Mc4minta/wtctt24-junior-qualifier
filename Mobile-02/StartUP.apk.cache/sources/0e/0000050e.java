package c.f.b.k;

import c.f.b.k.d;
import c.f.b.k.e;
import java.util.HashMap;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class h extends e {
    protected float G0 = -1.0f;
    protected int H0 = -1;
    protected int I0 = -1;
    private d J0 = this.F;
    private int K0 = 0;
    private int L0 = 0;

    /* compiled from: Guideline.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.b.values().length];
            a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public h() {
        this.N.clear();
        this.N.add(this.J0);
        int length = this.M.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.M[i2] = this.J0;
        }
    }

    @Override // c.f.b.k.e
    public void K0(c.f.b.d dVar) {
        if (H() == null) {
            return;
        }
        int y = dVar.y(this.J0);
        if (this.K0 == 1) {
            G0(y);
            H0(0);
            i0(H().w());
            F0(0);
            return;
        }
        G0(0);
        H0(y);
        F0(H().Q());
        i0(0);
    }

    public int L0() {
        return this.K0;
    }

    public int M0() {
        return this.H0;
    }

    public int N0() {
        return this.I0;
    }

    public float O0() {
        return this.G0;
    }

    public void P0(int i2) {
        if (i2 > -1) {
            this.G0 = -1.0f;
            this.H0 = i2;
            this.I0 = -1;
        }
    }

    public void Q0(int i2) {
        if (i2 > -1) {
            this.G0 = -1.0f;
            this.H0 = -1;
            this.I0 = i2;
        }
    }

    public void R0(float f2) {
        if (f2 > -1.0f) {
            this.G0 = f2;
            this.H0 = -1;
            this.I0 = -1;
        }
    }

    public void S0(int i2) {
        if (this.K0 == i2) {
            return;
        }
        this.K0 = i2;
        this.N.clear();
        if (this.K0 == 1) {
            this.J0 = this.E;
        } else {
            this.J0 = this.F;
        }
        this.N.add(this.J0);
        int length = this.M.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.M[i3] = this.J0;
        }
    }

    @Override // c.f.b.k.e
    public void f(c.f.b.d dVar) {
        f fVar = (f) H();
        if (fVar == null) {
            return;
        }
        d n = fVar.n(d.b.LEFT);
        d n2 = fVar.n(d.b.RIGHT);
        e eVar = this.Q;
        boolean z = true;
        boolean z2 = eVar != null && eVar.P[0] == e.b.WRAP_CONTENT;
        if (this.K0 == 0) {
            n = fVar.n(d.b.TOP);
            n2 = fVar.n(d.b.BOTTOM);
            e eVar2 = this.Q;
            if (eVar2 == null || eVar2.P[1] != e.b.WRAP_CONTENT) {
                z = false;
            }
            z2 = z;
        }
        if (this.H0 != -1) {
            c.f.b.i q = dVar.q(this.J0);
            dVar.e(q, dVar.q(n), this.H0, 8);
            if (z2) {
                dVar.h(dVar.q(n2), q, 0, 5);
            }
        } else if (this.I0 != -1) {
            c.f.b.i q2 = dVar.q(this.J0);
            c.f.b.i q3 = dVar.q(n2);
            dVar.e(q2, q3, -this.I0, 8);
            if (z2) {
                dVar.h(q2, dVar.q(n), 0, 5);
                dVar.h(q3, q2, 0, 5);
            }
        } else if (this.G0 != -1.0f) {
            dVar.d(c.f.b.d.s(dVar, dVar.q(this.J0), dVar.q(n2), this.G0));
        }
    }

    @Override // c.f.b.k.e
    public boolean g() {
        return true;
    }

    @Override // c.f.b.k.e
    public void l(e eVar, HashMap<e, e> hashMap) {
        super.l(eVar, hashMap);
        h hVar = (h) eVar;
        this.G0 = hVar.G0;
        this.H0 = hVar.H0;
        this.I0 = hVar.I0;
        S0(hVar.K0);
    }

    @Override // c.f.b.k.e
    public d n(d.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
            case 2:
                if (this.K0 == 1) {
                    return this.J0;
                }
                break;
            case 3:
            case 4:
                if (this.K0 == 0) {
                    return this.J0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(bVar.name());
    }
}