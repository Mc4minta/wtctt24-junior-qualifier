package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p6  reason: invalid package */
/* loaded from: classes2.dex */
final class p6<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f6891b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n6 f6892c;

    private p6(n6 n6Var) {
        List list;
        this.f6892c = n6Var;
        list = n6Var.f6857b;
        this.a = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f6891b == null) {
            map = this.f6892c.f6861f;
            this.f6891b = map.entrySet().iterator();
        }
        return this.f6891b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.a;
        if (i2 > 0) {
            list = this.f6892c.f6857b;
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
            list = this.f6892c.f6857b;
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