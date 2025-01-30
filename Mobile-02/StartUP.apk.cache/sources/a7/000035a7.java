package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class v6<K, V> implements Iterator<Map.Entry<K, V>> {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7371b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f7372c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ n6 f7373d;

    private v6(n6 n6Var) {
        this.f7373d = n6Var;
        this.a = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f7372c == null) {
            map = this.f7373d.f7267c;
            this.f7372c = map.entrySet().iterator();
        }
        return this.f7372c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.a + 1;
        list = this.f7373d.f7266b;
        if (i2 >= list.size()) {
            map = this.f7373d.f7267c;
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
        this.f7371b = true;
        int i2 = this.a + 1;
        this.a = i2;
        list = this.f7373d.f7266b;
        if (i2 < list.size()) {
            list2 = this.f7373d.f7266b;
            return (Map.Entry) list2.get(this.a);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f7371b) {
            this.f7371b = false;
            this.f7373d.q();
            int i2 = this.a;
            list = this.f7373d.f7266b;
            if (i2 < list.size()) {
                n6 n6Var = this.f7373d;
                int i3 = this.a;
                this.a = i3 - 1;
                n6Var.l(i3);
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