package kotlin.a0;

/* compiled from: IndexedValue.kt */
/* loaded from: classes3.dex */
public final class e0<T> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final T f17213b;

    public e0(int i2, T t) {
        this.a = i2;
        this.f17213b = t;
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.f17213b;
    }

    public final int c() {
        return this.a;
    }

    public final T d() {
        return this.f17213b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e0) {
                e0 e0Var = (e0) obj;
                return this.a == e0Var.a && kotlin.jvm.internal.m.c(this.f17213b, e0Var.f17213b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.a * 31;
        T t = this.f17213b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.f17213b + ")";
    }
}