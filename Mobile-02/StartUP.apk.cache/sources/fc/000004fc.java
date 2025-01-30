package c.f.b;

import c.f.b.b;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: PriorityGoalRow.java */
/* loaded from: classes.dex */
public class h extends c.f.b.b {

    /* renamed from: g  reason: collision with root package name */
    private int f2740g;

    /* renamed from: h  reason: collision with root package name */
    private i[] f2741h;

    /* renamed from: i  reason: collision with root package name */
    private i[] f2742i;

    /* renamed from: j  reason: collision with root package name */
    private int f2743j;

    /* renamed from: k  reason: collision with root package name */
    b f2744k;

    /* renamed from: l  reason: collision with root package name */
    c f2745l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<i> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(i iVar, i iVar2) {
            return iVar.f2750d - iVar2.f2750d;
        }
    }

    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    class b implements Comparable {
        i a;

        /* renamed from: b  reason: collision with root package name */
        h f2746b;

        public b(h hVar) {
            this.f2746b = hVar;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.a.f2750d - ((i) obj).f2750d;
        }

        public boolean h(i iVar, float f2) {
            boolean z = true;
            if (!this.a.f2748b) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float f3 = iVar.f2756j[i2];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f2;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        this.a.f2756j[i2] = f4;
                    } else {
                        this.a.f2756j[i2] = 0.0f;
                    }
                }
                return true;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.a.f2756j;
                fArr[i3] = fArr[i3] + (iVar.f2756j[i3] * f2);
                if (Math.abs(fArr[i3]) < 1.0E-4f) {
                    this.a.f2756j[i3] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                h.this.G(this.a);
            }
            return false;
        }

        public void n(i iVar) {
            this.a = iVar;
        }

        public final boolean q() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f2 = this.a.f2756j[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (f2 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean s(i iVar) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f2 = iVar.f2756j[i2];
                float f3 = this.a.f2756j[i2];
                if (f3 == f2) {
                    i2--;
                } else if (f3 < f2) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            String str = "[ ";
            if (this.a != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.a.f2756j[i2] + " ";
                }
            }
            return str + "] " + this.a;
        }

        public void y() {
            Arrays.fill(this.a.f2756j, 0.0f);
        }
    }

    public h(c cVar) {
        super(cVar);
        this.f2740g = 128;
        this.f2741h = new i[128];
        this.f2742i = new i[128];
        this.f2743j = 0;
        this.f2744k = new b(this);
        this.f2745l = cVar;
    }

    private final void F(i iVar) {
        int i2;
        int i3 = this.f2743j + 1;
        i[] iVarArr = this.f2741h;
        if (i3 > iVarArr.length) {
            i[] iVarArr2 = (i[]) Arrays.copyOf(iVarArr, iVarArr.length * 2);
            this.f2741h = iVarArr2;
            this.f2742i = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
        }
        i[] iVarArr3 = this.f2741h;
        int i4 = this.f2743j;
        iVarArr3[i4] = iVar;
        int i5 = i4 + 1;
        this.f2743j = i5;
        if (i5 > 1 && iVarArr3[i5 - 1].f2750d > iVar.f2750d) {
            int i6 = 0;
            while (true) {
                i2 = this.f2743j;
                if (i6 >= i2) {
                    break;
                }
                this.f2742i[i6] = this.f2741h[i6];
                i6++;
            }
            Arrays.sort(this.f2742i, 0, i2, new a());
            for (int i7 = 0; i7 < this.f2743j; i7++) {
                this.f2741h[i7] = this.f2742i[i7];
            }
        }
        iVar.f2748b = true;
        iVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(i iVar) {
        int i2 = 0;
        while (i2 < this.f2743j) {
            if (this.f2741h[i2] == iVar) {
                while (true) {
                    int i3 = this.f2743j;
                    if (i2 < i3 - 1) {
                        i[] iVarArr = this.f2741h;
                        int i4 = i2 + 1;
                        iVarArr[i2] = iVarArr[i4];
                        i2 = i4;
                    } else {
                        this.f2743j = i3 - 1;
                        iVar.f2748b = false;
                        return;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // c.f.b.b
    public void C(c.f.b.b bVar, boolean z) {
        i iVar = bVar.a;
        if (iVar == null) {
            return;
        }
        b.a aVar = bVar.f2722e;
        int currentSize = aVar.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            i a2 = aVar.a(i2);
            float b2 = aVar.b(i2);
            this.f2744k.n(a2);
            if (this.f2744k.h(iVar, b2)) {
                F(a2);
            }
            this.f2719b += bVar.f2719b * b2;
        }
        G(iVar);
    }

    @Override // c.f.b.b, c.f.b.d.a
    public void a(i iVar) {
        this.f2744k.n(iVar);
        this.f2744k.y();
        iVar.f2756j[iVar.f2752f] = 1.0f;
        F(iVar);
    }

    @Override // c.f.b.b, c.f.b.d.a
    public i b(d dVar, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.f2743j; i3++) {
            i iVar = this.f2741h[i3];
            if (!zArr[iVar.f2750d]) {
                this.f2744k.n(iVar);
                if (i2 == -1) {
                    if (!this.f2744k.q()) {
                    }
                    i2 = i3;
                } else {
                    if (!this.f2744k.s(this.f2741h[i2])) {
                    }
                    i2 = i3;
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.f2741h[i2];
    }

    @Override // c.f.b.b, c.f.b.d.a
    public void clear() {
        this.f2743j = 0;
        this.f2719b = 0.0f;
    }

    @Override // c.f.b.b
    public String toString() {
        String str = " goal -> (" + this.f2719b + ") : ";
        for (int i2 = 0; i2 < this.f2743j; i2++) {
            this.f2744k.n(this.f2741h[i2]);
            str = str + this.f2744k + " ";
        }
        return str;
    }
}