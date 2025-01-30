package com.google.firebase.e;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public class a<T> {
    private final Class<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final T f9085b;

    public T a() {
        return this.f9085b;
    }

    public Class<T> b() {
        return this.a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.a, this.f9085b);
    }
}