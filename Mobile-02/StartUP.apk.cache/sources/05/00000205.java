package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ConstraintSet.java */
/* loaded from: classes.dex */
public class d {
    private static final int[] a = {0, 4, 8};

    /* renamed from: b  reason: collision with root package name */
    private static SparseIntArray f1285b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1286c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.a> f1287d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private boolean f1288e = true;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, a> f1289f = new HashMap<>();

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        public final C0020d f1290b = new C0020d();

        /* renamed from: c  reason: collision with root package name */
        public final c f1291c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final b f1292d = new b();

        /* renamed from: e  reason: collision with root package name */
        public final e f1293e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.a> f1294f = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i2, ConstraintLayout.b bVar) {
            this.a = i2;
            b bVar2 = this.f1292d;
            bVar2.f1302i = bVar.f1235d;
            bVar2.f1303j = bVar.f1236e;
            bVar2.f1304k = bVar.f1237f;
            bVar2.f1305l = bVar.f1238g;
            bVar2.m = bVar.f1239h;
            bVar2.n = bVar.f1240i;
            bVar2.o = bVar.f1241j;
            bVar2.p = bVar.f1242k;
            bVar2.q = bVar.f1243l;
            bVar2.r = bVar.p;
            bVar2.s = bVar.q;
            bVar2.t = bVar.r;
            bVar2.u = bVar.s;
            bVar2.v = bVar.z;
            bVar2.w = bVar.A;
            bVar2.x = bVar.B;
            bVar2.y = bVar.m;
            bVar2.z = bVar.n;
            bVar2.A = bVar.o;
            bVar2.B = bVar.Q;
            bVar2.C = bVar.R;
            bVar2.D = bVar.S;
            bVar2.f1301h = bVar.f1234c;
            bVar2.f1299f = bVar.a;
            bVar2.f1300g = bVar.f1233b;
            b bVar3 = this.f1292d;
            bVar3.f1297d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar3.f1298e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar3.E = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar3.F = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar3.G = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar3.H = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar3.Q = bVar.F;
            bVar3.R = bVar.E;
            bVar3.T = bVar.H;
            bVar3.S = bVar.G;
            bVar3.i0 = bVar.T;
            bVar3.j0 = bVar.U;
            bVar3.U = bVar.I;
            bVar3.V = bVar.J;
            bVar3.W = bVar.M;
            bVar3.X = bVar.N;
            bVar3.Y = bVar.K;
            bVar3.Z = bVar.L;
            bVar3.a0 = bVar.O;
            bVar3.b0 = bVar.P;
            bVar3.h0 = bVar.V;
            bVar3.L = bVar.u;
            bVar3.N = bVar.w;
            bVar3.K = bVar.t;
            bVar3.M = bVar.v;
            b bVar4 = this.f1292d;
            bVar4.P = bVar.x;
            bVar4.O = bVar.y;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar4.I = bVar.getMarginEnd();
                this.f1292d.J = bVar.getMarginStart();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i2, e.a aVar) {
            f(i2, aVar);
            this.f1290b.f1315d = aVar.p0;
            e eVar = this.f1293e;
            eVar.f1318c = aVar.s0;
            eVar.f1319d = aVar.t0;
            eVar.f1320e = aVar.u0;
            eVar.f1321f = aVar.v0;
            eVar.f1322g = aVar.w0;
            eVar.f1323h = aVar.x0;
            eVar.f1324i = aVar.y0;
            eVar.f1325j = aVar.z0;
            eVar.f1326k = aVar.A0;
            eVar.f1327l = aVar.B0;
            eVar.n = aVar.r0;
            eVar.m = aVar.q0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(androidx.constraintlayout.widget.b bVar, int i2, e.a aVar) {
            g(i2, aVar);
            if (bVar instanceof Barrier) {
                b bVar2 = this.f1292d;
                bVar2.e0 = 1;
                Barrier barrier = (Barrier) bVar;
                bVar2.c0 = barrier.getType();
                this.f1292d.f0 = barrier.getReferencedIds();
                this.f1292d.d0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f1292d;
            bVar.f1235d = bVar2.f1302i;
            bVar.f1236e = bVar2.f1303j;
            bVar.f1237f = bVar2.f1304k;
            bVar.f1238g = bVar2.f1305l;
            bVar.f1239h = bVar2.m;
            bVar.f1240i = bVar2.n;
            bVar.f1241j = bVar2.o;
            bVar.f1242k = bVar2.p;
            bVar.f1243l = bVar2.q;
            bVar.p = bVar2.r;
            bVar.q = bVar2.s;
            bVar.r = bVar2.t;
            bVar.s = bVar2.u;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.E;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.F;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.G;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.H;
            bVar.x = bVar2.P;
            bVar.y = bVar2.O;
            bVar.u = bVar2.L;
            bVar.w = bVar2.N;
            bVar.z = bVar2.v;
            bVar.A = bVar2.w;
            bVar.m = bVar2.y;
            bVar.n = bVar2.z;
            b bVar3 = this.f1292d;
            bVar.o = bVar3.A;
            bVar.B = bVar3.x;
            bVar.Q = bVar3.B;
            bVar.R = bVar3.C;
            bVar.F = bVar3.Q;
            bVar.E = bVar3.R;
            bVar.H = bVar3.T;
            bVar.G = bVar3.S;
            bVar.T = bVar3.i0;
            bVar.U = bVar3.j0;
            bVar.I = bVar3.U;
            bVar.J = bVar3.V;
            bVar.M = bVar3.W;
            bVar.N = bVar3.X;
            bVar.K = bVar3.Y;
            bVar.L = bVar3.Z;
            bVar.O = bVar3.a0;
            bVar.P = bVar3.b0;
            bVar.S = bVar3.D;
            bVar.f1234c = bVar3.f1301h;
            bVar.a = bVar3.f1299f;
            bVar.f1233b = bVar3.f1300g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar3.f1297d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar3.f1298e;
            String str = bVar3.h0;
            if (str != null) {
                bVar.V = str;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                bVar.setMarginStart(this.f1292d.J);
                bVar.setMarginEnd(this.f1292d.I);
            }
            bVar.c();
        }

        /* renamed from: e */
        public a clone() {
            a aVar = new a();
            aVar.f1292d.a(this.f1292d);
            aVar.f1291c.a(this.f1291c);
            aVar.f1290b.a(this.f1290b);
            aVar.f1293e.a(this.f1293e);
            aVar.a = this.a;
            return aVar;
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class b {
        private static SparseIntArray a;

        /* renamed from: d  reason: collision with root package name */
        public int f1297d;

        /* renamed from: e  reason: collision with root package name */
        public int f1298e;
        public int[] f0;
        public String g0;
        public String h0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1295b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1296c = false;

        /* renamed from: f  reason: collision with root package name */
        public int f1299f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f1300g = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f1301h = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        public int f1302i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f1303j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f1304k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f1305l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public float v = 0.5f;
        public float w = 0.5f;
        public String x = null;
        public int y = -1;
        public int z = 0;
        public float A = 0.0f;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public int P = -1;
        public float Q = -1.0f;
        public float R = -1.0f;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = 0;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public int Z = -1;
        public float a0 = 1.0f;
        public float b0 = 1.0f;
        public int c0 = -1;
        public int d0 = 0;
        public int e0 = -1;
        public boolean i0 = false;
        public boolean j0 = false;
        public boolean k0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(i.E5, 24);
            a.append(i.F5, 25);
            a.append(i.H5, 28);
            a.append(i.I5, 29);
            a.append(i.N5, 35);
            a.append(i.M5, 34);
            a.append(i.p5, 4);
            a.append(i.o5, 3);
            a.append(i.m5, 1);
            a.append(i.S5, 6);
            a.append(i.T5, 7);
            a.append(i.w5, 17);
            a.append(i.x5, 18);
            a.append(i.y5, 19);
            a.append(i.X4, 26);
            a.append(i.J5, 31);
            a.append(i.K5, 32);
            a.append(i.v5, 10);
            a.append(i.u5, 9);
            a.append(i.W5, 13);
            a.append(i.Z5, 16);
            a.append(i.X5, 14);
            a.append(i.U5, 11);
            a.append(i.Y5, 15);
            a.append(i.V5, 12);
            a.append(i.Q5, 38);
            a.append(i.C5, 37);
            a.append(i.B5, 39);
            a.append(i.P5, 40);
            a.append(i.A5, 20);
            a.append(i.O5, 36);
            a.append(i.t5, 5);
            a.append(i.D5, 76);
            a.append(i.L5, 76);
            a.append(i.G5, 76);
            a.append(i.n5, 76);
            a.append(i.l5, 76);
            a.append(i.a5, 23);
            a.append(i.c5, 27);
            a.append(i.e5, 30);
            a.append(i.f5, 8);
            a.append(i.b5, 33);
            a.append(i.d5, 2);
            a.append(i.Y4, 22);
            a.append(i.Z4, 21);
            a.append(i.q5, 61);
            a.append(i.s5, 62);
            a.append(i.r5, 63);
            a.append(i.R5, 69);
            a.append(i.z5, 70);
            a.append(i.j5, 71);
            a.append(i.h5, 72);
            a.append(i.i5, 73);
            a.append(i.k5, 74);
            a.append(i.g5, 75);
        }

        public void a(b bVar) {
            this.f1295b = bVar.f1295b;
            this.f1297d = bVar.f1297d;
            this.f1296c = bVar.f1296c;
            this.f1298e = bVar.f1298e;
            this.f1299f = bVar.f1299f;
            this.f1300g = bVar.f1300g;
            this.f1301h = bVar.f1301h;
            this.f1302i = bVar.f1302i;
            this.f1303j = bVar.f1303j;
            this.f1304k = bVar.f1304k;
            this.f1305l = bVar.f1305l;
            this.m = bVar.m;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.q = bVar.q;
            this.r = bVar.r;
            this.s = bVar.s;
            this.t = bVar.t;
            this.u = bVar.u;
            this.v = bVar.v;
            this.w = bVar.w;
            this.x = bVar.x;
            this.y = bVar.y;
            this.z = bVar.z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.a0 = bVar.a0;
            this.b0 = bVar.b0;
            this.c0 = bVar.c0;
            this.d0 = bVar.d0;
            this.e0 = bVar.e0;
            this.h0 = bVar.h0;
            int[] iArr = bVar.f0;
            if (iArr != null) {
                this.f0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f0 = null;
            }
            this.g0 = bVar.g0;
            this.i0 = bVar.i0;
            this.j0 = bVar.j0;
            this.k0 = bVar.k0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.W4);
            this.f1296c = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = a.get(index);
                if (i3 == 80) {
                    this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            this.q = d.z(obtainStyledAttributes, index, this.q);
                            continue;
                        case 2:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 3:
                            this.p = d.z(obtainStyledAttributes, index, this.p);
                            continue;
                        case 4:
                            this.o = d.z(obtainStyledAttributes, index, this.o);
                            continue;
                        case 5:
                            this.x = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 7:
                            this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                            continue;
                        case 8:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            this.u = d.z(obtainStyledAttributes, index, this.u);
                            continue;
                        case 10:
                            this.t = d.z(obtainStyledAttributes, index, this.t);
                            continue;
                        case 11:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 12:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 13:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 14:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 15:
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            continue;
                        case 16:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 17:
                            this.f1299f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1299f);
                            continue;
                        case 18:
                            this.f1300g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1300g);
                            continue;
                        case 19:
                            this.f1301h = obtainStyledAttributes.getFloat(index, this.f1301h);
                            continue;
                        case 20:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            continue;
                        case 21:
                            this.f1298e = obtainStyledAttributes.getLayoutDimension(index, this.f1298e);
                            continue;
                        case 22:
                            this.f1297d = obtainStyledAttributes.getLayoutDimension(index, this.f1297d);
                            continue;
                        case 23:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 24:
                            this.f1302i = d.z(obtainStyledAttributes, index, this.f1302i);
                            continue;
                        case 25:
                            this.f1303j = d.z(obtainStyledAttributes, index, this.f1303j);
                            continue;
                        case 26:
                            this.D = obtainStyledAttributes.getInt(index, this.D);
                            continue;
                        case 27:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 28:
                            this.f1304k = d.z(obtainStyledAttributes, index, this.f1304k);
                            continue;
                        case 29:
                            this.f1305l = d.z(obtainStyledAttributes, index, this.f1305l);
                            continue;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                                break;
                            } else {
                                continue;
                            }
                        case 31:
                            this.r = d.z(obtainStyledAttributes, index, this.r);
                            continue;
                        case 32:
                            this.s = d.z(obtainStyledAttributes, index, this.s);
                            continue;
                        case 33:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 34:
                            this.n = d.z(obtainStyledAttributes, index, this.n);
                            continue;
                        case 35:
                            this.m = d.z(obtainStyledAttributes, index, this.m);
                            continue;
                        case 36:
                            this.w = obtainStyledAttributes.getFloat(index, this.w);
                            continue;
                        case 37:
                            this.R = obtainStyledAttributes.getFloat(index, this.R);
                            continue;
                        case 38:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 39:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        case 40:
                            this.T = obtainStyledAttributes.getInt(index, this.T);
                            continue;
                        default:
                            switch (i3) {
                                case 54:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 55:
                                    this.V = obtainStyledAttributes.getInt(index, this.V);
                                    continue;
                                case 56:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 57:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 58:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                case 59:
                                    this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    continue;
                                default:
                                    switch (i3) {
                                        case 61:
                                            this.y = d.z(obtainStyledAttributes, index, this.y);
                                            continue;
                                        case 62:
                                            this.z = obtainStyledAttributes.getDimensionPixelSize(index, this.z);
                                            continue;
                                        case 63:
                                            this.A = obtainStyledAttributes.getFloat(index, this.A);
                                            continue;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.b0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.c0 = obtainStyledAttributes.getInt(index, this.c0);
                                                    continue;
                                                case 73:
                                                    this.d0 = obtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                                    continue;
                                                case 74:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.k0 = obtainStyledAttributes.getBoolean(index, this.k0);
                                                    continue;
                                                case 76:
                                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                                                    continue;
                                                case 77:
                                                    this.h0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + a.get(index));
                                                    continue;
                                                    continue;
                                                    continue;
                                                    continue;
                                            }
                                    }
                            }
                    }
                } else {
                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class c {
        private static SparseIntArray a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1306b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f1307c = -1;

        /* renamed from: d  reason: collision with root package name */
        public String f1308d = null;

        /* renamed from: e  reason: collision with root package name */
        public int f1309e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f1310f = 0;

        /* renamed from: g  reason: collision with root package name */
        public float f1311g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f1312h = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(i.k6, 1);
            a.append(i.m6, 2);
            a.append(i.n6, 3);
            a.append(i.j6, 4);
            a.append(i.i6, 5);
            a.append(i.l6, 6);
        }

        public void a(c cVar) {
            this.f1306b = cVar.f1306b;
            this.f1307c = cVar.f1307c;
            this.f1308d = cVar.f1308d;
            this.f1309e = cVar.f1309e;
            this.f1310f = cVar.f1310f;
            this.f1312h = cVar.f1312h;
            this.f1311g = cVar.f1311g;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.h6);
            this.f1306b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        this.f1312h = obtainStyledAttributes.getFloat(index, this.f1312h);
                        break;
                    case 2:
                        this.f1309e = obtainStyledAttributes.getInt(index, this.f1309e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f1308d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f1308d = c.f.a.a.c.f2675b[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f1310f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1307c = d.z(obtainStyledAttributes, index, this.f1307c);
                        break;
                    case 6:
                        this.f1311g = obtainStyledAttributes.getFloat(index, this.f1311g);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: androidx.constraintlayout.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0020d {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1313b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f1314c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f1315d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1316e = Float.NaN;

        public void a(C0020d c0020d) {
            this.a = c0020d.a;
            this.f1313b = c0020d.f1313b;
            this.f1315d = c0020d.f1315d;
            this.f1316e = c0020d.f1316e;
            this.f1314c = c0020d.f1314c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.U6);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == i.W6) {
                    this.f1315d = obtainStyledAttributes.getFloat(index, this.f1315d);
                } else if (index == i.V6) {
                    this.f1313b = obtainStyledAttributes.getInt(index, this.f1313b);
                    this.f1313b = d.a[this.f1313b];
                } else if (index == i.Y6) {
                    this.f1314c = obtainStyledAttributes.getInt(index, this.f1314c);
                } else if (index == i.X6) {
                    this.f1316e = obtainStyledAttributes.getFloat(index, this.f1316e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class e {
        private static SparseIntArray a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1317b = false;

        /* renamed from: c  reason: collision with root package name */
        public float f1318c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f1319d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f1320e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f1321f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f1322g = 1.0f;

        /* renamed from: h  reason: collision with root package name */
        public float f1323h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f1324i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public float f1325j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f1326k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f1327l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            a = sparseIntArray;
            sparseIntArray.append(i.t7, 1);
            a.append(i.u7, 2);
            a.append(i.v7, 3);
            a.append(i.r7, 4);
            a.append(i.s7, 5);
            a.append(i.n7, 6);
            a.append(i.o7, 7);
            a.append(i.p7, 8);
            a.append(i.q7, 9);
            a.append(i.w7, 10);
            a.append(i.x7, 11);
        }

        public void a(e eVar) {
            this.f1317b = eVar.f1317b;
            this.f1318c = eVar.f1318c;
            this.f1319d = eVar.f1319d;
            this.f1320e = eVar.f1320e;
            this.f1321f = eVar.f1321f;
            this.f1322g = eVar.f1322g;
            this.f1323h = eVar.f1323h;
            this.f1324i = eVar.f1324i;
            this.f1325j = eVar.f1325j;
            this.f1326k = eVar.f1326k;
            this.f1327l = eVar.f1327l;
            this.m = eVar.m;
            this.n = eVar.n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.m7);
            this.f1317b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (a.get(index)) {
                    case 1:
                        this.f1318c = obtainStyledAttributes.getFloat(index, this.f1318c);
                        break;
                    case 2:
                        this.f1319d = obtainStyledAttributes.getFloat(index, this.f1319d);
                        break;
                    case 3:
                        this.f1320e = obtainStyledAttributes.getFloat(index, this.f1320e);
                        break;
                    case 4:
                        this.f1321f = obtainStyledAttributes.getFloat(index, this.f1321f);
                        break;
                    case 5:
                        this.f1322g = obtainStyledAttributes.getFloat(index, this.f1322g);
                        break;
                    case 6:
                        this.f1323h = obtainStyledAttributes.getDimension(index, this.f1323h);
                        break;
                    case 7:
                        this.f1324i = obtainStyledAttributes.getDimension(index, this.f1324i);
                        break;
                    case 8:
                        this.f1325j = obtainStyledAttributes.getDimension(index, this.f1325j);
                        break;
                    case 9:
                        this.f1326k = obtainStyledAttributes.getDimension(index, this.f1326k);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.f1327l = obtainStyledAttributes.getDimension(index, this.f1327l);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.m = true;
                            this.n = obtainStyledAttributes.getDimension(index, this.n);
                            break;
                        } else {
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1285b = sparseIntArray;
        sparseIntArray.append(i.u0, 25);
        f1285b.append(i.v0, 26);
        f1285b.append(i.x0, 29);
        f1285b.append(i.y0, 30);
        f1285b.append(i.E0, 36);
        f1285b.append(i.D0, 35);
        f1285b.append(i.c0, 4);
        f1285b.append(i.b0, 3);
        f1285b.append(i.Z, 1);
        f1285b.append(i.M0, 6);
        f1285b.append(i.N0, 7);
        f1285b.append(i.j0, 17);
        f1285b.append(i.k0, 18);
        f1285b.append(i.l0, 19);
        f1285b.append(i.s, 27);
        f1285b.append(i.z0, 32);
        f1285b.append(i.A0, 33);
        f1285b.append(i.i0, 10);
        f1285b.append(i.h0, 9);
        f1285b.append(i.Q0, 13);
        f1285b.append(i.T0, 16);
        f1285b.append(i.R0, 14);
        f1285b.append(i.O0, 11);
        f1285b.append(i.S0, 15);
        f1285b.append(i.P0, 12);
        f1285b.append(i.H0, 40);
        f1285b.append(i.s0, 39);
        f1285b.append(i.r0, 41);
        f1285b.append(i.G0, 42);
        f1285b.append(i.q0, 20);
        f1285b.append(i.F0, 37);
        f1285b.append(i.g0, 5);
        f1285b.append(i.t0, 82);
        f1285b.append(i.C0, 82);
        f1285b.append(i.w0, 82);
        f1285b.append(i.a0, 82);
        f1285b.append(i.Y, 82);
        f1285b.append(i.x, 24);
        f1285b.append(i.z, 28);
        f1285b.append(i.L, 31);
        f1285b.append(i.M, 8);
        f1285b.append(i.y, 34);
        f1285b.append(i.A, 2);
        f1285b.append(i.v, 23);
        f1285b.append(i.w, 21);
        f1285b.append(i.u, 22);
        f1285b.append(i.B, 43);
        f1285b.append(i.O, 44);
        f1285b.append(i.J, 45);
        f1285b.append(i.K, 46);
        f1285b.append(i.I, 60);
        f1285b.append(i.G, 47);
        f1285b.append(i.H, 48);
        f1285b.append(i.C, 49);
        f1285b.append(i.D, 50);
        f1285b.append(i.E, 51);
        f1285b.append(i.F, 52);
        f1285b.append(i.N, 53);
        f1285b.append(i.I0, 54);
        f1285b.append(i.m0, 55);
        f1285b.append(i.J0, 56);
        f1285b.append(i.n0, 57);
        f1285b.append(i.K0, 58);
        f1285b.append(i.o0, 59);
        f1285b.append(i.d0, 61);
        f1285b.append(i.f0, 62);
        f1285b.append(i.e0, 63);
        f1285b.append(i.P, 64);
        f1285b.append(i.X0, 65);
        f1285b.append(i.V, 66);
        f1285b.append(i.Y0, 67);
        f1285b.append(i.V0, 79);
        f1285b.append(i.t, 38);
        f1285b.append(i.U0, 68);
        f1285b.append(i.L0, 69);
        f1285b.append(i.p0, 70);
        f1285b.append(i.T, 71);
        f1285b.append(i.R, 72);
        f1285b.append(i.S, 73);
        f1285b.append(i.U, 74);
        f1285b.append(i.Q, 75);
        f1285b.append(i.W0, 76);
        f1285b.append(i.B0, 77);
        f1285b.append(i.Z0, 78);
        f1285b.append(i.X, 80);
        f1285b.append(i.W, 81);
    }

    private void A(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index != i.t && i.L != index && i.M != index) {
                aVar.f1291c.f1306b = true;
                aVar.f1292d.f1296c = true;
                aVar.f1290b.a = true;
                aVar.f1293e.f1317b = true;
            }
            switch (f1285b.get(index)) {
                case 1:
                    b bVar = aVar.f1292d;
                    bVar.q = z(typedArray, index, bVar.q);
                    break;
                case 2:
                    b bVar2 = aVar.f1292d;
                    bVar2.H = typedArray.getDimensionPixelSize(index, bVar2.H);
                    break;
                case 3:
                    b bVar3 = aVar.f1292d;
                    bVar3.p = z(typedArray, index, bVar3.p);
                    break;
                case 4:
                    b bVar4 = aVar.f1292d;
                    bVar4.o = z(typedArray, index, bVar4.o);
                    break;
                case 5:
                    aVar.f1292d.x = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f1292d;
                    bVar5.B = typedArray.getDimensionPixelOffset(index, bVar5.B);
                    break;
                case 7:
                    b bVar6 = aVar.f1292d;
                    bVar6.C = typedArray.getDimensionPixelOffset(index, bVar6.C);
                    break;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.f1292d;
                        bVar7.I = typedArray.getDimensionPixelSize(index, bVar7.I);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    b bVar8 = aVar.f1292d;
                    bVar8.u = z(typedArray, index, bVar8.u);
                    break;
                case 10:
                    b bVar9 = aVar.f1292d;
                    bVar9.t = z(typedArray, index, bVar9.t);
                    break;
                case 11:
                    b bVar10 = aVar.f1292d;
                    bVar10.N = typedArray.getDimensionPixelSize(index, bVar10.N);
                    break;
                case 12:
                    b bVar11 = aVar.f1292d;
                    bVar11.O = typedArray.getDimensionPixelSize(index, bVar11.O);
                    break;
                case 13:
                    b bVar12 = aVar.f1292d;
                    bVar12.K = typedArray.getDimensionPixelSize(index, bVar12.K);
                    break;
                case 14:
                    b bVar13 = aVar.f1292d;
                    bVar13.M = typedArray.getDimensionPixelSize(index, bVar13.M);
                    break;
                case 15:
                    b bVar14 = aVar.f1292d;
                    bVar14.P = typedArray.getDimensionPixelSize(index, bVar14.P);
                    break;
                case 16:
                    b bVar15 = aVar.f1292d;
                    bVar15.L = typedArray.getDimensionPixelSize(index, bVar15.L);
                    break;
                case 17:
                    b bVar16 = aVar.f1292d;
                    bVar16.f1299f = typedArray.getDimensionPixelOffset(index, bVar16.f1299f);
                    break;
                case 18:
                    b bVar17 = aVar.f1292d;
                    bVar17.f1300g = typedArray.getDimensionPixelOffset(index, bVar17.f1300g);
                    break;
                case 19:
                    b bVar18 = aVar.f1292d;
                    bVar18.f1301h = typedArray.getFloat(index, bVar18.f1301h);
                    break;
                case 20:
                    b bVar19 = aVar.f1292d;
                    bVar19.v = typedArray.getFloat(index, bVar19.v);
                    break;
                case 21:
                    b bVar20 = aVar.f1292d;
                    bVar20.f1298e = typedArray.getLayoutDimension(index, bVar20.f1298e);
                    break;
                case 22:
                    C0020d c0020d = aVar.f1290b;
                    c0020d.f1313b = typedArray.getInt(index, c0020d.f1313b);
                    C0020d c0020d2 = aVar.f1290b;
                    c0020d2.f1313b = a[c0020d2.f1313b];
                    break;
                case 23:
                    b bVar21 = aVar.f1292d;
                    bVar21.f1297d = typedArray.getLayoutDimension(index, bVar21.f1297d);
                    break;
                case 24:
                    b bVar22 = aVar.f1292d;
                    bVar22.E = typedArray.getDimensionPixelSize(index, bVar22.E);
                    break;
                case 25:
                    b bVar23 = aVar.f1292d;
                    bVar23.f1302i = z(typedArray, index, bVar23.f1302i);
                    break;
                case 26:
                    b bVar24 = aVar.f1292d;
                    bVar24.f1303j = z(typedArray, index, bVar24.f1303j);
                    break;
                case 27:
                    b bVar25 = aVar.f1292d;
                    bVar25.D = typedArray.getInt(index, bVar25.D);
                    break;
                case 28:
                    b bVar26 = aVar.f1292d;
                    bVar26.F = typedArray.getDimensionPixelSize(index, bVar26.F);
                    break;
                case 29:
                    b bVar27 = aVar.f1292d;
                    bVar27.f1304k = z(typedArray, index, bVar27.f1304k);
                    break;
                case 30:
                    b bVar28 = aVar.f1292d;
                    bVar28.f1305l = z(typedArray, index, bVar28.f1305l);
                    break;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.f1292d;
                        bVar29.J = typedArray.getDimensionPixelSize(index, bVar29.J);
                        break;
                    } else {
                        break;
                    }
                case 32:
                    b bVar30 = aVar.f1292d;
                    bVar30.r = z(typedArray, index, bVar30.r);
                    break;
                case 33:
                    b bVar31 = aVar.f1292d;
                    bVar31.s = z(typedArray, index, bVar31.s);
                    break;
                case 34:
                    b bVar32 = aVar.f1292d;
                    bVar32.G = typedArray.getDimensionPixelSize(index, bVar32.G);
                    break;
                case 35:
                    b bVar33 = aVar.f1292d;
                    bVar33.n = z(typedArray, index, bVar33.n);
                    break;
                case 36:
                    b bVar34 = aVar.f1292d;
                    bVar34.m = z(typedArray, index, bVar34.m);
                    break;
                case 37:
                    b bVar35 = aVar.f1292d;
                    bVar35.w = typedArray.getFloat(index, bVar35.w);
                    break;
                case 38:
                    aVar.a = typedArray.getResourceId(index, aVar.a);
                    break;
                case 39:
                    b bVar36 = aVar.f1292d;
                    bVar36.R = typedArray.getFloat(index, bVar36.R);
                    break;
                case 40:
                    b bVar37 = aVar.f1292d;
                    bVar37.Q = typedArray.getFloat(index, bVar37.Q);
                    break;
                case 41:
                    b bVar38 = aVar.f1292d;
                    bVar38.S = typedArray.getInt(index, bVar38.S);
                    break;
                case 42:
                    b bVar39 = aVar.f1292d;
                    bVar39.T = typedArray.getInt(index, bVar39.T);
                    break;
                case 43:
                    C0020d c0020d3 = aVar.f1290b;
                    c0020d3.f1315d = typedArray.getFloat(index, c0020d3.f1315d);
                    break;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.f1293e;
                        eVar.m = true;
                        eVar.n = typedArray.getDimension(index, eVar.n);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    e eVar2 = aVar.f1293e;
                    eVar2.f1319d = typedArray.getFloat(index, eVar2.f1319d);
                    break;
                case 46:
                    e eVar3 = aVar.f1293e;
                    eVar3.f1320e = typedArray.getFloat(index, eVar3.f1320e);
                    break;
                case 47:
                    e eVar4 = aVar.f1293e;
                    eVar4.f1321f = typedArray.getFloat(index, eVar4.f1321f);
                    break;
                case 48:
                    e eVar5 = aVar.f1293e;
                    eVar5.f1322g = typedArray.getFloat(index, eVar5.f1322g);
                    break;
                case 49:
                    e eVar6 = aVar.f1293e;
                    eVar6.f1323h = typedArray.getDimension(index, eVar6.f1323h);
                    break;
                case 50:
                    e eVar7 = aVar.f1293e;
                    eVar7.f1324i = typedArray.getDimension(index, eVar7.f1324i);
                    break;
                case 51:
                    e eVar8 = aVar.f1293e;
                    eVar8.f1325j = typedArray.getDimension(index, eVar8.f1325j);
                    break;
                case 52:
                    e eVar9 = aVar.f1293e;
                    eVar9.f1326k = typedArray.getDimension(index, eVar9.f1326k);
                    break;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.f1293e;
                        eVar10.f1327l = typedArray.getDimension(index, eVar10.f1327l);
                        break;
                    } else {
                        break;
                    }
                case 54:
                    b bVar40 = aVar.f1292d;
                    bVar40.U = typedArray.getInt(index, bVar40.U);
                    break;
                case 55:
                    b bVar41 = aVar.f1292d;
                    bVar41.V = typedArray.getInt(index, bVar41.V);
                    break;
                case 56:
                    b bVar42 = aVar.f1292d;
                    bVar42.W = typedArray.getDimensionPixelSize(index, bVar42.W);
                    break;
                case 57:
                    b bVar43 = aVar.f1292d;
                    bVar43.X = typedArray.getDimensionPixelSize(index, bVar43.X);
                    break;
                case 58:
                    b bVar44 = aVar.f1292d;
                    bVar44.Y = typedArray.getDimensionPixelSize(index, bVar44.Y);
                    break;
                case 59:
                    b bVar45 = aVar.f1292d;
                    bVar45.Z = typedArray.getDimensionPixelSize(index, bVar45.Z);
                    break;
                case 60:
                    e eVar11 = aVar.f1293e;
                    eVar11.f1318c = typedArray.getFloat(index, eVar11.f1318c);
                    break;
                case 61:
                    b bVar46 = aVar.f1292d;
                    bVar46.y = z(typedArray, index, bVar46.y);
                    break;
                case 62:
                    b bVar47 = aVar.f1292d;
                    bVar47.z = typedArray.getDimensionPixelSize(index, bVar47.z);
                    break;
                case 63:
                    b bVar48 = aVar.f1292d;
                    bVar48.A = typedArray.getFloat(index, bVar48.A);
                    break;
                case 64:
                    c cVar = aVar.f1291c;
                    cVar.f1307c = z(typedArray, index, cVar.f1307c);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f1291c.f1308d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f1291c.f1308d = c.f.a.a.c.f2675b[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f1291c.f1310f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f1291c;
                    cVar2.f1312h = typedArray.getFloat(index, cVar2.f1312h);
                    break;
                case 68:
                    C0020d c0020d4 = aVar.f1290b;
                    c0020d4.f1316e = typedArray.getFloat(index, c0020d4.f1316e);
                    break;
                case 69:
                    aVar.f1292d.a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f1292d.b0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f1292d;
                    bVar49.c0 = typedArray.getInt(index, bVar49.c0);
                    break;
                case 73:
                    b bVar50 = aVar.f1292d;
                    bVar50.d0 = typedArray.getDimensionPixelSize(index, bVar50.d0);
                    break;
                case 74:
                    aVar.f1292d.g0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f1292d;
                    bVar51.k0 = typedArray.getBoolean(index, bVar51.k0);
                    break;
                case 76:
                    c cVar3 = aVar.f1291c;
                    cVar3.f1309e = typedArray.getInt(index, cVar3.f1309e);
                    break;
                case 77:
                    aVar.f1292d.h0 = typedArray.getString(index);
                    break;
                case 78:
                    C0020d c0020d5 = aVar.f1290b;
                    c0020d5.f1314c = typedArray.getInt(index, c0020d5.f1314c);
                    break;
                case 79:
                    c cVar4 = aVar.f1291c;
                    cVar4.f1311g = typedArray.getFloat(index, cVar4.f1311g);
                    break;
                case 80:
                    b bVar52 = aVar.f1292d;
                    bVar52.i0 = typedArray.getBoolean(index, bVar52.i0);
                    break;
                case 81:
                    b bVar53 = aVar.f1292d;
                    bVar53.j0 = typedArray.getBoolean(index, bVar53.j0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1285b.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f1285b.get(index));
                    break;
            }
        }
    }

    private String G(int i2) {
        switch (i2) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private int[] n(View view, String str) {
        int i2;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = h.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i2 = ((Integer) designInformation).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    private a o(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.r);
        A(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private a p(int i2) {
        if (!this.f1289f.containsKey(Integer.valueOf(i2))) {
            this.f1289f.put(Integer.valueOf(i2), new a());
        }
        return this.f1289f.get(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int z(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    public void B(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1288e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1289f.containsKey(Integer.valueOf(id))) {
                this.f1289f.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f1289f.get(Integer.valueOf(id));
            if (!aVar.f1292d.f1296c) {
                aVar.f(id, bVar);
                if (childAt instanceof androidx.constraintlayout.widget.b) {
                    aVar.f1292d.f0 = ((androidx.constraintlayout.widget.b) childAt).getReferencedIds();
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        aVar.f1292d.k0 = barrier.r();
                        aVar.f1292d.c0 = barrier.getType();
                        aVar.f1292d.d0 = barrier.getMargin();
                    }
                }
                aVar.f1292d.f1296c = true;
            }
            C0020d c0020d = aVar.f1290b;
            if (!c0020d.a) {
                c0020d.f1313b = childAt.getVisibility();
                aVar.f1290b.f1315d = childAt.getAlpha();
                aVar.f1290b.a = true;
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 17) {
                e eVar = aVar.f1293e;
                if (!eVar.f1317b) {
                    eVar.f1317b = true;
                    eVar.f1318c = childAt.getRotation();
                    aVar.f1293e.f1319d = childAt.getRotationX();
                    aVar.f1293e.f1320e = childAt.getRotationY();
                    aVar.f1293e.f1321f = childAt.getScaleX();
                    aVar.f1293e.f1322g = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f1293e;
                        eVar2.f1323h = pivotX;
                        eVar2.f1324i = pivotY;
                    }
                    aVar.f1293e.f1325j = childAt.getTranslationX();
                    aVar.f1293e.f1326k = childAt.getTranslationY();
                    if (i3 >= 21) {
                        aVar.f1293e.f1327l = childAt.getTranslationZ();
                        e eVar3 = aVar.f1293e;
                        if (eVar3.m) {
                            eVar3.n = childAt.getElevation();
                        }
                    }
                }
            }
        }
    }

    public void C(d dVar) {
        for (Integer num : dVar.f1289f.keySet()) {
            int intValue = num.intValue();
            a aVar = dVar.f1289f.get(num);
            if (!this.f1289f.containsKey(Integer.valueOf(intValue))) {
                this.f1289f.put(Integer.valueOf(intValue), new a());
            }
            a aVar2 = this.f1289f.get(Integer.valueOf(intValue));
            b bVar = aVar2.f1292d;
            if (!bVar.f1296c) {
                bVar.a(aVar.f1292d);
            }
            C0020d c0020d = aVar2.f1290b;
            if (!c0020d.a) {
                c0020d.a(aVar.f1290b);
            }
            e eVar = aVar2.f1293e;
            if (!eVar.f1317b) {
                eVar.a(aVar.f1293e);
            }
            c cVar = aVar2.f1291c;
            if (!cVar.f1306b) {
                cVar.a(aVar.f1291c);
            }
            for (String str : aVar.f1294f.keySet()) {
                if (!aVar2.f1294f.containsKey(str)) {
                    aVar2.f1294f.put(str, aVar.f1294f.get(str));
                }
            }
        }
    }

    public void D(boolean z) {
        this.f1288e = z;
    }

    public void E(boolean z) {
        this.f1286c = z;
    }

    public void F(int i2, float f2) {
        p(i2).f1292d.w = f2;
    }

    public void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f1289f.containsKey(Integer.valueOf(id))) {
                Log.v("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.c(childAt));
            } else if (this.f1288e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (this.f1289f.containsKey(Integer.valueOf(id))) {
                    androidx.constraintlayout.widget.a.h(childAt, this.f1289f.get(Integer.valueOf(id)).f1294f);
                }
            }
        }
    }

    public void d(ConstraintLayout constraintLayout) {
        f(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void e(androidx.constraintlayout.widget.b bVar, c.f.b.k.e eVar, ConstraintLayout.b bVar2, SparseArray<c.f.b.k.e> sparseArray) {
        int id = bVar.getId();
        if (this.f1289f.containsKey(Integer.valueOf(id))) {
            a aVar = this.f1289f.get(Integer.valueOf(id));
            if (eVar instanceof c.f.b.k.j) {
                bVar.j(aVar, (c.f.b.k.j) eVar, bVar2, sparseArray);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f1289f.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f1289f.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.c(childAt));
            } else if (this.f1288e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.f1289f.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f1289f.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f1292d.e0 = 1;
                        }
                        int i3 = aVar.f1292d.e0;
                        if (i3 != -1 && i3 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f1292d.c0);
                            barrier.setMargin(aVar.f1292d.d0);
                            barrier.setAllowsGoneWidget(aVar.f1292d.k0);
                            b bVar = aVar.f1292d;
                            int[] iArr = bVar.f0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = bVar.g0;
                                if (str != null) {
                                    bVar.f0 = n(barrier, str);
                                    barrier.setReferencedIds(aVar.f1292d.f0);
                                }
                            }
                        }
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                        bVar2.c();
                        aVar.d(bVar2);
                        if (z) {
                            androidx.constraintlayout.widget.a.h(childAt, aVar.f1294f);
                        }
                        childAt.setLayoutParams(bVar2);
                        C0020d c0020d = aVar.f1290b;
                        if (c0020d.f1314c == 0) {
                            childAt.setVisibility(c0020d.f1313b);
                        }
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 17) {
                            childAt.setAlpha(aVar.f1290b.f1315d);
                            childAt.setRotation(aVar.f1293e.f1318c);
                            childAt.setRotationX(aVar.f1293e.f1319d);
                            childAt.setRotationY(aVar.f1293e.f1320e);
                            childAt.setScaleX(aVar.f1293e.f1321f);
                            childAt.setScaleY(aVar.f1293e.f1322g);
                            if (!Float.isNaN(aVar.f1293e.f1323h)) {
                                childAt.setPivotX(aVar.f1293e.f1323h);
                            }
                            if (!Float.isNaN(aVar.f1293e.f1324i)) {
                                childAt.setPivotY(aVar.f1293e.f1324i);
                            }
                            childAt.setTranslationX(aVar.f1293e.f1325j);
                            childAt.setTranslationY(aVar.f1293e.f1326k);
                            if (i4 >= 21) {
                                childAt.setTranslationZ(aVar.f1293e.f1327l);
                                e eVar = aVar.f1293e;
                                if (eVar.m) {
                                    childAt.setElevation(eVar.n);
                                }
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f1289f.get(num);
            int i5 = aVar2.f1292d.e0;
            if (i5 != -1 && i5 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar3 = aVar2.f1292d;
                int[] iArr2 = bVar3.f0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar3.g0;
                    if (str2 != null) {
                        bVar3.f0 = n(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f1292d.f0);
                    }
                }
                barrier2.setType(aVar2.f1292d.c0);
                barrier2.setMargin(aVar2.f1292d.d0);
                ConstraintLayout.b generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.q();
                aVar2.d(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar2.f1292d.f1295b) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.b generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.d(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void g(int i2, ConstraintLayout.b bVar) {
        if (this.f1289f.containsKey(Integer.valueOf(i2))) {
            this.f1289f.get(Integer.valueOf(i2)).d(bVar);
        }
    }

    public void h(int i2, int i3) {
        if (this.f1289f.containsKey(Integer.valueOf(i2))) {
            a aVar = this.f1289f.get(Integer.valueOf(i2));
            switch (i3) {
                case 1:
                    b bVar = aVar.f1292d;
                    bVar.f1303j = -1;
                    bVar.f1302i = -1;
                    bVar.E = -1;
                    bVar.K = -1;
                    return;
                case 2:
                    b bVar2 = aVar.f1292d;
                    bVar2.f1305l = -1;
                    bVar2.f1304k = -1;
                    bVar2.F = -1;
                    bVar2.M = -1;
                    return;
                case 3:
                    b bVar3 = aVar.f1292d;
                    bVar3.n = -1;
                    bVar3.m = -1;
                    bVar3.G = -1;
                    bVar3.L = -1;
                    return;
                case 4:
                    b bVar4 = aVar.f1292d;
                    bVar4.o = -1;
                    bVar4.p = -1;
                    bVar4.H = -1;
                    bVar4.N = -1;
                    return;
                case 5:
                    aVar.f1292d.q = -1;
                    return;
                case 6:
                    b bVar5 = aVar.f1292d;
                    bVar5.r = -1;
                    bVar5.s = -1;
                    bVar5.J = -1;
                    bVar5.P = -1;
                    return;
                case 7:
                    b bVar6 = aVar.f1292d;
                    bVar6.t = -1;
                    bVar6.u = -1;
                    bVar6.I = -1;
                    bVar6.O = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void i(Context context, int i2) {
        j((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void j(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f1289f.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1288e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1289f.containsKey(Integer.valueOf(id))) {
                this.f1289f.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f1289f.get(Integer.valueOf(id));
            aVar.f1294f = androidx.constraintlayout.widget.a.b(this.f1287d, childAt);
            aVar.f(id, bVar);
            aVar.f1290b.f1313b = childAt.getVisibility();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 17) {
                aVar.f1290b.f1315d = childAt.getAlpha();
                aVar.f1293e.f1318c = childAt.getRotation();
                aVar.f1293e.f1319d = childAt.getRotationX();
                aVar.f1293e.f1320e = childAt.getRotationY();
                aVar.f1293e.f1321f = childAt.getScaleX();
                aVar.f1293e.f1322g = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f1293e;
                    eVar.f1323h = pivotX;
                    eVar.f1324i = pivotY;
                }
                aVar.f1293e.f1325j = childAt.getTranslationX();
                aVar.f1293e.f1326k = childAt.getTranslationY();
                if (i3 >= 21) {
                    aVar.f1293e.f1327l = childAt.getTranslationZ();
                    e eVar2 = aVar.f1293e;
                    if (eVar2.m) {
                        eVar2.n = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f1292d.k0 = barrier.r();
                aVar.f1292d.f0 = barrier.getReferencedIds();
                aVar.f1292d.c0 = barrier.getType();
                aVar.f1292d.d0 = barrier.getMargin();
            }
        }
    }

    public void k(androidx.constraintlayout.widget.e eVar) {
        int childCount = eVar.getChildCount();
        this.f1289f.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = eVar.getChildAt(i2);
            e.a aVar = (e.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f1288e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f1289f.containsKey(Integer.valueOf(id))) {
                this.f1289f.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.f1289f.get(Integer.valueOf(id));
            if (childAt instanceof androidx.constraintlayout.widget.b) {
                aVar2.h((androidx.constraintlayout.widget.b) childAt, id, aVar);
            }
            aVar2.g(id, aVar);
        }
    }

    public void l(int i2, int i3, int i4, int i5) {
        if (!this.f1289f.containsKey(Integer.valueOf(i2))) {
            this.f1289f.put(Integer.valueOf(i2), new a());
        }
        a aVar = this.f1289f.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    b bVar = aVar.f1292d;
                    bVar.f1302i = i4;
                    bVar.f1303j = -1;
                    return;
                } else if (i5 == 2) {
                    b bVar2 = aVar.f1292d;
                    bVar2.f1303j = i4;
                    bVar2.f1302i = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + G(i5) + " undefined");
                }
            case 2:
                if (i5 == 1) {
                    b bVar3 = aVar.f1292d;
                    bVar3.f1304k = i4;
                    bVar3.f1305l = -1;
                    return;
                } else if (i5 == 2) {
                    b bVar4 = aVar.f1292d;
                    bVar4.f1305l = i4;
                    bVar4.f1304k = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
            case 3:
                if (i5 == 3) {
                    b bVar5 = aVar.f1292d;
                    bVar5.m = i4;
                    bVar5.n = -1;
                    bVar5.q = -1;
                    return;
                } else if (i5 == 4) {
                    b bVar6 = aVar.f1292d;
                    bVar6.n = i4;
                    bVar6.m = -1;
                    bVar6.q = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
            case 4:
                if (i5 == 4) {
                    b bVar7 = aVar.f1292d;
                    bVar7.p = i4;
                    bVar7.o = -1;
                    bVar7.q = -1;
                    return;
                } else if (i5 == 3) {
                    b bVar8 = aVar.f1292d;
                    bVar8.o = i4;
                    bVar8.p = -1;
                    bVar8.q = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
            case 5:
                if (i5 == 5) {
                    b bVar9 = aVar.f1292d;
                    bVar9.q = i4;
                    bVar9.p = -1;
                    bVar9.o = -1;
                    bVar9.m = -1;
                    bVar9.n = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + G(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    b bVar10 = aVar.f1292d;
                    bVar10.s = i4;
                    bVar10.r = -1;
                    return;
                } else if (i5 == 7) {
                    b bVar11 = aVar.f1292d;
                    bVar11.r = i4;
                    bVar11.s = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
            case 7:
                if (i5 == 7) {
                    b bVar12 = aVar.f1292d;
                    bVar12.u = i4;
                    bVar12.t = -1;
                    return;
                } else if (i5 == 6) {
                    b bVar13 = aVar.f1292d;
                    bVar13.t = i4;
                    bVar13.u = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
            default:
                throw new IllegalArgumentException(G(i3) + " to " + G(i5) + " unknown");
        }
    }

    public void m(int i2, int i3, int i4, int i5, int i6) {
        if (!this.f1289f.containsKey(Integer.valueOf(i2))) {
            this.f1289f.put(Integer.valueOf(i2), new a());
        }
        a aVar = this.f1289f.get(Integer.valueOf(i2));
        switch (i3) {
            case 1:
                if (i5 == 1) {
                    b bVar = aVar.f1292d;
                    bVar.f1302i = i4;
                    bVar.f1303j = -1;
                } else if (i5 == 2) {
                    b bVar2 = aVar.f1292d;
                    bVar2.f1303j = i4;
                    bVar2.f1302i = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + G(i5) + " undefined");
                }
                aVar.f1292d.E = i6;
                return;
            case 2:
                if (i5 == 1) {
                    b bVar3 = aVar.f1292d;
                    bVar3.f1304k = i4;
                    bVar3.f1305l = -1;
                } else if (i5 == 2) {
                    b bVar4 = aVar.f1292d;
                    bVar4.f1305l = i4;
                    bVar4.f1304k = -1;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
                aVar.f1292d.F = i6;
                return;
            case 3:
                if (i5 == 3) {
                    b bVar5 = aVar.f1292d;
                    bVar5.m = i4;
                    bVar5.n = -1;
                    bVar5.q = -1;
                } else if (i5 == 4) {
                    b bVar6 = aVar.f1292d;
                    bVar6.n = i4;
                    bVar6.m = -1;
                    bVar6.q = -1;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
                aVar.f1292d.G = i6;
                return;
            case 4:
                if (i5 == 4) {
                    b bVar7 = aVar.f1292d;
                    bVar7.p = i4;
                    bVar7.o = -1;
                    bVar7.q = -1;
                } else if (i5 == 3) {
                    b bVar8 = aVar.f1292d;
                    bVar8.o = i4;
                    bVar8.p = -1;
                    bVar8.q = -1;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
                aVar.f1292d.H = i6;
                return;
            case 5:
                if (i5 == 5) {
                    b bVar9 = aVar.f1292d;
                    bVar9.q = i4;
                    bVar9.p = -1;
                    bVar9.o = -1;
                    bVar9.m = -1;
                    bVar9.n = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + G(i5) + " undefined");
            case 6:
                if (i5 == 6) {
                    b bVar10 = aVar.f1292d;
                    bVar10.s = i4;
                    bVar10.r = -1;
                } else if (i5 == 7) {
                    b bVar11 = aVar.f1292d;
                    bVar11.r = i4;
                    bVar11.s = -1;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
                aVar.f1292d.J = i6;
                return;
            case 7:
                if (i5 == 7) {
                    b bVar12 = aVar.f1292d;
                    bVar12.u = i4;
                    bVar12.t = -1;
                } else if (i5 == 6) {
                    b bVar13 = aVar.f1292d;
                    bVar13.t = i4;
                    bVar13.u = -1;
                } else {
                    throw new IllegalArgumentException("right to " + G(i5) + " undefined");
                }
                aVar.f1292d.I = i6;
                return;
            default:
                throw new IllegalArgumentException(G(i3) + " to " + G(i5) + " unknown");
        }
    }

    public a q(int i2) {
        if (this.f1289f.containsKey(Integer.valueOf(i2))) {
            return this.f1289f.get(Integer.valueOf(i2));
        }
        return null;
    }

    public int r(int i2) {
        return p(i2).f1292d.f1298e;
    }

    public int[] s() {
        Integer[] numArr = (Integer[]) this.f1289f.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public a t(int i2) {
        return p(i2);
    }

    public int u(int i2) {
        return p(i2).f1290b.f1313b;
    }

    public int v(int i2) {
        return p(i2).f1290b.f1314c;
    }

    public int w(int i2) {
        return p(i2).f1292d.f1297d;
    }

    public void x(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    a o = o(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        o.f1292d.f1295b = true;
                    }
                    this.f1289f.put(Integer.valueOf(o.a), o);
                    continue;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0179, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.y(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}