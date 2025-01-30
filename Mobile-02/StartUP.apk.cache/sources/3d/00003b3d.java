package com.google.firebase.installations.r;

import com.google.firebase.installations.r.d;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final class a extends d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9244b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9245c;

    /* renamed from: d  reason: collision with root package name */
    private final e f9246d;

    /* renamed from: e  reason: collision with root package name */
    private final d.b f9247e;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* loaded from: classes2.dex */
    static final class b extends d.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f9248b;

        /* renamed from: c  reason: collision with root package name */
        private String f9249c;

        /* renamed from: d  reason: collision with root package name */
        private e f9250d;

        /* renamed from: e  reason: collision with root package name */
        private d.b f9251e;

        @Override // com.google.firebase.installations.r.d.a
        public d a() {
            return new a(this.a, this.f9248b, this.f9249c, this.f9250d, this.f9251e);
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a b(e eVar) {
            this.f9250d = eVar;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a c(String str) {
            this.f9248b = str;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a d(String str) {
            this.f9249c = str;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a e(d.b bVar) {
            this.f9251e = bVar;
            return this;
        }

        @Override // com.google.firebase.installations.r.d.a
        public d.a f(String str) {
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.installations.r.d
    public e b() {
        return this.f9246d;
    }

    @Override // com.google.firebase.installations.r.d
    public String c() {
        return this.f9244b;
    }

    @Override // com.google.firebase.installations.r.d
    public String d() {
        return this.f9245c;
    }

    @Override // com.google.firebase.installations.r.d
    public d.b e() {
        return this.f9247e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.a;
            if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
                String str2 = this.f9244b;
                if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                    String str3 = this.f9245c;
                    if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                        e eVar = this.f9246d;
                        if (eVar != null ? eVar.equals(dVar.b()) : dVar.b() == null) {
                            d.b bVar = this.f9247e;
                            if (bVar == null) {
                                if (dVar.e() == null) {
                                    return true;
                                }
                            } else if (bVar.equals(dVar.e())) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.installations.r.d
    public String f() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f9244b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f9245c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        e eVar = this.f9246d;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        d.b bVar = this.f9247e;
        return hashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.a + ", fid=" + this.f9244b + ", refreshToken=" + this.f9245c + ", authToken=" + this.f9246d + ", responseCode=" + this.f9247e + "}";
    }

    private a(String str, String str2, String str3, e eVar, d.b bVar) {
        this.a = str;
        this.f9244b = str2;
        this.f9245c = str3;
        this.f9246d = eVar;
        this.f9247e = bVar;
    }
}