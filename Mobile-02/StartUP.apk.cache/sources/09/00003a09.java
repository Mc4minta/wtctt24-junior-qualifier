package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class f extends v.d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8852b;

    /* renamed from: c  reason: collision with root package name */
    private final long f8853c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f8854d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f8855e;

    /* renamed from: f  reason: collision with root package name */
    private final v.d.a f8856f;

    /* renamed from: g  reason: collision with root package name */
    private final v.d.f f8857g;

    /* renamed from: h  reason: collision with root package name */
    private final v.d.e f8858h;

    /* renamed from: i  reason: collision with root package name */
    private final v.d.c f8859i;

    /* renamed from: j  reason: collision with root package name */
    private final w<v.d.AbstractC0173d> f8860j;

    /* renamed from: k  reason: collision with root package name */
    private final int f8861k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.b {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f8862b;

        /* renamed from: c  reason: collision with root package name */
        private Long f8863c;

        /* renamed from: d  reason: collision with root package name */
        private Long f8864d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f8865e;

        /* renamed from: f  reason: collision with root package name */
        private v.d.a f8866f;

        /* renamed from: g  reason: collision with root package name */
        private v.d.f f8867g;

        /* renamed from: h  reason: collision with root package name */
        private v.d.e f8868h;

        /* renamed from: i  reason: collision with root package name */
        private v.d.c f8869i;

        /* renamed from: j  reason: collision with root package name */
        private w<v.d.AbstractC0173d> f8870j;

        /* renamed from: k  reason: collision with root package name */
        private Integer f8871k;

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d a() {
            String str = "";
            if (this.a == null) {
                str = " generator";
            }
            if (this.f8862b == null) {
                str = str + " identifier";
            }
            if (this.f8863c == null) {
                str = str + " startedAt";
            }
            if (this.f8865e == null) {
                str = str + " crashed";
            }
            if (this.f8866f == null) {
                str = str + " app";
            }
            if (this.f8871k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new f(this.a, this.f8862b, this.f8863c.longValue(), this.f8864d, this.f8865e.booleanValue(), this.f8866f, this.f8867g, this.f8868h, this.f8869i, this.f8870j, this.f8871k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b b(v.d.a aVar) {
            Objects.requireNonNull(aVar, "Null app");
            this.f8866f = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b c(boolean z) {
            this.f8865e = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b d(v.d.c cVar) {
            this.f8869i = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b e(Long l2) {
            this.f8864d = l2;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b f(w<v.d.AbstractC0173d> wVar) {
            this.f8870j = wVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b g(String str) {
            Objects.requireNonNull(str, "Null generator");
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b h(int i2) {
            this.f8871k = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b i(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f8862b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b k(v.d.e eVar) {
            this.f8868h = eVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b l(long j2) {
            this.f8863c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.b
        public v.d.b m(v.d.f fVar) {
            this.f8867g = fVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(v.d dVar) {
            this.a = dVar.f();
            this.f8862b = dVar.h();
            this.f8863c = Long.valueOf(dVar.k());
            this.f8864d = dVar.d();
            this.f8865e = Boolean.valueOf(dVar.m());
            this.f8866f = dVar.b();
            this.f8867g = dVar.l();
            this.f8868h = dVar.j();
            this.f8869i = dVar.c();
            this.f8870j = dVar.e();
            this.f8871k = Integer.valueOf(dVar.g());
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public v.d.a b() {
        return this.f8856f;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public v.d.c c() {
        return this.f8859i;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public Long d() {
        return this.f8854d;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public w<v.d.AbstractC0173d> e() {
        return this.f8860j;
    }

    public boolean equals(Object obj) {
        Long l2;
        v.d.f fVar;
        v.d.e eVar;
        v.d.c cVar;
        w<v.d.AbstractC0173d> wVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d) {
            v.d dVar = (v.d) obj;
            return this.a.equals(dVar.f()) && this.f8852b.equals(dVar.h()) && this.f8853c == dVar.k() && ((l2 = this.f8854d) != null ? l2.equals(dVar.d()) : dVar.d() == null) && this.f8855e == dVar.m() && this.f8856f.equals(dVar.b()) && ((fVar = this.f8857g) != null ? fVar.equals(dVar.l()) : dVar.l() == null) && ((eVar = this.f8858h) != null ? eVar.equals(dVar.j()) : dVar.j() == null) && ((cVar = this.f8859i) != null ? cVar.equals(dVar.c()) : dVar.c() == null) && ((wVar = this.f8860j) != null ? wVar.equals(dVar.e()) : dVar.e() == null) && this.f8861k == dVar.g();
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public String f() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public int g() {
        return this.f8861k;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public String h() {
        return this.f8852b;
    }

    public int hashCode() {
        long j2 = this.f8853c;
        int hashCode = (((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8852b.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        Long l2 = this.f8854d;
        int hashCode2 = (((((hashCode ^ (l2 == null ? 0 : l2.hashCode())) * 1000003) ^ (this.f8855e ? 1231 : 1237)) * 1000003) ^ this.f8856f.hashCode()) * 1000003;
        v.d.f fVar = this.f8857g;
        int hashCode3 = (hashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        v.d.e eVar = this.f8858h;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        v.d.c cVar = this.f8859i;
        int hashCode5 = (hashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        w<v.d.AbstractC0173d> wVar = this.f8860j;
        return ((hashCode5 ^ (wVar != null ? wVar.hashCode() : 0)) * 1000003) ^ this.f8861k;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public v.d.e j() {
        return this.f8858h;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public long k() {
        return this.f8853c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public v.d.f l() {
        return this.f8857g;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public boolean m() {
        return this.f8855e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d
    public v.d.b n() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.a + ", identifier=" + this.f8852b + ", startedAt=" + this.f8853c + ", endedAt=" + this.f8854d + ", crashed=" + this.f8855e + ", app=" + this.f8856f + ", user=" + this.f8857g + ", os=" + this.f8858h + ", device=" + this.f8859i + ", events=" + this.f8860j + ", generatorType=" + this.f8861k + "}";
    }

    private f(String str, String str2, long j2, Long l2, boolean z, v.d.a aVar, v.d.f fVar, v.d.e eVar, v.d.c cVar, w<v.d.AbstractC0173d> wVar, int i2) {
        this.a = str;
        this.f8852b = str2;
        this.f8853c = j2;
        this.f8854d = l2;
        this.f8855e = z;
        this.f8856f = aVar;
        this.f8857g = fVar;
        this.f8858h = eVar;
        this.f8859i = cVar;
        this.f8860j = wVar;
        this.f8861k = i2;
    }
}