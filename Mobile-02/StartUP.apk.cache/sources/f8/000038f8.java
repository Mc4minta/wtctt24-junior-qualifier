package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.collect.v;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MapMaker.java */
/* loaded from: classes2.dex */
public final class u {
    boolean a;

    /* renamed from: b  reason: collision with root package name */
    int f8504b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f8505c = -1;

    /* renamed from: d  reason: collision with root package name */
    v.n f8506d;

    /* renamed from: e  reason: collision with root package name */
    v.n f8507e;

    /* renamed from: f  reason: collision with root package name */
    com.google.common.base.d<Object> f8508f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i2 = this.f8505c;
        if (i2 == -1) {
            return 4;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i2 = this.f8504b;
        if (i2 == -1) {
            return 16;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.common.base.d<Object> c() {
        return (com.google.common.base.d) com.google.common.base.h.a(this.f8508f, d().h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v.n d() {
        return (v.n) com.google.common.base.h.a(this.f8506d, v.n.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v.n e() {
        return (v.n) com.google.common.base.h.a(this.f8507e, v.n.a);
    }

    public <K, V> ConcurrentMap<K, V> f() {
        if (!this.a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        return v.b(this);
    }

    u g(v.n nVar) {
        v.n nVar2 = this.f8506d;
        com.google.common.base.l.q(nVar2 == null, "Key strength was already set to %s", nVar2);
        this.f8506d = (v.n) com.google.common.base.l.i(nVar);
        if (nVar != v.n.a) {
            this.a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public u h() {
        return g(v.n.f8538b);
    }

    public String toString() {
        h.b b2 = com.google.common.base.h.b(this);
        int i2 = this.f8504b;
        if (i2 != -1) {
            b2.a("initialCapacity", i2);
        }
        int i3 = this.f8505c;
        if (i3 != -1) {
            b2.a("concurrencyLevel", i3);
        }
        v.n nVar = this.f8506d;
        if (nVar != null) {
            b2.b("keyStrength", com.google.common.base.b.b(nVar.toString()));
        }
        v.n nVar2 = this.f8507e;
        if (nVar2 != null) {
            b2.b("valueStrength", com.google.common.base.b.b(nVar2.toString()));
        }
        if (this.f8508f != null) {
            b2.f("keyEquivalence");
        }
        return b2.toString();
    }
}