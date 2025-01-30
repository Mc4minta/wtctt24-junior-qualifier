package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class l2 {
    public static <T> m2<T> a(m2<T> m2Var) {
        if ((m2Var instanceof n2) || (m2Var instanceof o2)) {
            return m2Var;
        }
        if (m2Var instanceof Serializable) {
            return new o2(m2Var);
        }
        return new n2(m2Var);
    }

    public static <T> m2<T> b(@NullableDecl T t) {
        return new q2(t);
    }
}