package e.g.a.c.i;

import e.g.a.c.i.l;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class c extends l {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f12992b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.d f12993c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes2.dex */
    static final class b extends l.a {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f12994b;

        /* renamed from: c  reason: collision with root package name */
        private e.g.a.c.d f12995c;

        @Override // e.g.a.c.i.l.a
        public l a() {
            String str = "";
            if (this.a == null) {
                str = " backendName";
            }
            if (this.f12995c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.a, this.f12994b, this.f12995c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // e.g.a.c.i.l.a
        public l.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.a = str;
            return this;
        }

        @Override // e.g.a.c.i.l.a
        public l.a c(byte[] bArr) {
            this.f12994b = bArr;
            return this;
        }

        @Override // e.g.a.c.i.l.a
        public l.a d(e.g.a.c.d dVar) {
            Objects.requireNonNull(dVar, "Null priority");
            this.f12995c = dVar;
            return this;
        }
    }

    @Override // e.g.a.c.i.l
    public String b() {
        return this.a;
    }

    @Override // e.g.a.c.i.l
    public byte[] c() {
        return this.f12992b;
    }

    @Override // e.g.a.c.i.l
    public e.g.a.c.d d() {
        return this.f12993c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a.equals(lVar.b())) {
                if (Arrays.equals(this.f12992b, lVar instanceof c ? ((c) lVar).f12992b : lVar.c()) && this.f12993c.equals(lVar.d())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12992b)) * 1000003) ^ this.f12993c.hashCode();
    }

    private c(String str, byte[] bArr, e.g.a.c.d dVar) {
        this.a = str;
        this.f12992b = bArr;
        this.f12993c = dVar;
    }
}