package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class l extends v.d.AbstractC0173d.a.b {
    private final w<v.d.AbstractC0173d.a.b.e> a;

    /* renamed from: b  reason: collision with root package name */
    private final v.d.AbstractC0173d.a.b.c f8910b;

    /* renamed from: c  reason: collision with root package name */
    private final v.d.AbstractC0173d.a.b.AbstractC0179d f8911c;

    /* renamed from: d  reason: collision with root package name */
    private final w<v.d.AbstractC0173d.a.b.AbstractC0175a> f8912d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public static final class b extends v.d.AbstractC0173d.a.b.AbstractC0177b {
        private w<v.d.AbstractC0173d.a.b.e> a;

        /* renamed from: b  reason: collision with root package name */
        private v.d.AbstractC0173d.a.b.c f8913b;

        /* renamed from: c  reason: collision with root package name */
        private v.d.AbstractC0173d.a.b.AbstractC0179d f8914c;

        /* renamed from: d  reason: collision with root package name */
        private w<v.d.AbstractC0173d.a.b.AbstractC0175a> f8915d;

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0177b
        public v.d.AbstractC0173d.a.b a() {
            String str = "";
            if (this.a == null) {
                str = " threads";
            }
            if (this.f8913b == null) {
                str = str + " exception";
            }
            if (this.f8914c == null) {
                str = str + " signal";
            }
            if (this.f8915d == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new l(this.a, this.f8913b, this.f8914c, this.f8915d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0177b
        public v.d.AbstractC0173d.a.b.AbstractC0177b b(w<v.d.AbstractC0173d.a.b.AbstractC0175a> wVar) {
            Objects.requireNonNull(wVar, "Null binaries");
            this.f8915d = wVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0177b
        public v.d.AbstractC0173d.a.b.AbstractC0177b c(v.d.AbstractC0173d.a.b.c cVar) {
            Objects.requireNonNull(cVar, "Null exception");
            this.f8913b = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0177b
        public v.d.AbstractC0173d.a.b.AbstractC0177b d(v.d.AbstractC0173d.a.b.AbstractC0179d abstractC0179d) {
            Objects.requireNonNull(abstractC0179d, "Null signal");
            this.f8914c = abstractC0179d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b.AbstractC0177b
        public v.d.AbstractC0173d.a.b.AbstractC0177b e(w<v.d.AbstractC0173d.a.b.e> wVar) {
            Objects.requireNonNull(wVar, "Null threads");
            this.a = wVar;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b
    public w<v.d.AbstractC0173d.a.b.AbstractC0175a> b() {
        return this.f8912d;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b
    public v.d.AbstractC0173d.a.b.c c() {
        return this.f8910b;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b
    public v.d.AbstractC0173d.a.b.AbstractC0179d d() {
        return this.f8911c;
    }

    @Override // com.google.firebase.crashlytics.c.i.v.d.AbstractC0173d.a.b
    public w<v.d.AbstractC0173d.a.b.e> e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0173d.a.b) {
            v.d.AbstractC0173d.a.b bVar = (v.d.AbstractC0173d.a.b) obj;
            return this.a.equals(bVar.e()) && this.f8910b.equals(bVar.c()) && this.f8911c.equals(bVar.d()) && this.f8912d.equals(bVar.b());
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8910b.hashCode()) * 1000003) ^ this.f8911c.hashCode()) * 1000003) ^ this.f8912d.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.a + ", exception=" + this.f8910b + ", signal=" + this.f8911c + ", binaries=" + this.f8912d + "}";
    }

    private l(w<v.d.AbstractC0173d.a.b.e> wVar, v.d.AbstractC0173d.a.b.c cVar, v.d.AbstractC0173d.a.b.AbstractC0179d abstractC0179d, w<v.d.AbstractC0173d.a.b.AbstractC0175a> wVar2) {
        this.a = wVar;
        this.f8910b = cVar;
        this.f8911c = abstractC0179d;
        this.f8912d = wVar2;
    }
}