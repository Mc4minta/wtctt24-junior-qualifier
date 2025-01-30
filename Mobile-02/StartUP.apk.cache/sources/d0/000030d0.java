package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.g;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class b extends g {
    private final g.a a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5814b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g.a aVar, long j2) {
        Objects.requireNonNull(aVar, "Null status");
        this.a = aVar;
        this.f5814b = j2;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public long b() {
        return this.f5814b;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public g.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.a.equals(gVar.c()) && this.f5814b == gVar.b();
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f5814b;
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.f5814b + "}";
    }
}