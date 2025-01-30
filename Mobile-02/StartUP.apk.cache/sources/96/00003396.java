package com.google.android.gms.internal.p000firebaseperf;

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
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.j4  reason: invalid package */
/* loaded from: classes2.dex */
public final class j4 {
    private static final j4 A;
    private static final j4 B;
    private static final j4 C;
    private static final j4 D;
    private static final j4 E;
    private static final j4 F;
    private static final j4 G;
    private static final j4 H;
    private static final j4 I;
    private static final j4 J;
    private static final j4 K;
    private static final j4 L;
    private static final j4 M;
    public static final j4 N;
    private static final j4 O;
    private static final j4 P;
    private static final j4 Q;
    private static final j4 R;
    private static final j4 S;
    private static final j4 T;
    private static final j4 U;
    private static final j4 V;
    private static final j4 W;
    private static final j4 X;
    private static final j4 Y;
    private static final j4 Z;
    private static final j4 a;
    public static final j4 a0;

    /* renamed from: b  reason: collision with root package name */
    private static final j4 f6767b;
    private static final j4 b0;

    /* renamed from: c  reason: collision with root package name */
    private static final j4 f6768c;
    private static final j4 c0;

    /* renamed from: d  reason: collision with root package name */
    private static final j4 f6769d;
    private static final j4[] d0;

    /* renamed from: e  reason: collision with root package name */
    private static final j4 f6770e;
    private static final Type[] e0;

    /* renamed from: f  reason: collision with root package name */
    private static final j4 f6771f;
    private static final /* synthetic */ j4[] f0;

    /* renamed from: g  reason: collision with root package name */
    private static final j4 f6772g;

    /* renamed from: h  reason: collision with root package name */
    private static final j4 f6773h;

    /* renamed from: j  reason: collision with root package name */
    private static final j4 f6774j;

    /* renamed from: k  reason: collision with root package name */
    private static final j4 f6775k;

    /* renamed from: l  reason: collision with root package name */
    private static final j4 f6776l;
    private static final j4 m;
    private static final j4 n;
    private static final j4 p;
    private static final j4 q;
    private static final j4 t;
    private static final j4 u;
    private static final j4 v;
    private static final j4 w;
    private static final j4 x;
    private static final j4 y;
    private static final j4 z;
    private final w4 g0;
    private final int h0;
    private final l4 i0;
    private final Class<?> j0;
    private final boolean k0;

    static {
        l4 l4Var = l4.SCALAR;
        w4 w4Var = w4.f6947e;
        a = new j4("DOUBLE", 0, 0, l4Var, w4Var);
        w4 w4Var2 = w4.f6946d;
        f6767b = new j4("FLOAT", 1, 1, l4Var, w4Var2);
        w4 w4Var3 = w4.f6945c;
        f6768c = new j4("INT64", 2, 2, l4Var, w4Var3);
        f6769d = new j4("UINT64", 3, 3, l4Var, w4Var3);
        w4 w4Var4 = w4.f6944b;
        f6770e = new j4("INT32", 4, 4, l4Var, w4Var4);
        f6771f = new j4("FIXED64", 5, 5, l4Var, w4Var3);
        f6772g = new j4("FIXED32", 6, 6, l4Var, w4Var4);
        w4 w4Var5 = w4.f6948f;
        f6773h = new j4("BOOL", 7, 7, l4Var, w4Var5);
        w4 w4Var6 = w4.f6949g;
        f6774j = new j4("STRING", 8, 8, l4Var, w4Var6);
        w4 w4Var7 = w4.f6952k;
        f6775k = new j4("MESSAGE", 9, 9, l4Var, w4Var7);
        w4 w4Var8 = w4.f6950h;
        f6776l = new j4("BYTES", 10, 10, l4Var, w4Var8);
        m = new j4("UINT32", 11, 11, l4Var, w4Var4);
        w4 w4Var9 = w4.f6951j;
        n = new j4("ENUM", 12, 12, l4Var, w4Var9);
        p = new j4("SFIXED32", 13, 13, l4Var, w4Var4);
        q = new j4("SFIXED64", 14, 14, l4Var, w4Var3);
        t = new j4("SINT32", 15, 15, l4Var, w4Var4);
        u = new j4("SINT64", 16, 16, l4Var, w4Var3);
        v = new j4("GROUP", 17, 17, l4Var, w4Var7);
        l4 l4Var2 = l4.VECTOR;
        w = new j4("DOUBLE_LIST", 18, 18, l4Var2, w4Var);
        x = new j4("FLOAT_LIST", 19, 19, l4Var2, w4Var2);
        y = new j4("INT64_LIST", 20, 20, l4Var2, w4Var3);
        z = new j4("UINT64_LIST", 21, 21, l4Var2, w4Var3);
        A = new j4("INT32_LIST", 22, 22, l4Var2, w4Var4);
        B = new j4("FIXED64_LIST", 23, 23, l4Var2, w4Var3);
        C = new j4("FIXED32_LIST", 24, 24, l4Var2, w4Var4);
        D = new j4("BOOL_LIST", 25, 25, l4Var2, w4Var5);
        E = new j4("STRING_LIST", 26, 26, l4Var2, w4Var6);
        F = new j4("MESSAGE_LIST", 27, 27, l4Var2, w4Var7);
        G = new j4("BYTES_LIST", 28, 28, l4Var2, w4Var8);
        H = new j4("UINT32_LIST", 29, 29, l4Var2, w4Var4);
        I = new j4("ENUM_LIST", 30, 30, l4Var2, w4Var9);
        J = new j4("SFIXED32_LIST", 31, 31, l4Var2, w4Var4);
        K = new j4("SFIXED64_LIST", 32, 32, l4Var2, w4Var3);
        L = new j4("SINT32_LIST", 33, 33, l4Var2, w4Var4);
        M = new j4("SINT64_LIST", 34, 34, l4Var2, w4Var3);
        l4 l4Var3 = l4.PACKED_VECTOR;
        N = new j4("DOUBLE_LIST_PACKED", 35, 35, l4Var3, w4Var);
        O = new j4("FLOAT_LIST_PACKED", 36, 36, l4Var3, w4Var2);
        P = new j4("INT64_LIST_PACKED", 37, 37, l4Var3, w4Var3);
        Q = new j4("UINT64_LIST_PACKED", 38, 38, l4Var3, w4Var3);
        R = new j4("INT32_LIST_PACKED", 39, 39, l4Var3, w4Var4);
        S = new j4("FIXED64_LIST_PACKED", 40, 40, l4Var3, w4Var3);
        T = new j4("FIXED32_LIST_PACKED", 41, 41, l4Var3, w4Var4);
        U = new j4("BOOL_LIST_PACKED", 42, 42, l4Var3, w4Var5);
        V = new j4("UINT32_LIST_PACKED", 43, 43, l4Var3, w4Var4);
        W = new j4("ENUM_LIST_PACKED", 44, 44, l4Var3, w4Var9);
        X = new j4("SFIXED32_LIST_PACKED", 45, 45, l4Var3, w4Var4);
        w4 w4Var10 = w4.f6945c;
        Y = new j4("SFIXED64_LIST_PACKED", 46, 46, l4Var3, w4Var10);
        Z = new j4("SINT32_LIST_PACKED", 47, 47, l4Var3, w4.f6944b);
        a0 = new j4("SINT64_LIST_PACKED", 48, 48, l4Var3, w4Var10);
        b0 = new j4("GROUP_LIST", 49, 49, l4Var2, w4Var7);
        c0 = new j4("MAP", 50, 50, l4.MAP, w4.a);
        f0 = new j4[]{a, f6767b, f6768c, f6769d, f6770e, f6771f, f6772g, f6773h, f6774j, f6775k, f6776l, m, n, p, q, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0};
        e0 = new Type[0];
        j4[] values = values();
        d0 = new j4[values.length];
        for (j4 j4Var : values) {
            d0[j4Var.h0] = j4Var;
        }
    }

    private j4(String str, int i2, int i3, l4 l4Var, w4 w4Var) {
        int i4;
        this.h0 = i3;
        this.i0 = l4Var;
        this.g0 = w4Var;
        int i5 = i4.a[l4Var.ordinal()];
        boolean z2 = true;
        if (i5 == 1) {
            this.j0 = w4Var.h();
        } else if (i5 != 2) {
            this.j0 = null;
        } else {
            this.j0 = w4Var.h();
        }
        this.k0 = (l4Var != l4.SCALAR || (i4 = i4.f6755b[w4Var.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : z2;
    }

    public static j4[] values() {
        return (j4[]) f0.clone();
    }

    public final int h() {
        return this.h0;
    }
}