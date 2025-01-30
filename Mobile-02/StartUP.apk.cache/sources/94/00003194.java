package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class j<L> {
    private final L a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6124b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return this.a == jVar.a && this.f6124b.equals(jVar.f6124b);
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * 31) + this.f6124b.hashCode();
    }
}