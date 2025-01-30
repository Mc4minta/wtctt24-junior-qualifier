package c.f.a.a;

/* compiled from: CurveFit.java */
/* loaded from: classes.dex */
public abstract class b {

    /* compiled from: CurveFit.java */
    /* loaded from: classes.dex */
    static class a extends b {
        double a;

        /* renamed from: b  reason: collision with root package name */
        double[] f2674b;

        a(double d2, double[] dArr) {
            this.a = d2;
            this.f2674b = dArr;
        }

        @Override // c.f.a.a.b
        public double c(double d2, int i2) {
            return this.f2674b[i2];
        }

        @Override // c.f.a.a.b
        public void d(double d2, double[] dArr) {
            double[] dArr2 = this.f2674b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // c.f.a.a.b
        public void e(double d2, float[] fArr) {
            int i2 = 0;
            while (true) {
                double[] dArr = this.f2674b;
                if (i2 >= dArr.length) {
                    return;
                }
                fArr[i2] = (float) dArr[i2];
                i2++;
            }
        }

        @Override // c.f.a.a.b
        public double f(double d2, int i2) {
            return 0.0d;
        }

        @Override // c.f.a.a.b
        public void g(double d2, double[] dArr) {
            for (int i2 = 0; i2 < this.f2674b.length; i2++) {
                dArr[i2] = 0.0d;
            }
        }

        @Override // c.f.a.a.b
        public double[] h() {
            return new double[]{this.a};
        }
    }

    public static b a(int i2, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i2 = 2;
        }
        if (i2 != 0) {
            if (i2 != 2) {
                return new d(dArr, dArr2);
            }
            return new a(dArr[0], dArr2[0]);
        }
        return new e(dArr, dArr2);
    }

    public static b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new c.f.a.a.a(iArr, dArr, dArr2);
    }

    public abstract double c(double d2, int i2);

    public abstract void d(double d2, double[] dArr);

    public abstract void e(double d2, float[] fArr);

    public abstract double f(double d2, int i2);

    public abstract void g(double d2, double[] dArr);

    public abstract double[] h();
}