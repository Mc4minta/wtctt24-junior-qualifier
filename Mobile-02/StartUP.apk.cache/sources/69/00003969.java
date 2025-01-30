package com.google.firebase.components;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public class p implements com.google.firebase.e.d, com.google.firebase.e.c {
    private final Map<Class<?>, ConcurrentHashMap<com.google.firebase.e.b<Object>, Executor>> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<com.google.firebase.e.a<?>> f8629b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f8630c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Executor executor) {
        this.f8630c = executor;
    }

    private synchronized Set<Map.Entry<com.google.firebase.e.b<Object>, Executor>> d(com.google.firebase.e.a<?> aVar) {
        ConcurrentHashMap<com.google.firebase.e.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.a.get(aVar.b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    @Override // com.google.firebase.e.d
    public <T> void a(Class<T> cls, com.google.firebase.e.b<? super T> bVar) {
        b(cls, this.f8630c, bVar);
    }

    @Override // com.google.firebase.e.d
    public synchronized <T> void b(Class<T> cls, Executor executor, com.google.firebase.e.b<? super T> bVar) {
        r.b(cls);
        r.b(bVar);
        r.b(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(bVar, executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Queue<com.google.firebase.e.a<?>> queue;
        synchronized (this) {
            queue = this.f8629b;
            if (queue != null) {
                this.f8629b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (com.google.firebase.e.a<?> aVar : queue) {
                f(aVar);
            }
        }
    }

    public void f(com.google.firebase.e.a<?> aVar) {
        r.b(aVar);
        synchronized (this) {
            Queue<com.google.firebase.e.a<?>> queue = this.f8629b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (Map.Entry<com.google.firebase.e.b<Object>, Executor> entry : d(aVar)) {
                entry.getValue().execute(o.a(entry, aVar));
            }
        }
    }
}