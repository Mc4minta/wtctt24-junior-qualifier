package com.google.android.gms.internal.clearcut;

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
/* loaded from: classes2.dex */
public final class k1 {
    public static final k1 a;

    /* renamed from: b  reason: collision with root package name */
    public static final k1 f6475b;

    /* renamed from: c  reason: collision with root package name */
    public static final k1 f6476c;

    /* renamed from: d  reason: collision with root package name */
    public static final k1 f6477d;

    /* renamed from: e  reason: collision with root package name */
    public static final k1 f6478e;

    /* renamed from: f  reason: collision with root package name */
    public static final k1 f6479f;

    /* renamed from: g  reason: collision with root package name */
    public static final k1 f6480g;

    /* renamed from: h  reason: collision with root package name */
    public static final k1 f6481h;

    /* renamed from: j  reason: collision with root package name */
    public static final k1 f6482j;

    /* renamed from: k  reason: collision with root package name */
    public static final k1 f6483k;

    /* renamed from: l  reason: collision with root package name */
    private static final /* synthetic */ k1[] f6484l;
    private final Class<?> m;
    private final Class<?> n;
    private final Object p;

    static {
        k1 k1Var = new k1("VOID", 0, Void.class, Void.class, null);
        a = k1Var;
        Class cls = Integer.TYPE;
        k1 k1Var2 = new k1("INT", 1, cls, Integer.class, 0);
        f6475b = k1Var2;
        k1 k1Var3 = new k1("LONG", 2, Long.TYPE, Long.class, 0L);
        f6476c = k1Var3;
        k1 k1Var4 = new k1("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f6477d = k1Var4;
        k1 k1Var5 = new k1("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f6478e = k1Var5;
        k1 k1Var6 = new k1("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f6479f = k1Var6;
        k1 k1Var7 = new k1("STRING", 6, String.class, String.class, "");
        f6480g = k1Var7;
        k1 k1Var8 = new k1("BYTE_STRING", 7, a0.class, a0.class, a0.a);
        f6481h = k1Var8;
        k1 k1Var9 = new k1("ENUM", 8, cls, Integer.class, null);
        f6482j = k1Var9;
        k1 k1Var10 = new k1("MESSAGE", 9, Object.class, Object.class, null);
        f6483k = k1Var10;
        f6484l = new k1[]{k1Var, k1Var2, k1Var3, k1Var4, k1Var5, k1Var6, k1Var7, k1Var8, k1Var9, k1Var10};
    }

    private k1(String str, int i2, Class cls, Class cls2, Object obj) {
        this.m = cls;
        this.n = cls2;
        this.p = obj;
    }

    public static k1[] values() {
        return (k1[]) f6484l.clone();
    }

    public final Class<?> h() {
        return this.n;
    }
}