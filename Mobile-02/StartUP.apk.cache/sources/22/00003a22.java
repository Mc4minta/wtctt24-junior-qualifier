package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class o extends v.d.AbstractC0173d.a.b.AbstractC0179d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8930b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8931c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f8932b;

        /* renamed from: c  reason: collision with root package name */
        private Long f8933c;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a
        public v.d.AbstractC0173d.a.b.AbstractC0179d a() {
            String str = "";
            if (this.a == null) {
                str = " name";
            }
            if (this.f8932b == null) {
                str = str + " code";
            }
            if (this.f8933c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new o(this.a, this.f8932b, this.f8933c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a
        public v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a b(long j2) {
            this.f8933c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a
        public v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a c(String str) {
            Objects.requireNonNull(str, "Null code");
            this.f8932b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a
        public v.d.AbstractC0173d.a.b.AbstractC0179d.AbstractC0180a d(String str) {
            Objects.requireNonNull(str, "Null name");
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d
    public long b() {
        return this.f8931c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d
    public String c() {
        return this.f8930b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0179d
    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a.b.AbstractC0179d) {
            v.d.AbstractC0173d.a.b.AbstractC0179d abstractC0179d = (v.d.AbstractC0173d.a.b.AbstractC0179d) obj;
            return this.a.equals(abstractC0179d.d()) && this.f8930b.equals(abstractC0179d.c()) && this.f8931c == abstractC0179d.b();
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f8931c;
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8930b.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.a + ", code=" + this.f8930b + ", address=" + this.f8931c + "}";
    }

    private o(String str, String str2, long j2) {
        this.a = str;
        this.f8930b = str2;
        this.f8931c = j2;
    }
}