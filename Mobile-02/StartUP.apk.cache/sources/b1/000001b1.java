package androidx.constraintlayout.motion.widget;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.TokenParser;

/* compiled from: KeyCycleOscillator.java */
/* loaded from: classes.dex */
public abstract class g {
    private c.f.a.a.b a;

    /* renamed from: b  reason: collision with root package name */
    private d f1099b;

    /* renamed from: c  reason: collision with root package name */
    protected androidx.constraintlayout.widget.a f1100c;

    /* renamed from: d  reason: collision with root package name */
    private String f1101d;

    /* renamed from: e  reason: collision with root package name */
    private int f1102e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1103f = 0;

    /* renamed from: g  reason: collision with root package name */
    ArrayList<p> f1104g = new ArrayList<>();

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    class a implements Comparator<p> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(p pVar, p pVar2) {
            return Integer.compare(pVar.a, pVar2.a);
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class b extends g {
        b() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class c extends g {

        /* renamed from: h  reason: collision with root package name */
        float[] f1105h = new float[1];

        c() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            this.f1105h[0] = a(f2);
            this.f1100c.i(view, this.f1105h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class d {
        private final int a;

        /* renamed from: c  reason: collision with root package name */
        float[] f1107c;

        /* renamed from: d  reason: collision with root package name */
        double[] f1108d;

        /* renamed from: e  reason: collision with root package name */
        float[] f1109e;

        /* renamed from: f  reason: collision with root package name */
        float[] f1110f;

        /* renamed from: g  reason: collision with root package name */
        float[] f1111g;

        /* renamed from: h  reason: collision with root package name */
        int f1112h;

        /* renamed from: i  reason: collision with root package name */
        c.f.a.a.b f1113i;

        /* renamed from: j  reason: collision with root package name */
        double[] f1114j;

        /* renamed from: k  reason: collision with root package name */
        double[] f1115k;

        /* renamed from: l  reason: collision with root package name */
        float f1116l;

        /* renamed from: b  reason: collision with root package name */
        c.f.a.a.f f1106b = new c.f.a.a.f();
        public HashMap<String, androidx.constraintlayout.widget.a> m = new HashMap<>();

        d(int i2, int i3, int i4) {
            this.f1112h = i2;
            this.a = i3;
            this.f1106b.g(i2);
            this.f1107c = new float[i4];
            this.f1108d = new double[i4];
            this.f1109e = new float[i4];
            this.f1110f = new float[i4];
            this.f1111g = new float[i4];
        }

        public double a(float f2) {
            c.f.a.a.b bVar = this.f1113i;
            if (bVar != null) {
                double d2 = f2;
                bVar.g(d2, this.f1115k);
                this.f1113i.d(d2, this.f1114j);
            } else {
                double[] dArr = this.f1115k;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d3 = f2;
            double e2 = this.f1106b.e(d3);
            double d4 = this.f1106b.d(d3);
            double[] dArr2 = this.f1115k;
            return dArr2[0] + (e2 * dArr2[1]) + (d4 * this.f1114j[1]);
        }

        public double b(float f2) {
            c.f.a.a.b bVar = this.f1113i;
            if (bVar != null) {
                bVar.d(f2, this.f1114j);
            } else {
                double[] dArr = this.f1114j;
                dArr[0] = this.f1110f[0];
                dArr[1] = this.f1107c[0];
            }
            return this.f1114j[0] + (this.f1106b.e(f2) * this.f1114j[1]);
        }

        public void c(int i2, int i3, float f2, float f3, float f4) {
            this.f1108d[i2] = i3 / 100.0d;
            this.f1109e[i2] = f2;
            this.f1110f[i2] = f3;
            this.f1107c[i2] = f4;
        }

        public void d(float f2) {
            float[] fArr;
            this.f1116l = f2;
            double[][] dArr = (double[][]) Array.newInstance(double.class, this.f1108d.length, 2);
            float[] fArr2 = this.f1107c;
            this.f1114j = new double[fArr2.length + 1];
            this.f1115k = new double[fArr2.length + 1];
            if (this.f1108d[0] > 0.0d) {
                this.f1106b.a(0.0d, this.f1109e[0]);
            }
            double[] dArr2 = this.f1108d;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f1106b.a(1.0d, this.f1109e[length]);
            }
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2][0] = this.f1110f[i2];
                int i3 = 0;
                while (true) {
                    if (i3 < this.f1107c.length) {
                        dArr[i3][1] = fArr[i3];
                        i3++;
                    }
                }
                this.f1106b.a(this.f1108d[i2], this.f1109e[i2]);
            }
            this.f1106b.f();
            double[] dArr3 = this.f1108d;
            if (dArr3.length > 1) {
                this.f1113i = c.f.a.a.b.a(0, dArr3, dArr);
            } else {
                this.f1113i = null;
            }
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class e extends g {
        e() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(a(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class f extends g {
        f() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
        }

        public void j(View view, float f2, double d2, double d3) {
            view.setRotation(a(f2) + ((float) Math.toDegrees(Math.atan2(d3, d2))));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* renamed from: androidx.constraintlayout.motion.widget.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0018g extends g {

        /* renamed from: h  reason: collision with root package name */
        boolean f1117h = false;

        C0018g() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
            } else if (this.f1117h) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f1117h = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(a(f2)));
                    } catch (IllegalAccessException e2) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e3);
                    }
                }
            }
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class h extends g {
        h() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class i extends g {
        i() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class j extends g {
        j() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class k extends g {
        k() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class l extends g {
        l() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class m extends g {
        m() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class n extends g {
        n() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    static class o extends g {
        o() {
        }

        @Override // androidx.constraintlayout.motion.widget.g
        public void f(View view, float f2) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(a(f2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class p {
        int a;

        /* renamed from: b  reason: collision with root package name */
        float f1118b;

        /* renamed from: c  reason: collision with root package name */
        float f1119c;

        /* renamed from: d  reason: collision with root package name */
        float f1120d;

        public p(int i2, float f2, float f3, float f4) {
            this.a = i2;
            this.f1118b = f4;
            this.f1119c = f3;
            this.f1120d = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g c(String str) {
        if (str.startsWith("CUSTOM")) {
            return new c();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = TokenParser.CR;
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
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new C0018g();
            case 6:
                return new k();
            case 7:
                return new l();
            case '\b':
                return new b();
            case '\t':
                return new h();
            case '\n':
                return new e();
            case 11:
                return new f();
            case '\f':
                return new b();
            case '\r':
                return new b();
            default:
                return null;
        }
    }

    public float a(float f2) {
        return (float) this.f1099b.b(f2);
    }

    public float b(float f2) {
        return (float) this.f1099b.a(f2);
    }

    public void d(int i2, int i3, int i4, float f2, float f3, float f4) {
        this.f1104g.add(new p(i2, f2, f3, f4));
        if (i4 != -1) {
            this.f1103f = i4;
        }
        this.f1102e = i3;
    }

    public void e(int i2, int i3, int i4, float f2, float f3, float f4, androidx.constraintlayout.widget.a aVar) {
        this.f1104g.add(new p(i2, f2, f3, f4));
        if (i4 != -1) {
            this.f1103f = i4;
        }
        this.f1102e = i3;
        this.f1100c = aVar;
    }

    public abstract void f(View view, float f2);

    public void g(String str) {
        this.f1101d = str;
    }

    @TargetApi(19)
    public void h(float f2) {
        int size = this.f1104g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f1104g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, 2);
        this.f1099b = new d(this.f1102e, this.f1103f, size);
        Iterator<p> it = this.f1104g.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            p next = it.next();
            float f3 = next.f1120d;
            dArr[i2] = f3 * 0.01d;
            double[] dArr3 = dArr2[i2];
            float f4 = next.f1118b;
            dArr3[0] = f4;
            double[] dArr4 = dArr2[i2];
            float f5 = next.f1119c;
            dArr4[1] = f5;
            this.f1099b.c(i2, next.a, f3, f5, f4);
            i2++;
        }
        this.f1099b.d(f2);
        this.a = c.f.a.a.b.a(0, dArr, dArr2);
    }

    public boolean i() {
        return this.f1103f == 1;
    }

    public String toString() {
        String str = this.f1101d;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<p> it = this.f1104g.iterator();
        while (it.hasNext()) {
            p next = it.next();
            str = str + "[" + next.a + " , " + decimalFormat.format(next.f1118b) + "] ";
        }
        return str;
    }
}