package com.google.firebase.components;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final class s extends com.google.firebase.components.a {
    private final Set<Class<?>> a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Class<?>> f8633b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f8634c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f8635d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Class<?>> f8636e;

    /* renamed from: f  reason: collision with root package name */
    private final e f8637f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: classes2.dex */
    private static class a implements com.google.firebase.e.c {
        private final Set<Class<?>> a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.firebase.e.c f8638b;

        public a(Set<Class<?>> set, com.google.firebase.e.c cVar) {
            this.a = set;
            this.f8638b = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (n nVar : dVar.c()) {
            if (nVar.b()) {
                if (nVar.d()) {
                    hashSet3.add(nVar.a());
                } else {
                    hashSet.add(nVar.a());
                }
            } else if (nVar.d()) {
                hashSet4.add(nVar.a());
            } else {
                hashSet2.add(nVar.a());
            }
        }
        if (!dVar.f().isEmpty()) {
            hashSet.add(com.google.firebase.e.c.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.f8633b = Collections.unmodifiableSet(hashSet2);
        this.f8634c = Collections.unmodifiableSet(hashSet3);
        this.f8635d = Collections.unmodifiableSet(hashSet4);
        this.f8636e = dVar.f();
        this.f8637f = eVar;
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public <T> T a(Class<T> cls) {
        if (this.a.contains(cls)) {
            T t = (T) this.f8637f.a(cls);
            return !cls.equals(com.google.firebase.e.c.class) ? t : (T) new a(this.f8636e, (com.google.firebase.e.c) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.g.a<T> b(Class<T> cls) {
        if (this.f8633b.contains(cls)) {
            return this.f8637f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.g.a<Set<T>> c(Class<T> cls) {
        if (this.f8635d.contains(cls)) {
            return this.f8637f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public <T> Set<T> d(Class<T> cls) {
        if (this.f8634c.contains(cls)) {
            return this.f8637f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }
}