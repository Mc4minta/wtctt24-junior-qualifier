package com.google.gson;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* loaded from: classes2.dex */
public abstract class r {
    public static final r a;

    /* renamed from: b  reason: collision with root package name */
    public static final r f9545b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ r[] f9546c;

    /* compiled from: LongSerializationPolicy.java */
    /* loaded from: classes2.dex */
    enum a extends r {
        a(String str, int i2) {
            super(str, i2, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        a = aVar;
        r rVar = new r("STRING", 1) { // from class: com.google.gson.r.b
        };
        f9545b = rVar;
        f9546c = new r[]{aVar, rVar};
    }

    private r(String str, int i2) {
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f9546c.clone();
    }

    /* synthetic */ r(String str, int i2, a aVar) {
        this(str, i2);
    }
}