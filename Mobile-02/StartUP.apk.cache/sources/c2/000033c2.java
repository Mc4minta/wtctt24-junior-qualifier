package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.m8  reason: invalid package */
/* loaded from: classes2.dex */
final class m8<K, V> extends e8<Map.Entry<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n8 f6836c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m8(n8 n8Var) {
        this.f6836c = n8Var;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i2) {
        int i3;
        Object[] objArr;
        Object[] objArr2;
        i3 = this.f6836c.f6866f;
        c2.c(i2, i3);
        objArr = this.f6836c.f6864d;
        int i4 = i2 * 2;
        n8 n8Var = this.f6836c;
        Object obj = objArr[i4];
        objArr2 = n8Var.f6864d;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i4 + 1]);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i2;
        i2 = this.f6836c.f6866f;
        return i2;
    }
}