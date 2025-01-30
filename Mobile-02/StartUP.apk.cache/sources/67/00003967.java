package com.google.firebase.components;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final class n {
    private final Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8626b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8627c;

    private n(Class<?> cls, int i2, int i3) {
        this.a = (Class) r.c(cls, "Null dependency anInterface.");
        this.f8626b = i2;
        this.f8627c = i3;
    }

    public static n e(Class<?> cls) {
        return new n(cls, 0, 0);
    }

    public static n f(Class<?> cls) {
        return new n(cls, 1, 0);
    }

    public static n g(Class<?> cls) {
        return new n(cls, 1, 1);
    }

    public static n h(Class<?> cls) {
        return new n(cls, 2, 0);
    }

    public Class<?> a() {
        return this.a;
    }

    public boolean b() {
        return this.f8627c == 0;
    }

    public boolean c() {
        return this.f8626b == 1;
    }

    public boolean d() {
        return this.f8626b == 2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.a == nVar.a && this.f8626b == nVar.f8626b && this.f8627c == nVar.f8627c;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8626b) * 1000003) ^ this.f8627c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i2 = this.f8626b;
        sb.append(i2 == 1 ? "required" : i2 == 0 ? "optional" : "set");
        sb.append(", direct=");
        sb.append(this.f8627c == 0);
        sb.append("}");
        return sb.toString();
    }
}