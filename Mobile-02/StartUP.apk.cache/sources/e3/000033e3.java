package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.p8  reason: invalid package */
/* loaded from: classes2.dex */
final class p8<K> extends i8<K> {

    /* renamed from: c  reason: collision with root package name */
    private final transient j8<K, ?> f6893c;

    /* renamed from: d  reason: collision with root package name */
    private final transient e8<K> f6894d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p8(j8<K, ?> j8Var, e8<K> e8Var) {
        this.f6893c = j8Var;
        this.f6894d = e8Var;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@NullableDecl Object obj) {
        return this.f6893c.get(obj) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final int h(Object[] objArr, int i2) {
        return k().h(objArr, i2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final q8<K> i() {
        return (q8) k().iterator();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i8, com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.i8, com.google.android.gms.internal.p000firebaseperf.f8
    public final e8<K> k() {
        return this.f6894d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f6893c.size();
    }
}