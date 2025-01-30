package e.a.a.w.k;

/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class c {
    private final float[] a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f11785b;

    public c(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.f11785b = iArr;
    }

    public int[] a() {
        return this.f11785b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.f11785b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f11785b.length == cVar2.f11785b.length) {
            for (int i2 = 0; i2 < cVar.f11785b.length; i2++) {
                this.a[i2] = e.a.a.z.g.k(cVar.a[i2], cVar2.a[i2], f2);
                this.f11785b[i2] = e.a.a.z.b.c(f2, cVar.f11785b[i2], cVar2.f11785b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f11785b.length + " vs " + cVar2.f11785b.length + ")");
    }
}