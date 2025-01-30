package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class q extends v.d.AbstractC0173d.a.b.e.AbstractC0182b {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8938b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8939c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8940d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8941e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private String f8942b;

        /* renamed from: c  reason: collision with root package name */
        private String f8943c;

        /* renamed from: d  reason: collision with root package name */
        private Long f8944d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f8945e;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a
        public v.d.AbstractC0173d.a.b.e.AbstractC0182b a() {
            String str = "";
            if (this.a == null) {
                str = " pc";
            }
            if (this.f8942b == null) {
                str = str + " symbol";
            }
            if (this.f8944d == null) {
                str = str + " offset";
            }
            if (this.f8945e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new q(this.a.longValue(), this.f8942b, this.f8943c, this.f8944d.longValue(), this.f8945e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a
        public v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a b(String str) {
            this.f8943c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a
        public v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a c(int i2) {
            this.f8945e = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a
        public v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a d(long j2) {
            this.f8944d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a
        public v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a e(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a
        public v.d.AbstractC0173d.a.b.e.AbstractC0182b.AbstractC0183a f(String str) {
            Objects.requireNonNull(str, "Null symbol");
            this.f8942b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b
    public String b() {
        return this.f8939c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b
    public int c() {
        return this.f8941e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b
    public long d() {
        return this.f8940d;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a.b.e.AbstractC0182b) {
            v.d.AbstractC0173d.a.b.e.AbstractC0182b abstractC0182b = (v.d.AbstractC0173d.a.b.e.AbstractC0182b) obj;
            return this.a == abstractC0182b.e() && this.f8938b.equals(abstractC0182b.f()) && ((str = this.f8939c) != null ? str.equals(abstractC0182b.b()) : abstractC0182b.b() == null) && this.f8940d == abstractC0182b.d() && this.f8941e == abstractC0182b.c();
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0182b
    public String f() {
        return this.f8938b;
    }

    public int hashCode() {
        long j2 = this.a;
        int hashCode = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f8938b.hashCode()) * 1000003;
        String str = this.f8939c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.f8940d;
        return ((((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f8941e;
    }

    public String toString() {
        return "Frame{pc=" + this.a + ", symbol=" + this.f8938b + ", file=" + this.f8939c + ", offset=" + this.f8940d + ", importance=" + this.f8941e + "}";
    }

    private q(long j2, String str, String str2, long j3, int i2) {
        this.a = j2;
        this.f8938b = str;
        this.f8939c = str2;
        this.f8940d = j3;
        this.f8941e = i2;
    }
}