package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import okhttp3.HttpUrl;

/* compiled from: NavType.java */
/* loaded from: classes.dex */
public abstract class q<T> {
    public static final q<Integer> a = new c(false);

    /* renamed from: b  reason: collision with root package name */
    public static final q<Integer> f1930b = new d(false);

    /* renamed from: c  reason: collision with root package name */
    public static final q<int[]> f1931c = new e(true);

    /* renamed from: d  reason: collision with root package name */
    public static final q<Long> f1932d = new f(false);

    /* renamed from: e  reason: collision with root package name */
    public static final q<long[]> f1933e = new g(true);

    /* renamed from: f  reason: collision with root package name */
    public static final q<Float> f1934f = new h(false);

    /* renamed from: g  reason: collision with root package name */
    public static final q<float[]> f1935g = new i(true);

    /* renamed from: h  reason: collision with root package name */
    public static final q<Boolean> f1936h = new j(false);

    /* renamed from: i  reason: collision with root package name */
    public static final q<boolean[]> f1937i = new k(true);

    /* renamed from: j  reason: collision with root package name */
    public static final q<String> f1938j = new a(true);

    /* renamed from: k  reason: collision with root package name */
    public static final q<String[]> f1939k = new b(true);

    /* renamed from: l  reason: collision with root package name */
    private final boolean f1940l;

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class a extends q<String> {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "string";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public String b(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public String h(String str) {
            return str;
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class b extends q<String[]> {
        b(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "string[]";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public String[] b(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public String[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class c extends q<Integer> {
        c(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "integer";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public Integer h(String str) {
            if (str.startsWith("0x")) {
                return Integer.valueOf(Integer.parseInt(str.substring(2), 16));
            }
            return Integer.valueOf(Integer.parseInt(str));
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class d extends q<Integer> {
        d(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "reference";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public Integer h(String str) {
            throw new UnsupportedOperationException("References don't support parsing string values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class e extends q<int[]> {
        e(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "integer[]";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public int[] b(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public int[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class f extends q<Long> {
        f(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "long";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public Long b(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public Long h(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.startsWith("0x")) {
                return Long.valueOf(Long.parseLong(str.substring(2), 16));
            }
            return Long.valueOf(Long.parseLong(str));
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, Long l2) {
            bundle.putLong(str, l2.longValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class g extends q<long[]> {
        g(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "long[]";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public long[] b(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public long[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class h extends q<Float> {
        h(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "float";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public Float b(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public Float h(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, Float f2) {
            bundle.putFloat(str, f2.floatValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class i extends q<float[]> {
        i(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "float[]";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public float[] b(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public float[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class j extends q<Boolean> {
        j(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "boolean";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public Boolean b(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public Boolean h(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    class k extends q<boolean[]> {
        k(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.q
        public String c() {
            return "boolean[]";
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public boolean[] b(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public boolean[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class l<D extends Enum> extends p<D> {
        private final Class<D> n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.q.p, androidx.navigation.q
        public String c() {
            return this.n.getName();
        }

        @Override // androidx.navigation.q.p
        /* renamed from: m */
        public D k(String str) {
            D[] enumConstants;
            for (D d2 : this.n.getEnumConstants()) {
                if (d2.name().equals(str)) {
                    return d2;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.n.getName() + ".");
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class m<D extends Parcelable> extends q<D[]> {
        private final Class<D[]> m;

        public m(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable.");
        }

        @Override // androidx.navigation.q
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((m) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public D[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.m.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class n<D> extends q<D> {
        private final Class<D> m;

        public n(Class<D> cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
            }
            this.m = cls;
        }

        @Override // androidx.navigation.q
        public D b(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.q
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((n) obj).m);
        }

        @Override // androidx.navigation.q
        public D h(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.q
        public void i(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            if (d2 != null && !(d2 instanceof Parcelable)) {
                if (d2 instanceof Serializable) {
                    bundle.putSerializable(str, (Serializable) d2);
                    return;
                }
                return;
            }
            bundle.putParcelable(str, (Parcelable) d2);
        }
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static final class o<D extends Serializable> extends q<D[]> {
        private final Class<D[]> m;

        public o(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
                    return;
                } catch (ClassNotFoundException e2) {
                    throw new RuntimeException(e2);
                }
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        @Override // androidx.navigation.q
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((o) obj).m);
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public D[] h(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.m.cast(dArr);
            bundle.putSerializable(str, dArr);
        }
    }

    q(boolean z) {
        this.f1940l = z;
    }

    public static q<?> a(String str, String str2) {
        String str3;
        q<Integer> qVar = a;
        if (qVar.c().equals(str)) {
            return qVar;
        }
        q qVar2 = f1931c;
        if (qVar2.c().equals(str)) {
            return qVar2;
        }
        q<Long> qVar3 = f1932d;
        if (qVar3.c().equals(str)) {
            return qVar3;
        }
        q qVar4 = f1933e;
        if (qVar4.c().equals(str)) {
            return qVar4;
        }
        q<Boolean> qVar5 = f1936h;
        if (qVar5.c().equals(str)) {
            return qVar5;
        }
        q qVar6 = f1937i;
        if (qVar6.c().equals(str)) {
            return qVar6;
        }
        q<String> qVar7 = f1938j;
        if (qVar7.c().equals(str)) {
            return qVar7;
        }
        q qVar8 = f1939k;
        if (qVar8.c().equals(str)) {
            return qVar8;
        }
        q<Float> qVar9 = f1934f;
        if (qVar9.c().equals(str)) {
            return qVar9;
        }
        q qVar10 = f1935g;
        if (qVar10.c().equals(str)) {
            return qVar10;
        }
        q<Integer> qVar11 = f1930b;
        if (qVar11.c().equals(str)) {
            return qVar11;
        }
        if (str == null || str.isEmpty()) {
            return qVar7;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                str3 = str3.substring(0, str3.length() - 2);
                Class<?> cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new m(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new o(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new n(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new l(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new p(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q d(String str) {
        try {
            try {
                try {
                    try {
                        q<Integer> qVar = a;
                        qVar.h(str);
                        return qVar;
                    } catch (IllegalArgumentException unused) {
                        return f1938j;
                    }
                } catch (IllegalArgumentException unused2) {
                    q<Long> qVar2 = f1932d;
                    qVar2.h(str);
                    return qVar2;
                }
            } catch (IllegalArgumentException unused3) {
                q<Float> qVar3 = f1934f;
                qVar3.h(str);
                return qVar3;
            }
        } catch (IllegalArgumentException unused4) {
            q<Boolean> qVar4 = f1936h;
            qVar4.h(str);
            return qVar4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q e(Object obj) {
        if (obj instanceof Integer) {
            return a;
        }
        if (obj instanceof int[]) {
            return f1931c;
        }
        if (obj instanceof Long) {
            return f1932d;
        }
        if (obj instanceof long[]) {
            return f1933e;
        }
        if (obj instanceof Float) {
            return f1934f;
        }
        if (obj instanceof float[]) {
            return f1935g;
        }
        if (obj instanceof Boolean) {
            return f1936h;
        }
        if (obj instanceof boolean[]) {
            return f1937i;
        }
        if (!(obj instanceof String) && obj != null) {
            if (obj instanceof String[]) {
                return f1939k;
            }
            if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                return new m(obj.getClass().getComponentType());
            }
            if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
                return new o(obj.getClass().getComponentType());
            }
            if (obj instanceof Parcelable) {
                return new n(obj.getClass());
            }
            if (obj instanceof Enum) {
                return new l(obj.getClass());
            }
            if (obj instanceof Serializable) {
                return new p(obj.getClass());
            }
            throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
        }
        return f1938j;
    }

    public abstract T b(Bundle bundle, String str);

    public abstract String c();

    public boolean f() {
        return this.f1940l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T g(Bundle bundle, String str, String str2) {
        T h2 = h(str2);
        i(bundle, str, h2);
        return h2;
    }

    public abstract T h(String str);

    public abstract void i(Bundle bundle, String str, T t);

    public String toString() {
        return c();
    }

    /* compiled from: NavType.java */
    /* loaded from: classes.dex */
    public static class p<D extends Serializable> extends q<D> {
        private final Class<D> m;

        public p(Class<D> cls) {
            super(true);
            if (Serializable.class.isAssignableFrom(cls)) {
                if (!cls.isEnum()) {
                    this.m = cls;
                    return;
                }
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        @Override // androidx.navigation.q
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof p) {
                return this.m.equals(((p) obj).m);
            }
            return false;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.q
        /* renamed from: j */
        public D b(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.q
        /* renamed from: k */
        public D h(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.q
        /* renamed from: l */
        public void i(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            bundle.putSerializable(str, d2);
        }

        p(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }
    }
}