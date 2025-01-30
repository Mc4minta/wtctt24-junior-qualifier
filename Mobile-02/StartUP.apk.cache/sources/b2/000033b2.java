package com.google.android.gms.internal.p000firebaseperf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.l8  reason: invalid package */
/* loaded from: classes2.dex */
public final class l8<E> extends e8<E> {

    /* renamed from: c  reason: collision with root package name */
    static final e8<Object> f6820c = new l8(new Object[0], 0);

    /* renamed from: d  reason: collision with root package name */
    private final transient Object[] f6821d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f6822e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l8(Object[] objArr, int i2) {
        this.f6821d = objArr;
        this.f6822e = i2;
    }

    @Override // java.util.List
    public final E get(int i2) {
        c2.c(i2, this.f6822e);
        return (E) this.f6821d[i2];
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.e8, com.google.android.gms.internal.p000firebaseperf.f8
    final int h(Object[] objArr, int i2) {
        System.arraycopy(this.f6821d, 0, objArr, i2, this.f6822e);
        return i2 + this.f6822e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final Object[] l() {
        return this.f6821d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final int m() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    final int o() {
        return this.f6822e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final boolean p() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6822e;
    }
}