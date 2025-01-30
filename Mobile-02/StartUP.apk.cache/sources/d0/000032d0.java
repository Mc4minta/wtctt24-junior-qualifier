package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class o1<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> a;

    public o1(Iterator<Map.Entry<K, Object>> it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.a.next();
        return next.getValue() instanceof l1 ? new n1(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}