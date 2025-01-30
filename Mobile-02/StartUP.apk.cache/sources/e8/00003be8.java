package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes2.dex */
public abstract class d implements com.google.gson.e {
    public static final d a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f9516b;

    /* renamed from: c  reason: collision with root package name */
    public static final d f9517c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f9518d;

    /* renamed from: e  reason: collision with root package name */
    public static final d f9519e;

    /* renamed from: f  reason: collision with root package name */
    public static final d f9520f;

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ d[] f9521g;

    /* compiled from: FieldNamingPolicy.java */
    /* loaded from: classes2.dex */
    enum a extends d {
        a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // com.google.gson.e
        public String h(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        a = aVar;
        d dVar = new d("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.d.b
            @Override // com.google.gson.e
            public String h(Field field) {
                return d.s(field.getName());
            }
        };
        f9516b = dVar;
        d dVar2 = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.d.c
            @Override // com.google.gson.e
            public String h(Field field) {
                return d.s(d.q(field.getName(), " "));
            }
        };
        f9517c = dVar2;
        d dVar3 = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.d.d
            @Override // com.google.gson.e
            public String h(Field field) {
                return d.q(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        f9518d = dVar3;
        d dVar4 = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: com.google.gson.d.e
            @Override // com.google.gson.e
            public String h(Field field) {
                return d.q(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        f9519e = dVar4;
        d dVar5 = new d("LOWER_CASE_WITH_DOTS", 5) { // from class: com.google.gson.d.f
            @Override // com.google.gson.e
            public String h(Field field) {
                return d.q(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        f9520f = dVar5;
        f9521g = new d[]{aVar, dVar, dVar2, dVar3, dVar4, dVar5};
    }

    private d(String str, int i2) {
    }

    private static String n(char c2, String str, int i2) {
        if (i2 < str.length()) {
            return c2 + str.substring(i2);
        }
        return String.valueOf(c2);
    }

    static String q(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String s(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i2++;
            charAt = str.charAt(i2);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(n(Character.toUpperCase(charAt), str, i2 + 1));
        return sb.toString();
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f9521g.clone();
    }

    /* synthetic */ d(String str, int i2, a aVar) {
        this(str, i2);
    }
}