package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.k;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class e extends k {
    private final k.b a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.datatransport.cct.b.a f5748b;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    static final class b extends k.a {
        private k.b a;

        /* renamed from: b  reason: collision with root package name */
        private com.google.android.datatransport.cct.b.a f5749b;

        @Override // com.google.android.datatransport.cct.b.k.a
        public k.a a(com.google.android.datatransport.cct.b.a aVar) {
            this.f5749b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.k.a
        public k.a b(k.b bVar) {
            this.a = bVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.k.a
        public k c() {
            return new e(this.a, this.f5749b, null);
        }
    }

    /* synthetic */ e(k.b bVar, com.google.android.datatransport.cct.b.a aVar, a aVar2) {
        this.a = bVar;
        this.f5748b = aVar;
    }

    @Override // com.google.android.datatransport.cct.b.k
    public com.google.android.datatransport.cct.b.a b() {
        return this.f5748b;
    }

    @Override // com.google.android.datatransport.cct.b.k
    public k.b c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k.b bVar = this.a;
            if (bVar != null ? bVar.equals(((e) obj).a) : ((e) obj).a == null) {
                com.google.android.datatransport.cct.b.a aVar = this.f5748b;
                if (aVar == null) {
                    if (((e) obj).f5748b == null) {
                        return true;
                    }
                } else if (aVar.equals(((e) obj).f5748b)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        k.b bVar = this.a;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        com.google.android.datatransport.cct.b.a aVar = this.f5748b;
        return hashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.f5748b + "}";
    }
}