package com.google.android.gms.internal.p000firebaseperf;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.g8  reason: invalid package */
/* loaded from: classes2.dex */
public final class g8<E> extends e8<E> {

    /* renamed from: c  reason: collision with root package name */
    private final transient int f6722c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f6723d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ e8 f6724e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g8(e8 e8Var, int i2, int i3) {
        this.f6724e = e8Var;
        this.f6722c = i2;
        this.f6723d = i3;
    }

    @Override // java.util.List
    public final E get(int i2) {
        c2.c(i2, this.f6723d);
        return this.f6724e.get(i2 + this.f6722c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final Object[] l() {
        return this.f6724e.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final int m() {
        return this.f6724e.m() + this.f6722c;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    final int o() {
        return this.f6724e.m() + this.f6722c + this.f6723d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6723d;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.e8, java.util.List
    public final /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.e8
    public final e8<E> t(int i2, int i3) {
        c2.e(i2, i3, this.f6723d);
        e8 e8Var = this.f6724e;
        int i4 = this.f6722c;
        return (e8) e8Var.subList(i2 + i4, i3 + i4);
    }
}