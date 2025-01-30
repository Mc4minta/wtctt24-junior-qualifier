package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class m extends v.d.AbstractC0173d.a.b.AbstractC0175a {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final long f8916b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8917c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8918d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private Long f8919b;

        /* renamed from: c  reason: collision with root package name */
        private String f8920c;

        /* renamed from: d  reason: collision with root package name */
        private String f8921d;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a
        public v.d.AbstractC0173d.a.b.AbstractC0175a a() {
            String str = "";
            if (this.a == null) {
                str = " baseAddress";
            }
            if (this.f8919b == null) {
                str = str + " size";
            }
            if (this.f8920c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new m(this.a.longValue(), this.f8919b.longValue(), this.f8920c, this.f8921d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a
        public v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a
        public v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a c(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f8920c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a
        public v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a d(long j2) {
            this.f8919b = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a
        public v.d.AbstractC0173d.a.b.AbstractC0175a.AbstractC0176a e(String str) {
            this.f8921d = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a
    public long b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a
    public String c() {
        return this.f8917c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a
    public long d() {
        return this.f8916b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0175a
    public String e() {
        return this.f8918d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a.b.AbstractC0175a) {
            v.d.AbstractC0173d.a.b.AbstractC0175a abstractC0175a = (v.d.AbstractC0173d.a.b.AbstractC0175a) obj;
            if (this.a == abstractC0175a.b() && this.f8916b == abstractC0175a.d() && this.f8917c.equals(abstractC0175a.c())) {
                String str = this.f8918d;
                if (str == null) {
                    if (abstractC0175a.e() == null) {
                        return true;
                    }
                } else if (str.equals(abstractC0175a.e())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f8916b;
        int hashCode = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f8917c.hashCode()) * 1000003;
        String str = this.f8918d;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.a + ", size=" + this.f8916b + ", name=" + this.f8917c + ", uuid=" + this.f8918d + "}";
    }

    private m(long j2, long j3, String str, String str2) {
        this.a = j2;
        this.f8916b = j3;
        this.f8917c = str;
        this.f8918d = str2;
    }
}