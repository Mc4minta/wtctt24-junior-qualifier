package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GlyphContext.java */
/* loaded from: classes2.dex */
public class j {
    private double[] A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private final float M;
    private final float N;
    private final float O;
    final ArrayList<h> a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<c0[]> f10243b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<c0[]> f10244c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<c0[]> f10245d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<c0[]> f10246e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<double[]> f10247f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<Integer> f10248g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<Integer> f10249h;

    /* renamed from: i  reason: collision with root package name */
    private final ArrayList<Integer> f10250i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<Integer> f10251j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<Integer> f10252k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<Integer> f10253l;
    private final ArrayList<Integer> m;
    private final ArrayList<Integer> n;
    private final ArrayList<Integer> o;
    private final ArrayList<Integer> p;
    private double q;
    private h r;
    private double s;
    private double t;
    private double u;
    private double v;
    private c0[] w;
    private c0[] x;
    private c0[] y;
    private c0[] z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(float f2, float f3, float f4) {
        ArrayList<h> arrayList = new ArrayList<>();
        this.a = arrayList;
        ArrayList<c0[]> arrayList2 = new ArrayList<>();
        this.f10243b = arrayList2;
        ArrayList<c0[]> arrayList3 = new ArrayList<>();
        this.f10244c = arrayList3;
        ArrayList<c0[]> arrayList4 = new ArrayList<>();
        this.f10245d = arrayList4;
        ArrayList<c0[]> arrayList5 = new ArrayList<>();
        this.f10246e = arrayList5;
        ArrayList<double[]> arrayList6 = new ArrayList<>();
        this.f10247f = arrayList6;
        ArrayList<Integer> arrayList7 = new ArrayList<>();
        this.f10248g = arrayList7;
        ArrayList<Integer> arrayList8 = new ArrayList<>();
        this.f10249h = arrayList8;
        ArrayList<Integer> arrayList9 = new ArrayList<>();
        this.f10250i = arrayList9;
        ArrayList<Integer> arrayList10 = new ArrayList<>();
        this.f10251j = arrayList10;
        ArrayList<Integer> arrayList11 = new ArrayList<>();
        this.f10252k = arrayList11;
        this.f10253l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.q = 12.0d;
        this.r = h.a;
        c0[] c0VarArr = new c0[0];
        this.w = c0VarArr;
        this.x = new c0[0];
        this.y = new c0[0];
        this.z = new c0[0];
        this.A = new double[]{0.0d};
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.M = f2;
        this.N = f3;
        this.O = f4;
        arrayList2.add(c0VarArr);
        arrayList3.add(this.x);
        arrayList4.add(this.y);
        arrayList5.add(this.z);
        arrayList6.add(this.A);
        arrayList7.add(Integer.valueOf(this.G));
        arrayList8.add(Integer.valueOf(this.H));
        arrayList9.add(Integer.valueOf(this.I));
        arrayList10.add(Integer.valueOf(this.J));
        arrayList11.add(Integer.valueOf(this.K));
        arrayList.add(this.r);
        q();
    }

    private double[] a(ArrayList<c0> arrayList) {
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = arrayList.get(i2).a;
        }
        return dArr;
    }

    private c0[] e(ArrayList<c0> arrayList) {
        int size = arrayList.size();
        c0[] c0VarArr = new c0[size];
        for (int i2 = 0; i2 < size; i2++) {
            c0VarArr[i2] = arrayList.get(i2);
        }
        return c0VarArr;
    }

    private h f(l lVar) {
        if (this.L > 0) {
            return this.r;
        }
        for (l parentTextRoot = lVar.getParentTextRoot(); parentTextRoot != null; parentTextRoot = parentTextRoot.getParentTextRoot()) {
            h b2 = parentTextRoot.b0().b();
            if (b2 != h.a) {
                return b2;
            }
        }
        return h.a;
    }

    private static void h(ArrayList<Integer> arrayList, int i2) {
        while (i2 >= 0) {
            arrayList.set(i2, Integer.valueOf(arrayList.get(i2).intValue() + 1));
            i2--;
        }
    }

    private void q() {
        this.f10253l.add(Integer.valueOf(this.B));
        this.m.add(Integer.valueOf(this.C));
        this.n.add(Integer.valueOf(this.D));
        this.o.add(Integer.valueOf(this.E));
        this.p.add(Integer.valueOf(this.F));
    }

    private void r(l lVar, ReadableMap readableMap) {
        h f2 = f(lVar);
        this.L++;
        if (readableMap == null) {
            this.a.add(f2);
            return;
        }
        h hVar = new h(readableMap, f2, this.M);
        this.q = hVar.f10229b;
        this.a.add(hVar);
        this.r = hVar;
    }

    private void s() {
        this.F = 0;
        this.E = 0;
        this.D = 0;
        this.C = 0;
        this.B = 0;
        this.K = -1;
        this.J = -1;
        this.I = -1;
        this.H = -1;
        this.G = -1;
        this.v = 0.0d;
        this.u = 0.0d;
        this.t = 0.0d;
        this.s = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double c() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double i() {
        h(this.f10250i, this.D);
        int i2 = this.I + 1;
        c0[] c0VarArr = this.y;
        if (i2 < c0VarArr.length) {
            this.I = i2;
            this.u += w.a(c0VarArr[i2], this.N, 0.0d, this.M, this.q);
        }
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double j() {
        h(this.f10251j, this.E);
        int i2 = this.J + 1;
        c0[] c0VarArr = this.z;
        if (i2 < c0VarArr.length) {
            this.J = i2;
            this.v += w.a(c0VarArr[i2], this.O, 0.0d, this.M, this.q);
        }
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double k() {
        h(this.f10252k, this.F);
        int min = Math.min(this.K + 1, this.A.length - 1);
        this.K = min;
        return this.A[min];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double l(double d2) {
        h(this.f10248g, this.B);
        int i2 = this.G + 1;
        c0[] c0VarArr = this.w;
        if (i2 < c0VarArr.length) {
            this.u = 0.0d;
            this.G = i2;
            this.s = w.a(c0VarArr[i2], this.N, 0.0d, this.M, this.q);
        }
        double d3 = this.s + d2;
        this.s = d3;
        return d3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double m() {
        h(this.f10249h, this.C);
        int i2 = this.H + 1;
        c0[] c0VarArr = this.x;
        if (i2 < c0VarArr.length) {
            this.v = 0.0d;
            this.H = i2;
            this.t = w.a(c0VarArr[i2], this.O, 0.0d, this.M, this.q);
        }
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.a.remove(this.L);
        this.f10253l.remove(this.L);
        this.m.remove(this.L);
        this.n.remove(this.L);
        this.o.remove(this.L);
        this.p.remove(this.L);
        int i2 = this.L - 1;
        this.L = i2;
        int i3 = this.B;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int i7 = this.F;
        this.r = this.a.get(i2);
        this.B = this.f10253l.get(this.L).intValue();
        this.C = this.m.get(this.L).intValue();
        this.D = this.n.get(this.L).intValue();
        this.E = this.o.get(this.L).intValue();
        this.F = this.p.get(this.L).intValue();
        if (i3 != this.B) {
            this.f10243b.remove(i3);
            this.w = this.f10243b.get(this.B);
            this.G = this.f10248g.get(this.B).intValue();
        }
        if (i4 != this.C) {
            this.f10244c.remove(i4);
            this.x = this.f10244c.get(this.C);
            this.H = this.f10249h.get(this.C).intValue();
        }
        if (i5 != this.D) {
            this.f10245d.remove(i5);
            this.y = this.f10245d.get(this.D);
            this.I = this.f10250i.get(this.D).intValue();
        }
        if (i6 != this.E) {
            this.f10246e.remove(i6);
            this.z = this.f10246e.get(this.E);
            this.J = this.f10251j.get(this.E).intValue();
        }
        if (i7 != this.F) {
            this.f10247f.remove(i7);
            this.A = this.f10247f.get(this.F);
            this.K = this.f10252k.get(this.F).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(l lVar, ReadableMap readableMap) {
        r(lVar, readableMap);
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(boolean z, u0 u0Var, ReadableMap readableMap, ArrayList<c0> arrayList, ArrayList<c0> arrayList2, ArrayList<c0> arrayList3, ArrayList<c0> arrayList4, ArrayList<c0> arrayList5) {
        if (z) {
            s();
        }
        r(u0Var, readableMap);
        if (arrayList != null && arrayList.size() != 0) {
            this.B++;
            this.G = -1;
            this.f10248g.add(-1);
            c0[] e2 = e(arrayList);
            this.w = e2;
            this.f10243b.add(e2);
        }
        if (arrayList2 != null && arrayList2.size() != 0) {
            this.C++;
            this.H = -1;
            this.f10249h.add(-1);
            c0[] e3 = e(arrayList2);
            this.x = e3;
            this.f10244c.add(e3);
        }
        if (arrayList3 != null && arrayList3.size() != 0) {
            this.D++;
            this.I = -1;
            this.f10250i.add(-1);
            c0[] e4 = e(arrayList3);
            this.y = e4;
            this.f10245d.add(e4);
        }
        if (arrayList4 != null && arrayList4.size() != 0) {
            this.E++;
            this.J = -1;
            this.f10251j.add(-1);
            c0[] e5 = e(arrayList4);
            this.z = e5;
            this.f10246e.add(e5);
        }
        if (arrayList5 != null && arrayList5.size() != 0) {
            this.F++;
            this.K = -1;
            this.f10252k.add(-1);
            double[] a = a(arrayList5);
            this.A = a;
            this.f10247f.add(a);
        }
        q();
    }
}