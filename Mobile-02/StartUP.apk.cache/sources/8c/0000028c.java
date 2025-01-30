package androidx.core.util;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public interface f<T> {
    T acquire();

    boolean release(T t);
}