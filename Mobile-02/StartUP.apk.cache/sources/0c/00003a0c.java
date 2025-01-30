package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class g extends v.d.a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8872b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8873c;

    /* renamed from: d  reason: collision with root package name */
    private final v.d.a.b f8874d;

    /* renamed from: e  reason: collision with root package name */
    private final String f8875e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.a.AbstractC0172a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f8876b;

        /* renamed from: c  reason: collision with root package name */
        private String f8877c;

        /* renamed from: d  reason: collision with root package name */
        private v.d.a.b f8878d;

        /* renamed from: e  reason: collision with root package name */
        private String f8879e;

        @Override // com.google.firebase.crashlytics.c.i.v.d.a.AbstractC0172a
        public v.d.a a() {
            String str = "";
            if (this.a == null) {
                str = " identifier";
            }
            if (this.f8876b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new g(this.a, this.f8876b, this.f8877c, this.f8878d, this.f8879e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.a.AbstractC0172a
        public v.d.a.AbstractC0172a b(String str) {
            this.f8877c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.a.AbstractC0172a
        public v.d.a.AbstractC0172a c(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.a.AbstractC0172a
        public v.d.a.AbstractC0172a d(String str) {
            this.f8879e = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.a.AbstractC0172a
        public v.d.a.AbstractC0172a e(String str) {
            Objects.requireNonNull(str, "Null version");
            this.f8876b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.a
    public String b() {
        return this.f8873c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.a
    public String c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.a
    public String d() {
        return this.f8875e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.a
    public v.d.a.b e() {
        return this.f8874d;
    }

    public boolean equals(Object obj) {
        String str;
        v.d.a.b bVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.a) {
            v.d.a aVar = (v.d.a) obj;
            if (this.a.equals(aVar.c()) && this.f8872b.equals(aVar.f()) && ((str = this.f8873c) != null ? str.equals(aVar.b()) : aVar.b() == null) && ((bVar = this.f8874d) != null ? bVar.equals(aVar.e()) : aVar.e() == null)) {
                String str2 = this.f8875e;
                if (str2 == null) {
                    if (aVar.d() == null) {
                        return true;
                    }
                } else if (str2.equals(aVar.d())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.a
    public String f() {
        return this.f8872b;
    }

    public int hashCode() {
        int hashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8872b.hashCode()) * 1000003;
        String str = this.f8873c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        v.d.a.b bVar = this.f8874d;
        int hashCode3 = (hashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f8875e;
        return hashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.a + ", version=" + this.f8872b + ", displayVersion=" + this.f8873c + ", organization=" + this.f8874d + ", installationUuid=" + this.f8875e + "}";
    }

    private g(String str, String str2, String str3, v.d.a.b bVar, String str4) {
        this.a = str;
        this.f8872b = str2;
        this.f8873c = str3;
        this.f8874d = bVar;
        this.f8875e = str4;
    }
}