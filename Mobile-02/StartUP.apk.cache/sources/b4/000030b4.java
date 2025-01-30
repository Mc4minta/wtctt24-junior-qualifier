package com.google.android.datatransport.cct.b;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class h extends n {
    private final long a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(long j2) {
        this.a = j2;
    }

    @Override // com.google.android.datatransport.cct.b.n
    public long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.a == ((n) obj).a();
    }

    public int hashCode() {
        long j2 = this.a;
        return ((int) (j2 ^ (j2 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}