package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;

/* compiled from: Ordering.java */
/* loaded from: classes2.dex */
public abstract class z<T> implements Comparator<T> {
    public static <T> z<T> a(Comparator<T> comparator) {
        return comparator instanceof z ? (z) comparator : new f(comparator);
    }

    public <F> z<F> b(com.google.common.base.f<F, ? extends T> fVar) {
        return new c(fVar, this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(T t, T t2);
}