package com.horcrux.svg;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: RNSVGMarkerPosition.java */
/* loaded from: classes2.dex */
class x {
    private static ArrayList<x> a;

    /* renamed from: b  reason: collision with root package name */
    private static int f10314b;

    /* renamed from: c  reason: collision with root package name */
    private static v f10315c;

    /* renamed from: d  reason: collision with root package name */
    private static v f10316d;

    /* renamed from: e  reason: collision with root package name */
    private static v f10317e;

    /* renamed from: f  reason: collision with root package name */
    private static v f10318f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f10319g;

    /* renamed from: h  reason: collision with root package name */
    y f10320h;

    /* renamed from: i  reason: collision with root package name */
    v f10321i;

    /* renamed from: j  reason: collision with root package name */
    double f10322j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNSVGMarkerPosition.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10323b;

        static {
            int[] iArr = new int[f.values().length];
            f10323b = iArr;
            try {
                iArr[f.kCGPathElementAddCurveToPoint.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10323b[f.kCGPathElementAddQuadCurveToPoint.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10323b[f.kCGPathElementMoveToPoint.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10323b[f.kCGPathElementAddLineToPoint.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10323b[f.kCGPathElementCloseSubpath.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[y.values().length];
            a = iArr2;
            try {
                iArr2[y.kStartMarker.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[y.kMidMarker.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[y.kEndMarker.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private x(y yVar, v vVar, double d2) {
        this.f10320h = yVar;
        this.f10321i = vVar;
        this.f10322j = d2;
    }

    private static double a(double d2, double d3) {
        if (Math.abs(d2 - d3) > 180.0d) {
            d2 += 360.0d;
        }
        return (d2 + d3) / 2.0d;
    }

    private static void b(d0 d0Var, v vVar, v vVar2, v vVar3) {
        d0Var.a = k(vVar2, vVar);
        d0Var.f10222b = k(vVar3, vVar2);
        if (i(d0Var.a)) {
            d0Var.a = d0Var.f10222b;
        } else if (i(d0Var.f10222b)) {
            d0Var.f10222b = d0Var.a;
        }
    }

    private static double c(y yVar) {
        double j2 = j(f(f10317e));
        double j3 = j(f(f10318f));
        int i2 = a.a[yVar.ordinal()];
        if (i2 == 1) {
            return f10319g ? j3 + 180.0d : j3;
        } else if (i2 != 2) {
            if (i2 != 3) {
                return 0.0d;
            }
            return j2;
        } else {
            return a(j2, j3);
        }
    }

    private static d0 d(r rVar) {
        d0 d0Var = new d0();
        v[] vVarArr = rVar.f10295b;
        int i2 = a.f10323b[rVar.a.ordinal()];
        if (i2 == 1) {
            d0Var.f10223c = vVarArr[2];
            d0Var.a = k(vVarArr[0], f10315c);
            d0Var.f10222b = k(vVarArr[2], vVarArr[1]);
            if (i(d0Var.a)) {
                b(d0Var, vVarArr[0], vVarArr[1], vVarArr[2]);
            } else if (i(d0Var.f10222b)) {
                b(d0Var, f10315c, vVarArr[0], vVarArr[1]);
            }
        } else if (i2 == 2) {
            d0Var.f10223c = vVarArr[1];
            b(d0Var, f10315c, vVarArr[0], vVarArr[1]);
        } else if (i2 == 3 || i2 == 4) {
            v vVar = vVarArr[0];
            d0Var.f10223c = vVar;
            d0Var.a = k(vVar, f10315c);
            d0Var.f10222b = k(d0Var.f10223c, f10315c);
        } else if (i2 == 5) {
            v vVar2 = f10316d;
            d0Var.f10223c = vVar2;
            d0Var.a = k(vVar2, f10315c);
            d0Var.f10222b = k(d0Var.f10223c, f10315c);
        }
        return d0Var;
    }

    private static void e() {
        y yVar = y.kEndMarker;
        a.add(new x(yVar, f10315c, c(yVar)));
    }

    private static double f(v vVar) {
        return Math.atan2(vVar.f10313b, vVar.a);
    }

    private static void g(r rVar) {
        d0 d2 = d(rVar);
        f10318f = d2.a;
        int i2 = f10314b;
        if (i2 > 0) {
            y yVar = i2 == 1 ? y.kStartMarker : y.kMidMarker;
            a.add(new x(yVar, f10315c, c(yVar)));
        }
        f10317e = d2.f10222b;
        f10315c = d2.f10223c;
        f fVar = rVar.a;
        if (fVar == f.kCGPathElementMoveToPoint) {
            f10316d = rVar.f10295b[0];
        } else if (fVar == f.kCGPathElementCloseSubpath) {
            f10316d = new v(0.0d, 0.0d);
        }
        f10314b++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<x> h(ArrayList<r> arrayList) {
        a = new ArrayList<>();
        f10314b = 0;
        f10315c = new v(0.0d, 0.0d);
        f10316d = new v(0.0d, 0.0d);
        Iterator<r> it = arrayList.iterator();
        while (it.hasNext()) {
            g(it.next());
        }
        e();
        return a;
    }

    private static boolean i(v vVar) {
        return vVar.a == 0.0d && vVar.f10313b == 0.0d;
    }

    private static double j(double d2) {
        return d2 * 57.29577951308232d;
    }

    private static v k(v vVar, v vVar2) {
        return new v(vVar2.a - vVar.a, vVar2.f10313b - vVar.f10313b);
    }
}