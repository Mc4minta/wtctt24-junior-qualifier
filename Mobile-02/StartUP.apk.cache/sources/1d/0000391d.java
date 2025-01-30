package com.google.common.collect;

import com.google.common.base.g;
import java.util.Map;

/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public final class x {
    static final g.b a = e.a.j("=");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Maps.java */
    /* loaded from: classes2.dex */
    private static abstract class a implements com.google.common.base.f<Map.Entry<?, ?>, Object> {
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f8549b;

        /* renamed from: c  reason: collision with root package name */
        private static final /* synthetic */ a[] f8550c;

        /* compiled from: Maps.java */
        /* renamed from: com.google.common.collect.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        enum C0161a extends a {
            C0161a(String str, int i2) {
                super(str, i2, null);
            }

            @Override // com.google.common.base.f
            /* renamed from: h */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* compiled from: Maps.java */
        /* loaded from: classes2.dex */
        enum b extends a {
            b(String str, int i2) {
                super(str, i2, null);
            }

            @Override // com.google.common.base.f
            /* renamed from: h */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        static {
            C0161a c0161a = new C0161a("KEY", 0);
            a = c0161a;
            b bVar = new b("VALUE", 1);
            f8549b = bVar;
            f8550c = new a[]{c0161a, bVar};
        }

        private a(String str, int i2) {
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f8550c.clone();
        }

        /* synthetic */ a(String str, int i2, w wVar) {
            this(str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> b(K k2, V v) {
        return new k(k2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Map<?, ?> map) {
        StringBuilder a2 = e.a(map.size());
        a2.append('{');
        a.d(a2, map);
        a2.append('}');
        return a2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> com.google.common.base.f<Map.Entry<?, V>, V> d() {
        return a.f8549b;
    }
}