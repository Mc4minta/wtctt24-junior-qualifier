package kotlin;

import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes3.dex */
public final class t<A, B, C> implements Serializable {
    private final A a;

    /* renamed from: b  reason: collision with root package name */
    private final B f17411b;

    /* renamed from: c  reason: collision with root package name */
    private final C f17412c;

    public t(A a, B b2, C c2) {
        this.a = a;
        this.f17411b = b2;
        this.f17412c = c2;
    }

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.f17411b;
    }

    public final C c() {
        return this.f17412c;
    }

    public final A d() {
        return this.a;
    }

    public final B e() {
        return this.f17411b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof t) {
                t tVar = (t) obj;
                return kotlin.jvm.internal.m.c(this.a, tVar.a) && kotlin.jvm.internal.m.c(this.f17411b, tVar.f17411b) && kotlin.jvm.internal.m.c(this.f17412c, tVar.f17412c);
            }
            return false;
        }
        return true;
    }

    public final C f() {
        return this.f17412c;
    }

    public int hashCode() {
        A a = this.a;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.f17411b;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.f17412c;
        return hashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.f17411b + ", " + this.f17412c + ')';
    }
}