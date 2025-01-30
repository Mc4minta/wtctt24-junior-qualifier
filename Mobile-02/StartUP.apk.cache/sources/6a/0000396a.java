package com.google.firebase.components;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public class q<T> implements com.google.firebase.g.a<T> {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f8631b = a;

    /* renamed from: c  reason: collision with root package name */
    private volatile com.google.firebase.g.a<T> f8632c;

    public q(com.google.firebase.g.a<T> aVar) {
        this.f8632c = aVar;
    }

    @Override // com.google.firebase.g.a
    public T get() {
        T t = (T) this.f8631b;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = this.f8631b;
                if (t == obj) {
                    t = this.f8632c.get();
                    this.f8631b = t;
                    this.f8632c = null;
                }
            }
        }
        return t;
    }
}