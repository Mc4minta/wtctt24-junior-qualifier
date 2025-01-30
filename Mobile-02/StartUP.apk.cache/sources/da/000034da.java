package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class i2<T> extends g2<T> {
    private final T a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2(T t) {
        this.a = t;
    }

    @Override // com.google.android.gms.internal.measurement.g2
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.g2
    public final T c() {
        return this.a;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof i2) {
            return this.a.equals(((i2) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}