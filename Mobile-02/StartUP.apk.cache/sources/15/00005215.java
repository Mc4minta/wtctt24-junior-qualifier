package kotlin.j0;

import kotlin.j0.h;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface j<T, V> extends o<T, V>, h<V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<T, V> extends h.a<V>, kotlin.e0.c.p<T, V, kotlin.x> {
    }

    @Override // kotlin.j0.h
    a<T, V> getSetter();

    void set(T t, V v);
}