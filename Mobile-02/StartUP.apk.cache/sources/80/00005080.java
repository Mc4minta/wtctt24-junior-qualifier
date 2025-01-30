package h.c.u0;

import java.util.concurrent.TimeUnit;

/* compiled from: Timed.java */
/* loaded from: classes3.dex */
public final class b<T> {
    final T a;

    /* renamed from: b  reason: collision with root package name */
    final long f16828b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f16829c;

    public b(T t, long j2, TimeUnit timeUnit) {
        this.a = t;
        this.f16828b = j2;
        this.f16829c = (TimeUnit) h.c.n0.b.b.e(timeUnit, "unit is null");
    }

    public long a() {
        return this.f16828b;
    }

    public T b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return h.c.n0.b.b.c(this.a, bVar.a) && this.f16828b == bVar.f16828b && h.c.n0.b.b.c(this.f16829c, bVar.f16829c);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j2 = this.f16828b;
        return (((hashCode * 31) + ((int) (j2 ^ (j2 >>> 31)))) * 31) + this.f16829c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f16828b + ", unit=" + this.f16829c + ", value=" + this.a + "]";
    }
}