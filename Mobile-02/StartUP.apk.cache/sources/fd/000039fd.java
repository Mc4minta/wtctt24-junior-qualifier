package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class b extends v {

    /* renamed from: b  reason: collision with root package name */
    private final String f8831b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8832c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8833d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8834e;

    /* renamed from: f  reason: collision with root package name */
    private final String f8835f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8836g;

    /* renamed from: h  reason: collision with root package name */
    private final v.d f8837h;

    /* renamed from: i  reason: collision with root package name */
    private final v.c f8838i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0171b extends v.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f8839b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f8840c;

        /* renamed from: d  reason: collision with root package name */
        private String f8841d;

        /* renamed from: e  reason: collision with root package name */
        private String f8842e;

        /* renamed from: f  reason: collision with root package name */
        private String f8843f;

        /* renamed from: g  reason: collision with root package name */
        private v.d f8844g;

        /* renamed from: h  reason: collision with root package name */
        private v.c f8845h;

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v a() {
            String str = "";
            if (this.a == null) {
                str = " sdkVersion";
            }
            if (this.f8839b == null) {
                str = str + " gmpAppId";
            }
            if (this.f8840c == null) {
                str = str + " platform";
            }
            if (this.f8841d == null) {
                str = str + " installationUuid";
            }
            if (this.f8842e == null) {
                str = str + " buildVersion";
            }
            if (this.f8843f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.f8839b, this.f8840c.intValue(), this.f8841d, this.f8842e, this.f8843f, this.f8844g, this.f8845h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a b(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.f8842e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a c(String str) {
            Objects.requireNonNull(str, "Null displayVersion");
            this.f8843f = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a d(String str) {
            Objects.requireNonNull(str, "Null gmpAppId");
            this.f8839b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a e(String str) {
            Objects.requireNonNull(str, "Null installationUuid");
            this.f8841d = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a f(v.c cVar) {
            this.f8845h = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a g(int i2) {
            this.f8840c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a h(String str) {
            Objects.requireNonNull(str, "Null sdkVersion");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.a
        public v.a i(v.d dVar) {
            this.f8844g = dVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0171b() {
        }

        private C0171b(v vVar) {
            this.a = vVar.i();
            this.f8839b = vVar.e();
            this.f8840c = Integer.valueOf(vVar.h());
            this.f8841d = vVar.f();
            this.f8842e = vVar.c();
            this.f8843f = vVar.d();
            this.f8844g = vVar.j();
            this.f8845h = vVar.g();
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public String c() {
        return this.f8835f;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public String d() {
        return this.f8836g;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public String e() {
        return this.f8832c;
    }

    public boolean equals(Object obj) {
        v.d dVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (this.f8831b.equals(vVar.i()) && this.f8832c.equals(vVar.e()) && this.f8833d == vVar.h() && this.f8834e.equals(vVar.f()) && this.f8835f.equals(vVar.c()) && this.f8836g.equals(vVar.d()) && ((dVar = this.f8837h) != null ? dVar.equals(vVar.j()) : vVar.j() == null)) {
                v.c cVar = this.f8838i;
                if (cVar == null) {
                    if (vVar.g() == null) {
                        return true;
                    }
                } else if (cVar.equals(vVar.g())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public String f() {
        return this.f8834e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public v.c g() {
        return this.f8838i;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public int h() {
        return this.f8833d;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f8831b.hashCode() ^ 1000003) * 1000003) ^ this.f8832c.hashCode()) * 1000003) ^ this.f8833d) * 1000003) ^ this.f8834e.hashCode()) * 1000003) ^ this.f8835f.hashCode()) * 1000003) ^ this.f8836g.hashCode()) * 1000003;
        v.d dVar = this.f8837h;
        int hashCode2 = (hashCode ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        v.c cVar = this.f8838i;
        return hashCode2 ^ (cVar != null ? cVar.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public String i() {
        return this.f8831b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    public v.d j() {
        return this.f8837h;
    }

    @Override // com.google.firebase.crashlytics.c.i.v
    protected v.a l() {
        return new C0171b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f8831b + ", gmpAppId=" + this.f8832c + ", platform=" + this.f8833d + ", installationUuid=" + this.f8834e + ", buildVersion=" + this.f8835f + ", displayVersion=" + this.f8836g + ", session=" + this.f8837h + ", ndkPayload=" + this.f8838i + "}";
    }

    private b(String str, String str2, int i2, String str3, String str4, String str5, v.d dVar, v.c cVar) {
        this.f8831b = str;
        this.f8832c = str2;
        this.f8833d = i2;
        this.f8834e = str3;
        this.f8835f = str4;
        this.f8836g = str5;
        this.f8837h = dVar;
        this.f8838i = cVar;
    }
}