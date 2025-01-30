package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum a uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class h4 {
    private static final h4 A;
    private static final h4 B;
    private static final h4 C;
    private static final h4 D;
    private static final h4 E;
    private static final h4 F;
    private static final h4 G;
    private static final h4 H;
    private static final h4 I;
    private static final h4 J;
    private static final h4 K;
    private static final h4 L;
    private static final h4 M;
    public static final h4 N;
    private static final h4 O;
    private static final h4 P;
    private static final h4 Q;
    private static final h4 R;
    private static final h4 S;
    private static final h4 T;
    private static final h4 U;
    private static final h4 V;
    private static final h4 W;
    private static final h4 X;
    private static final h4 Y;
    private static final h4 Z;
    private static final h4 a;
    public static final h4 a0;

    /* renamed from: b  reason: collision with root package name */
    private static final h4 f7156b;
    private static final h4 b0;

    /* renamed from: c  reason: collision with root package name */
    private static final h4 f7157c;
    private static final h4 c0;

    /* renamed from: d  reason: collision with root package name */
    private static final h4 f7158d;
    private static final h4[] d0;

    /* renamed from: e  reason: collision with root package name */
    private static final h4 f7159e;
    private static final Type[] e0;

    /* renamed from: f  reason: collision with root package name */
    private static final h4 f7160f;
    private static final /* synthetic */ h4[] f0;

    /* renamed from: g  reason: collision with root package name */
    private static final h4 f7161g;

    /* renamed from: h  reason: collision with root package name */
    private static final h4 f7162h;

    /* renamed from: j  reason: collision with root package name */
    private static final h4 f7163j;

    /* renamed from: k  reason: collision with root package name */
    private static final h4 f7164k;

    /* renamed from: l  reason: collision with root package name */
    private static final h4 f7165l;
    private static final h4 m;
    private static final h4 n;
    private static final h4 p;
    private static final h4 q;
    private static final h4 t;
    private static final h4 u;
    private static final h4 v;
    private static final h4 w;
    private static final h4 x;
    private static final h4 y;
    private static final h4 z;
    private final w4 g0;
    private final int h0;
    private final k4 i0;
    private final Class<?> j0;
    private final boolean k0;

    static {
        k4 k4Var = k4.SCALAR;
        w4 w4Var = w4.f7386e;
        a = new h4("DOUBLE", 0, 0, k4Var, w4Var);
        w4 w4Var2 = w4.f7385d;
        f7156b = new h4("FLOAT", 1, 1, k4Var, w4Var2);
        w4 w4Var3 = w4.f7384c;
        f7157c = new h4("INT64", 2, 2, k4Var, w4Var3);
        f7158d = new h4("UINT64", 3, 3, k4Var, w4Var3);
        w4 w4Var4 = w4.f7383b;
        f7159e = new h4("INT32", 4, 4, k4Var, w4Var4);
        f7160f = new h4("FIXED64", 5, 5, k4Var, w4Var3);
        f7161g = new h4("FIXED32", 6, 6, k4Var, w4Var4);
        w4 w4Var5 = w4.f7387f;
        f7162h = new h4("BOOL", 7, 7, k4Var, w4Var5);
        w4 w4Var6 = w4.f7388g;
        f7163j = new h4("STRING", 8, 8, k4Var, w4Var6);
        w4 w4Var7 = w4.f7391k;
        f7164k = new h4("MESSAGE", 9, 9, k4Var, w4Var7);
        w4 w4Var8 = w4.f7389h;
        f7165l = new h4("BYTES", 10, 10, k4Var, w4Var8);
        m = new h4("UINT32", 11, 11, k4Var, w4Var4);
        w4 w4Var9 = w4.f7390j;
        n = new h4("ENUM", 12, 12, k4Var, w4Var9);
        p = new h4("SFIXED32", 13, 13, k4Var, w4Var4);
        q = new h4("SFIXED64", 14, 14, k4Var, w4Var3);
        t = new h4("SINT32", 15, 15, k4Var, w4Var4);
        u = new h4("SINT64", 16, 16, k4Var, w4Var3);
        v = new h4("GROUP", 17, 17, k4Var, w4Var7);
        k4 k4Var2 = k4.VECTOR;
        w = new h4("DOUBLE_LIST", 18, 18, k4Var2, w4Var);
        x = new h4("FLOAT_LIST", 19, 19, k4Var2, w4Var2);
        y = new h4("INT64_LIST", 20, 20, k4Var2, w4Var3);
        z = new h4("UINT64_LIST", 21, 21, k4Var2, w4Var3);
        A = new h4("INT32_LIST", 22, 22, k4Var2, w4Var4);
        B = new h4("FIXED64_LIST", 23, 23, k4Var2, w4Var3);
        C = new h4("FIXED32_LIST", 24, 24, k4Var2, w4Var4);
        D = new h4("BOOL_LIST", 25, 25, k4Var2, w4Var5);
        E = new h4("STRING_LIST", 26, 26, k4Var2, w4Var6);
        F = new h4("MESSAGE_LIST", 27, 27, k4Var2, w4Var7);
        G = new h4("BYTES_LIST", 28, 28, k4Var2, w4Var8);
        H = new h4("UINT32_LIST", 29, 29, k4Var2, w4Var4);
        I = new h4("ENUM_LIST", 30, 30, k4Var2, w4Var9);
        J = new h4("SFIXED32_LIST", 31, 31, k4Var2, w4Var4);
        K = new h4("SFIXED64_LIST", 32, 32, k4Var2, w4Var3);
        L = new h4("SINT32_LIST", 33, 33, k4Var2, w4Var4);
        M = new h4("SINT64_LIST", 34, 34, k4Var2, w4Var3);
        k4 k4Var3 = k4.PACKED_VECTOR;
        N = new h4("DOUBLE_LIST_PACKED", 35, 35, k4Var3, w4Var);
        O = new h4("FLOAT_LIST_PACKED", 36, 36, k4Var3, w4Var2);
        P = new h4("INT64_LIST_PACKED", 37, 37, k4Var3, w4Var3);
        Q = new h4("UINT64_LIST_PACKED", 38, 38, k4Var3, w4Var3);
        R = new h4("INT32_LIST_PACKED", 39, 39, k4Var3, w4Var4);
        S = new h4("FIXED64_LIST_PACKED", 40, 40, k4Var3, w4Var3);
        T = new h4("FIXED32_LIST_PACKED", 41, 41, k4Var3, w4Var4);
        U = new h4("BOOL_LIST_PACKED", 42, 42, k4Var3, w4Var5);
        V = new h4("UINT32_LIST_PACKED", 43, 43, k4Var3, w4Var4);
        W = new h4("ENUM_LIST_PACKED", 44, 44, k4Var3, w4Var9);
        X = new h4("SFIXED32_LIST_PACKED", 45, 45, k4Var3, w4Var4);
        w4 w4Var10 = w4.f7384c;
        Y = new h4("SFIXED64_LIST_PACKED", 46, 46, k4Var3, w4Var10);
        Z = new h4("SINT32_LIST_PACKED", 47, 47, k4Var3, w4.f7383b);
        a0 = new h4("SINT64_LIST_PACKED", 48, 48, k4Var3, w4Var10);
        b0 = new h4("GROUP_LIST", 49, 49, k4Var2, w4Var7);
        c0 = new h4("MAP", 50, 50, k4.MAP, w4.a);
        f0 = new h4[]{a, f7156b, f7157c, f7158d, f7159e, f7160f, f7161g, f7162h, f7163j, f7164k, f7165l, m, n, p, q, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0};
        e0 = new Type[0];
        h4[] values = values();
        d0 = new h4[values.length];
        for (h4 h4Var : values) {
            d0[h4Var.h0] = h4Var;
        }
    }

    private h4(String str, int i2, int i3, k4 k4Var, w4 w4Var) {
        int i4;
        this.h0 = i3;
        this.i0 = k4Var;
        this.g0 = w4Var;
        int i5 = g4.a[k4Var.ordinal()];
        boolean z2 = true;
        if (i5 == 1) {
            this.j0 = w4Var.h();
        } else if (i5 != 2) {
            this.j0 = null;
        } else {
            this.j0 = w4Var.h();
        }
        this.k0 = (k4Var != k4.SCALAR || (i4 = g4.f7140b[w4Var.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : z2;
    }

    public static h4[] values() {
        return (h4[]) f0.clone();
    }

    public final int a() {
        return this.h0;
    }
}