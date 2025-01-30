package e.g.a.c.i;

import e.g.a.c.i.h;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class a extends h {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f12974b;

    /* renamed from: c  reason: collision with root package name */
    private final g f12975c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12976d;

    /* renamed from: e  reason: collision with root package name */
    private final long f12977e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f12978f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b extends h.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f12979b;

        /* renamed from: c  reason: collision with root package name */
        private g f12980c;

        /* renamed from: d  reason: collision with root package name */
        private Long f12981d;

        /* renamed from: e  reason: collision with root package name */
        private Long f12982e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f12983f;

        @Override // e.g.a.c.i.h.a
        public h d() {
            String str = "";
            if (this.a == null) {
                str = " transportName";
            }
            if (this.f12980c == null) {
                str = str + " encodedPayload";
            }
            if (this.f12981d == null) {
                str = str + " eventMillis";
            }
            if (this.f12982e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f12983f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.a, this.f12979b, this.f12980c, this.f12981d.longValue(), this.f12982e.longValue(), this.f12983f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e.g.a.c.i.h.a
        protected Map<String, String> e() {
            Map<String, String> map = this.f12983f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.g.a.c.i.h.a
        public h.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f12983f = map;
            return this;
        }

        @Override // e.g.a.c.i.h.a
        public h.a g(Integer num) {
            this.f12979b = num;
            return this;
        }

        @Override // e.g.a.c.i.h.a
        public h.a h(g gVar) {
            Objects.requireNonNull(gVar, "Null encodedPayload");
            this.f12980c = gVar;
            return this;
        }

        @Override // e.g.a.c.i.h.a
        public h.a i(long j2) {
            this.f12981d = Long.valueOf(j2);
            return this;
        }

        @Override // e.g.a.c.i.h.a
        public h.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        @Override // e.g.a.c.i.h.a
        public h.a k(long j2) {
            this.f12982e = Long.valueOf(j2);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.g.a.c.i.h
    public Map<String, String> c() {
        return this.f12978f;
    }

    @Override // e.g.a.c.i.h
    public Integer d() {
        return this.f12974b;
    }

    @Override // e.g.a.c.i.h
    public g e() {
        return this.f12975c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.a.equals(hVar.j()) && ((num = this.f12974b) != null ? num.equals(hVar.d()) : hVar.d() == null) && this.f12975c.equals(hVar.e()) && this.f12976d == hVar.f() && this.f12977e == hVar.k() && this.f12978f.equals(hVar.c());
        }
        return false;
    }

    @Override // e.g.a.c.i.h
    public long f() {
        return this.f12976d;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f12974b;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j2 = this.f12976d;
        long j3 = this.f12977e;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.f12975c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f12978f.hashCode();
    }

    @Override // e.g.a.c.i.h
    public String j() {
        return this.a;
    }

    @Override // e.g.a.c.i.h
    public long k() {
        return this.f12977e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.f12974b + ", encodedPayload=" + this.f12975c + ", eventMillis=" + this.f12976d + ", uptimeMillis=" + this.f12977e + ", autoMetadata=" + this.f12978f + "}";
    }

    private a(String str, Integer num, g gVar, long j2, long j3, Map<String, String> map) {
        this.a = str;
        this.f12974b = num;
        this.f12975c = gVar;
        this.f12976d = j2;
        this.f12977e = j3;
        this.f12978f = map;
    }
}