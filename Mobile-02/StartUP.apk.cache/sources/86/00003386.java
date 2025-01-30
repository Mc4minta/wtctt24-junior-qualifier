package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h8  reason: invalid package */
/* loaded from: classes2.dex */
final class h8<E> extends d4<E> {

    /* renamed from: c  reason: collision with root package name */
    private final e8<E> f6735c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h8(e8<E> e8Var, int i2) {
        super(e8Var.size(), i2);
        this.f6735c = e8Var;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.d4
    protected final E b(int i2) {
        return this.f6735c.get(i2);
    }
}