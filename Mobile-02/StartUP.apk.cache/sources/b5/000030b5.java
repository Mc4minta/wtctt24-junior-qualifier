package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.o;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class i extends o {
    private final o.c a;

    /* renamed from: b  reason: collision with root package name */
    private final o.b f5774b;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    static final class b extends o.a {
        private o.c a;

        /* renamed from: b  reason: collision with root package name */
        private o.b f5775b;

        @Override // com.google.android.datatransport.cct.b.o.a
        public o.a a(o.b bVar) {
            this.f5775b = bVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.o.a
        public o.a b(o.c cVar) {
            this.a = cVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.o.a
        public o c() {
            return new i(this.a, this.f5775b, null);
        }
    }

    /* synthetic */ i(o.c cVar, o.b bVar, a aVar) {
        this.a = cVar;
        this.f5774b = bVar;
    }

    @Override // com.google.android.datatransport.cct.b.o
    public o.b b() {
        return this.f5774b;
    }

    @Override // com.google.android.datatransport.cct.b.o
    public o.c c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o.c cVar = this.a;
            if (cVar != null ? cVar.equals(((i) obj).a) : ((i) obj).a == null) {
                o.b bVar = this.f5774b;
                if (bVar == null) {
                    if (((i) obj).f5774b == null) {
                        return true;
                    }
                } else if (bVar.equals(((i) obj).f5774b)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        o.c cVar = this.a;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        o.b bVar = this.f5774b;
        return hashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.f5774b + "}";
    }
}