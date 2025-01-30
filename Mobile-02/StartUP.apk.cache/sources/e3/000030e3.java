package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.g;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class c extends g {
    private final e.g.a.c.i.w.a a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<e.g.a.c.d, g.b> f5833b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e.g.a.c.i.w.a aVar, Map<e.g.a.c.d, g.b> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.f5833b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g
    e.g.a.c.i.w.a d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.a.equals(gVar.d()) && this.f5833b.equals(gVar.g());
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.g
    Map<e.g.a.c.d, g.b> g() {
        return this.f5833b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f5833b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.f5833b + "}";
    }
}