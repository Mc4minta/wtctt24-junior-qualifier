package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.o8  reason: invalid package */
/* loaded from: classes2.dex */
final class o8 extends e8<Object> {

    /* renamed from: c  reason: collision with root package name */
    private final transient Object[] f6884c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f6885d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f6886e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o8(Object[] objArr, int i2, int i3) {
        this.f6884c = objArr;
        this.f6885d = i2;
        this.f6886e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        c2.c(i2, this.f6886e);
        return this.f6884c[(i2 * 2) + this.f6885d];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final boolean p() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6886e;
    }
}