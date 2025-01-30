package e.g.a.c.i;

import e.g.a.c.i.k;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class b extends k {
    private final l a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12984b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.c<?> f12985c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.e<?, byte[]> f12986d;

    /* renamed from: e  reason: collision with root package name */
    private final e.g.a.c.b f12987e;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: e.g.a.c.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0295b extends k.a {
        private l a;

        /* renamed from: b  reason: collision with root package name */
        private String f12988b;

        /* renamed from: c  reason: collision with root package name */
        private e.g.a.c.c<?> f12989c;

        /* renamed from: d  reason: collision with root package name */
        private e.g.a.c.e<?, byte[]> f12990d;

        /* renamed from: e  reason: collision with root package name */
        private e.g.a.c.b f12991e;

        @Override // e.g.a.c.i.k.a
        public k a() {
            String str = "";
            if (this.a == null) {
                str = " transportContext";
            }
            if (this.f12988b == null) {
                str = str + " transportName";
            }
            if (this.f12989c == null) {
                str = str + " event";
            }
            if (this.f12990d == null) {
                str = str + " transformer";
            }
            if (this.f12991e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.a, this.f12988b, this.f12989c, this.f12990d, this.f12991e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e.g.a.c.i.k.a
        k.a b(e.g.a.c.b bVar) {
            Objects.requireNonNull(bVar, "Null encoding");
            this.f12991e = bVar;
            return this;
        }

        @Override // e.g.a.c.i.k.a
        k.a c(e.g.a.c.c<?> cVar) {
            Objects.requireNonNull(cVar, "Null event");
            this.f12989c = cVar;
            return this;
        }

        @Override // e.g.a.c.i.k.a
        k.a d(e.g.a.c.e<?, byte[]> eVar) {
            Objects.requireNonNull(eVar, "Null transformer");
            this.f12990d = eVar;
            return this;
        }

        @Override // e.g.a.c.i.k.a
        public k.a e(l lVar) {
            Objects.requireNonNull(lVar, "Null transportContext");
            this.a = lVar;
            return this;
        }

        @Override // e.g.a.c.i.k.a
        public k.a f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f12988b = str;
            return this;
        }
    }

    @Override // e.g.a.c.i.k
    public e.g.a.c.b b() {
        return this.f12987e;
    }

    @Override // e.g.a.c.i.k
    e.g.a.c.c<?> c() {
        return this.f12985c;
    }

    @Override // e.g.a.c.i.k
    e.g.a.c.e<?, byte[]> e() {
        return this.f12986d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.a.equals(kVar.f()) && this.f12984b.equals(kVar.g()) && this.f12985c.equals(kVar.c()) && this.f12986d.equals(kVar.e()) && this.f12987e.equals(kVar.b());
        }
        return false;
    }

    @Override // e.g.a.c.i.k
    public l f() {
        return this.a;
    }

    @Override // e.g.a.c.i.k
    public String g() {
        return this.f12984b;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f12984b.hashCode()) * 1000003) ^ this.f12985c.hashCode()) * 1000003) ^ this.f12986d.hashCode()) * 1000003) ^ this.f12987e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.f12984b + ", event=" + this.f12985c + ", transformer=" + this.f12986d + ", encoding=" + this.f12987e + "}";
    }

    private b(l lVar, String str, e.g.a.c.c<?> cVar, e.g.a.c.e<?, byte[]> eVar, e.g.a.c.b bVar) {
        this.a = lVar;
        this.f12984b = str;
        this.f12985c = cVar;
        this.f12986d = eVar;
        this.f12987e = bVar;
    }
}