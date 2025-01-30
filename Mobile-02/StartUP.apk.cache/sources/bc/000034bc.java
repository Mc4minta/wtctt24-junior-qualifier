package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class g2<T> implements Serializable {
    public static <T> g2<T> a(T t) {
        return new i2(j2.a(t));
    }

    public static <T> g2<T> d() {
        return e2.a;
    }

    public abstract boolean b();

    public abstract T c();
}