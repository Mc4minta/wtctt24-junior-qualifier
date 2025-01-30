package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.d;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionPaths.java */
/* loaded from: classes.dex */
public class q implements Comparable<q> {
    static String[] a = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    c.f.a.a.c f1164b;

    /* renamed from: c  reason: collision with root package name */
    int f1165c;

    /* renamed from: d  reason: collision with root package name */
    float f1166d;

    /* renamed from: e  reason: collision with root package name */
    float f1167e;

    /* renamed from: f  reason: collision with root package name */
    float f1168f;

    /* renamed from: g  reason: collision with root package name */
    float f1169g;

    /* renamed from: h  reason: collision with root package name */
    float f1170h;

    /* renamed from: j  reason: collision with root package name */
    float f1171j;

    /* renamed from: k  reason: collision with root package name */
    float f1172k;

    /* renamed from: l  reason: collision with root package name */
    float f1173l;
    int m;
    LinkedHashMap<String, androidx.constraintlayout.widget.a> n;
    int p;
    double[] q;
    double[] t;

    public q() {
        this.f1165c = 0;
        this.f1172k = Float.NaN;
        this.f1173l = Float.NaN;
        this.m = c.a;
        this.n = new LinkedHashMap<>();
        this.p = 0;
        this.q = new double[18];
        this.t = new double[18];
    }

    private boolean q(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int A(String str, double[] dArr, int i2) {
        androidx.constraintlayout.widget.a aVar = this.n.get(str);
        if (aVar.f() == 1) {
            dArr[i2] = aVar.d();
            return 1;
        }
        int f2 = aVar.f();
        float[] fArr = new float[f2];
        aVar.e(fArr);
        int i3 = 0;
        while (i3 < f2) {
            dArr[i2] = fArr[i3];
            i3++;
            i2++;
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int B(String str) {
        return this.n.get(str).f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.f1168f;
        float f3 = this.f1169g;
        float f4 = this.f1170h;
        float f5 = this.f1171j;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i5 = i2 + 1;
        fArr[i2] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f3 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f7 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f3 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        int i10 = i9 + 1;
        fArr[i9] = f8 + 0.0f;
        fArr[i10] = f2 + 0.0f;
        fArr[i10 + 1] = f8 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D(String str) {
        return this.n.containsKey(str);
    }

    void E(i iVar, q qVar, q qVar2) {
        float f2 = iVar.f1082b / 100.0f;
        this.f1166d = f2;
        this.f1165c = iVar.f1124j;
        float f3 = Float.isNaN(iVar.f1125k) ? f2 : iVar.f1125k;
        float f4 = Float.isNaN(iVar.f1126l) ? f2 : iVar.f1126l;
        float f5 = qVar2.f1170h;
        float f6 = qVar.f1170h;
        float f7 = qVar2.f1171j;
        float f8 = qVar.f1171j;
        this.f1167e = this.f1166d;
        float f9 = qVar.f1168f;
        float f10 = qVar.f1169g;
        float f11 = (qVar2.f1168f + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
        float f12 = (qVar2.f1169g + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
        float f13 = (f5 - f6) * f3;
        float f14 = f13 / 2.0f;
        this.f1168f = (int) ((f9 + (f11 * f2)) - f14);
        float f15 = (f7 - f8) * f4;
        float f16 = f15 / 2.0f;
        this.f1169g = (int) ((f10 + (f12 * f2)) - f16);
        this.f1170h = (int) (f6 + f13);
        this.f1171j = (int) (f8 + f15);
        float f17 = Float.isNaN(iVar.m) ? f2 : iVar.m;
        float f18 = Float.isNaN(iVar.p) ? 0.0f : iVar.p;
        if (!Float.isNaN(iVar.n)) {
            f2 = iVar.n;
        }
        float f19 = Float.isNaN(iVar.o) ? 0.0f : iVar.o;
        this.p = 2;
        this.f1168f = (int) (((qVar.f1168f + (f17 * f11)) + (f19 * f12)) - f14);
        this.f1169g = (int) (((qVar.f1169g + (f11 * f18)) + (f12 * f2)) - f16);
        this.f1164b = c.f.a.a.c.c(iVar.f1122h);
        this.m = iVar.f1123i;
    }

    void F(i iVar, q qVar, q qVar2) {
        float f2;
        float f3;
        float f4 = iVar.f1082b / 100.0f;
        this.f1166d = f4;
        this.f1165c = iVar.f1124j;
        float f5 = Float.isNaN(iVar.f1125k) ? f4 : iVar.f1125k;
        float f6 = Float.isNaN(iVar.f1126l) ? f4 : iVar.f1126l;
        float f7 = qVar2.f1170h - qVar.f1170h;
        float f8 = qVar2.f1171j - qVar.f1171j;
        this.f1167e = this.f1166d;
        if (!Float.isNaN(iVar.m)) {
            f4 = iVar.m;
        }
        float f9 = qVar.f1168f;
        float f10 = qVar.f1170h;
        float f11 = qVar.f1169g;
        float f12 = qVar.f1171j;
        float f13 = (qVar2.f1168f + (qVar2.f1170h / 2.0f)) - ((f10 / 2.0f) + f9);
        float f14 = (qVar2.f1169g + (qVar2.f1171j / 2.0f)) - ((f12 / 2.0f) + f11);
        float f15 = f13 * f4;
        float f16 = (f7 * f5) / 2.0f;
        this.f1168f = (int) ((f9 + f15) - f16);
        float f17 = f4 * f14;
        float f18 = (f8 * f6) / 2.0f;
        this.f1169g = (int) ((f11 + f17) - f18);
        this.f1170h = (int) (f10 + f2);
        this.f1171j = (int) (f12 + f3);
        float f19 = Float.isNaN(iVar.n) ? 0.0f : iVar.n;
        this.p = 1;
        float f20 = (int) ((qVar.f1168f + f15) - f16);
        this.f1168f = f20;
        float f21 = (int) ((qVar.f1169g + f17) - f18);
        this.f1169g = f21;
        this.f1168f = f20 + ((-f14) * f19);
        this.f1169g = f21 + (f13 * f19);
        this.f1164b = c.f.a.a.c.c(iVar.f1122h);
        this.m = iVar.f1123i;
    }

    void G(int i2, int i3, i iVar, q qVar, q qVar2) {
        float f2 = iVar.f1082b / 100.0f;
        this.f1166d = f2;
        this.f1165c = iVar.f1124j;
        float f3 = Float.isNaN(iVar.f1125k) ? f2 : iVar.f1125k;
        float f4 = Float.isNaN(iVar.f1126l) ? f2 : iVar.f1126l;
        float f5 = qVar2.f1170h;
        float f6 = qVar.f1170h;
        float f7 = qVar2.f1171j;
        float f8 = qVar.f1171j;
        this.f1167e = this.f1166d;
        float f9 = qVar.f1168f;
        float f10 = qVar.f1169g;
        float f11 = qVar2.f1168f + (f5 / 2.0f);
        float f12 = qVar2.f1169g + (f7 / 2.0f);
        float f13 = (f5 - f6) * f3;
        this.f1168f = (int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f));
        float f14 = (f7 - f8) * f4;
        this.f1169g = (int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f));
        this.f1170h = (int) (f6 + f13);
        this.f1171j = (int) (f8 + f14);
        this.p = 3;
        if (!Float.isNaN(iVar.m)) {
            this.f1168f = (int) (iVar.m * ((int) (i2 - this.f1170h)));
        }
        if (!Float.isNaN(iVar.n)) {
            this.f1169g = (int) (iVar.n * ((int) (i3 - this.f1171j)));
        }
        this.f1164b = c.f.a.a.c.c(iVar.f1122h);
        this.m = iVar.f1123i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(float f2, float f3, float f4, float f5) {
        this.f1168f = f2;
        this.f1169g = f3;
        this.f1170h = f4;
        this.f1171j = f5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f8 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
        fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        boolean z;
        float f3 = this.f1168f;
        float f4 = this.f1169g;
        float f5 = this.f1170h;
        float f6 = this.f1171j;
        boolean z2 = true;
        if (iArr.length != 0 && this.q.length <= iArr[iArr.length - 1]) {
            int i2 = iArr[iArr.length - 1] + 1;
            this.q = new double[i2];
            this.t = new double[i2];
        }
        Arrays.fill(this.q, Double.NaN);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.q[iArr[i3]] = dArr[i3];
            this.t[iArr[i3]] = dArr2[i3];
        }
        int i4 = 0;
        float f7 = Float.NaN;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        while (true) {
            double[] dArr4 = this.q;
            if (i4 >= dArr4.length) {
                break;
            }
            if (Double.isNaN(dArr4[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                f2 = f3;
                z = z2;
            } else {
                double d2 = dArr3 != null ? dArr3[i4] : 0.0d;
                if (!Double.isNaN(this.q[i4])) {
                    d2 = this.q[i4] + d2;
                }
                f2 = f3;
                float f12 = (float) d2;
                float f13 = (float) this.t[i4];
                z = true;
                if (i4 == 1) {
                    f8 = f13;
                    f3 = f12;
                } else if (i4 == 2) {
                    f4 = f12;
                    f10 = f13;
                } else if (i4 == 3) {
                    f5 = f12;
                    f9 = f13;
                } else if (i4 == 4) {
                    f6 = f12;
                    f11 = f13;
                } else if (i4 == 5) {
                    f3 = f2;
                    f7 = f12;
                }
                i4++;
                z2 = z;
            }
            f3 = f2;
            i4++;
            z2 = z;
        }
        float f14 = f3;
        boolean z3 = z2;
        if (Float.isNaN(f7)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            view.setRotation((float) ((Float.isNaN(Float.NaN) ? 0.0f : Float.NaN) + f7 + Math.toDegrees(Math.atan2(f10 + (f11 / 2.0f), f8 + (f9 / 2.0f)))));
        }
        float f15 = f14 + 0.5f;
        int i5 = (int) f15;
        float f16 = f4 + 0.5f;
        int i6 = (int) f16;
        int i7 = (int) (f15 + f5);
        int i8 = (int) (f16 + f6);
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        if ((i9 == view.getMeasuredWidth() && i10 == view.getMeasuredHeight()) ? false : z3) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i9, 1073741824), View.MeasureSpec.makeMeasureSpec(i10, 1073741824));
        }
        view.layout(i5, i6, i7, i8);
    }

    public void h(d.a aVar) {
        this.f1164b = c.f.a.a.c.c(aVar.f1291c.f1308d);
        d.c cVar = aVar.f1291c;
        this.m = cVar.f1309e;
        this.f1172k = cVar.f1312h;
        this.f1165c = cVar.f1310f;
        this.f1173l = aVar.f1290b.f1316e;
        for (String str : aVar.f1294f.keySet()) {
            androidx.constraintlayout.widget.a aVar2 = aVar.f1294f.get(str);
            if (aVar2.c() != a.b.STRING_TYPE) {
                this.n.put(str, aVar2);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: n */
    public int compareTo(q qVar) {
        return Float.compare(this.f1167e, qVar.f1167e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(q qVar, boolean[] zArr, String[] strArr, boolean z) {
        zArr[0] = zArr[0] | q(this.f1167e, qVar.f1167e);
        zArr[1] = zArr[1] | q(this.f1168f, qVar.f1168f) | z;
        zArr[2] = z | q(this.f1169g, qVar.f1169g) | zArr[2];
        zArr[3] = zArr[3] | q(this.f1170h, qVar.f1170h);
        zArr[4] = q(this.f1171j, qVar.f1171j) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(double[] dArr, int[] iArr) {
        float[] fArr = {this.f1167e, this.f1168f, this.f1169g, this.f1170h, this.f1171j, this.f1172k};
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] < 6) {
                dArr[i2] = fArr[iArr[i3]];
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.f1168f;
        float f3 = this.f1169g;
        float f4 = this.f1170h;
        float f5 = this.f1171j;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    public q(int i2, int i3, i iVar, q qVar, q qVar2) {
        this.f1165c = 0;
        this.f1172k = Float.NaN;
        this.f1173l = Float.NaN;
        this.m = c.a;
        this.n = new LinkedHashMap<>();
        this.p = 0;
        this.q = new double[18];
        this.t = new double[18];
        int i4 = iVar.q;
        if (i4 == 1) {
            F(iVar, qVar, qVar2);
        } else if (i4 != 2) {
            E(iVar, qVar, qVar2);
        } else {
            G(i2, i3, iVar, qVar, qVar2);
        }
    }
}