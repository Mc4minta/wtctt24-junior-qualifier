package kotlin;

import java.io.Serializable;

/* compiled from: Tuples.kt */
/* loaded from: classes3.dex */
public final class o<A, B> implements Serializable {
    private final A a;

    /* renamed from: b  reason: collision with root package name */
    private final B f17387b;

    public o(A a, B b2) {
        this.a = a;
        this.f17387b = b2;
    }

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.f17387b;
    }

    public final A c() {
        return this.a;
    }

    public final B d() {
        return this.f17387b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof o) {
                o oVar = (o) obj;
                return kotlin.jvm.internal.m.c(this.a, oVar.a) && kotlin.jvm.internal.m.c(this.f17387b, oVar.f17387b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.a;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.f17387b;
        return hashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.f17387b + ')';
    }
}