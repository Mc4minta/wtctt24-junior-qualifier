package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* compiled from: SplineSet.java */
/* loaded from: classes.dex */
public abstract class s {
    protected c.f.a.a.b a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f1199b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f1200c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    private int f1201d;

    /* renamed from: e  reason: collision with root package name */
    private String f1202e;

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class a extends s {
        a() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class b extends s {

        /* renamed from: f  reason: collision with root package name */
        String f1203f;

        /* renamed from: g  reason: collision with root package name */
        SparseArray<androidx.constraintlayout.widget.a> f1204g;

        /* renamed from: h  reason: collision with root package name */
        float[] f1205h;

        public b(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
            this.f1203f = str.split(",")[1];
            this.f1204g = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void e(int i2, float f2) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            this.a.e(f2, this.f1205h);
            this.f1204g.valueAt(0).i(view, this.f1205h);
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void h(int i2) {
            float[] fArr;
            int size = this.f1204g.size();
            int f2 = this.f1204g.valueAt(0).f();
            double[] dArr = new double[size];
            this.f1205h = new float[f2];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, f2);
            for (int i3 = 0; i3 < size; i3++) {
                dArr[i3] = this.f1204g.keyAt(i3) * 0.01d;
                this.f1204g.valueAt(i3).e(this.f1205h);
                int i4 = 0;
                while (true) {
                    if (i4 < this.f1205h.length) {
                        dArr2[i3][i4] = fArr[i4];
                        i4++;
                    }
                }
            }
            this.a = c.f.a.a.b.a(i2, dArr, dArr2);
        }

        public void i(int i2, androidx.constraintlayout.widget.a aVar) {
            this.f1204g.append(i2, aVar);
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class c extends s {
        c() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class d extends s {
        d() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
        }

        public void i(View view, float f2, double d2, double d3) {
            view.setRotation(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class e extends s {
        e() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setPivotX(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class f extends s {
        f() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setPivotY(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class g extends s {

        /* renamed from: f  reason: collision with root package name */
        boolean f1206f = false;

        g() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (this.f1206f) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f1206f = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(a(f2)));
                    } catch (IllegalAccessException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e("SplineSet", "unable to setProgress", e3);
                    }
                }
            }
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class h extends s {
        h() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class i extends s {
        i() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class j extends s {
        j() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class k extends s {
        k() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class l extends s {
        l() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    private static class m {
        static void a(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static int b(int[] iArr, float[] fArr, int i2, int i3) {
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

        private static void c(int[] iArr, float[] fArr, int i2, int i3) {
            int i4 = iArr[i2];
            iArr[i2] = iArr[i3];
            iArr[i3] = i4;
            float f2 = fArr[i2];
            fArr[i2] = fArr[i3];
            fArr[i3] = f2;
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class n extends s {
        n() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class o extends s {
        o() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    static class p extends s {
        p() {
        }

        @Override // androidx.constraintlayout.motion.widget.s
        public void f(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s c(String str, SparseArray<androidx.constraintlayout.widget.a> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s d(String str) {
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
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = TokenParser.CR;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new n();
            case 3:
                return new o();
            case 4:
                return new p();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case '\b':
                return new a();
            case '\t':
                return new e();
            case '\n':
                return new f();
            case 11:
                return new h();
            case '\f':
                return new c();
            case '\r':
                return new d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public float a(float f2) {
        return (float) this.a.c(f2, 0);
    }

    public float b(float f2) {
        return (float) this.a.f(f2, 0);
    }

    public void e(int i2, float f2) {
        int[] iArr = this.f1199b;
        if (iArr.length < this.f1201d + 1) {
            this.f1199b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f1200c;
            this.f1200c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f1199b;
        int i3 = this.f1201d;
        iArr2[i3] = i2;
        this.f1200c[i3] = f2;
        this.f1201d = i3 + 1;
    }

    public abstract void f(View view, float f2);

    public void g(String str) {
        this.f1202e = str;
    }

    public void h(int i2) {
        int i3;
        int i4 = this.f1201d;
        if (i4 == 0) {
            return;
        }
        m.a(this.f1199b, this.f1200c, 0, i4 - 1);
        int i5 = 1;
        for (int i6 = 1; i6 < this.f1201d; i6++) {
            int[] iArr = this.f1199b;
            if (iArr[i6 - 1] != iArr[i6]) {
                i5++;
            }
        }
        double[] dArr = new double[i5];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i5, 1);
        int i7 = 0;
        for (i3 = 0; i3 < this.f1201d; i3 = i3 + 1) {
            if (i3 > 0) {
                int[] iArr2 = this.f1199b;
                i3 = iArr2[i3] == iArr2[i3 - 1] ? i3 + 1 : 0;
            }
            dArr[i7] = this.f1199b[i3] * 0.01d;
            dArr2[i7][0] = this.f1200c[i3];
            i7++;
        }
        this.a = c.f.a.a.b.a(i2, dArr, dArr2);
    }

    public String toString() {
        String str = this.f1202e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i2 = 0; i2 < this.f1201d; i2++) {
            str = str + "[" + this.f1199b[i2] + " , " + decimalFormat.format(this.f1200c[i2]) + "] ";
        }
        return str;
    }
}