package com.google.android.gms.internal.clearcut;

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
/* loaded from: classes2.dex */
public class f4 {
    public static final f4 a;

    /* renamed from: b  reason: collision with root package name */
    public static final f4 f6432b;

    /* renamed from: c  reason: collision with root package name */
    public static final f4 f6433c;

    /* renamed from: d  reason: collision with root package name */
    public static final f4 f6434d;

    /* renamed from: e  reason: collision with root package name */
    public static final f4 f6435e;

    /* renamed from: f  reason: collision with root package name */
    public static final f4 f6436f;

    /* renamed from: g  reason: collision with root package name */
    public static final f4 f6437g;

    /* renamed from: h  reason: collision with root package name */
    public static final f4 f6438h;

    /* renamed from: j  reason: collision with root package name */
    public static final f4 f6439j;

    /* renamed from: k  reason: collision with root package name */
    public static final f4 f6440k;

    /* renamed from: l  reason: collision with root package name */
    public static final f4 f6441l;
    public static final f4 m;
    public static final f4 n;
    public static final f4 p;
    public static final f4 q;
    public static final f4 t;
    public static final f4 u;
    public static final f4 v;
    private static final /* synthetic */ f4[] w;
    private final k4 x;
    private final int y;

    static {
        f4 f4Var = new f4("DOUBLE", 0, k4.DOUBLE, 1);
        a = f4Var;
        f4 f4Var2 = new f4("FLOAT", 1, k4.FLOAT, 5);
        f6432b = f4Var2;
        k4 k4Var = k4.LONG;
        f4 f4Var3 = new f4("INT64", 2, k4Var, 0);
        f6433c = f4Var3;
        f4 f4Var4 = new f4("UINT64", 3, k4Var, 0);
        f6434d = f4Var4;
        k4 k4Var2 = k4.INT;
        f4 f4Var5 = new f4("INT32", 4, k4Var2, 0);
        f6435e = f4Var5;
        f4 f4Var6 = new f4("FIXED64", 5, k4Var, 1);
        f6436f = f4Var6;
        f4 f4Var7 = new f4("FIXED32", 6, k4Var2, 5);
        f6437g = f4Var7;
        f4 f4Var8 = new f4("BOOL", 7, k4.BOOLEAN, 0);
        f6438h = f4Var8;
        f4 f4Var9 = new f4("STRING", 8, k4.STRING, 2) { // from class: com.google.android.gms.internal.clearcut.g4
        };
        f6439j = f4Var9;
        k4 k4Var3 = k4.MESSAGE;
        f4 f4Var10 = new f4("GROUP", 9, k4Var3, 3) { // from class: com.google.android.gms.internal.clearcut.h4
        };
        f6440k = f4Var10;
        f4 f4Var11 = new f4("MESSAGE", 10, k4Var3, 2) { // from class: com.google.android.gms.internal.clearcut.i4
        };
        f6441l = f4Var11;
        f4 f4Var12 = new f4("BYTES", 11, k4.BYTE_STRING, 2) { // from class: com.google.android.gms.internal.clearcut.j4
        };
        m = f4Var12;
        f4 f4Var13 = new f4("UINT32", 12, k4Var2, 0);
        n = f4Var13;
        f4 f4Var14 = new f4("ENUM", 13, k4.ENUM, 0);
        p = f4Var14;
        f4 f4Var15 = new f4("SFIXED32", 14, k4Var2, 5);
        q = f4Var15;
        f4 f4Var16 = new f4("SFIXED64", 15, k4Var, 1);
        t = f4Var16;
        f4 f4Var17 = new f4("SINT32", 16, k4Var2, 0);
        u = f4Var17;
        f4 f4Var18 = new f4("SINT64", 17, k4Var, 0);
        v = f4Var18;
        w = new f4[]{f4Var, f4Var2, f4Var3, f4Var4, f4Var5, f4Var6, f4Var7, f4Var8, f4Var9, f4Var10, f4Var11, f4Var12, f4Var13, f4Var14, f4Var15, f4Var16, f4Var17, f4Var18};
    }

    private f4(String str, int i2, k4 k4Var, int i3) {
        this.x = k4Var;
        this.y = i3;
    }

    public static f4[] values() {
        return (f4[]) w.clone();
    }

    public final k4 h() {
        return this.x;
    }
}