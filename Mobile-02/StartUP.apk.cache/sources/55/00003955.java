package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final class d<T> {
    private final Set<Class<? super T>> a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<n> f8607b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8608c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8609d;

    /* renamed from: e  reason: collision with root package name */
    private final g<T> f8610e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f8611f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: classes2.dex */
    public static class b<T> {
        private final Set<Class<? super T>> a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<n> f8612b;

        /* renamed from: c  reason: collision with root package name */
        private int f8613c;

        /* renamed from: d  reason: collision with root package name */
        private int f8614d;

        /* renamed from: e  reason: collision with root package name */
        private g<T> f8615e;

        /* renamed from: f  reason: collision with root package name */
        private Set<Class<?>> f8616f;

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> g() {
            this.f8614d = 1;
            return this;
        }

        private b<T> h(int i2) {
            r.d(this.f8613c == 0, "Instantiation type has already been set.");
            this.f8613c = i2;
            return this;
        }

        private void i(Class<?> cls) {
            r.a(!this.a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(n nVar) {
            r.c(nVar, "Null dependency");
            i(nVar.a());
            this.f8612b.add(nVar);
            return this;
        }

        public b<T> c() {
            return h(1);
        }

        public d<T> d() {
            r.d(this.f8615e != null, "Missing required property: factory.");
            return new d<>(new HashSet(this.a), new HashSet(this.f8612b), this.f8613c, this.f8614d, this.f8615e, this.f8616f);
        }

        public b<T> e() {
            return h(2);
        }

        public b<T> f(g<T> gVar) {
            this.f8615e = (g) r.c(gVar, "Null factory");
            return this;
        }

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.f8612b = new HashSet();
            this.f8613c = 0;
            this.f8614d = 0;
            this.f8616f = new HashSet();
            r.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                r.c(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> d<T> g(T t, Class<T> cls) {
        return h(cls).f(c.b(t)).d();
    }

    public static <T> b<T> h(Class<T> cls) {
        return a(cls).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object l(Object obj, e eVar) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object m(Object obj, e eVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> d<T> n(T t, Class<T> cls, Class<? super T>... clsArr) {
        return b(cls, clsArr).f(com.google.firebase.components.b.b(t)).d();
    }

    public Set<n> c() {
        return this.f8607b;
    }

    public g<T> d() {
        return this.f8610e;
    }

    public Set<Class<? super T>> e() {
        return this.a;
    }

    public Set<Class<?>> f() {
        return this.f8611f;
    }

    public boolean i() {
        return this.f8608c == 1;
    }

    public boolean j() {
        return this.f8608c == 2;
    }

    public boolean k() {
        return this.f8609d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.f8608c + ", type=" + this.f8609d + ", deps=" + Arrays.toString(this.f8607b.toArray()) + "}";
    }

    private d(Set<Class<? super T>> set, Set<n> set2, int i2, int i3, g<T> gVar, Set<Class<?>> set3) {
        this.a = Collections.unmodifiableSet(set);
        this.f8607b = Collections.unmodifiableSet(set2);
        this.f8608c = i2;
        this.f8609d = i3;
        this.f8610e = gVar;
        this.f8611f = Collections.unmodifiableSet(set3);
    }
}