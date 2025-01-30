package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class e3<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f6413b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ c3 f6414c;

    private e3(c3 c3Var) {
        List list;
        this.f6414c = c3Var;
        list = c3Var.f6390b;
        this.a = list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e3(c3 c3Var, d3 d3Var) {
        this(c3Var);
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f6413b == null) {
            map = this.f6414c.f6394f;
            this.f6413b = map.entrySet().iterator();
        }
        return this.f6413b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.a;
        if (i2 > 0) {
            list = this.f6414c.f6390b;
            if (i2 <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> entry;
        if (b().hasNext()) {
            entry = b().next();
        } else {
            list = this.f6414c.f6390b;
            int i2 = this.a - 1;
            this.a = i2;
            entry = (Map.Entry<K, V>) list.get(i2);
        }
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}