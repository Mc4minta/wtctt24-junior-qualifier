package com.google.firebase.installations;

import com.google.firebase.installations.m;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
/* loaded from: classes2.dex */
final class a extends m {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9203b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9204c;

    /* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
    /* loaded from: classes2.dex */
    static final class b extends m.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private Long f9205b;

        /* renamed from: c  reason: collision with root package name */
        private Long f9206c;

        @Override // com.google.firebase.installations.m.a
        public m a() {
            String str = "";
            if (this.a == null) {
                str = " token";
            }
            if (this.f9205b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f9206c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f9205b.longValue(), this.f9206c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.m.a
        public m.a b(String str) {
            Objects.requireNonNull(str, "Null token");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.m.a
        public m.a c(long j2) {
            this.f9206c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.installations.m.a
        public m.a d(long j2) {
            this.f9205b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.installations.m
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.installations.m
    public long c() {
        return this.f9204c;
    }

    @Override // com.google.firebase.installations.m
    public long d() {
        return this.f9203b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.a.equals(mVar.b()) && this.f9203b == mVar.d() && this.f9204c == mVar.c();
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f9203b;
        long j3 = this.f9204c;
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.f9203b + ", tokenCreationTimestamp=" + this.f9204c + "}";
    }

    private a(String str, long j2, long j3) {
        this.a = str;
        this.f9203b = j2;
        this.f9204c = j3;
    }
}