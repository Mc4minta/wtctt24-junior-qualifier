package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class p extends v.d.AbstractC0173d.a.b.e {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8934b;

    /* renamed from: c  reason: collision with root package name */
    private final w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> f8935c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.b.e.AbstractC0181a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f8936b;

        /* renamed from: c  reason: collision with root package name */
        private w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> f8937c;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0181a
        public v.d.AbstractC0173d.a.b.e a() {
            String str = "";
            if (this.a == null) {
                str = " name";
            }
            if (this.f8936b == null) {
                str = str + " importance";
            }
            if (this.f8937c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new p(this.a, this.f8936b.intValue(), this.f8937c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0181a
        public v.d.AbstractC0173d.a.b.e.AbstractC0181a b(w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> wVar) {
            Objects.requireNonNull(wVar, "Null frames");
            this.f8937c = wVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0181a
        public v.d.AbstractC0173d.a.b.e.AbstractC0181a c(int i2) {
            this.f8936b = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e.AbstractC0181a
        public v.d.AbstractC0173d.a.b.e.AbstractC0181a d(String str) {
            Objects.requireNonNull(str, "Null name");
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e
    public w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> b() {
        return this.f8935c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e
    public int c() {
        return this.f8934b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.e
    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a.b.e) {
            v.d.AbstractC0173d.a.b.e eVar = (v.d.AbstractC0173d.a.b.e) obj;
            return this.a.equals(eVar.d()) && this.f8934b == eVar.c() && this.f8935c.equals(eVar.b());
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8934b) * 1000003) ^ this.f8935c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.a + ", importance=" + this.f8934b + ", frames=" + this.f8935c + "}";
    }

    private p(String str, int i2, w<v.d.AbstractC0173d.a.b.e.AbstractC0182b> wVar) {
        this.a = str;
        this.f8934b = i2;
        this.f8935c = wVar;
    }
}