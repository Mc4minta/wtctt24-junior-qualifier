package c.f.a.a;

import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArcCurveFit.java */
/* loaded from: classes.dex */
public class a extends b {
    private final double[] a;

    /* renamed from: b  reason: collision with root package name */
    C0059a[] f2662b;

    /* compiled from: ArcCurveFit.java */
    /* renamed from: c.f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0059a {
        private static double[] a = new double[91];

        /* renamed from: b  reason: collision with root package name */
        double[] f2663b;

        /* renamed from: c  reason: collision with root package name */
        double f2664c;

        /* renamed from: d  reason: collision with root package name */
        double f2665d;

        /* renamed from: e  reason: collision with root package name */
        double f2666e;

        /* renamed from: f  reason: collision with root package name */
        double f2667f;

        /* renamed from: g  reason: collision with root package name */
        double f2668g;

        /* renamed from: h  reason: collision with root package name */
        double f2669h;

        /* renamed from: i  reason: collision with root package name */
        double f2670i;

        /* renamed from: j  reason: collision with root package name */
        double f2671j;

        /* renamed from: k  reason: collision with root package name */
        double f2672k;

        /* renamed from: l  reason: collision with root package name */
        double f2673l;
        double m;
        double n;
        double o;
        double p;
        double q;
        boolean r;
        boolean s;

        C0059a(int i2, double d2, double d3, double d4, double d5, double d6, double d7) {
            this.s = false;
            this.r = i2 == 1;
            this.f2665d = d2;
            this.f2666e = d3;
            this.f2671j = 1.0d / (d3 - d2);
            if (3 == i2) {
                this.s = true;
            }
            double d8 = d6 - d4;
            double d9 = d7 - d5;
            if (!this.s && Math.abs(d8) >= 0.001d && Math.abs(d9) >= 0.001d) {
                this.f2663b = new double[101];
                boolean z = this.r;
                this.f2672k = d8 * (z ? -1 : 1);
                this.f2673l = d9 * (z ? 1 : -1);
                this.m = z ? d6 : d4;
                this.n = z ? d5 : d7;
                a(d4, d5, d6, d7);
                this.o = this.f2664c * this.f2671j;
                return;
            }
            this.s = true;
            this.f2667f = d4;
            this.f2668g = d6;
            this.f2669h = d5;
            this.f2670i = d7;
            double hypot = Math.hypot(d9, d8);
            this.f2664c = hypot;
            this.o = hypot * this.f2671j;
            double d10 = this.f2666e;
            double d11 = this.f2665d;
            this.m = d8 / (d10 - d11);
            this.n = d9 / (d10 - d11);
        }

        private void a(double d2, double d3, double d4, double d5) {
            double[] dArr;
            double[] dArr2;
            double d6;
            double d7 = d4 - d2;
            double d8 = d3 - d5;
            int i2 = 0;
            double d9 = 0.0d;
            double d10 = 0.0d;
            double d11 = 0.0d;
            while (true) {
                if (i2 >= a.length) {
                    break;
                }
                double d12 = d9;
                double radians = Math.toRadians((i2 * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians) * d7;
                double cos = Math.cos(radians) * d8;
                if (i2 > 0) {
                    d6 = Math.hypot(sin - d10, cos - d11) + d12;
                    a[i2] = d6;
                } else {
                    d6 = d12;
                }
                i2++;
                d11 = cos;
                d9 = d6;
                d10 = sin;
            }
            double d13 = d9;
            this.f2664c = d13;
            int i3 = 0;
            while (true) {
                double[] dArr3 = a;
                if (i3 >= dArr3.length) {
                    break;
                }
                dArr3[i3] = dArr3[i3] / d13;
                i3++;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.f2663b.length) {
                    return;
                }
                double length = i4 / (dArr2.length - 1);
                int binarySearch = Arrays.binarySearch(a, length);
                if (binarySearch >= 0) {
                    this.f2663b[i4] = binarySearch / (a.length - 1);
                } else if (binarySearch == -1) {
                    this.f2663b[i4] = 0.0d;
                } else {
                    int i5 = -binarySearch;
                    int i6 = i5 - 2;
                    double[] dArr4 = a;
                    this.f2663b[i4] = (i6 + ((length - dArr4[i6]) / (dArr4[i5 - 1] - dArr4[i6]))) / (dArr4.length - 1);
                }
                i4++;
            }
        }

        double b() {
            double d2 = this.f2672k * this.q;
            double hypot = this.o / Math.hypot(d2, (-this.f2673l) * this.p);
            if (this.r) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        double c() {
            double d2 = this.f2672k * this.q;
            double d3 = (-this.f2673l) * this.p;
            double hypot = this.o / Math.hypot(d2, d3);
            return this.r ? (-d3) * hypot : d3 * hypot;
        }

        public double d(double d2) {
            return this.m;
        }

        public double e(double d2) {
            return this.n;
        }

        public double f(double d2) {
            double d3 = (d2 - this.f2665d) * this.f2671j;
            double d4 = this.f2667f;
            return d4 + (d3 * (this.f2668g - d4));
        }

        public double g(double d2) {
            double d3 = (d2 - this.f2665d) * this.f2671j;
            double d4 = this.f2669h;
            return d4 + (d3 * (this.f2670i - d4));
        }

        double h() {
            return this.m + (this.f2672k * this.p);
        }

        double i() {
            return this.n + (this.f2673l * this.q);
        }

        double j(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f2663b;
            double length = d2 * (dArr.length - 1);
            int i2 = (int) length;
            return dArr[i2] + ((length - i2) * (dArr[i2 + 1] - dArr[i2]));
        }

        void k(double d2) {
            double j2 = j((this.r ? this.f2666e - d2 : d2 - this.f2665d) * this.f2671j) * 1.5707963267948966d;
            this.p = Math.sin(j2);
            this.q = Math.cos(j2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r5 == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r0.a = r1
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            c.f.a.a.a$a[] r2 = new c.f.a.a.a.C0059a[r2]
            r0.f2662b = r2
            r2 = 0
            r4 = r2
            r5 = r3
            r6 = r5
        L14:
            c.f.a.a.a$a[] r7 = r0.f2662b
            int r8 = r7.length
            if (r4 >= r8) goto L51
            r8 = r25[r4]
            r9 = 3
            r10 = 2
            if (r8 == 0) goto L2d
            if (r8 == r3) goto L2a
            if (r8 == r10) goto L28
            if (r8 == r9) goto L26
            goto L2e
        L26:
            if (r5 != r3) goto L2a
        L28:
            r5 = r10
            goto L2b
        L2a:
            r5 = r3
        L2b:
            r6 = r5
            goto L2e
        L2d:
            r6 = r9
        L2e:
            c.f.a.a.a$a r22 = new c.f.a.a.a$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r2]
            r8 = r27[r4]
            r16 = r8[r3]
            r8 = r27[r23]
            r18 = r8[r2]
            r8 = r27[r23]
            r20 = r8[r3]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L14
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.a.a.a.<init>(int[], double[], double[][]):void");
    }

    @Override // c.f.a.a.b
    public double c(double d2, int i2) {
        C0059a[] c0059aArr = this.f2662b;
        int i3 = 0;
        if (d2 < c0059aArr[0].f2665d) {
            d2 = c0059aArr[0].f2665d;
        } else if (d2 > c0059aArr[c0059aArr.length - 1].f2666e) {
            d2 = c0059aArr[c0059aArr.length - 1].f2666e;
        }
        while (true) {
            C0059a[] c0059aArr2 = this.f2662b;
            if (i3 >= c0059aArr2.length) {
                return Double.NaN;
            }
            if (d2 <= c0059aArr2[i3].f2666e) {
                if (c0059aArr2[i3].s) {
                    if (i2 == 0) {
                        return c0059aArr2[i3].f(d2);
                    }
                    return c0059aArr2[i3].g(d2);
                }
                c0059aArr2[i3].k(d2);
                if (i2 == 0) {
                    return this.f2662b[i3].h();
                }
                return this.f2662b[i3].i();
            }
            i3++;
        }
    }

    @Override // c.f.a.a.b
    public void d(double d2, double[] dArr) {
        C0059a[] c0059aArr = this.f2662b;
        if (d2 < c0059aArr[0].f2665d) {
            d2 = c0059aArr[0].f2665d;
        }
        if (d2 > c0059aArr[c0059aArr.length - 1].f2666e) {
            d2 = c0059aArr[c0059aArr.length - 1].f2666e;
        }
        int i2 = 0;
        while (true) {
            C0059a[] c0059aArr2 = this.f2662b;
            if (i2 >= c0059aArr2.length) {
                return;
            }
            if (d2 <= c0059aArr2[i2].f2666e) {
                if (c0059aArr2[i2].s) {
                    dArr[0] = c0059aArr2[i2].f(d2);
                    dArr[1] = this.f2662b[i2].g(d2);
                    return;
                }
                c0059aArr2[i2].k(d2);
                dArr[0] = this.f2662b[i2].h();
                dArr[1] = this.f2662b[i2].i();
                return;
            }
            i2++;
        }
    }

    @Override // c.f.a.a.b
    public void e(double d2, float[] fArr) {
        C0059a[] c0059aArr = this.f2662b;
        if (d2 < c0059aArr[0].f2665d) {
            d2 = c0059aArr[0].f2665d;
        } else if (d2 > c0059aArr[c0059aArr.length - 1].f2666e) {
            d2 = c0059aArr[c0059aArr.length - 1].f2666e;
        }
        int i2 = 0;
        while (true) {
            C0059a[] c0059aArr2 = this.f2662b;
            if (i2 >= c0059aArr2.length) {
                return;
            }
            if (d2 <= c0059aArr2[i2].f2666e) {
                if (c0059aArr2[i2].s) {
                    fArr[0] = (float) c0059aArr2[i2].f(d2);
                    fArr[1] = (float) this.f2662b[i2].g(d2);
                    return;
                }
                c0059aArr2[i2].k(d2);
                fArr[0] = (float) this.f2662b[i2].h();
                fArr[1] = (float) this.f2662b[i2].i();
                return;
            }
            i2++;
        }
    }

    @Override // c.f.a.a.b
    public double f(double d2, int i2) {
        C0059a[] c0059aArr = this.f2662b;
        int i3 = 0;
        if (d2 < c0059aArr[0].f2665d) {
            d2 = c0059aArr[0].f2665d;
        }
        if (d2 > c0059aArr[c0059aArr.length - 1].f2666e) {
            d2 = c0059aArr[c0059aArr.length - 1].f2666e;
        }
        while (true) {
            C0059a[] c0059aArr2 = this.f2662b;
            if (i3 >= c0059aArr2.length) {
                return Double.NaN;
            }
            if (d2 <= c0059aArr2[i3].f2666e) {
                if (c0059aArr2[i3].s) {
                    if (i2 == 0) {
                        return c0059aArr2[i3].d(d2);
                    }
                    return c0059aArr2[i3].e(d2);
                }
                c0059aArr2[i3].k(d2);
                if (i2 == 0) {
                    return this.f2662b[i3].b();
                }
                return this.f2662b[i3].c();
            }
            i3++;
        }
    }

    @Override // c.f.a.a.b
    public void g(double d2, double[] dArr) {
        C0059a[] c0059aArr = this.f2662b;
        if (d2 < c0059aArr[0].f2665d) {
            d2 = c0059aArr[0].f2665d;
        } else if (d2 > c0059aArr[c0059aArr.length - 1].f2666e) {
            d2 = c0059aArr[c0059aArr.length - 1].f2666e;
        }
        int i2 = 0;
        while (true) {
            C0059a[] c0059aArr2 = this.f2662b;
            if (i2 >= c0059aArr2.length) {
                return;
            }
            if (d2 <= c0059aArr2[i2].f2666e) {
                if (c0059aArr2[i2].s) {
                    dArr[0] = c0059aArr2[i2].d(d2);
                    dArr[1] = this.f2662b[i2].e(d2);
                    return;
                }
                c0059aArr2[i2].k(d2);
                dArr[0] = this.f2662b[i2].b();
                dArr[1] = this.f2662b[i2].c();
                return;
            }
            i2++;
        }
    }

    @Override // c.f.a.a.b
    public double[] h() {
        return this.a;
    }
}