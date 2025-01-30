package com.google.protobuf;

/* compiled from: WireFormat.java */
/* loaded from: classes2.dex */
public final class y {
    static final int a = c(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f9761b = c(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f9762c = c(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f9763d = c(3, 2);

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
    /* compiled from: WireFormat.java */
    /* loaded from: classes2.dex */
    public static class b {
        public static final b a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f9764b;

        /* renamed from: c  reason: collision with root package name */
        public static final b f9765c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f9766d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f9767e;

        /* renamed from: f  reason: collision with root package name */
        public static final b f9768f;

        /* renamed from: g  reason: collision with root package name */
        public static final b f9769g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f9770h;

        /* renamed from: j  reason: collision with root package name */
        public static final b f9771j;

        /* renamed from: k  reason: collision with root package name */
        public static final b f9772k;

        /* renamed from: l  reason: collision with root package name */
        public static final b f9773l;
        public static final b m;
        public static final b n;
        public static final b p;
        public static final b q;
        public static final b t;
        public static final b u;
        public static final b v;
        private static final /* synthetic */ b[] w;
        private final c x;
        private final int y;

        /* compiled from: WireFormat.java */
        /* loaded from: classes2.dex */
        enum a extends b {
            a(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        /* compiled from: WireFormat.java */
        /* renamed from: com.google.protobuf.y$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        enum C0205b extends b {
            C0205b(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        /* compiled from: WireFormat.java */
        /* loaded from: classes2.dex */
        enum c extends b {
            c(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        /* compiled from: WireFormat.java */
        /* loaded from: classes2.dex */
        enum d extends b {
            d(String str, int i2, c cVar, int i3) {
                super(str, i2, cVar, i3);
            }
        }

        static {
            b bVar = new b("DOUBLE", 0, c.DOUBLE, 1);
            a = bVar;
            b bVar2 = new b("FLOAT", 1, c.FLOAT, 5);
            f9764b = bVar2;
            c cVar = c.LONG;
            b bVar3 = new b("INT64", 2, cVar, 0);
            f9765c = bVar3;
            b bVar4 = new b("UINT64", 3, cVar, 0);
            f9766d = bVar4;
            c cVar2 = c.INT;
            b bVar5 = new b("INT32", 4, cVar2, 0);
            f9767e = bVar5;
            b bVar6 = new b("FIXED64", 5, cVar, 1);
            f9768f = bVar6;
            b bVar7 = new b("FIXED32", 6, cVar2, 5);
            f9769g = bVar7;
            b bVar8 = new b("BOOL", 7, c.BOOLEAN, 0);
            f9770h = bVar8;
            a aVar = new a("STRING", 8, c.STRING, 2);
            f9771j = aVar;
            c cVar3 = c.MESSAGE;
            C0205b c0205b = new C0205b("GROUP", 9, cVar3, 3);
            f9772k = c0205b;
            c cVar4 = new c("MESSAGE", 10, cVar3, 2);
            f9773l = cVar4;
            d dVar = new d("BYTES", 11, c.BYTE_STRING, 2);
            m = dVar;
            b bVar9 = new b("UINT32", 12, cVar2, 0);
            n = bVar9;
            b bVar10 = new b("ENUM", 13, c.ENUM, 0);
            p = bVar10;
            b bVar11 = new b("SFIXED32", 14, cVar2, 5);
            q = bVar11;
            b bVar12 = new b("SFIXED64", 15, cVar, 1);
            t = bVar12;
            b bVar13 = new b("SINT32", 16, cVar2, 0);
            u = bVar13;
            b bVar14 = new b("SINT64", 17, cVar, 0);
            v = bVar14;
            w = new b[]{bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, aVar, c0205b, cVar4, dVar, bVar9, bVar10, bVar11, bVar12, bVar13, bVar14};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) w.clone();
        }

        public c h() {
            return this.x;
        }

        private b(String str, int i2, c cVar, int i3) {
            this.x = cVar;
            this.y = i3;
        }
    }

    /* compiled from: WireFormat.java */
    /* loaded from: classes2.dex */
    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(e.a),
        ENUM(null),
        MESSAGE(null);
        

        /* renamed from: l  reason: collision with root package name */
        private final Object f9783l;

        c(Object obj) {
            this.f9783l = obj;
        }
    }

    public static int a(int i2) {
        return i2 >>> 3;
    }

    public static int b(int i2) {
        return i2 & 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, int i3) {
        return (i2 << 3) | i3;
    }
}