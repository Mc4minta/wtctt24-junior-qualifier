package c.f.b;

import c.f.b.b;
import java.util.Arrays;

/* compiled from: SolverVariableValues.java */
/* loaded from: classes.dex */
public class j implements b.a {
    private static float a = 0.001f;

    /* renamed from: b  reason: collision with root package name */
    private final int f2764b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f2765c = 16;

    /* renamed from: d  reason: collision with root package name */
    private int f2766d = 16;

    /* renamed from: e  reason: collision with root package name */
    int[] f2767e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    int[] f2768f = new int[16];

    /* renamed from: g  reason: collision with root package name */
    int[] f2769g = new int[16];

    /* renamed from: h  reason: collision with root package name */
    float[] f2770h = new float[16];

    /* renamed from: i  reason: collision with root package name */
    int[] f2771i = new int[16];

    /* renamed from: j  reason: collision with root package name */
    int[] f2772j = new int[16];

    /* renamed from: k  reason: collision with root package name */
    int f2773k = 0;

    /* renamed from: l  reason: collision with root package name */
    int f2774l = -1;
    private final b m;
    protected final c n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar, c cVar) {
        this.m = bVar;
        this.n = cVar;
        clear();
    }

    private void j(i iVar, int i2) {
        int[] iArr;
        int i3 = iVar.f2750d % this.f2766d;
        int[] iArr2 = this.f2767e;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            iArr2[i3] = i2;
        } else {
            while (true) {
                iArr = this.f2768f;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i2;
        }
        this.f2768f[i2] = -1;
    }

    private void k(int i2, i iVar, float f2) {
        this.f2769g[i2] = iVar.f2750d;
        this.f2770h[i2] = f2;
        this.f2771i[i2] = -1;
        this.f2772j[i2] = -1;
        iVar.a(this.m);
        iVar.n++;
        this.f2773k++;
    }

    private int l() {
        for (int i2 = 0; i2 < this.f2765c; i2++) {
            if (this.f2769g[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void m() {
        int i2 = this.f2765c * 2;
        this.f2769g = Arrays.copyOf(this.f2769g, i2);
        this.f2770h = Arrays.copyOf(this.f2770h, i2);
        this.f2771i = Arrays.copyOf(this.f2771i, i2);
        this.f2772j = Arrays.copyOf(this.f2772j, i2);
        this.f2768f = Arrays.copyOf(this.f2768f, i2);
        for (int i3 = this.f2765c; i3 < i2; i3++) {
            this.f2769g[i3] = -1;
            this.f2768f[i3] = -1;
        }
        this.f2765c = i2;
    }

    private void o(int i2, i iVar, float f2) {
        int l2 = l();
        k(l2, iVar, f2);
        if (i2 != -1) {
            this.f2771i[l2] = i2;
            int[] iArr = this.f2772j;
            iArr[l2] = iArr[i2];
            iArr[i2] = l2;
        } else {
            this.f2771i[l2] = -1;
            if (this.f2773k > 0) {
                this.f2772j[l2] = this.f2774l;
                this.f2774l = l2;
            } else {
                this.f2772j[l2] = -1;
            }
        }
        int[] iArr2 = this.f2772j;
        if (iArr2[l2] != -1) {
            this.f2771i[iArr2[l2]] = l2;
        }
        j(iVar, l2);
    }

    private void p(i iVar) {
        int[] iArr;
        int i2 = iVar.f2750d;
        int i3 = i2 % this.f2766d;
        int[] iArr2 = this.f2767e;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            return;
        }
        if (this.f2769g[i4] == i2) {
            int[] iArr3 = this.f2768f;
            iArr2[i3] = iArr3[i4];
            iArr3[i4] = -1;
            return;
        }
        while (true) {
            iArr = this.f2768f;
            if (iArr[i4] == -1 || this.f2769g[iArr[i4]] == i2) {
                break;
            }
            i4 = iArr[i4];
        }
        int i5 = iArr[i4];
        if (i5 == -1 || this.f2769g[i5] != i2) {
            return;
        }
        iArr[i4] = iArr[i5];
        iArr[i5] = -1;
    }

    @Override // c.f.b.b.a
    public i a(int i2) {
        int i3 = this.f2773k;
        if (i3 == 0) {
            return null;
        }
        int i4 = this.f2774l;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2 && i4 != -1) {
                return this.n.f2726d[this.f2769g[i4]];
            }
            i4 = this.f2772j[i4];
            if (i4 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // c.f.b.b.a
    public float b(int i2) {
        int i3 = this.f2773k;
        int i4 = this.f2774l;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i2) {
                return this.f2770h[i4];
            }
            i4 = this.f2772j[i4];
            if (i4 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // c.f.b.b.a
    public void c(i iVar, float f2, boolean z) {
        float f3 = a;
        if (f2 <= (-f3) || f2 >= f3) {
            int n = n(iVar);
            if (n == -1) {
                g(iVar, f2);
                return;
            }
            float[] fArr = this.f2770h;
            fArr[n] = fArr[n] + f2;
            float f4 = fArr[n];
            float f5 = a;
            if (f4 <= (-f5) || fArr[n] >= f5) {
                return;
            }
            fArr[n] = 0.0f;
            h(iVar, z);
        }
    }

    @Override // c.f.b.b.a
    public void clear() {
        int i2 = this.f2773k;
        for (int i3 = 0; i3 < i2; i3++) {
            i a2 = a(i3);
            if (a2 != null) {
                a2.c(this.m);
            }
        }
        for (int i4 = 0; i4 < this.f2765c; i4++) {
            this.f2769g[i4] = -1;
            this.f2768f[i4] = -1;
        }
        for (int i5 = 0; i5 < this.f2766d; i5++) {
            this.f2767e[i5] = -1;
        }
        this.f2773k = 0;
        this.f2774l = -1;
    }

    @Override // c.f.b.b.a
    public float d(i iVar) {
        int n = n(iVar);
        if (n != -1) {
            return this.f2770h[n];
        }
        return 0.0f;
    }

    @Override // c.f.b.b.a
    public boolean e(i iVar) {
        return n(iVar) != -1;
    }

    @Override // c.f.b.b.a
    public float f(b bVar, boolean z) {
        float d2 = d(bVar.a);
        h(bVar.a, z);
        j jVar = (j) bVar.f2722e;
        int currentSize = jVar.getCurrentSize();
        int i2 = 0;
        int i3 = 0;
        while (i2 < currentSize) {
            int[] iArr = jVar.f2769g;
            if (iArr[i3] != -1) {
                c(this.n.f2726d[iArr[i3]], jVar.f2770h[i3] * d2, z);
                i2++;
            }
            i3++;
        }
        return d2;
    }

    @Override // c.f.b.b.a
    public void g(i iVar, float f2) {
        float f3 = a;
        if (f2 > (-f3) && f2 < f3) {
            h(iVar, true);
            return;
        }
        if (this.f2773k == 0) {
            k(0, iVar, f2);
            j(iVar, 0);
            this.f2774l = 0;
            return;
        }
        int n = n(iVar);
        if (n != -1) {
            this.f2770h[n] = f2;
            return;
        }
        if (this.f2773k + 1 >= this.f2765c) {
            m();
        }
        int i2 = this.f2773k;
        int i3 = this.f2774l;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            int[] iArr = this.f2769g;
            int i6 = iArr[i3];
            int i7 = iVar.f2750d;
            if (i6 == i7) {
                this.f2770h[i3] = f2;
                return;
            }
            if (iArr[i3] < i7) {
                i4 = i3;
            }
            i3 = this.f2772j[i3];
            if (i3 == -1) {
                break;
            }
        }
        o(i4, iVar, f2);
    }

    @Override // c.f.b.b.a
    public int getCurrentSize() {
        return this.f2773k;
    }

    @Override // c.f.b.b.a
    public float h(i iVar, boolean z) {
        int n = n(iVar);
        if (n == -1) {
            return 0.0f;
        }
        p(iVar);
        float f2 = this.f2770h[n];
        if (this.f2774l == n) {
            this.f2774l = this.f2772j[n];
        }
        this.f2769g[n] = -1;
        int[] iArr = this.f2771i;
        if (iArr[n] != -1) {
            int[] iArr2 = this.f2772j;
            iArr2[iArr[n]] = iArr2[n];
        }
        int[] iArr3 = this.f2772j;
        if (iArr3[n] != -1) {
            iArr[iArr3[n]] = iArr[n];
        }
        this.f2773k--;
        iVar.n--;
        if (z) {
            iVar.c(this.m);
        }
        return f2;
    }

    @Override // c.f.b.b.a
    public void i(float f2) {
        int i2 = this.f2773k;
        int i3 = this.f2774l;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f2770h;
            fArr[i3] = fArr[i3] / f2;
            i3 = this.f2772j[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    @Override // c.f.b.b.a
    public void invert() {
        int i2 = this.f2773k;
        int i3 = this.f2774l;
        for (int i4 = 0; i4 < i2; i4++) {
            float[] fArr = this.f2770h;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f2772j[i3];
            if (i3 == -1) {
                return;
            }
        }
    }

    public int n(i iVar) {
        int[] iArr;
        if (this.f2773k == 0) {
            return -1;
        }
        int i2 = iVar.f2750d;
        int i3 = this.f2767e[i2 % this.f2766d];
        if (i3 == -1) {
            return -1;
        }
        if (this.f2769g[i3] == i2) {
            return i3;
        }
        while (true) {
            iArr = this.f2768f;
            if (iArr[i3] == -1 || this.f2769g[iArr[i3]] == i2) {
                break;
            }
            i3 = iArr[i3];
        }
        if (iArr[i3] != -1 && this.f2769g[iArr[i3]] == i2) {
            return iArr[i3];
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i2 = this.f2773k;
        for (int i3 = 0; i3 < i2; i3++) {
            i a2 = a(i3);
            if (a2 != null) {
                String str2 = str + a2 + " = " + b(i3) + " ";
                int n = n(a2);
                String str3 = str2 + "[p: ";
                String str4 = (this.f2771i[n] != -1 ? str3 + this.n.f2726d[this.f2769g[this.f2771i[n]]] : str3 + "none") + ", n: ";
                str = (this.f2772j[n] != -1 ? str4 + this.n.f2726d[this.f2769g[this.f2772j[n]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}