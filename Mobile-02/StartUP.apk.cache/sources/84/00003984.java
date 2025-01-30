package com.google.firebase.crashlytics.c.g;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final class c extends n {
    private final com.google.firebase.crashlytics.c.i.v a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8672b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.google.firebase.crashlytics.c.i.v vVar, String str) {
        Objects.requireNonNull(vVar, "Null report");
        this.a = vVar;
        Objects.requireNonNull(str, "Null sessionId");
        this.f8672b = str;
    }

    @Override // com.google.firebase.crashlytics.c.g.n
    public com.google.firebase.crashlytics.c.i.v b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.c.g.n
    public String c() {
        return this.f8672b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return this.a.equals(nVar.b()) && this.f8672b.equals(nVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f8672b.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.a + ", sessionId=" + this.f8672b + "}";
    }
}