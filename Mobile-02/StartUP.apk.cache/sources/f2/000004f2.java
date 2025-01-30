package c.f.b;

import c.f.b.b;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a implements b.a {
    private static float a = 0.001f;

    /* renamed from: c  reason: collision with root package name */
    private final b f2709c;

    /* renamed from: d  reason: collision with root package name */
    protected final c f2710d;

    /* renamed from: b  reason: collision with root package name */
    int f2708b = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f2711e = 8;

    /* renamed from: f  reason: collision with root package name */
    private i f2712f = null;

    /* renamed from: g  reason: collision with root package name */
    private int[] f2713g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private int[] f2714h = new int[8];

    /* renamed from: i  reason: collision with root package name */
    private float[] f2715i = new float[8];

    /* renamed from: j  reason: collision with root package name */
    private int f2716j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f2717k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2718l = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f2709c = bVar;
        this.f2710d = cVar;
    }

    @Override // c.f.b.b.a
    public i a(int i2) {
        int i3 = this.f2716j;
        for (int i4 = 0; i3 != -1 && i4 < this.f2708b; i4++) {
            if (i4 == i2) {
                return this.f2710d.f2726d[this.f2713g[i3]];
            }
            i3 = this.f2714h[i3];
        }
        return null;
    }

    @Override // c.f.b.b.a
    public float b(int i2) {
        int i3 = this.f2716j;
        for (int i4 = 0; i3 != -1 && i4 < this.f2708b; i4++) {
            if (i4 == i2) {
                return this.f2715i[i3];
            }
            i3 = this.f2714h[i3];
        }
        return 0.0f;
    }

    @Override // c.f.b.b.a
    public void c(i iVar, float f2, boolean z) {
        float f3 = a;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.f2716j;
            if (i2 == -1) {
                this.f2716j = 0;
                this.f2715i[0] = f2;
                this.f2713g[0] = iVar.f2750d;
                this.f2714h[0] = -1;
                iVar.n++;
                iVar.a(this.f2709c);
                this.f2708b++;
                if (this.f2718l) {
                    return;
                }
                int i3 = this.f2717k + 1;
                this.f2717k = i3;
                int[] iArr = this.f2713g;
                if (i3 >= iArr.length) {
                    this.f2718l = true;
                    this.f2717k = iArr.length - 1;
                    return;
                }
                return;
            }
            int i4 = -1;
            for (int i5 = 0; i2 != -1 && i5 < this.f2708b; i5++) {
                int[] iArr2 = this.f2713g;
                int i6 = iArr2[i2];
                int i7 = iVar.f2750d;
                if (i6 == i7) {
                    float[] fArr = this.f2715i;
                    float f4 = fArr[i2] + f2;
                    float f5 = a;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    fArr[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.f2716j) {
                            this.f2716j = this.f2714h[i2];
                        } else {
                            int[] iArr3 = this.f2714h;
                            iArr3[i4] = iArr3[i2];
                        }
                        if (z) {
                            iVar.c(this.f2709c);
                        }
                        if (this.f2718l) {
                            this.f2717k = i2;
                        }
                        iVar.n--;
                        this.f2708b--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i7) {
                    i4 = i2;
                }
                i2 = this.f2714h[i2];
            }
            int i8 = this.f2717k;
            int i9 = i8 + 1;
            if (this.f2718l) {
                int[] iArr4 = this.f2713g;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            } else {
                i8 = i9;
            }
            int[] iArr5 = this.f2713g;
            if (i8 >= iArr5.length && this.f2708b < iArr5.length) {
                int i10 = 0;
                while (true) {
                    int[] iArr6 = this.f2713g;
                    if (i10 >= iArr6.length) {
                        break;
                    } else if (iArr6[i10] == -1) {
                        i8 = i10;
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            int[] iArr7 = this.f2713g;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                int i11 = this.f2711e * 2;
                this.f2711e = i11;
                this.f2718l = false;
                this.f2717k = i8 - 1;
                this.f2715i = Arrays.copyOf(this.f2715i, i11);
                this.f2713g = Arrays.copyOf(this.f2713g, this.f2711e);
                this.f2714h = Arrays.copyOf(this.f2714h, this.f2711e);
            }
            this.f2713g[i8] = iVar.f2750d;
            this.f2715i[i8] = f2;
            if (i4 != -1) {
                int[] iArr8 = this.f2714h;
                iArr8[i8] = iArr8[i4];
                iArr8[i4] = i8;
            } else {
                this.f2714h[i8] = this.f2716j;
                this.f2716j = i8;
            }
            iVar.n++;
            iVar.a(this.f2709c);
            this.f2708b++;
            if (!this.f2718l) {
                this.f2717k++;
            }
            int i12 = this.f2717k;
            int[] iArr9 = this.f2713g;
            if (i12 >= iArr9.length) {
                this.f2718l = true;
                this.f2717k = iArr9.length - 1;
            }
        }
    }

    @Override // c.f.b.b.a
    public final void clear() {
        int i2 = this.f2716j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2708b; i3++) {
            i iVar = this.f2710d.f2726d[this.f2713g[i2]];
            if (iVar != null) {
                iVar.c(this.f2709c);
            }
            i2 = this.f2714h[i2];
        }
        this.f2716j = -1;
        this.f2717k = -1;
        this.f2718l = false;
        this.f2708b = 0;
    }

    @Override // c.f.b.b.a
    public final float d(i iVar) {
        int i2 = this.f2716j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2708b; i3++) {
            if (this.f2713g[i2] == iVar.f2750d) {
                return this.f2715i[i2];
            }
            i2 = this.f2714h[i2];
        }
        return 0.0f;
    }

    @Override // c.f.b.b.a
    public boolean e(i iVar) {
        int i2 = this.f2716j;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.f2708b; i3++) {
            if (this.f2713g[i2] == iVar.f2750d) {
                return true;
            }
            i2 = this.f2714h[i2];
        }
        return false;
    }

    @Override // c.f.b.b.a
    public float f(b bVar, boolean z) {
        float d2 = d(bVar.a);
        h(bVar.a, z);
        b.a aVar = bVar.f2722e;
        int currentSize = aVar.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            i a2 = aVar.a(i2);
            c(a2, aVar.d(a2) * d2, z);
        }
        return d2;
    }

    @Override // c.f.b.b.a
    public final void g(i iVar, float f2) {
        if (f2 == 0.0f) {
            h(iVar, true);
            return;
        }
        int i2 = this.f2716j;
        if (i2 == -1) {
            this.f2716j = 0;
            this.f2715i[0] = f2;
            this.f2713g[0] = iVar.f2750d;
            this.f2714h[0] = -1;
            iVar.n++;
            iVar.a(this.f2709c);
            this.f2708b++;
            if (this.f2718l) {
                return;
            }
            int i3 = this.f2717k + 1;
            this.f2717k = i3;
            int[] iArr = this.f2713g;
            if (i3 >= iArr.length) {
                this.f2718l = true;
                this.f2717k = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f2708b; i5++) {
            int[] iArr2 = this.f2713g;
            int i6 = iArr2[i2];
            int i7 = iVar.f2750d;
            if (i6 == i7) {
                this.f2715i[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i4 = i2;
            }
            i2 = this.f2714h[i2];
        }
        int i8 = this.f2717k;
        int i9 = i8 + 1;
        if (this.f2718l) {
            int[] iArr3 = this.f2713g;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f2713g;
        if (i8 >= iArr4.length && this.f2708b < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f2713g;
                if (i10 >= iArr5.length) {
                    break;
                } else if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                } else {
                    i10++;
                }
            }
        }
        int[] iArr6 = this.f2713g;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f2711e * 2;
            this.f2711e = i11;
            this.f2718l = false;
            this.f2717k = i8 - 1;
            this.f2715i = Arrays.copyOf(this.f2715i, i11);
            this.f2713g = Arrays.copyOf(this.f2713g, this.f2711e);
            this.f2714h = Arrays.copyOf(this.f2714h, this.f2711e);
        }
        this.f2713g[i8] = iVar.f2750d;
        this.f2715i[i8] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.f2714h;
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            this.f2714h[i8] = this.f2716j;
            this.f2716j = i8;
        }
        iVar.n++;
        iVar.a(this.f2709c);
        int i12 = this.f2708b + 1;
        this.f2708b = i12;
        if (!this.f2718l) {
            this.f2717k++;
        }
        int[] iArr8 = this.f2713g;
        if (i12 >= iArr8.length) {
            this.f2718l = true;
        }
        if (this.f2717k >= iArr8.length) {
            this.f2718l = true;
            this.f2717k = iArr8.length - 1;
        }
    }

    @Override // c.f.b.b.a
    public int getCurrentSize() {
        return this.f2708b;
    }

    @Override // c.f.b.b.a
    public final float h(i iVar, boolean z) {
        if (this.f2712f == iVar) {
            this.f2712f = null;
        }
        int i2 = this.f2716j;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f2708b) {
            if (this.f2713g[i2] == iVar.f2750d) {
                if (i2 == this.f2716j) {
                    this.f2716j = this.f2714h[i2];
                } else {
                    int[] iArr = this.f2714h;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.c(this.f2709c);
                }
                iVar.n--;
                this.f2708b--;
                this.f2713g[i2] = -1;
                if (this.f2718l) {
                    this.f2717k = i2;
                }
                return this.f2715i[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f2714h[i2];
        }
        return 0.0f;
    }

    @Override // c.f.b.b.a
    public void i(float f2) {
        int i2 = this.f2716j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2708b; i3++) {
            float[] fArr = this.f2715i;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f2714h[i2];
        }
    }

    @Override // c.f.b.b.a
    public void invert() {
        int i2 = this.f2716j;
        for (int i3 = 0; i2 != -1 && i3 < this.f2708b; i3++) {
            float[] fArr = this.f2715i;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f2714h[i2];
        }
    }

    public String toString() {
        int i2 = this.f2716j;
        String str = "";
        for (int i3 = 0; i2 != -1 && i3 < this.f2708b; i3++) {
            str = ((str + " -> ") + this.f2715i[i2] + " : ") + this.f2710d.f2726d[this.f2713g[i2]];
            i2 = this.f2714h[i2];
        }
        return str;
    }
}