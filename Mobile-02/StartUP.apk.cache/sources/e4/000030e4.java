package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class d extends g.b {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5834b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<g.c> f5835c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    static final class b extends g.b.a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private Long f5836b;

        /* renamed from: c  reason: collision with root package name */
        private Set<g.c> f5837c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b.a
        public g.b a() {
            String str = "";
            if (this.a == null) {
                str = " delta";
            }
            if (this.f5836b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f5837c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new d(this.a.longValue(), this.f5836b.longValue(), this.f5837c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b.a
        public g.b.a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b.a
        public g.b.a c(Set<g.c> set) {
            Objects.requireNonNull(set, "Null flags");
            this.f5837c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b.a
        public g.b.a d(long j2) {
            this.f5836b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b
    long b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b
    Set<g.c> c() {
        return this.f5835c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g.b
    long d() {
        return this.f5834b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g.b) {
            g.b bVar = (g.b) obj;
            return this.a == bVar.b() && this.f5834b == bVar.d() && this.f5835c.equals(bVar.c());
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f5834b;
        return ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f5835c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.f5834b + ", flags=" + this.f5835c + "}";
    }

    private d(long j2, long j3, Set<g.c> set) {
        this.a = j2;
        this.f5834b = j3;
        this.f5835c = set;
    }
}