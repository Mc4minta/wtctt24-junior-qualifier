package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* compiled from: TimeCycleSplineSet.java */
/* loaded from: classes.dex */
public abstract class t {
    private static float a = 6.2831855f;

    /* renamed from: b  reason: collision with root package name */
    protected c.f.a.a.b f1207b;

    /* renamed from: f  reason: collision with root package name */
    private int f1211f;

    /* renamed from: g  reason: collision with root package name */
    private String f1212g;

    /* renamed from: j  reason: collision with root package name */
    long f1215j;

    /* renamed from: c  reason: collision with root package name */
    protected int f1208c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected int[] f1209d = new int[10];

    /* renamed from: e  reason: collision with root package name */
    protected float[][] f1210e = (float[][]) Array.newInstance(float.class, 10, 3);

    /* renamed from: h  reason: collision with root package name */
    private float[] f1213h = new float[3];

    /* renamed from: i  reason: collision with root package name */
    protected boolean f1214i = false;

    /* renamed from: k  reason: collision with root package name */
    float f1216k = Float.NaN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class a extends t {
        a() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setAlpha(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class b extends t {

        /* renamed from: l  reason: collision with root package name */
        String f1217l;
        SparseArray<androidx.constraintlayout.widget.a> m;
        SparseArray<float[]> n = new SparseArray<>();
        float[] o;
        float[] p;

        public b(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
            this.f1217l = str.split(",")[1];
            this.m = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public void e(int i2, float f2, float f3, int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            this.f1207b.e(f2, this.o);
            float[] fArr = this.o;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            float f5 = (float) ((this.f1216k + (((j2 - this.f1215j) * 1.0E-9d) * f3)) % 1.0d);
            this.f1216k = f5;
            this.f1215j = j2;
            float a = a(f5);
            this.f1214i = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.p;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.f1214i;
                float[] fArr3 = this.o;
                this.f1214i = z | (((double) fArr3[i2]) != 0.0d);
                fArr2[i2] = (fArr3[i2] * a) + f4;
                i2++;
            }
            this.m.valueAt(0).i(view, this.p);
            if (f3 != 0.0f) {
                this.f1214i = true;
            }
            return this.f1214i;
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public void i(int i2) {
            float[] fArr;
            int size = this.m.size();
            int f2 = this.m.valueAt(0).f();
            double[] dArr = new double[size];
            int i3 = f2 + 2;
            this.o = new float[i3];
            this.p = new float[f2];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = this.m.keyAt(i4);
                float[] valueAt = this.n.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                this.m.valueAt(i4).e(this.o);
                int i5 = 0;
                while (true) {
                    if (i5 < this.o.length) {
                        dArr2[i4][i5] = fArr[i5];
                        i5++;
                    }
                }
                dArr2[i4][f2] = valueAt[0];
                dArr2[i4][f2 + 1] = valueAt[1];
            }
            this.f1207b = c.f.a.a.b.a(i2, dArr, dArr2);
        }

        public void j(int i2, androidx.constraintlayout.widget.a aVar, float f2, int i3, float f3) {
            this.m.append(i2, aVar);
            this.n.append(i2, new float[]{f2, f3});
            this.f1208c = Math.max(this.f1208c, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class c extends t {
        c() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(b(f2, j2, view, eVar));
            }
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class d extends t {
        d() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            return this.f1214i;
        }

        public boolean j(View view, androidx.constraintlayout.motion.widget.e eVar, float f2, long j2, double d2, double d3) {
            view.setRotation(b(f2, j2, view, eVar) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class e extends t {

        /* renamed from: l  reason: collision with root package name */
        boolean f1218l = false;

        e() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(b(f2, j2, view, eVar));
            } else if (this.f1218l) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f1218l = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(b(f2, j2, view, eVar)));
                    } catch (IllegalAccessException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e("SplineSet", "unable to setProgress", e3);
                    }
                }
            }
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class f extends t {
        f() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setRotation(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class g extends t {
        g() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setRotationX(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class h extends t {
        h() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setRotationY(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class i extends t {
        i() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setScaleX(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class j extends t {
        j() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setScaleY(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class k {
        static void a(int[] iArr, float[][] fArr, int i2, int i3) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i3;
            iArr2[1] = i2;
            int i4 = 2;
            while (i4 > 0) {
                int i5 = i4 - 1;
                int i6 = iArr2[i5];
                i4 = i5 - 1;
                int i7 = iArr2[i4];
                if (i6 < i7) {
                    int b2 = b(iArr, fArr, i6, i7);
                    int i8 = i4 + 1;
                    iArr2[i4] = b2 - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i4 = i10 + 1;
                    iArr2[i10] = b2 + 1;
                }
            }
        }

        private static int b(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (iArr[i2] <= i4) {
                    c(iArr, fArr, i5, i2);
                    i5++;
                }
                i2++;
            }
            c(iArr, fArr, i5, i3);
            return i5;
        }

        private static void c(int[] iArr, float[][] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float[] fArr2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class l extends t {
        l() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setTranslationX(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class m extends t {
        m() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            view.setTranslationY(b(f2, j2, view, eVar));
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class n extends t {
        n() {
        }

        @Override // androidx.constraintlayout.motion.widget.t
        public boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(b(f2, j2, view, eVar));
            }
            return this.f1214i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t c(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static t d(String str, long j2) {
        t gVar;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                gVar = new g();
                break;
            case 1:
                gVar = new h();
                break;
            case 2:
                gVar = new l();
                break;
            case 3:
                gVar = new m();
                break;
            case 4:
                gVar = new n();
                break;
            case 5:
                gVar = new e();
                break;
            case 6:
                gVar = new i();
                break;
            case 7:
                gVar = new j();
                break;
            case '\b':
                gVar = new f();
                break;
            case '\t':
                gVar = new c();
                break;
            case '\n':
                gVar = new d();
                break;
            case 11:
                gVar = new a();
                break;
            default:
                return null;
        }
        gVar.g(j2);
        return gVar;
    }

    protected float a(float f2) {
        float abs;
        switch (this.f1208c) {
            case 1:
                return Math.signum(f2 * a);
            case 2:
                abs = Math.abs(f2);
                break;
            case 3:
                return (((f2 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f2 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f2 * a);
            case 6:
                float abs2 = 1.0f - Math.abs(((f2 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f2 * a);
        }
        return 1.0f - abs;
    }

    public float b(float f2, long j2, View view, androidx.constraintlayout.motion.widget.e eVar) {
        this.f1207b.e(f2, this.f1213h);
        float[] fArr = this.f1213h;
        float f3 = fArr[1];
        int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
        if (i2 == 0) {
            this.f1214i = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f1216k)) {
            float a2 = eVar.a(view, this.f1212g, 0);
            this.f1216k = a2;
            if (Float.isNaN(a2)) {
                this.f1216k = 0.0f;
            }
        }
        float f4 = (float) ((this.f1216k + (((j2 - this.f1215j) * 1.0E-9d) * f3)) % 1.0d);
        this.f1216k = f4;
        eVar.b(view, this.f1212g, 0, f4);
        this.f1215j = j2;
        float f5 = this.f1213h[0];
        float a3 = (a(this.f1216k) * f5) + this.f1213h[2];
        this.f1214i = (f5 == 0.0f && i2 == 0) ? false : true;
        return a3;
    }

    public void e(int i2, float f2, float f3, int i3, float f4) {
        int[] iArr = this.f1209d;
        int i4 = this.f1211f;
        iArr[i4] = i2;
        float[][] fArr = this.f1210e;
        fArr[i4][0] = f2;
        fArr[i4][1] = f3;
        fArr[i4][2] = f4;
        this.f1208c = Math.max(this.f1208c, i3);
        this.f1211f++;
    }

    public abstract boolean f(View view, float f2, long j2, androidx.constraintlayout.motion.widget.e eVar);

    protected void g(long j2) {
        this.f1215j = j2;
    }

    public void h(String str) {
        this.f1212g = str;
    }

    public void i(int i2) {
        int i3;
        int i4 = this.f1211f;
        if (i4 == 0) {
            Log.e("SplineSet", "Error no points added to " + this.f1212g);
            return;
        }
        k.a(this.f1209d, this.f1210e, 0, i4 - 1);
        int i5 = 1;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f1209d;
            if (i5 >= iArr.length) {
                break;
            }
            if (iArr[i5] != iArr[i5 - 1]) {
                i6++;
            }
            i5++;
        }
        if (i6 == 0) {
            i6 = 1;
        }
        double[] dArr = new double[i6];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i6, 3);
        int i7 = 0;
        for (i3 = 0; i3 < this.f1211f; i3 = i3 + 1) {
            if (i3 > 0) {
                int[] iArr2 = this.f1209d;
                i3 = iArr2[i3] == iArr2[i3 - 1] ? i3 + 1 : 0;
            }
            dArr[i7] = this.f1209d[i3] * 0.01d;
            double[] dArr3 = dArr2[i7];
            float[][] fArr = this.f1210e;
            dArr3[0] = fArr[i3][0];
            dArr2[i7][1] = fArr[i3][1];
            dArr2[i7][2] = fArr[i3][2];
            i7++;
        }
        this.f1207b = c.f.a.a.b.a(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.f1212g;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f1211f; i2++) {
            str = str + "[" + this.f1209d[i2] + " , " + decimalFormat.format(this.f1210e[i2]) + "] ";
        }
        return str;
    }
}