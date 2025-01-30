package com.google.android.gms.internal.p000firebaseperf;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p5  reason: invalid package */
/* loaded from: classes2.dex */
public final class p5<K, V> extends LinkedHashMap<K, V> {
    private static final p5 a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6890b;

    static {
        p5 p5Var = new p5();
        a = p5Var;
        p5Var.f6890b = false;
    }

    private p5() {
        this.f6890b = true;
    }

    public static <K, V> p5<K, V> e() {
        return a;
    }

    private final void i() {
        if (!this.f6890b) {
            throw new UnsupportedOperationException();
        }
    }

    private static int k(Object obj) {
        if (obj instanceof byte[]) {
            return n4.c((byte[]) obj);
        }
        if (!(obj instanceof q4)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final boolean b() {
        return this.f6890b;
    }

    public final void c(p5<K, V> p5Var) {
        i();
        if (p5Var.isEmpty()) {
            return;
        }
        putAll(p5Var);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        i();
        super.clear();
    }

    public final void d() {
        this.f6890b = false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = r1
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = r0
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p000firebaseperf.p5.equals(java.lang.Object):boolean");
    }

    public final p5<K, V> f() {
        return isEmpty() ? new p5<>() : new p5<>(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i2 += k(entry.getValue()) ^ k(entry.getKey());
        }
        return i2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k2, V v) {
        i();
        n4.a(k2);
        n4.a(v);
        return (V) super.put(k2, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        i();
        for (K k2 : map.keySet()) {
            n4.a(k2);
            n4.a(map.get(k2));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        i();
        return (V) super.remove(obj);
    }

    private p5(Map<K, V> map) {
        super(map);
        this.f6890b = true;
    }
}