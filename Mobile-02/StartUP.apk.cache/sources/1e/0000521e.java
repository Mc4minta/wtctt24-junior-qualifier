package kotlin.j0;

import kotlin.j0.m;

/* compiled from: KProperty.kt */
/* loaded from: classes3.dex */
public interface n<V> extends m<V>, kotlin.e0.c.a<V> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes3.dex */
    public interface a<V> extends m.b<V>, kotlin.e0.c.a<V> {
    }

    V get();

    Object getDelegate();

    @Override // kotlin.j0.m
    a<V> getGetter();
}