package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.g;
import androidx.constraintlayout.motion.widget.s;
import androidx.constraintlayout.motion.widget.t;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: MotionController.java */
/* loaded from: classes.dex */
public class n {
    private l[] A;
    View a;

    /* renamed from: b  reason: collision with root package name */
    int f1150b;

    /* renamed from: c  reason: collision with root package name */
    String f1151c;

    /* renamed from: i  reason: collision with root package name */
    private c.f.a.a.b[] f1157i;

    /* renamed from: j  reason: collision with root package name */
    private c.f.a.a.b f1158j;
    private int[] n;
    private double[] o;
    private double[] p;
    private String[] q;
    private int[] r;
    private HashMap<String, t> x;
    private HashMap<String, s> y;
    private HashMap<String, g> z;

    /* renamed from: d  reason: collision with root package name */
    private int f1152d = -1;

    /* renamed from: e  reason: collision with root package name */
    private q f1153e = new q();

    /* renamed from: f  reason: collision with root package name */
    private q f1154f = new q();

    /* renamed from: g  reason: collision with root package name */
    private m f1155g = new m();

    /* renamed from: h  reason: collision with root package name */
    private m f1156h = new m();

    /* renamed from: k  reason: collision with root package name */
    float f1159k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    float f1160l = 0.0f;
    float m = 1.0f;
    private int s = 4;
    private float[] t = new float[4];
    private ArrayList<q> u = new ArrayList<>();
    private float[] v = new float[1];
    private ArrayList<c> w = new ArrayList<>();
    private int B = c.a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(View view) {
        u(view);
    }

    private float f(float f2, float[] fArr) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.m;
            if (f4 != 1.0d) {
                float f5 = this.f1160l;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && f2 < 1.0d) {
                    f2 = (f2 - f5) * f4;
                }
            }
        }
        c.f.a.a.c cVar = this.f1153e.f1164b;
        float f6 = Float.NaN;
        Iterator<q> it = this.u.iterator();
        while (it.hasNext()) {
            q next = it.next();
            c.f.a.a.c cVar2 = next.f1164b;
            if (cVar2 != null) {
                float f7 = next.f1166d;
                if (f7 < f2) {
                    cVar = cVar2;
                    f3 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = next.f1166d;
                }
            }
        }
        if (cVar != null) {
            float f8 = (Float.isNaN(f6) ? 1.0f : f6) - f3;
            double d2 = (f2 - f3) / f8;
            f2 = (((float) cVar.a(d2)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d2);
            }
        }
        return f2;
    }

    private float m() {
        float f2;
        float[] fArr = new float[2];
        float f3 = 1.0f / 99;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        float f4 = 0.0f;
        while (i2 < 100) {
            float f5 = i2 * f3;
            double d4 = f5;
            c.f.a.a.c cVar = this.f1153e.f1164b;
            float f6 = Float.NaN;
            Iterator<q> it = this.u.iterator();
            float f7 = 0.0f;
            while (it.hasNext()) {
                q next = it.next();
                c.f.a.a.c cVar2 = next.f1164b;
                float f8 = f3;
                if (cVar2 != null) {
                    float f9 = next.f1166d;
                    if (f9 < f5) {
                        f7 = f9;
                        cVar = cVar2;
                    } else if (Float.isNaN(f6)) {
                        f6 = next.f1166d;
                    }
                }
                f3 = f8;
            }
            float f10 = f3;
            if (cVar != null) {
                if (Float.isNaN(f6)) {
                    f6 = 1.0f;
                }
                d4 = (((float) cVar.a((f5 - f7) / f2)) * (f6 - f7)) + f7;
            }
            this.f1157i[0].d(d4, this.o);
            this.f1153e.z(this.n, this.o, fArr, 0);
            if (i2 > 0) {
                f4 = (float) (f4 + Math.hypot(d3 - fArr[1], d2 - fArr[0]));
            }
            d2 = fArr[0];
            d3 = fArr[1];
            i2++;
            f3 = f10;
        }
        return f4;
    }

    private void n(q qVar) {
        int binarySearch = Collections.binarySearch(this.u, qVar);
        if (binarySearch == 0) {
            Log.e("MotionController", " KeyPath positon \"" + qVar.f1167e + "\" outside of range");
        }
        this.u.add((-binarySearch) - 1, qVar);
    }

    private void p(q qVar) {
        qVar.H((int) this.a.getX(), (int) this.a.getY(), this.a.getWidth(), this.a.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        this.w.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ArrayList<c> arrayList) {
        this.w.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(float[] fArr, int[] iArr) {
        if (fArr != null) {
            double[] h2 = this.f1157i[0].h();
            if (iArr != null) {
                Iterator<q> it = this.u.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    iArr[i2] = it.next().p;
                    i2++;
                }
            }
            int i3 = 0;
            for (double d2 : h2) {
                this.f1157i[0].d(d2, this.o);
                this.f1153e.z(this.n, this.o, fArr, i3);
                i3 += 2;
            }
            return i3 / 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float[] fArr, int i2) {
        float f2;
        int i3 = i2;
        float f3 = 1.0f;
        float f4 = 1.0f / (i3 - 1);
        HashMap<String, s> hashMap = this.y;
        s sVar = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, s> hashMap2 = this.y;
        s sVar2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, g> hashMap3 = this.z;
        g gVar = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, g> hashMap4 = this.z;
        g gVar2 = hashMap4 != null ? hashMap4.get("translationY") : null;
        int i4 = 0;
        while (i4 < i3) {
            float f5 = i4 * f4;
            float f6 = this.m;
            if (f6 != f3) {
                float f7 = this.f1160l;
                if (f5 < f7) {
                    f5 = 0.0f;
                }
                if (f5 > f7 && f5 < 1.0d) {
                    f5 = (f5 - f7) * f6;
                }
            }
            double d2 = f5;
            c.f.a.a.c cVar = this.f1153e.f1164b;
            float f8 = Float.NaN;
            Iterator<q> it = this.u.iterator();
            float f9 = 0.0f;
            while (it.hasNext()) {
                q next = it.next();
                c.f.a.a.c cVar2 = next.f1164b;
                if (cVar2 != null) {
                    float f10 = next.f1166d;
                    if (f10 < f5) {
                        f9 = f10;
                        cVar = cVar2;
                    } else if (Float.isNaN(f8)) {
                        f8 = next.f1166d;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d2 = (((float) cVar.a((f5 - f9) / f2)) * (f8 - f9)) + f9;
            }
            this.f1157i[0].d(d2, this.o);
            c.f.a.a.b bVar = this.f1158j;
            if (bVar != null) {
                double[] dArr = this.o;
                if (dArr.length > 0) {
                    bVar.d(d2, dArr);
                }
            }
            int i5 = i4 * 2;
            this.f1153e.z(this.n, this.o, fArr, i5);
            if (gVar != null) {
                fArr[i5] = fArr[i5] + gVar.a(f5);
            } else if (sVar != null) {
                fArr[i5] = fArr[i5] + sVar.a(f5);
            }
            if (gVar2 != null) {
                int i6 = i5 + 1;
                fArr[i6] = fArr[i6] + gVar2.a(f5);
            } else if (sVar2 != null) {
                int i7 = i5 + 1;
                fArr[i7] = fArr[i7] + sVar2.a(f5);
            }
            i4++;
            i3 = i2;
            f3 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f2, float[] fArr, int i2) {
        this.f1157i[0].d(f(f2, null), this.o);
        this.f1153e.C(this.n, this.o, fArr, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float f5 = f(f2, this.v);
        c.f.a.a.b[] bVarArr = this.f1157i;
        int i2 = 0;
        if (bVarArr != null) {
            double d2 = f5;
            bVarArr[0].g(d2, this.p);
            this.f1157i[0].d(d2, this.o);
            float f6 = this.v[0];
            while (true) {
                dArr = this.p;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2] = dArr[i2] * f6;
                i2++;
            }
            c.f.a.a.b bVar = this.f1158j;
            if (bVar != null) {
                double[] dArr2 = this.o;
                if (dArr2.length > 0) {
                    bVar.d(d2, dArr2);
                    this.f1158j.g(d2, this.p);
                    this.f1153e.I(f3, f4, fArr, this.n, this.p, this.o);
                    return;
                }
                return;
            }
            this.f1153e.I(f3, f4, fArr, this.n, dArr, this.o);
            return;
        }
        q qVar = this.f1154f;
        float f7 = qVar.f1168f;
        q qVar2 = this.f1153e;
        float f8 = f7 - qVar2.f1168f;
        float f9 = qVar.f1169g - qVar2.f1169g;
        float f10 = (qVar.f1170h - qVar2.f1170h) + f8;
        float f11 = (qVar.f1171j - qVar2.f1171j) + f9;
        fArr[0] = (f8 * (1.0f - f3)) + (f10 * f3);
        fArr[1] = (f9 * (1.0f - f4)) + (f11 * f4);
    }

    public int h() {
        int i2 = this.f1153e.f1165c;
        Iterator<q> it = this.u.iterator();
        while (it.hasNext()) {
            i2 = Math.max(i2, it.next().f1165c);
        }
        return Math.max(i2, this.f1154f.f1165c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f1154f.f1168f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.f1154f.f1169g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q k(int i2) {
        return this.u.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float f5 = f(f2, this.v);
        HashMap<String, s> hashMap = this.y;
        s sVar = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, s> hashMap2 = this.y;
        s sVar2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, s> hashMap3 = this.y;
        s sVar3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, s> hashMap4 = this.y;
        s sVar4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, s> hashMap5 = this.y;
        s sVar5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, g> hashMap6 = this.z;
        g gVar = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, g> hashMap7 = this.z;
        g gVar2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, g> hashMap8 = this.z;
        g gVar3 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, g> hashMap9 = this.z;
        g gVar4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, g> hashMap10 = this.z;
        g gVar5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        c.f.a.a.h hVar = new c.f.a.a.h();
        hVar.b();
        hVar.d(sVar3, f5);
        hVar.h(sVar, sVar2, f5);
        hVar.f(sVar4, sVar5, f5);
        hVar.c(gVar3, f5);
        hVar.g(gVar, gVar2, f5);
        hVar.e(gVar4, gVar5, f5);
        c.f.a.a.b bVar = this.f1158j;
        if (bVar != null) {
            double[] dArr = this.o;
            if (dArr.length > 0) {
                double d2 = f5;
                bVar.d(d2, dArr);
                this.f1158j.g(d2, this.p);
                this.f1153e.I(f3, f4, fArr, this.n, this.p, this.o);
            }
            hVar.a(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.f1157i != null) {
            double f6 = f(f5, this.v);
            this.f1157i[0].g(f6, this.p);
            this.f1157i[0].d(f6, this.o);
            float f7 = this.v[0];
            while (true) {
                double[] dArr2 = this.p;
                if (i4 < dArr2.length) {
                    dArr2[i4] = dArr2[i4] * f7;
                    i4++;
                } else {
                    this.f1153e.I(f3, f4, fArr, this.n, dArr2, this.o);
                    hVar.a(f3, f4, i2, i3, fArr);
                    return;
                }
            }
        } else {
            q qVar = this.f1154f;
            float f8 = qVar.f1168f;
            q qVar2 = this.f1153e;
            float f9 = f8 - qVar2.f1168f;
            float f10 = qVar.f1169g - qVar2.f1169g;
            g gVar6 = gVar4;
            float f11 = (qVar.f1171j - qVar2.f1171j) + f10;
            fArr[0] = (f9 * (1.0f - f3)) + (((qVar.f1170h - qVar2.f1170h) + f9) * f3);
            fArr[1] = (f10 * (1.0f - f4)) + (f11 * f4);
            hVar.b();
            hVar.d(sVar3, f5);
            hVar.h(sVar, sVar2, f5);
            hVar.f(sVar4, sVar5, f5);
            hVar.c(gVar3, f5);
            hVar.g(gVar, gVar2, f5);
            hVar.e(gVar6, gVar5, f5);
            hVar.a(f3, f4, i2, i3, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(View view, float f2, long j2, e eVar) {
        t.d dVar;
        boolean z;
        double d2;
        float f3 = f(f2, null);
        HashMap<String, s> hashMap = this.y;
        if (hashMap != null) {
            for (s sVar : hashMap.values()) {
                sVar.f(view, f3);
            }
        }
        HashMap<String, t> hashMap2 = this.x;
        if (hashMap2 != null) {
            dVar = null;
            boolean z2 = false;
            for (t tVar : hashMap2.values()) {
                if (tVar instanceof t.d) {
                    dVar = (t.d) tVar;
                } else {
                    z2 |= tVar.f(view, f3, j2, eVar);
                }
            }
            z = z2;
        } else {
            dVar = null;
            z = false;
        }
        c.f.a.a.b[] bVarArr = this.f1157i;
        if (bVarArr != null) {
            double d3 = f3;
            bVarArr[0].d(d3, this.o);
            this.f1157i[0].g(d3, this.p);
            c.f.a.a.b bVar = this.f1158j;
            if (bVar != null) {
                double[] dArr = this.o;
                if (dArr.length > 0) {
                    bVar.d(d3, dArr);
                    this.f1158j.g(d3, this.p);
                }
            }
            this.f1153e.J(view, this.n, this.o, this.p, null);
            HashMap<String, s> hashMap3 = this.y;
            if (hashMap3 != null) {
                for (s sVar2 : hashMap3.values()) {
                    if (sVar2 instanceof s.d) {
                        double[] dArr2 = this.p;
                        ((s.d) sVar2).i(view, f3, dArr2[0], dArr2[1]);
                    }
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.p;
                d2 = d3;
                z = dVar.j(view, eVar, f3, j2, dArr3[0], dArr3[1]) | z;
            } else {
                d2 = d3;
            }
            int i2 = 1;
            while (true) {
                c.f.a.a.b[] bVarArr2 = this.f1157i;
                if (i2 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i2].e(d2, this.t);
                this.f1153e.n.get(this.q[i2 - 1]).i(view, this.t);
                i2++;
            }
            m mVar = this.f1155g;
            if (mVar.f1141c == 0) {
                if (f3 <= 0.0f) {
                    view.setVisibility(mVar.f1142d);
                } else if (f3 >= 1.0f) {
                    view.setVisibility(this.f1156h.f1142d);
                } else if (this.f1156h.f1142d != mVar.f1142d) {
                    view.setVisibility(0);
                }
            }
            if (this.A != null) {
                int i3 = 0;
                while (true) {
                    l[] lVarArr = this.A;
                    if (i3 >= lVarArr.length) {
                        break;
                    }
                    lVarArr[i3].r(f3, view);
                    i3++;
                }
            }
        } else {
            q qVar = this.f1153e;
            float f4 = qVar.f1168f;
            q qVar2 = this.f1154f;
            float f5 = f4 + ((qVar2.f1168f - f4) * f3);
            float f6 = qVar.f1169g;
            float f7 = f6 + ((qVar2.f1169g - f6) * f3);
            float f8 = qVar.f1170h;
            float f9 = qVar2.f1170h;
            float f10 = qVar.f1171j;
            float f11 = qVar2.f1171j;
            float f12 = f5 + 0.5f;
            int i4 = (int) f12;
            float f13 = f7 + 0.5f;
            int i5 = (int) f13;
            int i6 = (int) (f12 + ((f9 - f8) * f3) + f8);
            int i7 = (int) (f13 + ((f11 - f10) * f3) + f10);
            int i8 = i6 - i4;
            int i9 = i7 - i5;
            if (f9 != f8 || f11 != f10) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
            }
            view.layout(i4, i5, i6, i7);
        }
        HashMap<String, g> hashMap4 = this.z;
        if (hashMap4 != null) {
            for (g gVar : hashMap4.values()) {
                if (gVar instanceof g.f) {
                    double[] dArr4 = this.p;
                    ((g.f) gVar).j(view, f3, dArr4[0], dArr4[1]);
                } else {
                    gVar.f(view, f3);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(c.f.b.k.e eVar, androidx.constraintlayout.widget.d dVar) {
        q qVar = this.f1154f;
        qVar.f1166d = 1.0f;
        qVar.f1167e = 1.0f;
        p(qVar);
        this.f1154f.H(eVar.R(), eVar.S(), eVar.Q(), eVar.w());
        this.f1154f.h(dVar.t(this.f1150b));
        this.f1156h.C(eVar, dVar, this.f1150b);
    }

    public void r(int i2) {
        this.B = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        q qVar = this.f1153e;
        qVar.f1166d = 0.0f;
        qVar.f1167e = 0.0f;
        qVar.H(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f1155g.B(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(c.f.b.k.e eVar, androidx.constraintlayout.widget.d dVar) {
        q qVar = this.f1153e;
        qVar.f1166d = 0.0f;
        qVar.f1167e = 0.0f;
        p(qVar);
        this.f1153e.H(eVar.R(), eVar.S(), eVar.Q(), eVar.w());
        d.a t = dVar.t(this.f1150b);
        this.f1153e.h(t);
        this.f1159k = t.f1291c.f1311g;
        this.f1155g.C(eVar, dVar, this.f1150b);
    }

    public String toString() {
        return " start: x: " + this.f1153e.f1168f + " y: " + this.f1153e.f1169g + " end: x: " + this.f1154f.f1168f + " y: " + this.f1154f.f1169g;
    }

    public void u(View view) {
        this.a = view;
        this.f1150b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.f1151c = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void v(int i2, int i3, float f2, long j2) {
        ArrayList arrayList;
        String[] strArr;
        t d2;
        androidx.constraintlayout.widget.a aVar;
        s d3;
        androidx.constraintlayout.widget.a aVar2;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i4 = this.B;
        if (i4 != c.a) {
            this.f1153e.m = i4;
        }
        this.f1155g.z(this.f1156h, hashSet2);
        ArrayList<c> arrayList2 = this.w;
        if (arrayList2 != null) {
            Iterator<c> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                c next = it.next();
                if (next instanceof i) {
                    i iVar = (i) next;
                    n(new q(i2, i3, iVar, this.f1153e, this.f1154f));
                    int i5 = iVar.f1127g;
                    if (i5 != c.a) {
                        this.f1152d = i5;
                    }
                } else if (next instanceof f) {
                    next.b(hashSet3);
                } else if (next instanceof k) {
                    next.b(hashSet);
                } else if (next instanceof l) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((l) next);
                } else {
                    next.e(hashMap);
                    next.b(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        int i6 = 0;
        if (arrayList != null) {
            this.A = (l[]) arrayList.toArray(new l[0]);
        }
        char c2 = 1;
        if (!hashSet2.isEmpty()) {
            this.y = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[c2];
                    Iterator<c> it3 = this.w.iterator();
                    while (it3.hasNext()) {
                        c next3 = it3.next();
                        HashMap<String, androidx.constraintlayout.widget.a> hashMap2 = next3.f1086f;
                        if (hashMap2 != null && (aVar2 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.f1082b, aVar2);
                        }
                    }
                    d3 = s.c(next2, sparseArray);
                } else {
                    d3 = s.d(next2);
                }
                if (d3 != null) {
                    d3.g(next2);
                    this.y.put(next2, d3);
                }
                c2 = 1;
            }
            ArrayList<c> arrayList3 = this.w;
            if (arrayList3 != null) {
                Iterator<c> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    c next4 = it4.next();
                    if (next4 instanceof d) {
                        next4.a(this.y);
                    }
                }
            }
            this.f1155g.h(this.y, 0);
            this.f1156h.h(this.y, 100);
            for (String str2 : this.y.keySet()) {
                this.y.get(str2).h(hashMap.containsKey(str2) ? hashMap.get(str2).intValue() : 0);
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.x == null) {
                this.x = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.x.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<c> it6 = this.w.iterator();
                        while (it6.hasNext()) {
                            c next6 = it6.next();
                            HashMap<String, androidx.constraintlayout.widget.a> hashMap3 = next6.f1086f;
                            if (hashMap3 != null && (aVar = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.f1082b, aVar);
                            }
                        }
                        d2 = t.c(next5, sparseArray2);
                    } else {
                        d2 = t.d(next5, j2);
                    }
                    if (d2 != null) {
                        d2.h(next5);
                        this.x.put(next5, d2);
                    }
                }
            }
            ArrayList<c> arrayList4 = this.w;
            if (arrayList4 != null) {
                Iterator<c> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    c next7 = it7.next();
                    if (next7 instanceof k) {
                        ((k) next7).M(this.x);
                    }
                }
            }
            for (String str4 : this.x.keySet()) {
                this.x.get(str4).i(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int i7 = 2;
        int size = this.u.size() + 2;
        q[] qVarArr = new q[size];
        qVarArr[0] = this.f1153e;
        qVarArr[size - 1] = this.f1154f;
        if (this.u.size() > 0 && this.f1152d == -1) {
            this.f1152d = 0;
        }
        Iterator<q> it8 = this.u.iterator();
        int i8 = 1;
        while (it8.hasNext()) {
            qVarArr[i8] = it8.next();
            i8++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.f1154f.n.keySet()) {
            if (this.f1153e.n.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.q = strArr2;
        this.r = new int[strArr2.length];
        int i9 = 0;
        while (true) {
            strArr = this.q;
            if (i9 >= strArr.length) {
                break;
            }
            String str6 = strArr[i9];
            this.r[i9] = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                } else if (qVarArr[i10].n.containsKey(str6)) {
                    int[] iArr = this.r;
                    iArr[i9] = iArr[i9] + qVarArr[i10].n.get(str6).f();
                    break;
                } else {
                    i10++;
                }
            }
            i9++;
        }
        boolean z = qVarArr[0].m != c.a;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i11 = 1; i11 < size; i11++) {
            qVarArr[i11].s(qVarArr[i11 - 1], zArr, this.q, z);
        }
        int i12 = 0;
        for (int i13 = 1; i13 < length; i13++) {
            if (zArr[i13]) {
                i12++;
            }
        }
        int[] iArr2 = new int[i12];
        this.n = iArr2;
        this.o = new double[iArr2.length];
        this.p = new double[iArr2.length];
        int i14 = 0;
        for (int i15 = 1; i15 < length; i15++) {
            if (zArr[i15]) {
                this.n[i14] = i15;
                i14++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance(double.class, size, this.n.length);
        double[] dArr2 = new double[size];
        for (int i16 = 0; i16 < size; i16++) {
            qVarArr[i16].y(dArr[i16], this.n);
            dArr2[i16] = qVarArr[i16].f1166d;
        }
        int i17 = 0;
        while (true) {
            int[] iArr3 = this.n;
            if (i17 >= iArr3.length) {
                break;
            }
            if (iArr3[i17] < q.a.length) {
                String str7 = q.a[this.n[i17]] + " [";
                for (int i18 = 0; i18 < size; i18++) {
                    str7 = str7 + dArr[i18][i17];
                }
            }
            i17++;
        }
        this.f1157i = new c.f.a.a.b[this.q.length + 1];
        int i19 = 0;
        while (true) {
            String[] strArr3 = this.q;
            if (i19 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i19];
            int i20 = i6;
            int i21 = i20;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i20 < size) {
                if (qVarArr[i20].D(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr4 = new int[i7];
                        iArr4[1] = qVarArr[i20].B(str8);
                        iArr4[i6] = size;
                        dArr4 = (double[][]) Array.newInstance(double.class, iArr4);
                    }
                    dArr3[i21] = qVarArr[i20].f1166d;
                    qVarArr[i20].A(str8, dArr4[i21], 0);
                    i21++;
                }
                i20++;
                i7 = 2;
                i6 = 0;
            }
            i19++;
            this.f1157i[i19] = c.f.a.a.b.a(this.f1152d, Arrays.copyOf(dArr3, i21), (double[][]) Arrays.copyOf(dArr4, i21));
            i7 = 2;
            i6 = 0;
        }
        this.f1157i[0] = c.f.a.a.b.a(this.f1152d, dArr2, dArr);
        if (qVarArr[0].m != c.a) {
            int[] iArr5 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance(double.class, size, 2);
            for (int i22 = 0; i22 < size; i22++) {
                iArr5[i22] = qVarArr[i22].m;
                dArr5[i22] = qVarArr[i22].f1166d;
                dArr6[i22][0] = qVarArr[i22].f1168f;
                dArr6[i22][1] = qVarArr[i22].f1169g;
            }
            this.f1158j = c.f.a.a.b.b(iArr5, dArr5, dArr6);
        }
        float f3 = Float.NaN;
        this.z = new HashMap<>();
        if (this.w != null) {
            Iterator<String> it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String next8 = it9.next();
                g c3 = g.c(next8);
                if (c3 != null) {
                    if (c3.i() && Float.isNaN(f3)) {
                        f3 = m();
                    }
                    c3.g(next8);
                    this.z.put(next8, c3);
                }
            }
            Iterator<c> it10 = this.w.iterator();
            while (it10.hasNext()) {
                c next9 = it10.next();
                if (next9 instanceof f) {
                    ((f) next9).O(this.z);
                }
            }
            for (g gVar : this.z.values()) {
                gVar.h(f3);
            }
        }
    }
}