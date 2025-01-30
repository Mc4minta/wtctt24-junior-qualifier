package com.facebook.common.references;

import java.lang.ref.SoftReference;

/* compiled from: OOMSoftReference.java */
/* loaded from: classes2.dex */
public class b<T> {
    SoftReference<T> a = null;

    /* renamed from: b  reason: collision with root package name */
    SoftReference<T> f4502b = null;

    /* renamed from: c  reason: collision with root package name */
    SoftReference<T> f4503c = null;

    public void a() {
        SoftReference<T> softReference = this.a;
        if (softReference != null) {
            softReference.clear();
            this.a = null;
        }
        SoftReference<T> softReference2 = this.f4502b;
        if (softReference2 != null) {
            softReference2.clear();
            this.f4502b = null;
        }
        SoftReference<T> softReference3 = this.f4503c;
        if (softReference3 != null) {
            softReference3.clear();
            this.f4503c = null;
        }
    }

    public T b() {
        SoftReference<T> softReference = this.a;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void c(T t) {
        this.a = new SoftReference<>(t);
        this.f4502b = new SoftReference<>(t);
        this.f4503c = new SoftReference<>(t);
    }
}