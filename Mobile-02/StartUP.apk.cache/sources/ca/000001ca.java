package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.s;
import androidx.constraintlayout.widget.a;
import androidx.constraintlayout.widget.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionConstrainedPoint.java */
/* loaded from: classes.dex */
public class m implements Comparable<m> {
    static String[] a = {"position", "x", "y", "width", "height", "pathRotate"};
    private float A;

    /* renamed from: d  reason: collision with root package name */
    int f1142d;
    private c.f.a.a.c u;
    private float w;
    private float x;
    private float y;
    private float z;

    /* renamed from: b  reason: collision with root package name */
    private float f1140b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    int f1141c = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1143e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f1144f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f1145g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f1146h = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f1147j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f1148k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f1149l = 1.0f;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float p = 0.0f;
    private float q = 0.0f;
    private float t = 0.0f;
    private int v = 0;
    private float B = Float.NaN;
    private float C = Float.NaN;
    LinkedHashMap<String, androidx.constraintlayout.widget.a> D = new LinkedHashMap<>();
    int E = 0;
    double[] F = new double[18];
    double[] G = new double[18];

    private boolean y(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    void A(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.z = f4;
        this.A = f5;
    }

    public void B(View view) {
        A(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        n(view);
    }

    public void C(c.f.b.k.e eVar, androidx.constraintlayout.widget.d dVar, int i2) {
        A(eVar.R(), eVar.S(), eVar.Q(), eVar.w());
        q(dVar.t(i2));
    }

    public void h(HashMap<String, s> hashMap, int i2) {
        for (String str : hashMap.keySet()) {
            s sVar = hashMap.get(str);
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c2 = TokenParser.CR;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    sVar.e(i2, Float.isNaN(this.f1146h) ? 0.0f : this.f1146h);
                    break;
                case 1:
                    sVar.e(i2, Float.isNaN(this.f1147j) ? 0.0f : this.f1147j);
                    break;
                case 2:
                    sVar.e(i2, Float.isNaN(this.p) ? 0.0f : this.p);
                    break;
                case 3:
                    sVar.e(i2, Float.isNaN(this.q) ? 0.0f : this.q);
                    break;
                case 4:
                    sVar.e(i2, Float.isNaN(this.t) ? 0.0f : this.t);
                    break;
                case 5:
                    sVar.e(i2, Float.isNaN(this.C) ? 0.0f : this.C);
                    break;
                case 6:
                    sVar.e(i2, Float.isNaN(this.f1148k) ? 1.0f : this.f1148k);
                    break;
                case 7:
                    sVar.e(i2, Float.isNaN(this.f1149l) ? 1.0f : this.f1149l);
                    break;
                case '\b':
                    sVar.e(i2, Float.isNaN(this.m) ? 0.0f : this.m);
                    break;
                case '\t':
                    sVar.e(i2, Float.isNaN(this.n) ? 0.0f : this.n);
                    break;
                case '\n':
                    sVar.e(i2, Float.isNaN(this.f1145g) ? 0.0f : this.f1145g);
                    break;
                case 11:
                    sVar.e(i2, Float.isNaN(this.f1144f) ? 0.0f : this.f1144f);
                    break;
                case '\f':
                    sVar.e(i2, Float.isNaN(this.B) ? 0.0f : this.B);
                    break;
                case '\r':
                    sVar.e(i2, Float.isNaN(this.f1140b) ? 1.0f : this.f1140b);
                    break;
                default:
                    if (!str.startsWith("CUSTOM")) {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    } else {
                        String str2 = str.split(",")[1];
                        if (!this.D.containsKey(str2)) {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                            break;
                        } else {
                            androidx.constraintlayout.widget.a aVar = this.D.get(str2);
                            if (sVar instanceof s.b) {
                                ((s.b) sVar).i(i2, aVar);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i2 + ", value" + aVar.d() + sVar);
                                break;
                            }
                        }
                    }
            }
        }
    }

    public void n(View view) {
        this.f1142d = view.getVisibility();
        this.f1140b = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f1143e = false;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            this.f1144f = view.getElevation();
        }
        this.f1145g = view.getRotation();
        this.f1146h = view.getRotationX();
        this.f1147j = view.getRotationY();
        this.f1148k = view.getScaleX();
        this.f1149l = view.getScaleY();
        this.m = view.getPivotX();
        this.n = view.getPivotY();
        this.p = view.getTranslationX();
        this.q = view.getTranslationY();
        if (i2 >= 21) {
            this.t = view.getTranslationZ();
        }
    }

    public void q(d.a aVar) {
        d.C0020d c0020d = aVar.f1290b;
        int i2 = c0020d.f1314c;
        this.f1141c = i2;
        int i3 = c0020d.f1313b;
        this.f1142d = i3;
        this.f1140b = (i3 == 0 || i2 != 0) ? c0020d.f1315d : 0.0f;
        d.e eVar = aVar.f1293e;
        this.f1143e = eVar.m;
        this.f1144f = eVar.n;
        this.f1145g = eVar.f1318c;
        this.f1146h = eVar.f1319d;
        this.f1147j = eVar.f1320e;
        this.f1148k = eVar.f1321f;
        this.f1149l = eVar.f1322g;
        this.m = eVar.f1323h;
        this.n = eVar.f1324i;
        this.p = eVar.f1325j;
        this.q = eVar.f1326k;
        this.t = eVar.f1327l;
        this.u = c.f.a.a.c.c(aVar.f1291c.f1308d);
        d.c cVar = aVar.f1291c;
        this.B = cVar.f1312h;
        this.v = cVar.f1310f;
        this.C = aVar.f1290b.f1316e;
        for (String str : aVar.f1294f.keySet()) {
            androidx.constraintlayout.widget.a aVar2 = aVar.f1294f.get(str);
            if (aVar2.c() != a.b.STRING_TYPE) {
                this.D.put(str, aVar2);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: s */
    public int compareTo(m mVar) {
        return Float.compare(this.w, mVar.w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(m mVar, HashSet<String> hashSet) {
        if (y(this.f1140b, mVar.f1140b)) {
            hashSet.add("alpha");
        }
        if (y(this.f1144f, mVar.f1144f)) {
            hashSet.add("elevation");
        }
        int i2 = this.f1142d;
        int i3 = mVar.f1142d;
        if (i2 != i3 && this.f1141c == 0 && (i2 == 0 || i3 == 0)) {
            hashSet.add("alpha");
        }
        if (y(this.f1145g, mVar.f1145g)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.B) || !Float.isNaN(mVar.B)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.C) || !Float.isNaN(mVar.C)) {
            hashSet.add("progress");
        }
        if (y(this.f1146h, mVar.f1146h)) {
            hashSet.add("rotationX");
        }
        if (y(this.f1147j, mVar.f1147j)) {
            hashSet.add("rotationY");
        }
        if (y(this.m, mVar.m)) {
            hashSet.add("transformPivotX");
        }
        if (y(this.n, mVar.n)) {
            hashSet.add("transformPivotY");
        }
        if (y(this.f1148k, mVar.f1148k)) {
            hashSet.add("scaleX");
        }
        if (y(this.f1149l, mVar.f1149l)) {
            hashSet.add("scaleY");
        }
        if (y(this.p, mVar.p)) {
            hashSet.add("translationX");
        }
        if (y(this.q, mVar.q)) {
            hashSet.add("translationY");
        }
        if (y(this.t, mVar.t)) {
            hashSet.add("translationZ");
        }
    }
}