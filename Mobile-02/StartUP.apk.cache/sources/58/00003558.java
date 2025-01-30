package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
final class q2<T> implements m2<T>, Serializable {
    @NullableDecl
    private final T a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(@NullableDecl T t) {
        this.a = t;
    }

    @Override // com.google.android.gms.internal.measurement.m2
    public final T a() {
        return this.a;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof q2) {
            T t = this.a;
            T t2 = ((q2) obj).a;
            if (t != t2) {
                return t != null && t.equals(t2);
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}