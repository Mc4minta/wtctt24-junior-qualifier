package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class r extends v.d.AbstractC0173d.c {
    private final Double a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8946b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8947c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8948d;

    /* renamed from: e  reason: collision with root package name */
    private final long f8949e;

    /* renamed from: f  reason: collision with root package name */
    private final long f8950f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.c.a {
        private Double a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f8951b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f8952c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f8953d;

        /* renamed from: e  reason: collision with root package name */
        private Long f8954e;

        /* renamed from: f  reason: collision with root package name */
        private Long f8955f;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c a() {
            String str = "";
            if (this.f8951b == null) {
                str = " batteryVelocity";
            }
            if (this.f8952c == null) {
                str = str + " proximityOn";
            }
            if (this.f8953d == null) {
                str = str + " orientation";
            }
            if (this.f8954e == null) {
                str = str + " ramUsed";
            }
            if (this.f8955f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new r(this.a, this.f8951b.intValue(), this.f8952c.booleanValue(), this.f8953d.intValue(), this.f8954e.longValue(), this.f8955f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c.a b(Double d2) {
            this.a = d2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c.a c(int i2) {
            this.f8951b = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c.a d(long j2) {
            this.f8955f = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c.a e(int i2) {
            this.f8953d = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c.a f(boolean z) {
            this.f8952c = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c.a
        public v.d.AbstractC0173d.c.a g(long j2) {
            this.f8954e = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c
    public Double b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c
    public int c() {
        return this.f8946b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c
    public long d() {
        return this.f8950f;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c
    public int e() {
        return this.f8948d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.c) {
            v.d.AbstractC0173d.c cVar = (v.d.AbstractC0173d.c) obj;
            Double d2 = this.a;
            if (d2 != null ? d2.equals(cVar.b()) : cVar.b() == null) {
                if (this.f8946b == cVar.c() && this.f8947c == cVar.g() && this.f8948d == cVar.e() && this.f8949e == cVar.f() && this.f8950f == cVar.d()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c
    public long f() {
        return this.f8949e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.c
    public boolean g() {
        return this.f8947c;
    }

    public int hashCode() {
        Double d2 = this.a;
        int hashCode = ((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.f8946b) * 1000003;
        int i2 = this.f8947c ? 1231 : 1237;
        long j2 = this.f8949e;
        long j3 = this.f8950f;
        return ((((((hashCode ^ i2) * 1000003) ^ this.f8948d) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.a + ", batteryVelocity=" + this.f8946b + ", proximityOn=" + this.f8947c + ", orientation=" + this.f8948d + ", ramUsed=" + this.f8949e + ", diskUsed=" + this.f8950f + "}";
    }

    private r(Double d2, int i2, boolean z, int i3, long j2, long j3) {
        this.a = d2;
        this.f8946b = i2;
        this.f8947c = z;
        this.f8948d = i3;
        this.f8949e = j2;
        this.f8950f = j3;
    }
}