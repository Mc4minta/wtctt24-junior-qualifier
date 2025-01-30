package e.f.h.f;

import e.f.d.c.i;
import java.util.Arrays;

/* compiled from: RoundingParams.java */
/* loaded from: classes2.dex */
public class d {
    private a a = a.BITMAP_ONLY;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12348b = false;

    /* renamed from: c  reason: collision with root package name */
    private float[] f12349c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f12350d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f12351e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f12352f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f12353g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12354h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12355i = false;

    /* compiled from: RoundingParams.java */
    /* loaded from: classes2.dex */
    public enum a {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static d a(float f2) {
        return new d().n(f2);
    }

    private float[] e() {
        if (this.f12349c == null) {
            this.f12349c = new float[8];
        }
        return this.f12349c;
    }

    public int b() {
        return this.f12352f;
    }

    public float c() {
        return this.f12351e;
    }

    public float[] d() {
        return this.f12349c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f12348b == dVar.f12348b && this.f12350d == dVar.f12350d && Float.compare(dVar.f12351e, this.f12351e) == 0 && this.f12352f == dVar.f12352f && Float.compare(dVar.f12353g, this.f12353g) == 0 && this.a == dVar.a && this.f12354h == dVar.f12354h && this.f12355i == dVar.f12355i) {
            return Arrays.equals(this.f12349c, dVar.f12349c);
        }
        return false;
    }

    public int f() {
        return this.f12350d;
    }

    public float g() {
        return this.f12353g;
    }

    public boolean h() {
        return this.f12355i;
    }

    public int hashCode() {
        a aVar = this.a;
        int hashCode = (((aVar != null ? aVar.hashCode() : 0) * 31) + (this.f12348b ? 1 : 0)) * 31;
        float[] fArr = this.f12349c;
        int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.f12350d) * 31;
        float f2 = this.f12351e;
        int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f12352f) * 31;
        float f3 = this.f12353g;
        return ((((floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31) + (this.f12354h ? 1 : 0)) * 31) + (this.f12355i ? 1 : 0);
    }

    public boolean i() {
        return this.f12348b;
    }

    public a j() {
        return this.a;
    }

    public boolean k() {
        return this.f12354h;
    }

    public d l(int i2, float f2) {
        i.c(f2 >= 0.0f, "the border width cannot be < 0");
        this.f12351e = f2;
        this.f12352f = i2;
        return this;
    }

    public d m(float f2, float f3, float f4, float f5) {
        float[] e2 = e();
        e2[1] = f2;
        e2[0] = f2;
        e2[3] = f3;
        e2[2] = f3;
        e2[5] = f4;
        e2[4] = f4;
        e2[7] = f5;
        e2[6] = f5;
        return this;
    }

    public d n(float f2) {
        Arrays.fill(e(), f2);
        return this;
    }

    public d o(int i2) {
        this.f12350d = i2;
        this.a = a.OVERLAY_COLOR;
        return this;
    }

    public d p(a aVar) {
        this.a = aVar;
        return this;
    }
}