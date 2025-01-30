package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.a5  reason: invalid package */
/* loaded from: classes2.dex */
final class a5<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> a;

    public a5(Iterator<Map.Entry<K, Object>> it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.a.next();
        return next.getValue() instanceof v4 ? new x4(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}