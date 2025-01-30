package c.f.b.k;

import c.f.b.k.e;
import c.f.b.k.n.b;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class f extends m {
    public c.f.b.e L0;
    int N0;
    int O0;
    int P0;
    int Q0;
    c.f.b.k.n.b H0 = new c.f.b.k.n.b(this);
    public c.f.b.k.n.e I0 = new c.f.b.k.n.e(this);
    protected b.InterfaceC0060b J0 = null;
    private boolean K0 = false;
    protected c.f.b.d M0 = new c.f.b.d();
    int R0 = 0;
    int S0 = 0;
    c[] T0 = new c[4];
    c[] U0 = new c[4];
    public boolean V0 = false;
    public boolean W0 = false;
    public boolean X0 = false;
    public int Y0 = 0;
    public int Z0 = 0;
    private int a1 = 263;
    public boolean b1 = false;
    private boolean c1 = false;
    private boolean d1 = false;
    int e1 = 0;

    private void R0(e eVar) {
        int i2 = this.R0 + 1;
        c[] cVarArr = this.U0;
        if (i2 >= cVarArr.length) {
            this.U0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.U0[this.R0] = new c(eVar, 0, d1());
        this.R0++;
    }

    private void S0(e eVar) {
        int i2 = this.S0 + 1;
        c[] cVarArr = this.T0;
        if (i2 >= cVarArr.length) {
            this.T0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.T0[this.S0] = new c(eVar, 1, d1());
        this.S0++;
    }

    private void h1() {
        this.R0 = 0;
        this.S0 = 0;
    }

    @Override // c.f.b.k.e
    public void J0(boolean z, boolean z2) {
        super.J0(z, z2);
        int size = this.G0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.G0.get(i2).J0(z, z2);
        }
    }

    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    @Override // c.f.b.k.m
    public void M0() {
        boolean z;
        ?? r11;
        boolean z2;
        this.V = 0;
        this.W = 0;
        int max = Math.max(0, Q());
        int max2 = Math.max(0, w());
        this.c1 = false;
        this.d1 = false;
        boolean z3 = g1(64) || g1(128);
        c.f.b.d dVar = this.M0;
        dVar.f2737l = false;
        dVar.m = false;
        if (this.a1 != 0 && z3) {
            dVar.m = true;
        }
        e.b[] bVarArr = this.P;
        e.b bVar = bVarArr[1];
        e.b bVar2 = bVarArr[0];
        ArrayList<e> arrayList = this.G0;
        e.b z4 = z();
        e.b bVar3 = e.b.WRAP_CONTENT;
        boolean z5 = z4 == bVar3 || N() == bVar3;
        h1();
        int size = this.G0.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.G0.get(i2);
            if (eVar instanceof m) {
                ((m) eVar).M0();
            }
        }
        int i3 = 0;
        boolean z6 = false;
        boolean z7 = true;
        while (z7) {
            int i4 = i3 + 1;
            try {
                this.M0.E();
                h1();
                m(this.M0);
                for (int i5 = 0; i5 < size; i5++) {
                    this.G0.get(i5).m(this.M0);
                }
                z7 = Q0(this.M0);
                if (z7) {
                    this.M0.A();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("EXCEPTION : " + e2);
            }
            if (z7) {
                l1(this.M0, k.a);
            } else {
                K0(this.M0);
                for (int i6 = 0; i6 < size; i6++) {
                    this.G0.get(i6).K0(this.M0);
                }
            }
            if (z5 && i4 < 8 && k.a[2]) {
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < size; i9++) {
                    e eVar2 = this.G0.get(i9);
                    i7 = Math.max(i7, eVar2.V + eVar2.Q());
                    i8 = Math.max(i8, eVar2.W + eVar2.w());
                }
                int max3 = Math.max(this.c0, i7);
                int max4 = Math.max(this.d0, i8);
                e.b bVar4 = e.b.WRAP_CONTENT;
                if (bVar2 != bVar4 || Q() >= max3) {
                    z = false;
                } else {
                    F0(max3);
                    this.P[0] = bVar4;
                    z = true;
                    z6 = true;
                }
                if (bVar == bVar4 && w() < max4) {
                    i0(max4);
                    this.P[1] = bVar4;
                    z = true;
                    z6 = true;
                }
            } else {
                z = false;
            }
            int max5 = Math.max(this.c0, Q());
            if (max5 > Q()) {
                F0(max5);
                this.P[0] = e.b.FIXED;
                z = true;
                z6 = true;
            }
            int max6 = Math.max(this.d0, w());
            if (max6 > w()) {
                i0(max6);
                r11 = 1;
                this.P[1] = e.b.FIXED;
                z = true;
                z2 = true;
            } else {
                r11 = 1;
                z2 = z6;
            }
            if (!z2) {
                e.b bVar5 = this.P[0];
                e.b bVar6 = e.b.WRAP_CONTENT;
                if (bVar5 == bVar6 && max > 0 && Q() > max) {
                    this.c1 = r11;
                    this.P[0] = e.b.FIXED;
                    F0(max);
                    z = r11;
                    z2 = z;
                }
                if (this.P[r11] == bVar6 && max2 > 0 && w() > max2) {
                    this.d1 = r11;
                    this.P[r11] = e.b.FIXED;
                    i0(max2);
                    z7 = true;
                    z6 = true;
                    i3 = i4;
                }
            }
            z7 = z;
            z6 = z2;
            i3 = i4;
        }
        this.G0 = arrayList;
        if (z6) {
            e.b[] bVarArr2 = this.P;
            bVarArr2[0] = bVar2;
            bVarArr2[1] = bVar;
        }
        b0(this.M0.w());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(e eVar, int i2) {
        if (i2 == 0) {
            R0(eVar);
        } else if (i2 == 1) {
            S0(eVar);
        }
    }

    public boolean Q0(c.f.b.d dVar) {
        f(dVar);
        int size = this.G0.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.G0.get(i2);
            eVar.p0(0, false);
            eVar.p0(1, false);
            if (eVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = this.G0.get(i3);
                if (eVar2 instanceof a) {
                    ((a) eVar2).O0();
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            e eVar3 = this.G0.get(i4);
            if (eVar3.e()) {
                eVar3.f(dVar);
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            e eVar4 = this.G0.get(i5);
            if (eVar4 instanceof f) {
                e.b[] bVarArr = eVar4.P;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                e.b bVar3 = e.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    eVar4.m0(e.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    eVar4.B0(e.b.FIXED);
                }
                eVar4.f(dVar);
                if (bVar == bVar3) {
                    eVar4.m0(bVar);
                }
                if (bVar2 == bVar3) {
                    eVar4.B0(bVar2);
                }
            } else {
                k.a(this, dVar, eVar4);
                if (!eVar4.e()) {
                    eVar4.f(dVar);
                }
            }
        }
        if (this.R0 > 0) {
            b.a(this, dVar, 0);
        }
        if (this.S0 > 0) {
            b.a(this, dVar, 1);
        }
        return true;
    }

    public boolean T0(boolean z) {
        return this.I0.f(z);
    }

    public boolean U0(boolean z) {
        return this.I0.g(z);
    }

    public boolean V0(boolean z, int i2) {
        return this.I0.h(z, i2);
    }

    public void W0(c.f.b.e eVar) {
        this.M0.v(eVar);
    }

    public b.InterfaceC0060b X0() {
        return this.J0;
    }

    public int Y0() {
        return this.a1;
    }

    @Override // c.f.b.k.m, c.f.b.k.e
    public void Z() {
        this.M0.E();
        this.N0 = 0;
        this.P0 = 0;
        this.O0 = 0;
        this.Q0 = 0;
        this.b1 = false;
        super.Z();
    }

    public boolean Z0() {
        return false;
    }

    public void a1() {
        this.I0.j();
    }

    public void b1() {
        this.I0.k();
    }

    public boolean c1() {
        return this.d1;
    }

    public boolean d1() {
        return this.K0;
    }

    public boolean e1() {
        return this.c1;
    }

    public long f1(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.N0 = i9;
        this.O0 = i10;
        return this.H0.d(this, i2, i9, i10, i3, i4, i5, i6, i7, i8);
    }

    public boolean g1(int i2) {
        return (this.a1 & i2) == i2;
    }

    public void i1(b.InterfaceC0060b interfaceC0060b) {
        this.J0 = interfaceC0060b;
        this.I0.n(interfaceC0060b);
    }

    public void j1(int i2) {
        this.a1 = i2;
        c.f.b.d.f2728c = k.b(i2, 256);
    }

    public void k1(boolean z) {
        this.K0 = z;
    }

    public void l1(c.f.b.d dVar, boolean[] zArr) {
        zArr[2] = false;
        K0(dVar);
        int size = this.G0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.G0.get(i2).K0(dVar);
        }
    }

    public void m1() {
        this.H0.e(this);
    }
}