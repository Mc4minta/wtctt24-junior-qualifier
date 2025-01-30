package e.g.a.c.i.v.j;

import e.g.a.c.i.v.j.d;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private final long f13038b;

    /* renamed from: c  reason: collision with root package name */
    private final int f13039c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13040d;

    /* renamed from: e  reason: collision with root package name */
    private final long f13041e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13042f;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    static final class b extends d.a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f13043b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f13044c;

        /* renamed from: d  reason: collision with root package name */
        private Long f13045d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f13046e;

        @Override // e.g.a.c.i.v.j.d.a
        d a() {
            String str = "";
            if (this.a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f13043b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f13044c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f13045d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f13046e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.a.longValue(), this.f13043b.intValue(), this.f13044c.intValue(), this.f13045d.longValue(), this.f13046e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e.g.a.c.i.v.j.d.a
        d.a b(int i2) {
            this.f13044c = Integer.valueOf(i2);
            return this;
        }

        @Override // e.g.a.c.i.v.j.d.a
        d.a c(long j2) {
            this.f13045d = Long.valueOf(j2);
            return this;
        }

        @Override // e.g.a.c.i.v.j.d.a
        d.a d(int i2) {
            this.f13043b = Integer.valueOf(i2);
            return this;
        }

        @Override // e.g.a.c.i.v.j.d.a
        d.a e(int i2) {
            this.f13046e = Integer.valueOf(i2);
            return this;
        }

        @Override // e.g.a.c.i.v.j.d.a
        d.a f(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }
    }

    @Override // e.g.a.c.i.v.j.d
    int b() {
        return this.f13040d;
    }

    @Override // e.g.a.c.i.v.j.d
    long c() {
        return this.f13041e;
    }

    @Override // e.g.a.c.i.v.j.d
    int d() {
        return this.f13039c;
    }

    @Override // e.g.a.c.i.v.j.d
    int e() {
        return this.f13042f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f13038b == dVar.f() && this.f13039c == dVar.d() && this.f13040d == dVar.b() && this.f13041e == dVar.c() && this.f13042f == dVar.e();
        }
        return false;
    }

    @Override // e.g.a.c.i.v.j.d
    long f() {
        return this.f13038b;
    }

    public int hashCode() {
        long j2 = this.f13038b;
        long j3 = this.f13041e;
        return ((((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f13039c) * 1000003) ^ this.f13040d) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f13042f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f13038b + ", loadBatchSize=" + this.f13039c + ", criticalSectionEnterTimeoutMs=" + this.f13040d + ", eventCleanUpAge=" + this.f13041e + ", maxBlobByteSizePerRow=" + this.f13042f + "}";
    }

    private a(long j2, int i2, int i3, long j3, int i4) {
        this.f13038b = j2;
        this.f13039c = i2;
        this.f13040d = i3;
        this.f13041e = j3;
        this.f13042f = i4;
    }
}