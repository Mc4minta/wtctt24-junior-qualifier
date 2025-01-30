package com.google.android.gms.internal.p000firebaseperf;

import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.h7  reason: invalid package */
/* loaded from: classes2.dex */
final class h7 implements Iterator<String> {
    private Iterator<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f7 f6734b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h7(f7 f7Var) {
        b5 b5Var;
        this.f6734b = f7Var;
        b5Var = f7Var.a;
        this.a = b5Var.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}