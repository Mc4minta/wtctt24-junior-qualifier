package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class n extends v.d.AbstractC0173d.a.b.c {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8922b;

    /* renamed from: c  reason: collision with root package name */
    private final w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> f8923c;

    /* renamed from: d  reason: collision with root package name */
    private final v.d.AbstractC0173d.a.b.c f8924d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8925e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.b.c.AbstractC0178a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private String f8926b;

        /* renamed from: c  reason: collision with root package name */
        private w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> f8927c;

        /* renamed from: d  reason: collision with root package name */
        private v.d.AbstractC0173d.a.b.c f8928d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f8929e;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c.AbstractC0178a
        public v.d.AbstractC0173d.a.b.c a() {
            String str = "";
            if (this.a == null) {
                str = " type";
            }
            if (this.f8927c == null) {
                str = str + " frames";
            }
            if (this.f8929e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new n(this.a, this.f8926b, this.f8927c, this.f8928d, this.f8929e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c.AbstractC0178a
        public v.d.AbstractC0173d.a.b.c.AbstractC0178a b(v.d.AbstractC0173d.a.b.c cVar) {
            this.f8928d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c.AbstractC0178a
        public v.d.AbstractC0173d.a.b.c.AbstractC0178a c(w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> wVar) {
            Objects.requireNonNull(wVar, "Null frames");
            this.f8927c = wVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c.AbstractC0178a
        public v.d.AbstractC0173d.a.b.c.AbstractC0178a d(int i2) {
            this.f8929e = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c.AbstractC0178a
        public v.d.AbstractC0173d.a.b.c.AbstractC0178a e(String str) {
            this.f8926b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c.AbstractC0178a
        public v.d.AbstractC0173d.a.b.c.AbstractC0178a f(String str) {
            Objects.requireNonNull(str, "Null type");
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c
    public v.d.AbstractC0173d.a.b.c b() {
        return this.f8924d;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c
    public w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> c() {
        return this.f8923c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c
    public int d() {
        return this.f8925e;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c
    public String e() {
        return this.f8922b;
    }

    public boolean equals(Object obj) {
        String str;
        v.d.AbstractC0173d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a.b.c) {
            v.d.AbstractC0173d.a.b.c cVar2 = (v.d.AbstractC0173d.a.b.c) obj;
            return this.a.equals(cVar2.f()) && ((str = this.f8922b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f8923c.equals(cVar2.c()) && ((cVar = this.f8924d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f8925e == cVar2.d();
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.c
    public String f() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f8922b;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f8923c.hashCode()) * 1000003;
        v.d.AbstractC0173d.a.b.c cVar = this.f8924d;
        return ((hashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f8925e;
    }

    public String toString() {
        return "Exception{type=" + this.a + ", reason=" + this.f8922b + ", frames=" + this.f8923c + ", causedBy=" + this.f8924d + ", overflowCount=" + this.f8925e + "}";
    }

    private n(String str, String str2, w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> wVar, v.d.AbstractC0173d.a.b.c cVar, int i2) {
        this.a = str;
        this.f8922b = str2;
        this.f8923c = wVar;
        this.f8924d = cVar;
        this.f8925e = i2;
    }
}