package com.facebook.react.common;

/* compiled from: ClearableSynchronizedPool.java */
/* loaded from: classes2.dex */
public class a<T> implements androidx.core.util.f<T> {
    private final Object[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f4785b = 0;

    public a(int i2) {
        this.a = new Object[i2];
    }

    public synchronized void a() {
        for (int i2 = 0; i2 < this.f4785b; i2++) {
            this.a[i2] = null;
        }
        this.f4785b = 0;
    }

    @Override // androidx.core.util.f
    public synchronized T acquire() {
        int i2 = this.f4785b;
        if (i2 == 0) {
            return null;
        }
        int i3 = i2 - 1;
        this.f4785b = i3;
        Object[] objArr = this.a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        return t;
    }

    @Override // androidx.core.util.f
    public synchronized boolean release(T t) {
        int i2 = this.f4785b;
        Object[] objArr = this.a;
        if (i2 == objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f4785b = i2 + 1;
        return true;
    }
}