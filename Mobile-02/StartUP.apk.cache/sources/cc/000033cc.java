package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.n8  reason: invalid package */
/* loaded from: classes2.dex */
final class n8<K, V> extends i8<Map.Entry<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    private final transient j8<K, V> f6863c;

    /* renamed from: d  reason: collision with root package name */
    private final transient Object[] f6864d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f6865e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f6866f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n8(j8<K, V> j8Var, Object[] objArr, int i2, int i3) {
        this.f6863c = j8Var;
        this.f6864d = objArr;
        this.f6866f = i3;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f6863c.get(key))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final int h(Object[] objArr, int i2) {
        return k().h(objArr, i2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final q8<Map.Entry<K, V>> i() {
        return (q8) k().iterator();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i8, com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final boolean p() {
        return true;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i8
    final e8<Map.Entry<K, V>> q() {
        return new m8(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f6866f;
    }
}