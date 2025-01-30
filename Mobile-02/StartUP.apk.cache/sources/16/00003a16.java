package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class k extends v.d.AbstractC0173d.a {
    private final v.d.AbstractC0173d.a.b a;

    /* renamed from: b  reason: collision with root package name */
    private final w<v.b> f8904b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f8905c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8906d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.AbstractC0174a {
        private v.d.AbstractC0173d.a.b a;

        /* renamed from: b  reason: collision with root package name */
        private w<v.b> f8907b;

        /* renamed from: c  reason: collision with root package name */
        private Boolean f8908c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f8909d;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.AbstractC0174a
        public v.d.AbstractC0173d.a a() {
            String str = "";
            if (this.a == null) {
                str = " execution";
            }
            if (this.f8909d == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new k(this.a, this.f8907b, this.f8908c, this.f8909d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.AbstractC0174a
        public v.d.AbstractC0173d.a.AbstractC0174a b(Boolean bool) {
            this.f8908c = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.AbstractC0174a
        public v.d.AbstractC0173d.a.AbstractC0174a c(w<v.b> wVar) {
            this.f8907b = wVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.AbstractC0174a
        public v.d.AbstractC0173d.a.AbstractC0174a d(v.d.AbstractC0173d.a.b bVar) {
            Objects.requireNonNull(bVar, "Null execution");
            this.a = bVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.AbstractC0174a
        public v.d.AbstractC0173d.a.AbstractC0174a e(int i2) {
            this.f8909d = Integer.valueOf(i2);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(v.d.AbstractC0173d.a aVar) {
            this.a = aVar.d();
            this.f8907b = aVar.c();
            this.f8908c = aVar.b();
            this.f8909d = Integer.valueOf(aVar.e());
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a
    public Boolean b() {
        return this.f8905c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a
    public w<v.b> c() {
        return this.f8904b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a
    public v.d.AbstractC0173d.a.b d() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a
    public int e() {
        return this.f8906d;
    }

    public boolean equals(Object obj) {
        w<v.b> wVar;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a) {
            v.d.AbstractC0173d.a aVar = (v.d.AbstractC0173d.a) obj;
            return this.a.equals(aVar.d()) && ((wVar = this.f8904b) != null ? wVar.equals(aVar.c()) : aVar.c() == null) && ((bool = this.f8905c) != null ? bool.equals(aVar.b()) : aVar.b() == null) && this.f8906d == aVar.e();
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a
    public v.d.AbstractC0173d.a.AbstractC0174a f() {
        return new b(this);
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        w<v.b> wVar = this.f8904b;
        int hashCode2 = (hashCode ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        Boolean bool = this.f8905c;
        return ((hashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f8906d;
    }

    public String toString() {
        return "Application{execution=" + this.a + ", customAttributes=" + this.f8904b + ", background=" + this.f8905c + ", uiOrientation=" + this.f8906d + "}";
    }

    private k(v.d.AbstractC0173d.a.b bVar, w<v.b> wVar, Boolean bool, int i2) {
        this.a = bVar;
        this.f8904b = wVar;
        this.f8905c = bool;
        this.f8906d = i2;
    }
}