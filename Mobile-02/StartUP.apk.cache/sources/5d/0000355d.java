package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public class q7 {
    public static final q7 a;

    /* renamed from: b  reason: collision with root package name */
    public static final q7 f7318b;

    /* renamed from: c  reason: collision with root package name */
    public static final q7 f7319c;

    /* renamed from: d  reason: collision with root package name */
    public static final q7 f7320d;

    /* renamed from: e  reason: collision with root package name */
    public static final q7 f7321e;

    /* renamed from: f  reason: collision with root package name */
    public static final q7 f7322f;

    /* renamed from: g  reason: collision with root package name */
    public static final q7 f7323g;

    /* renamed from: h  reason: collision with root package name */
    public static final q7 f7324h;

    /* renamed from: j  reason: collision with root package name */
    public static final q7 f7325j;

    /* renamed from: k  reason: collision with root package name */
    public static final q7 f7326k;

    /* renamed from: l  reason: collision with root package name */
    public static final q7 f7327l;
    public static final q7 m;
    public static final q7 n;
    public static final q7 p;
    public static final q7 q;
    public static final q7 t;
    public static final q7 u;
    public static final q7 v;
    private static final /* synthetic */ q7[] w;
    private final x7 x;
    private final int y;

    static {
        q7 q7Var = new q7("DOUBLE", 0, x7.DOUBLE, 1);
        a = q7Var;
        q7 q7Var2 = new q7("FLOAT", 1, x7.FLOAT, 5);
        f7318b = q7Var2;
        x7 x7Var = x7.LONG;
        q7 q7Var3 = new q7("INT64", 2, x7Var, 0);
        f7319c = q7Var3;
        q7 q7Var4 = new q7("UINT64", 3, x7Var, 0);
        f7320d = q7Var4;
        x7 x7Var2 = x7.INT;
        q7 q7Var5 = new q7("INT32", 4, x7Var2, 0);
        f7321e = q7Var5;
        q7 q7Var6 = new q7("FIXED64", 5, x7Var, 1);
        f7322f = q7Var6;
        q7 q7Var7 = new q7("FIXED32", 6, x7Var2, 5);
        f7323g = q7Var7;
        q7 q7Var8 = new q7("BOOL", 7, x7.BOOLEAN, 0);
        f7324h = q7Var8;
        final x7 x7Var3 = x7.STRING;
        q7 q7Var9 = new q7("STRING", 8, x7Var3, 2) { // from class: com.google.android.gms.internal.measurement.t7
        };
        f7325j = q7Var9;
        final x7 x7Var4 = x7.MESSAGE;
        q7 q7Var10 = new q7("GROUP", 9, x7Var4, 3) { // from class: com.google.android.gms.internal.measurement.s7
        };
        f7326k = q7Var10;
        q7 q7Var11 = new q7("MESSAGE", 10, x7Var4, 2) { // from class: com.google.android.gms.internal.measurement.v7
        };
        f7327l = q7Var11;
        final x7 x7Var5 = x7.BYTE_STRING;
        q7 q7Var12 = new q7("BYTES", 11, x7Var5, 2) { // from class: com.google.android.gms.internal.measurement.u7
        };
        m = q7Var12;
        q7 q7Var13 = new q7("UINT32", 12, x7Var2, 0);
        n = q7Var13;
        q7 q7Var14 = new q7("ENUM", 13, x7.ENUM, 0);
        p = q7Var14;
        q7 q7Var15 = new q7("SFIXED32", 14, x7Var2, 5);
        q = q7Var15;
        q7 q7Var16 = new q7("SFIXED64", 15, x7Var, 1);
        t = q7Var16;
        q7 q7Var17 = new q7("SINT32", 16, x7Var2, 0);
        u = q7Var17;
        q7 q7Var18 = new q7("SINT64", 17, x7Var, 0);
        v = q7Var18;
        w = new q7[]{q7Var, q7Var2, q7Var3, q7Var4, q7Var5, q7Var6, q7Var7, q7Var8, q7Var9, q7Var10, q7Var11, q7Var12, q7Var13, q7Var14, q7Var15, q7Var16, q7Var17, q7Var18};
    }

    private q7(String str, int i2, x7 x7Var, int i3) {
        this.x = x7Var;
        this.y = i3;
    }

    public static q7[] values() {
        return (q7[]) w.clone();
    }

    public final x7 h() {
        return this.x;
    }
}