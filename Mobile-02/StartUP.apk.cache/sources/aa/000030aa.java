package com.google.android.datatransport.cct.b;

import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class d extends j {
    private final List<m> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<m> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    @Override // com.google.android.datatransport.cct.b.j
    public List<m> b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.a.equals(((j) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.a + "}";
    }
}