package c.f.b;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
interface f<T> {
    void a(T[] tArr, int i2);

    T acquire();

    boolean release(T t);
}