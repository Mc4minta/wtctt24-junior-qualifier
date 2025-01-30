package com.google.common.base;

import java.io.Serializable;

/* compiled from: Predicates.java */
/* loaded from: classes2.dex */
public final class n {
    private static final g a = g.f(',');

    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    private static class b<T> implements m<T>, Serializable {
        private final T a;

        @Override // com.google.common.base.m
        public boolean apply(T t) {
            return this.a.equals(t);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.a + ")";
        }

        private b(T t) {
            this.a = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Predicates.java */
    /* loaded from: classes2.dex */
    public static abstract class c implements m<Object> {
        public static final c a;

        /* renamed from: b  reason: collision with root package name */
        public static final c f8442b;

        /* renamed from: c  reason: collision with root package name */
        public static final c f8443c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f8444d;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ c[] f8445e;

        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        enum a extends c {
            a(String str, int i2) {
                super(str, i2);
            }

            @Override // com.google.common.base.m
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        enum b extends c {
            b(String str, int i2) {
                super(str, i2);
            }

            @Override // com.google.common.base.m
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* compiled from: Predicates.java */
        /* renamed from: com.google.common.base.n$c$c  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        enum C0156c extends c {
            C0156c(String str, int i2) {
                super(str, i2);
            }

            @Override // com.google.common.base.m
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* compiled from: Predicates.java */
        /* loaded from: classes2.dex */
        enum d extends c {
            d(String str, int i2) {
                super(str, i2);
            }

            @Override // com.google.common.base.m
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        static {
            a aVar = new a("ALWAYS_TRUE", 0);
            a = aVar;
            b bVar = new b("ALWAYS_FALSE", 1);
            f8442b = bVar;
            C0156c c0156c = new C0156c("IS_NULL", 2);
            f8443c = c0156c;
            d dVar = new d("NOT_NULL", 3);
            f8444d = dVar;
            f8445e = new c[]{aVar, bVar, c0156c, dVar};
        }

        private c(String str, int i2) {
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f8445e.clone();
        }

        <T> m<T> h() {
            return this;
        }
    }

    public static <T> m<T> a(T t) {
        return t == null ? b() : new b(t);
    }

    public static <T> m<T> b() {
        return c.f8443c.h();
    }
}