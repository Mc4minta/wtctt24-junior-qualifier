package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class j extends v.d.AbstractC0173d {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8896b;

    /* renamed from: c  reason: collision with root package name */
    private final v.d.AbstractC0173d.a f8897c;

    /* renamed from: d  reason: collision with root package name */
    private final v.d.AbstractC0173d.c f8898d;

    /* renamed from: e  reason: collision with root package name */
    private final v.d.AbstractC0173d.AbstractC0184d f8899e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.b {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private String f8900b;

        /* renamed from: c  reason: collision with root package name */
        private v.d.AbstractC0173d.a f8901c;

        /* renamed from: d  reason: collision with root package name */
        private v.d.AbstractC0173d.c f8902d;

        /* renamed from: e  reason: collision with root package name */
        private v.d.AbstractC0173d.AbstractC0184d f8903e;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.b
        public v.d.AbstractC0173d a() {
            String str = "";
            if (this.a == null) {
                str = " timestamp";
            }
            if (this.f8900b == null) {
                str = str + " type";
            }
            if (this.f8901c == null) {
                str = str + " app";
            }
            if (this.f8902d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new j(this.a.longValue(), this.f8900b, this.f8901c, this.f8902d, this.f8903e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.b
        public v.d.AbstractC0173d.b b(v.d.AbstractC0173d.a aVar) {
            Objects.requireNonNull(aVar, "Null app");
            this.f8901c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.b
        public v.d.AbstractC0173d.b c(v.d.AbstractC0173d.c cVar) {
            Objects.requireNonNull(cVar, "Null device");
            this.f8902d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.b
        public v.d.AbstractC0173d.b d(v.d.AbstractC0173d.AbstractC0184d abstractC0184d) {
            this.f8903e = abstractC0184d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.b
        public v.d.AbstractC0173d.b e(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.b
        public v.d.AbstractC0173d.b f(String str) {
            Objects.requireNonNull(str, "Null type");
            this.f8900b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(v.d.AbstractC0173d abstractC0173d) {
            this.a = Long.valueOf(abstractC0173d.e());
            this.f8900b = abstractC0173d.f();
            this.f8901c = abstractC0173d.b();
            this.f8902d = abstractC0173d.c();
            this.f8903e = abstractC0173d.d();
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d
    public v.d.AbstractC0173d.a b() {
        return this.f8897c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d
    public v.d.AbstractC0173d.c c() {
        return this.f8898d;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d
    public v.d.AbstractC0173d.AbstractC0184d d() {
        return this.f8899e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d) {
            v.d.AbstractC0173d abstractC0173d = (v.d.AbstractC0173d) obj;
            if (this.a == abstractC0173d.e() && this.f8896b.equals(abstractC0173d.f()) && this.f8897c.equals(abstractC0173d.b()) && this.f8898d.equals(abstractC0173d.c())) {
                v.d.AbstractC0173d.AbstractC0184d abstractC0184d = this.f8899e;
                if (abstractC0184d == null) {
                    if (abstractC0173d.d() == null) {
                        return true;
                    }
                } else if (abstractC0184d.equals(abstractC0173d.d())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d
    public String f() {
        return this.f8896b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d
    public v.d.AbstractC0173d.b g() {
        return new b(this);
    }

    public int hashCode() {
        long j2 = this.a;
        int hashCode = (((((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f8896b.hashCode()) * 1000003) ^ this.f8897c.hashCode()) * 1000003) ^ this.f8898d.hashCode()) * 1000003;
        v.d.AbstractC0173d.AbstractC0184d abstractC0184d = this.f8899e;
        return hashCode ^ (abstractC0184d == null ? 0 : abstractC0184d.hashCode());
    }

    public String toString() {
        return "Event{timestamp=" + this.a + ", type=" + this.f8896b + ", app=" + this.f8897c + ", device=" + this.f8898d + ", log=" + this.f8899e + "}";
    }

    private j(long j2, String str, v.d.AbstractC0173d.a aVar, v.d.AbstractC0173d.c cVar, v.d.AbstractC0173d.AbstractC0184d abstractC0184d) {
        this.a = j2;
        this.f8896b = str;
        this.f8897c = aVar;
        this.f8898d = cVar;
        this.f8899e = abstractC0184d;
    }
}