package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.v6  reason: invalid package */
/* loaded from: classes2.dex */
final class v6<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6924b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f6925c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ n6 f6926d;

    private v6(n6 n6Var) {
        this.f6926d = n6Var;
        this.a = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f6925c == null) {
            map = this.f6926d.f6858c;
            this.f6925c = map.entrySet().iterator();
        }
        return this.f6925c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.a + 1;
        list = this.f6926d.f6857b;
        if (i2 >= list.size()) {
            map = this.f6926d.f6858c;
            if (map.isEmpty() || !b().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.f6924b = true;
        int i2 = this.a + 1;
        this.a = i2;
        list = this.f6926d.f6857b;
        if (i2 < list.size()) {
            list2 = this.f6926d.f6857b;
            return (Map.Entry) list2.get(this.a);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f6924b) {
            this.f6924b = false;
            this.f6926d.q();
            int i2 = this.a;
            list = this.f6926d.f6857b;
            if (i2 < list.size()) {
                n6 n6Var = this.f6926d;
                int i3 = this.a;
                this.a = i3 - 1;
                n6Var.i(i3);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v6(n6 n6Var, q6 q6Var) {
        this(n6Var);
    }
}