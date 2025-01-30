package com.google.firebase.installations.q;

import com.google.firebase.installations.q.c;
import com.google.firebase.installations.q.d;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private final String f9223b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f9224c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9225d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9226e;

    /* renamed from: f  reason: collision with root package name */
    private final long f9227f;

    /* renamed from: g  reason: collision with root package name */
    private final long f9228g;

    /* renamed from: h  reason: collision with root package name */
    private final String f9229h;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    static final class b extends d.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private c.a f9230b;

        /* renamed from: c  reason: collision with root package name */
        private String f9231c;

        /* renamed from: d  reason: collision with root package name */
        private String f9232d;

        /* renamed from: e  reason: collision with root package name */
        private Long f9233e;

        /* renamed from: f  reason: collision with root package name */
        private Long f9234f;

        /* renamed from: g  reason: collision with root package name */
        private String f9235g;

        @Override // com.google.firebase.installations.q.d.a
        public d a() {
            String str = "";
            if (this.f9230b == null) {
                str = " registrationStatus";
            }
            if (this.f9233e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f9234f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f9230b, this.f9231c, this.f9232d, this.f9233e.longValue(), this.f9234f.longValue(), this.f9235g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a b(String str) {
            this.f9231c = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a c(long j2) {
            this.f9233e = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a d(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a e(String str) {
            this.f9235g = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a f(String str) {
            this.f9232d = str;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a g(c.a aVar) {
            Objects.requireNonNull(aVar, "Null registrationStatus");
            this.f9230b = aVar;
            return this;
        }

        @Override // com.google.firebase.installations.q.d.a
        public d.a h(long j2) {
            this.f9234f = Long.valueOf(j2);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(d dVar) {
            this.a = dVar.d();
            this.f9230b = dVar.g();
            this.f9231c = dVar.b();
            this.f9232d = dVar.f();
            this.f9233e = Long.valueOf(dVar.c());
            this.f9234f = Long.valueOf(dVar.h());
            this.f9235g = dVar.e();
        }
    }

    @Override // com.google.firebase.installations.q.d
    public String b() {
        return this.f9225d;
    }

    @Override // com.google.firebase.installations.q.d
    public long c() {
        return this.f9227f;
    }

    @Override // com.google.firebase.installations.q.d
    public String d() {
        return this.f9223b;
    }

    @Override // com.google.firebase.installations.q.d
    public String e() {
        return this.f9229h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str3 = this.f9223b;
            if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                if (this.f9224c.equals(dVar.g()) && ((str = this.f9225d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f9226e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f9227f == dVar.c() && this.f9228g == dVar.h()) {
                    String str4 = this.f9229h;
                    if (str4 == null) {
                        if (dVar.e() == null) {
                            return true;
                        }
                    } else if (str4.equals(dVar.e())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.installations.q.d
    public String f() {
        return this.f9226e;
    }

    @Override // com.google.firebase.installations.q.d
    public c.a g() {
        return this.f9224c;
    }

    @Override // com.google.firebase.installations.q.d
    public long h() {
        return this.f9228g;
    }

    public int hashCode() {
        String str = this.f9223b;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f9224c.hashCode()) * 1000003;
        String str2 = this.f9225d;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f9226e;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j2 = this.f9227f;
        long j3 = this.f9228g;
        int i2 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str4 = this.f9229h;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.q.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f9223b + ", registrationStatus=" + this.f9224c + ", authToken=" + this.f9225d + ", refreshToken=" + this.f9226e + ", expiresInSecs=" + this.f9227f + ", tokenCreationEpochInSecs=" + this.f9228g + ", fisError=" + this.f9229h + "}";
    }

    private a(String str, c.a aVar, String str2, String str3, long j2, long j3, String str4) {
        this.f9223b = str;
        this.f9224c = aVar;
        this.f9225d = str2;
        this.f9226e = str3;
        this.f9227f = j2;
        this.f9228g = j3;
        this.f9229h = str4;
    }
}