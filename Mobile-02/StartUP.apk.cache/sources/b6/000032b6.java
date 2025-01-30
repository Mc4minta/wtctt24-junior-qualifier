package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class k3<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6485b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f6486c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ c3 f6487d;

    private k3(c3 c3Var) {
        this.f6487d = c3Var;
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k3(c3 c3Var, d3 d3Var) {
        this(c3Var);
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f6486c == null) {
            map = this.f6487d.f6391c;
            this.f6486c = map.entrySet().iterator();
        }
        return this.f6486c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.a + 1;
        list = this.f6487d.f6390b;
        if (i2 >= list.size()) {
            map = this.f6487d.f6391c;
            if (map.isEmpty() || !b().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        Map.Entry<K, V> next;
        List list2;
        this.f6485b = true;
        int i2 = this.a + 1;
        this.a = i2;
        list = this.f6487d.f6390b;
        if (i2 < list.size()) {
            list2 = this.f6487d.f6390b;
            next = (Map.Entry<K, V>) list2.get(this.a);
        } else {
            next = b().next();
        }
        return next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.f6485b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f6485b = false;
        this.f6487d.p();
        int i2 = this.a;
        list = this.f6487d.f6390b;
        if (i2 >= list.size()) {
            b().remove();
            return;
        }
        c3 c3Var = this.f6487d;
        int i3 = this.a;
        this.a = i3 - 1;
        c3Var.i(i3);
    }
}