package com.google.android.gms.internal.p000firebaseperf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum b uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.w4  reason: invalid package */
/* loaded from: classes2.dex */
public final class w4 {
    public static final w4 a;

    /* renamed from: b  reason: collision with root package name */
    public static final w4 f6944b;

    /* renamed from: c  reason: collision with root package name */
    public static final w4 f6945c;

    /* renamed from: d  reason: collision with root package name */
    public static final w4 f6946d;

    /* renamed from: e  reason: collision with root package name */
    public static final w4 f6947e;

    /* renamed from: f  reason: collision with root package name */
    public static final w4 f6948f;

    /* renamed from: g  reason: collision with root package name */
    public static final w4 f6949g;

    /* renamed from: h  reason: collision with root package name */
    public static final w4 f6950h;

    /* renamed from: j  reason: collision with root package name */
    public static final w4 f6951j;

    /* renamed from: k  reason: collision with root package name */
    public static final w4 f6952k;

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ w4[] f6953l;
    private final Class<?> m;
    private final Class<?> n;
    private final Object p;

    static {
        w4 w4Var = new w4("VOID", 0, Void.class, Void.class, null);
        a = w4Var;
        Class cls = Integer.TYPE;
        w4 w4Var2 = new w4("INT", 1, cls, Integer.class, 0);
        f6944b = w4Var2;
        w4 w4Var3 = new w4("LONG", 2, Long.TYPE, Long.class, 0L);
        f6945c = w4Var3;
        w4 w4Var4 = new w4("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f6946d = w4Var4;
        w4 w4Var5 = new w4("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f6947e = w4Var5;
        w4 w4Var6 = new w4("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f6948f = w4Var6;
        w4 w4Var7 = new w4("STRING", 6, String.class, String.class, "");
        f6949g = w4Var7;
        w4 w4Var8 = new w4("BYTE_STRING", 7, i3.class, i3.class, i3.a);
        f6950h = w4Var8;
        w4 w4Var9 = new w4("ENUM", 8, cls, Integer.class, null);
        f6951j = w4Var9;
        w4 w4Var10 = new w4("MESSAGE", 9, Object.class, Object.class, null);
        f6952k = w4Var10;
        f6953l = new w4[]{w4Var, w4Var2, w4Var3, w4Var4, w4Var5, w4Var6, w4Var7, w4Var8, w4Var9, w4Var10};
    }

    private w4(String str, int i2, Class cls, Class cls2, Object obj) {
        this.m = cls;
        this.n = cls2;
        this.p = obj;
    }

    public static w4[] values() {
        return (w4[]) f6953l.clone();
    }

    public final Class<?> h() {
        return this.n;
    }
}