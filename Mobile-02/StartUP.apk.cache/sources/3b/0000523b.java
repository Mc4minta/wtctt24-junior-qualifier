package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* compiled from: ClassReference.kt */
/* loaded from: classes3.dex */
public final class e implements kotlin.j0.d<Object>, d {
    private static final Map<Class<? extends kotlin.d<?>>, Integer> a;

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f17308b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, String> f17309c;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f17310d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, String> f17311e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f17312f = new a(null);

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f17313g;

    /* compiled from: ClassReference.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final String a(Class<?> jClass) {
            String str;
            m.g(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) e.f17310d.get(jClass.getName());
                return str3 != null ? str3 : jClass.getCanonicalName();
            }
            Class<?> componentType = jClass.getComponentType();
            m.f(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) e.f17310d.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 != null ? str2 : "kotlin.Array";
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
            if (r1 != null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String b(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.m.g(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                java.lang.String r1 = "Array"
                r2 = 0
                if (r0 == 0) goto L11
            Le:
                r1 = r2
                goto Lc1
            L11:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L73
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r1 = r8.getEnclosingMethod()
                java.lang.String r3 = "$"
                r4 = 2
                java.lang.String r5 = "name"
                if (r1 == 0) goto L43
                kotlin.jvm.internal.m.f(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r1 = r1.getName()
                r6.append(r1)
                r6.append(r3)
                java.lang.String r1 = r6.toString()
                java.lang.String r1 = kotlin.l0.o.W0(r0, r1, r2, r4, r2)
                if (r1 == 0) goto L43
                goto L66
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L65
                kotlin.jvm.internal.m.f(r0, r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r8 = r8.getName()
                r1.append(r8)
                r1.append(r3)
                java.lang.String r8 = r1.toString()
                java.lang.String r8 = kotlin.l0.o.W0(r0, r8, r2, r4, r2)
                r1 = r8
                goto L66
            L65:
                r1 = r2
            L66:
                if (r1 == 0) goto L69
                goto Lc1
            L69:
                kotlin.jvm.internal.m.f(r0, r5)
                r8 = 36
                java.lang.String r1 = kotlin.l0.o.V0(r0, r8, r2, r4, r2)
                goto Lc1
            L73:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto Lab
                java.lang.Class r8 = r8.getComponentType()
                java.lang.String r0 = "componentType"
                kotlin.jvm.internal.m.f(r8, r0)
                boolean r0 = r8.isPrimitive()
                if (r0 == 0) goto La7
                java.util.Map r0 = kotlin.jvm.internal.e.b()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto La7
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r1)
                java.lang.String r2 = r0.toString()
            La7:
                if (r2 == 0) goto Lc1
                goto Le
            Lab:
                java.util.Map r0 = kotlin.jvm.internal.e.b()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 == 0) goto Lbd
                goto Lc1
            Lbd:
                java.lang.String r1 = r8.getSimpleName()
            Lc1:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.e.a.b(java.lang.Class):java.lang.String");
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List j2;
        int r;
        Map<Class<? extends kotlin.d<?>>, Integer> r2;
        int d2;
        String Z0;
        String Z02;
        int i2 = 0;
        j2 = kotlin.a0.r.j(kotlin.e0.c.a.class, kotlin.e0.c.l.class, kotlin.e0.c.p.class, kotlin.e0.c.q.class, kotlin.e0.c.r.class, kotlin.e0.c.s.class, kotlin.e0.c.t.class, kotlin.e0.c.u.class, kotlin.e0.c.v.class, kotlin.e0.c.w.class, kotlin.e0.c.b.class, kotlin.e0.c.c.class, kotlin.e0.c.d.class, kotlin.e0.c.e.class, kotlin.e0.c.f.class, kotlin.e0.c.g.class, kotlin.e0.c.h.class, kotlin.e0.c.i.class, kotlin.e0.c.j.class, kotlin.e0.c.k.class, kotlin.e0.c.m.class, kotlin.e0.c.n.class, kotlin.e0.c.o.class);
        r = kotlin.a0.s.r(j2, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Object obj : j2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a0.r.q();
            }
            arrayList.add(kotlin.u.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        r2 = kotlin.a0.m0.r(arrayList);
        a = r2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f17308b = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f17309c = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        m.f(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            m.f(kotlinName, "kotlinName");
            Z02 = kotlin.l0.y.Z0(kotlinName, '.', null, 2, null);
            sb.append(Z02);
            sb.append("CompanionObject");
            kotlin.o a2 = kotlin.u.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a2.c(), a2.d());
        }
        for (Map.Entry<Class<? extends kotlin.d<?>>, Integer> entry : a.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        f17310d = hashMap3;
        d2 = kotlin.a0.l0.d(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(d2);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            Z0 = kotlin.l0.y.Z0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, Z0);
        }
        f17311e = linkedHashMap;
    }

    public e(Class<?> jClass) {
        m.g(jClass, "jClass");
        this.f17313g = jClass;
    }

    private final Void c() {
        throw new kotlin.e0.b();
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && m.c(kotlin.e0.a.c(this), kotlin.e0.a.c((kotlin.j0.d) obj));
    }

    @Override // kotlin.j0.b
    public List<Annotation> getAnnotations() {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> getJClass() {
        return this.f17313g;
    }

    @Override // kotlin.j0.d
    public Object getObjectInstance() {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.j0.d
    public String getQualifiedName() {
        return f17312f.a(getJClass());
    }

    @Override // kotlin.j0.d
    public String getSimpleName() {
        return f17312f.b(getJClass());
    }

    @Override // kotlin.j0.d
    public List<kotlin.j0.r> getTypeParameters() {
        c();
        throw new KotlinNothingValueException();
    }

    public int hashCode() {
        return kotlin.e0.a.c(this).hashCode();
    }

    @Override // kotlin.j0.d
    public boolean isAbstract() {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.j0.d
    public boolean isInner() {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.j0.d
    public boolean isSealed() {
        c();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}