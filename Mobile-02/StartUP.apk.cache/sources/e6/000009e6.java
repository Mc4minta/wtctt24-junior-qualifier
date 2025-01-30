package com.bumptech.glide.util;

import c.e.a;
import c.e.g;

/* loaded from: classes.dex */
public final class CachedHashCodeArrayMap<K, V> extends a<K, V> {
    private int hashCode;

    @Override // c.e.g, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // c.e.g, java.util.Map
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    @Override // c.e.g, java.util.Map
    public V put(K k2, V v) {
        this.hashCode = 0;
        return (V) super.put(k2, v);
    }

    @Override // c.e.g
    public void putAll(g<? extends K, ? extends V> gVar) {
        this.hashCode = 0;
        super.putAll(gVar);
    }

    @Override // c.e.g
    public V removeAt(int i2) {
        this.hashCode = 0;
        return (V) super.removeAt(i2);
    }

    @Override // c.e.g
    public V setValueAt(int i2, V v) {
        this.hashCode = 0;
        return (V) super.setValueAt(i2, v);
    }
}