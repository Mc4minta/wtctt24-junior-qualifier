package com.google.android.gms.internal.clearcut;

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
/* loaded from: classes2.dex */
public final class z0 {
    private static final z0 A;
    private static final z0 B;
    private static final z0 C;
    private static final z0 D;
    private static final z0 E;
    public static final z0 F;
    private static final z0 G;
    private static final z0 H;
    public static final z0 I;
    private static final z0 J;
    private static final z0 K;
    private static final z0 L;
    private static final z0 M;
    public static final z0 N;
    private static final z0 O;
    private static final z0 P;
    private static final z0 Q;
    private static final z0 R;
    private static final z0 S;
    private static final z0 T;
    private static final z0 U;
    private static final z0 V;
    public static final z0 W;
    private static final z0 X;
    private static final z0 Y;
    private static final z0 Z;
    private static final z0 a;
    public static final z0 a0;

    /* renamed from: b  reason: collision with root package name */
    private static final z0 f6662b;
    public static final z0 b0;

    /* renamed from: c  reason: collision with root package name */
    private static final z0 f6663c;
    public static final z0 c0;

    /* renamed from: d  reason: collision with root package name */
    private static final z0 f6664d;
    private static final z0[] d0;

    /* renamed from: e  reason: collision with root package name */
    private static final z0 f6665e;
    private static final Type[] e0;

    /* renamed from: f  reason: collision with root package name */
    private static final z0 f6666f;
    private static final /* synthetic */ z0[] f0;

    /* renamed from: g  reason: collision with root package name */
    private static final z0 f6667g;

    /* renamed from: h  reason: collision with root package name */
    private static final z0 f6668h;

    /* renamed from: j  reason: collision with root package name */
    private static final z0 f6669j;

    /* renamed from: k  reason: collision with root package name */
    public static final z0 f6670k;

    /* renamed from: l  reason: collision with root package name */
    private static final z0 f6671l;
    private static final z0 m;
    public static final z0 n;
    private static final z0 p;
    private static final z0 q;
    private static final z0 t;
    private static final z0 u;
    public static final z0 v;
    public static final z0 w;
    private static final z0 x;
    private static final z0 y;
    private static final z0 z;
    private final k1 g0;
    private final int h0;
    private final b1 i0;
    private final Class<?> j0;
    private final boolean k0;

    static {
        b1 b1Var = b1.SCALAR;
        k1 k1Var = k1.f6478e;
        a = new z0("DOUBLE", 0, 0, b1Var, k1Var);
        k1 k1Var2 = k1.f6477d;
        f6662b = new z0("FLOAT", 1, 1, b1Var, k1Var2);
        k1 k1Var3 = k1.f6476c;
        f6663c = new z0("INT64", 2, 2, b1Var, k1Var3);
        f6664d = new z0("UINT64", 3, 3, b1Var, k1Var3);
        k1 k1Var4 = k1.f6475b;
        f6665e = new z0("INT32", 4, 4, b1Var, k1Var4);
        f6666f = new z0("FIXED64", 5, 5, b1Var, k1Var3);
        f6667g = new z0("FIXED32", 6, 6, b1Var, k1Var4);
        k1 k1Var5 = k1.f6479f;
        f6668h = new z0("BOOL", 7, 7, b1Var, k1Var5);
        k1 k1Var6 = k1.f6480g;
        f6669j = new z0("STRING", 8, 8, b1Var, k1Var6);
        k1 k1Var7 = k1.f6483k;
        f6670k = new z0("MESSAGE", 9, 9, b1Var, k1Var7);
        k1 k1Var8 = k1.f6481h;
        f6671l = new z0("BYTES", 10, 10, b1Var, k1Var8);
        m = new z0("UINT32", 11, 11, b1Var, k1Var4);
        k1 k1Var9 = k1.f6482j;
        n = new z0("ENUM", 12, 12, b1Var, k1Var9);
        p = new z0("SFIXED32", 13, 13, b1Var, k1Var4);
        q = new z0("SFIXED64", 14, 14, b1Var, k1Var3);
        t = new z0("SINT32", 15, 15, b1Var, k1Var4);
        u = new z0("SINT64", 16, 16, b1Var, k1Var3);
        v = new z0("GROUP", 17, 17, b1Var, k1Var7);
        b1 b1Var2 = b1.VECTOR;
        w = new z0("DOUBLE_LIST", 18, 18, b1Var2, k1Var);
        x = new z0("FLOAT_LIST", 19, 19, b1Var2, k1Var2);
        y = new z0("INT64_LIST", 20, 20, b1Var2, k1Var3);
        z = new z0("UINT64_LIST", 21, 21, b1Var2, k1Var3);
        A = new z0("INT32_LIST", 22, 22, b1Var2, k1Var4);
        B = new z0("FIXED64_LIST", 23, 23, b1Var2, k1Var3);
        C = new z0("FIXED32_LIST", 24, 24, b1Var2, k1Var4);
        D = new z0("BOOL_LIST", 25, 25, b1Var2, k1Var5);
        E = new z0("STRING_LIST", 26, 26, b1Var2, k1Var6);
        F = new z0("MESSAGE_LIST", 27, 27, b1Var2, k1Var7);
        G = new z0("BYTES_LIST", 28, 28, b1Var2, k1Var8);
        H = new z0("UINT32_LIST", 29, 29, b1Var2, k1Var4);
        I = new z0("ENUM_LIST", 30, 30, b1Var2, k1Var9);
        J = new z0("SFIXED32_LIST", 31, 31, b1Var2, k1Var4);
        K = new z0("SFIXED64_LIST", 32, 32, b1Var2, k1Var3);
        L = new z0("SINT32_LIST", 33, 33, b1Var2, k1Var4);
        M = new z0("SINT64_LIST", 34, 34, b1Var2, k1Var3);
        b1 b1Var3 = b1.PACKED_VECTOR;
        N = new z0("DOUBLE_LIST_PACKED", 35, 35, b1Var3, k1Var);
        O = new z0("FLOAT_LIST_PACKED", 36, 36, b1Var3, k1Var2);
        P = new z0("INT64_LIST_PACKED", 37, 37, b1Var3, k1Var3);
        Q = new z0("UINT64_LIST_PACKED", 38, 38, b1Var3, k1Var3);
        R = new z0("INT32_LIST_PACKED", 39, 39, b1Var3, k1Var4);
        S = new z0("FIXED64_LIST_PACKED", 40, 40, b1Var3, k1Var3);
        T = new z0("FIXED32_LIST_PACKED", 41, 41, b1Var3, k1Var4);
        U = new z0("BOOL_LIST_PACKED", 42, 42, b1Var3, k1Var5);
        V = new z0("UINT32_LIST_PACKED", 43, 43, b1Var3, k1Var4);
        W = new z0("ENUM_LIST_PACKED", 44, 44, b1Var3, k1Var9);
        X = new z0("SFIXED32_LIST_PACKED", 45, 45, b1Var3, k1Var4);
        k1 k1Var10 = k1.f6476c;
        Y = new z0("SFIXED64_LIST_PACKED", 46, 46, b1Var3, k1Var10);
        Z = new z0("SINT32_LIST_PACKED", 47, 47, b1Var3, k1.f6475b);
        a0 = new z0("SINT64_LIST_PACKED", 48, 48, b1Var3, k1Var10);
        b0 = new z0("GROUP_LIST", 49, 49, b1Var2, k1Var7);
        c0 = new z0("MAP", 50, 50, b1.MAP, k1.a);
        f0 = new z0[]{a, f6662b, f6663c, f6664d, f6665e, f6666f, f6667g, f6668h, f6669j, f6670k, f6671l, m, n, p, q, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0};
        e0 = new Type[0];
        z0[] values = values();
        d0 = new z0[values.length];
        for (z0 z0Var : values) {
            d0[z0Var.h0] = z0Var;
        }
    }

    private z0(String str, int i2, int i3, b1 b1Var, k1 k1Var) {
        int i4;
        this.h0 = i3;
        this.i0 = b1Var;
        this.g0 = k1Var;
        int i5 = a1.a[b1Var.ordinal()];
        boolean z2 = true;
        this.j0 = (i5 == 1 || i5 == 2) ? k1Var.h() : null;
        this.k0 = (b1Var != b1.SCALAR || (i4 = a1.f6366b[k1Var.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : z2;
    }

    public static z0[] values() {
        return (z0[]) f0.clone();
    }

    public final int h() {
        return this.h0;
    }
}