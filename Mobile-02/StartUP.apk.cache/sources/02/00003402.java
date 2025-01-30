package com.google.android.gms.internal.p000firebaseperf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum c uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.s7  reason: invalid package */
/* loaded from: classes2.dex */
public class s7 {
    public static final s7 a;

    /* renamed from: b  reason: collision with root package name */
    public static final s7 f6907b;

    /* renamed from: c  reason: collision with root package name */
    public static final s7 f6908c;

    /* renamed from: d  reason: collision with root package name */
    public static final s7 f6909d;

    /* renamed from: e  reason: collision with root package name */
    public static final s7 f6910e;

    /* renamed from: f  reason: collision with root package name */
    public static final s7 f6911f;

    /* renamed from: g  reason: collision with root package name */
    public static final s7 f6912g;

    /* renamed from: h  reason: collision with root package name */
    public static final s7 f6913h;

    /* renamed from: j  reason: collision with root package name */
    public static final s7 f6914j;

    /* renamed from: k  reason: collision with root package name */
    public static final s7 f6915k;

    /* renamed from: l  reason: collision with root package name */
    public static final s7 f6916l;
    public static final s7 m;
    public static final s7 n;
    public static final s7 p;
    public static final s7 q;
    public static final s7 t;
    public static final s7 u;
    public static final s7 v;
    private static final /* synthetic */ s7[] w;
    private final v7 x;
    private final int y;

    static {
        s7 s7Var = new s7("DOUBLE", 0, v7.DOUBLE, 1);
        a = s7Var;
        s7 s7Var2 = new s7("FLOAT", 1, v7.FLOAT, 5);
        f6907b = s7Var2;
        v7 v7Var = v7.LONG;
        s7 s7Var3 = new s7("INT64", 2, v7Var, 0);
        f6908c = s7Var3;
        s7 s7Var4 = new s7("UINT64", 3, v7Var, 0);
        f6909d = s7Var4;
        v7 v7Var2 = v7.INT;
        s7 s7Var5 = new s7("INT32", 4, v7Var2, 0);
        f6910e = s7Var5;
        s7 s7Var6 = new s7("FIXED64", 5, v7Var, 1);
        f6911f = s7Var6;
        s7 s7Var7 = new s7("FIXED32", 6, v7Var2, 5);
        f6912g = s7Var7;
        s7 s7Var8 = new s7("BOOL", 7, v7.BOOLEAN, 0);
        f6913h = s7Var8;
        final v7 v7Var3 = v7.STRING;
        s7 s7Var9 = new s7("STRING", 8, v7Var3, 2) { // from class: com.google.android.gms.internal.firebase-perf.r7
        };
        f6914j = s7Var9;
        final v7 v7Var4 = v7.MESSAGE;
        s7 s7Var10 = new s7("GROUP", 9, v7Var4, 3) { // from class: com.google.android.gms.internal.firebase-perf.u7
        };
        f6915k = s7Var10;
        s7 s7Var11 = new s7("MESSAGE", 10, v7Var4, 2) { // from class: com.google.android.gms.internal.firebase-perf.t7
        };
        f6916l = s7Var11;
        final v7 v7Var5 = v7.BYTE_STRING;
        s7 s7Var12 = new s7("BYTES", 11, v7Var5, 2) { // from class: com.google.android.gms.internal.firebase-perf.w7
        };
        m = s7Var12;
        s7 s7Var13 = new s7("UINT32", 12, v7Var2, 0);
        n = s7Var13;
        s7 s7Var14 = new s7("ENUM", 13, v7.ENUM, 0);
        p = s7Var14;
        s7 s7Var15 = new s7("SFIXED32", 14, v7Var2, 5);
        q = s7Var15;
        s7 s7Var16 = new s7("SFIXED64", 15, v7Var, 1);
        t = s7Var16;
        s7 s7Var17 = new s7("SINT32", 16, v7Var2, 0);
        u = s7Var17;
        s7 s7Var18 = new s7("SINT64", 17, v7Var, 0);
        v = s7Var18;
        w = new s7[]{s7Var, s7Var2, s7Var3, s7Var4, s7Var5, s7Var6, s7Var7, s7Var8, s7Var9, s7Var10, s7Var11, s7Var12, s7Var13, s7Var14, s7Var15, s7Var16, s7Var17, s7Var18};
    }

    private s7(String str, int i2, v7 v7Var, int i3) {
        this.x = v7Var;
        this.y = i3;
    }

    public static s7[] values() {
        return (s7[]) w.clone();
    }

    public final v7 h() {
        return this.x;
    }

    public final int n() {
        return this.y;
    }
}