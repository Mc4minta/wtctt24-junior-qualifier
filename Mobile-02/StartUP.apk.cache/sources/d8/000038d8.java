package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Map;

/* compiled from: SingletonImmutableBiMap.java */
/* loaded from: classes2.dex */
final class h0<K, V> extends i<K, V> {

    /* renamed from: e  reason: collision with root package name */
    final transient K f8479e;

    /* renamed from: f  reason: collision with root package name */
    final transient V f8480f;
    @LazyInit

    /* renamed from: g  reason: collision with root package name */
    transient i<V, K> f8481g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(K k2, V v) {
        d.a(k2, v);
        this.f8479e = k2;
        this.f8480f = v;
    }

    @Override // com.google.common.collect.m
    r<Map.Entry<K, V>> c() {
        return r.r(x.b(this.f8479e, this.f8480f));
    }

    @Override // com.google.common.collect.m, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f8479e.equals(obj);
    }

    @Override // com.google.common.collect.m, java.util.Map
    public boolean containsValue(Object obj) {
        return this.f8480f.equals(obj);
    }

    @Override // com.google.common.collect.m
    r<K> d() {
        return r.r(this.f8479e);
    }

    @Override // com.google.common.collect.m, java.util.Map
    public V get(Object obj) {
        if (this.f8479e.equals(obj)) {
            return this.f8480f;
        }
        return null;
    }

    @Override // com.google.common.collect.i
    public i<V, K> p() {
        i<V, K> iVar = this.f8481g;
        if (iVar == null) {
            h0 h0Var = new h0(this.f8480f, this.f8479e, this);
            this.f8481g = h0Var;
            return h0Var;
        }
        return iVar;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    private h0(K k2, V v, i<V, K> iVar) {
        this.f8479e = k2;
        this.f8480f = v;
        this.f8481g = iVar;
    }
}