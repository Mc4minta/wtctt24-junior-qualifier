package com.google.zxing.v.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DataMask.java */
/* loaded from: classes2.dex */
abstract class c {
    public static final c a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f10119b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f10120c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f10121d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f10122e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f10123f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f10124g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f10125h;

    /* renamed from: j  reason: collision with root package name */
    private static final /* synthetic */ c[] f10126j;

    /* compiled from: DataMask.java */
    /* loaded from: classes2.dex */
    enum a extends c {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.zxing.v.c.c
        boolean h(int i2, int i3) {
            return ((i2 + i3) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        a = aVar;
        c cVar = new c("DATA_MASK_001", 1) { // from class: com.google.zxing.v.c.c.b
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return (i2 & 1) == 0;
            }
        };
        f10119b = cVar;
        c cVar2 = new c("DATA_MASK_010", 2) { // from class: com.google.zxing.v.c.c.c
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return i3 % 3 == 0;
            }
        };
        f10120c = cVar2;
        c cVar3 = new c("DATA_MASK_011", 3) { // from class: com.google.zxing.v.c.c.d
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return (i2 + i3) % 3 == 0;
            }
        };
        f10121d = cVar3;
        c cVar4 = new c("DATA_MASK_100", 4) { // from class: com.google.zxing.v.c.c.e
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return (((i2 / 2) + (i3 / 3)) & 1) == 0;
            }
        };
        f10122e = cVar4;
        c cVar5 = new c("DATA_MASK_101", 5) { // from class: com.google.zxing.v.c.c.f
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return (i2 * i3) % 6 == 0;
            }
        };
        f10123f = cVar5;
        c cVar6 = new c("DATA_MASK_110", 6) { // from class: com.google.zxing.v.c.c.g
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return (i2 * i3) % 6 < 3;
            }
        };
        f10124g = cVar6;
        c cVar7 = new c("DATA_MASK_111", 7) { // from class: com.google.zxing.v.c.c.h
            @Override // com.google.zxing.v.c.c
            boolean h(int i2, int i3) {
                return (((i2 + i3) + ((i2 * i3) % 3)) & 1) == 0;
            }
        };
        f10125h = cVar7;
        f10126j = new c[]{aVar, cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7};
    }

    private c(String str, int i2) {
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f10126j.clone();
    }

    abstract boolean h(int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(com.google.zxing.q.b bVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (h(i3, i4)) {
                    bVar.d(i4, i3);
                }
            }
        }
    }

    /* synthetic */ c(String str, int i2, a aVar) {
        this(str, i2);
    }
}