package com.google.firebase.crashlytics.c.i;

import com.google.firebase.crashlytics.c.i.v;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class h extends v.d.a.b {
    private final String a;

    @Override // com.google.firebase.crashlytics.c.i.v.d.a.b
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.a.b) {
            return this.a.equals(((v.d.a.b) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.a + "}";
    }
}