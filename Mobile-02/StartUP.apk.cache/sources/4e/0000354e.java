package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class p6<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f7303b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n6 f7304c;

    private p6(n6 n6Var) {
        List list;
        this.f7304c = n6Var;
        list = n6Var.f7266b;
        this.a = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f7303b == null) {
            map = this.f7304c.f7270f;
            this.f7303b = map.entrySet().iterator();
        }
        return this.f7303b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.a;
        if (i2 > 0) {
            list = this.f7304c.f7266b;
            if (i2 <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (!b().hasNext()) {
            list = this.f7304c.f7266b;
            int i2 = this.a - 1;
            this.a = i2;
            return (Map.Entry) list.get(i2);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p6(n6 n6Var, q6 q6Var) {
        this(n6Var);
    }
}