package com.google.android.gms.internal.p000firebaseperf;

import java.util.NoSuchElementException;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p0  reason: invalid package */
/* loaded from: classes2.dex */
public final class p0<T> {
    private static final p0<?> a = new p0<>();

    /* renamed from: b  reason: collision with root package name */
    private final T f6887b;

    private p0() {
        this.f6887b = null;
    }

    public static <T> p0<T> c(T t) {
        return new p0<>(t);
    }

    public static <T> p0<T> d(T t) {
        if (t == null) {
            return (p0<T>) a;
        }
        return c(t);
    }

    public static <T> p0<T> e() {
        return (p0<T>) a;
    }

    public final T a() {
        T t = this.f6887b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean b() {
        return this.f6887b != null;
    }

    private p0(T t) {
        Objects.requireNonNull(t, "value for optional is empty.");
        this.f6887b = t;
    }
}