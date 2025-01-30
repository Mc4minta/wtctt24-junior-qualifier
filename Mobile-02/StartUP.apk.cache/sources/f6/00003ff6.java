package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: OperatorNode.java */
/* loaded from: classes2.dex */
public class o extends com.swmansion.reanimated.nodes.m {
    private final int[] F;
    private final com.swmansion.reanimated.nodes.m[] G;
    private final g0 H;
    private static final g0 a = new k();

    /* renamed from: b  reason: collision with root package name */
    private static final g0 f10978b = new v();

    /* renamed from: c  reason: collision with root package name */
    private static final g0 f10979c = new y();

    /* renamed from: d  reason: collision with root package name */
    private static final g0 f10980d = new z();

    /* renamed from: e  reason: collision with root package name */
    private static final g0 f10981e = new a0();

    /* renamed from: f  reason: collision with root package name */
    private static final g0 f10982f = new b0();

    /* renamed from: g  reason: collision with root package name */
    private static final g0 f10983g = new c0();

    /* renamed from: h  reason: collision with root package name */
    private static final g0 f10984h = new d0();

    /* renamed from: i  reason: collision with root package name */
    private static final g0 f10985i = new e0();

    /* renamed from: j  reason: collision with root package name */
    private static final g0 f10986j = new a();

    /* renamed from: k  reason: collision with root package name */
    private static final g0 f10987k = new b();

    /* renamed from: l  reason: collision with root package name */
    private static final g0 f10988l = new c();
    private static final g0 m = new d();
    private static final g0 n = new e();
    private static final g0 o = new f();
    private static final g0 p = new g();
    private static final g0 q = new h();
    private static final g0 r = new i();
    private static final g0 s = new j();
    private static final g0 t = new l();
    private static final g0 u = new m();
    private static final g0 v = new n();
    private static final g0 w = new C0236o();
    private static final g0 x = new p();
    private static final g0 y = new q();
    private static final g0 z = new r();
    private static final g0 A = new s();
    private static final g0 B = new t();
    private static final g0 C = new u();
    private static final g0 D = new w();
    private static final g0 E = new x();

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class a extends i0 {
        a() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.cos(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class a0 extends h0 {
        a0() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return Math.pow(d2.doubleValue(), d3.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class b extends i0 {
        b() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.tan(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class b0 extends h0 {
        b0() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return ((d2.doubleValue() % d3.doubleValue()) + d3.doubleValue()) % d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class c extends i0 {
        c() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.acos(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class c0 extends i0 {
        c0() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.sqrt(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class d extends i0 {
        d() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.asin(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class d0 extends i0 {
        d0() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.log(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class e extends i0 {
        e() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.atan(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class e0 extends i0 {
        e0() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.sin(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class f extends i0 {
        f() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.exp(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    private static abstract class f0 implements g0 {
        private f0() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            return b((Double) mVarArr[0].value(), (Double) mVarArr[1].value()) ? 1.0d : 0.0d;
        }

        public abstract boolean b(Double d2, Double d3);

        /* synthetic */ f0(k kVar) {
            this();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class g extends i0 {
        g() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.round(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    private interface g0 {
        double a(com.swmansion.reanimated.nodes.m[] mVarArr);
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class h extends i0 {
        h() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.abs(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    private static abstract class h0 implements g0 {
        private h0() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            double doubleValue = mVarArr[0].doubleValue().doubleValue();
            for (int i2 = 1; i2 < mVarArr.length; i2++) {
                doubleValue = b(Double.valueOf(doubleValue), mVarArr[i2].doubleValue());
            }
            return doubleValue;
        }

        public abstract double b(Double d2, Double d3);

        /* synthetic */ h0(k kVar) {
            this();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class i extends i0 {
        i() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.floor(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    private static abstract class i0 implements g0 {
        private i0() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            return b((Double) mVarArr[0].value());
        }

        public abstract double b(Double d2);

        /* synthetic */ i0(k kVar) {
            this();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class j extends i0 {
        j() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.i0
        public double b(Double d2) {
            return Math.ceil(d2.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class k extends h0 {
        k() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return d2.doubleValue() + d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class l extends h0 {
        l() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return Math.min(d2.doubleValue(), d3.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class m extends h0 {
        m() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return Math.max(d2.doubleValue(), d3.doubleValue());
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class n implements g0 {
        n() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            boolean d2 = o.d(mVarArr[0].value());
            for (int i2 = 1; i2 < mVarArr.length && d2; i2++) {
                d2 = d2 && o.d(mVarArr[i2].value());
            }
            return d2 ? 1.0d : 0.0d;
        }
    }

    /* compiled from: OperatorNode.java */
    /* renamed from: com.swmansion.reanimated.nodes.o$o  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0236o implements g0 {
        C0236o() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            boolean d2 = o.d(mVarArr[0].value());
            for (int i2 = 1; i2 < mVarArr.length && !d2; i2++) {
                d2 = d2 || o.d(mVarArr[i2].value());
            }
            return d2 ? 1.0d : 0.0d;
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class p implements g0 {
        p() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            return o.d(mVarArr[0].value()) ? 0.0d : 1.0d;
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class q implements g0 {
        q() {
        }

        @Override // com.swmansion.reanimated.nodes.o.g0
        public double a(com.swmansion.reanimated.nodes.m[] mVarArr) {
            Object value = mVarArr[0].value();
            return (value == null || ((value instanceof Double) && ((Double) value).isNaN())) ? 0.0d : 1.0d;
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class r extends f0 {
        r() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.f0
        public boolean b(Double d2, Double d3) {
            return (d2 == null || d3 == null || d2.doubleValue() >= d3.doubleValue()) ? false : true;
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class s extends f0 {
        s() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.f0
        public boolean b(Double d2, Double d3) {
            return (d2 == null || d3 == null) ? d2 == d3 : d2.doubleValue() == d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class t extends f0 {
        t() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.f0
        public boolean b(Double d2, Double d3) {
            return (d2 == null || d3 == null || d2.doubleValue() <= d3.doubleValue()) ? false : true;
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class u extends f0 {
        u() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.f0
        public boolean b(Double d2, Double d3) {
            return d2.doubleValue() <= d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class v extends h0 {
        v() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return d2.doubleValue() - d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class w extends f0 {
        w() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.f0
        public boolean b(Double d2, Double d3) {
            return d2.doubleValue() >= d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class x extends f0 {
        x() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.f0
        public boolean b(Double d2, Double d3) {
            return (d2 == null || d3 == null) ? d2 == d3 : d2.doubleValue() != d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class y extends h0 {
        y() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return d2.doubleValue() * d3.doubleValue();
        }
    }

    /* compiled from: OperatorNode.java */
    /* loaded from: classes2.dex */
    static class z extends h0 {
        z() {
            super(null);
        }

        @Override // com.swmansion.reanimated.nodes.o.h0
        public double b(Double d2, Double d3) {
            return d2.doubleValue() / d3.doubleValue();
        }
    }

    public o(int i2, ReadableMap readableMap, com.swmansion.reanimated.b bVar) {
        super(i2, readableMap, bVar);
        int[] a2 = com.swmansion.reanimated.e.a(readableMap.getArray("input"));
        this.F = a2;
        this.G = new com.swmansion.reanimated.nodes.m[a2.length];
        String string = readableMap.getString("op");
        if ("add".equals(string)) {
            this.H = a;
        } else if ("sub".equals(string)) {
            this.H = f10978b;
        } else if ("multiply".equals(string)) {
            this.H = f10979c;
        } else if ("divide".equals(string)) {
            this.H = f10980d;
        } else if ("pow".equals(string)) {
            this.H = f10981e;
        } else if ("modulo".equals(string)) {
            this.H = f10982f;
        } else if ("sqrt".equals(string)) {
            this.H = f10983g;
        } else if ("log".equals(string)) {
            this.H = f10984h;
        } else if ("sin".equals(string)) {
            this.H = f10985i;
        } else if ("cos".equals(string)) {
            this.H = f10986j;
        } else if ("tan".equals(string)) {
            this.H = f10987k;
        } else if ("acos".equals(string)) {
            this.H = f10988l;
        } else if ("asin".equals(string)) {
            this.H = m;
        } else if ("atan".equals(string)) {
            this.H = n;
        } else if ("exp".equals(string)) {
            this.H = o;
        } else if ("round".equals(string)) {
            this.H = p;
        } else if ("and".equals(string)) {
            this.H = v;
        } else if ("or".equals(string)) {
            this.H = w;
        } else if ("not".equals(string)) {
            this.H = x;
        } else if ("defined".equals(string)) {
            this.H = y;
        } else if ("lessThan".equals(string)) {
            this.H = z;
        } else if ("eq".equals(string)) {
            this.H = A;
        } else if ("greaterThan".equals(string)) {
            this.H = B;
        } else if ("lessOrEq".equals(string)) {
            this.H = C;
        } else if ("greaterOrEq".equals(string)) {
            this.H = D;
        } else if ("neq".equals(string)) {
            this.H = E;
        } else if ("abs".equals(string)) {
            this.H = q;
        } else if ("floor".equals(string)) {
            this.H = r;
        } else if ("ceil".equals(string)) {
            this.H = s;
        } else if ("max".equals(string)) {
            this.H = u;
        } else if ("min".equals(string)) {
            this.H = t;
        } else {
            throw new JSApplicationIllegalArgumentException("Unrecognized operator " + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Object obj) {
        return (obj == null || obj.equals(Double.valueOf(0.0d))) ? false : true;
    }

    @Override // com.swmansion.reanimated.nodes.m
    protected Object evaluate() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.F;
            if (i2 < iArr.length) {
                this.G[i2] = this.mNodesManager.o(iArr[i2], com.swmansion.reanimated.nodes.m.class);
                i2++;
            } else {
                return Double.valueOf(this.H.a(this.G));
            }
        }
    }
}