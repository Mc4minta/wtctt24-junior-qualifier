package c.f.b;

import java.util.Arrays;
import java.util.HashSet;

/* compiled from: SolverVariable.java */
/* loaded from: classes.dex */
public class i {
    private static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2748b;

    /* renamed from: c  reason: collision with root package name */
    private String f2749c;

    /* renamed from: g  reason: collision with root package name */
    public float f2753g;

    /* renamed from: k  reason: collision with root package name */
    a f2757k;

    /* renamed from: d  reason: collision with root package name */
    public int f2750d = -1;

    /* renamed from: e  reason: collision with root package name */
    int f2751e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f2752f = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2754h = false;

    /* renamed from: i  reason: collision with root package name */
    float[] f2755i = new float[9];

    /* renamed from: j  reason: collision with root package name */
    float[] f2756j = new float[9];

    /* renamed from: l  reason: collision with root package name */
    b[] f2758l = new b[16];
    int m = 0;
    public int n = 0;
    HashSet<b> o = null;

    /* compiled from: SolverVariable.java */
    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.f2757k = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        a++;
    }

    public final void a(b bVar) {
        int i2 = 0;
        while (true) {
            int i3 = this.m;
            if (i2 < i3) {
                if (this.f2758l[i2] == bVar) {
                    return;
                }
                i2++;
            } else {
                b[] bVarArr = this.f2758l;
                if (i3 >= bVarArr.length) {
                    this.f2758l = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f2758l;
                int i4 = this.m;
                bVarArr2[i4] = bVar;
                this.m = i4 + 1;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i2 = this.m;
        int i3 = 0;
        while (i3 < i2) {
            if (this.f2758l[i3] == bVar) {
                while (i3 < i2 - 1) {
                    b[] bVarArr = this.f2758l;
                    int i4 = i3 + 1;
                    bVarArr[i3] = bVarArr[i4];
                    i3 = i4;
                }
                this.m--;
                return;
            }
            i3++;
        }
    }

    public void d() {
        this.f2749c = null;
        this.f2757k = a.UNKNOWN;
        this.f2752f = 0;
        this.f2750d = -1;
        this.f2751e = -1;
        this.f2753g = 0.0f;
        this.f2754h = false;
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2758l[i3] = null;
        }
        this.m = 0;
        this.n = 0;
        this.f2748b = false;
        Arrays.fill(this.f2756j, 0.0f);
    }

    public void e(d dVar, float f2) {
        this.f2753g = f2;
        this.f2754h = true;
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2758l[i3].B(dVar, this, false);
        }
        this.m = 0;
    }

    public void f(a aVar, String str) {
        this.f2757k = aVar;
    }

    public final void g(b bVar) {
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f2758l[i3].C(bVar, false);
        }
        this.m = 0;
    }

    public String toString() {
        if (this.f2749c != null) {
            return "" + this.f2749c;
        }
        return "" + this.f2750d;
    }
}