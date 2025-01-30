package kotlin.j0;

import kotlin.j0.m;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface o<T, V> extends m<V>, kotlin.e0.c.l<T, V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<T, V> extends m.b<V>, kotlin.e0.c.l<T, V> {
    }

    V get(T t);

    Object getDelegate(T t);

    @Override // kotlin.j0.m
    a<T, V> getGetter();
}