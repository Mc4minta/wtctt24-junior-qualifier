package com.google.firebase.installations.r;

import com.google.firebase.installations.r.e;

/* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
/* loaded from: classes2.dex */
final class b extends e {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9252b;

    /* renamed from: c  reason: collision with root package name */
    private final e.b f9253c;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.2 */
    /* renamed from: com.google.firebase.installations.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0191b extends e.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private Long f9254b;

        /* renamed from: c  reason: collision with root package name */
        private e.b f9255c;

        @Override // com.google.firebase.installations.r.e.a
        public e a() {
            String str = "";
            if (this.f9254b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.f9254b.longValue(), this.f9255c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.r.e.a
        public e.a b(e.b bVar) {
            this.f9255c = bVar;
            return this;
        }

        @Override // com.google.firebase.installations.r.e.a
        public e.a c(String str) {
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.r.e.a
        public e.a d(long j2) {
            this.f9254b = Long.valueOf(j2);
            return this;
        }
    }

    @Override // com.google.firebase.installations.r.e
    public e.b b() {
        return this.f9253c;
    }

    @Override // com.google.firebase.installations.r.e
    public String c() {
        return this.a;
    }

    @Override // com.google.firebase.installations.r.e
    public long d() {
        return this.f9252b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            String str = this.a;
            if (str != null ? str.equals(eVar.c()) : eVar.c() == null) {
                if (this.f9252b == eVar.d()) {
                    e.b bVar = this.f9253c;
                    if (bVar == null) {
                        if (eVar.b() == null) {
                            return true;
                        }
                    } else if (bVar.equals(eVar.b())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.f9252b;
        int i2 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        e.b bVar = this.f9253c;
        return i2 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.f9252b + ", responseCode=" + this.f9253c + "}";
    }

    private b(String str, long j2, e.b bVar) {
        this.a = str;
        this.f9252b = j2;
        this.f9253c = bVar;
    }
}